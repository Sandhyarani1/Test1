package com.accuweather.glacier.m.threeDayForeCast;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.threeDayForeCastMobilePage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;

public class Test_ThreeDayForeCastMobilePage extends AccuWeatherMobileBaseTest {

	private String zipcode = "53558";
	private String ExpectedactiveMobile = "subnav-item active";
	private LandingPageMobile landingpage = new LandingPageMobile();
	threeDayForeCastMobilePage threeDayForecastMobPage = new threeDayForeCastMobilePage();

	@Test(priority = 1, enabled = true)
	public void RW_T302_nowTabOnCityForecastPage() {
		String Expectedactive = "subnav-item active";
		testStart("Navigate to city forecast page and Verfiy Now Tab highlighted");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		// waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertEquals(threeDayForecastMobPage.isnowTabHighlighted(), ExpectedactiveMobile,
				"Now tab is not active ");
	}

	@Test(priority = 2, enabled = true)
	public void RW_T302_VerifyTodayWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardDisplayed();
	}

	@Test(priority = 3, enabled = true)
	public void RW_T302_VerifyTonightWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardDisplayed();
	}

	@Test(priority = 4, enabled = true)
	public void RW_T302_VerifyTomorrowWeatherCardsIsDisplayed() {
		testStart("Validate whether current, Today and Tomorrow weather cards are displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardDisplayed();
	}

	@Test(priority = 5, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardTitleIsDisplayed() {
		testStart("Validate whether Today weather card title is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardTitleDisplayed();
	}

	@Test(priority = 6, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardIconIsDisplayed() {
		testStart("Validate whether Today weather card icon is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardIconDisplayed();
	}

	@Test(priority = 7, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardTimeStampIsDisplayed() {
		testStart("Validate whether Today weather card Time Stamp is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardTimeStampDisplayed();
	}

	@Test(priority = 8, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardCurrentTemperatureIsDisplayed() {
		testStart("Validate whether Today weather card current temperature is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardCurrentTemeratureDisplayed();
	}

	@Test(priority = 9, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardReelFeelTemperatureIsDisplayed() {
		testStart("Validate whether Today weather card Reel Feel temperature is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardReelFeelTemperatureDisplayed();
	}

	@Test(priority = 10, enabled = true)
	public void RW_T303_VerifyTodayWeatherCardDescriptionIsDisplayed() {
		testStart("Validate whether Today weather card description is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTodayWeatherCardDescriptionDisplayed();
	}

	@Test(priority = 11, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardTitleIsDisplayed() {
		testStart("Validate whether tonight weather card Title is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonghtWeatherCardTitleDisplayed();
	}

	@Test(priority = 12, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardCurrentDateIsDisplayed() {
		testStart("Validate whether tonight weather card Current date is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardTimeStampDisplayed();
	}

	@Test(priority = 13, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardWeatherIconIsDisplayed() {
		testStart("Validate whether tonight weather card Weather icon is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardIconDisplayed();
	}

	@Test(priority = 14, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardLowTempIsDisplayed() {
		testStart("Validate whether tonight weather card Low Temerature is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardLowTemeratureDisplayed();
	}

	@Test(priority = 15, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardLowTextTempIsDisplayed() {
		testStart("Validate whether tonight weather card Low Temerature text is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardLowTextTemeratureDisplayed();
	}

	@Test(priority = 16, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardReelFeelTempIsDisplayed() {
		testStart("Validate whether tonight weather card Reel  Temerature text is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardReelFeelTemeratureDisplayed();
	}

	@Test(priority = 17, enabled = true)
	public void RW_T304_VerifyTonightWeatherCardWeatherDescriptionIsDisplayed() {
		testStart("Validate whether tonight weather card Weather Description text is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardReelWeatherDescriptionDisplayed();
	}

	@Test(priority = 18, enabled = true)
	public void RW_T303_VerifyTodayWeatherPageIsDipslayed() {
		testStart("Validate whether Today weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.isclickedonOnTodayWeatherCard(),
				"https://qualityassurance.accuweather.com/en/us/mc-farland/53558/current-weather/23238_pc",
				"On Tonight Weather page");

	}

	@Test(priority = 19, enabled = true)
	public void RW_T303_VerifyTonightWeatherPageIsDipslayed() {
		testStart("Validate whether tonight weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.isclickedOnTonightWeatherCard(),
				"https://qualityassurance.accuweather.com/en/us/mc-farland/53558/daily-weather-forecast/23238_pc?day=1",
				"On Tonight Weather page");
	}

	@Test(priority = 20, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardTitleIsDisplayed() {
		testStart("Validate whether tonight weather card Title is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardTitleDisplayed();
	}

	@Test(priority = 21, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardCurrentDateIsDisplayed() {
		testStart("Validate whether tonight weather card Current date is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardTimeStampDisplayed();
	}

	@Test(priority = 22, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardWeatherIconIsDisplayed() {
		testStart("Validate whether tonight weather card Weather icon is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardIconDisplayed();
	}

	@Test(priority = 23, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardLowTempIsDisplayed() {
		testStart("Validate whether tonight weather card Low Temerature is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardLowTemeratureDisplayed();
	}

	@Test(priority = 24, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardHighTempIsDisplayed() {
		testStart("Validate whether tonight weather card high Temerature is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTomorrowWeatherCardHighTempTemeratureDisplayed();
	}

	@Test(priority = 25, enabled = true)
	public void RW_T303_VerifyTomorrowWeatherCardWeatherDescriptionIsDisplayed() {
		testStart("Validate whether tonight weather card Weather Description text is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.isTonightWeatherCardReelWeatherDescriptionDisplayed();
	}

	@Test(priority = 25, enabled = true)
	public void RW_T303_VerifyTonightWeatherCardWeatherDescriptionIsDisplayed() {
		testStart("Validate whether tomorrow weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.isclickedOnTomorrowWeatherCard(),
				"https://qualityassurance.accuweather.com/en/us/mc-farland/53558/daily-weather-forecast/23238_pc?day=1",
				"On tomorrow Weather page");
	}

	@Test(priority = 26, enabled = true)
	public void RW_T304_VerifyThreeDayLandingPageForwardArrowLinkIsEnabled() {
		testStart("Validate whether tomorrow weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.isclickedOnThreeDayForcastLandingPageForwardArrowLink(),
				"arrow top card active", "Forward Arrow is not enabled");
	}

	@Test(priority = 27, enabled = true)
	public void RW_T304_VerifyThreeDayLandingPageBackwardArrowLinkIsDisabled() {
		testStart("Validate whether tomorrow weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.isclickedOnThreeDayForcastLandingPageForwardArrowLink(), "arrow",
				"Backward Arrow is enabled");
	}

	@Test(priority = 26, enabled = true)
	public void RW_T304_VerifyThreeDayLandingPageClickForwardArrowLink() {
		testStart("Validate whether tomorrow weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(threeDayForecastMobPage.clickOnThreeDayForcastLandingPageForwardArrowLink(), "arrow active",
				"Clicked on Forward arrow");
	}

	@Test(priority = 26, enabled = true)
	public void RW_T304_VerifyThreeDayLandingPageClickBackwardArrowLink() {
		testStart("Validate whether tomorrow weather page is displayed");
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		threeDayForecastMobPage.clickOnThreeDayForcastLandingPageForwardArrowLink();
		Assert.assertEquals(threeDayForecastMobPage.clickOnThreeDayForcastLandingPageBackwardArrowLink(), "arrow",
				"Clicked on backward arrow");
	}

}
