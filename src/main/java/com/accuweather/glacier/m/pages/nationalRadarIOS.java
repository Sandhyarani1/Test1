package com.accuweather.glacier.m.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class nationalRadarIOS extends BasePage {
	private By byfeaturedSearchbar = By
			.cssSelector(" div.searchbar.featured-search > div.searchbar-content > form > input");
	private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	private By byRadarSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(2) > a > h4");
	private By bysecondarynavMenus = By.cssSelector("div > div.subnav-items");
	private By bysecondarRadarTab = By.cssSelector("div.subnav-items > a.subnav-item.active");
	private By bysecondarymenuRadar = By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	private By bysecondarymenuSatellite = By.cssSelector("div.subnav-items > a:nth-child(2) > span");
	private By bysecondarymenuSevere = By.cssSelector("div.subnav-items > a:nth-child(3) > span");
	private By bysecondarymenuForecast = By.cssSelector("div.subnav-items > a:nth-child(4) > span");

	private By byTitleofNationalRadarpage = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byTooltiponNationalRadarpage = By.cssSelector(
			"div.map-container.full-mobile-width.content-module > div.map-header > div > div.icon-tooltip");
	private By bytooltipactive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
	private By bytooltiptextDisplayed = By
			.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
	private By byMapboxattribution = By
			.cssSelector("div.mapboxgl-control-container >div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");

	private By byFullscreenbutton = By.cssSelector(
			"div.map-container.full-mobile-width.content-module > div.map-canvas.full-mobile-width > div.full-screen-button");
	private By byFullscreeTimelinecontrol = By.cssSelector(
			"div.map-container.full-mobile-width.content-module.full-screen > div.map-tools > div.radar-controls.timeline-container.is-full-screen");
	private By bylegendonfullscreen = By.cssSelector(
			"div.map-container.full-mobile-width.content-module.full-screen > div.map-tools > div.radar-legend");
	private By byclosebutton = By.cssSelector(
			"div.map-container.full-mobile-width.content-module.full-screen > div.map-canvas.full-mobile-width > div.close-button");

	private By byTimelinecontrols = By.cssSelector(
			"div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container");
	private By byPastCTA = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container > div.map-button.toggle-button");
	private By byFutureCTAdisplayed = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.toggle-container > div:nth-child(2)");

	private By byPastCTAdisplayedGreyed = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.toggle-container > div:nth-child(1)");
	private By bySliderwithPlaybutton = By.xpath("//div[@class='play-toggle-button icon-play']");
	private By bySliderwithPausebutton = By.xpath("//div[@class='play-toggle-button icon-pause']");
	private By byTimestampdisplayed = By.cssSelector(
			"div.map-tools > div.radar-controls.timeline-container > div.timeline-controls > div.time-stamp");

	private By byLegendRain = By.xpath("//div[contains(text(),'Rain')]");
	private By bylegendSnow = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.label");
	private By bylegendIce = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.label");
	private By byLegendMix = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div.label");

	private By bylegendRainColors = By.xpath("//*[@class='key rain']//*[name()='rect']");
	private By bylegendSnowColors = By.xpath("//*[@class='key snow']//*[name()='rect']");
	private By bylegendIceColors = By.xpath("//*[@class='key ice']//*[name()='rect']");
	private By bylegendMixColors = By.xpath("//*[@class='key mix']//*[name()='rect']");
	private By byRainlegendtextLight = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(1)");
	private By byRainlegendtextSevere = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(2)");

	private By bySnowlegendtextLight = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.range-label > span:nth-child(1)");
	private By bySnowlegendtextSevere = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.range-label > span:nth-child(2)");

	private By byIceLegendTextLight = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.range-label > span:nth-child(1)");
	private By byIceLegendTextSevere = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.range-label > span:nth-child(2)");

	private By byMixLegendTextLight = By
			.cssSelector(" div.map-tools > div.radar-legend > div:nth-child(4) > div.range-label > span:nth-child(1)");
	private By byMixLegendTextSevere = By
			.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div.range-label > span:nth-child(2)");

	private By byzoomControls = By.cssSelector("div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left");
	private By byzoomInControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byzoomOutControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

	/**
	 * @author Sandhya Rani Method to search city by its name from featured Search
	 *         bar
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
	 * @author Sandhya Rani Method to find auto suggestions and click on city
	 * 
	 */
	public void selectCityByName() {
		getDriver().findElement(By.cssSelector("div.search-results > div:nth-child(2)")).click();
	}

	/**
	 * @author Sandhya Rani Method to hover over top level navigation menus on
	 *         Homepage
	 * 
	 * 
	 **/

	public void mouseHoverOnRadarAndMaps() {
		WebPageLoaded.isDomInteractive();
		WebElement radarandmaps = getDriver().findElement(byRadarMaps);
		radarandmaps.syncVisible(15);
		radarandmaps.hover();
	}

	/**
	 * @author Sandhya Rani Method to hover over top level navigation menus on Radar
	 *         Maps and to select Radar
	 * 
	 * 
	 **/

	public void navigateToRadar() {

		WebElement radarsubmenu = getDriver().findElement(byRadarSubMenu);

		radarsubmenu.syncVisible(9000);

		radarsubmenu.jsClick();
	}

	/**
	 * @author Sandhya Rani Method to Validate Secondary menus are displayed
	 * 
	 **/

	public boolean Secondarynavigationmenusdisplayed() {
		getDriver().navigate().refresh();

		WebElement secondarymenus = getDriver().findElement(bysecondarynavMenus);

		return secondarymenus.isDisplayed();
	}

	/**
	 * Method to Validate Secondary navigation menus displayed on Radar page
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/

	public boolean validateSecondaryMenusDisplayed() {
		return getDriver().findElements(bysecondarymenuRadar).size() > 0
				&& getDriver().findElements(bysecondarymenuSatellite).size() > 0
				&& getDriver().findElements(bysecondarymenuSevere).size() > 0
				&& getDriver().findElements(bysecondarymenuForecast).size() > 0;
	}

	/**
	 * @author Sandhya Rani Method to Validated Radar Tab Highlighted by Default in
	 *         orange color at the border top
	 * @return String Hex color
	 * 
	 **/

	public String RadartabHighlightedinOrange() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(bysecondarRadarTab);
		getDriver().findElement(bysecondarRadarTab).scrollIntoView();
		String radarBoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active\")).borderTopColor;",
				radarTab);
		System.out.println("result > > > > " + radarBoarderColor);
		String actualColourdisplayed = Color.fromString(radarBoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * @author Sandhya Rani Method to Validated Title of National Radar Page
	 * @return Title of the page
	 * 
	 **/
	public String titleOfRadarMap() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);

		return getDriver().findElement(byTitleofNationalRadarpage).getText();
	}

	/**
	 * @author Sandhya Rani Method to Validated Tool Tip of National Radar Page
	 * 
	 **/

	public boolean tooltipDisplayedonNationalRadarpage() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		return getDriver().findElements(byTooltiponNationalRadarpage).size() > 0;

	}

	public void clickontooltipfromNationalRadarpage() {
		WebPageLoaded.isDomInteractive();
		WebElement tooltip = getDriver().findElement(byTooltiponNationalRadarpage);
		Sleeper.sleep(4);
		tooltip.jsClick();
	}

	public String colordisplayedwhenclickedonTooltip() {
		getDriver().findElement(byTooltiponNationalRadarpage).jsClick();
		;
		WebElement ele = getDriver().findElement(bytooltipactive);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > div > div.tooltip-overlay > div.tooltip-header > div\")).backgroundColor;",
				ele);
		System.out.println("result > > > > " + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	public String textdisplayedwhenclickedonTooltip() {
		getDriver().findElement(byTooltiponNationalRadarpage).jsClick();
		Sleeper.sleep(3);
		return getDriver().findElement(bytooltiptextDisplayed).getText();

	}

	/**
	 * @author Sandhya Rani Method to Validate and Click on Zoom Control buttons
	 *         displayed at Top left corner of Radar Map
	 * 
	 * 
	 **/

	public boolean zoomControlsDisplayedonTopLeftCorner() {
		return getDriver().findElement(byzoomControls).isDisplayed();
	}

	public void zoominControls() {
		for (int i = 0; i <= 5; i++) {
			WebElement zoomIn = getDriver().findElement(byzoomInControl);
			Sleeper.sleep(4);
			zoomIn.jsClick();
		}
	}

	public void zoomoutControls() {
		for (int i = 0; i <= 5; i++) {
			WebElement zoomOut = getDriver().findElement(byzoomOutControl);
			Sleeper.sleep(4);
			zoomOut.jsClick();
		}

	}

	/**
	 * @author Sandhya Rani Method to Validate Map Box atrribution of National Radar
	 *         Page
	 * 
	 * 
	 **/
	public boolean MapboxattributionDisplayedBottomLeft() {
		return getDriver().findElements(byMapboxattribution).size() > 0;
	}

	public void ClickonMapboxattribution() {
		WebElement mapboxattribution = getDriver().findElement(byMapboxattribution);
		mapboxattribution.jsClick();
	}

	/**
	 * @author Sandhya Rani Method to get the current url of the landing page in New
	 *         Tab
	 * 
	 * 
	 **/

	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
		Sleeper.sleep(2);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}

	/**
	 * @author Sandhya Rani Method to validate Full Screen of National Radar Page
	 * 
	 * 
	 **/

	public boolean fullScreenbuttonDisplayed() {
		return getDriver().findElement(byFullscreenbutton).isDisplayed();
	}

	public int fullScreenbuttonDisplayedatbottomRight() {
		System.out.println(
				"Full screen buttun height" + getDriver().findElement(byFullscreenbutton).getSize().getHeight());
		return getDriver().findElement(byFullscreenbutton).getSize().getHeight();
	}

	public void ClikonFullScreenButton() {
		WebElement fullscreenbutton = getDriver().findElement(byFullscreenbutton);
		Sleeper.sleep(5);
		fullscreenbutton.jsClick();
	}

	/**
	 * @author Sandhya Rani Method to validate Time line controls and legends
	 *         displayed on Full Screen of Radar Map
	 * 
	 * 
	 **/

	public boolean timelinecontrolsdisplayedonFullscreen() {
		return getDriver().findElements(byFullscreeTimelinecontrol).size() > 0;
	}

	public boolean legendsdisplayedonFullscreenRadarMap() {
		return getDriver().findElements(bylegendonfullscreen).size() > 0;
	}

	public void clickedonClosebuttonfromFullscreenRadarMap() {
		getDriver().findElement(byclosebutton).jsClick();
	}

	/**
	 * @author Sandhya Rani Method to validate Time line controls,legends,Slider
	 *         with play button displayed on Radar Map
	 * 
	 * 
	 **/

	public boolean timelinecontrolsdisplayedonRadarMap() {
		return getDriver().findElements(byTimelinecontrols).size() > 0;
	}

	public String PastCTAHighlightedbyDefaultonRadarMap() {
		WebElement ele = getDriver().findElement(byPastCTA);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active\")).backgroundColor;",
				ele);
		System.out.println("result > > > > " + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	public String FutureCtaNotHighlightedonRadarMap() {
		WebElement ele = getDriver().findElement(byFutureCTAdisplayed);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container > div:nth-child(3)\")).backgroundColor;",
				ele);
		System.out.println("result > > > > " + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	public void ClickonFutureCTAonRadarMap() {
		WebElement futureCta = getDriver().findElement(byFutureCTAdisplayed);
		Sleeper.sleep(3);
		futureCta.jsClick();
	}

	public void ClickonPastCTAonRadarMap() {
		Sleeper.sleep(5);
		getDriver().findElement(byPastCTA).jsClick();

	}

	public void ClickonPastCTAonRadarMapGreyed() {
		Sleeper.sleep(5);
		getDriver().findElement(byPastCTAdisplayedGreyed).jsClick();

	}

	public boolean SliderwithPlayButtonDisplayed() {
		return getDriver().findElements(bySliderwithPlaybutton).size() > 0;
	}

	public void clickonPlayButton() {
		WebElement playbutton = getDriver().findElement(bySliderwithPlaybutton);
		Sleeper.sleep(3);
		playbutton.jsClick();
	}

	public void clickonPauseButton() {
		WebElement playbutton = getDriver().findElement(bySliderwithPausebutton);
		Sleeper.sleep(3);
		playbutton.jsClick();
	}

	public String timestampdisplayed() {
		WebElement timestamp = getDriver().findElement(byTimestampdisplayed);
		Sleeper.sleep(3);
		return timestamp.getText();
	}

	/**
	 * @author Sandhya Rani Method to validate following Legends displayed
	 *         (Rain,Snow,Ice,Mix) displayed on Radar Map
	 * 
	 * 
	 **/

	public boolean isLegendDisplayedbelowRadarMap(String link) {
		if (link.equalsIgnoreCase("Rain")) {

			Sleeper.sleep(3);
			return getDriver().findElements(byLegendRain).size() > 0;
		}

		if (link.equalsIgnoreCase("Snow")) {
			Sleeper.sleep(3);
			return getDriver().findElements(bylegendSnow).size() > 0;
		}

		if (link.equalsIgnoreCase("Ice")) {
			Sleeper.sleep(3);
			return getDriver().findElements(bylegendIce).size() > 0;
		}
		if (link.equalsIgnoreCase("Mix")) {
			Sleeper.sleep(3);
			return getDriver().findElements(byLegendMix).size() > 0;
		}
		return false;
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Rain Displayed with Text Light
	 *         and Severe
	 * 
	 * 
	 **/

	public boolean RainlegendtextLightandSevereDisplayed() {
		return getDriver().findElements(byRainlegendtextLight).size() > 0
				&& getDriver().findElements(byRainlegendtextLight).size() > 0;
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Snow Displayed with Text Light
	 *         and Severe
	 * 
	 * 
	 **/

	public boolean legendSnowDisplayedwithTextLightandSevere() {
		return getDriver().findElements(bySnowlegendtextLight).size() > 0
				&& getDriver().findElements(bySnowlegendtextSevere).size() > 0;
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Ice Displayed with Text Light
	 *         and Severe
	 * 
	 * 
	 **/
	public boolean legendIceDisplayedwithTextLightandSevere() {
		return getDriver().findElements(byIceLegendTextLight).size() > 0
				&& getDriver().findElements(byIceLegendTextSevere).size() > 0;
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Mix Displayed with Text Light
	 *         and Severe
	 *
	 * 
	 **/
	public boolean legendMixDisplayedwithTextLightandSevere() {
		return getDriver().findElements(byMixLegendTextLight).size() > 0
				&& getDriver().findElements(byMixLegendTextSevere).size() > 0;
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Rain Displayed with various
	 *         colors
	 * 
	 * 
	 **/

	public void legendRaincoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendRainColors);

		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(2);
			Boolean value = getDriver()
					.findElements(By.xpath("//*[@class='key rain']//*[name()='rect' and @class='c-" + i + "']"))
					.size() > 0;
		}

	}

	/**
	 * @author Sandhya Rani Method to validate Legend Snow Displayed with various
	 *         colors
	 * 
	 **/

	public void legendSnowcoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendSnowColors);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(2);
			Boolean value = getDriver()
					.findElements(By.xpath("//*[@class='key snow']//*[name()='rect' and @class='c-" + i + "']"))
					.size() > 0;
		}
	}

	/**
	 * @author Sandhya Rani Method to validate Legend Ice Displayed with various
	 *         colors
	 * 
	 **/
	public void legendIcecoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendIceColors);

		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(2);
			Boolean value = getDriver()
					.findElements(By.xpath("//*[@class='key ice']//*[name()='rect' and @class='c-" + i + "']"))
					.size() > 0;
		}

	}

	/**
	 * @author Sandhya Rani Method to validate Legend Mix Displayed with various
	 *         colors
	 * 
	 **/
	public void legendMixcoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendMixColors);

		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			Boolean value = getDriver()
					.findElements(By.xpath("//*[@class='key mix']//*[name()='rect' and @class='c-" + i + "']"))
					.size() > 0;
		}

	}
}
