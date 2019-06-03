package com.accuweather.glacier.www.pages;
import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class RadarWeatherPage extends BasePage 
{
	private By byRadarTab = By.cssSelector("div > div > a.subnav-item.active");
	private By byRadarTabValue = By.xpath("//div[contains(@id,'takeover-wrap')]/ul/li[1]/a");
	private By bySeverTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bySatelliteTab = By.cssSelector("div.subnav.secondary-nav.has-tertiary > div > a.subnav-item.active");
	private By byUSWeatherText = By.cssSelector(" div > div.map-header > h2");
	private By byUSMapCanvas = By.xpath("//div[contains(@id,'map')]/div[2]/canvas");
	
	public boolean isRadarTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement RadarTab = getDriver().findElement(byRadarTab);
        RadarTab.syncVisible(15);
        return RadarTab.isEnabled();
	}

	public boolean isSeverTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement SeverTab = getDriver().findElement(bySeverTab);
        SeverTab.syncVisible(15);
        return SeverTab.isEnabled();
	}

	public boolean isSatelliteTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement SatelliteTab = getDriver().findElement(bySatelliteTab);
        SatelliteTab.syncVisible(15);
        return SatelliteTab.isEnabled();
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

}
