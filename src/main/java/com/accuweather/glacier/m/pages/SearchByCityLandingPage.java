package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.m.MobileBasePage;

public class SearchByCityLandingPage extends MobileBasePage {

	private By searchBox = By.cssSelector("#FreeTextLocation");
    private By searchIcon = By.cssSelector("#location-search > div > button");
    private By searchResults = By.id("autoResults");
    private By selectCityName = By.cssSelector("div:nth-child(1) > ul > li:nth-child(2) > a");
    private By getCityName = By.cssSelector("#current > h2 > a");
   
    
    public void searchByCityNameAndSubmit(String searchText) {
        enterTextVisibleElement(searchBox, searchText);
        clickVisibleElement(searchIcon);
    }
    

    public void clickOnEnteredCityName() {
       clickVisibleElement(selectCityName);
    }
}
