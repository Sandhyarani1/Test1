package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface that wraps a WebElement in Link functionality.
 */

public class Link extends Element {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public Link(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Link(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    @Override
    public void click() {
        logTrace("Entering Link#click");
        try {
            getWrappedElement().click();
        } catch (RuntimeException rte) {
            interfaceLog(" Click Link [ <b>" + getElementLocatorInfo() + " </b> ]", true);
            throw rte;
        }
        interfaceLog(" Click Link [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Link#click");
    }

    public String getURL() {
        logTrace("Entering Link#getURL");
        String url = getWrappedElement().getAttribute("href");
        logTrace("Exiting Link#getURL");
        return url;
    }
}