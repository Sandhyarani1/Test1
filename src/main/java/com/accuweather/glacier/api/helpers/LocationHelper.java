package com.accuweather.glacier.api.helpers;

import java.util.Arrays;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.api.objects1.Location;
import com.chameleon.api.restServices.ResponseCodes;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;

public class LocationHelper {

    public static Location getLocation(final String environment, final LocationData locationData) {
        final RestResponse response = AccuweatherRest.locations().v1(environment).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Location[] locations = response.mapJSONToObject(Location[].class);
        return parseLocations(locations, locationData);
    }

    public static Location getLocation(final String environment, final String countryName, final String cityName, final String stateName) {
        final RestResponse response = AccuweatherRest.locations().v1(environment).textSearchByCountryCodeAndAdminCode(countryName, stateName, cityName);
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Location[] locations = response.mapJSONToObject(Location[].class);
        return parseLocations(locations, countryName, cityName);
    }

    public static Location getUSLocation(final String environment, final String cityName, final String stateName) {
        final RestResponse response = AccuweatherRest.locations().v1(environment).textSearchByCountryCodeAndAdminCode("US", stateName, cityName);
        TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK, "failed to get city data", response);
        final Location[] locations = response.mapJSONToObject(Location[].class);
        return parseLocations(locations, "US", cityName);
    }

    private static Location parseLocations(final Location[] locations, final String expectedCountry, final String expectedCity) {
        for (Location location : Arrays.asList(locations)) {
            if (location.getCountry().getID().equals(expectedCountry) &&
                    location.getLocalizedName().equals(expectedCity)) {
                return location;
            }
        }
        return locations[0];
    }

    private static Location parseLocations(final Location[] locations, final LocationData locationData) {
        for (Location location : Arrays.asList(locations)) {
            if (location.getCountry().getID().equals(locationData.getCountry()) &&
                    location.getAdministrativeArea().getID().equals(locationData.getState()) &&
                    location.getLocalizedName().equals(locationData.getCity())) {
                return location;
            }
        }
        return locations[0];
    }
}
