package com.accuweather.glacier.www.hourlyForecast;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.HourlyPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LegalFooter;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.date.SimpleDate;

public class RW_T2557_HourlyPageAPI extends AccuWeatherBaseTest
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
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	HourlyForecastPage hourlyPage = new HourlyForecastPage();
	NavigationBar navigationBar = new NavigationBar();
	SimpleDate simpleDate = new SimpleDate();
	LegalFooter legalFooter =  new LegalFooter();
	
	public void getTestData(String unit)
	{	
		/************************Get hourly content values from API*******************************/
		HourlyPageAPI.getHourlyPageAPIData(CITY_NAME, SimpleDate.getCurrentDate(DATE_FORMAT), unit);
		
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
		getTestData(UNIT_IMPERIAL);
		
		softAssert = new SoftAssert();
		testStart("******** Matching the data between API and UI*********************");
		legalFooter.clickIUnderstand();
		
		/************************Search with zipcode and select city and click hourly tab***************************/
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		/************************Get the text of all modules from each hour on hourlypage*******************************/
		hourlyPage.getTextOfAllLabelsFromEachHoursOnHourlyPage();
		
		/************************Compare UI and API content of hourly page*******************************/
		for(int i=0; i<HourlyForecastPage.timeList.size(); i++) {
		int j = i+1;
		softAssert.assertEquals(HourlyForecastPage.timeList.get(i), HourlyPageAPI.time_UI.get(i),
						"Issue-------> Mismatch between UI and API for the Time in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.dateList.get(i), HourlyPageAPI.date_UI.get(i),
				"Issue-------> Mismatch between UI and API for the Date in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.temperatureList.get(i), HourlyPageAPI.temperature_UI.get(i),
				"Issue-------> Mismatch between UI and API for the Temperature in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.iconPhraseList.get(i), HourlyPageAPI.iconPhrase_UI.get(i),
				"Issue------->Mismatch between UI and API for the Phrase in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.precipitationList.get(i), HourlyPageAPI.precipitation_UI.get(i),
				"Issue------->Mismatch between UI and API for the Precipitation in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.realFeelList.get(i), HourlyPageAPI.realFeel_UI.get(i),
				"Issue------->Mismatch between UI and API for the Realfeel in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.windList.get(i), HourlyPageAPI.wind_UI.get(i),
				"Issue------->Mismatch between UI and API for the Wind in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.windGustsList.get(i), HourlyPageAPI.windGusts_UI.get(i),
				"Issue------->Mismatch between UI and API for the Windgusts in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.HumidityList.get(i), HourlyPageAPI.humidity_UI.get(i),
				"Issue------->Mismatch between UI and API for the Humididty in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.dewPointList.get(i), HourlyPageAPI.dewPoint_UI.get(i),
				"Issue-------> Mismatch between UI and API for the Dewpoint in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.maxUVIndexValueList.get(i), HourlyPageAPI.UVIndex_UI.get(i),
				"Issue-------> Mismatch between UI and API for the MaxuvIndex in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.cloudCoverList.get(i), HourlyPageAPI.cloudCover_UI.get(i),
				"Issue-------> Mismatch between UI and API for the Cloudcover in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.rainList.get(i), HourlyPageAPI.rain_UI.get(i),
				"Issue------->Mismatch between UI and API for the Rain in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.snowList.get(i), HourlyPageAPI.snow_UI.get(i),
				"Issue------->Mismatch between UI and API for the Snow in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.iceList.get(i), HourlyPageAPI.ice_UI.get(i),
				"Issue------->Mismatch between UI and API for the Ice in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.visibilityList.get(i), HourlyPageAPI.visibility_UI.get(i),
				"Issue------->Mismatch between UI and API for the Visibility in tab "+j);
		
		softAssert.assertEquals(HourlyForecastPage.ceilingList.get(i), HourlyPageAPI.ceiling_UI.get(i),
				"Issue------->Mismatch between UI and API for the Ceiling in tab "+j);
		
	}
		softAssert.assertAll();
	}
	
	@Test(priority=1)
	public void RW_T2266_verifyDataOfHourlyPageContentThroughAPIForMetricUnit()
	{
		getTestData(UNIT_METRIC);
		
		softAssert = new SoftAssert();
		testStart("********Matching data between API and UI*********************");
		legalFooter.clickIUnderstand();
		
		/************************Search with zipcode and select city***************************/
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		
		/************************Change temperature from Imperial To Metric***************************/
		navigationBar.clickSettingsIcon();
		navigationBar.changeTemperatureFromFarenheitToCelcius();
		
		/************************Click hourly tab***************************/
		hourlyPage.clickOnHourlyTab();
		
		/************************Get the text of all modules from each hour on hourlypage******************/
		hourlyPage.getTextOfAllLabelsFromEachHoursOnHourlyPage();
		
		/************************Compare UI and API content of hourly page*******************************/
		for(int i=0; i<HourlyForecastPage.timeList.size(); i++) {
			int j = i + 1;
			softAssert.assertEquals(HourlyForecastPage.timeList.get(i), HourlyPageAPI.time_UI.get(i),
					"Issue-------> Mismatch between UI and API for the Time in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.dateList.get(i), HourlyPageAPI.date_UI.get(i),
			"Issue-------> Mismatch between UI and API for the Date in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.temperatureList.get(i), HourlyPageAPI.temperature_UI.get(i),
			"Issue-------> Mismatch between UI and API for the Temperature in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.iconPhraseList.get(i), HourlyPageAPI.iconPhrase_UI.get(i),
			"Issue------->Mismatch between UI and API for the Phrase in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.precipitationList.get(i), HourlyPageAPI.precipitation_UI.get(i),
			"Issue------->Mismatch between UI and API for the Precipitation in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.realFeelList.get(i), HourlyPageAPI.realFeel_UI.get(i),
			"Issue------->Mismatch between UI and API for the Realfeel in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.windList.get(i), HourlyPageAPI.wind_UI.get(i),
			"Issue------->Mismatch between UI and API for the Wind in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.windGustsList.get(i), HourlyPageAPI.windGusts_UI.get(i),
			"Issue------->Mismatch between UI and API for the Windgusts in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.HumidityList.get(i), HourlyPageAPI.humidity_UI.get(i),
			"Issue------->Mismatch between UI and API for the Humididty in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.dewPointList.get(i), HourlyPageAPI.dewPoint_UI.get(i),
			"Issue-------> Mismatch between UI and API for the Dewpoint in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.maxUVIndexValueList.get(i), HourlyPageAPI.UVIndex_UI.get(i),
			"Issue-------> Mismatch between UI and API for the MaxuvIndex in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.cloudCoverList.get(i), HourlyPageAPI.cloudCover_UI.get(i),
			"Issue-------> Mismatch between UI and API for the Cloudcover in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.rainList.get(i), HourlyPageAPI.rain_UI.get(i),
			"Issue------->Mismatch between UI and API for the Rain in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.snowList.get(i), HourlyPageAPI.snow_UI.get(i),
			"Issue------->Mismatch between UI and API for the Snow in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.iceList.get(i), HourlyPageAPI.ice_UI.get(i),
			"Issue------->Mismatch between UI and API for the Ice in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.visibilityList.get(i), HourlyPageAPI.visibility_UI.get(i),
			"Issue------->Mismatch between UI and API for the Visibility in tab "+j);
	
	softAssert.assertEquals(HourlyForecastPage.ceilingList.get(i), HourlyPageAPI.ceiling_UI.get(i),
			"Issue------->Mismatch between UI and API for the Ceiling in tab "+j);
		}

		softAssert.assertAll();
	}
	
}
