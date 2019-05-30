package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class ElementNotVisibleException extends WebException {
    private static final long serialVersionUID = 7724792038612608062L;

    public ElementNotVisibleException(String message) {
        super(message);
    }

    public ElementNotVisibleException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
