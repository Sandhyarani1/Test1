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
	SoftAssert softAssert;
	
	LandingPage landingPage = new LandingPage();
	HourlyForecastPage hourlyPage = new HourlyForecastPage();
	Localizations localization = new Localizations();
	NavigationBar navigationBar = new NavigationBar();
	SimpleDate simpleDate = new SimpleDate();
	
	@BeforeClass
	public void getTestData()
	{	
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
	public void RW_T2266_verifyDataOfHourlyPageContentThroughAPIForImperialUnit()
	{
		/************************Get hourly content values from API*******************************/
		HourlyPageAPI.getHourlyPageAPIData(CITY_NAME, simpleDate.getCurrentDate("yyyy-MM-dd"), "IMPERIAL");
		
		softAssert = new SoftAssert();
		testStart("******** Matching the data between API and UI*********************");
		landingPage.enterZipcodeInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);
		hourlyPage.clickOnHourlyTab();
		
		/************************Get the text of all modules from each hour on hourlypage*******************************/
		hourlyPage.getTextOfAllLabelsFromEachHoursOnHourlyPage();
		
		/************************Compare UI and API content of hourly page*******************************/
		softAssert.assertEquals(hourlyPage.timeList, HourlyPageAPI.time_UI,
						"Issue------->Time between time UI and time API");
		System.out.println("Time UI:" +hourlyPage.timeList);
		System.out.println("Time API:"+HourlyPageAPI.time_UI);
		
		softAssert.assertEquals(hourlyPage.dateList, HourlyPageAPI.date_UI,
				"Issue------->Date mismatch between UI and API");
		System.out.println("Date UI:" +hourlyPage.dateList);
		System.out.println("Date API:"+HourlyPageAPI.date_UI);
		
		softAssert.assertEquals(hourlyPage.temperatureList, HourlyPageAPI.temperature_UI,
				"Issue------->Temperature mismatch between UI and API");
		System.out.println("Temperature UI:" +hourlyPage.temperatureList);
		System.out.println("Temperature API:"+HourlyPageAPI.temperature_UI);
		
		softAssert.assertEquals(hourlyPage.iconPhraseList, HourlyPageAPI.iconPhrase_UI,
				"Issue------->Phrase mismatch between UI and API");
		System.out.println("Phrase UI:" +hourlyPage.iconPhraseList);
		System.out.println("Phrase API:"+HourlyPageAPI.iconPhrase_UI);
		
		softAssert.assertEquals(hourlyPage.precipitationList, HourlyPageAPI.precipitation_UI,
				"Issue------->Precipitation mismatch between UI and API");
		System.out.println("Precipitation UI:" +hourlyPage.precipitationList);
		System.out.println("Precipitation API:"+HourlyPageAPI.precipitation_UI);
		
		softAssert.assertEquals(hourlyPage.realFeelList, HourlyPageAPI.realFeel_UI,
				"Issue------->Realfeel mismatch between UI and API");
		System.out.println("Realfeel UI:" +hourlyPage.realFeelList);
		System.out.println("Realfeel API:"+HourlyPageAPI.realFeel_UI);
		
		softAssert.assertEquals(hourlyPage.windList, HourlyPageAPI.wind_UI,
				"Issue------->Wind mismatch between UI and API");
		System.out.println("Wind UI:" +hourlyPage.windList);
		System.out.println("Wind API:"+HourlyPageAPI.wind_UI);
		
		softAssert.assertEquals(hourlyPage.windGustsList, HourlyPageAPI.windGusts_UI,
				"Issue------->Windgusts mismatch between UI and API");
		System.out.println("Windgusts UI:" +hourlyPage.windGustsList);
		System.out.println("Windgusts API:"+HourlyPageAPI.windGusts_UI);
		
		softAssert.assertEquals(hourlyPage.HumidityList, HourlyPageAPI.humidity_UI,
				"Issue------->Humididty mismatch between UI and API");
		System.out.println("Humididty UI:" +hourlyPage.HumidityList);
		System.out.println("Humididty API:"+HourlyPageAPI.humidity_UI);
		
		softAssert.assertEquals(hourlyPage.dewPointList, HourlyPageAPI.dewPoint_UI,
				"Issue------->Dewpoint mismatch between UI and API");
		System.out.println("Dewpoint UI:" +hourlyPage.dewPointList);
		System.out.println("Dewpoint API:"+HourlyPageAPI.dewPoint_UI);
		
		softAssert.assertEquals(hourlyPage.maxUVIndexValueList, HourlyPageAPI.UVIndex_UI,
				"Issue------->MaxuvIndex mismatch between UI and API");
		System.out.println("MaxuvIndex UI:" +hourlyPage.maxUVIndexValueList);
		System.out.println("MaxuvIndex API:"+HourlyPageAPI.UVIndex_UI);
		
		softAssert.assertEquals(hourlyPage.cloudCoverList, HourlyPageAPI.cloudCover_UI,
				"Issue------->Cloudcover mismatch between UI and API");
		System.out.println("Cloundecover UI:" +hourlyPage.cloudCoverList);
		System.out.println("Cloundecover API:"+HourlyPageAPI.cloudCover_UI);
		
		softAssert.assertEquals(hourlyPage.rainList, HourlyPageAPI.rain_UI,
				"Issue------->Rain mismatch between UI and API");
		System.out.println("Rain UI:" +hourlyPage.rainList);
		System.out.println("Rain API:"+HourlyPageAPI.rain_UI);
		
		softAssert.assertEquals(hourlyPage.snowList, HourlyPageAPI.snow_UI,
				"Issue------->Snow mismatch between UI and API");
		System.out.println("Snow UI:" +hourlyPage.snowList);
		System.out.println("Snow API:"+HourlyPageAPI.snow_UI);
		
		softAssert.assertEquals(hourlyPage.iceList, HourlyPageAPI.ice_UI,
				"Issue------->Ice mismatch between UI and API");
		System.out.println("Ice UI:" +hourlyPage.iceList);
		System.out.println("Ice API:"+HourlyPageAPI.ice_UI);
		
		softAssert.assertEquals(hourlyPage.visibilityList, HourlyPageAPI.visibility_UI,
				"Issue------->Visibility mismatch between UI and API");
		System.out.println("Visibility UI:" +hourlyPage.visibilityList);
		System.out.println("Visibility API:"+HourlyPageAPI.visibility_UI);
		
		softAssert.assertEquals(hourlyPage.ceilingList, HourlyPageAPI.ceiling_UI,
				"Issue------->Ceiling mismatch between UI and API");
		System.out.println("ceilingList UI:" +hourlyPage.ceilingList);
		System.out.println("ceilingList API:"+HourlyPageAPI.ceiling_UI);

		softAssert.assertAll();
	}
	
	@Test(priority=1)
	public void RW_T2266_verifyDataOfHourlyPageContentThroughAPIForMetricUnit()
	{
		/************************Get hourly content values from API*******************************/
		HourlyPageAPI.getHourlyPageAPIData(CITY_NAME, simpleDate.getCurrentDate("yyyy-MM-dd"), "METRIC");
		
		/************************Change temperature from Imperial To Metric***************************/
		
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
		softAssert.assertEquals(hourlyPage.timeList, HourlyPageAPI.time_UI,
						"Issue------->Time mismatch between UI and API");
		System.out.println("Time UI:" +hourlyPage.timeList);
		System.out.println("Time API:"+HourlyPageAPI.time_UI);
		
		softAssert.assertEquals(hourlyPage.dateList, HourlyPageAPI.date_UI,
				"Issue------->Date  mismatch between UI and API");
		System.out.println("Date UI:" +hourlyPage.dateList);
		System.out.println("Date API:"+HourlyPageAPI.date_UI);
		
		softAssert.assertEquals(hourlyPage.temperatureList, HourlyPageAPI.temperature_UI,
				"Issue------->Temperature mismatch between UI and API");
		System.out.println("Temperature UI:" +hourlyPage.temperatureList);
		System.out.println("Temperature API:"+HourlyPageAPI.temperature_UI);
		
		softAssert.assertEquals(hourlyPage.iconPhraseList, HourlyPageAPI.iconPhrase_UI,
				"Issue------->Phrase mismatch between UI and API");
		System.out.println("Phrase UI:" +hourlyPage.iconPhraseList);
		System.out.println("Phrase API:"+HourlyPageAPI.iconPhrase_UI);
		
		softAssert.assertEquals(hourlyPage.precipitationList, HourlyPageAPI.precipitation_UI,
				"Issue------->Precipitation mismatch between UI and API");
		System.out.println("Precipitation UI:" +hourlyPage.precipitationList);
		System.out.println("Precipitation API:"+HourlyPageAPI.precipitation_UI);
		
		softAssert.assertEquals(hourlyPage.realFeelList, HourlyPageAPI.realFeel_UI,
				"Issue------->Realfeel mismatch between UI and API");
		System.out.println("Realfeel UI:" +hourlyPage.realFeelList);
		System.out.println("Realfeel API:"+HourlyPageAPI.realFeel_UI);
		
		softAssert.assertEquals(hourlyPage.windList, HourlyPageAPI.wind_UI,
				"Issue------->Wind mismatch between UI and API");
		System.out.println("Wind UI:" +hourlyPage.windList);
		System.out.println("Wind API:"+HourlyPageAPI.wind_UI);
		
		softAssert.assertEquals(hourlyPage.windGustsList, HourlyPageAPI.windGusts_UI,
				"Issue------->Windgusts mismatch between UI and API");
		System.out.println("Windgusts UI:" +hourlyPage.windGustsList);
		System.out.println("Windgusts API:"+HourlyPageAPI.windGusts_UI);
		
		softAssert.assertEquals(hourlyPage.HumidityList, HourlyPageAPI.humidity_UI,
				"Issue------->Humididty mismatch between UI and API");
		System.out.println("Humididty UI:" +hourlyPage.HumidityList);
		System.out.println("Humididty API:"+HourlyPageAPI.humidity_UI);
		
		softAssert.assertEquals(hourlyPage.dewPointList, HourlyPageAPI.dewPoint_UI,
				"Issue------->Dewpoint mismatch between UI and API");
		System.out.println("Dewpoint UI:" +hourlyPage.dewPointList);
		System.out.println("Dewpoint API:"+HourlyPageAPI.dewPoint_UI);
		
		softAssert.assertEquals(hourlyPage.maxUVIndexValueList, HourlyPageAPI.UVIndex_UI,
				"Issue------->MaxuvIndex mismatch between UI and API");
		System.out.println("MaxuvIndex UI:" +hourlyPage.maxUVIndexValueList);
		System.out.println("MaxuvIndex API:"+HourlyPageAPI.UVIndex_UI);
		
		softAssert.assertEquals(hourlyPage.cloudCoverList, HourlyPageAPI.cloudCover_UI,
				"Issue------->Cloudcover mismatch between UI and API");
		System.out.println("Cloundecover UI:" +hourlyPage.cloudCoverList);
		System.out.println("Cloundecover API:"+HourlyPageAPI.cloudCover_UI);
		
		softAssert.assertEquals(hourlyPage.rainList, HourlyPageAPI.rain_UI,
				"Issue------->Rain mismatch between UI and API");
		System.out.println("Rain UI:" +hourlyPage.rainList);
		System.out.println("Rain API:"+HourlyPageAPI.rain_UI);
		
		softAssert.assertEquals(hourlyPage.snowList, HourlyPageAPI.snow_UI,
				"Issue------->Snow mismatch between UI and API");
		System.out.println("Snow UI:" +hourlyPage.snowList);
		System.out.println("Snow API:"+HourlyPageAPI.snow_UI);
		
		softAssert.assertEquals(hourlyPage.iceList, HourlyPageAPI.ice_UI,
				"Issue------->Ice mismatch between UI and API");
		System.out.println("Ice UI:" +hourlyPage.iceList);
		System.out.println("Ice API:"+HourlyPageAPI.ice_UI);
		
		softAssert.assertEquals(hourlyPage.visibilityList, HourlyPageAPI.visibility_UI,
				"Issue------->Visibility mismatch between UI and API");
		System.out.println("Visibility UI:" +hourlyPage.visibilityList);
		System.out.println("Visibility API:"+HourlyPageAPI.visibility_UI);
		
		softAssert.assertEquals(hourlyPage.ceilingList, HourlyPageAPI.ceiling_UI,
				"Issue------->Ceiling mismatch between UI and API");
		System.out.println("ceilingList UI:" +hourlyPage.ceilingList);
		System.out.println("ceilingList API:"+HourlyPageAPI.ceiling_UI);

		softAssert.assertAll();
	}
	
}
