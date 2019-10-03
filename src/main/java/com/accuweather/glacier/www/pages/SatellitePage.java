package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class SatellitePage extends BasePage {
	private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	private By bymegaMenuSatellite = By.cssSelector("div.mega-menu > div > div:nth-child(4) > a > h4");
	private By bysatelliteTab = By
			.cssSelector("div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By bySatelliteTab = By.cssSelector("div > div.subnav-items > a:nth-child(2) > span");
	private By byEnhancedTab = By.cssSelector(" div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	private By byStandardTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(2)");
	private By byVisibleTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(3)");
	private By byWaterVaporTab = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(4)");
	private By byTitleofMap = By.cssSelector(" div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byTooltipText = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");

	private By byTooltipActive = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-header > div");
	private By byZoomcontrols = By.cssSelector("#map > div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left");
	private By byzoomInControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byzoomOutControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

	private By byMapboxattribution = By.cssSelector("div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byFullScreenButton = By.cssSelector("div.map-canvas.full-mobile-width > div.full-screen-button");
	private By byFullscreenVisble = By.cssSelector("div.map-canvas.full-mobile-width > div.full-screen-button");

	private By byTimelineControl = By.cssSelector("div.map-tools > div.timeline-controls");
	private By byPlaybutton = By.cssSelector("div.map-tools > div.timeline-controls > div.button-wrapper > div");
	private By byslider = By.cssSelector( "div.map-tools > div.timeline-controls > input");

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

	/**
	 * Method to click on City Satellite Page from Secondary Navigation menus
	 * @author sandhya.narayanarao
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
	 * @author sandhya.narayanarao
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
	 * Method to Validate Satellite Tab and Enchanced Tab Highlighted by default by orange color
	 * @author sandhya.narayanarao
	 * @return - Hex value of Satellite tab Top Border color
	 */

	public String satelliteTabHighlighted() {
		String tabColour = getDriver().findElement(bysatelliteTab).getCssValue("border-top");
		String boarderColor = tabColour.substring(10);
		return Color.fromString(boarderColor).asHex();
	}

	public String EnchancedTabHighlighted() {
		String tabColour = getDriver().findElement(byEnhancedTab).getCssValue("border-top");
		String boarderColor = tabColour.substring(10);
		return Color.fromString(boarderColor).asHex();

	}

	/**
	 * Method to Validate Tertiary navigation menus displayed on National satellite page
	 * @author sandhya.narayanarao
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
	 * @author sandhya.narayanarao
	 * @return Title of Map displayed
	 */
	public String getTitleofMap() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTitleofMap).getText();
	}

	/**
	 * Method to click on tertiary menus of National Satellite map
	 * @author sandhya.narayanarao
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
	 * @author sandhya.narayanarao
	 * 
	 */

	public boolean toolTipDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement tooltip = getDriver().findElement(byTooltip);
		tooltip.syncVisible(15);
		return tooltip.isDisplayed();
	}

	/**
	 * Method to Click on Tool Tip displayed at top right corner
	 * @author sandhya.narayanarao
	 * 
	 */

	public void clickOnToolTip() {
		WebElement tooltip = getDriver().findElement(byTooltip);
		tooltip.syncVisible(15);
		tooltip.jsClick();
	}

	/**
	 * Method to Click on Tool tip and Validate the text displayed on National Satellite map
	 * @author sandhya.narayanarao
	 * 
	 */
	public String toolTipTextdisplayed() {
		WebElement tooltip = getDriver().findElement(byTooltip);
		tooltip.syncVisible(60);
		return getDriver().findElement(byTooltipText).getText();
	}

	/**
	 * Method to validate Tooltip Highlighted in orange when Active
	 * @author sandhya.narayanarao
	 * @return Tooltip Hex value
	 * 
	 */
	public String toolTipActive() {
		String toolTipColor = getDriver().findElement(byTooltipActive).getCssValue("background-color");

		return Color.fromString(toolTipColor).asHex();

	}

	/**
	 * Method to validate Zoom control buttons displayed on satellite Map
	 * @author sandhya.narayanarao
	 * 
	 */
	public boolean zoomControlsDisplayedonTopLeftCorner() {
		return getDriver().findElement(byZoomcontrols).isDisplayed();
	}

	/**
	 * Method to ZoomIn Functionality on Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 */
	public void zoominControls() {
		for (int i = 0; i <= 5; i++) {

			WebElement zoomIn = getDriver().findElement(byzoomInControl);

			WebDriverWait wait = new WebDriverWait(getDriver(), 80000000);

			wait.until(ExpectedConditions.elementToBeClickable(zoomIn));

			zoomIn.jsClick();

			Sleeper.sleep(2);

			wait.until(ExpectedConditions.elementToBeClickable(zoomIn));

		}
	}

	/**
	 * Method to Zoom out on Functionality on Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 */

	public void zoomoutControls() {
		for (int i = 0; i <= 5; i++) {
			WebElement zoomOut = getDriver().findElement(byzoomOutControl);
			WebDriverWait wait = new WebDriverWait(getDriver(), 80000000);
			wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
			zoomOut.jsClick();
			Sleeper.sleep(2);
			wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
		}
	}

	/**
	 * Method to Validate Map Box atrribution of National Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 **/
	public boolean MapboxattributionDisplayedBottomLeft() {
		WebElement mapboxattribution = getDriver().findElement(byMapboxattribution);
		mapboxattribution.syncVisible(900);
		return mapboxattribution.isDisplayed();
	}

	public void ClickonMapboxattribution() {
		WebElement mapboxattribution = getDriver().findElement(byMapboxattribution);
		mapboxattribution.syncVisible(9000);
		mapboxattribution.jsClick();
	}

	/**
	 * Method to get the current url of the landing page redirected in New Tab
	 * @author sandhya.narayanarao
	 * @return String Landing page URL
	 * 
	 **/

	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
		WebPageLoaded.isDomComplete(8000000);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}

	/**
	 * Method to validate Full screen button displayed on Bottom Right corner of the Map
	 * @author sandhya.narayanarao
	 * 
	 */
	public boolean fullScreenButtonDisplayed() {
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenButton);
		fullScreenBtn.syncVisible(30);

		return fullScreenBtn.isDisplayed();
	}

	/**
	 * Method to validate Full screen button displayed on Bottom Right corner of the Map
	 * @author sandhya.narayanarao
	 * 
	 */
	public void clikonFullScreen() {
		getDriver().findElement(byFullscreenVisble).jsClick();
	}

	/**
	 * Method to validate Timeline controls ,Timeslider with play button and legends displayed
	 * @author sandhya.narayanarao
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
	 * Method to validate Timeline controls Slider with Pla butoon Legends and close button displayed on Fullscreen Satellite Map
	 * @author sandhya.narayanarao
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
		closeButton.syncVisible(90);
		closeButton.click();

		Sleeper.sleep(2);

		return timelineControl.isDisplayed() && slideBar.isDisplayed() && playButton.isDisplayed()
				&& legends.isDisplayed();

	}

	public String timeStampdisplayed() {
		WebElement timestamp = getDriver().findElement(bytimeStamp);
		WebDriverWait wait = new WebDriverWait(getDriver(), 800000);
		wait.until(ExpectedConditions.elementToBeClickable(timestamp));
		return timestamp.getText();

	}

	/**
	 * Method to Click on Play pause button displayed Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 */

	public void clickonPlayButton() {

		getDriver().findElement(byPlaybutton).jsClick();
	}

	public void clickonPauseButton() {
		getDriver().findElement(byPlaybutton).jsClick();
		Sleeper.sleep(2);
	}

	/**
	 * Method to validate text displayed for legend cloud for Enchanced Satellite Map
	 * @author sandhya.narayanarao
	 * @return - Boolean value - "true if Displayed else false"
	 */

	public boolean legendCloud_textLowandHigh_Displayed() {
		WebElement satelliteMap = getDriver().findElement(bySatelliteMap);
		satelliteMap.syncVisible(60);

		WebElement textLow = getDriver().findElement(bytextLow);
		textLow.syncVisible();

		WebElement textHigh = getDriver().findElement(bytextHigh);
		textHigh.syncVisible(30);

		return satelliteMap.isDisplayed() && textLow.isDisplayed() && textHigh.isDisplayed();
	}

	/**
	 * Method to validate text displayed for legend cloud for Visible Satellite Map
	 * @author sandhya.narayanarao
	 * @return - Boolean value - "true if Displayed else false"
	 * 
	 */

	public boolean legendClouds_with_text_ClearandClouds() {
		WebElement satelliteMap = getDriver().findElement(bySatelliteMap);
		satelliteMap.syncVisible(60);

		WebElement textClear = getDriver().findElement(bytextClear);
		textClear.syncVisible();

		WebElement textClouds = getDriver().findElement(bytextClouds);
		textClouds.syncVisible(30);

		return satelliteMap.isDisplayed() && textClear.isDisplayed() && textClouds.isDisplayed();
	}

	/**
	 * Method to validate text displayed for legend WaterVapor for WaterVapor Map
	 * @author sandhya.narayanarao
	 * @return - Boolean value - "true if Displayed else false"
	 * 
	 */

	public boolean legendWaterVapor_with_text_DryandMoist() {
		WebElement satelliteMap = getDriver().findElement(bySatelliteMap);
		satelliteMap.syncVisible(60);

		WebElement textDry = getDriver().findElement(bytextDry);
		textDry.syncVisible();

		WebElement textMoist = getDriver().findElement(bytextMoist);
		textMoist.syncVisible(30);

		return satelliteMap.isDisplayed() && textDry.isDisplayed() && textMoist.isDisplayed();
	}

	/**
	 * Method to validate Legend Cloud Displayed with various colors for Enhanced Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 **/
	public void coloursdisplayedforEnchacedSatelliteMap() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendClouds);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			WebDriverWait wait = new WebDriverWait(getDriver(), 80000);
			wait.until(ExpectedConditions.elementToBeClickable(bylegendClouds));
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key enhanced']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Cloud has following colors displayed for Enchanced Satellite Map" + list);

			}
		}
	}

	/**
	 * Method to validate Legend Clouds Displayed with various colors for Standard Satellite Map
	 * @author sandhya.narayanarao
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
	 * Method to validate Legend Cloud Displayed with various colors for Visible  Satellite Map
	 * @author sandhya.narayanarao
	 * 
	 **/
	public void colorsDisplayedforVisibleSatelliteMap() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendCloudsforVisbile);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(4);
			WebDriverWait wait = new WebDriverWait(getDriver(), 80000);
			wait.until(ExpectedConditions.elementToBeClickable(bylegendCloudsforVisbile));
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key visible']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Cloud has following colors displayed for Visible Satellite Map" + list);

			}
		}
	}

	/**
	 * Method to validate Legend WaterVapor Displayed with various colors
	 * @author sandhya.narayanarao
	 * 
	 **/
	public void colorsDisplayedforLegendWaterVapor() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendWaterVapor);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			WebDriverWait wait = new WebDriverWait(getDriver(), 80000);
			wait.until(ExpectedConditions.elementToBeClickable(bylegendWaterVapor));
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key waterVapor']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Cloud has following colors displayed for WaterVapor Satellite Map" + list);

			}
		}
	}
}

