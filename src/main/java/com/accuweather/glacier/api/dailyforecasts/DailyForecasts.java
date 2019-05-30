package com.accuweather.glacier.api.dailyforecasts;

import com.accuweather.glacier.Environment;
import com.accuweather.glacier.api.BaseAPI;
import com.accuweather.glacier.api.dailyforecasts.v1.V1;

public class DailyForecasts extends BaseAPI {

	private final static String PATH = "forecasts";
	
	public V1 v1() {
        return new V1(getRootURL(Environment.getEnvironment()) + PATH);
    }

    public V1 v1(final String environment) {
        return new V1(getRootURL(environment) + PATH);
    }
}
