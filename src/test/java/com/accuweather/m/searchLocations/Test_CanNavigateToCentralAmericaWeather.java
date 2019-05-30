package com.accuweather.m.searchLocations;

import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileRoutes;
import com.accuweather.glacier.m.pages.SearchLocationsPage;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class Test_CanNavigateToCentralAmericaWeather extends AccuWeatherMobileBaseTest {
    private SearchLocationsPage searchLocationsPage = new SearchLocationsPage();

    @Feature("Navigation")
    @Story("Can Navigate To Central America Weather")
    @Test(groups = { "regression", "navigation" })
    public void testCanNavigateToCentralAmericaWeather() {
        testStart("CanNavigateToCentralAmericaWeather");
        searchLocationsPage.clickCentralAmericaWeather();
        validateCurrentURL(MobileRoutes.CENTRAL_AMERICA_WEATHER, getCurrentLanguage());
    }
}
