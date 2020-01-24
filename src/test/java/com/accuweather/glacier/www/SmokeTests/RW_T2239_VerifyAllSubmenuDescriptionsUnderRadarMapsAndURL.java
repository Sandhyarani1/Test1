package com.accuweather.glacier.www.SmokeTests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

public class RW_T2239_VerifyAllSubmenuDescriptionsUnderRadarMapsAndURL extends AccuWeatherBaseTest
{
	private String EXPECTED_RADARMAPS_SUBMENU_DESCRIPTION = "Visualize past, present, and future weather from many angles via both static and interactive maps";
	private String EXPECTED_RADAR_SUBMENU_DESCRIPTION = "Current and future radar maps for assessing areas of precipitation, type, and intensity";
	private String EXPECTED_SATELLITE_SUBMENU_DESCRIPTION = "Satellite maps for visualizing where there is cloud cover and associated precipitation";
	private String EXPECTED_SEVERE_SUBMENU_DESCRIPTION = "Currently active global watches and warnings, lightning, and severe weather risk";
	private String EXPECTED_FORECAST_SUBMENU_DESCRIPTION = "Daily forecast map for precipitation";
	private String EXPECTED_SATELLITEMAP_TITLE = "United States Weather Radar";
	private String EXPECTED_SATELLITEMAP_DESCRIPTION = "United States National map showing where and how intense precipitation is falling";
	private String EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL = "https://qualityassurance.accuweather.com/en/us/national/weather-radar";
	
	private NavigationBar navBar = new NavigationBar();
	
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert;
	
	/************************************** RADARMAPS SUBMENU *************************************************/
	public final static String RADARMAPS_URL_SUFFIX = "en/us/virginia/weather-radar";
	public static String RADARMAPS_URL = "";
	
	/************************************** RADAR SUBMENU *************************************************/
	public final static String RADAR_URL_SUFFIX = "en/us/virginia/weather-radar";
	public static String RADAR_URL = "";
	
	/************************************** SATELLITE SUBMENU *************************************************/
	public final static String SATELLITE_URL_SUFFIX = "en/us/virginia/satellite";
	public static String SATELLITE_URL = "";
	
	/************************************** SEVERE SUBMENU *************************************************/
	public final static String SEVERE_URL_SUFFIX = "en/us/national/severe-weather-maps";
	public static String SEVERE_URL = "";
	
	/************************************** FORECAST SUBMENU *************************************************/
	public final static String FORECAST_URL_SUFFIX = "en/us/national/weather-forecast-maps";
	public static String FORECAST_URL = "";
	
	@BeforeTest
	public void setURLData()
	{
		RADARMAPS_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+RADARMAPS_URL_SUFFIX;
		RADAR_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+RADAR_URL_SUFFIX;
		SATELLITE_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+SATELLITE_URL_SUFFIX;
		SEVERE_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+SEVERE_URL_SUFFIX;
		FORECAST_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+FORECAST_URL_SUFFIX;		
	}
	
	@Test(priority=5)
	public void RW_T2239_verifyAllSubmenuDescriptionsUnderRadarMapsAndURL()
	{
		softAssert = new SoftAssert();
		testStart("Hover over radar&maps and verify all submenu description and url of each by click on each submenu");
			
		//Verifying the description of all submenu under radar&maps
		navBar.mouseHoverOnRadarAndMaps();
		softAssert.assertEquals(navBar.getMapsSubmenuDescription(), EXPECTED_RADARMAPS_SUBMENU_DESCRIPTION);
		softAssert.assertEquals(navBar.getRadarSubmenuDescription(), EXPECTED_RADAR_SUBMENU_DESCRIPTION);
		softAssert.assertEquals(navBar.getSatelliteSubmenuDescription(), EXPECTED_SATELLITE_SUBMENU_DESCRIPTION);
		softAssert.assertEquals(navBar.getSevereSubmenuDescription(), EXPECTED_SEVERE_SUBMENU_DESCRIPTION);
		softAssert.assertEquals(navBar.getForecastSubmenuDescription(), EXPECTED_FORECAST_SUBMENU_DESCRIPTION);
		
		//verify satellite image, map title and description and URL of mapimage, maptitle, mapdescription
		navBar.verifySatelliteImageTitleDescription();
		softAssert.assertEquals(navBar.strMapTitle, EXPECTED_SATELLITEMAP_TITLE);
		softAssert.assertEquals(navBar.strSatelliteMapDescription, EXPECTED_SATELLITEMAP_DESCRIPTION);
        softAssert.assertEquals(navBar.strMapUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL);
        softAssert.assertEquals(navBar.strMapTitleUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL);
        softAssert.assertEquals(navBar.strMapDescriptionUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL);
		
		//verify the url's of radarmaps submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToRadarAndMapsUnderRadarMaps();
		softAssert.assertEquals(getDriver().getCurrentUrl(), RADARMAPS_URL);
		
		//verify the url's of radar submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToRadar();
		softAssert.assertEquals(getDriver().getCurrentUrl(), RADAR_URL);
		
		//verify the url's of severe submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToSeverWeatherPage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), SEVERE_URL);
		
		//verify the url's of satellite submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToSatellitePage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), SATELLITE_URL);
		
		//verify the url's of forecast submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToForeCastPage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), FORECAST_URL);
		
		softAssert.assertAll();
	}
}
