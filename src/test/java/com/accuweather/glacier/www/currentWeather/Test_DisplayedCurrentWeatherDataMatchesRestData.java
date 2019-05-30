package com.accuweather.glacier.www.currentWeather;

import org.testng.annotations.Test;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.helpers.CurrentConditionsHelper;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.www.pages.CurrentWeatherPage;
import com.chameleon.selenium.web.WebBaseTest;
import com.chameleon.utils.TestReporter;

public class Test_DisplayedCurrentWeatherDataMatchesRestData extends WebBaseTest {
    private CurrentWeatherPage currentWeather = new CurrentWeatherPage();

    @Test
    public void test_DisplayedCurrentWeatherDataMatchesRestData() {
        Condition condition = CurrentConditionsHelper.getUSCityCurrentCondition(Environment.getEnvironment(), "New York", "NY");
        setPageURL(condition.getLink());
        testStart("test_DisplayedCurrentWeatherDataMatchesRestData");
        currentWeather.validateCurrentConditions(condition);
        TestReporter.assertAll();
    }
}
