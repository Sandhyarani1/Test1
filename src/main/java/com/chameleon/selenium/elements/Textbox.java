package com.chameleon.selenium.elements;

import static com.chameleon.utils.Base64Coder.decodeString;
import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.ExtendedDriver;

/**
 * Text field functionality.
 */
public class Textbox extends Element {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public Textbox(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Textbox(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    /**
     * @summary - Gets the value of an input field. Overrides default clear().
     * @see org.openqa.selenium.WebElement#clear()
     */

    @Override
    public void clear() {
        logTrace("Entering Textbox#clear");
        try {
            getWrappedElement().clear();
            interfaceLog("Clear text from Textbox [<b>" + getElementLocatorInfo() + " </b>]");
        } catch (RuntimeException rte) {
            interfaceLog("Clear text from Textbox [<b>" + getElementLocatorInfo() + " </b>]",
                    true);
            logTrace("Exiting Textbox#clear");
            throw rte;
        }
        logTrace("Exiting Textbox#clear");
    }

    /**
     * @summary - If the text parameter is not an empty string, this method
     *          clears any existing values and performs a "sendKeys(text)" to
     *          simulate typing the value. If the text parameter is an empty
     *          string, this step is skipped.
     * @param text
     *            - text to enter into the field
     */

    public void set(String text) {
        logTrace("Entering Textbox#set");
        if (!text.isEmpty()) {
            try {
                WebElement temp = getWrappedElement();
                temp.clear();
                temp.sendKeys(text);
            } catch (RuntimeException rte) {
                interfaceLog("Send Keys [ <b>" + text + "</b> ] to Textbox [ <b>"
                        + getElementLocatorInfo() + " </b>  ]", true);
                logTrace("Exiting Textbox#set");
                throw rte;
            }
        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Textbox#set");
    }

    /**
     * @summary - If the text parameter is not an empty string, the parameter is
     *          decoded using the Base64Coder class and a sendKeys() is used to
     *          simulate typing the text. If the text parameter is an empty
     *          string, this step is skipped.
     * @param text
     *            - text to enter into the field
     */

    public void setSecure(String text) {
        logTrace("Entering Textbox#setSecure");
        if (!text.isEmpty()) {
            try {
                getWrappedElement().sendKeys(decodeString(text));
                interfaceLog(" Send encoded text [ <b>" + text
                        + "</b> ] to Textbox [  <b>" + getElementLocatorInfo() + " </b> ]");
            } catch (RuntimeException rte) {
                interfaceLog("Send encoded text [ <b>" + text
                        + "</b> ] to Textbox [  <b>" + getElementLocatorInfo() + " </b> ]", true);
                throw rte;
            }
        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Textbox#setSecure");
    }

    /**
     * @summary - Gets the value of the attribute "value" of an input field.
     * @return String with the value of the field.
     */

    @Override
    public String getText() {
        logTrace("Entering Textbox#getText");
        String text;
        if (DriverType.WINDOWS.equals(driver.getDriverType())) {
            text = getWrappedElement().getText();
        } else {
            text = getWrappedElement().getAttribute("value");
        }

        logTrace("Exiting Textbox#getText");
        return text;
    }
}