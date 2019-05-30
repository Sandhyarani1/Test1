package com.accuweather.glacier.www.navigation;

import org.testng.annotations.Test;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.helpers.DailyForecastsHelper;
import com.accuweather.glacier.api.objects2.Example;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentWeatherPage2;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyForeCastPage1;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LocationsPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.accuweather.glacier.www.pages.SearchByLocation;
import com.accuweather.glacier.www.pages.SevereWeatherPage;
import com.accuweather.glacier.www.pages.VideoDetailsPage;

public class Test_SearchByBrowseLocation extends AccuWeatherBaseTest {

	String EnteredCityName;

	String ExpectedCityName;

	String GivenCityName = "State College";

	String AWBroadCastTitle = "AccuWeather Broadcasters";

	String RadarTitle = "US Doppler Weather Radar Map - AccuWeather.com";

	String TrendingNowTitle = "Trending Now";

	String AppandDwnldPageTitle = "AccuWeather Downloads";

	String AWPremiumPageTitle = "AccuWeather.com Premium - Login";

	String PodcastTile = "Everything Under the Sun - AccuWeather Podcast on Weekly Weather News & Stories";

	String AWProfPageTitle = "AccuWeather.com Professional - Login";

	String AboutAWPageTitle = "About AccuWeather Corporate - Weather Media with Superior Accuracy™";

	String CouponPageTitle = "AccuWeather Coupons | The Best Promo Codes & Discounts";

	// String TrendingNowTitle = "Trending Now - AccuWeather";

	// String VideosURL = "https://www.accuweather.com/en/videos/";

	private NavigationBar navBar = new NavigationBar();

	private LocationsPage locations = new LocationsPage();

	private SearchByLocation sbl = new SearchByLocation();

	private ForeCastWeatherPage fcwp = new ForeCastWeatherPage();

	private RadarWeatherPage rwp = new RadarWeatherPage();

	private NewsWeatherPage nwp = new NewsWeatherPage();

	private SevereWeatherPage swp = new SevereWeatherPage();

	private VideoDetailsPage vdp = new VideoDetailsPage();

	// private CurrentWeatherPage currentWeather = new CurrentWeatherPage();

	private CurrentWeatherPage2 currentWeather = new CurrentWeatherPage2();

	private DailyForeCastPage dailyforecastpage = new DailyForeCastPage();

	private DailyForeCastPage1 dailyforecastpage1 = new DailyForeCastPage1();

