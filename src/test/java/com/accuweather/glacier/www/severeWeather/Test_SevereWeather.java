package com.accuweather.glacier.www.severeWeather;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.SevereWeatherPage;

public class Test_SevereWeather extends AccuWeatherBaseTest
{
	private final static String ZIPCODE = "48073";
	private final static String EXPECTEDSEVEREWEATHERPAGE_URL = "https://qualityassurance.accuweather.com/en/us/severe-weather";
	private final static String EXPECTEDTOOLTIP_COLOR = "#f59721";
	private final static String EXPECTEDTOOLTIP_DESCRIPTION = "The severe weather map provides you with weather watches & warnings for your area so you can prepare for what’s ahead.";
	private final static String EXPECTEDMAPHEADER_TITLE = "United States Severe Weather Map";
	private final static String EXPECTEDCLOSEDTOOLTIP_COLOR = "#878787";
	private final static String EXPECTEDSEVERETAB_COLOR = "#f05514";
	
	private NavigationBar navBar = new NavigationBar();
	private CityRadarPage cityRadarPage = new CityRadarPage();
	private LandingPage landingPage = new LandingPage();
	private SevereWeatherPage severeWeatherPage = new SevereWeatherPage();
//	
//	@Test(priority=1)
//	public void RW_T502_ValidateTabsOnSevereWeatherPage_verifyUserIsTakenToSevereWeatherPage()
//	{
//		testStart("Validate user is taken to severe weatehr page");
//		navBar.mouseHoverOnSeverWeather();
//		navBar.isSeverWeatherSubMenuDisplayed();
//		navBar.clickSeverWeatherSubMenu();
//		String actualSevereWeatherPageUrl = getDriver().getCurrentUrl();
//		try
//		{
//			Assert.assertEquals(actualSevereWeatherPageUrl, EXPECTEDSEVEREWEATHERPAGE_URL);
//		}
//		catch (AssertionError ae)
//		{
//			System.out.println(ae.getMessage());
//		}
//	}
//	
//	@Test(priority=2)
//	public void RW_T502_ValidateTabsOnSevereWeatherPage_verifyTabsOnSevereWeatherPage()
//	{
//		testStart("Validate 3 tabs (Hurricane, severe, accuweather ready) on severe weatehr page");
//		navBar.mouseHoverOnSeverWeather();
//		navBar.isSeverWeatherSubMenuDisplayed();
//		navBar.isHurricaneSubMenuDisplayed();
//		navBar.isAWReadySubMenuDisplayed();
//	}
//	
//	@Test(priority=3)
//	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyTooltipHighlightedInOrangeColor()
//	{
//		testStart("Verify tooltip is orange in color");
//	    landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//		navBar.isSeverWeatherSubMenuDisplayed();
//		navBar.clickSeverWeatherSubMenu();
//		String actualColor = cityRadarPage.verifyTootipBackgroundColor();
//		try
//		{
//			Assert.assertEquals(EXPECTEDTOOLTIP_COLOR, actualColor);
//		}
//		catch(AssertionError ae)
//		{
//			System.err.println(ae.getMessage());
//			Assert.fail();
//		}
//	}
//	
//	@Test(priority=3)
//	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyTooltipDescription()
//	{
//		testStart("Verify tooltip description");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//	    navBar.isSeverWeatherSubMenuDisplayed();
//	    navBar.clickSeverWeatherSubMenu();
//		String actualDescription = cityRadarPage.verifyTooltipDescription();
//		try
//		{
//			Assert.assertEquals(EXPECTEDTOOLTIP_DESCRIPTION, actualDescription);
//		}
//		catch(AssertionError ae)
//		{
//			System.err.println(ae.getMessage());
//			Assert.fail();
//		}
//	}	
//	
//	@Test(priority=3)
//	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyZoomInAndZoomOutofMap()
//	{
//		testStart("Verify able to click zoom in and zoom out of the map");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//	    navBar.isSeverWeatherSubMenuDisplayed();
//	    navBar.clickSeverWeatherSubMenu();
//		cityRadarPage.clickZoomInAndZoomOut();
//		
//	}	
//	
//	@Test(priority=4)
//	public void RW_T381_TooltipAndZoomControlsOnRightCornerOfMap_verifyToolTipClosed()
//	{
//		testStart("Verify on click of tooltip again, the tooltip closes");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//        navBar.isSeverWeatherSubMenuDisplayed();
//        navBar.clickSeverWeatherSubMenu();
//		String actualColor = cityRadarPage.verifyToolTipClosed();
//		try
//		{
//			Assert.assertEquals(EXPECTEDCLOSEDTOOLTIP_COLOR, actualColor);
//		}
//		catch(AssertionError ae)
//		{
//			System.err.println(ae.getMessage());
//			Assert.fail();
//		}
//	}
//	
	@Test(priority=5)
	public void RW_T380_TitleOfMapForSevereWeather_verifyMapHeaderForSevereWeather()
	{
		testStart("Verify title of map for severe weather");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		navBar.mouseHoverOnSeverWeather();
        navBar.isSeverWeatherSubMenuDisplayed();
        navBar.clickSeverWeatherSubMenu();
		String actualHeader = cityRadarPage.getMapHeader();
		try
		{
			Assert.assertEquals(EXPECTEDMAPHEADER_TITLE, actualHeader);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}	}
//	
//	@Test(priority=6)
//	public void RW_T379_TitleOfMapForSevereWeather_verifySecondaryNavigationMenusAboveMap()
//	{
//		testStart("Verify secondary navigation menus [hurricane, severe] displayed above the map");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//        navBar.isSeverWeatherSubMenuDisplayed();
//        navBar.clickSeverWeatherSubMenu();
//        severeWeatherPage.verifySecondaryNavigationMenus();
//	}	
//	
//	@Test(priority=7)
//	public void RW_T379_TitleOfMapForSevereWeather_verifySevereTabHiglightedColor()
//	{
//		testStart("Verify severe tab highlighted in color");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//        navBar.isSeverWeatherSubMenuDisplayed();
//        navBar.clickSeverWeatherSubMenu();
//        String actualColor = severeWeatherPage.verifySevereTabHiglightedColor();
//        try
//		{
//			Assert.assertEquals(EXPECTEDSEVERETAB_COLOR, actualColor);
//		}
//		catch(AssertionError ae)
//		{
//			System.err.println(ae.getMessage());
//				Assert.fail();
//		}
//        
//	}	
//	
//	@Test(priority=8)
//	public void RW_T382_MapboxAttribution_locateMapboxAndClickInextToit()
//	{
//		testStart("Verify mapbox and click i next to mapbox");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//        navBar.isSeverWeatherSubMenuDisplayed();
//        navBar.clickSeverWeatherSubMenu();
//        severeWeatherPage.locateMapboxAndClickInextToit();
//	}	
//
//	@Test(priority=8)
//	public void RW_T382_MapboxAttribution_clickFullScreenButton()
//	{
//		testStart("Verify Map opens up into full screen with zoom controls if you click on x symbol the map switches back to normal");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		navBar.mouseHoverOnSeverWeather();
//        navBar.isSeverWeatherSubMenuDisplayed();
//        navBar.clickSeverWeatherSubMenu();
//        severeWeatherPage.clickFullScreenButtonOfMap();
//	}	
//}