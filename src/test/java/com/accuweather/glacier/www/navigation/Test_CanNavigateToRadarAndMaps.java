package com.accuweather.glacier.www.navigation;

import org.testng.annotations.Test;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.WebRoutes;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_CanNavigateToRadarAndMaps extends AccuWeatherBaseTest {
    private NavigationBar navBar = new NavigationBar();

    @Test
    public void test_CanNavigateToRadarAndMaps() {
        testStart("CanNavigateToRadarAndMaps");
        navBar.navigateToRadarAndMaps();
        setGeoLocation(LocationData.HIGH_POINT_NC);
        validateCurrentURL(WebRoutes.WEATHER_RADAR, getCurrentLanguage(), "us", "north-carolina");
    }

}
