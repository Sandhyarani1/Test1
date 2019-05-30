package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebException;
import com.chameleon.selenium.web.elements.WebListbox;

public class SearchLocationsPage extends MobileBasePage {

    private static final String ERROR_MESSAGE = "No results displayed for search";

    private By searchBox = By.className("loc_search_box");
    private By searchButton = By.xpath("/form[@id='location-search']/div/button");
    private By searchResults = By.id("autoResults");

    private By useCurrentLocationLink = By.id("UseCurrentLocationLink");
    private By browseForLocationLink = By.linkText("Browse for your location");

    private By worldWeather = By.linkText("World Weather");
    private By africaWeather = By.linkText("Africa Weather");
    private By antarcticaWeather = By.linkText("Antarctica Weather");
    private By arcticWeather = By.linkText("Arctic Weather");
    private By asiaWeather = By.linkText("Asia Weather");
    private By centralAmericaWeather = By.linkText("Central America Weather");
    private By europeWeather = By.linkText("Europe Weather");
    private By middleEastWeather = By.linkText("Middle East Weather");
    private By northAmericaWeather = By.linkText("North America Weather");
    private By oceaniaWeather = By.linkText("Oceania Weather");
    private By southAmericaWeather = By.linkText("South America Weather");

    public void searchByLocationAndSubmit(String searchText) {
        enterTextVisibleElement(searchBox, searchText);
        clickVisibleElement(searchButton);
    }

    public String searchByLocationAndSelectFirstOption(String searchText) {
        enterTextVisibleElement(searchBox, searchText);

        WebListbox lstResults = getDriver().findListbox(searchResults);
        if (lstResults.getOptions().isEmpty()) {
            throw new WebException(ERROR_MESSAGE, getDriver());
        }
        final String location = lstResults.getOptions().get(0).getText();
        lstResults.getOptions().get(0).click();
        return location;
    }

    public void searchByLocationAndSelectByValue(String searchText, String value) {
        enterTextVisibleElement(searchBox, searchText);

        WebListbox lstResults = getDriver().findListbox(searchResults);
        if (lstResults.getOptions().isEmpty()) {
            throw new WebException(ERROR_MESSAGE, getDriver());
        }

        lstResults.select(value);
    }

    public String searchByLocationAndGetFirstOptionText(String searchText) {
        enterTextVisibleElement(searchBox, searchText);

        WebListbox lstResults = getDriver().findListbox(searchResults);
        if (lstResults.getOptions().isEmpty()) {
            throw new WebException(ERROR_MESSAGE, getDriver());
        }

        return lstResults.getOptions().get(0).getText();
    }

    public void clickUseCurrentLocation() {
        getDriver().page().isDomInteractive();
        clickVisibleElement(useCurrentLocationLink);
    }

    public void clickBrowseForLocation() {
        getDriver().page().isDomInteractive();
        clickVisibleElement(browseForLocationLink);
    }

    public void clickWorldWeather() {
        clickVisibleElement(worldWeather);
    }

    public void clickAfricaWeather() {
        clickVisibleElement(africaWeather);
    }

    public void clickAntarcticaWeather() {
        clickVisibleElement(antarcticaWeather);
    }

    public void clickArcticWeather() {
        clickVisibleElement(arcticWeather);
    }

    public void clickAsiaWeather() {
        clickVisibleElement(asiaWeather);
    }

    public void clickCentralAmericaWeather() {
        clickVisibleElement(centralAmericaWeather);
    }

    public void clickEuropeWeather() {
        clickVisibleElement(europeWeather);
    }

    public void clickMiddleEastWeather() {
        clickVisibleElement(middleEastWeather);
    }

    public void clickNorthAmericaWeather() {
        clickVisibleElement(northAmericaWeather);
    }

    public void clickOceaniaWeather() {
        clickVisibleElement(oceaniaWeather);
    }

    public void clickSouthAmericaWeather() {
        clickVisibleElement(southAmericaWeather);
    }

}
