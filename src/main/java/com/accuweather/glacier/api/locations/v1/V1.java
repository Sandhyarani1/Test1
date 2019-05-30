package com.accuweather.glacier.api.locations.v1;

import com.accuweather.glacier.api.BaseAPI;
import com.accuweather.glacier.api.locations.v1.adminareas.AdminAreas;
import com.accuweather.glacier.api.locations.v1.countries.Countries;
import com.chameleon.api.restServices.ParameterBuilder.Parameters;
import com.chameleon.api.restServices.RestResponse;

public class V1 extends BaseAPI {
    private static final String SEARCH = "search";
    private static final String TOPCITIES = "topcities";
    private String path = "/v1";

    public V1(String previousPath) {
        path = previousPath + path;
    }

    public AdminAreas adminAreas() {
        return new AdminAreas();
    }

    public Countries countries() {
        return new Countries();
    }

    public RestResponse topCities(String groupSize) {
        return topCities(groupSize, false);
    }

    public RestResponse topCities(String groupSize, boolean details) {
        Parameters params = new Parameters();
        params.add("details", details);
        return sendGetRequest(pathBuilder(path, TOPCITIES, groupSize), buildParams(params));
    }

    public RestResponse searchByLocationKey(String locationKey) {
        return searchByLocationKey(locationKey, false);
    }

    public RestResponse searchByLocationKey(String locationKey, boolean details) {
        Parameters params = new Parameters();
        params.add("details", details);
        return sendGetRequest(pathBuilder(path, locationKey), buildParams(params));
    }

    public RestResponse textSearchByCountryCode(String countryCode, String searchText) {
        Parameters params = new Parameters();
        params.add("q", searchText);
        return sendGetRequest(pathBuilder(path, countryCode, SEARCH), buildParams(params));
    }

    public RestResponse textSearchByCountryCode(String countryCode, String searchText, Parameters params) {
        params.add("q", searchText);
        return sendGetRequest(pathBuilder(path, countryCode, SEARCH), buildParams(params));
    }

    public RestResponse textSearchByCountryCodeAndAdminCode(String countryCode, String adminCode, String searchText) {
        Parameters params = new Parameters();
        params.add("q", searchText);
        return sendGetRequest(pathBuilder(path, countryCode, adminCode, SEARCH), buildParams(params));
    }

    public RestResponse textSearchByCountryCodeAndAdminCode(String countryCode, String adminCode, String searchText, Parameters params) {
        params.add("q", searchText);
        return sendGetRequest(pathBuilder(path, countryCode, adminCode, SEARCH), buildParams(params));
    }
}
