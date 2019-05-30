package com.chameleon.selenium.web.elements;

import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.web.ExtendedWebDriver;

/**
 * Wrapper around a WebElement for the Select class in Selenium.
 */
public class WebListbox extends Listbox {
    /**
     * Wraps a WebElement with listbox functionality.
     *
     * @param extendedElement
     *            - element to wrap up
     */

    public WebListbox(ExtendedWebDriver driver, By by) {
        super(driver, by);

        logTrace("Entering Listbox#init");

        if (extendedElement != null) {
            optionTag = determineOptionTag();
            multiple = isMultiple();
        }

        logTrace("Exiting Listbox#init");
    }

    public WebListbox(ExtendedWebDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }
}