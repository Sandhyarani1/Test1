package com.accuweather.glacier.www.currentCondition;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentConditionpage;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.MonthlyForeCastPage;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
import com.chameleon.selenium.web.WebPageLoaded;



public class Test_CurrentCondition extends AccuWeatherBaseTest {

	String zipcode = "53558";

	String actualForecastPageTitle;

	String expectedForecastPageTitle = "Mc Farland Weather - AccuWeather Forecast for WI 53558";

	String currentWeatherPageTitle = "Mc Farland Current Weather - AccuWeather Forecast for WI 53558";

	String expectedTimecolourgrey = "#878787";

	String expectedblackcolour = "#1f1f1f";



	private LandingPage landingpage = new LandingPage();

	private ForeCastWeatherPage forecastpage = new ForeCastWeatherPage();

	private MonthlyForeCastPage monthlyforecast = new MonthlyForeCastPage();

	private ThreeDayForecastPage threedayforecast = new ThreeDayForecastPage();

	private CurrentConditionpage conditionpage = new CurrentConditionpage();



	@Test(priority = 1, enabled = true)

	public void TC1_CityForecastPageCurrentWeatherCardIsDisplayed() throws InterruptedException {

		testStart("Validate curent weather card is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Assert.assertTrue(threedayforecast.weatherCardIsDisplayed("currentWeather"));

	}



	@Test(priority = 2, enabled = true)

	public void TC1_CityForecastPageTodayCardIsDisplayed() throws InterruptedException {

		testStart("Validate Today card is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Assert.assertTrue(threedayforecast.weatherCardIsDisplayed("Today"));

	}



	@Test(priority = 3, enabled = true)

	public void TC1_CityForecastPageTonightCardIsDisplayed() throws InterruptedException {

		testStart("Validate Tonight card is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Assert.assertTrue(threedayforecast.weatherCardIsDisplayed("Tonight"));

	}



	@Test(priority = 4, enabled = true)

	public void TC1_CityForecastPageTomorrowCardIsDisplayed() throws InterruptedException {

		testStart("Validate Tomorrow card is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Assert.assertTrue(threedayforecast.weatherCardIsDisplayed("Tomorrow"));

	}



	@Test(priority = 5, enabled = true)

	public void TC1_CityForecastPageCurrentWeatherURL() throws InterruptedException {

		testStart("Validate curent weather Url ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Thread.sleep(3000);

		conditionpage.isclickedonCurrentweathercard();

		String ActualForecastPageTitle = conditionpage.isclickedonCurrentweathercard2();

		String expectedForecastPageTitle = "https://development.accuweather.com/en/us/state-college/16801/current-weather/6787_pc";

		Assert.assertEquals(ActualForecastPageTitle, expectedForecastPageTitle);

	}



	@Test(priority = 6, enabled = false)

	public void TC2_Currentweather() {

		testStart("Validate curent condition page current weather card is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		String ActualForecastPageTitle = conditionpage.isclickedonCurrentweathercard2();

		conditionpage.TitleofCurrentweathercard();

	}



	@Test(priority = 7, enabled = false)

	public void TC3_TimeDisplayedingrey() throws InterruptedException {

		testStart("Validate curent weather Time is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Thread.sleep(3000);

		conditionpage.isclickedonCurrentweathercard();

		conditionpage.timeoncurrentconditionpage();

		String Actualtimecolour = conditionpage.Timedisplayedcolour();

		Assert.assertEquals(Actualtimecolour, expectedTimecolourgrey);

	}



	@Test(priority = 8, enabled = false)

	public void TC3_Weatherdisplayed() throws InterruptedException {

		testStart("Validate curent weather icon is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		Thread.sleep(3000);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertTrue(conditionpage.weathericondisplayed());

	}



	@Test(priority = 9, enabled = false)

	public void TC3_Temperaturedisplayedinfont() throws InterruptedException {

		testStart("Validate curent weather Temperature is displayed in bold");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertTrue(Integer.parseInt(conditionpage.temperatureinbold()) > 290);

	}



	@Test(priority = 11, enabled = false)

	public void TC4_currentWeatherTimeisDisplayedinGrey() {

		testStart("Validate curent weather time is displayed in Grey color");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("time displayed"), expectedTimecolourgrey);

	}



	@Test(priority = 12, enabled = false)

	public void TC4_currentWeatherRealFeelTemperatureisDisplayedinGrey() {

		testStart("Validate current Weather Real Feel Temperature is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("Real feel temparature"), expectedTimecolourgrey);

	}



	@Test(priority = 13, enabled = false)

	public void TC4_currentWeatherHumidityisDisplayedinGrey() {

		testStart("Validate TC4_current Weather Humidity is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("Humidity"), expectedblackcolour);

	}



	@Test(priority = 14, enabled = false)

	public void TC4_currentWeatherUVIndexisDisplayedinGrey() {

		testStart("Validate current Weather UVIndex is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("UV index"), expectedblackcolour);

	}



	@Test(priority = 15, enabled = false)

	public void TC4_currentWeatherCloudCoverisDisplayedinGrey() {

		testStart("Validate current Weather Cloud cover is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("cloud cover"), expectedblackcolour);

	}



	@Test(priority = 16, enabled = false)

	public void TC4_currentWeatherPressureisDisplayedinGrey() {

		testStart("Validate current Weather Pressure is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("pressure"), expectedblackcolour);

	}



	@Test(priority = 17, enabled = false)

	public void TC4_currentWeatherDewPointisDisplayedinGrey() {

		testStart("Validate current Weather dew point is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("dew point"), expectedblackcolour);

	}



	@Test(priority = 18, enabled = false)

	public void TC4_currentWeathervisibilityisDisplayedinGrey() {

		testStart("Validate current Weather visibility is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("visibility"), expectedblackcolour);

	}



	@Test(priority = 19, enabled = false)

	public void TC4_currentWeatherRealfeelShadeIsDisplayedinGrey() {

		testStart("Validate current Weather real feel shade is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("real feel shade"), expectedblackcolour);

	}



	@Test(priority = 20, enabled = false)

	public void TC4_currentWeatherCompassIconIsDisplayedinGrey() {

		testStart("Validate current Weather compass icon is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("compass icon"), expectedblackcolour);

	}



	@Test(priority = 21)

	public void TC4_currentWeatherWindIsDisplayedinGrey() {

		testStart("Validate current Weather wind is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("wind"), expectedblackcolour);

	}



	@Test(priority = 22, enabled = false)

	public void TC4_currentWeatherGustsIsDisplayedinGrey() {

		testStart("Validate current Weather gusts is Displayed in Grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		Assert.assertEquals(conditionpage.validateElementIsGrey("gusts"), expectedblackcolour);

	}



	@Test(priority = 23, enabled = false)

	public void TC5_CurrentConditionDayOrganismRightArrowColor() throws InterruptedException {

		String ExpectedRightArrowcolour = "#f59721";

		String ExpectedHourlyforecasturl = "https://development.accuweather.com/en/us/state-college/16801/hourly-weather-forecast/6787_pc";

		testStart("Validate curent condition Day Organism Right Arrow color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		conditionpage.HourlyCTAdisplayed();

		String Actualarrowcolour = conditionpage.rightarrowcolour();

		Assert.assertEquals(Actualarrowcolour, ExpectedRightArrowcolour);

	}



	@Test(priority = 24, enabled = false)

	public void TC5_CurrentConditionDayOrganism() throws InterruptedException {

		String ExpectedRightArrowcolour = "#f59721";

		String ExpectedHourlyforecasturl = "https://development.accuweather.com/en/us/state-college/16801/hourly-weather-forecast/6787_pc";

		testStart("Validate curent condition Day Organism is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		conditionpage.HourlyCTAdisplayed();

		String Actualarrowcolour = conditionpage.rightarrowcolour();

		Assert.assertEquals(conditionpage.clickonHourlyCTA(), ExpectedHourlyforecasturl);

	}



	@Test(priority = 25, enabled = false)

	public void TC6_currentDateDisplayed() throws InterruptedException {

		String ExpectedRightArrowcolour = "#f59721";

		String ExpectedHourlyforecasturl = "https://development.accuweather.com/en/us/state-college/16801/daily-weather-forecast/6787_pc?day=1";

		testStart("Validate curent condition current Date is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		conditionpage.currentDateonAccPage();

		Assert.assertEquals(conditionpage.currentDateonAccPage(), conditionpage.currentDateonAccPage());

		String ActualarrowcolournexttoDate = conditionpage.arrownexttodate();

	}



	@Test(priority = 26, enabled = false)

	public void TC6_currentWeatherRightArrowNextToDateIsDisplayed() throws InterruptedException {

		String ExpectedRightArrowcolour = "#f59721";

		String ExpectedHourlyforecasturl = "https://development.accuweather.com/en/us/state-college/16801/daily-weather-forecast/6787_pc?day=1";

		testStart("Validate curent condition page Right Arrow colour is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		conditionpage.currentDateonAccPage();

		String ActualarrowcolournexttoDate = conditionpage.arrownexttodate();

		Assert.assertEquals(ActualarrowcolournexttoDate, ExpectedRightArrowcolour);

	}



	@Test(priority = 27, enabled = false)

	public void TC7_DayorganismIsDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism title is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		Assert.assertTrue(conditionpage.todayOrganism());

		conditionpage.scrollPage();

	}



	@Test(priority = 28, enabled = false)

	public void TC7_DayorganismTitleInUpperCaseISDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism title is in uppercase");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertTrue(conditionpage.isDayOranismTitleIsInUppercase("DAY"));



	}



	@Test(priority = 29, enabled = false)

	public void TC7_DayorganismTitleTextIsInBoldDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day Organism Title text is displayed in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		String Font = conditionpage.dayOrganismTextTitleisBold();

		Assert.assertTrue(Integer.parseInt(Font) > 499);

	}



	@Test(priority = 30, enabled = false)

	public void TC7_DayorganismDateIsDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day Organism Date is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		String Font = conditionpage.dayOrganismTextTitleisBold();

		Assert.assertTrue(conditionpage.dayOrganismDateIsDisplayed());

	}



	@Test(priority = 31, enabled = false)

	public void TC7_DayorganismWeatherIconIsDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day organism Weather Icon is Displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		String Font = conditionpage.dayOrganismTextTitleisBold();

		Assert.assertTrue(conditionpage.dayOrganismWeatheIconIsDisplayed());

	}



	@Test(priority = 32, enabled = false)

	public void TC7_DayorganismCurrentTemperatureisInBoldDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Current Temperature is displayed in bold");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		// waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		// waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		// waitUntilElementIsDisplayedOrClickable();

		conditionpage.scrollPage();

		String Font = conditionpage.dayOrganismTextTitleisBold();

		String dayCurrentTemperature = conditionpage.dayOrganismCurrentTemparatureisBold();

		Assert.assertTrue(Integer.parseInt(dayCurrentTemperature) > 299);

	}



	@Test(priority = 33, enabled = false)

	public void TC7_DayorganismReelFeelTemperatureContainsRegisteredTrademark() throws InterruptedException {

		testStart("Validate curent condition page ReelFeel Temperature contains Registered trademark");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertTrue(conditionpage.dayCurrentWeatherReelFeelTemperatureGetText().contains("RealFeel®"));

	}



	@Test(priority = 34, enabled = false)

	public void TC7_DayorganismWeatherDescriptionDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Weather Description s displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertTrue(conditionpage.bydayOrganismCurrentWeatherDescriptionIsDisplayed());

	}



	@Test(priority = 35, enabled = false)

	public void TC7_DayorganismCurrentWeatherPrecipitationDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day Organism Current Weather Precipitation is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertTrue(conditionpage.dayOrganismCurrentWeatherPrecipitationdisplayed());

	}



	@Test(priority = 36, enabled = false)

	public void TC7_DayorganismCurrentWeatherMaxUVIdexDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day organism Current Weather MaxUVIdex is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Organism Current Weather MaxUVIdex"),

				expectedblackcolour);

	}



	@Test(priority = 37, enabled = false)

	public void TC7_DayorganismThunderstormsIsDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Thunderstorms is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Thunderstorms"),

				expectedblackcolour);

	}



	@Test(priority = 38, enabled = false)

	public void TC7_DayorganismPrecipitationDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Precipitation is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Precipitation"),

				expectedblackcolour);

	}



	@Test(priority = 39, enabled = false)

	public void TC7_DayorganismRainDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Rain is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather rain"),

				expectedblackcolour);

	}



	@Test(priority = 40, enabled = false)

	public void TC7_DayorganismSnowDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Snow value is displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather snow"),

				expectedblackcolour);

	}



	@Test(priority = 41, enabled = false)

	public void TC7_DayorganismIceDisplayed() throws InterruptedException {

		testStart("Validate curent condition page day organism Snow value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather ice"),

				expectedblackcolour);

	}



	@Test(priority = 42, enabled = false)

	public void TC7_DayorganismHoursOfPrecipitationDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day organism Hours Of Precipitation is Displayed ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Hours of Precipitation"),

				expectedblackcolour);



	}



	@Test(priority = 43, enabled = false)

	public void TC7_DayorganismHOursOfRainDisplayed() throws InterruptedException {

		testStart("Validate curent condition page  Day organism Hours Of Rain is Displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Hours of Rain"),

				expectedblackcolour);



	}



