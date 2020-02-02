package com.accuweather.glacier.www.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class NewsWeatherPage extends BasePage 
{
	private By byNewsTab = By.cssSelector("div > div > a.subnav-item.active");
	//private By byBroadcastersTab = By.cssSelector(".nav > li:nth-child(2) > a:nth-child(1)");
	private By byWeatherBlogTab = By.cssSelector("div > a.subnav-item.active");
	private By byBroadcastersTab = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[1]/ul/li[2]/a[contains(@title,'Broadcasters')]");
	private By byClimateChangesection = By.cssSelector("div.page-column-1 > div");
	
	private By byNews = By.xpath("//div[@class='subnav-items']/a/h1[contains(text(),'News')]");
	private By byVideos = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'Videos')]");
	private By byBlogs = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'BLOGS')]");
	private By byPersonalities = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'Personalities')]");
	private By byNewsTabColor = By.xpath("//div[@class='subnav-items']/a[1]");
	private By byLightrail = By.xpath("//div/div[@class='right-rail-newsfeed']");
	private By byLatestNewsBelowSecondaryNavigation = By.xpath("//div[@class='page-subnav']/following::div/p[contains(text(),'Latest Weather News')]");
	
	public boolean isNewsTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement NewsTab = getDriver().findElement(byNewsTab);
        NewsTab.syncVisible(15);
        return NewsTab.isEnabled();
	}

	public void isBroadCasterTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement BroadcastTab = getDriver().findElement(byBroadcastersTab);
        BroadcastTab.syncVisible(15);
        BroadcastTab.isEnabled();
	}

	public boolean isWeatherBlogTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement WeatherBlogTab = getDriver().findElement(byWeatherBlogTab);
        WeatherBlogTab.syncVisible(15);
        return WeatherBlogTab.isDisplayed();
	}

	public void isClimateChangeSectionEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement ClimateChangeSection = getDriver().findElement(byClimateChangesection);
        ClimateChangeSection.syncVisible(15);
        ClimateChangeSection.isDisplayed();
	}
	
	/**
	 * Check for secondary navigation menus News, Videos, Blogs, Personalities.
	 * @author SOWMIYA
	 * Boolean -if menu is available
	 * */
	public Boolean checkSecondaryNavigationMenu()
	{
		WebPageLoaded.isDomInteractive();
		WebElement news = getDriver().findElement(byNews);
		WebElement videos = getDriver().findElement(byVideos);
		WebElement blogs = getDriver().findElement(byBlogs);
		WebElement personalities = getDriver().findElement(byPersonalities);
        return news.syncVisible(15) && videos.syncVisible(15) && blogs.syncVisible(15) && personalities.syncVisible(15);
	}

	/**
	 * Verify News tab is highlighted in orange color.
	 * @author SOWMIYA
	 * Boolean - return New tab color
	 * */
	public String checkNewsTabIsHighkightedInColor()
	{
		WebPageLoaded.isDomInteractive();
		//news tab background color
		String colorNewsTab = getDriver().findElement(byNewsTabColor).getCssValue("border-top");
		String trimColorNewsTab = colorNewsTab.substring(10);
		String actualNewsTabColor = Color.fromString(trimColorNewsTab).asHex();
		return actualNewsTabColor;
	}
	
	/**
	 * Verify right rail is below the ad.
	 * @author SOWMIYA
	 * Boolean - return true if right rail is present
	 * */
	public Boolean locateRightRailOrganism()
	{
		WebPageLoaded.isDomInteractive();
		WebElement lightRail = getDriver().findElement(byLightrail);
		return lightRail.syncVisible(10);
	}
	
	/**
	 * Verify latest news below secondary navigation.
	 * @author SOWMIYA
	 * Boolean - return true if latest news present
	 * */
	public Boolean verifyLatestNewsPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement latestNews = getDriver().findElement(byLatestNewsBelowSecondaryNavigation);
		return latestNews.syncVisible(10);
	}
	
}
