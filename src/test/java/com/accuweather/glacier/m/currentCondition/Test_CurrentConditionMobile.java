package com.accuweather.glacier.m.currentCondition;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CurrentConditionpageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.threeDayForeCastMobilePage;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentConditionpage;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.MonthlyForeCastPage;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
import com.chameleon.selenium.web.WebPageLoaded;

public class Test_CurrentConditionMobile extends AccuWeatherMobileBaseTest {
	String zipcode = "53558";
	String actualForecastPageTitle;
	String expectedForecastPageTitle = "Mc Farland Weather - AccuWeather Forecast for WI 53558";
	String currentWeatherPageTitle = "Mc Farland Current Weather - AccuWeather Forecast for WI 53558";
	String expectedTimecolourgrey = "#878787";
	String expectedblackcolour = "#1f1f1f";

	public static final String EXPECTED_FORECAST_PAGE_URL = "https://qualityassurance.accuweather.com/en/us/mc-farland/53558/current-weather/23238_pc";

	private LandingPageMobile landingpage = new LandingPageMobile();
	private CurrentConditionpageMobile conditionpage = new CurrentConditionpageMobile();

	@Test(priority = 2, enabled = true)
	public void RW_T239_CityForecastPageTodayCardIsDisplayed() throws InterruptedException {
		testStart("Validate Today card is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(conditionpage.isTodayWeatherCardTitleDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void RW_T239_CityForecastPageTonightCardIsDisplayed() throws InterruptedException {
		testStart("Validate Tonight card is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(conditionpage.isTonghtWeatherCardTitleDisplayed());
	}

	@Test(priority = 4, enabled = true)
	public void RW_T239_CityForecastPageTomorrowCardIsDisplayed() throws InterruptedException {
		testStart("Validate Tomorrow card is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(conditionpage.isTomorrowWeatherCardDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void RW_T239_CityForecastPageCurrentWeatherURL() throws InterruptedException {
		testStart("Validate curent weather Url ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Thread.sleep(3000);
		String ActualForecastPageTitle = conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(ActualForecastPageTitle, EXPECTED_FORECAST_PAGE_URL);
	}

	@Test(priority = 6, enabled = true)
	public void RW_T239_Currentweather() {
		testStart("Validate curent condition page current weather card is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String ActualForecastPageTitle = conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(ActualForecastPageTitle, EXPECTED_FORECAST_PAGE_URL);
	}

	@Test(priority = 7, enabled = true)
	public void RW_T239_TimeDisplayedingrey() throws InterruptedException {
		testStart("Validate curent weather Time is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Thread.sleep(3000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		conditionpage.timeoncurrentconditionpage();
		String Actualtimecolour = conditionpage.Timedisplayedcolour();
		Assert.assertEquals(Actualtimecolour, expectedblackcolour);
	}

	@Test(priority = 8, enabled = true)
	public void RW_T239_Weatherdisplayed() throws InterruptedException {
		testStart("Validate curent weather icon is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Thread.sleep(3000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertTrue(conditionpage.weathericondisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void RW_T239_Temperaturedisplayedinfont() throws InterruptedException {
		testStart("Validate curent weather Temperature is displayed in bold");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertTrue(Integer.parseInt(conditionpage.temperatureinbold()) > 290);
	}

	@Test(priority = 11, enabled = true)
	public void RW_T239_currentWeatherTimeisDisplayedinGrey() {
		testStart("Validate curent weather time is displayed in Grey color");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("time displayed"), expectedTimecolourgrey);
	}

	@Test(priority = 12, enabled = true)
	public void RW_T239_currentWeatherRealFeelTemperatureisDisplayedinGrey() {
		testStart("Validate current Weather Real Feel Temperature is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("Real feel temparature"), expectedTimecolourgrey);
	}

	@Test(priority = 13, enabled = true)
	public void RW_T239_currentWeatherHumidityisDisplayedinGrey() {
		testStart("Validate TC4_current Weather Humidity is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("Humidity"), expectedblackcolour);
	}

	@Test(priority = 14, enabled = true)
	public void RW_T239_currentWeatherUVIndexisDisplayedinGrey() {
		testStart("Validate current Weather UVIndex is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("UV index"), expectedblackcolour);
	}

	@Test(priority = 15, enabled = true)
	public void RW_T239_currentWeatherCloudCoverisDisplayedinGrey() {
		testStart("Validate current Weather Cloud cover is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("cloud cover"), expectedblackcolour);
	}

	@Test(priority = 16, enabled = true)
	public void RW_T239_currentWeatherPressureisDisplayedinGrey() {
		testStart("Validate current Weather Pressure is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("pressure"), expectedblackcolour);
	}

	@Test(priority = 17, enabled = true)
	public void RW_T239_currentWeatherDewPointisDisplayedinGrey() {
		testStart("Validate current Weather dew point is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("dew point"), expectedblackcolour);
	}

	@Test(priority = 18, enabled = true)
	public void RW_T239_currentWeathervisibilityisDisplayedinGrey() {
		testStart("Validate current Weather visibility is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("visibility"), expectedblackcolour);
	}

	@Test(priority = 19, enabled = true)
	public void RW_T239_currentWeatherRealfeelShadeIsDisplayedinGrey() {
		testStart("Validate current Weather real feel shade is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("real feel shade"), expectedblackcolour);
	}

	@Test(priority = 20, enabled = true)
	public void RW_T239_currentWeatherCompassIconIsDisplayedinGrey() {
		testStart("Validate current Weather compass icon is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("compass icon"), expectedblackcolour);
	}

	@Test(priority = 21, enabled = true)
	public void RW_T239_currentWeatherWindIsDisplayedinGrey() {
		testStart("Validate current Weather wind is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("wind"), expectedblackcolour);
	}

	@Test(priority = 22, enabled = true)
	public void RW_T239_currentWeatherGustsIsDisplayedinGrey() {
		testStart("Validate current Weather gusts is Displayed in Grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.validateElementIsGrey("gusts"), expectedblackcolour);
	}

	@Test(priority = 23, enabled = true)
	public void RW_T240_CurrentConditionDayOrganismRightArrowColor() throws InterruptedException {
		String ExpectedRightArrowcolour = "#f59721";
		String ExpectedHourlyforecasturl = "https://development.accuweather.com/en/us/state-college/16801/hourly-weather-forecast/6787_pc";
		testStart("Validate curent condition Day Organism Right Arrow color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		conditionpage.HourlyCTAdisplayed();
		String Actualarrowcolour = conditionpage.rightarrowcolour();
		Assert.assertEquals(Actualarrowcolour, ExpectedRightArrowcolour);
	}

	@Test(priority = 24, enabled = true)
	public void RW_T240_CurrentConditionDayOrganism() throws InterruptedException {
		String ExpectedRightArrowcolour = "#f59721";
		String ExpectedHourlyforecasturl = "https://qualityassurance.accuweather.com/en/us/mc-farland/53558/hourly-weather-forecast/23238_pc";
		testStart("Validate curent condition Day Organism is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		conditionpage.HourlyCTAdisplayed();
		Assert.assertEquals(conditionpage.clickonHourlyCTA(), ExpectedHourlyforecasturl);
	}

	@Test(priority = 25, enabled = true)
	public void RW_T240_currentDateMonthDisplayed() throws InterruptedException {
		String ExpectedRightArrowcolour = "#f59721";
		String ExpectedHourlyforecasturl = "https://qualityassurance.accuweather.com/en/us/state-college/16801/daily-weather-forecast/6787_pc?day=1";
		testStart("Validate curent condition current Date is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		String str1 = conditionpage.currentDateonAccPage().substring(0, 3);
		String str2 = conditionpage.returnCurrentDate().substring(0, 3);
		Assert.assertTrue(str1.equalsIgnoreCase(str2));
	}

	@Test(priority = 26, enabled = true)
	public void RW_T240_currentWeatherRightArrowNextToDateIsDisplayed() throws InterruptedException {
		String ExpectedRightArrowcolour = "#f59721";
		String ExpectedHourlyforecasturl = "https://qualityassurance.accuweather.com/en/us/state-college/16801/daily-weather-forecast/6787_pc?day=1";
		testStart("Validate curent condition page Right Arrow colour is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		Assert.assertEquals(conditionpage.arrownexttodate2(), ExpectedRightArrowcolour);
	}

	@Test(priority = 27, enabled = true)
	public void RW_T240_DayorganismIsDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism title is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.todayOrganism());

	}

	@Test(priority = 28, enabled = true)
	public void RW_T240_DayorganismTitleInUpperCaseISDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism title is in uppercase");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.isDayOranismTitleIsInUppercase("DAY"));
	}

	@Test(priority = 29, enabled = true)
	public void RW_T240_DayorganismTitleTextIsInBoldDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day Organism Title text is displayed in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		String Font = conditionpage.dayOrganismTextTitleisBold();
		Assert.assertTrue(Integer.parseInt(Font) > 499);
	}

	@Test(priority = 30, enabled = true)
	public void RW_T240_DayorganismDateIsDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day Organism Date is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		Assert.assertTrue(conditionpage.dayOrganismDateIsDisplayed());
	}

	@Test(priority = 31, enabled = true)
	public void RW_T240_DayorganismWeatherIconIsDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day organism Weather Icon is Displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.dayOrganismWeatheIconIsDisplayed());
	}

	@Test(priority = 32, enabled = true)
	public void RW_T240_DayorganismCurrentTemperatureisInBoldDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Current Temperature is displayed in bold");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		String dayCurrentTemperature = conditionpage.dayOrganismCurrentTemparatureisBold();
		Assert.assertTrue(Integer.parseInt(dayCurrentTemperature) > 299);
	}

	@Test(priority = 33, enabled = true)
	public void RW_T240_DayorganismReelFeelTemperatureContainsRegisteredTrademark() throws InterruptedException {
		testStart("Validate curent condition page ReelFeel Temperature contains Registered trademark");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.dayCurrentWeatherReelFeelTemperatureGetText().contains("RealFeel®"));
	}

	@Test(priority = 34, enabled = true)
	public void RW_T240_DayorganismWeatherDescriptionDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Weather Description s displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.bydayOrganismCurrentWeatherDescriptionIsDisplayed());
	}

	@Test(priority = 35, enabled = true)
	public void RW_T240_DayorganismCurrentWeatherPrecipitationDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day Organism Current Weather Precipitation is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.dayOrganismCurrentWeatherPrecipitationdisplayed());
	}

	@Test(priority = 36, enabled = true)
	public void RW_T240_DayorganismCurrentWeatherMaxUVIdexDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day organism Current Weather MaxUVIdex is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Organism Current Weather MaxUVIdex"),
				expectedblackcolour);
	}

	@Test(priority = 37, enabled = true)
	public void RW_T240_DayorganismThunderstormsIsDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Thunderstorms is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Thunderstorms"),
				expectedblackcolour);
	}

	@Test(priority = 38, enabled = true)
	public void RW_T240_DayorganismPrecipitationDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Precipitation is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Precipitation"),
				expectedblackcolour);
	}

	@Test(priority = 39, enabled = true)
	public void RW_T240_DayorganismRainDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Rain is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather rain"),
				expectedblackcolour);
	}

