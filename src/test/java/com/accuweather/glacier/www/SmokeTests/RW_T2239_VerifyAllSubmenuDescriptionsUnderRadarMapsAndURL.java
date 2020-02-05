package com.accuweather.glacier.www.SmokeTests;

import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
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
	private String EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL = "";
	
	private NavigationBar navBar = new NavigationBar();
	private LandingPage landingPage = new LandingPage();
	
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert;
	
	/************************************** RADARMAPS SUBMENU *************************************************/
	public final static String RADARMAPS_URL_SUFFIX = "weather-radar";
	public static String RADARMAPS_URL = "";
	
	/************************************** RADAR SUBMENU *************************************************/
	public final static String RADAR_URL_SUFFIX = "weather-radar";
	public static String RADAR_URL = "";
	
	/************************************** SATELLITE SUBMENU *************************************************/
	public final static String SATELLITE_URL_SUFFIX = "satellite";
	public static String SATELLITE_URL = "";
	
	/************************************** SEVERE SUBMENU *************************************************/
	public final static String SEVERE_URL_SUFFIX = "national/severe-weather-maps";
	public static String SEVERE_URL = "";
	
	/************************************** FORECAST SUBMENU *************************************************/
	public final static String FORECAST_URL_SUFFIX = "national/weather-forecast-maps";
	public static String FORECAST_URL = "";
	
	/******************** Test Data ***********************************/
	public final static String CITYNAME = "Buffalo";
	public final static String LANGUAGE = "EN";
	public static String countryCode = "";
	public static String stateName = "";
	public static String location = "";
	public static String stateCode = "";
	
	@BeforeTest
	public void setURLData()
	{
		int rowNo=0;
		rowNo = ExcelUtilities.getRowNumberForCity(CITYNAME);
		countryCode = ExcelUtilities.getCountryCode(rowNo);
		stateName = ExcelUtilities.getStateName(rowNo).replace(' ', '-');
		stateCode = ExcelUtilities.getStateCode(rowNo);
		location = CITYNAME + ", " + stateCode + ", " + countryCode;
		
		RADARMAPS_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+stateName+"/"+RADARMAPS_URL_SUFFIX).toLowerCase();
		RADAR_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+stateName+"/"+RADAR_URL_SUFFIX).toLowerCase();
		SATELLITE_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+stateName+"/"+SATELLITE_URL_SUFFIX).toLowerCase();
		SEVERE_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+SEVERE_URL_SUFFIX).toLowerCase();
		FORECAST_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+FORECAST_URL_SUFFIX).toLowerCase();
		EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/national/weather-radar").toLowerCase();
	}
	
	@Test(priority=5)
	public void RW_T2239_verifyAllSubmenuDescriptionsUnderRadarMapsAndURL()
	{
		softAssert = new SoftAssert();
		
		testStart("************* Hover over radar & maps and verify all submenu description and url of each by click on each submenu *************");
		
		landingPage.enterCityNameInSearchField(CITYNAME);
		landingPage.selectCityFromTheList(location);
			
		//Verifying the description of all submenu under radar&maps
		navBar.mouseHoverOnRadarAndMaps();
		softAssert.assertEquals(navBar.getMapsSubmenuDescription(), EXPECTED_RADARMAPS_SUBMENU_DESCRIPTION,
				"\nIssue---->Map Submenu description not as expected\n");
		softAssert.assertEquals(navBar.getRadarSubmenuDescription(), EXPECTED_RADAR_SUBMENU_DESCRIPTION,
				"\nIssue----->Radar Submenu description not as expected\n");
		softAssert.assertEquals(navBar.getSatelliteSubmenuDescription(), EXPECTED_SATELLITE_SUBMENU_DESCRIPTION,
				"\nIssue----->Satellite Submenu description not as expected\n");
		softAssert.assertEquals(navBar.getSevereSubmenuDescription(), EXPECTED_SEVERE_SUBMENU_DESCRIPTION,
				"\nIssue----->Severe Submenu description not as expected\n");
		softAssert.assertEquals(navBar.getForecastSubmenuDescription(), EXPECTED_FORECAST_SUBMENU_DESCRIPTION,
				"\nIssue---->Forecast Submenu description not as expected\n");
		
		//verify satellite image, map title and description and URL of mapimage, maptitle, mapdescription
		navBar.verifySatelliteImageTitleDescription();
		softAssert.assertEquals(navBar.strMapTitle, EXPECTED_SATELLITEMAP_TITLE,
				"\nIssue---->Satellite title not as expected\n");
		softAssert.assertEquals(navBar.strSatelliteMapDescription, EXPECTED_SATELLITEMAP_DESCRIPTION,
				"\nIssue---->Satellite map description not as expected\n");
        softAssert.assertEquals(navBar.strMapUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nIssue----->Satellite map url not as expected\n");
        softAssert.assertEquals(navBar.strMapTitleUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nIssue---->Satellite Map Title URL not as expected\n");
        softAssert.assertEquals(navBar.strMapDescriptionUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nSatellite Map description not as expected\n");
		
		//verify the url's of radarmaps submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToRadarAndMapsUnderRadarMaps();
		softAssert.assertEquals(getDriver().getCurrentUrl(), RADARMAPS_URL,
				"\nIssue---->Radar Maps URL not as expected");
		
		//verify the url's of radar submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToRadar();
		softAssert.assertEquals(getDriver().getCurrentUrl(), RADAR_URL,
				"\nIssue---->Radar URL not as expected\n");
		
		//verify the url's of severe submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToSeverWeatherPage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), SEVERE_URL,
				"\nIssue---->Severe URL not as expected\n");
		
		//verify the url's of satellite submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToSatellitePage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), SATELLITE_URL,
				"\nSatellite URL not as expected\n");
		
		//verify the url's of forecast submenu under radar and maps
		navBar.mouseHoverOnRadarAndMaps();
		navBar.navigateToForeCastPage();
		softAssert.assertEquals(getDriver().getCurrentUrl(), FORECAST_URL,
				"\nForecast URL not as expected\n");
		
		softAssert.assertAll();
	}
}
