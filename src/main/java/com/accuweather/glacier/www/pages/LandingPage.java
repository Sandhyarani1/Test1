package com.accuweather.glacier.www.pages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.BannerAlertsAPI;
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
private By byMapTitle = By.cssSelector("div.page-column-1 > div.content-module > a > div.cta-title");
private By byAccuWeatherLogo = By.cssSelector("div.main-menu > div.logo-wrapper > div.icon-text > a:nth-child(1)");
private By bySearchList = By.cssSelector("div.search-bar-result.search-result");
private By centerWell1Title = By.cssSelector("div.content-module.zone-centerWell1 > a > div > div > div.featured-title");
private By centerWell1FeaturedDate = By.cssSelector("div.content-module.zone-centerWell1 > a > div > div > div.featured-date");
private By centerWell1VideoTitle = By.cssSelector("div.title-share > div.jw-title.jw-reset-text > div.jw-title-primary.jw-reset-text");
private By weatherNewsArticles = By.cssSelector("div.zone-centerWell2 > div > a");
private By showMoreButton = By.cssSelector("div.zone-centerWell2 > div > a.more-button > span.text");

public static final String SHOW_MORE = "SHOW MORE";
public static final String SHOW_LESS = "SHOW LESS";


/**
 * @author HFARAZ
 * Method to click on AccuWeather Logo at the top
 * */
public void clickAccuWeatherLogo()
{
	WebPageLoaded.isDomComplete();
	getDriver().findElement(byAccuWeatherLogo).click();
}

/**
 * @author HFARAZ
 * Method to select from the list of cities that comes when user type any city name in search bar on home page
 * */
public void selectCityFromTheList(String city)
{
	WebPageLoaded.isDomComplete();
	List<WebElement> cities = getDriver().findElements(bySearchList);
	
	for(int i=0;i<=cities.size();i++)
	{
		int j=i+1;
		String cityName = getDriver().findElement(By.cssSelector("div.search-results > div:nth-child("+j+")")).getText();
		if(cityName.equalsIgnoreCase(city))
		{
			getDriver().findElement(By.cssSelector("div.search-results > div:nth-child("+j+")")).click();
			break;
		}	  		  			  
	}
}


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
//	Sleeper.sleep(2);
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

/*
 * Method to click More Maps Icon Link under Radar Section 
 * on Landing page
 */
public String getMapTitleName() {
	WebPageLoaded.isDomInteractive();
	WebElement mapTitle = getDriver().findElement(byMapTitle);
	mapTitle.syncVisible(15);
	return mapTitle.getText();
	}

/************************************* Methods to deal with CenterWell 1 Contents*******************************/
/**
 * @author HFARAZ
 * Method to check if the title of content module is displayed
 * @return true if displayed else false
 * */
public Boolean isContentModuleTitleDisplayed()
{
	Boolean isContentModuleTitleDisplayed = false;
	WebPageLoaded.isDomComplete();
	scrollDown(800);
	WebPageLoaded.isDomComplete();
	try
	{
		if(getDriver().findElement(centerWell1Title).isDisplayed())
			isContentModuleTitleDisplayed = true;
	}
	catch(NoSuchElementException nsee)
	{
		isContentModuleTitleDisplayed = false;
		System.err.println(nsee.getMessage());
	}
	return isContentModuleTitleDisplayed;
}

/**
 * @author HFARAZ
 * Method to get the text of Content Module title
 * @return String value of content module title
 * */
public String getContentModuleTitle()
{
	if(isContentModuleTitleDisplayed().equals(true))
		return getDriver().findElement(centerWell1Title).getText();
	else
		return null;
}

/**
 * @author HFARAZ
 * Method to check if the date of content module is displayed
 * @return true if displayed else false
 * */
