package com.chameleon.selenium.mobile.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class MobileTable extends Table {

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public MobileTable(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }

    public MobileTable(ExtendedMobileDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

}