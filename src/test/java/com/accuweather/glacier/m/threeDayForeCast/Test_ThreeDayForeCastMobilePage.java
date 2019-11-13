package com.accuweather.glacier.m.threeDayForeCast;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.threeDayForeCastMobilePage;
import com.chameleon.utils.Sleeper;

public class Test_ThreeDayForeCastMobilePage extends AccuWeatherMobileBaseTest {
	
	String citySearchedByName = "Washington";
	private String ExpectedactiveMobile = "subnav-item active";
	String expectedUrl="https://qualityassurance.accuweather.com/en/us/washington/20006/current-weather/327659";
	String expectedTommorrowLandingpageUrl="https://qualityassurance.accuweather.com/en/us/washington/20006/daily-weather-forecast/327659?day=2";
	public static final String EXPECTED_DAILY_PAGE_URL="https://qualityassurance.accuweather.com/en/us/washington/20006/daily-weather-forecast/327659";
	
	threeDayForeCastMobilePage threeDayForecastMobPage = new threeDayForeCastMobilePage();

	@Test(priority = 1, enabled = true)
	public void TC1_nowTabOnCityForecastPage() {
		testStart("Navigate to city forecast page and Verfiy Now Tab highlighted");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertEquals(threeDayForecastMobPage.isnowTabHighlighted(), ExpectedactiveMobile,
				"Now tab is not active ");
	}

