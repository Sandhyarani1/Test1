package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class VideoDetailsPage extends BasePage {
	
	private By byTrendingNowTab = By.cssSelector("nav > div > nav > ul > li.PageNavigation-items-item.active > a");
	private By byStormChasersTab = By.cssSelector("nav > div > nav > ul > li:nth-child(2) > a");
	private By byExpertForecastTab = By.cssSelector("nav > div > nav > ul > li:nth-child(3) > a");
	
	private By byplaceHolder = By.cssSelector("body > div.template-root.video-wall > div.page-content > div.placeholder.playing.content-module");

	public void isTrendingNowTabEnabled() {
		WebPageLoaded.isDomInteractive();
        //WebElement TrendingNowTab = getDriver().findElement(byTrendingNowTab);
		WebElement TrendingNowTab = getDriver().findElement(byplaceHolder);
        TrendingNowTab.syncVisible(15);
        TrendingNowTab.isDisplayed();
	}
	
	public void isStormChasersTabEnabled() {
		WebPageLoaded.isDomInteractive();
        //WebElement StormChasersTab = getDriver().findElement(byStormChasersTab);
        WebElement StormChasersTab = getDriver().findElement(byplaceHolder);
        StormChasersTab.syncVisible(15);
        StormChasersTab.isEnabled();
	}
	
	public void isExpertForecastsTabEnabled() {
		WebPageLoaded.isDomInteractive();
        //WebElement ExpertForecastsTab = getDriver().findElement(byExpertForecastTab);
        WebElement ExpertForecastsTab = getDriver().findElement(byplaceHolder);
        ExpertForecastsTab.syncVisible(15);
        ExpertForecastsTab.isEnabled();
	}
}
