
package com.accuweather.glacier.www.minutecastPage;



import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CityRadarPage;
import com.accuweather.glacier.www.pages.MinutecastPage;
import com.accuweather.glacier.www.pages.RadarPage;
import com.accuweather.glacier.www.pages.SatellitePage;
import com.chameleon.utils.Sleeper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_MinutecastPage  extends AccuWeatherBaseTest
{
	String citySearchedByName="Chicago";
	
	String ExpectedForecastPageTitle="https://qualityassurance.accuweather.com/en/us/chicago/60608/weather-forecast/348308";
	String ExpectedPageTitle="Chicago, IL MinuteCast(R) Weather | AccuWeather";
	String expectedTabcolor="#f05514";
	
	private static final String expectedMapTitle= "Chicago Weather Radar";
			
	private static final String GREY_COLOR_="#878787";
	private static final String CTA_NOT_HIGHLIGHTED ="#e8e8e8";
	private static final String ORANGE_COLOR="#f59721";
	private static final String TIMESTAMP_COLOR="#f05514";
	private static final String EXPECTED_TOOLTIP_TEXT="Weather radar map shows the location of precipitation, its type (rain, snow, and ice) and its recent movement to help you plan your day.";	
	
	private static final String MAP_BOX_LANDING_PAGE_URL="https://www.mapbox.com/about/maps/"; 
	private static final String OPEN_STREET_PAGE_URL="https://www.openstreetmap.org/about/";

	
	private static final String LEGEND_RAIN="Rain";
	private static final String LEGEND_SNOW="Snow";
	private static final String LEGEND_ICE="Ice";
	private static final String LEGEND_MIX="Mix";
	
	private static final int EXPECTED_TOTAL_DIFFERENCE_PASTCTA=25;
	private static final int EXPECTED_TIME_DIFFERENCE_FUTURECTA=10;
	private static final int EXPECTED_TIME_DIFFERENCE_inMINS=1800;
	
	private MinutecastPage minutecast=new MinutecastPage();
	private SatellitePage map= new SatellitePage();
	private CityRadarPage radarpage = new CityRadarPage();
	private RadarPage radar=new  RadarPage();
	
	
	
	@Test(priority=1)
	public void TC_RW_T82_navigateToMinutecastForecastPage() 
	{
		testStart("Is AW Minutecast Tab Displayed on Home Page");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
     	Assert.assertEquals(getDriver().getTitle(), ExpectedPageTitle);
	}

	@Test(priority=2)
	public void TC_RW_T82_validateMinutecastTabHighlighted() 
	{
		testStart("Is AW Minutecast Tab Displayed on Home Page");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		String tabcolor=minutecast.minutecastTabHighlighted();
		System.out.println("Color displayed is "+tabcolor);
		Assert.assertEquals(tabcolor, expectedTabcolor);
	}
	
	@Test(priority=3)
	public void TC_RW_T82_validatingMinutecastdialDisplayed() 
	{
		testStart("Validating Minutecast  Dial is Displayed on the Minutecast page.");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertTrue(minutecast.isminutecastDialDisplayed());
		
	}
	
	@Test(priority=4)
	public void TC_RW_T82_validatingMinutecastDialhasLargeWeatherDescriptionDisplayed() 
	{
		testStart("Validating Minutecast  Dial has large weather Description on the top of the molecule .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertNotNull(minutecast.isminutecastDialDisplayed());
	}
	
	@Test(priority=5)
	public void TC_RW_T82_validatingMinutecastDialhasTimeStampDisplayed() 
	{
		testStart("Validating Minutecast  Dial has large weather Description on the top of the molecule .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertNotNull(minutecast.isminutecastDialDisplayed());
	}
	
	@Test(priority=6)
	public void TC_RW_T82_validatingMinutecastDialhasWeathericonDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Weather icon displayed on the middle of the Dial .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		Sleeper.sleep(1);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertTrue(minutecast.minutecastDialWeathericonDisplayed());
		
	}
	
	@Test(priority=7)
	public void TC_RW_T82_validatingMinutecastDialhasShortweatherDescriptionDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Short weather Description below the weather icon .");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		Sleeper.sleep(1);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);;
		Assert.assertNotNull(minutecast.minutecastDialshortWeatherDescriptionDisplayed());
	}
	
	@Test(priority=8)
	public void TC_RW_T82_validatingMinutecastDialhasUpdatedTimeDisplayed() 
	{
		testStart("Validating Minutecast  Dial has Updated Time displayed  at the bottom right corner of the Dial.");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertNotNull(minutecast.minutecastDialhasUpdatedTimeDisplayed());
	}

	@Test(priority=9)
	public void TC_RW_T83_validatingMinutecastpagehasRadarMapdisplayed() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map Displayed on the page  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();Sleeper.sleep(1);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertTrue(minutecast.radarMapDisplayed());
	}
	
	@Test(priority=10)
	public void RW_TC83_validatingMinutecastRadarMapTitle() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map Displayed on the page  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();Sleeper.sleep(1);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		Assert.assertTrue(minutecast.radarMapTitle().equalsIgnoreCase(expectedMapTitle));
	}
	
	
	
	@Test(priority=11)
	public void RW_TC83_validatingMinutecastRadarMaphasTooltipDisplayed() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map has Tool tip displayed");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();Sleeper.sleep(1);
		Assert.assertEquals(minutecast.tooltipDefaultcolor(), GREY_COLOR_);
	}
	
	@Test(priority=12)
	public void RW_TC83_validatingMinutecastRadarMaphasToolActivewhenSelected() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map has Tool tip displayed in orange when clicked");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		Sleeper.sleep(2);
		Assert.assertEquals(minutecast.activetooltipcolor(),ORANGE_COLOR);
		
	}
	
	
	@Test(priority=13)
	public void RW_TC83_validatingMinutecastRadarMapTooltipHeaderTitle() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map has Tool tip displayed in orange when clicked");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		String headerTitle=minutecast.tooltipTitleandText();
		headerTitle.compareToIgnoreCase(expectedMapTitle);
		Assert.assertTrue(headerTitle.equalsIgnoreCase(expectedMapTitle));			
	}
	
	
	@Test(priority=14)
	public void RW_TC83_validatingMinutecastRadarMapTooltipHeaderTitledisplayedinOrange() 
	{
		testStart("Navigate to Minutecast forecast page and validate Radar map has Tool tip displayed in orange when clicked");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);                     
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		System.out.println("Headrr color displayed is"+minutecast.tooltipHeaderDisplayedColor());
		Assert.assertEquals(minutecast.tooltipHeaderDisplayedColor(), ORANGE_COLOR);
		
	}
	@Test(priority=15)
	public void RW_TC83_validatingMinutecastRadarMapTooltipText() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Tooltip title displayed");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		String actualText=minutecast.tooltipTextDisplayed();
		Assert.assertTrue(actualText.equalsIgnoreCase(EXPECTED_TOOLTIP_TEXT));
	
	}

	@Test(priority=16)
	public void RW_TC83_validatingMinutecastRadarMapTooltipcloseswhenclickedTwice() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Tooltip Closes when clicked twice");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.clickonTooltip();
		minutecast.clickonTooltip();
	}

	@Test(priority=17)
	public void RW_TC84_validatingMinutecastRadarMapZoominfunctionality() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Zoomin Functionality of the Radar Map");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		map.zoominControls();
	}
	
	@Test(priority=18)
	public void RW_TC84_validatingMinutecastRadarMapZoomoutfunctionality() 
	{
		testStart("Navigate to Minutecast forecast page and valdate Zoom out Functionality of the Radar Map");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		map.zoomoutControls();
	}
	
	@Test(priority=19)
	public void RW_TC84_validatingMapboxattributionDisplayed() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating landngpage Url for Mapbox ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();                                 
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.mapboxAttributiondisplayed());
	}
	
	@Test(priority=20)
	public void RW_TC84_validatingMapboxlandingpageURL() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating landngpage Url for Mapbox ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radarpage.clickMapbox();
		Assert.assertEquals(map.getlandingurltitle(),MAP_BOX_LANDING_PAGE_URL);	
	}
	
	@Test(priority=21)
	public void RW_TC84_validatingOpenStreetMaplandingpageurl() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating landngpage Url for Open street Map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radarpage.clickOpenStreetMap();
		String landingpageURL=map.getlandingurltitle();
		Assert.assertEquals(landingpageURL, OPEN_STREET_PAGE_URL);
		
	}
	@Test(priority=22)
	public void RW_TC84_validatingImprovethismapLandingpageURL() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating landngpage Url for improve this map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radarpage.clickImproveThisMap();
		String landingpageURL=map.getlandingurltitle();
		Assert.assertTrue(landingpageURL.startsWith("https://apps.mapbox.com/feedback/"));
	}
	
	
	
	@Test(priority=23)
	public void RW_TC87_validatingLegendRainDisplayedonMinutecastRadarMap() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Rain displayed ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radar.isLegendDisplayedbelowRadarMap(LEGEND_RAIN));
	}
	
	
	@Test(priority=24)
	public void RW_TC87_validatingLegendRainDisplayedwithTextLightandSevere() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Rain displayed with textLight and Severe");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.verifyLightAndSevertextdisplayedforLegendRain());
	}
	
	@Test(priority=25)
	public void RW_TC87_validatingLegendRainDisplayedwithVariousColors() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Rain displayed with various colors");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.legendRaincoloursdisplayed();
	}
	
	@Test(priority=26)
	public void RW_TC87_validatingLegendSnowDisplayedonMinutecastRadarMap() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating legend Snow displayed ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radar.isLegendDisplayedbelowRadarMap(LEGEND_SNOW));
	}
	
	@Test(priority=27)
	public void RW_TC87_validatingLegendSnowDisplayedwithTextLightandSevere() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Snow displayed with textLight and Severe");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radarpage.verifyLightAndSeverFromSnowLegend());	 
	}
	
	@Test(priority=28)
	public void RW_TC87_validatingLegendSnowDisplayedwithVariousColors() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Snow displayed with various colors");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.legendSnowcoloursdisplayed();	
	}
	
	@Test(priority=29)
	public void RW_TC87_validatingLegendIceDisplayedonMinutecastRadarMap() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating legend Ice displayed ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radar.isLegendDisplayedbelowRadarMap(LEGEND_ICE));
	}
	
	@Test(priority=30)
	public void RW_TC87_validatingLegendIceDisplayedwithTextLightandSevere() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Snow displayed with textLight and Severe");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radarpage.verifyLightAndSeverFromIceLegend());	 
	}
	
	@Test(priority=31)
	public void RW_TC87_validatingLegendIceDisplayedwithVariousColors() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Ice displayed with various colors");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.legendIcecoloursdisplayed();
	}
	
	@Test(priority=32)
	public void RW_TC87_validatingLegendMixDisplayedonMinutecastRadarMap() 
	{
		testStart("Radarmap displayed on Minutecast forecast page and validating legend Ice displayed ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radar.isLegendDisplayedbelowRadarMap(LEGEND_MIX));
	}
	
	@Test(priority=33)
	public void RW_TC87_validatingLegendMixDisplayedwithTextLightandSevere() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Snow displayed with textLight and Severe");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
	    Assert.assertTrue(radarpage.verifyLightAndSeverFromMixLegend());	 
	}
	
	@Test(priority=34)
	public void RW_TC87_validatingLegendMixDisplayedwithVariousColors() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating legend Mix displayed with various colors");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.legendMixcoloursdisplayed();
		
	}
	
	@Test(priority=35)
	public void RW_TC87_validatingMinutecastRadarMapFullScreenDisplayed() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Full Screen button displayed.");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Assert.assertTrue(minutecast.FullscreenbuttonOnBottomRight());
		
	}
	
	@Test(priority=36)
	public void RW_TC85_validatingMinutecastRadarMapFullScreenfunctions() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Full Screen radar map has timelincontrols.Slider with Playbutton,legend displayed and when click on x symbol the map switches back to normal.");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		minutecast.FullscreenButtonSelected();
		Assert.assertTrue(radarpage.clickFullScreenButtonOfMap());
	}
	@Test(priority=37)
	public void RW_TC87_validatingMapTimelineControlfunctions() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating map timelincontrols function PAST and FUTURE CTA ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radarpage.verifyPastAndFutureCTABelowMap();	
	}
	
	@Test(priority=38)
	public void RW_TC87_validatingMapTimelineControlpresentPastCTaHighlighted() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating map timelincontrols PAST CTA Highlighted By Default in orange color");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		String actualHighlightedcolor=radar.PastCTAHighlightedbyDefaultonRadarMap();
		Assert.assertEquals(actualHighlightedcolor,ORANGE_COLOR);
	}
	
	@Test(priority=39)
	public void RW_TC87_validatingMapTimelineControlpresentTogglebetweenPastandFutureCTA() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Toggle funtionality between PAST and FUTURE CTA ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Assert.assertTrue(radarpage.toggleBetweenPastAndFutureCTA());
	}
	
	@Test(priority=40)
	public void RW_TC87_validatingMapTimelineControlpresentValidateFutureCTAnotHighlighted_byDefault() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating FUTURE CTA Not HIghlighted by Default ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.FutureCtaNotHighlightedonRadarMap();
	    Assert.assertEquals(radar.FutureCtaNotHighlightedonRadarMap(),CTA_NOT_HIGHLIGHTED);
	}

	@Test(priority=41)
	public void RW_TC87_validatingMapTimelineControlpresentValidateFutureCTAHighlighted_inOrange() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating FUTURE CTA Not HIghlighted by Default ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		radar.FutureCtaNotHighlightedonRadarMap();
		radar.ClickonFutureCTAonRadarMap();
		Sleeper.sleep(3);
		String futureCTA=radar.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTA,ORANGE_COLOR );
	    
	}
	
	@Test(priority=42,enabled=false)
	public void RW_TC87_validatingPastCTATimeframes() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validate the timeframe displayed for PAST CTA  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		String endTime=radar.timestampdisplayed();	
		radar.clickonPlayButton();
		String startTime=radar.timestampdisplayed();
		waitUntilElementIsDisplayedOrClickable();
  		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		  Date date1;
		  Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);
			
			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60), EXPECTED_TOTAL_DIFFERENCE_PASTCTA);
		} 
		
		catch (ParseException e)
		{
			e.getMessage();
		}
	    
	}
	
	
	@Test(priority=43 ,enabled=false)
	public void RW_TC87_validatingFutureCTATimeframes() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validate the timeframe displayed for FUTURE CTA  ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		radar.ClickonFutureCTAonRadarMap();
		Sleeper.sleep(3);
		String time1=radar.timestampdisplayed();		
		waitUntilElementIsDisplayedOrClickable();
		radar.clickonPlayButton();			
		String time2=radar.timestampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try 
		{
			date1 = format.parse(time1);
			date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime(); 
			Assert.assertEquals(difference/(1000*60), EXPECTED_TIME_DIFFERENCE_FUTURECTA);
		} 
		
		
		catch (ParseException e)
		{
			e.getMessage();
		}
	    
	}
	
	@Test(priority=44)
	public void RW_TC88_validatingTimestampMoleculeDisplayedbelowRadarmap() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Timestamp Molecule displayed below radar map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(minutecast.timestampDisplayed());
		long difference=minutecast.timestamp();
		System.out.println("Time Difference is "+difference/(1000*3));
		Assert.assertEquals(difference/(1000*3), EXPECTED_TIME_DIFFERENCE_inMINS);
	}
	
	@Test(priority=45)
	public void RW_TC88_validatingTimestampMoleculeCurrentTimeDisplayedinOrange() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Timestamp Molecule displayed below radar map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		minutecast.timestampDisplayed();
		Assert.assertEquals(minutecast.timestampCurrentTimeinOrange(), TIMESTAMP_COLOR);
	}
	
	@Test(priority=46)
	public void RW_TC88_ClickingonEachTimestampMolecule() 
	{
		testStart("Navigate to Radarmap from Minutecast forecast page and validating Timestamp Molecule displayed below radar map ");
		minutecast.searchCityByName(citySearchedByName);    
		minutecast.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.isminutecastTabDisplayed();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		minutecast.scrolldownpage();
		Sleeper.sleep(3);
		minutecast.timestampDisplayed();
		minutecast.clickonEachtimestampMolecule();
		
	}
}

