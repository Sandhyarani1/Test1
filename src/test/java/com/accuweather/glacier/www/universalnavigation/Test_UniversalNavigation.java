package com.accuweather.glacier.www.universalnavigation;
import java.awt.AWTException;
//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.selenium.DriverManager;
//import com.chameleon.selenium.ExtendedExpectedConditions;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.WindowHandler;

public class Test_UniversalNavigation extends AccuWeatherBaseTest 
{
	String expectedradartitle = "United States Doppler Weather Radar Map - AccuWeather.com";
	String actualweathervideourl;
	String expectedweathervideourl = "https://qualityassurance.accuweather.com/en/videos";
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
	String expectedlocationsearchtitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";
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

	private NavigationBar navBar = new NavigationBar();
	private RadarWeatherPage rwp = new RadarWeatherPage();
	private NewsWeatherPage nwp = new NewsWeatherPage();
	private LandingPage landingpage = new LandingPage();

	
	
	
	
	
	  @Test (priority=2) public void isRadarSubMenuDisplayed() {
	  testStart("Verify Radar Sub Menu Is Displayed");
	  navBar.mouseHoverOnRadarAndMaps(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isRadarSubMenuDisplayed()); }
	 
	  
	  
	  
	
	  @Test (priority=3) public void isSeverSubMenuDisplayed() {
	  testStart("Verify Sever Sub Menu Is Displayed");
	  navBar.mouseHoverOnRadarAndMaps(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isSeverSubMenuDisplayed()); }
	 
	 
	  
	  
	  
