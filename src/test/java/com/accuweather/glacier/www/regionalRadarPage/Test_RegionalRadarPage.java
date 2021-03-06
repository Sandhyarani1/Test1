package com.accuweather.glacier.www.regionalRadarPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.RadarPage;
import com.chameleon.utils.Sleeper;

public class Test_RegionalRadarPage extends AccuWeatherBaseTest 
{
	String citySearchedByName = "Austin";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedRegionalWeatherRadarpage="https://qualityassurance.accuweather.com/en/us/texas/weather-radar";

	private static final String LEGEND_RAIN="Rain";
	private static final String LEGEND_SNOW="Snow";
	private static final String LEGEND_ICE="Ice";
	private static final String LEGEND_MIX="Mix";

	private static final String EXPECTED_MAP_TITLE="Texas Weather Radar";
	private static final String EXPECTED_TOOLTIP_TEXT= "Weather radar map shows the location of precipitation, its type (rain, snow, and ice) and its recent movement to help you plan your day.";
	private static final int    EXPECTED_FULLSCREEN_BUTTONHEIGHT= 44;

	private static final String EXPECTED_RADARTAB_HIGHLIGHTED="#f05514";
	private static final String EXPECTED_TOOLTIP_COLOR="#f59721";	
	private static final String EXPECTED_PASTCTA_COLOR="#f59721";
	private static final String EXPECTED_FUTURECTA_COLOR="#e8e8e8";
	private static final String EXPECTED_FUTURECTA_HIGHLIGHTED="#f59721";

	private static final int EXPECTED_TOTAL_DIFFERENCE = 20;
	private static final int EXPECTED_TIME_DIFFERENCE_FUTURECTA = 15;

	private static final String EXPECTED_LANDINGPAGE_URL="https://www.mapbox.com/";

	private RadarPage radarPage=new RadarPage();

