package com.accuweather.sandbox;

import static com.chameleon.selenium.DriverConstants.DEFAULT_CHROME_PAGE_LOAD_STRATEGY;
import static com.chameleon.selenium.web.chromeDevTool.ChromeDevToolEmulator.DEVICE_NAME;
import static com.chameleon.selenium.web.chromeDevTool.ChromeDevToolEmulator.GALAXY_S5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.api.helpers.CurrentConditionsHelper;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.Location;
import com.accuweather.glacier.m.pages.SearchLocationsPage;
import com.accuweather.glacier.m.pages.WeatherForecastCityPage;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentWeatherPage;
//import com.accuweather.www.pages.CurrentWeatherPage2;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverManagerFactory;
import com.chameleon.selenium.DriverOptionsManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.TestReporter;
import com.neovisionaries.ws.client.WebSocketException;

public class Sandbox2 extends AccuWeatherBaseTest {
    private SearchLocationsPage searchLocation = new SearchLocationsPage();
    private WeatherForecastCityPage city = new WeatherForecastCityPage();
    private CurrentWeatherPage currentWeather = new CurrentWeatherPage();
    //private CurrentWeatherPage2 currentWeather = new CurrentWeatherPage2();
    
    
    /*
     * private NavBar navBar = new NavBar();
     *
     * @BeforeMethod
     * public void start() {
     * testStart("Sandbox");
     * }
     *
     * @Test
     * public void navigateToHome() {
     * navBar.navigateToHome();
     * TestReporter.assertTrue(navBar.validateNavigation("https://www.accuweather.com/"), "Assert navigated");
     * }
     *
     * @Test
     * public void navigateToRadarAndMaps() {
     * navBar.navigateToRadarAndMaps();
     * TestReporter.assertTrue(navBar.validateNavigation("/weather-radar"), "Assert navigated");
     * }
     *
     * @Test
     * public void navigateToNews() {
     * navBar.navigateToNews();
     * TestReporter.assertTrue(navBar.validateNavigation("/weather-news"), "Assert navigated");
     * }
     *
     * @Test
     * public void navigateToVideo() {
     * navBar.navigateToVideo();
     * TestReporter.assertTrue(navBar.validateNavigation("https://www.accuweather.com/en/videos"), "Assert navigated");
     * }
     *
     * @Test
     * public void navigateToSevereWeather() {
     * navBar.navigateToSevereWeather();
     * TestReporter.assertTrue(navBar.validateNavigation("/severe-weather"), "Assert navigated");
     * }
     *
     * @Test
     * public void locationSearch() {
     * navBar.locationSearch("27127");
     * TestReporter.assertTrue(navBar.validateNavigation("/search-locations"), "Assert navigated");
     * }
     */

    //@Test(priority=1)
    public void googleMaps() throws IOException, WebSocketException, InterruptedException {
        TestReporter.setDebugLevel(3);

        DriverOptionsManager manager = new DriverOptionsManager();
        

       Map<String, Object> mobileEmulation = new HashMap<>();
       System.out.println("mobileEmulation mobileEmulation...."+mobileEmulation);
        //mobileEmulation.put(DEVICE_NAME, GALAXY_S5);
        mobileEmulation.put("devicename", "Galaxy S5");

        manager.getChromeOptions().setPageLoadStrategy(DEFAULT_CHROME_PAGE_LOAD_STRATEGY);
        manager.getChromeOptions().setAcceptInsecureCerts(true);
        manager.getChromeOptions().setExperimentalOption("useAutomationExtension", false);
        manager.getChromeOptions().setExperimentalOption("mobileEmulation", mobileEmulation);
        
        DriverManagerFactory.getManager(DriverType.CHROME, manager).initalizeDriver();
        ExtendedWebDriver driver = DriverManager.getWebDriver();

        Sleeper.sleep(5);

        // ChromeDevToolClient.getInstance().sendMessage(ChromeDevToolCommands.emulationGeoLocationMessage(Location.LAS_VEGAS_NV));
        Sleeper.sleep(1);
        //driver.get("https://maps.google.com");
        driver.get("https://www.accuweather.com");
        
        Thread.sleep(7000);
        System.out.println();
    }

	
	  @Test(priority=2) public void mobile() throws InterruptedException { TestReporter.setDebugLevel(3);
	  
	  Map<String, Object> deviceMetrics = new HashMap<String, Object>();
      deviceMetrics.put("width", 1024);  // device width
      deviceMetrics.put("height", 768); // device height
      deviceMetrics.put("pixelRatio", 2.0);
      
	  DriverOptionsManager manager = new DriverOptionsManager();
	  
	  Map<String, Object> mobileEmulation = new HashMap<>();
	  mobileEmulation.put("deviceMetrics", deviceMetrics);
	  mobileEmulation.put(DEVICE_NAME, GALAXY_S5.getName());
	  //mobileEmulation.put("devicename", "Galaxy S5");
	  //mobileEmulation.put("devicename", "iPad Pro");
	  //mobileEmulation.put("devicename", "iPhone X");
	  manager.getChromeOptions().setPageLoadStrategy(
	  DEFAULT_CHROME_PAGE_LOAD_STRATEGY);
	  manager.getChromeOptions().setExperimentalOption("useAutomationExtension",
	  false); manager.getChromeOptions().setExperimentalOption("mobileEmulation",
	  mobileEmulation);
	  
	  DriverManagerFactory.getManager(DriverType.CHROME,
	  manager).initalizeDriver(); ExtendedWebDriver driver =
	  DriverManager.getWebDriver();
	  
	  Condition condition = CurrentConditionsHelper.getUSCityCurrentCondition("qa",
	  "Atlanta", "GA");
	  
	  driver.get(condition.getMobileLink());
	  Thread.sleep(10000);
	  System.out.println(); }
	 

	/*
	 * //@Test public void testWeb() { TestReporter.setDebugLevel(3); Condition
	 * condition = testStartInCity("testStartInCity", "US", "Atlanta", "GA");
	 * currentWeather.validateCurrentConditions(condition);
	 * TestReporter.assertAll(); System.out.println(); }
	 */

	/*
	 * // @Test public void test() { RestResponse rest =
	 * AccuweatherRest.locations().v1("prod").topCities("50", false); Location[]
	 * locations = rest.mapJSONToObject(Location[].class); System.out.println();
	 * 
	 * }
	 */
}
