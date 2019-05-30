package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class ElementNotEnabledException extends WebException {

    private static final long serialVersionUID = 6579447002670243452L;

    public ElementNotEnabledException(String message) {
        super(message);
    }

    public ElementNotEnabledException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
