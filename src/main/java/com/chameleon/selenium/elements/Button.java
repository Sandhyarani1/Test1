package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface that wraps a WebElement in Button functionality.
 */
public class Button extends Element {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            - element to wrap up
     */

    public Button(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Button(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    @Override
    public void click() {
        logTrace("Entering Button#click");
        try {
            logTrace("Attempting to invoke method [ Click ] on element [ " + by.toString() + " ] ");
            getWrappedElement().click();
        } catch (RuntimeException rte) {
            interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b> ]", true);
            throw rte;
        }

        interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b> ] ");
        logTrace("Successfully invoked method [ Click ] on element [ " + by.toString() + " ] ");
        logTrace("Exiting Button#click");
    }

}