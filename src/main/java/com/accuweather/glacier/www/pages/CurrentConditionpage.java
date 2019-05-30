package com.accuweather.glacier.www.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

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
			"div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current");
	private By bycurrentWeatherTitle = By.cssSelector(
			"div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p:nth-child(1)");
	private By bycurrentconditiontime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > p.module-header.sub.date");
	private By bycurrentconditionweathericon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > img");
	private By bycurrentconditionTemperaure = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.value");
	private By bycurrentconditionRealfeelTemp = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.temp-icon-wrapper > div > p.realFeel");
	private By bycurrentconditionWeatherDescription = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.conditions-card.card.panel.conditions > div.phrase");
	private By bycurrentconditionHumidity = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(1)");
	private By bycurrentconditionUVIndex = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(2)");
	private By bycurrentconditionCloudCover = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(3)");
	private By bycurrentconditionPressure = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(4)");
	private By bycurrentconditionDewPoint = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(5)");
	private By bycurrentconditionVisibility = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(6)");
	private By bycurrentconditionRealfeelshade = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.list > p:nth-child(7)");
	private By bycurrentconditionCompassicon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > div > svg");
	private By bycurrentconditionWind = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(2)");
	private By bycurrentconditionGusts = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > div > div.details-card.card.panel > div.short-list > p:nth-child(3)");
	private By bycurrentconditionHourlyCTB = By.cssSelector(".current-conditions-card > .card-button");
	private By byrightarrow = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.current-conditions-card.content-module > a > div > svg");
	private By bycurrentdate = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.card-button.content-module.centered > span");
	private By byrightarrownnexttoDate = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.card-button.content-module.centered > a > svg");
	private By bynextDaylink = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.card-button.content-module.centered > a");
	private By bydayorganism = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper");
	private By bydayorganismTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bydayOrganismDate = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > p.module-header.sub.date");
	private By bynightOrganismDate = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > p.module-header.sub.date");
	private By bydayOrganismWeatherIcon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > img");
	private By bynightOrganismWeatherIcon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > img");
	private By bydayOrganismWeatherCurrenTempearture = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value");
	private By bydayOrganismWeatherCurrentReelFeelTemperature = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.realFeel");
	private By bydayOrganismCurrentWeatherDescription = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.phrase");
	private By bydayOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(1)");
	private By bydayOrganismCurrentWeatherMaxUVIdex = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)");
	private By bydayOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)");
	private By bydayOrganismCurrentWeatherRain = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)");
	private By bydayOrganismCurrentWeatherSnow = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)");
	private By bydayOrganismCurrentWeatherIce = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)");
	private By bydayOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)");
	private By bydayOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(9)");
	private By bydayOrganismCurrentWeatherWind = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)");
	private By bydayOrganismCurrentWeatherGusts = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(3)");
	private By bydayOrganismCurrentWeatherCompassIcon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > div > svg");
	private By bynightOrganismCurrentWeather = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > p:nth-child(1)");
	private By bynightOrganismWeatherCurrentTempearture = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.value");
	private By bynightOrganismWeatherCurrentReelFeelTemperature = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.temp-icon-wrapper > div > p.realFeel");
	private By bynightOrganismCurrentWeatherDescription = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.conditions-card.card.panel.allow-wrap > div.phrase");
	private By bynightOrganismCurrentWeatherPrecipitation = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(1)");
	private By bynightOrganismCurrentWeatherMaxUVIdex = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(2)");
	private By bynightOragnismCurrentWeatherThunderstorms = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(3)");
	private By bynightOrganismCurrentWeatherPrecipitation2 = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(4)");
	private By bynightOrganismCurrentWeatherRain = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(5)");
	private By bynightOrganismCurrentWeatherSnow = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(6)");
	private By bynightOrganismCurrentWeatherIce = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(7)");
	private By bynightOrganismCurrentWeatherHoursOfPrecipitation = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(8)");
	private By bynightOrganismCurrentWeatherHoursOfRain = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.list > p:nth-child(9)");
	private By bynightOrganismCurrentWeatherWind = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(2)");
	private By bynightOrganismCurrentWeatherGusts = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > p:nth-child(3)");
	private By bynightcurrentconditionCompassicon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.content > div.details-card.card.panel.details.allow-wrap > div.short-list > div > svg");
	private By bytemperatureHistoryOrganismCurrentWeather = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.title > span:nth-child(1)");
	private By bytemperatureHistoryOrganismDate = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.title > span.module-header.sub");
	private By bytemperatureHistoryOrganismTodayHeader = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.row > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalHeader = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.row > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordHeader = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.row > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearHeader = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.header.card > div.row > span.label.last");
	private By bytemperatureHistoryOrganismTodayFirstRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismTodaySecondRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(1)");
	private By bytemperatureHistoryOrganismNormalFirstRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismNormalSecondRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(2)");
	private By bytemperatureHistoryOrganismRecordFirstRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismRecordSecondRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(3)");
	private By bytemperatureHistoryOrganismLastYearFirstRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(1) > span.label.last");
	private By bytemperatureHistoryOrganismLastYearSecondRowValue = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > div.history.card > div:nth-child(2) > span.label.last");
	private By byRecentLocationWeatherIcon = By.cssSelector(
			"body > div.template-root.current-weather > div.page-subheader.content-module > div > div.recent-locations-label > a.recent-location-display > img");
	private By byTodayCardonThreeDayForecastPage = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p:nth-child(1)");
	private By bysunrisesunsetorganism = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div");
	private By bysunriseTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-header");
	private By bysunrisetime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content");
	private By bysunsetTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-header");
	private By bysunsetTime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byduartionTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By bydurationTime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By bysunIcon = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img");
	private By bymoonriseTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-header");
	private By bymoonriseTime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content");
	private By bymoonsetTitle = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-header");
	private By bymoonsetTime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By bymoonrisemoonsetduration = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By bymoonrisemoonsetdurationtime = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.sliding-panel.sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By bymoreHistoricalWeatherData = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > a > span");
	private By bymoreHistoricalCTAarrow = By.cssSelector(
			"body > div.template-root.current-weather > div.two-column-page-content > div.page-column-1 > div.temp-history.content-module > a > div > svg");

	public void isclickedonCurrentweathercard() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(bycurrentWeatherCard).syncVisible();
		getDriver().findElement(bycurrentWeatherCard).click();
	}

	public void isclickedonRecentLocationWeatherIcon() {
		WebPageLoaded.isDomInteractive(10000);
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
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherDescription).isDisplayed();
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
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather MaxUVIdex")) {
			WebPageLoaded.isDomInteractive();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bydayorganism).isDisplayed();
	}

	public Boolean nightOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bynightOrganismCurrentWeather).isDisplayed();
	}

	public Boolean temperatureHistoryOrganism() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTitle() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismCurrentWeather).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismDate() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismDate).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodayHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodayHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismLastYearHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismLastYearHeader).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodayFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodayFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismTodaySecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismTodaySecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismNormalSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismNormalSecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordFirstRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismRecordSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismRecordSecondRowValue).isDisplayed();
	}

	public Boolean temperatureHistoryOrganismLastYearFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(bytemperatureHistoryOrganismLastYearFirstRowValue).isDisplayed();
	}

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

	public String nightOrganismTextTitleisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bynightOrganismCurrentWeather).getCssValue("font-weight");
		return dayOrganismFont;

	}

	public String dayOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bydayOrganismWeatherCurrenTempearture).getCssValue("font-weight");
		return dayOrganismFont;

	}

	public String nightOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomInteractive();
		String dayOrganismFont = getDriver().findElement(bynightOrganismWeatherCurrentTempearture).getCssValue("font-weight");
		return dayOrganismFont;

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

	public Boolean dayOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}

	public Boolean nightOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomInteractive();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
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
		String displayedcolour = getDriver().findElement(bysunIcon).getCssValue("margin");
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

}
