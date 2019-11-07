package com.accuweather.glacier.m.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;
import org.openqa.selenium.support.Color;

public class MinutecastpageIpad  extends MobileBasePage
{
	
	

	private By byfeaturedSearchbar = By
			.cssSelector(" div.searchbar.featured-search > div.searchbar-content > form > input");
	private By byminutecastTab = By.cssSelector("div > div.subnav-items > a:nth-child(3) > span");
	private By byradarMap = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-canvas.full-mobile-width");
	private By byradarMapTitle = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");

	private By byradaraMapToolTip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byradartooltipTitle = By.cssSelector("div.tooltip-overlay > div.tooltip-header > span");
	private By byradarmapTooltipText = By.cssSelector("div.tooltip-overlay > div.tooltip-content");
	private By byradarmapTooltipHeader = By.cssSelector("div.tooltip-overlay > div.tooltip-header > span");

	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byCloseButton = By.cssSelector("div.close-button");
	
	private By byFutureCTA=By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.toggle-container > div:nth-child(2)");
	private By byTimelinecontrols = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container");
	private By byPastButton = By.cssSelector(".toggle-button");
	
	private By bySlideBar = By.cssSelector("div.timeline-controls > input.slider");
	private By byPlayButton = By.xpath("//input[@class='slider']/../div/div[@class='play-toggle-button icon-play']");
	private By byTimeStamp = By.cssSelector(".time-stamp");
	
	private By bysecondarymenuRadar = By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	private By bysecondarymenuSatellite = By.cssSelector("div.subnav-items > a:nth-child(2) > span");
	private By bysecondarymenuSevere = By.cssSelector("div.subnav-items > a:nth-child(3) > span");
	private By bysecondarymenuForecast = By.cssSelector("div.subnav-items > a:nth-child(4) > span");
	private By byzoomInControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byzoomOutControl = By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

	private By byminutecastDial = By.cssSelector("div.content-module > div.minutecast-dial.content-module");
	private By byminutecastDialLargeWeatherDescription = By.cssSelector("div.minutecast-dial.content-module > p.title");
	private By byminutecastDialTimesatmp = By.cssSelector(" div.minutecast-dial.content-module > p.graphic-label.top");
	private By byminutecastDialWeathericon = By.cssSelector("div.minutecast-dial.content-module > div > div > img");
	private By byminutecastShotDescription = By.cssSelector("div.minutecast-dial.content-module > div > div > p");
	private By byminutecastDialUpdatedTime = By.cssSelector("div.minutecast-dial.content-module > p.update");

	private By bytimeStampmolecule = By.cssSelector("div.minutecast-minute-by-minute.content-module > div.timestamps");
	private By bytimeStampCurrentTime = By.cssSelector("div.timestamps > div:nth-child(1) > span");
	private By byTimeslotsdisplayed = By.xpath("//div[@class='timestamps']//div");
	
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
	
	private By byPastCTABelowMap = By.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[2]");
	private By byFutureCTABelowMap = By.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[3]");
	
	private By byCtaActive =By.cssSelector("div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active	");
	private By byFuturectaActive =By.cssSelector("div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active");
	
		
	private By bylegendRainColors = By.xpath("//*[@class='key rain']//*[name()='rect']");
	private By bylegendSnowColors = By.xpath("//*[@class='key snow']//*[name()='rect']");
	private By bylegendIceColors = By.xpath("//*[@class='key ice']//*[name()='rect']");
	private By bylegendMixColors = By.xpath("//*[@class='key mix']//*[name()='rect']");
	
	private By byPastCTA = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(2)");
	private By byFutureCTAdisplayed = By
			.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(3)");
	private By bySliderwithPlaybutton = By.xpath("//div[@class='play-toggle-button icon-play']");

