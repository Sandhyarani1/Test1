package com.accuweather.glacier.www.universalnavigation;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.Localizations;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;

public class Test_UniversalNavigation extends AccuWeatherBaseTest 
{
	
	public static String ACCUWEATHER_LOGO_IMAGE_SOURCE = "images/logos/accuweather.svg";
	public static final String SEARCH_INPUT_TEXT = "Search location, zip...";
	
	
	String expectedradartitle = "United States Doppler Weather Radar Map - AccuWeather.com";
	String actualweathervideourl;
	String expectedweathervideourl = "https:qualityassurance.accuweather.com/en/videos";
	String actualclimatechangeurl;
	String expectedclimatechangeurl = "https:qualityassurance.accuweather.com/en/climate-change";
	String AWBroadCastTitle = "AccuWeather Broadcasters";
	String AWViedoPageTitle = "Trending Now - AccuWeather";
	String AWHurricanePageTitle = "Hurricane";
	String AWSeverWeatherPageTitle = "Severe Weather Watches and Weather Warnings - AccuWeather.com";
	String AWWinterWeatherPageTitle = "Winter Center - AccuWeather.com";
	String expectedForecastPageTitle = "AccuWeather Forecast for";
	String AWReadyPageTitle = "AccuWeather Ready";
	String actualpersonalitiesurl;
	String expectedpersonalitiesurl = "https:getaccuweather.tv/broadcasters";
	String actualvideodescriptiontext;
	String expectedvideodescriptiontext = "Video coverage of the top weather events people are talking about";
	String actualtrendingnowtext;
	String expectedtrendingnowtext = "Watch the best weather videos across the web";
	String actualstormchasersurl;
	String expectedstormchasersurl = "https:qualityassurance.accuweather.com/en/videos/storm-chasers";
	String actualstormchaserstext;
	String expectedstormchaserstext = "Our field teams brave the elements";
	String actualforecastsurl;
	String expectedforecastsurl = "https:qualityassurance.accuweather.com/en/videos/experts";
	String expectedseverweaterurl = "https:qualityassurance.accuweather.com/en/us/severe-weather";
	String actualseverweatherurl;
	String actualhurricaneurl;
	String expectedhurricaneurl = "https:qualityassurance.accuweather.com/en/hurricane";
	String actualwinterweatherurl;
	String expectedwitnerweatherurl = "https:qualityassurance.accuweather.com/en/us/winter-weather";
	String actualawreadyurl;
	String expectedawreadyurl = "https:qualityassurance.accuweather.com/en/accuweather-ready";
	String actualcitypagetitle;
	String expectedcitypagetitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
	String actuallocationsearchtitle;
	String actualbrowselocationtitle;
	String expectedlocationsearchtitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
	String expectedbrowselocationtitle = "Browse For Your Weather Location | AccuWeather";
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

	private NavigationBar navigationBar = new NavigationBar();
	private RadarWeatherPage rwp = new RadarWeatherPage();
	private NewsWeatherPage nwp = new NewsWeatherPage();
	private LandingPage landingPage = new LandingPage();
	private Localizations localizations = new Localizations();
	
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert;
	
/******************************************************* RADAR & MAPS SUBMENU ****************************************************************************/
	
	public static final String RADAR_AND_MAPS_TAB 				= "RADAR & MAPS";
	public static final String RADAR_AND_MAPS_SUBMENU 			= "Radar & Maps";
	public static final String RADAR_SUBMENU					= "Radar";
	public static final String CURRENT_CONDITIONS_SUBMENU		= "Current Conditions";
	public static final String FORECAST_SUBMENU					= "Forecast";
	public static final String SATELLITE_SUBMENU				= "Satellite";
	public static final String SEVERE_SUBMENU					= "Severe";
	
	//Radar Sub Menu
	public static String RADARMAPS_URL = "";
	public final static String RADAR_MAPS_URL_SUFFIX = "weather-radar";
	
	// CURRENT CONDITIONS SUBMENU
	public final static String CURRENT_CONDITIONS_URL_SUFFIX = "national/current-weather-maps";
	public static String CURRENT_CONDITIONS_URL = "";
	
	//SATELLITE SUBMENU
	public final static String SATELLITE_URL_SUFFIX = "satellite";
	public static String SATELLITE_URL = "";
	
	// SEVERE SUBMENU
	public final static String SEVERE_URL_SUFFIX = "national/severe-weather-maps";
	public static String SEVERE_URL = "";
	
	// FORECAST SUBMENU
	public final static String FORECAST_URL_SUFFIX = "national/weather-forecast-maps";
	public static String FORECAST_URL = "";
	
