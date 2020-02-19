package com.accuweather.glacier.www.hourlyForecast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class RW_T190_HourlyPageItemsPresent extends AccuWeatherBaseTest {
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
	SimpleDate sd = new SimpleDate();
	
	@BeforeClass
	public void getTestData()
	{	
		int rowNo = 0;
		rowNo = ExcelUtilities.getRowNumberForCity(CITY_NAME);
		zipCode = ExcelUtilities.getZipCode(rowNo);
        stateCode = ExcelUtilities.getStateCode(rowNo);
        countryCode = ExcelUtilities.getCountryCode(rowNo);
        locationKey = ExcelUtilities.getLocationKey(rowNo);
		location = CITY_NAME + ", " + stateCode + ", " + countryCode;
		cityNameForURL = CITY_NAME.replace(' ', '-');
		
		expectedHourlyForecastURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + "en/us/" + cityNameForURL + "/"
				+ zipCode + "/hourly-weather-forecast/" + locationKey).toLowerCase();
		
		expectedHourlyForecastTitle = CITY_NAME + ", " + stateCode
				+ " Hourly Weather | AccuWeather";
	}
	
	@Test(priority=1)
	public void RW_T190_verifyHourlyPageItemsArePresent()
	{	
		softAssert = new SoftAssert();
		testStart("********Hourly Page items are present*********************");
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		 
		/******************** Validating the title on Hourly Forecast Page *******************************/
		softAssert.assertEquals(getDriver().getTitle(), expectedHourlyForecastTitle);
		
		/******************** Validating the Hourly Forecast URL *******************************/
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedHourlyForecastURL);
		
		/**************************Check current hour tab is expanded when first page is loaded*****************************/
		softAssert.assertTrue(hourlyPage.isCurrentHourTabExpanded_WhenFirstPageLoaded(),
						"Issue------->Current hour tab is not expanded when the first page is loaded");
		
				
		softAssert.assertAll();
	}

}
