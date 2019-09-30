package com.accuweather.glacier.m.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class SatellitePageMobile extends MobileBasePage {
	private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	private By bymegaMenuSatellite = By.cssSelector("div.mega-menu > div > div:nth-child(4) > a > h4");
	private By bysatelliteTab = By
			.cssSelector("div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By byEnhancedTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	private By byStandardTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(2)");
	private By byVisibleTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(3)");
	private By byWaterVaporTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(4)");
	private By byTitleofMap = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byTooltipText = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");

	private By byTooltipActive = By
			.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-header > div");
	private By byZoomcontrols = By.cssSelector("#map > div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left");
	private By byzoomInControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byzoomOutControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

	private By byMapboxattribution = By.cssSelector("div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byFullScreenButton = By.xpath("//div[@class='full-screen-button']");
	private By byFullscreenVisble = By.cssSelector("div.map-canvas.full-mobile-width > div.full-screen-button");

	private By byTimelineControl = By.cssSelector("div.map-tools > div.timeline-controls");
	private By byPlaybutton = By.cssSelector("div.map-tools > div.timeline-controls > div.button-wrapper > div");
	private By byslider = By.cssSelector("div.map-tools > div.timeline-controls > input");

	private By byLegendsDisplayedonfullScreenMap = By.cssSelector("div.map-tools > div.satellite-legend > div");
	private By byCloseButton = By.cssSelector("div.map-canvas.full-mobile-width > div.close-button > svg");

	private By bytimeStamp = By.cssSelector("div.map-tools > div.timeline-controls > div.time-stamp");
	private By bySatelliteMap = By.cssSelector("div.map-tools > div.satellite-legend > div > div.label");

	private By bytextLow = By.cssSelector("div.range-label > span:nth-child(1)");
	private By bytextHigh = By.cssSelector("div.range-label > span:nth-child(2)");

	private By bytextClear = By.cssSelector("div.range-label > span:nth-child(1)");
	private By bytextClouds = By.cssSelector("div > div.range-label > span:nth-child(2)");

	private By bytextDry = By.cssSelector("div.range-label > span:nth-child(1)");
	private By bytextMoist = By.cssSelector("div.range-label > span:nth-child(2)");

	private By bylegendClouds = By.xpath("//*[@class='key enhanced']//*[name()='rect']");
	private By bylegendCloudsforVisbile = By.xpath("//*[@class='key visible']//*[name()='rect']");
	private By bylegendWaterVapor = By.xpath("//*[@class='key waterVapor']//*[name()='rect']");
	private By byfeaturedSearchbar = By
			.cssSelector(" div.searchbar.featured-search > div.searchbar-content > form > input");

	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By byBreadCrumbMenuRadarAndMaps = By
			.cssSelector(".header-accordion > .accordion-item:nth-child(1) .accordion-item-header-content");
	private By byBreadCrumbMenuSatellite = By.xpath("//a[contains(text(),'Satellite')]");
	private By bySatelliteTab = By.cssSelector(
			"body > div > div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active > h1");

	/**
	 * Method to click on City Satellite Page from Secondary Navigation menus
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public void clickonSatelliteTab() {
		WebPageLoaded.isDomInteractive();
		WebElement satelliteTab = getDriver().findElement(bySatelliteTab);
		satelliteTab.syncVisible(30);
		satelliteTab.jsClick();
	}

	/**
	 * Method to Hover over megamenus and Select Satellite Tab
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public void mouseHoverOnRadarAndMaps() {
		WebPageLoaded.isDomInteractive();
		WebElement radarandmaps = getDriver().findElement(byRadarMaps);
		radarandmaps.syncVisible(15);
		radarandmaps.hover();
	}

	public void navigateToSatellite() {
		WebElement radarsubmenu = getDriver().findElement(bymegaMenuSatellite);
		radarsubmenu.syncVisible(9000);
		radarsubmenu.jsClick();

	}

	/**
	 * Method to Validate Satellite Tab and Enchanced Tab Highlighted by default by
	 * orange color
	 * 
	 * @author Mohammed Siddiq
	 * @return - Hex value of Satellite tab Top Border color
	 */

	public String satelliteTabHighlighted() {
		WebElement ele = getDriver().findElement(bysatelliteTab);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active\")).borderTopColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	public String EnchancedTabHighlighted() {

		WebElement ele = getDriver().findElement(byEnhancedTab);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active\")).borderBottomColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to Validate Tertiary navigation menus displayed on National satellite
	 * page
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/

	public boolean istertiarymenuhas(String link) {
		if (link.equalsIgnoreCase("Enchanced")) {
			WebPageLoaded.isDomInteractive();
			WebElement enhancedTab = getDriver().findElement(byEnhancedTab);
			enhancedTab.syncVisible(6000);
			return enhancedTab.isDisplayed();
		}

		if (link.equalsIgnoreCase("Standard")) {
			WebPageLoaded.isDomInteractive();
			WebElement standardTab = getDriver().findElement(byStandardTab);
			standardTab.syncVisible(6000);
			return standardTab.isDisplayed();
		}

		if (link.equalsIgnoreCase("Visible")) {
			WebPageLoaded.isDomInteractive();
			WebElement visibleTab = getDriver().findElement(byVisibleTab);
			visibleTab.syncVisible(6000);
			return visibleTab.isDisplayed();

		}
		if (link.equalsIgnoreCase("WaterVapor")) {
			WebPageLoaded.isDomInteractive();
			WebElement watervaporTab = getDriver().findElement(byWaterVaporTab);
			watervaporTab.syncVisible(6000);
			return watervaporTab.isDisplayed();
		}

		return false;
	}

	/**
	 * Method to get the Title of the National Satellite map
	 * 
	 * @author Mohammed Siddiq
	 * @return Title of Map displayed
	 */
	public String getTitleofMap() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTitleofMap).getText();
	}

	/**
	 * Method to click on tertiary menus of National Satellite map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public boolean clickOnTertiarymenus(String tabName) {
		if (tabName.equalsIgnoreCase("Standard")) {
			WebPageLoaded.isDomInteractive();
			WebElement standard = getDriver().findElement(byStandardTab);
			standard.jsClick();
		}

		if (tabName.equalsIgnoreCase("Visible")) {
			WebPageLoaded.isDomInteractive();
			WebElement visiblity = getDriver().findElement(byVisibleTab);
			visiblity.jsClick();
		}

		if (tabName.equalsIgnoreCase("WaterVapor")) {
			WebPageLoaded.isDomInteractive();
			WebElement watervapor = getDriver().findElement(byWaterVaporTab);
			watervapor.jsClick();
		}

		return false;
	}

	/**
	 * Method to validate Tool Tip displayed on Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public boolean toolTipDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement tooltip = getDriver().findElement(byTooltip);
		tooltip.syncVisible(15);
		return getDriver().findElements(byTooltip).size() > 0;
	}

	/**
	 * Method to Click on Tool Tip displayed at top right corner
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public void clickOnToolTip() {
		WebElement tooltip = getDriver().findElement(byTooltip);
		tooltip.jsClick();
	}

	/**
	 * Method to Click on Tool tip and Validate the text displayed on National
	 * Satellite map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public String toolTipTextdisplayed() {
		WebElement tooltip = getDriver().findElement(byTooltip);
		return getDriver().findElement(byTooltipText).getText();
	}

	/**
	 * Method to validate Tooltip Highlighted in orange when Active
	 * 
	 * @author Mohammed Siddiq
	 * @return Tooltip Hex value
	 * 
	 */
	public String toolTipActive() {
		WebElement ele = getDriver().findElement(byTooltipActive);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).backgroundColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Zoom control buttons displayed on satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public boolean zoomControlsDisplayedonTopLeftCorner() {
		return getDriver().findElement(byZoomcontrols).isDisplayed();
	}

	/**
	 * Method to ZoomIn Functionality on Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public void zoominControls() {
		for (int i = 0; i <= 5; i++) {

			WebElement zoomIn = getDriver().findElement(byzoomInControl);
			WebDriverWait wait = new WebDriverWait(getDriver(), 3);
			wait.until(ExpectedConditions.elementToBeClickable(zoomIn));
			zoomIn.click();
			Sleeper.sleep(2);
			wait.until(ExpectedConditions.elementToBeClickable(zoomIn));
		}
	}

	/**
	 * Method to Zoom out on Functionality on Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public void zoomoutControls() {
		for (int i = 0; i <= 5; i++) {
			WebElement zoomOut = getDriver().findElement(byzoomOutControl);
			WebDriverWait wait = new WebDriverWait(getDriver(), 3);
			wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
			zoomOut.click();
			Sleeper.sleep(2);
			wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
		}
	}

	/**
	 * Method to Validate Map Box atrribution of National Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public boolean MapboxattributionDisplayedBottomLeft() {
		getDriver().findElement(byMapboxattribution).scrollIntoView();
		return getDriver().findElements(byMapboxattribution).size() > 0;
	}

	public void ClickonMapboxattribution() {
		WebElement mapboxattribution = getDriver().findElement(byMapboxattribution);
		mapboxattribution.click();
	}

	/**
	 * Method to get the current url of the landing page redirected in New Tab
	 * 
	 * @author Mohammed Siddiq
	 * @return String Landing page URL
	 * 
	 **/

	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
		WebPageLoaded.isDomComplete(5);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}

	/**
	 * Method to validate Full screen button displayed on Bottom Right corner of the
	 * Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public boolean fullScreenButtonDisplayed() {
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenButton);
		fullScreenBtn.syncVisible(30);

		return getDriver().findElements(byFullScreenButton).size() > 0;
	}

	/**
	 * Method to validate Full screen button displayed on Bottom Right corner of the
	 * Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */
	public void clikonFullScreen() {
		getDriver().findElement(byFullscreenVisble).click();
	}

	/**
	 * Method to validate Timeline controls ,Timeslider with play button and legends
	 * displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return - Boolean value - "true if Displayed else false"
	 */

	public boolean validateTimeLineControlsliderwithPlayButtonandlegendsDisplayed() {
		// TimelineControl with Play button
		WebElement timelineControl = getDriver().findElement(byTimelineControl);
		timelineControl.syncVisible(40);

		// play button and slider bar
		WebElement slideBar = getDriver().findElement(byslider);
		WebElement playButton = getDriver().findElement(byPlaybutton);

		slideBar.syncVisible();
		playButton.syncVisible();

		// Legends Displayed
		WebElement legends = getDriver().findElement(byLegendsDisplayedonfullScreenMap);
		legends.syncVisible();

		return timelineControl.isDisplayed() && slideBar.isDisplayed() && playButton.isDisplayed()
				&& legends.isDisplayed();
	}

	/**
	 * Method to validate Timeline controls Slider with Pla butoon Legends and close
	 * button displayed on Fullscreen Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * @return - Boolean value - "true if Displayed else false"
	 * 
	 */

	public boolean validateFullscreenMap() {
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenButton);
		fullScreenBtn.jsClick();

		// TimelineControl with Play button
		WebElement timelineControl = getDriver().findElement(byTimelineControl);
		timelineControl.syncVisible(40);

		// play button and slider bar
		WebElement slideBar = getDriver().findElement(byslider);
		WebElement playButton = getDriver().findElement(byPlaybutton);

		slideBar.syncVisible();
		playButton.syncVisible();

		// Legends Displayed
		WebElement legends = getDriver().findElement(byLegendsDisplayedonfullScreenMap);
		legends.syncVisible();

		// click 'x' at the top right corner
		WebElement closeButton = getDriver().findElement(byCloseButton);
		closeButton.syncVisible(30);
		closeButton.click();

		Sleeper.sleep(2);

		return getDriver().findElements(byTimelineControl).size() > 0 && getDriver().findElements(byslider).size() > 0
				&& getDriver().findElements(byPlaybutton).size() > 0
				&& getDriver().findElements(byLegendsDisplayedonfullScreenMap).size() > 0;

	}

	public String timeStampdisplayed() {
		WebElement timestamp = getDriver().findElement(bytimeStamp);
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		return timestamp.getText();
	}

	/**
	 * Method to Click on Play pause button displayed Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 */

	public void clickonPlayButton() {

		getDriver().findElement(byPlaybutton).click();
	}

	public void clickonPauseButton() {
		getDriver().findElement(byPlaybutton).click();
		Sleeper.sleep(2);
	}

	/**
	 * Method to validate text displayed for legend cloud for Enchanced Satellite
	 * Map
	 * 
	 * @author Mohammed Siddiq
	 * @return - Boolean value - "true if Displayed else false"
	 */

	public boolean legendCloud_textLowandHigh_Displayed() {
		return getDriver().findElements(bySatelliteMap).size() > 0 && getDriver().findElements(bytextLow).size() > 0
				&& getDriver().findElements(bytextHigh).size() > 0;
	}

	/**
	 * Method to validate text displayed for legend cloud for Visible Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * @return - Boolean value - "true if Displayed else false"
	 * 
	 */

	public boolean legendClouds_with_text_ClearandClouds() {
		return getDriver().findElements(bySatelliteMap).size() > 0 && getDriver().findElements(bytextClear).size() > 0
				&& getDriver().findElements(bytextClouds).size() > 0;
	}

	/**
	 * Method to validate text displayed for legend WaterVapor for WaterVapor Map
	 * 
	 * @author Mohammed Siddiq
	 * @return - Boolean value - "true if Displayed else false"
	 * 
	 */

	public boolean legendWaterVapor_with_text_DryandMoist() {
		return getDriver().findElements(bySatelliteMap).size() > 0 && getDriver().findElements(bytextDry).size() > 0
				&& getDriver().findElements(bytextMoist).size() > 0;
	}

	/**
	 * Method to validate Legend Cloud Displayed with various colors for Enhanced
	 * Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void coloursdisplayedforEnchacedSatelliteMap() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendClouds);
		for (int j = 1; j <= childrenElements.size(); j++) {
			WebElement ele = null;
			String result = null;
			ele = getDriver().findElement(By.xpath("(//*[@class='key enhanced']//*[name()='rect'])[" + j + "]"));
			ele.syncVisible(3);
			result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > "
							+ "div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > "
							+ "div > svg > rect.c-" + j + "\")).fill;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			System.out.println("color displayed :" + Color.fromString(result).asHex());
		}
	}

	/**
	 * Method to validate Legend Clouds Displayed with various colors for Standard
	 * Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void coloursdisplayedforStandardSatelliteMap() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendClouds);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			WebDriverWait wait = new WebDriverWait(getDriver(), 80000);
			wait.until(ExpectedConditions.elementToBeClickable(bylegendClouds));
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key standard']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Cloud has following colors displayed for Standard Satellite Map" + list);

			}
		}
	}

	/**
	 * Method to validate Legend Cloud Displayed with various colors for Visible
	 * Satellite Map
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void colorsDisplayedforVisibleSatelliteMap() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendCloudsforVisbile);
		for (int j = 1; j <= childrenElements.size(); j++) {
			WebElement ele = null;
			String result = null;
			ele = getDriver()
					.findElement(By.xpath("//*[@class='key visible']//*[name()='rect' and @class='c-" + j + "']"));
			ele.syncVisible(3);
			result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-"
							+ j + "\")).fill;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
		}

	}

	/**
	 * Method to validate Legend WaterVapor Displayed with various colors
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void colorsDisplayedforLegendWaterVapor() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendWaterVapor);
		for (int j = 1; j <= childrenElements.size(); j++) {
			WebElement ele = null;
			String result = null;
			ele = getDriver()
					.findElement(By.xpath("//*[@class='key waterVapor']//*[name()='rect' and @class='c-" + j + "']"));
			ele.syncVisible(3);
			result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-"
							+ j + "\")).fill;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
		}

	}

	/**
	 * Method to search city by name
	 * 
	 **/
	public void searchCityByName(String cityName) {
		WebPageLoaded.isDomInteractive();
		WebElement searchBartextfield = getDriver().findElement(byfeaturedSearchbar);
		searchBartextfield.syncVisible(15);
		searchBartextfield.hover();
		searchBartextfield.sendKeys(cityName);
		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-results']//*")));
	}

	/**
	 * Method to find auto suggestions
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void selectCityByName() {
		getDriver().findElement(By.cssSelector("div.search-results > div:nth-child(2)")).click();
	}

	public Boolean clickBreadCrumbMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenu).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenu).click();
		return true;
	}

	public Boolean clickBreadCrumbMenuRadarAndMaps() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuRadarAndMaps).click();
		return true;
	}

	public Boolean clickbyBreadCrumbMenuSatellite() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuSatellite).scrollIntoView();
		getDriver().findElement(byBreadCrumbMenuSatellite).click();
		getDriver().findElement(bySatelliteTab).syncVisible();
		return true;
	}
}