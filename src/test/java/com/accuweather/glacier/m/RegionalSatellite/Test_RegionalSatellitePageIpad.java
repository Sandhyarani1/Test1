package com.accuweather.glacier.m.RegionalSatellite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.SatellitePageMobileIpad;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.chameleon.utils.Sleeper;

public class Test_RegionalSatellitePageIpad extends AccuWeatherBaseTest {
	String citySearchedByName = "Chicago";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedlandingpageURL = "https://qualityassurance.accuweather.com/en/us/illinois/satellite";
	String expectedSatellitepageTitle = "https://qualityassurance.accuweather.com/en/us/illinois/satellite";
	String expectedvisiblepageTitle = "qualityassurance.accuweather.com/en/us/illinois/satellite-vis";

	private static final String EXPECTED_SATELLITETAB_HIGHLIGHTED = "#f05514";
	private static final String EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT = "#ec5f17";
	private static final String EXPECTED_TOOL_TIP_COLOR = "#f59721";

	private static final String ENCHANCED_TAB = "Enchanced";
	private static final String STANDARD_TAB = "Standard";
	private static final String VISIBLE_TAB = "Visible";
	private static final String WATERVAPOR_TAB = "WaterVapor";

	private static final String EXPECTED_TITLE_OF_MAP_ENCHANCED = "Enhanced Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_STANDARD = "Standard Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_VISIBLE = "Visible Satellite for Illinois";
	private static final String EXPECTED_TITLE_OF_MAP_WATERVAPOR = "Water Vapor Satellite for Illinois";

	private static final String EXPECTED_TOOL_TIPTEXT = "This map displays the infrared band of light and show relative warmth of objects. Infrared imagery is useful for determining clouds both at day and night. Colder objects are brighter and warmer objects are darker. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB = "This map shows how the human eye would see the atmosphere from the satellite. It displays the weather systems and patterns that may affect your area.";
	private static final String EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB = "This image is taken using a wavelength sensitive to the content of water vapor in the atmosphere. Water vapor imagery is useful for both determining locations of moisture and atmospheric circulations that may affect your area.";

	private static final int EXPECTED_DIFFERENCE = 5;
	private static final String MAP_BOX_LANDING_PAGE_URL = "https://www.mapbox.com/";
	private static final String EXPECTED_URL_FOR_SATELLITE = "https://qualityassurance.accuweather.com/en/us/illinois/satellite-ir";

	private SatellitePageMobileIpad satellitePage = new SatellitePageMobileIpad();

