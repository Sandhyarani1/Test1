package com.accuweather.glacier.www.pages;



import org.openqa.selenium.By;

import org.openqa.selenium.support.Color;

//import org.openqa.selenium.support.Color;

import org.testng.Assert;



import com.accuweather.glacier.BasePage;

import com.chameleon.selenium.web.WebPageLoaded;

import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.date.SimpleDate;



public class ThreeDayForecastPage extends BasePage {



	private By bynowTab = By.cssSelector(

			"body > div.template-root > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");

	private By bycurrentWeatherCard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p:nth-child(1)");

	private By bycurrentTime=By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p.module-header.sub.date");

	private By bytodaycardcurrentDate=By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p.module-header.sub.date");

	private By bytonightcardCurrentDate=By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > p.module-header.sub.date");

	private By byTomorrowcardDate=By.cssSelector("body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > p.module-header.sub.date");

	

	private By byCurrentWeatherTimeStamp = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > p.module-header.sub.date");

	private By byCurrentWeatherIcon = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > img");

	private By byCurrentWeatherTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > div.temp > span");

	private By byCurrentWeatherRealFeelTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > div.real-feel");

	private By byCurrentWeatherDescription = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current > div > div.cond");

	private By byCurrentweatherwholecard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current");

	private By byTodayCard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p:nth-child(1)");

	private By byTodaydate = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > p.module-header.sub.date");

	private By byTodayWeathericon = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > img");

	private By byTodayTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > div.temp.has-real-feel > span.high");

	private By byTodayRealFeelTemprature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > div.real-feel");

	private By byTodayWeatherdescription = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > div.cond");

	private By byTodayHighTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div > div.temp.has-real-feel > span.low");

	private By byTodaywholecard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(2) > div");

	private By byTonightLowTemperatue = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > div.temp.has-real-feel > span.low");

	private By byTonightcard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > p:nth-child(1)");

	private By byTonightdate = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > p.module-header.sub.date");

	private By byTonightWeathericon = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > img");

	private By byTonightTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > div.temp.has-real-feel > span.high");

	private By byTonightRealFeelTemprature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > div.real-feel");

	private By byTonightWeatherdescription = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(3) > div > div.cond");

	private By byTomorrowcard = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > p:nth-child(1)");

	private By byTomorrowdate = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > p.module-header.sub.date");

	private By byTomorrowWeathericon = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > img");

	private By byTomorrowTemperature = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > div.temp > span.high");

	private By byTomorrowWeatherdescription = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > div.cond");

	private By bytommorowHiLotemp=By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(4) > div > div.temp");

	private By byAnimationBarForward = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div.arrow.top.card.active");

	private By byAnimationBarBackward = By.cssSelector(

			"div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div:nth-child(2)");

	private By bynextdayheader = By.cssSelector(

			"div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a:nth-child(1) > div > p:nth-child(1)");

	private By forwardarrow = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div.arrow.top.card.active > svg");

	private By fourweathercards = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll");

	private By currentweathertext = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll > a.panel.panel-fade-in.card.current.reverse > div > p:nth-child(1)");

	private By backarrow = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div:nth-child(2) > svg");

	private By forwadarrowhighlighted = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div.arrow.top.card.active > svg > path");

	private By nextdayforecast = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width");

	private By backarrowhighlighted = By.cssSelector(

			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.next > div:nth-child(2) > svg > path");
	
	SimpleDate currentDate = new SimpleDate();



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

		WebPageLoaded.isDomInteractive();

		return getDriver().findElement(byTonightcard).isDisplayed();

	}



	public Boolean tomorrowWeathercardisDisplayed() {

		WebPageLoaded.isDomInteractive();

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

		return getDriver().findElement(byTodayCard).getText();

	}

	public String tonightweathercardTitle() {

		WebPageLoaded.isDomInteractive();

		return getDriver().findElement(byTonightcard).getText();

	}

	public String tomorrowweathercardTitle() {

		WebPageLoaded.isDomInteractive();

		return getDriver().findElement(byTomorrowcard).getText();

	}

	public void isclickedonCurrentWeather() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byCurrentweatherwholecard).click();

	}

	public String CurrentWeatherurldisplayed() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byCurrentweatherwholecard).click();

		return getDriver().getCurrentUrl();

	}

	public void isclickedonTodayWeather() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byTodaywholecard).click();

	}

	public String todayWeatherurldisplayed() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byTodaywholecard).click();

		return getDriver().getCurrentUrl();

	}

	public void isclickedonTomorrowWeather() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byTomorrowcard).click();

	}

	public String tomorrowWeatherurldisplayed() {

		WebPageLoaded.isDomInteractive();

		getDriver().findElement(byTomorrowcard).click();

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

	   WebPageLoaded.isDomInteractive();

       WebElement time = getDriver().findElement(bytodaycardcurrentDate);

       time.syncVisible(15);

       return time.getText();

		 

	 }

	 

	 public String gettonightcardDate()

	 {

	   WebPageLoaded.isDomInteractive();

       WebElement time = getDriver().findElement(bytonightcardCurrentDate);

       time.syncVisible(15);

       return time.getText();

	 }

	 

	 public String gettomorrowcardDate()

	 {

	   WebPageLoaded.isDomInteractive();

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

		if (cardName.equalsIgnoreCase("Current Weather")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(bycurrentWeatherCard).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current Weather Time Stamp")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byCurrentWeatherTimeStamp).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current Weather Weather Icon")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byCurrentWeatherIcon).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current Weather Temperature")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byCurrentWeatherTemperature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current Weather RealFeelTemperature")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byCurrentWeatherRealFeelTemperature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current Weather Description")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byCurrentWeatherDescription).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Today")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodayCard).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Current date")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodaydate).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Today Weather icon")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodayWeathericon).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Today High Temperature")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodayTemperature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Today RealFeelTemperature with trademark")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodayRealFeelTemprature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Today Weather Description")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTodayWeatherdescription).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tonight Current date")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTonightdate).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tonight Weather icon")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTonightWeathericon).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tonight Low Temperature")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTonightTemperature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tonight RealFeelTemperature with trademark")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTonightRealFeelTemprature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tonight Weather Description")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTonightWeatherdescription).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tomorrow Current date")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTomorrowdate).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tomorrow Weather icon")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTomorrowWeathericon).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tomorrow High and Low Temperature")) {

			WebPageLoaded.isDomInteractive();

			return getDriver().findElement(byTomorrowTemperature).isDisplayed();

		}

		if (cardName.equalsIgnoreCase("Tomorrow  Weather Description")) {

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

			String Expectedurl = "https://qualityassurance.accuweather.com/en/us/state-college/16801/current-weather/6787_pc";

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

			String Expectedurl = "https://development.accuweather.com/en/us/state-college/16801/current-weather/6787_pc";

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

			String Expectedurl = "https://development.accuweather.com/en/us/state-college/16801/current-weather/6787_pc";

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

			String Expectedurl = "https://development.accuweather.com/en/us/state-college/16801/daily-weather-forecast/6787_pc?day=1";

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

		WebPageLoaded.isDomInteractive();

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

	public boolean nextfourdaysforecast() {

		WebPageLoaded.isDomInteractive();

		return getDriver().findElement(nextdayforecast).isDisplayed();

	}

	String toBrowserHexValue(int number) {

		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));

		while (builder.length() < 2) {

			builder.append("0");

		}

		return builder.toString().toUpperCase();

	}



	

}