	/*
	 * 
	 * @Test (priority=1) public void isHomePageDisplayed() {
	 * 
	 * testStart("Navigate To Radar Page"); navBar.mouseHoverOnAWLogo();
	 * 
	 * navBar.navigateToHomePageByLogo(); navBar.isAWLogoDisplayed(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=2) public void isRadarAndMapsSubMenuDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isRadarSubMenuDisplayed();
	 * 
	 * navBar.isSeverSubMenuDisplayed(); navBar.isSatelliteMapsSubMenuDisplayed();
	 * 
	 * navBar.isForecastMapsSubMenuDisplayed(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=3) public void isRadarTabDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isRadarSubMenuDisplayed();
	 * 
	 * navBar.navigateToRadar(); rwp.isRadarTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=4) public void isSeverWeatherTabDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isSeverSubMenuDisplayed();
	 * 
	 * navBar.navigateToSeverWeatherPage(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=5) public void isSatelliteTabDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isSatelliteMapsSubMenuDisplayed();
	 * 
	 * navBar.navigateToSatellitePage(); rwp.isSatelliteTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=6) public void isForecastTabDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isForecastMapsSubMenuDisplayed();
	 * 
	 * navBar.navigateToForeCastPage(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=7) public void isNewsSubMenuDisplayed() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isNewsSubMenuDisplayed(); navBar.isWeatherNewsSubMenuDisplayed();
	 * 
	 * navBar.isPersonalitiesSubMenuDisplayed();
	 * 
	 * navBar.isWeatherBlogsSubMenuDisplayed();
	 * 
	 * navBar.isClimateChangeSubMenuDisplayed(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=8) public void isNewsTabSelected() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isNewsSubMenuDisplayed(); navBar.navigateToNewsTab();
	 * 
	 * nwp.isNewsTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=9) public void isNewsTabEnabledFromWeatherNewsSubMenu() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isWeatherNewsSubMenuDisplayed(); navBar.navigateToNewsPage();
	 * 
	 * nwp.isNewsTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=10) public void isBlogsTabEnabledFromWeatherBlogSubMenu() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isWeatherBlogsSubMenuDisplayed(); navBar.navigateToWeatherBlogPage();
	 * 
	 * nwp.isWeatherBlogTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=11) public void
	 * 
	 * isClimateChangeDisplayedFromWeatherBlogSubMenu() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isClimateChangeSubMenuDisplayed();
	 * 
	 * navBar.navigateToClimateChangePage(); nwp.isClimateChangeSectionEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=12) public void
	 * 
	 * isAWBroadcastDisplayedFromPersonalitiesSubMenu() {
	 * 
	 * testStart("Navigate To News Sub Menu"); navBar.mouseHoverOnNews();
	 * 
	 * navBar.isPersonalitiesSubMenuDisplayed();
	 * 
	 * navBar.navigateToPersonalitiesPage(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWBroadCastTitle);
	 * 
	 * nwp.isBroadCasterTabeEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=13) public void isAWReadySubMenuDisplayed() {
	 * 
	 * testStart("Navigate To Accuweather Ready Sub Menu");
	 * 
	 * navBar.mouseHoverOnSeverWeather(); navBar.isAWReadySubMenuDisplayed();
	 * 
	 * navBar.isHurricaneSubMenuDisplayed();
	 * 
	 * navBar.isWinterWeatherSubMenuDisplayed(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=14) public void isSevereTabSelected() {
	 * 
	 * testStart("Navigate To Accuweather Ready Sub Menu");
	 * 
	 * navBar.mouseHoverOnSeverWeather(); navBar.isAWReadySubMenuDisplayed();
	 * 
	 * navBar.navigateToSevereTabFromSevereWeatherSubMenu();
	 * 
	 * swp.isSevereTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=15) public void isAWSeverTabSelected() {
	 * 
	 * testStart("Navigate To Accuweather Ready Sub Menu");
	 * 
	 * navBar.mouseHoverOnSeverWeather(); navBar.isSeverWeatherSubMenuDisplayed();
	 * 
	 * navBar.navigateToSevereTab(); swp.isSevereTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=16) public void isUSWeatherTextDisplayed() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.isRadarSubMenuDisplayed();
	 * 
	 * navBar.navigateToRadar(); rwp.isRadarTabeEnabled();
	 * 
	 * rwp.isUSWeatherTextDisplayed();}
	 * 
	 */

	/*
	 * 
	 * @Test (priority=17) public void navigateToRadarPageFromDescriptionLink() {
	 * 
	 * testStart("Navigate To Radar&Maps Sub Menu");
	 * 
	 * navBar.mouseHoverOnRadarAndMaps(); navBar.mouseHoverOnDescriptionLink();
	 * 
	 * navBar.isDescriptionLinkDisplayed();
	 * 
	 * navBar.navigateToRadarPageFromDescritionLink(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, RadarTitle);
	 * 
	 * rwp.isUSWeatherTextDisplayed(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=18) public void navigateToVideosPageFromTrendingNowSubMenu()
	 * 
	 * { testStart("Navigate To Trending Now Page"); navBar.mouseHoverOnVideo();
	 * 
	 * //navBar.clickOnVideoMainMenu(); navBar.isTrendingNowSubMenuDisplayed();
	 * 
	 * navBar.mouseHoverOnTrendingNowSubMenu(); navBar.clickTrendingNowSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, TrendingNowTitle);
	 * 
	 * vdp.isTrendingNowTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=19) public void
	 * 
	 * navigateToVideosPageFromExpertForecastsSubMenu(){
	 * 
	 * testStart("Navigate To Video Page"); navBar.mouseHoverOnVideo();
	 * 
	 * navBar.isExpertForecastSubMenuDisplayed();
	 * 
	 * navBar.clickExpertForecastSubMenu(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, TrendingNowTitle);
	 * 
	 * vdp.isStormChasersTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=18) public void
	 * 
	 * navigateToVideosPageFromExpertForecastsSubMenu(){
	 * 
	 * testStart("Navigate To Video Page"); navBar.mouseHoverOnVideo();
	 * 
	 * navBar.isExpertForecastSubMenuDisplayed();
	 * 
	 * navBar.clickExpertForecastSubMenu(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, TrendingNowTitle);
	 * 
	 * vdp.isExpertForecastsTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=19) public void navigateToVideosPageFromStormChaserSubMenu()
	 * 
	 * { testStart("Navigate To Video Page"); navBar.mouseHoverOnVideo();
	 * 
	 * navBar.isStormChasersSubMenuDisplayed(); navBar.clickStormChasersSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, TrendingNowTitle);
	 * 
	 * vdp.isStormChasersTabEnabled(); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=20) public void navigateToAWPremiumPageFromAWPremiumSubMenu()
	 * 
	 * throws InterruptedException {
	 * 
	 * testStart("Navigate To AccuWeather Premium Page");
	 * 
	 * navBar.mouseHoverOnMoreMenu(); navBar.mouseHoverOnAWPremiumSubMenu();
	 * 
	 * navBar.isAWPremiumSubMenuDisplayed(); navBar.clickOnAWPremiumSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWPremiumPageTitle);
	 * 
	 * Thread.sleep(2000);}
	 * 
	 */

