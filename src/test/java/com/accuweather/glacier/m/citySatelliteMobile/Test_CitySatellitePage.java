package com.accuweather.glacier.m.citySatelliteMobile;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.SatellitePageMobile;
import com.chameleon.utils.Sleeper;

public class Test_CitySatellitePage extends AccuWeatherMobileBaseTest {

	String citySearchedByName = "Rio ";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedlandingpageURL = "https://qualityassurance.accuweather.com/en/us/michigan/satellite";
	String zipcode = "48073";

	private static final String EXPECTED_SATELLITETAB_HIGHLIGHTED = "#f05514";
	private static final String EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT = "#ec5f17";
	private static final String EXPECTED_TOOL_TIP_COLOR = "#f59721";

	private static final String STANDARD_TAB = "Standard";
	private static final String VISIBLE_TAB = "Visible";
	private static final String WATERVAPOR_TAB = "WaterVapor";

	private static final String EXPECTED_TITLE_OF_MAP_ENCHANCED = "Enhanced Satellite for Michigan";
	private static final String EXPECTED_TITLE_OF_MAP_STANDARD = "Standard Satellite for Michigan";
	private static final String EXPECTED_TITLE_OF_MAP_VISIBLE = "Visible Satellite for Michigan";
	private static final String EXPECTED_TITLE_OF_MAP_WATERVAPOR = "Water Vapor Satellite for Michigan";

	private static final String EXPECTED_TOOL_TIPTEXT = "This map displays the infrared band of light and show relative warmth of objects. Infrared imagery is useful for determining clouds both at day and night. Colder objects are brighter and warmer objects are darker. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_VISIBLE_SATELLITE_MAP = "This map shows how the human eye would see the atmosphere from the satellite. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_WATERVAPOR_SATELLITE_MAP = "This image is taken using a wavelength sensitive to the content of water vapor in the atmosphere. Water vapor imagery is useful for both determining locations of moisture and atmospheric circulations that may affect your area.";

	private static final int EXPECTED_DIFFERENCE = 5;
	private static final String MAP_BOX_LANDING_PAGE_URL = "https://www.mapbox.com/";

	String expectedvisiblepageTitle = "qualityassurance.accuweather.com/en/us/illinois/satellite-vis";

	private static final String EXPECTED_URL_FOR_SATELLITE = "https://qualityassurance.accuweather.com/en/us/michigan/satellite-ir";

