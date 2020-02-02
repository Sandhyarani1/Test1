package com.accuweather.glacier.m.NatiionalRadar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.nationalRadarIOS;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.chameleon.utils.Sleeper;

public class Test_NationalRadarPageIOS extends AccuWeatherBaseTest {
	String citySearchedByName = "Washington,DC";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
	String expectedNationalRadarpageURL = "https://qualityassurance.accuweather.com/en/us/national/weather-radar";
	String defaultWindowid;
	
	private static final int EXPECTED_FULLSCREEN_BUTTONHEIGHT = 88;
	private static final String RADAR_TAB = "Radar";
	private static final String SATELLITE_TAB = "Satellite";
	private static final String SEVERE_TAB = "Severe";
	private static final String FORECAST_TAB = "Forecast";

	private static final String LEGEND_RAIN = "Rain";
	private static final String LEGEND_SNOW = "Snow";
	private static final String LEGEND_ICE = "Ice";
	private static final String LEGEND_MIX = "Mix";
	private static final String EXPECTED_MAPTITLE = "UNITED STATES WEATHER RADAR";
	private static final String EXPECTED_TOOLTIP_TEXT = "WEATHER RADAR MAP SHOWS THE LOCATION OF PRECIPITATION, ITS TYPE (RAIN, SNOW, AND ICE) AND ITS RECENT MOVEMENT TO HELP YOU PLAN YOUR DAY.";
	private static final String EXPECTED_RADARTAB_HIGHLIGHTED = "#f05514";
	private static final String EXPECTED_TOOLTIP_COLOR = "#f59721";
	private static final String EXPECTED_PASTCTA_COLOR = "#f59721";
	private static final String EXPECTED_FUTURE_CTA_COLOR = "#e8e8e8";
	private static final String EXPECTED_FUTURECTA_HIGHLIGHTED = "#f59721";

	private static final int EXPECTED_TOTAL_DIFFERENCE = 20;
	private static final int EXPECTED_TIME_DIFFERENCE_FUTURECTA = 15;
	private static final String EXPECTED_LANDINGPAGE_URL = "https://www.mapbox.com/";

