package com.accuweather.glacier.m.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class CityRadarPageMobile extends MobileBasePage {

	Boolean flag;
	String[] expectedNavigationMenu = { "Now", "Radar", "MinuteCast", "Hourly", "Daily", "Month" };
	private By byRadarTab = By.cssSelector("div.subnav-container > div > div.subnav-items > a.subnav-item.active > h1");
	private By byBarsList = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > svg > rect");
	private By byLightMix = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div > span:nth-child(1)");
	private By bySeveremix = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div > span:nth-child(2)");
	private By byLightIce = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div > span:nth-child(1)");
	private By bySevereIce = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div > span:nth-child(2)");
	private By byLightSnow = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div > span:nth-child(1)");
	private By bySevereSnow = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div > span:nth-child(2)");
	private By bySlideBar = By.cssSelector("div.timeline-controls > input.slider");
	private By byPlayButton = By.xpath("//input[@class='slider']/../div/div[@class='play-toggle-button icon-play']");
	private By byTimeStamp = By.cssSelector(".time-stamp");
	private By byFutureCTA = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(3)");
	private By byFutureCTAIsActive = By
			.cssSelector("div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active");
	private By byPastCTA = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.toggle-container > div.map-button.is-active");
	private By byPastCTAIsActive = By
			.cssSelector("div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active");
	private By byPastCTABelowMap = By
			.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[2]");
	private By byFutureCTABelowMap = By
			.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[3]");
	private By byMapbox = By.cssSelector("mapboxgl-ctrl mapboxgl-ctrl-attrib mapboxgl-compact");
	private By byMapboxLink = By.xpath("//a[contains(text(),'© Mapbox')]");
	private By byOpenStreetMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(2)");
	private By byImproveThisMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(3)");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By byZoomIn = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byZoomOut = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byTooltipActive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
	private By byTooltipHeader = By
			.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-header > span");
	private By byTooltipDescription = By
			.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
	private By byRadarTabColor = By.cssSelector("div.subnav-items > a.subnav-item.active");
	private By byMapHeader = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byNavigationMenusList = By.cssSelector("div.subnav-items > a");
	private By byRadarNavigationMenu = By.cssSelector("div.subnav-items > a:nth-child(2)");

	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By byBreadCrumbMenuRadarAndMaps = By
			.cssSelector(".accordion-item:nth-child(1) .accordion-item-header-content");
	private By byBreadCrumbMenuRadar = By.cssSelector(".accordion-item:nth-child(1) a:nth-child(1)");

	private By byPastButton = By.cssSelector(".toggle-button");
	
	private By byBreadCrumbMenuMaps = By
			.cssSelector(".accordion-item:nth-child(1) .accordion-item-header-content");
	private By byBreadCrumbMenuSatellite = By.cssSelector(".accordion-item:nth-child(1) a:nth-child(1)");
	private By byBreadCrumbMenuSevere = By.cssSelector(".accordion-item:nth-child(1) a:nth-child(2)");
	
	private By bySevereTab = By.cssSelector("body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By byBreadCrumbTemperatureToggleMenu = By.cssSelector(".bar");
	
	public Boolean clickBreadcrumbTemperatureToggleMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbTemperatureToggleMenu).scrollIntoView();
		getDriver().findElement(byBreadCrumbTemperatureToggleMenu).click();
		Sleeper.sleep(4);
		return true;
	}
	
	public Boolean clickbyBreadCrumbMenuSatellite() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSatellite).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuSatellite).click();
		return true;
	}

	public Boolean clickBreadCrumbMenu() {
		WebPageLoaded.isDomInteractive();
	//	getDriver().findElement(byBreadCrumbMenu).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenu).jsClick();
		return true;
	}

	public Boolean clickbyBreadCrumbMenuSevere() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSevere).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuSevere).click();
		if (getDriver().findElements(bySevereTab).size() > 0)
			return true;
		else
			return false;
	}
	public Boolean clickBreadCrumbMenuRadarAndMaps() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).click();
		return true;
	}

	public Boolean clickbyBreadCrumbMenuRadar() {
		WebPageLoaded.isDomInteractive();
		//getDriver().findElement(byBreadCrumbMenuRadar).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuRadar).jsClick();
		//getDriver().findElement(byRadarTab).syncVisible();
		return true;
	}
	
	public Boolean clickBreadCrumbMenuMaps() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuMaps).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuMaps).click();
		return true;
	}

	/**
	 * Method to verify severe text below the Mix legend
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if light and severe link are present else
	 *         false"
	 */
	public Boolean verifyLightAndSeverFromMixLegend() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		//radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightMix);
		WebElement severe = getDriver().findElement(bySeveremix);
		//light.syncVisible();
		//severe.syncVisible();
		return getDriver().findElements(byLightMix).size()>0 && getDriver().findElements(bySeveremix).size()>0;
	}

	/**
	 * Method to verify color vary from light to dark
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if the color gradually increases from light
	 *         to dark else false"
	 */
	public Boolean verifyColorVaryFromLightToDark() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible(30);
		List<WebElement> listBars = getDriver().findElements(byBarsList);

		float colorLight = 0;
		for (int i = 2; i <= listBars.size(); i++) {
			String getPercentageOfEachKey = getDriver()
					.findElement(By.cssSelector(
							"div.map-tools > div.radar-legend > div:nth-child(4) > svg > rect:nth-child(" + i + ")"))
					.getAttribute("x");
			String percentage = getPercentageOfEachKey.substring(0, getPercentageOfEachKey.length() - 1);
			float colorDark = Float.parseFloat(percentage);
			if (colorDark > colorLight) {
				flag = true;
				colorLight = colorDark;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to verify severe text below the Ice legend
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if light and severe link are present else
	 *         false"
	 */
	public Boolean verifyLightAndSeverFromIceLegend() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		//radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightIce);
		WebElement severe = getDriver().findElement(bySevereIce);
		//light.syncVisible();
		//severe.syncVisible();
		return getDriver().findElements(byLightIce).size()>0 && getDriver().findElements(bySevereIce).size()>0;
	}

	/**
	 * Method to verify severe text below the snow legend
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if light and severe link are present else
	 *         false"
	 */
	public Boolean verifyLightAndSeverFromSnowLegend() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		//radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightSnow);
		WebElement severe = getDriver().findElement(bySevereSnow);
		//light.syncVisible();
		//severe.syncVisible();
		return getDriver().findElements(byLightSnow).size()>0 && getDriver().findElements(bySevereSnow).size()>0;
	}

	/**
	 * Method to verify presence of slide bar with play button and time at the end
	 * of the bar
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if slidebar, playbutton and timestamp are
	 *         present else false"
	 */
	public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement slideBar = getDriver().findElement(bySlideBar);
		WebElement playButton = getDriver().findElement(byPlayButton);
		WebElement timeStamp = getDriver().findElement(byTimeStamp);
		return getDriver().findElements(bySlideBar).size()>0 && getDriver().findElements(byPlayButton).size()>0 && getDriver().findElements(byTimeStamp).size()>0;
	}

	/**
	 * Method to toggle between past and future CTA
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if past and future cta is active depending on
	 *         what Cta is selected else false"
	 */
	public Boolean toggleBetweenPastAndFutureCTA() {

		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		// past cta
		getDriver().findElement(byPastButton).scrollIntoView();
		WebElement ctaPast = getDriver().findElement(byPastButton);
		ctaPast.jsClick();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement ctaPast2 = getDriver().findElement(byPastCTA);
		ctaPast2.jsClick();
		return true;
	}

	/**
	 * Method to verify timeline controls like Past and Future CTA below the map
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if past and future cta is below the map else
	 *         false"
	 */
	public Boolean verifyPastAndFutureCTABelowMap() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		//radarTab.syncVisible();
		// future cta
		WebElement pastCTABelowMap = getDriver().findElement(byPastCTABelowMap);
		WebElement futureCTABelowMap = getDriver().findElement(byFutureCTABelowMap);
		return getDriver().findElements(byPastCTABelowMap).size()>0 && getDriver().findElements(byFutureCTABelowMap).size()>0;
	}

	/**
	 * Method to verify PAST CTA highlighted by default on city Weather Radar page
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if past is active else false"
	 */
	public Boolean locatePastCTAHighlightedByDefault() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement ctaPastActive = getDriver().findElement(byPastButton);
		return getDriver().findElements(byPastButton).size()>0;
	}

	/**
	 * Method to click mapbox
	 * 
	 * @author Mohammed
	 */
	public void clickMapbox() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement mapbox = getDriver().findElement(byMapbox);
		Sleeper.sleep(3);
		WebElement mapboxlink = getDriver().findElement(byMapboxLink);
		mapboxlink.jsClick();
		System.out.println("clicked on mapbox link");
		Sleeper.sleep(3);
	}

	public void scrollPage() {
		WebPageLoaded.isDomInteractive();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	/**
	 * Method to click open street map
	 * 
	 * @author Mohammed
	 */
	public void clickOpenStreetMap() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement openStreetMap = getDriver().findElement(byOpenStreetMap);
		Sleeper.sleep(3);
		openStreetMap.jsClick();
		Sleeper.sleep(6);
	}
	
	

	/**
	 * Method to click improve this map
	 * 
	 * @author Mohammed
	 */
	public void clickImproveThisMap() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement maplink = getDriver().findElement(byMapbox);
		getDriver().executeJavaScript("seetest:client.click(\"NATIVE\", \"xpath=//*[@class='i-amphtml-fill-content i-amphtml-fit-text-content']\", 0, 1)");
		

		
		//getDriver().executeJavaScript("seetest:client.click(\"WEB\", \"class=mapboxgl-ctrl mapboxgl-ctrl-attrib mapboxgl-compact\", 0, 1");
		Sleeper.sleep(3);
		WebElement improveThisMap = getDriver().findElement(byImproveThisMap);
		Sleeper.sleep(3);
		getDriver().executeJavaScript("seetest:client.click(\"NATIVE\", \"xpath=//*[@text=Improve this map]\", 0, 1)");
		Sleeper.sleep(4);
	}

	/**
	 * Click full screen button of the map verify Map opens up into full screen with
	 * timeline controls, slider with play button, and legend and if you click on x
	 * symbol the map switches back to normal
	 * 
	 * @author Mohammed
	 */
	public Boolean clickFullScreenButtonOfMap() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement map = getDriver().findElement(byMap);
		map.syncVisible();

		// get small screen width and height
		int smallScreenWidth = map.getSize().getWidth();
		int smallcreenHeight = map.getSize().getHeight();

		// click fullscreen button
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.jsClick();
		// play button and slider bar
		WebElement slideBar = getDriver().findElement(bySlideBar);
		WebElement playButton = getDriver().findElement(byPlayButton);
		slideBar.syncVisible();
		playButton.syncVisible();
		// click 'x' at the top right corner
		WebElement closeButton = getDriver().findElement(byCloseButton);
		closeButton.syncVisible();
		return true;
	}

	/**
	 * Method to click zoom in and zoom out of the map
	 * 
	 * @author Mohammed
	 */
	public void clickZoomInAndZoomOut() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement zoomIn = getDriver().findElement(byZoomIn);
		zoomIn.jsClick();
		WebElement zoomOut = getDriver().findElement(byZoomOut);
		zoomOut.jsClick();
	}

	/**
	 * Method to verify tooltip background color in orange
	 * 
	 * @author Mohammed return tooltip color
	 */
	public String verifyTootipBackgroundColor() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible(5);
		WebElement toolTip = getDriver().findElement(byTooltip);
		//toolTip.syncVisible(5);
		toolTip.jsClick();
		WebElement ele = getDriver().findElement(byTooltipActive);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).backgroundColor;",
				ele);
		System.out.println("result > > > > " + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to verify tooltip background color in orange
	 * 
	 * @author Mohammed return tooltip header color
	 */
	public String verifyTootipHeaderBackgroundColor() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement toolTip = getDriver().findElement(byTooltip);
		//toolTip.syncVisible();
		toolTip.jsClick();
		WebElement ele = getDriver().findElement(byTooltipHeader);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > div > div.tooltip-overlay > div.tooltip-header > span\")).color;",
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
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement toolTip = getDriver().findElement(byTooltip);
		//toolTip.syncVisible();
		toolTip.jsClick();
		getDriver().findElement(byTooltipDescription).scrollIntoView();
		WebElement tooltipDescription = getDriver().findElement(byTooltipDescription);
		String getTooltipDescription = tooltipDescription.getText();
		return getTooltipDescription;
	}

	/**
	 * Method to get the radar tab boarder highlighted color
	 * 
	 * @author Mohammed return radar tab color
	 */
	public String verifyRadarTabHighlightedColor() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		getDriver().findElement(byRadarTabColor).scrollIntoView();
		WebElement ele = getDriver().findElement(byRadarTabColor);
		String radarBoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active\")).borderTop;",
				ele);
		System.out.println("result > > > > " + radarBoarderColor);
		String boarderColor = radarBoarderColor.substring(10);
		String actualColourdisplayed = Color.fromString(boarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to get title of the map on map header
	 * 
	 * @author Mohammed return map header text
	 */
	public String getMapHeader() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement mapHeader = getDriver().findElement(byMapHeader);
		String mapHeaderText = mapHeader.getText();
		return mapHeaderText;
	}

	/**
	 * Method to verify on click of tooltip again, the tooltip closes
	 * 
	 * @author Mohammed return tooltip color
	 */
	public String verifyToolTipClosed() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.syncVisible();
		toolTip.jsClick();
		WebElement toolTipActive = getDriver().findElement(byTooltipActive);
		toolTipActive.jsClick();
		getDriver().findElement(byTooltip).scrollIntoView();
		WebElement ele = getDriver().findElement(byTooltip);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > div > div.icon-tooltip\")).color;",
				ele);
		System.out.println("result > > > > " + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to verify the presence of navigation menu n city forecast page
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if navigation menu matches the expected one"
	 */
	public Boolean verifyPresenceOfNavigationMenus() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> navigationMenusList = getDriver().findElements(byNavigationMenusList);
		for (int i = 1; i <= navigationMenusList.size(); i++) {
			String actualNavigationMenu = getDriver()
					.findElement(By.cssSelector("div.subnav-items > a:nth-child(" + i + ")")).getText();
			if (actualNavigationMenu.equalsIgnoreCase(expectedNavigationMenu[i - 1])) {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to click radar navigation menu
	 * 
	 * @author Mohammed
	 */
	public void clickRadarNavigationMenu() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarNavigationMenu);
		radarTab.jsClick();
		Sleeper.sleep(3);
	}

	public void switchToPopUpWindow(String defaultwindow) {

		Set<String> windows = getDriver().getWindowHandles();
		Iterator iterator = windows.iterator();
		String currentwindowId;
		while (iterator.hasNext()) {
			currentwindowId = iterator.next().toString();
			if (!currentwindowId.equals(defaultwindow)) {
				getDriver().switchTo().window(currentwindowId);

			}
		}

	}
}
