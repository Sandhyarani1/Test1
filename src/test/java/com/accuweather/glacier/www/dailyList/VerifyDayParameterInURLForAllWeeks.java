package com.accuweather.glacier.www.dailyList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.DailyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class VerifyDayParameterInURLForAllWeeks extends AccuWeatherBaseTest {
	
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
	public void RW_T192_verifyDayParameterOfEachTabForThreeWeeks()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of day parameter is correct as per the tab for three weeks clusters*********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		/************************Verify the day parameter is correct as per the tab from 1st week card*******************************/
		dailyListPage.firstWeekCardClickAllTabAndGetURLFrom();
		for (int i=1; i<=7;i++) {
			softAssert.assertEquals(DailyListPage.firstWeekURLList_UI.get(i-1),  expectedDailyURL + "?day=" + i,
					"Issue------->Click on "+i+"th/st tab and day Parameter in the URL is matching as expected");
		}
		
		/************************Verify the day parameter is correct as per the tab from 2nd week card*******************************/
		dailyListPage.secondWeekCardClickAllTabAndGetURLFrom();
		for (int i=8; i<=14; i++) {
			softAssert.assertEquals(DailyListPage.secondWeekURLList_UI.get(i-8),  expectedDailyURL + "?day=" + i,
					"Issue------->Click on "+i+"th/st tab and day Parameter in the URL is matching as expected");
		}
        
		/************************Verify the day parameter is correct as per the tab from 3rd week card*******************************/
		dailyListPage.thirdWeekCardClickAllTabAndGetURLFrom();
		for (int i=15; i<=21; i++) {
			softAssert.assertEquals(DailyListPage.thirdWeekURLList_UI.get(i-15),  expectedDailyURL + "?day=" + i,
					"Issue------->Click on "+i+"th/st tab and day Parameter in the URL is matching as expected");
		}
		
		softAssert.assertAll();
	}

}
