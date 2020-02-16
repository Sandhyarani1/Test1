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
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class RW_T188_NextWeekListPageItemsPresent extends AccuWeatherBaseTest {
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
	DailyListPage dailyListPage = new DailyListPage();
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
	
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
		dailyListPage.getNextWeekHeaderDateAndMonthFromUI();
		dailyListPage.getStartAndEndHeaderOnAllPagesUsingCalendarFunction();
		for (int i=0; i<DailyListPage.dateMonthDateList_UI.size(); i++)
		softAssert.assertEquals(DailyListPage.MonthAndDateHeaderList_UserDefined.get(i), DailyListPage.dateMonthDateList_UI.get(i),
						"Issue------->Nextweek header Month and date from userdefined "+DailyListPage.MonthAndDateHeaderList_UserDefined.get(i)+" and "+DailyListPage.dateMonthDateList_UI.get(i)+" from UI are not matching as expected");
		 
		softAssert.assertAll();
	}

}