	@Test(priority=1,enabled = true)
	public void RW_TC106_Regional_Radar_page_loads_succesfully()
	{
		testStart("Validate Regional Radar page is loaded successfully");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(8);
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegionalWeatherRadarpage);		
	}

	@Test(priority=2,enabled = true)
	public void RW_TC107_Tabs_on_Secondary_navigations_displayed_on_Regional_weather_radar_page()
	{
		testStart("Validate Secondary Navigation menus displayed on Regional Radar Page");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(radarPage.Secondarynavigationmenusdisplayed());			
	}

	@Test(priority=3,enabled = true)
	public void RW_TC107_a_Validate_Secondary_Navigation_menus_Radar_Displayed_for_RegionalRadarpage()
	{
		testStart("Validate Secondary Navigation menus displayed for Regional  Page");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		Assert.assertTrue(radarPage.validateSecondaryMenusDisplayed());		
	}

	@Test(priority=4
			,enabled = true)
	public void RW_TC107_e__Validate_Radar_Tab_Highlighted_byDefault_on_Regional_Radar_Page()
	{
		testStart("Validate Radar TAb from Secondary Navigation menus is Highlighted on Radar Page");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String actualRadarTabcolour= radarPage.RadartabHighlightedinOrange();
		Assert.assertEquals(actualRadarTabcolour, EXPECTED_RADARTAB_HIGHLIGHTED);		
	}


	@Test(priority=8,enabled = true)
	public void RW_TC108_Validate_Title_of_Map_on_Regional_Radar_Page()
	{
		testStart("Navigate to Regional Radar page and Validate Title displayed on the Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.titleOfRadarMap().equalsIgnoreCase(EXPECTED_MAP_TITLE));
	}



	@Test(priority=10,enabled = true)
	public void RW_TC109_a_Validate_Tool_Highlighted_inOranage_whenClicked()
	{
		testStart("Navigate to Regional Radar page and Validate Tooltip highlighted in Orange when clicked");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.colordisplayedwhenclickedonTooltip(), EXPECTED_TOOLTIP_COLOR);
	}

	@Test(priority=11,enabled = true)
	public void RW_TC109_b_Validate_Text_dispayed_whenClicked_onTooltip_onNationalRadarpage()
	{
		testStart("Navigate to Regional Radar page and Validate Tooltip text displayed when clicked on Tooltip");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.textdisplayedwhenclickedonTooltip().equalsIgnoreCase(EXPECTED_TOOLTIP_TEXT));
	}

	@Test(priority=12,enabled = true)
	public void RW_TC109_c_Validate_Tooltip_closes_whenClicked_onTooltip_twice()
	{
		testStart("Navigate to Regional Radar page and Validate Tooltip closes when clicked on Tooltip twice");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
	}


	@Test(priority=14,enabled = true) 
	public void RW_TC110_a_Validate_Zoom_Button_functioning_onRegional_RadarMap() 
	{ 
		testStart("Validate Zoom in Control buttons working as expeceted on Radar Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3); 
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		radarPage.mouseHoverOnRadarAndMaps(); 
		radarPage.navigateToRadar(); 
		Sleeper.sleep(5);
		radarPage.zoominControls();
		Sleeper.sleep(3);
		radarPage.zoomoutControls();
	} 


	@Test(priority=17,enabled = true)
	public void RW_TC111_a_Click_onMapbox_attribution_displayed_BottomLeft_onNationalRadarpage()
	{
		testStart("Navigate to Regional Radar page and Click on Mapbox attribution displayed on Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.ClickonMapboxattribution();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Assert.assertEquals(radarPage.getlandingurltitle(), EXPECTED_LANDINGPAGE_URL);		
	}

	@Test(priority=18,enabled = true)
	public void RW_TC112_Validate_Full_Screen_button_displayed_onRight_corner_ofRadarMap()
	{
		testStart("Navigate to Regional Radar page and Validate Full screen button displayed on Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		int actualFullScreenbuttonHeight=radarPage.fullScreenbuttonDisplayedatbottomRight();
		Assert.assertEquals(actualFullScreenbuttonHeight, EXPECTED_FULLSCREEN_BUTTONHEIGHT);		
	}

	@Test(priority=19,enabled = false)
	public void RW_TC112_a_Validate_Timeline_controls_onFull_Screen_RadarMap() 
	{
		testStart("Navigate to Regional Radar page and validate timeline controls displayed on fullscreen Radar Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.ClikonFullScreenButton();
		Assert.assertTrue(radarPage.timelinecontrolsdisplayedonFullscreen());
	}

	@Test(priority=20,enabled = true)
	public void RW_TC112_b_Validate_legends_displayed_onFull_Screen_RadarMap() 
	{
		testStart("Navigate to Regional Radar page and validate legends displayed on Full screen Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		radarPage.ClikonFullScreenButton();
		Assert.assertTrue(radarPage.legendsdisplayedonFullscreenRadarMap());
	}

	@Test(priority=21,enabled = true)
	public void RW_TC112_c_Validate_Fullscreen_Radarmap_closed_when_clicked_onCloseSymbol()
	{
		testStart("Navigate to Regional Radar page Click on Full screen button and Validate full screen exits when clicked on close symbol");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.ClikonFullScreenButton();
		Sleeper.sleep(3);
		radarPage.clickedonClosebuttonfromFullscreenRadarMap();
	}

	@Test(priority=22,enabled = true)
	public void RW_TC113_Validate_Timeline_controls_PastandFuture_displayed_on_RadarMap()
	{
		testStart("Validate Timeline controls PastandFuture displayed on Regional Weather Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.timelinecontrolsdisplayedonRadarMap());
	}

	@Test(priority=23,enabled = true)
	public void RW_TC113_a_Validate_PASTCTA_Highlighted_byDeafult_RadarMap()
	{
		testStart("Validate PASTCTA Highlighted byDeafult on RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.PastCTAHighlightedbyDefaultonRadarMap(), EXPECTED_PASTCTA_COLOR);
	}

	@Test(priority=24,enabled = true)
	public void RW_TC113b_Validate_FUTURE_CTA_NotHighlighted_byDeafult_RadarMap()
	{
		testStart("Validate FUTURE CTA Not Highlighted byDeafult on RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String futureCTAdisplayed=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed, EXPECTED_FUTURECTA_COLOR);
	}

	@Test(priority=25,enabled = true)
	public void RW_TC114_Toggle_between_Past_andFuture_CTA_onRegional_RadarMap()
	{
		testStart("Validate Past andFuture CTA displayed on Regional Weather Radar Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		String futureCTAdisplayed=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed, EXPECTED_FUTURECTA_COLOR);
		radarPage.ClickonFutureCTAonRadarMap();
		String futureCTAdisplayed2=radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed2,EXPECTED_FUTURECTA_HIGHLIGHTED );
	}

	@Test(priority=26,enabled = true)
	public void RW_TC115_Validate_Time_Slider_With_Playbutton_displayed_onRegional_RadarMap()
	{
		testStart("Validate Time Slider Playbutton displayed on Regional Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		Assert.assertTrue(radarPage.SliderwithPlayButtonDisplayed());

	}
	@Test(priority=27,enabled = true)
	public void RW_TC115_Toggle_between_Pastand_Future_CTA_Validate_Timeslider_onRegional_RadarMap()
	{
		testStart("Toggle between Pastand FututreCTA on Regional Radar Page and Validate Timeslider");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);
		radarPage.clickonPlayButton();
		radarPage.ClickonFutureCTAonRadarMap();	    
		radarPage.clickonPlayButton();
		radarPage.ClickonPastCTAonRadarMap();
		radarPage.clickonPlayButton();

	}

	@Test(priority=28,enabled = false)
	public void RW_TC116_Select_PastCTA_and_click_on_Play_button_onRegional_RadarPage() 
	{
		testStart("Validate PastCTA selected and clicked on Playbutton on regional Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3);               
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);

		String endTime=radarPage.timestampdisplayed();	
		radarPage.clickonPlayButton();
		String startTime=radarPage.timestampdisplayed();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
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

	@Test(priority=29,enabled = false)
	public void RW_TC116_Select_FutureCTA_and_click_on_Play_button_onNational_RadarPage() 
	{
		testStart("Validate when Future CTA Selected and click on Play button on Regional Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(3); 
		radarPage.ClickonFutureCTAonRadarMap();
		String time1=radarPage.timestampdisplayed();		
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
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

	@Test(priority=30,enabled = true)
	public void RW_TC_117_Validate_Rain_Legend_Displayed_below_RadarMap()
	{
		testStart("Validate Rain Legends is Displayed below Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_RAIN));	
	}

	@Test(priority=31,enabled = true)
	public void RW_TC_117_a_Validate_Rain_Legend_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Rain displayed with Text Light and Severe");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(5);
		Assert.assertTrue(radarPage.RainlegendtextLightandSevereDisplayed());
	}



	@Test(priority=33,enabled = true)
	public void RW_TC_117_c_Validate_Legend_Rain_displayed_with_Following_Colors() 
	{
		testStart("Validate Legend Rain displayed with various colors");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		radarPage.legendRaincoloursdisplayed();
	}

	@Test(priority=34,enabled = true)
	public void RW_TC_118_Validate_Legend_Snow_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Snow displayed below Radar map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_SNOW));

	}

	@Test(priority=35,enabled = true)
	public void RW_TC_118_a_Validate_Snow_Legend_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Snow displayed with Text Light and Severe");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.legendSnowDisplayedwithTextLightandSevere());	
	}


	@Test(priority=37,enabled = true)
	public void RW_TC_118_c_Validate_Legend_Snow_displayed_with_following_Colors()
	{
		testStart("Validate Legend Snow displayed with Text Severe");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		radarPage.legendSnowcoloursdisplayed();

	}


	@Test(priority=38,enabled = true)
	public void RW_TC_119_Validate_Legend_Ice_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Ice Displayed below Radar Map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_ICE));
	}

	@Test(priority=39,enabled = true)
	public void RW_TC_119_a_Validate_Legend_ICE_displayed_with_Text_Light_andSevere() 
	{
		testStart("Validate Legend Ice displayed with Text Light and Severe");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.legendIceDisplayedwithTextLightandSevere());
	}



	@Test(priority=41,enabled = true)
	public void RW_TC_119_c_Validate_Legend_ICE_displayed_with_Following_Colors() 
	{
		testStart("Validate Legend Ice displayed with following colors");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		radarPage.legendIcecoloursdisplayed();
	}


	@Test(priority=42,enabled = true)
	public void RW_TC_120_Validate_Legend_Mix_Displayed_below_RadarMap()
	{
		testStart("Validate Legend Mix Displayed below RadarMap");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_MIX));

	}

	@Test(priority=43,enabled = true)
	public void RW_TC_120_a_Validate_Legend_Mix_displayed_with_Text_Light_andSevee() 
	{
		testStart("Validate Legend Mix displayed with Text Light");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		Sleeper.sleep(4);
		Assert.assertTrue(radarPage.legendMixDisplayedwithTextLightandSevere());	
	}


	@Test(priority=45,enabled = true)
	public void RW_TC_120_c_Validate_Legend_Mix_displayed_with_Following_Colors() 
	{
		testStart("Validate Legend Mix displayed with various colors");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		Sleeper.sleep(5);
		radarPage.mouseHoverOnRadarAndMaps();
		radarPage.navigateToRadar();
		radarPage.legendMixcoloursdisplayed();
	}

}
