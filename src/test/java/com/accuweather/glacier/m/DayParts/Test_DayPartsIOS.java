package com.accuweather.glacier.m.DayParts;

import java.net.URL;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.DayPartsPageIOS;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentConditionpage;
import com.accuweather.glacier.www.pages.DayPartsPage;
import com.accuweather.glacier.www.pages.LandingPage;

public class Test_DayPartsIOS extends AccuWeatherBaseTest {
	public final static String ZIPCODE = "16803";
	public final static String ACTUALFORECASTPAGETITLE = null;
	public final static String EXPECTEDFORECASTPAGETITLE = "State College, PA Three Day Weather Forecast | AccuWeather";
	public final static String CURRENTWEATHERPAGETITLE = "State College Current Weather - AccuWeather Forecast for PA 16801";
	public final static String EXPECTED_COLOR_GREY = "#878787";
	public final static String EXPECTED_BLACK_COLOR = "#1f1f1f";
	public final static String EXPECTED_BLACK_COLORV2 = "#1e1e1e";
	public final static String EXPECTED_BLACK_COLORV4 = "#8f8f8f";
	public final static String EXPECTED_BLACK_COLORV3 = "#1e1e1e";
	public final static String EXPECTED_DAY_PARTS_MORNING_TITLE = "State College Morning Weather - AccuWeather Forecast for PA 16803";
	public final static String EXPECTED_DAY_PARTS_MORNING_URL = "https://qualityassurance.accuweather.com/en/us/state-college/16803/morning-weather-forecast/6789_pc";
	public final static String EXPECTED_DAY_PARTS_AFTERNOON_URL = "https://qualityassurance.accuweather.com/en/us/state-college/16803/afternoon-weather-forecast/6789_pc";
	public final static String EXPECTED_DAY_PARTS_EVENING_URL = "https://qualityassurance.accuweather.com/en/us/state-college/16803/evening-weather-forecast/6789_pc";
	public final static String EXPECTED_DAY_PARTS_OVER_NIGHT_URL = "https://qualityassurance.accuweather.com/en/us/state-college/16803/overnight-weather-forecast/6789_pc";
	public final static String EXPECTED_AFTERNOON_TEXT_COLOR = "#f59721";
	public final static String MORNING_WEATHER_SUNRISE_TEXT = "Sunrise/Sunset";
	public final static String MORNING_WEATHER_SUNRISE_TIME = "Sunrise Time";
	public final static String MORNING_WEATHER_SUNRISE_SUNSET_TEXT = "Sunrise/Sunset";
	public final static String MORNING_WEATHER_SUNSET_TIME = "Sunset Time";
	public final static String MORNING_WEATHER_SUNRISE_SUNSET_DURARION_TEXT = "Sunrise/Sunset Duration text";
	public final static String MORNING_WEATHER_SUNRISE_SUNSET_DURATION_TIME = "Sunrise/Sunset Duration time";
	public final static String MORNING_WEATHER_SUNRISE_SUNSET_ICON = "Sunrise Sunset Icon";
	public final static String MORNING_WEATHER_MOONRISE_MOONSET_TEXT = "MoonRise MoonSet";
	public final static String MORNING_WEATHER_MOONRISE_TIME = "MoonRise Time";
	public final static String MORNING_WEATHER_MOONSET_TIME = "MoonSet Time";
	public final static String MORNING_WEATHER_MOONRISE_MOONSET_DURATION_TEXT = "MoonRise/MoonSet Duration text";
	public final static String MORNING_WEATHER_MOONRISE_MOONSET_DURATION_TIME = "MoonRise/MoonSet Duration time text";
	public final static String MORNING_WEATHER_MOONRISE_MOONSET_ICON = "MoonRise/MoonSet Icon";
	public final static String REEL_FEEL_TEMPERATURE = "Reel Feel Temperature";
	public final static String PRECIPITATION_PROBABLITY = "Precipitation Probablity";
	public final static String AFTERNOON_HUMIDITY = "Humidity";
	public final static String AFTERNOON_PRECIPITATION = "Precipitation";
	public final static String AFTERNOONRAIN = "Rain";
	public final static String AFTERNOON_SNOW = "Snow";
	public final static String AFTERNOON_ICE = "Ice";
	public final static String AFTERNOON_CLOUD_COVER = "Cloud Cover";
	public final static String AFTERNOON_DEW_POINT = "Dew Point";
	public final static String AFTERNOON_VISIBILITY = "Visibility";
	public final static String AFTERNOON_COMPASS_ICON = "Comopass Icon";
	public final static String AFTERNOON_WIND = "Wind";
	public final static String AFTERNOON_GUSTS = "Gusts";
	public final static String AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT = "Sunrise SunsetText";
	public final static String AFTERNOON_WEATHER_SUNRISE_TIME = "Sunrise Time";
	public final static String AFTERNOON_WEATHER_SUNSET_TIME = "Sunset Time";
	public final static String AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TEXT = "Sunrise/Sunset Duration text";
	public final static String AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TIME = "Sunrise/Sunset Duration time";
	public final static String AFTERNOON_WEATHER_MOONRISE_MOONSET_TEXT = "MoonRise MoonSet";
	public final static String AFTERNOON_WEATHER_MOONRISE_TIME = "MoonRise Time";
	public final static String AFTERNOON_WEATHER_MOONSET_TIME = "MoonSet Time";
	public final static String AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TEXT = "MoonRise/MoonSet Duration text";
	public final static String AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TIME = "MoonRise/MoonSet Duration time text";
	public final static String AFTERNOON_WEATHER_MOONRISE_MOONSET_ICON = "MoonRise/MoonSet Icon";
	public final static String EVENING_WEATHER_CURRENT_TEMPERATURE = "Current Temperature";
	public final static String OVERNIGHT_WEATHER_CURRENT_TEMPERATURE = "Title";
	private LandingPageMobile landingpage = new LandingPageMobile();
	private CurrentConditionpage conditionpage = new CurrentConditionpage();
	private DayPartsPageIOS dayPartsPage = new DayPartsPageIOS();

	@Test(priority = 1, enabled = true)
	public void TC1_verifyMorningforecastpagenavigation() throws InterruptedException {
		testStart("Validate whether Morning forecast page navigation is functional");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		Assert.assertEquals(dayPartsPage.currentweatherMorningLinkISClicked(), EXPECTED_DAY_PARTS_MORNING_URL);
	}

