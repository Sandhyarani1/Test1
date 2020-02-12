package com.accuweather.glacier.www.dailyList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.date.SimpleDate;

public class RW_T188_NextweekListPageItemsPresent extends AccuWeatherBaseTest {
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
	SimpleDate sd = new SimpleDate();
	DailyListPage dailyListPage = new DailyListPage();
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
	
	@BeforeClass
	public void getTestData()
	{
		HourlyPageAPI.getHourlyForecastData(CITY_NAME, sd.getCurrentDate("yyyy-MM-dd"), "IMPERIAL");
		
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
	public void RW_T192_verifyNextWeekHeaderDateAndMonthOnAllPages()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of present and future link on Hourly page *********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		/************************Verify NextWeek Headers (MonthAndDate)*******************************/
		softAssert.assertTrue(dailyListPage.compareNextWeekHeaderArraylists(),
						"Issue------->NExtweek heare Month and date are not matching as expected");
		 
		softAssert.assertAll();
	}

}
