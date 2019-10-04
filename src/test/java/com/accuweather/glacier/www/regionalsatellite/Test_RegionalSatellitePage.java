
package com.accuweather.glacier.www.regionalsatellite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.RadarPage;
import com.accuweather.glacier.www.pages.SatellitePage;
import com.chameleon.utils.Sleeper;

public class Test_RegionalSatellitePage extends AccuWeatherBaseTest
{
	String citySearchedByName="Chicago";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedlandingpageURL="https://qualityassurance.accuweather.com/en/us/washington/satellite";
	String expectedSatellitepageTitle="https://qualityassurance.accuweather.com/en/us/illinois/satellite";
	String expectedvisiblepageTitle="qualityassurance.accuweather.com/en/us/illinois/satellite-vis";
	
	private static final String EXPECTED_SATELLITETAB_HIGHLIGHTED="#f05514";
	private static final String EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT="#ec5f17";
	private static final String EXPECTED_TOOL_TIP_COLOR="#f59721";
	
	private static final String ENCHANCED_TAB="Enchanced";  
	private static final String STANDARD_TAB="Standard";  
	private static final String VISIBLE_TAB="Visible";  
	private static final String WATERVAPOR_TAB="WaterVapor";

	private static final String EXPECTED_TITLE_OF_MAP_ENCHANCED = "Enhanced Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_STANDARD ="Standard Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_VISIBLE="Visible Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_WATERVAPOR="Water Vapor Satellite for Illinois";
	
	private static final String EXPECTED_TOOL_TIPTEXT = "This map displays the infrared band of light and show relative warmth of objects. Infrared imagery is useful for determining clouds both at day and night. Colder objects are brighter and warmer objects are darker. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB="This map shows how the human eye would see the atmosphere from the satellite. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB="This image is taken using a wavelength sensitive to the content of water vapor in the atmosphere. Water vapor imagery is useful for both determining locations of moisture and atmospheric circulations that may affect your area.";
		
	private static final int EXPECTED_DIFFERENCE =5;
	private static final String MAP_BOX_LANDING_PAGE_URL="https://www.mapbox.com/";
	private static final String EXPECTED_URL_FOR_SATELLITE="https://qualityassurance.accuweather.com/en/us/national/satellite-ir";


	RadarPage radarPage=new RadarPage();
	private SatellitePage satellitePage=new SatellitePage();

