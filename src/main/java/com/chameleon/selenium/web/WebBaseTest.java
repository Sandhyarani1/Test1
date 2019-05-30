package com.chameleon.selenium.web;

import static com.chameleon.selenium.DriverConstants.DEFAULT_CHROME_PAGE_LOAD_STRATEGY;
import static com.chameleon.selenium.web.chromeDevTool.ChromeDevToolEmulator.DEVICE_NAME;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.accuweather.glacier.Environment;
import com.chameleon.AutomationException;
import com.chameleon.BaseTest;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverManagerFactory;
import com.chameleon.selenium.DriverOptionsManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.chromeDevTool.ChromeDevToolEmulator;
import com.chameleon.selenium.web.debugging.Highlight;
import com.chameleon.utils.Base64Coder;
import com.chameleon.utils.Constants;
import com.chameleon.utils.TestReporter;
import com.chameleon.utils.io.PropertiesManager;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.saucerest.SauceREST;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobilePlatform;

/**
 *
 * @author Justin Phlegar & Waightstill W Avery
 * @summary This class is designed to be extended by page classes and
 *          implemented by test classes. It houses test environment data and
 *          associated getters and setters, setup for both local and remote
 *          WebDrivers as well as page class methods used to sync page behavior.
 *          The need for this arose due to the parallel behavior that indicated
 *          that WebDriver instances were crossing threads and testing on the
 *          wrong os/browser configurations
 * @date April 5, 2015
 *
 */
public class WebBaseTest extends BaseTest {
    /*
     * Test Environment Fields
     */
    protected static ThreadLocal<String> applicationUnderTest = new ThreadLocal<>();
    protected static ThreadLocal<String> browserUnderTest = new ThreadLocal<>();
    protected static ThreadLocal<String> browserVersion = new ThreadLocal<>();
    protected static ThreadLocal<String> operatingSystem = new ThreadLocal<>();
    protected static ThreadLocal<String> runLocation = new ThreadLocal<>();
    protected static ThreadLocal<String> pageUrl = new ThreadLocal<>();

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
     * Mobile Fields
     */
    protected static ThreadLocal<String> deviceID = new ThreadLocal<>();
    protected String mobileHubURL = appURLRepository.get("MOBILE_HUB_URL");
    protected String mobileHubKey = appURLRepository.get("MOBILE_HUB_ACCESS_KEY");
    protected static ThreadLocal<String> mobileOSVersion = new ThreadLocal<>();
    protected String mobileAppPath = appURLRepository.get("MOBILE_APP_PATH");

    /*
     * Sauce Labs Fields
     */

    /**
     * Constructs a {@link com.saucelabs.common.SauceOnDemandAuthentication}
     * instance using the supplied user name/access key. To use the
     * authentication supplied by environment variables or from an external
     * file, use the no-arg
     * {@link com.saucelabs.common.SauceOnDemandAuthentication} constructor.
     */

