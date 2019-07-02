package com.accuweather.glacier.www.PerformanceTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.WindowHandler;

public class Test_UniversalNavigationPerformance extends AccuWeatherBaseTest {
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

	
	
	
	
	  @Test (priority=1,invocationCount=5) public void TC1_isRadarSubMenuDisplayed() {
	  testStart("Verify Radar Sub Menu Is Displayed");
	  navBar.mouseHoverOnRadarAndMaps(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 
	  
	  
	  @Test (priority=2,invocationCount=5) public void isSeverSubMenuDisplayed() {
	  testStart("Verify Sever Sub Menu Is Displayed");
	  navBar.mouseHoverOnRadarAndMaps(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
		  
	  
	  
	  @Test (priority=3,invocationCount=5) public void isSatelliteSubMenuDisplayed() {
	  testStart("Verify Satellite Sub Menu Is Displayed");
	  navBar.mouseHoverOnRadarAndMaps();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	 	  
	  
	  @Test (priority=4,invocationCount=5) public void isRadarTabDisplayed() {
	  testStart("Navigate To Radar page from Radar Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); 
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.isRadarSubMenuDisplayed();
	  navBar.navigateToRadar();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 
	  
	  @Test (priority=5,invocationCount=5) public void isSeverTabEnabled() {
	  testStart("Navigate To Radar page from Sever Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); 
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.isSeverSubMenuDisplayed();
	  navBar.navigateToSevereTab();
	  waitUntilElementIsDisplayedOrClickable(); 
	  }
	  
	  
	  
	  @Test (priority=6,invocationCount=5) public void isSatelliteTabEnabled() {
	  testStart("Navigate To Radar page from Satellite Sub Menu");
	  navBar.mouseHoverOnRadarAndMaps(); 
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.isSatelliteMapsSubMenuDisplayed();
	  navBar.navigateToSatellitePage();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 
	  
	  
	  @Test (priority=7,invocationCount=5) public void isNewsSubMenuDisplayed() {
	  testStart("Navigate To News Page from News Sub Menu");
	  navBar.mouseHoverOnNews(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  @Test (priority=8,invocationCount=5) public void isWeatherNewsSubMenuDisplayed() {
	  testStart("Navigate To Weather News page from WeatherNews Sub Menu");
	  navBar.mouseHoverOnNews(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  @Test (priority=9,invocationCount=5) public void isPersonalitiesSubMenuDisplayed() {
	  testStart("Is Personalities Sub Menu Displayed");
	  navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  
	  @Test (priority=10,invocationCount=5) public void isWeatherBlogSubMenuDisplayed() {
	  testStart("Is Weather Blog Sub Menu Displayed");
	  navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  @Test (priority=11,invocationCount=5) public void isClimateChangeSubMenuDisplayed() {
	  testStart("Is Climate Change Sub Menu Displayed"); 
	  navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=12,invocationCount=5) public void isNewsTabEnabledFromNewsSubMenu() {
	  testStart("Is News Tab Enabled"); 
	  navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000);
	  navBar.isNewsSubMenuDisplayed(); 
	  navBar.navigateToNewsTab();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=13,invocationCount=5) public void isNewsTabEnabledFromWeatherNewsSubMenu()
	  { testStart("Is News Tab Enabled"); navBar.mouseHoverOnNews();
	  navBar.isWeatherNewsSubMenuDisplayed(); navBar.navigateToNewsPage();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 
	  
	  @Test (priority=14,invocationCount=5) public void isBlogsTabEnabledFromWeatherBlogSubMenu() {
	  testStart("Is Weather BLOG Tab Enabled"); navBar.mouseHoverOnNews();
	  navBar.isWeatherBlogsSubMenuDisplayed(); navBar.navigateToWeatherBlogPage();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 
	  
	  
	  @Test (priority=15,invocationCount=5) public void isWatchNewsCTASubMenuDisplayed() {
	  testStart("Is Watch News CTA Sub Menu Displayed"); navBar.mouseHoverOnNews();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=16,invocationCount=5) public void isWeatherVideoPageisplayed() {
	  testStart("Is Weather Video page displayed from Watch News CTA Sub Menu");
	  navBar.mouseHoverOnNews();
	  Assert.assertTrue(navBar.isWatchNewsSubMenuDisplayed());
	  navBar.navigateToWeatherVidoesPage();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 	  
	  
	  @Test (priority=17,invocationCount=5) public void isClimateChangePageDisplayedFromClimateChangeSubMenu() {
	  testStart("Is Climate Change page displayed from Climate Change Sub Menu");
	  navBar.mouseHoverOnNews(); navBar.isClimateChangeSubMenuDisplayed();
	  navBar.navigateToClimateChangePage(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=18,invocationCount=5) public void isAWBroadcastDisplayedFromPersonalitiesSubMenu() {
	  testStart("Is Broadcast page displayed from Personalities Sub Menu");
	  navBar.mouseHoverOnNews(); navBar.isPersonalitiesSubMenuDisplayed();
	  navBar.navigateToPersonalitiesPage(); 
	  getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	  WindowHandler.waitUntilWindowExistsWithTitle(driver, AWBroadCastTitle);
	  nwp.isBroadCasterTabeEnabled(); 
	  waitUntilElementIsDisplayedOrClickable();
	  }
	   
	  
	  
	  @Test (priority=19,invocationCount=5) public void isVideoSubMenuDisplayed() {
	  testStart("Is Video Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	 }
	  
	   
	  
	  @Test (priority=20,invocationCount=5) public void isWatchVideoSubMenuDisplayed() {
	  testStart("Is Watch Video Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	  navBar.clickWatchVideoButton(); 
	  }
	  
	  
	  @Test (priority=21,invocationCount=5) public void isTrendingNowSubMenuDisplayed() {
	  testStart("Is Trending Now Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=22,invocationCount=5) public void isStormChasersSubMenuDisplayed() {
	  testStart("Is Storm Chasers Sub Menu Displayed"); navBar.mouseHoverOnVideo();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	 	  
	  
	  
	  @Test (priority=23,invocationCount=5) public void isExpertForecastsSubMenuDisplayed() {
	  testStart("Is Expert Forecasts Sub Menu Displayed");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	 }
	  
	  @Test (priority=24,invocationCount=5) public void isVideoPageDisplayed() {
	  testStart("Is Videos Page Displayed From Video Sub Menu");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	  defaultWindowid = getDriver().getWindowHandle(); navBar.clickVidoeSubMenu();
	  navBar.switchToPopUpWindow(defaultWindowid); 
	  }
		  
	  
	@Test (priority=25,invocationCount=5) public void isVideoPageDisplayedFromWatchVideoSubMenu() {
	testStart("Is Videos Page displayed from Watch Video Sub Menu");
	navBar.mouseHoverOnVideo();
    navBar.clickWatchVideoButton(); 
    ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	WindowHandler.waitUntilWindowExistsWithTitle(driver, AWViedoPageTitle);
	}
		  
		  
	@Test (priority=26,invocationCount=5) public void isVideoDisplayedFromTrednignNowSubMenu() { 
	testStart("Is Videos Page displayed from Watch Video Sub Menu");
	navBar.mouseHoverOnVideo(); defaultWindowid = getDriver().getWindowHandle();
	navBar.clickTrendingNowSubMenu();
	navBar.switchToPopUpWindow(defaultWindowid); 
	}
	
	
	@Test (priority=27,invocationCount=5) public void isVideoPageDisplayedFromStormChasersSubMenu() {
	  testStart("Is Video Page displayed from Storm Chasers Sub Menu");
	  navBar.mouseHoverOnVideo(); waitUntilElementIsDisplayedOrClickable();
	  defaultWindowid = getDriver().getWindowHandle();
	  navBar.clickStormChasersSubMenu();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  }
	
	 @Test (priority=28,invocationCount=5) public void isVideoPageDisplayedFromExpertForecastsSubMenu() {
	  testStart("Is Video Page displayed from Expert Forecasts Sub Menu");
	  navBar.mouseHoverOnVideo(); defaultWindowid = getDriver().getWindowHandle();
	  navBar.clickExpertForecastSubMenu();
	  navBar.switchToPopUpWindow(defaultWindowid);
	  }
	  
	  
	  
	  @Test (priority=29,invocationCount=5) public void isSeverWeatherSubMenuDisplayed() {
	  testStart("Verify Sever Weather Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather(); waitUntilElementIsDisplayedOrClickable();
	 }
		  
	  
	  @Test (priority=30,invocationCount=5) public void isHurricaneSubMenuDisplayed() {
	  testStart("Verify Hurricane Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather();
	  waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  @Test (priority=31,invocationCount=5) public void isAccuWeatherReadySubMenuDisplayed() {
	  testStart("Verify AccuWeather Ready Weather Sub Menu Is Displayed");
	  navBar.mouseHoverOnSeverWeather();
	  waitUntilElementIsDisplayedOrClickable();}
	  
	  
	  @Test (priority=32,invocationCount=5) public void isSeverWeatherPageDisplayedFromSeverWeatherSubMenu() {
	  testStart("Is Sever Weather Page displayed from Sever Weather Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clickSeverWeatherSubMenu();
	  waitUntilWindowExistsWithTitle(AWSeverWeatherPageTitle);
	  }
	  
	  
	  @Test (priority=33,invocationCount=5) public void isHurricanePageDisplayedFromHurricaneSubMenu() {
	  testStart("Is Hurricane Page displayed from Hurricane Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clickHurricaneSubMenu();
	  waitUntilWindowExistsWithTitle(AWHurricanePageTitle);
	  }
	  
	  
	  
	  @Test (priority=34,invocationCount=5) public void isAWReadyPageDisplayedFromAWReadySubMenu() {
	  testStart("Is AW Ready Page displayed from AW Ready Sub Menu");
	  navBar.mouseHoverOnSeverWeather(); navBar.clicAwReadySubMenu();
	  waitUntilWindowExistsWithTitle(AWReadyPageTitle);
	  }
	  
	  
	  @Test (priority=35,invocationCount=5) public void isAboutWeatherSubMenuDisplayed() {
	  testStart("Is About Weather Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 }
	  
	  
	  @Test (priority=36,invocationCount=5) public void isAppsDownloadsSubMenuDisplayed() {
	  testStart("Is Apps and Downloads Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=37,invocationCount=5) public void isPodcastSubMenuDisplayed() {
	  testStart("Is Podcast Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  @Test (priority=38,invocationCount=5) public void isAWPreimumSubMenuDisplayed() {
	  testStart("Is Accuweather Premium Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  @Test (priority=39,invocationCount=5) public void isAWProfessionalSubMenuDisplayed() {
	  testStart("Is Accuweather Professional Sub Menu displayed Under More Main Menu"
	  ); navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  
	  @Test (priority=40,invocationCount=5) public void isCouponsSubMenuDisplayed() {
	  testStart("Is Coupons Sub Menu displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 }
	  
	  
	  
	  
	  @Test (priority=41,invocationCount=5) public void isFacebookIconisplayed() {
	  testStart("Is Facebook Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	   }
	  
	  
	  
	  @Test (priority=42,invocationCount=5) public void isTwitterIconisplayed() {
	  testStart("Is Twitter Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  
	  @Test (priority=43,invocationCount=5) public void isInstagramIconisplayed() throws
	  InterruptedException {
	  testStart("Is Instagram Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 }
	  
	 	  
	  
	  @Test (priority=44,invocationCount=5) public void isYoutubeIconDisplayed() {
	  testStart("Is YOUTUBE Icon displayed Under More Main Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
	  
	  
	  @Test (priority=45,invocationCount=5) public void isStartSearchIconDisplayed() {
	  testStart("Is Start Search Icon displayed Under any Categories on Top Menu");
	  navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	  }
}
