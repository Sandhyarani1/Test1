package com.chameleon.selenium.mobile.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logFailure;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.elements.Button;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;
import com.chameleon.selenium.web.WebException;

/**
 * Wraps a label on a html form with some behavior.
 */
public class MobileButton extends Button {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            - element to wrap up
     */

    public MobileButton(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }

    public MobileButton(ExtendedMobileDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public void jsClick() {
        logTrace("Entering Button#jsClick");
        try {
            logTrace("Attempting to executed [ jsClick ] on element [ " + by.toString() + " ] ");
            DriverManager.getWebDriver().executeJavaScript("arguments[0].click();", getWrappedElement());
            logTrace("Successfully executed [ jsClick ] on element [ " + by.toString() + " ] ");
        } catch (RuntimeException rte) {
            logFailure("Clicked Button [ <b>" + getElementLocatorInfo() + "</b> ]");
            logTrace("Failed to execute [ jsClick ] on element [ " + by.toString() + " ] ");
            logTrace("Exiting Button#jsClick");
            throw new WebException(rte.getMessage(), driver);
        }
        interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b> ]");
        logTrace("Exiting Button#jsClick");

    }
}