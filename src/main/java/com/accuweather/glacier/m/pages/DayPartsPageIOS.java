package com.accuweather.glacier.m.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class DayPartsPageIOS extends BasePage {
	private By byCurrentweatherMorningLink = By.cssSelector(".panel-1 .left");
	private By byCurrentweatherAfterNoonLink = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.quarter-day-links > a.card-button.quarter-day-link.right");
	private By byMorningOrganismTitle = By.cssSelector(".conditions-card > .module-header:nth-child(1)");
	private By byAfterNoonOrganismTitle = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byMorningOrganismWeatherIcon = By.cssSelector(".weather-icon:nth-child(1)");
	private By byMorningOrganismCurrentTemperature = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value");
	private By byMorningOrganismReelFeelTemperature = By.cssSelector(".realFeel");
	private By byMorningOrganismWeatherDescription = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
	private By byMorningOrganismPrecipitationProbability = By.cssSelector(".list > p:nth-child(1)");
	private By byMorningOrganismHumidity = By.cssSelector(".list > p:nth-child(2)");
	private By byMorningOrganismPrecipitation = By.cssSelector(".list > p:nth-child(3)");
	private By byMorningOrganismRain = By.cssSelector("p:nth-child(4)");
	private By byMorningOrganismSnow = By.cssSelector("p:nth-child(5)");
	private By byMorningOrganismIce = By.cssSelector("p:nth-child(6)");
	private By byMorningOrganismCloudCover = By.cssSelector("p:nth-child(7)");
	private By byMorningOrganismDewPoint = By.cssSelector("p:nth-child(8)");
	private By byMorningOrganismVisibility = By.cssSelector("p:nth-child(9)");
	private By byMorningOrganismCompassIcon = By.cssSelector(".icon-wind > .arrow");
	private By byMorningOrganismWind = By.cssSelector(".short-list > p:nth-child(2)");
	private By byMorningOrganismGusts = By.cssSelector(".short-list > p:nth-child(3)");
	private By byMorningOrganismAfternoonLink = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-links.content-module > a.card-button.quarter-day-link.left");
	private By byMorningOrganismAfternoonLinkText = By.cssSelector(".left > .text");
	private By byMorningOrganismAfternoonLinkArrow = By.cssSelector(".left path");
	private By byMorningOrganismDayAndNightLink = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right");
	private By byMorningOrganismDayAndNightLinkText = By
			.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span");
	private By byMorningOrganismDayAndNightLinkArrow = By
			.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg");
	private By byMorningOrganismElement = By.cssSelector(".conditions-card > .module-header:nth-child(1)");
	private By byAfterNoonOrganismElement = By
			.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byMorningWeatherCardSunriseText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > p");
	private By byMorningWeatherCardSunriseTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content");
	private By byMorningWeatherCardSunsetTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byMorningWeatherCardSunriseSunsetDurationText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By byMorningWeatherCardSunriseSunsetDurationTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By byMorningWeatherCardSunriseSunsetIcon = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img");
	private By byMorningWeatherCardMoonRiseMoonsetText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > p");
	private By byMorningWeatherCardMoonRiseTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content");
	private By byMorningWeatherCardMoonsetTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byMorningWeatherCardMoonRiseMoonSetDurationText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By byMorningWeatherCardMoonRiseMoonSetDurationTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By byMorningWeatherCardMoonRiseMoonSetIcon = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > img");
	private By byMorningWeatherCardTemperatureHistoryTitle = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.title > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryDate = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.title > span.module-header.sub");
	private By byMorningWeatherCardTemperatureHistoryTodayHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeader = By
			.cssSelector("div.temp-history.content-module > div.header.card > div.row > span.label.last");
	private By byMorningWeatherCardTemperatureHistoryTodayHeaderFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryTodayHeaderSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeaderFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeaderSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeaderFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeaderSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeaderFirstRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(1) > span.label.last");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeaderSecondRowValue = By
			.cssSelector("div.temp-history.content-module > div.history.card > div:nth-child(2) > span.label.last");
	private By byNationalNewsFeedtext = By.cssSelector("div.zone-centerWell2 > div > p");
	private By byContentCirculationArticleOneImage = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > img");
	private By byContentCirculationArticleOneTitle = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-title > h4");
	private By byContentCirculationArticleOneCategory = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleOnePublishDate = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleTwoPublishImage = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(5) > img");
	private By byContentCirculationArticleTwoPublishTitle = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-title > h4");
	private By byContentCirculationArticleTwoPublishCategory = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(5) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleTwoPublishDate = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(5) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleThreePublishImage = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(6) > img");
	private By byContentCirculationArticleThreePublishTitle = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-title > h4");
	private By byContentCirculationArticleThreePublishCategory = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleThreePublishDate = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleFourPublishImage = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(7) > img");
	private By byContentCirculationArticleFourPublishTitle = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-title > h4");
	private By byContentCirculationArticleFourPublishCategory = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleFourPublishDate = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleFivePublishImage = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(8) > img");
	private By byContentCirculationArticleFivePublishTitle = By
			.cssSelector("div.zone-centerWell2 > div > a:nth-child(8) > div > div.tout-title > h4");
	private By byContentCirculationArticleFivePublishCategory = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleFivePublishDate = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleLinkOne = By.cssSelector("div.zone-centerWell2 > div > a:nth-child(2)");
	private By byContentCirculationArticleLinkTwo = By.cssSelector("div.zone-centerWell2 > div > a:nth-child(5)");
	private By byContentCirculationArticleLinkThree = By.cssSelector("div.zone-centerWell2 > div > a:nth-child(6)");
	private By byContentCirculationArticleLinkFour = By.cssSelector("div.zone-centerWell2 > div > a:nth-child(7)");
	private By byContentCirculationArticleLinkFive = By.cssSelector("div.zone-centerWell2 > div > a:nth-child(8)");
	private By byContentLinkMoreButton = By.cssSelector(
			"body > div.template-root > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.zone-centerWell2 > div > a.more-button > svg");
	private By byAfterNoonOrganismWeatherIcon = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > img");
	private By byAfterNoonOrganismCurrentTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value");
	private By byAfterNoonOrganismReelFeelTemperature = By
			.cssSelector("div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel");
	private By byAfterNoonOrganismWeatherDescription = By
			.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
	private By byAfterNoonOrganismPrecipitationProbability = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(1)");
	private By byAfterNoonOrganismPrecipitationHumidity = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(2)");
	private By byAfterNoonOrganismPrecipitation = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(3)");
	private By byAfterNoonOrganismRain = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(4)");
	private By byAfterNoonOrganismSnow = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(5)");
	private By byAfterNoonOrganismIce = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(6)");
	private By byAfterNoonOrganismCloudCover = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(7)");
	private By byAfterNoonOrganismDewPoint = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(8)");
	private By byAfterNoonOrganismVisibility = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(9)");
	private By byAfterNoonOrganismCompassIcon = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > div");
	private By byAfterNoonOrganismWind = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(2)");
	private By byAfterNoonOrganismGusts = By.cssSelector(
			"div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(3)");
	private By byAfterNoonDayAndNightOrganismLinkText = By
			.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span");
	private By byAfterNoonOrganismDayAndNightLinkArrow = By
			.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg");
	private By byAfterNoonWeatherCardSunriseSunsetText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > p");
	private By byAfterNoonWeatherCardSunriseTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content");
	private By byAfterNoonWeatherCardSunsetTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byAfterNoonWeatherCardSunriseSunsetDurationText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By byAfterNoonWeatherCardSunriseSunsetDurationTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By byAfterNoonWeatherCardSunriseSunsetIcon = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img");
	private By byAfterNoonWeatherCardMoonRiseMoonSetIcon = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > img");
	private By byAfterNoonWeatherCardMoonRiseMoonSetDurationTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last");
	private By byAfterNoonWeatherCardMoonRiseMoonSetDurationText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-header");
	private By byAfterNoonWeatherCardMoonSetTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content");
	private By byAfterNoonWeatherCardMoonRiseTime = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content");
	private By byAfterNoonWeatherCardMoonRiseMoonsetText = By.cssSelector(
			"div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > p");
	private By byCurrentweatherEveningLink = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.quarter-day-links > a.card-button.quarter-day-link.left");
	private By byEveningOrganismElement = By
			.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byEveningOrganismWeatherIcon = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > img");
	private By byeveningOrganismCurrentTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value");
	private By byeveningOrganismReelFeelTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel");
	private By byEveningOrganismWeatherDescription = By
			.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
	private By byCurrentweatherOverNightLink = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.quarter-day-links > a.card-button.quarter-day-link.right");
	private By byOverNightOrganismElement = By
			.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byMorningOrganismCurrentTemperature2 = By.cssSelector(
			"div.template-root:nth-child(1) div.two-column-page-content:nth-child(6) div.page-column-1 div.quarter-day-card-wrapper div.conditions-card.card.quarter-day-card div.temp-icon-wrapper:nth-child(3) div.temperatures > p.value");
	// private By byTodayWeatherCard = By.cssSelector("body > div.template-root >
	// div.two-column-page-content > div.page-column-1 >
	// div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width >
	// div.scroll > a:nth-child(2)");

	private By byTodayWeatherCard = By.cssSelector(
			"div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > p:nth-child(1)");
	private By byMonthDateFromCTA = By
			.cssSelector("div.content-module > div.card-button.content-module.centered > span");
	private By byMonthDate = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p.module-header.sub.date");

	/**
	 * Method to scroll into page
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void scrollPagewithCounter(int count) {
		for (int i = count; i > 0; i--) {
			WebPageLoaded.isDomInteractive();
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to click on Current Weather today
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to current today card
	 **/
	public void isclickedonTodayweathercard() {
		getDriver().findElement(byTodayWeatherCard).jsClick();
	}

	/**
	 * Method to click on Current Weather cards Morning link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Morning weather Page
	 **/
	public String currentweatherMorningLinkISClicked() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCurrentweatherMorningLink).jsClick();
		WebPageLoaded.isDomInteractive(5);
		return getDriver().getCurrentUrl();
	}

	/**
	 * Method to click on Current Weather cards AfterNoon link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to AfterNoon weather Page
	 **/
	public String currentweatherAfterNoonLinkISClicked() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCurrentweatherAfterNoonLink).jsClick();
		getDriver().findElement(byAfterNoonOrganismElement);
		WebPageLoaded.isDomInteractive(5);
		return getDriver().getCurrentUrl();
	}

	/**
	 * Method to click on Current Weather cards Evening link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Evening weather Page
	 **/
	public String currentweatherEveningLinkISClicked() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCurrentweatherEveningLink).jsClick();
		WebPageLoaded.isDomInteractive(5);
		Sleeper.sleep(5);
		return getDriver().getCurrentUrl();
	}

	/**
	 * Method to click on Current Weather cards Night link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Night weather Page
	 **/
	public String currentweatherOverNightLinkISClicked() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCurrentweatherOverNightLink).jsClick();
		getDriver().findElement(byOverNightOrganismElement);
		WebPageLoaded.isDomInteractive(5);
		return getDriver().getCurrentUrl();
	}

	/**
	 * Method to scroll on any Page
	 * 
	 * @author Mohammed Siddiq
	 **/
	public void scrollToelment() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCurrentweatherMorningLink).syncVisible();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				byCurrentweatherMorningLink);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to validate Morning organism Title is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String morningOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismElement).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismElement);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate AfterNoon organism Title is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String afterNoonOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonOrganismElement).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonOrganismElement);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;

	}

	/**
	 * Method to validate Morning Evening Title is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String eveningOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byEveningOrganismElement).scrollIntoView();
		WebElement ele = getDriver().findElement(byEveningOrganismElement);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Night organism Title is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String overNightOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byOverNightOrganismElement).syncVisible();
		String fontsize = getDriver().findElement(byOverNightOrganismElement).getCssValue("font-weight");
		return fontsize;
	}

	/**
	 * Method to validate Morning organism Temperature is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String morningOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismCurrentTemperature).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismCurrentTemperature);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Morning organism temperature is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns the temperature value
	 **/
	public String morningOrganismCurrentTemperatureISdisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningOrganismTitle).syncVisible();
		String text = getDriver().findElement(byMorningOrganismCurrentTemperature2).getText();
		return text;
	}

	/**
	 * Method to validate afternoon organism Temperature is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String afterNoonOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonOrganismCurrentTemperature).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonOrganismCurrentTemperature);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate evening organism Temperature is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String eveningOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byeveningOrganismCurrentTemperature).scrollIntoView();
		WebElement ele = getDriver().findElement(byeveningOrganismCurrentTemperature);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Morning organism Sunrise Time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String morningOrganismSuriseTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismTitle).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismTitle);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate afternoon organism Sunrise time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String afterNoonOrganismSuriseTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonWeatherCardSunriseTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Morning organism sunset time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunset time
	 **/
	public String morningOrganismSunsetTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismTitle).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismTitle);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate afternoon organism sunset time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunset time
	 **/
	public String afterNoonOrganismSunsetTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonWeatherCardSunsetTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunsetTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate morning organism sunrise duration time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise duration time
	 **/
	public String morningOrganismSunriseSunsetDurationTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
				ele);

		System.out.println("FontWeight" + result);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate afternoon organism Sunrise/sunset card duration time is
	 * Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Sunrise /Sunset card time
	 **/
	public String afterNoonOrganismSunriseSunsetDurationTimeISbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate morning organism Moon rise time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise time
	 **/
	public String morningOrganismMoonRiseTimeIsbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningWeatherCardMoonRiseTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate afternoon organism Moon rise time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise time
	 **/
	public String afterNoonOrganismMoonRiseTimeIsbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate morning organism Moon set time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon Set time
	 **/
	public String morningOrganismMoonSetTimeIsbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningWeatherCardMoonsetTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningWeatherCardMoonsetTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return  getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > "
						+ "div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > "
						+ "div.set.content-panel > span.section-content\")).color",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;

	}

	/**
	 * Method to validate morning organism moon set duration time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String morningOrganismMoonRiseMoonSetDurationTimeIsbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;

	}

	/**
	 * Method to validate afternoon organism Moon rise duration time is Bold
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise duration time
	 **/
	public String afterNoonOrganismMoonRiseMoonSetDurationTimeIsbold() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate over night organism elements are grey
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateOverNightOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byOverNightOrganismElement).scrollIntoView();
			WebElement ele = getDriver().findElement(byOverNightOrganismElement);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate evening organism elements
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateEveningOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byEveningOrganismElement).scrollIntoView();
			WebElement ele = getDriver().findElement(byEveningOrganismElement);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byeveningOrganismCurrentTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byeveningOrganismCurrentTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byeveningOrganismReelFeelTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byeveningOrganismReelFeelTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismPrecipitationProbability).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismPrecipitationProbability);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate afternoon organism elements
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateAfterNoonOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("MoonRise/MoonSet Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("MoonRise/MoonSet Duration time text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("MoonRise/MoonSet Duration text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationText).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("MoonSet Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonSetTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("MoonRise Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("MoonRise MoonSet")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonsetText).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonsetText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > p\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismTitle).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismTitle);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismCurrentTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismCurrentTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismReelFeelTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismReelFeelTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismPrecipitationProbability).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismPrecipitationProbability);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Precipitation")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismPrecipitation).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismPrecipitation);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Rain")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismRain).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismRain);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(4)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("Snow")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismSnow).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismSnow);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(5)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Ice")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismIce).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Cloud Cover")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismCloudCover).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismCloudCover);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Dew Point")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismDewPoint).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismDewPoint);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(8)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Visibility")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismVisibility).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismVisibility);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(9)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Comopass Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismCompassIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismCompassIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > div\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Wind")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismWind).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismWind);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Gusts")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonOrganismGusts).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonOrganismGusts);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate Morning organism elements are grey
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns the color value
	 **/
	public String validateElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismElement).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismElement);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismCurrentTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismCurrentTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismReelFeelTemperature).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismReelFeelTemperature);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismPrecipitationProbability).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismPrecipitationProbability);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(1)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismHumidity).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismHumidity);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Precipitation")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismPrecipitation).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismPrecipitation);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Rain")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismRain).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismRain);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(4)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Snow")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismSnow).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismSnow);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(5)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (element.equals("Ice")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismIce).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismIce);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(6)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Cloud Cover")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismCloudCover).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismCloudCover);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(7)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Dew Point")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismDewPoint).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismDewPoint);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(8)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Visibility")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismVisibility).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismVisibility);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.list > p:nth-child(9)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Comopass Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismCompassIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismCompassIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > div > svg\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Wind")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismWind).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismWind);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(2)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (element.equals("Gusts")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningOrganismGusts).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningOrganismGusts);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-card-wrapper > div.details-card.card.quarter-day-card > div.short-list > p:nth-child(3)\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate National News feed Text is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean nationalNewsFeedTextIsDisplayed() {
		WebPageLoaded.isDomInteractive(5);
		scrollUntilElementIsFoundAndClick(byNationalNewsFeedtext);
		return getDriver().findElements(byNationalNewsFeedtext).size() > 0;
	}

	/**
	 * Method to validate weather icon is displayed on Morning organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean weatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byMorningOrganismWeatherIcon).size() > 0;
	}

	/**
	 * Method to validate weather icon is displayed on afternoon organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean afterNoonweatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byAfterNoonOrganismWeatherIcon).size() > 0;
	}

	/**
	 * Method to validate weather icon is displayed on evening organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean eveningweatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byEveningOrganismWeatherIcon).size() > 0;

	}

	/**
	 * Method to validate humidity is displayed on Morning organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean weatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byMorningOrganismHumidity).size() > 0;
	}

	/**
	 * Method to validate weather description is displayed on afternoon organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonweatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byAfterNoonOrganismWeatherDescription).size() > 0;
	}

	/**
	 * Method to validate CTA is displayed on evening organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean eveningweatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byEveningOrganismWeatherDescription).size() > 0;
	}

	/**
	 * Method to validate cta is displayed on afternoon organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoonCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismAfternoonLinkText).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismAfternoonLinkText);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.left > span\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate cta is displayed on afternoon/Day and Night organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoondayAndNightCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonDayAndNightOrganismLinkText).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonDayAndNightOrganismLinkText);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate cta is displayed in orange color on afternoon organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoonCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismAfternoonLinkArrow).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismAfternoonLinkArrow);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.left > div > svg > path\")).fill;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate cta is displayed in orange color on morning/Day and Night
	 * organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String dayAndNightCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismDayAndNightLinkText).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismDayAndNightLinkText);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate CTA is displayed in orange color on Morning/Day and Night
	 * organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String dayAndNightCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byMorningOrganismDayAndNightLinkArrow).scrollIntoView();
		WebElement ele = getDriver().findElement(byMorningOrganismDayAndNightLinkArrow);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate CTA is displayed in orange color on Afternoon/Day and
	 * Night organism.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoondayAndNightCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byAfterNoonOrganismDayAndNightLinkArrow).scrollIntoView();
		WebElement ele = getDriver().findElement(byAfterNoonOrganismDayAndNightLinkArrow);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg\")).fill;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/**
	 * Method to validate Elements are displayed in grey in color
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String validateElementINAfterNoonWeatherPageIsGrey(String cardElement) {
		String timedisplayedcolour = null;
		if (cardElement.equals("Sunrise SunsetText")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetText).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > p\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunriseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunset Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunsetTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunsetTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationText).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Sunset Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate Elements are displayed in grey in color
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String validateElementINMorningeatherPageIsGrey(String cardElement) {
		String timedisplayedcolour = null;
		if (cardElement.equals("MoonRise/MoonSet Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > img\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("MoonRise/MoonSet Duration time text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("MoonRise/MoonSet Duration text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("MoonSet Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("MoonRise Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (cardElement.equals("MoonRise MoonSet")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonsetText).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardMoonRiseMoonsetText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-2 > div > div.row-1 > div > p\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Sunset Icon")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetIcon).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseSunsetIcon);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > img\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunriseText).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > p\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		if (cardElement.equals("Sunrise/Sunset Duration time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-content.last\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunriseTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-1 > div > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunset Time")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunsetTime).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunsetTime);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.set.content-panel > span.section-content\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration text")) {
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationText).scrollIntoView();
			WebElement ele = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationText);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.quarter-sliding-panel.content-module > div > div.panel-1 > div > div.row-2 > div.duration.content-panel > span.section-header\")).color;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;

		}
		return timedisplayedcolour;
	}

	/**
	 * Method to validate Sunsrise time of morning Organism is displayed in AM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSuriseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byMorningWeatherCardSunriseTime).getText().contains("AM");
	}

	/**
	 * Method to validate Sunsrise time of afternoon Organism is displayed in AM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSuriseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byAfterNoonWeatherCardSunriseTime).getText().contains("AM");
	}

	/**
	 * Method to validate Sunset time of morning Organism is displayed in PM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSunsetTimeIsdisplayedinPM() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byMorningWeatherCardSunsetTime).getText().contains("PM");
	}

	/**
	 * Method to validate Sunset time of afternoon Organism is displayed in PM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSunsetTimeIsdisplayedinPM() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byAfterNoonWeatherCardSunsetTime).getText().contains("PM");
	}

	/**
	 * Method to validate Moon Rise time of morning Organism is displayed in AM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonRiseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byMorningWeatherCardMoonRiseTime).getText().contains("AM");
	}

	/**
	 * Method to validate Moon Rise time of afternoon Organism is displayed in AM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonRiseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).getText().contains("AM");
	}

	/**
	 * Method to validate Moon set time of morning Organism is displayed in AM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonSetTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byMorningWeatherCardMoonsetTime).getText().contains("M");
	}

	/**
	 * Method to validate Moon set time of afternoon Organism is displayed in PM
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonSetTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).getText().contains("PM");
	}

	/**
	 * Method to validate sun Rise time of morning Organism is displayed in HR
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSunriseSunsetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).getText().contains("hr");
	}

	/**
	 * Method to validate sun set time of afternoon Organism is displayed in HR
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSunriseSunsetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).getText().contains("hr");
	}

	/**
	 * Method to validate moon Rise time of morning Organism is displayed in HR
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).getText().contains("hr");
	}

	/**
	 * Method to validate Moon rise time of afternoon Organism is displayed in HR
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).getText().contains("hr");
	}

	/**
	 * Method to validate Temperature History title on Morning Weather card is
	 * displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean temperatureHistoryOrganismTitle() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryTitle).size() > 0;
	}

	/**
	 * Method to validate Temperature History Date on Morning Weather card is
	 * displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismDate() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryDate).size() > 0;
	}

	/**
	 * Method to validate Temperature History header on Morning Weather card is
	 * displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodayHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryTodayHeader).size() > 0;
	}

	/**
	 * Method to validate Temperature History Normal Header on Morning Weather card
	 * is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryNormalHeader).size() > 0;
	}

	/**
	 * Method to validate Temperature History record Header on Morning Weather card
	 * is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryRecordHeader).size() > 0;
	}

	/**
	 * Method to validate Temperature History last year Header on Morning Weather
	 * card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryLastYearHeader).size() > 0;
	}

	/**
	 * Method to validate Temperature History Today's First Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodayFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryTodayHeaderFirstRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History Normal's First Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryNormalHeaderFirstRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History Record's First Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryRecordHeaderFirstRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History Record's second Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryRecordHeaderSecondRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History last year's First Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryLastYearHeaderFirstRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History Today's second Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodaySecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryTodayHeaderSecondRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History last year's second Row value on
	 * Morning Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryLastYearHeaderSecondRowValue).size() > 0;
	}

	/**
	 * Method to validate Temperature History Normal's second Row value on Morning
	 * Weather card is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElements(byMorningWeatherCardTemperatureHistoryNormalHeaderSecondRowValue).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article One Image is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleOneImage).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article Title is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleOneTitle).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article One Category is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleOneCategory).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article One publish date is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOnePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleOnePublishDate).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article two title is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		// getDriver().executeJavaScript("window.scrollTo(0, 1550)");
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleTwoPublishTitle);
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleTwoPublishTitle).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article two category is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleTwoPublishCategory).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article two publish date is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoPublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleTwoPublishDate).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article two Image is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollTo(0, 1250)");
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleTwoPublishImage).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article three Image is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleThreePublishImage);
		Sleeper.sleep(3);
		return getDriver().findElements(byContentCirculationArticleThreePublishImage).size() > 0;
	}

	/**
	 * Method to validate Content circulation Article three title is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		scrollUntilElementIsFound(byContentCirculationArticleThreePublishTitle);
		return true;
	}

	/**
	 * Method to validate Content circulation Article three category is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		scrollUntilElementIsFound(byContentCirculationArticleThreePublishCategory);
		return true;
	}

	public void scrollUntilElementIsFound(By element) {
		do {
			getDriver().executeJavaScript("window.scrollTo(0, 250)");
			Sleeper.sleep(1);
		} while (getDriver().findElements(element).size() < 0);

	}

	public boolean scroll2(By element) {
		WebElement ele = getDriver().findElement(element);
		int i = 0;
		do {
			scrollWindow();
			Sleeper.sleep(1);
			i++;
			if (i > 10)
				break;
		} while (!(getDriver().findElements(element).size() > 0));

		if (i <= 10)
			return true;
		else
			return false;

	}

	public boolean scroll3() {
		getDriver().executeJavaScript("window.scrollBy(0, 1750)");
		return true;

	}

	public boolean scrollUntilElementIsFoundAndClick(By element) {
		WebElement ele = getDriver().findElement(element);
		int i = 0;
		do {
			scrollWindow();
			Sleeper.sleep(1);
			i++;
			if (i > 15)
				break;
		} while (!(getDriver().findElements(element).size() > 0));
		Sleeper.sleep(10);
		return getDriver().findElements(element).size() > 0;
	}

	public void scrollWindow() {
		getDriver().executeJavaScript("window.scrollBy(0, 200)");
	}

	/**
	 * Method to validate Content circulation Article three publish date is
	 * displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleThreePublishDate);
		return true;
	}

	/**
	 * Method to validate Content circulation Article four Image is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFourPublishImage);
		return true;
	}

	/**
	 * Method to validate Content circulation Article four title is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFourPublishTitle);
		return true;
	}

	/**
	 * Method to validate Content circulation Article four category is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFourPublishCategory);
		return true;
	}

	/**
	 * Method to validate Content circulation Article four publish date is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourPublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFourPublishDate);
		return true;
	}

	/**
	 * Method to validate Content circulation Article five Image is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFivePublishImage);
		return true;
	}

	/**
	 * Method to validate Content circulation Article five title is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFivePublishTitle);
		return true;
	}

	/**
	 * Method to validate Content circulation Article five category is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFound(byContentCirculationArticleFivePublishCategory);
		return true;
	}

	/**
	 * Method to validate Content circulation Article five publish date is displayed
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFivePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		return scrollUntilElementIsFoundAndClick(byContentCirculationArticleFivePublishDate);
	}

	private void scrollUsingAppium(By element) {
		WebElement ele = getDriver().findElement(element);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("direction", "down");
		params.put("element", (ele));
		getDriver().executeAsyncJavaScript("mobile: swipe", params);

	}

	public Boolean scrollUsingJavaScript(By byContentCirculationArticleFivePublishDate) {
		WebElement ele = getDriver().findElement(byContentCirculationArticleFivePublishDate);
		getDriver().executeAsyncJavaScript("arguments[0].scrollIntoView();", ele);
		return true;
	}

	/**
	 * Method to validate Content circulation Article One Navigation
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public Boolean contentCirculationArticleOnenavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleLinkOne);
		return true;
	}

	/**
	 * Method to validate Content circulation Article two Navigation
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleTwonavigtionIsClicked() {
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleLinkTwo);
		return true;
	}

	/**
	 * Method to validate Content circulation Article three Navigation
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleThreenavigtionIsClicked() {
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleLinkThree);
		return true;

	}

	/**
	 * Method to validate Content circulation Article four Navigation
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleFournavigtionIsClicked() {
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleLinkFour);
		return true;
	}

	/**
	 * Method to validate Content circulation Article five Navigation
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleFivenavigtionIsClicked() {
		scrollUntilElementIsFoundAndClick(byContentLinkMoreButton);
		Sleeper.sleep(3);
		scrollUntilElementIsFoundAndClick(byContentCirculationArticleLinkFive);
		return true;

	}

	/**
	 * Method to validate current temperature on morning organism
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public String getCurrentTemperature() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningOrganismTitle).syncVisible();
		return getDriver().findElement(byMorningOrganismCurrentTemperature).getText();
	}

	/**
	 * Method to validate current temperature
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns current temperature by parsing json response
	 **/
	public String sendGet() throws Exception {
		String url = "http://ncus-gadc-api-production.trafficmanager.net/forecasts/v1/daily/quarters/stations/VIDP.json?apikey=5251445912b143d8b4bee5a741762dd1&locationOffset=5.5&language=en-us&details=False&startDate=2019-05-30T00:00:00Z&dayCount=1&metric=False";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	/**
	 * Method to get the date and month
	 * 
	 * @author Sowmiya
	 * @return-String - date and month
	 **/
	public Boolean verifyDateAndMonthPresent() {

		// get current date and month from calendar
		Calendar c = Calendar.getInstance();

		Format monthNameAndDate = new SimpleDateFormat("MMMM d");
		String getMonthNameWithDateFromCTA = monthNameAndDate.format(c.getTime());

		Format monthNumericAndDate = new SimpleDateFormat("M/d");
		String getMonthNumberWithDate = monthNumericAndDate.format(c.getTime());

		// get current date and month from UI
		WebElement monthDateFromCTA = getDriver().findElement(byMonthDateFromCTA);
		String strMonthDateFromCTA = monthDateFromCTA.getText();

		WebElement monthDate = getDriver().findElement(byMonthDate);
		String strMonthDate = monthDate.getText();

		return strMonthDateFromCTA.equalsIgnoreCase(getMonthNameWithDateFromCTA)
				&& strMonthDate.equalsIgnoreCase(getMonthNumberWithDate);
	}

}
