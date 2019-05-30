package com.accuweather.glacier.m;

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
import com.chameleon.selenium.web.chromeDevTool.ChromeDevToolClient;
import com.chameleon.selenium.web.chromeDevTool.ChromeDevToolCommands;
import com.chameleon.utils.TestReporter;

public class AccuWeatherMobileBaseTest extends WebBaseTest {

    // setting default language to be english
    private ThreadLocal<String> currentLanguage = ThreadLocal.withInitial(() -> "en");

    public AccuWeatherMobileBaseTest() {
    }

    @BeforeMethod
    public void setApp() {
        setApplicationUnderTest("AccuWeather_Mobile");
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

    public void navigateToURL(String url, Object... args) {
        navigateToURL(String.format(url, args));
    }

    public void navigateToURL(String url) {
        DriverManager.getDriver().navigate().to(url);
    }

    public void setGeoLocation(LocationData location) {
        ChromeDevToolClient client = ChromeDevToolClient.getInstance();
        client.sendMessage(ChromeDevToolCommands.emulationGeoLocationMessage(location));
        client.close();
    }

    public ExtendedWebDriver testStartInCity(final String testName, final String countryName, final String cityName, final String adminAreaName) {
        Condition condition = CurrentConditionsHelper.getCityCurrentCondition(Environment.getEnvironment(), countryName, cityName, adminAreaName);
        setPageURL(condition.getMobileLink());
        return testStart(testName);
    }
}
