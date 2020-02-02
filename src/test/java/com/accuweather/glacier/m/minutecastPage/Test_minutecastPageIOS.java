package com.accuweather.glacier.m.minutecastPage;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.MinutecastMobile;
import com.chameleon.utils.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_minutecastPageIOS extends AccuWeatherMobileBaseTest
{
    String citySearchedByName="Chicago";
	
	String EXPECTED_MINIUTECAST_PAGETITLE="https://qualityassurance.accuweather.com/en/us/chicago/60608/weather-forecast/348308";
	String ExpectedPageTitle="Chicago, IL MinuteCast(R) Weather | AccuWeather";

	private static final String EXPECTED_TOOLTIP_TEXT="Weather radar map shows the location of precipitation, its type (rain, snow, and ice) and its recent movement to help you plan your day.";	
//	private static final  String EXPECTED_MINIUTECAST_PAGETITLE="Chicago, IL MinuteCast(R) Weather | AccuWeather";
	
	private static final String ORANGE_COLOR="#f59721";
	private static final String expectedTabcolor="#f05514";
	private static final String EXPECTED_MINUTECASTTAB_COLOR = "#f05514";
	private static final String TIMESTAMP_CURRENT_TTIME_inORANGECOLOR="#f05514";
	private static final String EXPECTED_RADAR_MAP_TITLE= "Chicago Weather Radar";
	private static final int EXPECTED_TIME_DIFFERENCE_inMINS=1800;
	private static final String EXPECTED_FUTURE_CTA_COLOR = "#e8e8e8";
	private static final String EXPECTED_PASTCTA_COLOR = "#f59721";
	String expectedMapbox_URL = "https://www.mapbox.com/about/maps/";
	String expectedRadarPage_URL = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/weather-radar/20813_pc";
	String expectedOpenStreetMap_URL = "https://www.openstreetmap.org/about/";
	String expectedImproveThisMap_URL = "https://apps.mapbox.com/feedback/?owner=accuweather-inc-dev&id=cjfvtyj1h0e4p2rp95falted1&access_token=pk.eyJ1IjoiYWNjdXdlYXRoZXItaW5jLWRldiIsImEiOiJjanBpaXB1ZmgxNzU0M3dwZDd2dTVkYmFpIn0.IZ_I_4zFPzzc-VdC_d5JXg";

	
	
	
	MinutecastMobile minutecast =new MinutecastMobile();
	
	
	
	@Test(priority=1,enabled=true)
	public void TC_RW_T831_navigateToCityForecastPage_Valdiate_Secondary_Navigationmenus_Displayed() 
	{
		testStart("Navigation to City Forecast page validate secondary naviagtion menus Displayed ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(minutecast.validateSecondaryMenusDisplayed());
	}
	
	@Test(priority=2,enabled=true)
	public void TC_RW_T831_navigateToMinutecastForecastPage_Validate_MinutecastPageTitle() 
	{
		testStart("Navigation to Minutecast page from city forecast page ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
     	Assert.assertEquals(getDriver().getTitle(), ExpectedPageTitle);
	}
	

	
	@Test(priority=4,enabled=true)
	public void TC_RW_T831_Navigate_toMinutecastpage__validatingMinutecastDialhasLargeWeatherDescriptionDisplayed() 
	{
		testStart("Validate Minutecast page Displayed with Large WeatherDescription ");
		minutecast.searchCityByName(citySearchedByName);
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(8);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertNotNull(minutecast.minutecastDialLargeWeatherDescriptionDisplayed());
	}
	
	@Test(priority=5,enabled=true)
	public void TC_RW_T831_Navigate_toMinutecastpage_validatingMinutecastDialhasTimeStampDisplayed() 
	{
		testStart("Validating Minutecast  Dial has large weather Description on the top of the molecule .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(8);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertNotNull(minutecast.minutecastDialTimestampDisplayed());
	}
	
	
	@Test(priority=6,enabled=false)
	public void TC_RW_T831_Navigate_toMinutecastpage_validatingMinutecastDialhasWeathericonDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Weather icon displayed on the middle of the Dial .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(8);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertTrue(minutecast.minutecastDialWeathericonDisplayed());
		
	}
	
	@Test(priority=7,enabled=false)
	public void TC_RW_T831_Navigate_toMinutecastpage_validatingMinutecastDialhasShortweatherDescriptionDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Short weather Description below the weather icon .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(8);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertNotNull(minutecast.minutecastDialshortWeatherDescriptionDisplayed());
	}
	
	@Test(priority=8,enabled=false)
	public void TC_RW_T831_Navigate_toMinutecastpage_validatingMinutecastDialhasUpdatedTimeDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Updated Time displayed  at the bottom right corner of the Dial.");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(8);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertNotNull(minutecast.minutecastDialhasUpdatedTimeDisplayed());
	}
	
	
	@Test(priority=9,enabled=false)
	public void TC_RW_T832_validatingMinutecastpagehasRadarMapdisplayed() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map Displayed on the page  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertTrue(minutecast.radarMapDisplayed());
	}

	@Test(priority=10,enabled=false)
	public void RW_TC832_validatingMinutecastRadarMapTitle() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map title  Displayed on the page  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(4);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		Assert.assertTrue(minutecast.radarMapTitle().equalsIgnoreCase(EXPECTED_RADAR_MAP_TITLE));
	}
	
	@Test(priority=11,enabled=false)
	public void RW_TC832_validatingMinutecastRadarMapZoomfunctionality() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Zoomin and Zoomout  Functionality on the Map");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(4);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		minutecast.zoominControls();
		Sleeper.sleep(4);
		minutecast.zoomoutControls();		
	}
	
		
	
	@Test(priority=12,enabled=false)
	public void RW_TC833_validatingMinutecastRadarMapTooltipText() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Tooltip title displayed");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		Sleeper.sleep(3);
		String actualText=minutecast.tooltipTextDisplayed();
		System.out.println("Tool tip text displayed is "+actualText);
		Assert.assertTrue(actualText.equalsIgnoreCase(EXPECTED_TOOLTIP_TEXT));
	}
	
	
	@Test(priority=13,enabled=false)
	public void RW_TC833_validatingMinutecastRadarMapTooltipcloseswhenclickedTwice() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Tooltip Closes when clicked twice");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		minutecast.clickonTooltip();
		Sleeper.sleep(3);
		minutecast.clickonTooltip();
		Sleeper.sleep(2);
	}
	
	
	@Test(priority=14 ,enabled=false)
	public void RW_TC836_validatingTimestampMoleculesDisplayed() 
	{
		testStart("Navigate to Minutecast forecast page and validating Timestamp Molecule displayed below radar map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(minutecast.timestampMolecuesDisplayed());
	}
	
	@Test(priority=15 ,enabled=false)
	public void RW_TC836_validatingTimestampMoleculeCurrentTimeDisplayedinOrange() 
	{
		testStart("Navigate to Minutecast forecast page and validating Timestamp Molecule displayed ad Current Time Highligted in Orange");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		minutecast.timestampMolecuesDisplayed();
		Assert.assertEquals(minutecast.timestampCurrentTimeinOrange(), TIMESTAMP_CURRENT_TTIME_inORANGECOLOR);
	}  
	
	
	@Test(priority=16 ,enabled=false)
	public void RW_TC836_validatingTimestampMoleculeDisplayedbelowRadarmap()  
	{
		testStart("Navigate to Minutecast forecast page and validating Timestamp Molecule displayed for 30 minutes interval for one and half hour duration ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.timestampMolecuesDisplayed());
		
		long difference=minutecast.timeSlotsDisplayed();
		System.out.println("Time Difference is "+difference/(1000*3));
		Assert.assertEquals(difference/(1000*3), EXPECTED_TIME_DIFFERENCE_inMINS);
	}
	
	@Test(priority=17 ,enabled=false)
	public void RW_TC836_ClickingonEachTimestampMolecule() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Timestamp Molecule displayed below radar map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		minutecast.timestampMolecuesDisplayed();
		minutecast.clickonEachtimestampMolecule();
	}
	
	
	
	@Test(priority=18 ,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendRain_displayedwithText_LightandSevere() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.RainlegendtextLightandSevereDisplayed());
	}
	
	@Test(priority=19,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendSnow_displayedwithText_LightandSevere() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.legendSnowDisplayedwithTextLightandSevere());
	}
	
	@Test(priority=20,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendIce_displayedwithText_LightandSevere() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.legendIceDisplayedwithTextLightandSevere());
	}
	
	@Test(priority=21,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendMix_displayedwithText_LightandSevere() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.legendMixDisplayedwithTextLightandSevere());
	}
	
	
	@Test(priority=22,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendRain_Displayed_withVariousColors() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
	    minutecast.legendRaincoloursdisplayed();
	}
	
	@Test(priority=23,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendSnow_Displayed_withVariousColors() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
	    minutecast.legendSnowcoloursdisplayed();
	}
	
	@Test(priority=24,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendICE_Displayed_withVariousColors() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
	    minutecast.legendIcecoloursdisplayed();
	}
	
	@Test(priority=25,enabled=false)
	public void RW_TC1562_Navigating_toMinutecastpage_validating_LegendMIX_Displayed_withVariousColors() 
	{
		testStart("Navigate to Minutecast forecast page and validating Legend Rain Displayed withText LightandSevere ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
	    minutecast.legendMixcoloursdisplayed();
	}
	
	
	@Test(priority=26,enabled=false)
	public void RW_TC1563_validatingPastandFutureCTADisplayed() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating map timelincontrols function PAST and FUTURE CTA ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.verifyPastAndFutureCTABelowMap());	
	}
	
	@Test(priority=27,enabled=false)
	public void RW_TC1563_Validate_Timeline_controls_PastandFuture_CTA_displayed_on_RadarMap() {
		testStart("Validate Timeline controls with play button  displayed on RadarMap");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.timelinecontrolsdisplayedonRadarMap());
	} 

	@Test(priority=28,enabled=false)
	public void RW_TC1563_Validate_presence_Timesliderbar_WithPlayButton_displayed_on_RadarMap() {
		testStart("Validate Timeline controls with play button  displayed on RadarMap");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.verifyPresenceOfSliderBarWithPlayButtonAndTime());
	} 



	@Test(priority=29,enabled=false)
	public void RW_TC1563_Toggle_between_Past_andFuture_CTA_onNational_RadarMap() {
		testStart("Validate Past andFuture CTA displayed on National  Weather Radar Map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.toggleBetweenPastAndFutureCTA());
	} 

	@Test(priority=30,enabled=false)
	public void RW_TC1563_Validate_Fullscreen_Radarmap_Displayed_Timeslider_Playbutton() {
		testStart("Validate Past andFuture CTA displayed on National  Weather Radar Map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.clickingonFullScreenButtonValidtaingFunctions());
	} 

	
	
	@Test(priority=31,enabled= false)
	public void RW_T259_MapboxAttribution_clickMapbox() {
		testStart("Click on the mapbox and verify the user is navigated to mapbox URL");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		String defaultWindowid = getDriver().getWindowHandle();
		minutecast.clickMapbox();
		minutecast.switchToDifferentTab(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedMapbox_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	} 

	@Test(priority=32,enabled= false)
	public void RW_T259_MapboxAttribution_clickOpenStreetMap() {
		testStart("Click on the openstreetmap and verify the user is navigated to openstreet map URL");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		String defaultWindowid = getDriver().getWindowHandle();
		minutecast.clickOpenStreetMap();
		minutecast.switchToDifferentTab(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedOpenStreetMap_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	} 

	@Test(priority=33,enabled= false)
	public void RW_T259_MapboxAttribution_clickImproveThisMap() {
		testStart("Click on the improvethis map and verify the user is navigated to improve this map URL");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		minutecast.isNavigationtoMinutecastpage();
		Sleeper.sleep(4);
		waitUntilWindowExistsWithTitle(EXPECTED_MINIUTECAST_PAGETITLE);
		minutecast.scrolldownpage();
		String defaultWindowid = getDriver().getWindowHandle();
		minutecast.clickImproveThisMap();
		minutecast.switchToDifferentTab(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedImproveThisMap_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
	
}




