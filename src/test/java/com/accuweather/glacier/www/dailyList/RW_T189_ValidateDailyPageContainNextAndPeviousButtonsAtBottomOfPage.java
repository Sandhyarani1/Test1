package com.accuweather.glacier.www.dailyList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.date.SimpleDate;

public class RW_T189_ValidateDailyPageContainNextAndPeviousButtonsAtBottomOfPage extends AccuWeatherBaseTest {
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
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
	DailyListPage dailyListPage = new DailyListPage();
	
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
	public void RW_T192_validatePageNumberInUrlforNextAndPrevious()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of present and future link on Hourly page *********************");
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		
		/************************Click Next CTA and verify the page is increased by 1 in the URL*******************************/
		softAssert.assertTrue(dailyListPage.validatePageNumberInURLWhenClickOnNextCTA(),
						"Issue------->Parameter in the URL is not increased by 1 when clicked on next CTA");
		
		/************************Verify last page has just 1 week report*******************************/
		softAssert.assertTrue(dailyListPage.lastPageHaveOneWeekReports(),
				        "Issue------->There is issue in showing one week report on last page");
		
		/************************Click Previous CTA and verify the page is decreased by 1 in the URL*******************************/
		softAssert.assertTrue(dailyListPage.validatePageNumberInURLWhenClickOnPreviousCTA(),
						"Issue------->Parameter in the URL is not decreased by 1 when clicked on previous CTA");
		
		/************************Click Next CTA and the page displayed three weeks*******************************/
		softAssert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClustersWhenClickedOnNextCTA(),
						"Issue------->There is some issue in showing 3 weeks on a page when clicked on next CTA");
		
		/************************Click Previous CTA and the page displayed three weeks*******************************/
		softAssert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClustersWhenClickedOnPreviousCTA(),
						"Issue------->There is some issue in showing 3 weeks on a page when clicked on previous CTA");
		
		softAssert.assertAll();
	}


}
