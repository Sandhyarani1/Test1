package com.chameleon.selenium.windows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.chameleon.AutomationException;
import com.chameleon.BaseTest;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverManagerFactory;
import com.chameleon.selenium.DriverOptionsManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.debugging.Highlight;
import com.chameleon.utils.Constants;
import com.chameleon.utils.TestReporter;
import com.chameleon.utils.io.PropertiesManager;

public class WindowsBaseTest extends BaseTest {
    /*
     * Test Environment Fields
     */
    protected static ThreadLocal<String> applicationUnderTest = new ThreadLocal<>();
    protected static String runLocation = null;

    /*
     * WebDriver Fields
     */
    protected static ThreadLocal<String> sessionId = new ThreadLocal<>();

    /*
     * URL and Credential Repository Field
     */
    protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
    /*
     * Selenium Grid Hub Field
     */
    protected String defaultSeleniumHubURL = appURLRepository.get("DEFAULT_SELENIUMGRID_HUB_URL");

    /*
     * Getters and setters
     */
    public void setApplicationUnderTest(String aut) {
        applicationUnderTest.set(aut);
    }

    public String getApplicationUnderTest() {
        return applicationUnderTest.get();
    }

    protected void setRunLocation(String location) {
        if (location.equalsIgnoreCase("jenkinsParameter")) {
            runLocation = (System.getProperty("jenkinsRunLocation".trim()));
        } else {
            runLocation = (location);
        }
    }

    public String getRunLocation() {
        return runLocation == null ? "" : runLocation;
    }

    public String getRemoteURL() {
        if (getRunLocation().equalsIgnoreCase("grid")) {
            return defaultSeleniumHubURL;
        } else {
            return "";
        }
    }

    protected void setSeleniumHubURL(String newHubURLName) {
        defaultSeleniumHubURL = appURLRepository.get(newHubURLName);
    }

    // ************************************
    // ************************************
    // ************************************
    // DRIVER SETUP
    // ************************************
    // ************************************
    // ************************************

    @Parameters({ "applicationName", "runLocation" })
    @BeforeSuite(alwaysRun = true)
    public void beforeWindowsSuite(@Optional String applicationName, @Optional String runLocation) {
        setApplicationUnderTest(applicationName);
        setRunLocation(StringUtils.isNotEmpty(runLocation) ? runLocation : Constants.TESTNG_PARAM_RUN_LOCATION);
        Highlight.setDebugMode(false);
    }

    @Parameters({ "applicationName", "runLocation", "logLevel" })
    @BeforeMethod(alwaysRun = true)
    public void beforeWindowsMethod(@Optional String applicationName, @Optional String runLocation, @Optional String logLevel) {
        setApplicationUnderTest(applicationName);
        setRunLocation(StringUtils.isNotEmpty(runLocation) ? runLocation : Constants.TESTNG_PARAM_RUN_LOCATION);
        Highlight.setDebugMode(false);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResults) {
        endTest(getTestName(), testResults);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(ITestContext testResults) {
        endTest(getTestName(), testResults);
    }

    public ExtendedWindowsDriver testStart(String testName) {
        // Uncomment the following line to have TestReporter outputs output to
        // the console
        TestReporter.setPrintToConsole(Constants.TEST_REPORTER_DEFAULT_CONSOLE_PRINT);
        TestReporter.setDebugLevel(Constants.TEST_REPORTER_DEFAULT_LEVEL);
        setTestName(testName);
        driverSetup();
        return (ExtendedWindowsDriver) DriverManager.getDriver();
    }

    protected void endTest(String testName, ITestResult testResults) {
        // quit driver
        DriverManager.quitDriver();
    }

    /**
     * Ends the test and grabs the test result (pass/fail) in case need to use that
     * for additional reporting - such as to a sauce labs run. Allows for different
     * ways of quiting the browser depending on run status
     * Use ITestContext from @AfterTest or @AfterSuite to determine run status
     * before closing test if reporting to sauce labs
     */
    protected void endTest(String testName, ITestContext testResults) {
        ExtendedDriver driver = null;
        try {
            driver = DriverManager.getDriver();
        } catch (AutomationException e) {

        }
        if (driver != null && driver.getWebDriver() != null && !driver.getWebDriver().toString().contains("null") &&
                DriverManager.getDriver().getWebDriver().getWindowHandles().size() > 0) {

            // quit driver
            DriverManager.quitDriver();
            DriverManager.stopService();
        }

    }

    private void driverSetup() {
        // local execution
        if (getRunLocation().equalsIgnoreCase("local")) {
            localDriverSetup();
            // Code for running on remote execution such as a selenium grid or saucelabs
        } else if (getRunLocation().equalsIgnoreCase("grid")) {
            remoteDriverSetup();
        } else {
            throw new AutomationException("Parameter for run [Location] was not set to 'Local', 'Grid'");
        }

    }

    private void localDriverSetup() {
        DriverOptionsManager options = new DriverOptionsManager();
        final String app = getApplicationUnderTest();
        String appLocation = appURLRepository.get("WINDOWS_" + app);
        appLocation = appLocation == null ? app : appLocation.replace("[[project]]", Constants.CURRENT_DIR);
        options.getWindowsOptions().setApp(appLocation);
        DriverManagerFactory.getManager(DriverType.WINDOWS, options).initalizeDriver();
    }

    private void remoteDriverSetup() {

        DriverOptionsManager options = new DriverOptionsManager();
        options.getWindowsOptions().setApp(getApplicationUnderTest());

        // Create the remote web driver
        URL url = null;
        try {
            url = new URL(getRemoteURL());

        } catch (MalformedURLException e) {
            throw new AutomationException("Failed to create Remote WebDriver", e);
        }
        DriverManagerFactory.getManager(DriverType.WINDOWS, options).initalizeDriver(url);
    }
}
