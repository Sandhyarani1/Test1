package com.accuweather.glacier.m.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
//import com.chameleon.selenium.web.elements.WebLabel;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.Sleeper;

public class ForeCastWeatherIOS extends MobileBasePage {

	private By byForecastCityName = By.cssSelector("a:nth-child(3) > h1");
	private By byNowTab = By.cssSelector("div > div > div.subnav-items > a.subnav-item.active");
	private By byForecastTab = By.cssSelector("div > div > div.subnav-items > a.subnav-item.active");
	private By byForecastTabColor = By.cssSelector("div.subnav-items > a.subnav-item.active > h2");

	private By byForecastMapTitle = By.cssSelector(
			"div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By bySatelliteTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byRadarTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byMinuteCastTab = By.cssSelector("div > div.subnav-items > a:nth-child(3)");
	private By byHourlyTab = By.cssSelector("div > div.subnav-items > a:nth-child(4)");
	private By byDailyTab = By.cssSelector("div > div.subnav-items > a:nth-child(5)");
	// private By byMonthlyTab = By.cssSelector("body > div.template-root >
	// div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	// private By byMonthlyTab = By.cssSelector("body > div.template-root >
	// div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	private By byMonthlyTab = By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/a[6]");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By bySlideBar = By.cssSelector("div.timeline-controls > input.slider");
	private By byPlayButton = By.xpath("//input[@class='slider']/../div/div[@class='play-toggle-button icon-play']");
	private By byMapbox = By
			.cssSelector("div.mapboxgl-control-container > div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byMapboxNextToi = By
			.xpath("//a[@class='mapboxgl-ctrl-logo']/../../div/div[@class='mapboxgl-ctrl-attrib-inner']");
	private By byTimeStamp = By.cssSelector("div.timeline-controls > input ~ div.time-stamp");
	private By byGetCurrentDate = By
			.cssSelector("div.map-tools > div.timeline-controls.precip-forecast-timeline-controls > div.time-stamp");
	private By byRainLightModerateHeavy = By.xpath(
			"//div[@class='legend-labels rain']/span[contains(text(),'light')]/../span[contains(text(),'Moderate')]/../span[contains(text(),'Heavy')]");
	private By byRainTextAboveRainLegend = By.xpath("//div[@class='color-bar rain']/../div/span[text()='Rain']");
	private By bySnowLightModerateHeavy = By.xpath(
			"//div[@class='legend-labels snow']/span[contains(text(),'light')]/../span[contains(text(),'Moderate')]/../span[contains(text(),'Heavy')]");
	private By bySnowTextAboveSnowLegend = By.xpath("//div[@class='color-bar snow']/../div/span[text()='Snow']");
	private By byIceTextAboveIceLegend = By.xpath("//div[@class='color-bar ice']/../div/span[text()='Ice']");
	private By byIceLegendBarColor = By.cssSelector(
			"div.page-column-1 > div:nth-child(1) > div.map-container.full-mobile-width.content-module > div.map-tools > div.forecast-map-legend > div:nth-child(4) > div.color-bar.ice > span");
	private By byMixTextAboveMixLegend = By.xpath("//div[@class='color-bar mix']/../div/span[text()='Mix']");
	private By byMixLegendBarColor = By
			.cssSelector("div.map-tools > div.forecast-map-legend > div:nth-child(5) > div.color-bar.mix > span");
	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By byBreadCrumbMenuRadarAndMaps = By
			.cssSelector(".accordion-item:nth-child(1) .accordion-item-header-content");
	private By byBreadCrumbsubMenuForecast = By.cssSelector(".accordion-item:nth-child(1) a:nth-child(4)");
	private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
	private By byTooltipDescription = By
			.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
	private By byTooltipActive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
	private By byZoomIn = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byZoomOut = By
			.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");

	/**
	 * Method to verify on click of tooltip again, the tooltip closes
	 * 
	 * @author MOHAMMED return tooltip color
	 */
	public String verifyToolTipClosed() {
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.click();
		WebElement toolTipActive = getDriver().findElement(byTooltipActive);
		toolTipActive.click();
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(byTooltip);
		getDriver().findElement(byTooltip).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div:nth-child(1) > div.map-container.full-mobile-width.content-module > div.map-header > div > div.icon-tooltip\")).backgroundColor;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to click Bread Crumb sub menu Forecast
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public Boolean clickBreadCrumbSubmenuForecast() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbsubMenuForecast).click();
		Sleeper.sleep(1);
		return true;
	}

	/**
	 * Method to click Bread Crumb menu Radar and Maps
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

	/*
	 * Method to get ForeCast City Name on AW Monthly Forecast page
	 */
	public String getforecastCityNameSubString() {

		WebPageLoaded.isDomInteractive();
		final WebElement ForecastCityName = getDriver().findElement(byForecastCityName);
		ForecastCityName.syncVisible();
		String ForecastCityNam = ForecastCityName.getText();
		String substringForecastCityName = ForecastCityNam.substring(0, ForecastCityNam.length() - 4);
		return substringForecastCityName;
	}

	/*
	 * Method to verify Now tab is selected by default AW Monthly Forecast page
	 */
	public boolean isNowTabEnabled() {
		WebPageLoaded.isDomInteractive();
		WebElement nowtab = getDriver().findElement(byNowTab);
		nowtab.syncVisible(15);
		return nowtab.isEnabled();
	}

	/*
	 * Method to verify Satellite tab is selected by default AW Monthly Forecast
	 * page
	 */
	public boolean isSatelliteTabEnabled() {
		WebPageLoaded.isDomInteractive();
		WebElement satellitetab = getDriver().findElement(bySatelliteTab);
		satellitetab.syncVisible(15);
		return satellitetab.isEnabled();
	}

	/*
	 * Method to click Satellite tab on the AW Monthly Forecast page
	 */
	public void clickOnSatelliteTab() {
		WebPageLoaded.isDomInteractive();
		WebElement SatelliteTab = getDriver().findElement(bySatelliteTab);
		SatelliteTab.hover();
		SatelliteTab.jsClick();
	}

	/*
	 * Method to click Monthly tab on the AW Monthly Forecast page
	 */
	public void clickOnMonthlyTab() {
		WebPageLoaded.isDomInteractive();
		WebElement monthtab = getDriver().findElement(byMonthlyTab);
		monthtab.hover();
		monthtab.jsClick();
	}

	/*
	 * Method to verify Radar tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isRadarTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement radar = getDriver().findElement(byRadarTab);
		radar.syncVisible(15);
		return radar.isDisplayed();
	}

	/*
	 * Method to verify MinuteCast tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isMinuteCastTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement minutecasttab = getDriver().findElement(byMinuteCastTab);
		minutecasttab.syncVisible(15);
		return minutecasttab.isDisplayed();
	}

	/*
	 * Method to verify Hourly tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isHourlyTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement hourlytab = getDriver().findElement(byHourlyTab);
		hourlytab.syncVisible(15);
		return hourlytab.isDisplayed();
	}

	/*
	 * Method to verify Daily tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isDailyTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement dailytab = getDriver().findElement(byDailyTab);
		dailytab.syncVisible(15);
		return dailytab.isDisplayed();
	}

	/*
	 * Method to verify Monthly tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isMonthlyTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement monthlytab = getDriver().findElement(byMonthlyTab);
		monthlytab.syncVisible(15);
		return monthlytab.isDisplayed();
	}

	/*
	 * Method to verify Satellite tab displayed by default AW Monthly Forecast page
	 */
	public boolean isSatelliteTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement satellitetab = getDriver().findElement(bySatelliteTab);
		satellitetab.syncVisible(15);
		return satellitetab.isDisplayed();
	}

