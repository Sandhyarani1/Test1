package com.accuweather.glacier.www.nationalsatellitepage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.RadarPage;
import com.accuweather.glacier.www.pages.SatellitePage;
import com.chameleon.utils.Sleeper;


public class Test_NationalSatellitePage extends AccuWeatherBaseTest
{

	String citySearchedByName="Washington";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedlandingpageURL="https://qualityassurance.accuweather.com/en/us/national/satellite";
	String expectedSatellitepageTitle="United States Enhanced Weather Satellite Map - AccuWeather.com";
	String expectedvisiblepageTitle="https://qualityassurance.accuweather.com/en/us/national/satellite-vis";
	
	private static final String STANDARD_TAB="Standard";  
	private static final String VISIBLE_TAB="Visible";  
	private static final String WATERVAPOR_TAB="WaterVapor";

	private static final String EXPECTED_SATELLITETAB_HIGHLIGHTED ="#f05514";

	private static final String EXPECTED_TITLE_OF_MAP_ENCHANCED = "Enhanced Satellite for United States";
	private static final String EXPECTED_TITLE_OF_MAP_STANDARD ="Standard Satellite for United States";
	private static final String EXPECTED_TITLE_OF_MAP_VISIBLE="Visible Satellite for United States";
	private static final String EXPECTED_TITLE_OF_MAP_WATERVAPOR="Water Vapor Satellite for United States";
	
	private static final String EXPECTED_TOOL_TIP_COLOR="#f59721";

	private static final String EXPECTED_TOOL_TIPTEXT = "This map displays the infrared band of light and show relative warmth of objects. Infrared imagery is useful for determining clouds both at day and night. Colder objects are brighter and warmer objects are darker. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB="This map shows how the human eye would see the atmosphere from the satellite. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB="This image is taken using a wavelength sensitive to the content of water vapor in the atmosphere. Water vapor imagery is useful for both determining locations of moisture and atmospheric circulations that may affect your area.";
	
	private static final int EXPECTED_DIFFERENCE =5;
	private static final String MAP_BOX_LANDING_PAGE_URL="https://www.mapbox.com/";
	private static final String EXPECTED_URL_FOR_SATELLITE="https://qualityassurance.accuweather.com/en/us/national/satellite-ir";


	RadarPage radarPage=new RadarPage();
	private SatellitePage satellitePage=new SatellitePage();

