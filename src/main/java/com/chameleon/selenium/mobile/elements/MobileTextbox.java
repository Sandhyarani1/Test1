package com.chameleon.selenium.mobile.elements;

import static com.chameleon.utils.Base64Coder.decodeString;
import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;

/**
 * TextInput wrapper.
 */
public class MobileTextbox extends Textbox {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param extendedElement
     *            element to wrap up
     */

    public MobileTextbox(ExtendedMobileDriver driver, By by) {
        super(driver, by);
    }

    public MobileTextbox(ExtendedMobileDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    /**
     * @summary - If the text parameter is not an empty string, this method
     *          clears any existing values and performs a "sendKeys(text)" to
     *          simulate typing the value. If the text parameter is an empty
     *          string, this step is skipped.
     * @param text
     *            - text to enter into the field
     */
    public void jsSet(String text) {
        logTrace("Entering Textbox#jsSet");
        if (text == null) {
            text = "";
        }
        if (!text.isEmpty()) {
            if (text.equalsIgnoreCase("<blank>") || text.equalsIgnoreCase("(blank)")) {
                interfaceLog(" Request to blank text field sent. Clearing Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
                getWrappedElement().clear();
            } else {
                interfaceLog(" Send Keys [ <b>" + text + "</b> ] to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
                try {
                    DriverManager.getWebDriver().executeJavaScript("arguments[0].scrollIntoView(true);arguments[0].setAttribute('value', arguments[1])", getWrappedElement(), text);
                } catch (WebDriverException wde) {
                    getWrappedElement().clear();
                    getWrappedElement().sendKeys(text);
                }
            }
        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Textbox#jsSet");
    }

    /**
     * @summary - Overloads overridden set() method. If the text parameter is
     *          not an empty string, this method uses a JavascriptExecutor to
     *          scroll the text field into view and click the text field, then
     *          uses Selenium to clear any existing values and performs a
     *          "sendKeys(text)" to simulate typing the value. If the text
     *          parameter is an empty string, this step is skipped.
     * @param text
     *            - text to enter into the field
     */
    public void scrollAndSet(String text) {
        logTrace("Entering Textbox#scrollAndSet");
        if (!text.isEmpty()) {
            try {
                DriverManager.getWebDriver().executeJavaScript("arguments[0].scrollIntoView(true);arguments[0].click();", getWrappedElement());
                getWrappedElement().clear();
                getWrappedElement().sendKeys(text);
                interfaceLog(" Send Keys [ <b>" + text + "</b> ] to Textbox [ <b>"
                        + getElementLocatorInfo() + " </b> ]");

            } catch (RuntimeException rte) {
                interfaceLog("Send Keys [ <b>" + text + "</b> ] to Textbox [ <b>"
                        + getElementLocatorInfo() + " </b> ]", true);
                logTrace("Exiting Textbox#scrollAndSet");
                throw rte;
            }
        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Textbox#scrollAndSet");
    }

    /**
     * @summary - If the text parameter is not an empty string, the text field
     *          is clicked, then sendKeys() is used to select any/all existing
     *          text, type the text passed in the parameter and send a "TAB"
     *          key. This is useful if moving from an element is required to
     *          trigger underlying JavaScript. If the text parameter is an empty
     *          string, this step is skipped.
     * @param text
     *            - text to enter into the field
     */
    public void safeSet(String text) {
        logTrace("Entering Textbox#safeSet");
        if (!text.isEmpty()) {
            try {

                DriverManager.getWebDriver().executeJavaScript("arguments[0].setAttribute('value', arguments[1])", getWrappedElement(), "");
                getWrappedElement().sendKeys(text);
                getWrappedElement().sendKeys(Keys.TAB);
                interfaceLog(" Send Keys [ <b>" + text + "</b> ] to Textbox [  <b>"
                        + getElementLocatorInfo() + " </b> ]");
            } catch (RuntimeException rte) {
                interfaceLog("Send Keys [ <b>" + text + "</b> ] to Textbox [  <b>"
                        + getElementLocatorInfo() + " </b> ]", true);
                throw rte;
            }
        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Textbox#safeSet");
    }

    /**
     * @summary - If the text parameter is not an empty string, the text field
     *          is clicked, then sendKeys() is used to select any/all existing
     *          text, type the decoded parameter (decode the parameter using the
     *          Base64Coder) in the text field and send a "TAB" key. This is
     *          useful if moving from an element is required to trigger
     *          underlying JavaScript. If the text parameter is an empty string,
     *          this step is skipped.
     * @param text
     *            - text to enter into the field
     */
    public void safeSetSecure(String text) {
        logTrace("Entering Textbox#safeSetSecure");
        if (!text.isEmpty()) {
            try {
                DriverManager.getWebDriver().executeJavaScript("arguments[0].setAttribute('value', arguments[1])", getWrappedElement(), "");
                getWrappedElement().sendKeys(decodeString(text));
                getWrappedElement().sendKeys(Keys.TAB);
                interfaceLog(" Send encoded text [ <b>" + text + "</b> ] to Textbox [  <b>"
                        + getElementLocatorInfo() + " </b> ]");
            } catch (RuntimeException rte) {
                interfaceLog("Send encoded text [ <b>" + text
                        + "</b> ] to Textbox [  <b>" + getElementLocatorInfo() + " </b> ]", true);
                logTrace("Exiting Textbox#safeSetSecure");
                throw rte;
            }

        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }

        logTrace("Exiting Textbox#safeSetSecure");
    }
}