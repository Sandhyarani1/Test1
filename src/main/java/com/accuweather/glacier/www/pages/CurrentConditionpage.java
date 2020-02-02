package com.accuweather.glacier.www.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class CurrentConditionpage extends BasePage {
	/*
	 * 
	 * locators
	 * 
	 */
	private By bycurrentWeatherCard = By.cssSelector(
			"div.page-column-1 > div > div > a:nth-child(1)");
	private By byTodayWeatherCard = By.cssSelector(
			"div.page-column-1 > div > div > a:nth-child(2)");
	private By bycurrentWeatherTitle = By.cssSelector(
			"div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p:nth-child(1)");
	private By bycurrentconditiontime = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > p.module-header.sub.date");
	private By bycurrentconditionweathericon = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > img");
	private By bycurrentconditionTemperaure = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.value");
	private By bycurrentconditionRealfeelTemp = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.realFeel");
	private By bycurrentconditionWeatherDescription = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.phrase");
	private By bycurrentconditionHumidity = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(1)");
	private By bycurrentconditionUVIndex = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(2)");
	private By bycurrentconditionCloudCover = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(3)");
	private By bycurrentconditionPressure = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(4)");
	private By bycurrentconditionDewPoint = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(5)");
	private By bycurrentconditionVisibility = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(6)");
	private By bycurrentconditionRealfeelshade = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(7)");
	private By bycurrentconditionCompassicon = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > div > svg");
	private By bycurrentconditionWind = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(2)");
	private By bycurrentconditionGusts = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(3)");
	private By bycurrentconditionHourlyCTB = By.cssSelector("div.current-conditions-card.content-module > a > span");
	private By byrightarrow = By.cssSelector(
			"div.current-conditions-card.content-module > a > div > svg");
	private By bycurrentdate = By.cssSelector(
			"div.card-button.content-module.centered > span");
	private By byrightarrownnexttoDate = By.cssSelector(
			"div.card-button.content-module.centered > a > svg");
	private By bynextDaylink = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.card-button.content-module.centered > a");
	private By bydayorganism = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bydayorganismTitle = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bydayOrganismDate = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p.module-header.sub.date");
	private By bydayOrganismWeatherIcon = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > img");
	
	private By bydayOrganismWeatherCurrenTempearture = By.cssSelector("div > div.panel-2 > div > div > div > div > div.temp-icon-wrapper > div > p.value");
	private By bydayOrganismWeatherCurrentReelFeelTemperature = By.cssSelector("div.panel-2 > div > div > div > div > div > div > p.realFeel");
	private By bydayOrganismCurrentWeatherDescription = By.cssSelector("div.panel-2 > div > div > div > div > div.phrase");
	
	private By bydayOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(1)");
	private By bydayOrganismCurrentWeatherMaxUVIdex = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(2)");
	private By bydayOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(4)");
	private By bydayOrganismCurrentWeatherRain = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(5)");
	private By bydayOrganismCurrentWeatherSnow = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(6)");
	private By bydayOrganismCurrentWeatherIce = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(7)");
	private By bydayOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(8)");
	private By bydayOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.list > p:nth-child(9)");
	private By bydayOrganismCurrentWeatherWind = By.cssSelector(
			"div > div.panel-1 > div > div > div> div > div.short-list > p:nth-child(2)");
	private By bydayOrganismCurrentWeatherGusts = By.cssSelector(
			"div > div.panel-1 > div > div > div> div > div.short-list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherCompassIcon = By.cssSelector(
			"div > div.panel-1 > div > div > div > div > div.short-list > p:nth-child(3)");
   
	//NIGHT ORGANISMS
	private By bynightOrganismTextInBold = By.cssSelector("div.panel-2 > div > div > div > div > p:nth-child(1)");
	private By bynightOrganismDate = By.cssSelector("div.panel-2 > div > div > div > div> p.module-header.sub.date");
	private By bynightOrganismWeatherIcon = By.cssSelector("div.panel-2 > div > div > div > div > div.temp-icon-wrapper > img");
	private By byNightOrganismWeatherCurrenTempearture = By.cssSelector("div > div.panel-2 > div > div > div > div > div.temp-icon-wrapper > div > p.value");
	private By bynightOrganismWeatherCurrentReelFeelTemperature = By.cssSelector("div.panel-2 > div > div > div > div > div > div > p.realFeel");
	private By byNightOrganismCurrentWeatherDescription = By.cssSelector("div.panel-2 > div > div > div > div > div.phrase");
	
	private By bynightOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(1)");
	private By bynightOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(2)");
	private By bynightOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(3)");
	private By bynightOrganismCurrentWeatherRain = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(4)");
	private By bynightOrganismCurrentWeatherSnow = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(5)");
	private By bynightOrganismCurrentWeatherIce = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(6)");
	private By bynightOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(7)");
	private By bynightOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.list > p:nth-child(8)");
	private By bynightOrganismCurrentWeatherWind = By.cssSelector(
			"div > div.panel-2 > div > div > div> div > div.short-list > p:nth-child(2)");
	private By bynightOrganismCurrentWeatherGusts = By.cssSelector(
			"div > div.panel-2 > div > div > div> div > div.short-list > p:nth-child(3)");
	private By bynightcurrentconditionCompassicon = By.cssSelector(
			"div > div.panel-2 > div > div > div > div > div.short-list > div > svg");
	
	
	private By bytemperatureHistoryOrganismCurrentWeather = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.title > span:nth-child(1)");
	private By bytemperatureHistoryOrganismDate = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.title > span.module-header.sub");
	private By bytemperatureHistoryOrganismTodayHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span.label.last");
	private By bytemperatureHistoryOrganismTodayFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismTodaySecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismNormalSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismRecordSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span.label.last");
	private By bytemperatureHistoryOrganismLastYearSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span.label.last");
	private By byRecentLocationWeatherIcon = By.cssSelector(
			"div.recent-locations-label > a.recent-location-display > img");
	private By byTodayCardonThreeDayForecastPage = By.cssSelector(
			"div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p:nth-child(1)");
	private By bysunrisesunsetorganism = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div");
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
	private By bysunIcon = By.cssSelector(
			"div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img");
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
	private By bymoreHistoricalWeatherData = By.cssSelector(
			"div.temp-history.content-module > a > span");
	private By bymoreHistoricalCTAarrow = By.cssSelector(
			"div.temp-history.content-module > a > div > svg");
	private By byDayMoreButton = By.cssSelector("div.panel-1 > div > div > div > div > div > span.text.more");
	private By byNightMoreButton = By.cssSelector("div.panel-2 > div > div > div > div > div > span.text.more");
	private By byDayLessButton = By.cssSelector("div.panel-1 > div > div > div > div.conditions-card.card.panel.allow-wrap.expanded > div.toggle.trigger > span.text.less");
	private By byDayLessButtonUpArrow = By.cssSelector("div.panel-1 > div > div > div > div > div.toggle.trigger > svg");
	private By byNightLessButton = By.cssSelector("div.panel-2 > div > div > div > div.conditions-card.card.panel.allow-wrap.expanded > div.toggle.trigger > span.text.less");
	private By byNightLessButtonUpArrow = By.cssSelector("div.panel-2 > div > div > div > div > div.toggle.trigger > svg");
	private By byEveningCTAFromNightOrganism = By.cssSelector("div.page-column-1 > div > div > div > div.panel-2 > div > div.quarter-day-links > a.card-button.quarter-day-link.left");
	private By byOvernightCTAFromNightOrganism = By.cssSelector("div.page-column-1 > div> div > a.card-button.quarter-day-link.left");
	
	
	public void isclickedonCurrentweathercard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bycurrentWeatherCard).syncVisible();
		getDriver().findElement(bycurrentWeatherCard).click();
	}

	public void isclickedonRecentLocationWeatherIcon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byRecentLocationWeatherIcon).syncVisible();
		getDriver().findElement(byRecentLocationWeatherIcon).click();
	}

	public String isclickedonCurrentweathercard2() {
		WebPageLoaded.isDomInteractive();
		WebElement currentcard = getDriver().findElement(bycurrentWeatherCard);
		String url = getDriver().getCurrentUrl();
		return url;
	}

	public void TitleofCurrentweathercard() {
		WebPageLoaded.isDomInteractive();
		String Title = getDriver().findElement(bycurrentWeatherTitle).getText();
	}

	public String timeoncurrentconditionpage() {
		WebPageLoaded.isDomInteractive();
		String time = getDriver().findElement(bycurrentconditiontime).getText();
		return time;
	}

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

	public Boolean weathericondisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bycurrentconditionweathericon).isDisplayed();
		return icondisplayed;
	}

	public Boolean bydayOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	public Boolean bynightOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(byNightOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	public String temperatureinbold() {
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bycurrentconditionTemperaure).getCssValue("font-weight");
		return fontsize;
	}

	public String validateElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title Sunrise displayed in grey")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bysunriseTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Sunset displayed in grey"))
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bysunsetTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Sunrise Time displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bysunrisetime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Sunset Time displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bysunsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Duration displayed in grey")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(byduartionTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Duration displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydurationTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Moonrise displayed in grey")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonriseTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise Time displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonriseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Moonset displayed in grey")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonsetTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonset Time displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise moonset Duration Title  displayed in grey")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonrisemoonsetduration).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise moonset Duration time displayed in Black")) 
		{
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bymoonrisemoonsetdurationtime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather compass icon")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightcurrentconditionCompassicon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Gusts")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather wind")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Ice")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Snow")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Rain")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Precipitation")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			System.out.println("actualcolourdisplayed:"+actualcolourdisplayed);
			return actualcolourdisplayed;
		}

