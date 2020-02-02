package com.accuweather.glacier.www.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class HomePageNonUS extends BasePage
{
	Boolean flag;
	int actualLocationsInTotal;
	int expectedLocationsInTotal = 20;
	String[] expectedNavigationMenu = {"Now", "Radar" ,"MinuteCast", "Hourly", "Daily", "Month"};
	private By byLanguage = By.cssSelector("div.settings-wrap > div.fade-in-left:nth-of-type(2)  > div.dropdown-content > div:nth-child(3)");
	private By byLanguageddl = By.cssSelector("div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-select-wrapper");
	private By byNavigationMenu = By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	private By byMapTitle = By.cssSelector("div.page-column-1 > div.content-module > a > div.cta-title");
	private By byMapCTA = By.cssSelector("div.page-column-1 > div.content-module > a > div.cta-text > div");
	private By byLogo = By.cssSelector("div > div.main-menu > div.logo-wrapper >div.icon-text > a");
	private By byCountryLocations = By.cssSelector("div.nearby-locations-list > a");
	private By byStateOnHomePage = By.cssSelector("div.breadcrumbs-wrapper > div > div:nth-child(4) > a");
	private By byWeatherConditionsTitle = By.cssSelector("div.content-module > div.nearby-locations.content-module > p");
	private By byCountryOnHomePage = By.cssSelector("div.breadcrumbs-wrapper > div > div:nth-child(3) > a");
	private By byContinentOnHomePage = By.cssSelector("div.breadcrumbs-wrapper > div > div:nth-child(2) > a");
	private By byWorldOnHomePage = By.cssSelector("div.breadcrumbs-wrapper > div > div:nth-child(1) > a");
	
	/**
	 * Method to change the language
	 * @author SOWMIYA  
	 * */
	public void changeLanguage()
	{
		WebPageLoaded.isDomInteractive();
		WebElement languageddl = getDriver().findElement(byLanguageddl);
		languageddl.syncVisible(25);
		languageddl.jsClick();
		WebElement language = getDriver().findElement(byLanguage);
		language.syncVisible(25);
		language.jsClick();
		Sleeper.sleep(5);
		WebElement logo = getDriver().findElement(byLogo);
		logo.syncVisible(25);
		logo.jsClick();
		Sleeper.sleep(5);
	}
	
	/**
	 * Method to verify city page should get translated in selected langauge.
	 * @author SOWMIYA
	 * @return - navigation menu 
	 * */
	public String verifyCityPageTranslatedInSelectedLanguage()
	{
		WebPageLoaded.isDomInteractive();
		WebElement languageddl = getDriver().findElement(byLanguageddl);
		languageddl.syncVisible(15);
		languageddl.jsClick();
		WebElement language = getDriver().findElement(byLanguage);
		language.syncVisible(15);
		language.jsClick();
		WebElement navigationMenu = getDriver().findElement(byNavigationMenu);
		navigationMenu.syncVisible(30);
		return navigationMenu.getText();
	}
	
	/**
	 * Method to verify map title is non english language on home page.
	 * @author SOWMIYA
	 * @return - map title
	 * */
	public String verifyMapTitleLanguage()
	{
		WebPageLoaded.isDomInteractive();
		WebElement mapTitle = getDriver().findElement(byMapTitle);
		mapTitle.syncVisible(20);
		return mapTitle.getText();
	}
	
	/**
	 * Method to verify map title is non english language on home page.
	 * @author SOWMIYA
	 * @return - map cta
	 * */
	public String verifyMapCTALanguage()
	{
		WebElement mapCTA = getDriver().findElement(byMapCTA);
		mapCTA.syncVisible(20);
		return mapCTA.getText();
	}
	
	/**
	 * Method to verify 20 locations of the country.
	 * @author SOWMIYA
	 * @return - Boolean value true if number of locations match the expected number else false
	 * */
	public Boolean verify20LocationsOfCountry()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		if(actualLocationsInTotal==expectedLocationsInTotal)
			flag = true;
		else
			flag = false;
		
		return flag;
		
	}
	
	/**
	 * Method to Verify weahter for all 20 locations of the country.
	 * @author SOWMIYA
	 * @return - Boolean value true if icon is present else false
	 * */
	public Boolean verifyWeathericonForAllLocationsOfCountry()
	{
		WebPageLoaded.isDomInteractive();
		changeLanguage();
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		for(int i=1;i<=locations.size();i++) {
			if(getDriver().findElement(By.cssSelector("div.nearby-locations-list > a:nth-child("+i+") > img")).syncVisible(5)) {
				flag = true;
			    continue;}
			else 
				flag = false;
				break;
		}
		return flag;
	}
	
	/**
	 * Method to verify temperature for all 20 locations of the country.
	 * @author SOWMIYA
	 * @return - Boolean value true if temperature is present else false
	 * */
	public Boolean verifyTemperatureForAllLocationsOfCountry()
	{
		WebPageLoaded.isDomInteractive();
		changeLanguage();
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		for(int i=1;i<=locations.size();i++) {
			if(getDriver().findElement(By.cssSelector("div > a:nth-child("+i+") > span.text.temp")).syncVisible(5)) {
				flag = true;
			    continue;}
			else 
				flag = false;
				break;
		}
		return flag;
	}
	
	/**
	 * Method to click one of the locations
	 * @author SOWMIYA  
	 * */
	public void clickLocation()
	{
		WebPageLoaded.isDomInteractive();
		WebElement location = getDriver().findElement(By.cssSelector("div.nearby-locations-list > a:nth-child(1)"));
		location.syncVisible(15);
		location.jsClick();
	}
	
	/**
	 * Method to click state on homepage above universal footer
	 * @author SOWMIYA  
	 * */
	public void clickStateOnHomePage()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement stateOnHomePage = getDriver().findElement(byStateOnHomePage);
		stateOnHomePage.syncVisible(25);
		stateOnHomePage.jsClick();
		WebElement weatherConditionstitle = getDriver().findElement(byWeatherConditionsTitle);
		weatherConditionstitle.syncVisible(25);
	}
	
	/**
	 * Method to click country on homepage above universal footer
	 * @author SOWMIYA  
	 * */
	public void clickCountryOnHomePage()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement countryOnHomePage = getDriver().findElement(byCountryOnHomePage);
		countryOnHomePage.syncVisible(25);
		countryOnHomePage.jsClick();
		WebElement weatherConditionstitle = getDriver().findElement(byWeatherConditionsTitle);
		weatherConditionstitle.syncVisible(25);
	}
	
	/**
	 * Method to click continent on homepage above universal footer
	 * @author SOWMIYA  
	 * */
	public void clickContinentOnHomePage()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement continentOnHomePage = getDriver().findElement(byContinentOnHomePage);
		continentOnHomePage.syncVisible(25);
		continentOnHomePage.jsClick();
		WebElement weatherConditionstitle = getDriver().findElement(byWeatherConditionsTitle);
		weatherConditionstitle.syncVisible(25);
	}
	
	/**
	 * Method to click world on homepage above universal footer
	 * @author SOWMIYA  
	 * */
	public void clickWorldOnHomePage()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement worldOnHomePage = getDriver().findElement(byWorldOnHomePage);
		worldOnHomePage.syncVisible(25);
		worldOnHomePage.jsClick();
		WebElement weatherConditionstitle = getDriver().findElement(byWeatherConditionsTitle);
		weatherConditionstitle.syncVisible(25);
	}
	
	
}
