package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class RadarWeatherPage extends BasePage {

	private By byRadarTab = By.cssSelector("div > div > a.subnav-item.active");
	private By byRadarTabValue = By.xpath("//div[contains(@id,'takeover-wrap')]/ul/li[1]/a");
	private By bySatelliteTab = By.cssSelector("div.subnav.secondary-nav.has-tertiary > div > a.subnav-item.active");
	private By byUSWeatherText = By.cssSelector(" div > div.map-header > h2");
	private By byUSMapCanvas = By.xpath("//div[contains(@id,'map')]/div[2]/canvas");
	
	public void isRadarTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement RadarTab = getDriver().findElement(byRadarTab);
        RadarTab.syncVisible(15);
        RadarTab.isEnabled();
	}
	
	public void isSatelliteTabeEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement RadarTab = getDriver().findElement(bySatelliteTab);
        RadarTab.syncVisible(15);
        RadarTab.isEnabled();
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
