package com.chameleon.utils.exception;

import com.chameleon.AutomationException;

public class JsonMapperException extends AutomationException {
    private static final long serialVersionUID = 3407361723082329697L;

    public JsonMapperException(String message) {
        super(message);
    }

    public JsonMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
