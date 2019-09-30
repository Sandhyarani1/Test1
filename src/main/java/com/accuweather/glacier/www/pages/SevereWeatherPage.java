package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class SevereWeatherPage extends BasePage {
    Boolean flag;
   
	private By AWReadyHeader = By.cssSelector("div.page-column-1 > div");
	private By HurricaneTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(3)");
	private By SevereTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(4)");
	private By WinterWeatherTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(5)");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byHurricaneSecondaryTab = By.cssSelector("div.subnav-items > a:nth-child(1) > span");
	private By bySevereSecondaryTab = By.cssSelector("div.subnav-items > a.subnav-item.active");
	private By byMapBox = By.cssSelector("div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byINextToMapBox = By.cssSelector("div.mapboxgl-ctrl-bottom-left > div.mapboxgl-ctrl.mapboxgl-ctrl-attrib.mapboxgl-compact");
	private By byMapBoxOption = By.xpath("//div[@class='mapboxgl-ctrl-attrib-inner']/a[text()='© Mapbox']");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By byZoomIn = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byZoomOut = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

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
	
	/**
	 * Method to verify secondary navigation menus like hurricane, severe
	 * @author SOWMIYA
	 * return Boolean value - true if hurricane and severe menus are available else false
	 * */
	public Boolean verifySecondaryNavigationMenus()
	{
		WebPageLoaded.isDomInteractive();
		WebElement hurricaneSecondaryTab = getDriver().findElement(byHurricaneSecondaryTab);
		WebElement severeSecondaryTab = getDriver().findElement(bySevereSecondaryTab);
		
		return hurricaneSecondaryTab.syncVisible(10) && severeSecondaryTab.syncVisible(10);
	}
	
	/**
	 * Method to verify severe tab highlighted in orange color
	 * @author SOWMIYA
	 * return Boolean value - color
	 * */
	public String verifySevereTabHiglightedColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement severeSecondaryTab = getDriver().findElement(bySevereSecondaryTab);
		severeSecondaryTab.syncVisible(10);
		String colorTooltip = getDriver().findElement(bySevereSecondaryTab).getCssValue("border-top");
		String color = colorTooltip.substring(10);
		String actualcolourdisplayed = Color.fromString(color).asHex();
		return actualcolourdisplayed;
	}
	
	/**
	 * Method to verify mapbox and click i next to mapbox
	 * @author SOWMIYA
	 * return Boolean value - true if hurricane and severe menus are available else false
	 * */
	public Boolean locateMapboxAndClickInextToit()
	{
		WebPageLoaded.isDomInteractive();
		WebElement mapBox = getDriver().findElement(byMapBox);
		mapBox.syncVisible();
		WebElement iNextToMapBox = getDriver().findElement(byINextToMapBox);
		iNextToMapBox.syncVisible();
		iNextToMapBox.click();
		WebElement mapBoxOption = getDriver().findElement(byMapBoxOption);
		return mapBoxOption.syncVisible(15);
	}
	
	/**
	 * Click full screen button of the map
	 * verify Map opens up into full screen with zoom controls if you click on x symbol the map switches back to normal
	 * @author SOWMIYA
	 * Boolean return value - true if screen size decreased when the close button is clicked on fullscreen
	 * */
	public Boolean clickFullScreenButtonOfMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement map = getDriver().findElement(byMap);
		map.syncVisible();
		
		//get small screen width and height
		int smallScreenWidth = map.getSize().getWidth();
		int smallcreenHeight = map.getSize().getHeight();
		
		//click fullscreen button
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.jsClick();
		
		//get fullscreen map width and height
		int afterFullScreenWidth = map.getSize().getWidth();
		int afterFullScreenHeight = map.getSize().getHeight();
		
		if(afterFullScreenWidth > smallScreenWidth && afterFullScreenHeight > smallcreenHeight) {
			//zoom in
			WebElement zoomIn = getDriver().findElement(byZoomIn);
			zoomIn.syncVisible(10);
			//zoom out
			WebElement zoomOut = getDriver().findElement(byZoomOut);
			zoomOut.syncVisible(10);
			
			//click 'x' at the top right corner
			WebElement closeButton = getDriver().findElement(byCloseButton);
			closeButton.syncVisible();
			closeButton.click();
		}
		
		//again take small screen width and height and verify the width and height
		int screenWidth = map.getSize().getWidth();
		int screenHeight = map.getSize().getHeight();
		if(smallScreenWidth == screenWidth && smallcreenHeight == screenHeight)
			flag = true;
		else
			flag = false;
		
		return flag;
	}
}