	//Descriptions of Radar & Maps Sub menus
	public static final String EXPECTED_RADARMAPS_SUBMENU_DESCRIPTION 			= "Visualize past, present, and future weather from many angles via both static and interactive maps";
	public static final String EXPECTED_RADAR_SUBMENU_DESCRIPTION 				= "Current and future radar maps for assessing areas of precipitation, type, and intensity";
	public static final String EXPECTED_CURRENT_CONDITIONS_SUBMENU_DESCRIPTION 	= "View live current conditions in and around your area";
	public static final String EXPECTED_SATELLITE_SUBMENU_DESCRIPTION 			= "Satellite maps for visualizing where there is cloud cover and associated precipitation";
	public static final String EXPECTED_SEVERE_SUBMENU_DESCRIPTION 				= "Currently active global watches and warnings, lightning, and severe weather risk";
	public static final String EXPECTED_FORECAST_SUBMENU_DESCRIPTION 			= "Daily forecast map for precipitation";
	public static final String EXPECTED_SATELLITEMAP_TITLE 						= "United States Weather Radar";
	public static final String EXPECTED_SATELLITEMAP_DESCRIPTION 				= "United States National map showing where and how intense precipitation is falling";
	public static String EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL 	= "";
/********************************************END OF RADAR AND MAPS ****************************************************************************************/


/************************************** NEWS SUBMENU **************************************************************************************************/
	public static final String NEWS_TAB		 						= "NEWS";
	public static final String NEWS_SUBMENU							= "News";
	public static final String NEWS_SUBMENU_DESCRIPTION				= "Coverage of top events from the world’s most trusted name in weather";
	public static final String WATCH_NEWS							= "Watch News";
	public static final String WEATHER_NEWS_SUBMENU					= "Weather News";
	public static final String WEATHER_NEWS_SUBMENU_DESCRIPTION		= "Breaking news and top weather stories from around the globe";
	public static final String PERSONALITIES_SUBMENU				= "Personalities";
	public static final String PERSONALITIES_SUBMENU_DESCRIPTION	= "Meet the talent dedicated to bringing you the most accurate information";
	public static final String WEATHER_BLOGS_SUBMENU				= "Weather Blogs";
	public static final String WEATHER_BLOGS_SUBMENU_DESCRIPTION	= "Opinions on weather and climate by our top experts";
	public static final String CLIMATE_CHANGE_SUBMENU				= "Climate Change";
	public static final String CLIMATE_CHANGE_SUBMENU_DESCRIPTION	= "Daily blog of news related to the topic of global climate change";
	public String getThumbnailImgSrc 								= "";
	public String getDateFromAPI 									= "";
	public String getArticleTitleFromAPI 							= "";
	public String getArticleTitleUrlFromAPI 						= "";
	public static String newsURL									= "";
	public static final String NEWS_URL_SUFFIX						= "weather-news";
	public static String watchNewsURL								= "";
	public static final String WATCH_NEWS_URL_SUFFIX				= "videos";
	public static String weatherNewsURL								= "";
	public static final String WEATHER_NEWS_URL_SUFFIX				= "weather-news";
	public static final String PERSONALITIES_URL					= "https://getaccuweather.tv/broadcasters";
	public static String weatherBlogsURL							= "";
	public static final String WEATHER_BLOGS_URL_SUFFIX				= "weather-blogs";
	public static String climateChangeURL							= "";
	public static final String CLIMATE_CHANGE_URL_SUFFIX			= "climate-change";
	
/***************************************** END OF NEWS ***************************************************************************************************/
	
	
/************************************** VIDEOS SUBMENU ****************************************************************************************************/
	public static final String VIDEO_TAB 							= "VIDEO";
	public static final String VIDEO_SUBMENU	 					= "Video";
	public static final String WATCH_VIDEO							= "Watch Video";
	public static final String TRENDING_NOW							= "Trending Now";
	public static final String EXPERT_FORECASTS						= "Expert Forecasts";
	public static final String STORM_CHASERS						= "Storm Chasers";
	public static final String VIDEO_SUBMENU_DESCRIPTION			= "Video coverage of the top weather events people are talking about";
	public static final String TRENDING_NOW_DESCRIPTION				= "Watch the best weather videos across the web";
	public static final String EXPERT_FORECASTS_DESCRIPTION			= "How will the latest weather patterns impact you?";
	public static final String STORM_CHASERS_DESCRIPTION			= "Our field teams brave the elements";
	public static final String VIDEO_URL_SUFFIX						= "videos";
	public static String video_URL									= "";
	public static String watchVideo_URL								= "";
	public static String trendingNow_URL							= "";
	public static String expertForecasts_URL						= "";
	public static final String EXPERT_FORECASTS_URL_SUFFIX			= "videos/experts";
	public static String stormChasers_URL							= "";
	public static final String STORM_CHASERS_URL_SUFFIX				= "videos/storm-chasers";
	public String getThumbnailImgSrc_VIDEO 							= "";
	public String getVideoDurationFromAPI 							= "";
	public String getVideo_ArticleTitleFromAPI 						= "";
	public String getVideo_ArticleTitleUrlFromAPI 					= "";
	
/******************************************END OF VIDEO *************************************************************************************************/	
	
/******************************************** SEVERE WEATHER *********************************************************************************************/	
	public static final String SEVERE_WEATHER_TAB		 					= "SEVERE WEATHER";
	public static final String SEVERE_WEATHER_SUBMENU						= "Severe Weather";
	public static final String HURRICANE_SUBMENU							= "Hurricane";
	public static final String HURRICANE_SUBMENU_DESCRIPTION				= "Everything you need for tracking hurricane season";
	public static final String ACCUWEATHER_READY_SUBMENU					= "AccuWeather Ready";
	public static final String ACCUWEATHER_READY_SUBMENU_DESCRIPTION		= "Be prepared for any type of weather";
	public static final String WINTER_WEATHER_SUBMENU						= "Winter Weather";
	public static final String WINTER_WEATHER_SUBMENU_DESCRIPTION			= "Provides winter weather forecasts and the winter weather outlook for your area";
	public static String severeWeatherURL									= "";
	public static final String SEVERE_WEATHER_URL_SUFFIX					= "severe-weather";
	public static String hurricaneURL										= "";
	public static final String HURRICANE_URL_SUFFIX							= "hurricane";
	public static String accuWeatherReadyURL								= "";
	public static final String ACCUWEATHER_READY_URL_SUFFIX					= "accuweather-ready";
	public static String winterWeatherURL									= "";
	public static final String WINTER_WEATHER_URL_SUFFIX					= "winter-weather";
	
/******************************************* END OF SEVERE WEATHER ***************************************************************************************/
	
	
/************************************* MORE SUBMENU *****************************************************/
	public static final String MORE_TAB 							= "MORE";
	public static final String ABOUT_ACCUWEATHER					= "About AccuWeather";
	public static final String ABOUT_ACCUWEATHER_DESCRIPTION		= "Visit our Corporate Site for more info on AccuWeather";
	public static final String ACCUWEATHER_PREMIUM					= "AccuWeather Premium"; 
	public static final String ACCUWEATHER_PREMIUM_DESCRIPTION		= "Explore More, Dive Deeper, Analyse Faster with AccuWeather Premium";
	public static final String APPS_AND_DOWNLOADS					= "Apps & Downloads"; 
	public static final String APPS_AND_DOWNLOADS_DESCRIPTION		= "Download our free award-winning apps for Superior Accuracy™ on the go"; 
	public static final String ACCUWEATHER_PROFESSIONAL				= "AccuWeather Professional"; 
	public static final String ACCUWEATHER_PROFESSIONAL_DESCRIPTION	= "Specialised Weather Centres, More of Everything with AccuWeather Professional"; 
	public static final String PODCAST								= "Podcast"; 
	public static final String PODCAST_DESCRIPTION					= "Listen to behind-the-scenes details on trending weather topics."; 
/************************************************* END OF MORE *****************************************************************************/	
	
/**************************************************** Test Data ********************************************************************************************/
	public final static String CITYNAME = "Buffalo";
	public final static String LANGUAGE = "EN";
	public static String countryCode = "";
	public static String stateName = "";
	public static String location = "";
	public static String stateCode = "";
/***********************************************************************************************************************************************************/	
	
	
	@BeforeTest
	public void setURLData()
	{
		int rowNo=0;
		rowNo = ExcelUtilities.getRowNumberForCity(CITYNAME);
		countryCode = ExcelUtilities.getCountryCode(rowNo);
		stateName = ExcelUtilities.getStateName(rowNo).replace(' ', '-');
		stateCode = ExcelUtilities.getStateCode(rowNo);
		location = CITYNAME + ", " + stateCode + ", " + countryCode;
		
		ACCUWEATHER_LOGO_IMAGE_SOURCE = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+ACCUWEATHER_LOGO_IMAGE_SOURCE;
		
		/************************************* API DATA FOR NEWS*************************************************/
		getThumbnailImgSrc = LandingPageAPI.getUniversalNavigationNewsData()[4];
		getDateFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[1];
		getArticleTitleFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[0];
		getArticleTitleUrlFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[2];
		getThumbnailImgSrc_VIDEO = LandingPageAPI.getUniversalNavigationVideoData()[1];
		getVideoDurationFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[2];
		getVideo_ArticleTitleFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[0];
		getVideo_ArticleTitleUrlFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[3];
		
/********************************************* URLS*************************************************************************************************/
/********************************************* RADAR AND MAPS URLS *********************************************************************************/
		RADARMAPS_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+stateName+"/"+RADAR_MAPS_URL_SUFFIX).toLowerCase();
		CURRENT_CONDITIONS_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+CURRENT_CONDITIONS_URL_SUFFIX).toLowerCase();
		SATELLITE_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+stateName+"/"+SATELLITE_URL_SUFFIX).toLowerCase();
		SEVERE_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+SEVERE_URL_SUFFIX).toLowerCase();
		FORECAST_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+FORECAST_URL_SUFFIX).toLowerCase();
		EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/national/weather-radar").toLowerCase();
		
