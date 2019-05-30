package com.chameleon.selenium.mobile.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;

/**
 * Wraps a label on a html form with some behavior.
 */
public class MobileLabel extends Label {
    /**
     * Creates an Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public MobileLabel(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }

    public MobileLabel(ExtendedMobileDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

}