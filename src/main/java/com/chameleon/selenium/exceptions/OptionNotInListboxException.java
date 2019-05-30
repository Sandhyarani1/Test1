package com.chameleon.selenium.exceptions;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebException;

public class OptionNotInListboxException extends WebException {

    private static final long serialVersionUID = 4926417034544326093L;

    public OptionNotInListboxException(String message) {
        super(message);
    }

    public OptionNotInListboxException(String message, ExtendedDriver driver) {
        super(message, driver);
    }
}