	@Test(priority = 2, enabled = true)
	public void TC2_verifyMorningOrganismTitleIsDisplayedInBold() throws InterruptedException {
		testStart("Validate whether Morning Organism Title Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismTitleISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 3, enabled = true)
	public void TC2_verifyMorningOrganismTitleIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate whether Morning Organism Title Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Title"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 4, enabled = true)
	public void TC2_verifyMorningOrganismWeatherIconIsDisplayed() throws InterruptedException {
		testStart("Validate whether Morning Organism Weather Icon Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.weatherIconIsdisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void TC2_verifyMorningOrganismCurrentTemperatureIsDisplayedInBold() throws InterruptedException {
		testStart("Validate whether Morning Organism Current Temparature Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismCurrentTemperatureISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 6, enabled = true)
	public void TC2_verifyMorningOrganismCurrentTemperatureIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate whether Morning Organism Current Temparature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Current Temperature"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 7, enabled = true)
	public void TC2_verifyMorningOrganismReelFeelTemperatureIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Reel Feel Temperature Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Reel Feel Temperature"), EXPECTED_COLOR_GREY);
	}

	@Test(priority = 8, enabled = true)
	public void TC2_verifyMorningOrganismWEatherDescriptionIsDisplayed() throws InterruptedException {
		testStart("Validate whether Morning Organism Weather Descripition Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.weatherDescripitionIsdisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void TC2_verifyMorningOrganismPrecipitationProbablityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Precipitation Probablity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Precipitation Probablity"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 10, enabled = true)
	public void TC2_verifyMorningOrganismHumidityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Humidity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Humidity"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 11, enabled = true)
	public void TC2_verifyMorningOrganismPrecipitationIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Precipitation Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Precipitation"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 12, enabled = true)
	public void TC2_verifyMorningOrganismRainIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Rain Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Rain"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 13, enabled = true)
	public void TC2_verifyMorningOrganismSnowIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Snow Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Snow"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 14, enabled = true)
	public void TC2_verifyMorningOrganismIceIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Ice Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Ice"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 15, enabled = true)
	public void TC2_verifyMorningOrganismCloudCoverIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Morning Organism Cloud Cover Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Cloud Cover"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 16, enabled = true)
	public void TC2_verifyMorningOrganismDewPointIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Dew Point Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Dew Point"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 17, enabled = true)
	public void TC2_verifyMorningOrganismVisibilityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate whether Morning Organism Visibility Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Visibility"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 18, enabled = true)
	public void TC2_verifyMorningOrganismCompassIconIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Morning Organism Compass Icon Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Comopass Icon"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 19, enabled = true)
	public void TC2_verifyMorningOrganismWindIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Morning Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Wind"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 20, enabled = true)
	public void TC2_verifyMorningOrganismGustsIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Morning Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementIsGrey("Gusts"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 21, enabled = true)
	public void TC2_verifyMorningOrganismAfterNoonCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Morning Organism AfterNoon CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoonCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 22, enabled = true)
	public void TC2_verifyMorningOrganismAfterNoonCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Morning Organism AfterNoon CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoonCTAArrowIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 23, enabled = true)
	public void TC2_verifyMorningOrganismDayAndNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Morning Organism day and night CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.dayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 24, enabled = true)
	public void TC2_verifyMorningOrganismDayAndNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Morning Organism day and night CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.dayAndNightCTAArrowIsOrangeColor(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 25, enabled = true)
	public void TC3_verifyMorningOrganismSunriseCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Morning Organism sunrise title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	// fixed

	@Test(priority = 26, enabled = true)
	public void TC3_verifyMorningOrganismSunriseCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Morning Organism sunrise card time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 27, enabled = true)
	public void TC3_verifyMorningOrganismSunriseCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart(" Validate Morning Organism sunrise time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismSuriseTimeISbold(), EXPECTED_BLACK_COLOR);
	}

	// bold reference

	@Test(priority = 28, enabled = true)
	public void TC3_verifyMorningOrganismSunriseCardTimeContainsAM() throws InterruptedException {
		testStart("Morning Organism sunrise time is displayed in am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismSuriseTimeIsdisplayedinAM());
	}

	@Test(priority = 29, enabled = true)
	public void TC3_verifyMorningOrganismSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Morning Organism sunset card Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 30, enabled = true)
	public void TC3_verifyMorningOrganismSunsetCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Morning Organism sunset card time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	// fixed

	@Test(priority = 31, enabled = true)
	public void TC3_verifyMorningOrganismSunsetCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Morning Organism sunset card time Is Displayed bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismSunsetTimeISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 32, enabled = true)
	public void TC3_verifyMorningOrganismSunsetCardTimeContainsPM() throws InterruptedException {
		testStart("Validate Morning Organism sunset time is displayed in PM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismSunsetTimeIsdisplayedinPM());
	}

	@Test(priority = 33, enabled = true)
	public void TC3_verifyMorningOrganismSunriseSunsetCardDurationIsinGrey() throws InterruptedException {
		testStart("Validate Morning Organism sunrise duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_DURARION_TEXT),
				EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 34, enabled = true)
	public void TC3_verifyMorningOrganismSunriseSunsetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate Morning Organism sunrise sunset duration time is dislayed in HR");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismSunriseSunsetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 35, enabled = true)
	public void TC3_verifyMorningOrganismSunriseSunsetCardDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate Morning Organism sunset duration time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismSunriseSunsetDurationTimeISbold(), EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 36, enabled = true)
	public void TC3_MorningOrganismSunriseSunsetCardDurationTimeIsInBlack() throws InterruptedException {
		testStart("Validate Morning Organism sunrise sunset duration time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_DURATION_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 37, enabled = true)
	public void TC3_verifyMorningOrganismSunriseSunsetCardIsDisplayedInOrange() throws InterruptedException {
		testStart("validate Morning Organism sunrise sunset icon Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 38, enabled = true)
	public void TC4_verifyverifyMorningOrganismMoonRiseMoonSetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Morning Organism Moonr rise Moon set title is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONRISE_MOONSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 39, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseTimeContainsAM() throws InterruptedException {
		testStart("validate Morning Organism moon rise time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismMoonRiseTimeIsdisplayedinAM());
	}

	@Test(priority = 40, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseTimeIsInBold() throws InterruptedException {
		testStart("validate Morning Organism Moon rise time is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismMoonRiseTimeIsbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 41, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseTimeIsinGrey() throws InterruptedException {
		testStart("validate Morning Organism moon rise  time Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 42, enabled = true)
	public void TC4_verifyMorningOrganismMoonSetTimeContainsAM() throws InterruptedException {
		testStart("validate Morning Organism Moon set time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismMoonSetTimeIsdisplayedinAM());
	}

	@Test(priority = 43, enabled = true)
	public void TC4_verifyMorningOrganismMoonSetTimeIsInBold() throws InterruptedException {
		testStart("validate Morning Organism moon set time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismMoonSetTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 44, enabled = true)
	public void TC4_verifyMorningOrganismMoonSetTimeIsinGrey() throws InterruptedException {
		testStart("validate Morning Organism AfterNoon moon set Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 45, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseMoonSetDurationIsinGrey() throws InterruptedException {
		testStart("validate Morning Organism moon set duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONRISE_MOONSET_DURATION_TEXT),
				EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 46, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseMoonSetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("validate Morning Organism moon rise duration time Is Displayed In HR");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.morningOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 47, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseMoonSetDurationTimeIsInBold() throws InterruptedException {
		testStart("Morning Organism moon rise moon set duration time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		System.out
				.println("Font weight test case 47" + dayPartsPage.morningOrganismMoonRiseMoonSetDurationTimeIsbold());
		Assert.assertEquals(dayPartsPage.morningOrganismMoonRiseMoonSetDurationTimeIsbold(), EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 48, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseMoonSetDurationTimeIsinGrey() throws InterruptedException {
		testStart("validate Morning Organism moon rise moon set duration time Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONRISE_MOONSET_DURATION_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 49, enabled = true)
	public void TC4_verifyMorningOrganismMoonRiseMoonSetIconIsinGrey() throws InterruptedException {
		testStart("validate Morning Organism moonrise moon set icon Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINMorningeatherPageIsGrey(MORNING_WEATHER_MOONRISE_MOONSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 50, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryTitleIsDisplayed() throws InterruptedException {
		testStart("validate Morning Organism temperature history title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTitle());
	}

	@Test(priority = 51, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryDateIsDisplayed() throws InterruptedException {
		testStart("validate Morning Organism temperature history Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismDate());
	}

	@Test(priority = 52, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryTodayHeaderIsDisplayed() throws InterruptedException {
		testStart("validate Morning Organism Temperature History Today Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayHeader());
	}

	@Test(priority = 53, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryNormalHeaderIsDisplayed() throws InterruptedException {
		testStart("validate Morning Organism Temperature History Normal Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalHeader());
	}

	@Test(priority = 54, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryRecordHeaderIsDisplayed() throws InterruptedException {
		testStart("validate Morning Organism TemperatureHistoryRecordHeader Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordHeader());
	}

	@Test(priority = 55, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryLastYearHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Last Year Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearHeader());
	}

	@Test(priority = 56, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryTodayHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism  Temperature History Today Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayFirstRowValue());
	}

	@Test(priority = 57, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryTodayHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism TemperatureHistoryTodayHeaderSecondRowValue Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodaySecondRowValue());
	}

	@Test(priority = 58, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryNormalHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Normal Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalFirstRowValue());
	}

	@Test(priority = 59, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryNormalHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Normal Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalSecondRowValue());
	}

	@Test(priority = 60, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryRecordHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Record Header First Row value  Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordFirstRowValue());
	}

	@Test(priority = 61, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryRecordHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Record Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordSecondRowValue());
	}

	@Test(priority = 62, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryLastYearHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism  Temperature History Last Year Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearFirstRowValue());
	}

	@Test(priority = 63, enabled = true)
	public void TC5_verifyMorningOrganismTemperatureHistoryLastYearHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Morning Organism Temperature History Last Year Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearSecondRowValue());
	}

	@Test(priority = 64, enabled = true)
	public void TC6_verifyNationalNewsFeedtextIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism National News Feed text Is Displayed Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 65, enabled = true)
	public void TC6_verifyContentRecirculationOrganismArticleOneIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article One Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 66, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleOneImageIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article One image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneImageIsDisplayed());
	}

	@Test(priority = 67, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleOneTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article One title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneTitleIsDisplayed());
	}

	@Test(priority = 68, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleOneCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article One category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneCategoryIsDisplayed());
	}

	@Test(priority = 69, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleOnePublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article One publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnePublishDateIsDisplayed());
	}

	@Test(priority = 70, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleTwoImageIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article two  image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoImageIsDisplayed());
	}

	@Test(priority = 71, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleTwoTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article two title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoTitleIsDisplayed());
	}

	@Test(priority = 72, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleTwoCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article two category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoCategoryIsDisplayed());
	}

	@Test(priority = 73, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleTwoPublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article two publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoPublishDateIsDisplayed());
	}

	@Test(priority = 74, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleThreeImageIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article three image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeImageIsDisplayed());
	}

	@Test(priority = 75, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleThreeTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article three title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeTitleIsDisplayed());
	}

	@Test(priority = 76, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleThreeCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article three category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeCategoryIsDisplayed());
	}

	@Test(priority = 77, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleThreePublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article three publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreePublishDateIsDisplayed());
	}

	@Test(priority = 78, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFourImageIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article four image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourImageIsDisplayed());
	}

	@Test(priority = 79, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFourTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article four title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourTitleIsDisplayed());
	}

	@Test(priority = 80, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFourCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article four category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourCategoryIsDisplayed());
	}

	@Test(priority = 81, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFourPublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article four publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourPublishDateIsDisplayed());
	}

	@Test(priority = 82, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFiveImageIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article five image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveImageIsDisplayed());
	}

	@Test(priority = 83, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFiveTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article five title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveTitleIsDisplayed());
	}

	@Test(priority = 84, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFiveCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article five category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveCategoryIsDisplayed());
	}

