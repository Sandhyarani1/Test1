package com.accuweather.glacier.www.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class LandingPage extends BasePage {

private By byZipCodeSearchBox = By.cssSelector("div.searchbar.featured-search > div.searchbar-content > form > input.search-input");
private By byZipCodeSearchIcon = By.cssSelector("div.searchbar.featured-search > div.searchbar-content > svg.icon-search.search-icon");
//private By byAllLocations = By.cssSelector("div.template-root > div.hero.page-hero.content-module.hero-5 > div.featured-locations > a");
private By byAllLocations = By.xpath("//body/div[1]/div[1]/div[4]/a[contains(@class,'recent-location-item featured-location')]");
private By byRecentLocation = By.cssSelector(".recent-location-item");
private By byRecentLocationName = By.cssSelector(".recent-location-name");
private By byCrumbLocationName = By.cssSelector("div.crumb:nth-child(5) > a:nth-child(1)");
private By byFirstLocation = By.cssSelector("div.template-root > div.hero.page-hero.content-module.hero-4 > div.featured-locations > a:nth-child(1)");
//private By bySecondLocation = By.cssSelector("div.template-root > div.hero.page-hero.content-module.hero-5 > div.featured-locations > a:nth-child(2)");
private By bySecondLocation = By.cssSelector("div.featured-locations > a:nth-child(2)");
//private By bySecondLocation = By.xpath("//body/div[1]/div[1]/div[4]/a[contains(@class,'recent-location-item featured-location')]");
private By byThirdLocation = By.cssSelector("div.featured-locations > a:nth-child(3)");
private By byCTATitle = By.cssSelector(".cta-title");
private By byVideo = By.xpath("//div[contains(@class,'video-player')]/div[contains(@id,'jw-container-yYI3lbdK-L6hCQGol')]");
//private By byVideo = By.xpath("//div[contains(@class,'video-player')]");
//private By byVideoAutoPlay = By.xpath("//div[contains(@class,'video-player')]/div[contains(@id,'jw-container-yYI3lbdK-L6hCQGol') and contains(@class,'jwplayer jw-reset jw-state')]");
private By byVideoAutoPlay = By.xpath("//div[contains(@aria-label,'Video Player')]");
//private By byVideoAutoPlay = By.xpath("//div[contains(@class,'video-player')]/div[contains(@id,'jw-container-yYI3lbdK-L6hCQGol')]");
private By byWeatherImage = By.cssSelector("div.two-column-page-content > div.page-column-1 > div > a > img");
private By byMoreMapsLink = By.cssSelector("div.two-column-page-content > div.page-column-1 > div > a > div.cta-text > div");
private By byMoreMapsIconLink = By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > a > div.cta-text > svg");

/*
 * Method to enter ZIPcode under ZipCode search field on the AccuWeather Landing page
 */
public void enterZipcodeInSearchField(String zip) {
	WebPageLoaded.isDomInteractive();
	WebElement zipcodetextfield = getDriver().findElement(byZipCodeSearchBox);
	zipcodetextfield.syncVisible(15);
	zipcodetextfield.hover();
	zipcodetextfield.sendKeys(zip);
	}

/*
 * Method to click ZIPcode Icon on the AccuWeather Landing page
 */
public void clickOnZipcodeSearchIcon() {
	WebPageLoaded.isDomInteractive();
	WebElement zipcodesearchicon = getDriver().findElement(byZipCodeSearchIcon);
	zipcodesearchicon.syncVisible(15);
	zipcodesearchicon.hover();
	zipcodesearchicon.click();
	}

/*
 * Method to enter ZIPcode under ZipCode search field on the AccuWeather Landing page
 */
public void enterZipcodeInSearchFieldAndClick(String zip) {
	WebPageLoaded.isDomInteractive();
	WebElement zipcodetextfield = getDriver().findElement(byZipCodeSearchBox);
	zipcodetextfield.syncVisible(15);
	zipcodetextfield.hover();
	zipcodetextfield.sendKeys(zip);
	zipcodetextfield.sendKeys(Keys.ENTER);
	Sleeper.sleep(8);
	}

/*
 * Method to get HREF Attribute of Recent Location on the AccuWeather Landing page
 */
public String getHrefAttributeOfRecentLocation() {
	WebPageLoaded.isDomInteractive();
	String attribute = getDriver().findElement(byRecentLocation).getAttribute("href");
	System.out.println("attribute attribute.... "+attribute);
	return attribute;
	}

/*
 * Method to get CTA Title on the AccuWeather Landing page
 */
public String getCTATitle() {
	WebPageLoaded.isDomInteractive();
	String ctatitle = getDriver().findElement(byCTATitle).getText();
	System.out.println("ctatitle ctatitle.... "+ctatitle);
	return ctatitle;
	}

/*
 * Method to verify Recent Location is displayed under Recent 
 * Locations section on Landing page
 */
public boolean isRecentLocationDisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement recentlocation = getDriver().findElement(byRecentLocation);
	recentlocation.syncVisible(15);
	return recentlocation.isDisplayed();
}

/*
 * Method to verify First Location is displayed under Recent 
 * Locations section on Landing page
 */
public boolean isFirstLocationDisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement firstlocation = getDriver().findElement(byFirstLocation);
	firstlocation.syncVisible(15);
	return firstlocation.isDisplayed();
}

/*
 * Method to verify Second Location is displayed under Recent 
 * Locations section on Landing page
 */
public boolean isSecondLocationDisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement secondlocation = getDriver().findElement(bySecondLocation);
	secondlocation.syncVisible(15);
	return secondlocation.isDisplayed();
}

