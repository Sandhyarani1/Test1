package com.accuweather.m.searchLocations;

import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileRoutes;
import com.accuweather.glacier.m.pages.SearchLocationsPage;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class Test_CanNavigateToEuropeWeather extends AccuWeatherMobileBaseTest {
    private SearchLocationsPage searchLocationsPage = new SearchLocationsPage();

    @Feature("Navigation")
    @Story("Can Navigate To Europe Weather")
    @Test(groups = { "regression", "navigation" })
    public void testCanNavigateToEuropeWeather() {
        testStart("CanNavigateToEuropeWeather");
        searchLocationsPage.clickEuropeWeather();
        validateCurrentURL(MobileRoutes.EUROPE_WEATHER, getCurrentLanguage());
    }
}
