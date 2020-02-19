package com.accuweather.glacier.www.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.chameleon.Utilities.CommonUtilities;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class CurrentConditionpage extends BasePage
{
	
/**************************************************** LOCATORS **********************************************************************************************/
	
	
/************************************************** CURRENT WEATHER CARD *************************************************************************************/
	private By byCurrentWeatherCard 				= By.cssSelector("div.page-column-1 > div > div > a:nth-child(1)");
	private By byCurrentWeatherTitle 				= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > p:nth-child(1)");
	private By byCurrentWeatherTime 				= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > p:nth-child(2)");
	private By byCurrentWeatherIcon			 		= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > img.weather-icon.icon");
	private By byCurrentWeatherTemp			 		= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > div.temp > span.high");
	private By byCurrentWeatherTempUnit				= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > div.temp > span.low");
	private By byCurrentWeatherRealfeel		 		= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > div.real-feel");
	private By byCurrentWeatherIconPhrase			= By.cssSelector("a.panel.panel-fade-in.card.current > div.day-panel > div.cond");
/******************************************************************************************************************************************************************/
	
	
/************************************************* CURRENT WEATHER MODULE ON THE NEXT PAGE ****************************************************************/
	private By byCurrentWeatherModuleTitle			= By.cssSelector("div.current-conditions-card.content-module > div > div > div > p.module-header.title");
	private By byCurrentWeatherModuleTempUnit		= By.cssSelector("div.current-conditions-card.content-module > div > div > div > p.module-header.title > span.temp-unit");
	private By byCurrentWeatherModuleTime			= By.cssSelector("div.current-conditions-card.content-module > div > div > div > p.module-header.sub.date");
	private By byCurrentWeatherModuleIcon			= By.cssSelector("div.current-conditions-card.content-module > div > div > div > div.temp-icon-wrapper > img");
	private By byCurrentWeatherModuleTemp			= By.cssSelector("div.current-conditions-card.content-module > div > div > div > div.temp-icon-wrapper > div.temperatures > p.value");
	private By byCurrentWeatherModuleRealFeel		= By.cssSelector("div.current-conditions-card.content-module > div > div > div > div.temp-icon-wrapper > div.temperatures > p.realFeel.top");
	private By byCurrentWeatherModuleRealFeelShade	= By.cssSelector("div.current-conditions-card.content-module > div > div > div > div.temp-icon-wrapper > div.temperatures > p:nth-child(3)");
	private By byCurrentWeatherModuleIconPhrase		= By.cssSelector("div.current-conditions-card.content-module > div > div > div > div.phrase");
	private By byCurrentConditionUVIndex = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(1)");
	private By byCurrentConditionWind = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(2)");
	private By byCurrentConditionGusts = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(3)");
	private By byCurrentConditionHumidity = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(4)");
	private By byCurrentConditionDewPoint = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(5)");
	private By byCurrentConditionPressure = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(6)");
	private By byCurrentConditionCloudCover = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(7)");
	private By byCurrentConditionVisibility = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(8)");
	private By byCurrentConditionCeiling = By.cssSelector(
			"div.current-conditions-card.content-module > div > div.accordion-item-content.accordion-item-content > div.details-card.card.panel > div.list > p:nth-child(9)");
/************************************************************************************************************************************************************************************************/	
	
	private By byTodayWeatherCard 					= By.cssSelector("div.page-column-1 > div > div > a:nth-child(2)");
	private By byTonightWeatherCard 				= By.cssSelector("div.page-column-1 > div > div > a:nth-child(3)");
	private By byTomorrowWeatherCard 				= By.cssSelector("div.page-column-1 > div > div > a:nth-child(4)");
	
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
	
/************************************************ TEMPERATURE HISTORY *********************************************************************************/	
	private By byTempHistoryTitle 			= By.cssSelector("div.temp-history > div.header-row.card > div.title > div > span:nth-child(1)");
	private By byTempHistoryDate 			= By.cssSelector("div.temp-history > div.header-row.card > div.title > div > span:nth-child(2)");
	private By byTempHistoryTempUnit 		= By.cssSelector("div.temp-history > div.header-row.card > div.title > div.temp-unit");
	private By byForecastHeaderTempHistory 	= By.cssSelector("div.temp-history > div.header-row.card > div.row > span:nth-child(1)");
	private By byAverageHeaderTempHistory 	= By.cssSelector("div.temp-history > div.header-row.card > div.row > span:nth-child(2)");
	private By byRecordsHeaderTempHistory 	= By.cssSelector("div.temp-history > div.header-row.card > div.row > span:nth-child(3)");
	private By byLastYearHeaderTempHistory 	= By.cssSelector("div.temp-history > div.header-row.card > div.row > span:nth-child(4)");
	private By byHiLabelTempHistory 		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(1) > span:nth-child(1) > span.hi");
	public By byForecastMaxTempHistory 	= By.xpath("/html/body/div/div[5]/div[1]/div[1]/div[6]/div[2]/div[3]/span[1]/text()");
	private By byAverageMaxTempHistory		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(1) > span:nth-child(2)");
	private By byRecordsMaxTempHistory		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(1) > span:nth-child(3) > span.record-temp");
	private By byRecordsMaxTempYearHistory	= By.cssSelector("div.temp-history > div.history.card > div:nth-child(1) > span:nth-child(3) > span.sub");
	private By byLastYearMaxTempHistory 	= By.cssSelector("div.temp-history > div.history.card > div:nth-child(1) > span:nth-child(4)");
	private By byLoLabelTempHistory 		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(1) > span.hi");
	private By byForecastMinTempHistory 	= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(1) > span.hi");
	private By byAverageMinTempHistory		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(2)");
	private By byRecordsMinTempHistory		= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(3) > span.record-temp");
	private By byRecordsMinTempYearHistory	= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(3) > span.sub");
	private By byLastYearMinTempHistory 	= By.cssSelector("div.temp-history > div.history.card > div:nth-child(3) > span:nth-child(4)");
/***********************************************************************************************************************************************************/	
	
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
	

/********************************************************** CURRENT WEATHER CARD METHODS ***************************************************************/	
	
	/**
	 * @author HFARAZ
	 * Method to check if current weather card is displayed
	 * */
	public Boolean isCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		scrollDown(200);
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherCard).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to click current weather card, if displayed
	 * */
	public void clickCurrentweathercard()
	{
		WebPageLoaded.isDomComplete();
		if(isCurrentWeatherCardDisplayed())
			getDriver().findElement(byCurrentWeatherCard).jsClick();
		
		WebPageLoaded.isDomComplete();
		scrollDown(200);
	}

	/**
	 * @author HFARAZ
	 * Method to check if title of current weather card is displayed
	 * */
	public Boolean isTitleOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		scrollDown(100);
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherTitle).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the title of Current weather card
	 * */
	public String getTitleOfCurrentWeathercard()
	{
		scrollDown(200);
		WebPageLoaded.isDomComplete();
		String currentWeatherTitle = null;
		WebPageLoaded.isDomComplete();
		if(isTitleOnCurrentWeatherCardDisplayed())
			currentWeatherTitle = getDriver().findElement(byCurrentWeatherTitle).getText();
		
		return currentWeatherTitle;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if time on current weather card is displayed
	 * */
	public Boolean isTimeOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherTime).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the time on Current weather card
	 * */
	public String getTimeOnCurrentWeatherCard()
	{
		String time = null;
		WebPageLoaded.isDomComplete();
		if (isTimeOnCurrentWeatherCardDisplayed())
		time = getDriver().findElement(byCurrentWeatherTime).getText();
		
		return time;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if time on current weather card is displayed
	 * */
	public Boolean isWeatherIconOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherIcon).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the time on Current weather card
	 * */
	public String getWeatherIconNumberOnCurrentWeatherCard()
	{
		String imageSource = null;
		WebPageLoaded.isDomComplete();
		if (isWeatherIconOnCurrentWeatherCardDisplayed())
			imageSource = getDriver().findElement(byCurrentWeatherIcon).getAttribute("data-src");
		
		return CommonUtilities.getAllCharacters(imageSource).get(1);
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if temperature on current weather card is displayed
	 * */
	public Boolean isTemperatureOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherTemp).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the temperature on Current weather card
	 * */
	public String getTemperatureOnCurrentWeatherCard()
	{
		String temperature = null;
		WebPageLoaded.isDomComplete();
		if (isTemperatureOnCurrentWeatherCardDisplayed())
			temperature = getDriver().findElement(byCurrentWeatherTemp).getText();
		
		return temperature;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if temperature unit on current weather card is displayed
	 * */
	public Boolean isTemperatureUnitOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherTempUnit).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the temperature unit on Current weather card
	 * */
	public String getTemperatureUnitOnCurrentWeatherCard()
	{
		String tempUnit = null;
		WebPageLoaded.isDomComplete();
		if (isTemperatureUnitOnCurrentWeatherCardDisplayed())
			tempUnit = getDriver().findElement(byCurrentWeatherTempUnit).getText();
		
		return tempUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if real feel on current weather card is displayed
	 * */
	public Boolean isRealFeelOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherRealfeel).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the real feel on Current weather card
	 * */
	public String getRealFeelOnCurrentWeatherCard()
	{
		String realFeel = null;
		WebPageLoaded.isDomComplete();
		if (isRealFeelOnCurrentWeatherCardDisplayed())
			realFeel = getDriver().findElement(byCurrentWeatherRealfeel).getText();
		
		return realFeel;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if icon phrase on current weather card is displayed
	 * */
	public Boolean isIconPhraseOnCurrentWeatherCardDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherIconPhrase).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the icon phrase on Current weather card
	 * */
	public String getIconPhraseOnCurrentWeatherCard()
	{
		String iconPhrase = null;
		WebPageLoaded.isDomComplete();
		if (isIconPhraseOnCurrentWeatherCardDisplayed())
			iconPhrase = getDriver().findElement(byCurrentWeatherIconPhrase).getText();
		
		return iconPhrase;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if title on current weather card on next module is displayed
	 * */
	public Boolean isTitleOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleTitle).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the title of Current weather module
	 * */
	public String getTitleOfCurrentWeatherModule()
	{
		String title = null;
		WebPageLoaded.isDomComplete();
		if (isTitleOnCurrentWeatherModuleDisplayed())
			title = getDriver().findElement(byCurrentWeatherModuleTitle).getText();
		
		return title;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if temperature unit on current weather module is displayed
	 * */
	public Boolean isTempUnitOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleTempUnit).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the temperature unit of Current weather module
	 * */
	public String getTempUnitOfCurrentWeatherModule()
	{
		String tempUnit = null;
		WebPageLoaded.isDomComplete();
		if (isTempUnitOnCurrentWeatherModuleDisplayed())
			tempUnit = getDriver().findElement(byCurrentWeatherModuleTempUnit).getText();
		
		return tempUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if time on current weather module is displayed
	 * */
	public Boolean isTimeOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleTime).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the time of Current weather module
	 * */
	public String getTimeOnCurrentWeatherModule()
	{
		String time = null;
		WebPageLoaded.isDomComplete();
		if (isTimeOnCurrentWeatherModuleDisplayed())
			time = getDriver().findElement(byCurrentWeatherModuleTime).getText();
		
		return time;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if temperature  current weather module is displayed
	 * */
	public Boolean isTempOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleTemp).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the temperature of Current weather module
	 * */
	public String getTemperatureOnCurrentWeatherModule()
	{
		String temperature = null;
		WebPageLoaded.isDomComplete();
		if (isTempOnCurrentWeatherModuleDisplayed())
			temperature = getDriver().findElement(byCurrentWeatherModuleTemp).getText();
		
		return temperature;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if weather icon on current weather module is displayed
	 * */
	public Boolean isWeatherIconOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleIcon).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the weather icon number of Current weather module
	 * */
	public String getWeatherIconNumberOnCurrentWeatherModule()
	{
		String weatherIcon = null;
		WebPageLoaded.isDomComplete();
		if (isWeatherIconOnCurrentWeatherModuleDisplayed())
			weatherIcon = getDriver().findElement(byCurrentWeatherModuleIcon).getAttribute("data-src");
		
		return CommonUtilities.getAllCharacters(weatherIcon).get(1);
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if real feel on current weather module is displayed
	 * */
	public Boolean isRealFeelOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleRealFeel).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the real feel value of Current weather module
	 * */
	public String getRealFeelValueOnCurrentWeatherModule()
	{
		String realFeel = null;
		WebPageLoaded.isDomComplete();
		if (isRealFeelOnCurrentWeatherModuleDisplayed())
			realFeel = getDriver().findElement(byCurrentWeatherModuleRealFeel).getText();
		
		return realFeel;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if real feel shade on current weather module is displayed
	 * */
	public Boolean isRealFeelShadeOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleRealFeelShade).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the real feel shade of Current weather module
	 * */
	public String getRealFeelShadeValueOnCurrentWeatherModule()
	{
		String realFeelShade = null;
		WebPageLoaded.isDomComplete();
		if (isRealFeelShadeOnCurrentWeatherModuleDisplayed())
			realFeelShade = getDriver().findElement(byCurrentWeatherModuleRealFeelShade).getText();
		
		return realFeelShade;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Icon Phrase on current weather module is displayed
	 * */
	public Boolean isIconPhraseOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentWeatherModuleIconPhrase).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the Icon Phrase of Current weather module
	 * */
	public String getIconPhraseOnCurrentWeatherModule()
	{
		String iconPhrase = null;
		WebPageLoaded.isDomComplete();
		if (isIconPhraseOnCurrentWeatherModuleDisplayed())
			iconPhrase = getDriver().findElement(byCurrentWeatherModuleIconPhrase).getText();
		
		return iconPhrase;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if UV Index on current weather module is displayed
	 * */
	public Boolean isUVIndexOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionUVIndex).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the UV Index of Current weather module
	 * */
	public String getUVIndexValueOnCurrentWeatherModule()
	{
		String uvIndex = null;
		WebPageLoaded.isDomComplete();
		if (isUVIndexOnCurrentWeatherModuleDisplayed())
			uvIndex = getDriver().findElement(byCurrentConditionUVIndex).getText();
		
		return uvIndex;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Wind on current weather module is displayed
	 * */
	public Boolean isWindOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionWind).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the Wind of Current weather module
	 * */
	public String getWindValueOnCurrentWeatherModule()
	{
		String windValue = null;
		WebPageLoaded.isDomComplete();
		if (isWindOnCurrentWeatherModuleDisplayed())
			windValue = getDriver().findElement(byCurrentConditionWind).getText();
		
		return windValue;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Wind gusts on current weather module is displayed
	 * */
	public Boolean isWindGustsOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionGusts).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the Wind gusts value of Current weather module
	 * */
	public String getWindGustsValueOnCurrentWeatherModule()
	{
		String windGustsValue = null;
		WebPageLoaded.isDomComplete();
		if (isWindGustsOnCurrentWeatherModuleDisplayed())
			windGustsValue = getDriver().findElement(byCurrentConditionGusts).getText();
		
		return windGustsValue;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if humidity on current weather module is displayed
	 * */
	public Boolean isHumidityOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionHumidity).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the Humidity value of Current weather module
	 * */
	public String getHumidityValueOnCurrentWeatherModule()
	{
		String humidityValue = null;
		WebPageLoaded.isDomComplete();
		if (isHumidityOnCurrentWeatherModuleDisplayed())
			humidityValue = getDriver().findElement(byCurrentConditionHumidity).getText();
		
		return humidityValue;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if dew point on current weather module is displayed
	 * */
	public Boolean isDewPointOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionDewPoint).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the dew point value of Current weather module
	 * */
	public String getDewPointValueOnCurrentWeatherModule()
	{
		String dewPoint = null;
		WebPageLoaded.isDomComplete();
		if (isDewPointOnCurrentWeatherModuleDisplayed())
			dewPoint = getDriver().findElement(byCurrentConditionDewPoint).getText();
		
		return dewPoint;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if pressure on current weather module is displayed
	 * */
	public Boolean isPressureOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionPressure).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the pressure value of Current weather module
	 * */
	public String getPressureValueOnCurrentWeatherModule()
	{
		String pressure = null;
		WebPageLoaded.isDomComplete();
		if (isPressureOnCurrentWeatherModuleDisplayed())
			pressure = getDriver().findElement(byCurrentConditionPressure).getText();
		
		return pressure;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if cloud cover on current weather module is displayed
	 * */
	public Boolean isCloudCoverOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionCloudCover).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the cloud cover value of Current weather module
	 * */
	public String getCloudCoverValueOnCurrentWeatherModule()
	{
		String cloudCover = null;
		WebPageLoaded.isDomComplete();
		if (isCloudCoverOnCurrentWeatherModuleDisplayed())
			cloudCover = getDriver().findElement(byCurrentConditionCloudCover).getText();
		
		return cloudCover;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if visibility on current weather module is displayed
	 * */
	public Boolean isVisibilityOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionVisibility).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the visibility value of Current weather module
	 * */
	public String getVisibilityValueOnCurrentWeatherModule()
	{
		String visibility = null;
		WebPageLoaded.isDomComplete();
		if (isVisibilityOnCurrentWeatherModuleDisplayed())
			visibility = getDriver().findElement(byCurrentConditionVisibility).getText();
		
		return visibility;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if ceiling on current weather module is displayed
	 * */
	public Boolean isCeilingOnCurrentWeatherModuleDisplayed()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCurrentConditionCeiling).syncVisible(15,false);
	}

	/**
	 * @author HFARAZ
	 * Method to get the ceiling value of Current weather module
	 * */
	public String getCeilingValueOnCurrentWeatherModule()
	{
		String ceiling = null;
		WebPageLoaded.isDomComplete();
		if (isCeilingOnCurrentWeatherModuleDisplayed())
			ceiling = getDriver().findElement(byCurrentConditionCeiling).getText();
		
		return ceiling;
	}
	
	