	@Test(priority = 2, enabled = true)
	public void TC2_VerifyTodayWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardDisplayed());
	}

	
	@Test(priority = 3, enabled = true)
	public void TC2_VerifyTonightWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardDisplayed());
		
	}

	@Test(priority = 4, enabled = true)
	public void TC2_VerifyTomorrowWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void TC5_VerifyTodayWeatherCardTitleIsDisplayed() {
		testStart("Validate whether Today weather card title is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardTitleDisplayed());
	}

	@Test(priority = 6, enabled = true)
	public void TC5_VerifyTodayWeatherCardIconIsDisplayed() {
		testStart("Validate whether Today weather card icon is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardIconDisplayed());
	}

	@Test(priority = 7, enabled = true)
	public void TC5_VerifyTodayWeatherCardTimeStampIsDisplayed() {
		testStart("Validate whether Today weather card Time Stamp is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardTimeStampDisplayed());
	}

	@Test(priority = 8, enabled = true)
	public void TC5_VerifyTodayWeatherCardCurrentTemperatureIsDisplayed() {
		testStart("Validate whether Today weather card current temperature is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardCurrentTemeratureDisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void TC5_VerifyTodayWeatherCardReelFeelTemperatureIsDisplayed() {
		testStart("Validate whether Today weather card Reel Feel temperature is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardReelFeelTemperatureDisplayed());
	}

	@Test(priority = 10, enabled = true)
	public void TC5_VerifyTodayWeatherCardDescriptionIsDisplayed() {
		testStart("Validate whether Today weather card description is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTodayWeatherCardDescriptionDisplayed());
	}

	// test case 6

	@Test(priority = 11, enabled = true)
	public void TC6_VerifyTonightWeatherCardTitleIsDisplayed() {
		testStart("Validate whether tonight weather card Title is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonghtWeatherCardTitleDisplayed());
	}

	@Test(priority = 12, enabled = true)
	public void TC6_VerifyTonightWeatherCardCurrentDateIsDisplayed() {
		testStart("Validate whether tonight weather card Current date is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardCurrentDateDisplayed());
	}

	
	@Test(priority = 13, enabled = true)
	public void TC6_VerifyTonightWeatherCardWeatherIconIsDisplayed() {
		testStart("Validate whether tonight weather card Weather icon is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardIconDisplayed());
	}

	@Test(priority = 14, enabled = true)
	public void TC6_VerifyTonightWeatherCardLowTempIsDisplayed() {
		testStart("Validate whether tonight weather card Low Temerature is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardLowTemeratureDisplayed());
	}
	

	@Test(priority = 15, enabled = true)
	public void TC6_VerifyTonightWeatherCardLowTextDisplayed() {
		testStart("Validate whether tonight weather card Low Temerature text is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardLowTextTemeratureDisplayed());
	}

	@Test(priority = 16, enabled = true)
	public void TC6_VerifyTonightWeatherCardReelFeelTempIsDisplayed() {
		testStart("Validate whether tonight weather card Reel  Temerature text is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardReelFeelTemeratureDisplayed());
	}

	@Test(priority = 17, enabled = true)
	public void TC6_VerifyTonightWeatherCardWeatherDescriptionIsDisplayed() {
		testStart("Validate whether tonight weather card Weather Description text is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardReelWeatherDescriptionDisplayed());
	}
/////////////////////////////////////////
	// test case 7

	@Test(priority = 18, enabled = true)
	public void TC7_VerifyTodayWeatherPageIsDipslayed() {
		testStart("Validate whether Today weather page is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		threeDayForecastMobPage.isclickedonOnTodayWeatherCard();
		System.out.println("Laanding page Url Today "+getDriver().getCurrentUrl());
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);

	}

	@Test(priority = 19, enabled = true)
	public void TC7_VerifyTonightWeatherPageIsDipslayed() {
		testStart("Validate whether tonight weather page is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		threeDayForecastMobPage.isclickedOnTonightWeatherCard();
		System.out.println("LAnding page Url for Tonight  "+getDriver().getCurrentUrl());
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);

	}

	// Test case 8

	@Test(priority = 20, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardTitleIsDisplayed() {
		testStart("Validate whether tonight weather card Title is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardTitleDisplayed());
	}

	@Test(priority = 21, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardCurrentDateIsDisplayed() {
		testStart("Validate whether tonight weather card Current date is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardDateDisplayed());
	}

	@Test(priority = 22, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardWeatherIconIsDisplayed() {
		testStart("Validate whether tonight weather card Weather icon is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardIconDisplayed());
	}

	
	@Test(priority = 23, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardLowTempIsDisplayed() {
		testStart("Validate whether Tomorrow weather card Low Temerature is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardLowTemeratureDisplayed());
	}

	@Test(priority = 24, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardHighTempIsDisplayed() {
		testStart("Validate whether Tomorrow weather card high Temerature is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTomorrowWeatherCardHighTempTemeratureDisplayed());
	}

	@Test(priority = 25, enabled = true)
	public void TC6_VerifyTomorrowWeatherCardWeatherDescriptionIsDisplayed() {
		testStart("Validate whether tonight weather card Weather Description text is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.isTonightWeatherCardReelWeatherDescriptionDisplayed());
	}

	// test case 9

	@Test(priority = 25, enabled = true)
	public void TC7_VerifyTommorowWeatherlandingpageDisplayed() {
		testStart("Validate whether tomorrow weather page is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		String actualTommorowpageUrl=threeDayForecastMobPage.isclickedOnTomorrowWeatherCard();
		Assert.assertEquals(actualTommorowpageUrl, expectedTommorrowLandingpageUrl);

	}

	// test case 10
	@Test(priority = 26, enabled = true)
	public void TC7_VerifyThreeDayLandingPageForwardArrowLinkIsEnabled() {
		testStart("Validate whether tomorrow weather page is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastMobPage.verfiyForwardArrowDisplayed());
	}

	

	// test case 11
	@Test(priority = 26, enabled = true)
	public void TC7_VerifyThreeDayLandingPageClickForwardArrowLink() {
		testStart("Validate whether tomorrow weather page is displayed");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertEquals(threeDayForecastMobPage.clickOnThreeDayForcastLandingPageForwardArrowLink(), "arrow active",
				"Clicked on Forward arrow");
	}

	@Test(priority = 26, enabled = true)
	public void TC7_VerifyDailypageloads() {
		testStart("Validating Daily  page loads when clicked on Forward arrow from city forecast page");
		threeDayForecastMobPage.searchCityByName(citySearchedByName);
		threeDayForecastMobPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		threeDayForecastMobPage.clickonForwardArrow();
		Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_DAILY_PAGE_URL);
		
	}

}
