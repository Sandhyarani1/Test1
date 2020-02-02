package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class SevereWeatherPageIPAD extends MobileBasePage {
	Boolean flag;

	private By AWReadyHeader = By.cssSelector("div.page-column-1 > div");
	private By HurricaneTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(3)");
	private By SevereTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(4)");
	private By WinterWeatherTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(5)");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byHurricaneSecondaryTab = By.cssSelector("div.subnav-items > a:nth-child(1) > span");
	private By bySevereSecondaryTab = By.cssSelector("div.subnav-items > a.subnav-item.active");
	private By byMapBox = By.cssSelector("div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byINextToMapBox = By
			.cssSelector("div.mapboxgl-ctrl-bottom-left > div.mapboxgl-ctrl.mapboxgl-ctrl-attrib.mapboxgl-compact");
	private By byMapBoxOption = By.xpath("//div[@class='mapboxgl-ctrl-attrib-inner']/a[text()='© Mapbox']");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By byZoomIn = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byZoomOut = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
	
	private By bySevereWeather = By.cssSelector("div.main-menu > ul > li:nth-child(4)");
	private By byWinterWeatherSubMenu = By.xpath("//h4[contains(.,'Winter Weather')]");
	private By bySeverWeatherSubMenu = By.cssSelector("div.mega-menu > div > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a > h4");
	private By byHurricaneSubMenu = By.cssSelector("div > div:nth-child(2) > a > h4");
	private By byAWReadySubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(3) > a > h4");
	private By byTooltipNonActive = By.xpath("//div[@class='icon-tooltip']");
	private By byTooltipActive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
	private By byTooltipDescription = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
	private By byMapHeader = By.xpath("//h2[contains(text(),'United States Severe Weather Map')]");
	private By bySevereSecondaryTabColor = By
			.cssSelector("body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1");



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
	 * 
	 * @author MOHAMMED return Boolean value - true if hurricane and severe menus are
	 *         available else false
	 */
	public Boolean verifySecondaryNavigationMenus() {
		WebPageLoaded.isDomInteractive();
		WebElement hurricaneSecondaryTab = getDriver().findElement(byHurricaneSecondaryTab);
		WebElement severeSecondaryTab = getDriver().findElement(bySevereSecondaryTab);
		return getDriver().findElements(byHurricaneSecondaryTab).size()>0 && getDriver().findElements(bySevereSecondaryTab).size()>0;
	}

	/**
	 * Method to verify severe tab highlighted in orange color
	 * 
	 * @author MOHAMMED return Boolean value - color
	 */
	public String verifySevereTabHiglightedColor() {
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(bySevereSecondaryTabColor);
		getDriver().findElement(bySevereSecondaryTabColor).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1\")).borderBottomColor;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to verify mapbox and click i next to mapbox
	 * 
	 * @author MOHAMMED return Boolean value - true if hurricane and severe menus are
	 *         available else false
	 */
	public Boolean locateMapboxAndClickInextToit() {
		WebPageLoaded.isDomInteractive();
		WebElement mapBox = getDriver().findElement(byMapBox);
		WebElement iNextToMapBox = getDriver().findElement(byINextToMapBox);
		iNextToMapBox.click();
		WebElement mapBoxOption = getDriver().findElement(byMapBoxOption);
		return getDriver().findElements(byMapBoxOption).size() > 0;
	}

	/**
	 * Click full screen button of the map verify Map opens up into full screen with
	 * zoom controls if you click on x symbol the map switches back to normal
	 * 
	 * @author MOHAMMED Boolean return value - true if screen size decreased when the
	 *         close button is clicked on fullscreen
	 */
	public Boolean clickFullScreenButtonOfMap() {
		WebPageLoaded.isDomInteractive();
		WebElement map = getDriver().findElement(byMap);
		// get small screen width and height
		int smallScreenWidth = map.getSize().getWidth();
		int smallcreenHeight = map.getSize().getHeight();

		// click fullscreen button
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.click();

		// get fullscreen map width and height
		int afterFullScreenWidth = map.getSize().getWidth();
		int afterFullScreenHeight = map.getSize().getHeight();

		if (afterFullScreenWidth > smallScreenWidth && afterFullScreenHeight > smallcreenHeight) {
			// zoom in
			WebElement zoomIn = getDriver().findElement(byZoomIn);
			// zoom out
			WebElement zoomOut = getDriver().findElement(byZoomOut);

			// click 'x' at the top right corner
			WebElement closeButton = getDriver().findElement(byCloseButton);
			closeButton.click();
		}

		// again take small screen width and height and verify the width and height
		int screenWidth = map.getSize().getWidth();
		int screenHeight = map.getSize().getHeight();
		if (smallScreenWidth == screenWidth && smallcreenHeight == screenHeight)
			flag = true;
		else
			flag = false;

		return flag;
		
	}
	
	public void mouseHoverOnSeverWeather() {
		WebPageLoaded.isDomInteractive();
		WebElement severeweather = getDriver().findElement(bySevereWeather);
		severeweather.hover();
	}
	
	public boolean isSeverWeatherSubMenuDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(bySeverWeatherSubMenu).size()>0;
	}
	
	public boolean isHurricaneSubMenuDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byHurricaneSubMenu).size()>0;
	}
	
	public boolean isAWReadySubMenuDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byAWReadySubMenu).size()>0;
	}
	
	public void clickSeverWeatherSubMenu() {
		
		getDriver().findElement(bySeverWeatherSubMenu).click();
	}
	
	public String verifyTootipBackgroundColor() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().findElement(byTooltipNonActive).click();
		Sleeper.sleep(3);
		WebElement newsTab = getDriver().findElement(byTooltipActive);
		getDriver().findElement(byTooltipActive).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.map-severe.content-module > div > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).backgroundColor;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}
	
	/**
	 * Method to get tooltip description
	 * 
	 * @author MOHAMMED return tooltip description
	 */
	public String verifyTooltipDescription() {
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.click();
		WebElement tooltipDescription = getDriver().findElement(byTooltipDescription);
		String getTooltipDescription = tooltipDescription.getText();
		return getTooltipDescription;
	}
	
	/**
	 * Method to verify on click of tooltip again, the tooltip closes
	 * 
	 * @author MOHAMMED return tooltip color
	 */
	public String verifyToolTipClosed() {
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltipNonActive);
		toolTip.click();
		WebElement toolTipActive = getDriver().findElement(byTooltipActive);
		toolTipActive.click();
		WebPageLoaded.isDomInteractive();
		WebElement tootltipColor = getDriver().findElement(byTooltipNonActive);
		getDriver().findElement(byTooltipNonActive).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.map-severe.content-module > div > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).color;",
				tootltipColor);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}
	
	/**
	 * Method to get title of the map on map header
	 * @author MOHAMMED
	 * return map header text
	 * */
	public String getMapHeader()
	{
		WebPageLoaded.isDomInteractive();
		WebElement mapHeader = getDriver().findElement(byMapHeader);
		String mapHeaderText = mapHeader.getText();
		return mapHeaderText;
	}
	
	/**
	 * Method to click zoom in and zoom out of the map
	 * 
	 * @author MOHAMMED
	 */
	public boolean clickZoomInAndZoomOut() {
		WebPageLoaded.isDomInteractive();
		WebElement zoomIn = getDriver().findElement(byZoomIn);
		zoomIn.click();
		WebElement zoomOut = getDriver().findElement(byZoomOut);
		zoomOut.click();
		return true;
	}


}
