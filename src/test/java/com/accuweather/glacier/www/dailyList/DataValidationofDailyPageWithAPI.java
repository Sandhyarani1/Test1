package com.accuweather.glacier.www.dailyList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.DailyPageAPI;
import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.Localizations;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.date.SimpleDate;

public class DataValidationofDailyPageWithAPI extends AccuWeatherBaseTest {
	
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
	public static final String UNIT_IMPERIAL = "IMPERIAL";
	public static final String UNIT_METRIC = "METRIC";
	public static final int DAY_COUNT = 21; 
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	DailyListPage dailyListPage = new DailyListPage();
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
	Localizations localization = new Localizations();
	NavigationBar navigationBar = new NavigationBar();
	
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
	public void verifyElementsPresentOnAllThreeWeeks_ImperialUnit()
	{
		softAssert = new SoftAssert();
		testStart("******** Validation of correct value present in all the tabs*********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		/************************Get hourly content values from API******************************/
		DailyPageAPI.getDailyPageDataForUI(DAY_COUNT, SimpleDate.getCurrentDate("yyyy-MM-dd"), UNIT_IMPERIAL, locationKey);
		
		/************************Get text of all elements from all three week cards*******************************/
		dailyListPage.getTextOfAllValueFromThreeWeekClustersOnDailyPage();
	
		/************************Compare UI and API content of daily page*******************************/
		for (int i = 0; i<DAY_COUNT; i++) {
			
		softAssert.assertEquals(DailyListPage.dateList.get(i), DailyPageAPI.date_UI.get(i),
				"Issue------->Date in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.maximimTemperatureList.get(i), DailyPageAPI.maxTemperature_UI.get(i),
				"Issue------->Maximum temperature in "+i+" tab mismatch between time UI and time API");

        softAssert.assertEquals(DailyListPage.minimumTemperatureList.get(i), DailyPageAPI.minTemperature_UI.get(i),
				"Issue------->Minimum temperature in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.iconPhraseList.get(i), DailyPageAPI.iconPhrase_UI.get(i),
				"Issue------->Phrase in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.precipitationPercentageList.get(i), DailyPageAPI.precipitation_UI.get(i),
				"Issue------->Precip in "+i+" tab mismatch between time UI and time API");
        
        /************************Verify minimum temperature is not greater than / equal to maximum temperature*******************************/
        softAssert.assertTrue(dailyListPage.verifyMinimumTemperatureIsNotGreaterOrEqualToMaximumTemperature(DailyPageAPI.minTemperature_UI, DailyPageAPI.maxTemperature_UI),
        		"Issue------->Minimum temperature in "+i+" tab is not less than maximum temperature");
		
        /************************compare dayList_UI and dayList_Userdefined and make sure both matches*******************************/
		dailyListPage.verifyDayShownInAllThreeWeeks();
		softAssert.assertEquals(DailyListPage.dayList_UI.get(i), DailyListPage.dayList_Userdefined.get(i),
        		"Issue------->Day in "+i+" tab shown is not matching as expected");
        
		}
		
		softAssert.assertAll();
	} 
	
	@Test(priority=1)
	public void verifyElementsPresentOnAllThreeWeeks_MetricUnit()
	{
		softAssert = new SoftAssert();
		
		/************************Get hourly content values from API******************************/
		DailyPageAPI.getDailyPageDataForUI(DAY_COUNT, SimpleDate.getCurrentDate("yyyy-MM-dd"), UNIT_METRIC, locationKey);
		
		testStart("******** Validation of correct value present in all the tabs*********************");
		
		/************************Change temperature from Imperial To Metric***************************/
		navigationBar.clickSettingsIcon();
		localization.changeTemperatureFromFarenheitToCelcius();
		
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		dailyForeCastPage.clickDailyTab();
		
		/************************Get text of all elements from all three week cards*******************************/
		dailyListPage.getTextOfAllValueFromThreeWeekClustersOnDailyPage();
	
		/************************Compare UI and API content of daily page*******************************/
		for (int i = 0; i<DAY_COUNT; i++) {
			
		softAssert.assertEquals(DailyListPage.dateList.get(i), DailyPageAPI.date_UI.get(i),
				"Issue------->Date in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.maximimTemperatureList.get(i), DailyPageAPI.maxTemperature_UI.get(i),
				"Issue------->Maximum temperature in "+i+" tab mismatch between time UI and time API");

        softAssert.assertEquals(DailyListPage.minimumTemperatureList.get(i), DailyPageAPI.minTemperature_UI.get(i),
				"Issue------->Minimum temperature in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.iconPhraseList.get(i), DailyPageAPI.iconPhrase_UI.get(i),
				"Issue------->Phrase in "+i+" tab mismatch between time UI and time API");
        
        softAssert.assertEquals(DailyListPage.precipitationPercentageList.get(i), DailyPageAPI.precipitation_UI.get(i),
				"Issue------->Precip in "+i+" tab mismatch between time UI and time API");
        
        /************************Verify minimum temperature is not greater than / equal to maximum temperature*******************************/
        softAssert.assertTrue(dailyListPage.verifyMinimumTemperatureIsNotGreaterOrEqualToMaximumTemperature(DailyPageAPI.minTemperature_UI, DailyPageAPI.maxTemperature_UI),
        		"Issue------->Minimum temperature in tab "+i+" is not less than maximum temperature");
		
        /************************compare dayList_UI and dayList_Userdefined and make sure both matches*******************************/
		dailyListPage.verifyDayShownInAllThreeWeeks();
		softAssert.assertEquals(DailyListPage.dayList_UI.get(i), DailyListPage.dayList_Userdefined.get(i),
        		"Issue------->Day in "+i+" tab shown is not matchin as expected");
        
		}
		
		softAssert.assertAll();
	} 
}
