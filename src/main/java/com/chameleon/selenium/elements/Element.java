package com.chameleon.selenium.elements;

import static com.chameleon.selenium.ExtendedDriver.DEFAULT_SYNC_HANDLER;
import static com.chameleon.utils.Constants.MILLISECONDS_TO_POLL_FOR_ELEMENT;
import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logInfo;
import static com.chameleon.utils.TestReporter.logTrace;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.ExtendedExpectedConditions;
import com.chameleon.selenium.exceptions.ElementAttributeValueNotMatchingException;
import com.chameleon.selenium.exceptions.ElementNotDisabledException;
import com.chameleon.selenium.exceptions.ElementNotEnabledException;
import com.chameleon.selenium.exceptions.ElementNotHiddenException;
import com.chameleon.selenium.exceptions.ElementNotVisibleException;
import com.chameleon.selenium.exceptions.TextInElementNotPresentException;
import com.chameleon.selenium.web.debugging.Highlight;
import com.chameleon.utils.Constants;

/**
 * wraps a web element interface with extra functionality. Anything added here
 * will be added to all descendants.
 */

public class Element implements WebElement, WrapsElement, Locatable {

    protected WebElement extendedElement;
    protected By by;
    protected ExtendedDriver driver;

    public Element(final ExtendedDriver driver, final By by) {
        this.by = by;
        this.driver = driver;
    }

    public Element(final ExtendedDriver driver, final By by, final WebElement element) {
        this.by = by;
        this.driver = driver;
        this.extendedElement = element;
        logTrace("Exiting Element#init");
    }

    /**
     * @see org.openqa.selenium.WebElement#click()
     */
    @Override
    public void click() {
        logTrace("Entering Element#click");
        try {
            getWrappedElement().click();
        } catch (RuntimeException rte) {
            interfaceLog("Clicked [ <font size = 2 color=\"red\"><b> " + getElementLocatorInfo() + " </font></b> ]");
            throw rte;
        }
        interfaceLog("Clicked [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Element#click");
    }

    public void focus() {
        logTrace("Entering Element#focus");
        new Actions(driver).moveToElement(getWrappedElement()).build().perform();
        interfaceLog("Focus on  [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Element#focus");
    }

    public void focusClick() {
        logTrace("Entering Element#focusClick");
        new Actions(driver).moveToElement(getWrappedElement()).click().perform();
        interfaceLog("Focus Clicked [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Element#focusClick");
    }
    

    /**
     * @see org.openqa.selenium.WebElement#getLocation()
     */
    @Override
    public Point getLocation() {
        logTrace("Entering Element#getLocation");
        Point point = getWrappedElement().getLocation();
        logTrace("Location of element: X = [ " + point.getX() + " ], Y = [ " + point.getY() + " ] ");
        logTrace("Exiting Element#getLocation");
        return point;
    }

    /**
     * @see org.openqa.selenium.WebElement#submit()
     */
    @Override
    public void submit() {
        logTrace("Entering Element#submit");
        getWrappedElement().submit();
        logTrace("Exiting Element#submit");
    }

    /**
     * @see org.openqa.selenium.WebElement#getAttribute(String)
     */
    @Override
    public String getAttribute(String name) {
        logTrace("Entering Element#getAttribute");
        String value = getWrappedElement().getAttribute(name);
        logTrace("Attribute value for [ " + name + " ] is [ " + value + " ]");
        logTrace("Exiting Element#getAttribute");
        return value;
    }

    /**
     * @see org.openqa.selenium.WebElement#getCssValue(String)
     */
    @Override
    public String getCssValue(String propertyName) {
        logTrace("Entering Element#getCssValue");
        String value = getWrappedElement().getCssValue(propertyName);
        logTrace("CSS property value for [ " + propertyName + " ] is [ " + value + " ]");
        logTrace("Exiting Element#getCssValue");
        return value;
    }