/********************************************* NEWS URLS ******************************************************************************************/
		newsURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+NEWS_URL_SUFFIX).toLowerCase();
		watchNewsURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+WATCH_NEWS_URL_SUFFIX).toLowerCase();
		weatherNewsURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+NEWS_URL_SUFFIX).toLowerCase();
		weatherBlogsURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+WEATHER_BLOGS_URL_SUFFIX).toLowerCase();
		climateChangeURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+CLIMATE_CHANGE_URL_SUFFIX).toLowerCase();
		
/********************************************* VIDEO URLS *****************************************************************************************/
		video_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+VIDEO_URL_SUFFIX).toLowerCase();
		watchVideo_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+VIDEO_URL_SUFFIX).toLowerCase();
		trendingNow_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+VIDEO_URL_SUFFIX).toLowerCase();
		expertForecasts_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+EXPERT_FORECASTS_URL_SUFFIX).toLowerCase();
		stormChasers_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+STORM_CHASERS_URL_SUFFIX).toLowerCase();
		
/********************************************* SEVERE WEATHER URLS ******************************************************************************/
		severeWeatherURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+SEVERE_WEATHER_URL_SUFFIX).toLowerCase();
		hurricaneURL = 	(appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+HURRICANE_URL_SUFFIX).toLowerCase();
		accuWeatherReadyURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+ACCUWEATHER_READY_URL_SUFFIX).toLowerCase();
		winterWeatherURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+countryCode+"/"+WINTER_WEATHER_URL_SUFFIX).toLowerCase();
		
	}
	
	@Test(priority=1)
	public void RW_T270Logo_Search_And_NavigationMenuVerification()
	{
		softAssert = new SoftAssert();
		testStart("********** Test whether logos, search and Navigation menu are displayed *************");
		
		/************** Validation whether the AccuWeather logo is displayed ******************************/
		softAssert.assertTrue(navigationBar.isAccuWeatherLogoDisplayed(),
				"\nIssue-----> AccuWeather logo is not displayed");
		
		/************** Validation of AccuWeather image source ****************************/
		softAssert.assertEquals(navigationBar.getImageSourceOfAccuWeatherLogo(), ACCUWEATHER_LOGO_IMAGE_SOURCE,
				"\nIssue---------> AccuWeather logo image source not matching");
		
		/********************* Validate if the Universal Navigation menu is displayed and the text is correct *******************/
		
		/*********************************** Radar & Maps Tab **********************************/
		softAssert.assertTrue(navigationBar.isRadarAndMapsTabDisplayed(),
				"\nIssue--------> Radar & Maps tab not found\n");
		softAssert.assertEquals(navigationBar.getRadarAndMapsText(), RADAR_AND_MAPS_TAB);
		
		
		/*********************************** News Tab **********************************/
		softAssert.assertTrue(navigationBar.isNewsTabDisplayed(),
				"\nIssue-------> News Tab not found\n");
		softAssert.assertEquals(navigationBar.getNewsText(), NEWS_TAB);
		
		
		/*********************************** Video Tab **********************************/
		softAssert.assertTrue(navigationBar.isVideoTabDisplayed(),
				"\nIssue--------> Video Tab not found\n");
		softAssert.assertEquals(navigationBar.getVideoText(), VIDEO_TAB);
		
		
		/*********************************** Severe Weather Tab **********************************/
		softAssert.assertTrue(navigationBar.isSevereWeatherTabDisplayed(),
				"\nIssue---------> Severe Weather Tab not found");
		softAssert.assertEquals(navigationBar.getSevereWeatherText(), SEVERE_WEATHER_TAB);
		
		
		/*********************************** More Tab **********************************/
		softAssert.assertTrue(navigationBar.isMoreTabDisplayed(),
				"\nIssue--------> More tab not found");
		softAssert.assertEquals(navigationBar.getMoreText(), MORE_TAB);
		
		
		/*********************************** Search Bar **********************************/
		softAssert.assertTrue(navigationBar.isSearchBarDisplayed(),
				"\nIssue--------> Search Bar not found");
		softAssert.assertTrue(navigationBar.isSearchIconDisplayed(),
				"\nIssue--------> Search Icon not found");
		softAssert.assertTrue(navigationBar.isSearchInputDisplayed(),
				"\nIssue--------> Search Input not found");
		softAssert.assertEquals(navigationBar.getSearchInputText(),SEARCH_INPUT_TEXT,
				"\nIssue--------> Search Input text not found");
				
		
		/********************* Validate if the setting icon is displayed **************************/
		softAssert.assertTrue(navigationBar.isSettingIconDisplayed(),
				"\nIssue----------> Setting icon not found");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void RW_T284_RadarAndMapsTab_Validation()
	{
		softAssert = new SoftAssert();
		testStart("********************* Validation of Radar & Maps tab and sub menu items ******************************");
		
		/********************* Validate if all the sub menus under Radar & Maps are displayed, the texts and descriptions are as expected ********/
		
		landingPage.enterCityNameInSearchField(CITYNAME);
		landingPage.selectCityFromTheList(location);
			
		/**************************** Verifying the description of all sub menu under radar & maps *****************************/
		
		//Radar and Maps sub menu validations
		navigationBar.hoverOnRadarAndMaps();
		softAssert.assertTrue(navigationBar.isRadarAndMapsSubMenuDisplayed(),
				"\nIssue-----> Radar & Maps submenu not found");
		softAssert.assertEquals(navigationBar.getRadarAndMapsSubMenuText(), RADAR_AND_MAPS_SUBMENU);
		softAssert.assertEquals(navigationBar.getRadarAndMapsSubmenuDescription(), EXPECTED_RADARMAPS_SUBMENU_DESCRIPTION,
				"\nIssue---->Map Submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getRadarAndMapPageURL(), RADARMAPS_URL,
						"\nIssue---->Radar Maps URL not as expected");
		
		
		//Radar Sub menu validations
		softAssert.assertTrue(navigationBar.isRadarSubMenuDisplayed(),
				"\nIssue-----> Radar submenu not found");
		softAssert.assertEquals(navigationBar.getRadarSubMenuText(), RADAR_SUBMENU,
				"\nIssue-----> Radar submenu text not as expected");
		softAssert.assertEquals(navigationBar.getRadarSubmenuDescription(), EXPECTED_RADAR_SUBMENU_DESCRIPTION,
				"\nIssue----->Radar Submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getRadarPageURL(), RADARMAPS_URL,
				"\nIssue---->Radar Page URL not as expected");
		
		
		//Current conditions sub menu validations
		softAssert.assertTrue(navigationBar.isCurrentConditionsSubMenuDisplayed(),
				"\nIssue-----> Curent conditions submenu not found");
		softAssert.assertEquals(navigationBar.getCurrentConditionsSubMenuText(), CURRENT_CONDITIONS_SUBMENU,
				"\nIssue------> Current conditions submenu text not as expected");
		softAssert.assertEquals(navigationBar.getCurrentConditionsSubmenuDescription(), EXPECTED_CURRENT_CONDITIONS_SUBMENU_DESCRIPTION,
				"\nIssue----->Current conditions submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getCurrentConditionsPageURL(), CURRENT_CONDITIONS_URL,
				"\nIssue---->Current conditions page URL not as expected\n");
		
		
		//Satellite sub menu validations
		softAssert.assertTrue(navigationBar.isSatelliteSubMenuDisplayed(),
				"\nIssue-----> Satellite submenu not found");
		softAssert.assertEquals(navigationBar.getSatelliteSubMenuText(), SATELLITE_SUBMENU,
				"\nIssue-----> Satellite submenu text not as expected");
		softAssert.assertEquals(navigationBar.getSatelliteSubmenuDescription(), EXPECTED_SATELLITE_SUBMENU_DESCRIPTION,
				"\nIssue----->Satellite Submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getSatellitePageURL(), SATELLITE_URL,
				"\nIssue---->Satellite URL not as expected\n");
		
		
		//Severe sub menu validations
		softAssert.assertTrue(navigationBar.isSeverSubMenuDisplayed(),
				"\nIssue-----> Severe submenu not found");
		softAssert.assertEquals(navigationBar.getSevereSubMenuText(), SEVERE_SUBMENU,
				"\nIssue Severe submenu text not as expected");
		softAssert.assertEquals(navigationBar.getSevereSubmenuDescription(), EXPECTED_SEVERE_SUBMENU_DESCRIPTION,
				"\nIssue----->Severe Submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getSevereWeatherPageURL(), SEVERE_URL,
				"\nIssue---->Severe URL not as expected\n");
		
		
		
		//Forecast sub menu validations
		softAssert.assertTrue(navigationBar.isForecastSubMenuDisplayed(),
				"\nIssue-----> Forecast submenu not found");
		softAssert.assertEquals(navigationBar.getForecastSubMenuText(), FORECAST_SUBMENU);
		softAssert.assertEquals(navigationBar.getForecastSubmenuDescription(), EXPECTED_FORECAST_SUBMENU_DESCRIPTION,
				"\nIssue---->Forecast Submenu description not as expected\n");
		softAssert.assertEquals(navigationBar.getForecastPageURL(), FORECAST_URL,
				"\nIssue---->Forecast URL not as expected\n");
		
		/************************* verify satellite image, map title and description and URL of mapimage, maptitle, mapdescription *************************/
		navigationBar.verifySatelliteImageTitleDescription();
		softAssert.assertEquals(NavigationBar.strMapTitle, EXPECTED_SATELLITEMAP_TITLE,
				"\nIssue---->Satellite title not as expected\n");
		
		softAssert.assertEquals(NavigationBar.strSatelliteMapDescription, EXPECTED_SATELLITEMAP_DESCRIPTION,
				"\nIssue---->Satellite map description not as expected\n");
        
		softAssert.assertEquals(NavigationBar.strMapUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nIssue----->Satellite map url not as expected\n");
        
		softAssert.assertEquals(NavigationBar.strMapTitleUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nIssue---->Satellite Map Title URL not as expected\n");
        
		softAssert.assertEquals(NavigationBar.strMapDescriptionUrl, EXPECTED_RADARMAPS_MAPIMAGETITLEDESCRIPTION_URL,
        		"\nSatellite Map description not as expected\n");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void RW_T287_NewsTabValidation()
	{
		softAssert = new SoftAssert();
		testStart("********************* Validation of news tab and sub menu items of News ******************************");
		
		/********************* Validate if all the sub menus under News are displayed, the texts and descriptions are as expected ********/
		
		/*************************** News **********************************/
		softAssert.assertTrue(navigationBar.isNewsSubMenuDisplayed(),
				"\nIssue-----> News submenu unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getNewsSubMenuText(), NEWS_SUBMENU,
				"\nIssue----> News submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getNewsSubMenuDescription(), NEWS_SUBMENU_DESCRIPTION,
				"\n Issue News Submenu description not correct\n");
		softAssert.assertEquals(navigationBar.getNewsPageURL(), newsURL,
				"\nIssue-----> News Page URL not matching");
		
		
		/*************************** Watch News **********************************/
		softAssert.assertTrue(navigationBar.isWatchNewsSubMenuDisplayed(),
				"\nIssue-----> Watch News submenu unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getWatchNewsText(), WATCH_NEWS,
				"\nIssue----> Watch News text is not correct\n");
		softAssert.assertEquals(navigationBar.getWatchNewsPageURL(), watchNewsURL,
				"\nIssue-----> Watch News Page URL not matching");
		
		/*************************** Weather News **********************************/
		softAssert.assertTrue(navigationBar.isWeatherNewsSubMenuDisplayed(),
				"\nIssue-----> Weather News submenu unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getWeatherNewsText(), WEATHER_NEWS_SUBMENU,
				"\nIssue----> Weather News submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getWeatherNewsDescription(), WEATHER_NEWS_SUBMENU_DESCRIPTION,
				"\n Issue Weather News description not correct\n");
		softAssert.assertEquals(navigationBar.getWeatherNewsPageURL(), weatherNewsURL,
				"\nIssue-----> Weather News Page URL not matching");
		
		/*************************** Personalities **********************************/
		softAssert.assertTrue(navigationBar.isPersonalitiesSubMenuDisplayed(),
				"\nIssue-----> Personalities submenu unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getPersonalitiesText(), PERSONALITIES_SUBMENU,
				"\nIssue----> Personalities submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getPersonalitiesDescription(), PERSONALITIES_SUBMENU_DESCRIPTION,
				"\n Issue Personalities description not correct\n");
		softAssert.assertEquals(navigationBar.getPersonalitiesPageURL(), PERSONALITIES_URL,
				"\nIssue-----> Personalities Page URL not matching");
		
		
		/*************************** Weather Blogs **********************************/
		softAssert.assertTrue(navigationBar.isWeatherBlogsSubMenuDisplayed(),
				"\nIssue-----> Weather Blogs unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getWeatherBlogsText(), WEATHER_BLOGS_SUBMENU,
				"\nIssue----> News submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getWeatherBlogsDescription(), WEATHER_BLOGS_SUBMENU_DESCRIPTION,
				"\n Issue Weather Blogs description not correct\n");
		softAssert.assertEquals(navigationBar.getWeatherBlogsURL(), weatherBlogsURL,
				"\nIssue-----> Weather Blogs Page URL not matching");
		
		
		/*************************** Climate Change **********************************/
		softAssert.assertTrue(navigationBar.isClimateChangeSubMenuDisplayed(),
				"\nIssue-----> Climate change submenu unders News tab not displayed\n");
		softAssert.assertEquals(navigationBar.getClimateChangeText(), CLIMATE_CHANGE_SUBMENU,
				"\nIssue----> Climate Change text is not correct\n");
		softAssert.assertEquals(navigationBar.getClimateChangeDescription(), CLIMATE_CHANGE_SUBMENU_DESCRIPTION,
				"\n Issue Climate Change Submenu description not correct\n");
		softAssert.assertEquals(navigationBar.getClimateChangePageURL(), climateChangeURL,
				"\nIssue-----> Climate Change Page URL not matching");
		
		/************************** API Validations ***********************************/
		softAssert.assertEquals(navigationBar.getImgSrcThumbnailUnderNews(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under news is not matching with API Data");

		/****************Validate date of the news article ***************************************/	
		softAssert.assertEquals(navigationBar.getDateBelowThumbnailUnderNews(), getDateFromAPI,
				"Issue-----> Date below thumbnail under news is not matching with API Data");
		
		
		/****************Validate article title***************************************/
		softAssert.assertEquals(navigationBar.getArticleTitleUnderNews(), getArticleTitleFromAPI,
				"Issue-----> Article title under news is not matching with API Data");
		
		/******************** URL *********************************/
		softAssert.assertEquals(navigationBar.getArticleTitleUrlUnderNews(), getArticleTitleUrlFromAPI,
				"Issue------> Article URL not matching with the API Data");	
		
		softAssert.assertAll();
	}
	
	
	@Test(priority=4)
	public void RW_T288_VideoTabValidation()
	{
		softAssert = new SoftAssert();
		testStart("********************* Validation of VIDEO tab and sub menu items of Video ******************************");
		
		/********************* Validate if all the sub menus under video are displayed, the texts and descriptions are as expected ********/
		
		/*************************** Video **********************************/
		softAssert.assertTrue(navigationBar.isVideoSubMenuDisplayed(),
				"\nIssue-----> Video submenu tab not displayed\n");
		softAssert.assertEquals(navigationBar.getVideoText(), VIDEO_TAB,
				"\nIssue----> Video submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getVideoSubMenuDescriptionText(), VIDEO_SUBMENU_DESCRIPTION,
				"\n Video Submenu description not correct\n");
		softAssert.assertEquals(navigationBar.getVideoSubMenuPageURL(), video_URL,
				"\nIssue-----> Video Page URL not matching");
		
		
		/*************************** Watch Video **********************************/
		softAssert.assertTrue(navigationBar.isWatchVideoDisplayed(),
				"\nIssue-----> Watch Video submenu unders Video tab not displayed\n");
		softAssert.assertEquals(navigationBar.getWatchVideoText(), WATCH_VIDEO,
				"\nIssue----> Watch Video text is not correct\n");
		softAssert.assertEquals(navigationBar.getWatchVideo_SubMenu_PageURL(), watchVideo_URL,
				"\nIssue-----> Watch Video Page URL not matching");
		
		/*************************** Trending Now **********************************/
		softAssert.assertTrue(navigationBar.isTrendingNow_SubMenu_Displayed(),
				"\nIssue-----> Trending Now tab not displayed\n");
		softAssert.assertEquals(navigationBar.getTrendingNowText(), TRENDING_NOW,
				"\nIssue----> Trending Now text is not correct\n");
		softAssert.assertEquals(navigationBar.getTredndingNowSubMenuDescriptionText(), TRENDING_NOW_DESCRIPTION,
				"\n Trending Now description not correct\n");
		softAssert.assertEquals(navigationBar.getTrendingNowSubMenuPageURL(), trendingNow_URL,
				"\nIssue-----> Trending Now Page URL not matching");
		
		/*************************** Expert Forecasts **********************************/
		softAssert.assertTrue(navigationBar.isExpertForecastSubMenuDisplayed(),
				"\nIssue-----> Expert Forecast submenu unders Video tab not displayed\n");
		softAssert.assertEquals(navigationBar.getExpertForecastText(), EXPERT_FORECASTS,
				"\nIssue---->"+EXPERT_FORECASTS+" submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getExpertForecastDescription(), EXPERT_FORECASTS_DESCRIPTION,
				"\n Issue "+EXPERT_FORECASTS +" description not correct\n");
		softAssert.assertEquals(navigationBar.getExpertForecastSubMenuPageURL(), expertForecasts_URL,
				"\nIssue-----> "+EXPERT_FORECASTS+" Page URL not matching");
		
		
		/*************************** Storm Chasers **********************************/
		softAssert.assertTrue(navigationBar.isStormChasersSubMenuDisplayed(),
				"\nIssue-----> "+STORM_CHASERS+" submenu not displayed\n");
		softAssert.assertEquals(navigationBar.getStormChasersText(), STORM_CHASERS,
				"\nIssue----> "+STORM_CHASERS+" submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getStormChasersDescription(), STORM_CHASERS_DESCRIPTION,
				"\n Issue "+STORM_CHASERS+" description not correct\n");
		softAssert.assertEquals(navigationBar.getStormChasersSubMenuPageURL(), stormChasers_URL,
				"\nIssue-----> "+STORM_CHASERS+" Page URL not matching");
		
		navigationBar.hoverOnVideo();
		softAssert.assertEquals(navigationBar.getImgSrcThumbnailUnderVideo(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under video is not matching with API Data");

		
		/****************Validate date below thumbnail***************************************/
		
		softAssert.assertTrue(navigationBar.getDurationBelowThumbnailUnderVideoAndCompareWithApiDuration(getVideoDurationFromAPI),
				"Issue-----> Duration below thumbnail under video is not matching with duration shown in API");
		
		
		/****************Validate article title*************************************************/
		
		softAssert.assertEquals(navigationBar.getArticleTitleUnderVideo(), getVideo_ArticleTitleFromAPI,
				"Issue-----> Article title under video is not matching with API Data");
		
		/******************** URL *********************************/
		
		String articleTitleUrlFromAPI = getVideo_ArticleTitleUrlFromAPI.toLowerCase();
		softAssert.assertEquals(navigationBar.getArticleTitleUrlUnderVideo(), articleTitleUrlFromAPI,
				"Issue------> Article URL not matching with the API Data");	
		
		softAssert.assertAll();

		
	}
	
	@Test(priority=5)
	public void RW_T288_SeverWeatherTabValidation()
	{
		softAssert = new SoftAssert();
		testStart("********************* Validation of Severe Weather tab and sub menu items of Severe Weather ******************************");
		
		/********************* Validate if all the sub menus under video are displayed, the texts and descriptions are as expected ********/
		
		/*************************** Severe Weather Sub Menu **********************************/
		softAssert.assertTrue(navigationBar.isSeverWeatherSubMenuDisplayed(),
				"\nIssue-----> Severe Weather submenu tab not displayed\n");
		softAssert.assertEquals(navigationBar.getSevereWeatherSubMenuText(), SEVERE_WEATHER_SUBMENU,
				"\nIssue----> Severe Weather submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getSevereWeatherSubMenuURL(), severeWeatherURL,
				"\n Severe Weather URL not as expected\n");
		
		
		/*************************** Hurricane **********************************/
		softAssert.assertTrue(navigationBar.isHurricaneSubMenuDisplayed(),
				"\nIssue-----> Hurricane submenu unders Severe Weather tab not displayed\n");
		softAssert.assertEquals(navigationBar.getHurricaneSubMenuText(), HURRICANE_SUBMENU,
				"\nIssue----> HURRICANE Sub Menu text is not correct\n");
		softAssert.assertEquals(navigationBar.getHurricaneDescription(), HURRICANE_SUBMENU_DESCRIPTION,
				"\nIssue-----> Hurricane Sub menu description not matching");
		softAssert.assertEquals(navigationBar.getHurricaneSubMenuURL(), hurricaneURL,
				"\n hurricane URL not as expected\n");
		
		/*************************** AccuWeather Ready **********************************/
		softAssert.assertTrue(navigationBar.isAWReadySubMenuDisplayed(),
				"\nIssue-----> AccuWeather Ready tab not displayed\n");
		softAssert.assertEquals(navigationBar.getAWReadyText(), ACCUWEATHER_READY_SUBMENU,
				"\nIssue----> "+ACCUWEATHER_READY_SUBMENU+" text is not correct\n");
		softAssert.assertEquals(navigationBar.getAWReadyDescription(), ACCUWEATHER_READY_SUBMENU_DESCRIPTION,
				"\n Issue----->"+ ACCUWEATHER_READY_SUBMENU+" description not correct\n");
		softAssert.assertEquals(navigationBar.getAWReadySubMenuURL(), accuWeatherReadyURL,
				"\nIssue-----> AccuWeather Ready URL not matching");
		
		/*************************** Winter Weather **********************************/
		softAssert.assertTrue(navigationBar.isWinterWeatherSubMenuDisplayed(),
				"\nIssue-----> Winter Weather submenu tab not displayed\n");
		softAssert.assertEquals(navigationBar.getWinterWeatherSubMenuText(), WINTER_WEATHER_SUBMENU,
				"\nIssue---->"+WINTER_WEATHER_SUBMENU+" submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.getWinterWeatherDescription(), WINTER_WEATHER_SUBMENU_DESCRIPTION,
				"\n Issue "+WINTER_WEATHER_SUBMENU +" description not correct\n");
		softAssert.assertEquals(navigationBar.getWinterWeatherSubMenuURL(), winterWeatherURL,
				"\nIssue-----> "+WINTER_WEATHER_SUBMENU+" Page URL not matching");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=6)
	public void RW_T289_MoreTabValidation()
	{
		softAssert = new SoftAssert();
		testStart("********************* Validation of More tab and sub menu items under More ******************************");
		
		/********************* Validate if all the sub menus under video are displayed, the texts and descriptions are as expected ********/
		
		/*************************** About AccuWeather **********************************/
		softAssert.assertTrue(navigationBar.isAWAboutSubMenuDisplayed(),
				"\nIssue-----> About AccuWeather submenu tab not displayed\n");
		softAssert.assertEquals(navigationBar.getAWAboutText(), ABOUT_ACCUWEATHER,
				"\nIssue----> About AccuWeather submenu text is not correct\n");
		softAssert.assertEquals(navigationBar.isAWAboutDescriptionDisplayed(),
				"\nIssue-----> About Accuweather Submenu description not found\n");
		softAssert.assertEquals(navigationBar.getAWAboutDescription(), ABOUT_ACCUWEATHER_DESCRIPTION,
				"\nIssue-----> About Accuweather description not matching");
		
		
		/*************************** AccuWeather Premium **********************************/
		softAssert.assertTrue(navigationBar.isAWPremiumSubMenuDisplayed(),
				"\nIssue-----> AW Premium submenu not displayed\n");
		softAssert.assertEquals(navigationBar.getAWPremiumText(), ACCUWEATHER_PREMIUM,
				"\nIssue----> "+ACCUWEATHER_PREMIUM+" text is not correct\n");
		softAssert.assertEquals(navigationBar.isAWProfessionalDescriptionDisplayed(),
				"\nIssue-----> "+ ACCUWEATHER_PREMIUM+" description not found");
		softAssert.assertEquals(navigationBar.getAWPremiumDescription(), ACCUWEATHER_PREMIUM_DESCRIPTION,
				"\nIssue-----> "+ACCUWEATHER_PREMIUM+" description not matching");
		
		/*************************** Apps & Downloads **********************************/
		softAssert.assertTrue(navigationBar.isAppsAndDownloadSubMenuDisplayed(),
				"\nIssue-----> "+APPS_AND_DOWNLOADS+" submenu not displayed\n");
		softAssert.assertEquals(navigationBar.isAppAndDwnldTextDisplayed(), APPS_AND_DOWNLOADS,
				"\nIssue----> "+ACCUWEATHER_PREMIUM+" is not correct\n");
		softAssert.assertEquals(navigationBar.getAppAndDownloadDescription(), APPS_AND_DOWNLOADS_DESCRIPTION,
				"\n "+APPS_AND_DOWNLOADS+" description not correct\n");
		softAssert.assertEquals(navigationBar.getTrendingNowSubMenuPageURL(), trendingNow_URL,
				"\nIssue-----> Trending Now Page URL not matching");
		
		/*************************** AccuWeather Professional **********************************/
		softAssert.assertTrue(navigationBar.isAWProfessionalSubMenuDisplayed(),
				"\nIssue-----> "+ACCUWEATHER_PROFESSIONAL+" submenu unders More tab not displayed\n");
		
		softAssert.assertEquals(navigationBar.getAWProfessionalText(), ACCUWEATHER_PROFESSIONAL,
				"\nIssue---->"+ACCUWEATHER_PROFESSIONAL+" submenu text is not correct\n");
		
		softAssert.assertEquals(navigationBar.getAWProfessionalDescription(), ACCUWEATHER_PROFESSIONAL_DESCRIPTION,
				"\n Issue "+ACCUWEATHER_PROFESSIONAL +" description not correct\n");
		
		softAssert.assertEquals(navigationBar.getExpertForecastSubMenuPageURL(), expertForecasts_URL,
				"\nIssue-----> "+ACCUWEATHER_PROFESSIONAL+" Page URL not matching");
		
		
		/*************************** Podcast **********************************/
		softAssert.assertTrue(navigationBar.isPodcastSubMenuDisplayed(),
				"\nIssue-----> "+PODCAST+" submenu not displayed\n");
		softAssert.assertEquals(navigationBar.getPodcastDescription(), PODCAST_DESCRIPTION,
				"\nIssue----> "+PODCAST+" description is not correct\n");
		softAssert.assertEquals(navigationBar.getStormChasersSubMenuPageURL(), stormChasers_URL,
				"\nIssue-----> "+PODCAST+" Page URL not matching");
		
		softAssert.assertEquals(navigationBar.getImgSrcThumbnailUnderVideo(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under video is not matching with API Data");


		
	}

}
