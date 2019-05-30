package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface that wraps a WebElement in CheckBox functionality.
 */
public class Checkbox extends Element {
    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public Checkbox(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Checkbox(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public void toggle() {
        logTrace("Entering Checkbox#toggle");
        getWrappedElement().click();
        logTrace("Exiting Checkbox#toggle");
    }

    public void check() {
        logTrace("Entering Checkbox#check");
        if (!isChecked()) {
            try {
                toggle();
            } catch (RuntimeException rte) {
                interfaceLog(" Checking the Checkbox [ <b>" + getElementLocatorInfo() + " </b>]", true);
                logTrace("Exiting Checkbox#uncheck");
                throw rte;
            }
            interfaceLog(" Checking the Checkbox [ <b>" + getElementLocatorInfo() + " </b>]");
        }
        logTrace("Exiting Checkbox#check");
    }

    public void uncheck() {
        logTrace("Entering Checkbox#uncheck");
        if (isChecked()) {
            try {
                toggle();
            } catch (RuntimeException rte) {
                interfaceLog(" Unchecking the Checkbox [ <b>" + getElementLocatorInfo() + " </b>]", true);
                logTrace("Exiting Checkbox#uncheck");
                throw rte;
            }

            interfaceLog(" Unchecking the Checkbox [ <b>" + getElementLocatorInfo() + " </b>]");
        }
        logTrace("Exiting Checkbox#uncheck");
    }

    public boolean isChecked() {
        logTrace("Entering Checkbox#isChecked");
        boolean checked = getWrappedElement().isSelected();
        logTrace("Exiting Checkbox#isChecked");
        return checked;
    }

}