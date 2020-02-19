package com.accuweather.glacier.www.hourlyForecast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class RW_T192_ValidatePresentAndFutureLinkAndParameterInURL extends AccuWeatherBaseTest {
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
		System.out.println("location:"+location);
		cityNameForURL = CITY_NAME.replace(' ', '-');
		
		expectedHourlyForecastURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + "en/us/" + cityNameForURL + "/"
				+ zipCode + "/hourly-weather-forecast/" + locationKey).toLowerCase();
		
		expectedHourlyForecastTitle = CITY_NAME + ", " + stateCode
				+ " Hourly Weather | AccuWeather";
	
	}
	
	@Test(priority=1)
	public void RW_T192_verifyPresentAndFutureLinkAndParameterInURL()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of present and future link on Hourly page *********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		
		/************************Click NextDay CTA and verify the day parameter is increased by 1 in the URL*******************************/
		softAssert.assertTrue(hourlyPage.validateDayParamInURLForNextDay(appURLRepository.get(Constants.ACCUWEATHER_WEB_QA), cityNameForURL, zipCode, locationKey),
						"Issue------->NextDay parameter in the URL is not increased by 1");
		 
		/************************Click PreviousDay CTA and verify the day parameter is decreased by 1 in the URL*******************************/
		softAssert.assertTrue(hourlyPage.validateDayParamInURLForPreviousDay(appURLRepository.get(Constants.ACCUWEATHER_WEB_QA), cityNameForURL, zipCode, locationKey),
						"Issue------->PreviousDay parameter in the URL is not decreased by 1");
		
		/************************Validate NextDays On SubsequentPages*******************************/
		hourlyPage.validateNextDays();
		softAssert.assertTrue(hourlyPage.getNextDayTextValidation(),
						"Issue------->NextDay from UI is not matching with API as expected");
		
		/************************Validate PreviousDays On SubsequentPages*******************************/
		hourlyPage.clickHighlightedHourlyTab();
		hourlyPage.validatePreviousDays();
		softAssert.assertTrue(hourlyPage.getNextDayTextValidation(),
						"Issue------->NextDay from UI is not matching with API as expected");
		
		softAssert.assertAll();
	}

}
