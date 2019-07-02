package com.accuweather.glacier.www.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;

public class DayPartsPage extends BasePage {
	private By byCurrentweatherMorningLink = By.cssSelector(".panel-1 .left");
	private By byCurrentweatherAfterNoonLink = By.cssSelector("div.sliding-panel.sliding-panel.half-day > div > div.panel-1 > div > div.quarter-day-links > a.card-button.quarter-day-link.right");
	private By byMorningOrganismTitle = By.cssSelector(".conditions-card > .module-header:nth-child(1)");
	private By byMorningOrganismWeatherIcon = By.cssSelector(".weather-icon:nth-child(1)");
	private By byMorningOrganismCurrentTemperature = By.cssSelector(".value");
	private By byMorningOrganismReelFeelTemperature = By.cssSelector(".realFeel");
	private By byMorningOrganismWeatherDescription = By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
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
	private By byMorningOrganismAfternoonLink = By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-links.content-module > a.card-button.quarter-day-link.left");
	private By byMorningOrganismAfternoonLinkText = By.cssSelector(".left > .text");
	private By byMorningOrganismAfternoonLinkArrow = By.cssSelector(".left path");
	private By byMorningOrganismDayAndNightLink = By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.quarter-day-links.content-module > a.card-button.quarter-day-link.right");
	private By byMorningOrganismDayAndNightLinkText = By.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span");
	private By byMorningOrganismDayAndNightLinkArrow = By.cssSelector("div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg");
	private By byMorningOrganismElement = By.cssSelector(".conditions-card > .module-header:nth-child(1)");
	private By byAfterNoonOrganismElement = By.cssSelector("div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
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
	private By byMorningWeatherCardTemperatureHistoryTitle = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.title > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryDate = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.title > span.module-header.sub");
	private By byMorningWeatherCardTemperatureHistoryTodayHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeader = By.cssSelector(
			"div.temp-history.content-module > div.header.card > div.row > span.label.last");
	private By byMorningWeatherCardTemperatureHistoryTodayHeaderFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryTodayHeaderSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(1)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeaderFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryNormalHeaderSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(2)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeaderFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryRecordHeaderSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span:nth-child(3)");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeaderFirstRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(1) > span.label.last");
	private By byMorningWeatherCardTemperatureHistoryLastYearHeaderSecondRowValue = By.cssSelector(
			"div.temp-history.content-module > div.history.card > div:nth-child(2) > span.label.last");
	private By byNationalNewsFeedtext = By.cssSelector(
			"div.zone-centerWell2 > div > p");
	private By byContentCirculationArticleOneImage = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(2) > img");
	private By byContentCirculationArticleOneTitle = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-title > h4");
	private By byContentCirculationArticleOneCategory = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleOnePublishDate = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleTwoPublishImage = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(5) > img");
	private By byContentCirculationArticleTwoPublishTitle = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-title > h4");
	private By byContentCirculationArticleTwoPublishCategory = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(5) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleTwoPublishDate = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(5) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleThreePublishImage = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6) > img");
	private By byContentCirculationArticleThreePublishTitle = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-title > h4");
	private By byContentCirculationArticleThreePublishCategory = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleThreePublishDate = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleFourPublishImage = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(7) > img");
	private By byContentCirculationArticleFourPublishTitle = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-title > h4");
	private By byContentCirculationArticleFourPublishCategory = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleFourPublishDate = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(7) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleFivePublishImage = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(8) > img");
	private By byContentCirculationArticleFivePublishTitle = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(8) > div > div.tout-title > h4");
	private By byContentCirculationArticleFivePublishCategory = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(8) > div > div.tout-meta > span.tout-type");
	private By byContentCirculationArticleFivePublishDate = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(8) > div > div.tout-meta > span.tout-date");
	private By byContentCirculationArticleLinkOne = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(2)");
	private By byContentCirculationArticleLinkTwo = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(5)");
	private By byContentCirculationArticleLinkThree = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(6)");
	private By byContentCirculationArticleLinkFour = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(7)");
	private By byContentCirculationArticleLinkFive = By.cssSelector(
			"div.zone-centerWell2 > div > a:nth-child(8)");
	private By byAfterNoonOrganismWeatherIcon = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > img");
	private By byAfterNoonOrganismCurrentTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value");
	private By byAfterNoonOrganismReelFeelTemperature = By.cssSelector(
			"div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel");
	private By byAfterNoonOrganismWeatherDescription = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
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
	private By byAfterNoonDayAndNightOrganismLinkText = By.cssSelector(
			"div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > span");
	private By byAfterNoonOrganismDayAndNightLinkArrow = By.cssSelector(
			"div.quarter-day-links.content-module > a.card-button.quarter-day-link.right > div > svg");
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
	private By byEveningOrganismElement = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byEveningOrganismWeatherIcon = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > img");
	private By byeveningOrganismCurrentTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.value");
	private By byeveningOrganismReelFeelTemperature = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.temp-icon-wrapper > div > p.realFeel");
	private By byEveningOrganismWeatherDescription = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > div.phrase");
	private By byCurrentweatherOverNightLink = By.cssSelector(
			"div.sliding-panel.sliding-panel.half-day > div > div.panel-2 > div > div.quarter-day-links > a.card-button.quarter-day-link.right");
	private By byOverNightOrganismElement = By.cssSelector(
			"div.quarter-day-card-wrapper > div.conditions-card.card.quarter-day-card > p:nth-child(1)");
	private By byMorningOrganismCurrentTemperature2 = By.cssSelector(
			"div.template-root:nth-child(1) div.two-column-page-content:nth-child(6) div.page-column-1 div.quarter-day-card-wrapper div.conditions-card.card.quarter-day-card div.temp-icon-wrapper:nth-child(3) div.temperatures > p.value");
	//private By byTodayWeatherCard = By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2)");
	
	private By byTodayWeatherCard = By.cssSelector(".day-panel"); 
	
	/**
	 * Method to scroll into page
	 * 
	 * @author Mohammed Siddiq
	 * 
	 **/
	public void scrollPagewithCounter(int count) {
		for (int i = count ; i > 0; i--) {
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
					try {
						Thread.sleep(2000);
					}
 catch (InterruptedException e) {
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
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byTodayWeatherCard).syncVisible();
		getDriver().findElement(byTodayWeatherCard).jsClick();
	}
	/**
	 * Method to click on Current Weather cards Morning link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Morning weather Page
	 **/
	public String currentweatherMorningLinkISClicked() {
		WebPageLoaded.isDomInteractive(30000);
		getDriver().findElement(byCurrentweatherMorningLink).syncVisible();
		getDriver().findElement(byCurrentweatherMorningLink).jsClick();
		getDriver().findElement(byMorningOrganismTitle).syncVisible();
		WebPageLoaded.isDomInteractive(30000);
		return getDriver().getCurrentUrl();
	}
	/**
	 * Method to click on Current Weather cards AfterNoon link
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to AfterNoon weather Page
	 **/
	public String currentweatherAfterNoonLinkISClicked() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byCurrentweatherAfterNoonLink).syncVisible();
		getDriver().findElement(byCurrentweatherAfterNoonLink).jsClick();
		getDriver().findElement(byAfterNoonOrganismElement).syncVisible();
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}
	/**
	 * Method to click on Current Weather cards Evening link
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Evening weather Page
	 **/
	public String currentweatherEveningLinkISClicked() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byCurrentweatherEveningLink).syncVisible();
		getDriver().findElement(byCurrentweatherEveningLink).jsClick();
		getDriver().findElement(byEveningOrganismElement).syncVisible();
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}
	/**
	 * Method to click on Current Weather cards Night link
	 * @author Mohammed Siddiq
	 * @return-String - Returns url navigated to Night weather Page
	 **/
	public String currentweatherOverNightLinkISClicked() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byCurrentweatherOverNightLink).syncVisible();
		getDriver().findElement(byCurrentweatherOverNightLink).jsClick();
		getDriver().findElement(byOverNightOrganismElement).syncVisible();
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}
	/**
	 * Method to scroll on any Page
	 * @author Mohammed Siddiq
	 **/
	public void scrollToelment() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(byCurrentweatherMorningLink).syncVisible();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				byCurrentweatherMorningLink);
		try {
			Thread.sleep(3000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to validate Morning organism Title is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String morningOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningOrganismElement).syncVisible();
		String fontsize = getDriver().findElement(byMorningOrganismElement).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate AfterNoon organism Title is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String afterNoonOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonOrganismElement).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonOrganismElement).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate Morning Evening Title is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the title
	 **/
	public String eveningOrganismTitleISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byEveningOrganismElement).syncVisible();
		String fontsize = getDriver().findElement(byEveningOrganismElement).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate Night organism Title is Bold
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
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String morningOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningOrganismElement).syncVisible();
		String fontsize = getDriver().findElement(byMorningOrganismCurrentTemperature).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate Morning organism temperature is displayed
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
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String afterNoonOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonOrganismCurrentTemperature).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonOrganismCurrentTemperature).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate evening organism Temperature is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the temperature
	 **/
	public String eveningOrganismCurrentTemperatureISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byeveningOrganismCurrentTemperature).syncVisible();
		String fontsize = getDriver().findElement(byeveningOrganismCurrentTemperature).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate Morning organism Sunrise Time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String morningOrganismSuriseTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningOrganismTitle).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardSunriseTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate afternoon organism Sunrise time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String afterNoonOrganismSuriseTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonWeatherCardSunriseTime).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonWeatherCardSunriseTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate Morning organism sunset time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunset time
	 **/
	public String morningOrganismSunsetTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningOrganismTitle).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardSunsetTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate afternoon organism sunset time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunset time
	 **/
	public String afterNoonOrganismSunsetTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonWeatherCardSunsetTime).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonWeatherCardSunsetTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate morning organism sunrise duration time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise duration time
	 **/
	public String morningOrganismSunriseSunsetDurationTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime)
				.getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate afternoon organism Sunrise/sunset card duration time is
	 * Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Sunrise /Sunset card time
	 **/
	public String afterNoonOrganismSunriseSunsetDurationTimeISbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime)
				.getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate morning organism Moon rise time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise time
	 **/
	public String morningOrganismMoonRiseTimeIsbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningWeatherCardMoonRiseTime).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardMoonRiseTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate afternoon organism Moon rise time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise time
	 **/
	public String afterNoonOrganismMoonRiseTimeIsbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate morning organism Moon set time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon Set time
	 **/
	public String morningOrganismMoonSetTimeIsbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningWeatherCardMoonsetTime).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardMoonsetTime).getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate morning organism moon set duration time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the sunrise time
	 **/
	public String morningOrganismMoonRiseMoonSetDurationTimeIsbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
		String fontsize = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime)
				.getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate afternoon organism Moon rise duration time is Bold
	 * @author Mohammed Siddiq
	 * @return-String - Returns Font size of the Moon rise duration time
	 **/
	public String afterNoonOrganismMoonRiseMoonSetDurationTimeIsbold() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
		String fontsize = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime)
				.getCssValue("font-weight");
		return fontsize;
	}
	/**
	 * Method to validate over night organism elements are grey
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateOverNightOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byOverNightOrganismElement).syncVisible();
			timedisplayedcolour = getDriver().findElement(byOverNightOrganismElement).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}
	/**
	 * Method to validate evening organism elements
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateEveningOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byEveningOrganismElement).syncVisible();
			timedisplayedcolour = getDriver().findElement(byEveningOrganismElement).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byeveningOrganismCurrentTemperature).syncVisible();
			timedisplayedcolour = getDriver().findElement(byeveningOrganismCurrentTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byeveningOrganismReelFeelTemperature).syncVisible();
			timedisplayedcolour = getDriver().findElement(byeveningOrganismReelFeelTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismPrecipitationProbability).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismPrecipitationProbability)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
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
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value
	 **/
	public String validateAfterNoonOrganismElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("MoonRise/MoonSet Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetIcon)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("MoonRise/MoonSet Duration time text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("MoonRise/MoonSet Duration text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationText)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("MoonSet Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("MoonRise Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("MoonRise MoonSet")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonsetText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonsetText)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismReelFeelTemperature).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismReelFeelTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismCurrentTemperature).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismCurrentTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismCurrentTemperature).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismCurrentTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismPrecipitationProbability).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismPrecipitationProbability)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismPrecipitationHumidity)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Precipitation")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismPrecipitation).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Rain")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismRain).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Snow")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismSnow).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Ice")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismIce).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Cloud Cover")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismCloudCover).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismCloudCover).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Dew Point")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismDewPoint).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismDewPoint).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Visibility")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismVisibility).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismVisibility).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Comopass Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismCompassIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismCompassIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Wind")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismWind).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Gusts")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonOrganismGusts).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonOrganismGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}
	/**
	 * Method to validate Morning organism elements are grey
	 * @author Mohammed Siddiq
	 * @return-String - Returns the color value
	 **/
	public String validateElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismElement).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismElement).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Current Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismElement).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismCurrentTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Reel Feel Temperature")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismElement).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismReelFeelTemperature).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Precipitation Probablity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismPrecipitationProbability).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismPrecipitationProbability)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Humidity")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismHumidity).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismHumidity)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Precipitation")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismPrecipitation).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Rain")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismRain).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Snow")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismSnow).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Ice")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismIce).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Cloud Cover")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismCloudCover).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismCloudCover).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Dew Point")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismDewPoint).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismDewPoint).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Visibility")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismVisibility).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismVisibility).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Comopass Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismCompassIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismCompassIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Wind")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismWind).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (element.equals("Gusts")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningOrganismGusts).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningOrganismGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}
	/**
	 * Method to validate National News feed Text is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean nationalNewsFeedTextIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byNationalNewsFeedtext).syncVisible();
		return getDriver().findElement(byNationalNewsFeedtext).isDisplayed();
	}
	/**
	 * Method to validate weather icon is displayed on Morning organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean weatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningOrganismWeatherIcon).isDisplayed();
		return true;
	}
	/**
	 * Method to validate weather icon is displayed on afternoon organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean afterNoonweatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonOrganismWeatherIcon).isDisplayed();
		return true;
	}
	/**
	 * Method to validate weather icon is displayed on evening organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean eveningweatherIconIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byEveningOrganismWeatherIcon).isDisplayed();
		return true;
	}
	/**
	 * Method to validate humidity is displayed on Morning organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean weatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningOrganismHumidity).syncVisible();
		getDriver().findElement(byMorningOrganismHumidity).isDisplayed();
		return true;
	}
	/**
	 * Method to validate weather description is displayed on afternoon organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonweatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonOrganismWeatherDescription).syncVisible();
		getDriver().findElement(byAfterNoonOrganismWeatherDescription).isDisplayed();
		return true;
	}
	/**
	 * Method to validate CTA is displayed on evening organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean eveningweatherDescripitionIsdisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byEveningOrganismWeatherDescription).syncVisible();
		getDriver().findElement(byEveningOrganismWeatherDescription).isDisplayed();
		return true;
	}
	/**
	 * Method to validate cta is displayed on afternoon organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoonCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byMorningOrganismAfternoonLinkText).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate cta is displayed on afternoon/Day and Night organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoondayAndNightCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byAfterNoonDayAndNightOrganismLinkText).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate cta is displayed in orange color on afternoon organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoonCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byMorningOrganismAfternoonLinkArrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate cta is displayed in orange color on morning/Day and Night
	 * organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String dayAndNightCTATextIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byMorningOrganismDayAndNightLinkText).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate CTA is displayed in orange color on Morning/Day and Night
	 * organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String dayAndNightCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byMorningOrganismDayAndNightLinkArrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate CTA is displayed in orange color on Afternoon/Day and
	 * Night organism.
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String afterNoondayAndNightCTAArrowIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		String arrowcolour = getDriver().findElement(byAfterNoonOrganismDayAndNightLinkArrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}
	/**
	 * Method to validate Elements are displayed in grey in color
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String validateElementINAfterNoonWeatherPageIsGrey(String cardElement) {
		String timedisplayedcolour = null;
		if (cardElement.equals("Sunrise SunsetText")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetText).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunriseTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunriseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunset Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunsetTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationText)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Sunset Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}
	/**
	 * Method to validate Elements are displayed in grey in color
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String validateElementINMorningeatherPageIsGrey(String cardElement) {
		String timedisplayedcolour = null;
		if (cardElement.equals("MoonRise/MoonSet Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("MoonRise/MoonSet Duration time text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("MoonRise/MoonSet Duration text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationText)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("MoonSet Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonsetTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("MoonRise Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonRiseTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("MoonRise MoonSet")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardMoonRiseMoonsetText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardMoonRiseMoonsetText).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Sunset Icon")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetIcon).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunriseSunsetIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunriseText).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunriseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunset Time")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseTime).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		if (cardElement.equals("Sunrise/Sunset Duration text")) {
			WebPageLoaded.isDomInteractive(5000);
			getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationText).syncVisible();
			timedisplayedcolour = getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationText)
					.getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}
		return timedisplayedcolour;
	}
	/**
	 * Method to validate Sunsrise time of morning Organism is displayed in AM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSuriseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardSunriseTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardSunriseTime).getText().contains("AM");
	}
	/**
	 * Method to validate Sunsrise time of afternoon Organism is displayed in AM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSuriseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardSunriseTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardSunriseTime).getText().contains("AM");
	}
	/**
	 * Method to validate Sunset time of morning Organism is displayed in PM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSunsetTimeIsdisplayedinPM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardSunsetTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardSunsetTime).getText().contains("PM");
	}
	/**
	 * Method to validate Sunset time of afternoon Organism is displayed in PM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSunsetTimeIsdisplayedinPM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardSunsetTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardSunsetTime).getText().contains("PM");
	}
	/**
	 * Method to validate Moon Rise time of morning Organism is displayed in AM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonRiseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardMoonRiseTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardMoonRiseTime).getText().contains("AM");
	}
	/**
	 * Method to validate Moon Rise time of afternoon Organism is displayed in AM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonRiseTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardMoonRiseTime).getText().contains("AM");
	}
	/**
	 * Method to validate Moon set time of morning Organism is displayed in AM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonSetTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardMoonsetTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardMoonsetTime).getText().contains("AM");
	}
	/**
	 * Method to validate Moon set time of afternoon Organism is displayed in PM
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonSetTimeIsdisplayedinAM() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardMoonSetTime).getText().contains("PM");
	}
	/**
	 * Method to validate sun Rise time of morning Organism is displayed in HR
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismSunriseSunsetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardSunriseSunsetDurationTime).getText().contains("hr");
	}
	/**
	 * Method to validate sun set time of afternoon Organism is displayed in HR
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismSunriseSunsetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardSunriseSunsetDurationTime).getText().contains("hr");
	}
	/**
	 * Method to validate moon Rise time of morning Organism is displayed in HR
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean morningOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
		return getDriver().findElement(byMorningWeatherCardMoonRiseMoonSetDurationTime).getText().contains("hr");
	}
	/**
	 * Method to validate Moon rise time of afternoon Organism is displayed in HR
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean afterNoonOrganismMoonRiseMoonSetDurationTimeIsdisplayedinHR() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).syncVisible();
		return getDriver().findElement(byAfterNoonWeatherCardMoonRiseMoonSetDurationTime).getText().contains("hr");
	}
	/**
	 * Method to validate Temperature History title on Morning Weather card is
	 * displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean temperatureHistoryOrganismTitle() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryTitle).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Date on Morning Weather card is
	 * displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismDate() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryDate).isDisplayed();
	}
	/**
	 * Method to validate Temperature History header on Morning Weather card is
	 * displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodayHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryTodayHeader).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Normal Header on Morning Weather card
	 * is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryNormalHeader).isDisplayed();
	}
	/**
	 * Method to validate Temperature History record Header on Morning Weather card
	 * is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryRecordHeader).isDisplayed();
	}
	/**
	 * Method to validate Temperature History last year Header on Morning Weather
	 * card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearHeader() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryLastYearHeader).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Today's First Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodayFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryTodayHeaderFirstRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Normal's First Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryNormalHeaderFirstRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Record's First Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryRecordHeaderFirstRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Record's second Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismRecordSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryRecordHeaderSecondRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History last year's First Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearFirstRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryLastYearHeaderFirstRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History Today's second Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismTodaySecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryTodayHeaderSecondRowValue).isDisplayed();
	}
	/**
	 * Method to validate Temperature History last year's second Row value on
	 * Morning Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismLastYearSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryLastYearHeaderSecondRowValue)
				.isDisplayed();
	}
	/**
	 * Method to validate Temperature History Normal's second Row value on Morning
	 * Weather card is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean temperatureHistoryOrganismNormalSecondRowValue() {
		WebPageLoaded.isDomInteractive();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getDriver().findElement(byMorningWeatherCardTemperatureHistoryNormalHeaderSecondRowValue).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article One Image is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleOneImage).syncVisible();
		return getDriver().findElement(byContentCirculationArticleOneImage).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article Title is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleOneTitle).syncVisible();
		return getDriver().findElement(byContentCirculationArticleOneTitle).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article One Category is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOneCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleOneCategory).syncVisible();
		return getDriver().findElement(byContentCirculationArticleOneCategory).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article One publish date is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleOnePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleOnePublishDate).syncVisible();
		return getDriver().findElement(byContentCirculationArticleOnePublishDate).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article two title is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleTwoPublishTitle).syncVisible();
		return getDriver().findElement(byContentCirculationArticleTwoPublishTitle).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article two category is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleTwoPublishCategory).syncVisible();
		return getDriver().findElement(byContentCirculationArticleTwoPublishCategory).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article two publish date is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoPublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleTwoPublishDate).syncVisible();
		return getDriver().findElement(byContentCirculationArticleTwoPublishDate).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article two Image is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public Boolean contentCirculationArticleTwoImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleTwoPublishImage).syncVisible();
		return getDriver().findElement(byContentCirculationArticleTwoPublishImage).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article three Image is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleThreePublishImage).syncVisible();
		return getDriver().findElement(byContentCirculationArticleThreePublishImage).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article three title is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleThreePublishTitle).syncVisible();
		return getDriver().findElement(byContentCirculationArticleThreePublishTitle).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article three category is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreeCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleThreePublishCategory).syncVisible();
		return getDriver().findElement(byContentCirculationArticleThreePublishCategory).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article three publish date is
	 * displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleThreePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleThreePublishDate).syncVisible();
		return getDriver().findElement(byContentCirculationArticleThreePublishDate).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article four Image is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFourPublishImage).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFourPublishImage).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article four title is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFourPublishTitle).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFourPublishTitle).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article four category is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFourPublishCategory).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFourPublishCategory).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article four publish date is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFourPublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFourPublishDate).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFourPublishDate).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article five Image is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveImageIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFivePublishImage).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFivePublishImage).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article five title is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveTitleIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFivePublishTitle).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFivePublishTitle).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article five category is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFiveCategoryIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFivePublishCategory).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFivePublishCategory).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article five publish date is displayed
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if displayed
	 **/
	public boolean contentCirculationArticleFivePublishDateIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleFivePublishDate).syncVisible();
		return getDriver().findElement(byContentCirculationArticleFivePublishDate).isDisplayed();
	}
	/**
	 * Method to validate Content circulation Article One Navigation
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public Boolean contentCirculationArticleOnenavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleLinkOne).syncVisible();
		getDriver().findElement(byContentCirculationArticleLinkOne).jsClick();
		WebPageLoaded.isDomInteractive();
		return true;
	}
	/**
	 * Method to validate Content circulation Article two Navigation
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleTwonavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleLinkTwo).syncVisible();
		getDriver().findElement(byContentCirculationArticleLinkTwo).jsClick();
		WebPageLoaded.isDomInteractive();
		return true;
	}
	/**
	 * Method to validate Content circulation Article three Navigation
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleThreenavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleLinkThree).syncVisible();
		getDriver().findElement(byContentCirculationArticleLinkThree).jsClick();
		WebPageLoaded.isDomInteractive();
		return true;
	}
	/**
	 * Method to validate Content circulation Article four Navigation
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleFournavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleLinkFour).syncVisible();
		getDriver().findElement(byContentCirculationArticleLinkFour).jsClick();
		WebPageLoaded.isDomInteractive();
		return true;
	}
	/**
	 * Method to validate Content circulation Article five Navigation
	 * @author Mohammed Siddiq
	 * @return-String - Returns true if navigated
	 **/
	public boolean contentCirculationArticleFivenavigtionIsClicked() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byContentCirculationArticleLinkFive).syncVisible();
		getDriver().findElement(byContentCirculationArticleLinkFive).jsClick();
		WebPageLoaded.isDomInteractive();
		return true;
	}
	/**
	 * Method to validate current temperature on morning organism
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
}