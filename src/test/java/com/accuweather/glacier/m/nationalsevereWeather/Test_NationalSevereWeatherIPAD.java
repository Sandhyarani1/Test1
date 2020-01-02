package com.accuweather.glacier.m.nationalsevereWeather;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.NationalSevereWeatherPageIPAD;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Sleeper;

public class Test_NationalSevereWeatherIPAD extends AccuWeatherMobileBaseTest {

	private final static String EXPECTED_SEVERE_PAGE_URL = "https://qualityassurance.accuweather.com/en/us/national/severe-weather-maps";
	private final static String EXPECTED_TEXT_AT_BOTTOM_OF_MAP = "Tap an active alert area on map for details";
	private final static String EXPECTED_ZOOM_OUT_TEXT_AT_BOTTOM_OF_MAP = "Zoom in for more details";
	private final static String EXPECTED_TITLE_OF_MAP = "United States Severe Weather Map";
	private final static String EXPECTED_TOOLTIP_COLOR = "#f59721";
	private final static String EXPECTED_TOOLTIP_ClOSED_COLOR = "#878787";
	private final static String EXPECTED_TOOLTIP_DESCRIPTION = "The severe weather map provides you with weather watches & warnings for your area so you can prepare for what’s ahead.";
	private final static String zipcode = "48073";

	private NavigationBar navigationBar = new NavigationBar();
	private NationalSevereWeatherPageIPAD nationalSevereWeatherPage = new NationalSevereWeatherPageIPAD();
	private CityRadarPage cityRadar = new CityRadarPage();
	private LandingPageMobile landingPage = new LandingPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T392_DynamicKeyTextatBottomOfMapAndLegendsDisplayed_verifyTextAtBottomOfMap() {
		testStart("Validate text at the bottom of the map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualText = nationalSevereWeatherPage.verifyTextAtBottomOfMap();
		Assert.assertEquals(actualText, EXPECTED_TEXT_AT_BOTTOM_OF_MAP);
	}

	

	/*
	 * @Test(priority=2,enabled=true) public void
	 * RW_T392_DynamicKeyTextatBottomOfMapAndLegendsDisplayed_verifyTextZoomInForMoreDetails
	 * () {
	 * testStart("Validate text zoom in for more details at the bottom of the map");
	 * landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
	 * landingPage.clickOnZipcodeSearchIcon();
	 * navigationBar.mouseHoverOnRadarAndMaps();
	 * navigationBar.isSeverSubMenuDisplayed(); navigationBar.navigateToSevereTab();
	 * Sleeper.sleep(2); String actualSevereURL = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL); String
	 * actualText = nationalSevereWeatherPage.verifyTextZoomInForMoreDetails();
	 * Assert.assertEquals(actualText, EXPECTED_ZOOM_OUT_TEXT_AT_BOTTOM_OF_MAP); }
	 */

	@Test(priority = 3, enabled = true)
	public void RW_T393_OverlayOnSeverWeatherMapForFullScreen_verifyDynamicTextInFullScreenModeofMap() {
		testStart("Validate text at the bottom of the map in full screen mode");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualText = nationalSevereWeatherPage.verifyTextAtBottomOfMap();
		Assert.assertEquals(actualText, EXPECTED_TEXT_AT_BOTTOM_OF_MAP);

	}

	

	@Test(priority = 4, enabled = true)
	public void RW_T393_OverlayOnSeverWeatherMapForFullScreen_closeMapFullScreen() {
		testStart("Close he map full screen and verify the map is back to default mode");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		Assert.assertTrue(nationalSevereWeatherPage.closeMapFullScreen());
	}

	

	@Test(priority = 5, enabled = true)
	public void RW_T393_OverlayOnSeverWeatherMapForFullScreen_verifyTitleOfTheMap() {
		testStart("Verify title of the map under secondary navigation menu");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualTitleOfMap = nationalSevereWeatherPage.verifyTitleOfTheMap();
		Assert.assertEquals(actualTitleOfMap, EXPECTED_TITLE_OF_MAP.toUpperCase());
	}

	

	@Test(priority = 6, enabled = true)
	public void RW_T390_TooltipAndZoomControlsOnRightCornerOfMapHeader_verifyTootipBackgroundColor() {
		testStart("Verify tool tip background color");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualTooltipColor = nationalSevereWeatherPage.verifyTootipBackgroundColor();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOLTIP_COLOR);
	}

	

	@Test(priority = 7, enabled = true)
	public void RW_T390_TooltipAndZoomControlsOnRightCornerOfMapHeader_verifyTootipDescription() {
		testStart("Verify tool tip description");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualTooltipDescription = nationalSevereWeatherPage.verifyTooltipDescription();
		Assert.assertEquals(actualTooltipDescription, EXPECTED_TOOLTIP_DESCRIPTION.toUpperCase());
	}

	

	@Test(priority = 8, enabled = true)
	public void RW_T390_TooltipAndZoomControlsOnRightCornerOfMapHeader_verifyTootipIsClosed() {
		testStart("Verify tool tip color after the tool tip is closed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		String actualColor = nationalSevereWeatherPage.verifyToolTipClosed();
		Assert.assertEquals(actualColor, EXPECTED_TOOLTIP_ClOSED_COLOR);
	}

	

	@Test(priority = 9, enabled = true)
	public void RW_T390_TooltipAndZoomControlsOnRightCornerOfMapHeader_clickZoomInAndZoomOut() {
		testStart("Verify zoom in and zoom out");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isSeverSubMenuDisplayed();
		navigationBar.navigateToSevereTab();
		Sleeper.sleep(2);
		String actualSevereURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualSevereURL, EXPECTED_SEVERE_PAGE_URL);
		nationalSevereWeatherPage.clickZoomInAndZoomOut();
	}

}