	@Test(priority = 1, enabled = false)
	public void RW_TC313_Regional_Satellite_page_loads_succesfully() {
		testStart("Validate Regional Satellite page is loaded successfully");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedlandingpageURL);

	} // pass

	@Test(priority = 2, enabled = false)
	public void RW_TC313_Validate_Satellite_tab_Highlighted_byDefault_onSecondary_Navigations_menus_ofRegional_Satellite_Map() {
		testStart(
				"Validate Satellite tab highlighted in orange by default on secondary navigations menus of satellite map.");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(satellitePage.satelliteTabHighlighted(), EXPECTED_SATELLITETAB_HIGHLIGHTED);
	}// pass

	@Test(priority = 3, enabled = false)
	public void RW_TC313_Validate_Enchanced_tab_Highlighted_byDefault_onTeritary_Navigations_menus_ofRegional_Satellite_Map() {
		testStart(
				"Validate Enchaced Tab highlighted in orange by default on Teritary navigations menus of satellite map.");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(satellitePage.EnchancedTabHighlighted(), EXPECTED_ENCHANCEDTAB_HIGHLIGHTED_BYDEFAULT);
	}// pass

	@Test(priority = 4, enabled = false)
	public void RW_TC313_Validate_EnchancedTab_on_Tertiary_menu_isDisplayed_for_Regional_Satellite_Map() {
		testStart("Validate Enchanced Tab is displayed on Tertiary menus of Regional satellite page.");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.validateTeritaryMenusDisplayed());

	}// pass

	@Test(priority = 8, enabled = false)
	public void RW_TC313_Validate_Title_of_map_displayed_on_Regional_Satellite_page() {
		testStart("Validate Title of the map displayed on Regional Satellite Map.");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_ENCHANCED));

	} // pass

	@Test(priority = 10, enabled = false)
	public void RW_TC314_Validate_ToolTip_Active_when_Clicked_for_Enchanced_Satellite_Map() {
		testStart("Navigate to Regional Satellite page and Validate Tooltip Active when Clicked ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	} // pass

	@Test(priority = 11, enabled = false)
	public void RW_TC314_Validate_ToolTip_Text_Displayed_for_Enchanced_Satellite_Map() {
		testStart("Navigate to Regional Satellite page and Validate Tool tip text displayed ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	} // pass

	@Test(priority = 12, enabled = false)
	public void RW_TC314_Validate_ToolTip_Closes_when_Clicked_Twice_for_Enchanced_Satellite_Map() {
		testStart("Navigate to Regional Satellite page and Validate Tooltip closes when clicked twice ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	} // pass

	@Test(priority = 14, enabled = false)
	public void RW_TC314_Validate_Zoomin_Button_working_onRegional_satellitePage_For_Enchanced_Tab() {
		testStart("Navigate to Regional satellite page and Validate Zoom In Control button Functioning as expeceted");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	} // pass

	@Test(priority = 17, enabled = false)
	public void RW_TC315_Validate_Mapbox_Attribution_Landing_Page_UrlFor_Enchanced_Tab() {
		testStart("Navigate to Regional satellite page and Validate Mapbox landing page For Enchanced Tab");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} // fail

	@Test(priority = 18, enabled = false)
	public void RW_TC220_Validate_Legend_Clouds_Displayed_withText_LowandHigh_for_Regional_SatelliteMapFor_Enchanced_Tab() {
		testStart(
				"Navigate to Regional Satellite Map and Validate Legend cloud displayed with text High and Low For Enchanced Tab");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	} // pass

	@Test(priority = 19, enabled = false)
	public void RW_TC315_Validate_Legend_Clouds_Displayed_with_colors_RegionalMapFor_Enchanced_Tab() {
		testStart("Navigate to Regional Satellite Map and Validate legend cloud displayed with colors ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	} // pass

	@Test(priority = 20, enabled = false)
	public void RW_TC315_Validate_TimeDisplayed_onTimelineControls_of_RegionalMapFor_Enchanced_Tab() {
		testStart("Navigate to Regional page and Validate time displayed on Timeline controls");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
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
		}

		catch (ParseException e) {
			e.getMessage();
		}
	} // fail

	@Test(priority = 23, enabled = false)
	public void RW_TC315_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_SatelliteMapFor_Enchanced_Tab() {
		testStart(
				"Navigate to Regional Satellite full screen page and Validate Legend Clouds displayed with text Low and High");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	}

	@Test(priority = 24, enabled = false)
	public void RW_TC315_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_SatelliteMapFor_Enchanced_Tab() {
		testStart("Navigate to Regional Satellite page and Validate legend cloud displayed with colors");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	} // fail

	// ***** Validation of Standard Satellite Map ******//

	@Test(priority = 25, enabled = false)
	public void RW_TC316_Navigate_to_Standard_Satellite_Map_From_Teritarytab_validate_Landing_page_URL() {
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Landing page URL ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL_FOR_SATELLITE);
	}

	@Test(priority = 26, enabled = false)
	public void RW_TC316_Navigate_to_Standard_Satellite_Map_from_tertiaryTab_validate_MapTitle() {
		testStart("Navigate to Standard Satellite Map from teritary tab and Validate Title displayed on the  Map ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(EXPECTED_URL_FOR_SATELLITE);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_STANDARD));
	}

	@Test(priority = 27, enabled = false)
	public void RW_TC316_Validate_ToolTip_textDisplayed_for_Standard_SatelliteMap() {
		testStart(
				"Navigate to Standard Satellite Map from teritary tab and Validate Tooltip text displayed on the  Map ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		satellitePage.clickOnToolTip();
		Assert.assertTrue(satellitePage.toolTipTextdisplayed().equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT));
	}

	@Test(priority = 28, enabled = false)
	public void RW_TC316_Validate_ToolTip_highlighted_inOrange_for_Standard_SatelliteMap() {
		testStart("Navigate to Standard satellite Map from teritary tab and Validate Tooltip Highlighted when Active");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.toolTipDisplayed());
		satellitePage.clickOnToolTip();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.toolTipActive();
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);
	}// fail

	@Test(priority = 29, enabled = false)
	public void RW_TC316_Validate_ToolTip_Closes_when_Clicked_Twice_for_Standarad_Satellite_Map() {
		testStart(
				"Navigate to Standard Satellite Map from teritary tab and Validate Tooltip Closes when clicked Twice ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}

	@Test(priority = 31, enabled = false)
	public void RW_TC316_Validate_Zoomin_Button_Functions_forStandard_SatelliteMap() {
		testStart(
				"Navigate to Standard Satellite Map from teritary tab and Validate ZoomIn Control button functions as expected");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();

	} // pass

	@Test(priority = 34, enabled = false)
	public void RW_TC317_Validate_Landingpage_URL_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_for_Standard_SatelliteMap() {
		testStart(
				"Navigate to Standard Satellite Map from teritary tab and Validate Mapbox attribution displayed on Bottom left corner of Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);
	} // pass

	@Test(priority = 35, enabled = false)
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Standard_SatelliteMap() {
		testStart(
				"Navigate to Standard teritary tab from Satellite Map and Validate Mapbox attribution displayed on Bottom left corner of Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	} // pass

	@Test(priority = 36, enabled = false)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_on_StandardMap() {
		testStart("Navigate to National Satellite page and Validate Clors displayed under legend Cloud ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	} // pass

	@Test(priority = 37, enabled = false)
	public void RW_TC317_Validate_TimeDisplayed_onTimelineControls_on_Standard_SatelliteMap() {
		testStart(
				"Navigate to Standard teritary tab from Satellite Map  and Validate Timeline controls Time displayed for Full screen Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
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
		}

		catch (ParseException e) {
			e.getMessage();
		}
	}

	@Test(priority = 39, enabled = false)
	public void RW_TC317_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_fullScreen_StandardMap() {
		testStart(
				"Navigate to Standard teritary tab from Satellite Map and Validate legend Cloud displayed with text High and Low");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.fullScreenButtonDisplayed();
		Assert.assertTrue(satellitePage.legendCloud_textLowandHigh_Displayed());
	} // pass

	@Test(priority = 40, enabled = false)
	public void RW_TC317_Validate_Legend_Clouds_Displayed_with_colors_onfullScreen_StandardMap() {
		testStart("Navigate to National Satellite Standard Map page and Validate colors displayed under legend Cloud ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforStandardSatelliteMap();
	} // pass

	@Test(priority = 41, enabled = false)
	public void RW_TC317_Validate_FullScreen_Standard_SatelliteMap_hasTimelineControl_Slider_legend() {
		testStart(
				"Navigate to Standard satellite Full Screen Map and Validate Timeline control ,Timeslider with play button and legend displayed ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(STANDARD_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		satellitePage.validateFullscreenMap();
	}

	// ****** Validation for Visible Satellite Map *******//

	@Test(priority = 42, enabled = false)
	public void RW_TC318_Validate_Visible_Satellite_Map_Title() {
		testStart("Navigate to Visible Satellite Map from teritary tab and Validate Title of the map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_VISIBLE));

	}

	@Test(priority = 44, enabled = false)
	public void RW_TC318_Validate_ToolTip_Active_when_Clicked_for_Visible_Satellite_Map() {
		testStart("Navigate to Visible Satellite Map and Validate Tooltip active when clicked");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);

	}

	@Test(priority = 45, enabled = false)
	public void RW_TC318_Validate_ToolTip_Text_Displayed_for_Visible_Satellite_Map() {
		testStart("Navigate to Visible Satellite Map and Validate Tooltip text displayed");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_VISIBLE_TAB));

	}

	@Test(priority = 46, enabled = false)
	public void RW_TC318_Validate_ToolTip_Closes_when_Clicked_Twice_for_Visible_Satellite_Map() {
		testStart("Navigate to Visible Satellite Map and Validate Tooltip Closes when clicked Twice ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);	
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}

	@Test(priority = 48, enabled = false)
	public void RW_TC318_Validate_Zoomin_Button_Functioning_onVisible_satelliteMap() {
		testStart("Navigate to Visible Satellite Map and Validate Zoom Control button Funtions on Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	}

	@Test(priority = 51, enabled = false)
	public void RW_TC319_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_ofVisible_SatelliteMap() {
		testStart("Navigate to Visible satellite Map and Validate Mapbox landing page");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);

	}

	@Test(priority = 52, enabled = false)
	public void RW_TC319_Validate_Legend_Clouds_Text_LowandHigh_Displayed_for_Visible_SatelliteMap() {
		testStart("Navigate to Visible Satellite Map and Validate Legend cloud displayed  and text Clouds and Clear");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());

	}

	@Test(priority = 53, enabled = false)
	public void RW_TC319_Validate_Legend_Clouds_Displayed_with_colors_for_Visible_SatelliteMap() {
		testStart("Navigate to Visible Satellite Map and Validate various colors displayed under legend cloud ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.colorsDisplayedforVisibleSatelliteMap();
	}

	@Test(priority = 54, enabled = false)
	public void RW_TC319_Validate_TimeDisplayed_onTimelineControls_for_Visible_SatelliteMap() {
		testStart("Navigate to Visible Satellite Map and Validate Time displayed on Timeline controls");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
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
		}

		catch (ParseException e) {
			e.getMessage();
		}
	}

	

	@Test(priority = 56, enabled = false)
	public void RW_TC319_Validate_FullScreen_Visible_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend() {
		testStart(
				"Navigate to Visible satellite Full Screen View and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	}

	@Test(priority = 57, enabled = false)
	public void RW_TC319_Validate_FullScreen_Visble_SatelliteMap_display_Legend_Clouds_andText_ClearandClouds() {
		testStart(
				"Navigate to Visible Satellite Full screen view and Validate Legend cloud with text clouds and clear");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendClouds_with_text_ClearandClouds());

	}

	@Test(priority = 58, enabled = false)
	public void RW_TC319_Validate_FullScreen_Visbile_SatelliteMap_Displayed_with_legend_colors() {
		testStart("Navigate to Visible Satellite full screen view and Validate legends colors displayed");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(VISIBLE_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		satellitePage.coloursdisplayedforEnchacedSatelliteMap();
	}

	// ******Validating WaterVapor Satellite Map *************//

	@Test(priority = 59, enabled = false)
	public void RW_TC320_Navigation_toWaterVapor_Satellite_Map_Validate_Title_() {
		testStart("Navigate to WaterVapor Satellite Map from teritary tab and Validate Title of the map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		// waitUntilWindowExistsWithTitle(expectedvisiblepageTitle);
		Assert.assertTrue(satellitePage.getTitleofMap().equalsIgnoreCase(EXPECTED_TITLE_OF_MAP_WATERVAPOR));

	}

	
	@Test(priority = 61, enabled = false)
	public void RW_TC320_Validate_ToolTip_Active_when_Clicked_for_WaterVapor_Satellite_Map() {
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip active when clicked");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipColor = satellitePage.toolTipActive();
		Assert.assertEquals(actualTooltipColor, EXPECTED_TOOL_TIP_COLOR);

	}

	@Test(priority = 62, enabled = false)
	public void RW_TC320_Validate_ToolTip_Text_Displayed_for_WaterVapor_Satellite_Map() {
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip text displayed");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(3);
		String actualTooltipText = satellitePage.toolTipTextdisplayed();
		Assert.assertTrue(actualTooltipText.equalsIgnoreCase(EXPECTED_TOOL_TIPTEXT_WATERVAPOR_TAB));

	}

	@Test(priority = 63, enabled = false)
	public void RW_TC320_Validate_ToolTip_Closes_when_Clicked_Twice_for_WaterVapor_Satellite_Map() {
		testStart("Navigate to WaterVapor Satellite Map and Validate Tooltip Closes when clicked Twice ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clickOnToolTip();
		Sleeper.sleep(2);
		satellitePage.clickOnToolTip();
	}

	@Test(priority = 65, enabled = false)
	public void RW_TC320_Validate_Zoomin_Button_Functioning_onWaterVapor_satelliteMap() {
		testStart("Navigate to WaterVapor Satellite Map and Validate Zoom In Control button Funtions on Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.zoominControls();
		Sleeper.sleep(3);
		satellitePage.zoomoutControls();
	}

	
	
	@Test(priority = 68, enabled = false)
	public void RW_TC321_Validate_when_clicked_Mapbox_Attribution_onBottomLeft_Corner_forWaterVapor_SatelliteMap() {
		testStart("Navigate to WaterVapor satellite Map and Validate Mapbox landing page");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		String actualLandingpageUrl = satellitePage.getlandingurltitle();
		Assert.assertEquals(actualLandingpageUrl, MAP_BOX_LANDING_PAGE_URL);

	}

	@Test(priority = 69, enabled = false)
	public void RW_TC321_Validate_Legend_WaterVapor_Displayed_withtext_DryandMoist() {
		testStart(
				"Navigate to WaterVapor Satellite Map and Validate Legend WaterVapor displayed with text Dry and Moist");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());

	}

	@Test(priority = 70, enabled = false)
	public void RW_TC321_Validate_Legend_WaterVapor_Displayed_with_colors_forWaterVapor_SatelliteMap() {
		testStart(
				"Navigate to WaterVapor Satellite Map and Validate various colors displayed under legend WaterVapor ");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}

	@Test(priority = 71, enabled = false)
	public void RW_TC321_Validate_TimeDisplayed_onTimelineControls_for_WaterVapor_SatelliteMap() {
		testStart("Navigate to WaterVapor Satellite Map and Validate Time displayed on Timeline controls");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
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
		}

		catch (ParseException e) {
			e.getMessage();
		}
	}

	

	@Test(priority = 73, enabled = false)
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_Timeslider_Timeline_Controls_andLegend() {
		testStart(
				"Navigate to WaterVapor Satellite Map for fullscreen and Validate Timeline control ,Timeslider with play button and legend displayed on Full screen Map");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.validateFullscreenMap());

	}

	@Test(priority = 74, enabled = false)
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_display_Legend_WaterVapor_andText_DryandMoist() {
		testStart(
				"Navigate to WaterVapor Satellite map Full screen view and Validate Legend WaterVapor with text Dry and Moist");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(3);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		Assert.assertTrue(satellitePage.legendWaterVapor_with_text_DryandMoist());

	}

	@Test(priority = 75, enabled = false)
	public void RW_TC321_Validate_FullScreen_WaterVapor_SatelliteMap_Displayed_with_legend_and_colors() {
		testStart("Navigate to WaterVapor Satellite full screen view and Validate legends colors displayed");
		satellitePage.searchCityByName(citySearchedByName);
		satellitePage.selectCityByName();
		waitUntilElementIsDisplayedOrClickable();
		satellitePage.mouseHoverOnRadarAndMaps();
		satellitePage.navigateToSatellite();
		Sleeper.sleep(3);
		satellitePage.clickOnTertiarymenus(WATERVAPOR_TAB);
		Sleeper.sleep(2);
		satellitePage.clikonFullScreen();
		Sleeper.sleep(3);
		satellitePage.colorsDisplayedforLegendWaterVapor();
	}

}
