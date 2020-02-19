package com.accuweather.glacier.www.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.Constants;
import com.chameleon.utils.Sleeper;

public class NavigationBar extends BasePage
{
	private By byAccuWeatherLogo 			= By.cssSelector("div.main-menu > div > div > a > img");
	private By byMegaMenu 					= By.cssSelector("div.main-menu-content");

	/*********************************
	 * Universal Navigation Menu Items
	 ***************************************/
	private By byRadarMaps				 	= By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	private By byNews 						= By.cssSelector("div.main-menu > ul > li:nth-child(2)");
	private By byVideo 						= By.cssSelector("div.main-menu > ul > li:nth-child(3)");
	private By bySevereWeather 				= By.cssSelector("div.main-menu > ul > li:nth-child(4)");
	private By byMore 						= By.cssSelector("div.main-menu > ul > li:nth-child(5)");

	/**
	 *	***************************** SETTINGS *************************************
	 */
	private By bySettingIcon 				= By.cssSelector("div.settings-button > svg.icon-settings");
	private By bySettingCountry 			= By.cssSelector("div.settings-wrap > div.dropdown-select.fade-in-left > div.dropdown-select-wrapper > div.select-title");
	private By bySettingLanguage 			= By.cssSelector("div.settings-wrap > div.fade-in-left:nth-of-type(2) > div > div");
	private By bySettingTemperature 		= By.cssSelector("div.settings-wrap > div.temp-switcher.fade-in-left > span.temp-switcher-label");
	private By bySettingCountryUpArrow 		= By.cssSelector("div > div:nth-child(1) > div.dropdown-select-wrapper > svg.hide-mobile.icon-chevron");
	private By bySettingMyRecentCountries 	= By.cssSelector("div > div.dropdown-select.fade-in-left > div.dropdown-content > div.dropdown-content-title");
	private By bySettingMoreCountries 		= By.cssSelector("div > div > div.dropdown-content > a.button-primary");
	private By bySettingCountryName 		= By.cssSelector("div > div > div.dropdown-content > a.dropdown-content-item");
	private By bySettingLanguageArrow 		= By.cssSelector("div > div.fade-in-left:nth-of-type(2) > div > svg.hide-mobile.icon-chevron");
	private By bySettingLangugaeList 		= By.cssSelector("div > div > div.dropdown-content");
	private By bySettingLanguageSelect 		= By.cssSelector("div > div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-content > div.dropdown-content-item:nth-child(3)");
	private By bySettingCentigradeLabel 	= By.cssSelector("div.settings-wrap > div.temp-switcher.fade-in-left > div.switcher-container.switch-right");
	private By bySettingTempBall 			= By.cssSelector("div > div.temp-switcher.fade-in-left > div.switcher-container > div.switcher > div.ball");
	private By bySettingTempBar 			= By.cssSelector("div > div.temp-switcher.fade-in-left > div.switcher-container > div.switcher > div.bar");
	private By bySettingUnitsDropdown       = By.cssSelector("div.utility-bar > div > div > div.dropdown-select.select-units.fade-in-left.select-units > div.dropdown-select-wrapper");
    private By bySettingTempCelciusLabel    = By.cssSelector(" div.utility-bar > div > div > div.dropdown-select.select-units.fade-in-left.select-units > div.dropdown-content > div:nth-child(3)");
    
	/**
	 * *********************** SEARCH BAR **********************************
	 * */
	private By bySearchBar					= By.cssSelector("div.search-wrapper.is-wide");
	private By bySearchIcon					= By.cssSelector("div.search-wrapper.is-wide > svg.icon-search");
	private By bySearchInput				= By.cssSelector("div.search-wrapper.is-wide > div.search-input");
	
	
	private By byStartSearch 				= By.className("search-input");
	private By byCityNameOnCityPage 		= By.cssSelector("#sub-header-recent-location > a.recent-location-display > span.recent-location-display-label.location-label");
	private By byTopSearch 					= By.xpath("//div[contains(@class,'header-right-container')]/div/div");
	private By byTopSearchClose 			= By.cssSelector("div.utility-bar-wrapper > svg.icon-close");
	private By bySuperSearch 				= By.cssSelector("div.super-search-wrap > form.super-search-form > input");
	private By byBrowseLocation 			= By.cssSelector("div.mega-menu-search > div.content-column > a.super-search-browse");
	private By byTopNavCTA 					= By.cssSelector("div.mega-menu-search > div.content-column > div.super-search-current-location");
	private By byTopNavNYCityImage 			= By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(1) > img");
	private By byTopNavChicagoCityImage 	= By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(2) > img");
	private By byTopNavDCCityImage 			= By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(3) > img");
	private By byTopNavHoustonCityImage 	= By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(4) > img");
	private By byFirstCityName 				= By.cssSelector("div > div > a.recent-location-item-header.recent-location-link.fade-in-left > span.recent-location-name");
	private By byTopNavCityList 			= By.cssSelector("div.mega-menu-search > div.content-column > a.recent-location-link");
	private By bySuperSearchCityName 		= By.xpath("//body[contains(@id,'home')]/nav/div[5]/div/div[1]/ul/li/a");

	/**************************************
	 * Radar & Maps Sub Menus Items
	 ********************************************************/
	private By byRadarAndMapsSubMenu 		= By.cssSelector("div.mega-menu-content-cta > div > a > h4");
	private By byRadarSubMenu 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > a > h4");
	private By bySatelliteMapsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > a > h4");
	private By byCurrentConditionsSubMenu 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > a > h4");
	private By bySevereSubMenu 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > a > h4");
	private By byForecastMapsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(5) > a > h4");

	/*************************************
	 * Description of Radar & Maps Sub Menu
	 ******************************************/
	private By byRadarMapsSubMenuDescription 			= By.cssSelector("div.mega-menu-content-cta > div > p");
	private By byRadarSubMenuDescription 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > p");
	private By bySatelliteSubMenuDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > p");
	private By byCurrentConditionsSubMenuDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > p");
	private By bySevereSubMenuDescription 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > p");
	private By byForecastSubMenuDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(5) > p");
	private By bySatelliteSubMenuMapTitle 				= By.cssSelector("div.mega-menu-content-media > a > figure > p");
	private By bySatelliteSubMenuMapDescription 		= By.cssSelector("div.mega-menu-content-media > a > figure > figcaption");
	private By bySatelliteImageSubMenu 					= By.cssSelector("div.mega-menu-content-media > a > figure > img");

	/************************************
	 * News Sub Menus Items
	 ************************************************************/
	private By byNewsSubMenu 				= By.cssSelector("div.mega-menu-content-cta > div > a > h4");
	private By byWatchNewsSubMenu 			= By.cssSelector("div.mega-menu-content-cta > a.button-cta");
	private By byWeatherNewsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > a");
	private By byWeatherBlogsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > a");
	private By byPersonalitiesSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > a");
	private By byClimateChangeSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > a");
	private By byThumbnailUnderNews 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > img");
	private By byDateUnderNewsCategory 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > p");
	private By byTitleUnderNews 			= By.cssSelector("div.mega-menu-content-media > div > a > figure > figcaption");

	/***********************************
	 * News Sub Menus Descriptions
	 *****************************************************/
	private By byNewsDescription 			= By.cssSelector("div.mega-menu-content-cta > div > p");
	private By byWeatherNewsDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > p");
	private By byWeatherBlogsDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > p");
	private By byPersonalitiesDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > p");
	private By byClimateChangeDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > p");

	/**********************************
	 * Video Sub Menus Items
	 ************************************************************/
	private By byVideoSubMenu 				= By.cssSelector("div.mega-menu-content-cta > div > a > h4");
	private By byWatchVideoButton 			= By.cssSelector("div.mega-menu-content-cta > a.button-cta");
	private By byTrendingNow 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > a > h4");
	private By byStormChasers 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > a > h4");
	private By byExpertForecasts 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > a > h4");

	/*********************************
	 * Video Sub Menus Descriptions
	 ****************************************************/
	private By byVideoDescription 			= By.cssSelector("div.mega-menu-content-cta > div > p");
	private By byTrendingNowDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > p");
	private By byStormChasersDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > p");
	private By byExpertForecastDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > p");
	private By byThumbnailUnderVideo 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > img");
	private By byDurationUnderVideo 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > p");
	private By byArticleTitleUnderVideo 	= By.cssSelector("div.mega-menu-content-media > div > a > figure > figcaption");

