package com.chameleon.validators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Reporter;

import com.chameleon.AutomationException;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectComparator {
    private boolean failTestOnFailedComparison = true;
    private boolean reportSuccessfulValidations = true;
    private List<String> optionalPropertyPaths = new ArrayList<>();

    private final static String SKIP_PASS_VALIDATIONS = "<b>Only reporting failed validations, successful validations excluded from report</b></br>";

    private final static String PASS = "<b>Pass</b>";
    private final static String FAIL_NO_MATCHING_PROP = "<b>Failed - No matching property</b>";
    private final static String SKIP = "<b>Skipped - Property validation was marked as optional</b>";

    private final static String BLACK = "black";
    private final static String GREEN = "green";
    private final static String RED = "red";
    private final static String PURPLE = "purple";

    private final static String LEFT = "left";
    private final static String CENTER = "center";

    private final static String START_TABLE = "<table border='1' width='100%'>";
    private final static String CLOSE_TABLE = "</table>";
    private final static String START_ROW = "<tr>";
    private final static String CLOSE_ROW = "</tr>";
    private final static String BREAK = "</br>";

    private final static String COL_HEAD_PROPERTY_INDEX = "<td style='width: 100px; color: black; text-align: center;'><b>Index</b></td>";
    private final static String COL_HEAD_PROPERTY_PATH = "<td style='width: 100px; color: black; text-align: center;'><b>Property Path</b></td>";
    private final static String COL_HEAD_PROPERTY_VALUE_1 = "<td style='width: 100px; color: black; text-align: center;'><b>Response 1 Property Value</b></td>";
    private final static String COL_HEAD_PROPERTY_VALUE_2 = "<td style='width: 100px; color: black; text-align: center;'><b>Response 2 Property Value</b></td>";
    private final static String COL_HEAD_PROPERTY_STATUS = "<td style='width: 100px; color: black; text-align: center;'><b>Status</b></td>";
    private final static String ADD_CELL_DATA = "<td style='width: 100px; color: %s; text-align: %s;'>%s</td>";

    private final static String COL_HEAD_MISSING_PROPERTY_PATH = "<td style='width: 100px; color: black; text-align: center;'><b>Properties in Response 2 not found in Response 1</b></td>";
    private final static String COL_HEAD_MISSING_PROPERTY_VALUE = "<td style='width: 100px; color: black; text-align: center;'><b>Values</b></td>";

    public JsonObjectComparator addOptionalPropertyPath(final String path) {
        optionalPropertyPaths.add(path);
        return this;
    }

    public JsonObjectComparator setFailTestOnFailedComparison(final boolean failTestOnFailedComparison) {
        this.failTestOnFailedComparison = failTestOnFailedComparison;
        return this;
    }

    public JsonObjectComparator setReportSuccessfulValidations(final boolean reportSuccessfulValidations) {
        this.reportSuccessfulValidations = reportSuccessfulValidations;
        return this;
    }

    public void validate(final RestResponse restResponse1, final RestResponse restResponse2) {
        validate(restResponse1.getResponse(), restResponse2.getResponse());
    }

    public boolean validate(final String json1, final String json2) {
        final Map<String, Object> json1Map = buildMap(json1);
        final Map<String, Object> json2Map = buildMap(json2);
        boolean success = true;

        StringBuffer buffer = new StringBuffer();

        // Report out a warning message to report in case of no failures and empty table
        // generated when disabling successful validaiton reports.
        if (!reportSuccessfulValidations) {
            Reporter.log(SKIP_PASS_VALIDATIONS);
        }

        buffer.append(START_TABLE);

        // build headers
        buffer.append(START_ROW);
        buffer.append(COL_HEAD_PROPERTY_INDEX);
        buffer.append(COL_HEAD_PROPERTY_PATH);
        buffer.append(COL_HEAD_PROPERTY_VALUE_1);
        buffer.append(COL_HEAD_PROPERTY_VALUE_2);
        buffer.append(COL_HEAD_PROPERTY_STATUS);
        buffer.append(CLOSE_ROW);

        Iterator<Entry<String, Object>> response1Iterator = json1Map.entrySet().iterator();
        Iterator<Entry<String, Object>> response2Iterator = null;

        // Loop through all baseline map items
        while (response1Iterator.hasNext()) {
            Map.Entry<String, Object> response1Entry = response1Iterator.next();
            Map.Entry<String, Object> response2Entry = null;
            String[] index = response1Entry.getKey().split("_:_");
            response2Iterator = json2Map.entrySet().iterator();
            final String response1Compare = index[1] + "=" + response1Entry.getValue();

            while (response2Iterator.hasNext()) {
                response2Entry = response2Iterator.next();

                if (response2Entry.toString().contains(response1Compare)) {
                    break;
                }
            }

            /**
             * Three possible workflows.
             * 1. No more entries in second map. This can happen if all
             * entries was found in second map, but first map still
             * has entries.
             *
             * 2. The entry was found in both maps. Remove entry from second map
             *
             * 3. The map 1 entry was not found in map 2.
             *
             * For both workflow 1 and 3, do a check if user define the property to be optional
             * - If property is marked to be optional, report entry as SKIPPED. Do not mark overall validation as failure
             * - If property is not marked to be optional, report entry as FAILED and mark overall validation as failure
             */
            if (response2Entry == null) {
                if (optionalPropertyPaths.contains(index[1])) {
                    buildRow(buffer, index[0], index[1], response1Entry.getValue(), "", PURPLE, SKIP);
                } else {
                    buildRow(buffer, index[0], index[1], response1Entry.getValue(), "", RED, FAIL_NO_MATCHING_PROP);
                    success = false;
                }
            } else if (response1Entry.getValue().equals(response2Entry.getValue())) {
                if (reportSuccessfulValidations) {
                    buildRow(buffer, index[0], index[1], response1Entry.getValue(), response2Entry.getValue(), GREEN, PASS);
                }
                if (response2Entry != null) {
                    response2Iterator.remove();
                }
            } else {
                if (optionalPropertyPaths.contains(index[1])) {
                    buildRow(buffer, index[0], index[1], response1Entry.getValue(), "", PURPLE, SKIP);
                } else {
                    buildRow(buffer, index[0], index[1], response1Entry.getValue(), "", RED, FAIL_NO_MATCHING_PROP);
                    success = false;
                }
            }

            // Remove entry from list to ensure it is not repeated
            response1Iterator.remove();
        }

        // Close up the table
        buffer.append(CLOSE_TABLE);

        // Check for left overs. If found this means there are values not found and make a separate table
        if (json2Map.size() > 0) {
            success = buildLeftOverTable(buffer, json2Map);
        }

        // Report out buffer to build HTML tables
        Reporter.log(buffer.toString() + BREAK);

        // Clear out and nullify buffer to conserve memory
        buffer.setLength(0);
        buffer = null;

        // Do not fail test if user does not want to
        if (failTestOnFailedComparison) {
            TestReporter.assertTrue(success, "Ensure response details matched");
        }

        return success;
    }

    private Map<String, Object> buildMap(final String response) {
        final JsonFactory factory = new JsonFactory();
        final ObjectMapper mapper = new ObjectMapper(factory);
        mapper.setSerializationInclusion(Include.ALWAYS);
        JsonNode responseRoot = null;
        try {
            responseRoot = mapper.readTree(response);
        } catch (IOException e) {
            throw new AutomationException("Could not parse JSON", e);
        }

        final Map<String, Object> responseMap = new LinkedHashMap<>();

        // Mark position to maintain duplicate Property paths
        long position = 1L;
        position = parse(responseRoot, "", responseMap, position);

        return responseMap;
    }

    private long parse(JsonNode node, String parent, Map<String, Object> map, long position) {

        if (node.isArray()) {
            for (JsonNode n : node) {
                position = parse(n, parent, map, position);
            }
        }

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = node.fields();
        while (fieldsIterator.hasNext()) {

            Map.Entry<String, JsonNode> field = fieldsIterator.next();

            if (field.getValue().isObject()) {
                if (parent.isEmpty()) {
                    position = parse(field.getValue(), field.getKey(), map, position);
                } else {
                    position = parse(field.getValue(), parent + "." + field.getKey(), map, position);
                }
            } else if (field.getValue().isArray()) {
                for (JsonNode n : node) {
                    if (parent.isEmpty()) {
                        position = parse(n, field.getKey(), map, position);
                    } else {
                        position = parse(n, parent + "." + field.getKey(), map, position);
                    }
                }
            } else {
                if (parent.isEmpty()) {
                    map.put(position + "_:_" + field.getKey(), field.getValue());
                } else {
                    map.put(position + "_:_" + parent + "." + field.getKey(), field.getValue());
                }
                position++;
            }
        }
        return position;
    }

    private void buildRow(final StringBuffer buffer, final String index, final String property, final Object value1, final Object value2, final String color, final String status) {
        buffer.append(START_ROW);
        buffer.append(String.format(ADD_CELL_DATA, BLACK, CENTER, index));
        buffer.append(String.format(ADD_CELL_DATA, BLACK, LEFT, property));
        buffer.append(String.format(ADD_CELL_DATA, BLACK, CENTER, value1));
        buffer.append(String.format(ADD_CELL_DATA, BLACK, CENTER, value2));
        buffer.append(String.format(ADD_CELL_DATA, color, CENTER, status));
        buffer.append(CLOSE_ROW);
    }

    private void buildRow(final StringBuffer buffer, final String index, final String property, final Object value1, final String color) {
        buffer.append(START_ROW);
        buffer.append(String.format(ADD_CELL_DATA, BLACK, CENTER, index));
        buffer.append(String.format(ADD_CELL_DATA, BLACK, LEFT, property));
        buffer.append(String.format(ADD_CELL_DATA, color, CENTER, value1));
        buffer.append(CLOSE_ROW);
    }

    private boolean buildLeftOverTable(final StringBuffer buffer, final Map<String, Object> map) {
        boolean success = true;
        buffer.append(BREAK);
        buffer.append(BREAK);
        buffer.append(BREAK);
        buffer.append(BREAK);
        buffer.append(START_TABLE);
        buffer.append(START_ROW);
        buffer.append(COL_HEAD_PROPERTY_INDEX);
        buffer.append(COL_HEAD_MISSING_PROPERTY_PATH);
        buffer.append(COL_HEAD_MISSING_PROPERTY_VALUE);
        buffer.append(CLOSE_ROW);
        for (String key : map.keySet()) {
            String[] index = key.split("_:_");
            if (optionalPropertyPaths.contains(index[1])) {
                buildRow(buffer, index[0], index[1], SKIP, PURPLE);
            } else {
                buildRow(buffer, index[0], index[1], map.get(key), BLACK);
                success = false;
            }
        }
        buffer.append(CLOSE_TABLE);

        return success;
    }
}