/*************************************************************** END OF CURRENT WEATHER CARD METHODS ****************************************************/	
	
/*************************************************************** TEMPERATURE HISTORY METHODS ************************************************************/
	
	/**
	 * @author HFARAZ
	 * Method to check Temperature history title is displayed
	 * */
	public Boolean isTemperatureHistoryTitleDisplayed() 
	{
		scrollDown(900);
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTempHistoryTitle).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Temperature history title
	 * */
	public String getTemperatureHistoryTitle()
	{
		String tempHistoryTitle = null;
		WebPageLoaded.isDomComplete();
		if (isTemperatureHistoryTitleDisplayed())
			tempHistoryTitle = getDriver().findElement(byTempHistoryTitle).getText();
		
		return tempHistoryTitle;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the current date is displayed on Temperature history
	 * */
	public Boolean isDateInTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTempHistoryDate).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get current date on Temperature History
	 * */
	public String getDateInTemperatureHistory()
	{
		String tempHistoryDate = null;
		WebPageLoaded.isDomComplete();
		if (isDateInTemperatureHistoryDisplayed())
			tempHistoryDate = getDriver().findElement(byTempHistoryDate).getText();
		
		return tempHistoryDate;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the temp unit is displayed on Temperature history
	 * */
	public Boolean isTempUnitInTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTempHistoryTempUnit).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get temp unit on Temperature History
	 * */
	public String getTempUnitInTemperatureHistory()
	{
		String tempUnit = null;
		WebPageLoaded.isDomComplete();
		if (isTempUnitInTemperatureHistoryDisplayed())
			tempUnit = getDriver().findElement(byTempHistoryTempUnit).getText();
		
		return tempUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the Forecast header is displayed on Temperature history
	 * */
	public Boolean isForecastHeaderOnTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byForecastHeaderTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Forecast Header on Temperature History
	 * */
	public String getForecastHeaderTextInTemperatureHistory()
	{
		String forecastHeader = null;
		WebPageLoaded.isDomComplete();
		if (isForecastHeaderOnTemperatureHistoryDisplayed())
			forecastHeader = getDriver().findElement(byForecastHeaderTempHistory).getText();
		
		return forecastHeader;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the Average header is displayed on Temperature history
	 * */
	public Boolean isAverageHeaderOnTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byAverageHeaderTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Average Header on Temperature History
	 * */
	public String getAverageHeaderTextInTemperatureHistory()
	{
		String averageHeader = null;
		WebPageLoaded.isDomComplete();
		if (isAverageHeaderOnTemperatureHistoryDisplayed())
			averageHeader = getDriver().findElement(byAverageHeaderTempHistory).getText();
		
		return averageHeader;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the Records header is displayed on Temperature history
	 * */
	public Boolean isRecordsHeaderOnTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRecordsHeaderTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Records Header on Temperature History
	 * */
	public String getRecordsHeaderTextInTemperatureHistory()
	{
		String recordsHeader = null;
		WebPageLoaded.isDomComplete();
		if (isRecordsHeaderOnTemperatureHistoryDisplayed())
			recordsHeader = getDriver().findElement(byRecordsHeaderTempHistory).getText();
		
		return recordsHeader;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the Year header is displayed on Temperature history
	 * */
	public Boolean isLastYearHeaderOnTemperatureHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byLastYearHeaderTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get last year Header on Temperature History
	 * */
	public String getLastYearHeaderTextInTemperatureHistory()
	{
		String yearHeader = null;
		WebPageLoaded.isDomComplete();
		if (isLastYearHeaderOnTemperatureHistoryDisplayed())
			yearHeader = getDriver().findElement(byLastYearHeaderTempHistory).getText();
		
		return yearHeader;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Hi Temperature title is displayed
	 * */
	public Boolean isHiTempTitleDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byHiLabelTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Hi Temperature history title
	 * */
	public String getHiTempTitle()
	{
		String hiTitle = null;
		WebPageLoaded.isDomComplete();
		if (isHiTempTitleDisplayed())
			hiTitle = getDriver().findElement(byHiLabelTempHistory).getText();
		
		return hiTitle;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if Lo Temperature title is displayed
	 * */
	public Boolean isLoTempTitleDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byLoLabelTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get Lo Temperature history title
	 * */
	public String getLoTempTitle()
	{
		String loTitle = null;
		WebPageLoaded.isDomComplete();
		if (isLoTempTitleDisplayed())
			loTitle = getDriver().findElement(byLoLabelTempHistory).getText();
		
		return loTitle;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if year in Records columns for maximum temp is displayed in temperature history
	 * */
	public Boolean isYearForMaxTempDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRecordsMaxTempYearHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the year in the Records column for maximum temperature
	 * */
	public String getYearForMaxTemp()
	{
		String year = null;
		WebPageLoaded.isDomComplete();
		if (isYearForMaxTempDisplayed())
			year = getDriver().findElement(byRecordsMaxTempYearHistory).getText();
		
		return year;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if year in Records columns for minimum temp is displayed in temperature history
	 * */
	public Boolean isYearForMinTempDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRecordsMinTempYearHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the year in the Records column for minimum temperature
	 * */
	public String getYearForMinTemp()
	{
		String year = null;
		WebPageLoaded.isDomComplete();
		if (isYearForMinTempDisplayed())
			year = getDriver().findElement(byRecordsMinTempYearHistory).getText();
		
		return year;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if maximum temp is displayed in Records section in temperature history
	 * */
	public Boolean isMaxTempInRecordsDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRecordsMaxTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the maximum temp in the Records column
	 * */
	public String getMaxTempInRecords()
	{
		String maxTemp = null;
		WebPageLoaded.isDomComplete();
		if (isMaxTempInRecordsDisplayed())
			maxTemp = getDriver().findElement(byRecordsMaxTempHistory).getText();
		
		return maxTemp;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if minimum temp is displayed in Records section in temperature history
	 * */
	public Boolean isMinTempInRecordsDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byRecordsMinTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the minimum temp in the Records column
	 * */
	public String getMinTempInRecords()
	{
		String minTemp = null;
		WebPageLoaded.isDomComplete();
		if (isMinTempInRecordsDisplayed())
			minTemp = getDriver().findElement(byRecordsMinTempHistory).getText();
		
		return minTemp;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if max temp is displayed in Average section in temperature history
	 * */
	public Boolean isMaxTempInAverageDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byAverageMaxTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the max temp in the Average column
	 * */
	public String getMaxTempInAverage()
	{
		String maxTemp = null;
		WebPageLoaded.isDomComplete();
		if (isMaxTempInAverageDisplayed())
			maxTemp = getDriver().findElement(byAverageMaxTempHistory).getText();
		
		return maxTemp;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if min temp is displayed in Average section in temperature history
	 * */
	public Boolean isMinTempInAverageDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byAverageMinTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the min temp in the Average column
	 * */
	public String getMinTempInAverage()
	{
		String minTemp = null;
		WebPageLoaded.isDomComplete();
		if (isMinTempInAverageDisplayed())
			minTemp = getDriver().findElement(byAverageMinTempHistory).getText();
		
		return minTemp;
	}

	/**
	 * @author HFARAZ
	 * Method to check if maximum temperature history is displayed
	 * */
	public Boolean isLastYearMaxTempHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byLastYearMaxTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the maximum temperature for the last year
	 * */
	public String getLastYearMaxTempHistory()
	{
		String maxTemp = null;
		WebPageLoaded.isDomComplete();
		if (isLastYearMaxTempHistoryDisplayed())
			maxTemp = getDriver().findElement(byLastYearMaxTempHistory).getText();
		
		return maxTemp;
	}

	/**
	 * @author HFARAZ
	 * Method to check if minimum temperature history is displayed
	 * */
	public Boolean isLastYearMinTempHistoryDisplayed() 
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byLastYearMinTempHistory).syncVisible(15,false);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the minimum temperature for the last year
	 * */
	public String getLastYearMinTempHistory()
	{
		String minTemp = null;
		WebPageLoaded.isDomComplete();
		if (isLastYearMinTempHistoryDisplayed())
			minTemp = getDriver().findElement(byLastYearMinTempHistory).getText();
		
		return minTemp;
	}
	
/**************************************************************** END OF TEMPERATURE HISTORY **************************************************************/	
	
	
	
	public String Timedisplayedcolour() {
		WebPageLoaded.isDomComplete();
		String timedisplayedcolour = getDriver().findElement(byCurrentWeatherTime).getCssValue("color");
		String timecolour = Color.fromString(timedisplayedcolour).asHex();
		return timecolour;
	}

	public Boolean TodayCardonThreeDayForecastPageIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(byTodayCardonThreeDayForecastPage).isDisplayed();
		return icondisplayed;
	}

	public Boolean weathericondisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(byCurrentWeatherIcon).isDisplayed();
		return icondisplayed;
	}

	public Boolean bydayOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	public Boolean bynightOrganismCurrentWeatherDescriptionIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(byNightOrganismCurrentWeatherDescription).isDisplayed();
		return icondisplayed;
	}

	public String temperatureinbold() {
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(byCurrentWeatherTemp).getCssValue("font-weight");
		return fontsize;
	}

	public String validateElementIsGrey(String element) {
		String timedisplayedcolour = null;
		if (element.equals("Title Sunrise displayed in grey")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bysunriseTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Sunset displayed in grey"))
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bysunsetTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Sunrise Time displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bysunrisetime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Sunset Time displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bysunsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Duration displayed in grey")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byduartionTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Duration displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydurationTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Moonrise displayed in grey")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonriseTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise Time displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonriseTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Title Moonset displayed in grey")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonsetTitle).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonset Time displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonsetTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise moonset Duration Title  displayed in grey")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonrisemoonsetduration).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Moonrise moonset Duration time displayed in Black")) 
		{
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bymoonrisemoonsetdurationtime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather compass icon")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightcurrentconditionCompassicon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Gusts")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather wind")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Ice")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Snow")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Rain")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Precipitation")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("night Organism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			System.out.println("actualcolourdisplayed:"+actualcolourdisplayed);
			return actualcolourdisplayed;
		}

//		if (element.equals("night Organism Current Weather MaxUVIdex")) {
//			WebPageLoaded.isDomComplete();
//			timedisplayedcolour = getDriver().findElement(bynightOrganismCurrentWeatherMaxUVIdex).getCssValue("color");
//			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
//			return actualcolourdisplayed;
//		}

		if (element.equals("day Oragnism Current Weather Compass Icon")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherCompassIcon).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Gusts")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Wind")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Rain")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Hours of Precipitation")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather ice")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherIce).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather snow")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherSnow).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather rain")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherRain).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Precipitation")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation2).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Oragnism Current Weather Thunderstorms")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOragnismCurrentWeatherThunderstorms).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("day Organism Current Weather MaxUVIdex")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(bydayOrganismCurrentWeatherMaxUVIdex).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("time displayed")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentWeatherTime).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Real feel temparature")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentWeatherRealfeel).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("Humidity")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionHumidity).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("UV index")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionUVIndex).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("cloud cover")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionCloudCover).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("pressure")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionPressure).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("dew point")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionDewPoint).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("visibility")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionVisibility).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("real feel shade")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentWeatherModuleRealFeelShade).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("wind")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionWind).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		if (element.equals("gusts")) {
			WebPageLoaded.isDomComplete();
			timedisplayedcolour = getDriver().findElement(byCurrentConditionGusts).getCssValue("color");
			String actualcolourdisplayed = Color.fromString(timedisplayedcolour).asHex();
			return actualcolourdisplayed;
		}

		return timedisplayedcolour;
	}

	public Boolean HourlyCTAdisplayed() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bycurrentconditionHourlyCTB).isDisplayed();
	}

	public String dayCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bydayOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	public String nightCurrentWeatherReelFeelTemperatureGetText() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bynightOrganismWeatherCurrentReelFeelTemperature).getText();
	}

	public String rightarrowcolour() {
		WebPageLoaded.isDomComplete();
		String arrowcolour = getDriver().findElement(byrightarrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String clickonHourlyCTA() {
		WebPageLoaded.isDomComplete();
		getDriver().findElement(bycurrentconditionHourlyCTB).jsClick();
		return getDriver().getCurrentUrl();
	}

	public String currentDateonAccPage() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bycurrentdate).getText();
	}

	public String getCurrentDate() {
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		String strDateFormat = "MMM-dd"; // Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // Date format string is passed as an argument to
		return objSDF.format(objDate);
	}

	public String arrownexttodate() {
		WebPageLoaded.isDomComplete();
		String arrowcolour = getDriver().findElement(byrightarrownnexttoDate).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String clickonNextdatearrow() throws InterruptedException {
		WebPageLoaded.isDomComplete();
		Thread.sleep(5000);
		getDriver().findElement(bynextDaylink).jsClick();
		Thread.sleep(5000);
		return getDriver().getCurrentUrl();
	}

	public Boolean todayOrganism() {
		WebPageLoaded.isDomComplete();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(bydayorganism).isDisplayed();
	}

	public Boolean nightOrganism() {
		WebPageLoaded.isDomComplete();
		try {
			Thread.sleep(5000);
		}
 catch (InterruptedException e) {
			e.printStackTrace();
		}

		return getDriver().findElement(byNightOrganismWeatherCurrenTempearture).isDisplayed();
	}

	

	public void scrollPage() {
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
		String dayOrganismFont = getDriver().findElement(bydayorganismTitle).getCssValue("font-weight");
		return dayOrganismFont;
	}

	public Boolean nightOrganismTextTitleisBold() {
		WebPageLoaded.isDomComplete();
		String dayOrganismTextInCaps = getDriver().findElement(bynightOrganismTextInBold).getText();
		String dayOrganismFont = getDriver().findElement(bynightOrganismTextInBold).getCssValue("font-weight");
		return dayOrganismFont.equalsIgnoreCase("500") && dayOrganismTextInCaps.equals("NIGHT");
	}

	public String dayOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomComplete();
		String dayOrganismFont = getDriver().findElement(bydayOrganismWeatherCurrenTempearture).getCssValue("font-weight");
		return dayOrganismFont;
	}

	public Boolean nightOrganismCurrentTemparatureisBold() {
		WebPageLoaded.isDomComplete();
		String dayOrganismFont = getDriver().findElement(byNightOrganismWeatherCurrenTempearture).getCssValue("font-weight");
		return dayOrganismFont.equals("300");
	}

	public Boolean dayOrganismDateIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean dayDatedisplayed = getDriver().findElement(bydayOrganismDate).isDisplayed();
		return dayDatedisplayed;
	}

	public Boolean nightOrganismDateIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean dayDatedisplayed = getDriver().findElement(bynightOrganismDate).isDisplayed();
		return dayDatedisplayed;
	}

	public Boolean dayOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean dayIcondisplayed = getDriver().findElement(bydayOrganismWeatherIcon).isDisplayed();
		return dayIcondisplayed;
	}

	public Boolean nightOrganismWeatheIconIsDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean dayIcondisplayed = getDriver().findElement(bynightOrganismWeatherIcon).isDisplayed();
		return dayIcondisplayed;
	}


	public Boolean Sunrisesunsetorganismdisplayed() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
	}

	public Boolean IssuniconDisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bysunIcon).isDisplayed();
		return icondisplayed;
	}

	public String Sunicon() {
		WebPageLoaded.isDomComplete();
		String displayedcolour = getDriver().findElement(bysunIcon).getCssValue("color");
		String Actualcolourdisplayed = Color.fromString(displayedcolour).asHex();
		return Actualcolourdisplayed;
	}

	public boolean Historicalweatherdata() {
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(bymoreHistoricalWeatherData).isDisplayed();
	}

	public String morehistoricalCTAcolour() {
		WebPageLoaded.isDomComplete();
		String arrowcolour = getDriver().findElement(bymoreHistoricalCTAarrow).getCssValue("fill");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	public String Sunrisetimeinbold()
	{
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bysunrisetime).getCssValue("font-weight");
		return fontsize;
	}

	public String Sunsettimeinbold()
	{
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bysunsetTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Durationtimeinbold()
	{
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bydurationTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Moonrisetimeinbold()
	{
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bymoonriseTime).getCssValue("font-weight");
		return fontsize;
	}

	public String Moonsetimeinbold() {
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bymoonsetTime).getCssValue("font-weight");
		return fontsize;
	}

	public String moonrisemoonsetDurationtimeinbold() {
		WebPageLoaded.isDomComplete();
		String fontsize = getDriver().findElement(bymoonrisemoonsetdurationtime).getCssValue("font-weight");
		return fontsize;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Boolean dayOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherMaxUVIndexdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherMaxUVIdex).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherThunderstormsdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOragnismCurrentWeatherThunderstorms).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherPrecipitation2displayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherPrecipitation2).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherRaindisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherSnowdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherSnow).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherIcedisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherIce).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherHoursOfPrecipitationdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherHoursOfRaindisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherHoursOfRain).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherWeatherWinddisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherWind).isDisplayed();
		return icondisplayed;
	}

	public Boolean dayOrganismCurrentWeatherGustsdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherGusts).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean dayOrganismCurrentWeatherCompassIcondisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bydayOrganismCurrentWeatherCompassIcon).isDisplayed();
		return icondisplayed;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Boolean nightOrganismCurrentWeatherPrecipitationdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherThunderstormdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOragnismCurrentWeatherThunderstorms).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherPrecipitationtowdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherPrecipitation2).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherRaindisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherSnowdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherSnow).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherIcedisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherIce).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherHoursOfPrecipitationdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfPrecipitation).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherHoursOfRaindisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherHoursOfRain).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherWinddisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherWind).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherGustsdisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightOrganismCurrentWeatherGusts).isDisplayed();
		return icondisplayed;
	}
	
	public Boolean nightOrganismCurrentWeatherCompassiondisplayed() {
		WebPageLoaded.isDomComplete();
		Boolean icondisplayed = getDriver().findElement(bynightcurrentconditionCompassicon).isDisplayed();
		return icondisplayed;
	}
	
	/**
	 * Method to verify more button is present on day/night cards
	 * @author SOWMIYA
	 * Boolean - return value - "true if more button is present"
	 * */
	public Boolean isMoreButtonPresent() {
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byTodayWeatherCard).syncVisible(15);
		getDriver().findElement(byTodayWeatherCard).click();
	}
	
	/**
	 * Method to click on evening CTA on night card - today's module
	 * @author SOWMIYA
	 * Boolean - return value - "Evening URL"
	 * */
	public String clickEveningCTA() {
		WebPageLoaded.isDomComplete();
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
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byEveningCTAFromNightOrganism).syncVisible(15);
		getDriver().findElement(byEveningCTAFromNightOrganism).click();
		getDriver().findElement(byOvernightCTAFromNightOrganism).syncVisible(15);
		getDriver().findElement(byOvernightCTAFromNightOrganism).click();
		return getDriver().getCurrentUrl();
	}
}