    protected SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
            Base64Coder.decodeString(appURLRepository.get("SAUCELABS_USERNAME")),
            Base64Coder.decodeString(appURLRepository.get("SAUCELABS_KEY")));

    protected String sauceLabsURL = "http://" + authentication.getUsername() + ":" + authentication.getAccessKey()
            + "@ondemand.saucelabs.com:80/wd/hub";

    /*
     * Mustard Fields
     */
    protected boolean reportToMustard = false;

    /*
     * Getters and setters
     */
    public void setApplicationUnderTest(String aut) {
        applicationUnderTest.set(aut);
    }

    public String getApplicationUnderTest() {
        return applicationUnderTest.get();
    }

    public void setPageURL(String url) {
        pageUrl.set(url);
    }

    public String getPageURL() {
        return pageUrl.get();
    }

    public void setBrowserUnderTest(String but) {
        if (but.equalsIgnoreCase("jenkinsParameter")) {
            browserUnderTest.set(System.getProperty("jenkinsBrowser").trim());
        } else {
            browserUnderTest.set(but);
        }
    }

    public String getBrowserUnderTest() {
        return browserUnderTest.get() == null ? "" : browserUnderTest.get();
    }

    public void setBrowserVersion(String bv) {
        if (bv.equalsIgnoreCase("jenkinsParameter")) {
            if (System.getProperty("jenkinsBrowserVersion") == null
                    || System.getProperty("jenkinsBrowserVersion") == "null") {
                browserVersion.set("");
            } else {
                browserVersion.set(System.getProperty("jenkinsBrowserVersion").trim());
            }
        } else {
            browserVersion.set(bv);
        }
    }

    public String getBrowserVersion() {
        return browserVersion.get();
    }

    protected void setRunLocation(String location) {
        if (location.equalsIgnoreCase("jenkinsParameter")) {
            runLocation.set(System.getProperty("jenkinsRunLocation".trim()));
        } else {
            runLocation.set(location);
        }
    }

    public String getRunLocation() {
        return runLocation.get() == null ? "" : runLocation.get();
    }

    public void setOperatingSystem(String os) {
        if (os.equalsIgnoreCase("jenkinsParameter")) {
            operatingSystem.set(System.getProperty("jenkinsOperatingSystem").trim());
        } else {
            operatingSystem.set(os);
        }
    }

    public String getOperatingSystem() {
        return operatingSystem.get() == null ? "" : operatingSystem.get();
    }

    public String getRemoteURL() {
        if (getRunLocation().equalsIgnoreCase("sauce")) {
            return sauceLabsURL;
        } else if (getRunLocation().equalsIgnoreCase("grid")) {
            return defaultSeleniumHubURL;
        } else if (getRunLocation().equalsIgnoreCase("mobile")) {
            return mobileHubURL;
        } else {
            return "";
        }
    }

    protected void setSeleniumHubURL(String newHubURLName) {
        defaultSeleniumHubURL = appURLRepository.get(newHubURLName);
        ;
    }

    /*
     * Mobile Specific
     */
    protected void setDeviceID(String deviceId) {
        deviceID.set(deviceId);
    }

    protected void setMobileOSVersion(String mobileVersion) {
        mobileOSVersion.set(mobileVersion);
    }

    // ************************************
    // ************************************
    // ************************************
    // WEBDRIVER SETUP
    // ************************************
    // ************************************
    // ************************************

    /**
     * Doubling up to cover different threading between before test and before method
     *
     * @param browserUnderTest
     * @param browserVersion
     * @param operatingSystem
     * @param runLocation
     */
    @Parameters({ "browserUnderTest", "browserVersion", "operatingSystem", "runLocation" })
    @BeforeSuite(alwaysRun = true)
    public void beforeWebTest(@Optional String browserUnderTest, @Optional String browserVersion, @Optional String operatingSystem, @Optional String runLocation) {
        setBrowserUnderTest(StringUtils.isNotEmpty(browserUnderTest) ? browserUnderTest : Constants.TESTNG_PARAM_BROWSER);
        setBrowserVersion(StringUtils.isNotEmpty(browserVersion) ? browserVersion : "");
        setOperatingSystem(StringUtils.isNotEmpty(operatingSystem) ? operatingSystem : "");
        setRunLocation(StringUtils.isNotEmpty(runLocation) ? runLocation : Constants.TESTNG_PARAM_RUN_LOCATION);
        Highlight.setDebugMode(true);
    }

    /**
     * Doubling up to cover different threading between before test and before method
     *
     * @param browserUnderTest
     * @param browserVersion
     * @param operatingSystem
     * @param runLocation
     * @param environment
     */
    @Parameters({ "browserUnderTest", "browserVersion", "operatingSystem", "runLocation", "environment" })
    @BeforeMethod(alwaysRun = true)
    public void beforeWebMethod(@Optional String browserUnderTest, @Optional String browserVersion, @Optional String operatingSystem, @Optional String runLocation, @Optional String environment) {
        setBrowserUnderTest(StringUtils.isNotEmpty(browserUnderTest) ? browserUnderTest : Constants.TESTNG_PARAM_BROWSER);
        setBrowserVersion(StringUtils.isNotEmpty(browserVersion) ? browserVersion : "");
        setOperatingSystem(StringUtils.isNotEmpty(operatingSystem) ? operatingSystem : "");
        setRunLocation(StringUtils.isNotEmpty(runLocation) ? runLocation : Constants.TESTNG_PARAM_RUN_LOCATION);
        setEnvironment(StringUtils.isNotEmpty(environment) ? environment : Constants.TESTNG_PARAM_ENVIRONMENT);
        Environment.setEnvironment(environment);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResults) {
        endTest(getTestName(), testResults);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(ITestContext testResults) {
        endTest(getTestName(), testResults);
    }

    /**
     * Method to retrive the URL and Credential Repository
     */
    protected Map<String, String> getEnvironmentURLRepository() {
        return appURLRepository;
    }

    /**
     * Launches the application under test using a URL passed into method
     *
     * @version 12/16/2014
     * @author Justin Phlegar
     * @return Nothing
     */
    private void launchApplication(String URL) {
        DriverManager.getDriver().get(URL);
    }

    /**
     * Launches the application under test using the URL grabbed from the EnvironmentURLs properties file
     * It will look for a key in the properties file with the
     * prefix of the application under test + "_" + the environment being tested.
     *
     * @version 12/16/2014
     * @author Justin Phlegar
     * @return Nothing
     */
    private void launchApplication() {
        launchApplication(appURLRepository.get(getApplicationUnderTest().toUpperCase() + "_" + getEnvironment().toUpperCase()));
    }

    /**
     * Initializes the webdriver, sets up the run location, driver type,
     * launches the application. Gives the option of using the EnvironmentURL properties
     * file to launch the URL of the application, or you can set the page URL during setup by calling
     * setPageURL("http://urlforthepage.com"). Unless you are wanting the test to start from a specific
     * page in the application under test, you will not set that field & will instead just use the base
     * URL from the properties file
     *
     * @version 12/16/2014
     * @author Jessica Marshall
     */
    public ExtendedWebDriver testStart(String testName) {
        // Uncomment the following line to have TestReporter outputs output to
        // the console
        TestReporter.setPrintToConsole(true);
        setTestName(testName);
        driverSetup();
        // launch the application under test normally
        if (getPageURL() == null || getPageURL().isEmpty()) {
            launchApplication();
            // Otherwise if you have a specific page you want the test to start from
        } else {
            launchApplication(getPageURL());
        }
        return DriverManager.getWebDriver();
    }

    /**
     * Ends the test and grabs the test result (pass/fail) in case need to use that
     * for additional reporting - such as to a sauce labs run. Allows for different
     * ways of quiting the browser depending on r
     * Use ITestResult from @AfterMethod to determine run status before closing
     * test if reporting to sauce labs
     */
    protected void endTest(String testName, ITestResult testResults) {

        ExtendedWebDriver driver = null;
        try {
            driver = DriverManager.getWebDriver();
        } catch (AutomationException e) {

        }
        if (driver != null && driver.getWebDriver() != null && !driver.getWebDriver().toString().contains("null") &&
                DriverManager.getDriver().getWebDriver().getWindowHandles().size() > 0) {
            if (getRunLocation().equalsIgnoreCase("sauce")) {
                // Sauce labs specific to end test
                if (getRunLocation().equalsIgnoreCase("sauce")) {
                    // reportToSauceLabs(testResults.getStatus());
                }
            }
            // quit driver
            DriverManager.quitDriver();
            DriverManager.stopService();
        }
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
            if (getRunLocation().equalsIgnoreCase("sauce")) {
                if (testResults.getFailedTests().size() == 0) {
                    // reportToSauceLabs(ITestResult.SUCCESS);
                } else {
                    // reportToSauceLabs(ITestResult.FAILURE);
                }
            }
            // quit driver
            DriverManager.quitDriver();
            DriverManager.stopService();
        }

    }

    /**
     * Ends the test for a sauce labs run by passing in the test results (pass/fail)
     * and quits
     *
     * @param result
     */
    private void reportToSauceLabs(int result) {
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", getTestName());

        if (result == ITestResult.FAILURE) {
            updates.put("passed", false);
        } else {
            updates.put("passed", true);
        }
        SauceREST client = new SauceREST(authentication.getUsername(), authentication.getAccessKey());
        client.updateJobInfo(DriverManager.getDriver().getSessionId(), updates);
    }

    /**
     * Sets up the driver type, location, browser under test, os
     *
     * @param None
     * @version 12/16/2014
     * @author Justin Phlegar
     * @return Nothing
     * @throws IOException
     * @throws InterruptedException
     */
    private void driverSetup() {
        // local execution
        if (getRunLocation().equalsIgnoreCase("local")) {
            localDriverSetup();

            // Code for running on remote execution such as a selenium grid or saucelabs
        } else if (getRunLocation().equalsIgnoreCase("grid") || getRunLocation().equalsIgnoreCase("sauce")) {
            remoteDriverSetup();
        }
        // Code for running on mobile devices
        else if (getRunLocation().equalsIgnoreCase("mobile")) {
            mobileDriverSetup();
        }
        // Code for running on mobile devices
        else if (getRunLocation().equalsIgnoreCase("mobile_emulator")) {
            mobileEmulatorDriverSetup();
        } else {
            throw new AutomationException(
                    "Parameter for run [Location] was not set to 'Local', 'Grid', 'Sauce', 'Mobile'");
        }

        // Microsoft Edge Browser
        if (!getRunLocation().equalsIgnoreCase("mobile")) {
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    /**
     * Creates a local web driver instance based on browser, browser version (required only for firefox).
     * It uses driver servers for each browser that are stored within the project.
     * For firefox versions greater than 46, you will need to use the marionette/gecko driver.
     *
     * @author jessica.marshall
     * @date 9/13/2016
     */
    private void localDriverSetup() {
        if (DriverType.HTML.equals(DriverType.fromString(getBrowserUnderTest()))) {
            DriverOptionsManager options = new DriverOptionsManager();
            options.getFirefoxOptions().setHeadless(true);
            setBrowserUnderTest("firefox");
            DriverManagerFactory.getManager(DriverType.fromString(getBrowserUnderTest()), options).initalizeDriver();
        } else {
            DriverManagerFactory.getManager(DriverType.fromString(getBrowserUnderTest())).initalizeDriver();
        }
    }

    /**
     * Creates the remote webdriver instance based on browser, browser version
     * OS, and the remote grid URL
     *
     * @author jessica.marshall
     * @date 9/13/2016
     */
    private void remoteDriverSetup() {
        DriverOptionsManager options = new DriverOptionsManager();
        DriverType type = DriverType.fromString(getBrowserUnderTest());

        if (!getBrowserVersion().isEmpty()) {
            // Setting Browser version if desired
            options.setBrowserVersion(type, getBrowserVersion());
        }

        // Setting default Broswer options
        switch (DriverType.fromString(getBrowserUnderTest())) {
            case SAFARI:
                // options.getSafariOptions().useCleanSession(true);
                // options.getSafariOptions().setCapability(SafariOptions.CAPABILITY, options.getSafariOptions());
                break;
            case INTERNETEXPLORER:
                options.getInternetExplorerOptions().ignoreZoomSettings();
                break;
            default:
                break;
        }

        // Operating System
        options.setPlatform(type, getOperatingSystem());
        options.setCapability(type, "name", getTestName());
        // Create the remote web driver
        URL url = null;
        try {
            url = new URL(getRemoteURL());

        } catch (MalformedURLException e) {
            throw new AutomationException("Failed to create Remote WebDriver", e);
        }
        DriverManagerFactory.getManager(type, options).initalizeDriver(url);
        // allows for local files to be uploaded via remote webdriver on grid machines
        DriverManager.getDriver().setFileDetector();
    }

    /**
     * Sets up the driver with capabilities for mobile devices. Uses a remote mobile hub URL
     * Gives user option to either specify the device to test on using deviceID or to give
     * parameters for auto selection of device. If deviceID is null, then will do auto selection using
     * these parameters:
     * operatingSystem -- mobile OS platform, e.g. iOS, Android
     * mobileOSVersion -- Mobile OS version, e.g. 7.1, 4.4
     * browserUnderTest -- Name of mobile web browser to automate. Should be an empty string if automating an app instead
     * mobileAppPath -- The absolute local path or remote http URL to an .ipa or .apk file, or a .zip containing one of these.
     * Leave browserUnderTest blank/null if using this
     *
     * @date 9/28/2016
     * @author jessica.marshall
     */
    private void mobileDriverSetup() {
        DriverOptionsManager options = new DriverOptionsManager();
        DriverType type = DriverType.fromString(getOperatingSystem());

        // Setting default Broswer options
        switch (type) {
            case IOS_WEB:
                options.getIOSOptions().setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
                options.getIOSOptions().setCapability(CapabilityType.VERSION, "Any");
                options.getIOSOptions().setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                options.getIOSOptions().setCapability("testName", getTestName());
                options.getIOSOptions().setCapability("accessKey", mobileHubKey);
                break;
            case ANDROID_WEB:
                options.getSafariOptions().setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
                options.getSafariOptions().setCapability(CapabilityType.VERSION, "Any");
                options.getSafariOptions().setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                options.getIOSOptions().setCapability("testName", getTestName());
                options.getIOSOptions().setCapability("accessKey", mobileHubKey);
                break;
            default:
                break;
        }

        // Operating System
        // Create the remote web driver
        URL url = null;
        try {
            url = new URL(getRemoteURL());

        } catch (MalformedURLException e) {
            throw new AutomationException("Failed to create Remote WebDriver", e);
        }
        DriverManagerFactory.getManager(type, options).initalizeDriver(url);
    }

    private void mobileEmulatorDriverSetup() {
        DriverOptionsManager manager = new DriverOptionsManager();
        ChromeDevToolEmulator emulator = ChromeDevToolEmulator.fromString(getOperatingSystem());
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put(DEVICE_NAME, emulator.getName());

        manager.getChromeOptions().setPageLoadStrategy(DEFAULT_CHROME_PAGE_LOAD_STRATEGY);
        manager.getChromeOptions().setAcceptInsecureCerts(true);
        manager.getChromeOptions().setExperimentalOption("useAutomationExtension", false);
        manager.getChromeOptions().setExperimentalOption("mobileEmulation", mobileEmulation);
        // manager.getChromeOptions().addArguments("--remote-debugging-port=9222");

        DriverManagerFactory.getManager(DriverType.CHROME, manager).initalizeDriver();
    }

}
