package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class NewsWeatherPage extends BasePage {
	
	private By byNewsTab = By.cssSelector("div > div > a.subnav-item.active");
	//private By byBroadcastersTab = By.cssSelector(".nav > li:nth-child(2) > a:nth-child(1)");
	private By byWeatherBlogTab = By.cssSelector("div > a.subnav-item.active");
	private By byBroadcastersTab = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[1]/ul/li[2]/a[contains(@title,'Broadcasters')]");
	private By byClimateChangesection = By.cssSelector("div.page-column-1 > div");
	
	public void isNewsTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement NewsTab = getDriver().findElement(byNewsTab);
        NewsTab.syncVisible(15);
        NewsTab.isEnabled();
	}
	
	public void isBroadCasterTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement BroadcastTab = getDriver().findElement(byBroadcastersTab);
        BroadcastTab.syncVisible(15);
        BroadcastTab.isEnabled();
	}
	
	public void isWeatherBlogTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement WeatherBlogTab = getDriver().findElement(byWeatherBlogTab);
        WeatherBlogTab.syncVisible(15);
        WeatherBlogTab.isDisplayed();
	}
	
	public void isClimateChangeSectionEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement ClimateChangeSection = getDriver().findElement(byClimateChangesection);
        ClimateChangeSection.syncVisible(15);
        ClimateChangeSection.isDisplayed();
	}
}
