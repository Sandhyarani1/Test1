package com.accuweather.glacier.m.UniversalNavigation;

import java.awt.AWTException;
//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.UniversalNavigationMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;

import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.selenium.DriverManager;
//import com.chameleon.selenium.ExtendedExpectedConditions;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.WindowHandler;
import com.chameleon.utils.Sleeper;

public class Test_UniversalNavigationMobileIOS extends AccuWeatherMobileBaseTest {
	String expectedradartitle = "United States Doppler Weather Radar Map - AccuWeather.com";
	String actualweathervideourl;
	String expectedweathervideourl = "https://qualityassurance.accuweather.com/en/videos/";
	String actualclimatechangeurl;
	String expectedclimatechangeurl = "https://qualityassurance.accuweather.com/en/climate-change";
	String AWBroadCastTitle = "AccuWeather Broadcasters";
	String AWViedoPageTitle = "Trending Now - AccuWeather";
	String AWHurricanePageTitle = "Hurricane";
	String AWSeverWeatherPageTitle = "Severe Weather Watches and Weather Warnings - AccuWeather.com";
	String AWWinterWeatherPageTitle = "Winter Center - AccuWeather.com";
	String expectedForecastPageTitle = "AccuWeather Forecast for";
	String AWReadyPageTitle = "AccuWeather Ready";
	String actualpersonalitiesurl;
	String expectedpersonalitiesurl = "https://getaccuweather.tv/broadcasters";
	String actualvideodescriptiontext;
	String expectedvideodescriptiontext = "Video coverage of the top weather events people are talking about";
	String actualtrendingnowtext;
	String expectedtrendingnowtext = "Watch the best weather videos across the web";
	String actualstormchasersurl;
	String expectedstormchasersurl = "https://qualityassurance.accuweather.com/en/videos/storm-chasers";
	String actualstormchaserstext;
	String expectedstormchaserstext = "Our field teams brave the elements";
	String actualforecastsurl;
	String expectedforecastsurl = "https://qualityassurance.accuweather.com/en/videos/expert-forecasts";
	String expectedseverweaterurl = "https://qualityassurance.accuweather.com/en/us/severe-weather";
	String actualseverweatherurl;
	String actualhurricaneurl;
	String expectedhurricaneurl = "https://qualityassurance.accuweather.com/en/hurricane";
	String actualwinterweatherurl;
	String expectedwitnerweatherurl = "https://qualityassurance.accuweather.com/en/us/winter-weather";
	String actualawreadyurl;
	String expectedawreadyurl = "https://qualityassurance.accuweather.com/en/accuweather-ready";
	String actualcitypagetitle;
	String expectedcitypagetitle = "Local Weather from AccuWeather.com - Superior Accuracy&trade;";
	String actuallocationsearchtitle;
	String actualbrowselocationtitle;
	String expectedlocationsearchtitle = "Find Your Location's Weather Forecast | AccuWeather";
	String expectedbrowselocationtitle3 ="Browse For Your Weather Location | AccuWeather";
	String expectedlocationsearchtitle2 = "Stockholm, Stockholm, Sweden Three Day Weather Forecast | AccuWeather";
	String expectedbrowselocationtitle = "World Weather - Browse for your location - AccuWeather";
	String actualwebforecasttitle;
	String expectedwebforecasttitle = " Weather - AccuWeather Forecast for ";
	String zipcode = "56186";
	String zip = "16803";
	String pincode = "45874";
	String pin = "35954";
	String pinzip = "30518";
	String houstonzip = "77045";
	String twochar = "st";
	String engtitle = "English(US)";
	String actualspanishtitle;
	String expectedspanishtitle = "Español";
	String actualusnamespanish;
	String expectedusnamespanish = "Estados Unidos";
	String defaultWindowid;
	String zipcode2 = "48073";