	@Test(priority=1,enabled = true)
	public void RW_TC313_Regional_Satellite_page_loads_succesfully()
	{
		testStart("Validate Regional Satellite page is loaded successfully");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
        Sleeper.sleep(5);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedlandingpageURL);
		
	}

	@Test(priority=2,enabled = true)
	public void RW_TC313_Validate_Satellite_tab_Highlighted_byDefault_onSecondary_Navigations_menus_ofRegional_Satellite_Map()
	{
		testStart("Validate Satellite tab highlighted in orange by default on secondary navigations menus of satellite map.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		 Sleeper.sleep(5);
		Assert.assertEquals(satellitePage.satelliteTabHighlighted(),EXPECTED_SATELLITETAB_HIGHLIGHTED);
	}
	
	
	@Test(priority=3,enabled = true)
	public void RW_TC313_Validate_Enchanced_tab_Highlighted_byDefault_onTeritary_Navigations_menus_ofRegional_Satellite_Map()
	{
		testStart("Validate Enchaced Tab highlighted in orange by default on Teritary navigations menus of satellite map.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(4);
		Assert.assertEquals(satellitePage.EnchancedTabHighlighted(),EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT);
	}
	
	@Test(priority=4,enabled = true)
	public void RW_TC313_Validate_EnchancedTab_on_Tertiary_menu_isDisplayed_for_Regional_Satellite_Map()
	{
		testStart("Validate Enchanced Tab is displayed on Tertiary menus of Regional satellite page.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.istertiarymenuhas(ENCHANCED_TAB));
		
	}
	
	@Test(priority=5,enabled = true)
	public void RW_TC313_Validate_StandardTab_on_Tertiary_menu_isDisplayed_on_Regional_Satellite_Map()
	{
		testStart("Validate Standard Tab is displayed on Tertiary menus of Regional satellite page.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.istertiarymenuhas(STANDARD_TAB));
		
	}

	@Test(priority=6,enabled = true)
	public void RW_TC313_Validate_VisibleTab_on_Tertiary_menu_isDisplayed_on_Regional_Satellite_Map()
	{
		testStart("Validate visible Tab is displayed on Tertiary menus of Regional satellite page.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.istertiarymenuhas(VISIBLE_TAB));
		
	}

	@Test(priority=7,enabled = true)
	public void RW_TC313_Validate_WaterVaporTab_on_Tertiary_menu_isDisplayed_on_Regional_Satellite_Map()
	{
		testStart("Validate WaterVapor Tab is displayed on Tertiary menus of Regional satellite page.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.istertiarymenuhas(WATERVAPOR_TAB));		
	}
	
	@Test(priority=8,enabled = true)
	public void RW_TC313_Validate_Title_of_map_displayed_on_Regional_Satellite_page()
	{
		testStart("Validate Title of the map displayed on Regional Satellite Map.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_ENCHANCED));
		
	}

	
	@Test(priority=9,enabled = true)
	public void RW_TC314_Validate_ToolTip_Displayed_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to Regional Satellite page and Validate Tooltip displayed on the  Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
	}

	@Test(priority=10,enabled = true)
	public void RW_TC314_Validate_ToolTip_Active_when_Clicked_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to Regional Satellite page and Validate Tooltip Active when Clicked ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}
	@Test(priority=11,enabled = true)
	public void RW_TC314_Validate_ToolTip_Text_Displayed_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to Regional Satellite page and Validate Tool tip text displayed ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();	
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority=12,enabled = true)
	public void RW_TC314_Validate_ToolTip_Closes_when_Clicked_Twice_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to Regional Satellite page and Validate Tooltip closes when clicked twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();	
	}

	@Test(priority=13,enabled = true) 
	public void RW_TC314_Validate_Zoom_Control_Buttons_displayed_Top_leftcorner_ofRegional_SatellitePage() 
	{ 
		testStart("Naviagte to Regional Satellite Page and validate Zoom Control Buttons displayed on Top leftcorner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.zoomControlsDisplayedonTopLeftCorner());
	} 

	@Test(priority=14,enabled = true) 
	public void RW_TC314_Validate_Zoomin_Button_working_onRegional_satellitePage_For_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional satellite page and Validate Zoom In Control button Functioning as expeceted"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.zoominControls();
	} 

	@Test(priority=15,enabled = true) 
	public void RW_TC314_Validate_Zoomout_Button_working_onRegional_SatellitePage_For_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional Satellite page and Validate Zoom out Control button Functioning as expeceted "); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	} 


	@Test(priority=16,enabled = true) 
	public void RW_TC315_Validate_Mapbox_Attribution_onBottomLeft_Corner_ofNational_RegionalPageFor_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional satellite page and Validate Mapbox attribution displayed on Bottom left corner of Map for Enchanced Tab"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.MapboxattributionDisplayedBottomLeft());
	} 


	@Test(priority=17,enabled = true) 
	public void RW_TC315_Validate_Mapbox_Attribution_Landing_Page_UrlFor_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional satellite page and Validate Mapbox landing page For Enchanced Tab"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable(); 
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} 

	@Test(priority=18,enabled = true)
	public void RW_TC220_Validate_Legend_Clouds_Displayed_withText_LowandHigh_for_Regional_SatelliteMapFor_Enchanced_Tab()
	{
		testStart("Navigate to Regional Satellite Map and Validate Legend cloud displayed with text High and Low For Enchanced Tab");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority=19,enabled = true)
	public void RW_TC315_Validate_Legend_Clouds_Displayed_with_colors_RegionalMapFor_Enchanced_Tab()
	{
		testStart("Navigate to Regional Satellite Map and Validate legend cloud displayed with colors ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	@Test(priority=20,enabled = true) 
	public void RW_TC315_Validate_TimeDisplayed_onTimelineControls_of_RegionalMapFor_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional page and Validate time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);

		String endTime=satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();

		String startTime=satellitePage.timeStampdisplayed();

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60*60), EXPECTED_DIFFERENCE);
		} 

		catch (ParseException e)
		{
			e.getMessage();
		}
	} 

	@Test(priority=21,enabled = true) 
	public void RW_TC315_Validate_FullScreen_button_Displayed_onBottomRight_Corner_ofRegional_SatellitePageFor_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional page and Validate Full screen button displayed on Bottom Right corner"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.fullScreenButtonDisplayed());
	} 

	@Test(priority=22,enabled = true) 
	public void RW_TC315_Validate_FullScreen_Displayed_with_Timeslider_legends_with_textFor_Enchanced_Tab()
	{ 
		testStart("Navigate to Regional Satellite full screen page and Validate Timeline control ,Timeslider with play button and legend displayed"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	} 

	@Test(priority=23,enabled = true)
	public void RW_TC315_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_SatelliteMapFor_Enchanced_Tab()
	{
		testStart("Navigate to Regional Satellite full screen page and Validate Legend Clouds displayed with text Low and High");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3); 
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority=24,enabled = true)
	public void RW_TC315_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_SatelliteMapFor_Enchanced_Tab()
	{
		testStart("Navigate to Regional Satellite page and Validate legend cloud displayed with colors");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(2);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	//***** Validation of Standard Satellite Map ******//
	
	@Test(priority=25,enabled = true)
	public void RW_TC316_Navigate_to_Standard_Satellite_Map_From_Teritarytab_validate_Landing_page_URL()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Landing page URL ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilWindowExistsWithTitle(EXPECTED_URL_FOR_SATELLITE);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL_FOR_SATELLITE);
	}

	@Test(priority=26,enabled = true)
	public void RW_TC316_Navigate_to_Standard_Satellite_Map_from_tertiaryTab_validate_MapTitle()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Title displayed on the  Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilWindowExistsWithTitle(EXPECTED_URL_FOR_SATELLITE);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_STANDARD));
	}

	@Test(priority=27,enabled = true)
	public void RW_TC316_Validate_ToolTip_textDisplayed_for_Standard_SatelliteMap()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Tooltip text displayed on the  Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		satellitePage.clickOnToolTip();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.toolTipTextdisplayed().equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority=28,enabled = true)
	public void RW_TC316_Validate_ToolTip_highlighted_inOrange_for_Standard_SatelliteMap()
	{
		testStart("Navigate to Standard satellite Map from teritary tab and Validate Tooltip Highlighted when Active");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.toolTipActive();
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}

	@Test(priority=29,enabled = true)
	public void RW_TC316_Validate_ToolTip_Closes_when_Clicked_Twice_for_Standarad_Satellite_Map()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();	
	}

	@Test(priority=30,enabled = true) 
	public void RW_TC316_Validate_Zoom_Control_Buttons_displayed_Top_leftcorner_for_Standard_SatelliteMap() 
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and validate Validate Zoom Control Buttons displayed on Top leftcorner"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.zoomControlsDisplayedonTopLeftCorner());
	} 

	@Test(priority=31,enabled = true) 
	public void RW_TC316_Validate_Zoomin_Button_Functions_forStandard_SatelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate ZoomIn Control button functions as expected"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.zoominControls();
	} 

	@Test(priority=32,enabled = true) 
	public void RW_TC316_Validate_Zoomout_Button_Functions_forStandard_SatelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Zoom out Control button functions as expeceted"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.zoomoutControls();
	} 


	@Test(priority=33,enabled = true) 
	public void RW_TC317_Validate_Mapbox_Attribution_onBottomLeft_Corner_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.MapboxattributionDisplayedBottomLeft());
	} 


	@Test(priority=34,enabled = true) 
	public void RW_TC317_Validate_Landingpage_URL_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable(); 
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} 
	

	@Test(priority=35,enabled = true) 
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard teritary tab from Satellite Map and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}
	
	
	@Test(priority=36,enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_on_StandardMap()
	{
		testStart("Navigate to National Satellite page and Validate Clors displayed under legend Cloud ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilElementIsDisplayedOrClickable(); 
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	}
	
	@Test(priority=37,enabled = true) 
	public void RW_TC317_Validate_TimeDisplayed_onTimelineControls_on_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard teritary tab from Satellite Map  and Validate Timeline controls Time displayed for Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);

		String endTime=satellitePage.timeStampdisplayed();

		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		

		String startTime=satellitePage.timeStampdisplayed();

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60*60), EXPECTED_DIFFERENCE);
		} 

		catch (ParseException e)
		{
			e.getMessage();
		}
	} 
	
	@Test(priority=38,enabled = true) 
	public void RW_TC317_Validate_FullScreen_button_Displayed_onBottomRight_Corner_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard teritary tab from Satellite Map and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.fullScreenButtonDisplayed();
		Assert.assertTrue(satellitePage.fullScreenButtonDisplayed());
	} 
	
	@Test(priority=39,enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_StandardMap()
	{
		testStart("Navigate to Standard teritary tab from Satellite Map and Validate legend Cloud displayed with text High and Low");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.fullScreenButtonDisplayed();
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority=40,enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_StandardMap()
	{
		testStart("Navigate to National Satellite Standard Map page and Validate colors displayed under legend Cloud ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);;
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilElementIsDisplayedOrClickable(); 
		satellitePage.clikonFullScreen();
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	}

	@Test(priority=41,enabled = true) 
	public void RW_TC317_Validate_FullScreen_Standard_SatelliteMap_hasTimelineControl_Slider_legend()
	{ 
		testStart("Navigate to Standard satellite Full Screen Map and Validate Timeline control ,Timeslider with play button and legend displayed "); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilElementIsDisplayedOrClickable(); 
		satellitePage.clikonFullScreen();
		Sleeper.sleep(1);
		satellitePage.validateFullscreenMap();
	} 
	
	//****** Validation for Visible Satellite Map *******//
	
	@Test(priority=42,enabled = true)
	public void RW_TC318_Validate_Visible_Satellite_Map_Title()
	{
		testStart("Navigate to Visible Satellite Map from teritary tab and Validate Title of the map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		waitUntilWindowExistsWithTitle(expectedvisiblepageTitle);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_VISIBLE));
		
	}

	@Test(priority=43,enabled = true)
	public void RW_TC318_Validate_ToolTip_Displayed_for_visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip Displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		
	}

	@Test(priority=44,enabled = true)
	public void RW_TC318_Validate_ToolTip_Active_when_Clicked_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip active when clicked");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(1);
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
		
	}
	
	@Test(priority=45,enabled = true)
	public void RW_TC318_Validate_ToolTip_Text_Displayed_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip text displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(1);
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB));
		
	}

	@Test(priority=46,enabled = true)
	public void RW_TC318_Validate_ToolTip_Closes_when_Clicked_Twice_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();	
	}

	@Test(priority=47,enabled = true) 
	public void RW_TC318_Validate_Zoom_Control_Buttons_displayed_Top_leftcorner_for_Visible_SatelliteMap() 
	{ 
		testStart("Naviagte to Visible Satellite Map and Validate Zoom Control Buttons Displayed"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.zoomControlsDisplayedonTopLeftCorner());
		
	} 

	@Test(priority=48,enabled = true) 
	public void RW_TC318_Validate_Zoomin_Button_Functioning_onVisible_satelliteMap()
	{ 
		testStart("Navigate to Visible Satellite Map and Validate Zoom In Control button Funtions on Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.zoominControls();
	} 

	@Test(priority=49,enabled = true) 
	public void RW_TC318_Validate_Zoomout_Button_Functioning_onVisilbe_SatelliteMap()
	{ 
		testStart("Navigate to Visible Satellite Map and Validate Zoom out Control button Functions on Satellite Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.zoomoutControls();
	} 

	@Test(priority=50,enabled = true) 
	public void RW_TC319_Validate_Mapbox_Attribution_onBottomLeft_Corner_ofVisible_SatelliteMap()
	{ 
		testStart("Navigate to Visible satellite Map and Validate Mapbox attribution displayed"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.MapboxattributionDisplayedBottomLeft());
		
	} 


	@Test(priority=51,enabled = true) 
	public void RW_TC319_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_ofVisible_SatelliteMap()
	{ 
		testStart("Navigate to Visible satellite Map and Validate Mapbox landing page"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable(); 
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
		
	} 

	@Test(priority=52,enabled = true)
	public void RW_TC319_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Visible_SatelliteMap()
	{
		testStart("Navigate to Visible Satellite Map and Validate Legend cloud displayed  and text Clouds and Clear");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());
		
		
	}

	@Test(priority=53,enabled = true)
	public void RW_TC319_Validate_Legend_Clouds_Displayed_with_colors_for_Visible_SatelliteMap()
	{
		testStart("Navigate to Visible Satellite Map and Validate various colors displayed under legend cloud ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB); 
		satellitePage.colorsDisplayedforVisibleSatelliteMap();
	}

	@Test(priority=54,enabled = true) 
	public void RW_TC319_Validate_TimeDisplayed_onTimelineControls_for_Visible_SatelliteMap()
	{ 
		testStart("Navigate to Visible Satellite Map and Validate Time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB); 
		String endTime=satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		String startTime=satellitePage.timeStampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60*60), EXPECTED_DIFFERENCE);
		} 

		catch (ParseException e)
		{
			e.getMessage();
		}
	} 

	@Test(priority=55,enabled = true) 
	public void RW_TC319_Validate_FullScreen_button_Displayed_onBottomRight_Corner_for_Visible_SatelliteMap()
	{ 
		testStart("Navigate to Visible satellite Map and Validate Full screen Button displayed on Bottom Right corner of the Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.fullScreenButtonDisplayed());
		
	} 

	@Test(priority=56,enabled = true) 
	public void RW_TC319_Validate_FullScreen_Visible_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend()
	{ 
		testStart("Navigate to Visible satellite Full Screen View and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB); 
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.validateFullscreenMap());
		
	} 

	@Test(priority=57,enabled = true)
	public void RW_TC319_Validate_FullScreen_Visble_SatelliteMap_display_Legend_Clouds_andText_ClearandClouds()
	{
		testStart("Navigate to Visible Satellite Full screen view and Validate Legend cloud with text clouds and clear");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());
		
	}

	@Test(priority=58,enabled = true)
	public void RW_TC319_Validate_FullScreen_Visbile_SatelliteMap_Displayed_with_legend_colors()
	{
		testStart("Navigate to Visible Satellite full screen view and Validate legends colors displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL); 
		Sleeper.sleep(2);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	 //******Validating WaterVapor Satellite Map *************//

	@Test(priority=59,enabled = true)
	public void RW_TC320_Navigation_toWaterVapor_Satellite_Map_Validate_Title_()
	{
		testStart("Navigate to WaterVapor Satellite Map from teritary tab and Validate Title of the map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		waitUntilWindowExistsWithTitle(expectedvisiblepageTitle);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_WATERVAPOR));
			
	}

	@Test(priority=60,enabled = true)
	public void RW_TC320_Validate_ToolTip_Displayed_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip Displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		
	}

	@Test(priority=61,enabled = true)
	public void RW_TC320_Validate_ToolTip_Active_when_Clicked_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip active when clicked");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
		
	}
	
	@Test(priority=62,enabled = true)
	public void RW_TC320_Validate_ToolTip_Text_Displayed_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip text displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();	
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB));
		
	}

	@Test(priority=63,enabled = true)
	public void RW_TC320_Validate_ToolTip_Closes_when_Clicked_Twice_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();	
	}

	@Test(priority=64,enabled = true) 
	public void RW_TC320_Validate_Zoom_Control_Buttons_displayed_Top_leftcorner_for_WaterVapor_SatelliteMap() 
	{ 
		testStart("Naviagte to WaterVapor Satellite Map and validate Validate Zoom Control Buttons"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Assert.assertTrue(satellitePage.zoomControlsDisplayedonTopLeftCorner());
	
	} 

	@Test(priority=65,enabled = true) 
	public void RW_TC320_Validate_Zoomin_Button_Functioning_onWaterVapor_satelliteMap()
	{ 
		testStart("Navigate to WaterVapor Satellite Map and Validate Zoom In Control button Funtions on Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.zoominControls();
	} 

	@Test(priority=66,enabled = true) 
	public void RW_TC320_Validate_Zoomout_Button_Functioning_onWaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor Satellite Map and Validate Zoom out Control button Functions on Satellite Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.zoomoutControls();
	} 


	@Test(priority=67,enabled = true) 
	public void RW_TC320_Validate_Mapbox_Attribution_onBottomLeft_Corner_of_WaterVaporSatelliteMap()
	{ 
		testStart("Navigate to WaterVapor satellite Map and Validate Mapbox attribution displayed"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Assert.assertTrue(satellitePage.MapboxattributionDisplayedBottomLeft());		
	} 


	@Test(priority=68,enabled = true) 
	public void RW_TC321_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_forWaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor satellite Map and Validate Mapbox landing page"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable(); 
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
		
	} 

	@Test(priority=69,enabled = true)
	public void RW_TC321_Validate_Legend_WaterVapor_Displayed_withtext_DryandMoist()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Legend WaterVapor displayed with text Dry and Moist");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());
		
	}

	@Test(priority=70,enabled = true)
	public void RW_TC321_Validate_Legend_WaterVapor_Displayed_with_colors_forWaterVapor_SatelliteMap()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate various colors displayed under legend WaterVapor ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB); 
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}

	@Test(priority=71,enabled = true) 
	public void RW_TC321_Validate_TimeDisplayed_onTimelineControls_for_WaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor Satellite Map and Validate Time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB); 
		String endTime=satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();

		String startTime=satellitePage.timeStampdisplayed();

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try 
		{
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime(); 
			Assert.assertEquals(difference/(1000*60*60), EXPECTED_DIFFERENCE);
		} 

		catch (ParseException e)
		{
			e.getMessage();
		}
	} 

	@Test(priority=72,enabled = true) 
	public void RW_TC321_Validate_FullScreen_button_Displayed_onBottomRight_Corner_for_WaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor satellite Map and Validate Full screen Button displayed on Bottom Right corner of the Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);  
		Assert.assertTrue(satellitePage.fullScreenButtonDisplayed());
		
	} 

	@Test(priority=73,enabled = true) 
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend()
	{ 
		testStart("Navigate to WaterVapor Satellite Map for fullscreen and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);  
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.validateFullscreenMap());
		
	} 

	@Test(priority=74,enabled = true)
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_display_Legend_WaterVapor_andText_DryandMoist()
	{
		testStart("Navigate to WaterVapor Satellite map Full screen view and Validate Legend WaterVapor with text Dry and Moist");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());
		
	}

	@Test(priority=75,enabled = true)
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_legend_and_colors()
	{
		testStart("Navigate to WaterVapor Satellite full screen view and Validate legends colors displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedlandingpageURL); 
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}	

}

