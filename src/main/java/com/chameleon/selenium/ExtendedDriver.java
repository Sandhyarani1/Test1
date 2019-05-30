package com.chameleon.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteKeyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.chameleon.selenium.elements.Button;
import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.elements.Element;
import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.web.debugging.Colors;
import com.chameleon.selenium.web.debugging.Highlight;
import com.chameleon.utils.JavaUtilities;
import com.chameleon.utils.TestReporter;
import com.chameleon.utils.dataHelpers.DataWarehouse;

public abstract class ExtendedDriver implements WebDriver, TakesScreenshot {
    protected WebDriver driver;
    protected DataWarehouse dataWarehouse;
    protected int currentPageTimeout;
    protected int currentElementTimeout;
    public static boolean DEFAULT_SYNC_HANDLER = true;
    protected DriverType driverType;

    public abstract <T extends Button> List<T> findButtons(By by);

    public abstract <T extends Button> T findButton(By by);

    public abstract <T extends Checkbox> List<T> findCheckboxes(By by);

    public abstract <T extends Checkbox> T findCheckbox(By by);

    public abstract <T extends Label> List<T> findLabels(By by);

    public abstract <T extends Label> T findLabel(By by);

    public abstract <T extends Link> List<T> findLinks(By by);

    public abstract <T extends Link> T findLink(By by);

    public abstract <T extends Listbox> List<T> findListboxes(By by);

    public abstract <T extends Listbox> T findListbox(By by);

    public abstract <T extends RadioGroup> T findRadioGroup(By by);

    public abstract <T extends Textbox> List<T> findTextboxes(By by);

    public abstract <T extends Textbox> T findTextbox(By by);

    public abstract <T extends Table> List<T> findTables(By by);

    public abstract <T extends Table> T findTable(By by);

    @Override
    public Element findElement(By by) {
        return (Element) driver.findElement(by);
    }

