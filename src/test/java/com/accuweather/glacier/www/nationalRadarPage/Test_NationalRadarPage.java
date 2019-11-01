package com.accuweather.glacier.www.nationalRadarPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.RadarPage;
import com.chameleon.utils.Sleeper;

public class Test_NationalRadarPage extends AccuWeatherBaseTest
{	
	String citySearchedByName="Washington";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedNationalRadarpageURL="https://qualityassurance.accuweather.com/en/us/national/weather-radar";
	
	private static final int EXPECTED_FULLSCREEN_BUTTONHEIGHT= 44;
	private static final String RADAR_TAB="Radar";  
	private static final String SATELLITE_TAB="Satellite";  
	private static final String SEVERE_TAB="Severe";  
	private static final String FORECAST_TAB="Forecast";
	
	private static final String LEGEND_RAIN="Rain";
	private static final String LEGEND_SNOW="Snow";
	private static final String LEGEND_ICE="Ice";
	private static final String LEGEND_MIX="Mix";
	private static final String EXPECTED_MAPTITLE="UNITED STATES WEATHER RADAR";
	private static final String EXPECTED_TOOLTIP_TEXT= "Weather radar map shows the location of precipitation, its type (rain, snow, and ice) and its recent movement to help you plan your day.";
	private static final String EXPECTED_RADARTAB_HIGHLIGHTED="#f05514";
	private static final String EXPECTED_TOOLTIP_COLOR="#f59721";
	private static final String EXPECTED_PASTCTA_COLOR="#f59721";
	private static final String EXPECTED_FUTURE_CTA_COLOR="#e8e8e8";
	private static final String EXPECTED_FUTURECTA_HIGHLIGHTED="#f59721";
	
	private static final int EXPECTED_TOTAL_DIFFERENCE = 25;
	private static final int EXPECTED_TIME_DIFFERENCE_FUTURECTA = 15;
	private static final String EXPECTED_LANDINGPAGE_URL="https://www.mapbox.com/";
	
	private RadarPage radarPage=new RadarPage();
	

	@Test(priority=1,enabled = true)
	public void RW_TC163_National_Radar_page_loads_succesfully()
	{
		testStart("Validate National Radar page is loaded successfully");
        radarPage.searchCityByName(citySearchedByName);    
        radarPage.selectCityByName();
    	waitUntilElementIsDisplayedOrClickable();
    	 Sleeper.sleep(3);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
        Sleeper.sleep(8);
	    Assert.assertEquals(getDriver().getCurrentUrl(), expectedNationalRadarpageURL);
		
	}
	
	@Test(priority=2,enabled = true)
	public void RW_TC164_Tabs_on_Secondary_navigations_displayed_on_National_weather_radar_page()
	{
		testStart("Validate Secondary Navigation menus are displayed on National Radar Page");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		Assert.assertTrue(radarPage.validateSecondaryMenusDisplayed());			
	}
		
	@Test(priority=3,enabled = true)
	public void RW_TC165_Validate_Radar_Tab_Highlighted_byDefault_on_National_Radar_Page()
	{
		testStart("Validate Radar TAb from Secondary Navigation menus is Highlighted on Radar Page");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String actualRadarTabcolour= radarPage.RadartabHighlightedinOrange();
		Assert.assertEquals(actualRadarTabcolour, EXPECTED_RADARTAB_HIGHLIGHTED);		
	}
	