	/**
	 * Method to verify forecast tab is active and higlighted in orange color
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if tab is active"
	 */
	public String verifyForecastTabIsHiglighted() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byForecastTabColor).scrollIntoView();
		WebElement ele = getDriver().findElement(byForecastTabColor);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h2\")).borderBottomColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to verify title of the map on forecast page
	 * 
	 * @author MOHAMMED
	 * @return - title of the map
	 */
	public String verifyTitleOfTheMap() {
		WebPageLoaded.isDomInteractive();
		WebElement forecastMapTitle = getDriver().findElement(byForecastMapTitle);
		String titleOfMap = forecastMapTitle.getText();
		return titleOfMap;
	}

	/**
	 * Click full screen button of the map verify Map opens up into full screen with
	 * timeline controls, slider with play button, and legend and if you click on x
	 * symbol the map switches back to normal
	 * 
	 * @author MOHAMMED
	 */
	public Boolean clickFullScreenButtonOfMap() {
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		WebElement map = getDriver().findElement(byMap);
		Boolean flag;
		// get small screen width and height
		int smallScreenWidth = map.getSize().getWidth();
		int smallcreenHeight = map.getSize().getHeight();
		// click fullscreen button
		WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
		fullScreenBtn.jsClick();
		// get fullscreen map width and height
		int afterFullScreenWidth = map.getSize().getWidth();
		int afterFullScreenHeight = map.getSize().getHeight();
		if (afterFullScreenWidth > smallScreenWidth && afterFullScreenHeight > smallcreenHeight) {
			// play button and slider bar
			WebElement slideBar = getDriver().findElement(bySlideBar);
			WebElement playButton = getDriver().findElement(byPlayButton);
			// playButton.syncVisible();
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

	/**
	 * Method to verify mapbox on the map and i next to it
	 * 
	 * @author MOHAMMED
	 * @return - true if mapbox and i present on the map
	 */
	public Boolean verifyMapboxAndiNextToIt() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byMapbox).size() > 0 && getDriver().findElements(byMapboxNextToi).size() > 0;
	}

	/**
	 * Method to verify presence of slide bar with play button and time at the end
	 * of the bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if slidebar, playbutton and timestamp are
	 *         present else false"
	 */
	public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 100)");
		return getDriver().findElements(bySlideBar).size() > 0 && getDriver().findElements(byPlayButton).size() > 0
				&& getDriver().findElements(byTimeStamp).size() > 0;
	}

	/**
	 * Method to verify presence of current date at end of slide bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if current date matches the current day"
	 */
	public Boolean verifyCurrentDateAtTheEndOfSliderBar() {
		WebPageLoaded.isDomInteractive();
		WebElement currentdate = getDriver().findElement(byGetCurrentDate);
		String getDateFromSlider = currentdate.getText().substring(0, 3);
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
		String getTodayDay = simpleDateformat.format(now);
		return getDateFromSlider.equalsIgnoreCase(getTodayDay.toUpperCase());
	}

	/**
	 * Method to verify light moderate and heavy from rainare in order
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if are in order"
	 */
	public Boolean verifyLightModerateHeavyFromRainLegend() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byRainLightModerateHeavy).size() > 0;
	}

	/**
	 * Method to verify Legends for Rain should have text Rain in the center of the
	 * bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if rain legend have rain text"
	 */
	public Boolean verifyLegendsForRainHaveTextRain() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byRainTextAboveRainLegend).size() > 0;
	}

	/**
	 * Method to verify light moderate and heavy from snow are in order
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if are in order"
	 */
	public Boolean verifyLightModerateHeavyFromSnowLegend() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(bySnowLightModerateHeavy).size() > 0;
	}

	/**
	 * Method to verify Legends for Snow should have text Snow in the center of the
	 * bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if snow legend have sanow text"
	 */
	public Boolean verifyLegendsForSnowHaveTextSnow() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(bySnowTextAboveSnowLegend).size() > 0;
	}

	/**
	 * Method to verify Legends for Ice should have text ICe in the center of the
	 * bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if ice legend have ice text"
	 */
	public Boolean verifyLegendsForIceHaveTextIce() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byIceTextAboveIceLegend).size() > 0;
	}

	/**
	 * Method to verify Legends for Ice legend color
	 * 
	 * @author MOHAMMED
	 * @return - ice legend color
	 */
	public String verifyIceLegendBarColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byIceLegendBarColor).scrollIntoView();
		WebElement ele = getDriver().findElement(byIceLegendBarColor);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div:nth-child(1) > div.map-container.full-mobile-width.content-module > div.map-tools > div.forecast-map-legend > div:nth-child(4) > div.color-bar.ice > span\")).backgroundColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;

	}

	/**
	 * Method to verify Legends for mix should have text mix in the center of the
	 * bar
	 * 
	 * @author MOHAMMED
	 * @return - Boolean value - "true if mix legend have mix text"
	 */
	public Boolean verifyLegendsForMixHaveTextMix() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byMixTextAboveMixLegend).size() > 0;
	}

	/**
	 * Method to verify Legends for mix legend color
	 * 
	 * @author MOHAMMED
	 * @return - mix legend color
	 */
	public String verifyMixLegendBarColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMixLegendBarColor).scrollIntoView();
		WebElement ele = getDriver().findElement(byMixLegendBarColor);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div:nth-child(1) > div.map-container.full-mobile-width.content-module > div.map-tools > div.forecast-map-legend > div:nth-child(5) > div.color-bar.mix > span\")).backgroundColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
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
