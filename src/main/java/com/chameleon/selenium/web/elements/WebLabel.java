package com.chameleon.selenium.web.elements;

import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.chameleon.Beta;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.web.ExtendedWebDriver;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WebLabel extends Label {
    /**
     * Creates an Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public WebLabel(ExtendedWebDriver driver, By by) {
        super(driver, by);
    }

    public WebLabel(ExtendedWebDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    @Beta
    public void hover() {
        logTrace("Entering Element#hover");
        String jsFireEvent = "if(document.createEvent){var evObj = "
                + "document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); "
                + "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                + "{ arguments[0].fireEvent('onmouseover');}";

        try {
            DriverManager.getWebDriver().executeJavaScript(jsFireEvent, getWrappedElement());
        } catch (WebDriverException wde) {
        }
        logTrace("Exiting Element#hover");
    }
}