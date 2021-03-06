package com.accuweather.glacier.m.cityRadar;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.CityRadarPageMobileIpad;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_cityRadar_ipad extends AccuWeatherBaseTest {
	String zipcode = "48073";
	String expectedMapbox_URL = "https://www.mapbox.com/about/maps/";
	String expectedRadarPage_URL = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/weather-radar/20813_pc";
	String expectedOpenStreetMap_URL = "https://www.openstreetmap.org/about/";
	String expectedImproveThisMap_URL = "https://apps.mapbox.com/feedback/?owner=accuweather-inc-dev&id=cjfvtyj1h0e4p2rp95falted1&access_token=pk.eyJ1IjoiYWNjdXdlYXRoZXItaW5jLWRldiIsImEiOiJjanBpaXB1ZmgxNzU0M3dwZDd2dTVkYmFpIn0.IZ_I_4zFPzzc-VdC_d5JXg";
	String expectedColor = "#f59721";
	String expectedTooltipColor = "#878787";
	String expectedRadarTabColor = "#f05514";
	String expectedMapHeader = "Michigan Weather Radar";
	String expectedDescription = "Weather radar map shows the location of precipitation, its type (rain, snow, and ice) and its recent movement to help you plan your day.";
	String defaultWindowid;
	private LandingPage landingPage = new LandingPage();
	private CityRadarPageMobileIpad cityRadar = new CityRadarPageMobileIpad();

	@Test(priority = 1,enabled = false)
	public void RW_T268_MixLegendsBelowMap_verifyLightAndSeverFromMixLegend() {
		testStart("Verify severe and light present below the mix legend");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyLightAndSeverFromMixLegend());
	}

	@Test(priority = 2,enabled = false)
	public void RW_T268_MixLegendsBelowMap_verifyMixLegendColorVaryFromLightToDark() {
		testStart("Verify the color vary from light to dark");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyColorVaryFromLightToDark());
	}

	@Test(priority = 3,enabled = false)
	public void RW_T267_IceLegendsBelowMap_verifyLightAndSeverFromIceLegend() {
		testStart("Verify severe and light present below the ice legend");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyLightAndSeverFromIceLegend());
	}

	@Test(priority = 4,enabled = false)
	public void RW_T267_IceLegendsBelowMap_verifyMixLegendColorVaryFromLightToDark() {
		testStart("Verify the color vary from light to dark");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyColorVaryFromLightToDark());
	}

	@Test(priority = 5,enabled = false)
	public void RW_T266_SnowLegendsBelowMap_verifyLightAndSeverFromSnowLegend() {
		testStart("Verify severe and light present below the ice legend");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyLightAndSeverFromSnowLegend());
	}

	@Test(priority = 6,enabled = false)
	public void RW_T266_SnowLegendsBelowMap_verifyMixLegendColorVaryFromLightToDark() {
		testStart("Verify the color vary from light to dark");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyColorVaryFromLightToDark());
	}

	@Test(priority = 7,enabled = false)
	public void RW_T265_RainLegendsBelowMap_verifyLightAndSeverFromSnowLegend() {
		testStart("Verify severe and light present below the ice legend");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyLightAndSeverFromSnowLegend());
	}

	@Test(priority = 8,enabled = false)
	public void RW_T265_RainLegendsBelowMap_verifyMixLegendColorVaryFromLightToDark() {
		testStart("Verify the color vary from light to dark");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyColorVaryFromLightToDark());
	}

	@Test(priority = 9,enabled = false)
	public void RW_T261_ToggleBetweenPastAndFutureCTA_verifyTimelineControlsBelowMap() {
		testStart("Verify timeline controls like Past and Future CTA below the map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyPastAndFutureCTABelowMap());
	}

	@Test(priority = 10,enabled = false)
	public void RW_T261_AddSliderWithPlayButton_verifyPresenceOfSliderBarWithPlayButtonAndTime() {
		testStart("Locate for Slider with Play button and time at the end of the slider bar");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.verifyPresenceOfSliderBarWithPlayButtonAndTime());
	}

	@Test(priority = 11,enabled = false)
	public void RW_T262_AddSliderWithPlayButton_verifyPlayButtonBackgroundColor() {
		testStart("Toggle between future and past cta");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.toggleBetweenPastAndFutureCTA());
	}

	@Test(priority = 12,enabled = false)
	public void RW_T260_TimelineControlsToRadarMap_locatePastCTAHighlightedByDefault() {
		testStart("Verify PAST CTA highlighted by default on city Weather Radar page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.locatePastCTAHighlightedByDefault());
	}

	@Test(priority = 13,enabled = false)
	public void RW_T259_MapboxAttribution_clickMapbox() {
		testStart("Click on the mapbox and verify the user is navigated to mapbox URL");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		defaultWindowid = getDriver().getWindowHandle();
		cityRadar.clickMapbox();
		cityRadar.switchToPopUpWindow(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedMapbox_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 14,enabled = false)
	public void RW_T259_MapboxAttribution_clickOpenStreetMap() {
		testStart("Click on the openstreetmap and verify the user is navigated to openstreet map URL");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		defaultWindowid = getDriver().getWindowHandle();
		cityRadar.clickOpenStreetMap();
		cityRadar.switchToPopUpWindow(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedOpenStreetMap_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 15,enabled = false)
	public void RW_T259_MapboxAttribution_clickImproveThisMap() {
		testStart("Click on the improvethis map and verify the user is navigated to improve this map URL");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		defaultWindowid = getDriver().getWindowHandle();
		cityRadar.clickImproveThisMap();
		cityRadar.switchToPopUpWindow(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedImproveThisMap_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 16,enabled = false)
	public void RW_T258_FullScreenButton_ClickFullScreenButton() {
		testStart(
				"Click fullscreen button and verify Map opens up into full screen with timeline controls, slider with play button, and legend and if you click on x symbol the map switches back to normal.");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		Assert.assertTrue(cityRadar.clickFullScreenButtonOfMap());
	}

	@Test(priority = 17,enabled = false)
	public void RW_T257_ZoomControlButton_clickZoomInAndOut() {
		testStart("Verify able to click zoom in and zoom out of the map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		cityRadar.clickZoomInAndZoomOut();
	}

	@Test(priority = 18,enabled = false)
	public void RW_T256_ToolTip_verifyTootipBackgroundColor() {
		testStart("Verify tooltip background color in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualColor = cityRadar.verifyTootipBackgroundColor();
		try {
			Assert.assertEquals(expectedColor, actualColor);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 19,enabled = false)
	public void RW_T256_ToolTip_verifyTooltipHeaderBackgroundColor() {
		testStart("Verify tooltip header background color in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualColor = cityRadar.verifyTootipHeaderBackgroundColor();
		try {
			Assert.assertEquals(expectedColor, actualColor);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 20,enabled = false)
	public void RW_T256_ToolTip_verifyTooltipDescription() {
		testStart("Verify tooltip description");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualDescription = cityRadar.verifyTooltipDescription();
		try {
			Assert.assertEquals(expectedDescription, actualDescription);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 21,enabled = false)
	public void RW_T256_ToolTip_verifyRadarTabHighlightedColor() {
		testStart("Verify radar tab highlighted color");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualColor = cityRadar.verifyRadarTabHighlightedColor();
		try {
			Assert.assertEquals(expectedRadarTabColor, actualColor);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 22,enabled = false)
	public void RW_T256_ToolTip_verifyTooltipMapHeader() {
		testStart("Verify tooltip description");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualHeader = cityRadar.getMapHeader();
		try {
			Assert.assertEquals(expectedMapHeader, actualHeader);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 23,enabled = false)
	public void RW_T256_ToolTip_verifyToolTipClosed() {
		testStart("Verify on click of tooltip again, the tooltip closes");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		cityRadar.mouseHoverOnRadarAndMaps();
		cityRadar.isRadarSubMenuDisplayed();
		cityRadar.navigateToRadar();
		String actualColor = cityRadar.verifyToolTipClosed();
		try {
			Assert.assertEquals(expectedTooltipColor, actualColor);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 24,enabled = false)
	public void RW_T253_CityRadarPage_verifyNavigationMenusOnCityForecastPage() {
		testStart("Verify navigation menus on city forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		Assert.assertTrue(cityRadar.verifyPresenceOfNavigationMenus());
	}

	@Test(priority = 25,enabled = false)
	public void RW_T253_CityRadarPage__clickRadarTab() {
		testStart("Click on the Radar on city forecast page and verify the user is navigated to radar page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		defaultWindowid = getDriver().getWindowHandle();
		cityRadar.clickRadarNavigationMenu();
		cityRadar.switchToPopUpWindow(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedRadarPage_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
}