	private By byMapbox = By.cssSelector(".mapboxgl-ctrl-attrib");
	private By byMapboxLink = By.xpath("//a[contains(text(),'© Mapbox')]");
	private By byOpenStreetMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(2)");
	private By byImproveThisMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(3)");
	
	
	
	
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
		Sleeper.sleep(5);
//		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-results']//*")));
	}

	/**
	 * @author Sandhya Rani Method to find auto suggestions and click on city
	 * 
	 */
	public void selectCityByName() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(2);
		getDriver().findElement(By.cssSelector("div.search-results > div:nth-child(2)")).click();
	}
	
	/**
	 * Method to Validate Secondary navigation menus displayed on Radar page
	 * @author sandhya.narayanarao
	 * 
	 **/
	
	public boolean validateSecondaryMenusDisplayed() {
		// Secondary menus has Radar Tab Displayed
		
		WebElement radarTab = getDriver().findElement(bysecondarymenuRadar);
		radarTab.syncVisible(60);

		// Secondary menus has Satellite Tab Displayed
		WebElement satelliteTab = getDriver().findElement(bysecondarymenuSatellite);
		satelliteTab.syncVisible(60);

		
		// Secondary menus has Severe Tab Displayed
		WebElement severeTab = getDriver().findElement(bysecondarymenuSevere);
		severeTab.syncVisible(60);
		
		// Secondary menus has Forecast Tab Displayed
		 WebElement forecastTab = getDriver().findElement(bysecondarymenuForecast);
		 forecastTab.syncVisible(60);

		return radarTab.isDisplayed() && satelliteTab.isDisplayed() && severeTab.isDisplayed()
				&& forecastTab.isDisplayed();
	}
	
	/**
	 * @author Sandhya Rani 
	 * Method to validate Minutecast Dial Displayed on Minutecast page and validate Large weather description,
	 *  Short weather description,Dial Timestamp,Dial weather icon and Dial Updated Time displayed 
	 * 
	 **/


	public boolean isminutecastDialDisplayed() {
		WebElement minutecastTabDial = getDriver().findElement(byminutecastDial);
		//minutecastTabDial.syncVisible(60);
		return minutecastTabDial.isDisplayed();
	}

	public String minutecastDialLargeWeatherDescriptionDisplayed() {
		WebElement minutecastDialLargeWeatherDescription = getDriver()
				.findElement(byminutecastDialLargeWeatherDescription);
		//minutecastDialLargeWeatherDescription.syncVisible(30);
		return minutecastDialLargeWeatherDescription.getText();
	}

	public String minutecastDialshortWeatherDescriptionDisplayed() {
		WebElement minutecastDialshortWeatherDescription = getDriver().findElement(byminutecastShotDescription);
		//minutecastDialshortWeatherDescription.syncVisible(30);
		return minutecastDialshortWeatherDescription.getText();
	}

	public String minutecastDialTimestampDisplayed() {
		WebElement minutecastDialLargeWeatherDescription = getDriver().findElement(byminutecastDialTimesatmp);
		//minutecastDialLargeWeatherDescription.syncVisible(30);
		return minutecastDialLargeWeatherDescription.getText();
	}

	public boolean minutecastDialWeathericonDisplayed()

	{
		WebElement weathericon = getDriver().findElement(byminutecastDialWeathericon);
		//weathericon.syncVisible(60);
		return weathericon.isDisplayed();
	}

	public String minutecastDialhasUpdatedTimeDisplayed()

	{
		WebElement updatedTime = getDriver().findElement(byminutecastDialUpdatedTime);
		//updatedTime.syncVisible(60);
		return updatedTime.getText();
	}

	
	
	/**
	 * @author Sandhya Rani 
	 * Method to validate Minutecast tab Displayed ,Highlighted by default and get the hex tab color
	 * 
	 * 
	 **/
	public void isNavigationtoMinutecastpage() {
		WebElement minutecastTab = getDriver().findElement(byminutecastTab);
		minutecastTab.syncVisible(30);
		minutecastTab.jsClick();
	}
	
	public String minutecastTabHighlighted() {
		String tabColour = getDriver().findElement(byminutecastTab).getCssValue("border-top");
		String boarderColor = tabColour.substring(10);
		return Color.fromString(boarderColor).asHex();
	}

	/**
	 * @author Sandhya Rani
	 * Method to Validte Radar map displayed and to validate  map title text , Tooltip displayed ,
	 *  validate default tooltip color displayed and active color when selected
	 *         
	 **/

	public boolean radarMapDisplayed() {
		WebElement radarMap = getDriver().findElement(byradarMap);
		return radarMap.isDisplayed();
	}

	public String radarMapTitle() {
		return getDriver().findElement(byradarMapTitle).getText();

	}


	public boolean TooltipDisplayedonRadarMap() {
		WebElement toolTip = getDriver().findElement(byradaraMapToolTip);
		toolTip.syncVisible(60);
		return toolTip.isDisplayed();

	}

	/**
	 * @author Sandhya Rani
	 * Method to Scroll down the Page 
	 *         
	 **/

	public void scrolldownpage() {
		getDriver().executeJavaScript("window.scrollBy(0,750)");
		Sleeper.sleep(3);
	}
	
	
	/**
	 * Method to ZoomIn Functionality on the  Map
	 * @author sandhya.narayanarao
	 * 
	 */
	public void zoominControls() {
		for (int i = 0; i <= 5; i++) {

			WebElement zoomIn = getDriver().findElement(byzoomInControl);
             Sleeper.sleep(3);
			zoomIn.jsClick();
			Sleeper.sleep(2);
		}
	}


	public void zoomoutControls() {
		for (int i = 0; i <= 5; i++) {
			WebElement zoomOut = getDriver().findElement(byzoomOutControl);
			Sleeper.sleep(3);
			
			zoomOut.jsClick();
			
			Sleeper.sleep(2);
	
		}
	}
	
	/**
	 * @author Sandhya Rani
	 * Method to  click on tooltip and get the text displayed on tooltip and the color displayed for tooltip header
	 *         
	 **/
	public void clickonTooltip() {
		getDriver().findElement(byradaraMapToolTip).jsClick();
		Sleeper.sleep(3);
	}

	public String tooltipTitleandText() {
		WebElement tooltipTitle = getDriver().findElement(byradartooltipTitle);
		tooltipTitle.syncVisible(50);
		return tooltipTitle.getText();
	}

	public String tooltipTextDisplayed() {
		WebElement tooltipText = getDriver().findElement(byradarmapTooltipText);
		return tooltipText.getText();
	}

	public String tooltipHeaderDisplayedColor() {
		String defaulTooltipColor = getDriver().findElement(byradarmapTooltipHeader).getCssValue("color");
		return Color.fromString(defaulTooltipColor).asHex();
	}

	
	/**
	 * @author Sandhya Rani
	 * Method to Validate Timestamp displayed below the Radar map and get the current time displayed in orange color
	 *         
	 **/

	public boolean timestampMolecuesDisplayed() {
		WebElement timeStamp = getDriver().findElement(bytimeStampmolecule);
		getDriver().findElement(bytimeStampmolecule).scrollIntoView();
		//return timeStamp.isDisplayed();
				
		return getDriver().findElements(bytimeStampmolecule).size() > 0;

	}

	public String timestampCurrentTimeinOrange() {
		String timeStampColor = getDriver().findElement(bytimeStampCurrentTime).getCssValue("color");
		return Color.fromString(timeStampColor).asHex();
	}

	/**
	 * @author Sandhya Rani
	 * Method to Validate Timestamp displayed below the Radar map 
	 * @return long Timestamp        
	 **/

	public long timeSlotsDisplayed() {
		List<org.openqa.selenium.WebElement> time = getDriver().findElements(byTimeslotsdisplayed);

		for (org.openqa.selenium.WebElement w : time) {
			System.out.println("Time Stamp molecules displayed " + w.getText());
		}

		String time1 = time.get(0).getText();
		String lastTime = time.get(time.size() - 1).getText();

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1;
		Date date2;

		try {
			date1 = format.parse(time1);
			date2 = format.parse(lastTime);
			return date2.getTime() - date1.getTime();

		} catch (ParseException e) {

			e.getMessage();
		}
		return 0;

	}
	
	/**
	 * @author Sandhya Rani
	 *  Method to validate each timestamp displayed and to Click on Each Timestamp molecule below the Radar map
	 *         
	 **/

	public void clickonEachtimestampMolecule() {
		List<org.openqa.selenium.WebElement> time = getDriver().findElements(byTimeslotsdisplayed);

		for (int i = 0; i < time.size(); i++) {
			time.get(i).isDisplayed();
			time.get(i).click();
			Sleeper.sleep(3);
		}

	}

	
	/**
	 * Method to verify timeline controls like Past and Future CTA below the map
	 * @author Sandhya Narayanarao
	 * @return - Boolean value - "true if past and future cta is below the map else false"
	 * */
	
	
	
	public Boolean verifyPastAndFutureCTABelowMap()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		
		return getDriver().findElements(byPastCTABelowMap).size() > 0  && getDriver().findElements(byFutureCTABelowMap).size() >0;

	}
	
	public boolean timelinecontrolsdisplayedonRadarMap() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		return getDriver().findElements(byTimelinecontrols).size() > 0;
	}
	/**
	 * Method to toggle between past and future CTA 
	 * @author Sandhya Narayanarao
	 * @return - Boolean value - "true if past and future cta is active depending on what Cta is selected else false"
	 * */
	public Boolean toggleBetweenPastAndFutureCTA()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement ctaFuture = getDriver().findElement(byFutureCTABelowMap);
		ctaFuture.syncVisible(40);
		ctaFuture.jsClick();
		WebElement ctaFutureActive = getDriver().findElement(byCtaActive);
		ctaFutureActive.syncVisible(15);
		//past cta
		WebElement ctaPast = getDriver().findElement(byPastCTABelowMap);
		ctaPast.jsClick();
		WebElement ctaPastActive = getDriver().findElement(byCtaActive);
		ctaPastActive.syncVisible(15);
		return ctaPastActive.syncVisible();
	}
	
	/**
	 * @author Sandhya Rani Method to validate Follwing legends  Displayed with Text Light
	 *         and Severe
	 *
	 * 
	 **/
	

	public boolean RainlegendtextLightandSevereDisplayed() {
		return getDriver().findElements(byRainlegendtextLight).size() > 0
				&& getDriver().findElements(byRainlegendtextSevere).size() > 0;
	}
	

	public boolean legendSnowDisplayedwithTextLightandSevere() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);

		getDriver().findElement(bySnowlegendtextLight).scrollIntoView();
		return getDriver().findElements(bySnowlegendtextLight).size() > 0
				&& getDriver().findElements(bySnowlegendtextSevere).size() > 0;
	}
	
	
	public boolean legendIceDisplayedwithTextLightandSevere() {
		return getDriver().findElements(byIceLegendTextLight).size() > 0
				&& getDriver().findElements(byIceLegendTextSevere).size() > 0;
	}

	
	public boolean legendMixDisplayedwithTextLightandSevere() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().findElement(byMixLegendTextLight).scrollIntoView();
		
		return getDriver().findElements(byMixLegendTextLight).size() > 0
				&& getDriver().findElements(byMixLegendTextSevere).size() > 0;
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

	public boolean SliderwithPlayButtonDisplayed() {
		return getDriver().findElements(bySliderwithPlaybutton).size() > 0;
	}


	/**
 * Method to verify color vary from light to dark for Legend Mix
 * 
 * @author Sandhya Narayanarao
 * @return - Boolean value - "true if the color gradually increases from light
 *         to dark else false"
 */
	
	
	public void legendRaincoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendRainColors);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key rain']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Rain has following colors displayed for the Map" + list);

			}
		}
	}
	/**
	 * @author Sandhya Rani 
	 * Method to validate Legend Snow Displayed with various colors
	 *         
	 * 
	 **/


	
	public void legendSnowcoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendSnowColors);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key snow']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Snow has following colors displayed for the Map" + list);

			}
		}
	}

	/**
	 * @author Sandhya Rani 
	 * Method to validate Legend Ice Displayed with various colors
	 *         
	 * 
	 **/


	public void legendIcecoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendIceColors);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key ice']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Ice has following colors displayed for the Map" + list);

			}
		}
	}
	/**
	 * @author Sandhya Rani 
	 * Method to validate Legend Mix Displayed with various colors
	 *         
	 * 
	 **/
	
	

	public void legendMixcoloursdisplayed() {
		List<WebElement> childrenElements = getDriver().findElements(bylegendMixColors);
		for (int i = 1; i <= childrenElements.size(); i++) {
			Sleeper.sleep(3);
			
			String colorDisplayed = getDriver()
					.findElement(By.xpath("//*[@class='key mix']//*[name()='rect' and @class='c-" + i + "']"))
					.getCssValue("fill");
			String colorinHex = Color.fromString(colorDisplayed).asHex();
			ArrayList<String> aList = new ArrayList<>();
			aList.add(colorinHex);
			for (String list : aList) {
				System.out.println("Legend Mix has following colors displayed for the Map" + list);

			}
		}
	}
	
	/**
	 * Method to verify presence of slide bar with play button and time at the end
	 * of the bar
	 * 
	 * @author Sandhya Narayanarao
	 * @return - Boolean value - "true if slidebar, playbutton and timestamp are
	 *         present else false"
	 */
	public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime() {
		WebPageLoaded.isDomInteractive();
	    Sleeper.sleep(3);
		WebElement slideBar = getDriver().findElement(bySlideBar);
		//slideBar.syncVisible(30);
		WebElement playButton = getDriver().findElement(byPlayButton);
		//playButton.syncVisible(30);
		WebElement timeStamp = getDriver().findElement(byTimeStamp);
		//timeStamp.syncVisible(30);
		return getDriver().findElements(bySlideBar).size()>0 && getDriver().findElements(byPlayButton).size()>0 && getDriver().findElements(byTimeStamp).size()>0;
	}

	
	/**
	 * @author Sandhya Rani
	 * Method to Validte Radar map displayed and to validate  map title text , Tooltip displayed ,
	 *  validate default tooltip color displayed and active color when selected
	 *         
	 **/


	public Boolean clickingonFullScreenButtonValidtaingFunctions() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement map = getDriver().findElement(byMap);
		map.syncVisible();

		// click fullscreen button
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.jsClick();
		// play button and slider bar
		WebElement slideBar = getDriver().findElement(bySlideBar);
		WebElement playButton = getDriver().findElement(byPlayButton);
		//slideBar.syncVisible();
		//playButton.syncVisible();
		// click 'x' at the top right corner
		WebElement closeButton = getDriver().findElement(byCloseButton);
		//closeButton.syncVisible();
		return getDriver().findElements(bySlideBar).size() >0 && getDriver().findElements(byPlayButton).size() >0  && getDriver().findElements(byCloseButton).size() >0 ;
		
	}
	
	/**
	 * Method to click mapbox
	 * @author Sandhya Narayanarao
	 */
	public void clickMapbox() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement mapbox = getDriver().findElement(byMapbox);
		Sleeper.sleep(3);
		WebElement mapboxlink = getDriver().findElement(byMapboxLink);
		mapboxlink.jsClick();
		System.out.println("clicked on mapbox link");
		Sleeper.sleep(3);
	}

	

	/**
	 * Method to click open street map 
	 *  @author Sandhya Narayanarao
	 */
	public void clickOpenStreetMap() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement openStreetMap = getDriver().findElement(byOpenStreetMap);
		Sleeper.sleep(3);
		openStreetMap.jsClick();
		Sleeper.sleep(6);
	}

	/**
	 * Method to click improve this map
	 * @author Sandhya Narayanarao
	 */
	public void clickImproveThisMap() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement improveThisMap = getDriver().findElement(byImproveThisMap);
		Sleeper.sleep(3);
		improveThisMap.jsClick();
		Sleeper.sleep(4);
	}



	

}
