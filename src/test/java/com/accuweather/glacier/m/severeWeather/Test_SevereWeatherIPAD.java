package com.accuweather.glacier.m.severeWeather;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.SevereWeatherPageIPAD;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_SevereWeatherIPAD extends AccuWeatherBaseTest {
	private final static String ZIPCODE = "48073";
	private final static String EXPECTEDSEVEREWEATHERPAGE_URL = "https://qualityassurance.accuweather.com/en/us/severe-weather";
	private final static String EXPECTEDTOOLTIP_COLOR = "#f59721";
	private final static String EXPECTEDTOOLTIP_DESCRIPTION = "THE SEVERE WEATHER MAP PROVIDES YOU WITH WEATHER WATCHES & WARNINGS FOR YOUR AREA SO YOU CAN PREPARE FOR WHAT’S AHEAD.";
	private final static String EXPECTEDMAPHEADER_TITLE = "UNITED STATES SEVERE WEATHER MAP";
	private final static String EXPECTEDCLOSEDTOOLTIP_COLOR = "#878787";
	private final static String EXPECTEDSEVERETAB_COLOR = "#f05514";

	private LandingPageMobile landingPage = new LandingPageMobile();
	private SevereWeatherPageIPAD severeWeatherPage = new SevereWeatherPageIPAD();

	@Test(priority = 1,enabled=true)
	public void RW_T502_ValidateTabsOnSevereWeatherPage_verifyUserIsTakenToSevereWeatherPage() {
		testStart("Validate user is taken to severe weatehr page");
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualSevereWeatherPageUrl = getDriver().getCurrentUrl();
			Assert.assertEquals(actualSevereWeatherPageUrl, EXPECTEDSEVEREWEATHERPAGE_URL);
	}
	
	

	@Test(priority = 2,enabled=true)
	public void RW_T502_ValidateTabsOnSevereWeatherPage_verifyTabsOnSevereWeatherPage() {
		testStart("Validate 3 tabs (Hurricane, severe, accuweather ready) on severe weatehr page");
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.isHurricaneSubMenuDisplayed();
		severeWeatherPage.isAWReadySubMenuDisplayed();
	}
	
	

	@Test(priority = 3,enabled=true)
	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyTooltipHighlightedInOrangeColor() {
		testStart("Verify tooltip is orange in color");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualColor = severeWeatherPage.verifyTootipBackgroundColor();
		Assert.assertEquals(actualColor,EXPECTEDTOOLTIP_COLOR);
	}
	
	

	@Test(priority = 4,enabled=true)
	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyTooltipDescription() {
		testStart("Verify tooltip description");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualDescription = severeWeatherPage.verifyTooltipDescription();
		Assert.assertEquals(actualDescription,EXPECTEDTOOLTIP_DESCRIPTION);
	}
	
	

	@Test(priority = 5,enabled=true)
	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyZoomInAndZoomOutofMap() {
		testStart("Verify able to click zoom in and zoom out of the map");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		severeWeatherPage.clickZoomInAndZoomOut();

	}
	
	

	@Test(priority = 6,enabled=true)
	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyToolTipClosed() {
		testStart("Verify on click of tooltip again, the tooltip closes");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualColor = severeWeatherPage.verifyToolTipClosed();
		Assert.assertEquals(actualColor,EXPECTEDCLOSEDTOOLTIP_COLOR);
	}
	
	

	@Test(priority = 7,enabled=true)
	public void RW_T380_TitleOfMapForSevereWeather_verifyMapHeaderForSevereWeather() {
		testStart("Verify title of map for severe weather");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualHeader = severeWeatherPage.getMapHeader();
		Assert.assertEquals(actualHeader,EXPECTEDMAPHEADER_TITLE);
	}
	
	

	@Test(priority = 8,enabled=true)
	public void RW_T379_TitleOfMapForSevereWeather_verifySecondaryNavigationMenusAboveMap() {
		testStart("Verify secondary navigation menus [hurricane, severe] displayed above the map");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		Assert.assertTrue(severeWeatherPage.verifySecondaryNavigationMenus());
	}
	
	
	

	@Test(priority = 9,enabled=true)
	public void RW_T379_TitleOfMapForSevereWeather_verifySevereTabHiglightedColor() {
		testStart("Verify severe tab highlighted in color");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		String actualColor = severeWeatherPage.verifySevereTabHiglightedColor();
		Assert.assertEquals(actualColor,EXPECTEDSEVERETAB_COLOR);
	}
	
	

	@Test(priority = 10,enabled=true)
	public void RW_T382_MapboxAttribution_locateMapboxAndClickInextToit() {
		testStart("Verify mapbox and click i next to mapbox");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		severeWeatherPage.locateMapboxAndClickInextToit();
	}
	
	

	@Test(priority = 11,enabled=true)
	public void RW_T382_MapboxAttribution_clickFullScreenButton() {
		testStart("Verify Map opens up into full screen with zoom controls if you click on x symbol the map switches back to normal");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		severeWeatherPage.mouseHoverOnSeverWeather();
		severeWeatherPage.isSeverWeatherSubMenuDisplayed();
		severeWeatherPage.clickSeverWeatherSubMenu();
		severeWeatherPage.clickFullScreenButtonOfMap();
	}
	
	

}
