package com.chameleon.selenium.mobile.elements;

import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class MobileCheckbox extends Checkbox {
    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public MobileCheckbox(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }

    public MobileCheckbox(ExtendedMobileDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public void jsToggle() {
        logTrace("Entering Checkbox#jsToggle");
        DriverManager.getWebDriver().executeJavaScript("if( document.createEvent ) {var click_ev = document.createEvent('MouseEvents'); click_ev.initEvent('click', true , true )"
                + ";arguments[0].dispatchEvent(click_ev);} else { arguments[0].click();}", getWrappedElement());
        logTrace("Exiting Checkbox#jsToggle");
    }
}