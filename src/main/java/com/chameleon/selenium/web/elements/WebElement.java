package com.chameleon.selenium.web.elements;

import static com.chameleon.selenium.ExtendedDriver.DEFAULT_SYNC_HANDLER;
import static com.chameleon.utils.Constants.MILLISECONDS_TO_POLL_FOR_ELEMENT;
import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chameleon.Beta;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.ExtendedExpectedConditions;
import com.chameleon.selenium.elements.Element;
import com.chameleon.selenium.exceptions.ElementCssValueNotMatchingException;
import com.chameleon.selenium.exceptions.ElementNotFoundInFrameException;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.debugging.Highlight;
import com.chameleon.utils.Constants;

/**
 * An ementation of the Element interface. Delegates its work to an
 * underlying WebElement instance for custom functionality.
 */
public class WebElement extends Element {

    public WebElement(final ExtendedWebDriver driver, final By by) {
        super(driver, by);
    }

    public WebElement(final ExtendedWebDriver driver, final By by, final org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    public void jsClick() {
        logTrace("Entering Element#jsClick");
        DriverManager.getWebDriver().executeJavaScript("arguments[0].scrollIntoView(true);arguments[0].click();", getWrappedElement());
        interfaceLog("Clicked [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Element#jsClick");
    }

    public void onBlur() {
        logTrace("Entering Element#onBlur");
        String jsFireEvent = "if ('createEvent' in document) { " +
                " var evt = document.createEvent('HTMLEvents'); " +
                " evt.initEvent('change', false, true); " +
                " arguments[0].dispatchEvent(evt); " +
                " } else arguments[0].fireEvent('onblur');";

        try {
            DriverManager.getWebDriver().executeJavaScript(jsFireEvent, getWrappedElement());
        } catch (WebDriverException wde) {
        }
        logTrace("Exiting Element#onBlur");
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @SuppressWarnings("unchecked")
    @Override
    public WebElement findElement(By by) {
        logTrace("Entering Element#findWebElement");
        WebElement el = getWrappedElement().findElement(by);
        logTrace("Exiting Element#findWebElement");
        return el;
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WebElement> findElements(By by) {
        logTrace("Entering Element#findWebElements");
        List<WebElement> elements = getWrappedElement().findElements(by);
        logTrace("Exiting Element#findWebElements");
        return elements;
    }

    public void highlight() {
        logTrace("Entering Element#highlight");
        Highlight.highlight(driver, getWrappedElement());
        logTrace("Exiting Element#highlight");
    }

    public void scrollIntoView() {
        logTrace("Entering Element#scrollIntoView");
        DriverManager.getWebDriver().executeJavaScript("arguments[0].scrollIntoView(true);", getWrappedElement());
        logTrace("Exiting Element#scrollIntoView");
    }

    @SuppressWarnings("rawtypes")
    public ArrayList getAllAttributes() {
        return (ArrayList) DriverManager.getWebDriver().executeJavaScript(
                "var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + ':' + a.value); } ; return s;",
                getWrappedElement());
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param cssProperty
     *            (Required) - Element CSS Property to view
     * @param value
     *            (Required) - The text the element attribute should contain in either its text or value attribute
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncCssContainsValue("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncCssContainsValue("text", 10, false)
     */
    public boolean syncCssPropertyContainsValue(String cssProperty, String value, Object... args) {
        logTrace("Entering Element#syncCssPropertyContainsValue");
        int requestedTimeout = Constants.ELEMENT_TIMEOUT;
        int originalTimeout = driver.getElementTimeout(); // to set back the icit wait to original value
        boolean failTestOnSync = DEFAULT_SYNC_HANDLER;

        try {
            if (args[0] != null) {
                requestedTimeout = Integer.valueOf(args[0].toString());
            }
            if (args[1] != null) {
                failTestOnSync = Boolean.parseBoolean(args[1].toString());
            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
        }

        boolean found = false;
        long timeLapse;
        driver.setElementTimeout(0);
        StopWatch stopwatch = new StopWatch();
        interfaceLog("<i>Syncing to CSS Property [ <b> " + cssProperty + "</b> ] to contain [ <b> " + value + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b> " + requestedTimeout + "</b> ] seconds.</i>");
        WebDriverWait wait = new WebDriverWait(driver, 1);
        stopwatch.start();

        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.textToBePresentInElementCssProperty(getWrappedElement(), cssProperty, value));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
                found = false;
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, getWrappedElement());
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] did not contain the text [ " + value
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementCssValueNotMatchingException("Element [ " + getElementLocatorInfo() + " ] CSS Property [" + cssProperty + " ] did not contain the text [ " + value
                    + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.", driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] did not contain the text [ " + value
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncCssPropertyContainsValue");
            return found;
        }

        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] contains the text [ " + value
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncCssPropertyContainsValue");
        return found;
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param cssProperty
     *            (Required) - Element CSS Property to match
     * @param regex
     *            (Required) - The regular expression that should match the text of the element CSS Property
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncCssMatchesValue("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncCssMatchesValue("text", 10, false)
     */
    public boolean syncCssPropertyMatchesValue(String cssProperty, String regex, Object... args) {
        logTrace("Entering Element#syncCssPropertyMatchesValue");
        int requestedTimeout = Constants.ELEMENT_TIMEOUT;
        int originalTimeout = driver.getElementTimeout(); // to set back the icit wait to original value
        boolean failTestOnSync = DEFAULT_SYNC_HANDLER;

        try {
            if (args[0] != null) {
                requestedTimeout = Integer.valueOf(args[0].toString());
            }
            if (args[1] != null) {
                failTestOnSync = Boolean.parseBoolean(args[1].toString());
            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
        }

        boolean found = false;
        long timeLapse;
        driver.setElementTimeout(0);
        StopWatch stopwatch = new StopWatch();
        interfaceLog("<i>Syncing to CSS Property [ <b> " + cssProperty + "</b> ] to contain [ <b> " + regex + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b> " + requestedTimeout + "</b> ] seconds.</i>");
        WebDriverWait wait = new WebDriverWait(driver, 0);
        stopwatch.start();
        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.textToMatchInElementCssProperty(getWrappedElement(), cssProperty, regex));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
                found = false;
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, getWrappedElement());
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementCssValueNotMatchingException(
                    "Element [ " + getElementLocatorInfo() + " ] CSS Property [" + cssProperty + "] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncCssPropertyMatchesValue");
            return found;
        }
        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] CSS Property [ <b>" + cssProperty + "</b> ] matches the regular expression of [ " + regex
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncCssPropertyMatchesValue");
        return found;
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

    @Beta
    public boolean syncInFrame(Object... args) {
        logTrace("Entering Element#syncInFrame");
        final String action = "<b>FOUND IN FRAME</b>";
        int requestedTimeout = Constants.ELEMENT_TIMEOUT;
        int originalTimeout = driver.getElementTimeout(); // to set back the icit wait to original value
        boolean failTestOnSync = DEFAULT_SYNC_HANDLER;

        try {
            if (args[0] != null) {
                requestedTimeout = Integer.valueOf(args[0].toString());
            }
            if (args[1] != null) {
                failTestOnSync = Boolean.parseBoolean(args[1].toString());
            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
        }

        interfaceLog("<i>Syncing to element [ <b>" + getElementLocatorInfo()
                + "</b> ] to be " + action + " within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");
        StopWatch stopwatch = new StopWatch();
        boolean found = false;
        long timeLapse;
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.setElementTimeout(0);
        stopwatch.start();
        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.elementToFoundInFrame(by));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            }
        }
        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            logTrace("Element not " + action + " and failTestOnSync is [ TRUE ]");
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not " + action + " on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementNotFoundInFrameException(
                    "Element [ " + getElementLocatorInfo() + " ] is not FOUND IN FRAME on the page after [ "
                            + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not " + action + " on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncInFrame");
            return found;
        }

        interfaceLog("<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] is " + action + " on the page after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        logTrace("Exiting Element#syncInFrame");
        return found;
    }
}