	/*
	 * 
	 * @Test (priority=21) public void
	 * 
	 * navigateAppsAppsAndDwnldPageFromAppsAndDownloadsSubMenu() throws
	 * 
	 * InterruptedException { testStart("Navigate To Apps And Download Page");
	 * 
	 * navBar.mouseHoverOnMoreMenu(); navBar.mouseHoverOnApssAppsAndDwnldSubMenu();
	 * 
	 * navBar.isAppAndDwnldSubMenuDisplayed(); navBar.clickOnAppAndDwnldSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AppandDwnldPageTitle);
	 * 
	 * Thread.sleep(2000);}
	 * 
	 */

	/*
	 * 
	 * @Test (priority=22) public void navigateToPodcastPageFromPodcastSubMenu()
	 * 
	 * throws InterruptedException { testStart("Navigate To Podcast Page");
	 * 
	 * navBar.mouseHoverOnMoreMenu(); navBar.mouseHoverOnPodcastSubMenu();
	 * 
	 * navBar.isPodcastSubMenuDisplayed(); navBar.clickOnPodcastSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, PodcastTile);
	 * 
	 * Thread.sleep(2000); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=23) public void
	 * 
	 * navigateToAWProfessionalPageFromAWProfSubMenu() throws InterruptedException {
	 * 
	 * testStart("Navigate To AccuWeather Professional Page");
	 * 
	 * navBar.mouseHoverOnMoreMenu(); navBar.mouseHoverOnAWProfessionalSubMenu();
	 * 
	 * navBar.isAWProfessionalSubMenuDisplayed();
	 * 
	 * navBar.clickOnAWProfessionalSubMenu(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AWProfPageTitle);
	 * 
	 * Thread.sleep(2000); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=24) public void navigateToAboutAWPageFromAboutAWSubMenu()
	 * 
	 * throws InterruptedException {
	 * 
	 * testStart("Navigate To About AccuWeather Page");
	 * 
	 * navBar.mouseHoverOnMoreMenu(); navBar.mouseHoverOnAWAboutSubMenu();
	 * 
	 * navBar.isAWAboutSubMenuDisplayed(); navBar.clickOnAWAboutSubMenu();
	 * 
	 * ExtendedWebDriver driver = (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, AboutAWPageTitle);
	 * 
	 * Thread.sleep(2000); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=25) public void navigateToCouponsPageFromCouponsSubMenu() {
	 * 
	 * testStart("Navigate To Coupons Page"); navBar.mouseHoverOnMoreMenu();
	 * 
	 * navBar.mouseHoverOnCouponsSubMenu(); navBar.isCouponsSubMenuDisplayed();
	 * 
	 * navBar.clickOnCouponsSubMenu(); ExtendedWebDriver driver =
	 * 
	 * (ExtendedWebDriver) DriverManager.getDriver();
	 * 
	 * WindowHandler.waitUntilWindowExistsWithTitle(driver, CouponPageTitle); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=1) public void test_SearchByBrowseLocation() throws
	 * 
	 * InterruptedException { testStart("Navigate To ForeCast Page");
	 * 
	 * Thread.sleep(2000);
	 * 
	 * 
	 * 
	 * navBar.clickStartSearch(); sbl.navigateToLocations();
	 * 
	 * locations.navigateToCountry(); locations.navigateToState();
	 * 
	 * locations.navigateToCity(); String ActualForeCastCityName =
	 * 
	 * locations.navigateToForeCast(); //Thread.sleep(5000);
	 * 
	 * System.out.println("ActualForeCastCityName...." +ActualForeCastCityName);
	 * 
	 * String ExpectedForeCastCityName = fcwp.getforecastCityNameSubString();
	 * 
	 * System.out.println("ExpectedForeCastCityName......."+ExpectedForeCastCityName
	 * 
	 * ); TestReporter.assertEquals(ActualForeCastCityName,
	 * 
	 * ExpectedForeCastCityName,"The City Name's Are Same");
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	/*
	 * 
	 * @Test (priority=2) public void test_AreForecastCityNameSame() {
	 * 
	 * testStart("Navigate To ForeCast Page"); EnteredCityName =
	 * 
	 * navBar.clickAndGetlocationCityName(GivenCityName);
	 * 
	 * System.out.println("EnteredCityName......." +EnteredCityName);
	 * 
	 * ExpectedCityName = fcwp.getforecastCityNameSubString();
	 * 
	 * System.out.println("ExpectedCityName......." +ExpectedCityName);
	 * 
	 * TestReporter.assertEquals(ExpectedCityName,
	 * 
	 * EnteredCityName,"The City Name's Are Same"); }
	 * 
	 */

