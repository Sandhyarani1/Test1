package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class ElementAttributeValueNotMatchingException extends WebException {
    private static final long serialVersionUID = 3407361723082329697L;

    public ElementAttributeValueNotMatchingException(String message) {
        super(message);
    }

    public ElementAttributeValueNotMatchingException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
