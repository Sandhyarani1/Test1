package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.web.WebException;

public class NullDriverException extends WebException {
    private static final long serialVersionUID = 3407361723082329697L;

    public NullDriverException() {
        super("Driver was null");
    }
}