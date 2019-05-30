package com.chameleon.selenium.web.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.web.ExtendedWebDriver;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class WebTable extends Table {

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public WebTable(ExtendedWebDriver driver, By by) {
        super(driver, by);
    }

    public WebTable(ExtendedWebDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

}