package com.chameleon.selenium.web.elements;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.web.ExtendedWebDriver;

/**
 * Wrapper around a WebElement for the Select class in Selenium.
 */
public class WebRadioGroup extends RadioGroup {

    /**
     * Wraps a WebElement as an Element with radioGroup functionality.
     *
     * @param element
     *            - element to wrap up
     * @throws NoSuchAttributeException
     */

    public WebRadioGroup(ExtendedWebDriver driver, By by) {
        super(driver, by);
    }
}