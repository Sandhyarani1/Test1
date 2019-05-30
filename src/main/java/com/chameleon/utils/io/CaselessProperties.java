package com.chameleon.utils.io;

import java.util.Properties;

public class CaselessProperties extends Properties {
    private static final long serialVersionUID = -3713936963486995273L;

    public Object put(Object key, Object value) {
        String lowercase = ((String) key).toLowerCase();
        return super.put(lowercase, value);
    }

    public String getProperty(String key) {
        String lowercase = key.toLowerCase();
        return super.getProperty(lowercase);
    }

    public String getProperty(String key, String defaultValue) {
        String lowercase = key.toLowerCase();
        return super.getProperty(lowercase, defaultValue);
    }
}
