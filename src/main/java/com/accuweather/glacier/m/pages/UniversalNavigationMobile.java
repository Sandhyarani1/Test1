package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.Sleeper;

public class UniversalNavigationMobile extends MobileBasePage {
	

	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By byBreadCrumbMenuRadarAndMaps = By.cssSelector(".header-accordion > .accordion-item:nth-child(1) .accordion-item-header-content");
	private By byBreadCrumbMenuRadar = By.cssSelector("//*[@text='Radar & Maps']");
	private By byBreadCrumbMenuSevere = By.xpath("//a[contains(text(),'Severe')]");
	private By byBreadCrumbMenuSatellite = By.xpath("//a[contains(text(),'Satellite')]");
	private By byBreadCrumbMenuWeatherNews = By.xpath("//a[contains(text(),'Weather News')]");
	private By byBreadCrumbMenuPersonalities = By.xpath("//a[contains(text(),'Personalities')]");
	private By byBreadCrumbMenuWeatherBlogs = By.xpath("//a[contains(text(),'Weather Blogs')]");
	private By byBreadCrumbMenuTrendingNow = By.xpath("//a[contains(text(),'Trending Now')]");
	private By byBreadCrumbMenuStormChasers = By.xpath("//a[contains(text(),'Storm Chasers')]");
	private By byBreadCrumbMenuExpertForecasts = By.xpath("//a[contains(text(),'Expert Forecasts')]");
	private By byBreadCrumbSubMenuSevereWeather = By.xpath("//a[contains(text(),'Severe Weather')]");
	private By byBreadCrumbSubMenuHurricane = By.xpath("//a[contains(text(),'Hurricane')]");
	private By byBreadCrumbSubMenuAccuWeatherReady = By.xpath("//a[contains(text(),'AccuWeather Ready')]");
	private By byBreadCrumbSubMenuAboutAccuWeather = By.xpath("//a[contains(text(),'About AccuWeather')]");
	private By byBreadCrumbSubMenuAppsAndDownloads = By.xpath("//a[contains(text(),'Apps & Downloads')]");
	private By byBreadCrumbSubMenuPodCasts = By.xpath("//a[contains(text(),'Podcast')]");
	private By byBreadCrumbSubMenuAccuWeatherPremium= By.xpath("//a[contains(text(),'AccuWeather Premium')]");
	private By byBreadCrumbSubMenuAccuWeatherProfessional= By.xpath("//a[contains(text(),'AccuWeather Professional')]");
	private By byBreadCrumbSubMenuAccuWeatherCoupons= By.xpath("//a[contains(text(),'Coupons')]");
	private By byBreadCrumbSubMenufacebookIcon= By.cssSelector(".icon-facebook path:nth-child(1)");
	private By byBreadCrumbSubMenuTwitterIcon= By.cssSelector(".icon-twitter path:nth-child(2)");
	private By byBreadCrumbSubMenuInstagramIcon= By.cssSelector(".icon-instagram");
	private By byBreadCrumbSubMenuYouTubeIcon= By.cssSelector("path:nth-child(4)");
	private By byTopSearch = By.cssSelector(".icon-search");
	private By byTopSearch2 = By.xpath("//input[@name='query']");
	private By byTopSearch3 = By.xpath("//a[contains(text(),'State College, PA, US')]");
	private By byTopSearchCloseIcon = By.cssSelector(".utility-bar-wrapper > .icon-close");
	private By byTopNavCTA = By.xpath("//span[contains(.,'Use Current Location')]");
	private By byTopNavNYCityImage = By.cssSelector(
			"div.mega-menu-search > div.content-column > div.popular-location.fade-in-left:nth-of-type(1) > img");

	
	
	

	private By byBreadCrumbMenuClimateChange = By.xpath("//a[contains(text(),'Climate Change')]");
	private By byBreadCrumbMenuNews = By.xpath("//span[contains(.,'NEWS')]");
	private By byBreadCrumbMenuVideo = By.xpath("//span[contains(.,'VIDEO')]");
	private By byBreadCrumbMenuSevereWeather = By.cssSelector(".header-accordion > .accordion-item:nth-child(4) .accordion-item-header-content");
	private By byBreadCrumbMenuMore = By.cssSelector(".header-accordion > .accordion-item:nth-child(5) .accordion-item-header-content");
	private By byBreadCrumbMenuSettings = By.cssSelector(".header-accordion > .accordion-item:nth-child(7) .accordion-item-header-content");
	private By byBreadCrumbMenuLanguageSettings = By.cssSelector(".dropdown-select:nth-child(2) select");
	private By byBreadCrumbMenuCountrySettings = By.cssSelector(".dropdown-select:nth-child(1) select");
	private By byBreadCrumbMenuTemperatureSettings = By.cssSelector(".bar");
	
	
	private By byRadarTab = By.cssSelector("div > div > a.subnav-item.active");
	private By byRadarTabValue = By.xpath("//div[contains(@id,'takeover-wrap')]/ul/li[1]/a");
	private By bySeverTab = By.cssSelector("body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bySatelliteTab = By.cssSelector("body > div > div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By byNewsTab = By.cssSelector("body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By byPersonalities = By.cssSelector("#left-nav > div:nth-child(1) > div > a");
	private By byWeatherBlogs = By.cssSelector("body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By byClimateChangePage = By.cssSelector("body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.zone-centerWell2 > div > p");
	private By byUSWeatherText = By.cssSelector(" div > div.map-header > h2");
	private By byUSMapCanvas = By.xpath("//div[contains(@id,'map')]/div[2]/canvas");
	
	

	public Boolean clickBreadCrumbMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenu).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenu).click();
		return true;
	}