	@Test(priority=4,enabled = true)
	public void RW_TC166_Validate_Title_of_Map_on_National_Radar_Page()
	{
		testStart("Navigate to National Radar page and Validate Title displayed on Radar Map ");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		System.out.println("Map Title is "+radarPage.titleOfRadarMap());
		Assert.assertTrue(radarPage.titleOfRadarMap().equalsIgnoreCase(EXPECTED_MAPTITLE));
	}
	
	
	@Test(priority=5,enabled = true)
	public void RW_TC167_a_Validate_Tool_Highlighted_inOranage_whenClicked()
	{
		testStart("Navigate to National Radar page and Validate Tooltip highlighted in Orange when clicked");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.colordisplayedwhenclickedonTooltip(), EXPECTED_TOOLTIP_COLOR);
	}
	
	@Test(priority=6,enabled = true)
	public void RW_TC167_b_Validate_Text_dispayed_whenClicked_onTooltip_onNationalRadarpage()
	{
		testStart("Navigate to National Radar page and Validate Tooltip text displayed when clicked on Tooltip");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.textdisplayedwhenclickedonTooltip().equalsIgnoreCase(EXPECTED_TOOLTIP_TEXT));
	}
	
	@Test(priority=7,enabled = true)
	public void RW_TC167_c_Validate_Tooltip_closes_whenClicked_onTooltip_twice()
	{
		testStart("Navigate to National Radar page and Validate Tooltip closes when clicked on Tooltip twice");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
	}

	 
	 @Test(priority=8,enabled = true) 
	 public void RW_TC168_Validate_Zoomin_Button_working_onNational_RadarPage()
	 { 
	    testStart("Validate Zoom Control buttons working as expeceted on Radar Map"); 
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName(); 
	    waitUntilElementIsDisplayedOrClickable(); 
	    Sleeper.sleep(3);
	    waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
	    radarPage.mouseHoverOnRadarAndMaps(); 
        radarPage.navigateToRadar(); 
        Sleeper.sleep(5);
        radarPage.zoominControls();  
        Sleeper.sleep(3);
	    radarPage.zoomoutControls();
	 } 
	 
	 @Test(priority=9,enabled = true) 
	 public void RW_TC168_Validate_Zoomout_Button_onNational_RadarPage()
	  { 
	     testStart("Validate Zoom Control buttons working as expeceted on Radar Map"); 
	 	 radarPage.searchCityByName(citySearchedByName);    
	     radarPage.selectCityByName(); 
	     waitUntilElementIsDisplayedOrClickable(); 
	     Sleeper.sleep(3);
	     waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
	     radarPage.mouseHoverOnRadarAndMaps(); 
	     radarPage.navigateToRadar(); 
	     Sleeper.sleep(3);
	     radarPage.zoomoutControls();
	    } 
	
	@Test(priority=10,enabled = true)
	public void RW_TC169_Validate_Mapbox_attribution_displayed_BottomLeft_onNationalRadarpage()
	{
		testStart("Navigate to National Radar page and Validate Mapbox attribution displayed on Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.MapboxattributionDisplayedBottomLeft());
	}
	
	@Test(priority=11,enabled = false)
	public void RW_TC169_Click_onMapbox_attribution_displayed_BottomLeft_onNationalRadarpage()
	{
		testStart("Navigate to National Radar page and Validate Mapbox attribution displayed on Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.ClickonMapboxattribution();
		getDriver().close();
		Assert.assertEquals(radarPage.getlandingurltitle(), EXPECTED_LANDINGPAGE_URL);
		//getDriver().close();
	}
	
	@Test(priority=12,enabled = true)
	public void RW_TC170_Validate_Full_Screen_button_displayed_onRight_corner_ofRadarMap()
	{
		testStart("Navigate to National Radar page and Validate Full screen button displayed on Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		int actualFullScreenbuttonHeight=radarPage.fullScreenbuttonDisplayedatbottomRight();
		Assert.assertEquals(actualFullScreenbuttonHeight, EXPECTED_FULLSCREEN_BUTTONHEIGHT);		
	}
	
	@Test(priority=13,enabled = true)
	public void RW_TC170a_Validate_Timeline_controls_onFull_Screen_RadarMap() 
	{
		testStart("Navigate to National Radar page and validate timeline controls displayed on fullscreen Radar Map ");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
        radarPage.ClikonFullScreenButton();
        Assert.assertTrue(radarPage.timelinecontrolsdisplayedonFullscreen());
	}
	
	@Test(priority=14,enabled = true)
	public void RW_TC170b_Validate_legends_displayed_onFull_Screen_RadarMap() 
	{
		testStart("Navigate to National Radar page and validate legends displayed on Full screen Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
        radarPage.ClikonFullScreenButton();
        Assert.assertTrue(radarPage.legendsdisplayedonFullscreenRadarMap());
	}

	@Test(priority=15,enabled = true)
	public void RW_TC170c_Validate_Fullscreen_Radarmap_closed_when_clicked_onCloseSymbol()
	{
		testStart("Navigate to National Radar page Click on Full screen button and Validate full screen exits when clicked on close symbol");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
        radarPage.ClikonFullScreenButton();
        Sleeper.sleep(3);
        radarPage.clickedonClosebuttonfromFullscreenRadarMap();
  	}
	
	@Test(priority=16,enabled = true)
	public void RW_TC171_Validate_Timeline_controls_PastandFuture_displayed_onNational_RadarMap()
	{
		testStart("Validate Timeline controls PastandFuture displayed onNational RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.timelinecontrolsdisplayedonRadarMap());
	}
	
	@Test(priority=17,enabled = true)
	public void RW_TC171a_Validate_PASTCTA_Highlighted_byDeafult_onNational_RadarMap()
	{
		testStart("Validate PASTCTA Highlighted byDeafult onNational RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.PastCTAHighlightedbyDefaultonRadarMap(), EXPECTED_PASTCTA_COLOR);
	}
	
	@Test(priority=18,enabled = true)
	public void RW_TC171b_Validate_FUTURE_CTA_NotHighlighted_byDeafult_onNational_RadarMap()
	{
		testStart("Validate FUTURE CTA NotHighlighted byDeafult onNational RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String futureCTAdisplayed=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed, EXPECTED_FUTURE_CTA_COLOR);
	}
	
	@Test(priority=19,enabled = true)
	public void RW_TC172_Toggle_between_Past_andFuture_CTA_onNational_RadarMap()
	{
		testStart("Validate Past andFuture CTA displayed on National  Weather Radar Map ");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String futureCTAdisplayed=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed, EXPECTED_FUTURE_CTA_COLOR);
		radarPage.ClickonFutureCTAonRadarMap();
		String futureCTAdisplayed2=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed2,EXPECTED_FUTURECTA_HIGHLIGHTED );
	}
	
	@Test(priority=20,enabled = true)
	public void RW_TC173_Validate_Time_Slider_Playbutton_displayed_onNational_RadarMap()
	{
		testStart("Validate Time Slider with Playbutton displayed on National Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
        Assert.assertTrue(radarPage.SliderwithPlayButtonDisplayed());
        
	}
	
	@Test(priority=21,enabled = true)
	public void RW_TC173_Validate_Timeslider_toggle_between_Pastand_FututreCTA_onNational_RadarPage()
	{
		testStart("Toggle between Pastand FututreCTA on National RadarPage and Validate Timeslider");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
        radarPage.clickonPlayButton();
        radarPage.ClickonFutureCTAonRadarMap();	    
        radarPage.clickonPlayButton();
        radarPage.ClickonPastCTAonRadarMap();
        radarPage.clickonPlayButton();
	}
	
	@Test(priority=22,enabled = false)
	public void RW_TC174_Select_PastCTA_and_click_on_Play_button_onNational_RadarPage()
	{
		testStart("Validate when PastCTA Select and clicked on Playbutton onNational_RadarPage");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		String endTime=radarPage.timestampdisplayed();	
		radarPage.clickonPlayButton();
		String startTime=radarPage.timestampdisplayed();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
  		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		  Date date1;
		  Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);
			
			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60), EXPECTED_TOTAL_DIFFERENCE);
		} 
		
		catch (ParseException e)
		{
			e.getMessage();
		}
	}
	
	@Test(priority=23,enabled = false)
	public void RW_TC175_Select_FutureCTA_and_click_on_Play_button_onNational_RadarPage()
	{
		testStart("Validate when FutureCTA Selected and click on Play button onNational RadarPage");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.ClickonFutureCTAonRadarMap();
		
		String time1=radarPage.timestampdisplayed();		
		waitUntilElementIsDisplayedOrClickable();
		radarPage.clickonPlayButton();			
		String time2=radarPage.timestampdisplayed();
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
	
	@Test(priority=24,enabled = true)
	public void RW_TC_176_Validate_Rain_Legends_below_RadarMap()
	{
		testStart("Validate Rain Legends below RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
	    Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_RAIN));	
	}
	
	@Test(priority=25,enabled = true)
	public void RW_TC_176_a_Validate_Rain_Legends_displayed_with_Text_Light_andSevere()
	{
		testStart("Validate Legend Rain displayed with Text Light");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.RainlegendtextLightandSevereDisplayed());
		
		
	}
	
	
	@Test(priority=26,enabled = true)
	public void RW_TC_177_c_Validate_Legend_Rain_displayed_with_Color() 
	{
		testStart("Validate Legend Snow displayed with Text Severe");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.legendRaincoloursdisplayed();
	
	}
	@Test(priority=27,enabled = true)
	public void RW_TC_177_Validate_Legend_Snow_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Snow displayed below Radar map");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_SNOW));
	  
	}
	
	@Test(priority=28,enabled = true)
	public void RW_TC_177_a_Validate_Snow_Legends_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Snow displayed with Text Light");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendSnowDisplayedwithTextLightandSevere());	

	}
	
	
	@Test(priority=29,enabled = true)
	public void RW_TC_177_c_Validate_Legend_Snow_displayed_with_Color()
	{
		testStart("Validate Legend Snow displayed with Text Severe");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.legendSnowcoloursdisplayed();
	
	}
	
	
	@Test(priority=30,enabled = true)
	public void RW_TC_178_Validate_Legend_Ice_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Ice Displayed below RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_ICE));
	  
	}
	
	@Test(priority=31,enabled = true)
	public void RW_TC_178_a_Validate_Legend_ICE_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Ice displayed with Text Light");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendIceDisplayedwithTextLightandSevere());	
	}
	
	
	@Test(priority=32,enabled = true)
	public void RW_TC_177_c_Validate_Legend_ICE_displayed_with_Color() 
	{
		testStart("Validate Legend Snow displayed with Text Severe");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.legendIcecoloursdisplayed();
	}
	
	
	@Test(priority=33,enabled = true)
	public void RW_TC_180_Validate_Legend_Mix_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Mix Displayed below RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_MIX));
	  
	}
	
	@Test(priority=34,enabled = true)
	public void RW_TC_180_a_Validate_Legend_Mix_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Mix displayed with Text Light");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendMixDisplayedwithTextLightandSevere());	
	}
	

	@Test(priority=35,enabled = true)
	public void RW_TC_177_c_Validate_Legend_Mix_displayed_with_Color() 
	{
		testStart("Validate Legend Mix displayed with various colors");
		radarPage.searchCityByName(citySearchedByName);    
	    radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		 Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.legendMixcoloursdisplayed();
	}
}
