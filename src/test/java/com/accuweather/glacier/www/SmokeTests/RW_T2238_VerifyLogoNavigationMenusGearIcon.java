package com.accuweather.glacier.www.SmokeTests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

public class RW_T2238_VerifyLogoNavigationMenusGearIcon extends AccuWeatherBaseTest
{
	
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
	public void RW_T2238_verifyLogoNavigationMenusGearIcon()
	{
		softAssert = new SoftAssert();
		testStart("Verify accuweatherlogo, universal navigation menus and gear icon");
		
		//Verifying the presence of accuweather logo information
		softAssert.assertTrue(navBar.isAccuWeatherLogoDisplayed());
		
		//Verifying the universal navigation menu appears 
		softAssert.assertTrue(navBar.isRadarAndMapsTabDisplayed());
		softAssert.assertTrue(navBar.isNewsTabDisplayed());
		softAssert.assertTrue(navBar.isVideoTabDisplayed());
		softAssert.assertTrue(navBar.isSevereWeatherTabDisplayed());
		softAssert.assertTrue(navBar.isMoreTabDisplayed());
		
		//Verifying a gear icon is present
		softAssert.assertTrue(navBar.isSettingIconDisplayed());

		softAssert.assertAll();
	}
	
}