	@Test(priority = 44, enabled = false)

	public void TC7_DayorganismWindDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day organism Wind is Displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Wind"),

				expectedblackcolour);



	}



	@Test(priority = 45, enabled = false)

	public void TC7_DayorganismCompassIconIsDisplayed() throws InterruptedException {

		testStart("Validate curent condition page Day organism Compass Icon Is Displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertEquals(conditionpage.validateElementIsGrey("day Oragnism Current Weather Compass Icon"),

				expectedblackcolour);



	}



	@Test(priority = 46, enabled = false)

	public void TC8_NightorganismTitleIsBold() {

		testStart("Validate whether Night organism has Its elements");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 47, enabled = false)

	public void TC8_NightorganismTimeDisplayed() {

		testStart("Validate whether Night organism has Its elements");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		String Font = conditionpage.dayOrganismTextTitleisBold();

		try {

			Assert.assertTrue(conditionpage.nightOrganismDateIsDisplayed());

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 48, enabled = false)

	public void TC8_NightorganismWeatherIconIsDisplayed() {

		testStart("Validate whether Night organism has Its elements");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 49, enabled = false)

	public void TC8_NightorganismCurrentTemperarureIsBold() {

		testStart("Validate whether Night organism has Its elements");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 50, enabled = false)

	public void TC8_NightorganismReelFeelTemperatureIsDisplayed() {

		testStart("Validate whether Night organism has ReelFeel Temperature");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertTrue(conditionpage.nightCurrentWeatherReelFeelTemperatureGetText().contains("RealFeel®"));

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 51, enabled = false)

	public void TC8_NightorganismCurrentWeatherDescriptionIsDisplayed() {

		testStart("Validate whether Night organism has Weather description");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertTrue(conditionpage.bynightOrganismCurrentWeatherDescriptionIsDisplayed());

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 52, enabled = false)

	public void TC8_NightorganismCurrentWeatherPrecipitationPercentageIsDisplayed() {

		testStart("Validate whether Night organism Current Weather Precipitation is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertTrue(conditionpage.nightOrganismCurrentWeatherPrecipitationdisplayed());

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 53, enabled = false)

	public void TC8_NightorganismCurrentWeatherMaxUVIndexIsInGreyColor() {

		testStart("Validate whether night Organism Current Weather MaxUVIdex is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather MaxUVIdex"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 54, enabled = false)

	public void TC8_NightorganismCurrentWeatherThunderstormsIsInGreyColor() {

		testStart("Validate whether night Organism Current Weather Thunderstorms is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Thunderstorms"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 55, enabled = false)

	public void TC8_NightorganismCurrentWeatherPrecipitationIsInGreyColor() {

		testStart("Validate whether night Organism Current Weather Precipitation is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Precipitation"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 56, enabled = false)

	public void TC8_NightorganismCurrentWeatherRainIsInGreyColor() {

		testStart("Validate whether Night organism Current Weather Rain is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Rain"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 57, enabled = false)

	public void TC8_NightorganismCurrentWeatherSnowIsInGreyColor() {

		testStart("Validate whether Night organism Current Weather Snow is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Snow"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 58, enabled = false)

	public void TC8_NightorganismCurrentWeatherIceIsInGreyColor() {

		testStart("Validate whether Night organism Current Weather Ice is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Ice"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 59, enabled = false)

	public void TC8_NightorganismCurrentWeatherHoursOfPrecipitationIsInGreyColor() {

		testStart("Validate whether Night organism  Hours of Precipitation is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(

					conditionpage.validateElementIsGrey("night Organism Current Weather Hours of Precipitation"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 60, enabled = false)

	public void TC8_NightorganismCurrentWeatherHoursOfRainIsInGreyColor() {

		testStart("Validate whether Night organism Hours of Rain is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Hours of Rain"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 61, enabled = false)

	public void TC8_NightorganismCurrentWeatherWindIsInGreyColor() {

		testStart("Validate whether Night organism wind is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather wind"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 62, enabled = false)

	public void TC8_NightorganismCurrentWeatherGustsIsInGreyColor() {

		testStart("Validate whether Night organism Gusts element is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather Gusts"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 63, enabled = false)

	public void TC8_NightorganismCurrentWeatherCompassIconIsInGreyColor() {

		testStart("Validate whether Night organism compass icon is grey");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.nightOrganism();

		conditionpage.scrollPage();

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("night Organism Current Weather compass icon"),

					expectedblackcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 64, enabled = false)

	public void TC13_temperatureHistoryOrganismIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 65, enabled = false)

	public void TC13_temperatureHistoryOrganismTitleIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Title is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 66, enabled = false)

	public void TC13_temperatureHistoryOrganismDateIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Date is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 67, enabled = false)

	public void TC13_temperatureHistoryOrganismTodayHeaderIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Today Header is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 68, enabled = false)

	public void TC13_temperatureHistoryOrganismNormalHeaderIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Normal Header is dispalyed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 69, enabled = false)

	public void TC13_temperatureHistoryOrganismRecordHeaderIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Record Header is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 70, enabled = false)

	public void TC13_temperatureHistoryOrganismLastYearHeaderIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Last Year Header is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 71, enabled = false)

	public void TC13_temperatureHistoryOrganismTodayFirstRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Today First Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 72, enabled = false)

	public void TC13_temperatureHistoryOrganismTodaySecondRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Today Second Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 73, enabled = false)

	public void TC13_temperatureHistoryOrganismNormalFirstRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Normal First Row Values is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 74, enabled = false)

	public void TC13_temperatureHistoryOrganismNormalSecondRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Normal Second Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 75, enabled = false)

	public void TC13_temperatureHistoryOrganismRecordFirstRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Record First Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 76, enabled = false)

	public void TC13_temperatureHistoryOrganismRecordSecondRowValueIsDisplayed() {

		testStart("Validate whether Night organism temperature History Organism Record Second Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 77, enabled = false)

	public void TC13_temperatureHistoryOrganismLastYearFirstRowValueIsDisplayed() {

		testStart(

				"Validate whether Night organism temperature History Organism Last Year First Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 78, enabled = false)

	public void TC13_temperatureHistoryOrganismLastYearSecondRowValueIsDisplayed() {

		testStart(

				"Validate whether Night organism temperature History Organism Last Year Second Row Value is displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 79, enabled = false)

	public void TC18_ValidateRecentLocationLinkNavigatesToThreeDayForecastPage() {

		testStart("Validate whether Night organism Today Three Day Forecast Page Is Displayed");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 80, enabled = false)

	public void TC11_Elements_on_Sunrise_and_sunset_organism_Displayed() {

		testStart("Validate Elements on Sunrise/sunset organism in current condition page ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		Assert.assertTrue(conditionpage.Sunrisesunsetorganismdisplayed());

	}



	@Test(priority = 81, enabled = false)

	public void TC11_Sunrise_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f";

		testStart("Validate Title Sunrise displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 82, enabled = false)

	public void TC11_Sunrise_Time_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validate time displayed in Sunrise organism is in Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 83, enabled = false)

	public void TC11_Sunrise_Time_Displayed_inBold() {



		testStart("Validate time displayed in Sunrise organism is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		String sunriseTime = conditionpage.Sunrisetimeinbold();

		try {

			Assert.assertTrue(Integer.parseInt(sunriseTime) > 399);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 84, enabled = false)

	public void TC11_Sunset_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f";

		testStart("Validate Title Sunset displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		String Actualcolour = conditionpage.validateElementIsGrey("Title Sunset displayed in grey");

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunset displayed in grey"), Expectedcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 85, enabled = false)

	public void TC11_Sunset_Time_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validate time displayed in Sunrise organism is in Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 86, enabled = false)

	public void TC11_Sunset_Time_Displayed_inBold() {



		testStart("Validate time displayed in Sunrise organism is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		String Sunsettime = conditionpage.Sunsettimeinbold();

		try {

			Assert.assertTrue(Integer.parseInt(Sunsettime) > 399);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 87, enabled = false)

	public void TC11_Duartion_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f";

		testStart("Validate Title Sunset displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		String Actualcolour = conditionpage.validateElementIsGrey("Title Duration displayed in grey");

		try {

			Assert.assertEquals(conditionpage.validateElementIsGrey("Title Sunset displayed in grey"), Expectedcolour);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 88, enabled = false)

	public void TC11_Sunrise_Sunset_Duration_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validating time displayed under duration title is Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 89, enabled = false)

	public void TC11_Sunrise_Sunset_Duration_Displayed_inBold() {



		testStart("Validating time displayed under duration title is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		String Durationtime = conditionpage.Durationtimeinbold();

		try {

			Assert.assertTrue(Integer.parseInt(Durationtime) > 399);

		} catch (Exception e) {

			System.err.println(e.getMessage());

			Assert.fail();

		}

	}



	@Test(priority = 90, enabled = false)

	public void TC11_Sunrise_Sunset_sunIcondisplayed() {

		testStart("Validating time displayed under duration title is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		Assert.assertTrue(conditionpage.IssuniconDisplayed());

		conditionpage.Sunicon();

	}



	@Test(priority = 91, enabled = false)

	public void T12_Moonrise_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f"; // Expected Colour display is Grey

		testStart("Validate Title Moonrise displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 92, enabled = false)

	public void TC12_Moonrise_Time_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validate time displayed in Sunrise organism is in Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 93, enabled = false)

	public void TC12_Moonrise_Time_Displayed_inBold() {

		testStart("Validate time displayed in Sunrise organism is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 94, enabled = false)

	public void T12_Moonset_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f"; // Expected Colour display is Grey

		testStart("Validate Title Moonset displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 95, enabled = false)

	public void TC12_Moonset_Time_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validate time displayed in Moonset organism is in Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 96, enabled = false)

	public void TC12_Moonset_Time_Displayed_inBold() {

		testStart("Validate time displayed under Moonset organism is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 97, enabled = false)

	public void TC12_Moonrise_Moonset_Duartion_Title_Displayed_inGrey() {

		String Expectedcolour = "#8f8f8f";

		testStart("Validate Title Duration displayed in grey color ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 98, enabled = false)

	public void TC12_Moonrise_Moonset_Duration_Displayed_inBlack() {

		String Expectedblackcolour2 = "#1e1e1e";

		testStart("Validating Moonrise and Moonset time displayed under duration title is Black ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 99, enabled = false)

	public void TC12_Moonrise_Moonset_Duration_Displayed_inBold() {

		testStart("Validating time displayed under duration title is in Bold ");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

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



	@Test(priority = 100, enabled = false)

	public void TC13_More_Historical_Weather_Datadisplayed() {

		testStart("Validating Historical_Weather Data CTA displayed on Currentcondition page");

		landingpage.enterZipcodeInSearchField(zipcode);

		landingpage.clickOnZipcodeSearchIcon();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);

		WebPageLoaded.isDomInteractive(1000);

		conditionpage.isclickedonCurrentweathercard();

		waitUntilElementIsDisplayedOrClickable();

		waitUntilWindowExistsWithTitle(currentWeatherPageTitle);

		conditionpage.scrollPage();

		waitUntilElementIsDisplayedOrClickable();

		Assert.assertTrue(conditionpage.Historicalweatherdata());



	}
}

