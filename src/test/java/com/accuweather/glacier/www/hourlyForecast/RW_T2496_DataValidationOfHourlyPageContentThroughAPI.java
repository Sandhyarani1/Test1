package com.accuweather.glacier.www.hourlyForecast;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.Localizations;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.date.SimpleDate;

public class RW_T2496_DataValidationOfHourlyPageContentThroughAPI extends AccuWeatherBaseTest
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
	public static final String UNIT_IMPERIAL = "IMPERIAL";
	public static final String UNIT_METRIC = "METRIC";
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	HourlyForecastPage hourlyPage = new HourlyForecastPage();
	Localizations localization = new Localizations();
	NavigationBar navigationBar = new NavigationBar();
	SimpleDate simpleDate = new SimpleDate();
	
	@BeforeClass
	public void getTestData()
	{	
		stateCode = HourlyPageAPI.getStateCode();
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
	public void RW_T2266_verifyDataOfHourlyPageContentThroughAPIForImperialUnit()
	{
		/************************Get hourly content values from API*******************************/
		HourlyPageAPI.getHourlyPageAPIData(CITY_NAME, SimpleDate.getCurrentDate("yyyy-MM-dd"), UNIT_IMPERIAL);
		
		softAssert = new SoftAssert();
		testStart("******** Matching the data between API and UI*********************");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		/************************Get the text of all modules from each hour on hourlypage*******************************/
		hourlyPage.getTextOfAllLabelsFromEachHoursOnHourlyPage();
		
		/************************Compare UI and API content of hourly page*******************************/
		for(int i=0; i<HourlyForecastPage.timeList.size(); i++) {
			
		softAssert.assertEquals(HourlyForecastPage.timeList.get(i), HourlyPageAPI.time_UI.get(i),
						"Issue------->Time between time UI and time API");
		
		softAssert.assertEquals(HourlyForecastPage.dateList.get(i), HourlyPageAPI.date_UI.get(i),
				"Issue------->Date mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.temperatureList.get(i), HourlyPageAPI.temperature_UI.get(i),
				"Issue------->Temperature mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.iconPhraseList.get(i), HourlyPageAPI.iconPhrase_UI.get(i),
				"Issue------->Phrase mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.precipitationList.get(i), HourlyPageAPI.precipitation_UI.get(i),
				"Issue------->Precipitation mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.realFeelList.get(i), HourlyPageAPI.realFeel_UI.get(i),
				"Issue------->Realfeel mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.windList.get(i), HourlyPageAPI.wind_UI.get(i),
				"Issue------->Wind mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.windGustsList.get(i), HourlyPageAPI.windGusts_UI.get(i),
				"Issue------->Windgusts mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.HumidityList.get(i), HourlyPageAPI.humidity_UI.get(i),
				"Issue------->Humididty mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.dewPointList.get(i), HourlyPageAPI.dewPoint_UI.get(i),
				"Issue------->Dewpoint mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.maxUVIndexValueList.get(i), HourlyPageAPI.UVIndex_UI.get(i),
				"Issue------->MaxuvIndex mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.cloudCoverList.get(i), HourlyPageAPI.cloudCover_UI.get(i),
				"Issue------->Cloudcover mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.rainList.get(i), HourlyPageAPI.rain_UI.get(i),
				"Issue------->Rain mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.snowList.get(i), HourlyPageAPI.snow_UI.get(i),
				"Issue------->Snow mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.iceList.get(i), HourlyPageAPI.ice_UI.get(i),
				"Issue------->Ice mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.visibilityList.get(i), HourlyPageAPI.visibility_UI.get(i),
				"Issue------->Visibility mismatch between UI and API");
		
		softAssert.assertEquals(HourlyForecastPage.ceilingList.get(i), HourlyPageAPI.ceiling_UI.get(i),
				"Issue------->Ceiling mismatch between UI and API");
		
	}
		softAssert.assertAll();
	}
	
	@Test(priority=1)
	public void RW_T2266_verifyDataOfHourlyPageContentThroughAPIForMetricUnit()
	{
		/************************Get hourly content values from API*******************************/
		HourlyPageAPI.getHourlyPageAPIData(CITY_NAME, SimpleDate.getCurrentDate("yyyy-MM-dd"), UNIT_METRIC);
		
		softAssert = new SoftAssert();
		testStart("********Matching data between API and UI*********************");
		
		/************************Change temperature from Imperial To Metric***************************/
		navigationBar.clickSettingsIcon();
		localization.changeTemperatureFromFarenheitToCelcius();
		
		/************************Click hourly tab***************************/
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		/************************Get the text of all modules from each hour on hourlypage******************/
		hourlyPage.getTextOfAllLabelsFromEachHoursOnHourlyPage();
		
		/************************Compare UI and API content of hourly page*******************************/
		for(int i=0; i<HourlyForecastPage.timeList.size(); i++) {
			
			softAssert.assertEquals(HourlyForecastPage.timeList.get(i), HourlyPageAPI.time_UI.get(i),
							"Issue------->Time between time UI and time API");
			
			softAssert.assertEquals(HourlyForecastPage.dateList.get(i), HourlyPageAPI.date_UI.get(i),
					"Issue------->Date mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.temperatureList.get(i), HourlyPageAPI.temperature_UI.get(i),
					"Issue------->Temperature mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.iconPhraseList.get(i), HourlyPageAPI.iconPhrase_UI.get(i),
					"Issue------->Phrase mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.precipitationList.get(i), HourlyPageAPI.precipitation_UI.get(i),
					"Issue------->Precipitation mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.realFeelList.get(i), HourlyPageAPI.realFeel_UI.get(i),
					"Issue------->Realfeel mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.windList.get(i), HourlyPageAPI.wind_UI.get(i),
					"Issue------->Wind mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.windGustsList.get(i), HourlyPageAPI.windGusts_UI.get(i),
					"Issue------->Windgusts mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.HumidityList.get(i), HourlyPageAPI.humidity_UI.get(i),
					"Issue------->Humididty mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.dewPointList.get(i), HourlyPageAPI.dewPoint_UI.get(i),
					"Issue------->Dewpoint mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.maxUVIndexValueList.get(i), HourlyPageAPI.UVIndex_UI.get(i),
					"Issue------->MaxuvIndex mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.cloudCoverList.get(i), HourlyPageAPI.cloudCover_UI.get(i),
					"Issue------->Cloudcover mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.rainList.get(i), HourlyPageAPI.rain_UI.get(i),
					"Issue------->Rain mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.snowList.get(i), HourlyPageAPI.snow_UI.get(i),
					"Issue------->Snow mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.iceList.get(i), HourlyPageAPI.ice_UI.get(i),
					"Issue------->Ice mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.visibilityList.get(i), HourlyPageAPI.visibility_UI.get(i),
					"Issue------->Visibility mismatch between UI and API");
			
			softAssert.assertEquals(HourlyForecastPage.ceilingList.get(i), HourlyPageAPI.ceiling_UI.get(i),
					"Issue------->Ceiling mismatch between UI and API");
		}

		softAssert.assertAll();
	}
	
}
