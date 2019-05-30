package com.chameleon.selenium.web.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.web.ExtendedWebDriver;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WebLink extends Link {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public WebLink(ExtendedWebDriver driver, By by) {
        super(driver, by);
    }

    public WebLink(ExtendedWebDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public void jsClick() {
        logTrace("Entering Link#jsClick");

        try {
            DriverManager.getWebDriver().executeJavaScript(
                    "if( document.createEvent ) {var click_ev = document.createEvent('MouseEvents'); click_ev.initEvent('click', true , true )"
                            + ";arguments[0].dispatchEvent(click_ev);} else { arguments[0].click();}",
                    getWrappedElement());
        } catch (RuntimeException rte) {
            interfaceLog(" Click Link [ <b>" + getElementLocatorInfo() + " </b> ]", true);
            throw rte;
        }
        interfaceLog(" Click Link [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Link#jsClick");

    }
}
