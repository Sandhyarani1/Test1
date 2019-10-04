package com.accuweather.glacier.www.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class MinutecastPage extends BasePage {

	private By byfeaturedSearchbar = By
			.cssSelector("div.searchbar.featured-search > div.searchbar-content > form > input");

	private By byminutecastTab = By.cssSelector("div.subnav-items > a:nth-child(3)");
	private By byminutecastDial = By.cssSelector("div.content-module > div.minutecast-dial.content-module");
	private By byminutecastDialLargeWeatherDescription = By.cssSelector("div.minutecast-dial.content-module > p.title");
	private By byminutecastDialTimesatmp = By.cssSelector(" div.minutecast-dial.content-module > p.graphic-label.top");
	private By byminutecastDialWeathericon = By.cssSelector("div.minutecast-dial.content-module > div > div > img");
	private By byminutecastShotDescription = By.cssSelector("div.minutecast-dial.content-module > div > div > p");
	private By byminutecastDialUpdatedTime = By.cssSelector("div.minutecast-dial.content-module > p.update");
	private By byradarMap = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-canvas.full-mobile-width");
	private By byradarMapTitle = By
			.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");

	private By byradaraMapToolTip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byradartoolTipActive = By.xpath("//div[@class='icon-tooltip is-active']");

	private By byradartooltipTitle = By.cssSelector("div.tooltip-overlay > div.tooltip-header > span");
	private By byradarmapTooltipText = By.cssSelector("div.tooltip-overlay > div.tooltip-content");
	private By byradarmapTooltipHeader = By.cssSelector("div.tooltip-overlay > div.tooltip-header > span");

	private By bymapboxAttribution = By.cssSelector("div.mapboxgl-control-container > div.mapboxgl-ctrl-bottom-left");

	private By byRainlegendTextLight = By
			.cssSelector("div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(1)");
	private By byRainlegendTextSevere = By
			.cssSelector("div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(2)");

	private By byfullscreenButton = By.cssSelector("div.map-canvas.full-mobile-width > div.full-screen-button");
	private By bytimeStampmolecule = By.cssSelector("div.minutecast-minute-by-minute.content-module > div.timestamps");
	private By byTimedisplayed = By.xpath("//div[@class='timestamps']//div");
	private By bytimeStampCurrentTime = By.cssSelector("div.timestamps > div:nth-child(1) > span");
	/**
	 * @author Sandhya Rani Method to Search City by its name from featured
	 *         search bar
	 *
	 **/

	public void searchCityByName(String cityName) {
		WebPageLoaded.isDomInteractive();
		WebElement searchBartextfield = getDriver().findElement(byfeaturedSearchbar);
		searchBartextfield.syncVisible(15);
		searchBartextfield.hover();
		searchBartextfield.sendKeys(cityName);
		Sleeper.sleep(3);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-results']//*")));
	}

	public void selectCityByName() {
		getDriver().findElement(By.cssSelector("div.search-results > div:nth-child(2)")).click();
	}

	/**
	 * @author Sandhya Rani 
	 * Method to validate Minutecast tab Displayed ,Highlighted by default and get the hex tab color
	 * 
	 * 
	 **/
	public void isminutecastTabDisplayed() {
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
	 * Method to validate Minutecast Dial Displayed on Minutecast page and validate Large weather description,
	 *  Short weather description,Dial Timestamp,Dial weather icon and Dial Updated Time displayed 
	 * 
	 * 
	 **/


	public boolean isminutecastDialDisplayed() {
		WebElement minutecastTabDial = getDriver().findElement(byminutecastDial);
		minutecastTabDial.syncVisible(30);
		return minutecastTabDial.isDisplayed();
	}

	public String minutecastDialLargeWeatherDescriptionDisplayed() {
		WebElement minutecastDialLargeWeatherDescription = getDriver()
				.findElement(byminutecastDialLargeWeatherDescription);
		minutecastDialLargeWeatherDescription.syncVisible(30);
		return minutecastDialLargeWeatherDescription.getText();
	}

	public String minutecastDialshortWeatherDescriptionDisplayed() {
		WebElement minutecastDialshortWeatherDescription = getDriver().findElement(byminutecastShotDescription);
		minutecastDialshortWeatherDescription.syncVisible(30);
		return minutecastDialshortWeatherDescription.getText();
	}

	public String minutecastDialTimestampDisplayed() {
		WebElement minutecastDialLargeWeatherDescription = getDriver().findElement(byminutecastDialTimesatmp);
		minutecastDialLargeWeatherDescription.syncVisible(30);
		return minutecastDialLargeWeatherDescription.getText();
	}

	public boolean minutecastDialWeathericonDisplayed()

	{
		WebElement weathericon = getDriver().findElement(byminutecastDialWeathericon);
		weathericon.syncVisible(60);
		return weathericon.isDisplayed();
	}

	public String minutecastDialhasUpdatedTimeDisplayed()

	{
		WebElement updatedTime = getDriver().findElement(byminutecastDialUpdatedTime);
		updatedTime.syncVisible(60);
		return updatedTime.getText();
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


	public String tooltipDefaultcolor() {
		String defaulTooltipColor = getDriver().findElement(byradaraMapToolTip).getCssValue("color");
		return Color.fromString(defaulTooltipColor).asHex();
	}

	public String activetooltipcolor() {
		String activeTooltipColor = getDriver().findElement(byradartoolTipActive).getCssValue("background-color");
		return Color.fromString(activeTooltipColor).asHex();
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
	 * Method to Validate mapbox attribution displayed 
	 *         
	 **/


	public boolean mapboxAttributiondisplayed() {
		WebElement mapboxattribution = getDriver().findElement(bymapboxAttribution);
		mapboxattribution.syncVisible(30);
		return mapboxattribution.isDisplayed();
	}

	/**
	 * @author Sandhya Rani
	 * Method to Validate legend Rain displayed with text Light and Severe 
	 *         
	 **/
	public Boolean verifyLightAndSevertextdisplayedforLegendRain() {
		WebPageLoaded.isDomInteractive();
		WebElement radarMap = getDriver().findElement(byradarMap);
		radarMap.syncVisible();
		WebElement light = getDriver().findElement(byRainlegendTextLight);
		WebElement severe = getDriver().findElement(byRainlegendTextSevere);
		light.syncVisible();
		severe.syncVisible();
		return light.isDisplayed() && severe.isDisplayed();
	}

	/**
	 * @author Sandhya Rani
	 * Method to Validate Fullscreen button displayed and to click on Fullscreen button 
	 *         
	 **/

	public boolean FullscreenbuttonOnBottomRight() {
		WebPageLoaded.isDomInteractive();
		WebElement radarMap = getDriver().findElement(byfullscreenButton);
		radarMap.syncVisible();
		return radarMap.isDisplayed();

	}

	public void FullscreenButtonSelected() {
		WebPageLoaded.isDomInteractive();
		WebElement radarMap = getDriver().findElement(byfullscreenButton);
		radarMap.syncVisible();
		radarMap.jsClick();
	}

	/**
	 * @author Sandhya Rani
	 * Method to Validate Timestamp displayed below the Radar map and get the current time displayed in orange color
	 *         
	 **/

	public boolean timestampDisplayed() {
		WebElement timeStamp = getDriver().findElement(bytimeStampmolecule);
		timeStamp.syncVisible(30);
		return timeStamp.isDisplayed();

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

	public long timestamp() {
		List<org.openqa.selenium.WebElement> time = getDriver().findElements(byTimedisplayed);

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
		List<org.openqa.selenium.WebElement> time = getDriver().findElements(byTimedisplayed);

		for (int i = 0; i < time.size(); i++) {
			time.get(i).isDisplayed();
			time.get(i).click();
			Sleeper.sleep(3);
		}

	}
}

