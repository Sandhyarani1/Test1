package com.accuweather.glacier.m.pages;

	
	import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
	import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

	public class NationalSevereWeatherPageIOS extends MobileBasePage {
		
		private By byTextAtBottomOfMap = By.cssSelector("div.map-container.full-mobile-width.severe-map-container > div.map-tools > div");
		private By byZoomInForMoreDetailsTextBottomOfMap = By.cssSelector("div.content-module > div.map-severe.content-module > div.severe-legend > div");
		private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
		private By byCloseButton = By.cssSelector("div.close-button");
		private By bySevereWeatherTab = By.cssSelector("div.page-subnav > div > div > div > a:nth-child(3)");
		private By byTitleOfMap = By.cssSelector("div.map-container.full-mobile-width.severe-map-container > div.map-header > h2");
		
		private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
		private By byBreadCrumbMenuRadarAndMaps = By.cssSelector(".accordion-item:nth-child(1) .accordion-item-header-content");
		private By byBreadCrumbMenuSevereWeather = By.cssSelector(".accordion-item:nth-child(1) a:nth-child(2)");
		private By byRadarTab = By.cssSelector("div.subnav-container > div > div.subnav-items > a.subnav-item.active > h1");
		private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
		private By byTooltipActive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
		private By byTooltipDescription = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
		private By byZoomIn = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
		private By byZoomOut = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
		
		/**
		 * Method to click Bread Crumb Menu >> Radar and Maps >> Severe Weather
		 * 
		 * @author Mohammed Siddiq
		 * @return - boolean value
		 */
		
		public Boolean clickbyBreadCrumbMenuSevereWeather() {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byBreadCrumbMenuSevereWeather).jsClick();
			return true;
		}
		
		/**
		 * Method to click Bread Crumb Menu >> radar and Maps
		 * 
		 * @author Mohammed Siddiq
		 * @return - boolean value
		 */
		
		public Boolean clickBreadCrumbMenuRadarAndMaps() {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byBreadCrumbMenuRadarAndMaps).scrollIntoView();
			getDriver().findElement(byBreadCrumbMenuRadarAndMaps).click();
			return true;
		}
		
		/**
		 * Method to click Bread Crumb Menu
		 * 
		 * @author Mohammed Siddiq
		 * @return - boolean value
		 */

		public Boolean clickBreadCrumbMenu() {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byBreadCrumbMenu).jsClick();
			return true;
		}
		
		/**
		 * Method to verify text at the bottom of the map
		 * @author MOHAMMED SIDDIQ
		 * @return - text at the bottom of the map
		 * */
		public String verifyTextAtBottomOfMap() {
			WebPageLoaded.isDomInteractive();
			WebElement textAtBottomOfMap = getDriver().findElement(byTextAtBottomOfMap);
			return textAtBottomOfMap.getText();
		}	
		
		/**
		 * Method to verify text zoom in for more details at the bottom of the map
		 * @author MOHAMMED SIDDIQ
		 * @return - text at the bottom of the map
		 * */
		public String verifyTextZoomInForMoreDetails() {
			WebPageLoaded.isDomInteractive();
			WebElement textAtBottomOfMap = getDriver().findElement(byZoomInForMoreDetailsTextBottomOfMap);
			return textAtBottomOfMap.getText();
		}	
		
		/**
		 * Method to verify text at the bottom of the map in full screen of the map
		 * @author MOHAMMED SIDDIQ
		 * @return - text at the bottom of the map
		 * */
		public String verifyTextAtBottomOfMapInFullScrenMode() {
			WebPageLoaded.isDomInteractive();
			WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
			fullScreenBtn.click();
			Sleeper.sleep(1);
			WebElement textAtBottomOfMap = getDriver().findElement(byTextAtBottomOfMap);
			return textAtBottomOfMap.getText();
		}	
		
		/**
		 * Method to close he map full screen and verify the map is back to default mode
		 * @author MOHAMMED SIDDIQ
		 * @return - Boolean - true if severe weathertab is available 
		 * */
		public Boolean closeMapFullScreen() {
			WebPageLoaded.isDomInteractive();
			WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
			fullScreenBtn.click();
			Sleeper.sleep(1);
			WebElement closeButton = getDriver().findElement(byCloseButton);
			closeButton.click();
			Sleeper.sleep(1);
			return getDriver().findElements(bySevereWeatherTab).size()>0;
		}
		
		/**
		 * Method to verify title of the map on severe weather page
		 * @author MOHAMMED SIDDIQ
		 * @return - title of the map
		 * */
		public String verifyTitleOfTheMap() {
			WebPageLoaded.isDomInteractive();
			WebElement titleOfMap = getDriver().findElement(byTitleOfMap);
			return titleOfMap.getText();
		}
		
		/**
		 * Method to verify tooltip background color in orange
		 * 
		 * @author Mohammed return tooltip color
		 */
		public String verifyTootipBackgroundColor() {
			WebPageLoaded.isDomInteractive();
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.click();
			WebElement ele = getDriver().findElement(byTooltipActive);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div:nth-child(1) > div.map-severe.content-module > div > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).backgroundColor;",
					ele);
			System.out.println("result > > > > " + result);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		
		/**
		 * Method to get tooltip description
		 * 
		 * @author Mohammed return tooltip description
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
		 * @author Mohammed return tooltip color
		 */
		public String verifyToolTipClosed() {
			WebPageLoaded.isDomInteractive();
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.click();
			WebElement toolTipActive = getDriver().findElement(byTooltipActive);
			toolTipActive.click();
			getDriver().findElement(byTooltip).scrollIntoView();
			WebElement ele = getDriver().findElement(byTooltip);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div:nth-child(1) > div.map-severe.content-module > div > div.map-header > div > div.icon-tooltip\")).color;",
					ele);
			System.out.println("result > > > > " + result);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		

		/**
		 * Method to click zoom in and zoom out of the map
		 * 
		 * @author Mohammed
		 */
		public void clickZoomInAndZoomOut() {
			WebPageLoaded.isDomInteractive();
			WebElement zoomIn = getDriver().findElement(byZoomIn);
			zoomIn.click();
			WebElement zoomOut = getDriver().findElement(byZoomOut);
			zoomOut.click();
		}


}
