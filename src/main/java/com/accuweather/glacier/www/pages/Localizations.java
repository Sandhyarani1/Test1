package com.accuweather.glacier.www.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class Localizations extends BasePage
{
	
	private By byMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
    private By byMapsSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(1) > a > h4");
    private By bySatelliteSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(2) > a > h4");
    private By bySatelliteImageSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(6) > a  > figure > img");
    private By bySatelliteSubMenuMapTitle = By.cssSelector("div.mega-menu-content > div:nth-child(6) > a  > figure > p");
    private By bySatelliteSubMenuMapDescription = By.cssSelector("div.mega-menu-content > div:nth-child(6) > a  > figure > figcaption");
    private By bySettingTempCelciusLabel = By.cssSelector("div.utility-bar > div > div > div.temp-switcher.fade-in-left > div > span:nth-child(3)");
    private By byRecentLocationTempInCelcius = By.cssSelector("div.template-root > div > div.featured-locations > a:nth-child(1) > span.recent-location-temp");
    private By bySatelliteTab = By.cssSelector("div.subnav-items > a > h1");
    private By byMinuteCast = By.cssSelector("div.subnav-items > a:nth-child(3) > span");
    
	/**
	 * Method to validate if Maps category present on top level navigation
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps category is present else false"
	 * */
	public Boolean isMapsPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement maps = getDriver().findElement(byMaps);
		return maps.syncVisible();
	}
	
	/**
	 * Method to validate maps categories [Maps, Satellite and Satellite Image] on city forecast page
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps categories present on city forecast page"
	 * */
	public Boolean isCityForecastMapCategoriesPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement submenuMaps = getDriver().findElement(byMapsSubMenu);
		WebElement submenuSatellite = getDriver().findElement(bySatelliteSubMenu);
		WebElement submenuSatelliteImage = getDriver().findElement(bySatelliteImageSubMenu);
		return submenuMaps.syncVisible() && submenuSatellite.syncVisible() && submenuSatelliteImage.syncVisible();
	}
	

	
	/**
	 * Method  to click on the satellite image title under Maps.
	 * @author Sowmiya
	 * @return - Boolean value - "true if landed on the correct page by identifying Satellite tab"
	 * */
	public Boolean clickSatelliteImageTitle()
	{
		WebPageLoaded.isDomInteractive();
		WebElement satelliteSubMenuMapTitle = getDriver().findElement(bySatelliteSubMenuMapTitle);
		satelliteSubMenuMapTitle.syncVisible(15);
		satelliteSubMenuMapTitle.jsClick();
		WebElement satelliteTab = getDriver().findElement(bySatelliteTab);
		return satelliteTab.syncVisible();
	}
	
	/**
	 * Method  to click on the satellite image description under Maps.
	 * @author Sowmiya
	 * @return - Boolean value - "true if landed on the correct page by identifying Satellite tab"
	 * */
	public Boolean clickSatelliteImageDescription()
	{
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteIMage = getDriver().findElement(bySatelliteSubMenuMapDescription);
		submenuSatelliteIMage.syncVisible(15);
		submenuSatelliteIMage.jsClick();
		WebElement satelliteTab = getDriver().findElement(bySatelliteTab);
		return satelliteTab.syncVisible();
	}
	

	/**
	 * Method to get the text of Satellite submenu title of the map.
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains the title of the map"
	 * */
	public String getSatelliteSubMenuMapTitle()
	{
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteMapTitle = getDriver().findElement(bySatelliteSubMenuMapTitle);
		submenuSatelliteMapTitle.syncVisible();
		System.out.println(submenuSatelliteMapTitle.getText());
		return submenuSatelliteMapTitle.getText();	
	}
	
	/**
	 * Method  to get the text of Satellite submenu description of the map.
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains the description of the map"
	 * */
	public String getSatelliteSubMenuMapDescription()
	{
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteMapDescription = getDriver().findElement(bySatelliteSubMenuMapDescription);
		submenuSatelliteMapDescription.syncVisible();
		System.out.println(submenuSatelliteMapDescription.getText());
		return submenuSatelliteMapDescription.getText();
	}
	
	/**
	 * Method to verify the presence of minutecast on city forecast page
	 * @author Sowmiya
	 * @return - Boolean value - "true if minutecast tab is present on the city forecast page"
	 * */
	public Boolean isMinutecastPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement minuteCast = getDriver().findElement(byMinuteCast);
		return minuteCast.syncVisible();
	}
	
	/**
	 * Method  to change the temperature from Farenheit to Celcius
	 * @author Sowmiya
	 * @return - Boolean value - "if recent location temperature is in Celcius"
	 * */
	public Boolean changeTemperatureFromFarenheitToCelcius()
	{
		WebPageLoaded.isDomInteractive();
		WebElement tempCelciusLabel = getDriver().findElement(bySettingTempCelciusLabel);
		tempCelciusLabel.syncVisible();
		tempCelciusLabel.click();
		WebElement recentLocationTempInCelcius = getDriver().findElement(byRecentLocationTempInCelcius);
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		recentLocationTempInCelcius.syncVisible(10);
		System.out.println(recentLocationTempInCelcius.getText());
		return recentLocationTempInCelcius.getText().contains("C");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void selectOptionWithText(String textToSelect) {
		try {
			//WebElement autoOptions = getDriver().findElement(By.cssSelector(("div.searchbar.featured-search > div.search-results > div.search-bar-result.search-result")));

			List<WebElement> optionsToSelect = getDriver().findElements(By.cssSelector(("div.searchbar.featured-search > div.search-results > div.search-bar-result.search-result")));
			System.out.println(optionsToSelect.get(0).getText());
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
