package com.accuweather.glacier.www.universalnavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WindowHandler;

public class Test_UniversalNavigation extends AccuWeatherBaseTest 
{
	String expectedradartitle = "United States Doppler Weather Radar Map - AccuWeather.com";
	String actualweathervideourl;
	String expectedweathervideourl = "https://development.glacier.accuweather.com/en/videos";
	String actualclimatechangeurl;
	String expectedclimatechangeurl = "https://development.glacier.accuweather.com/en/climate-change";
	String AWBroadCastTitle = "AccuWeather Broadcasters";
	String AWViedoPageTitle = "Trending Now - AccuWeather";
	String AWHurricanePageTitle = "Hurricane";
	String AWSeverWeatherPageTitle = "Severe Weather Watches and Weather Warnings - AccuWeather.com";
	String AWWinterWeatherPageTitle = "Winter Center - AccuWeather.com";
	String AWReadyPageTitle = "AccuWeather Ready";
	String actualpersonalitiesurl;
	String expectedpersonalitiesurl = "https://getaccuweather.tv/broadcasters";
	String actualvideodescriptiontext;
	String expectedvideodescriptiontext = "Video coverage of the top weather events people are talking about";
	String actualtrendingnowtext;
	String expectedtrendingnowtext = "Watch the best weather videos across the web";
	String actualstormchasersurl;
	String expectedstormchasersurl = "https://development.glacier.accuweather.com/en/videos/storm-chasers";
	String actualstormchaserstext;
	String expectedstormchaserstext = "Our field teams brave the elements";
	String actualforecastsurl;
	String expectedforecastsurl = "https://development.glacier.accuweather.com/en/videos/expert-forecasts";
	String expectedseverweaterurl = "https://development.glacier.accuweather.com/en/us/severe-weather";
	String actualseverweatherurl;
	String actualhurricaneurl;
	String expectedhurricaneurl = "https://development.glacier.accuweather.com/en/hurricane";
	String actualwinterweatherurl;
	String expectedwitnerweatherurl = "https://development.glacier.accuweather.com/en/us/winter-weather";
	String actualawreadyurl;
	String expectedawreadyurl = "https://development.glacier.accuweather.com/en/accuweather-ready";
	private NavigationBar navBar = new NavigationBar();
	private RadarWeatherPage rwp = new RadarWeatherPage();
	private NewsWeatherPage nwp = new NewsWeatherPage();
	
