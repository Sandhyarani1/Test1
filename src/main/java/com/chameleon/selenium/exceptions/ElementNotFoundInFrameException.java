package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class ElementNotFoundInFrameException extends WebException {
    private static final long serialVersionUID = 624614577584686540L;

    public ElementNotFoundInFrameException(String message) {
        super(message);
    }

    public ElementNotFoundInFrameException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
