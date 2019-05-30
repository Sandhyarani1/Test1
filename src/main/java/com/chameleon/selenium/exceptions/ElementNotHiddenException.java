package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class ElementNotHiddenException extends WebException {

    private static final long serialVersionUID = 1865273000586352087L;

    public ElementNotHiddenException(String message) {
        super(message);
    }

    public ElementNotHiddenException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
