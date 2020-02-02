package com.accuweather.glacier.m.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class LocalizationsMobileIos extends MobileBasePage {
	private By byMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	private By byMapsSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(1) > a > h4");
	private By byMapsSubMenuDescription = By.cssSelector("div.mega-menu-content > div:nth-child(1) > p");
	private By bySatelliteSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(2) > a > h4");
	private By bySatelliteSubMenuDescription = By.cssSelector("div.mega-menu-content > div:nth-child(2) > p");
	private By bySevereSubMenuDescription = By.cssSelector("div.mega-menu-content > div:nth-child(3) > p");
	private By bySatelliteImageSubMenu = By.cssSelector("div.mega-menu-content > div:nth-child(4) > a  > figure > img");
	private By bySatelliteSubMenuMapTitle = By
			.cssSelector("div.mega-menu-content > div:nth-child(4) > a  > figure > p");
	private By bySatelliteSubMenuMapDescription = By
			.cssSelector("div.mega-menu-content > div:nth-child(4) > a  > figure > figcaption");
	private By bySettingTempCelciusLabel = By
			.cssSelector("div.utility-bar > div > div > div.temp-switcher.fade-in-left > div > span:nth-child(3)");
	private By byRecentLocationTempInCelcius = By.cssSelector(
			"body > div > div.page-subheader.content-module > div > div > a.recent-location-display > span:nth-child(2)");
	private By bySatelliteImage = By
			.cssSelector("div.mega-menu-content > div:nth-child(4) > a.nav-media-item > figure > figcaption");
	private By bySatelliteTab = By.cssSelector("div.subnav-items > a > h1");
	private By byMinuteCast = By.cssSelector("div.subnav-items > a:nth-child(3) > span");

	/**
	 * Method to validate if Maps category present on top level navigation
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps category is present else false"
	 */
	public Boolean isMapsPresent() {
		WebPageLoaded.isDomInteractive();
		WebElement maps = getDriver().findElement(byMaps);
		return maps.syncVisible();
	}

	/**
	 * Method to validate maps categories [Maps, Satellite and Satellite Image] on
	 * city forecast page
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps categories present on city forecast
	 *         page"
	 */
	public Boolean isCityForecastMapCategoriesPresent() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuMaps = getDriver().findElement(byMapsSubMenu);
		WebElement submenuSatellite = getDriver().findElement(bySatelliteSubMenu);
		WebElement submenuSatelliteImage = getDriver().findElement(bySatelliteImageSubMenu);
		return submenuMaps.syncVisible() && submenuSatellite.syncVisible() && submenuSatelliteImage.syncVisible();
	}

	/**
	 * Method to get the description of Maps submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Maps submenu contains description on city
	 *         forecast page"
	 */
	public String getMapsSubmenuDescription() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuMapsDescription = getDriver().findElement(byMapsSubMenuDescription);
		submenuMapsDescription.syncVisible();
		return submenuMapsDescription.getText();
	}

	/**
	 * Method to get the description of Satellite submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains description
	 *         present on city forecast page"
	 */
	public String getSatelliteSubmenuDescription() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteDescription = getDriver().findElement(bySatelliteSubMenuDescription);
		submenuSatelliteDescription.syncVisible();
		return submenuSatelliteDescription.getText();
	}

	/**
	 * Method to get the description of Severe submenu.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Severe submenu contains description
	 *         present on city forecast page"
	 */
	public String getSevereSubmenuDescription() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteDescription = getDriver().findElement(bySevereSubMenuDescription);
		submenuSatelliteDescription.syncVisible();
		return submenuSatelliteDescription.getText();
	}

	/**
	 * Method to get the text of Satellite submenu title of the map.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains the title of
	 *         the map"
	 */
	public String getSatelliteSubMenuMapTitle() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteMapTitle = getDriver().findElement(bySatelliteSubMenuMapTitle);
		submenuSatelliteMapTitle.syncVisible();
		System.out.println(submenuSatelliteMapTitle.getText());
		return submenuSatelliteMapTitle.getText();
	}

	/**
	 * Method to get the text of Satellite submenu description of the map.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if Satellite submenu contains the description
	 *         of the map"
	 */
	public String getSatelliteSubMenuMapDescription() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteMapDescription = getDriver().findElement(bySatelliteSubMenuMapDescription);
		submenuSatelliteMapDescription.syncVisible();
		System.out.println(submenuSatelliteMapDescription.getText());
		return submenuSatelliteMapDescription.getText();
	}

	/**
	 * Method to click on the satellite image under Maps.
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if landed on the correct page by identifying
	 *         Satellite tab"
	 */
	public Boolean clickSatelliteImage() {
		WebPageLoaded.isDomInteractive();
		WebElement submenuSatelliteIMage = getDriver().findElement(bySatelliteImage);
		submenuSatelliteIMage.syncVisible(15);
		submenuSatelliteIMage.jsClick();
		System.out.println("after image click");
		WebElement satelliteTab = getDriver().findElement(bySatelliteTab);
		return satelliteTab.syncVisible();
	}

	/**
	 * Method to verify the presence of minutecast on city forecast page
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "true if minutecast tab is present on the city
	 *         forecast page"
	 */
	public Boolean isMinutecastPresent() {
		WebPageLoaded.isDomInteractive();
		WebElement minuteCast = getDriver().findElement(byMinuteCast);
		return getDriver().findElements(byMinuteCast).size()>0;
	}

	/**
	 * Method to change the temperature from Farenheit to Celcius
	 * 
	 * @author Sowmiya
	 * @return - Boolean value - "if recent location temperature is in Celcius"
	 */
	public Boolean changeTemperatureFromFarenheitToCelcius() {
		return getDriver().findElement(byRecentLocationTempInCelcius).getText().contains("C");

	}

	public void selectOptionWithText(String textToSelect) {
		try {
			List<WebElement> optionsToSelect = getDriver().findElements(By.cssSelector(
					("div.searchbar.featured-search > div.search-results > div.search-bar-result.search-result")));
			System.out.println(optionsToSelect.get(0).getText());
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
