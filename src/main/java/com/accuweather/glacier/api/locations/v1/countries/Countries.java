package com.accuweather.glacier.api.locations.v1.countries;

import com.accuweather.glacier.api.BaseAPI;
import com.chameleon.api.restServices.RestResponse;

public class Countries extends BaseAPI {
    public static final String COUNTRIES = "countries";

    public RestResponse countryList(String regionCode) {
        return sendGetRequest(pathBuilder(COUNTRIES, regionCode));
    }
}
