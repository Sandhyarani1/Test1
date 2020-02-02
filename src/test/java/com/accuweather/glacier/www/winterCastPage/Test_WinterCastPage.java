package com.accuweather.glacier.www.winterCastPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.UniversalFooterPage;
import com.accuweather.glacier.www.pages.WinterCastPage;
import com.accuweather.glacier.www.pages.WinterWeatherPage;
import com.chameleon.utils.Sleeper;

public class Test_WinterCastPage extends AccuWeatherBaseTest 
{
	private String EXPECTED_WINTERWEATHER_URL = "https://qualityassurance.accuweather.com/en/us/winter-weather";
	private String EXPECTED_MAP_TITLE = "NATIONAL WEATHER SERVICE - SNOW DEPTH";
	private String EXPECTED_NATIONAL_FORECAST_MAP_TITLE = "NATIONAL 24-HOUR SNOWFALL FORECAST MAP";
	private String EXPECTED_LOCAL_FORECAST_MAP_TITLE = "LOCAL FORECAST MAPS";
	private String EXPECTED_COLOR = "#2cabdc";
	private String EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION = "Provides winter weather forecasts and the winter weather outlook for your area";
	private String LOCATION = "Alpena, MI";
	private String EXPECTED_TOOTLTIP_CONTENT_COLOR = "OUR FORECASTED SNOWFALL ACCUMULATION FEATURE DISPLAYS A GRAPH OF SNOWFALL ACCUMULATION OVER TIME FOR THE CURRENT OR UPCOMING SNOW EVENT FOR YOUR LOCATION. THE DEPTH VALUE AT ANY POINT WITHIN THE GRAPH REPRESENTS HOW MUCH NEW SNOW IS PREDICTED TO BE ON THE GROUND AT THAT HOUR.|#1f1f1f";
	private LandingPage landingPage = new LandingPage();
	private WinterCastPage winterCastPage = new WinterCastPage();
	private UniversalFooterPage universalFooterPage = new UniversalFooterPage();
	
	@Test(priority=1)
	public void RW_T1706_RightRailTodayLifestyleForecastModuleOnWinterCastTab_verifyLifestyleIndexForecastsDisplayed()
	{
		testStart("Right Rail TODAY'S LIFESTYLE FORECAST module on WinterCast tab");
		landingPage.enterZipcodeInSearchFieldAndClick("Denver, CO");
		winterCastPage.clickWinterCastTab();
		winterCastPage.verifyRightRailLifestyleForecast();
	}
	
	@Test(priority=1)
	public void RW_T1707_SnowfallAccumulationModuleVerifyToolTipIconAndTitleDisplayInBlue_verifyTooltipIconAndTitleDisplayInBlue()
	{
		testStart("Snowfall Accumulation module - Verify the Tool Tip icon and the Title should display in blue");
		landingPage.enterZipcodeInSearchFieldAndClick("Denver, CO, US");
		winterCastPage.clickWinterCastTab();
		String actualColor = winterCastPage.verifySnowfallAccumulationAndTooltipIconPresentAndTooltipHeaderInBlue();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}
	
	@Test(priority=1)
	public void RW_T1708_SnowfallAmountProbabilityerifyToolTipIconAndTitleDisplayInBlue_verifyTooltipIconAndTitleDisplayInBlue()
	{
		testStart("Snowfall Accumulation module - Verify the Tool Tip icon and the Title should display in blue");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		String actualColor = winterCastPage.verifySnowfallAmountProbabilityAndTooltipIconPresentAndTooltipHeaderInBlue();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}
	
	
	@Test(priority=1)
	public void RW_T1695_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModule()
	{
		testStart("Verify read more button is present in right rail module");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		Assert.assertTrue(winterCastPage.verifyReadMoreButtonPresntInRightRailModule());
	}
	
	@Test(priority=1)
	public void RW_T1633_SnowfallAccumulationModuleTertiaryNavigation_verifyTertiaryNavigationMenuPresent()
	{
		testStart("Verify the title and presence of Tertiary Navigation menu on the WinterCast page");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		Assert.assertTrue(winterCastPage.verifyTertiaryNavigationMenuPresent());
	}
	
	@Test(priority=1)
	public void RW_T1661_ValidateWintercastTabLocatedBesideNOWTab_verifyWinterCastTabIsBesideNowTab()
	{
		testStart("Validating the WINTERCAST tab is located beside the NOW tab");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		Assert.assertTrue(winterCastPage.verifyWinterCastTabIsBesideNowTab());
	}
	
	@Test(priority=1)
	public void RW_T1641_SnowfallAccumulationModuleToolTip_verifyColorPickerForSpanText()
	{
		testStart("Verify the verify the color picker for the time span text of snowfall accumulation");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		winterCastPage.verifyColorPickerForSpanText();
	}

	@Test(priority=1)
	public void RW_T1641_SnowfallAccumulationModuleToolTip_verifySnowfallAccumulationTooltipDescriptionAndColor()
	{
		testStart("Verify snowfall accumulation tooltip descritpion and color");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		String actualTootltipContentAndColor = winterCastPage.verifySnowfallAccumulationTooltipDescriptionAndColor();
		System.out.println("getext:"+actualTootltipContentAndColor);
		Assert.assertEquals(actualTootltipContentAndColor, EXPECTED_TOOTLTIP_CONTENT_COLOR);
	}
	
	@Test(priority=1)
	public void RW_T1641_SnowfallAccumulationModuleToolTip_verifyTooltipRevertBackToPreviousState()
	{
		testStart("Verify tooltip content and color");
		landingPage.enterZipcodeInSearchFieldAndClick(LOCATION);
		winterCastPage.clickWinterCastTab();
		Assert.assertTrue(winterCastPage.verifyTooltipRevertBackToPreviousState());
	}
}