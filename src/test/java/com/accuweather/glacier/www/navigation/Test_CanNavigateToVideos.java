package com.accuweather.glacier.www.navigation;

import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.WebRoutes;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_CanNavigateToVideos extends AccuWeatherBaseTest {
    private NavigationBar navBar = new NavigationBar();

    @Test
    public void test_CanNavigateToVideos() {
        testStart("CanNavigateToVideos");
        navBar.navigateToVideo();
        validateCurrentURL(WebRoutes.VIDEOS_SITE_NAV, getCurrentLanguage(), "utm_source=accuweather&utm_medium=accuweather&utm_campaign=sitenav");
    }

}