	public Boolean BreadCrumbMenuRadarAndMapsIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).isDisplayed();
		return true;
	}

	
	public Boolean clickbyBreadCrumbMenuSevere() {
		WebPageLoaded.isDomInteractive();
		//getDriver().findElement(byBreadCrumbMenuSevere).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuSevere).click();
		return true;
	}
	
	
	public Boolean clickbyBreadCrumbMenuSatellite() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSatellite).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuWeatherNews() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuWeatherNews).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuPersonalities() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuPersonalities).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuWeatherBlogs() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuWeatherBlogs).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuTrendingNow() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuTrendingNow).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuStormChasers() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuStormChasers).click();
		return true;
	}
	
	
	public Boolean clickbyBreadCrumbMenuExpertForecasts() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuExpertForecasts).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuSevereWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuSevereWeather).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuHurricane() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuHurricane).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuAccuWeatherReady() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAccuWeatherReady).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuAboutAccuWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAboutAccuWeather).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuAppsAndDownloads() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAppsAndDownloads).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubMenuPodcasts() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuPodCasts).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubAccuWeatherPremium() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAccuWeatherPremium).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubAccuWeatherProfessional() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAccuWeatherProfessional).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubCoupons() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuAccuWeatherCoupons).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubFacebookIcon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenufacebookIcon).click();
		return true;
	}
	
	
	public Boolean clickbyBreadCrumbSubTwitterIcon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuTwitterIcon).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubInstagramIcon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuInstagramIcon).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbSubYouTubeIcon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbSubMenuYouTubeIcon).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuClimateChange() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuClimateChange).click();
		return true;
	}
	
	
	public Boolean clickbyBreadCrumbMenuNews() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuNews).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuVideo() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuVideo).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuSevereWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSevereWeather).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuMore() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuMore).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuSettings() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSettings).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuCountrySettings() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuCountrySettings).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuLanguageSettings() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuLanguageSettings).click();
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuTemperatureSettings() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byBreadCrumbMenuTemperatureSettings).size()>0;
	}
	
	
	
	public boolean isRadarTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement RadarTab = getDriver().findElement(byRadarTab);
        RadarTab.syncVisible(15);
        return RadarTab.isEnabled();
	}

	public boolean isSeverTabEnabled() {
        WebElement SeverTab = getDriver().findElement(bySeverTab);
        return getDriver().findElements(bySeverTab).size()>0;
	}

	public boolean isSatelliteTabEnabled() {
		WebPageLoaded.isDomInteractive();
        return getDriver().findElements(bySatelliteTab).size()>0;
	}
	
	public boolean isNewsTabEnabled() {
		WebPageLoaded.isDomInteractive();
        return getDriver().findElements(byNewsTab).size()>0;
	}
	
	public boolean isPersonalitiesTabEnabled() {
		WebPageLoaded.isDomInteractive();
        return getDriver().findElements(byPersonalities).size()>0;
	}
	
	public boolean isWeatherBlogsTabEnabled() {
		WebPageLoaded.isDomInteractive();
        return getDriver().findElements(byWeatherBlogs).size()>0;
	}
	
	public boolean isClimateChangeTabEnabled() {
		WebPageLoaded.isDomInteractive();
        return getDriver().findElements(byClimateChangePage).size()>0;
	}

	public void isUSWeatherTextDisplayed() {
		WebPageLoaded.isDomInteractive();
        WebElement USWeatherText = getDriver().findElement(byUSWeatherText);
        USWeatherText.syncVisible(15);
        USWeatherText.isDisplayed();
	}

	public void isUSMapCanvasDisplayed() {
		WebPageLoaded.isDomInteractive();
        WebElement USMapCanvas = getDriver().findElement(byUSMapCanvas);
        USMapCanvas.syncVisible(15);
        USMapCanvas.isDisplayed();
	}

	public void mouseHoverOnUSWeatherText() {
    	WebPageLoaded.isDomInteractive();
        WebElement usWeatherText = getDriver().findElement(byUSWeatherText);
        usWeatherText.syncVisible(15);
        usWeatherText.hover();
    }
	
	public Boolean clickBreadCrumbMenuRadarAndMaps() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).click();
		return true;
	}
	
	public boolean isStartSearchDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byTopSearch).size()>0;
		
	}
	
	public boolean isTopNavSearchIconclick() {
		WebPageLoaded.isDomInteractive();
		 getDriver().findElement(byTopSearch).click();
		return true;
	}
	
	public boolean isTopNavSearchIconclick2(String zip) {
		WebPageLoaded.isDomInteractive();
		 getDriver().findElement(byTopSearch2).click();
		 getDriver().findElement(byTopSearch2).sendKeys(zip);
		 Sleeper.sleep(3);
		 getDriver().findElement(byTopSearch3).click();
		return true;
	}
	
	public boolean isTopNavSearchCloseIconDisplayed() {
		WebPageLoaded.isDomInteractive();
		 getDriver().findElement(byTopSearch).click();
		 getDriver().findElement(byTopSearchCloseIcon).click();
		return true;
	}
	
	public boolean isTopNavCTATextDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byTopNavCTA).size()>0;
	}
	
	public boolean isTopNavNYCityImageDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebTextbox topnavcityimage = getDriver().findTextbox(byTopNavNYCityImage);
		topnavcityimage.syncVisible(15);
		return topnavcityimage.isDisplayed();
	}
	
	public void getLanguageListfromSettingsMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuLanguageSettings);
		Object languuageList = getDriver().executeJavaScript(("seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPicker']\", 0, 0)"));
	}

}


