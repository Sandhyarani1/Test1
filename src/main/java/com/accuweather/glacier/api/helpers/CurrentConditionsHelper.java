package com.accuweather.glacier.api.helpers;

import java.util.Arrays;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.Location;
import com.chameleon.api.restServices.ResponseCodes;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;

public class CurrentConditionsHelper {

    public static Condition getCityCurrentCondition(final String environment, final LocationData locationData) {
        final Location location = LocationHelper.getLocation(environment, locationData);
        final RestResponse response = AccuweatherRest.currentConditions().v1(environment).getDetails(location, true);
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Condition[] conditions = response.mapJSONToObject(Condition[].class);
        return parseLocations(conditions);
    }

    public static Condition getCityCurrentCondition(final String environment, final String countryName, final String cityName, final String stateName) {
        final Location location = LocationHelper.getLocation(environment, countryName, cityName, stateName);
        final RestResponse response = AccuweatherRest.currentConditions().v1(environment).getDetails(location, true);
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Condition[] conditions = response.mapJSONToObject(Condition[].class);
        return parseLocations(conditions);
    }

    public static Condition getUSCityCurrentCondition(final String environment, final String cityName, final String stateName) {
        final Location location = LocationHelper.getUSLocation(environment, cityName, stateName);
        final RestResponse response = AccuweatherRest.currentConditions().v1(environment).getDetails(location, true);
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Condition[] locations = response.mapJSONToObject(Condition[].class);
        return parseLocations(locations);
    }

    private static Condition parseLocations(final Condition[] locations) {
        for (Condition location : Arrays.asList(locations)) {
            return location;
        }
        return null;
    }

}
