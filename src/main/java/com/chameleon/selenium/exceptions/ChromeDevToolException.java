package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.web.WebException;

public class ChromeDevToolException extends WebException {
    private static final long serialVersionUID = 3407361723082329697L;

    public ChromeDevToolException(String message) {
        super(message);
    }

    public ChromeDevToolException(String message, Exception e) {
        super(message, e);
    }
}