/*
 * Method to verify Third Location is displayed under Recent 
 * Locations section on Landing page
 */
public boolean isThirdLocationDisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement thirdlocation = getDriver().findElement(byThirdLocation);
	thirdlocation.syncVisible(15);
	return thirdlocation.isDisplayed();
}

/*
 * Method to get size of all Locations
 * under Locations section on Landing page
 */
public int getAllLocationsSize() {
	WebPageLoaded.isDomInteractive();
	int alllocationssize = getDriver().findElements(byAllLocations).size();
	return alllocationssize;
}

/*
 * Method to get default location name under recent location on the AccuWeather Landing page
 */
public String getDefaultLocationName() {
	WebPageLoaded.isDomInteractive();
	String locationname = getDriver().findElement(byRecentLocationName).getText();
	System.out.println("locationname locationname.... "+locationname);
	return locationname;
	}

/*
 * Method to get location name under Bread Crumb on the AccuWeather Landing page
 */
public String getCrumbLocationName() {
	WebPageLoaded.isDomInteractive();
	String crumblocationname = getDriver().findElement(byCrumbLocationName).getText();
	System.out.println("crumblocationname crumblocationname.... "+crumblocationname);
	return crumblocationname;
	}

/*
 * Method to verify Video is AutoPlayed on the AccuWeather Landing page
 */
public boolean isVideoAutoPlayed() {
	WebPageLoaded.isDomInteractive();
	WebElement video = getDriver().findElement(byVideoAutoPlay);
	video.scrollIntoView();
	video.syncVisible(15);
	boolean videoautoplay = getDriver().findElement(byVideoAutoPlay).isEnabled();
	return videoautoplay;
	}

/*
 * Method to get class attribute value of Video on the AccuWeather Landing page
 */
public String getVideoClassAttribute() throws InterruptedException {
	WebPageLoaded.isDomInteractive();
	WebElement video = getDriver().findElement(byVideoAutoPlay);
	video.scrollIntoView(); 
	video.syncVisible(15); 
	video.hover(); 
	int xcoordinate = video.getCoordinates().onPage().x;
	System.out.println("xcoordinate xcoordinate... "+xcoordinate);
	int ycoordinate = video.getCoordinates().onPage().y;
	System.out.println("ycoordinate ycoordinate... "+ycoordinate);
	getDriver().actions().moveToElement(video, xcoordinate,ycoordinate).build().perform();
	getDriver().manage().timeouts().setScriptTimeout(250, TimeUnit.SECONDS);
	WebElement classattribute = getDriver().findElement(byVideoAutoPlay);
	getDriver().executeJavaScript("arguments[0].scrollIntoView(true);", classattribute);
	//getDriver().executeJavaScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	//WebPageLoaded.isJQueryComplete(); 
	String classattributes = getDriver().findElement(byVideoAutoPlay).getAttribute("class").substring(0, 35);
	System.out.println("classattributes classattributes..... "+classattributes);
	return classattributes;	
	}

/*
 * Method to get class attribute value of Sticky Video on the AccuWeather Landing page
 */
public String getStickyVideoClassAttribute() throws InterruptedException {
	WebPageLoaded.isDomInteractive();
	WebElement video = getDriver().findElement(byVideoAutoPlay);
	video.scrollIntoView(); 
	video.syncVisible(15); 
	video.hover(); 
	int xcoordinate = video.getCoordinates().onPage().x;
	System.out.println("xcoordinate xcoordinate... "+xcoordinate);
	int ycoordinate = video.getCoordinates().onPage().y;
	System.out.println("ycoordinate ycoordinate... "+ycoordinate);
	getDriver().actions().moveToElement(video, xcoordinate,ycoordinate).build().perform();
	getDriver().manage().timeouts().setScriptTimeout(500, TimeUnit.SECONDS);
	WebElement classattribute = getDriver().findElement(byVideoAutoPlay);
	getDriver().executeJavaScript("arguments[0].scrollIntoView(true);", classattribute);
	getDriver().executeJavaScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	//WebPageLoaded.isJQueryComplete(); 
	String classattributes = getDriver().findElement(byVideoAutoPlay).getAttribute("class").substring(0, 35);
	System.out.println("classattributes classattributes..... "+classattributes);
	return classattributes;	
	}

/*
 * Method to verify Weather Radar Image is displayed under Radar Section 
 * on Landing page
 */
public boolean isWeatherRadarImageDisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement weatherradarimage = getDriver().findElement(byWeatherImage);
	weatherradarimage.syncVisible(15);
	return weatherradarimage.isDisplayed();
}

/*
 * Method to verify More Maps Link is displayed under Radar Section 
 * on Landing page
 */
public boolean isMoreMapsLinkisplayed() {
	WebPageLoaded.isDomInteractive();
	WebElement moremaps = getDriver().findElement(byMoreMapsLink);
	moremaps.syncVisible(15);
	return moremaps.isDisplayed();
}

/*
 * Method to click More Maps Link under Radar Section 
 * on Landing page
 */
public void clickMoreMapsLink() {
	WebPageLoaded.isDomInteractive();
	WebElement moremapslink = getDriver().findElement(byMoreMapsLink);
	moremapslink.syncVisible(15);
	moremapslink.jsClick();
	}

/*
 * Method to click More Maps Icon Link under Radar Section 
 * on Landing page
 */
public void clickMoreMapsIconLink() {
	WebPageLoaded.isDomInteractive();
	WebElement moremapsiconlink = getDriver().findElement(byMoreMapsIconLink);
	moremapsiconlink.syncVisible(15);
	moremapsiconlink.click();
	}
}