public Boolean isContentModuleDateDisplayed()
{
	Boolean isContentModuleDateDisplayed = false;
	WebPageLoaded.isDomComplete();
	try
	{
		if(getDriver().findElement(centerWell1FeaturedDate).isDisplayed())
			isContentModuleDateDisplayed = true;
	}
	catch(NoSuchElementException nsee)
	{
		isContentModuleDateDisplayed = false;
		System.err.println(nsee.getMessage());
	}
	return isContentModuleDateDisplayed;
}

/**
 * @author HFARAZ
 * Method to get the text of Content Module date
 * @return String value of content module date
 * */
public String getContentModuleDate()
{
	if(isContentModuleDateDisplayed().equals(true))
		return getDriver().findElement(centerWell1FeaturedDate).getText();
	else
		return null;
}

/**
 * @author HFARAZ
 * Method to check if the date of content module is displayed
 * @return true if displayed else false
 * */
public Boolean isCenterWell1VideoDisplayed()
{
	Boolean isCenterWell1Video = false;
	WebPageLoaded.isDomComplete();
	try
	{
		if(getDriver().findElement(centerWell1VideoTitle).isDisplayed())
			isCenterWell1Video = true;
	}
	catch(NoSuchElementException nsee)
	{
		isCenterWell1Video = false;
		System.err.println(nsee.getMessage());
	}
	return isCenterWell1Video;
}

/**
 * @author HFARAZ
 * Method to get the text of Content Module date
 * @return String value of content module date
 * */
public String getCenterWell1VideoTitle()
{
	if(isCenterWell1VideoDisplayed().equals(true))
		return getDriver().findElement(centerWell1VideoTitle).getText();
	else
		return null;
}

/**
 * @author HFARAZ
 * Method to check if the date of content module is displayed
 * @return true if displayed else false
 * */
public Boolean isWeatherNewsArticlesDisplayed()
{
	Boolean isWeatherArticleDisplayed = false;
	WebPageLoaded.isDomComplete();
	try
	{
		if(getDriver().findElement(weatherNewsArticles).isDisplayed())
			isWeatherArticleDisplayed = true;
	}
	catch(NoSuchElementException nsee)
	{
		isWeatherArticleDisplayed = false;
		System.err.println(nsee.getMessage());
	}
	return isWeatherArticleDisplayed;
}

/**
 * @author HFARAZ
 * Method to get the text of Content Module date
 * @return String value of content module date
 * */
public int getCountOfWeatherNewsArticles()
{
	 WebPageLoaded.isDomComplete();
	 scrollDown(100);
	 List<WebElement> weatherArticles = getDriver().findElements(weatherNewsArticles);
	 if(!weatherArticles.isEmpty())
		 return weatherArticles.size()-1;
	 else 
		 return 0;
}

/**
 * @author HFARAZ
 * Method to click 'SHOW MORE' button for Weather News
 * */
public void clickShowMore()
{
	WebPageLoaded.isDomComplete();
	scrollDown(800);
	WebPageLoaded.isDomComplete();
	while(getDriver().findElement(showMoreButton).getText().equalsIgnoreCase(SHOW_MORE))
	{
		scrollDown(200);
		WebPageLoaded.isDomComplete();
		getDriver().findElement(showMoreButton).jsClick();
	}
		
}

/**
 * @author HFARAZ
 * Method to read the titles of weather news articles
 * @return ArrayList of titles of all the weather news
 * */
