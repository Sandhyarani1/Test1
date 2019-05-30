package com.accuweather.glacier.api.validators;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Reporter;

import com.chameleon.AutomationException;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseValidator {

    private final String PASS = "<b>Pass</b>";
    private final String FAIL = "<b>Failed - No matching property</b>";
    private final String REPORT_FAIL_ONLY = "<b>Table will only report non-passing comparisions</b>";

    private final String BLACK = "black";
    private final String GREEN = "green";
    private final String RED = "red";

    private final String LEFT = "left";
    private final String CENTER = "center";

    private final String START_TABLE = "<table border='1' width='100%'>";
    private final String CLOSE_TABLE = "</table>";
    private final String START_ROW = "<tr>";
    private final String CLOSE_ROW = "</tr>";
    private final String BREAK = "</br>";

    private final String COL_HEAD_PROPERTY_INDEX = "<td style='width: 100px; color: black; text-align: center;'><b>Index</b></td>";
    private final String COL_HEAD_PROPERTY_PATH = "<td style='width: 100px; color: black; text-align: center;'><b>Property Path</b></td>";
    private final String COL_HEAD_PROPERTY_VALUE_1 = "<td style='width: 100px; color: black; text-align: center;'><b>Response 1 Property Value</b></td>";
    private final String COL_HEAD_PROPERTY_VALUE_2 = "<td style='width: 100px; color: black; text-align: center;'><b>Response 2 Property Value</b></td>";
    private final String COL_HEAD_PROPERTY_STATUS = "<td style='width: 100px; color: black; text-align: center;'><b>Status</b></td>";
    private final String ADD_CELL_DATA = "<td style='width: 100px; color: %s; text-align: %s;'>%s</td>";

    private final String COL_HEAD_MISSING_PROPERTY_PATH = "<td style='width: 100px; color: black; text-align: center;'><b>Properties in Response 2 not found in Response 1</b></td>";
    private final String COL_HEAD_MISSING_PROPERTY_VALUE = "<td style='width: 100px; color: black; text-align: center;'><b>Values</b></td>";

    private ThreadLocal<Boolean> reportOnlyFailedValidations = ThreadLocal.withInitial(() -> false);

    public ResponseValidator setReportOnlyFailedValidations(boolean reportOnlyFailed) {
        reportOnlyFailedValidations.set(reportOnlyFailed);
        return this;
    }

    public void validateResponsesAreEqual(final RestResponse restResponse1, final RestResponse restResponse2) {
        final Map<String, Object> response1Map = buildMap(restResponse1.getResponse());
        final Map<String, Object> response2Map = buildMap(restResponse2.getResponse());
        boolean success = true;

        StringBuffer buffer = new StringBuffer();
        if (reportOnlyFailedValidations.get()) {
            buffer.append(REPORT_FAIL_ONLY).append(BREAK);
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
        Iterator<Entry<String, Object>> response1Iterator = response1Map.entrySet().iterator();
        Iterator<Entry<String, Object>> response2Iterator = null;

        // Loop through all baseline map items
        while (response1Iterator.hasNext()) {
            Map.Entry<String, Object> response1Entry = response1Iterator.next();
            Map.Entry<String, Object> response2Entry = null;
            String[] index = response1Entry.getKey().split("_:_");
            // Find corrosponding xpath in response map
            response2Iterator = response2Map.entrySet().iterator();
            while (response2Iterator.hasNext()) {
                response2Entry = response2Iterator.next();
                if (response2Entry.toString().equals(response1Entry.toString())) {
                    break;
                }
            }

            // Compare number of xpaths and report findings
            if (response1Entry.getValue().equals(response2Entry.getValue())) {
                if (reportOnlyFailedValidations.get() == false) {
                    buffer.append(START_ROW);
                    addTableCellData(buffer, BLACK, CENTER, index[0]);
                    addTableCellData(buffer, BLACK, LEFT, index[1]);
                    addTableCellData(buffer, BLACK, CENTER, response1Entry.getValue().toString());
                    addTableCellData(buffer, BLACK, CENTER, response2Entry.getValue().toString());
                    addTableCellData(buffer, GREEN, CENTER, PASS);
                    buffer.append(CLOSE_ROW);
                }
                response1Iterator.remove();
                response2Iterator.remove();
            } else {
                buffer.append(START_ROW);
                addTableCellData(buffer, BLACK, CENTER, index[0]);
                addTableCellData(buffer, BLACK, LEFT, index[1]);
                addTableCellData(buffer, BLACK, CENTER, response1Entry.getValue().toString());
                addTableCellData(buffer, BLACK, CENTER, "");
                addTableCellData(buffer, GREEN, RED, FAIL);
                success = false;
                response1Iterator.remove();
                buffer.append(CLOSE_ROW);
            }
        }

        buffer.append(CLOSE_TABLE);

        // Check for left overs. If found this means there are values not found and make a seperate table
        if (response2Map.size() > 0) {
            buffer.append(BREAK);
            buffer.append(BREAK);
            buffer.append(BREAK);
            buffer.append(BREAK);
            buffer.append(START_TABLE);
            buffer.append(START_ROW);
            buffer.append(COL_HEAD_MISSING_PROPERTY_PATH);
            buffer.append(COL_HEAD_MISSING_PROPERTY_VALUE);
            buffer.append(CLOSE_ROW);
            for (String key : response2Map.keySet()) {
                buffer.append(START_ROW);
                buffer.append(COL_HEAD_PROPERTY_INDEX);
                addTableCellData(buffer, BLACK, LEFT, key.substring(0, key.indexOf("_:_")));
                addTableCellData(buffer, BLACK, LEFT, key.substring(key.indexOf("_:_")));
                addTableCellData(buffer, BLACK, CENTER, response2Map.get(key).toString());
                buffer.append(CLOSE_ROW);
            }
        }

        buffer.append(CLOSE_TABLE);
        Reporter.log(buffer.toString() + BREAK);
        buffer.setLength(0);
        buffer = null;

        TestReporter.assertTrue(success, "Ensure response details matched");
    }

    private void addTableCellData(final StringBuffer buffer, final String color, final String alignment, final String text) {
        buffer.append(String.format(ADD_CELL_DATA, color, alignment, text));
    }

    private Map<String, Object> buildMap(final String response) {
        final JsonFactory factory = new JsonFactory();
        final ObjectMapper mapper = new ObjectMapper(factory);

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
}
