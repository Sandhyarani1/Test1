package com.accuweather.glacier.m.forecastMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.m.pages.ForeCastWeatherIOS;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_ForecastMapIOS extends AccuWeatherBaseTest {
	private final static String ZIPCODE = "53558";
	private final static String EXPECTED_FORECAST_PAGE_URL = "https://qualityassurance.accuweather.com/en/us/national/weather-forecast-maps";
	private final static String EXPECTED_FORECAST_TAB_COLOR = "#f05514";
	private final static String EXPECTED_TOOLTIP_COLOR = "#878787";
	private final static String EXPECTED_MAP_TITLE = "5-Day Precipitation Outlook";
	private final static String EXPECTED_ICE_LEGEND_COLOR = "#9b1682";
	private final static String EXPECTED_MIX_LEGEND_COLOR = "#e67db4";
	private final static String EXPECTED_TOOLTIP_DESCRIPTION = "Our 5-Day Precipitation Outlook feature displays an interactive map prediction of upcoming rain, snow, ice, and mixed precipitation over time for day/night periods within the next 5 days. Rainfall and snowfall zones are further refined into light, moderate, and heavy regions";

	private ForeCastWeatherIOS foreCastWeatherPage = new ForeCastWeatherIOS();
	private LandingPageMobile landingPage = new LandingPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T1380_WeatherForecastMapsPage_verifyWeatherForecastMapsPageLoads() {
		testStart("Validate weather forecast maps page loads successfully");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualForecastURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualForecastURL, EXPECTED_FORECAST_PAGE_URL);
	}

	@Test(priority = 2, enabled = true)
	public void RW_T397_ForecastTabHighlightedOnForecasrPage_verifyForecastTabIsHighlighted() {
		testStart("Validate forecast tab is highlighted in froecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualcolor = foreCastWeatherPage.verifyForecastTabIsHiglighted();
		Assert.assertEquals(actualcolor, EXPECTED_FORECAST_TAB_COLOR);
	}

	@Test(priority = 3, enabled = true)
	public void RW_T1378_TitleOfTheMapOnForecastPage_verifyTitleOfTheMap() {
		testStart("Validate title of the map on froecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualTitleOfMap = foreCastWeatherPage.verifyTitleOfTheMap();
		Assert.assertEquals(actualTitleOfMap, EXPECTED_MAP_TITLE.toUpperCase());
	}

	@Test(priority = 4, enabled = true)
	public void RW_T399_ToolTipOnRightCornerOfMapHeader_verifyToolTip() {
		testStart("Verify tool tip on the right corner of the map header");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualTooltipDescription = foreCastWeatherPage.verifyTooltipDescription();
		Assert.assertEquals(actualTooltipDescription, EXPECTED_TOOLTIP_DESCRIPTION.toUpperCase());
	}

	@Test(priority = 5, enabled = true)
	public void RW_T1377_ToolTipOnRightCornerOfMapHeader_verifyToolTipClosed() {
		testStart("Verify tool tip is closed");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualTooltipColor = foreCastWeatherPage.verifyToolTipClosed();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOLTIP_COLOR);
	}

	@Test(priority = 6, enabled = false)
	public void RW_T1375_ZoomControlsOnLeftCornerOfMap_verifyZoomcontrolsButton() {
		testStart("Verify zoom in and zoom out button");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.clickZoomInAndZoomOut());
	}

	@Test(priority = 7, enabled = false)
	public void RW_T1373_FullScreenOnRightCornerOfMap_verifyFullScreenButton() {
		testStart("Verify fullscreen button on the map");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.clickFullScreenButtonOfMap());
	}

	@Test(priority = 8, enabled = false)
	public void RW_T1374_ValidateMapboxAttributes_verifyMapboxAndiPresent() {
		testStart("Verify mapbox present on the screen and i displayed next to it");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyMapboxAndiNextToIt());
	}

	@Test(priority = 9, enabled = false)
	public void RW_T1372_AddSliderWithPlayButton_verifyPresenceOfSliderBarWithPlayButtonAndTime() {
		testStart("Verify presence of slider button");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyPresenceOfSliderBarWithPlayButtonAndTime());
	}

	@Test(priority = 10, enabled = false)
	public void RW_T1372_AddSliderWithPlayButton_verifyCurrentDateAtTheEndOfSliderBar() {
		testStart("Verify current date at the end of slide bar");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyCurrentDateAtTheEndOfSliderBar());
	}

	@Test(priority = 11, enabled = false)
	public void RW_T1371_ValidateRainLegends_verifyLightModerateHeavyFromRainLegend() {
		testStart("Verify light moderate heavy are in order");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLightModerateHeavyFromRainLegend());

	}

	@Test(priority = 12, enabled = false)
	public void RW_T1371_ValidateRainLegends_verifyLegendsForRainHaveTextRain() {
		testStart("Legends for Rain should have text Rain in the center of the bar");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLegendsForRainHaveTextRain());

	}

	@Test(priority = 13, enabled = false)
	public void RW_T1369_ValidateSnowLegends_verifyLightModerateHeavyFromSnowLegend() {
		testStart("Verify light moderate heavy from snow are in order");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLightModerateHeavyFromSnowLegend());

	}

	@Test(priority = 14, enabled = false)
	public void RW_T1369_ValidateSnowLegends_verifyLegendsForSnowHaveTextSnow() {
		testStart("Legends for Snow should have text Snow in the center of the bar");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLegendsForSnowHaveTextSnow());

	}

	@Test(priority = 15, enabled = false)
	public void RW_T1368_ValidateIceLegends_verifyLegendsForIceHaveTextIce() {
		testStart("Legends for Ice should have text Ice in the center of the bar");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLegendsForIceHaveTextIce());
	}

	@Test(priority = 16, enabled = false)
	public void RW_T1367_ValidateIceLegends_verifyIceLegendBarColor() {
		testStart("Verify legend bar is purple in color");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualLegendBarcolor = foreCastWeatherPage.verifyIceLegendBarColor();
		Assert.assertEquals(actualLegendBarcolor, EXPECTED_ICE_LEGEND_COLOR);
	}

	@Test(priority = 17, enabled = false)
	public void RW_T1367_ValidateMixLegends_verifyLegendsForMixHaveTextMix() {
		testStart("Legends for Mix should have text Mix in the center of the bar");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		Assert.assertTrue(foreCastWeatherPage.verifyLegendsForMixHaveTextMix());

	}

	@Test(priority = 18, enabled = false)
	public void RW_T1367_ValidateMixLegends_verifyMixLegendBarColor() {
		testStart("Verify mix legend bar is purple in color");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		foreCastWeatherPage.clickBreadCrumbMenu();
		foreCastWeatherPage.clickBreadCrumbMenuRadarAndMaps();
		foreCastWeatherPage.clickBreadCrumbSubmenuForecast();
		String actualLegendBarcolor = foreCastWeatherPage.verifyMixLegendBarColor();
		Assert.assertEquals(actualLegendBarcolor, EXPECTED_MIX_LEGEND_COLOR);
	}

}
