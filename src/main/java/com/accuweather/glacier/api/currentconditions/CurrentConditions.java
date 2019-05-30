package com.accuweather.glacier.api.currentconditions;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.BaseAPI;
import com.accuweather.glacier.api.currentconditions.v1.V1;

public class CurrentConditions extends BaseAPI {
    private final static String PATH = "currentconditions";

    public V1 v1() {
        return new V1(getRootURL(Environment.getEnvironment()) + PATH);
    }

    public V1 v1(final String environment) {
        return new V1(getRootURL(environment) + PATH);
    }
}