	@Test(priority = 85, enabled = true)
	public void TC7_verifyContentRecirculationOrganismArticleFivePublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Morning Organism  Content Recirculation Organism Article five publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivePublishDateIsDisplayed());
	}

	@Test(priority = 86, enabled = true)
	public void TC8_verifyContentRecirculationOrganismArticleOneNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnenavigtionIsClicked());
	}

	@Test(priority = 87, enabled = true)
	public void TC8_verifyContentRecirculationOrganismArticleTwoNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article two Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwonavigtionIsClicked());
	}

	@Test(priority = 88, enabled = true)
	public void TC8_verifyContentRecirculationOrganismArticleThreeNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article three Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreenavigtionIsClicked());
	}

	@Test(priority = 89, enabled = true)
	public void TC8_verifyContentRecirculationOrganismArticleFourNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFournavigtionIsClicked());
	}

	@Test(priority = 90, enabled = true)
	public void TC8_verifyContentRecirculationOrganismArticleFiveNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article five Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivenavigtionIsClicked());
	}

	@Test(priority = 91, enabled = true)
	public void TC9_verifyAfterNoonforecastpagenavigation() throws InterruptedException {
		testStart("Validate afterNoon forecast page navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		Assert.assertEquals(dayPartsPage.currentweatherAfterNoonLinkISClicked(), EXPECTED_DAY_PARTS_AFTERNOON_URL);
	}

	@Test(priority = 92, enabled = true)
	public void TC10_verifyAfterNoonOrganismTitleIsDisplayedInBold() throws InterruptedException {
		testStart("Validate  afternoon Organism Title Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismTitleISbold(), EXPECTED_BLACK_COLOR);

	}

	@Test(priority = 93, enabled = true)
	public void TC10_verifyAfterNoonOrganismTitleIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate afternoon Organism Title Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey("Title"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 94, enabled = true)
	public void TC10_verifyAfterNoonOrganismWeatherIconIsDisplayed() throws InterruptedException {
		testStart("Validate afternoon Organism Weather Icon Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonweatherIconIsdisplayed());
	}

	@Test(priority = 95, enabled = true)
	public void TC10_verifyAfterNoonOrganismCurrentTemperatureIsDisplayedInBold() throws InterruptedException {
		testStart("Validate afternoon Organism Current Temparature Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismCurrentTemperatureISbold(), EXPECTED_BLACK_COLOR);

	}

	@Test(priority = 96, enabled = true)
	public void TC10_verifyAfterNoonOrganismCurrentTemperatureIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate afternoon Organism Current Temparature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey("Current Temperature"),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 97, enabled = true)
	public void TC10_verifyAfterNoonOrganismReelFeelTemperatureIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism Reel Feel Temperature Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(REEL_FEEL_TEMPERATURE),
				EXPECTED_COLOR_GREY);
	}

	@Test(priority = 98, enabled = true)
	public void TC10_verifyAfterNoonOrganismWEatherDescriptionIsDisplayed() throws InterruptedException {
		testStart("Validate afternoon Organism Weather Descripition Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonweatherDescripitionIsdisplayed());
	}

	@Test(priority = 99, enabled = true)
	public void TC10_verifyAfterNoonOrganismPrecipitationProbablityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism Precipitation Probablity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(PRECIPITATION_PROBABLITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 100, enabled = true)
	public void TC10_verifyAfterNoonOrganismHumidityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism humidity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_HUMIDITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 101, enabled = true)
	public void TC10_verifyAfterNoonOrganismPrecipitationIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism Precipitation Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_PRECIPITATION),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 102, enabled = true)
	public void TC10_verifyAfterNoonOrganismRainIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism rain Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOONRAIN), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 103, enabled = true)
	public void TC10_verifyAfterNoonOrganismSnowIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism snow Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_SNOW), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 104, enabled = true)
	public void TC10_verifyAfterNoonOrganismIceIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism ice Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_ICE), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 105, enabled = true)
	public void TC10_verifyAfterNoonOrganismCloudCoverIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism cloud cover Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_CLOUD_COVER),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 106, enabled = true)
	public void TC10_verifyAfterNoonOrganismDewPointIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism dew point  Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_DEW_POINT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 107, enabled = true)
	public void TC10_verifyAfterNoonOrganismVisibilityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism Visibility Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_VISIBILITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 108, enabled = true)
	public void TC10_verifyAfterNoonOrganismCompassIconIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism Compass Icon Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_COMPASS_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 109, enabled = true)
	public void TC10_verifyAfterNoonOrganismWindIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WIND), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 110, enabled = true)
	public void TC10_verifyAfterNoonOrganismGustsIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate afternoon Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_GUSTS), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 111, enabled = true)
	public void TC10_verifyAfterNoonOrganismAfterNoonCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate afternoon Organism AfterNoon CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 112, enabled = true)
	public void TC10_verifyAfterNoonOrganismAfterNoonCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate afternoon Organism AfterNoon CTA arrow Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 113, enabled = true)
	public void TC10_verifyAfterNoonOrganismDayAndNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate afternoon Organism AfterNoon CTA text Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 114, enabled = true)
	public void TC10_verifyMorningOrganismDayAndNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Morning Organism day and night CTA arrwo Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTAArrowIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 115, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Valid afternoon Organism sunrise sunset card CTA title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 116, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 117, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSuriseTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 118, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseCardTimeContainsAM() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSuriseTimeIsdisplayedinAM());
	}

	@Test(priority = 119, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate afternoon Organism sunset title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 120, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunsetCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate afternoon Organism sunset time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 121, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunsetCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate afternoon Organism sunset time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunsetTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 122, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunsetCardTimeContainsPM() throws InterruptedException {
		testStart("Validate afternoon Organism sunset time Is Displayed In pm");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunsetTimeIsdisplayedinPM());
	}

	@Test(priority = 123, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardDurationIsinGrey() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TEXT), EXPECTED_BLACK_COLORV4);
	}

	@Test(priority = 124, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise sunset duration Is Displayed In hr");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 125, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise sunset duration Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 126, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardDurationTimeIsInBlack() throws InterruptedException {
		testStart("Validate afternoon Organism sunrise sunset duration Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TIME), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 127, enabled = true)
	public void TC11_verifyAfterNoonOrganismSunriseSunsetCardIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate afternoon Organism surise sunset icon Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 128, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 129, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseTimeContainsAM() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseTimeIsdisplayedinAM());
	}

	@Test(priority = 130, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseTimeIsInBold() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 131, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseTimeIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise time Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 132, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonSetTimeContainsAM() throws InterruptedException {
		testStart("Validate Afternoon Organism moonset time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonSetTimeIsdisplayedinAM());
	}

	@Test(priority = 133, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonSetTimeIsInBold() throws InterruptedException {
		testStart("Validate Afternoon Organism moonset time Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismMoonSetTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 134, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonSetTimeIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon set time Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 135, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetDurationIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TEXT),
				EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 136, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set Is Displayed In hr");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 137, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set Is Displayed In bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 138, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetDurationTimeIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 139, enabled = true)
	public void TC12_verifyAfternoonOrganismMoonRiseMoonSetIconIsinGrey() throws InterruptedException {
		testStart("Validate Afternoon Organism moon rise moon set duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 140, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryTitleIsDisplayed() throws InterruptedException {
		testStart("Validate AfterNoon Organism  Temperature History title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTitle());
	}

	@Test(priority = 141, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryDateIsDisplayed() throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismDate());
	}

	@Test(priority = 142, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryTodayHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate afterNoon Organism Temperature History Today Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayHeader());
	}

	@Test(priority = 143, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryNormalHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Normal Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalHeader());
	}

	@Test(priority = 144, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryRecordHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Record Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordHeader());
	}

	@Test(priority = 145, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryLastYearHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Last Year Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearHeader());
	}

	@Test(priority = 146, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryTodayHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History  Today Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayFirstRowValue());
	}

	@Test(priority = 147, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryTodayHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate MAfterNoon Organism Temperature History Today Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodaySecondRowValue());
	}

	@Test(priority = 148, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryNormalHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Normal Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalFirstRowValue());
	}

	@Test(priority = 149, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryNormalHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Normal Header Second Row value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalSecondRowValue());
	}

	@Test(priority = 150, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryRecordHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Record Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordFirstRowValue());
	}

	@Test(priority = 151, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryRecordHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Record Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordSecondRowValue());
	}

	@Test(priority = 152, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryLastYearHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History LastYear Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearFirstRowValue());
	}

	@Test(priority = 153, enabled = true)
	public void TC13_verifyAfterNoonOrganismTemperatureHistoryLastYearHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate AfterNoon Organism Temperature History Last Year Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearSecondRowValue());
	}

	@Test(priority = 154, enabled = true)
	public void TC14_verifyNationalNewsFeedtextIsDisplayed() throws InterruptedException {
		testStart("Validate National News Feed text Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 155, enabled = true)
	public void TC14_verifyContentRecirculationOrganismArticleOneIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 156, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleOneImageIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneImageIsDisplayed());
	}

	@Test(priority = 157, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleOneTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism ArticleOne Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneTitleIsDisplayed());
	}

	@Test(priority = 158, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleOneCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneCategoryIsDisplayed());
	}

	@Test(priority = 159, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleOnePublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnePublishDateIsDisplayed());
	}

	@Test(priority = 160, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleTwoImageIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Two Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoImageIsDisplayed());
	}

	@Test(priority = 161, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleTwoTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Two Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoTitleIsDisplayed());
	}

	@Test(priority = 162, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleTwoCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Two Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoCategoryIsDisplayed());
	}

	@Test(priority = 163, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleTwoPublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Two Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoPublishDateIsDisplayed());
	}

	@Test(priority = 164, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleThreeImageIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Three Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeImageIsDisplayed());
	}

	@Test(priority = 165, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleThreeTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Three Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeTitleIsDisplayed());
	}

	@Test(priority = 166, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleThreeCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Three Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeCategoryIsDisplayed());
	}

	@Test(priority = 167, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleThreePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Content Recirculation Organism Articl Three Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreePublishDateIsDisplayed());
	}

	@Test(priority = 168, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFourImageIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourImageIsDisplayed());
	}

	@Test(priority = 169, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFourTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourTitleIsDisplayed());
	}

	@Test(priority = 170, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFourCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourCategoryIsDisplayed());
	}

	@Test(priority = 171, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFourPublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four PublishDate Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourPublishDateIsDisplayed());
	}

	@Test(priority = 172, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFiveImageIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Five Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveImageIsDisplayed());
	}

	@Test(priority = 173, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFiveTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Five Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveTitleIsDisplayed());
	}

	@Test(priority = 174, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFiveCategoryIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Five Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveCategoryIsDisplayed());
	}

	@Test(priority = 175, enabled = true)
	public void TC15_verifyContentRecirculationOrganismArticleFivePublishDateIsDisplayed() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Five Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivePublishDateIsDisplayed());
	}

	@Test(priority = 176, enabled = true)
	public void TC16_verifyContentRecirculationOrganismArticleOneNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article One Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnenavigtionIsClicked());
	}

	@Test(priority = 177, enabled = true)
	public void TC16_verifyContentRecirculationOrganismArticleTwoNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Two Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwonavigtionIsClicked());
	}

	@Test(priority = 178, enabled = true)
	public void TC16_verifyContentRecirculationOrganismArticleThreeNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Three Navigation");
		landingpage.enterZipcodeInSearchField(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreenavigtionIsClicked());
	}

	@Test(priority = 180, enabled = true)
	public void TC16_verifyContentRecirculationOrganismArticleFourNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Four Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFournavigtionIsClicked());
	}

	@Test(priority = 181, enabled = true)
	public void TC16_verifyContentRecirculationOrganismArticleFiveNavigation() throws InterruptedException {
		testStart("Validate Content Recirculation Organism Article Five Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivenavigtionIsClicked());
	}

	@Test(priority = 182, enabled = true)
	public void TC17_verifyEveningforecastpagenavigation() throws InterruptedException {
		testStart("Validate Eveningforecastpagenavigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		Assert.assertEquals(dayPartsPage.currentweatherEveningLinkISClicked(), EXPECTED_DAY_PARTS_EVENING_URL);
	}

	@Test(priority = 183, enabled = true)
	public void TC18_verifyEveningOrganismTitleIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Evening Organism Title Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.eveningOrganismTitleISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 184, enabled = true)
	public void TC18_verifyEveningOrganismTitleIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Evening Organism Title Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey("Title"), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 185, enabled = true)
	public void TC18_verifyEveningOrganismWeatherIconIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Weather Icon Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.eveningweatherIconIsdisplayed());
	}

	@Test(priority = 186, enabled = true)
	public void TC18_verifyEveningOrganismCurrentTemperatureIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Evening Organism Current Temparature Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.eveningOrganismCurrentTemperatureISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 187, enabled = true)
	public void TC18_verifyEveningOrganismCurrentTemperatureIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Evening Organism Current Temparature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(EVENING_WEATHER_CURRENT_TEMPERATURE),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 188, enabled = true)
	public void TC18_verifyEveningOrganismReelFeelTemperatureIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Reel Feel Temperature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(REEL_FEEL_TEMPERATURE),
				EXPECTED_COLOR_GREY);
	}

	@Test(priority = 189, enabled = true)
	public void TC18_verifyEveningOrganismWEatherDescriptionIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Weather Descripition Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.eveningweatherDescripitionIsdisplayed());
	}

	@Test(priority = 190, enabled = true)
	public void TC18_verifyEveningOrganismPrecipitationProbablityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Precipitation Probablity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(PRECIPITATION_PROBABLITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 191, enabled = true)
	public void TC18_verifyEveningOrganismHumidityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Humidity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_HUMIDITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 192, enabled = true)
	public void TC18_verifyEveningOrganismPrecipitationIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Precipitation Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_PRECIPITATION),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 193, enabled = true)
	public void TC18_verifyEveningOrganismRainIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Rain Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOONRAIN), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 194, enabled = true)
	public void TC18_verifyEveningOrganismSnowIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Snow Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_SNOW), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 195, enabled = true)
	public void TC18_verifyEveningOrganismIceIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Ice Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_ICE), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 196, enabled = true)
	public void TC18_verifyEveningOrganismCloudCoverIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Cloud Cover Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_CLOUD_COVER),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 197, enabled = true)
	public void TC18_verifyEveningOrganismDewPointIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Dew Point Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_DEW_POINT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 198, enabled = true)
	public void TC18_verifyEveningOrganismVisibilityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Visibility Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_VISIBILITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 199, enabled = true)
	public void TC18_verifyEveningOrganismCompassIconIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism Compass Icon Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_COMPASS_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 200, enabled = true)
	public void TC18_verifyEveningOrganismWindIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WIND), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 201, enabled = true)
	public void TC18_verifyEveningOrganismGustsIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate Evening Organism gusts Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_GUSTS), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 202, enabled = true)
	public void TC18_verifyEveningOrganismOverNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Evening Evening Organism OverNight CTA Text Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 203, enabled = true)
	public void TC18_verifyEveningOrganismOverNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Evening Organism OverNight CTA Arrow Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 204, enabled = true)
	public void TC18_verifyEveningOrganismDayAndNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Evening Organism Day And Night CTA Text Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 205, enabled = true)
	public void TC18_verifyEveningOrganismDayAndNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Evening Organism Day And Night CTA Arrow Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTAArrowIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 206, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism SunriseSunset title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 207, enabled = true)
	public void TC19_verifyEveningOrganismSunriseCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Card Time Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 208, enabled = true)
	public void TC19_verifyEveningOrganismSunriseCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Card Time Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSuriseTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 209, enabled = true)
	public void TC19_verifyEveningOrganismSunriseCardTimeContainsAM() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Card time Contains AM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSuriseTimeIsdisplayedinAM());
	}

	@Test(priority = 210, enabled = true)
	public void TC19_verifyEveningOrganismSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism Sunset Card Title Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 211, enabled = true)
	public void TC19_verifyEveningOrganismSunsetCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate Evening Organism Sunset Card Time Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 212, enabled = true)
	public void TC19_verifyEveningOrganismSunsetCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Evening Organism Sunset Card Time Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunsetTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 213, enabled = true)
	public void TC19_verifyEveningOrganismSunsetCardTimeContainsPM() throws InterruptedException {
		testStart("Validate Evening Organism SunsetCard Time Contains PM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunsetTimeIsdisplayedinPM());
	}

	@Test(priority = 214, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardDurationIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Sunset Card Duration Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TEXT), EXPECTED_BLACK_COLORV4);
	}

	@Test(priority = 215, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate Evening Organism Evening CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 216, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate Morning Organism AfterNoon CTA Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 217, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardDurationTimeIsInBlack() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Sunset Card Duration Time Is In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TIME), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 218, enabled = true)
	public void TC19_verifyEveningOrganismSunriseSunsetCardIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate Evening Organism Sunrise Sunset Card Is Displayed InOrange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 219, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate Evening organism Moon Rise Moon Set Card Title Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 220, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseTimeContainsAM() throws InterruptedException {
		testStart("Validate evening Organism MoonRise Time Contains AM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseTimeIsdisplayedinAM());
	}

	@Test(priority = 221, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseTimeIsInBold() throws InterruptedException {
		testStart("Validate Evening Organism MoonRise Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseTimeIsbold(), EXPECTED_BLACK_COLORV2);

	}

	@Test(priority = 222, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseTimeIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism MoonRise Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 223, enabled = true)
	public void TC20_verifyEveningOrganismMoonSetTimeContainsAM() throws InterruptedException {
		testStart("Validate Evening Organism MoonSet Time Contains AM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonSetTimeIsdisplayedinAM());
	}

	@Test(priority = 224, enabled = true)
	public void TC20_verifyEveningOrganismMoonSetTimeIsInBold() throws InterruptedException {
		testStart("Validate Evening Organism MoonSet Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismMoonSetTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 225, enabled = true)
	public void TC20_verifyEveningOrganismMoonSetTimeIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism MoonSet Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 226, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetDurationIsinGrey() throws InterruptedException {
		testStart("Validate Evening Organism Moon Rise MoonSet Duration Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TEXT),
				EXPECTED_BLACK_COLORV4);
	}

	@Test(priority = 227, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate Evening Organism MoonRise MoonSet Card Duration Time Contains HR");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 228, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate Evening Organism MoonRise MoonSet Duration Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 229, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetDurationTimeIsinGrey() throws InterruptedException {
		testStart("Validate Evening OrganismMoon RiseMoon Set Duration Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 230, enabled = true)
	public void TC20_verifyEveningOrganismMoonRiseMoonSetIconIsinGrey() throws InterruptedException {
		testStart("Validate verify Evening Organism MoonRise MoonSet Icon Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_ICON),
				EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 231, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTitle());
	}

	@Test(priority = 232, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryDateIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismDate());
	}

	@Test(priority = 233, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryTodayHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Today Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayHeader());
	}

	@Test(priority = 234, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryNormalHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Normal Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalHeader());
	}

	@Test(priority = 235, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryRecordHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Record Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordHeader());
	}

	@Test(priority = 236, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryLastYearHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Organism Temperature History LastYear Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearHeader());
	}

	@Test(priority = 237, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryTodayHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Today Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayFirstRowValue());
	}

	@Test(priority = 238, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryTodayHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Today Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodaySecondRowValue());
	}

	@Test(priority = 239, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryNormalHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Normal Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalFirstRowValue());
	}

	@Test(priority = 240, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryNormalHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Normal Header SecondRow Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalSecondRowValue());
	}

	@Test(priority = 241, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryRecordHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Record Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordFirstRowValue());
	}

	@Test(priority = 242, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryRecordHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Record Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordSecondRowValue());
	}

	@Test(priority = 243, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryLastYearHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism Temperature History Last Year Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearFirstRowValue());
	}

	@Test(priority = 244, enabled = true)
	public void TC21_verifyEveningOrganismTemperatureHistoryLastYearHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Organism TemperatureHistory Last Year Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearSecondRowValue());
	}

	@Test(priority = 245, enabled = true)
	public void TC22_verifyEveningNationalNewsFeedtextIsDisplayed() throws InterruptedException {
		testStart("Validate Evening National News Feed text Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 246, enabled = true)
	public void TC22_verifyEveningContentRecirculationOrganismArticleOneIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article One Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 247, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleOneImageIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article One Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneImageIsDisplayed());
	}

	@Test(priority = 248, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleOneTitleIsDisplayed() throws InterruptedException {
		testStart("Validate evening Content Recirculation Organism Article One Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneTitleIsDisplayed());
	}

	@Test(priority = 249, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleOneCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article One Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneCategoryIsDisplayed());
	}

	@Test(priority = 250, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleOnePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article One Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnePublishDateIsDisplayed());
	}

	@Test(priority = 251, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleTwoImageIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Two Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoImageIsDisplayed());
	}

	@Test(priority = 252, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleTwoTitleIsDisplayed() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Two Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoTitleIsDisplayed());
	}

	@Test(priority = 253, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleTwoCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Two Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoCategoryIsDisplayed());
	}

	@Test(priority = 254, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleTwoPublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Two Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoPublishDateIsDisplayed());
	}

	@Test(priority = 255, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleThreeImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Three Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeImageIsDisplayed());
	}

	@Test(priority = 256, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleThreeTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Three Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeTitleIsDisplayed());
	}

	@Test(priority = 257, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleThreeCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Three Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeCategoryIsDisplayed());
	}

	@Test(priority = 258, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleThreePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Three Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreePublishDateIsDisplayed());
	}

	@Test(priority = 259, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFourImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Four Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourImageIsDisplayed());
	}

	@Test(priority = 260, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFourTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content RecirculationOrganism Article Four Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourTitleIsDisplayed());
	}

	@Test(priority = 261, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFourCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Four Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourCategoryIsDisplayed());
	}

	@Test(priority = 262, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFourPublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Four Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourPublishDateIsDisplayed());
	}

	@Test(priority = 263, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFiveImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Five Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveImageIsDisplayed());
	}

	@Test(priority = 264, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFiveTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Five Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveTitleIsDisplayed());
	}

	@Test(priority = 265, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFiveCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Five Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveCategoryIsDisplayed());
	}

	@Test(priority = 266, enabled = true)
	public void TC23_verifyEveningContentRecirculationOrganismArticleFivePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Five Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivePublishDateIsDisplayed());
	}

	@Test(priority = 267, enabled = true)
	public void TC24_verifyEveningContentRecirculationOrganismArticleOneNavigation() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article One Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnenavigtionIsClicked());
	}

	@Test(priority = 268, enabled = true)
	public void TC24_verifyEveningContentRecirculationOrganismArticleTwoNavigation() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Two Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwonavigtionIsClicked());
	}

	@Test(priority = 269, enabled = true)
	public void TC24_verifyEveningContentRecirculationOrganismArticleThreeNavigation() throws InterruptedException {
		testStart("Validate Evening Conten tRecirculation Organism Article Three Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreenavigtionIsClicked());
	}

	@Test(priority = 270, enabled = true)
	public void TC24_verifyEveningContentRecirculationOrganismArticleFourNavigation() throws InterruptedException {
		testStart("Validate Evening ontent Recirculation Organism Article Four Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFournavigtionIsClicked());
	}

	@Test(priority = 271, enabled = true)
	public void TC24_verifyEveningContentRecirculationOrganismArticleFiveNavigation() throws InterruptedException {
		testStart("Validate Evening Content Recirculation Organism Article Five Navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivenavigtionIsClicked());
	}

	@Test(priority = 272, enabled = true)
	public void TC25_verifyOverNightforecastpagenavigation() throws InterruptedException {
		testStart("Validate OverNight forecast page navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		Assert.assertEquals(dayPartsPage.currentweatherOverNightLinkISClicked(), EXPECTED_DAY_PARTS_OVER_NIGHT_URL);
	}

	@Test(priority = 273, enabled = true)
	public void TC26_verifyOverNightOrganismTitleIsDisplayedInBold() throws InterruptedException {
		testStart("Validate OverNight Organism Title Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.eveningOrganismTitleISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 274, enabled = true)
	public void TC26_verifyOverNightOrganismTitleIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate OverNight Organism Title Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateOverNightOrganismElementIsGrey(OVERNIGHT_WEATHER_CURRENT_TEMPERATURE),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 275, enabled = true)
	public void TC26_verifyOverNightOrganismWeatherIconIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Weather Icon Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.eveningweatherIconIsdisplayed());
	}

	@Test(priority = 276, enabled = true)
	public void TC26_verifyOverNightOrganismCurrentTemperatureIsDisplayedInBold() throws InterruptedException {
		testStart("Validate OverNight Organism Current Temparature Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(2);
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.eveningOrganismCurrentTemperatureISbold(), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 277, enabled = true)
	public void TC26_verifyOverNightOrganismCurrentTemperatureIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate OverNight Organism Current Temparature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(EVENING_WEATHER_CURRENT_TEMPERATURE),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 278, enabled = true)
	public void TC26_verifyOverNightOrganismReelFeelTemperatureIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Reel Feel Temperature Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(REEL_FEEL_TEMPERATURE),
				EXPECTED_COLOR_GREY);
	}

	@Test(priority = 279, enabled = true)
	public void TC26_verifyOverNightOrganismWEatherDescriptionIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Weather Descripition Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.eveningweatherDescripitionIsdisplayed());
	}

	@Test(priority = 280, enabled = true)
	public void TC26_verifyOverNightOrganismPrecipitationProbablityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Precipitation Probablity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateEveningOrganismElementIsGrey(PRECIPITATION_PROBABLITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 281, enabled = true)
	public void TC26_verifyOverNightOrganismHumidityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Humidity Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_HUMIDITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 282, enabled = true)
	public void TC26_verifyOverNightOrganismPrecipitationIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Precipitation Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_PRECIPITATION),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 283, enabled = true)
	public void TC26_verifyOverNightOrganismRainIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Rain Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOONRAIN), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 284, enabled = true)
	public void TC26_verifyOverNightOrganismSnowIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Snow Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_SNOW), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 285, enabled = true)
	public void TC26_verifyOverNightOrganismIceIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Ice Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_ICE), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 286, enabled = true)
	public void TC26_verifyOverNightOrganismCloudCoverIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Cloud Cover Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_CLOUD_COVER),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 287, enabled = true)
	public void TC26_verifyOverNightOrganismDewPointIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Dew Point Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_DEW_POINT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 288, enabled = true)
	public void TC26_verifyOverNightOrganismVisibilityIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Visibility Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_VISIBILITY),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 289, enabled = true)
	public void TC26OverNightOrganismCompassIconIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism Compass Icon Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_COMPASS_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 290, enabled = true)
	public void TC26_verifyOverNightOrganismWindIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism wind Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WIND), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 291, enabled = true)
	public void TC26_verifyOverNightOrganismGustsIsDisplayedInGrey() throws InterruptedException {
		testStart("Validate OverNight Organism gusts Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_GUSTS), EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 292, enabled = true)
	public void TC26_verifyOverNightOrganismOverNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Evening OverNight  CTA text Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 293, enabled = true)
	public void TC26_verifyOverNightOrganismOverNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate overnight OverNight  CTA arrow Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 294, enabled = true)
	public void TC26_verifyOverNightOrganismDayAndNightCTATextIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate overnight Organism AfterNoon CTA text Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTATextIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 295, enabled = true)
	public void TC26_verifyOverNightOrganismDayAndNightCTAArrowIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate overnight Organism AfterNoon CTA arrow Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.afterNoonCTATextIsOrangeColor();
		Assert.assertEquals(dayPartsPage.afterNoondayAndNightCTAArrowIsOrangeColor(), EXPECTED_AFTERNOON_TEXT_COLOR);
	}

	@Test(priority = 296, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism sunset title Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 297, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate OverNight Organism sunries time Is Displayed In black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 298, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate OverNight Organism sunrise time Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSuriseTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 299, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseCardTimeContainsAM() throws InterruptedException {
		testStart("Validate OverNight Organism sunrise time Is Displayed In am");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSuriseTimeIsdisplayedinAM());
	}

	@Test(priority = 300, enabled = true)
	public void TC27_verifyOverNightOrganismSunsetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism sunset Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNRISE_SUNSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 301, enabled = true)
	public void TC27_verifyOverNightOrganismSunsetCardTimeIsDisplayedInBlack() throws InterruptedException {
		testStart("Validate OverNight Organism Sunset Card Time Is Displayed In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(AFTERNOON_WEATHER_SUNSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 302, enabled = true)
	public void TC27_verifyOverNightOrganismSunsetCardTimeIsDisplayedInBold() throws InterruptedException {
		testStart("Validate Over Night Organism Sunset Card Time Is Displayed In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunsetTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 303, enabled = true)
	public void TC27_verifyOverNightOrganismSunsetCardTimeContainsPM() throws InterruptedException {
		testStart("Validate OverNight Organism sunset time Is Displayed In pm");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunsetTimeIsdisplayedinPM());
	}

	@Test(priority = 304, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardDurationIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism OverNight sunset sunrise duration Is Displayed In grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TEXT), EXPECTED_BLACK_COLORV4);
	}

	@Test(priority = 305, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate OverNight Organism Ovesunrise sunset time  Is Displayed In hr");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 306, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate OverNight Organism Sunrise Sunset Card Duration Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismSunriseSunsetDurationTimeISbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 307, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardDurationTimeIsInBlack() throws InterruptedException {
		testStart("Validate OverNight Organism sunrise SunsetCard Duration Time Is In Black");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(
				AFTERNOON_WEATHER_SUNRISE_SUNSET_DURATION_TIME), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 308, enabled = true)
	public void TC27_verifyOverNightOrganismSunriseSunsetCardIsDisplayedInOrange() throws InterruptedException {
		testStart("Validate OverNight Organism Sunrise Sunset Card Is Displayed In Orange");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateElementINAfterNoonWeatherPageIsGrey(MORNING_WEATHER_SUNRISE_SUNSET_ICON),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 309, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetCardTitleIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Card Title Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_TEXT),
				EXPECTED_BLACK_COLOR);
	}

	@Test(priority = 310, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseTimeContainsAM() throws InterruptedException {
		testStart("Validate Over Night Organism MoonRise Time Contains AM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseTimeIsdisplayedinAM());
	}

	@Test(priority = 311, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseTimeIsInBold() throws InterruptedException {
		testStart("Validate Over Night Organism MoonRise Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseTimeIsbold(), EXPECTED_BLACK_COLORV2);

	}

	@Test(priority = 312, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseTimeIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 313, enabled = true)
	public void TC28_verifyOverNightOrganismMoonSetTimeContainsAM() throws InterruptedException {
		testStart("Validate OverNight Organism MoonSet Time Contains AM");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonSetTimeIsdisplayedinAM());
	}

	@Test(priority = 314, enabled = true)
	public void TC28_verifyOverNightOrganismMoonSetTimeIsInBold() throws InterruptedException {
		testStart("Validate OverNight Organism MoonSet Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.morningOrganismMoonSetTimeIsbold(), EXPECTED_BLACK_COLORV2);

	}

	@Test(priority = 315, enabled = true)
	public void TC28_verifyOverNightOrganismMoonSetTimeIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonSet Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONSET_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 316, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetDurationIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Duration Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TEXT),
				EXPECTED_BLACK_COLORV4);
	}

	@Test(priority = 317, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetCardDurationTimeContainsHR() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Card Duration Time Contains HR");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertTrue(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR());
	}

	@Test(priority = 318, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetDurationTimeIsInBold() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Duration Time Is In Bold");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(dayPartsPage.afterNoonOrganismMoonRiseMoonSetDurationTimeIsbold(), EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 319, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetDurationTimeIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Duration Time Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_DURATION_TIME),
				EXPECTED_BLACK_COLORV2);
	}

	@Test(priority = 320, enabled = true)
	public void TC28_verifyOverNightOrganismMoonRiseMoonSetIconIsinGrey() throws InterruptedException {
		testStart("Validate OverNight Organism MoonRise MoonSet Icon Is in Grey");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		Assert.assertEquals(
				dayPartsPage.validateAfterNoonOrganismElementIsGrey(AFTERNOON_WEATHER_MOONRISE_MOONSET_ICON),
				EXPECTED_BLACK_COLORV3);
	}

	@Test(priority = 321, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryTitleIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTitle());
	}

	@Test(priority = 322, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryDateIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismDate());
	}

	@Test(priority = 323, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryTodayHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Today Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayHeader());
	}

	@Test(priority = 324, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryNormalHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Normal Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalHeader());
	}

	@Test(priority = 325, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryRecordHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History RecordHeader Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordHeader());
	}

	@Test(priority = 326, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryLastYearHeaderIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Last Year Header Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearHeader());
	}

	@Test(priority = 327, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryTodayHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Today Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodayFirstRowValue());
	}

	@Test(priority = 328, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryTodayHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Today Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismTodaySecondRowValue());
	}

	@Test(priority = 329, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryNormalHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Normal Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalFirstRowValue());
	}

	@Test(priority = 330, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryNormalHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Normal Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismNormalSecondRowValue());
	}

	@Test(priority = 331, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryRecordHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Record Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordFirstRowValue());
	}

	@Test(priority = 332, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryRecordHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Record Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismRecordSecondRowValue());
	}

	@Test(priority = 333, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryLastYearHeaderFirstRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Last Year Header First Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearFirstRowValue());
	}

	@Test(priority = 334, enabled = true)
	public void TC29_verifyOverNightOrganismTemperatureHistoryLastYearHeaderSecondRowValueIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Organism Temperature History Last Year Header Second Row Value Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(1);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.temperatureHistoryOrganismLastYearSecondRowValue());
	}

	@Test(priority = 335, enabled = true)
	public void TC30_verifyOverNightNationalNewsFeedtextIsDisplayed() throws InterruptedException {
		testStart("Validate Over Night National News Feed text Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 336, enabled = true)
	public void TC30_verifyOverNightContentRecirculationOrganismArticleOneIsDisplayed() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article One Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.nationalNewsFeedTextIsDisplayed());
	}

	@Test(priority = 337, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleOneImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article One Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneImageIsDisplayed());
	}

	@Test(priority = 338, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleOneTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening OverNight  Content Recirculation Organism Article One Title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneTitleIsDisplayed());
	}

	@Test(priority = 339, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleOneCategoryIsDisplayed()
			throws InterruptedException {
		testStart("OverNightContent Recirculation Organism Article One Category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOneCategoryIsDisplayed());
	}

	@Test(priority = 340, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleOnePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article One Publish Date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnePublishDateIsDisplayed());
	}

	@Test(priority = 341, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleTwoImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article Two Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoImageIsDisplayed());
	}

	@Test(priority = 342, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleTwoTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article Two title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoTitleIsDisplayed());
	}

	@Test(priority = 343, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleTwoCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article Two category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoCategoryIsDisplayed());
	}

	@Test(priority = 344, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleTwoPublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article Two publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwoPublishDateIsDisplayed());
	}

	@Test(priority = 345, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleThreeImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article three Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeImageIsDisplayed());
	}

	@Test(priority = 346, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleThreeTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article three title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeTitleIsDisplayed());
	}

	@Test(priority = 347, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleThreeCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article three category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreeCategoryIsDisplayed());
	}

	@Test(priority = 348, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleThreePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article three publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreePublishDateIsDisplayed());
	}

	@Test(priority = 349, enabled = true)
	public void TC31_verifyOverNightgContentRecirculationOrganismArticleFourImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article four Image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourImageIsDisplayed());
	}

	@Test(priority = 350, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFourTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article four title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourTitleIsDisplayed());
	}

	@Test(priority = 351, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFourCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article four category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourCategoryIsDisplayed());
	}

	@Test(priority = 352, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFourPublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article four publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFourPublishDateIsDisplayed());
	}

	@Test(priority = 353, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFiveImageIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article five image Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveImageIsDisplayed());
	}

	@Test(priority = 354, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFiveTitleIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article five title Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveTitleIsDisplayed());
	}

	@Test(priority = 355, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFiveCategoryIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article five category Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFiveCategoryIsDisplayed());
	}

	@Test(priority = 356, enabled = true)
	public void TC31_verifyOverNightContentRecirculationOrganismArticleFivePublishDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article five publish date Is Displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivePublishDateIsDisplayed());
	}

	@Test(priority = 357, enabled = true)
	public void TC32_verifyOverNightContentRecirculationOrganismArticleOneNavigation() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article one navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleOnenavigtionIsClicked());
	}

	@Test(priority = 358, enabled = true)
	public void TC32_verifyOverNightContentRecirculationOrganismArticleTwoNavigation() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article two navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleTwonavigtionIsClicked());
	}

	@Test(priority = 359, enabled = true)
	public void TC32_verifyOverNightContentRecirculationOrganismArticleThreeNavigation() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article three navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleThreenavigtionIsClicked());
	}

	@Test(priority = 360, enabled = true)
	public void to() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article four navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFournavigtionIsClicked());
	}

	@Test(priority = 361, enabled = true)
	public void TC32_verifyOverNightContentRecirculationOrganismArticleFiveNavigation() throws InterruptedException {
		testStart("Validate OverNight Content Recirculation Organism Article five navigation");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.contentCirculationArticleFivenavigtionIsClicked());
	}

	@Test(priority = 362, enabled = true)
	public void TC2_verifyMorningOrganismReelFeelTemperatureIsDisplayedInGrey_Api_Validation() throws Exception {
		testStart("Validate whether Morning Organism Reel Feel Temperature matches with api");
		URL url = new URL(
				"http://ncus-gadc-api-production.trafficmanager.net/forecasts/v1/daily/quarters/stations/VIDP.json?apikey=5251445912b143d8b4bee5a741762dd1&locationOffset=5.5&language=en-us&details=False&startDate=2019-05-30T00:00:00Z&dayCount=1&metric=False");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherMorningLinkISClicked();
		String response = dayPartsPage.sendGet();
		response = response.replace("[", "");
		response = response.replace("]", "");
		JSONObject myResponse = new JSONObject(response);
		Assert.assertEquals((myResponse.getJSONObject("Temperature").getJSONObject("Maximum").get("Value").toString()),
				dayPartsPage.morningOrganismCurrentTemperatureISdisplayed());
	}

	@Test(priority = 8, enabled = true)
	public void RW_T895_PaginationandDateonQuarterDays_verifyMorningMonthAndDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate whether Morning month and date");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.scrollPagewithCounter(3);
		dayPartsPage.currentweatherMorningLinkISClicked();
		Assert.assertTrue(dayPartsPage.verifyDateAndMonthPresent());
	}

	@Test(priority = 360, enabled = true)
	public void RW_T895_PaginationandDateonQuarterDays_verifyOvernightMonthAndDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate OverNight month and date");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherOverNightLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.verifyDateAndMonthPresent());
	}

	@Test(priority = 267, enabled = true)
	public void RW_T895_PaginationandDateonQuarterDays_verifyEveningMonthAndDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate Evening month and date are present");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherEveningLinkISClicked();
		dayPartsPage.scrollPagewithCounter(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(dayPartsPage.verifyDateAndMonthPresent());
	}

	@Test(priority = 21, enabled = true)
	public void RW_T895_PaginationandDateonQuarterDays_verifyAfternoonMonthAndDateIsDisplayed()
			throws InterruptedException {
		testStart("Validate afternoon month and date");
		landingpage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTEDFORECASTPAGETITLE);
		dayPartsPage.isclickedonTodayweathercard();
		dayPartsPage.currentweatherAfterNoonLinkISClicked();
		Assert.assertTrue(dayPartsPage.verifyDateAndMonthPresent());
	}

}
