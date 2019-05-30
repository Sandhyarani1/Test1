package com.chameleon.utils.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.chameleon.utils.TestReporter;
import com.chameleon.utils.exception.JsonMapperException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectMapper {

    public static String getJsonFromObject(Object request) {
        return getJsonFromObject(request, Include.ALWAYS);
    }

    public static String getJsonFromObject(Object request, Include includeRule) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setSerializationInclusion(includeRule);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new JsonMapperException("Failed to convert object to json", e);
        }
    }

    public static String getJsonFromObject(Object request, List<Include> includeRule) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            includeRule.forEach(rule -> mapper.setSerializationInclusion(rule));
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new JsonMapperException("Failed to convert object to json", e);
        }
    }

    public static <T> T mapJSONToObject(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        T map = null;
        try {
            map = mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            throw new JsonMapperException("Failed to parse JSON", e);
        } catch (JsonMappingException e) {
            throw new JsonMapperException("Failed to Map JSON", e);
        } catch (IOException e) {
            throw new JsonMapperException("Failed to output JSON", e);
        }
        return map;
    }

    public static <T> T readJsonFromFile(String filePath, Class<T> clazz) {
        TestReporter.logDebug("Loading resource [ " + clazz.getClass().getResourceAsStream(filePath) + " ]");
        InputStream resource = clazz.getClassLoader().getResourceAsStream(filePath);
        if (resource == null) {
            resource = clazz.getClassLoader().getResourceAsStream("/" + filePath);

            if (resource == null) {
                throw new JsonMapperException("Failed to find resource [ " + filePath + " ]");
            }
        }
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource));

            String line;
            sb = new StringBuilder();

            try {
                while ((line = br.readLine()) != null) {
                    sb.append(line.trim());
                }
            } catch (IOException e) {
                throw new JsonMapperException("Failed to read xml from file [ " + filePath + " ]", e);
            }
        } finally {
            try {
                br.close();
            } catch (IOException e1) {
                throw new JsonMapperException("Failed to close buffer reader", e1);
            }
        }
        return mapJSONToObject(sb.toString(), clazz);
    }

    public static String readJsonFromFile(String filePath) {
        TestReporter.logDebug("Loading resource [ " + JsonObjectMapper.class.getResourceAsStream(filePath) + " ]");
        InputStream resource = JsonObjectMapper.class.getClassLoader().getResourceAsStream(filePath);
        if (resource == null) {
            resource = JsonObjectMapper.class.getResourceAsStream("/" + filePath);

            if (resource == null) {
                throw new JsonMapperException("Failed to find resource [ " + filePath + " ]");
            }
        }
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource));

            String line;
            sb = new StringBuilder();

            try {
                while ((line = br.readLine()) != null) {
                    sb.append(line.trim());
                }
            } catch (IOException e) {
                throw new JsonMapperException("Failed to read xml from file [ " + filePath + " ]", e);
            }
        } finally {
            try {
                br.close();
            } catch (IOException e1) {
                throw new JsonMapperException("Failed to close buffer reader", e1);
            }
        }
        return sb.toString();
    }
}