	@Test(priority=1,enabled = true)
	public void RW_TC218_National_Satellite_page_loads_succesfully()
	{
		testStart("Validate National Satellite page is loaded successfully");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		Sleeper.sleep(5);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedlandingpageURL);
	}
	
	@Test(priority = 2, enabled = true)
	public void RW_TC293_Validate_Satellite_tab_Highlighted_byDefault_onSecondary_Navigations_menus() {
		testStart("Validate Satellite Tab highlighted in orange by default on secondary navigations menus.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(5);
		Assert.assertEquals(satellitePage.satelliteTabHighlighted(), EXPECTED_SATELLITETAB_HIGHLIGHTED);
	}

	@Test(priority=3,enabled = true)
	public void RW_TC218_validate_Secondary_navigations_menus_displayedon_National_Satellite_page()
	{
		testStart("Validate secondary navigations menus displayed on national satellite page.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.validateSecondaryMenusDisplayed());		
	}

	
	@Test(priority=4,enabled = true)
	public void RW_TC218_f_Validate_Title_of_map_displayed_on_National_Satellite_page()
	{
		testStart("Validate Title of the map displayed on National Satellite Map.");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_ENCHANCED));
		
	}

	@Test(priority=5,enabled = true)
	public void RW_TC219_Validate_ToolTip_Active_when_Clicked_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to National Satellite page and Validate Tooltip Active when Clicked ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}
	
	@Test(priority=6,enabled = true)
	public void RW_TC219_Validate_ToolTip_Text_Displayed_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to National Satellite page and Validate text displayed ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(5);
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority=7,enabled = true)
	public void RW_TC219_Validate_ToolTip_Closes_when_Clicked_Twice_for_Enchanced_Satellite_Map()
	{
		testStart("Navigate to National Satellite page and Validate Tooltip closes when clicked twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(5);
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(4);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(5);
	}

	
	@Test(priority=8,enabled = true) 
	public void RW_TC219_Validate_Zoom_Button_working_onNational_satellitePage_For_Enchanced_Tab()
	{ 
		testStart("Navigate to National satellite page and Validate Zoom  Control button Functioning as expeceted"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	} 

	@Test(priority=9,enabled = true) 
	public void RW_TC220_Validate_Mapbox_Attribution_Landing_Page_UrlFor_Enchanced_Tab()
	{ 
		testStart("Navigate to National satellite page and Validate Mapbox landing page For Enchanced Tab"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} 

	@Test(priority=10,enabled = true)
	public void RW_TC220_Validate_Legend_Clouds_Displayed_withText_LowandHigh_for_National_SatelliteMapFor_Enchanced_Tab()
	{
		testStart("Navigate to National Satellite Map and Validate Legend cloud displayed and text High and Low For Enchanced Tab");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL); 
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority=11,enabled = true)
	public void RW_TC220_Validate_Legend_Clouds_Displayed_with_colors_SatelliteMapFor_Enchanced_Tab()
	{
		testStart("Navigate to National Satellite Map and Validate legend cloud displayed with colors ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL); 
		Sleeper.sleep(5);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	@Test(priority=12,enabled = false) 
	public void RW_TC220_Validate_TimeDisplayed_onTimelineControls_of_SatelliteMapFor_Enchanced_Tab()
	{ 
		testStart("Navigate to satellite page and Validate time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(5);
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

	@Test(priority=13,enabled = true) 
	public void RW_TC220_Validate_FullScreen_Displayed_with_Timeslider_legends_with_textFor_Enchanced_Tab()
	{ 
		testStart("Navigate to National Satellite full screen page and Validate Timeline control ,Timeslider with play button and legend displayed"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	} 


	 //******Validating Standard Satellite Map *************//
	
	
	@Test(priority=14,enabled = true)
	public void RW_TC221_a_Navigate_to_Standard_tertiary_from_National_Stalellite_Map_validate_Title()
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

	@Test(priority=15,enabled = true)
	public void RW_TC221_b_Validate_ToolTip_textDisplayed_for_Standard_Satellite_Map()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Tooltip text displayed on the  Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.toolTipTextdisplayed().equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority=16,enabled = true)
	public void RW_TC221_c_Validate_ToolTip_highlighted_inOrange_when_clicked_for_Standard_SatelliteMap()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Tooltip Highlighted when Active");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(5);
		satellitePage.toolTipActive();
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}

	@Test(priority=17,enabled = true)
	public void RW_TC221_d_Validate_ToolTip_Closes_when_Clicked_Twice_for_Standard_Satellite_Map()
	{
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(4);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(5);
	}

	

	@Test(priority=18,enabled = true) 
	public void RW_TC221_f_Validate_Zoom_Button_Functions_onStandard_satelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Zoom Control button functions as expected"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.zoominControls();
		Sleeper.sleep(5);
		satellitePage.zoomoutControls();
	} 

	@Test(priority=19,enabled = true) 
	public void RW_TC222_Validate_Landingpage_URL_when_clicked_onMapbox_Attribution_onBottomLeft_Corner_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} 
	

	@Test(priority=20,enabled = false) 
	public void RW_TC222_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard teritary tab from Satellite Map and Validate Mapbox attribution displayed on Bottom left corner of Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}
	
	
	@Test(priority=21,enabled = true)
	public void RW_TC222_Validate_Legend_Clouds_Displayed_with_colors_on_StandardMap()
	{
		testStart("Navigate to National Satellite page and Validate Tooltip displayed on the  Map ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		waitUntilElementIsDisplayedOrClickable(); 
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	}
	
	@Test(priority=22,enabled = false) 
	public void RW_TC222_Validate_TimeDisplayed_onTimelineControls_on_Standard_SatelliteMap()
	{ 
		testStart("Navigate to Standard teritary tab from Satellite Map  and Validate Timeline controls Time displayed for Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(4);

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
	

	@Test(priority=23,enabled = true)
	public void RW_TC222_Validate_FullScreen_StandardMap_Displayedwith_Timelinecontrols_playbutton()
	{
		testStart("Navigate to National Satellite page and Validate Full screen map displayed with Timeslider ,Timelinecontrols and Legends ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL); 
		Sleeper.sleep(5);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.validateFullscreenMap());
	}


	 //******Validating Visible Satellite Map *************//

	@Test(priority=24,enabled = true)
	public void RW_TC223_Navigate_Visible_Satellite_Map_Validate_Title()
	{
		testStart("Navigate to Visible Satellite Map from teritary tab and Validate Title of the map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		waitUntilWindowExistsWithTitle(expectedvisiblepageTitle);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_VISIBLE));
		
	}

	@Test(priority=25,enabled = true)
	public void RW_TC223_Validate_ToolTip_Active_when_Clicked_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip active when clicked");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clickOnToolTip();
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
		
	}
	
	@Test(priority=26,enabled = true)
	public void RW_TC223_Validate_ToolTip_Text_Displayed_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip text displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.clickOnToolTip();	
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB));
		
	}

	@Test(priority=27,enabled = true)
	public void RW_TC223_Validate_ToolTip_Closes_when_Clicked_Twice_for_Visible_Satellite_Map()
	{
		testStart("Navigate to Visible Satellite Map and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		waitUntilWindowExistsWithTitle(expectedlandingpageURL);		
		Sleeper.sleep(5);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(4);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(3);
	}

	
	@Test(priority=28,enabled = true) 
	public void RW_TC223_Validate_Zoom_Button_Functioning_onVisible_satelliteMap()
	{ 
		testStart("Navigate to Visible Satellite Map and Validate Zoom In Control button Funtions on Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();		
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.zoominControls();
		Sleeper.sleep(4);
		satellitePage.zoomoutControls();
		
	} 


	@Test(priority=30,enabled = true) 
	public void RW_TC224_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_ofVisible_SatelliteMap()
	{ 
		testStart("Navigate to Visible satellite Map and Validate Mapbox landing page"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(4);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable(); 
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
		
	} 

	@Test(priority=31,enabled = true)
	public void RW_TC224_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Visible_SatelliteMap()
	{
		testStart("Navigate to Visible Satellite Map and Validate Legend cloud displayed  and text Clouds and Clear");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();		
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());
		
		
	}

	@Test(priority=32,enabled = true)
	public void RW_TC224_Validate_Legend_Clouds_Displayed_with_colors_for_Visible_SatelliteMap()
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

	@Test(priority=33,enabled = false) 
	public void RW_TC224_Validate_TimeDisplayed_onTimelineControls_for_Visible_SatelliteMap()
	{ 
		testStart("Navigate to Visible Satellite Map and Validate Time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
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

	
	@Test(priority=34,enabled = true) 
	public void RW_TC224_Validate_FullScreen_Visible_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend()
	{ 
		testStart("Navigate to Visible satellite Full Screen View and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB); 
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.validateFullscreenMap());
		
	} 

		 //******Validating WaterVapor Satellite Map *************//

	@Test(priority=37,enabled = true)
	public void RW_TC225_Navigate_WaterVapor_Satellite_Map_Validate_Title_()
	{
		testStart("Navigate to WaterVapor Satellite Map from teritary tab and Validate Title of the map");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		waitUntilWindowExistsWithTitle(expectedvisiblepageTitle);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_WATERVAPOR));
			
	}


	@Test(priority=38,enabled = true)
	public void RW_TC225_Validate_ToolTip_Active_when_Clicked_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip active when clicked");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();
		String actualTooltipColor=satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
		
	}
	
	@Test(priority=39,enabled = true)
	public void RW_TC225_Validate_ToolTip_Text_Displayed_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip text displayed");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(2);
		String actualTooltipText=satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB));
		
	}

	@Test(priority=40,enabled = true)
	public void RW_T25_Validate_ToolTip_Closes_when_Clicked_Twice_for_WaterVapor_Satellite_Map()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip Closes when clicked Twice ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(4);
		satellitePage.clickOnToolTip();	
		Sleeper.sleep(3);
	}

	
	@Test(priority=41,enabled = true) 
	public void RW_TC225_Validate_Zoom_Button_Functioning_onWaterVapor_satelliteMap()
	{ 
		testStart("Navigate to WaterVapor Satellite Map and Validate Zoom In Control button Funtions on Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.zoominControls();
		Sleeper.sleep(5);
		satellitePage.zoomoutControls();
	} 
	
	@Test(priority=42,enabled = true) 
	public void RW_TC226_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_forWaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor satellite Map and Validate Mapbox landing page"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		String actualLandingpageUrl= satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
		
	} 

	@Test(priority=43,enabled = true)
	public void RW_TC226_Validate_Legend_WaterVapor_Displayed_withtext_DryandMoist()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate Legend WaterVapor displayed with text Dry and Moist");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());
		
	}

	@Test(priority=44,enabled = true)
	public void RW_TC226_Validate_Legend_WaterVapor_Displayed_with_colors_forWaterVapor_SatelliteMap()
	{
		testStart("Navigate to WaterVapor Satellite Map and Validate various colors displayed under legend WaterVapor ");
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB); 
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}

	@Test(priority=45,enabled = false) 
	public void RW_TC226_Validate_TimeDisplayed_onTimelineControls_for_WaterVapor_SatelliteMap()
	{ 
		testStart("Navigate to WaterVapor Satellite Map and Validate Time displayed on Timeline controls"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
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

	
	@Test(priority=46,enabled = true) 
	public void RW_TC226_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend()
	{ 
		testStart("Navigate to WaterVapor Satellite Map for fullscreen and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map"); 
		radarPage.searchCityByName(citySearchedByName);    
		radarPage.selectCityByName(); 
		waitUntilElementIsDisplayedOrClickable(); 
		waitUntilWindowExistsWithTitle(expectedHomePageTitle); 
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();	
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);  
		Sleeper.sleep(5);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.validateFullscreenMap());
		
	} 

	
}
