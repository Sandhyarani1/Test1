package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class SevereWeatherPage extends BasePage {

	private By AWReadyHeader = By.cssSelector("div.page-column-1 > div");
	private By HurricaneTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(3)");
	private By SevereTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(4)");
	private By WinterWeatherTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(5)");
	
	public void isSevereTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement severetab = getDriver().findElement(SevereTab);
        severetab.syncVisible(15);
        severetab.isDisplayed();
	}
	
	public void isWinterWeatherTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement winterweathertab = getDriver().findElement(WinterWeatherTab);
        winterweathertab.syncVisible(15);
        winterweathertab.isDisplayed();
	}
	
	public void isHurricaneTabEnabled() {
		WebPageLoaded.isDomInteractive();
        WebElement hurricanetab = getDriver().findElement(HurricaneTab);
        hurricanetab.syncVisible(15);
        hurricanetab.isDisplayed();
	}
	
}
