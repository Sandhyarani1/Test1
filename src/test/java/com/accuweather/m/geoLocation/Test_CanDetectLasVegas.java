package com.accuweather.m.geoLocation;

import org.testng.annotations.Test;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.SearchLocationsPage;
import com.accuweather.glacier.m.pages.WeatherForecastCityPage;
import com.chameleon.utils.TestReporter;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class Test_CanDetectLasVegas extends AccuWeatherMobileBaseTest {
    private SearchLocationsPage searchLocationsPage = new SearchLocationsPage();
    private WeatherForecastCityPage city = new WeatherForecastCityPage();

    private LocationData location = LocationData.LAS_VEGAS_NV;

    @Feature("GeoLocation")
    @Story("Can locate North American Cities")
    @Test(groups = { "regression", "geolocation" })
    public void test_CanDetectLasVegas() {
        testStart("CanDetectLasVegas");
        setGeoLocation(location);

        searchLocationsPage.clickUseCurrentLocation();
        TestReporter.assertTrue(city.isExpectedCityDisplayed(location.getCity(), location.getState()), "Validate city displayed was [ " + location.getCity() + " ] and state was [ " + location.getState() + " ]");
    }
}
