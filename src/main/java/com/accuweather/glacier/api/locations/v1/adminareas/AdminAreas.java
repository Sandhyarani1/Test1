package com.accuweather.glacier.api.locations.v1.adminareas;

import com.accuweather.glacier.api.BaseAPI;
import com.chameleon.api.restServices.RestResponse;

public class AdminAreas extends BaseAPI {

    public static final String ADMINAREAS = "adminareas";

    public RestResponse adminAreaList(String countryCode) {
        return sendGetRequest(pathBuilder(ADMINAREAS, countryCode));
    }
}
