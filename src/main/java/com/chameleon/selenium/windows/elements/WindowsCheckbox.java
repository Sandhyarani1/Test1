package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class WindowsCheckbox extends Checkbox {
    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public WindowsCheckbox(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }

    public WindowsCheckbox(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }
}