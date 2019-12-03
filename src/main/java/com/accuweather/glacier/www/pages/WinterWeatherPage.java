package com.accuweather.glacier.www.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class WinterWeatherPage extends BasePage {
   
	private By byNationalWeatherServiceMapTitle = By.cssSelector("div > div.snow-depth-map.content-module.full-mobile-width > p");
	private By byNationalForecastMapTitle = By.cssSelector("div.page-column-1 > div.content-module > div > div.map-header > h2");
	private By byLocalForecastMapSearchModule = By.cssSelector("div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div > div > div.searchbar > div.searchbar-content > form > input");
	private By byLocalForecastMapTitle = By.cssSelector("div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div.title.card");
	private By byRightRailReadMoreButton = By.cssSelector("div.page-column-2 > div > div.content-module.zone-rightRail1 > div > a:nth-child(1) > div.right-rail-cta-text > div");
	private By byWinterWeatherSubmenuDescription = By.xpath("/html/body/div/div[1]/div[1]/div/div/div[5]/div/div[5]/p");
	private By byWinterWeatheerTab = By.cssSelector("div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By byWinterHomeTab = By.cssSelector("div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	
	/**
	 * Method to verify user is able to see national weather service map
	 * @author SOWMIYA
	 * @return - String value - "return title of the map"
	 * */
	public String verifyUserSeeNationalWeatherServiceMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nationalWeatherServiceMap = getDriver().findElement(byNationalWeatherServiceMapTitle);
		nationalWeatherServiceMap.syncVisible(30);
		return nationalWeatherServiceMap.getText();
	}
	
	/**
	 * Method to verify user is able to see national forecast map
	 * @author SOWMIYA
	 * @return - String value - "return title of the map"
	 * */
	public String verifyNationalForecastMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byNationalForecastMapTitle);
		nationalForecastMap.syncVisible(30);
		return nationalForecastMap.getText();
	}
	
	/**
	 * Method to verify user is able to see local forecast map search module
	 * @author SOWMIYA
	 * @return - String value - "return title of the map"
	 * */
	public String verifyLocalForecastMapSearchModule()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byLocalForecastMapSearchModule);
		nationalForecastMap.syncVisible(30);
		WebElement localForecastMapTitle = getDriver().findElement(byLocalForecastMapTitle);
		localForecastMapTitle.syncVisible(30);
		return localForecastMapTitle.getText();
	}
	
	/**
	 * Method to verify user able to see read more button in right rail module
	 * @author SOWMIYA
	 * @return - Boolean value - "true if read more button is present"
	 * */
	public Boolean verifyReadMoreButtonPresntInRightRailModule()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rightRailReadMoreButton = getDriver().findElement(byRightRailReadMoreButton);
		rightRailReadMoreButton.syncVisible(30);
		String strrightRailReadMoreButton = rightRailReadMoreButton.getText();
	
		return strrightRailReadMoreButton.equalsIgnoreCase("Read More");
	}
	
	/**
	 * Method to verify user able to see read more button in right rail module color
	 * @author SOWMIYA
	 * @return - String value - "return color"
	 * */
	public String verifyReadMoreButtonPresntInRightRailModuleColor()
	{
		WebPageLoaded.isDomInteractive();
		String colorReadMoreButton = getDriver().findElement(byRightRailReadMoreButton).getCssValue("color");
		getDriver().findElement(byRightRailReadMoreButton).syncVisible(25);
		String actualcolourdisplayed = Color.fromString(colorReadMoreButton).asHex();
		return actualcolourdisplayed;
	}
	
	/**
	 * Method to verify winter weather submenu description
	 * @author SOWMIYA
	 * @return - String value - "return description"
	 * */
	public String verifyWinterWeatherSubmenuDescription()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement winterWeatherSubmenuDescription = getDriver().findElement(byWinterWeatherSubmenuDescription);
		winterWeatherSubmenuDescription.syncVisible(30);
		return winterWeatherSubmenuDescription.getText();
	}
	
	/**
	 * Method to verify winter weather tab is present and its color
	 * @author SOWMIYA
	 * @return - String value - "return color"
	 * */
	public String verifyWinterWeatherTabIsPresentAndColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement winterWeatheerTab = getDriver().findElement(byWinterWeatheerTab);
		winterWeatheerTab.syncVisible(30);
		String colorTab = getDriver().findElement(byWinterWeatheerTab).getCssValue("border-top");
		String trimColorReadMoreButton = colorTab.substring(10);
		String actualcolourdisplayed = Color.fromString(trimColorReadMoreButton).asHex();
		return actualcolourdisplayed;
	}
	
	/**
	 * Method to verify winter home tab is present and its color
	 * @author SOWMIYA
	 * @return - String value - "return color"
	 * */
	public String verifyWinterHomeTabIsPresentAndColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement winterWeatheerTab = getDriver().findElement(byWinterWeatheerTab);
		winterWeatheerTab.syncVisible(30);
		String colorTab = getDriver().findElement(byWinterHomeTab).getCssValue("border-bottom");
		String trimColorReadMoreButton = colorTab.substring(10);
		String actualcolourdisplayed = Color.fromString(trimColorReadMoreButton).asHex();
		return actualcolourdisplayed;
	}
}