	private nationalRadarIOS radarPage = new nationalRadarIOS();
	private LandingPageMobile landingPage = new LandingPageMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_TC163_National_Radar_page_loads_succesfully() {
		testStart("Validate National Radar page is loaded successfully");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedNationalRadarpageURL);
	} 

	@Test(priority = 2, enabled = true)
	public void RW_TC164_Tabs_on_Secondary_navigations_displayed_on_National_weather_radar_page() {
		testStart("Validate Secondary Navigation menus are displayed on National Radar Page");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(5);
		Assert.assertTrue(radarPage.validateSecondaryMenusDisplayed());
	} 

	@Test(priority = 3, enabled = true)
	public void RW_TC165_Validate_Radar_Tab_Highlighted_byDefault_on_National_Radar_Page() {
		testStart("Validate Radar TAb from Secondary Navigation menus is Highlighted on Radar Page");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(5);
		String actualRadarTabcolour = radarPage.RadartabHighlightedinOrange();
		Assert.assertEquals(actualRadarTabcolour, EXPECTED_RADARTAB_HIGHLIGHTED);
	} 

	@Test(priority = 4, enabled = true)
	public void RW_TC166_Validate_Title_of_Map_on_National_Radar_Page() {
		testStart("Navigate to National Radar page and Validate Title displayed on Radar Map ");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		System.out.println("Map Title is " + radarPage.titleOfRadarMap());
		Assert.assertTrue(radarPage.titleOfRadarMap().equalsIgnoreCase(EXPECTED_MAPTITLE));
	} 

	@Test(priority = 5, enabled = true)
	public void RW_TC167_a_Validate_Tool_Highlighted_inOranage_whenClicked() {
		testStart("Navigate to National Radar page and Validate Tooltip highlighted in Orange when clicked");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.colordisplayedwhenclickedonTooltip(), EXPECTED_TOOLTIP_COLOR);
	}

	@Test(priority = 6, enabled = false)
	public void RW_TC167_b_Validate_Text_dispayed_whenClicked_onTooltip_onNationalRadarpage() {
		testStart("Navigate to National Radar page and Validate Tooltip text displayed when clicked on Tooltip");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.textdisplayedwhenclickedonTooltip().equalsIgnoreCase(EXPECTED_TOOLTIP_TEXT));
	}

	@Test(priority = 7, enabled = false)
	public void RW_TC167_c_Validate_Tooltip_closes_whenClicked_onTooltip_twice() {
		testStart("Navigate to National Radar page and Validate Tooltip closes when clicked on Tooltip twice");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(3);
		radarPage.clickontooltipfromNationalRadarpage();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 8, enabled = false)
	public void RW_TC168_Validate_Zoomin_Button_working_onNational_RadarPage() {
		testStart("Validate Zoom Control buttons working as expeceted on Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.zoominControls();
		Sleeper.sleep(3);
		radarPage.zoomoutControls();
	} 

	@Test(priority = 9, enabled = false)
	public void RW_TC168_Validate_Zoomout_Button_onNational_RadarPage() {
		testStart("Validate Zoom Control buttons working as expeceted on Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.zoomoutControls();
	} 

	@Test(priority = 10, enabled = false)
	public void RW_TC169_Validate_Mapbox_attribution_displayed_BottomLeft_onNationalRadarpage() {
		testStart("Navigate to National Radar page and Validate Mapbox attribution displayed on Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.MapboxattributionDisplayedBottomLeft());
	} 

	@Test(priority = 11, enabled = false)
	public void RW_TC169_Click_onMapbox_attribution_displayed_BottomLeft_onNationalRadarpage() {
		testStart("Navigate to National Radar page and Validate Mapbox attribution displayed on Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		defaultWindowid= getDriver().getWindowHandle();
		radarPage.ClickonMapboxattribution();
		Sleeper.sleep(3);
		cityRadar.switchToPopUpWindow(defaultWindowid);
		System.out.println(getDriver().getCurrentUrl());
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_LANDINGPAGE_URL);
	} 

	@Test(priority = 12, enabled = false)
	public void RW_TC170_Validate_Full_Screen_button_displayed_onRight_corner_ofRadarMap() {
		testStart("Navigate to National Radar page and Validate Full screen button displayed on Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		int actualFullScreenbuttonHeight = radarPage.fullScreenbuttonDisplayedatbottomRight();
		Assert.assertEquals(actualFullScreenbuttonHeight, EXPECTED_FULLSCREEN_BUTTONHEIGHT);
	} 

	@Test(priority = 13, enabled = false)
	public void RW_TC170a_Validate_Timeline_controls_onFull_Screen_RadarMap() {
		testStart("Navigate to National Radar page and validate timeline controls displayed on fullscreen Radar Map ");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.ClikonFullScreenButton();
		Assert.assertTrue(radarPage.timelinecontrolsdisplayedonFullscreen());
	} 

	@Test(priority = 14, enabled = false)
	public void RW_TC170b_Validate_legends_displayed_onFull_Screen_RadarMap() {
		testStart("Navigate to National Radar page and validate legends displayed on Full screen Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.ClikonFullScreenButton();
		Assert.assertTrue(radarPage.legendsdisplayedonFullscreenRadarMap());
	} 

	@Test(priority = 15, enabled = false)
	public void RW_TC170c_Validate_Fullscreen_Radarmap_closed_when_clicked_onCloseSymbol() {
		testStart("Navigate to National Radar page Click on Full screen button and Validate full screen exits when clicked on close symbol");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.ClikonFullScreenButton();
		Sleeper.sleep(3);
		radarPage.clickedonClosebuttonfromFullscreenRadarMap();
	} 

	@Test(priority = 16, enabled = false)
	public void RW_TC171_Validate_Timeline_controls_PastandFuture_displayed_onNational_RadarMap() {
		testStart("Validate Timeline controls PastandFuture displayed onNational RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.timelinecontrolsdisplayedonRadarMap());
	} 

	@Test(priority = 17, enabled = false)
	public void RW_TC171a_Validate_PASTCTA_Highlighted_byDeafult_onNational_RadarMap() {
		testStart("Validate PASTCTA Highlighted byDeafult onNational RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.PastCTAHighlightedbyDefaultonRadarMap(), EXPECTED_PASTCTA_COLOR);
	} 

	@Test(priority = 18, enabled = false)
	public void RW_TC171b_Validate_FUTURE_CTA_NotHighlighted_byDeafult_onNational_RadarMap() {
		testStart("Validate FUTURE CTA NotHighlighted byDeafult onNational RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		String futureCTAdisplayed = radarPage.FutureCtaNotHighlightedonRadarMap();
		Assert.assertEquals(futureCTAdisplayed, EXPECTED_FUTURE_CTA_COLOR);
	} 

	@Test(priority = 19, enabled = false)
	public void RW_TC172_Toggle_between_Past_andFuture_CTA_onNational_RadarMap() {
		testStart("Validate Past andFuture CTA displayed on National  Weather Radar Map ");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.ClickonPastCTAonRadarMap();
		Sleeper.sleep(3);
		radarPage.ClickonFutureCTAonRadarMap();
		Sleeper.sleep(3);
		radarPage.ClickonPastCTAonRadarMap();
		Sleeper.sleep(3);
		radarPage.ClickonPastCTAonRadarMapGreyed();
		Sleeper.sleep(3);
		Assert.assertEquals(radarPage.PastCTAHighlightedbyDefaultonRadarMap(), EXPECTED_PASTCTA_COLOR);
	} 

	@Test(priority = 20, enabled = false)
	public void RW_TC173_Validate_Time_Slider_Playbutton_displayed_onNational_RadarMap() {
		testStart("Validate Time Slider with Playbutton displayed on National Radar Map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.SliderwithPlayButtonDisplayed());

	} 

	@Test(priority = 21, enabled = false)
	public void RW_TC173_Validate_Timeslider_toggle_between_Pastand_FututreCTA_onNational_RadarPage() {
		testStart("Toggle between Pastand FututreCTA on National RadarPage and Validate Timeslider");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.clickonPlayButton();
		radarPage.ClickonPastCTAonRadarMap();
		radarPage.ClickonPastCTAonRadarMapGreyed();
		radarPage.clickonPauseButton();
	} 

	@Test(priority = 22, enabled = false)
	public void RW_TC174_Select_PastCTA_and_click_on_Play_button_onNational_RadarPage() {
		testStart("Validate when PastCTA Select and clicked on Playbutton onNational_RadarPage");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		waitUntilElementIsDisplayedOrClickable();
		String endTime = radarPage.timestampdisplayed();
		radarPage.clickonPlayButton();
		String startTime = radarPage.timestampdisplayed();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(endTime);
			date2 = format.parse(startTime);

			long difference = date1.getTime() - date2.getTime();
			Assert.assertEquals(difference / (1000 * 60), EXPECTED_TOTAL_DIFFERENCE);
		}

		catch (ParseException e) {
			e.getMessage();
		}
	} 

	@Test(priority = 23, enabled = false)
	public void RW_TC175_Select_FutureCTA_and_click_on_Play_button_onNational_RadarPage() {
		testStart("Validate when FutureCTA Selected and click on Play button onNational RadarPage");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.ClickonPastCTAonRadarMap();
		Sleeper.sleep(3);
		radarPage.ClickonFutureCTAonRadarMap();
		Sleeper.sleep(3);
		String time1 = radarPage.timestampdisplayed();
		waitUntilElementIsDisplayedOrClickable();
		radarPage.clickonPlayButton();
		String time2 = radarPage.timestampdisplayed();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;
		try {
			date1 = format.parse(time1);
			date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			Assert.assertEquals(difference / (1000 * 60), EXPECTED_TIME_DIFFERENCE_FUTURECTA);
		} catch (ParseException e) {

			e.getMessage();
		}

	} 

	@Test(priority = 24, enabled = false)
	public void RW_TC_176_Validate_Rain_Legends_below_RadarMap() {
		testStart("Validate Rain Legends below RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_RAIN));
	}

	@Test(priority = 25, enabled = false)
	public void RW_TC_176_a_Validate_Rain_Legends_displayed_with_Text_Light_andSevere() {
		testStart("Validate Legend Rain displayed with Text Light");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.RainlegendtextLightandSevereDisplayed());

	} 

	@Test(priority = 26, enabled = false)
	public void RW_TC_177_c_Validate_Legend_Rain_displayed_with_Color() {
		testStart("Validate Legend Snow displayed with Text Severe");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.legendRaincoloursdisplayed();

	} 

	@Test(priority = 27, enabled = false)
	public void RW_TC_177_Validate_Legend_Snow_Displayed_below_RadarMap() {
		testStart("Validate Legend Snow displayed below Radar map");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_SNOW));

	}

	@Test(priority = 28, enabled = false)
	public void RW_TC_177_a_Validate_Snow_Legends_displayed_with_Text_Light_andSevere() {
		testStart("Validate Legend Snow displayed with Text Light");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendSnowDisplayedwithTextLightandSevere());
	}

	@Test(priority = 29, enabled = false)
	public void RW_TC_177_c_Validate_Legend_Snow_displayed_with_Color() {
		testStart("Validate Legend Snow displayed with Text Severe");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.legendSnowcoloursdisplayed();

	}

	@Test(priority = 30, enabled = false)
	public void RW_TC_178_Validate_Legend_Ice_Displayed_below_RadarMap() {
		testStart("Validate Legend Ice Displayed below RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_ICE));

	}

	@Test(priority = 31, enabled = false)
	public void RW_TC_178_a_Validate_Legend_ICE_displayed_with_Text_Light_andSevere() {
		testStart("Validate Legend Ice displayed with Text Light");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendIceDisplayedwithTextLightandSevere());
	}

	@Test(priority = 32, enabled = false)
	public void RW_TC_177_c_Validate_Legend_ICE_displayed_with_Color() {
		testStart("Validate Legend Snow displayed with Text Severe");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.legendIcecoloursdisplayed();
	}

	@Test(priority = 33, enabled = false)
	public void RW_TC_180_Validate_Legend_Mix_Displayed_below_RadarMap() {
		testStart("Validate Legend Mix Displayed below RadarMap");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.isLegendDisplayedbelowRadarMap(LEGEND_MIX));

	}

	@Test(priority = 34, enabled = false)
	public void RW_TC_180_a_Validate_Legend_Mix_displayed_with_Text_Light_andSevere() {
		testStart("Validate Legend Mix displayed with Text Light");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		Assert.assertTrue(radarPage.legendMixDisplayedwithTextLightandSevere());
	}

	@Test(priority = 35, enabled = false)
	public void RW_TC_177_c_Validate_Legend_Mix_displayed_with_Color() {
		testStart("Validate Legend Mix displayed with various colors");
		landingPage.enterZipcodeInSearchFieldAndClick(citySearchedByName);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuRadar();
		Sleeper.sleep(3);
		radarPage.legendMixcoloursdisplayed();
	}
}
