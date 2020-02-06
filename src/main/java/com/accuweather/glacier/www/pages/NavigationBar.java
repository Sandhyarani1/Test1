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
    private By byAccuWeatherLogo = By.cssSelector("div.main-menu > div > div > a");
    private By byMegaMenu = By.cssSelector("div.main-menu-content");
    private By byRadar = By.xpath("//*[text()='Radar' and contains(@href,'weather-radar']");
    
    /********************************* Universal Navigation Menu Items ***************************************/
    private By byRadarMaps 		= By.cssSelector("div.main-menu > ul > li:nth-child(1)");
    private By byNews 			= By.cssSelector("div.main-menu > ul > li:nth-child(2)");
    private By byVideo 			= By.cssSelector("div.main-menu > ul > li:nth-child(3)");
    private By bySevereWeather 	= By.cssSelector("div.main-menu > ul > li:nth-child(4)");
    private By byMore 			= By.cssSelector("div.main-menu > ul > li:nth-child(5)");
    
    /******************************** Settings Items ********************************************************/
    private By bySettingIcon = By.cssSelector("div.settings-button > svg.icon-settings");
    private By bySettingCountry = By.cssSelector("div.settings-wrap > div.dropdown-select.fade-in-left > div.dropdown-select-wrapper > div.select-title");
    private By bySettingLanguage = By.cssSelector("div.settings-wrap > div.fade-in-left:nth-of-type(2) > div > div");
    private By bySettingTemperature = By.cssSelector("div.settings-wrap > div.temp-switcher.fade-in-left > span.temp-switcher-label");
    private By bySettingCountryUpArrow = By.cssSelector("div > div:nth-child(1) > div.dropdown-select-wrapper > svg.hide-mobile.icon-chevron");
    private By bySettingMyRecentCountries = By.cssSelector("div > div.dropdown-select.fade-in-left > div.dropdown-content > div.dropdown-content-title");
    private By bySettingMoreCountries = By.cssSelector("div > div > div.dropdown-content > a.button-primary");
    private By bySettingCountryName = By.cssSelector("div > div > div.dropdown-content > a.dropdown-content-item");
    private By bySettingLanguageArrow = By.cssSelector("div > div.fade-in-left:nth-of-type(2) > div > svg.hide-mobile.icon-chevron");
    private By bySettingLangugaeList = By.cssSelector("div > div > div.dropdown-content");
    private By bySettingLanguageSelect = By.cssSelector("div > div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-content > div.dropdown-content-item:nth-child(3)");
    private By bySettingCentigradeLabel = By.cssSelector("div.settings-wrap > div.temp-switcher.fade-in-left > div.switcher-container.switch-right");
    private By bySettingTempBall = By.cssSelector("div > div.temp-switcher.fade-in-left > div.switcher-container > div.switcher > div.ball");
    private By bySettingTempBar = By.cssSelector("div > div.temp-switcher.fade-in-left > div.switcher-container > div.switcher > div.bar" );
    private By byStartSearch = By.className("search-input");
    private By byCityNameOnCityPage = By.cssSelector("#sub-header-recent-location > a.recent-location-display > span.recent-location-display-label.location-label");
    //private By byTopSearch = By.cssSelector("div.main-menu > div.header-right-container > div.search-wrapper.is-wide > svg.icon-search");
    private By byTopSearch = By.xpath("//div[contains(@class,'header-right-container')]/div/div");
    //private By byTopSearchClose = By.xpath("//div[contains(@class,'header-right-container')]/svg");
    private By byTopSearchClose = By.cssSelector("div.utility-bar-wrapper > svg.icon-close");
    //private By bySuperSearch = By.className("super-search-input");
    private By bySuperSearch = By.cssSelector("div.super-search-wrap > form.super-search-form > input");
    private By byBrowseLocation = By.cssSelector("div.mega-menu-search > div.content-column > a.super-search-browse");
    private By byTopNavCTA = By.cssSelector("div.mega-menu-search > div.content-column > div.super-search-current-location");
    private By byTopNavNYCityImage = By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(1) > img");
    private By byTopNavChicagoCityImage = By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(2) > img");
    //private By byTopNavChicagoCityImage = By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(2) > img");
    private By byTopNavDCCityImage = By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(3) > img");
    private By byTopNavHoustonCityImage = By.cssSelector("div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(4) > img");
    private By byFirstCityName = By.cssSelector("div > div > a.recent-location-item-header.recent-location-link.fade-in-left > span.recent-location-name");
    private By byTopNavCityList = By.cssSelector("div.mega-menu-search > div.content-column > a.recent-location-link");
    //private By bySuperSearchCityName = By.xpath("//nav[contains(@class,'header-refresh ')]/div[5]/div/div[1]/ul/li[1]/a[contains(@href,'select-city')]");
    private By bySuperSearchCityName = By.xpath("//body[contains(@id,'home')]/nav/div[5]/div/div[1]/ul/li/a");
    //private By byRadarAndMapsSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(1) > a");
    
    /************************************** Radar & Maps Sub Menus ********************************************************/
    private By byRadarAndMapsSubMenu		= By.cssSelector("div.mega-menu-content-cta > div > a > h4");
    private By byRadarSubMenu 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > a > h4");
    private By bySatelliteMapsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > a > h4");
    private By byCurrentConditionsSubMenu 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > a > h4");
    private By bySevereSubMenu 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > a > h4");
    private By byForecastMapsSubMenu 		= By.cssSelector("div.mega-menu-content-links > div:nth-child(5) > a > h4");
    
    /************************************* Description of Radar & Maps Sub Menu ******************************************/
    private By byRadarMapsSubMenuDescription 			= By.cssSelector("div.mega-menu-content-cta > div > p");
    private By byRadarSubMenuDescription 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(1) > p");
    private By bySatelliteSubMenuDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(2) > p");
    private By byCurrentConditionsSubMenuDescription 	= By.cssSelector("div.mega-menu-content-links > div:nth-child(3) > p");
    private By bySevereSubMenuDescription 				= By.cssSelector("div.mega-menu-content-links > div:nth-child(4) > p");
    private By byForecastSubMenuDescription 			= By.cssSelector("div.mega-menu-content-links > div:nth-child(5) > p");
    private By bySatelliteSubMenuMapTitle 				= By.cssSelector("div.mega-menu-content-media > a > figure > p");
    private By bySatelliteSubMenuMapDescription 		= By.cssSelector("div.mega-menu-content-media > a > figure > figcaption");
    private By bySatelliteImageSubMenu 					= By.cssSelector("div.mega-menu-content-media > a > figure > img");
    
    private By byDateUnderNewsCategory = By.cssSelector("div > div.mega-menu-item.mega-menu-item-media.fade-in-left > div > a > figure > p");
    private By byMapDescriptionUnderNews = By.cssSelector("div > div.mega-menu-item.mega-menu-item-media.fade-in-left > div > a > figure > figcaption");
    
    
    private By byMainMenuDescriptionLink = By.cssSelector("a > figure > figcaption");
    //private By byWatchNewsSubMenu = By.cssSelector("div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(3)");
    private By byWatchNewsSubMenu = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a.button-cta");
    private By byWeatherNewsSubMenu = By.cssSelector("div > div:nth-child(2) > a > h4");
    private By byPersonalitiesSubMenu = By.cssSelector("div > div:nth-child(3) > a > h4");
    private By byWeatherBlogsSubMenu = By.cssSelector("div:nth-child(4) > a > h4");
    private By byClimateChangeSubMenu = By.cssSelector("div:nth-child(5) > a > h4");
    private By byNewsSubMenu = By.cssSelector("div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(1) > h4");
    private By byHurricaneSubMenu = By.xpath("//div[@class='mega-menu-content']/div[3]/a/h4[text()='Hurricane']");
    private By byAWReadySubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(4) > a");
    private By byWinterWeatherSubMenu = By.xpath("//div[@class='mega-menu-content']/div[5]/a/h4[text()='Winter Weather']");
    private By bySeverWeatherSubMenu = By.xpath("//div[@class='mega-menu-content']/div[1]/a/h4[text()='Severe Weather']");
    //Maps Submenu
    private By byMapsSubMenu = By.cssSelector("div.mega-menu > div.mega-menu-content > div:nth-child(1) > a");
    private By bySatelliteSubMenu = By.cssSelector("div.mega-menu > div.mega-menu-content > div:nth-child(2) > a");
    //private By byVideoSubMenu = By.cssSelector("div.menu-dropdown > div > div:nth-child(1) > div > a:nth-child(1) > h3");
    private By byVideoSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(1) > a:nth-child(1) > h4");
    private By byVideoDescription = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > p");
    //private By byVideoDescription = By.cssSelector("div.mega-menu > div:nth-child(1) > div:first-child");
    private By byWatchVideoButton = By.cssSelector("div.mega-menu > div > div:nth-child(1) > a:nth-child(3)");
   // private By byWatchVideoButton = By.cssSelector("div > a:nth-child(3)");
    //private By byWatchVideoButton = By.cssSelector("div.menu-dropdown > div > div:nth-child(1) > div > a.orange-button.videos");
    //private By byTrendingNow = By.cssSelector("div.menu-dropdown > div > div:nth-child(2) > div:nth-child(1) > h4 > a");
    private By byTrendingNow = By.cssSelector("div > div:nth-child(2) > a > h4");
    private By byTrendingNowDescription = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-link.fade-in-left:nth-of-type(2) > p");
    //private By byTrendingNowDescription = By.cssSelector("div.mega-menu > div > div:nth-child(2)");
    //private By byExpertForecasts = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-of-type(3) > h4");
    private By byExpertForecasts = By.cssSelector(" div.mega-menu > div > div:nth-child(3) > a > h4");
    //private By byExpertForecasts = By.cssSelector(" div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(3) > h4");
    private By byStormChasers = By.cssSelector(" div.mega-menu > div > div:nth-child(4) > a > h4");
    //private By byStormChasersDescription = By.cssSelector("div.mega-menu > div > div:nth-child(4)");
    private By byStormChasersDescription = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-link.fade-in-left:nth-of-type(4) > p");
    private By byExpertForecastDescription = By.cssSelector("div.mega-menu > div > div:nth-child(3)");
    //private By byTrendingNow = By.xpath("//body[contains(@id,'home')]//div[5]/div/div[2]/div[1]/h4/a[contains(.,'Trending Now')]");
    //private By byExpertForecasts = By.cssSelector("div.menu-dropdown > div > div:nth-child(2) > div:nth-child(2) > h4 > a");
    //private By byStormChasers = By.cssSelector("div.menu-dropdown > div > div:nth-child(3) > div > h4 > a");
    private By byVideoThumbNail = By.cssSelector("div.menu-dropdown > div > div:nth-child(4) > div > a > img");
    private By byVideoDescriptionLink = By.cssSelector("div.menu-dropdown > div > div:nth-child(4) > div > a > p.thumb-description");
    private By byAppsAndDownloadsSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(1) > a > h4");
    private By byAppsAndDownloadText = By.cssSelector("div > div.mega-menu > div > div:nth-child(1) > p");
    private By byAWPremiumSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(2) > a > h4");
    private By byAWPremiumText = By.cssSelector("div > div.mega-menu > div > div:nth-child(2) > p");
    private By byPodcastSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(5) > a > h4");
    private By byPodcastText = By.cssSelector("div > div.mega-menu > div > div:nth-child(3) > p");
    private By byAWProfessionalSubMenu = By.cssSelector("div > div.mega-menu-content > div.mega-menu-item.mega-menu-item-link.fade-in-left:nth-of-type(4) > a > h4");
    //private By byAWProfessionalSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(4) > a > h4");
    private By byAWProfessionalText = By.cssSelector("div > div.mega-menu > div > div:nth-child(4) > p");
    //private By byAboutAWSubMenu = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(5) > h4");
    private By byAboutAWSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(1) > a > h4");
    //private By byAboutAWSubMenu = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(1) > h4");
    private By byAboutAWText = By.cssSelector("div > div.mega-menu > div > div:nth-child(5) > p");
    //private By byCouponsSubMenu = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left:nth-of-type(6) > a > h4");
    //private By byCouponsSubMenu = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(6) > h4");
    private By byCouponsSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(6) > a > h4");
   private By byCouponsText = By.cssSelector("div > div.mega-menu > div > div:nth-child(6) > p");
    private By byFacebookIcon = By.cssSelector("div.mega-menu-content > div.header-social.fade-in-left:nth-of-type(7) > a > svg.icon-facebook > g > path");
    //private By byFacebookIcon = By.cssSelector("div.mega-menu-content > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(7) > h4");
    //private By byFacebookIcon = By.cssSelector("div > div.mega-menu > div > div:nth-child(7) > a > h4");
    private By byTwitterIcon = By.cssSelector("div.mega-menu-content > div.header-social.fade-in-left:nth-of-type(7) > a > svg.icon-twitter > g > path");
    private By byYoutubeIcon = By.cssSelector("div.mega-menu-content > div.header-social.fade-in-left:nth-of-type(7) > a > svg.icon-youtube > g > path");
    private By byInstagramIcon = By.cssSelector("div.mega-menu-content > div.header-social.fade-in-left:nth-of-type(7) > a >img.icon-instagram");
    private By byFaceBookText = By.xpath("//div[contains(@class,'social')]/a[1]/h4");
    private By byTwitterText = By.xpath("//div[contains(@class,'social')]/a[2]/h4");
    private By byInstagramText = By.xpath("//div[contains(@class,'social')]/a[3]/h4");
    private By byyoutubeText = By.xpath("//div[contains(@class,'social')]/a[4]/h4");
       //secondary tabs
    private By byRadarTabSecondaryNavigation = By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(2)");
   
   //under radar & maps category
    public static String strMapTitle;
    public static String strSatelliteMapDescription;
    public static String strMapUrl;
    public static String strMapTitleUrl;
    public static String strMapDescriptionUrl;
   
    /**************************** News Items ***************************************************/
    public static String strMapDescriptionUnderNews;
    public static String strDateUnderNews;
    
    private By byThumbnailUnderNews 	= By.cssSelector("div.mega-menu-content-media > div > a > figure > img");
    private By byNewsArticleDate 		= By.cssSelector("div.mega-menu-content-media > div > a > figure > p");
    private By byArticleTitleUnderNews 	= By.cssSelector("div.mega-menu-content-media > div > a > figure > figcaption");
  
    /**************************** Video Items ************************************/
    private By byThumbnailUnderVideo = By.xpath("//div[@class='zone-navigationVideo']/a/figure/img");
    private By byDurationUnderVideo = By.xpath("//div[@class='zone-navigationVideo']/a/figure/p");
    private By byArticleTitleUnderVideo = By.xpath("//div[@class='zone-navigationVideo']/a/figure/figcaption");
    
    /************************** Severe Weather Items ***************************/
    private By byThumbnailUnderSevereWeather = By.xpath("//div[@class='zone-navigationSevere']/a/figure/img");
    private By byDateUnderSevereWeather = By.xpath("//div[@class='zone-navigationSevere']/a/figure/p");
    private By byArticleTitleUnderSevereWeather = By.xpath("//div[@class='zone-navigationSevere']/a/figure/figcaption");
      
  
        
   
    public void navigateToHome() {
        clickVisibleElement(byAccuWeatherLogo);
    }
 
    public void navigateToRadarAndMaps() {
        clickVisibleElement(byRadarMaps);
    }
 
    public void navigateToNews() {
        clickVisibleElement(byNews);
    }
 
    public void navigateToVideo() {
        clickVisibleElement(byVideo);
    }
 
    public void navigateToSevereWeather() {
        clickVisibleElement(bySevereWeather);
    }
 
    public void navigateToForecast() {
        clickVisibleElement(bySuperSearchCityName);
    }
 
    //click radar and maps submenu under radar & maps
    public void navigateToRadarAndMapsUnderRadarMaps() {
        getDriver().findElement(byRadarAndMapsSubMenu).jsClick();
        Sleeper.sleep(2);
    }
   
  //click radar submenu under radar & maps
    public void navigateToRadar() {
    //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(byRadarSubMenu));
    getDriver().findElement(byRadarSubMenu).click();
    Sleeper.sleep(2);
    //clickVisibleElement(byRadarSubMenu);
    }
    
  //click radar submenu under radar & maps
    public void navigateToCurrentConditions()
    {
    getDriver().findElement(byCurrentConditionsSubMenu).click();
    Sleeper.sleep(2);
    }
 
    public void navigateToHomePageByLogo() {
        getDriver().findElement(byAccuWeatherLogo).jsClick();
        Sleeper.sleep(3);
        //clickVisibleElement(byRadarSubMenu);
        }
 
    public void navigateToSeverWeatherPage() {
        getDriver().findElement(bySevereSubMenu).click();
        //clickVisibleElement(byRadarSubMenu);
        }
 
    public void navigateToSatellitePage() {
        getDriver().findElement(bySatelliteMapsSubMenu).jsClick();
        //getDriver().findElement(bySatelliteMapsSubMenu).click();
         }
 
    public void navigateToForeCastPage() {
        getDriver().findElement(byForecastMapsSubMenu).jsClick();
        //clickVisibleElement(byRadarSubMenu);
        }
 
       /*
       * public void locationSearch(String info) { //WebTextbox txtSearch =
       * getDriver().findTextbox(byStartSearch); WebTextbox txtSearch =
       * getDriver().findTextbox(byTopSearch); txtSearch.syncEnabled();
       * txtSearch.click(); WebTextbox txtSuperSearch =
       * getDriver().findTextbox(bySuperSearch); txtSuperSearch.syncVisible();
       * txtSuperSearch.set(info); txtSuperSearch.sendKeys(Keys.RETURN); }
       */
   
    public void locationSearch(String info) {
        WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
        txtSuperSearch.syncVisible();
        txtSuperSearch.set(info);
        txtSuperSearch.sendKeys(Keys.RETURN);
    }
 
    public boolean isSettingCountryDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox settingcountry = getDriver().findTextbox(bySettingCountry);
        settingcountry.syncVisible(15);
       return settingcountry.isDisplayed();    
       }
      
        public boolean isSettingLanguageDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox settinglang = getDriver().findTextbox(bySettingLanguage);
        settinglang.syncVisible(15);
       return settinglang.isDisplayed();    
       }
       
        public boolean isSettingTemperatureDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebTextbox settingtemp = getDriver().findTextbox(bySettingTemperature);
            settingtemp.syncVisible(15);
             return settingtemp.isDisplayed();    
           }
   
    public boolean isStartSearchDisplayed() {
       WebPageLoaded.isDomInteractive();
    WebTextbox txtSearch = getDriver().findTextbox(byTopSearch);
       return txtSearch.syncVisible(15);    
   }
   
    
    public void clickSettingsIcon() {
             WebPageLoaded.isDomInteractive();
        WebTextbox settingicon = getDriver().findTextbox(bySettingIcon);
        settingicon.syncVisible(15);
       settingicon.click();
       Sleeper.sleep(5);
       }
   
    public void clickTopNavStartSearchIcon() {
             WebPageLoaded.isDomInteractive();
        WebTextbox startsearch = getDriver().findTextbox(byTopSearch);
        startsearch.syncVisible(15);
       startsearch.click();  
       Sleeper.sleep(5);
       }
   
    public void clickBrowseYourLocationLink() {
             WebPageLoaded.isDomInteractive();
             getDriver().findTextbox(byBrowseLocation).syncVisible();
        WebTextbox browselocation = getDriver().findTextbox(byBrowseLocation);
        browselocation.syncVisible(15);
        browselocation.click();  
        Sleeper.sleep(3);
       }
 
    public boolean isMegaMenuContentDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebElement megamenucontent = getDriver().findElement(byMegaMenu);
        megamenucontent.syncVisible(15);
       return megamenucontent.isDisplayed();    
       }
 
    public boolean isTopNavSearchCloseIconDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox closesearch = getDriver().findTextbox(byTopSearchClose);
        closesearch.syncVisible(15);
       return closesearch.isDisplayed();    
       }
   
    public boolean isTopNavCTATextDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavctatext = getDriver().findTextbox(byTopNavCTA);
        topnavctatext.syncVisible(15);
       return topnavctatext.isDisplayed();    
       }
   
    public boolean isTopNavNYCityImageDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavNYCityImage);
        topnavcityimage.syncVisible(15);
       return topnavcityimage.isDisplayed();    
       }
   
    public boolean isTopNavChicagoCityImageDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavChicagoCityImage);
        topnavcityimage.syncVisible(15);
       return topnavcityimage.isDisplayed();    
       }
   
    public boolean isTopNavDCCityImageDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavDCCityImage);
        topnavcityimage.syncVisible(15);
       return topnavcityimage.isDisplayed();    
       }
   
    public boolean isTopNavHoustonCityImageDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavHoustonCityImage);
        topnavcityimage.syncVisible(15);
       return topnavcityimage.isDisplayed();    
       }
   
    
    public boolean isTopNavFirstCityDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavCityList);
        topnavcityimage.syncVisible(15);
       return topnavcityimage.isDisplayed();    
       }
   
    
    public boolean isRecentCityNameDisplayed() {
             WebPageLoaded.isDomInteractive();
        WebTextbox recentcityname = getDriver().findTextbox(byFirstCityName);
        recentcityname.syncVisible(15);
       return recentcityname.isDisplayed();    
       }
 
    public void clickTopNavSearchCloseIcon() {
             WebPageLoaded.isDomInteractive();
        WebTextbox closesearch = getDriver().findTextbox(byTopSearchClose);
        closesearch.syncVisible(15);
       closesearch.click();    
       }
 
    public void clickStartSearch() {
    WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
       txtSearch.syncVisible(15);
       txtSearch.click();
    }
   
    
    public void clickTopNavCTALink() {
        WebTextbox ctalink = getDriver().findTextbox(byTopNavCTA);
       ctalink.syncEnabled();
       ctalink.click();
   }
 
    public boolean validateNavigation(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Constants.PAGE_TIMEOUT);
        return wait.until(ExpectedConditions.urlContains(url));
    }
 
    public String clickAndGetlocationCityName(String info) {
               WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
               txtSearch.syncEnabled(); txtSearch.click();
        WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
        txtSuperSearch.syncVisible();
        txtSuperSearch.set(info);
        txtSuperSearch.sendKeys();
        String CityName = getCityNameText(info);
        //WebLink link = getDriver().findLink(bySuperSearchCityName);
        //link.click();
        navigateToForecast();
        return CityName;
    }
 
    public boolean isRadarSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement radar = getDriver().findElement(byRadarSubMenu);
        radar.syncVisible(15);
        return radar.isDisplayed();          
    }
 
    public boolean isSeverSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement Severe = getDriver().findElement(bySevereSubMenu);
        Severe.syncVisible(15); 
        return Severe.isDisplayed();
    }
 
    public boolean isSatelliteMapsSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement SatelliteMaps = getDriver().findElement(bySatelliteMapsSubMenu);
        SatelliteMaps.syncVisible(15);
        return SatelliteMaps.isDisplayed();               
    }
 
    public boolean isForecastMapsSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement SatelliteMaps = getDriver().findElement(byForecastMapsSubMenu);
        SatelliteMaps.syncVisible(15);
        return SatelliteMaps.isDisplayed();               
    }
 
    public boolean isDescriptionLinkDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement descriptionLink = getDriver().findElement(byMainMenuDescriptionLink);
        descriptionLink.syncVisible(15);
        return descriptionLink.isDisplayed();             
    }
 
    public void mouseHoverOnAWLogo() {
       WebPageLoaded.isDomInteractive();
        WebElement radarandmaps = getDriver().findElement(byAccuWeatherLogo);
        radarandmaps.syncVisible(15);
        radarandmaps.hover();
    }
 
    public void mouseHoverOnRadarAndMaps() {
       WebPageLoaded.isDomInteractive();
        WebElement radarandmaps = getDriver().findElement(byRadarMaps);
        radarandmaps.syncVisible(25);
        Sleeper.sleep(5);
        radarandmaps.hover();
        Sleeper.sleep(5);
    }
   
    //verify universsal navigation menu is present
    public Boolean isRadarAndMapsDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement radarandmaps = getDriver().findElement(byRadarMaps);
        radarandmaps.syncVisible(25);
        return radarandmaps.isDisplayed();
    }
    //news
    public Boolean isNewsDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement news = getDriver().findElement(byNews);
        news.syncVisible(25);
        return news.isDisplayed();
    }
    //video
    public Boolean isVideoDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement video = getDriver().findElement(byVideo);
        video.syncVisible(25);
        return video.isDisplayed();
    }
    //severeweather
    public Boolean isSevereWeatherDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement severeweather = getDriver().findElement(bySevereWeather);
        severeweather.syncVisible(25);
        return severeweather.isDisplayed();
    }
    //more
    public Boolean isMoreDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement more = getDriver().findElement(byMore);
        more.syncVisible(25);
        return more.isDisplayed();
    }
   
    //verify gear icon is present
    public Boolean isGearIconDisplayed() {
       WebPageLoaded.isDomInteractive();
       WebElement gearIcon = getDriver().findElement(bySettingIcon);
       gearIcon.syncVisible(25);
       return gearIcon.isDisplayed();
   }
   
  
	
	  public void mouseHoverOnMaps() {
	  WebPageLoaded.isDomInteractive();
	  WebElement maps = getDriver().findElement(byRadarMaps);
	  maps.syncVisible(20);
	  Sleeper.sleep(4);
	  maps.hover();
	  Sleeper.sleep(3);
	  }
	 
  
    //Maps categories - Maps Submenu
    public boolean isMapsSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement submenuMaps = getDriver().findElement(byMapsSubMenu);
        submenuMaps.syncVisible(15);
        return submenuMaps.isDisplayed();          
    }
   
    //Maps categories - Satellite Submenu
    public boolean isSatelliteSubMenuDisplayed() {
       WebPageLoaded.isDomInteractive();
        WebElement submenuSatellite = getDriver().findElement(bySatelliteSubMenu);
        submenuSatellite.syncVisible(15);
        return submenuSatellite.isDisplayed();            
    }
   
    //Click on maps submenu
    public void clickOnMapsSubMenu() {
       getDriver().findElement(byMapsSubMenu).jsClick();         
    }
   
    //Click on satelllite submenu
    public void clickOnSatelliteSubMenu() {
       getDriver().findElement(bySatelliteSubMenu).jsClick();         
    }
 
        public void mouseHoverOnDescriptionLink() {
             WebPageLoaded.isDomInteractive();
            WebElement descriptionLink = getDriver().findElement(byMainMenuDescriptionLink);
            descriptionLink.syncVisible(15);
            descriptionLink.hover();
        }
 
        public boolean isAWLogoDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awlogo = getDriver().findElement(byAccuWeatherLogo);
            awlogo.syncVisible(15);
            return awlogo.isDisplayed();            
        }
 
        public boolean isNewsSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement news = getDriver().findElement(byNewsSubMenu);
            news.syncVisible(15);
            return news.isDisplayed();              
        }
 
        public boolean isWatchNewsSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement watchnews = getDriver().findElement(byWatchNewsSubMenu);
            watchnews.syncVisible(15);
            return watchnews.isDisplayed();               
        }
 
        public boolean isWeatherNewsSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement weatherNews = getDriver().findElement(byWeatherNewsSubMenu);
            weatherNews.syncVisible(15);
            return weatherNews.isDisplayed();             
        }
 
        public boolean isPersonalitiesSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement personalities = getDriver().findElement(byPersonalitiesSubMenu);
            personalities.syncVisible(15);
            return personalities.isDisplayed();                     
        }
 
        public boolean isWeatherBlogsSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement weatherblogs = getDriver().findElement(byWeatherBlogsSubMenu);
            weatherblogs.syncVisible(15);
            return weatherblogs.isDisplayed();                      
        }
 
        public boolean isClimateChangeSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement climatechange = getDriver().findElement(byClimateChangeSubMenu);
            climatechange.syncVisible(15);
            return climatechange.isDisplayed();                     
        }
 
        public void navigateToNewsPage() {
            
            getDriver().findElement(byWeatherNewsSubMenu).jsClick();
            //getDriver().findElement(byWeatherNewsSubMenu).click();
           
            }
 
        public void navigateToWeatherVidoesPage() {
            getDriver().findElement(byWatchNewsSubMenu).jsClick();
            //getDriver().findElement(byWatchNewsSubMenu).click();
           
            }
 
            public void navigateToPersonalitiesPage() {
                getDriver().findElement(byPersonalitiesSubMenu).jsClick();
               // getDriver().findElement(byPersonalitiesSubMenu).click();
              }
 
            public void navigateToWeatherBlogPage() {
                getDriver().findElement(byWeatherBlogsSubMenu).jsClick();
                //getDriver().findElement(byWeatherBlogsSubMenu).click();
                //clickVisibleElement(byRadarSubMenu);
                }
 
            public void navigateToClimateChangePage() {
                getDriver().findElement(byClimateChangeSubMenu).click();
                Sleeper.sleep(2);
                //clickVisibleElement(byRadarSubMenu);
                }
 
            public void navigateToNewsTab() {
                getDriver().findElement(byNewsSubMenu).jsClick();
                //getDriver().findElement(byNewsSubMenu).click();
              }
 
            public void navigateToRadarPageFromDescritionLink() {
                getDriver().findElement(byMainMenuDescriptionLink).jsClick();
                //clickVisibleElement(byRadarSubMenu);
                }
 
        public void mouseHoverOnNews() {
             WebPageLoaded.isDomInteractive();
            WebElement news = getDriver().findElement(byNews);
            news.syncVisible(15);
            news.hover();
        }
 
        public boolean isHurricaneSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement hurricane = getDriver().findElement(byHurricaneSubMenu);
            hurricane.syncVisible(15);
            return hurricane.isDisplayed();               
        }
 
        public boolean isAWReadySubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awready = getDriver().findElement(byAWReadySubMenu);
            awready.syncVisible(15);
            return awready.isDisplayed();                 
        }
 
        public boolean isWinterWeatherSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement winterweather = getDriver().findElement(byWinterWeatherSubMenu);
            winterweather.syncVisible(25);
            return winterweather.isDisplayed();                     
        }
 
        public boolean isSeverWeatherSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement severweather = getDriver().findElement(bySeverWeatherSubMenu);
            severweather.syncVisible(15);
            return severweather.isDisplayed();                      
        }
 
        public void navigateToSevereTab() {
             //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //wait.until(ExpectedConditions.elementToBeClickable(bySevereSubMenu));
               getDriver().findElement(bySevereSubMenu).jsClick();
            //getDriver().findElement(bySevereSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void navigateToSevereTabFromSevereWeatherSubMenu() {
            getDriver().findElement(byAWReadySubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void navigateToWinterWeatherTab() {
            getDriver().findElement(byWinterWeatherSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void navigateToHurricaneTab() {
            getDriver().findElement(byHurricaneSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void mouseHoverOnSeverWeather() {
             WebPageLoaded.isDomInteractive();
            WebElement severeweather = getDriver().findElement(bySevereWeather);
            severeweather.syncVisible(30);
            severeweather.hover();
            Sleeper.sleep(3);
        }
 
        public void mouseHoverOnVideo() {
             WebPageLoaded.isDomInteractive();
            WebElement video = getDriver().findElement(byVideo);
            video.syncVisible(15);
            video.hover();
            Sleeper.sleep(3);
        }
 
        public void mouseHoverOnVideoDescriptionLink() {
             WebPageLoaded.isDomInteractive();
            WebElement vidoedescriptionLink = getDriver().findElement(byVideoDescriptionLink);
            vidoedescriptionLink.syncVisible(15);
            vidoedescriptionLink.hover();
            }
 
        public void mouseHoverOnTrendingNowSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement trendingnowsubmenu = getDriver().findElement(byTrendingNow);
            trendingnowsubmenu.syncVisible(15);
            trendingnowsubmenu.hover();
            }
 
        public boolean isVideoSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement videosubmenu = getDriver().findElement(byVideoSubMenu);
            videosubmenu.syncVisible(15);
            return videosubmenu.isDisplayed();            
        }
 
        public boolean isWatchVideoButtonDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement watchvideobtn = getDriver().findElement(byWatchVideoButton);
            watchvideobtn.syncVisible(15);
            return watchvideobtn.isDisplayed();          
        }
 
        public boolean isTrendingNowSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement trendingnow = getDriver().findElement(byTrendingNow);
            trendingnow.syncVisible(15);
            return trendingnow.isDisplayed();             
        }
 
        public boolean isExpertForecastSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement expertforecast = getDriver().findElement(byExpertForecasts);
            expertforecast.syncVisible(15);
            return expertforecast.isDisplayed();          
        }
 
        public boolean isStormChasersSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement stormchasers = getDriver().findElement(byStormChasers);
            stormchasers.syncVisible(15);
            return stormchasers.isDisplayed();            
        }
 
        public boolean isVideoTumbnailDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement videothumnail = getDriver().findElement(byVideoThumbNail);
            videothumnail.syncVisible(15);
            return videothumnail.isDisplayed();          
        }
 
        public boolean isVideoDescriptionLinkDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement videodescriptionlink = getDriver().findElement(byVideoThumbNail);
            videodescriptionlink.syncVisible(15);
            return videodescriptionlink.isDisplayed();             
        }
 
        public void clickVidoeSubMenu() {
            getDriver().findElement(byVideoSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickOnVideoMainMenu() {
            getDriver().findElement(byVideo).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickWatchVideoButton() {
            getDriver().findElement(byWatchVideoButton).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickTrendingNowSubMenu() {
            getDriver().findElement(byTrendingNow).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickExpertForecastSubMenu() {
            getDriver().findElement(byExpertForecasts).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickStormChasersSubMenu() {
            getDriver().findElement(byStormChasers).click();
            //clickVisibleElement(byRadarSubMenu);
            }
 
        public void clickVideoThumbNail() {
            getDriver().findElement(byVideoThumbNail).click();
                     }
 
        public void clickVideoDescriptionLink() {
            getDriver().findElement(byVideoDescriptionLink).click();
                        }
 
        public void clickSeverWeatherSubMenu() {
        getDriver().findElement(bySeverWeatherSubMenu).click();
        }
 
        public void clickHurricaneSubMenu() {
            getDriver().findElement(byHurricaneSubMenu).click();
            }
 
        public void clickWinterWeatherSubMenu() {
            getDriver().findElement(byWinterWeatherSubMenu).click();
            }
 
        public void clicAwReadySubMenu() {
            getDriver().findElement(byAWReadySubMenu).click();
            }
 
        public void mouseHoverOnMoreMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement more = getDriver().findElement(byMore);
            more.syncVisible(15);
            more.hover();
            Sleeper.sleep(2);
            }
       
        public void mouseHoverOnSettingsIcon() {
             WebPageLoaded.isDomInteractive();
            WebElement settings = getDriver().findElement(bySettingIcon);
            settings.syncVisible(15);
            settings.hover();
            }
       
        
        public void mouseHoverOnSettingCountryUpArrowIcon() {
             WebPageLoaded.isDomInteractive();
            WebElement settingcountryuparrow = getDriver().findElement(bySettingCountryUpArrow);
            settingcountryuparrow.syncVisible(15);
            settingcountryuparrow.hover();
            }
       
        
        public void clickSettingCountryUPArrow() {
            getDriver().findElement(bySettingCountryUpArrow).click();
            }
       
        
        public boolean isMyRecentCountriesTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement myrecentcountry = getDriver().findElement(bySettingMyRecentCountries);
            myrecentcountry.syncVisible(15);
            return myrecentcountry.isDisplayed();                   
        }
       
        public boolean isMoreCountriesButtonDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement morecountries = getDriver().findElement(bySettingMoreCountries);
            morecountries.syncVisible(15);
            return morecountries.isDisplayed();          
        }
       
        public void clickSettingMoreCountriesLink() {
            getDriver().findElement(bySettingMoreCountries).click();
            }
       
        
        public void mouseHoverOnSettingLanguageArrowIcon() {
             WebPageLoaded.isDomInteractive();
            WebElement settinglangarrow = getDriver().findElement(bySettingLanguageArrow);
            settinglangarrow.syncVisible(15);
            settinglangarrow.hover();
            }
       
        public boolean isSettingsLanguageListDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement langlist = getDriver().findElement(bySettingLangugaeList);
            langlist.syncVisible(15);
            return langlist.isDisplayed();                
        }
       
        
        public void clickSettingLanguageArrowLink() {
            getDriver().findElement(bySettingLanguageArrow).click();
            }
       
        public void mouseHoverOnSettingCountryNameLink() {
             WebPageLoaded.isDomInteractive();
            WebElement countryname = getDriver().findElement(bySettingCountryName);
            countryname.syncVisible(15);
            countryname.hover();
            }
       
        
        public void mouseHoverOnSettingLanguageNameLink() {
             WebPageLoaded.isDomInteractive();
            WebElement langname = getDriver().findElement(bySettingLanguageSelect);
            langname.syncVisible(15);
            langname.hover();
            }
       
        public void clickSettingLangNameLink() {
            getDriver().findElement(bySettingLanguageSelect).click();
            }
       
        public String getSettingTranslatedLanguageNameText() {
            return getDriver().findElement(bySettingLanguage).getText();                      
        }
       
        public void clickSettingCountryNameLink() {
            getDriver().findElement(bySettingCountryName).click();
            Sleeper.sleep(2);
            }
       
        public String getSettingCountryNameLinkText() {
            return getDriver().findElement(bySettingCountryName).getText();                      
        }
       
        
        public void mouseHoverOnTemperatureBall() {
             WebPageLoaded.isDomInteractive();
            WebElement tempball = getDriver().findElement(bySettingTempBall);
            WebElement tempbar = getDriver().findElement(bySettingTempBar);
            //tempball.syncVisible(15);
            //tempball.hover();
            //getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempball, 1014 + 34, 0).build().perform();
            getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempbar, 1014 + 34, 0).build().perform();
 
            }
        
        public void dragAndDropTemperatureBall() {
             WebPageLoaded.isDomInteractive();
            //WebElement tempbar = getDriver().findElement(bySettingTempBar);
            WebElement tempball = getDriver().findElement(bySettingTempBall);
            getDriver().actions().moveToElement(tempball).click().build().perform();
            getDriver().actions().moveByOffset(1014 + 34, 60).build().perform();
            //getDriver().actions().dragAndDropBy(tempball, 1014 + 34, 60).build().perform();
            //getDriver().actions().moveToElement(tempball).click().dragAndDropBy(tempball, 1014 + 34, 60).build().perform();
            //getDriver().actions().moveByOffset(1014, 60).perform();
            //settingTempbarWidth();
            //settingTempBarXAxis();
            //settingTempBarYAxis();
        }
       
        public void settingTempBarXAxis() {
             WebPageLoaded.isDomInteractive();
            WebElement tempbar = getDriver().findElement(bySettingTempBar);
            int xcoordinate = tempbar.getLocation().getX();
            //int xcoordinate = tempbar.getCoordinates().onPage().x;
            System.out.println("xcoordinate .......... " +xcoordinate);
        }
       
        public void settingTempBarYAxis() {
             WebPageLoaded.isDomInteractive();
            WebElement tempbar = getDriver().findElement(bySettingTempBar);
            int ycoordinate = tempbar.getLocation().getY();
            //int ycoordinate = tempbar.getCoordinates().onPage().y;
            System.out.println("ycoordinate .......... " +ycoordinate);
        }
       
        public void settingTempbarWidth() {
             WebPageLoaded.isDomInteractive();
            WebElement tempbar = getDriver().findElement(bySettingTempBar);
             Dimension tempbarSize = tempbar.getSize();
            int barwidth = tempbarSize.getWidth();
            //int ycoordinate = tempbar.getCoordinates().onPage().y;
            System.out.println("barwidth .......... " +barwidth);
        }
 
        public void mouseHoverOnPodcastSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement podcast = getDriver().findElement(byPodcastSubMenu);
            podcast.syncVisible(15);
            podcast.hover();
            }
 
       
        
        public boolean isSettingCentigradeLabelDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement centigrade = getDriver().findElement(bySettingCentigradeLabel);
            centigrade.syncVisible(15);
            return centigrade.isDisplayed();              
        }
        public boolean isPodcastSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement podcast = getDriver().findElement(byPodcastSubMenu);
            podcast.syncVisible(15);
            return podcast.isDisplayed();          
        }
 
        public void clickOnPodcastSubMenu() {
            //getDriver().findElement(byPodcastSubMenu).click();
               getDriver().findElement(byPodcastSubMenu).jsClick();         
        }
 
        public void mouseHoverOnAWPremiumSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement awpremium = getDriver().findElement(byAWPremiumSubMenu);
            awpremium.syncVisible(15);
            awpremium.hover();
            }
 
        public boolean isAWPremiumSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awpremium = getDriver().findElement(byAWPremiumSubMenu);
            awpremium.syncVisible(15);
            return awpremium.isDisplayed();               
        }
 
        public boolean isAWPremiumTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awpremiumtext = getDriver().findElement(byAWPremiumText);
            awpremiumtext.syncVisible(15);
            return awpremiumtext.isDisplayed();          
        }
 
        public void clickOnAWPremiumSubMenu() {
            getDriver().findElement(byAWPremiumSubMenu).click();                      
        }
 
        public String getAWPremiumText() {
            return getDriver().findElement(byAWPremiumSubMenu).getText();                      
        }
       
               
 
        public void mouseHoverOnAWProfessionalSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement awprofessional = getDriver().findElement(byAWProfessionalSubMenu);
            awprofessional.syncVisible(15);
            awprofessional.hover();
            }
 
        public boolean isAWProfessionalSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awprofessional = getDriver().findElement(byAWProfessionalSubMenu);
            awprofessional.syncVisible(15);
            return awprofessional.isDisplayed();          
        }
 
        public boolean isAWProfessionalTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awprofessionaltext = getDriver().findElement(byAWProfessionalText);
            awprofessionaltext.syncVisible(15);
            return awprofessionaltext.isDisplayed();                
        }
 
        public void clickOnAWProfessionalSubMenu() {
            getDriver().findElement(byAWProfessionalSubMenu).click();                      
        }
 
        public String getAWProfessionalText() {
            return getDriver().findElement(byAWProfessionalText).getText();                      
        }
 
        public void mouseHoverOnAWAboutSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement awabout = getDriver().findElement(byAboutAWSubMenu);
            awabout.syncVisible(15);
            awabout.hover();
            }
 
        public boolean isAWAboutSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awabout = getDriver().findElement(byAboutAWSubMenu);
            awabout.syncVisible(15);
            return awabout.isDisplayed();          
        }
 
        public boolean isAWAboutTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awabouttext = getDriver().findElement(byAboutAWText);
            awabouttext.syncVisible(15);
            return awabouttext.isDisplayed();             
        }
 
        public void clickOnAWAboutSubMenu() {
            getDriver().findElement(byAboutAWSubMenu).click();                      
        }
 
        public String getAWAboutText() {
            return getDriver().findElement(byAboutAWText).getText();                      
        }
 
        public void mouseHoverOnCouponsSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement coupons = getDriver().findElement(byCouponsSubMenu);
            coupons.syncVisible(15);
            coupons.hover();
            }
 
        public boolean isCouponsSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement coupons = getDriver().findElement(byCouponsSubMenu);
            coupons.syncVisible(15);
            return coupons.isDisplayed();          
        }
 
        public boolean isCouponsTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement couponstext = getDriver().findElement(byCouponsText);
            couponstext.syncVisible(15);
            return couponstext.isDisplayed();             
        }
 
        public void clickOnCouponsSubMenu() {
            getDriver().findElement(byCouponsSubMenu).click();                      
        }
 
        public String getCouponsText() {
            return getDriver().findElement(byCouponsText).getText();                      
        }
 
        public boolean isPodcastTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement podcasttext = getDriver().findElement(byPodcastText);
            podcasttext.syncVisible(15);
            return podcasttext.isDisplayed();             
        }
 
        public String getPodcastText() {
            return getDriver().findElement(byPodcastText).getText();                      
        }
 
        public void mouseHoverOnApssAppsAndDwnldSubMenu() {
             WebPageLoaded.isDomInteractive();
            WebElement appdwnldsubmenu = getDriver().findElement(byAppsAndDownloadsSubMenu);
            appdwnldsubmenu.syncVisible(15);
            appdwnldsubmenu.hover();
            }
 
        public boolean isAppAndDwnldSubMenuDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement appdwnldsubmenu = getDriver().findElement(byAppsAndDownloadsSubMenu);
            appdwnldsubmenu.syncVisible(15);
            return appdwnldsubmenu.isDisplayed();                   
        }
 
        public boolean isAppAndDwnldTextDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement awpremiumtext = getDriver().findElement(byAppsAndDownloadText);
            awpremiumtext.syncVisible(15);
            return awpremiumtext.isDisplayed();          
        }
 
        public void clickOnAppAndDwnldSubMenu() {
            getDriver().findElement(byAppsAndDownloadsSubMenu).click();                      
        }
 
        public String getAppAndDwnldText() {
            return getDriver().findElement(byAppsAndDownloadsSubMenu).getText();                      
        }
 
        public boolean isFacebookIconDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement fbicon = getDriver().findElement(byFacebookIcon);
            fbicon.syncVisible(15);
            return fbicon.isDisplayed();                  
        }
 
        public boolean isTwitterIconDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement twittericon = getDriver().findElement(byTwitterIcon);
            twittericon.syncVisible(15);
            return twittericon.isDisplayed();             
        }
 
        public boolean isInstagramIconDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement instagramicon = getDriver().findElement(byInstagramIcon);
            instagramicon.syncVisible(15);
            return instagramicon.isDisplayed();                     
        }
 
        public boolean isYoutubeIconDisplayed() {
             WebPageLoaded.isDomInteractive();
            WebElement youtubeicon = getDriver().findElement(byYoutubeIcon);
            youtubeicon.syncVisible(15);
            return youtubeicon.isDisplayed();             
        }
 
        public void clickOnTwitterIcon() {
            getDriver().findElement(byTwitterIcon).click();                      
        }
       
        /**
        * Method to click Radar Tab on secondary navigation [city forecast page]
        * @author Sowmiya
        * */
       public void clickRadarTabOnCityForecastPage()
       {
             WebPageLoaded.isDomInteractive();
             WebElement radarTabSecondaryNavigation = getDriver().findElement(byRadarTabSecondaryNavigation);
             radarTabSecondaryNavigation.syncVisible(15);
             radarTabSecondaryNavigation.jsClick();
             Sleeper.sleep(2);
       }
      
        /*
         * Method to get Video Sub Menu Description Text from Navigation Bar
         */
        public String getVideoSubMenuDescriptionText() {
            return getDriver().findElement(byVideoDescription).getText();
           // return getDriver().findElement(byVideoDescription).getText().substring(5,71).trim();                      
        }
 
        /*
         * Method to get Trending Now Sub Menu Description Text from Navigation Bar
         */
        public String getTredndingNowSubMenuDescriptionText() {
            return getDriver().findElement(byTrendingNowDescription).getText();                      
 
             //return getDriver().findElement(byTrendingNowDescription).getText().substring(12,57).trim();                      
        }
 
        /*
         * Method to get Storm Chasers Sub Menu Description Text from Navigation Bar
         */
        public String getStormChasersSubMenuDescriptionText() {
            return getDriver().findElement(byStormChasersDescription).getText();                      
            //return getDriver().findElement(byStormChasersDescription).getText().substring(13,48).trim();                      
        }
 
        /*
         * Method to get Expert Forecast Sub Menu Description Text from Navigation Bar
         */
        public String getExpertForecastSubMenuDescriptionText() {
            return getDriver().findElement(byExpertForecastDescription).getText().substring(15,49).trim();                      
        }
       
        public void switchToPopUpWindow(String defaultwindow) {
            
             Set<String> windows = getDriver().getWindowHandles();
             Iterator iterator = windows.iterator();
             String currentwindowId;
             while(iterator.hasNext()) {
             currentwindowId = iterator.next().toString();
                           if(!currentwindowId.equals(defaultwindow)) {
                    getDriver().switchTo().window(currentwindowId);
                   
             }
       }
            
    }
       
        public void locationSearch2Chars() {
         WebElement element = getDriver().findElement(bySuperSearch);
        getDriver().executeJavaScript("arguments[0].setAttribute('value', 'st')", element);
       }
       
        public void locationSearchWithoutChars() {
               WebElement element = getDriver().findElement(bySuperSearch);
               getDriver().executeJavaScript("arguments[0].setAttribute('value', '')", element);
              }
 
        public void enterlocationSearch() throws AWTException, InterruptedException  {
             Robot robot = new Robot();
             robot.keyPress(KeyEvent.VK_ENTER);
             WebPageLoaded.isDomComplete(2000);
             //Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            WebPageLoaded.isDomComplete(2000);
            //Thread.sleep(2000);
            
        }
       
        public void satelliteCitylocationSearch() {
         WebElement element = getDriver().findElement(bySuperSearch);
        getDriver().executeJavaScript("arguments[0].setAttribute('value', 'Rio de Janeiro, Rio De Janeiro, BR')", element);
        }
       
        /**
        * Method to verify city page has correct searched location
        * @author Sowmiya
        * return - String - city name
        * */
       public String verifyCityPageHasSearchedLocation()
       {
             WebPageLoaded.isDomInteractive();
             WebElement cityNameOnCityPage = getDriver().findElement(byCityNameOnCityPage);
             cityNameOnCityPage.syncVisible(15);
             return cityNameOnCityPage.getText();
       }
      
       /**
        * Method to get the description of RadarMaps submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Maps submenu contains description on city forecast page"
        * */
       public String getMapsSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement submenuMapsDescription = getDriver().findElement(byRadarMapsSubMenuDescription);
             submenuMapsDescription.syncVisible(30);
             return submenuMapsDescription.getText();     
       }
      
      
       /**
        * Method to get the description of Radar submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Radar submenu contains description on city forecast page"
        * */
       public String getRadarSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement submenuRadarDescription = getDriver().findElement(byRadarSubMenuDescription);
             submenuRadarDescription.syncVisible(30);
             return submenuRadarDescription.getText();    
       }
       
       /**
        * Method to get the description of Current conditions submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Radar submenu contains description on city forecast page"
        * */
       public String getCurrentConditionsSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement currentConditionsSubMenuDescription = getDriver().findElement(byCurrentConditionsSubMenuDescription);
             currentConditionsSubMenuDescription.syncVisible(30);
             return currentConditionsSubMenuDescription.getText();    
       }
 
       /**
        * Method  to get the description of Severe submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Severe submenu contains description present on city forecast page"
        * */
       public String getSevereSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement submenuSevereDescription = getDriver().findElement(bySevereSubMenuDescription);
             submenuSevereDescription.syncVisible(30);
             return submenuSevereDescription.getText();   
       }
 
       /**
        * Method  to get the description of Satellite submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Satellite submenu contains description present on city forecast page"
        * */
       public String getSatelliteSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement submenuSatelliteDescription = getDriver().findElement(bySatelliteSubMenuDescription);
             submenuSatelliteDescription.syncVisible(30);
             return submenuSatelliteDescription.getText();
       }
      
       /**
        * Method  to get the description of Forecast submenu.
        * @author Sowmiya
        * @return - Boolean value - "true if Forecast submenu contains description present on city forecast page"
        * */
       public String getForecastSubmenuDescription()
       {
             WebPageLoaded.isDomInteractive();
             WebElement submenuForecastDescription = getDriver().findElement(byForecastSubMenuDescription);
             submenuForecastDescription.syncVisible(30);
             return submenuForecastDescription.getText(); 
       }
      
       /**
        * Method  to verify satellite image is present, title of map and get the text of Satellite submenu description of the map.
        * @author Sowmiya
        * @return - Boolean value - "true if satellite image "
        * */
       public void verifySatelliteImageTitleDescription()
       {
             WebPageLoaded.isDomComplete();
             this.mouseHoverOnRadarAndMaps();
             WebElement satelliteImage = getDriver().findElement(bySatelliteImageSubMenu);
             satelliteImage.click();
             strMapUrl = getDriver().getCurrentUrl();
            
             //get title of map
             getDriver().navigate().back();
             this.mouseHoverOnRadarAndMaps();
             WebElement titleOfMap = getDriver().findElement(bySatelliteSubMenuMapTitle);
             titleOfMap.syncVisible(15);
             strMapTitle = titleOfMap.getText();
             titleOfMap.click();
             strMapTitleUrl = getDriver().getCurrentUrl();
            
             //get text of satellite image description
             getDriver().navigate().back();
             this.mouseHoverOnRadarAndMaps();
             WebElement submenuSatelliteMapDescription = getDriver().findElement(bySatelliteSubMenuMapDescription);
             submenuSatelliteMapDescription.syncVisible(15);
             strSatelliteMapDescription = submenuSatelliteMapDescription.getText();
             submenuSatelliteMapDescription.click();
             strMapDescriptionUrl = getDriver().getCurrentUrl();
            
       }
      
       /**
        * Method  to verify thumbnail below date under severe category.
        * @author Sowmiya
        * */
       public void verifyThumbnailBelowDateUnderSevereWeather()
       {
             WebPageLoaded.isDomComplete();
             //verify thumbnail
             this.mouseHoverOnSeverWeather();
             WebElement thumbnailUnderSevereWeather = getDriver().findElement(byThumbnailUnderSevereWeather);
             thumbnailUnderSevereWeather.syncVisible(15);
            getDriver().navigate().back();  
       }
      
       /**
        * Method  to get date and description of the map under news category.
        * @author Sowmiya
        * */
       public void getDateAndDescriptionOfMapUnderNewsCategory()
       {     
             //get title of date and year under news category
             WebElement date = getDriver().findElement(byDateUnderNewsCategory);
             date.syncVisible(15);
             strDateUnderNews = date.getText();
            
             //get text of map description under news category
             WebElement mapDescription = getDriver().findElement(byMapDescriptionUnderNews);
             mapDescription.syncVisible(15);
             strMapDescriptionUnderNews = mapDescription.getText();
       }
      
       /**
        * @author SOWMIYA
        * Method get the img data src of thumbnail under News category
        * @return data-src value
        * */
       public String getImgSrcThumbnailUnderSevereWeather()
       {
             WebElement thumbnailUnderSevereWeather = getDriver().findElement(byThumbnailUnderSevereWeather);
             thumbnailUnderSevereWeather.syncVisible(15);
             return thumbnailUnderSevereWeather.getAttribute("data-src");     
       }
      
       /**
        * @author SOWMIYA
        * Method to get the date below thumbnail under severe weather category
        * @return date
        * */
       public String getDateBelowThumbnailUnderSevereWeather()
       {
             //get date under severe weather
             WebElement strDateUnderSevereWeather = getDriver().findElement(byDateUnderSevereWeather);
             strDateUnderSevereWeather.syncVisible(30);
             return strDateUnderSevereWeather.getText();  
       }
      
       /**
        * @author SOWMIYA
        * Method to get the article title under severe weather category
        * @return article title
        * */
       public String getArticleTitleUnderSevereWeather()
       {
             //get article title under severe weather
             WebElement strArticleTitleUnderSevereWeather = getDriver().findElement(byArticleTitleUnderSevereWeather);
              strArticleTitleUnderSevereWeather.syncVisible(15);
             String getArticleTitleUnderSevereWeather = strArticleTitleUnderSevereWeather.getText();
             return getArticleTitleUnderSevereWeather;    
       }
      
       /**
        * @author SOWMIYA
        * Method to click on article title under severe weather and get URL
        * @return article title url
        * */
       public String getArticleTitleUrlUnderSevereWeather()
       {
             //click article title  under severe weather
             WebElement strArticleTitleUnderSevereWeather = getDriver().findElement(byArticleTitleUnderSevereWeather);
              strArticleTitleUnderSevereWeather.syncVisible(15);
             strArticleTitleUnderSevereWeather.click();
             Sleeper.sleep(2);
             return getDriver().getCurrentUrl();   
       }
      
       /**
        * @author SOWMIYA
        * Method get the img data src of thumbnail under News category
        * @return data-src value
        * */
       public String getImgSrcThumbnailUnderNews()
       {
             this.mouseHoverOnNews();
             WebElement thumbnailUnderNews = getDriver().findElement(byThumbnailUnderNews);
             thumbnailUnderNews.syncVisible(15);
             return thumbnailUnderNews.getAttribute("data-src");      
       }
      
       /**
        * @author SOWMIYA
        * Method to get the date below thumbnail under News category
        * @return date
        * */
       public String getDateBelowThumbnailUnderNews()
       {
             //get date under news
             WebElement strDateUnderNews = getDriver().findElement(byNewsArticleDate);
             strDateUnderNews.syncVisible(30);
             return strDateUnderNews.getText();    
       }
      
       /**
        * @author SOWMIYA
        * Method to get the article title under news category
        * @return article title
        * */
       public String getArticleTitleUnderNews()
       {
             //get article title under news
             WebElement strArticleTitleUnderNews = getDriver().findElement(byArticleTitleUnderNews);
             strArticleTitleUnderNews.syncVisible(15);
             String getArticleTitleUnderNews = strArticleTitleUnderNews.getText();
             return getArticleTitleUnderNews;      
       }
      
       /**
        * @author SOWMIYA
        * Method to click on article title under news and get URL
        * @return article title url
        * */
       public String getArticleTitleUrlUnderNews()
       {
             //click article title  under news
             WebElement strArticleTitleUnderNews = getDriver().findElement(byArticleTitleUnderNews);
             strArticleTitleUnderNews.syncVisible(15);
             strArticleTitleUnderNews.click();
             Sleeper.sleep(2);
             return getDriver().getCurrentUrl();
       }
      
       /**
        * @author SOWMIYA
        * Method get the img data src of thumbnail under Video category
        * @return data-src value
        * */
       public String getImgSrcThumbnailUnderVideo()
       {
             WebElement thumbnailUnderVideo = getDriver().findElement(byThumbnailUnderVideo);
             thumbnailUnderVideo.syncVisible(15);
             return thumbnailUnderVideo.getAttribute("data-src");      
       }
      
       /**
        * @author SOWMIYA
        * Method to convert the duration from API into MM:SS format
        * Method to get the duration below thumbnail under Video category
        * @return true - if both UI and API duration are same else false
        * */
       public Boolean getDurationBelowThumbnailUnderVideoAndCompareWithApiDuration(String durationFromAPI)
       {
           //convert API duration from seconds into MM:SS
           String apiSec = durationFromAPI;
                 int x = Integer.parseInt(apiSec);
              
               int p1 = x % 60;
               int p2 = x / 60;
               
               String getP1Value = String.valueOf(p1);
               String getP2Value = String.valueOf(p2);
             
               if( getP1Value.length()==1 ) {
                  getP1Value = "0"+getP1Value;
                 }
               
               String durationFromAPIinMtsAndSec = getP2Value + ":" + getP1Value;
            
             //get duration under video from UI
             WebElement strDurationUnderVideo = getDriver().findElement(byDurationUnderVideo);
             strDurationUnderVideo.syncVisible(30);
             String durationfromUI = strDurationUnderVideo.getText();
 
             return durationFromAPIinMtsAndSec.equalsIgnoreCase(durationfromUI);
       }
      
       /**
        * @author SOWMIYA
        * Method to get the article title under video category
        * @return article title
        * */
       public String getArticleTitleUnderVideo()
       {
             //get article title under video
             WebElement strArticleTitleUnderVideo = getDriver().findElement(byArticleTitleUnderVideo);
             strArticleTitleUnderVideo.syncVisible(15);
             String getArticleTitleUnderVideo = strArticleTitleUnderVideo.getText();
             return getArticleTitleUnderVideo;     
       }
      
       /**
        * @author SOWMIYA
        * Method to click on article title under video and get URL
        * @return article url
        * */
       public String getArticleTitleUrlUnderVideo()
       {
             //click article url under video
             WebElement strArticleUrlUnderVideo = getDriver().findElement(byArticleTitleUnderVideo);
             strArticleUrlUnderVideo.syncVisible(15);
             strArticleUrlUnderVideo.click();
             Sleeper.sleep(2);
             String window = getDriver().getWindowHandle();
             switchToDifferentTab(window);
             Sleeper.sleep(2);
             return getDriver().getCurrentUrl();
       }
}