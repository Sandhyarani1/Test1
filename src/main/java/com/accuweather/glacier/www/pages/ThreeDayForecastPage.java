package com.accuweather.glacier.www.pages;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
//import org.openqa.selenium.support.Color;
import org.testng.Assert;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.date.SimpleDate;

public class ThreeDayForecastPage extends BasePage 
{
	private By bynowTab = By.cssSelector(
			"body > div.template-root > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bycurrentWeatherCard = By.cssSelector("div > div.three-day-panel.three-day-forecast.full-mobile-width > a.panel.panel-fade-in.card.current > div > p:nth-child(1)");
	private By bycurrentTime=By.cssSelector("div > div.three-day-panel.three-day-forecast.full-mobile-width > a.panel.panel-fade-in.card.current > div > p.module-header.sub.date");
	private By bytodaycardcurrentDate=By.cssSelector("div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > p.module-header.sub.date");
	private By bytonightcardCurrentDate=By.cssSelector("div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(3) > div > p.module-header.sub.date");
	private By byTomorrowcardDate=By.cssSelector("div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(4) > div > p.module-header.sub.date");
	private By byCurrentWeatherTimeStamp = By.cssSelector(
			"div > div.scroll > a.panel.panel-fade-in.card.current > div > p.module-header.sub.date");
	private By byCurrentWeatherIcon = By.cssSelector(
			"div >div > a.panel.panel-fade-in.card.current > div > img");
	private By byCurrentWeatherTemperature = By.cssSelector(
			"div > div > a.panel.panel-fade-in.card.current > div > div.temp > span.high");
	private By byCurrentWeatherRealFeelTemperature = By.cssSelector(
			"div > div > a.panel.panel-fade-in.card.current > div > div.real-feel");
	private By byCurrentWeatherDescription = By.cssSelector(
			"div.three-day-panel.three-day-forecast.full-mobile-width > a.panel.panel-fade-in.card.current > div > div.cond");
	private By byCurrentweatherwholecard = By.cssSelector(
			"div > div > a.panel.panel-fade-in.card.current");
	private By byTodayCard = By.cssSelector("div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2)");
	private By byTodayCardTitle = By.cssSelector(" div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > p:nth-child(1)");
	private By byTodaydate = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > p.module-header.sub.date");
	private By byTodayWeathericon = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > img");
	private By byTodayTemperature = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(2) > div > div.temp > span.high");
	private By byTodayRealFeelTemprature = By.cssSelector(
			"div > div > a:nth-child(2) > div > div.real-feel");
	private By byTodayWeatherdescription = By.cssSelector(
			"div > div > a:nth-child(2) > div > div.cond");
	private By byTodayHighTemperature = By.cssSelector(
			"div > a:nth-child(2) > div > div.temp > span.low");
	private By byTodaywholecard = By.cssSelector(
			"div > div.page-column-1 > div > div > a:nth-child(2)");
	private By byTonightLowTemperatue = By.cssSelector(
			"div > div > a:nth-child(3) > div > div.temp > span.low");
	private By byTonightcard = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(3)");
	private By byTonightcardTitle = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(3) > div > p:nth-child(1)");
	private By byTonightdate = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(3) > div > p.module-header.sub.date");
	private By byTonightWeathericon = By.cssSelector(
			"div > div > a:nth-child(3) > div > img");
	private By byTonightTemperature = By.cssSelector(
			"div > div > a:nth-child(3) > div > div.temp > span.high");
	private By byTonightRealFeelTemprature = By.cssSelector(
			"div > div > a:nth-child(3) > div > div.real-feel");
	private By byTonightWeatherdescription = By.cssSelector(
			"div > div > a:nth-child(3) > div > div.cond");
	private By byTomorrowcard = By.cssSelector(
			"div > div.three-day-panel.three-day-forecast.full-mobile-width > a:nth-child(4) > div");
	private By byTomorrowcardTitle = By.cssSelector(
			"div > div > a:nth-child(4) > div > p:nth-child(1)");
	private By byTomorrowdate = By.cssSelector(
			"div > div > a:nth-child(4) > div > p.module-header.sub.date");
	private By byTomorrowWeathericon = By.cssSelector(
			"div > div > a:nth-child(4) > div > img");
	private By byTomorrowTemperature = By.cssSelector(
			"div > div > a:nth-child(4) > div > div.temp > span.high");
	private By byTomorrowWeatherdescription = By.cssSelector(
			"div > div > a:nth-child(4) > div > div.cond");
	private By bytommorowHiLotemp=By.cssSelector(
			"div > div > a:nth-child(4) > div > div.temp > span.high");
	private By byAnimationBarForward = By.cssSelector("div > div > a.next-arrow.card");
	private By byAnimationBarBackward = By.cssSelector("div > div.next > div:nth-child(2)");
	private By bynextdayheader = By.cssSelector(
			"div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(1) > div > p:nth-child(1)");
	private By byForwardarrow = By.cssSelector("div > div.page-column-1 > div > div.three-day-panel.three-day-forecast.full-mobile-width > a.next-arrow.card");
	private By fourweathercards = By.cssSelector("div > div.three-day-panel.three-day-forecast.full-mobile-width");
	private By currentweathertext = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current.reverse > div > p:nth-child(1)");
	private By backarrow = By.cssSelector("div.flipper-panel > div.next > div:nth-child(2) > svg");
	private By forwadarrowhighlighted = By.cssSelector("div.three-day-panel.three-day-forecast.full-mobile-width > a.next-arrow.card > svg");
	private By nextdayforecast = By.cssSelector(
			"div.content-module > div > div.flipper-panel");
	private By backarrowhighlighted = By.cssSelector(
			"div > div.next > div:nth-child(2) > svg");
	
	private By byRegionalWeatherRadarTitle = By.cssSelector("div:nth-child(5) > div > div.page-column-1 > div > a.base-map-cta.content-module > div.cta-title");
	private By byNationalWeatherRadarTitle = By.cssSelector("div:nth-child(5) > div > div.page-column-1 > div > a > div.cta-title");
	private By byNationalSatelliteTitle = By.cssSelector("div:nth-child(5) > div > div.page-column-1 > div > a > div.cta-title");
	private By byMoreMapsCTA = By.cssSelector("div:nth-child(5) > div > div.page-column-1 > div > a > div.cta-text > div");
	private By byCurrentDay = By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.date > p.dow");
	private By byCurrentDayIsHighlighted = By.cssSelector("body > div > div > div.page-column-1 > div > div:nth-child(1) > a.forecast-list-card.forecast-card.today");
	
	
	SimpleDate currentDate = new SimpleDate();
	private final static String CURRENT_WEATHER = "Current Weather";
	private final static String CURRENT_WEATHER_TIME_STAMP= "Current Weather Time Stamp";
	private final static String CURRENT_WEATHER_WEATHER_ICON = "Current Weather Weather Icon";
	private final static String CURRENT_WEATHER_TEMPERATURE = "Current Weather Temperature";
	private final static String CURRENT_WEATHER_REALFEEL_TEMP = "Current Weather RealFeelTemperature";
	private final static String CURRENT_WEATHER_DESCRIPTION = "Current Weather Description";
	private final static String TODAY = "Today";
	private final static String CURRENT_DATE = "Current date";
	private final static String TODAY_WEATHER_ICON = "Today Weather icon";
	private final static String TODAY_HIGH_TEMP = "Today High Temperature";
	private final static String TODAY_REALFEEL_TEMP_WITH_TRADEMARK = "Today RealFeelTemperature with trademark";
	private final static String TODAY_WEATHER_DESCRIPTION = "Today Weather Description";
	private final static String TONIGHT_CURRENT_DATE = "Tonight Current date";
	private final static String TONIGHT_WEATHER_ICON = "Tonight Weather icon";
	private final static String TONIGHT_LOW_TEMP = "Tonight Low Temperature";
	private final static String TONIGHT_REALFEEL_TEMP_WITH_TRADEMARK = "Tonight RealFeelTemperature with trademark";
	private final static String TONIGHT_WEATHER_DESCRIPTION = "Tonight Weather Description";
	private final static String TOMORROW_CURRENT_DATE = "Tomorrow Current date";
	private final static String TOMORROW_WEATHER_ICON = "Tomorrow Weather icon";
	private final static String TOMORROW_HIGH_AND_LOW_TEMP = "Tomorrow High and Low Temperature";
	private final static String TOMORROW_WEATHER_DESCRIPTION = "Tomorrow  Weather Description";
	Boolean flag;
	
	public String isnowTabHighlighted() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bynowTab).getAttribute("class");
	}

	public String nowTabcolour() {
		WebPageLoaded.isDomInteractive();
		String tabcolour = getDriver().findElement(bynowTab).getCssValue("border-top-color");
		String Actualtabcolour = Color.fromString(tabcolour).asHex();
		return Actualtabcolour;
	}

	public Boolean fourWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(fourweathercards).isDisplayed();
	}

	public Boolean currentWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentWeatherCard).isDisplayed();
	}

	public Boolean timeValidationOnCurrentWeather()
	{
		WebPageLoaded.isDomInteractive();
		System.out.println(getDriver().findElement(bycurrentTime).getText());
		System.out.println("currentDate.getCurrentTime():"+currentDate.getCurrentTime());
		if(getDriver().findElement(bycurrentTime).getText().equals(currentDate.getCurrentTime()))
			return true;
		else
			return false;
	}

	public Boolean dateValidationOnTodayCard()
	{
		WebPageLoaded.isDomInteractive();
		if(getDriver().findElement(bytodaycardcurrentDate).getText().equals(SimpleDate.getCurrentDate("M/d")))
			return true;
		else
			return false;
	}

	public Boolean dateValidationOnTonightCard()
	{
		WebPageLoaded.isDomInteractive();
		if(getDriver().findElement(bytonightcardCurrentDate).getText().equals(SimpleDate.getCurrentDate("M/d")))
			return true;
		else
			return false;
	}

	public Boolean dateValidationOnTomorrowsCard()
	{
		WebPageLoaded.isDomInteractive();
		if(getDriver().findElement(byTomorrowcardDate).getText().equals(currentDate.getTomorrowDate("M/d")))
			return true;
		else
			return false;
	}

	public Boolean todayWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayCard).isDisplayed();
	}

	public Boolean tonightWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byTonightcard).isDisplayed();
	}

	public Boolean tomorrowWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().findElement(byTomorrowcard).isDisplayed();
	}

	public String currentWeathercardTitle() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bycurrentWeatherCard).getText();
	}

	public Boolean currentWeathercardTimedisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byCurrentWeatherTimeStamp).isDisplayed();
	}

	public String TodayweathercardTitle() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayCardTitle).getText();
	}

	public String tonightweathercardTitle() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightcardTitle).getText();
	}

	public String tomorrowweathercardTitle() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowcardTitle).getText();
	}

	public void isclickedonCurrentWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byCurrentweatherwholecard).click();
		Sleeper.sleep(3);
	}

	public String CurrentWeatherurldisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byCurrentweatherwholecard).click();
		return getDriver().getCurrentUrl();
	}

	public void isclickedonTodayWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTodaywholecard).click();
		Sleeper.sleep(3);
	}

	public String todayWeatherurldisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTodaywholecard).click();
		Sleeper.sleep(3);
		return getDriver().getCurrentUrl();
	}

	public void isclickedonTomorrowWeather() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTomorrowcard).click();
		Sleeper.sleep(3);
	}

	public String tomorrowWeatherurldisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTomorrowcard).click();
		Sleeper.sleep(3);
		return getDriver().getCurrentUrl();
	}

	 public String todaytextdisplayedisHigh()
	 {
		 WebPageLoaded.isDomInteractive();
		 return getDriver().findElement(byTodayHighTemperature).getText();
	 }

	 public String tonighttextdisplayedisLow()
	 {
		 WebPageLoaded.isDomInteractive();
		 return getDriver().findElement(byTonightLowTemperatue).getText();
	 }

	 public String tomorrowtextHiLoDisplayed()
	 {
		 WebPageLoaded.isDomInteractive();
		 return getDriver().findElement(bytommorowHiLotemp).getText();
	 }

	 public String getcurentTime()
	 {
		 WebPageLoaded.isDomInteractive();
        WebElement time = getDriver().findElement(bycurrentTime);
         time.syncVisible(15);
       return time.getText();
	 }

	 public String gettodaycardDate()
	 {
	 WebPageLoaded.isDomInteractive();Sleeper.sleep(3);
       WebElement time = getDriver().findElement(bytodaycardcurrentDate);
       time.syncVisible(15);
       return time.getText();
	 }

	 public String gettonightcardDate()
	 {
	 WebPageLoaded.isDomInteractive();Sleeper.sleep(3);
       WebElement time = getDriver().findElement(bytonightcardCurrentDate);
       time.syncVisible(15);
       return time.getText();
	 }

	 public String gettomorrowcardDate()
	 {
	 WebPageLoaded.isDomInteractive();Sleeper.sleep(3);
       WebElement time = getDriver().findElement(byTomorrowcardDate);
       time.syncVisible(15);
       return time.getText();
	 }

	public Boolean weatherCardIsDisplayed(String cardName) {
		if (cardName.equalsIgnoreCase("currentWeather")) {
			WebPageLoaded.isDomInteractive();
			WebElement currentWeatherCard = getDriver().findElement(bycurrentWeatherCard);
			currentWeatherCard.syncVisible(20);
			currentWeatherCard.isSelected();
			return true;
		}

		if (cardName.equalsIgnoreCase("Today")) {
			WebPageLoaded.isDomInteractive();
			WebElement TodayCard = getDriver().findElement(byTodayCard);
			TodayCard.syncVisible(20);
			TodayCard.isSelected();
			return true;
		}

		if (cardName.equalsIgnoreCase("Tonight")) {
			WebPageLoaded.isDomInteractive();
			WebElement TonightCard = getDriver().findElement(byTonightcard);
			TonightCard.syncVisible(20);
			TonightCard.isSelected();
			return true;
		}

		if (cardName.equalsIgnoreCase("Tomorrow")) {
			WebPageLoaded.isDomInteractive();
			WebElement Tomorrow = getDriver().findElement(byTomorrowcard);
			Tomorrow.syncVisible(20);
			Tomorrow.isSelected();
			return true;
		}

		return false;
	}

	public boolean weatherCardElementsDetailsDisplayed(String cardName) {
		WebPageLoaded.isDomInteractive();
		if (cardName.equalsIgnoreCase(CURRENT_WEATHER)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(bycurrentWeatherCard).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_WEATHER_TIME_STAMP)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byCurrentWeatherTimeStamp).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_WEATHER_WEATHER_ICON)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byCurrentWeatherIcon).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_WEATHER_TEMPERATURE)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byCurrentWeatherTemperature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_WEATHER_REALFEEL_TEMP)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byCurrentWeatherRealFeelTemperature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_WEATHER_DESCRIPTION)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byCurrentWeatherDescription).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TODAY)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodayCard).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(CURRENT_DATE)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodaydate).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TODAY_WEATHER_ICON)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodayWeathericon).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TODAY_HIGH_TEMP)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodayTemperature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TODAY_REALFEEL_TEMP_WITH_TRADEMARK)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodayRealFeelTemprature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TODAY_WEATHER_DESCRIPTION)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTodayWeatherdescription).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TONIGHT_CURRENT_DATE)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTonightdate).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TONIGHT_WEATHER_ICON)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTonightWeathericon).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TONIGHT_LOW_TEMP)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTonightTemperature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TONIGHT_REALFEEL_TEMP_WITH_TRADEMARK)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTonightRealFeelTemprature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TONIGHT_WEATHER_DESCRIPTION)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTonightWeatherdescription).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TOMORROW_CURRENT_DATE)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTomorrowdate).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TOMORROW_WEATHER_ICON)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTomorrowWeathericon).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TOMORROW_HIGH_AND_LOW_TEMP)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTomorrowTemperature).isDisplayed();
		}

		if (cardName.equalsIgnoreCase(TOMORROW_WEATHER_DESCRIPTION)) {
			WebPageLoaded.isDomInteractive();
			return getDriver().findElement(byTomorrowWeatherdescription).isDisplayed();
		}

		return false;
	}

	public void navigatingtoappropriateweatherpage(String weathercard) {
		if (weathercard.equalsIgnoreCase("current weather")) {
			WebPageLoaded.isDomInteractive();
			WebElement currentWeatherCard = getDriver().findElement(bycurrentWeatherCard);
			currentWeatherCard.click();
			WebPageLoaded.isDomInteractive();
			String Expectedurl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
			WebPageLoaded.isDomInteractive();
			String actualUrl = getDriver().getCurrentUrl();
			WebPageLoaded.isDomInteractive();
			Assert.assertEquals(actualUrl, Expectedurl);
		}

		else if (weathercard.equalsIgnoreCase("Today")) {
			WebPageLoaded.isDomInteractive();
			WebElement currentWeatherCard = getDriver().findElement(byTodayCard);
			currentWeatherCard.click();
			WebPageLoaded.isDomInteractive();
			String Expectedurl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
			WebPageLoaded.isDomInteractive();
			String actualUrl = getDriver().getCurrentUrl();
			WebPageLoaded.isDomInteractive();
			Assert.assertEquals(actualUrl, Expectedurl);
		}

		else if (weathercard.equalsIgnoreCase("Tonight")) {
			WebPageLoaded.isDomInteractive();
			WebElement currentWeatherCard = getDriver().findElement(byTonightcard);
			currentWeatherCard.click();
			WebPageLoaded.isDomInteractive();
			String Expectedurl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
			WebPageLoaded.isDomInteractive();
			String actualUrl = getDriver().getCurrentUrl();
			WebPageLoaded.isDomInteractive();
			Assert.assertEquals(actualUrl, Expectedurl);
		}

		else if (weathercard.equalsIgnoreCase("tomorrow")) {
			WebPageLoaded.isDomInteractive();
			WebElement currentWeatherCard = getDriver().findElement(byTomorrowcard);
			currentWeatherCard.click();
			WebPageLoaded.isDomInteractive();
			String Expectedurl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/daily-weather-forecast/20813_pc?day=2";
			WebPageLoaded.isDomInteractive();
			String actualUrl = getDriver().getCurrentUrl();
			WebPageLoaded.isDomInteractive();
			Assert.assertEquals(actualUrl, Expectedurl);
		}

	}

	public void todayWeatherMax_hiTemperature() {
		WebPageLoaded.isDomInteractive();
		WebElement TodayHighTemperature = getDriver().findElement(byTodayHighTemperature);
		Assert.assertTrue(TodayHighTemperature.isDisplayed());
	}

	public void tonightWeatherMin_loTemperature() {
		WebPageLoaded.isDomInteractive();
		WebElement TonightLowTemperatue = getDriver().findElement(byTonightLowTemperatue);
		Assert.assertTrue(TonightLowTemperatue.isDisplayed());
	}

	public WebElement animationBarForwardarrow() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byAnimationBarForward);
	}

	public WebElement animationBarBackwardarrow() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byAnimationBarBackward);
	}

	public void animationforwardarrowclick() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byAnimationBarForward).click();
	}

	public void animationBackwardarrowclick() {
		WebPageLoaded.isDomInteractive(5000);
		getDriver().findElement(byAnimationBarBackward).click();
	}

	public String Backarrowcolour() {
		WebPageLoaded.isDomInteractive();
		String backarrowcolour = getDriver().findElement(backarrow).getCssValue("fill");
		String ActualBackarrowcolour = Color.fromString(backarrowcolour).asHex();
		return ActualBackarrowcolour;
	}

	public String Backarrowcolour2() {
		WebPageLoaded.isDomInteractive();
		String backarrowcolour = getDriver().findElement(backarrowhighlighted).getCssValue("fill");
		String ActualBackarrowcolour = Color.fromString(backarrowcolour).asHex();
		return ActualBackarrowcolour;
	}

	public String Forwardarrowcolour() {
		WebPageLoaded.isDomInteractive();
		String Forwardarrowcolour = getDriver().findElement(forwadarrowhighlighted).getCssValue("fill");
		String Actualarrowcolour = Color.fromString(Forwardarrowcolour).asHex();
		return Actualarrowcolour;
	}

	String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}

		return builder.toString().toUpperCase();
	}
		
	/**
	 * Method to verify forecast list for the current week should be displayed and limited to number of days in the current week
	 * @author SOWMIYA
	 * Boolean - return value - "true if two arraylist matches else false"
	 * */
	public Boolean verifyLimitedNumberOfDaysInCurrentWeek()
	{
        //Pull the list of week from UI
        List<WebElement> actualArray = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
        int sizeOfActualArray = actualArray.size();
        
        ArrayList<String> actualDays = new ArrayList<String>();
        
        //get day from UI and assign it to arraylist
        for(int i=1; i<=actualArray.size(); i++)
        {
        	String getDay = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a:nth-child("+i+") > div > p.dow")).getText();
        	actualDays.add(getDay);
        }
        
        //Userdefined days of a week
        ArrayList<String> daysUserDefined = new ArrayList<String>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        int sizeOfuserDefinedArray = daysUserDefined.size();
        
        //substract userdefined array size and actualArray size
        int noOfdysToRemoveFromUserdefinedArray = sizeOfuserDefinedArray-sizeOfActualArray;
        
        //Userdefined new array
        for(int i=0; i<noOfdysToRemoveFromUserdefinedArray; i++) {
        	daysUserDefined.remove(0);
        }
        
        System.out.println("daysUserDefined:"+daysUserDefined);
        
        //Compare 2 arraylist
        for(int i=0;i<actualDays.size();i++) {
        		if(actualDays.get(i).equalsIgnoreCase(daysUserDefined.get(i))) {
        			flag = true;
        			continue;
        		}else 
        			flag = false;
        			break;
        }
	return flag;
	}
	
	/**
	 * Method to get weather radar title
	 * @author SOWMIYA
	 * Boolean - return radar title
	 * */
	public String verifyRegionalWeatherRadarTitle() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement regionalWeatherRadarTitle = getDriver().findElement(byRegionalWeatherRadarTitle);
		regionalWeatherRadarTitle.syncVisible(25);
		return regionalWeatherRadarTitle.getText().toUpperCase();
	}
	
	/**
	 * Method to get national weather radar title
	 * @author SOWMIYA
	 * Boolean - return national weather title
	 * */
	public String verifyNationalWeatherRadarTitle() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalWeatherRadarTitle = getDriver().findElement(byNationalWeatherRadarTitle);
		nationalWeatherRadarTitle.syncVisible(25);
		return nationalWeatherRadarTitle.getText().toUpperCase();
	}
	
	/**
	 * Method to get national satellite title
	 * @author SOWMIYA
	 * Boolean - return national satellite title
	 * */
	public String verifyNationalSatelliteTitle() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalSatelliteTitle = getDriver().findElement(byNationalSatelliteTitle);
		nationalSatelliteTitle.syncVisible(100);
		return nationalSatelliteTitle.getText().toUpperCase();
	}
	
	/**
	 * Method to verify user is directed to national weather radar page on click of more maps CTA
	 * @author SOWMIYA
	 * Boolean - return national weather URL
	 * */
	public String verifyUserIsDirectedToNationalWeatherRadarPageOnClickofMoreMapsCTA() {
		WebPageLoaded.isDomInteractive();
		WebElement moreMapsCTA = getDriver().findElement(byMoreMapsCTA);
		moreMapsCTA.syncVisible(100);
		moreMapsCTA.click();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify user is directed to city weather radar page on click of more maps CTA
	 * @author SOWMIYA
	 * Boolean - return city weather URL
	 * */
	public String verifyUserIsDirectedToCityWeatherRadarPageOnClickofMoreMapsCTA() {
		WebPageLoaded.isDomInteractive();
		WebElement moreMapsCTA = getDriver().findElement(byMoreMapsCTA);
		moreMapsCTA.syncVisible(100);
		moreMapsCTA.click();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify user is directed to national satellite page on click of more maps CTA
	 * @author SOWMIYA
	 * Boolean - return national satellite URL
	 * */
	public String verifyUserIsDirectedToNationalSatellitePageOnClickofMoreMapsCTA() {
		WebPageLoaded.isDomInteractive();
		WebElement moreMapsCTA = getDriver().findElement(byMoreMapsCTA);
		moreMapsCTA.syncVisible(100);
		moreMapsCTA.click();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify URl reflects daily weather forecast on click of forward arrrow
	 * @author SOWMIYA
	 * Boolean - return national satellite URL
	 * */
	public String verifyURLReflectsDailyWeatherForecast() {
		WebPageLoaded.isDomInteractive();
		WebElement forwardarrow = getDriver().findElement(byForwardarrow);
		forwardarrow.syncVisible(100);
		forwardarrow.click();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify User is directed to the Daily Page where the current day is highlighted
	 * @author SOWMIYA
	 * Boolean - return color
	 * */
	public String verifyCurrentDayIsHiglighted() {
		WebPageLoaded.isDomInteractive();
		WebElement forwardarrow = getDriver().findElement(byForwardarrow);
		forwardarrow.syncVisible(100);
		forwardarrow.click();
	    //verify current day
		Date now = new Date();
	    SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
	    String expectedDay = simpleDateformat.format(now);
	    WebElement actualDayOnPage = getDriver().findElement(byCurrentDay);
	    actualDayOnPage.syncVisible(15);
	    expectedDay.equalsIgnoreCase(actualDayOnPage.getText());
	    
	    String currentDayIsHighlighted = getDriver().findElement(byCurrentDayIsHighlighted).getCssValue("border-left");
	    String highlightColorRGB = currentDayIsHighlighted.substring(10);
		String higlightedColor = Color.fromString(highlightColorRGB).asHex();
		return higlightedColor;
	}


}