	private SatellitePageMobile satellitePage = new SatellitePageMobile();
	private LandingPageMobile landingPage = new LandingPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_TC293_City_Satellite_page_loads_succesfully() {
		testStart("Validate City Satellite page is loaded successfully");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedlandingpageURL);
	}

	@Test(priority = 2, enabled = true)
	public void RW_TC293_Validate_Satellite_tab_Highlighted_byDefault_onSecondary_Navigations_menus() {
		testStart("Validate Satellite Tab highlighted in orange by default on secondary navigations menus.");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(satellitePage.satelliteTabHighlighted(), EXPECTED_SATELLITETAB_HIGHLIGHTED);
	}

	@Test(priority = 3, enabled = true)
	public void RW_TC293_Validate_Enchanced_tab_Highlighted_byDefault_onTeritary_Navigations_menus_forCity_Satellite_Map() {
		testStart("Validate Enchanced tab highlighted in orange by default on teritary navigations menus.");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		Assert.assertEquals(satellitePage.EnchancedTabHighlighted(), EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT);
	}


	@Test(priority = 4, enabled = true)
	public void RW_TC293_Validate_Tertiary_menu_Displayed_on_City_Satellite_Map() {
		testStart("Validate Teritary menus  displayed on Tertiary menus of City satellite Map.");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.validateTeritaryMenusDisplayed());
	}

	@Test(priority = 5, enabled = true)
	public void RW_TC293_Validate_Title_of_map_displayed_on_Enchanced_City_Satellite_page() {
		testStart("Validate Title of the map displayed on City Satellite Page.");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_ENCHANCED));

	}


	@Test(priority = 6, enabled = true)
	public void RW_TC294_Validate_ToolTip_Active_when_Clicked_for_Enchanced_City_Satellite_Map() {
		testStart("Navigate to Enchanced Satellite page and Validate Tooltip Active when Clicked ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}

	@Test(priority = 7, enabled = true)
	public void RW_TC294_Validate_ToolTip_Text_Displayed_for_Enchanced_City_Satellite_Map() {
		testStart("Navigate to Enchanced Satellite page and Validate Tool tip text displayed ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority = 8, enabled = true)
	public void RW_TC294_Validate_ToolTip_Closes_when_Clicked_Twice_for_Enchanced_City_Satellite_Map() {
		testStart("Navigate to Enchanced Satellite page and Validate Tooltip closes when clicked twice ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		
	}

	@Test(priority = 9, enabled = true)
	public void RW_TC294_Validate_Zoom_Button_working_onEnchanced_City_Satellite_Page() {
		testStart("Navigate to Enchanced satellite page and Validate Zoom  Control button Functioning as expeceted");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.zoominControls();
		Sleeper.sleep(5);
		satellitePage.zoomoutControls();
	}

	

	@Test(priority = 10, enabled = true)
	public void RW_TC315_Validate_Mapbox_Attribution_Landing_Page_UrlFor_Enchanced_Tab() {
		testStart("Navigate to City satellite page and Validate Mapbox landing page For Enchanced Tab");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(8);
		waitUntilElementIsDisplayedOrClickable();
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	}

	@Test(priority = 11, enabled = true)
	public void RW_TC295_Validate_Legend_Clouds_Displayed_withText_LowandHigh_for_City_SatelliteMapFor_Enchanced_Tab() {
		testStart(
				"Navigate to City Satellite Map and Validate Legend cloud displayed with text High and Low For Enchanced Tab");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority = 12, enabled = true)
	public void RW_TC295_Validate_Legend_Clouds_Displayed_with_colors_CitySatelliteMapFor_Enchanced_Tab() {
		testStart("Navigate to City Satellite Map and Validate legend cloud displayed with colors ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	@Test(priority = 13, enabled = true)
	public void RW_TC295_Validate_TimeDisplayed_onTimelineControls_of_CitySatelliteMapFor_Enchanced_Tab() {
		testStart("Navigate City page and Validate time displayed on Timeline controls");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		String endTime = satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		String startTime = satellitePage.timeStampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime();
			Assert.assertEquals(difference / (1000 * 60 * 60), EXPECTED_DIFFERENCE);
		} catch (ParseException e) {
			e.getMessage();
		}
	}

	
	@Test(priority = 14, enabled = true)
	public void RW_TC295_Validate_FullScreen_Displayed_with_Timeslider_legends_with_textFor_Enchanced_Tab() {
		testStart(
				"Navigate to City Satellite full screen page and Validate Timeline control ,Timeslider with play button and legend displayed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	}

	@Test(priority = 15, enabled = true)
	public void RW_TC295_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_SatelliteMapFor_Enchanced_Tab() {
		testStart(
				"Navigate to City Satellite full screen page and Validate Legend Clouds displayed with text Low and High");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority = 16, enabled = true)
	public void RW_TC295_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_SatelliteMapFor_Enchanced_Tab() {
		testStart("Navigate to City Satellite page and Validate legend cloud displayed with colors");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.clikonFullScreen();
		Sleeper.sleep(5);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	// ***** Validation of Standard Satellite Map ******//

	@Test(priority = 17, enabled = true)
	public void RW_TC296_Navigate_to_Standard_CitySatellite_Map_From_Teritarytab_validate_Landing_page_URL() {
		testStart("Navigate to Standard City Satellite Map from teritary tab and Validate Landing page URL ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL_FOR_SATELLITE);
	}

	@Test(priority = 18, enabled = true)
	public void RW_TC296_Navigate_to_Standard_CitySatellite_Map_from_tertiaryTab_validate_MapTitle() {
		testStart(
				"Navigate to Standard City Satellite Map from teritary tab and Validate Title displayed on the  Map ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		waitUntilWindowExistsWithTitle(EXPECTED_TITLE_OF_MAP_STANDARD);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_STANDARD));
	}

	@Test(priority = 19, enabled = true)
	public void RW_TC296_Validate_ToolTip_textDisplayed_for_Standard_CitySatelliteMap() {
		testStart(
				"Navigate to Standard City Satellite Map from teritary tab and Validate Tooltip text displayed on the  Map ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(satellitePage.toolTipTextdisplayed().equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority = 20, enabled = true)
	public void RW_TC296_Validate_ToolTip_highlighted_inOrange_for_Standard_CitySatelliteMap() {
		testStart(
				"Navigate to Standard City satellite Map from teritary tab and Validate Tooltip Highlighted when Active");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		satellitePage.toolTipActive();
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}

	@Test(priority = 21, enabled = true)
	public void RW_TC296_Validate_ToolTip_Closes_when_Clicked_Twice_for_Standarad_CitySatellite_Map() {
		testStart(
				"Navigate to Standard City Satellite Map from teritary tab and Validate Tooltip Closes when clicked Twice ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}

	

	@Test(priority = 22, enabled = true)
	public void RW_TC296_Validate_Zoom_Button_Functions_forStandard_CitySatelliteMap() {
		testStart(
				"Navigate to Standard City Satellite Map from teritary tab and Validate Zoom Control button functions as expected");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.zoominControls();
		Sleeper.sleep(2);
		satellitePage.zoomoutControls();
	}

	
	@Test(priority = 23, enabled = true)
	public void RW_TC297_Validate_Landingpage_URL_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_for_Standard_CitySatelliteMap() {
		testStart(
				"Navigate to City Standard Satellite Map from teritary tab and Validate Mapbox attribution displayed on Bottom left corner of Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(8);
		waitUntilElementIsDisplayedOrClickable();
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	}

	@Test(priority = 24, enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Standard_CitySatelliteMap() {
		testStart(
				"Navigate to City Standard teritary tab from Satellite Map and Validate Mapbox attribution displayed on Bottom left corner of Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority = 25, enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_on_Standard_City_SatelliteMap() {
		testStart("Navigate to City Standards Satellite page and Validate Colors displayed below the legend Cloud ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	}

	@Test(priority = 26, enabled = true)
	public void RW_TC317_Validate_TimeDisplayed_onTimelineControls_on_Standard_City_SatelliteMap() {
		testStart(
				"Navigate to City Standard Satellite Map  and Validate Timeline controls Time displayed for Full screen Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		String endTime = satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		String startTime = satellitePage.timeStampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime();
			Assert.assertEquals(difference / (1000 * 60 * 60), EXPECTED_DIFFERENCE);
		} catch (ParseException e) {
			e.getMessage();
		}
	}

	
	@Test(priority = 27, enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_Standard_City_SatelliteMap() {
		testStart(
				"Navigate to City Standard Satellite Map from  teritary tab and Validate legend Cloud displayed with text High and Low");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.fullScreenButtonDisplayed();
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority = 28, enabled = true)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_Standard_City_SatelliteMap() {
		testStart("Navigate to City Satellite Standard Map and Validate colors displayed under legend Cloud ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(2);
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	}

	@Test(priority = 29, enabled = true)
	public void RW_TC317_Validate_FullScreen_Standard_City_SatelliteMap_hasTimelineControl_Slider_legend() {
		testStart(
				"Navigate to City Standard satellite Full Screen Map and Validate Timeline control ,Timeslider with play button and legend displayed ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(2);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.validateFullscreenMap();
	}

	// ****** Validation for Visible Satellite Map *******//

	@Test(priority = 30, enabled = true)
	public void RW_TC318_Validate_Visible_City_Satellite_Map_Title() {
		testStart("Navigate to Visible City Satellite Map from teritary tab and Validate Title of the map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_VISIBLE));

	}

	@Test(priority = 31, enabled = true)
	public void RW_TC318_Validate_ToolTip_Active_when_Clicked_for_Visible_City_Satellite_Map() {
		testStart("Navigate to Visible City Satellite Map and Validate Tooltip active when clicked");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);

	}

	@Test(priority = 32, enabled = true)
	public void RW_TC318_Validate_ToolTip_Text_Displayed_for_Visible_City_Satellite_Map() {
		testStart("Navigate to Visible City Satellite Map and Validate Tooltip text displayed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_VISIBLE_SATELLITE_MAP));

	}

	@Test(priority = 33, enabled = true)
	public void RW_TC318_Validate_ToolTip_Closes_when_Clicked_Twice_for_Visible_City_Satellite_Map() {
		testStart("Navigate to Visible City Satellite Map and Validate Tooltip Closes when clicked Twice ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}


	@Test(priority = 34, enabled = true)
	public void RW_TC318_Validate_Zoom_Button_Functioning_onVisible_City_SatelliteMap() {
		testStart("Navigate to Visible City Satellite Map and Validate Zoom  Control button Funtions on Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.zoominControls();
		Sleeper.sleep(2);
		satellitePage.zoomoutControls();
	}

	
	
	@Test(priority = 35, enabled = true)
	public void RW_TC299_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_ofVisible_City_SatelliteMap() {
		testStart("Navigate to Visible City Satellite Map and Validate Mapbox landing page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(8);
		waitUntilElementIsDisplayedOrClickable();
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);

	}

	@Test(priority = 36, enabled = true)
	public void RW_TC299_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Visible_City_SatelliteMap() {
		testStart(
				"Navigate to Visible City Satellite Map and Validate Legend cloud displayed  and text Clouds and Clear");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());

	}

	@Test(priority = 37, enabled = true)
	public void RW_TC299_Validate_Legend_Clouds_Displayed_with_colors_for_Visible_City_SatelliteMap() {
		testStart("Navigate to Visible City Satellite Map and Validate various colors displayed under legend cloud ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.colorsDisplayedforVisibleSatelliteMap();

	}

	@Test(priority = 38, enabled = true)
	public void RW_TC299_Validate_TimeDisplayed_onTimelineControls_for_Visible_City_SatelliteMap() {
		testStart("Navigate to Visible City Satellite Map and Validate Time displayed on Timeline controls");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		String endTime = satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		String startTime = satellitePage.timeStampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime();
			Assert.assertEquals(difference / (1000 * 60 * 60), EXPECTED_DIFFERENCE);
		} catch (ParseException e) {
			e.getMessage();
		}
	}

	
	@Test(priority = 39, enabled = true)
	public void RW_TC299_Validate_FullScreen_Visible_City_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend() {
		testStart(
				"Navigate to Visible City satellite Full Screen View and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.validateFullscreenMap());
	}

	@Test(priority = 40, enabled = true)
	public void RW_TC299_Validate_FullScreen_Visble_City_SatelliteMap_display_Legend_Clouds_andText_ClearandClouds() {
		testStart(
				"Navigate to Visible City Satellite Full screen view and Validate Legend cloud with text clouds and clear");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(2);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());
	}

	@Test(priority = 41, enabled = true)
	public void RW_TC299_Validate_FullScreen_Visbile_City_SatelliteMap_Displayed_with_legend_colors() {
		testStart("Navigate to Visible City Satellite full screen view and Validate legends colors displayed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(2);
		satellitePage.colorsDisplayedforVisibleSatelliteMap();
	}

	// ******Validating WaterVapor Satellite Map *************//

	@Test(priority = 42, enabled = true)
	public void RW_TC300_Navigation_toWaterVapor_City_Satellite_Map_Validate_Title_() {
		testStart("Navigate to WaterVapor City Satellite Map from teritary tab and Validate Title of the map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_WATERVAPOR));

	}



	@Test(priority = 43, enabled = true)
	public void RW_TC300_Validate_ToolTip_Active_when_Clicked_for_WaterVapor_City_Satellite_Map() {
		testStart("Navigate to WaterVapor City Satellite Map and Validate Tooltip active when clicked");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}

	@Test(priority = 44, enabled = true)
	public void RW_TC300_Validate_ToolTip_Text_Displayed_for_WaterVapor_City_Satellite_Map() {
		testStart("Navigate to WaterVapor City Satellite Map and Validate Tooltip text displayed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_WATERVAPOR_SATELLITE_MAP));
	}

	@Test(priority = 45, enabled = true)
	public void RW_TC300_Validate_ToolTip_Closes_when_Clicked_Twice_for_WaterVapor_City_Satellite_Map() {
		testStart("Navigate to WaterVapor City Satellite Map and Validate Tooltip Closes when clicked Twice ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}

	@Test(priority = 46, enabled = true)
	public void RW_TC300_Validate_Zoom_Button_Functioning_onWaterVapor_City_SatelliteMap() {
		testStart("Navigate to WaterVapor City Satellite Map and Validate Zoom  Control button Funtions on Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	}

	
	@Test(priority = 47, enabled = true)
	public void RW_TC301_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_forWaterVapor_SatelliteMap() {
		testStart("Navigate to WaterVapor City  Satellite Map and Validate Mapbox landing page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(8);
		waitUntilElementIsDisplayedOrClickable();
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);

	}

	@Test(priority = 48, enabled = true)
	public void RW_TC301_Validate_Legend_WaterVapor_Displayed_withtext_DryandMoist() {
		testStart(
				"Navigate to WaterVapor CitySatellite Map and Validate Legend WaterVapor displayed with text Dry and Moist");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());

	}

	@Test(priority = 49, enabled = true)
	public void RW_TC301_Validate_Legend_WaterVapor_Displayed_with_colors_forWaterVapor_SatelliteMap() {
		testStart(
				"Navigate to WaterVapor City Satellite Map and Validate various colors displayed under legend WaterVapor ");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}

	@Test(priority = 50, enabled = true)
	public void RW_TC301_Validate_TimeDisplayed_onTimelineControls_for_WaterVapor_SatelliteMap() {
		testStart("Navigate to WaterVapor City Satellite Map and Validate Time displayed on Timeline controls");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		String endTime = satellitePage.timeStampdisplayed();
		satellitePage.clickonPlayButton();
		satellitePage.clickonPauseButton();
		String startTime = satellitePage.timeStampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime();
			Assert.assertEquals(difference / (1000 * 60 * 60), EXPECTED_DIFFERENCE);
		} catch (ParseException e) {
			e.getMessage();
		}
	}

	
	@Test(priority = 51, enabled = true)
	public void RW_TC301_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend() {
		testStart(
				"Navigate to WaterVapor City Satellite Map for fullscreen and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	}

	@Test(priority = 52, enabled = true)
	public void RW_TC301_Validate_FullScreen_WaterVapor_City_SatelliteMap_display_Legend_WaterVapor_andText_DryandMoist() {
		testStart(
				"Navigate to WaterVapor City Satellite Full screen view and Validate Legend WaterVapor with text Dry and Moist");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());

	}

	@Test(priority = 53, enabled = true)
	public void RW_TC301_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_legend_and_colors() {
		testStart("Navigate to WaterVapor City Satellte Map Full Screen view and Validate legends colors displayed");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		satellitePage.clickBreadCrumbMenu();
		satellitePage.clickBreadCrumbMenuRadarAndMaps();
		satellitePage.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}
}
