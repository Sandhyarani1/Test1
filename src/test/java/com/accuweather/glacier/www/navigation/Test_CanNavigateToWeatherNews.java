package com.accuweather.glacier.www.navigation;

import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.WebRoutes;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_CanNavigateToWeatherNews extends AccuWeatherBaseTest {
    private NavigationBar navBar = new NavigationBar();

    @Test
    public void test_CanNavigateToWeatherNews() {
        testStart("CanNavigateToWeatherNews");
        navBar.navigateToNews();
        validateCurrentURL(WebRoutes.WEATHER_NEWS, getCurrentLanguage());
    }

}