	/*
	 * @Test (priority=2) public void isRadarSubMenuDisplayed() {
	 * testStart("Verify Radar Sub Menu Is Displayed");
	 * navBar.mouseHoverOnRadarAndMaps();
	 * Assert.assertTrue(navBar.isRadarSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=3) public void isSeverSubMenuDisplayed() {
	 * testStart("Verify Sever Sub Menu Is Displayed");
	 * navBar.mouseHoverOnRadarAndMaps();
	 * Assert.assertTrue(navBar.isSeverSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=4) public void isSatelliteSubMenuDisplayed() {
	 * testStart("Verify Satellite Sub Menu Is Displayed");
	 * navBar.mouseHoverOnRadarAndMaps();
	 * Assert.assertTrue(navBar.isSatelliteMapsSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=4) public void isRadarTabDisplayed() {
	 * testStart("Navigate To Radar page from Radar Sub Menu");
	 * navBar.mouseHoverOnRadarAndMaps(); 
	 * navBar.isRadarSubMenuDisplayed();
	 * navBar.navigateToRadar(); 
	 * Assert.assertTrue(rwp.isRadarTabEnabled()); 
	 * }

	 */
	/*
	 * @Test (priority=5) public void isSeverTabEnabled() {
	 * testStart("Navigate To Radar page from Sever Sub Menu");
	 * navBar.mouseHoverOnRadarAndMaps(); 
	 * navBar.isSeverSubMenuDisplayed();
	 * navBar.navigateToSevereTab(); 
	 * Assert.assertTrue(rwp.isSeverTabEnabled()); 
	 * }

	 */
	/*
	 * @Test (priority=6) public void isSatelliteTabEnabled() {
	 * testStart("Navigate To Radar page from Satellite Sub Menu");
	 * navBar.mouseHoverOnRadarAndMaps(); 
	 * navBar.isSatelliteMapsSubMenuDisplayed();
	 * navBar.navigateToSatellitePage();
	 * Assert.assertTrue(rwp.isSatelliteTabEnabled()); 
	 * }

	 */
	/*
	 * @Test (priority=7) public void TC42_isNewsSubMenuDisplayed() {
	 * testStart("Navigate To News Page from News Sub Menu");
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isNewsSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=8) public void TC42_isWeatherNewsSubMenuDisplayed() {
	 * testStart("Navigate To Weather News page from WeatherNews Sub Menu");
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isWeatherNewsSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=9) public void TC42_isPersonalitiesSubMenuDisplayed() {
	 * testStart("Is Personalities Sub Menu Displayed"); 
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isPersonalitiesSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=10) public void TC42_isWeatherBlogSubMenuDisplayed() {
	 * testStart("Is Weather Blog Sub Menu Displayed"); 
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isWeatherBlogsSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=11) public void TC42_isClimateChangeSubMenuDisplayed() {
	 * testStart("Is Climate Change Sub Menu Displayed"); 
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isClimateChangeSubMenuDisplayed()); 
	 * }

	 */
	/*
	 * @Test (priority=12) public void TC43_isNewsTabEnabledFromNewsSubMenu() {
	 * testStart("Is News Tab Enabled"); 
	 * navBar.mouseHoverOnNews();
	 * navBar.isNewsSubMenuDisplayed(); 
	 * navBar.navigateToNewsTab();
	 * Assert.assertTrue(nwp.isNewsTabEnabled()); 
	 * }

	 */
	/*
	 * @Test (priority=13) public void TC45_isNewsTabEnabledFromWeatherNewsSubMenu() {
	 * testStart("Is News Tab Enabled"); 
	 * navBar.mouseHoverOnNews();
	 * navBar.isWeatherNewsSubMenuDisplayed(); 
	 * navBar.navigateToNewsPage();
	 * Assert.assertTrue(nwp.isNewsTabEnabled());  
	 * }

	 */
	/*
	 * @Test (priority=14) public void TC46_isBlogsTabEnabledFromWeatherBlogSubMenu() {
	 * testStart("Is Weather BLOG Tab Enabled"); 
	 * navBar.mouseHoverOnNews();
	 * navBar.isWeatherBlogsSubMenuDisplayed(); 
	 * navBar.navigateToWeatherBlogPage();
	 * Assert.assertTrue(nwp.isWeatherBlogTabeEnabled()); 
	 * }

	 */
	/*
	 * @Test (priority=15) public void TC42_isWatchNewsCTASubMenuDisplayed() {
	 * testStart("Is Watch News CTA Sub Menu Displayed");
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isWatchNewsSubMenuDisplayed());
	 }

	 */
	/*
	 * @Test (priority=16) public void TC44_isWeatherVideoPageisplayed() {
	 * testStart("Is Weather Video page displayed from Watch News CTA Sub Menu");
	 * navBar.mouseHoverOnNews();
	 * Assert.assertTrue(navBar.isWatchNewsSubMenuDisplayed());
	 * navBar.navigateToWeatherVidoesPage(); 
	 * actualweathervideourl = getDriver().getCurrentUrl(); 
	 * Assert.assertEquals(actualweathervideourl,expectedweathervideourl); 
	 * }

	 */
	/*
	 * @Test (priority=17) public void
	 * TC48_isClimateChangePageDisplayedFromClimateChangeSubMenu() {
	 * testStart("Is Climate Change page displayed from Climate Change Sub Menu");
	 * navBar.mouseHoverOnNews(); 
	 * navBar.isClimateChangeSubMenuDisplayed();
	 * navBar.navigateToClimateChangePage(); 
	 * actualclimatechangeurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualclimatechangeurl,expectedclimatechangeurl); 
	 * }

	 */
	/*
	 * @Test (priority=18) public void
	 * TC47_isAWBroadcastDisplayedFromPersonalitiesSubMenu() {
	 * testStart("Is Broadcast page displayed from Personalities Sub Menu");
	 * navBar.mouseHoverOnNews(); 
	 * navBar.isPersonalitiesSubMenuDisplayed();
	 * navBar.navigateToPersonalitiesPage();
	 *  ExtendedWebDriver driver = 	(ExtendedWebDriver) DriverManager.getDriver();
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWBroadCastTitle);
	 * nwp.isBroadCasterTabeEnabled(); 
	 * String actualpersonalitiesurl = getDriver().getCurrentUrl(); 
	 * Assert.assertEquals(actualpersonalitiesurl,expectedpersonalitiesurl); 
	 * }

	 */
	/*
	 * @Test (priority=19) public void TC49_isVideoSubMenuDisplayed() {
	 * testStart("Is Video Sub Menu Displayed");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isVideoSubMenuDisplayed());
	 }

	 */
	/*
	 * @Test (priority=20) public void TC49_isWatchVideoSubMenuDisplayed() {
	 * testStart("Is Watch Video Sub Menu Displayed");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isWatchVideoButtonDisplayed());
	 * navBar.clickWatchVideoButton(); }

	 */
	/*
	 * @Test (priority=21) public void TC49_isTrendingNowSubMenuDisplayed() {
	 * testStart("Is Trending Now Sub Menu Displayed");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isTrendingNowSubMenuDisplayed());
	 * }

	 */
	/*
	 * @Test (priority=22) public void TC49_isStormChasersSubMenuDisplayed() {
	 * testStart("Is Storm Chasers Sub Menu Displayed");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isStormChasersSubMenuDisplayed());
	 * }

	 */
	/*
	 * @Test (priority=23) public void TC49_isExpertForecastsSubMenuDisplayed() {
	 * testStart("Is Expert Forecasts Sub Menu Displayed");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isExpertForecastSubMenuDisplayed());
	 * //navBar.clickStormChasersSubMenu(); }

	 */
	/*
	 * @Test (priority=24) public void TC50_isVideoDescriptionTextDisplayed() {
	 * testStart("Is Video Description Text Displayed under Video Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * actualvideodescriptiontext =	navBar.getVideoSubMenuDescriptionText();
	 * Assert.assertEquals(actualvideodescriptiontext,expectedvideodescriptiontext);
	 * }

	 */
	/*
	 * @Test (priority=25) public void TC50_isVideoPageDisplayed() {
	 * testStart("Is Videos Page Displayed From Video Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * navBar.clickVidoeSubMenu();
	 * actualweathervideourl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualweathervideourl,expectedweathervideourl); 
	 * }

	 */
	/*
	 * @Test (priority=26) public void TC51_isVideoPageDisplayedFromWatchVideoSubMenu() {
	 * testStart("Is Videos Page displayed from Watch Video Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isWatchVideoButtonDisplayed());
	 * navBar.clickWatchVideoButton();
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWViedoPageTitle);
	 * actualweathervideourl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualweathervideourl,expectedweathervideourl); 
	 * }

	 */
	/*
	 * @Test (priority=27) public void TC52_isVideoDisplayedFromTrednignNowSubMenu()
	 * { testStart("Is Videos Page displayed from Watch Video Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * Assert.assertTrue(navBar.isWatchVideoButtonDisplayed());
	 * navBar.clickTrendingNowSubMenu();
	 * actualweathervideourl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualweathervideourl,expectedweathervideourl); 
	 * }

	 */
	/*
	 * @Test (priority=28) public void TC52_isTrendingNowDescriptionTextDisplayed()
	 * {
	 * testStart("Is Trending Now Description Text Displayed under Video Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * actualtrendingnowtext = navBar.getTredndingNowSubMenuDescriptionText();
	 * Assert.assertEquals(actualtrendingnowtext,expectedtrendingnowtext); 
	 * }

	 */
	/*
	 * @Test (priority=29) public void TC53_isVideoPageDisplayedFromStormChasersSubMenu() {
	 * testStart("Is Video Page displayed from Storm Chasers Sub Menu");
	 * navBar.mouseHoverOnVideo(); 
	 * navBar.clickStormChasersSubMenu();
	 * actualstormchasersurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualstormchasersurl,expectedstormchasersurl); 
	 * }

	 */
	 /* @Test (priority=30) public void TC52_isStormChasersDescriptionTextDisplayed()
	  {
	  testStart("Is Storm Chasers Text Displayed under Storm Chasers Sub Menu");
	  navBar.mouseHoverOnVideo();
	  actualstormchaserstext = navBar.getStormChasersSubMenuDescriptionText();
	  Assert.assertEquals(actualstormchaserstext,expectedstormchaserstext); 
	  }

	  */
	/*
	 * @Test (priority=31) public void TC54_isVideoPageDisplayedFromExpertForecastsSubMenu() {
	 * testStart("Is Video Page displayed from Expert Forecasts Sub Menu");
	 * navBar.mouseHoverOnVideo();
	 * navBar.clickExpertForecastSubMenu();
	 * actualforecastsurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualforecastsurl,expectedforecastsurl); 
	 * }

	 */
	/*
	 * @Test (priority=32) public void TC55_isSeverWeatherSubMenuDisplayed() {
	 * testStart("Verify Sever Weather Sub Menu Is Displayed");
	 * navBar.mouseHoverOnSeverWeather();
	 * Assert.assertTrue(navBar.isSeverWeatherSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=33) public void TC55_isHurricaneSubMenuDisplayed() {
	 * testStart("Verify Hurricane Sub Menu Is Displayed");
	 * navBar.mouseHoverOnSeverWeather();
	 * Assert.assertTrue(navBar.isHurricaneSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=34) public void TC55_isWinterWeatherSubMenuDisplayed() {
	 * testStart("Verify Winter Weather Sub Menu Is Displayed");
	 * navBar.mouseHoverOnSeverWeather();
	 * Assert.assertTrue(navBar.isWinterWeatherSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=35) public void TC55_isAccuWeatherReadySubMenuDisplayed() {
	 * testStart("Verify AccuWeather Ready Weather Sub Menu Is Displayed");
	 * navBar.mouseHoverOnSeverWeather();
	 * Assert.assertTrue(navBar.isAWReadySubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=36) public void TC56_isSeverWeatherPageDisplayedFromSeverWeatherSubMenu() {
	 * testStart("Is Sever Weather Page displayed from Sever Weather Sub Menu");
	 * navBar.mouseHoverOnSeverWeather();
	 * navBar.clickSeverWeatherSubMenu();
	 * waitUntilWindowExistsWithTitle(AWSeverWeatherPageTitle);
	 * actualseverweatherurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualseverweatherurl,expectedseverweaterurl);
	 * }

	 */
	/*
	 * @Test (priority=37) public void TC57_isHurricanePageDisplayedFromHurricaneSubMenu() {
	 * testStart("Is Hurricane Page displayed from Hurricane Sub Menu");
	 * navBar.mouseHoverOnSeverWeather();
	 * navBar.clickHurricaneSubMenu();
	 * waitUntilWindowExistsWithTitle(AWHurricanePageTitle); 
	 * actualhurricaneurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualhurricaneurl,expectedhurricaneurl); 
	 * }

	 */
	/*
	 * @Test (priority=38) public void TC58_isWinterWeatherPageDisplayedFromWinterWeatherSubMenu() {
	 * testStart("Is Winter Weather Page displayed from Winter Weather Sub Menu");
	 * navBar.mouseHoverOnSeverWeather();
	 * navBar.clickWinterWeatherSubMenu();
	 * waitUntilWindowExistsWithTitle(AWWinterWeatherPageTitle);
	 * actualwinterweatherurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualwinterweatherurl,expectedwitnerweatherurl); 
	 * }

	 */
	/*
	 * @Test (priority=39) public void TC59_isAWReadyPageDisplayedFromAWReadySubMenu() {
	 * testStart("Is AW Ready Page displayed from AW Ready Sub Menu");
	 * navBar.mouseHoverOnSeverWeather();
	 * navBar.clicAwReadySubMenu();
	 * waitUntilWindowExistsWithTitle(AWReadyPageTitle); 
	 * actualawreadyurl = getDriver().getCurrentUrl();
	 * Assert.assertEquals(actualawreadyurl,expectedawreadyurl);
	 * }

	 */
	/*
	 * @Test (priority=40) public void TC60_isAboutWeatherSubMenuDisplayed() {
	 * testStart("Is About Weather Sub Menu displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isAWAboutSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=41) public void TC60_isAppsDownloadsSubMenuDisplayed() {
	 * testStart("Is Apps and Downloads Sub Menu displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isAppAndDwnldSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=42) public void TC60_isPodcastSubMenuDisplayed() {
	 * testStart("Is Podcast Sub Menu displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isPodcastSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=43) public void TC60_isAWPreimumSubMenuDisplayed() {
	 * testStart("Is Accuweather Premium Sub Menu displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isAWPremiumSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=44) public void TC60_isAWProfessionalSubMenuDisplayed() {
	 * testStart("Is Accuweather Professional Sub Menu displayed Under More Main Menu"
	 * ); navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isAWProfessionalSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=45) public void TC60_isCouponsSubMenuDisplayed() {
	 * testStart("Is Coupons Sub Menu displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isCouponsSubMenuDisplayed()); }

	 */
	/*
	 * @Test (priority=46) public void TC60_isFacebookIconisplayed() {
	 * testStart("Is Facebook Icon displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isFacebookIconDisplayed()); }

	 */
	/*
	 * @Test (priority=47) public void TC60_isTwitterIconisplayed() {
	 * testStart("Is Twitter Icon displayed Under More Main Menu");
	 * navBar.mouseHoverOnMoreMenu();
	 * Assert.assertTrue(navBar.isTwitterIconDisplayed()); }

	 */
	/*@Test (priority=48) public void TC60_isInstagramIconisplayed() {
	testStart("Is Instagram Icon displayed Under More Main Menu");
	navBar.mouseHoverOnMoreMenu();
	waitUntilElementIsDisplayedOrClickable();
	Assert.assertTrue(navBar.isInstagramIconDisplayed()); 
	}*/
	/*@Test (priority=48) public void TC60_isYoutubeIconDisplayed() {
	testStart("Is YOUTUBE Icon displayed Under More Main Menu");
	navBar.mouseHoverOnMoreMenu();
	waitUntilElementIsDisplayedOrClickable();
	Assert.assertTrue(navBar.isYoutubeIconDisplayed()); 
	}*/
	/*
	 * @Test (priority=49) public void TC04_isStartSearchIconDisplayed() {
	 * testStart("Is Start Search Icon displayed Under any Categories on Top Menu");
	 * navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 * Assert.assertTrue(navBar.isStartSearchDisplayed()); }

	 */
	@Test (priority=49) public void TC06_isStartSearchCloseIconDisplayed() {
	testStart("Is Start Search Close Icon displayed Under any Categories on Top Menu");
	navBar.mouseHoverOnMoreMenu();
	waitUntilElementIsDisplayedOrClickable();
	navBar.isTopNavSearchCloseIconDisplayed();
	navBar.clickTopNavSearchCloseIcon();
	}

}
