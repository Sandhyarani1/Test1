package com.accuweather.glacier.www.forecastMap;

import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.NavigationBar;

import junit.framework.Assert;

public class Test_ForecastMap extends AccuWeatherBaseTest {
	private final static String ZIPCODE = "53558";
	private final static String EXPECTED_FORECAST_PAGE_URL = "https://qualityassurance.accuweather.com/en/us/national/weather-forecast-maps";
	private final static String EXPECTED_FORECAST_TAB_COLOR = "#f05514";
	private final static String EXPECTED_TOOLTIP_COLOR = "#1f1f1f";
	private final static String EXPECTED_MAP_TITLE = "5-Day Precipitation Outlook";
	private final static String EXPECTED_ICE_LEGEND_COLOR = "#9b1682";
	private final static String EXPECTED_MIX_LEGEND_COLOR = "#e67db4";
	private final static String EXPECTED_TOOLTIP_DESCRIPTION = "Our 5-Day Precipitation Outlook feature displays an interactive map prediction of upcoming rain, snow, ice, and mixed precipitation over time for day/night periods within the next 5 days. Rainfall and snowfall zones are further refined into light, moderate, and heavy regions";
	
	private CityRadarPage cityRadarPage = new CityRadarPage();
	private NavigationBar navigationBar = new NavigationBar();
    private ForeCastWeatherPage foreCastWeatherPage = new ForeCastWeatherPage();
	
