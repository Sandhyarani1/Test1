package com.chameleon.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.chameleon.AutomationException;
import com.chameleon.utils.Sleeper;

public class PropertiesManager {
    private static Map<String, Map<String, String>> propertyFiles = new HashMap<>();
    private static boolean cachingInProgress = false;
    private static boolean cachingIsDone = false;
    private static int cacheTimeout = 500; // 5 seconds

    public static Map<String, String> properties(String propertiesPath) {
        if (propertyFiles.containsKey(propertiesPath) == false) {
            cacheProperties(propertiesPath);
            cachingInProgress = false;
            cachingIsDone = false;
        }
        return propertyFiles.get(propertiesPath);
    }

    private static synchronized void cacheProperties(String propertiesPath) {
        // Start Cache Load
        // If cache has not been created, then populate cache
        if (!cachingIsDone) {
            // need to lock process so only a single thread will populate cache
            // Multiple threads will open multiple file streams and duplicate data
            // First thread will attempt to lock the process and have other threads
            // poll every 100th second until caching is completed
            if (!cachingInProgress) {
                cachingInProgress = true;
                loadProperties(propertiesPath);
                cachingIsDone = true;
            } else {
                int cacheTries = 0;
                do {
                    Sleeper.sleep(.01);
                    cacheTries++;
                } while (cacheTries < cacheTimeout && !cachingIsDone);

                // Timeout reached without cache being popluated, there may be an issue.
                // Fail script here to avoid causing other environment issues
                if (cacheTries == cacheTimeout) {
                    throw new AutomationException("Failed trying to cache data");
                }
            }
        }
        // End Cache Load
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void loadProperties(String propertiesPath) {
        Properties props = new CaselessProperties();
        try (InputStream stream = PropertiesManager.class.getClassLoader().getResourceAsStream(propertiesPath)) {
            props.load(stream);
        } catch (IOException | NullPointerException e) {
            throw new AutomationException("Failed to load properties file [ " + propertiesPath + " ]", e);
        }

        Map<String, String> properties = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        properties.putAll((Map) props);
        propertyFiles.put(propertiesPath, properties);

        props = null;
    }
}
