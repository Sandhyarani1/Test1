package com.accuweather.glacier.api.helpers;

import java.util.Arrays;
import java.util.List;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.DailyForeCast1;
import com.accuweather.glacier.api.objects1.DailyForeCast2;
import com.accuweather.glacier.api.objects1.DailyForeCast3;
import com.accuweather.glacier.api.objects1.DailyForeCasts5;
import com.accuweather.glacier.api.objects1.DailyForecast4;
import com.accuweather.glacier.api.objects1.Location;
import com.accuweather.glacier.api.objects2.Example;
import com.accuweather.glacier.api.objects2.Headline;
import com.accuweather.glacier.api.objects2.Headline2;
//import com.accuweather.api.objects1.Location;
import com.chameleon.api.restServices.ResponseCodes;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;

public class DailyForecastsHelper {
	

	  public static Headline getCityDailyForecastHeadline(final String environment,
	  final String countryName, final String cityName, final String stateName) {
	  final Location location = LocationHelper.getLocation(environment,
	  countryName, cityName, stateName); final RestResponse response =
	  AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	  TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	  "failed to get city data", response); final Headline headline =
	  response.mapJSONToObject(Headline.class); 
	  return parseLocations(headline);}
	  
	  
	
	  public static Example getCityDailyForecast(final String
	  environment,final LocationData locationData) { final Location location =
	  LocationHelper.getLocation(environment, locationData); final RestResponse
	  response =
	  AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	  TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	  "failed to get city data", response); final Example example =
	  response.mapJSONToObject(Example.class);
	  System.out.println("The DailyForeCastsHelper......" +example); return
	  parseLocations(example); }
	 	    
	       
	public static Example getCityDailyForecast(final String environment,
	  final String countryName, final String cityName, final String stateName) {
	  final Location location = LocationHelper.getLocation(environment,
	  countryName, cityName, stateName); final RestResponse response =
	  AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	  TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	  "failed to get city data", response); 
	  //final Example example = response.; 
	  final Example example = response.mapJSONToObject(Example.class); 
	  //final String dailyforecast = response.toString();
	  return parseLocations(example);
	  //return parseLocations(dailyforecast1); 
	  }
	 
	 public static Example getUSCityDailyForecast(final String environment,
	  final String cityName, final String stateName) { final Location location =
	  LocationHelper.getUSLocation(environment, cityName, stateName); final
	  RestResponse response =
	  AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	  TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	  "failed to get city data", response); 
	  //DailyForeCasts[] dailyforecasts = response.getForObject(DailyForeCasts.class);
	  final Example example = response.mapJSONToObject(Example.class); 
	  return parseLocations(example); 
	  
	}
	  
		  private static Headline parseLocations(final Headline locations) { for
			 (Headline location : Arrays.asList(locations)) { return location; } return
			 null; }
	 
	  private static Example parseLocations(final Example locations) {
	        for (Example location : Arrays.asList(locations)) {
	            return location;
	        }
	        return null;
	    }
	  
	/*
	 * private static Example parseDailyForeCast(final Example example) { for
	 * (Example dailyforecastt : Arrays.asList(example)) { return dailyforecastt; }
	 * return null; }
	 */
	
	/*
	 * public static Headline getCityDailyForecastHeadline(final String environment,
	 * final String countryName, final String cityName, final String stateName) {
	 * final Location location = LocationHelper.getLocation(environment,
	 * countryName, cityName, stateName); final RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final Headline headline =
	 * response.mapJSONToObject(Headline.class); return parseLocations(headline);}
	 * 
	 * public static DailyForeCasts getCityDailyForecast(final String
	 * environment,final LocationData locationData) { final Location location =
	 * LocationHelper.getLocation(environment, locationData); final RestResponse
	 * response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts dailyforecast =
	 * response.mapJSONToObject(DailyForeCasts.class);
	 * System.out.println("The DailyForeCastsHelper......" +dailyforecast); return
	 * parseLocations(dailyforecast); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static DailyForeCasts getCityDailyForecast(final String environment,
	 * final String countryName, final String cityName, final String stateName) {
	 * final Location location = LocationHelper.getLocation(environment,
	 * countryName, cityName, stateName); final RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts dailyforecast =
	 * response.mapJSONToObject(DailyForeCasts.class); //final String dailyforecast
	 * = response.toString(); return parseLocations(dailyforecast); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static DailyForeCasts getUSCityDailyForecast(final String environment,
	 * final String cityName, final String stateName) { final Location location =
	 * LocationHelper.getUSLocation(environment, cityName, stateName); final
	 * RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts dailyforecast =
	 * response.mapJSONToObject(DailyForeCasts.class); return
	 * parseLocations(dailyforecast); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private static Headline parseLocations(final Headline locations) { for
	 * (Headline location : Arrays.asList(locations)) { return location; } return
	 * null; }
	 * 
	 * private static DailyForeCasts parseLocations(final DailyForeCasts locations)
	 * { for (DailyForeCasts location : Arrays.asList(locations)) { return location;
	 * } return null; }
	 */
	  
	
	
	
	/*
	 * public static Headline getCityDailyForecastHeadline(final String environment,
	 * final String countryName, final String cityName, final String stateName) {
	 * final Location location = LocationHelper.getLocation(environment,
	 * countryName, cityName, stateName); final RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final Headline headline =
	 * response.mapJSONToObject(Headline.class); return parseLocations(headline);}
	 * 
	 * 
	 * public static DailyForeCasts getCityDailyForecast(final String environment,
	 * final LocationData locationData) { final Location location =
	 * LocationHelper.getLocation(environment, locationData); final RestResponse
	 * response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts[] DailyForeCasts =
	 * response.mapJSONToObject(DailyForeCasts[].class); return
	 * parseLocations(DailyForeCasts); }
	 * 
	 * 
	 * 
	 * public static DailyForeCasts getCityDailyForecast(final String environment,
	 * final String countryName, final String cityName, final String stateName) {
	 * final Location location = LocationHelper.getLocation(environment,
	 * countryName, cityName, stateName); final RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts[] dailyforecast =
	 * response.mapJSONToObject(DailyForeCasts[].class); return
	 * parseLocations(dailyforecast); }
	 * 
	 * 
	 * 
	 * 
	 * public static DailyForeCasts getUSCityDailyForecast(final String environment,
	 * final String cityName, final String stateName) { final Location location =
	 * LocationHelper.getUSLocation(environment, cityName, stateName); final
	 * RestResponse response =
	 * AccuweatherRest.dailyforecasts().v1(environment).getDetails(location, true);
	 * TestReporter.logAPI(response.getStatusCode() == ResponseCodes.OK,
	 * "failed to get city data", response); final DailyForeCasts[] dailyforecast =
	 * response.mapJSONToObject(DailyForeCasts[].class); return
	 * parseLocations(dailyforecast); }
	 * 
	 * private static DailyForeCasts parseLocations(final DailyForeCasts[]
	 * locations) { for (DailyForeCasts location : Arrays.asList(locations)) {
	 * return location; } return null; }
	 * 
	 * private static Headline parseLocations(final Headline locations) { for
	 * (Headline location : Arrays.asList(locations)) { return location; } return
	 * null; }
	 */
	 
	
}
