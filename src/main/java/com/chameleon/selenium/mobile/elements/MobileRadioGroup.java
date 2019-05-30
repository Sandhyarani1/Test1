package com.chameleon.selenium.mobile.elements;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;

/**
 * Wrapper around a WebElement for the Select class in Selenium.
 */
public class MobileRadioGroup extends RadioGroup {

    /**
     * Wraps a WebElement as an Element with radioGroup functionality.
     *
     * @param element
     *            - element to wrap up
     * @throws NoSuchAttributeException
     */

    public MobileRadioGroup(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }
}