	private NavigationBar navBar = new NavigationBar();
	private RadarWeatherPage rwp = new RadarWeatherPage();
	private NewsWeatherPage nwp = new NewsWeatherPage();
	private LandingPageMobile landingPage = new LandingPageMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();
	private UniversalNavigationMobile universalNavigationMobile = new UniversalNavigationMobile();

	@Test(priority = 2, enabled = true)
	public void isRadarSubMenuDisplayed() {
		testStart("Verify Radar Sub Menu Is Displayed");
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.BreadCrumbMenuRadarAndMapsIsDisplayed());
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 3, enabled = true)
	public void isSeverSubMenuDisplayed() {
		testStart("Verify Sever Sub Menu Is Displayed");
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuSevere());
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 4, enabled = true)
	public void isSatelliteSubMenuDisplayed() {
		testStart("Verify Satellite Sub Menu Is Displayed");
		WebPageLoaded.isDomInteractive(1000);
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuSatellite());
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 4, enabled = true)
	public void isRadarTabDisplayed() {
		testStart("Navigate To Radar page from Radar Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		universalNavigationMobile.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		Assert.assertTrue(cityRadar.clickbyBreadCrumbMenuRadar());
	} 

	@Test(priority = 5, enabled = false)
	public void isSeverTabEnabled() {
		testStart("Navigate To Radar page from Sever Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickBreadCrumbMenuRadarAndMaps();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuSevere());
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isSeverTabEnabled());
	} 

	@Test(priority = 6, enabled = false)
	public void isSatelliteTabEnabled() {
		testStart("Navigate To Radar page from Satellite Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickBreadCrumbMenuRadarAndMaps();
		universalNavigationMobile.clickbyBreadCrumbMenuSatellite();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isSatelliteTabEnabled());
	}

	@Test(priority = 7, enabled = false)
	public void isNewsSubMenuDisplayed() {
		testStart("TC42_Navigate To News Page from News Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isNewsTabEnabled());
		
	} 

	@Test(priority = 8, enabled = false)
	public void isWeatherNewsSubMenuDisplayed() {
		testStart("TC42_Navigate To Weather News page from WeatherNews Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isNewsTabEnabled());
	} 

	@Test(priority = 9, enabled = false)
	public void isPersonalitiesSubMenuDisplayed() {
		testStart("TC42_Is Personalities Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuPersonalities();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isPersonalitiesTabEnabled());
	}

	@Test(priority = 10, enabled = false)
	public void isWeatherBlogSubMenuDisplayed() {
		testStart("TC42_Is Weather Blog Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuWeatherBlogs();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isWeatherBlogsTabEnabled());
	}

	@Test(priority = 11, enabled = false)
	public void isClimateChangeSubMenuDisplayed() {
		testStart("TC42_Is Climate Change Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuClimateChange();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isClimateChangeTabEnabled());
	} 

	/*
	 * @Test(priority = 12, enabled = false) public void
	 * isNewsTabEnabledFromNewsSubMenu() {
	 * testStart("TC42_Navigate To Weather News page from WeatherNews Sub Menu");
	 * landingPage.enterZipcodeInSearchField(zipcode2);
	 * landingPage.clickOnZipcodeSearchIcon(); Sleeper.sleep(5);
	 * universalNavigationMobile.clickBreadCrumbMenu();
	 * universalNavigationMobile.clickbyBreadCrumbMenuNews();
	 * universalNavigationMobile.clickbyBreadCrumbMenuWeatherNews();
	 * Sleeper.sleep(5);
	 * Assert.assertTrue(universalNavigationMobile.isNewsTabEnabled()); }
	 */ //NA

	@Test(priority = 13, enabled = false)
	public void isNewsTabEnabledFromWeatherNewsSubMenu() {
		testStart("TC42_Navigate To Weather News page from WeatherNews Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isNewsTabEnabled());
	}

	@Test(priority = 14, enabled = false)
	public void isBlogsTabEnabledFromWeatherBlogSubMenu() {
		testStart("TC46_Is Weather BLOG Tab Enabled");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuWeatherBlogs();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isWeatherBlogsTabEnabled());
	} 

	/*
	 * @Test(priority = 15, enabled = false) public void
	 * isWatchNewsCTASubMenuDisplayed() {
	 * testStart("TC42_Is Watch News CTA Sub Menu Displayed");
	 * navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(3000);
	 * getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 * Assert.assertTrue(navBar.isWatchNewsSubMenuDisplayed()); }
	 */ //NA

	@Test(priority = 16, enabled = false)
	public void isWeatherVideoPageDisplayed() {
		testStart("TC44_Is Weather Video page displayed from Watch News CTA Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		universalNavigationMobile.clickbyBreadCrumbMenuTrendingNow();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualweathervideourl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualweathervideourl, expectedweathervideourl);
	} 

	@Test(priority = 17, enabled = false)
	public void isClimateChangePageDisplayedFromClimateChangeSubMenu() {
		testStart("TC48_Is Climate Change page displayed from Climate Change Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuClimateChange();
		Sleeper.sleep(5);
		universalNavigationMobile.isClimateChangeTabEnabled();
		actualclimatechangeurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualclimatechangeurl, expectedclimatechangeurl);
	}

	@Test(priority = 18, enabled = false)
	public void isAWBroadcastDisplayedFromPersonalitiesSubMenu() {
		testStart("TC47_Is Broadcast page displayed from Personalities Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuNews();
		universalNavigationMobile.clickbyBreadCrumbMenuPersonalities();
		Sleeper.sleep(5);
		universalNavigationMobile.isPersonalitiesTabEnabled();
		String actualpersonalitiesurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualpersonalitiesurl, expectedpersonalitiesurl);
	} 

	@Test(priority = 19, enabled = false)
	public void isVideoSubMenuDisplayed() {
		testStart("TC49_Is Video Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuVideo());
	} 

	/*
	 * @Test(priority = 20, enabled = false) public void
	 * TC49_isWatchVideoSubMenuDisplayed() {
	 * testStart("Is Watch Video Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	 * WebPageLoaded.isDomInteractive(1000);
	 * Assert.assertTrue(navBar.isWatchVideoButtonDisplayed());
	 * navBar.clickWatchVideoButton(); } //na
	 */
	@Test(priority = 21, enabled = false)
	public void TC49_isTrendingNowSubMenuDisplayed() {
		testStart("Is Trending Now Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuTrendingNow());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 22, enabled = false)
	public void TC49_isStormChasersSubMenuDisplayed() {
		testStart("Is Storm Chasers Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuStormChasers());
	} 

	@Test(priority = 23, enabled = false)
	public void TC49_isExpertForecastsSubMenuDisplayed() {
		testStart("Is Expert Forecasts Sub Menu Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuExpertForecasts());
	} 

	@Test(priority = 25, enabled = false)
	public void TC50_isVideoPageDisplayed() {
		testStart("Is Videos Page Displayed From Video Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		universalNavigationMobile.clickbyBreadCrumbMenuTrendingNow();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualweathervideourl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualweathervideourl, expectedweathervideourl);
	} 

	/*
	 * @Test(priority = 26, enabled = false) public void
	 * TC51_isVideoPageDisplayedFromWatchVideoSubMenu() {
	 * testStart("Is Videos Page displayed from Watch Video Sub Menu");
	 * navBar.mouseHoverOnVideo(); navBar.clickWatchVideoButton(); ExtendedWebDriver
	 * driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWViedoPageTitle);
	 * actualweathervideourl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualweathervideourl, expectedweathervideourl); } //NA
	 */
	@Test(priority = 27, enabled = false)
	public void TC52_isVideoDisplayedFromTrednignNowSubMenu() {
		testStart("Is Videos Page displayed from Watch Video Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		universalNavigationMobile.clickbyBreadCrumbMenuTrendingNow();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualweathervideourl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualweathervideourl, expectedweathervideourl);
	} 

	@Test(priority = 29, enabled = false)
	public void TC53_isVideoPageDisplayedFromStormChasersSubMenu() {
		testStart("Is Video Page displayed from Storm Chasers Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		universalNavigationMobile.clickbyBreadCrumbMenuStormChasers();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualweathervideourl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualweathervideourl, expectedstormchasersurl);
	} 

	@Test(priority = 31, enabled = false)
	public void TC54_isVideoPageDisplayedFromExpertForecastsSubMenu() {
		testStart("Is Video Page displayed from Expert Forecasts Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuVideo();
		universalNavigationMobile.clickbyBreadCrumbMenuExpertForecasts();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualweathervideourl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualweathervideourl, expectedforecastsurl);
	} 

	@Test(priority = 32,enabled = false)
	public void TC55_isSeverWeatherSubMenuDisplayed() {
		testStart("Verify Sever Weather Sub Menu Is Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuSevereWeather());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 33,enabled = false)
	public void TC55_isHurricaneSubMenuDisplayed() {
		testStart("Verify Hurricane Sub Menu Is Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuHurricane());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 35,enabled = false)
	public void TC55_isAccuWeatherReadySubMenuDisplayed() {
		testStart("Verify AccuWeather Ready Weather Sub Menu Is Displayed");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuAccuWeatherReady());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 36,enabled = false)
	public void TC56_isSeverWeatherPageDisplayedFromSeverWeatherSubMenu() {
		testStart("Is Sever Weather Page displayed from Sever Weather Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuSevereWeather());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		actualseverweatherurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualseverweatherurl, expectedseverweaterurl);
	} 

	@Test(priority = 37, enabled = false)
	public void TC57_isHurricanePageDisplayedFromHurricaneSubMenu() {
		testStart("Is Hurricane Page displayed from Hurricane Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuHurricane());
		waitUntilWindowExistsWithTitle(AWHurricanePageTitle);
		actualhurricaneurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualhurricaneurl, expectedhurricaneurl);
	} 

	@Test(priority = 39, enabled = false)
	public void TC59_isAWReadyPageDisplayedFromAWReadySubMenu() {
		testStart("Is AW Ready Page displayed from AW Ready Sub Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuSevereWeather();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuAccuWeatherReady());
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(AWReadyPageTitle);
		actualawreadyurl = getDriver().getCurrentUrl();
		Assert.assertEquals(actualawreadyurl, expectedawreadyurl);
	} 

	@Test(priority = 40, enabled = false)
	public void TC60_isAboutWeatherSubMenuDisplayed() {
		testStart("Is About Weather Sub Menu displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuAboutAccuWeather());
		Sleeper.sleep(5);
	} 

	@Test(priority = 41, enabled = false)
	public void TC60_isAppsDownloadsSubMenuDisplayed() {
		testStart("Is Apps and Downloads Sub Menu displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuAppsAndDownloads());
		Sleeper.sleep(5);
	}

	@Test(priority = 42, enabled = false)
	public void TC60_isPodcastSubMenuDisplayed() {
		testStart("Is Podcast Sub Menu displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubMenuPodcasts());
		Sleeper.sleep(5);
	} 

	@Test(priority = 43, enabled = false)
	public void TC60_isAWPreimumSubMenuDisplayed() {
		testStart("Is Accuweather Premium Sub Menu displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubAccuWeatherPremium());
		Sleeper.sleep(5);
	} 

	@Test(priority = 44, enabled = false)
	public void TC60_isAWProfessionalSubMenuDisplayed() {
		testStart("Is Accuweather Professional Sub Menu displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubAccuWeatherProfessional());
		Sleeper.sleep(5);
	} 

	/*
	 * @Test(priority = 45, enabled = false) public void
	 * TC60_isCouponsSubMenuDisplayed() {
	 * testStart("Is Coupons Sub Menu displayed Under More Main Menu");
	 * landingPage.enterZipcodeInSearchField(zipcode2);
	 * landingPage.clickOnZipcodeSearchIcon(); Sleeper.sleep(5);
	 * universalNavigationMobile.clickBreadCrumbMenu();
	 * universalNavigationMobile.clickbyBreadCrumbMenuMore();
	 * Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubCoupons()); }
	 * 
	 */
	@Test(priority = 46, enabled = false)
	public void TC60_isFacebookIconDisplayed() {
		testStart("Is Facebook Icon displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubFacebookIcon());
	} 

	@Test(priority = 47, enabled = false)
	public void TC60_isTwitterIconDisplayed() {
		testStart("Is Twitter Icon displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubTwitterIcon());
	} 

	@Test(priority = 48, enabled = false)
	public void TC60_isInstagramIconDisplayed() throws InterruptedException {
		testStart("Is Instagram Icon displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubInstagramIcon());
	} 

	@Test(priority = 48, enabled = false)
	public void TC60_isYoutubeIconDisplayed() {
		testStart("Is YOUTUBE Icon displayed Under More Main Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuMore();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbSubYouTubeIcon());
	} 

	@Test(priority = 49, enabled = false)
	public void TC04_isStartSearchIconDisplayed() {
		testStart("Is Start Search Icon displayed Under any Categories on Top Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isStartSearchDisplayed());
	} 

	@Test(priority = 50, enabled = false)
	public void TC06_isStartSearchCloseIconDisplayed() {
		testStart("Is Start Search Close Icon displayed Under any Categories on Top Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		Assert.assertTrue(universalNavigationMobile.isTopNavSearchCloseIconDisplayed());
	} 

	@Test(priority = 51, enabled = false)
	public void TC05_isTopNavCTATextDisplayed() {
		testStart("Is CTA Text displayed Under on Top Nav Menu");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		Assert.assertTrue(universalNavigationMobile.isTopNavCTATextDisplayed());
	} 

	@Test(priority = 52, enabled = false)
	public void TC05_isCTACityPageDisplayed() {
		testStart("Is City Page displayed on clicking CTA Link on Top Nav");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		Assert.assertTrue(universalNavigationMobile.isTopNavSearchIconclick());
	} 

	/*
	 * @Test(priority = 53, enabled = false) public void
	 * TC07_isTopNavNYCityImageDisplayed() {
	 * testStart("Is NY City Image displayed on clicking CTA Link on Top Nav");
	 * landingPage.enterZipcodeInSearchField(zipcode2);
	 * landingPage.clickOnZipcodeSearchIcon(); Sleeper.sleep(5);
	 * universalNavigationMobile.isTopNavSearchIconclick();
	 * universalNavigationMobile.isTopNavSearchIconclick();
	 * Assert.assertTrue(universalNavigationMobile.isTopNavNYCityImageDisplayed());
	 * }
	 */ //NA

	/*
	 * @Test(priority = 54, enabled = false) public void
	 * TC07_isTopNavChicagoCityImageDisplayed() {
	 * testStart("Is Chicago City Image displayed on clicking CTA Link on Top Nav");
	 * navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 * Assert.assertTrue(navBar.isTopNavChicagoCityImageDisplayed()); }
	 */ //NA

	/*
	 * @Test(priority = 55, enabled = false) public void
	 * TC07_isTopNavDCCityImageDisplayed() {
	 * testStart("Is DC City Image displayed on clicking CTA Link on Top Nav");
	 * navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 * Assert.assertTrue(navBar.isTopNavDCCityImageDisplayed()); }
	 */ //NA
	
	/*
	 * @Test(priority = 56, enabled = false) public void
	 * TC07_isTopNavHoustonCityImageDisplayed() {
	 * testStart("Is Houston City Image displayed on clicking CTA Link on Top Nav");
	 * navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	 * waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 * getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * Assert.assertTrue(navBar.isTopNavHoustonCityImageDisplayed()); }
	 */ //NA

	/*@Test(priority = 57, enabled = false)
	public void TC08_isTopNavHoustonCityImageDisplayed() throws InterruptedException {
		testStart("Is Houston City Image displayed on clicking CTA Link on Top Nav");
		landingpage.enterZipcodeInSearchField(pincode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		navBar.navigateToHome();
		WebPageLoaded.isDomInteractive(1000);
		landingpage.enterZipcodeInSearchField(pin);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		navBar.navigateToHome();
		WebPageLoaded.isDomInteractive(1000);
		landingpage.enterZipcodeInSearchField(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		navBar.navigateToHome();
		WebPageLoaded.isDomInteractive(1000);
		landingpage.enterZipcodeInSearchField(zip);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		navBar.navigateToHome();
		WebPageLoaded.isDomInteractive(1000);
		landingpage.enterZipcodeInSearchField(houstonzip);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		navBar.mouseHoverOnMoreMenu();
		waitUntilElementIsDisplayedOrClickable();
		navBar.clickTopNavStartSearchIcon();
		Thread.sleep(1000);
		Assert.assertTrue(navBar.isRecentCityNameDisplayed());
	}*/

	@Test(priority = 58, enabled = false)
	public void TC09_isSearchLocationPageDisplayed() throws InterruptedException, AWTException {
		testStart("Is Search Location Page displayed upon entering 2 chars in Top Nav Search Fiel");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		navBar.locationSearch2Chars();
		WebPageLoaded.isDomComplete(3000);
		//navBar.enterlocationSearch2();
		waitUntilElementIsDisplayedOrClickable();
		actuallocationsearchtitle = getDriver().getTitle();
		Assert.assertEquals(actuallocationsearchtitle, expectedlocationsearchtitle);
	} 

	@Test(priority = 59, enabled = false)
	public void TC11_isBrowseLocationPageDisplayed() {
		testStart("Is Browse Location Page displayed upon entering 2 chars in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		navBar.locationSearch2Chars();
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomComplete(5);
		//navBar.clickBrowseYourLocationLink2();
		waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
		waitUntilElementIsDisplayedOrClickable();
		actualbrowselocationtitle = getDriver().getTitle();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(actualbrowselocationtitle, expectedbrowselocationtitle3);
	}

	@Test(priority = 60, enabled = false)
	public void TC12_isBrowseLocationPageDisplayed() {
		testStart("Is Browse Location Page displayed without chars in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		//navBar.locationSearch2Chars2();
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomComplete(5);
		//navBar.clickBrowseYourLocationLink2();
		waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
		waitUntilElementIsDisplayedOrClickable();
		actualbrowselocationtitle = getDriver().getTitle();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(actualbrowselocationtitle, expectedbrowselocationtitle3);
	} 

	@Test(priority = 60,enabled = false)
	public void TC12_isForecastPageDisplayed() throws InterruptedException {
		testStart("Is Forecast Page displayed with Valid Zip in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.isTopNavSearchIconclick();
		universalNavigationMobile.isTopNavSearchIconclick2(zip);
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(3);
		actualwebforecasttitle = getDriver().getTitle();
		expectedwebforecasttitle = " Weather - AccuWeather Forecast for ";
		Assert.assertTrue(actualwebforecasttitle.contains(actualwebforecasttitle));
	}

	@Test(priority = 61,enabled = false)
	public void TC15_isSettingCountryDisplayed() {
		testStart("Is Country Name displayed under Settings in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuCountrySettings());
		//Assert.assertTrue(navBar.isSettingCountryDisplayed());
		waitUntilElementIsDisplayedOrClickable();
	} 

	@Test(priority = 61,enabled = false)
	public void TC15_isSettingLanguageDisplayed() {
		testStart("Is Language displayed under Settings in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuLanguageSettings());
		waitUntilElementIsDisplayedOrClickable();
	}

	@Test(priority = 62,enabled = false)
	public void TC15_isSettingTemperatureDisplayed() {
		testStart("Is Temperature displayed under Settings in Top Nav Search Field");
		landingPage.enterZipcodeInSearchField(zipcode2);
		landingPage.clickOnZipcodeSearchIcon();
		Sleeper.sleep(5);
		universalNavigationMobile.clickBreadCrumbMenu();
		Assert.assertTrue(universalNavigationMobile.clickbyBreadCrumbMenuTemperatureSettings());
		waitUntilElementIsDisplayedOrClickable();
	} 

	/*
	 * @Test(priority = 63,enabled = false) public void
	 * TC16_isMyRecentCountriesTextDisplayed() {
	 * testStart("Is My Recent Countries Text displayed under Settings in Top Nav Search Field"
	 * ); navBar.mouseHoverOnSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.mouseHoverOnSettingCountryUpArrowIcon();
	 * navBar.clickSettingCountryUPArrow();
	 * waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(3000);
	 * Assert.assertTrue(navBar.isMyRecentCountriesTextDisplayed()); }
	 */ //NA

	/*
	 * @Test(priority = 64, enabled = false) public void
	 * TC16_isMoreCountriesButtonDisplayed() {
	 * testStart("Is More Countries Button displayed under Settings in Top Nav Search Field"
	 * ); navBar.mouseHoverOnSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.mouseHoverOnSettingCountryUpArrowIcon();
	 * navBar.clickSettingCountryUPArrow();
	 * waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(3000);
	 * Assert.assertTrue(navBar.isMoreCountriesButtonDisplayed()); }
	 */ //NA

	/*
	 * @Test(priority = 65, enabled = false) public void
	 * TC18_isRecentCountriesHomePageDisplayed() {
	 * testStart("Is Recent Country HomePage displayed under Settings in Top Nav Search Field"
	 * ); navBar.mouseHoverOnSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.mouseHoverOnSettingCountryUpArrowIcon();
	 * navBar.clickSettingCountryUPArrow();
	 * waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(5000);
	 * navBar.mouseHoverOnSettingCountryNameLink();
	 * waitUntilElementIsDisplayedOrClickable(); String countryname =
	 * navBar.getSettingCountryNameLinkText();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.clickSettingCountryNameLink();
	 * waitUntilWindowExistsWithTitle(countryname);
	 * waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(5000);
	 * getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); String
	 * landingpagetitle = getDriver().getTitle();
	 * Assert.assertTrue(landingpagetitle.contains(countryname)); }
	 */ //NA

	/*
	 * @Test(priority = 66, enabled = false) public void
	 * TC19_isBrowseLocationsPageDisplayed() {
	 * testStart("Is Browse Locations page displayed under Settings in Top Nav Search Field"
	 * ); navBar.mouseHoverOnSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.mouseHoverOnSettingCountryUpArrowIcon();
	 * navBar.clickSettingCountryUPArrow();
	 * waitUntilElementIsDisplayedOrClickable();
	 * navBar.clickSettingMoreCountriesLink();
	 * waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
	 * waitUntilElementIsDisplayedOrClickable();
	 * WebPageLoaded.isDomInteractive(5000);
	 * getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 * actualbrowselocationtitle = getDriver().getTitle();
	 * Assert.assertEquals(actualbrowselocationtitle, expectedbrowselocationtitle);
	 * }
	 */

	@Test(priority = 67, enabled = false)
	public void TC20_SettingsLanguageListDisplayed() {
		testStart("Is Language List displayed under Settings in Top Nav Search Field");
		universalNavigationMobile.clickBreadCrumbMenu();
		universalNavigationMobile.clickbyBreadCrumbMenuLanguageSettings();
		waitUntilElementIsDisplayedOrClickable();
		universalNavigationMobile.getLanguageListfromSettingsMenu();
	}

}
