package com.accuweather.glacier.www.dailyList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class RW_T189_ValidateDailyPageContainNextAndPeviousButtonsAtBottomOfPage extends AccuWeatherBaseTest {
	public static final String CITY_NAME = "Buffalo";
	public static String stateCode = "";
	public static String locationKey = "";
	public static String countryCode = "";
	public static String zipCode = "";
	public static String location = "";
	public static String regionName = "";
	public static String countryName = "";
	public static String stateName = "";
	public static String cityNameForURL = "";
	public static String expectedDailyURL = "";
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	SimpleDate sd = new SimpleDate();
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
	DailyListPage dailyListPage = new DailyListPage();
	
	@BeforeClass
	public void getTestData()
	{
		int rowNo = 0;
        rowNo = ExcelUtilities.getRowNumberForCity(CITY_NAME);
        zipCode = ExcelUtilities.getZipCode(rowNo);
        stateCode = ExcelUtilities.getStateCode(rowNo);
        countryCode = ExcelUtilities.getCountryCode(rowNo);
        locationKey = ExcelUtilities.getLocationKey(rowNo);
        regionName = ExcelUtilities.getRegionName(rowNo);
        countryName = ExcelUtilities.getCountryName(rowNo);
        stateName = ExcelUtilities.getStateName(rowNo);
        location = CITY_NAME + ", " + stateCode + ", " + countryCode;
		cityNameForURL = CITY_NAME.replace(' ', '-');
		
		expectedDailyURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + "en/us/" + cityNameForURL + "/"
				+ zipCode + "/daily-weather-forecast/" + locationKey).toLowerCase();
	}
	
	@Test(priority=1)
	public void RW_T192_validatePageNumberInUrlforNextAndPrevious()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of present and future link on Hourly page *********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		
		/************************Click Next CTA and verify the page is increased by 1 in the URL*******************************/
		dailyListPage.getURLWhenClickOnNextCTA();
		for (int i=1; i<=4;i++) {
			softAssert.assertEquals(DailyListPage.pageNumberForwardList_UI.get(i-1),  expectedDailyURL + "?page=" + i,
					"Issue------->Parameter in the URL for the day "+i+" is not increased by 1 when clicked on next CTA");
		}
		
		/************************Verify last page has just 1 week report*******************************/
		softAssert.assertTrue(dailyListPage.lastPageHaveOneWeekReports(),
				        "Issue------->There is issue in showing one week report on last page");
		
		/************************Click Previous CTA and verify the page is decreased by 1 in the URL*******************************/
		dailyListPage.getURLWhenClickOnPreviousCTA();
		for (int i=0; i<=4; i++) {
			softAssert.assertEquals(DailyListPage.pageNumberPreviousList_UI.get(i),  expectedDailyURL + "?page=" + i,
					"Issue------->Parameter in the URL for the day "+i+" is not decreased by 1 when clicked on previous CTA");
		}
		
		/************************Click Next CTA and the page displayed three weeks*******************************/
		softAssert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClustersWhenClickedOnNextCTA(),
						"Issue------->There is some issue in showing 3 weeks on a page when clicked on next CTA");
		
		/************************Click Previous CTA and the page displayed three weeks*******************************/
		softAssert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClustersWhenClickedOnPreviousCTA(),
						"Issue------->There is some issue in showing 3 weeks on a page when clicked on previous CTA");
		
		softAssert.assertAll();
	}


}
