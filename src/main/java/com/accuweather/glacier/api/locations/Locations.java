package com.accuweather.glacier.api.locations;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.BaseAPI;
import com.accuweather.glacier.api.locations.v1.V1;

public class Locations extends BaseAPI {
    private final static String PATH = "locations";

    public V1 v1() {
        return new V1(getRootURL(Environment.getEnvironment()) + PATH);
    }

    public V1 v1(final String environment) {
        return new V1(getRootURL(environment) + PATH);
    }
}
