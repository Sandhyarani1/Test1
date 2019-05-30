package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WindowsLink extends Link {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public WindowsLink(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }

    public WindowsLink(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }
}