    /**
     * Method to return the current ExtendedWebDriver
     * Example usage: getDriver().getDriver();
     *
     * @return - current ExtendedWebDriver
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }

    /**
     * Method to set the page timeout
     *
     * @param timeout
     *            - timeout with which to set the page timeout
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#pageLoadTimeout-long-java.util.concurrent.TimeUnit-
     */
    public void setPageTimeout(int timeout) {
        setPageTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * Method to set the page timeout
     *
     * @param timeout
     *            - timeout with which to set the page timeout
     * @param timeUnit
     *            -Java TimeUnit, used to determine the unit of time to be associated with the timeout
     * @see http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TimeUnit.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#pageLoadTimeout-long-java.util.concurrent.TimeUnit-
     */
    public void setPageTimeout(int timeout, TimeUnit timeUnit) {
        if (!(DriverType.SAFARI.equals(driverType))) {
            this.currentPageTimeout = timeout;
            driver.manage().timeouts().pageLoadTimeout(timeout, timeUnit);
        }
    }

    /**
     * Method to return the page timeout
     *
     * @return - page timeout
     */
    public int getPageTimeout() {
        return currentPageTimeout;
    }

    /**
     * Method to set element timeout
     *
     * @param timeout
     *            - timeout with which to set the element timeout
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#implicitlyWait-long-java.util.concurrent.TimeUnit-
     */
    public void setElementTimeout(int timeout) {
        setElementTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * Method to set the element timeout
     *
     * @param timeout
     *            - timeout with which to set the element timeout
     * @param timeUnit
     * @see http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TimeUnit.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#implicitlyWait-long-java.util.concurrent.TimeUnit-
     */
    public void setElementTimeout(int timeout, TimeUnit timeUnit) {
        this.currentElementTimeout = timeout;
        driver.manage().timeouts().implicitlyWait(timeout, timeUnit);
    }

    /**
     * Method to return the element timeout
     *
     * @return - element timeout
     */
    public int getElementTimeout() {
        return currentElementTimeout;
    }

    /**
     * Used when you want to upload a local file to the remote webdriver for use
     * on the selenium grid nodes.
     * You would then just use your normal sendKeys() method to populate the upload
     * input with a local file and selenium will transfer file across the wire to the grid
     */
    public void setFileDetector() {
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
    }

    /**
     * Method to return the RemoteWebDriver session ID
     *
     * @return RemotWebDriver session ID as a String
     * @see https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/remote/SessionId.java
     */
    public String getSessionId() {
        if (JavaUtilities.isValid(getRemoteWebDriver().getSessionId())) {
            return getRemoteWebDriver().getSessionId().toString();
        } else {
            return null;
        }
    }

    /**
     * Method to return the RemoteWebDriver
     *
     * @return RemotWebDriver
     * @see https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/remote/RemoteKeyboard.java
     */
    public RemoteKeyboard getKeyboard() {
        return new RemoteKeyboard(new RemoteExecuteMethod(getRemoteWebDriver()));
    }

    /**
     * Method to return the Selenium DesiredCapabilities
     *
     * @return Selenium DesiredCapabilitie
     */
    public Capabilities getDriverCapability() {
        return new Capabilities();
    }

    /**
     * Method to take a screen shot
     *
     * @param target
     *            - image type to capture the screenshot
     * @return Object which si stored information about the screenshot
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/TakesScreenshot.html#getScreenshotAs-org.openqa.selenium.OutputType-
     */
    @Override
    public <X> X getScreenshotAs(OutputType<X> target) {
        return ((TakesScreenshot) driver).getScreenshotAs(target);
    }

    /**
     * Method that returns the instance of the DataWarehouse
     */
    public DataWarehouse data() {
        if (dataWarehouse == null) {
            dataWarehouse = new DataWarehouse();
        }
        return dataWarehouse;
    }

    /**
     * Method to return the RemoteWebDriver
     *
     * @return RemotWebDriver
     * @see https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/remote/RemoteWebDriver.java
     */
    private RemoteWebDriver getRemoteWebDriver() {
        return ((RemoteWebDriver) driver);
    }

    public Actions actions() {
        return new Actions(driver);
    }

    /**
     * Subclass to assist with interacting with a RemoteWebDriver
     *
     * @author Justin Phlegar
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/remote/RemoteWebDriver.html#getCapabilities()
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/Capabilities.html
     */
    public class Capabilities {

        public String browserName() {
            return getRemoteWebDriver().getCapabilities().getBrowserName();
        }

        public String browserVersion() {
            return getRemoteWebDriver().getCapabilities().getVersion();
        }

        public String platformOS() {
            return getRemoteWebDriver().getCapabilities().getPlatform().name() + " "
                    + getRemoteWebDriver().getCapabilities().getPlatform().getMajorVersion() + "."
                    + getRemoteWebDriver().getCapabilities().getPlatform().getMinorVersion();
        }

        public Platform platform() {
            return getRemoteWebDriver().getCapabilities().getPlatform();
        }

    }

    public Debug debug() {
        return new Debug();
    }

    public class Debug {
        public void setReporterLogLevel(int level) {
            TestReporter.setDebugLevel(level);
        }

        public void setReporterPrintToConsole(boolean print) {
            TestReporter.setPrintToConsole(print);
        }

        public void setHighlightOnSync(boolean highlight) {
            Highlight.setDebugMode(highlight);
        }

        public void setDebugColor(Colors color) {
            Highlight.setDebugColor(color);
        }

        public void setHighlightColor(Colors color) {
            Highlight.setHighlightColor(color);
        }

        public void setErrorColor(Colors color) {
            Highlight.setErrorColor(color);
        }

        public void setSyncToFailTest(boolean syncHandler) {
            DEFAULT_SYNC_HANDLER = syncHandler;
        }

    }

    /**
     * Method to return the title of the current page
     * Example usage: getDriver().getTitle();
     *
     * @return - title of the current page
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#getTitle--
     */
    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Method to return the page source of a given current page
     *
     * @return page source of the given current page
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#getPageSource--
     */
    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    /**
     * Method to close the current window
     *
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#close--
     */
    @Override
    public void close() {
        driver.close();
    }

    /**
     * Method to quit the driver, closing every associated window
     *
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#quit--
     */
    @Override
    public void quit() {
        driver.quit();
    }

    /**
     * Method to return all window handles contained within a given current driver
     *
     * @return Set of string window handles
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#getWindowHandles--
     */
    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * Method to return the current window handle for a given currnet driver
     *
     * @return Current window handle as a String
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#getWindowHandle--
     */
    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * Method to switch to another frame or window
     *
     * @return TargetLocator that can be used to select a frame or window
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#switchTo--
     */
    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    /**
     * Method to navigate to a pre-defined URL
     *
     * @return Navigation object that allows the selection of what to do next
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#navigate--
     */
    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    /**
     * Method to facilitate the management of the driver (e.g. timeouts, cookies, etc)
     *
     * @return Options interface
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#manage--
     */
    @Override
    public Options manage() {
        return driver.manage();
    }

    /**
     * Method to return a current instance of this class as a String
     *
     * @return - current instance of this class as a String
     * @see http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#toString--
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
