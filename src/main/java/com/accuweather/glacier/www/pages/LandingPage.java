package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class LandingPage extends BasePage {
	
private By byZipCodeSearchBox = By.cssSelector("div.searchbar.featured-search > div.searchbar-content > form > input.search-input");
private By byZipCodeSearchIcon = By.cssSelector("div.searchbar.featured-search > div.searchbar-content > svg.icon-search.search-icon");

/*
 * Method to enter ZIPcode under ZipCode search field on the AccuWeather Landing page
 */
public void enterZipcodeInSearchField(String zip) {
	WebPageLoaded.isDomInteractive();
	WebElement zipcodetextfield = getDriver().findElement(byZipCodeSearchBox);
	zipcodetextfield.syncVisible(15);
	zipcodetextfield.hover();
	zipcodetextfield.sendKeys(zip);
	}

/*
 * Method to click ZIPcode Icon on the AccuWeather Landing page
 */
public void clickOnZipcodeSearchIcon() {
	WebPageLoaded.isDomInteractive();
	WebElement zipcodesearchicon = getDriver().findElement(byZipCodeSearchIcon);
	zipcodesearchicon.syncVisible(15);
	zipcodesearchicon.hover();
	zipcodesearchicon.click();
	}
}
