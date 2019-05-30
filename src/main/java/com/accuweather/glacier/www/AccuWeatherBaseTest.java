package com.accuweather.glacier.www;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.api.helpers.CurrentConditionsHelper;
import com.accuweather.glacier.api.objects1.Condition;
import com.chameleon.selenium.DriverConstants;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebBaseTest;
import com.chameleon.selenium.web.WindowHandler;
import com.chameleon.selenium.web.chromeDevTool.ChromeDevToolClient;
import com.chameleon.selenium.web.chromeDevTool.ChromeDevToolCommands;
import com.chameleon.utils.TestReporter;

public class AccuWeatherBaseTest extends WebBaseTest {

    // setting default language to be english
    private ThreadLocal<String> currentLanguage = ThreadLocal.withInitial(() -> "en");

    public AccuWeatherBaseTest() {
    }

    @BeforeMethod
    public void setApp() {
        setApplicationUnderTest("AccuWeather_Web");
    }

    protected void setCurrentLanguage(String language) {
        currentLanguage.set(language);
    }

    protected String getCurrentLanguage() {
        return currentLanguage.get();
    }

    protected ExtendedWebDriver getDriver() {
        return DriverManager.getWebDriver();
    }

    public void validateCurrentURL(String expectedUrl, Object... args) {
        validateCurrentURL(String.format(expectedUrl, args));
    }

    public void validateCurrentURL(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DriverConstants.PAGE_TIMEOUT / 1000);
        final boolean success = wait.until(ExpectedConditions.urlToBe(expectedUrl));
        final String currentUrl = DriverManager.getDriver().getCurrentUrl();
        TestReporter.assertTrue(success, "Validate expected URL [ " + expectedUrl + " ] is loaded. Found [ " + currentUrl + " ]");
    }

    public void setGeoLocation(LocationData location) {
        ChromeDevToolClient client = ChromeDevToolClient.getInstance();
        client.sendMessage(ChromeDevToolCommands.emulationGeoLocationMessage(location));
        client.close();
    }

    public Condition testStartInCity(final String testName, final String countryName, final String cityName, final String adminAreaName) {
        Condition condition = CurrentConditionsHelper.getCityCurrentCondition(Environment.getEnvironment(), countryName, cityName, adminAreaName);
        setPageURL(condition.getLink());
        testStart(testName);
        return condition;
    }
    
    @SuppressWarnings("deprecation")
	public void waitUntilElementIsDisplayedOrClickable() {
    	WebDriverWait wait = new WebDriverWait(getDriver(),100);
		  wait.pollingEvery(5,TimeUnit.SECONDS);
    }
    
    public void waitUntilWindowExistsWithTitle(String string) {
    	ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
  	  WindowHandler.waitUntilWindowExistsWithTitle(driver, string);
    }
}
