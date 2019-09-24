package com.accuweather.glacier.m.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class CurrentConditionpageMobile extends MobileBasePage {
	/*
	 * 
	 * locators
	 * 
	 */

	private By byTomorrowWeatherCard = By
			.xpath("//a[@href='/en/us/mc-farland/53558/daily-weather-forecast/23238_pc?day=1']");

	private By byTonightWeatherCardTitle = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > p:nth-child(1)");

	private By byTodayWeatherCardTitle = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > p:nth-child(1)");

	private By byTodayWeatherCard = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2)");

	private By bycurrentWeatherCard = By.cssSelector(
			"div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current");
	private By bycurrentWeatherTitle = By.cssSelector(
			"div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p:nth-child(1)");
	private By bycurrentconditiontime = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > p.module-header.sub.date");
	private By bycurrentconditionweathericon = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > img");
	private By bycurrentconditionTemperaure = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.value");
	private By bycurrentconditionRealfeelTemp = By.xpath(
			"//div[@class='conditions-card card panel conditions']//p[@class='realFeel'][contains(text(),'RealFeel®')]");
	private By bycurrentconditionWeatherDescription = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.phrase");
	private By bycurrentconditionHumidity = By.xpath("//p[contains(text(),'Humidity:')]");
	private By bycurrentconditionUVIndex = By.xpath("(//p[contains(text(),'UV Index: ')])[1]");
	private By bycurrentconditionCloudCover = By.xpath("//p[contains(text(),'Cloud Cover:')]");
	private By bycurrentconditionPressure = By.xpath("//p[contains(text(),'Pressure:')]");
	private By bycurrentconditionDewPoint = By.xpath("//p[contains(text(),'Dew Point:')]");
	private By bycurrentconditionVisibility = By.xpath("//p[contains(text(),'Visibility:')]");
	private By bycurrentconditionRealfeelshade = By.xpath("//p[contains(text(),'RealFeel® Shade:')]");
	private By bycurrentconditionCompassicon = By.xpath("//div[@class='details-card card panel']//*[@class='arrow']");
	private By bycurrentconditionWind = By.xpath("(//p[contains(text(),'Wind:')])[1]");
	private By bycurrentconditionGusts = By.xpath("(//p[contains(text(),'Gusts:')])[1]");
	private By bycurrentconditionHourlyCTB = By.cssSelector("div.current-conditions-card.content-module > a > span");
	private By byrightarrow = By.cssSelector("div.current-conditions-card.content-module > a > div > svg");
	private By bycurrentdate = By.cssSelector("div.card-button.content-module.centered > span");
	private By byrightarrownnexttoDate = By.cssSelector("div.card-button.content-module.centered > a > svg");
	private By bynextDaylink = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.card-button.content-module.centered > a");
	private By bydayorganism = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bydayorganismTitle = By.xpath("//p[contains(text(),'Day')]");
	private By bydayOrganismDate = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p.module-header.sub.date");
	private By bynightOrganismDate = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > p.module-header.sub.date");
	private By bydayOrganismWeatherIcon = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > img");
	private By bynightOrganismWeatherIcon = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > img");
	private By bydayOrganismWeatherCurrenTempearture = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value");
	private By bydayOrganismWeatherCurrentReelFeelTemperature = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.realFeel");
	private By bydayOrganismCurrentWeatherDescription = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.phrase");
	private By bydayOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(1)");
	private By bydayOrganismCurrentWeatherMaxUVIdex = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)");
	private By bydayOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)");
	private By bydayOrganismCurrentWeatherRain = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)");
	private By bydayOrganismCurrentWeatherSnow = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)");
	private By bydayOrganismCurrentWeatherIce = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)");
	private By bydayOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)");
	private By bydayOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(9)");
	private By bydayOrganismCurrentWeatherWind = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)");
	private By bydayOrganismCurrentWeatherGusts = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherCompassIcon = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > div > svg");
	private By bynightOrganismCurrentWeather = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bynightOrganismWeatherCurrentTempearture = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value");
	private By bynightOrganismWeatherCurrentReelFeelTemperature = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.realFeel");
	private By bynightOrganismCurrentWeatherDescription = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.phrase");
	private By bynightOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(1)");
	private By bynightOrganismCurrentWeatherMaxUVIdex = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)");
	private By bynightOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)");
	private By bynightOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)");
	private By bynightOrganismCurrentWeatherRain = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)");
	private By bynightOrganismCurrentWeatherSnow = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)");
	private By bynightOrganismCurrentWeatherIce = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)");
	private By bynightOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)");
	private By bynightOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)");
	private By bynightOrganismCurrentWeatherWind = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)");
	private By bynightOrganismCurrentWeatherGusts = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(3)");
	private By bynightcurrentconditionCompassicon = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > div > svg");
	private By bytemperatureHistoryOrganismCurrentWeather = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.title > span:nth-child(1)");
	private By bytemperatureHistoryOrganismDate = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.title > span.module-header.sub");
	private By bytemperatureHistoryOrganismTodayHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span.label.last");
	private By bytemperatureHistoryOrganismTodayFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismTodaySecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismNormalSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismRecordSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span.label.last");
	private By bytemperatureHistoryOrganismLastYearSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span.label.last");
	private By byRecentLocationWeatherIcon = By
			.cssSelector("div.recent-locations-label > a.recent-location-display > img");
	private By byTodayCardonThreeDayForecastPage = By.cssSelector(
			"div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p:nth-child(1)");
	private By bysunrisesunsetorganism = By
			.cssSelector("div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div");
	private By bysunriseTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-header");
	private By bysunrisetime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content");
	private By bysunsetTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-header");
	private By bysunsetTime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byduartionTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By bydurationTime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By bysunIcon = By
			.cssSelector("div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img");
	private By bymoonriseTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-header");
	private By bymoonriseTime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content");
	private By bymoonsetTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-header");
	private By bymoonsetTime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By bymoonrisemoonsetduration = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By bymoonrisemoonsetdurationtime = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By bymoreHistoricalWeatherData = By.cssSelector("div.temp-history.content-module > a > span");
	private By bymoreHistoricalCTAarrow = By.cssSelector("div.temp-history.content-module > a > div > svg");

	/**
	 * Method to verify whether current Weather card is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if current Weather card is
	 *         displayed"
	 */

	public void isclickedonCurrentweathercard() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(bycurrentWeatherCard).syncVisible();
		getDriver().findElement(bycurrentWeatherCard).click();
	}

	/**
	 * Method to verify whether clicked on recent Location
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if clicked in recent location icon
	 */

	public void isclickedonRecentLocationWeatherIcon() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byRecentLocationWeatherIcon).syncVisible();
		getDriver().findElement(byRecentLocationWeatherIcon).click();
	}

	/**
	 * Method to verify whether clicked on recent Location
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's url if clicked in recent location icon
	 */

	public String isclickedonCurrentweathercard2() {
		WebPageLoaded.isDomInteractive();
		WebElement currentcard = getDriver().findElement(bycurrentWeatherCard);
		String url = getDriver().getCurrentUrl();
		return url;
	}

	/**
	 * Method to verify whether clicked on Today weather card
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's url if clicked in today weather card
	 */

	public String isclickedonCurrentweathercardUsingTodayWeatherCard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTodayWeatherCard).click();
		return getDriver().getCurrentUrl();

	}

	/**
	 * Method to get the title of current weather card
	 * 
	 * @author Mohammed
	 * @return - String value of the title of the current weather card
	 */

	public void TitleofCurrentweathercard() {
		WebPageLoaded.isDomInteractive();
		String Title = getDriver().findElement(bycurrentWeatherTitle).getText();
	}

	/**
	 * Method to get the time on current weather card
	 * 
	 * @author Mohammed
	 * @return - String value of the time on the current weather card
	 */

	public String timeoncurrentconditionpage() {
		WebPageLoaded.isDomInteractive();
		String time = getDriver().findElement(bycurrentconditiontime).getText();
		return time;
	}

	/**
	 * Method to get the time color displayed on current weather card
	 * 
	 * @author Mohammed
	 * @return - String value of the time color displayed on the current weather
	 *         card
	 */

	public String Timedisplayedcolour() {
		WebPageLoaded.isDomInteractive();
		String timedisplayedcolour = getDriver().findElement(bycurrentconditiontime).getCssValue("color");
		String timecolour = Color.fromString(timedisplayedcolour).asHex();
		return timecolour;
	}

	public Boolean TodayCardonThreeDayForecastPageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(byTodayCardonThreeDayForecastPage).isDisplayed();
		return icondisplayed;
	}

	/**
	 * Method to get the weather icon displayed on current weather card
	 * 
	 * @author Mohammed
	 * @return - String value of the weather icon displayed on the current weather
	 *         card
	 */

	public Boolean weathericondisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bycurrentconditionweathericon).isDisplayed();
		return icondisplayed;
	}

	/**
	 * Method to get the day organism current weather description displayed on
	 * current weather card
	 * 
	 * @author Mohammed
	 * @return - true value if day organism current weather description displayed on
	 *         current weather card
	 */

	public Boolean bydayOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	/**
	 * Method to get the night organism current weather description displayed on
	 * current weather card
	 * 
	 * @author Mohammed
	 * @return - true value if night organism current weather description displayed
	 *         on current weather card
	 */

	public Boolean bynightOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	/**
	 * Method to get the day organism current weather temperature displayed on
	 * current weather card
	 * 
	 * @author Mohammed
	 * @return - true value if day organism current weather temperature displayed on
	 *         current weather card
	 */
	public String temperatureinbold() {
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bycurrentconditionTemperaure).getCssValue("font-weight");
		return fontsize;
	}

	/**
	 * Method to get the day/night organism elements on current weather card is
	 * displayed in grey
	 * 
	 * @author Mohammed
	 * @return - color value of the day/night organism elements on current weather
	 *         card is displayed in grey
	 */

	public String validateElementIsGrey(String element) {
		String timedisplayedcolour = null;

		if (element.equals("Title Sunrise displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bysunriseTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(bysunriseTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("Title Sunset displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bysunsetTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(bysunsetTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("Sunrise Time displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bysunrisetime).scrollIntoView();
			WebElement ele = getDriver().findElement(bysunrisetime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Sunset Time displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bysunsetTime).scrollIntoView();
			WebElement ele = getDriver().findElement(bysunsetTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Title Duration displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byduartionTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(byduartionTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("Duration displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydurationTime).scrollIntoView();
			WebElement ele = getDriver().findElement(bydurationTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Title Moonrise displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bymoonriseTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(bymoonriseTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Moonrise Time displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bymoonriseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(bymoonriseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Title Moonset displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bymoonsetTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(bymoonsetTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Moonset Time displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bymoonsetTime).scrollIntoView();
			WebElement ele = getDriver().findElement(bymoonsetTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("Moonrise moonset Duration Title  displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonrisemoonsetduration).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise moonset Duration time displayed in Black")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bymoonrisemoonsetdurationtime).scrollIntoView();
			WebElement ele = getDriver().findElement(bymoonrisemoonsetdurationtime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("night Organism Current Weather compass icon")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightcurrentconditionCompassicon).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightcurrentconditionCompassicon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > div > svg\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Gusts")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherGusts).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherGusts);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("night Organism Current Weather wind")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherWind).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherWind);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("night Organism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("night Organism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("night Organism Current Weather Ice")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Snow")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherSnow).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherSnow);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Rain")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherRain).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherRain);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Precipitation")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather MaxUVIdex")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Compass Icon")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex).scrollIntoView();
			WebElement ele = getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Gusts")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Wind")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherWind).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherWind);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(9)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("day Oragnism Current Weather ice")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather snow")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather rain")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Precipitation")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}

		if (element.equals("day Oragnism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("day Organism Current Weather MaxUVIdex")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bydayOrganismCurrentWeatherIce).scrollIntoView();
			WebElement ele = getDriver().findElement(bydayOrganismCurrentWeatherIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("time displayed")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditiontime).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditiontime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > p.module-header.sub.date\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("Real feel temparature")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionRealfeelTemp).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionRealfeelTemp);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.realFeel\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionUVIndex).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionUVIndex);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("UV index")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionUVIndex).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionUVIndex);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("cloud cover")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionCloudCover).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionCloudCover);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("pressure")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionPressure).scrollIntoView();// today
			WebElement ele = getDriver().findElement(bycurrentconditionPressure);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(4)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("dew point")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionVisibility).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionVisibility);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(5)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("visibility")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionVisibility).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionVisibility);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("real feel shade")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionRealfeelshade).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionRealfeelshade);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("compass icon")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionCompassicon).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionCompassicon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > div > svg\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("wind")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionWind).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionWind);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}

		if (element.equals("gusts")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bycurrentconditionGusts).scrollIntoView();
			WebElement ele = getDriver().findElement(bycurrentconditionGusts);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		return timedisplayedcolour;

	}

	/**
	 * Method to get hourly cta on current weather card is displayed
	 * 
	 * @author Mohammed
	 * @return - true if hourly cta on current weather card is displayed
	 */

	public Boolean HourlyCTAdisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentconditionHourlyCTB).isDisplayed();
	}

	/**
	 * Method to get day organism Current Weather ReelFeel Temperature is displayed
	 * 
	 * @author Mohammed
	 * @return - true if day organism Current Weather ReelFeel Temperature is
	 *         displayed
	 */

	public String dayCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydayOrganismWeatherCurrentReelFeelTemperature).scrollIntoView();
		return getDriver().findElement(bydayOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	/**
	 * Method to get night organism Current Weather ReelFeel Temperature is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - true if night organism Current Weather ReelFeel Temperature is
	 *         displayed
	 */

	public String nightCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bynightOrganismWeatherCurrentReelFeelTemperature).scrollIntoView();
		return getDriver().findElement(bynightOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	/**
	 * Method to get day right arrow is displayed
	 * 
	 * @author Mohammed
	 * @return - arrow color
	 */

	public String rightarrowcolour() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byrightarrow).scrollIntoView();
		WebElement ele = getDriver().findElement(byrightarrow);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"e-column-1 > div.content-module >div.current-conditions-card.content-module > a > div > svg\")).fill;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to get hourly cta
	 * 
	 * @author Mohammed
	 * @return - url of the hourly cta
	 */

	public String clickonHourlyCTA() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bycurrentconditionHourlyCTB).jsClick();
		return getDriver().getCurrentUrl();
	}

	public String currentDateonAccPage() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentdate).getText();
	}

	/**
	 * Method to get current date
	 * 
	 * @author Mohammed
	 * @return - current date
	 */

	public String getCurrentDate() {
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		String strDateFormat = "MMM-dd"; // Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // Date format string is passed as an argument to
		return objSDF.format(objDate);

	}

	/**
	 * Method to get arrow color next to date
	 * 
	 * @author Mohammed
	 * @return - arrow color
	 */

	public String arrownexttodate() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byrightarrownnexttoDate).scrollIntoView();
		String arrowcolour = getDriver().findElement(byrightarrownnexttoDate).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;

	}

	/**
	 * Method to get arrow color next to date
	 * 
	 * @author Mohammed
	 * @return - arrow color
	 */

	public String arrownexttodate2() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byrightarrownnexttoDate).scrollIntoView();
		WebElement ele = getDriver().findElement(byrightarrownnexttoDate);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.card-button.content-module.centered > a > svg\")).fill;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to click on next day
	 * 
	 * @author Mohammed
	 * @return - url of the next day
	 */

	public String clickonNextdatearrow() throws InterruptedException {
		WebPageLoaded.isDomInteractive();
		Thread.sleep(5000);
		getDriver().findElement(bynextDaylink).jsClick();
		Thread.sleep(5000);
		return getDriver().getCurrentUrl();
	}

	/**
	 * Method to get the today organism is displayed
	 * 
	 * @author Mohammed
	 * @return - true if today organism is displayed
	 */

	public Boolean todayOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getDriver().findElement(bydayorganism).scrollIntoView();
		return getDriver().findElements(bydayorganism).size() > 0;
	}

	/**
	 * Method to get the night organism is displayed
	 * 
	 * @author Mohammed
	 * @return - true if night organism is displayed
	 */

	public Boolean nightOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bynightOrganismCurrentWeather).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism is displayed
	 */

	public Boolean temperatureHistoryOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism title is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism title is displayed
	 */

	public Boolean temperatureHistoryOrganismTitle() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism date is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism date is displayed
	 */

	public Boolean temperatureHistoryOrganismDate() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismDate).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism today header is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism today header is displayed
	 */

	public Boolean temperatureHistoryOrganismTodayHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodayHeader).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism normal header is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism normal header is displayed
	 */

	public Boolean temperatureHistoryOrganismNormalHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalHeader).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism record header is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism record header is displayed
	 */

	public Boolean temperatureHistoryOrganismRecordHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordHeader).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism last year header is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism last year header is displayed
	 */

	public Boolean temperatureHistoryOrganismLastYearHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismLastYearHeader).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism today header first row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism today header first row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismTodayFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodayFirstRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism today header second row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism today header second row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismTodaySecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodaySecondRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism normal header first row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism normal header first row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismNormalFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalFirstRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism normal header second row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism normal header second row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismNormalSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalSecondRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism today header first row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism today header first row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismRecordFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordFirstRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism today header second row value
	 * is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism today header second row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismRecordSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordSecondRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism last year header first row
	 * value is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism last year header first row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismLastYearFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismLastYearFirstRowValue).isDisplayed();
	}

	/**
	 * Method to get the temperature history organism last year header second row
	 * value is displayed
	 * 
	 * @author Mohammed
	 * @return - true if temperature organism last year header second row value is
	 *         displayed
	 */

	public Boolean temperatureHistoryOrganismLastYearSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismLastYearSecondRowValue).isDisplayed();
	}

	public void scrollPage() {
		WebPageLoaded.isDomInteractive();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	/**
	 * Method to get the day organism title is in upper case is displayed
	 * 
	 * @author Mohammed
	 * @return - true if ay organism title is in upper case is displayed
	 */

	public Boolean isDayOranismTitleIsInUppercase(String DayOranismTextValue) {
		String Text = DayOranismTextValue;
		WebPageLoaded.isDomInteractive();
		System.out.println("element on web" + getDriver().findElement(bydayorganismTitle).getText());
		String Daytext = getDriver().findElement(bydayorganismTitle).getText().toLowerCase();
		Daytext.compareTo("DAY");
		String DayOrganismTextinBoldActual = getDriver().findElement(bydayorganismTitle).getText().toLowerCase();
		String DayOrganismTextinBoldExpected = Text.toLowerCase();
		if (DayOrganismTextinBoldActual.equals(DayOrganismTextinBoldExpected))
			return true;
		else
			return false;

	}

	/**
	 * Method to get the day organism title is in bold
	 * 
	 * @author Mohammed
	 * @return - true if ay organism title is in bold
	 */

	public String dayOrganismTextTitleisBold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydayorganismTitle).scrollIntoView();
		WebElement ele = getDriver().findElement(bydayorganismTitle);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)\")).fontWeight;",
				ele);
		return result;

	}

	/**
	 * Method to get the night organism title is in bold
	 * 
	 * @author Mohammed
	 * @return - true if ay night organism title is in bold
	 */

	public String nightOrganismTextTitleisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bynightOrganismCurrentWeather).getCssValue("font-weight");
		return dayOrganismFont;

	}

	/**
	 * Method to get the day organism temperature is in bold
	 * 
	 * @author Mohammed
	 * @return - true if day organism temperature is in bold
	 */

	public String dayOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydayOrganismWeatherCurrenTempearture).scrollIntoView();
		WebElement ele = getDriver().findElement(bydayOrganismWeatherCurrenTempearture);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value\")).fontWeight;",
				ele);
		return result;

	}

	/**
	 * Method to get the night organism temperature is in bold
	 * 
	 * @author Mohammed
	 * @return - true if night organism temperature is in bold
	 */

	public String nightOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bynightOrganismWeatherCurrentTempearture).scrollIntoView();
		WebElement ele = getDriver().findElement(bynightOrganismWeatherCurrentTempearture);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value\")).fontWeight;",
				ele);
		return result;
	}

	/**
	 * Method to get the day organism date is displayed
	 * 
	 * @author Mohammed
	 * @return - true if day organism date is displayed
	 */

	public Boolean dayOrganismDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydayOrganismDate).scrollIntoView();
		Boolean dayDatedisplayed = getDriver().findElements(bydayOrganismDate).size() > 0;
		return dayDatedisplayed;
	}

	/**
	 * Method to get the night organism date is displayed
	 * 
	 * @author Mohammed
	 * @return - true if night organism date is displayed
	 */

	public Boolean nightOrganismDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bynightOrganismDate).scrollIntoView();
		Boolean dayDatedisplayed = getDriver().findElements(bynightOrganismDate).size() > 0;
		return dayDatedisplayed;
	}

	/**
	 * Method to get the day organism weather icon is displayed
	 * 
	 * @author Mohammed
	 * @return - true if day organism weather icon is displayed
	 */

	public Boolean dayOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean dayIcondisplayed = getDriver().findElement(bydayOrganismWeatherIcon).isDisplayed();
		return dayIcondisplayed;
	}

	/**
	 * Method to get the night organism weather icon is displayed
	 * 
	 * @author Mohammed
	 * @return - true if night organism weather icon is displayed
	 */

	public Boolean nightOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bynightOrganismWeatherIcon).scrollIntoView();
		Boolean dayIcondisplayed = getDriver().findElements(bynightOrganismWeatherIcon).size() > 0;
		return dayIcondisplayed;
	}

	/**
	 * Method to get the day organism weather precipitation is displayed
	 * 
	 * @author Mohammed
	 * @return - true if day organism precipitation is displayed
	 */

	public Boolean dayOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).scrollIntoView();
		Boolean icondisplayed = getDriver().findElements(bydayOrganismCurrentWeatherPrecipitation).size() > 0;
		return icondisplayed;
	}

	/**
	 * Method to get the day organism weather precipitation is displayed
	 * 
	 * @author Mohammed
	 * @return - true if day organism precipitation is displayed
	 */

	public Boolean nightOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}

	/**
	 * Method to get the sunset organism is displayed
	 * 
	 * @author Mohammed
	 * @return - true if sunset is displayed
	 */

	public Boolean Sunrisesunsetorganismdisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
	}

	/**
	 * Method to get the sun icon organism is displayed
	 * 
	 * @author Mohammed
	 * @return - true if sun icon is displayed
	 */

	public Boolean IssuniconDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElements(bysunIcon).size() > 0;
		return icondisplayed;
	}

	/**
	 * Method to get the sun icon color is displayed
	 * 
	 * @author Mohammed
	 * @return - true if sun icon color is displayed
	 */

	public String Sunicon() {
		WebPageLoaded.isDomInteractive();
		String displayedcolour = getDriver().findElement(bysunIcon).getCssValue("color");
		String Actualcolourdisplayed = Color.fromString(displayedcolour).asHex();
		return Actualcolourdisplayed;
	}

	/**
	 * Method to get the Historical weather data is displayed
	 * 
	 * @author Mohammed
	 * @return - true if historical weather data is displayed
	 */

	public boolean Historicalweatherdata() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bymoreHistoricalWeatherData).isDisplayed();
	}

	/**
	 * Method to get the Historical weather data cta color
	 * 
	 * @author Mohammed
	 * @return - color of the historical weather cta
	 */

	public String morehistoricalCTAcolour() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(bymoreHistoricalCTAarrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to get the sunrise time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the sunrise time
	 */

	public String Sunrisetimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bysunrisetime).scrollIntoView();
		WebElement ele = getDriver().findElement(bysunrisetime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content\")).fontWeight;",
				ele);
		return result;
	}

	/**
	 * Method to get the sunset time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the sunset time
	 */

	public String Sunsettimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bysunsetTime).scrollIntoView();
		WebElement ele = getDriver().findElement(bysunsetTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).fontWeight;",
				ele);
		return result;
	}

	/**
	 * Method to get the duration time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the duration time
	 */

	public String Durationtimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(bydurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).fontWeight;",
				ele);
		return result;

	}

	/**
	 * Method to get the moonrise time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the moon rise time
	 */

	public String Moonrisetimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bydurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(bydurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).fontWeight;",
				ele);
		return result;
	}

	/**
	 * Method to get the moonset time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the moonset time
	 */

	public String Moonsetimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bymoonsetTime).scrollIntoView();
		WebElement ele = getDriver().findElement(bymoonsetTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content\")).fontWeight;",
				ele);
		return result;
	}

	/**
	 * Method to get the moon set duration time is bold
	 * 
	 * @author Mohammed
	 * @return - font size of the moon set duration time
	 */

	public String moonrisemoonsetDurationtimeinbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bymoonrisemoonsetdurationtime).scrollIntoView();
		WebElement ele = getDriver().findElement(bymoonrisemoonsetdurationtime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).fontWeight;",
				ele);
		return result;
	}

	public String returnCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date.toString();
	}

	/**
	 * Method to verify whether today Weather card title is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card title is
	 *         displayed"
	 */

	public boolean isTodayWeatherCardTitleDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardTitle).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card title is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card title is
	 *         displayed"
	 */

	public boolean isTonghtWeatherCardTitleDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardTitle).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow's Weather card is
	 *         displayed"
	 */

	public boolean isTomorrowWeatherCardDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCard).isDisplayed();
	}

}
