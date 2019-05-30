package com.chameleon.selenium.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface that wraps a WebElement in Html form label functionality.
 */
public class Label extends Element {
    /**
     * Creates an Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public Label(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Label(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }
}