	/**********************************
	 * Severe Weather Sub Menus Items
	 ****************************************/
	private By bySeverWeatherSubMenu 		= By.cssSelector("div.mega-menu-content-cta > div > a > h4");
	private By byHurricaneSubMenu 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > a > h4");
	private By byWinterWeatherSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > a > h4");
	private By byAWReadySubMenu 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > a > h4");

	/**********************************
	 * Severe Weather Sub Menus Descriptions
	 ********************************/
	private By byHurricaneDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > p");
	private By byWinterWeatherDescription 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > p");
	private By byAWReadyDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > p");
	private By byThumbnailUnderSevereWeather 	= By.cssSelector("div.mega-menu-content-media > div > a > figure > img");
	private By byDateUnderSevereWeather 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > p");
	private By byArticleTitleUnderSevereWeather = By.cssSelector("div.mega-menu-content-media > div > a > figure > figcaption");

	/*********************************
	 * More Sub Menus Items
	 ************************************************/
	private By byAboutAccuWeather = By.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(1) > a > h4");
	private By byAppsAndDownload = By.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(2) > a > h4");
	private By byPodcast = By.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(3) > a > h4");
	private By byAccuWeatherPremium = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(4) > a > h4");
	private By byAccuWeatherProfessional = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(5) > a > h4");

	private By byFacebookIcon = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(1) > img");
	private By byFaceBookText = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(1) > h4");

	private By byTwitterIcon = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(2) > img");
	private By byTwitterText = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(2) > h4");

	private By byInstagramIcon = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(3) > img");
	private By byInstagramText = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(3) > h4");

	private By byYoutubeIcon = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(4) > img");
	private By byYoutubeText = By
			.cssSelector("div.mega-menu-content > div.header-social.fade-in-left > a:nth-child(4) > h4");

	/********************************
	 * More Sub Menus Items Description
	 ****************************************/
	private By byAboutAccuWeatherDescription = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(1) > p");
	private By byAppsAndDownloadDescription = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(2) > p");
	private By byPodcastDescription = By.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(3) > p");
	private By byAccuWeatherPremiumDescription = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(4) > p");
	private By byAccuWeatherProfessionalDescription = By
			.cssSelector("div.mega-menu-content-links.three-col > div:nth-child(5) > p");

	// secondary tabs
	private By byRadarTabSecondaryNavigation = By
			.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(2)");

	// under radar & maps category
	public static String strMapTitle;
	public static String strSatelliteMapDescription;
	public static String strMapUrl;
	public static String strMapTitleUrl;
	public static String strMapDescriptionUrl;

	/****************************
	 * News Items
	 ***************************************************/
	public static String strMapDescriptionUnderNews;
	public static String strDateUnderNews;
	
	
	/**
	 * @author HFARAZ
	 * Method to check if Accuweather logo is displayed
	 * */
	public Boolean isAccuWeatherLogoDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byAccuWeatherLogo).syncVisible(15, false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the image source of AccuWeather logo
	 * */
	public String getImageSourceOfAccuWeatherLogo()
	{
		return getDriver().findElement(byAccuWeatherLogo).getAttribute("src");
	}
	
	/**
	 * @author HFARAZ
	 * Method to click AccuWeather logo
	 * */
	public void clickAccuWeatherLogo()
	{
		WebPageLoaded.isDomComplete();
		if(isAccuWeatherLogoDisplayed())
			getDriver().findElement(byAccuWeatherLogo).jsClick();
	}

	

	public void locationSearch(String info)
	{
		WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
		txtSuperSearch.syncVisible();
		txtSuperSearch.set(info);
		txtSuperSearch.sendKeys(Keys.RETURN);
	}

	public boolean isSettingCountryDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox settingcountry = getDriver().findTextbox(bySettingCountry);
		settingcountry.syncVisible(15);
		return settingcountry.isDisplayed();
	}

	public boolean isSettingLanguageDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox settinglang = getDriver().findTextbox(bySettingLanguage);
		settinglang.syncVisible(15);
		return settinglang.isDisplayed();
	}

	public boolean isSettingTemperatureDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox settingtemp = getDriver().findTextbox(bySettingTemperature);
		settingtemp.syncVisible(15);
		return settingtemp.isDisplayed();
	}

	public boolean isStartSearchDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox txtSearch = getDriver().findTextbox(byTopSearch);
		return txtSearch.syncVisible(15);
	}

	public void clickSettingsIcon()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox settingicon = getDriver().findTextbox(bySettingIcon);
		settingicon.syncVisible(15);
		settingicon.click();
		Sleeper.sleep(5);
	}

	public void clickTopNavStartSearchIcon()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox startsearch = getDriver().findTextbox(byTopSearch);
		startsearch.syncVisible(15);
		startsearch.click();
		Sleeper.sleep(5);
	}

	public void clickBrowseYourLocationLink()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findTextbox(byBrowseLocation).syncVisible();
		WebTextbox browselocation = getDriver().findTextbox(byBrowseLocation);
		browselocation.syncVisible(15);
		browselocation.click();
		Sleeper.sleep(3);
	}

	public boolean isMegaMenuContentDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebElement megamenucontent = getDriver().findElement(byMegaMenu);
		megamenucontent.syncVisible(15);
		return megamenucontent.isDisplayed();
	}

	public boolean isTopNavSearchCloseIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox closesearch = getDriver().findTextbox(byTopSearchClose);
		closesearch.syncVisible(15);
		return closesearch.isDisplayed();
	}

	public boolean isTopNavCTATextDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavctatext = getDriver().findTextbox(byTopNavCTA);
		topnavctatext.syncVisible(15);
		return topnavctatext.isDisplayed();
	}

	public boolean isTopNavNYCityImageDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavNYCityImage);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}

	public boolean isTopNavChicagoCityImageDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavChicagoCityImage);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}

	public boolean isTopNavDCCityImageDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavDCCityImage);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}

	public boolean isTopNavHoustonCityImageDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavHoustonCityImage);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}

	public boolean isTopNavFirstCityDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavCityList);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}

	public boolean isRecentCityNameDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox recentcityname = getDriver().findTextbox(byFirstCityName);
		recentcityname.syncVisible(15);
		return recentcityname.isDisplayed();
	}

	public void clickTopNavSearchCloseIcon()
	{
		WebPageLoaded.isDomComplete();
		WebTextbox closesearch = getDriver().findTextbox(byTopSearchClose);
		closesearch.syncVisible(15);
		closesearch.click();
	}

	public void clickStartSearch()
	{
		WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
		txtSearch.syncVisible(15);
		txtSearch.click();
	}

	public void clickTopNavCTALink()
	{
		WebTextbox ctalink = getDriver().findTextbox(byTopNavCTA);
		ctalink.syncEnabled();
		ctalink.click();
	}

	public boolean validateNavigation(String url)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Constants.PAGE_TIMEOUT);
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public String clickAndGetlocationCityName(String info)
	{
		WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
		txtSearch.syncEnabled();
		txtSearch.click();
		WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
		txtSuperSearch.syncVisible();
		txtSuperSearch.set(info);
		txtSuperSearch.sendKeys();
		String CityName = getCityNameText(info);
		navigateToForeCastPage();
		return CityName;
	}

