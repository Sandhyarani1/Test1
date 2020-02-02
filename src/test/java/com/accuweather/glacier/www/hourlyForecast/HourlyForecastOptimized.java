package com.accuweather.glacier.www.hourlyForecast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;

public class HourlyForecastOptimized extends AccuWeatherBaseTest
{
	public static final String CITY_NAME = "Buffalo";
	public static String stateCode = "";
	public static String locationKey = "";
	public static String countryCode = "";
	public static String zipCode = "";
	public static String location = "";
	public static String cityNameForURL = "";
	public static String expectedHourlyForecastURL = "";
	public static String expectedHourlyForecastTitle = "";
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	HourlyForecastPage hourlyPage = new HourlyForecastPage();
	
	@BeforeClass
	public void getTestData()
	{
		HourlyPageAPI.getHourlyForecastData(CITY_NAME);
		
		stateCode = HourlyPageAPI.getStateName();
		locationKey = HourlyPageAPI.getLocationKey();
		zipCode = HourlyPageAPI.getZipCode();
		countryCode = HourlyPageAPI.getCountryCode();
		location = CITY_NAME + ", " + stateCode + ", " + countryCode;
		cityNameForURL = CITY_NAME.replace(' ', '-');
		
		expectedHourlyForecastURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + "en/us/" + cityNameForURL + "/"
				+ zipCode + "/hourly-weather-forecast/" + locationKey).toLowerCase();
		
		expectedHourlyForecastTitle = CITY_NAME + ", " + stateCode
				+ " Hourly Weather | AccuWeather";
	
	}
	
	@Test(priority=1)
	public void testNewCode()
	{
		softAssert = new SoftAssert();
		testStart("******** Testing newly optimized and generic code for Hourly page *********************");
		
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		/******************** Validating the title on Hourly Forecast Page *******************************/
		softAssert.assertEquals(getDriver().getTitle(), expectedHourlyForecastTitle);
		
		/******************** Validating the Hourly Forecast URL *******************************/
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedHourlyForecastURL);
		
		softAssert.assertAll();
	}
}