	  @Test(priority = 4) public void isSatelliteSubMenuDisplayed() {
	  testStart("Verify Satellite Sub Menu Is Displayed");
	  WebPageLoaded.isDomInteractive(1000); 
	  navBar.mouseHoverOnRadarAndMaps();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isSatelliteMapsSubMenuDisplayed()); }
	  
	  
	  
	  
	
	
	  @Test (priority=4) public void isRadarTabDisplayed() {
	  testStart("Navigate To Radar page from Radar Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); waitUntilElementIsDisplayedOrClickable();
	  navBar.isRadarSubMenuDisplayed(); navBar.navigateToRadar();
	  WebPageLoaded.isDomInteractive(4000);
	  getDriver().manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
	  Assert.assertTrue(rwp.isRadarTabEnabled()); }
	 
	  
	  
	
	  @Test (priority=5) public void isSeverTabEnabled() {
	  testStart("Navigate To Radar page from Sever Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); waitUntilElementIsDisplayedOrClickable();
	  navBar.isSeverSubMenuDisplayed(); navBar.navigateToSevereTab();
	  WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(rwp.isSeverTabEnabled()); }
	 
	  
	  
	  
	
	  @Test (priority=6) public void isSatelliteTabEnabled() {
	  testStart("Navigate To Radar page from Satellite Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); navBar.isSatelliteMapsSubMenuDisplayed();
	  navBar.navigateToSatellitePage(); WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(rwp.isSatelliteTabEnabled()); }
	 
	  
	  
	  
	  
	
	  @Test (priority=7) public void isNewsSubMenuDisplayed() {
	  testStart("TC42_Navigate To News Page from News Sub Menu");
	  navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isNewsSubMenuDisplayed()); }
	 
	  
	  
	  
	  
	  @Test (priority=8) public void isWeatherNewsSubMenuDisplayed() {
	  testStart("TC42_Navigate To Weather News page from WeatherNews Sub Menu");
	  navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isWeatherNewsSubMenuDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=9) public void isPersonalitiesSubMenuDisplayed() {
	  testStart("TC42_Is Personalities Sub Menu Displayed");
	  navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isPersonalitiesSubMenuDisplayed()); }
	  
	  
	  
	  
	  
	  
	  
	  @Test (priority=10) public void isWeatherBlogSubMenuDisplayed() {
	  testStart("TC42_Is Weather Blog Sub Menu Displayed");
	  navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isWeatherBlogsSubMenuDisplayed()); }
	  
	  
	 
	  
	
	
	  @Test (priority=11) public void isClimateChangeSubMenuDisplayed() {
	  testStart("TC42_Is Climate Change Sub Menu Displayed");
	  navBar.mouseHoverOnNews(); navBar.navigateToClimateChangePage();
	  waitUntilWindowExistsWithTitle(expectedclimatechangeurl);
	  waitUntilElementIsDisplayedOrClickable(); actualclimatechangeurl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualclimatechangeurl,expectedclimatechangeurl); 
	  }
	  
	  
	  
	  @Test (priority=12) public void isNewsTabEnabledFromNewsSubMenu() {
	  testStart("TC43_Is News Tab Enabled"); navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000); navBar.isNewsSubMenuDisplayed();
	  navBar.navigateToNewsTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(nwp.isNewsTabEnabled()); }
	  
	  
	  
	  @Test (priority=13) public void isNewsTabEnabledFromWeatherNewsSubMenu() {
	  testStart("TC45_Is News Tab Enabled"); navBar.mouseHoverOnNews();
	  navBar.isWeatherNewsSubMenuDisplayed(); navBar.navigateToNewsPage();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(nwp.isNewsTabEnabled()); }
	  
	  
	  
	  
	  @Test (priority=14) public void isBlogsTabEnabledFromWeatherBlogSubMenu() {
	  testStart("TC46_Is Weather BLOG Tab Enabled"); navBar.mouseHoverOnNews();
	  navBar.isWeatherBlogsSubMenuDisplayed(); navBar.navigateToWeatherBlogPage();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(nwp.isWeatherBlogTabeEnabled()); }
	  
	  
	  
	  
	  
	  
	  @Test (priority=15) public void isWatchNewsCTASubMenuDisplayed() {
	  testStart("TC42_Is Watch News CTA Sub Menu Displayed");
	  navBar.mouseHoverOnNews(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isWatchNewsSubMenuDisplayed()); }
	  
	  
	  
	  
	  
	  
	  
	  @Test (priority=16) public void isWeatherVideoPageDisplayed() {
	  testStart("TC44_Is Weather Video page displayed from Watch News CTA Sub Menu"
	  ); navBar.mouseHoverOnNews(); defaultWindowid =
	  getDriver().getWindowHandle(); navBar.navigateToWeatherVidoesPage();
	  waitUntilWindowExistsWithTitle(expectedweathervideourl);
	  navBar.switchToPopUpWindow(defaultWindowid);
	  waitUntilElementIsDisplayedOrClickable(); actualweathervideourl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualweathervideourl,expectedweathervideourl); 
	  }
	  
	  
	  
	  
	  
	  @Test (priority=17) public void
	  isClimateChangePageDisplayedFromClimateChangeSubMenu() {
	  testStart("TC48_Is Climate Change page displayed from Climate Change Sub Menu"
	  ); navBar.mouseHoverOnNews(); navBar.isClimateChangeSubMenuDisplayed();
	  WebPageLoaded.isDomInteractive(6000); navBar.navigateToClimateChangePage();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(6000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  actualclimatechangeurl = getDriver().getCurrentUrl();
	  Assert.assertEquals(actualclimatechangeurl,expectedclimatechangeurl); }
	  
	  
	  
	  @Test (priority=18) public void
	  isAWBroadcastDisplayedFromPersonalitiesSubMenu() {
	  testStart("TC47_Is Broadcast page displayed from Personalities Sub Menu");
	  navBar.mouseHoverOnNews(); navBar.isPersonalitiesSubMenuDisplayed();
	  navBar.navigateToPersonalitiesPage();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	  WindowHandler.waitUntilWindowExistsWithTitle(driver, AWBroadCastTitle);
	  nwp.isBroadCasterTabeEnabled();
	  getDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); String
	  actualpersonalitiesurl = getDriver().getCurrentUrl();
	  Assert.assertEquals(actualpersonalitiesurl,expectedpersonalitiesurl); }
	  
	  
	  @Test (priority=19) public void isVideoSubMenuDisplayed() {
	  testStart("TC49_Is Video Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isVideoSubMenuDisplayed()); }
	  
	  
	  @Test (priority=20) public void TC49_isWatchVideoSubMenuDisplayed() {
	  testStart("Is Watch Video Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(navBar.isWatchVideoButtonDisplayed());
	  navBar.clickWatchVideoButton(); }
	  
	  
	  @Test (priority=21) public void TC49_isTrendingNowSubMenuDisplayed() {
	  testStart("Is Trending Now Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(navBar.isTrendingNowSubMenuDisplayed()); }
	  
	  
	  @Test (priority=22) public void TC49_isStormChasersSubMenuDisplayed() {
	  testStart("Is Storm Chasers Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  WebPageLoaded.isDomComplete(3000); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isStormChasersSubMenuDisplayed()); }
	  
	  
	  
	  @Test (priority=23) public void TC49_isExpertForecastsSubMenuDisplayed() {
	  testStart("Is Expert Forecasts Sub Menu Displayed");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isExpertForecastSubMenuDisplayed()); }
	 
	 
	  
	  
	  
	  @Test (priority=25) public void TC50_isVideoPageDisplayed() {
	  testStart("Is Videos Page Displayed From Video Sub Menu");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	  defaultWindowid = getDriver().getWindowHandle(); 
	  navBar.clickVidoeSubMenu();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  WebPageLoaded.isDomComplete(3000); actualweathervideourl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualweathervideourl,expectedweathervideourl); }
	  
	  
	  @Test (priority=26) public void
	  TC51_isVideoPageDisplayedFromWatchVideoSubMenu() {
	  testStart("Is Videos Page displayed from Watch Video Sub Menu");
	  navBar.mouseHoverOnVideo(); navBar.clickWatchVideoButton(); ExtendedWebDriver
	  driver = (ExtendedWebDriver) DriverManager.getDriver();
	  WindowHandler.waitUntilWindowExistsWithTitle(driver, AWViedoPageTitle);
	  actualweathervideourl = getDriver().getCurrentUrl();
	  Assert.assertEquals(actualweathervideourl,expectedweathervideourl); }
	  
	  
	  
	  @Test (priority=27) public void TC52_isVideoDisplayedFromTrednignNowSubMenu()
	  { testStart("Is Videos Page displayed from Watch Video Sub Menu");
	  navBar.mouseHoverOnVideo(); defaultWindowid = getDriver().getWindowHandle();
	  navBar.clickTrendingNowSubMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	  actualweathervideourl = getDriver().getCurrentUrl();
	  Assert.assertEquals(actualweathervideourl,expectedweathervideourl); }
	  
	 	
	  @Test (priority=29) public void
	  TC53_isVideoPageDisplayedFromStormChasersSubMenu() {
	  testStart("Is Video Page displayed from Storm Chasers Sub Menu");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	  defaultWindowid = getDriver().getWindowHandle();
	  navBar.clickStormChasersSubMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  WebPageLoaded.isDomComplete(3000); actualstormchasersurl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualstormchasersurl,expectedstormchasersurl); 
	  }
	 
	  
	  
	  
	
	  @Test (priority=31) public void
	  TC54_isVideoPageDisplayedFromExpertForecastsSubMenu() {
	  testStart("Is Video Page displayed from Expert Forecasts Sub Menu");
	  navBar.mouseHoverOnVideo(); defaultWindowid = getDriver().getWindowHandle();
	  navBar.clickExpertForecastSubMenu();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  WebPageLoaded.isDomComplete(3000); actualforecastsurl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualforecastsurl,expectedforecastsurl); }
	 
	  
	  
	  
	
	  
	  
	  @Test (priority=32) public void TC55_isSeverWeatherSubMenuDisplayed() {
	  testStart("Verify Sever Weather Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isSeverWeatherSubMenuDisplayed()); }
	  
	  
	  @Test (priority=33) public void TC55_isHurricaneSubMenuDisplayed() {
	  testStart("Verify Hurricane Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather();
	  Assert.assertTrue(navBar.isHurricaneSubMenuDisplayed()); }
	  
	  
	  
	  @Test (priority=35) public void TC55_isAccuWeatherReadySubMenuDisplayed() {
	  testStart("Verify AccuWeather Ready Weather Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather();
	  Assert.assertTrue(navBar.isAWReadySubMenuDisplayed()); }
	  
	  
	  
	  @Test (priority=36) public void
	  TC56_isSeverWeatherPageDisplayedFromSeverWeatherSubMenu() {
	  testStart("Is Sever Weather Page displayed from Sever Weather Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clickSeverWeatherSubMenu();
	  waitUntilWindowExistsWithTitle(AWSeverWeatherPageTitle);
	  actualseverweatherurl = getDriver().getCurrentUrl();
	  Assert.assertEquals(actualseverweatherurl,expectedseverweaterurl); }
	  
	  
	  @Test (priority=37) public void
	  TC57_isHurricanePageDisplayedFromHurricaneSubMenu() {
	  testStart("Is Hurricane Page displayed from Hurricane Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clickHurricaneSubMenu();
	  waitUntilWindowExistsWithTitle(AWHurricanePageTitle); actualhurricaneurl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualhurricaneurl,expectedhurricaneurl); }
	  
	  
	  
	  @Test (priority=39) public void
	  TC59_isAWReadyPageDisplayedFromAWReadySubMenu() {
	  testStart("Is AW Ready Page displayed from AW Ready Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clicAwReadySubMenu();
	  waitUntilWindowExistsWithTitle(AWReadyPageTitle); actualawreadyurl =
	  getDriver().getCurrentUrl();
	  Assert.assertEquals(actualawreadyurl,expectedawreadyurl); }
	  
	  
	  
	  
	  @Test (priority=40) public void TC60_isAboutWeatherSubMenuDisplayed() {
	  testStart("Is About Weather Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isAWAboutSubMenuDisplayed()); }
	  
	  
	  @Test (priority=41) public void TC60_isAppsDownloadsSubMenuDisplayed() {
	  testStart("Is Apps and Downloads Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isAppAndDwnldSubMenuDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=42) public void TC60_isPodcastSubMenuDisplayed() {
	  testStart("Is Podcast Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isPodcastSubMenuDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=43) public void TC60_isAWPreimumSubMenuDisplayed() {
	  testStart("Is Accuweather Premium Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isAWPremiumSubMenuDisplayed()); }
	  
	  
	  
	  @Test (priority=44) public void TC60_isAWProfessionalSubMenuDisplayed() {
	  testStart("Is Accuweather Professional Sub Menu displayed Under More Main Menu"
	  ); navBar.mouseHoverOnMoreMenu(); WebPageLoaded.isDomComplete(3000);
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isAWProfessionalSubMenuDisplayed()); }
	  
	  
	  
	  
	  
	  @Test (priority=45) public void TC60_isCouponsSubMenuDisplayed() {
	  testStart("Is Coupons Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); WebPageLoaded.isDomComplete(3000);
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isCouponsSubMenuDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=46) public void TC60_isFacebookIconDisplayed() {
	  testStart("Is Facebook Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); WebPageLoaded.isDomComplete(3000);
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isFacebookIconDisplayed()); }
	  
	  
	  
	  @Test (priority=47) public void TC60_isTwitterIconDisplayed() {
	  testStart("Is Twitter Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); //waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isTwitterIconDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=48) public void TC60_isInstagramIconDisplayed() throws
	  InterruptedException {
	  testStart("Is Instagram Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Thread.sleep(200); Assert.assertTrue(navBar.isInstagramIconDisplayed()); }
	  
	  
	  
	  
	  
	  @Test (priority=48) public void TC60_isYoutubeIconDisplayed() {
	  testStart("Is YOUTUBE Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isYoutubeIconDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=49) public void TC04_isStartSearchIconDisplayed() {
	  testStart("Is Start Search Icon displayed Under any Categories on Top Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isStartSearchDisplayed()); }
	  
	  
	  
	  @Test (priority=50) public void TC06_isStartSearchCloseIconDisplayed() {
	  testStart("Is Start Search Close Icon displayed Under any Categories on Top Menu"
	  ); navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isTopNavSearchCloseIconDisplayed()); }
	  
	  
	  
	  
	  @Test (priority=51) public void TC05_isTopNavCTATextDisplayed() {
	  testStart("Is CTA Text displayed Under on Top Nav Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(navBar.isTopNavCTATextDisplayed()); }
	  
	  
	  @Test (priority=52) public void TC05_isCTACityPageDisplayed() {
	  testStart("Is City Page displayed on clicking CTA Link on Top Nav");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.isTopNavCTATextDisplayed();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickTopNavCTALink();
	  actualcitypagetitle = getDriver().getTitle();
	  Assert.assertEquals(actualcitypagetitle,expectedcitypagetitle); }
	 
	  
	  
	  
	  
	  @Test (priority=53) public void TC07_isTopNavNYCityImageDisplayed() {
	  testStart("Is NY City Image displayed on clicking CTA Link on Top Nav");
	  navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isTopNavNYCityImageDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 54) public void TC07_isTopNavChicagoCityImageDisplayed() {
	  testStart("Is Chicago City Image displayed on clicking CTA Link on Top Nav");
	  navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isTopNavChicagoCityImageDisplayed()); }
	  
	  
	  
	  
	  
	  
	  @Test(priority = 55) public void TC07_isTopNavDCCityImageDisplayed() {
	  testStart("Is DC City Image displayed on clicking CTA Link on Top Nav");
	  navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isTopNavDCCityImageDisplayed()); }
	  
	  
	
	  @Test(priority = 56) public void TC07_isTopNavHoustonCityImageDisplayed() {
	  testStart("Is Houston City Image displayed on clicking CTA Link on Top Nav");
	  navBar.mouseHoverOnMoreMenu(); navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	  getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isTopNavHoustonCityImageDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 57) public void TC08_isTopNavHoustonCityImageDisplayed()
	  throws InterruptedException {
	  testStart("Is Houston City Image displayed on clicking CTA Link on Top Nav");
	  landingpage.enterZipcodeInSearchField(pincode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.enterZipcodeInSearchField(pin);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.enterZipcodeInSearchField(zip);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.enterZipcodeInSearchField(houstonzip);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon(); Thread.sleep(1000);
	  Assert.assertTrue(navBar.isRecentCityNameDisplayed()); }
	  
	  
	  
	  
	  
	  @Test(priority = 58) public void TC09_isSearchLocationPageDisplayed() throws InterruptedException, AWTException {
		  testStart("Is Search Location Page displayed upon entering 2 chars in Top Nav Search Fiel"
		  ); navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
		  navBar.clickTopNavStartSearchIcon();
		  waitUntilElementIsDisplayedOrClickable(); 
		  navBar.locationSearch2Chars();
		  WebPageLoaded.isDomComplete(3000);
		  navBar.enterlocationSearch();
		  waitUntilElementIsDisplayedOrClickable();
		  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		  actuallocationsearchtitle = getDriver().getTitle();
		  Assert.assertEquals(actuallocationsearchtitle,expectedlocationsearchtitle); 
		  }
	  
	  
	  
	  @Test(priority = 59) public void TC11_isBrowseLocationPageDisplayed() {
	  testStart("Is Browse Location Page displayed upon entering 2 chars in Top Nav Search Field"
	  ); WebPageLoaded.isDomComplete(2000);
	  navBar.mouseHoverOnMoreMenu(); 
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.locationSearch2Chars();
	  waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(5000);
	  navBar.clickBrowseYourLocationLink();
	  waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
	  waitUntilElementIsDisplayedOrClickable(); actualbrowselocationtitle =
	  getDriver().getTitle(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertEquals(actualbrowselocationtitle,expectedbrowselocationtitle); 
	  }
	  
	  
	  @Test(priority = 60) public void TC12_isBrowseLocationPageDisplayed() {
	  testStart("Is Browse Location Page displayed without chars in Top Nav Search Field"
	  ); navBar.mouseHoverOnMoreMenu();waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.locationSearchWithoutChars();
	  waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(5000);
	  navBar.clickBrowseYourLocationLink();
	  waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
	  waitUntilElementIsDisplayedOrClickable(); actualbrowselocationtitle =
	  getDriver().getTitle(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertEquals(actualbrowselocationtitle,expectedbrowselocationtitle); 
	  }
	  
	  
	  
	  
	  
	  @Test(priority = 60) public void TC12_isForecastPageDisplayed() throws
	  InterruptedException {
	  testStart("Is Forecast Page displayed with Valid Zip in Top Nav Search Field"
	  ); navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickTopNavStartSearchIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.locationSearch(zip);
	  WebPageLoaded.isDomInteractive(3000); actualwebforecasttitle =
	  getDriver().getTitle(); expectedwebforecasttitle =
	  " Weather - AccuWeather Forecast for ";
	  Assert.assertTrue(actualwebforecasttitle.contains(actualwebforecasttitle)); }
	  
	  @Test(priority = 61) public void TC15_isSettingCountryDisplayed() {
	  testStart("Is Country Name displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isSettingCountryDisplayed());
	  waitUntilElementIsDisplayedOrClickable(); 
	  }
	  
	  
	  
	  @Test(priority = 61) public void TC15_isSettingLanguageDisplayed() {
	  testStart("Is Language displayed under Settings in Top Nav Search Field");
	  navBar.mouseHoverOnSettingsIcon(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickSettingsIcon(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  Assert.assertTrue(navBar.isSettingLanguageDisplayed());
	  waitUntilElementIsDisplayedOrClickable(); }
	  
	  
	  
	  @Test(priority = 62) public void TC15_isSettingTemperatureDisplayed() {
	  testStart("Is Temperature displayed under Settings in Top Nav Search Field");
	  navBar.mouseHoverOnSettingsIcon(); waitUntilElementIsDisplayedOrClickable();
	  navBar.clickSettingsIcon(); waitUntilElementIsDisplayedOrClickable();
	  navBar.isSettingTemperatureDisplayed();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000); }
	  
	  
	  
	  
	  @Test(priority = 63) public void TC16_isMyRecentCountriesTextDisplayed() {
	  testStart("Is My Recent Countries Text displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.mouseHoverOnSettingCountryUpArrowIcon();
	  navBar.clickSettingCountryUPArrow();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  Assert.assertTrue(navBar.isMyRecentCountriesTextDisplayed()); }
	  
	  @Test(priority = 64) public void TC16_isMoreCountriesButtonDisplayed() {
	  testStart("Is More Countries Button displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.mouseHoverOnSettingCountryUpArrowIcon();
	  navBar.clickSettingCountryUPArrow();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  Assert.assertTrue(navBar.isMoreCountriesButtonDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 65) public void TC18_isRecentCountriesHomePageDisplayed() {
	  testStart("Is Recent Country HomePage displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.mouseHoverOnSettingCountryUpArrowIcon();
	  navBar.clickSettingCountryUPArrow();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  navBar.mouseHoverOnSettingCountryNameLink();
	  waitUntilElementIsDisplayedOrClickable(); String countryname =
	  navBar.getSettingCountryNameLinkText();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.clickSettingCountryNameLink();
	  waitUntilWindowExistsWithTitle(countryname);
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); String
	  landingpagetitle = getDriver().getTitle();
	  Assert.assertTrue(landingpagetitle.contains(countryname)); 
	  }
	  
	  
	  @Test(priority = 66) public void TC19_isBrowseLocationsPageDisplayed() {
	  testStart("Is Browse Locations page displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.mouseHoverOnSettingCountryUpArrowIcon();
	  navBar.clickSettingCountryUPArrow();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.clickSettingMoreCountriesLink();
	  waitUntilWindowExistsWithTitle(expectedbrowselocationtitle);
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  actualbrowselocationtitle = getDriver().getTitle();
	  Assert.assertEquals(actualbrowselocationtitle,expectedbrowselocationtitle);
	  }
	  
	  
	  
	  
	  @Test(priority = 67) public void TC20_SettingsLanguageListDisplayed() {
	  testStart("Is Language List displayed under Settings in Top Nav Search Field"
	  ); navBar.mouseHoverOnSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable(); navBar.clickSettingsIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.mouseHoverOnSettingLanguageArrowIcon();
	  navBar.clickSettingLanguageArrowLink();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  navBar.isSettingsLanguageListDisplayed(); 
	  }
	 
	 

}