public ArrayList readWeatherNewsTitles(int count)
{
	String window = "";
	ArrayList<String> weatherNewsTitles = new ArrayList<String>();
	WebPageLoaded.isDomComplete();
	
	for(int i=1;i<=count;i++)
	{
		if (i==1)
		{
			int j=i+1;
			if(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText().equalsIgnoreCase("VIDEO"))
			{
				getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-title > p")).jsClick();
					/*
					 * window = getDriver().getWindowHandle(); switchToDifferentTab(window);
					 */
				String parentWindow = getDriver().getWindowHandle();
				Set<String> setOfWindows = getDriver().getWindowHandles();
				Iterator<String> iterator = setOfWindows.iterator();
				while (iterator.hasNext())
				{
					String childWindow = iterator.next();
					if(!parentWindow.equals(childWindow))
					{
						getDriver().switchTo().window(childWindow);
						WebPageLoaded.isDomComplete();
						weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div > div.featured-video.featured-video > div.video-content > div.media-data > h1")).getText());
						getDriver().close();
					}
				}
				getDriver().switchTo().window(parentWindow);
				
			}
			else
			{
				getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-title > p")).jsClick();
				WebPageLoaded.isDomComplete();
				weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div.template-root > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.article.card.full-mobile-width.comments > h1.title.hasPartner")).getText());
				getDriver().navigate().back();
			}
		}
		else
		{
			int j=i+2;
			WebPageLoaded.isDomComplete();
			clickShowMore();
			if (getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText().equalsIgnoreCase("VIDEO"))
			{
				String parentWindow = getDriver().getWindowHandle();
				getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div > div.tout-title > p")).jsClick();
					/*
					 * window = getDriver().getWindowHandle(); switchToDifferentTab(window);
					 */
				Set<String> setOfWindows = getDriver().getWindowHandles();
				Iterator<String> iterator = setOfWindows.iterator();
				while (iterator.hasNext())
				{
					String childWindow = iterator.next();
					if(!parentWindow.equals(childWindow))
					{
						getDriver().switchTo().window(childWindow);
						WebPageLoaded.isDomComplete();
						weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div > div.featured-video.featured-video > div.video-content > div.media-data > h1")).getText());
						getDriver().close();
					}
				}
				getDriver().switchTo().window(parentWindow);
			}
			else
			{
				getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div > div.tout-title > p")).jsClick();
				weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div.template-root > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.article.card.full-mobile-width.comments > h1.title.hasPartner")).getText());
				getDriver().navigate().back();
			}
		}
		
		
	}
	return weatherNewsTitles;
	
}

/**
 * @author HFARAZ
 * Method to read the dates of weather news articles
 * @return ArrayList of dates of all the weather news
 * */
public ArrayList readWeatherNewsDate(int count)
{
	ArrayList<String> weatherNewsDates = new ArrayList<String>();
	WebPageLoaded.isDomComplete();
	for(int i=1;i<=count;i++)
	{
		if (i==1)
		{
			int j=i+1;
			weatherNewsDates.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-date")).getText());
		}
		else
		{
			int j=i+2;
			weatherNewsDates.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-date")).getText());
		}
		
	}
	return weatherNewsDates;
	
}

/**
 * @author HFARAZ
 * Method to read the types of weather news
 * @return ArrayList of types of all the weather news
 * */
public ArrayList readWeatherNewsType(int count)
{
	ArrayList<String> weatherNewsTypes = new ArrayList<String>();
	WebPageLoaded.isDomComplete();
	
	for(int i=1;i<=count;i++)
	{
		if (i==1)
		{
			int j=i+1;
			weatherNewsTypes.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText());
		}
		else
		{
			int j=i+2;
			weatherNewsTypes.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText());
		}
	}
	return weatherNewsTypes;
	
}

/**
 * @author HFARAZ
 * Method to read the titles of right rail articles
 * @return ArrayList of the titles of right rail articles
 * */
public ArrayList<String> getRightRailArticlesTitles(int count)
{
	ArrayList<String> rightRailArticlesTitle = new ArrayList<String>();
	WebPageLoaded.isDomComplete();
	for (int i=1;i<=count;i++)
	{
		try
		{
			if(getDriver().findElement(By.cssSelector("div.content-module.zone-rightRail1 > div > a:nth-child("+i+") > p.right-rail-article-title")).isDisplayed())
				rightRailArticlesTitle.add(getDriver().findElement(By.cssSelector("div.content-module.zone-rightRail1 > div > a:nth-child("+i+") > p.right-rail-article-title")).getText());
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
		}
		
	}
	return rightRailArticlesTitle;
}
}