	/*
	 * 
	 * @Test (priority =5) public void
	 * 
	 * test_DisplayedCurrentWeatherDataMatchesRestData() { Condition condition =
	 * 
	 * CurrentConditionsHelper.getCityCurrentCondition(Environment.getEnvironment(),
	 * 
	 * "US", "State College", "PA"); System.out.println("condition..............."
	 * 
	 * +condition); String ConditionLink = condition.getLink();
	 * 
	 * System.out.println("ConditionLink ConditionLink ConditionLink...."
	 * 
	 * +ConditionLink); setPageURL(condition.getLink());
	 * 
	 * testStart("test_DisplayedCurrentWeatherDataMatchesRestData");
	 * 
	 * currentWeather.validateCurrentConditions(condition);
	 * 
	 * TestReporter.assertAll(); }
	 * 
	 */

	@Test(priority = 6)
	public void test_DisplayedDailyForeCastWeatherDataMatchesRestData()

	{

		Example example = DailyForecastsHelper.getCityDailyForecast(Environment.getEnvironment(),

				"US", "State College", "PA");

		System.out.println("dailyforecast..............." + example);

		String DailyForeCastURL = example.getDailyForecasts().get(0).getLink();

		System.out.println("DailyForeCastURL DailyForeCastURL..............." + DailyForeCastURL);

		setPageURL(DailyForeCastURL);

		Double DailyForeCastMaximumTemperature = example.getDailyForecasts().get(0).getTemperature().getMaximum()
				.getValue();

		System.out.println("DailyForeCastMaximumTemperature.............." + DailyForeCastMaximumTemperature);

		String DailyForeCastAirPollenName = example.getDailyForecasts().get(0).getAirAndPollen().get(0).getName();

		System.out.println("DailyForeCastAirPollenName..............." + DailyForeCastAirPollenName);

		String DailyForeCastHeadLineText = example.getHeadline().getText();

		System.out.println("DailyForeCastHeadLineText.............." + DailyForeCastHeadLineText);

		testStart("test_DisplayedDailyForeCastDataMatchesRestData");

		// int DailyTemp = dailyforecastpage1.validate1(by, elementName, expectedText);;

		// Assert.assertEquals(DailyTemp, DailyForeCastMaximumTemperature);

		// Double DailyForecastTemperature =
		// example.getDailyForecasts().get(0).getTemperature().

		// Assert.assertTrue(dailyforecastpage1.validateDailyForeCastPage1(example));

		dailyforecastpage1.validateDailyForeCastPage1(example);

	}

}