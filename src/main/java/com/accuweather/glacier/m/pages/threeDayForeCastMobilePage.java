package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class threeDayForeCastMobilePage extends MobileBasePage {

	private By bynowTab = By.cssSelector("div.subnav-items > a.subnav-item.active");
	private By byTodayWeatherCard = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2)");
	private By byTonightWeatherCard = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3)");
	private By byTomorrowWeatherCard = By
			.xpath("//a[@href='/en/us/mc-farland/53558/daily-weather-forecast/23238_pc?day=1']");

	private By byTodayWeatherCardTitle = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > p:nth-child(1)");
	private By byTodayWeatherCardTimeStamp = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > p.module-header.sub.date");
	private By byTodayWeatherCardIcon = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > img");
	private By byTodayWeatherCardCurrentTemerature = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > div.temp > span.high");
	private By byTodayWeatherCardReelFeelTemperature = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > div.real-feel");
	private By byTodayWeatherCardWeatherDescription = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2) > div > div.cond");

	private By byTonightWeatherCardTitle = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > p:nth-child(1)");
	private By byTonightWeatherCardCurrentDate = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > p.module-header.sub.date");
	private By byTonightWeatherCardWeatherIcon = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > img");
	private By byTonightWeatherCardLowTemp = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > div.temp > span.high");
	private By byTonightWeatherCardLowTempwithLoText = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > div.temp > span.low");
	private By byTonightWeatherCardReelFeelTemp = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > div.real-feel");
	private By byTonightWeatherCardWeatherDescription = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3) > div > div.cond");

	private By byTodayWeatherCardLink = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(2)");
	private By byTonightWeatherCardLink = By.cssSelector(
			"div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(3)");
	private By byTomorrowWeatherCardLink = By.xpath("(//a[@class='panel panel-fade-in card'])[3]");

	private By byTomorrowWeatherCardTitle = By.xpath("//p[contains(text(),'Tomorrow')]");
	private By byTomorrowWeatherCardDate = By
			.xpath("(//div[@class='day-panel']/p[@class='module-header sub date'])[3]");
	private By byTomorrowWeatherCardWeatherIcon = By.cssSelector("(//img[@class='weather-icon icon'])[4]");
	private By byTomorrowWeatherCardHighTemp = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(4) > div > div.temp > span.high");
	private By byTomorrowWeatherCardLowTemp = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width > div > div.scroll > a:nth-child(4) > div > div.temp > span.low");
	private By byTomorrowWeatherCardTitleWeatherDescription = By.xpath("(//div[@class='cond'])[4]");

	private By byForwardArrowlinkCityForecastPage = By.xpath("//div[@class='arrow top card active']");
	private By byBackWardArrowlinkCityForecastPage = By.xpath("//div[@class='arrow active']");
	private By byBackWardArrowlinkCityForecastPage2 = By.xpath("//div[@class='arrow']");

	/**
	 * Method to verify whether Now Tab is highlighted
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Now tab is highlighted"
	 */
	public String isnowTabHighlighted() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(bynowTab).getAttribute("class");
	}

	/**
	 * Method to verify whether Today Weather card is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card is
	 *         displayed"
	 */

	public boolean isTodayWeatherCardDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCard).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card is
	 *         displayed"
	 */

	public boolean isTonightWeatherCardDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCard).isDisplayed();
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
	 * Method to verify whether today Weather card title is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card title is
	 *         displayed"
	 */

	public boolean isTodayWeatherCardTimeStampDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardTimeStamp).isDisplayed();
	}

	/**
	 * Method to verify whether today Weather card icon is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card icon is
	 *         displayed"
	 */

	public boolean isTodayWeatherCardIconDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardIcon).isDisplayed();
	}

	/**
	 * Method to verify whether today Weather card current temperature is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card current
	 *         temperature is displayed"
	 */

	public boolean isTodayWeatherCardCurrentTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardCurrentTemerature).isDisplayed();
	}

	/**
	 * Method to verify whether today Weather card Reel feel temperature is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card reel feel
	 *         temperature is displayed"
	 */

	public boolean isTodayWeatherCardReelFeelTemperatureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardReelFeelTemperature).isDisplayed();
	}

	/**
	 * Method to verify whether today Weather card description is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather card description
	 *         is displayed"
	 */

	public boolean isTodayWeatherCardDescriptionDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTodayWeatherCardWeatherDescription).isDisplayed();
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
	 * Method to verify whether tonight Weather card current temperature is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card current
	 *         temperature is displayed"
	 */

	public boolean isTonightWeatherCardTimeStampDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardCurrentDate).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card icon is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card icon is
	 *         displayed"
	 */

	public boolean isTonightWeatherCardIconDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardWeatherIcon).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card low temperature is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card low
	 *         temperature is displayed"
	 */

	public boolean isTonightWeatherCardLowTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardLowTemp).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card low temperature text is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card low
	 *         temperature text is displayed"
	 */

	public boolean isTonightWeatherCardLowTextTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardLowTempwithLoText).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card reel feel temperature is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card reel feel
	 *         temperature is displayed"
	 */

	public boolean isTonightWeatherCardReelFeelTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardReelFeelTemp).isDisplayed();
	}

	/**
	 * Method to verify whether tonight Weather card weather description is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather card weather
	 *         description is displayed"
	 */

	public boolean isTonightWeatherCardReelWeatherDescriptionDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTonightWeatherCardWeatherDescription).isDisplayed();
	}

	/**
	 * Method to verify url after clicking Today weather card
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if Today's Weather url is as
	 *         expected"
	 */

	public String isclickedonOnTodayWeatherCard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTodayWeatherCardLink).click();
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().getCurrentUrl();

	}

	/**
	 * Method to verify url after clicking tonight weather card
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tonight's Weather url is as
	 *         expected"
	 */

	public String isclickedOnTonightWeatherCard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTonightWeatherCardLink).click();
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().getCurrentUrl();

	}

	/**
	 * Method to verify url after clicking tomorrow weather card
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow's Weather url is as
	 *         expected"
	 */

	public String isclickedOnTomorrowWeatherCard() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byTomorrowWeatherCardLink).click();
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().getCurrentUrl();

	}

	// Tomorrow Weather Card methods

	/**
	 * Method to verify whether tomorrow Weather card title is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card title is
	 *         displayed"
	 */

	public boolean isTomorrowWeatherCardTitleDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardTitle).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card time stamp is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card time stamp
	 *         is displayed"
	 */

	public boolean isTomorrowWeatherCardTimeStampDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardDate).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card icon is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card icon is
	 *         displayed"
	 */

	public boolean isTomorrowWeatherCardIconDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardWeatherIcon).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card low temperature is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card low
	 *         temperature is displayed"
	 */

	public boolean isTomorrowWeatherCardLowTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardLowTemp).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card high temperature is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card high
	 *         temperature is displayed"
	 */

	public boolean isTomorrowWeatherCardHighTempTemeratureDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardHighTemp).isDisplayed();
	}

	/**
	 * Method to verify whether tomorrow Weather card reel feel temperature is
	 * displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if tomorrow Weather card reel feel
	 *         temperature is displayed"
	 */

	public boolean isTomorrowWeatherCardReelWeatherDescriptionDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byTomorrowWeatherCardTitleWeatherDescription).isDisplayed();
	}

	/**
	 * Method to verify whether is clicked On ThreeDay Forecast LandingPage Forward
	 * Arrow Link
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if clicked On ThreeDay Forecast
	 *         LandingPage Forward Arrow Link"
	 */

	public String isclickedOnThreeDayForcastLandingPageForwardArrowLink() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byForwardArrowlinkCityForecastPage).getAttribute("class");

	}

	/**
	 * Method to verify whether is clicked On ThreeDay Forecast LandingPage backward
	 * Arrow Link
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if clicked On ThreeDay Forecast
	 *         LandingPage backward Arrow Link"
	 */

	public String isclickedOnThreeDayForcastLandingPageBackwardArrowLink() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byBackWardArrowlinkCityForecastPage).getAttribute("class");

	}

	/**
	 * Method to verify whether is clicked On ThreeDay Forecast LandingPage forward
	 * Arrow Link
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if clicked On ThreeDay Forecast
	 *         LandingPage forward Arrow Link"
	 */

	public String clickOnThreeDayForcastLandingPageForwardArrowLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byForwardArrowlinkCityForecastPage).click();
		return getDriver().findElement(byBackWardArrowlinkCityForecastPage).getAttribute("class");

	}

	/**
	 * Method to verify whether is clicked On ThreeDay Forecast LandingPage backward
	 * Arrow Link
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "Return's true if clicked On ThreeDay Forecast
	 *         LandingPage backward Arrow Link"
	 */

	public String clickOnThreeDayForcastLandingPageBackwardArrowLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBackWardArrowlinkCityForecastPage).click();
		return getDriver().findElement(byBackWardArrowlinkCityForecastPage2).getAttribute("class");
	}

}
