package com.accuweather.glacier.m.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.mobile.driverManager.IOSAppDriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;
import com.chameleon.selenium.web.elements.WebTextbox;

public class HomePageNonUSMobile extends MobileBasePage {
	Boolean flag;
	int actualLocationsInTotal;
	int expectedLocationsInTotal = 20;
	String[] expectedNavigationMenu = { "Now", "Radar", "MinuteCast", "Hourly", "Daily", "Month" };
	private By byLanguage = By.cssSelector(
			"div.settings-wrap > div.fade-in-left:nth-of-type(2)  > div.dropdown-content > div:nth-child(3)");
	private By byLanguageddl = By
			.cssSelector("div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-select-wrapper");
	private By byNavigationMenu = By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	private By byMapTitle = By.cssSelector("div.page-column-1 > div.content-module > a > div.cta-title");
	private By byMapCTA = By.cssSelector("div.page-column-1 > div.content-module > a > div.cta-text > div");
	private By byLogo = By.xpath("//div[@class='icon-text']//a");
	private By byCountryLocations = By.cssSelector("div.nearby-locations-list > a");
	private By bySettingIcon = By.cssSelector("div.settings-button > svg.icon-settings");
	private By byBreadCrumbMenuLanguageSelector = By.cssSelector(".locale-dropdown select");
	private By fourweathercardsMobile = By.cssSelector(
			"div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width");
	private By fourweathercards = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.flipper-panel.three-day-panel.three-day-forecast.full-mobile-width > div.scroll");
	private By byLogo2 = By.cssSelector("body > div > div.component-sticky-container.header > div > div.main-menu-wrapper > div > div.logo-wrapper > div > a > img");

	
	
	

	/**
	 * Method to change the language
	 * 
	 * @author SOWMIYA
	 */
	public void changeLanguage() {
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
	
	
	public void clickLogo()
	{
		WebElement logo = getDriver().findElement(byLogo);
		logo.click();
		Sleeper.sleep(5);
	}

	/**
	 * Method to verify city page should get translated in selected langauge.
	 * 
	 * @author SOWMIYA
	 * @return - navigation menu
	 */
	public String verifyCityPageTranslatedInSelectedLanguage() {
		WebElement language = getDriver().findElement(byLanguage);
		WebElement navigationMenu = getDriver().findElement(byNavigationMenu);
		return navigationMenu.getText();
	}

	/**
	 * Method to verify map title is non english language on home page.
	 * 
	 * @author SOWMIYA
	 * @return - map title
	 */
	public String verifyMapTitleLanguage() {
		WebPageLoaded.isDomInteractive();
		WebElement mapTitle = getDriver().findElement(byMapTitle);
		return mapTitle.getText();
	}

	/**
	 * Method to verify map title is non english language on home page.
	 * 
	 * @author SOWMIYA
	 * @return - map cta
	 */
	public String verifyMapCTALanguage() {
		WebElement mapCTA = getDriver().findElement(byMapCTA);
		return mapCTA.getText();
	}

	/**
	 * Method to verify 20 locations of the country.
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value true if number of locations match the expected number
	 *         else false
	 */
	public Boolean verify20LocationsOfCountry() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		if (actualLocationsInTotal == expectedLocationsInTotal)
			flag = true;
		else
			flag = false;

		return flag;

	}

	/**
	 * Method to Verify weahter for all 20 locations of the country.
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value true if icon is present else false
	 */
	public Boolean verifyWeathericonForAllLocationsOfCountry() {
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		for (int i = 1; i <= locations.size(); i++) {
			if (getDriver().findElements(By.cssSelector("div.nearby-locations-list > a:nth-child(" + i + ") > img"))
					.size()>0) {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to verify temperature for all 20 locations of the country.
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value true if temperature is present else false
	 */
	public Boolean verifyTemperatureForAllLocationsOfCountry() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> locations = getDriver().findElements(byCountryLocations);
		actualLocationsInTotal = locations.size();
		for (int i = 1; i <= locations.size(); i++) {
			if (getDriver().findElements(By.cssSelector("div > a:nth-child(" + i + ") > span.text.temp"))
					.size()>0) {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to click one of the locations
	 * 
	 * @author SOWMIYA
	 */
	public void clickLocation() {
		WebPageLoaded.isDomInteractive();
		WebElement location = getDriver().findElement(By.cssSelector("div.nearby-locations-list > a:nth-child(1)"));
		location.jsClick();
	}
	
	
	
	public void clickSettingsIcon() {
       	WebPageLoaded.isDomInteractive();
        WebTextbox settingicon = getDriver().findTextbox(bySettingIcon);
        settingicon.syncVisible(15);
    	settingicon.click(); 
    	Sleeper.sleep(10);
       }
	
	public Boolean clickBreadCrumbMenulanguageSelect() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuLanguageSelector).click();
		Sleeper.sleep(4);
		return true;
	}
	
	
	public Boolean clickBreadCrumbMenulanguageSelectMobile() {
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("seetest:client.setPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPicker']\", 0, 0, \"Español\")");
		getDriver().executeJavaScript("seetest:client.click(\"NATIVE\", \"xpath=//*[@text='Done']\", 0, 1)");
		Sleeper.sleep(4);
		return true;
	}
	
	public Boolean clickBreadCrumbMenulanguageSelectMobileEnglish() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().executeJavaScript("seetest:client.setPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPicker']\", 0, 0, \"English (UK)\")");
		getDriver().executeJavaScript("seetest:client.click(\"NATIVE\", \"xpath=//*[@text='Done']\", 0, 1)");
		return true;
	}
	
	public String selectLanguagefromdropdown() {
		WebPageLoaded.isDomInteractive();
		WebElement dropdown = getDriver().findElement(byBreadCrumbMenuLanguageSelector);
		dropdown.jsClick();
		dropdown.sendKeys("Español");
		WebElement navigationMenu = getDriver().findElement(byNavigationMenu);
		navigationMenu.syncVisible(30);
		return navigationMenu.getText();
	}
	
	
	public Boolean fourWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(fourweathercardsMobile).isDisplayed();
	}
	
	public void navigateToHomePageByLogo() {
		getDriver().findElement(byLogo2).jsClick();
		Sleeper.sleep(5);
	}
	

}
