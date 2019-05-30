package com.accuweather.glacier.api.dailyforecasts.v1;

import com.accuweather.glacier.api.BaseAPI;
import com.accuweather.glacier.api.objects1.Location;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.api.restServices.ParameterBuilder.Parameters;

public class V1 extends BaseAPI {
	private String path = "/v1/Daily";

    public V1(String previousPath) {
        path = previousPath + path;
        
    }

    public RestResponse getDetails(Location location) {
        return getDetails(location, false);
    }

    public RestResponse getDetails(Location location, boolean details) {
        Parameters params = new Parameters();
        params.add("details", details);
        return sendGetRequest(pathBuilder(path, location.getKey()), buildParams(params));
    }

    public RestResponse getDetails(String locationKey) {
        return getDetails(locationKey, false);
    }

    public RestResponse getDetails(String locationKey, boolean details) {
        Parameters params = new Parameters();
        params.add("details", details);
        return sendGetRequest(pathBuilder(path, locationKey), buildParams(params));
    }
    
   

	/*
	 * public RestResponse getDetails(com.accuweather.api.objects1.Location
	 * location, boolean details) { // TODO Auto-generated method stub return null;
	 * }
	 */
}
