package com.accuweather.glacier.www.currentWeather;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.api.helpers.CurrentConditionsHelper;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.Location;
import com.accuweather.glacier.www.pages.CurrentWeatherPage;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.selenium.web.WebBaseTest;
import com.chameleon.utils.TestReporter;

public class Test_DisplayedCurrentWeatherDataMatchesRestDataForTopCities extends WebBaseTest {
    private CurrentWeatherPage currentWeather = new CurrentWeatherPage();

    @DataProvider(name = "topcities", parallel = true)
    public Location[][] topcities() {
        RestResponse rest = AccuweatherRest.locations().v1(Environment.PROD).topCities("50", false);
        Location[] locations = rest.mapJSONToObject(Location[].class);
        Location[][] location = new Location[50][];
        for (int x = 0; x < 50; x++) {
            Location[] obj = new Location[] { locations[x] };
            location[x] = obj;
        }
        return location;
    }

    @Test(dataProvider = "topcities")
    public void test_DisplayedCurrentWeatherDataMatchesRestDataForTopCities(Location location) {
        TestReporter.setDebugLevel(0);
        Condition condition = CurrentConditionsHelper.getCityCurrentCondition(Environment.PROD, location.getCountry().getID(), location.getEnglishName(), location.getAdministrativeArea().getID());
        setPageURL(condition.getLink());
        testStart("test_DisplayedCurrentWeatherDataMatchesRestData");

        currentWeather.validateCurrentConditions(condition);
        TestReporter.assertAll();

    }
}