	@Test(priority=1)
	public void RW_T396_WeatherForecastMapsPage_verifyWeatherForecastMapsPageLoads()
	{
		testStart("Validate weather forecast maps page loads successfully");
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isForecastMapsSubMenuDisplayed();
		navigationBar.navigateToForeCastPage();
		String actualForecastURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualForecastURL, EXPECTED_FORECAST_PAGE_URL);
	}
	
	@Test(priority=2)
	public void RW_T397_ForecastTabHighlightedOnForecasrPage_verifyForecastTabIsHighlighted()
	{
		testStart("Validate forecast tab is highlighted in froecast page");
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isForecastMapsSubMenuDisplayed();
		navigationBar.navigateToForeCastPage();
		String actualcolor = foreCastWeatherPage.verifyForecastTabIsHiglighted();
		Assert.assertEquals(actualcolor, EXPECTED_FORECAST_TAB_COLOR);
	}
    
    @Test(priority=3)
	public void RW_T398_TitleOfTheMapOnForecastPage_verifyTitleOfTheMap()
	{
		testStart("Validate title of the map on froecast page");
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isForecastMapsSubMenuDisplayed();
		navigationBar.navigateToForeCastPage();
		String actualTitleOfMap = foreCastWeatherPage.verifyTitleOfTheMap();
		Assert.assertEquals(actualTitleOfMap, EXPECTED_MAP_TITLE.toUpperCase());
	}

    @Test(priority=4)
 	public void RW_T399_ToolTipOnRightCornerOfMapHeader_verifyToolTip()
 	{
 		testStart("Verify tool tip on the right corner of the map header");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		String actualTooltipDescription = cityRadarPage.verifyTooltipDescription();
 		Assert.assertEquals(actualTooltipDescription, EXPECTED_TOOLTIP_DESCRIPTION.toUpperCase());
 	}


    @Test(priority=5)
 	public void RW_T399_ToolTipOnRightCornerOfMapHeader_verifyToolTipClosed()
 	{
 		testStart("Verify tool tip is closed");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		String actualTooltipColor = cityRadarPage.verifyToolTipClosed();
 		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOLTIP_COLOR);
 	}
    
    @Test(priority=6)
 	public void RW_T401_ZoomControlsOnLeftCornerOfMap_verifyZoomcontrolsButton()
 	{
 		testStart("Verify zoom in and zoom out button");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		cityRadarPage.clickZoomInAndZoomOut();
 	}

    @Test(priority=7)
 	public void RW_T403_FullScreenOnRightCornerOfMap_verifyFullScreenButton()
 	{
 		testStart("Verify fullscreen button on the map");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		foreCastWeatherPage.clickFullScreenButtonOfMap();
 	}
    
    @Test(priority=8)
 	public void RW_T402_ValidateMapboxAttributes_verifyMapboxAndiPresent()
 	{
 		testStart("Verify mapbox present on the screen and i displayed next to it");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		foreCastWeatherPage.verifyMapboxAndiNextToIt();
 	}
    
    @Test(priority=9)
 	public void RW_T404_AddSliderWithPlayButton_verifyPresenceOfSliderBarWithPlayButtonAndTime()
 	{
 		testStart("Verify presence of slider button");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		foreCastWeatherPage.verifyPresenceOfSliderBarWithPlayButtonAndTime();
 	}
    
  @Test(priority=10)
	public void RW_T404_AddSliderWithPlayButton_verifyCurrentDateAtTheEndOfSliderBar()
	{
		testStart("Verify current date at the end of slide bar");
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isForecastMapsSubMenuDisplayed();
		navigationBar.navigateToForeCastPage();
		foreCastWeatherPage.verifyCurrentDateAtTheEndOfSliderBar();
	}
     
    @Test(priority=11)
  	public void RW_T405_ValidateRainLegends_verifyLightModerateHeavyFromRainLegend()
  	{
  		testStart("Verify light moderate heavy are in order");
  		navigationBar.mouseHoverOnRadarAndMaps();
  		navigationBar.isForecastMapsSubMenuDisplayed();
  		navigationBar.navigateToForeCastPage();
  		foreCastWeatherPage.verifyLightModerateHeavyFromRainLegend();
  	}
    
    @Test(priority=12)
  	public void RW_T405_ValidateRainLegends_verifyLegendsForRainHaveTextRain()
  	{
  		testStart("Legends for Rain should have text Rain in the center of the bar");
  		navigationBar.mouseHoverOnRadarAndMaps();
  		navigationBar.isForecastMapsSubMenuDisplayed();
  		navigationBar.navigateToForeCastPage();
  		foreCastWeatherPage.verifyLegendsForRainHaveTextRain();
  	}
    
    @Test(priority=13)
	public void RW_T406_ValidateSnowLegends_verifyLightModerateHeavyFromSnowLegend()
	{
		testStart("Verify light moderate heavy from snow are in order");
		navigationBar.mouseHoverOnRadarAndMaps();
		navigationBar.isForecastMapsSubMenuDisplayed();
		navigationBar.navigateToForeCastPage();
		foreCastWeatherPage.verifyLightModerateHeavyFromSnowLegend();
	}
   
    @Test(priority=14)
   	public void RW_T406_ValidateSnowLegends_verifyLegendsForSnowHaveTextSnow()
   	{
   		testStart("Legends for Snow should have text Snow in the center of the bar");
   		navigationBar.mouseHoverOnRadarAndMaps();
   		navigationBar.isForecastMapsSubMenuDisplayed();
   		navigationBar.navigateToForeCastPage();
   		foreCastWeatherPage.verifyLegendsForSnowHaveTextSnow();
   	}
   
    @Test(priority=15)
   	public void RW_T407_ValidateIceLegends_verifyLegendsForIceHaveTextIce()
   	{
   		testStart("Legends for Ice should have text Ice in the center of the bar");
   		navigationBar.mouseHoverOnRadarAndMaps();
   		navigationBar.isForecastMapsSubMenuDisplayed();
   		navigationBar.navigateToForeCastPage();
   		foreCastWeatherPage.verifyLegendsForIceHaveTextIce();
   	}
    
    @Test(priority=16)
   	public void RW_T407_ValidateIceLegends_verifyIceLegendBarColor()
   	{
   		testStart("Verify legend bar is purple in color");
   		navigationBar.mouseHoverOnRadarAndMaps();
   		navigationBar.isForecastMapsSubMenuDisplayed();
   		navigationBar.navigateToForeCastPage();
   		String actualLegendBarcolor = foreCastWeatherPage.verifyIceLegendBarColor();
   		Assert.assertEquals(actualLegendBarcolor, EXPECTED_ICE_LEGEND_COLOR);
   	}
    
  @Test(priority=17)
 	public void RW_T408_ValidateMixLegends_verifyLegendsForMixHaveTextMix()
 	{
 		testStart("Legends for Mix should have text Mix in the center of the bar");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		foreCastWeatherPage.verifyLegendsForMixHaveTextMix();
 	}
  
  @Test(priority=18)
 	public void RW_T408_ValidateMixLegends_verifyMixLegendBarColor()
 	{
 		testStart("Verify mix legend bar is purple in color");
 		navigationBar.mouseHoverOnRadarAndMaps();
 		navigationBar.isForecastMapsSubMenuDisplayed();
 		navigationBar.navigateToForeCastPage();
 		String actualLegendBarcolor = foreCastWeatherPage.verifyIceLegendBarColor();
 		Assert.assertEquals(actualLegendBarcolor, EXPECTED_ICE_LEGEND_COLOR);
 	}
}