    /**
     * @see org.openqa.selenium.WebElement#getSize()
     */
    @Override
    public Dimension getSize() {
        logTrace("Entering Element#getSize");
        Dimension dimension = getWrappedElement().getSize();
        logTrace("Location of element: height = [ " + dimension.getHeight() + " ], width = [ " + dimension.getWidth() + " ] ");
        logTrace("Exiting Element#getSize");
        return dimension;
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @Override
    public <T extends org.openqa.selenium.WebElement> List<T> findElements(By by) {
        logTrace("Entering Element#findWebElements");
        List<Element> elements = getWrappedElement().findElements(by);
        logTrace("Exiting Element#findWebElements");
        return (List<T>) elements;
    }

    /**
     * @see org.openqa.selenium.WebElement#getText()
     */

    @Override
    public String getText() {
        logTrace("Entering Element#getText");
        String text = getWrappedElement().getText();
        logInfo("Text found in element [ " + text + " ]");
        logTrace("Exiting Element#getText");
        return text;
    }

    /**
     * @see org.openqa.selenium.WebElement#getTagName()
     */
    @Override
    public String getTagName() {
        logTrace("Entering Element#getTagName");
        String name = getWrappedElement().getTagName();
        logInfo("Tagname of element [ " + name + " ]");
        logTrace("Exiting Element#getTagName");
        return name;
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Element findElement(By by) {
        logTrace("Entering Element#findElement");
        Element el = driver.findElement(by);
        logTrace("Exiting Element#findElement");
        return el;
    }

    /**
     * @see org.openqa.selenium.WebElement#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        logTrace("Entering Element#isEnabled");
        boolean enabled = getWrappedElement().isEnabled();
        logTrace("Exiting Element#isEnabled");
        return enabled;
    }

    /**
     * @see org.openqa.selenium.WebElement#isDisplayed()
     */
    @Override
    public boolean isDisplayed() {
        logTrace("Entering Element#isDisplayed");
        boolean displayed = getWrappedElement().isDisplayed();
        logTrace("Exiting Element#isDisplayed");
        return displayed;
    }

    /**
     * @see org.openqa.selenium.WebElement#isSelected()
     */
    @Override
    public boolean isSelected() {
        logTrace("Entering Element#isSelected");
        boolean selected = getWrappedElement().isSelected();
        logTrace("Exiting Element#isSelected");
        return selected;
    }

    /**
     * @see org.openqa.selenium.WebElement#clear()
     */
    @Override
    public void clear() {
        logTrace("Entering Element#clear");
        getWrappedElement().clear();
        interfaceLog("Clear text from Element [ <b>" + getElementLocatorInfo() + " </b> ]");
        logTrace("Exiting Element#clear");
    }

    /**
     * @see org.openqa.selenium.WebElement#sendKeys(CharSequence...)
     */
    @Override
    public void sendKeys(CharSequence... keysToSend) {
        logTrace("Entering Element#sendKeys");
        String keys = "";
        if (Arrays.toString(keysToSend) != "") {
            getWrappedElement().sendKeys(keysToSend);

            for (CharSequence key : keysToSend) {
                if (key instanceof Keys) {
                    if (keys.isEmpty()) {
                        keys = "Key." + ((Keys) key).name();
                    } else {
                        keys += " + Key." + ((Keys) key).name();
                    }
                } else {
                    if (keys.isEmpty()) {
                        keys = key.toString();
                    } else {
                        keys += key.toString();
                    }
                }
            }

            interfaceLog(" Send Keys [ <b>" + keys + "</b> ] to Textbox [ <b>"
                    + getElementIdentifier() + " </b> ]");
        }
        logTrace("Exiting Element#sendKeys");
    }

    @Override
    public WebElement getWrappedElement() {
        logTrace("Entering Element#getWrappedElement");
        org.openqa.selenium.WebElement tempElement = null;
        try {
            logTrace("Validate element [ " + by.toString() + " ] is not null");
            if (extendedElement == null) {
                logTrace("Element [ " + by.toString() + " ] is null, attempt to cache the element");
                try {
                    WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), driver.getElementTimeout());
                    tempElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
                } catch (WebDriverException wde) {
                    throw new NoSuchElementException("Failed locate element [ " + by.toString() + " ]", wde);
                }
                extendedElement = tempElement;
                logTrace("Successfully cached element [ " + by.toString() + " ]");

            } else {
                tempElement = extendedElement;
            }

            logTrace("Validate element [ " + by.toString() + " ] is not stale");
            tempElement.isDisplayed();

            logTrace("Successfully validated element [ " + by.toString() + " ] is usable");
            logTrace("Exiting Element#getWrappedElement");
            return tempElement;
        } catch (StaleElementReferenceException | NullPointerException e) {

            try {
                logTrace("Element [ " + by.toString() + " ] is stale, attempt to recache the element");
                WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), driver.getElementTimeout());
                tempElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
                logTrace("Successfully recached element [ " + by.toString() + " ]");
                extendedElement = tempElement;
                logTrace("Exiting Element#getWrappedElement");
                return tempElement;
            } catch (NullPointerException sere) {
                logTrace("Exiting Element#getWrappedElement");
                return extendedElement;
            }
        } catch (NoSuchElementException nsee) {
            logTrace("Failed to recache element [ " + by.toString() + " ]");
            logTrace("Exiting Element#getWrappedElement");
            throw nsee;
        }
    }

    public boolean elementWired() {
        return (getWrappedElement() != null);
    }

    public String getElementIdentifier() {
        String locator = "";
        int startPosition = 0;
        startPosition = by.toString().lastIndexOf(": ") + 2;
        locator = by.toString().substring(startPosition, by.toString().length());
        return locator.trim();

    }

    public String getElementLocatorInfo() {
        return by.toString();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) {
        return getWrappedElement().getScreenshotAs(target);
    }

    /**
     * Used to determine if the desired element is visible on the screen
     * Will wait for default element timeout unless new timeout is passed in
     * If object is not visible within the time, handle the error based default handler
     * or by boolean passed in
     *
     * @author Justin
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncVisible(10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncVisible(10, false)
     */
    public boolean syncVisible(Object... args) {
        logTrace("Entering Element#syncVisible");
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
                + "</b> ] to be <b>VISIBLE</b> within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");

        StopWatch stopwatch = new StopWatch();
        boolean found = false;
        long timeLapse;

        driver.setElementTimeout(0);
        WebDriverWait wait = new WebDriverWait(driver, 1);
        stopwatch.start();
        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {

                if (extendedElement == null) {
                    getWrappedElement();
                }

                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.elementToBeVisible(by));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            }
        }
        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            logTrace("Element not <b>VISIBLE</b> and failTestOnSync is [ TRUE ]");
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>VISIBLE</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementNotVisibleException(
                    "Element [ " + getElementLocatorInfo() + " ] is not VISIBLE on the page after [ "
                            + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>VISIBLE</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncVisible");
            return found;
        }

        interfaceLog("<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] is <b>VISIBLE</b> on the page after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncVisible");
        return found;

    }

    /**
     * Used to determine if the desired element is hidden on the screen
     * Will wait for default element timeout unless new timeout is passed in
     * If object is not hidden within the time, handle the error based default handler
     * or by boolean passed in
     *
     * @author Justin
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncHidden(10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncHidden(10, false)
     */
    public boolean syncHidden(Object... args) {
        logTrace("Entering Element#syncHidden");
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

        StopWatch stopwatch = new StopWatch();
        interfaceLog("<i>Syncing to element [ <b>" + getElementLocatorInfo()
                + "</b> ] to be <b>HIDDEN</b> within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");

        boolean found = false;
        long timeLapse;
        driver.setElementTimeout(0);
        stopwatch.start();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.elementToBeHidden(by));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            logTrace("Element not <b>HIDDEN</b> and failTestOnSync is [ TRUE ]");
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>HIDDEN</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementNotHiddenException(
                    "Element [ " + getElementLocatorInfo() + " ] is not HIDDEN on the page after [ "
                            + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>HIDDEN</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncHidden");
            return found;
        }

        interfaceLog("<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] is <b>HIDDEN</b> on the page after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        logTrace("Exiting Element#syncHidden");
        return found;
    }

    /**
     * Used to determine if the desired element is enabled on the screen
     * Will wait for default element timeout unless new timeout is passed in
     * If object is not enabled within the time, handle the error based default handler
     * or by boolean passed in
     *
     * @author Justin
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncEnabled(10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncEnabled(10, false)
     */
    public boolean syncEnabled(Object... args) {
        logTrace("Entering Element#syncEnabled");
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
        interfaceLog("<i>Syncing to element [ <b>" + getElementLocatorInfo()
                + "</b> ] to be <b>ENABLED</b> within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");
        stopwatch.start();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExpectedConditions.elementToBeClickable(getWrappedElement())) != null;
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            } catch (WebDriverException we) {
                if (!we.getMessage().toLowerCase().contains("is not clickable at point")) {
                    throw we;
                }
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, extendedElement);
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>ENABLED</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementNotEnabledException(
                    "Element [ " + getElementLocatorInfo() + " ] is not ENABLED on the page after [ "
                            + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>ENABLED</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncEnabled");
            return found;
        }

        interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                + " </b> ] is <b>ENABLED</b> on the page after [ "
                + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncEnabled");
        return found;
    }

    /**
     * Used to determine if the desired element is disabled on the screen
     * Will wait for default element timeout unless new timeout is passed in
     * If object is not disabled within the time, handle the error based default handler
     * or by boolean passed in
     *
     * @author Justin
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncDisabled(10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncDisabled(10, false)
     */
    public boolean syncDisabled(Object... args) {
        logTrace("Entering Element#syncDisabled");
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
        interfaceLog("<i>Syncing to element [ <b>" + getElementLocatorInfo()
                + "</b> ] to be <b>DISABLED</b> within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");
        stopwatch.start();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(getWrappedElement()))) != null;
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            } catch (WebDriverException we) {
                if (!we.getMessage().toLowerCase().contains("is not clickable at point")) {
                    throw we;
                }
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, getWrappedElement());
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>DISABLED</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementNotDisabledException(
                    "Element [ " + getElementLocatorInfo() + " ] is not DISABLED on the page after [ "
                            + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                    + " </b> ] is not <b>DISABLED</b> on the page after [ "
                    + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncDisabled");
            return found;
        }

        interfaceLog("<i>Element [ <b>" + getElementLocatorInfo()
                + " </b> ] is <b>DISABLED</b> on the page after [ "
                + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncDisabled");
        return found;
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param text
     *            (Required) The text the element should contain in either its text or value attribute
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncTextInElement("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncTextInElement("text", 10, false)
     */
    public boolean syncTextInElement(String text, Object... args) {
        logTrace("Entering Element#syncTextInElement");
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
        StopWatch stopwatch = new StopWatch();
        interfaceLog("<i>Syncing to text [ <b>" + text + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");

        driver.setElementTimeout(0);
        WebDriverWait wait = new WebDriverWait(driver, 0);
        stopwatch.start();
        if (Highlight.getDebugMode()) {
            Highlight.highlightDebug(driver, getWrappedElement());
        }
        do {
            try {
                if (wait.until(ExpectedConditions.textToBePresentInElement(getWrappedElement(), text)) != null) {
                    found = true;
                } else if (wait.until(ExpectedConditions.textToBePresentInElementValue(getWrappedElement(), text)) != null) {
                    found = true;
                }
                if (found) {
                    break;
                }
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            }
        } while (stopwatch.getTime() / 1000.0 < requestedTimeout);

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, extendedElement);
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] did not contain the text [ " + text
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new TextInElementNotPresentException(
                    "Element [ " + getElementLocatorInfo() + " ] did not contain the text [ " + text
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] did not contain the text [ " + text
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncTextInElement");
            return found;
        }
        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] contains the text [ " + text
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncTextInElement");
        return found;
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param regex
     *            (Required) The text the element should contain in either its text or value attribute
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncTextMatchesInElement("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncTextMatchesInElement("text", 10, false)
     */
    public boolean syncTextMatchesInElement(String regex, Object... args) {
        logTrace("Entering Element#syncTextMatchesInElement");
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
        interfaceLog("<i>Syncing to text regular expression [ <b>" + regex + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b>" + requestedTimeout + "</b> ] seconds.</i>");
        stopwatch.start();
        WebDriverWait wait = new WebDriverWait(driver, 0);

        do {

            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                if (wait.until(ExtendedExpectedConditions.textToMatchInElement(getWrappedElement(), regex)) != null) {
                    found = true;
                } else if (wait.until(ExtendedExpectedConditions.textToMatchInElementAttribute(getWrappedElement(), "value", regex)) != null) {
                    found = true;
                }
                if (found) {
                    break;
                }
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException e) {
            }
        } while (stopwatch.getTime() / 1000.0 < requestedTimeout);

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, getWrappedElement());
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] did not contain the text [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new TextInElementNotPresentException(
                    "Element [ " + getElementLocatorInfo() + " ] did not contain the text [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] did not contain the text [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncTextMatchesInElement");
            return found;
        }

        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] contains the text [ " + regex
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncTextMatchesInElement");
        return found;
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param attribute
     *            (Required) - Element attribute to view
     * @param value
     *            (Required) - The text the element attribute should contain in either its text or value attribute
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncAttributeContainsValue("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncAttributeContainsValue("text", 10, false)
     */
    public boolean syncAttributeContainsValue(String attribute, String value, Object... args) {
        logTrace("Entering Element#syncAttributeContainsValue");
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
        interfaceLog("<i>Syncing to attribute [ <b> " + attribute + "</b> ] to contain [ <b> " + value + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b> " + requestedTimeout + "</b> ] seconds.</i>");
        stopwatch.start();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.textToBePresentInElementAttribute(getWrappedElement(), attribute, value));
            } catch (NoSuchElementException | ClassCastException | StaleElementReferenceException | TimeoutException te) {
            }
        }

        stopwatch.stop();
        timeLapse = stopwatch.getTime();
        stopwatch.reset();
        driver.setElementTimeout(originalTimeout);

        if (!found && failTestOnSync) {
            Highlight.highlightError(driver, getWrappedElement());
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] did not contain the text [ " + value
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementAttributeValueNotMatchingException(
                    "Element [ " + getElementLocatorInfo() + " ]attribute [" + attribute + "] did not contain the text [ " + value
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] did not contain the text [ " + value
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncAttributeContainsValue");
            return found;
        }

        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] contains the text [ " + value
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncAttributeContainsValue");
        return found;
    }

    /**
     * Sync for the Element's text or it's value attribute contains the desired text.
     * Additional parameters can be added to override the default timeout and if the
     * test should fail if the sync fails
     *
     * @param attribute
     *            (Required) - Element attribute to view
     * @param regex
     *            (Required) - The regular expression that should match the text of the element attribute
     * @param args
     *            Optional arguments </br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>timeout</b> - the maximum time in seconds the method should try to sync. Called
     *            with syncAttributeMatchesValue("text", 10)</br>
     *            &nbsp;&nbsp;&nbsp;&nbsp;<b>failTestOnSyncFailure </b>- if TRUE, the test will throw an exception and
     *            fail the script. If FALSE, the script will
     *            not fail, instead a FALSE will be returned
     *            to the calling function. Called with
     *            syncAttributeMatchesValue("text", 10, false)
     */
    public boolean syncAttributeMatchesValue(String attribute, String regex, Object... args) {
        logTrace("Entering Element#syncAttributeMatchesValue");
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
        interfaceLog("<i>Syncing to attribute [ <b> " + attribute + "</b> ] to match the regular expression of [ <b> " + regex + "</b> ] in element [ <b>"
                + getElementLocatorInfo() + "</b> ] to be displayed within [ <b> " + requestedTimeout + "</b> ] seconds.</i>");
        WebDriverWait wait = new WebDriverWait(driver, 1);

        stopwatch.start();
        while (((stopwatch.getTime()) / 1000.0) < requestedTimeout && !found) {
            try {
                if (Highlight.getDebugMode()) {
                    Highlight.highlightDebug(driver, getWrappedElement());
                }
                found = wait.pollingEvery(Duration.ofMillis(MILLISECONDS_TO_POLL_FOR_ELEMENT)).until(ExtendedExpectedConditions.textToMatchInElementAttribute(getWrappedElement(), attribute, regex));
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
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            throw new ElementAttributeValueNotMatchingException(
                    "Element [ " + getElementLocatorInfo() + " ]attribute [" + attribute + "] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.",
                    driver);
        } else if (!found) {
            interfaceLog(
                    "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] did not match the regular expression of [ " + regex
                            + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
            logTrace("Exiting Element#syncAttributeMatchesValue");
            return found;
        }
        interfaceLog(
                "<i>Element [ <b>" + getElementLocatorInfo() + " </b> ] attribute [ <b>" + attribute + "</b> ] matches the regular expression of [ " + regex
                        + " ] after [ " + (timeLapse) / 1000.0 + " ] seconds.</i>");
        if (Highlight.getDebugMode()) {
            Highlight.highlightSuccess(driver, getWrappedElement());
        }
        logTrace("Exiting Element#syncAttributeMatchesValue");
        return found;
    }

    @Override
    public Rectangle getRect() {
        return getWrappedElement().getRect();
    }

    @Override
    public Coordinates getCoordinates() {

        return new Coordinates() {

            @Override
            public Point onScreen() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Point inViewPort() {
                return getWrappedElement().getLocation();
            }

            @Override
            public Point onPage() {
                return getLocation();
            }

            @Override
            public Object getAuxiliary() {
                return ((RemoteWebElement) getWrappedElement()).getId();
            }
        };
    }

}