	@Test(priority = 40, enabled = true)
	public void RW_T240_DayorganismSnowDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Snow value is displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather snow"),
				expectedblackcolour);
	}

	@Test(priority = 41, enabled = true)
	public void RW_T240_DayorganismIceDisplayed() throws InterruptedException {
		testStart("Validate curent condition page day organism Snow value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather ice"),
				expectedblackcolour);
	}

	@Test(priority = 42, enabled = true)
	public void RW_T240_DayorganismHoursOfPrecipitationDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day organism Hours Of Precipitation is Displayed ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Hours of Precipitation"),
				expectedblackcolour);
	}

	@Test(priority = 43, enabled = true)
	public void RW_T240_DayorganismHOursOfRainDisplayed() throws InterruptedException {
		testStart("Validate curent condition page  Day organism Hours Of Rain is Displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Hours of Rain"),
				expectedblackcolour);
	}

	@Test(priority = 44, enabled = true)
	public void RW_T240_DayorganismWindDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day organism Wind is Displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Wind"),
				expectedblackcolour);
	}

	@Test(priority = 45, enabled = true)
	public void RW_T240_DayorganismCompassIconIsDisplayed() throws InterruptedException {
		testStart("Validate curent condition page Day organism Compass Icon Is Displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Compass Icon"),
				expectedblackcolour);
	}

	@Test(priority = 46, enabled = true)
	public void RW_T241_NightorganismTitleIsBold() {
		testStart("Validate whether Night organism has Its elements");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.nightOrganism();
		conditionpage.scrollPage();
		String Font = conditionpage.dayOrganismTextTitleisBold();
		try {
			Assert.assertTrue(Integer.parseInt(Font) > 499);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 47, enabled = true)
	public void RW_T241_NightorganismTimeDisplayed() {
		testStart("Validate whether Night organism has Its elements");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.nightOrganism();
		conditionpage.scrollPage();
		try {
			Assert.assertTrue(conditionpage.nightOrganismDateIsDisplayed());
			Thread.sleep(5000);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 48, enabled = true)
	public void RW_T241_NightorganismWeatherIconIsDisplayed() {
		testStart("Validate whether Night organism has Its elements");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.nightOrganism();
		conditionpage.scrollPage();
		try {
			Assert.assertTrue(conditionpage.nightOrganismWeatheIconIsDisplayed());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 49, enabled = true)
	public void RW_T241_NightorganismCurrentTemperarureIsBold() {
		testStart("Validate whether Night organism has Its elements");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.nightOrganism();
		conditionpage.scrollPage();
		String dayCurrentTemperature = conditionpage.nightOrganismCurrentTemparatureisBold();
		try {
			Assert.assertTrue(Integer.parseInt(dayCurrentTemperature) > 299);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 50, enabled = true)
	public void RW_T241_NightorganismReelFeelTemperatureIsDisplayed() {
		testStart("Validate whether Night organism has ReelFeel Temperature");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.nightOrganism();
		try {
			Assert.assertTrue(conditionpage.nightCurrentWeatherReelFeelTemperatureGetText().contains("RealFeel®"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 51, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherDescriptionIsDisplayed() {
		testStart("Validate whether Night organism has Weather description");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertTrue(conditionpage.bynightOrganismCurrentWeatherDescriptionIsDisplayed());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 52, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherPrecipitationPercentageIsDisplayed() {
		testStart("Validate whether Night organism Current Weather Precipitation is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertTrue(conditionpage.nightOrganismCurrentWeatherPrecipitationdisplayed());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 53, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherMaxUVIndexIsInGreyColor() {
		testStart("Validate whether night Organism Current Weather MaxUVIdex is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather MaxUVIdex"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 54, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherThunderstormsIsInGreyColor() {
		testStart("Validate whether night Organism Current Weather Thunderstorms is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Thunderstorms"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 55, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherPrecipitationIsInGreyColor() {
		testStart("Validate whether night Organism Current Weather Precipitation is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Precipitation"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 56, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherRainIsInGreyColor() {
		testStart("Validate whether Night organism Current Weather Rain is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Rain"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 57, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherSnowIsInGreyColor() {
		testStart("Validate whether Night organism Current Weather Snow is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Snow"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 58, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherIceIsInGreyColor() {
		testStart("Validate whether Night organism Current Weather Ice is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Ice"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 59, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherHoursOfPrecipitationIsInGreyColor() {
		testStart("Validate whether Night organism  Hours of Precipitation is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(
					conditionpage.validateElementIsGrey("night Organism Current Weather Hours of Precipitation"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 60, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherHoursOfRainIsInGreyColor() {
		testStart("Validate whether Night organism Hours of Rain is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Hours of Rain"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 61, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherWindIsInGreyColor() {
		testStart("Validate whether Night organism wind is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather wind"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 62, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherGustsIsInGreyColor() {
		testStart("Validate whether Night organism Gusts element is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Gusts"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 63, enabled = true)
	public void RW_T241_NightorganismCurrentWeatherCompassIconIsInGreyColor() {
		testStart("Validate whether Night organism compass icon is grey");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather compass icon"),
					expectedblackcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 64, enabled = true)
	public void RW_T243_temperatureHistoryOrganismIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganism());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 65, enabled = true)
	public void RW_T243_temperatureHistoryOrganismTitleIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Title is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismTitle());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 66, enabled = true)
	public void RW_T243_temperatureHistoryOrganismDateIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Date is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismDate());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 67, enabled = true)
	public void RW_T243_temperatureHistoryOrganismTodayHeaderIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Today Header is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismTodayHeader());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 68, enabled = true)
	public void RW_T243_temperatureHistoryOrganismNormalHeaderIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Normal Header is dispalyed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismNormalHeader());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 69, enabled = true)
	public void RW_T243_temperatureHistoryOrganismRecordHeaderIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Record Header is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismRecordHeader());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 70, enabled = true)
	public void RW_T243_temperatureHistoryOrganismLastYearHeaderIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Last Year Header is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 3; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismLastYearHeader());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 71, enabled = true)
	public void RW_T243_temperatureHistoryOrganismTodayFirstRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Today First Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismTodayFirstRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 72, enabled = true)
	public void RW_T243_temperatureHistoryOrganismTodaySecondRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Today Second Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismTodaySecondRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 73, enabled = true)
	public void RW_T243_temperatureHistoryOrganismNormalFirstRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Normal First Row Values is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismNormalFirstRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 74, enabled = true)
	public void RW_T243_temperatureHistoryOrganismNormalSecondRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Normal Second Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismNormalSecondRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 75, enabled = true)
	public void RW_T243_temperatureHistoryOrganismRecordFirstRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Record First Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismRecordFirstRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 76, enabled = true)
	public void RW_T243_temperatureHistoryOrganismRecordSecondRowValueIsDisplayed() {
		testStart("Validate whether Night organism temperature History Organism Record Second Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismRecordSecondRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 77, enabled = true)
	public void RW_T243_temperatureHistoryOrganismLastYearFirstRowValueIsDisplayed() {
		testStart(
				"Validate whether Night organism temperature History Organism Last Year First Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismLastYearFirstRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 78, enabled = true)
	public void RW_T243_temperatureHistoryOrganismLastYearSecondRowValueIsDisplayed() {
		testStart(
				"Validate whether Night organism temperature History Organism Last Year Second Row Value is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		for (int i = 0; i < 2; i++) {
			conditionpage.scrollPage();
		}

		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.temperatureHistoryOrganismLastYearSecondRowValue());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 79, enabled = true)
	public void RW_T244_ValidateRecentLocationLinkNavigatesToThreeDayForecastPage() {
		testStart("Validate whether Night organism Today Three Day Forecast Page Is Displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.isclickedonRecentLocationWeatherIcon();
		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertTrue(conditionpage.TodayCardonThreeDayForecastPageIsDisplayed());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 80, enabled = true)
	public void RW_T242_Elements_on_Sunrise_and_sunset_organism_Displayed() {
		testStart("Validate Elements on Sunrise/sunset organism in current condition page ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(conditionpage.Sunrisesunsetorganismdisplayed());
	}

	@Test(priority = 81, enabled = true)
	public void RW_T242_Sunrise_Title_Displayed_inGrey() {
		String Expectedcolour = "#8f8f8f";
		testStart("Validate Title Sunrise displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Actualcolour = conditionpage.validateElementIsGrey("Title Sunrise displayed in grey");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunrise displayed in grey"), Expectedcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 82, enabled = true)
	public void RW_T242_Sunrise_Time_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validate time displayed in Sunrise organism is in Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String ACTUALCOLOUR = conditionpage.validateElementIsGrey("Sunrise Time displayed in Black");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Sunrise Time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 83, enabled = true)
	public void RW_T242_Sunrise_Time_Displayed_inBold() {
		testStart("Validate time displayed in Sunrise organism is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		waitUntilElementIsDisplayedOrClickable();
		Object sunriseTime = conditionpage.Sunrisetimeinbold();
		Assert.assertTrue(Integer.parseInt(sunriseTime.toString()) > 399);
	}

	@Test(priority = 84, enabled = true)
	public void RW_T242_Sunset_Title_Displayed_inGrey() {
		testStart("Validate Title Sunset displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Actualcolour = conditionpage.validateElementIsGrey("Title Sunset displayed in grey");
		Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunset displayed in grey"), expectedblackcolour);
	}

	@Test(priority = 85, enabled = true)
	public void RW_T242_Sunset_Time_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validate time displayed in Sunrise organism is in Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String ACTUALCOLOUR = conditionpage.validateElementIsGrey("Sunset Time displayed in Black");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Sunset Time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 86, enabled = true)
	public void RW_T242_Sunset_Time_Displayed_inBold() {
		testStart("Validate time displayed in Sunrise organism is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		waitUntilElementIsDisplayedOrClickable();
		String Sunsettime = conditionpage.Sunsettimeinbold();
		Assert.assertTrue(Integer.parseInt(Sunsettime) > 399);
	}

	@Test(priority = 87, enabled = true)
	public void RW_T242_Duartion_Title_Displayed_inGrey() {
		testStart("Validate Title Sunset displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunset displayed in grey"), expectedblackcolour);
	}

	@Test(priority = 88, enabled = true)
	public void RW_T242_Sunrise_Sunset_Duration_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validating time displayed under duration title is Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String ACTUALCOLOUR = conditionpage.validateElementIsGrey("Duration displayed in Black");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Sunset Time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 89, enabled = true)
	public void RW_T242_Sunrise_Sunset_Duration_Displayed_inBold() {
		testStart("Validating time displayed under duration title is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(Integer.parseInt(conditionpage.Durationtimeinbold()) > 399);
	}

	@Test(priority = 90, enabled = true)
	public void RW_T242_Sunrise_Sunset_sunIcondisplayed() {
		testStart("Validating time displayed under duration title is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		Assert.assertTrue(conditionpage.IssuniconDisplayed());
	}

	@Test(priority = 91, enabled = true)
	public void RW_T242_Moonrise_Title_Displayed_inGrey() {
		String Expectedcolour = "#8f8f8f"; // Expected Colour display is Grey
		testStart("Validate Title Moonrise displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Actualcolour = conditionpage.validateElementIsGrey("Title Moonrise displayed in grey");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Moonrise displayed in grey"),
					Expectedcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 92, enabled = true)
	public void RW_T242_Moonrise_Time_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validate time displayed in Sunrise organism is in Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String ACTUALCOLOUR = conditionpage.validateElementIsGrey("Moonrise Time displayed in Black");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Moonrise Time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 93, enabled = true)
	public void RW_T242_Moonrise_Time_Displayed_inBold() {
		testStart("Validate time displayed in Sunrise organism is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Sunsettime = conditionpage.Moonrisetimeinbold();
		try {
			Assert.assertTrue(Integer.parseInt(Sunsettime) > 399);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 94, enabled = true)
	public void RW_T242_Moonset_Title_Displayed_inGrey() {
		String Expectedcolour = "#8f8f8f"; // Expected Colour display is Grey
		testStart("Validate Title Moonset displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Actualcolour = conditionpage.validateElementIsGrey("Title Moonset displayed in grey");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Moonset displayed in grey"), Expectedcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 95, enabled = true)
	public void RW_T242_Moonset_Time_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validate time displayed in Moonset organism is in Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Moonset Time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 96, enabled = true)
	public void RW_T242_Moonset_Time_Displayed_inBold() {
		testStart("Validate time displayed under Moonset organism is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Moonsettime = conditionpage.Moonsetimeinbold();
		try {
			Assert.assertTrue(Integer.parseInt(Moonsettime) > 399);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 97, enabled = true)
	public void RW_T242_Moonrise_Moonset_Duartion_Title_Displayed_inGrey() {
		String Expectedcolour = "#8f8f8f";
		testStart("Validate Title Duration displayed in grey color ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Actualcolour = conditionpage.validateElementIsGrey("Moonrise moonset Duration Title  displayed in grey");
		try {
			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunset displayed in grey"), Expectedcolour);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 98, enabled = true)
	public void RW_T242_Moonrise_Moonset_Duration_Displayed_inBlack() {
		String Expectedblackcolour2 = "#1e1e1e";
		testStart("Validating Moonrise and Moonset time displayed under duration title is Black ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String ACTUALCOLOUR = conditionpage.validateElementIsGrey("Moonrise moonset Duration time displayed in Black");
		try {
			Assert.assertEquals(
					conditionpage.validateElementIsGrey("Moonrise moonset Duration time displayed in Black"),
					Expectedblackcolour2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 99, enabled = true)
	public void RW_T242_Moonrise_Moonset_Duration_Displayed_inBold() {
		testStart("Validating time displayed under duration title is in Bold ");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		String Durationtime = conditionpage.moonrisemoonsetDurationtimeinbold();
		try {
			Assert.assertTrue(Integer.parseInt(Durationtime) > 399);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 100, enabled = true)
	public void RW_T242_More_Historical_Weather_Datadisplayed() {
		testStart("Validating Historical_Weather Data CTA displayed on Currentcondition page");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		conditionpage.isclickedonCurrentweathercardUsingTodayWeatherCard();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);
		conditionpage.scrollPage();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(conditionpage.Historicalweatherdata());
	}

}