/***************************************************** START OF RADAR & MAPS CATEGORY ***************************************************************/	
	/**
	 * @author HFARAZ
	 * Method to validate if Radar & Maps tab is displayed in Universal Navigation Menu
	 */
	public Boolean isRadarAndMapsTabDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRadarMaps).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar & Maps tab
	 * */
	public String getRadarAndMapsText()
	{
		String radarAndMapsText=null;
		if(isRadarAndMapsTabDisplayed())
		{
			radarAndMapsText = getDriver().findElement(byRadarMaps).getText();
		}
		return radarAndMapsText;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to hover on Radar and maps tab
	 * */
	public void hoverOnRadarAndMaps()
	{
		WebPageLoaded.isDomComplete();
		if(isRadarAndMapsTabDisplayed())
		{
			getDriver().findElement(byRadarMaps).hover();
		}
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Radar & Maps sub menu is displayed
	 * */
	public Boolean isRadarAndMapsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(byRadarAndMapsSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar and maps sub menu
	 * */
	public String getRadarAndMapsSubMenuText()
	{
		String radarAndMapsDescription=null;
		if(isRadarAndMapsSubMenuDisplayed())
		{
			radarAndMapsDescription = getDriver().findElement(byRadarAndMapsSubMenu).getText();
		}
		return radarAndMapsDescription;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Radar & Maps sub menu is displayed
	 * */
	public Boolean isRadarSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(byRadarSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar and maps sub menu
	 * */
	public String getRadarSubMenuText()
	{
		String radarSubMenuText=null;
		if(isRadarSubMenuDisplayed())
		{
			radarSubMenuText = getDriver().findElement(byRadarSubMenu).getText();
		}
		return radarSubMenuText;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Current conditons sub menu is displayed
	 * */
	public Boolean isCurrentConditionsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(byCurrentConditionsSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of current conditions sub menu
	 * */
	public String getCurrentConditionsSubMenuText()
	{
		String currentConditionsDescription=null;
		if(isCurrentConditionsSubMenuDisplayed())
		{
			currentConditionsDescription = getDriver().findElement(byCurrentConditionsSubMenu).getText();
		}
		return currentConditionsDescription;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Forecast sub menu is displayed
	 * */
	public Boolean isForecastSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(byForecastMapsSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar and maps sub menu
	 * */
	public String getForecastSubMenuText()
	{
		String forecastDescription=null;
		if(isRadarAndMapsSubMenuDisplayed())
		{
			forecastDescription = getDriver().findElement(byForecastMapsSubMenu).getText();
		}
		return forecastDescription;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Radar & Maps sub menu is displayed
	 * */
	public Boolean isSatelliteSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(bySatelliteMapsSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar and maps sub menu
	 * */
	public String getSatelliteSubMenuText()
	{
		String satellite=null;
		if(isRadarAndMapsSubMenuDisplayed())
		{
			satellite = getDriver().findElement(bySatelliteMapsSubMenu).getText();
		}
		return satellite;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Radar & Maps sub menu is displayed
	 * */
	public Boolean isSeverSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnRadarAndMaps();
		return getDriver().findElement(bySevereSubMenu).syncVisible(15,false);	
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Radar and maps sub menu
	 * */
	public String getSevereSubMenuText()
	{
		String severeSubMenuText=null;
		if(isSeverSubMenuDisplayed())
		{
			severeSubMenuText = getDriver().findElement(bySevereSubMenu).getText();
		}
		return severeSubMenuText;		
	}
	
	/**
	 * Method to get the description of RadarMaps submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps submenu contains description on city
	 *         forecast page"
	 */
	public String getRadarAndMapsSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement submenuMapsDescription = getDriver().findElement(byRadarMapsSubMenuDescription);
		submenuMapsDescription.syncVisible(30);
		return submenuMapsDescription.getText();
	}

	/**
	 * Method to get the description of Radar submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Radar submenu contains description on city
	 *         forecast page"
	 */
	public String getRadarSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement submenuRadarDescription = getDriver().findElement(byRadarSubMenuDescription);
		submenuRadarDescription.syncVisible(30);
		return submenuRadarDescription.getText();
	}

	/**
	 * Method to get the description of Current conditions submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Radar submenu contains description on city
	 *         forecast page"
	 */
	public String getCurrentConditionsSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement currentConditionsSubMenuDescription = getDriver().findElement(byCurrentConditionsSubMenuDescription);
		currentConditionsSubMenuDescription.syncVisible(30);
		return currentConditionsSubMenuDescription.getText();
	}

	/**
	 * Method to get the description of Severe submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Severe submenu contains description
	 *         present on city forecast page"
	 */
	public String getSevereSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement submenuSevereDescription = getDriver().findElement(bySevereSubMenuDescription);
		submenuSevereDescription.syncVisible(30);
		return submenuSevereDescription.getText();
	}

	/**
	 * Method to get the description of Satellite submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains description
	 *         present on city forecast page"
	 */
	public String getSatelliteSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement submenuSatelliteDescription = getDriver().findElement(bySatelliteSubMenuDescription);
		submenuSatelliteDescription.syncVisible(30);
		return submenuSatelliteDescription.getText();
	}

	/**
	 * Method to get the description of Forecast submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Forecast submenu contains description
	 *         present on city forecast page"
	 */
	public String getForecastSubmenuDescription()
	{
		WebPageLoaded.isDomComplete();
		WebElement submenuForecastDescription = getDriver().findElement(byForecastSubMenuDescription);
		submenuForecastDescription.syncVisible(30);
		return submenuForecastDescription.getText();
	}
	
	/**
	 * Method to verify satellite image is present, title of map and get the text of
	 * Satellite submenu description of the map.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if satellite image "
	 */
	public void verifySatelliteImageTitleDescription()
	{
		WebPageLoaded.isDomComplete();
		this.hoverOnRadarAndMaps();
		WebElement satelliteImage = getDriver().findElement(bySatelliteImageSubMenu);
		satelliteImage.click();
		strMapUrl = getDriver().getCurrentUrl();

		// get title of map
		getDriver().navigate().back();
		this.hoverOnRadarAndMaps();
		WebElement titleOfMap = getDriver().findElement(bySatelliteSubMenuMapTitle);
		titleOfMap.syncVisible(15);
		strMapTitle = titleOfMap.getText();
		titleOfMap.click();
		strMapTitleUrl = getDriver().getCurrentUrl();

		// get text of satellite image description
		getDriver().navigate().back();
		this.hoverOnRadarAndMaps();
		WebElement submenuSatelliteMapDescription = getDriver().findElement(bySatelliteSubMenuMapDescription);
		submenuSatelliteMapDescription.syncVisible(15);
		strSatelliteMapDescription = submenuSatelliteMapDescription.getText();
		submenuSatelliteMapDescription.click();
		strMapDescriptionUrl = getDriver().getCurrentUrl();

	}
	
	// click radar and maps submenu under radar & maps
		public void navigateToRadarAndMapsSubMenu()
		{
			getDriver().findElement(byRadarAndMapsSubMenu).jsClick();
			WebPageLoaded.isDomComplete();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Radar And Maps page
		 * */
		public String getRadarAndMapPageURL()
		{
			navigateToRadarAndMapsSubMenu();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}

		/**
		 * @author HFARAZ
		 * Method to navigate and click Radar
		 * **/
		public void navigateToRadar()
		{
			getDriver().findElement(byRadarSubMenu).click();
			WebPageLoaded.isDomComplete();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Radar And Maps page
		 * */
		public String getRadarPageURL()
		{
			navigateToRadar();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}

		/**
		 * @author HFARAZ
		 * Method to navigate current conditions under Radar & Maps and click
		 * */
		public void navigateToCurrentConditions()
		{
			getDriver().findElement(byCurrentConditionsSubMenu).click();
			WebPageLoaded.isDomComplete();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Current conditions page
		 * */
		public String getCurrentConditionsPageURL()
		{
			navigateToCurrentConditions();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}

		public void navigateToSeverWeatherPage()
		{
			getDriver().findElement(bySevereSubMenu).click();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Severe weather page
		 * */
		public String getSevereWeatherPageURL()
		{
			navigateToSeverWeatherPage();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}

		public void navigateToSatellitePage()
		{
			getDriver().findElement(bySatelliteMapsSubMenu).jsClick();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Satellite page
		 * */
		public String getSatellitePageURL()
		{
			navigateToSatellitePage();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}

		public void navigateToForeCastPage()
		{
			getDriver().findElement(byForecastMapsSubMenu).jsClick();
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the URL of Current conditions page
		 * */
		public String getForecastPageURL()
		{
			navigateToForeCastPage();
			WebPageLoaded.isDomComplete();
			return getDriver().getCurrentUrl();
		}
	
/**************************************************** END OF RADAR & MAPS CATEGORY *****************************************************************/	


/******************************************** START OF NEWS CATEGORY ***********************************************************************************/

	/**
	 * @author HFARAZ
	 * Method to validate if News tab is displayed in Universal Navigation Menu
	 * */
	public Boolean isNewsTabDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byNews).syncVisible(15,false);			
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of News tab
	 * */
	public String getNewsText()
	{
		String newsTab=null;
		if(isNewsTabDisplayed())
		{
			newsTab = getDriver().findElement(byNews).getText();
		}
		return newsTab;		
	}
	
	public void hoverOnNews()
	{
		if(isNewsTabDisplayed())
			getDriver().findElement(byNews).hover();
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if News Sub Menu is displayed
	 * */
	public Boolean isNewsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byNewsSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of News Sub menu tab
	 * */
	public String getNewsSubMenuText()
	{
		String newsSubMenu=null;
		if(isNewsSubMenuDisplayed())
		{
			newsSubMenu = getDriver().findElement(byNewsSubMenu).getText();
		}
		return newsSubMenu;			
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if News Sub Menu description is displayed
	 * */
	public Boolean isNewsSubMenuDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byNewsDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the description of news sub menu
	 * */
	public String getNewsSubMenuDescription()
	{
		String newsSubMenuDescription=null;
		if(isNewsSubMenuDescriptionDisplayed())
		{
			newsSubMenuDescription = getDriver().findElement(byNewsDescription).getText();
		}
		return newsSubMenuDescription;			
	}

	/**
	 * @author HFARAZ
	 * Method to validate if News Sub Menu is displayed
	 * */
	public Boolean isWatchNewsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byWatchNewsSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Watch News Sub menu tab
	 * */
	public String getWatchNewsText()
	{
		String watchNewsSubMenu=null;
		if(isWatchNewsSubMenuDisplayed())
		{
			watchNewsSubMenu = getDriver().findElement(byWatchNewsSubMenu).getText();
		}
		return watchNewsSubMenu;	
			
	}

	/**
	 * @author HFARAZ
	 * Method to validate if Weather News sub menu is displayed
	 * */
	public Boolean isWeatherNewsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byWeatherNewsSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of weather News Submenu tab
	 * */
	public String getWeatherNewsText()
	{
		String weatherNewsSubMenu=null;
		if(isWeatherNewsSubMenuDisplayed())
		{
			weatherNewsSubMenu = getDriver().findElement(byWeatherNewsSubMenu).getText();
		}
		return weatherNewsSubMenu;	
			
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if Weather News description is displayed
	 * */
	public Boolean isWeatherNewsDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byWeatherNewsDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of weather News description
	 * */
	public String getWeatherNewsDescription()
	{
		String weatherNewsDescription=null;
		if(isWeatherNewsDescriptionDisplayed())
		{
			weatherNewsDescription = getDriver().findElement(byWeatherNewsDescription).getText();
		}
		return weatherNewsDescription;	
			
	}

	/**
	 * @author HFARAZ
	 * Method to validate if Personalities submenu is displayed under News tab
	 * */
	public boolean isPersonalitiesSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byPersonalitiesSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of weather News Submenu tab
	 * */
	public String getPersonalitiesText()
	{
		String personalitiesSubMenu=null;
		if(isPersonalitiesSubMenuDisplayed())
		{
			personalitiesSubMenu = getDriver().findElement(byPersonalitiesSubMenu).getText();
		}
		return personalitiesSubMenu;	
			
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if Personalities description is displayed
	 * */
	public Boolean isPersonalitiesDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byPersonalitiesDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the Personalities description
	 * */
	public String getPersonalitiesDescription()
	{
		String personalitiesDescription=null;
		if(isPersonalitiesDescriptionDisplayed())
		{
			personalitiesDescription = getDriver().findElement(byPersonalitiesDescription).getText();
		}
		return personalitiesDescription;	
			
	}

	/**
	 * @author HFARAZ
	 * Method to check if Weather blogs is displayed under News tab
	 * */
	public boolean isWeatherBlogsSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byWeatherBlogsSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of weather News sub menu tab
	 * */
	public String getWeatherBlogsText()
	{
		String weatherBlogsText=null;
		if(isWeatherBlogsSubMenuDisplayed())
		{
			weatherBlogsText = getDriver().findElement(byWeatherBlogsSubMenu).getText();
		}
		return weatherBlogsText;			
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if Weather blogs description is displayed
	 * */
	public Boolean isWeatherBlogsDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byWeatherBlogsDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the Weather blogs description
	 * */
	public String getWeatherBlogsDescription()
	{
		String weatherBlogsDescription=null;
		if(isWeatherBlogsDescriptionDisplayed())
		{
			weatherBlogsDescription = getDriver().findElement(byWeatherBlogsDescription).getText();
		}
		return weatherBlogsDescription;	
			
	}

	/**
	 * @author HFARAZ
	 * Method to check if Climate change is displayed under News tab
	 * */
	public boolean isClimateChangeSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byClimateChangeSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of climate change sub menu tab
	 * */
	public String getClimateChangeText()
	{
		String climateChangeText=null;
		if(isClimateChangeSubMenuDisplayed())
		{
			climateChangeText = getDriver().findElement(byClimateChangeSubMenu).getText();
		}
		return climateChangeText;	
			
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if Climate change description is displayed
	 * */
	public Boolean isClimateChangeDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnNews();
		return getDriver().findElement(byClimateChangeDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the climate change description
	 * */
	public String getClimateChangeDescription()
	{
		String climateChangeDescription=null;
		if(isClimateChangeDescriptionDisplayed())
		{
			climateChangeDescription = getDriver().findElement(byClimateChangeDescription).getText();
		}
		return climateChangeDescription;	
			
	}
	
	/**
	 * @author HFARAZ
	 * Method to navigate to News sub menu
	 * */
	public void navigateToNewsSubMenu()
	{
		if(isNewsSubMenuDisplayed())
			getDriver().findElement(byNewsSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}

	/**
	 * @author HFARAZ
	 * Method to navigate to Weather news sub menu
	 * */
	public void navigateToWeatherNewsPage()
	{
		if(isWeatherNewsSubMenuDisplayed())
			getDriver().findElement(byWeatherNewsSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}

	/**
	 * @author HFARAZ
	 * Method to navigate to Videos
	 * */
	public void navigateToNewsVideosPage()
	{
		if(isWatchNewsSubMenuDisplayed())
			getDriver().findElement(byWatchNewsSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}

	/**
	 * @author HFARAZ
	 * Method to navigate to Personalities
	 * */
	public void navigateToPersonalitiesPage()
	{
		if(isPersonalitiesSubMenuDisplayed())
			getDriver().findElement(byPersonalitiesSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}

	/**
	 * @author HFARAZ
	 * Method to navigate to Weather Blogs
	 * */
	public void navigateToWeatherBlogPage()
	{
		if(isWeatherBlogsSubMenuDisplayed())
			getDriver().findElement(byWeatherBlogsSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}

	/**
	 * @author HFARAZ
	 * Method to navigate to Climate change
	 * */
	public void navigateToClimateChangePage()
	{
		if(isClimateChangeSubMenuDisplayed())
			getDriver().findElement(byClimateChangeSubMenu).click();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of News page
	 * */
	public String getNewsPageURL()
	{
		navigateToNewsSubMenu();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Watch News page
	 * */
	public String getWatchNewsPageURL()
	{
		navigateToNewsVideosPage();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Weather News page
	 * */
	public String getWeatherNewsPageURL()
	{
		navigateToWeatherNewsPage();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Personalities page
	 * */
	public String getPersonalitiesPageURL()
	{
		String url = "";
		navigateToPersonalitiesPage();
		WebPageLoaded.isDomComplete();
		url = getDriver().getCurrentUrl();
		getDriver().navigate().back();
		return url;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Weather Blogs page
	 * */
	public String getWeatherBlogsURL()
	{
		navigateToWeatherBlogPage();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Climate change page
	 * */
	public String getClimateChangePageURL()
	{
		navigateToClimateChangePage();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author SOWMIYA
	 *         Method get the img data src of thumbnail under News category
	 * @return data-src value
	 */
	public String getImgSrcThumbnailUnderNews()
	{
		this.hoverOnNews();
		WebElement thumbnailUnderNews = getDriver().findElement(byThumbnailUnderNews);
		thumbnailUnderNews.syncVisible(15);
		return thumbnailUnderNews.getAttribute("data-src");
	}

	/**
	 * @author SOWMIYA
	 *         Method to get the date below thumbnail under News category
	 * @return date
	 */
	public String getDateBelowThumbnailUnderNews()
	{
		// get date under news
		WebElement strDateUnderNews = getDriver().findElement(byDateUnderNewsCategory);
		strDateUnderNews.syncVisible(30);
		return strDateUnderNews.getText();
	}

	/**
	 * @author SOWMIYA
	 *         Method to get the article title under news category
	 * @return article title
	 */
	public String getArticleTitleUnderNews()
	{
		// get article title under news
		WebElement strArticleTitleUnderNews = getDriver().findElement(byTitleUnderNews);
		strArticleTitleUnderNews.syncVisible(15);
		String getArticleTitleUnderNews = strArticleTitleUnderNews.getText();
		return getArticleTitleUnderNews;
	}

	/**
	 * @author SOWMIYA
	 *         Method to click on article title under news and get URL
	 * @return article title url
	 */
	public String getArticleTitleUrlUnderNews()
	{
		String url = "";
		WebElement strArticleTitleUnderNews = getDriver().findElement(byTitleUnderNews);
		strArticleTitleUnderNews.syncVisible(15);
		strArticleTitleUnderNews.click();
		WebPageLoaded.isDomComplete();
		url = getDriver().getCurrentUrl();
		getDriver().navigate().back();
		return url;
	}
	
	/**
	 * Method to get date and description of the map under news category.
	 * 
	 * @author Sowmiya
	 */
	public void getDateAndDescriptionOfMapUnderNewsCategory()
	{
		// get title of date and year under news category
		WebElement date = getDriver().findElement(byDateUnderNewsCategory);
		date.syncVisible(15);
		strDateUnderNews = date.getText();

		// get text of map description under news category
		WebElement mapDescription = getDriver().findElement(byTitleUnderNews);
		mapDescription.syncVisible(15);
		strMapDescriptionUnderNews = mapDescription.getText();
	}
	
/********************************************************* END OF NEWS CATEGORY **************************************************************************/	
	

	
/********************************************************* START OF VIDEOS CATEGORY *********************************************************************/	
	
	/**
	 * @author HFARAZ
	 * Method to validate if the video tab is displayed
	 * */
	public Boolean isVideoTabDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byVideo).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Video tab
	 * */
	public String getVideoText()
	{
		String videoTab=null;
		if(isVideoTabDisplayed())
		{
			videoTab = getDriver().findElement(byVideo).getText();
		}
		return videoTab;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to hover on Video tab
	 * */
	public void hoverOnVideo()
	{
		if(isVideoTabDisplayed())
			getDriver().findElement(byVideo).hover();
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if the video description is displayed
	 * */
	public Boolean isVideoSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byVideoSubMenu).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Video
	 * */
	public String getVideoSubMenuText()
	{
		String videoSubMenu = null;
		if(isVideoSubMenuDisplayed())
			videoSubMenu = getDriver().findElement(byVideoSubMenu).getText();
		
		return videoSubMenu;
	}
	
	/**
	 * @author HFARAZ
	 * Method to navigate to Video submenu page
	 * */
	public void navigateToVideoSubMenu()
	{
		if(isVideoSubMenuDisplayed())
			getDriver().findElement(byVideoSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Video submenu page
	 * */
	public String getVideoSubMenuPageURL()
	{
		navigateToVideoSubMenu();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if the Watch video submenu is displayed
	 * */
	public Boolean isWatchVideoDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byWatchVideoButton).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Watch Video button
	 * */
	public String getWatchVideoText()
	{
		String watchVideo=null;
		if(isWatchVideoDisplayed())
		{
			watchVideo = getDriver().findElement(byWatchVideoButton).getText();
		}
		return watchVideo;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to navigate to Watch News page
	 * */
	public void navigateToWatchVideoTab()
	{
		if(isWatchVideoDisplayed())
			getDriver().findElement(byWatchVideoButton).jsClick();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Watch Video submenu page
	 * */
	public String getWatchVideo_SubMenu_PageURL()
	{
		navigateToWatchVideoTab();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if the video tab is displayed
	 * */
	public Boolean isTrendingNow_SubMenu_Displayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byTrendingNow).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Video tab
	 * */
	public String getTrendingNowText()
	{
		String videoTab=null;
		if(isTrendingNow_SubMenu_Displayed())
		{
			videoTab = getDriver().findElement(byTrendingNow).getText();
		}
		return videoTab;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if the video description is displayed
	 * */
	public Boolean isTrendingNow_DescriptionDisplayed()
	{
		hoverOnVideo();
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTrendingNowDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the description of News tab
	 * */
	public String getTrendingNowDescription()
	{
		String trendingNowDescription=null;
		if(isTrendingNow_DescriptionDisplayed())
		{
			trendingNowDescription = getDriver().findElement(byTrendingNowDescription).getText();
		}
		return trendingNowDescription;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to navigate to Watch News page
	 * */
	public void navigateToTrendingNow()
	{
		if(isTrendingNow_SubMenu_Displayed())
			getDriver().findElement(byTrendingNow).jsClick();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Trending Now submenu page
	 * */
	public String getTrendingNowSubMenuPageURL()
	{
		navigateToTrendingNow();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}

	public boolean isExpertForecastSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byExpertForecasts).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Video tab
	 * */
	public String getExpertForecastText()
	{
		String expertForecast=null;
		if(isTrendingNow_SubMenu_Displayed())
		{
			expertForecast = getDriver().findElement(byExpertForecasts).getText();
		}
		return expertForecast;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to validate if the video description is displayed
	 * */
	public Boolean isExpertForecast_DescriptionDisplayed()
	{
		hoverOnVideo();
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byExpertForecastDescription).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the description of News tab
	 * */
	public String getExpertForecastDescription()
	{
		String expertForecastDescription=null;
		if(isExpertForecast_DescriptionDisplayed())
		{
			expertForecastDescription = getDriver().findElement(byExpertForecastDescription).getText();
		}
		return expertForecastDescription;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to navigate to Watch News page
	 * */
	public void navigateToExpertForecast()
	{
		if(isExpertForecastSubMenuDisplayed())
			getDriver().findElement(byExpertForecasts).jsClick();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Expert Forecast submenu page
	 * */
	public String getExpertForecastSubMenuPageURL()
	{
		navigateToExpertForecast();
		WebPageLoaded.isDomComplete();
		return getDriver().getCurrentUrl();
	}

	public boolean isStormChasersSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byStormChasers).syncVisible(15,false);
	}
	
	public String getStormChasersText()
	{
		String stormChasers = null;
		if(isStormChasersSubMenuDisplayed())
			stormChasers = getDriver().findElement(byStormChasers).getText();
		
		return stormChasers;	
	}
	
	public boolean isStormChasers_SubMenu_DescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byStormChasersDescription).syncVisible(15,false);
	}
	
	public String getStormChasersDescription()
	{
		String stormChasers = null;
		if(isStormChasers_SubMenu_DescriptionDisplayed())
			stormChasers = getDriver().findElement(byStormChasersDescription).getText();
		
		return stormChasers;	
	}
	
	public void navigateToStormChasersSubMenu()
	{
		if(isStormChasersSubMenuDisplayed())
			getDriver().findElement(byStormChasers).click();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL of Storm Chasers submenu page
	 * */
	public String getStormChasersSubMenuPageURL()
	{
		String url = "";
		navigateToStormChasersSubMenu();
		WebPageLoaded.isDomComplete();
		url = getDriver().getCurrentUrl();
		getDriver().navigate().back();
		return url;
		
	}

	public boolean isVideoTumbnailDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byThumbnailUnderVideo).syncVisible(15,false);
	}

	public boolean isVideoDescriptionLinkDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnVideo();
		return getDriver().findElement(byArticleTitleUnderVideo).syncVisible(15,false);
	}

	public void clickVideoThumbNail()
	{
		if(isVideoTumbnailDisplayed())
			getDriver().findElement(byThumbnailUnderVideo).click();
	}

	public void clickVideoDescriptionLink()
	{
		if(isVideoDescriptionLinkDisplayed())
			getDriver().findElement(byArticleTitleUnderVideo).click();
	}
	
	
	/**
	 * @author SOWMIYA
	 *         Method get the img data src of thumbnail under Video category
	 * @return data-src value
	 */
	public String getImgSrcThumbnailUnderVideo()
	{
		WebElement thumbnailUnderVideo = getDriver().findElement(byThumbnailUnderVideo);
		thumbnailUnderVideo.syncVisible(15);
		return thumbnailUnderVideo.getAttribute("data-src");
	}

	/**
	 * @author SOWMIYA
	 *         Method to convert the duration from API into MM:SS format
	 *         Method to get the duration below thumbnail under Video category
	 * @return true - if both UI and API duration are same else false
	 */
	public Boolean getDurationBelowThumbnailUnderVideoAndCompareWithApiDuration(String durationFromAPI)
	{
		// convert API duration from seconds into MM:SS
		String apiSec = durationFromAPI;
		int x = Integer.parseInt(apiSec);

		int p1 = x % 60;
		int p2 = x / 60;

		String getP1Value = String.valueOf(p1);
		String getP2Value = String.valueOf(p2);

		if (getP1Value.length() == 1)
		{
			getP1Value = "0" + getP1Value;
		}

		String durationFromAPIinMtsAndSec = getP2Value + ":" + getP1Value;

		// get duration under video from UI
		WebElement strDurationUnderVideo = getDriver().findElement(byDurationUnderVideo);
		strDurationUnderVideo.syncVisible(30);
		String durationfromUI = strDurationUnderVideo.getText();

		return durationFromAPIinMtsAndSec.equalsIgnoreCase(durationfromUI);
	}

	/**
	 * @author SOWMIYA
	 *         Method to get the article title under video category
	 * @return article title
	 */
	public String getArticleTitleUnderVideo()
	{
		// get article title under video
		WebElement strArticleTitleUnderVideo = getDriver().findElement(byArticleTitleUnderVideo);
		strArticleTitleUnderVideo.syncVisible(15);
		String getArticleTitleUnderVideo = strArticleTitleUnderVideo.getText();
		return getArticleTitleUnderVideo;
	}

	/**
	 * @author SOWMIYA
	 *         Method to click on article title under video and get URL
	 * @return article url
	 */
	public String getArticleTitleUrlUnderVideo()
	{
		// click article url under video
		WebElement strArticleUrlUnderVideo = getDriver().findElement(byArticleTitleUnderVideo);
		strArticleUrlUnderVideo.syncVisible(15);
		strArticleUrlUnderVideo.click();
		WebPageLoaded.isDomComplete();
		String window = getDriver().getWindowHandle();
		switchToDifferentTab(window);
		WebPageLoaded.isDomComplete();
		String url = getDriver().getCurrentUrl();
		getDriver().navigate().back();
		return url;
	}
	
/******************************************************* END OF VIDEOS CATEGORY ************************************************************************/	

	

/******************************************************* START OF SEVERE WEATHER ***********************************************************************/
	/**
	 * @author HFARAZ
	 * Method to validate if the Severe weather tab is displayed
	 * */
	public Boolean isSevereWeatherTabDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bySevereWeather).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Video tab
	 * */
	public String getSevereWeatherText()
	{
		String severeTab=null;
		if(isSevereWeatherTabDisplayed())
		{
			severeTab = getDriver().findElement(bySevereWeather).getText();
		}
		return severeTab;		
	}
	
	public void hoverOnSevereWeather()
	{
		if(isSevereWeatherTabDisplayed())
			getDriver().findElement(bySevereWeather).hover();
	}
	
	public boolean isHurricaneSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byHurricaneSubMenu).syncVisible(15,false);
	}
	
	public String getHurricaneSubMenuText()
	{
		String hurricaneSubMenu = null;
		if(isHurricaneSubMenuDisplayed())
			hurricaneSubMenu = getDriver().findElement(byHurricaneSubMenu).getText();
		
		return hurricaneSubMenu;
	}
	
	public boolean isHurricaneDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byHurricaneDescription).syncVisible(15,false);
	}
	
	public String getHurricaneDescription()
	{
		String hurricaneDescription = null;
		if(isHurricaneSubMenuDisplayed())
			hurricaneDescription = getDriver().findElement(byHurricaneDescription).getText();
		
		return hurricaneDescription;
	}
	
	

	public boolean isAWReadySubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byAWReadySubMenu).syncVisible(15,false);
	}
	
	public String getAWReadyText()
	{
		String awReadySubMenu = null;
		if(isAWReadySubMenuDisplayed())
			awReadySubMenu = getDriver().findElement(byAWReadySubMenu).getText();
		
		return awReadySubMenu;
	}
	
	public boolean isAWReadyDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byAWReadyDescription).syncVisible(15,false);
	}
	
	public String getAWReadyDescription()
	{
		String awReadyDescription = null;
		if(isAWReadyDescriptionDisplayed())
			awReadyDescription = getDriver().findElement(byAWReadyDescription).getText();
		
		return awReadyDescription;
	}

	public boolean isWinterWeatherSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byWinterWeatherSubMenu).syncVisible(15,false);
	}
	
	public String getWinterWeatherSubMenuText()
	{
		String winterWeatherSubMenu = null;
		if(isWinterWeatherSubMenuDisplayed())
			winterWeatherSubMenu = getDriver().findElement(byWinterWeatherSubMenu).getText();
		
		return winterWeatherSubMenu;
	}
	
	public boolean isWinterWeatherDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(byWinterWeatherDescription).syncVisible(15,false);
	}
	
	public String getWinterWeatherDescription()
	{
		String winterWeatherDescription = null;
		if(isWinterWeatherDescriptionDisplayed())
			winterWeatherDescription = getDriver().findElement(byWinterWeatherDescription).getText();
		
		return winterWeatherDescription;
	}

	public boolean isSeverWeatherSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnSevereWeather();
		return getDriver().findElement(bySeverWeatherSubMenu).syncVisible(15,false);
	}
	
	public String getSevereWeatherSubMenuText()
	{
		String severeWeatherSubMenuText = null;
		if(isSeverWeatherSubMenuDisplayed())
			severeWeatherSubMenuText =  getDriver().findElement(bySeverWeatherSubMenu).getText();
		
		return severeWeatherSubMenuText;
	}

	public void navigateToAccuWeatherReady()
	{
		if(isAWReadySubMenuDisplayed())
			getDriver().findElement(byAWReadySubMenu).jsClick();
	}

	public void navigateToWinterWeather()
	{
		if(isWinterWeatherSubMenuDisplayed())
			getDriver().findElement(byWinterWeatherSubMenu).jsClick();
	}

	public void navigateToHurricane()
	{
		if(isHurricaneSubMenuDisplayed())
			getDriver().findElement(byHurricaneSubMenu).jsClick();
	}
	
	public void navigateToSevereWeatherSubMenu()
	{
		if(isSeverWeatherSubMenuDisplayed())
			getDriver().findElement(bySeverWeatherSubMenu).jsClick();
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL for Severe Weather page
	 * */
	public String getSevereWeatherSubMenuURL()
	{
		navigateToSevereWeatherSubMenu();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL for Severe Weather page
	 * */
	public String getHurricaneSubMenuURL()
	{
		navigateToHurricane();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL for Severe Weather page
	 * */
	public String getAWReadySubMenuURL()
	{
		navigateToAccuWeatherReady();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the URL for Severe Weather page
	 * */
	public String getWinterWeatherSubMenuURL()
	{
		navigateToWinterWeather();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify thumbnail below date under severe category.
	 * 
	 * @author Sowmiya
	 */
	public void verifyThumbnailBelowDateUnderSevereWeather()
	{
		WebPageLoaded.isDomComplete();
		// verify thumbnail
		this.hoverOnSevereWeather();
		WebElement thumbnailUnderSevereWeather = getDriver().findElement(byThumbnailUnderSevereWeather);
		thumbnailUnderSevereWeather.syncVisible(15);
		getDriver().navigate().back();
	}

	/**
	 * @author SOWMIYA
	 *         Method get the img data src of thumbnail under News category
	 * @return data-src value
	 */
	public String getImgSrcThumbnailUnderSevereWeather()
	{
		WebElement thumbnailUnderSevereWeather = getDriver().findElement(byThumbnailUnderSevereWeather);
		thumbnailUnderSevereWeather.syncVisible(15);
		return thumbnailUnderSevereWeather.getAttribute("data-src");
	}

	/**
	 * @author SOWMIYA
	 *         Method to get the date below thumbnail under severe weather category
	 * @return date
	 */
	public String getDateBelowThumbnailUnderSevereWeather()
	{
		// get date under severe weather
		WebElement strDateUnderSevereWeather = getDriver().findElement(byDateUnderSevereWeather);
		strDateUnderSevereWeather.syncVisible(30);
		return strDateUnderSevereWeather.getText();
	}

	/**
	 * @author SOWMIYA
	 *         Method to get the article title under severe weather category
	 * @return article title
	 */
	public String getArticleTitleUnderSevereWeather()
	{
		// get article title under severe weather
		WebElement strArticleTitleUnderSevereWeather = getDriver().findElement(byArticleTitleUnderSevereWeather);
		strArticleTitleUnderSevereWeather.syncVisible(15);
		String getArticleTitleUnderSevereWeather = strArticleTitleUnderSevereWeather.getText();
		return getArticleTitleUnderSevereWeather;
	}

	/**
	 * @author SOWMIYA
	 *         Method to click on article title under severe weather and get URL
	 * @return article title url
	 */
	public String getArticleTitleUrlUnderSevereWeather()
	{
		// click article title under severe weather
		WebElement strArticleTitleUnderSevereWeather = getDriver().findElement(byArticleTitleUnderSevereWeather);
		strArticleTitleUnderSevereWeather.syncVisible(15);
		strArticleTitleUnderSevereWeather.click();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}

/******************************************************* END OF SEVERE WEATHER ***********************************************************************/	

	
	
/********************************************** START OF MORE ITEMS ************************************************************************************/
	
	/**
	 * @author HFARAZ
	 * Method to validate if the More tab is displayed
	 * */
	public Boolean isMoreTabDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byMore).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of More tab
	 * */
	public String getMoreText()
	{
		String moreTab=null;
		if(isMoreTabDisplayed())
		{
			moreTab = getDriver().findElement(byMore).getText();
		}
		return moreTab;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to hover on More tab
	 * */
	public void hoverOnMoreMenu()
	{
		if(isMoreTabDisplayed())
		{
			WebPageLoaded.isDomComplete();
			getDriver().findElement(byMore).hover();
		}	
	}
	
	/**
	 * @author HFARAZ
	 * Method to verify if search bar is present or not
	 * */
	public Boolean isSearchBarDisplayed()
	{
		hoverOnMoreMenu();
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bySearchBar).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to verify if search icon is present or not
	 * */
	public Boolean isSearchIconDisplayed()
	{
		if(isSearchBarDisplayed())
			return getDriver().findElement(bySearchIcon).syncVisible(15,false);
		else
			return false;
	}
	
	/**
	 * @author HFARAZ
	 * Method to click on search icon
	 * */
	public void clickTopSearchIcon()
	{
		if(isSearchIconDisplayed())
			getDriver().findElement(bySearchIcon).jsClick();
	}
	
	/**
	 * @author HFARAZ
	 * Method to verify if search input is present or not
	 * */
	public Boolean isSearchInputDisplayed()
	{
		if(isSearchBarDisplayed())
			return getDriver().findElement(bySearchInput).syncVisible(15,false);
		else
			return false;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text on Search input bar at the top of Universal Navigation menu
	 * */
	public String getSearchInputText()
	{
		if(isSearchBarDisplayed())
			return getDriver().findElement(bySearchInput).getText();
		else
			return "";
	}
	
	
	public boolean isPodcastSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byPodcast).syncVisible(15,false);
	}

	public void clickOnPodcastSubMenu()
	{
		if(isPodcastSubMenuDisplayed())
			getDriver().findElement(byPodcast).jsClick();
	}

	public boolean isAWPremiumSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAccuWeatherPremium).syncVisible(15,false);
	}

	public boolean isAWPremiumDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAccuWeatherPremiumDescription).syncVisible(15,false);
	}

	public void clickOnAWPremiumSubMenu()
	{
		if(isAWPremiumSubMenuDisplayed())
			getDriver().findElement(byAccuWeatherPremium).jsClick();
	}
	
	public String getAWPremiumDescription()
	{
		String awPremiumText = null;
		if(isAWPremiumDescriptionDisplayed())
		awPremiumText = getDriver().findElement(byAccuWeatherPremiumDescription).getText();
		
		return awPremiumText;
	}

	public String getAWPremiumText()
	{
		String awPremiumText = null;
		if(isAWPremiumSubMenuDisplayed())
		awPremiumText = getDriver().findElement(byAccuWeatherPremium).getText();
		
		return awPremiumText;
	}


	public boolean isAWProfessionalSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAccuWeatherProfessional).syncVisible(15,false);
	}

	public boolean isAWProfessionalDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAccuWeatherProfessionalDescription).syncVisible(15,false);
	}
	
	public String getAWProfessionalDescription()
	{
		String awProfessionalDescription = "";
		if(isAWProfessionalDescriptionDisplayed())
			awProfessionalDescription = getDriver().findElement(byAccuWeatherProfessionalDescription).getText();
		
		return awProfessionalDescription;
	}

	public void clickOnAWProfessionalSubMenu()
	{
		if(isAWAboutSubMenuDisplayed())
			getDriver().findElement(byAccuWeatherProfessional).jsClick();
	}

	public String getAWProfessionalText()
	{
		String awProfessional = null;
		if(isAWProfessionalSubMenuDisplayed())
			awProfessional = getDriver().findElement(byAccuWeatherProfessional).getText();
		
		return awProfessional;
	}

	public boolean isAWAboutSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAboutAccuWeather).syncVisible(15,false);
	}

	public boolean isAWAboutDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAboutAccuWeatherDescription).syncVisible(15,false);
	}
	
	public String getAWAboutDescription()
	{
		String aboutAWDescription = null;
		if(isAWAboutDescriptionDisplayed())
			aboutAWDescription = getDriver().findElement(byAboutAccuWeatherDescription).getText();
		return aboutAWDescription;
	}

	public void clickOnAWAboutSubMenu()
	{
		if(isAWAboutSubMenuDisplayed())
		getDriver().findElement(byAboutAccuWeather).jsClick();
	}

	public String getAWAboutText()
	{
		String aboutAWText = null;
		if(isAWAboutSubMenuDisplayed())
		aboutAWText = getDriver().findElement(byAboutAccuWeather).getText();
		return aboutAWText;
	}
	
	public boolean isPodcastDescriptionDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byPodcastDescription).syncVisible(15,false);
	}

	public String getPodcastDescription()
	{
		String podcastDescription = null;
		if(isPodcastDescriptionDisplayed())
			podcastDescription = getDriver().findElement(byPodcastDescription).getText();
		
		return podcastDescription;
	}

	public boolean isAppsAndDownloadSubMenuDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAppsAndDownload).syncVisible(15,false);
	}

	public boolean isAppAndDwnldTextDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byAppsAndDownloadDescription).syncVisible(15,false);
	}

	public void clickOnAppAndDwnldSubMenu()
	{
		if(isAppsAndDownloadSubMenuDisplayed())
		getDriver().findElement(byAppsAndDownload).jsClick();
	}

	public String getAppAndDownloadDescription()
	{
		return getDriver().findElement(byAppsAndDownloadDescription).getText();
	}

	public boolean isFacebookIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byFacebookIcon).syncVisible(15,false);
	}
	
	public void clickOnFacebookIcon()
	{
		if(isTwitterIconDisplayed())
			getDriver().findElement(byFacebookIcon).click();
	}

	public boolean isTwitterIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byTwitterIcon).syncVisible(15,false);
	}
	
	public void clickOnTwitterIcon()
	{
		if(isTwitterIconDisplayed())
			getDriver().findElement(byTwitterIcon).click();
	}

	public boolean isInstagramIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byInstagramIcon).syncVisible(15,false);
	}
	
	public void clickOnInstagramIcon()
	{
		if(isTwitterIconDisplayed())
			getDriver().findElement(byInstagramIcon).click();
	}

	public boolean isYoutubeIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		hoverOnMoreMenu();
		return getDriver().findElement(byYoutubeIcon).syncVisible(15,false);
	}
	
	public void clickOnYoutubeIcon()
	{
		if(isTwitterIconDisplayed())
			getDriver().findElement(byYoutubeIcon).click();
	}

	
	
	
/*********************************************** END OF MORE ITEMS **********************************************************************************/	

	/**
	 * @author HFARAZ
	 * Method to validate if the setting icon is displayed
	 * */
	public Boolean isSettingIconDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bySettingIcon).syncVisible(15,false);
	}


	

	

	public void mouseHoverOnSettingsIcon()
	{
		WebPageLoaded.isDomComplete();
		WebElement settings = getDriver().findElement(bySettingIcon);
		settings.syncVisible(15);
		settings.hover();
	}

	public void mouseHoverOnSettingCountryUpArrowIcon()
	{
		WebPageLoaded.isDomComplete();
		WebElement settingcountryuparrow = getDriver().findElement(bySettingCountryUpArrow);
		settingcountryuparrow.syncVisible(15);
		settingcountryuparrow.hover();
	}

	public void clickSettingCountryUPArrow()
	{
		getDriver().findElement(bySettingCountryUpArrow).click();
	}

	public boolean isMyRecentCountriesTextDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebElement myrecentcountry = getDriver().findElement(bySettingMyRecentCountries);
		myrecentcountry.syncVisible(15);
		return myrecentcountry.isDisplayed();
	}

	public boolean isMoreCountriesButtonDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebElement morecountries = getDriver().findElement(bySettingMoreCountries);
		morecountries.syncVisible(15);
		return morecountries.isDisplayed();
	}

	public void clickSettingMoreCountriesLink()
	{
		getDriver().findElement(bySettingMoreCountries).click();
	}

	public void mouseHoverOnSettingLanguageArrowIcon()
	{
		WebPageLoaded.isDomComplete();
		WebElement settinglangarrow = getDriver().findElement(bySettingLanguageArrow);
		settinglangarrow.syncVisible(15);
		settinglangarrow.hover();
	}

	public boolean isSettingsLanguageListDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebElement langlist = getDriver().findElement(bySettingLangugaeList);
		langlist.syncVisible(15);
		return langlist.isDisplayed();
	}

	public void clickSettingLanguageArrowLink()
	{
		getDriver().findElement(bySettingLanguageArrow).click();
	}

	public void mouseHoverOnSettingCountryNameLink()
	{
		WebPageLoaded.isDomComplete();
		WebElement countryname = getDriver().findElement(bySettingCountryName);
		countryname.syncVisible(15);
		countryname.hover();
	}

	public void mouseHoverOnSettingLanguageNameLink()
	{
		WebPageLoaded.isDomComplete();
		WebElement langname = getDriver().findElement(bySettingLanguageSelect);
		langname.syncVisible(15);
		langname.hover();
	}

	public void clickSettingLangNameLink()
	{
		getDriver().findElement(bySettingLanguageSelect).click();
	}

	public String getSettingTranslatedLanguageNameText()
	{
		return getDriver().findElement(bySettingLanguage).getText();
	}

	public void clickSettingCountryNameLink()
	{
		getDriver().findElement(bySettingCountryName).click();
		Sleeper.sleep(2);
	}

	public String getSettingCountryNameLinkText()
	{
		return getDriver().findElement(bySettingCountryName).getText();
	}

	public void mouseHoverOnTemperatureBall()
	{
		WebPageLoaded.isDomComplete();
		WebElement tempball = getDriver().findElement(bySettingTempBall);
		WebElement tempbar = getDriver().findElement(bySettingTempBar);
		// tempball.syncVisible(15);
		// tempball.hover();
		// getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempball,
		// 1014 + 34, 0).build().perform();
		getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempbar, 1014 + 34, 0).build().perform();

	}

	public void dragAndDropTemperatureBall()
	{
		WebPageLoaded.isDomComplete();
		// WebElement tempbar = getDriver().findElement(bySettingTempBar);
		WebElement tempball = getDriver().findElement(bySettingTempBall);
		getDriver().actions().moveToElement(tempball).click().build().perform();
		getDriver().actions().moveByOffset(1014 + 34, 60).build().perform();
		// getDriver().actions().dragAndDropBy(tempball, 1014 + 34,
		// 60).build().perform();
		// getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempball,
		// 1014 + 34, 60).build().perform();
		// getDriver().actions().moveByOffset(1014, 60).perform();
		// settingTempbarWidth();
		// settingTempBarXAxis();
		// settingTempBarYAxis();
	}

	public void settingTempBarXAxis()
	{
		WebPageLoaded.isDomComplete();
		WebElement tempbar = getDriver().findElement(bySettingTempBar);
		int xcoordinate = tempbar.getLocation().getX();
		// int xcoordinate = tempbar.getCoordinates().onPage().x;
		System.out.println("xcoordinate .......... " + xcoordinate);
	}

	public void settingTempBarYAxis()
	{
		WebPageLoaded.isDomComplete();
		WebElement tempbar = getDriver().findElement(bySettingTempBar);
		int ycoordinate = tempbar.getLocation().getY();
		// int ycoordinate = tempbar.getCoordinates().onPage().y;
		System.out.println("ycoordinate .......... " + ycoordinate);
	}

	public void settingTempbarWidth()
	{
		WebPageLoaded.isDomComplete();
		WebElement tempbar = getDriver().findElement(bySettingTempBar);
		Dimension tempbarSize = tempbar.getSize();
		int barwidth = tempbarSize.getWidth();
		// int ycoordinate = tempbar.getCoordinates().onPage().y;
		System.out.println("barwidth .......... " + barwidth);
	}

	public void mouseHoverOnPodcastSubMenu()
	{
		WebPageLoaded.isDomComplete();
		WebElement podcast = getDriver().findElement(byPodcast);
		podcast.syncVisible(15);
		podcast.hover();
	}

	public boolean isSettingCentigradeLabelDisplayed()
	{
		WebPageLoaded.isDomComplete();
		WebElement centigrade = getDriver().findElement(bySettingCentigradeLabel);
		centigrade.syncVisible(15);
		return centigrade.isDisplayed();
	}

	

	/**
	 * Method to click Radar Tab on secondary navigation [city forecast page]
	 * 
	 * @author Sowmiya
	 */
	public void clickRadarTabOnCityForecastPage()
	{
		WebPageLoaded.isDomComplete();
		WebElement radarTabSecondaryNavigation = getDriver().findElement(byRadarTabSecondaryNavigation);
		radarTabSecondaryNavigation.syncVisible(15);
		radarTabSecondaryNavigation.jsClick();
		Sleeper.sleep(2);
	}

	/*
	 * Method to get Video Sub Menu Description Text from Navigation Bar
	 */
	public String getVideoSubMenuDescriptionText()
	{
		return getDriver().findElement(byVideoDescription).getText();
	}

	/*
	 * Method to get Trending Now Sub Menu Description Text from Navigation Bar
	 */
	public String getTredndingNowSubMenuDescriptionText()
	{
		return getDriver().findElement(byTrendingNowDescription).getText();
	}

	/*
	 * Method to get Storm Chasers Sub Menu Description Text from Navigation Bar
	 */
	public String getStormChasersSubMenuDescriptionText()
	{
		return getDriver().findElement(byStormChasersDescription).getText();
	}

	/*
	 * Method to get Expert Forecast Sub Menu Description Text from Navigation Bar
	 */
	public String getExpertForecastSubMenuDescriptionText()
	{
		return getDriver().findElement(byExpertForecastDescription).getText().substring(15, 49).trim();
	}

	public void switchToPopUpWindow(String defaultwindow)
	{

		Set<String> windows = getDriver().getWindowHandles();
		Iterator iterator = windows.iterator();
		String currentwindowId;
		while (iterator.hasNext())
		{
			currentwindowId = iterator.next().toString();
			if (!currentwindowId.equals(defaultwindow))
			{
				getDriver().switchTo().window(currentwindowId);

			}
		}

	}

	public void locationSearch2Chars()
	{
		WebElement element = getDriver().findElement(bySuperSearch);
		getDriver().executeJavaScript("arguments[0].setAttribute('value', 'st')", element);
	}

	public void locationSearchWithoutChars()
	{
		WebElement element = getDriver().findElement(bySuperSearch);
		getDriver().executeJavaScript("arguments[0].setAttribute('value', '')", element);
	}

	public void enterlocationSearch() throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		WebPageLoaded.isDomComplete(2000);
		// Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebPageLoaded.isDomComplete(2000);
		// Thread.sleep(2000);

	}

	public void satelliteCitylocationSearch()
	{
		WebElement element = getDriver().findElement(bySuperSearch);
		getDriver().executeJavaScript("arguments[0].setAttribute('value', 'Rio de Janeiro, Rio De Janeiro, BR')",
				element);
	}

	/**
	 * Method to verify city page has correct searched location
	 * 
	 * @author Sowmiya
	 *         return - String - city name
	 */
	public String verifyCityPageHasSearchedLocation()
	{
		WebPageLoaded.isDomComplete();
		WebElement cityNameOnCityPage = getDriver().findElement(byCityNameOnCityPage);
		cityNameOnCityPage.syncVisible(15);
		return cityNameOnCityPage.getText();
	}
	
	/**
	 * Method  to change the temperature from Farenheit (IMPERIAL) to Celcius (METRIC)
	 * @author Sowmiya
	 * */
	public void changeTemperatureFromFarenheitToCelcius()
	{
		WebPageLoaded.isDomComplete(10);
		WebElement unitsDropdown = getDriver().findElement(bySettingUnitsDropdown);
		unitsDropdown.syncVisible(30);
		unitsDropdown.jsClick();
		Sleeper.sleep(3);
		
		WebElement tempCelciusLabel = getDriver().findElement(bySettingTempCelciusLabel);
		tempCelciusLabel.syncVisible();
		tempCelciusLabel.click();
		Sleeper.sleep(2);
	}	

	
}