//		if (element.equals("night Organism Current Weather MaxUVIdex")) {
//			WebPageLoaded.isDomInteractive();
//			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex).getCssValue("color");
//			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
//			return actualcolourdisplayed;
//		}

		if (element.equals("day Oragnism Current Weather Compass Icon")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherCompassIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Gusts")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Wind")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather ice")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather snow")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather rain")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Precipitation")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation2).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOragnismCurrentWeatherThunderstorms).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Organism Current Weather MaxUVIdex")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherMaxUVIdex).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("time displayed")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditiontime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Real feel temparature")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionRealfeelTemp).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionHumidity).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("UV index")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionUVIndex).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("cloud cover")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionCloudCover).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("pressure")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionPressure).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("dew point")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionDewPoint).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("visibility")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionVisibility).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("real feel shade")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionRealfeelshade).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("compass icon")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionCompassicon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("wind")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("gusts")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bycurrentconditionGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		return timedisplayedcolour;
	}

	public Boolean HourlyCTAdisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentconditionHourlyCTB).isDisplayed();
	}

	public String dayCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bydayOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	public String nightCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bynightOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	public String rightarrowcolour() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byrightarrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String clickonHourlyCTA() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bycurrentconditionHourlyCTB).jsClick();
		return getDriver().getCurrentUrl();
	}

	public String currentDateonAccPage() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentdate).getText();
	}

	public String getCurrentDate() {
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		String strDateFormat = "MMM-dd"; // Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // Date format string is passed as an argument to
		return objSDF.format(objDate);
	}

	public String arrownexttodate() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byrightarrownnexttoDate).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String clickonNextdatearrow() throws InterruptedException {
		WebPageLoaded.isDomInteractive();
		Thread.sleep(5000);
		getDriver().findElement(bynextDaylink).jsClick();
		Thread.sleep(5000);
		return getDriver().getCurrentUrl();
	}

	public Boolean todayOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bydayorganism).isDisplayed();
	}

	public Boolean nightOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(byNightOrganismWeatherCurrenTempearture).isDisplayed();
	}

	public Boolean temperatureHistoryOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTitle() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismDate() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismDate).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodayHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismTodayHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismNormalHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismRecordHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismLastYearHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismLastYearHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodayFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismTodayFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodaySecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismTodaySecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismNormalFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismNormalSecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismRecordFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismRecordSecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismLastYearFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismLastYearFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismLastYearSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bytemperatureHistoryOrganismLastYearSecondRowValue).isDisplayed();
	}

	public void scrollPage() {
		WebPageLoaded.isDomInteractive();
		Robot robot = null;
		try {
			robot = new Robot();
		}
 catch (AWTException e) {
			e.printStackTrace();
		}

		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	public Boolean isDayOranismTitleIsInUppercase(String DayOranismTextValue) {
		String Text = DayOranismTextValue;
		WebPageLoaded.isDomInteractive();
		String Daytext = getDriver().findElement(bydayorganismTitle).getText().toLowerCase();
		Daytext.compareTo("DAY");
		String DayOrganismTextinBoldActual = getDriver().findElement(bydayorganismTitle).getText().toLowerCase();
		String DayOrganismTextinBoldExpected = Text.toLowerCase();
		if (DayOrganismTextinBoldActual.equals(DayOrganismTextinBoldExpected))
			return true;
		else
			return false;
	}

	public String dayOrganismTextTitleisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bydayorganismTitle).getCssValue("font-weight");
		return dayOrganismFont;
	}

	public Boolean nightOrganismTextTitleisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismTextInCaps = getDriver().findElement(bynightOrganismTextInBold).getText();
		String dayOrganismFont = getDriver().findElement(bynightOrganismTextInBold).getCssValue("font-weight");
		return dayOrganismFont.equalsIgnoreCase("500") && dayOrganismTextInCaps.equals("NIGHT");
	}

	public String dayOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bydayOrganismWeatherCurrenTempearture).getCssValue("font-weight");
		return dayOrganismFont;
	}

	public Boolean nightOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(byNightOrganismWeatherCurrenTempearture).getCssValue("font-weight");
		return dayOrganismFont.equals("300");
	}

	public Boolean dayOrganismDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean dayDatedisplayed = getDriver().findElement(bydayOrganismDate).isDisplayed();
		return dayDatedisplayed;
	}

	public Boolean nightOrganismDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean dayDatedisplayed = getDriver().findElement(bynightOrganismDate).isDisplayed();
		return dayDatedisplayed;
	}

	public Boolean dayOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean dayIcondisplayed = getDriver().findElement(bydayOrganismWeatherIcon).isDisplayed();
		return dayIcondisplayed;
	}

	public Boolean nightOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean dayIcondisplayed = getDriver().findElement(bynightOrganismWeatherIcon).isDisplayed();
		return dayIcondisplayed;
	}


	public Boolean Sunrisesunsetorganismdisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
	}

	public Boolean IssuniconDisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bysunIcon).isDisplayed();
		return icondisplayed;
	}

	public String Sunicon() {
		WebPageLoaded.isDomInteractive();
		String displayedcolour = getDriver().findElement(bysunIcon).getCssValue("color");
		String Actualcolourdisplayed = Color.fromString(displayedcolour).asHex();
		return Actualcolourdisplayed;
	}

	public boolean Historicalweatherdata() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bymoreHistoricalWeatherData).isDisplayed();
	}

	public String morehistoricalCTAcolour() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(bymoreHistoricalCTAarrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String Sunrisetimeinbold()
	{
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bysunrisetime).getCssValue("font-weight");
		return fontsize;
	}

	public String Sunsettimeinbold()
	{
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bysunsetTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Durationtimeinbold()
	{
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bydurationTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Moonrisetimeinbold()
	{
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bymoonriseTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Moonsetimeinbold() {
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bymoonsetTime).getCssValue("font-weight");
		return fontsize;
	}

	public String moonrisemoonsetDurationtimeinbold() {
		WebPageLoaded.isDomInteractive();
		String fontsize = getDriver().findElement(bymoonrisemoonsetdurationtime).getCssValue("font-weight");
		return fontsize;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Boolean dayOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherMaxUVIndexdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherMaxUVIdex).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherThunderstormsdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOragnismCurrentWeatherThunderstorms).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherPrecipitation2displayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation2).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherRaindisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherSnowdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherSnow).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherIcedisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherIce).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherHoursOfPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherHoursOfRaindisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherWeatherWinddisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherWind).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherGustsdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherGusts).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherCompassIcondisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherCompassIcon).isDisplayed();
		return icondisplayed;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Boolean nightOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherThunderstormdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherPrecipitationtowdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherRaindisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherSnowdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherSnow).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherIcedisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherIce).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherHoursOfPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherHoursOfRaindisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherWinddisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherWind).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherGustsdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherGusts).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherCompassiondisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightcurrentconditionCompassicon).isDisplayed();
		return icondisplayed;
	}
	
	/**
	 * Method to verify more button is present on day/night cards
	 * @author SOWMIYA
	 * Boolean - return value - "true if more button is present"
	 * */
	public Boolean isMoreButtonPresent() {
		WebPageLoaded.isDomInteractive();
		WebElement dayMoreButton = getDriver().findElement(byDayMoreButton);
		WebElement nightMoreButton = getDriver().findElement(byNightMoreButton);
		return dayMoreButton.syncVisible(15) && nightMoreButton.syncVisible(15);
	}
	
	/**
	 * Method to verify less button is present on click of more button on day cards
	 * @author SOWMIYA
	 * Boolean - return value - "true if less button and less arrow is present"
	 * */
	public Boolean verifyLessIsShownOnClickOfMoreButtonOnDayCard() {
		WebPageLoaded.isDomInteractive();
		WebElement dayMoreButton = getDriver().findElement(byDayMoreButton);
		dayMoreButton.syncVisible(15);
		dayMoreButton.click();
		//verify less button is present and arrow next to less button is present
		WebElement dayLessButton = getDriver().findElement(byDayLessButton);
		WebElement dayLessButtonUpArrow = getDriver().findElement(byDayLessButtonUpArrow);
		
		return dayLessButton.syncVisible(15) && dayLessButtonUpArrow.syncVisible(15);
	}
	
	/**
	 * Method to verify less button is present on click of more button on night cards
	 * @author SOWMIYA
	 * Boolean - return value - "true if less button and less arrow is present"
	 * */
	public Boolean verifyLessIsShownOnClickOfMoreButtonOnNightCard() {
		WebPageLoaded.isDomInteractive();
		WebElement nightMoreButton = getDriver().findElement(byNightMoreButton);
		nightMoreButton.syncVisible(15);
		nightMoreButton.jsClick();
		//verify less button is present and arrow next to less button is present
		WebElement nightLessButton = getDriver().findElement(byNightLessButton);
		WebElement nightLessButtonUpArrow = getDriver().findElement(byNightLessButtonUpArrow);
		
		return nightLessButton.syncVisible(15) && nightLessButtonUpArrow.syncVisible(15);
	}
	
	/**
	 * Method to click on today's weather card on night cards
	 * @author SOWMIYA
	 * Boolean - return value - "true if less button and less arrow is present"
	 * */
	public void isclickedonTodayWeathercard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTodayWeatherCard).syncVisible(15);
		getDriver().findElement(byTodayWeatherCard).click();
	}
	
	/**
	 * Method to click on evening CTA on night card - today's module
	 * @author SOWMIYA
	 * Boolean - return value - "Evening URL"
	 * */
	public String clickEveningCTA() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byEveningCTAFromNightOrganism).syncVisible(15);
		getDriver().findElement(byEveningCTAFromNightOrganism).click();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to click on overnight CTA on evening card - today's module
	 * @author SOWMIYA
	 * Boolean - return value - "Overnight URL"
	 * */
	public String clickOvernightCTA() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byEveningCTAFromNightOrganism).syncVisible(15);
		getDriver().findElement(byEveningCTAFromNightOrganism).click();
		getDriver().findElement(byOvernightCTAFromNightOrganism).syncVisible(15);
		getDriver().findElement(byOvernightCTAFromNightOrganism).click();
		return getDriver().getCurrentUrl();
	}
}
