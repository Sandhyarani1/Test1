package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class NationalSevereWeatherPage extends BasePage {
	
	private By byTextAtBottomOfMap = By.cssSelector("div.map-container.full-mobile-width.severe-map-container > div.map-tools > div");
	private By byZoomInForMoreDetailsTextBottomOfMap = By.cssSelector("div.content-module > div.map-severe.content-module > div.severe-legend > div");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By bySevereWeatherTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(3)");
	private By byTitleOfMap = By.cssSelector("div.map-container.full-mobile-width.severe-map-container > div.map-header > h2");
	
	/**
	 * Method to verify text at the bottom of the map
	 * @author SOWMIYA
	 * @return - text at the bottom of the map
	 * */
	public String verifyTextAtBottomOfMap() {
		WebPageLoaded.isDomInteractive();
		WebElement textAtBottomOfMap = getDriver().findElement(byTextAtBottomOfMap);
		textAtBottomOfMap.syncVisible(15);
		return textAtBottomOfMap.getText();
	}	
	
	/**
	 * Method to verify text zoom in for more details at the bottom of the map
	 * @author SOWMIYA
	 * @return - text at the bottom of the map
	 * */
	public String verifyTextZoomInForMoreDetails() {
		WebPageLoaded.isDomInteractive();
		
		WebElement textAtBottomOfMap = getDriver().findElement(byZoomInForMoreDetailsTextBottomOfMap);
		textAtBottomOfMap.syncVisible(15);
		return textAtBottomOfMap.getText();
	}	
	
	/**
	 * Method to verify text at the bottom of the map in full screen of the map
	 * @author SOWMIYA
	 * @return - text at the bottom of the map
	 * */
	public String verifyTextAtBottomOfMapInFullScrenMode() {
		WebPageLoaded.isDomInteractive();
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.syncVisible(15);
		fullScreenBtn.click();
		WebElement textAtBottomOfMap = getDriver().findElement(byTextAtBottomOfMap);
		textAtBottomOfMap.syncVisible(15);
		return textAtBottomOfMap.getText();
	}	
	
	/**
	 * Method to close he map full screen and verify the map is back to default mode
	 * @author SOWMIYA
	 * @return - Boolean - true if severe weathertab is available 
	 * */
	public Boolean closeMapFullScreen() {
		WebPageLoaded.isDomInteractive();
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.syncVisible(15);
		fullScreenBtn.click();
		WebElement closeButton = getDriver().findElement(byCloseButton);
		closeButton.syncVisible();
		closeButton.click();
		WebElement severeWeatherTab = getDriver().findElement(bySevereWeatherTab);
		return severeWeatherTab.syncVisible(15);
	}
	
	/**
	 * Method to verify title of the map on severe weather page
	 * @author SOWMIYA
	 * @return - title of the map
	 * */
	public String verifyTitleOfTheMap() {
		WebPageLoaded.isDomInteractive();
		WebElement titleOfMap = getDriver().findElement(byTitleOfMap);
		titleOfMap.syncVisible(15);
		return titleOfMap.getText();
	}
}
