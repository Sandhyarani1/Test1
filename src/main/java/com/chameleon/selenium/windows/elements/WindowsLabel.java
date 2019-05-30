package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WindowsLabel extends Label {
    /**
     * Creates an Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public WindowsLabel(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }

    public WindowsLabel(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

}