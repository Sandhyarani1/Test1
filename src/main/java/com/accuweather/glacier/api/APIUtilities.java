package com.accuweather.glacier.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtilities extends ExcelUtilities
{
	
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	
	/**
	 * @author HFARAZ
	 * Method to call API to get the no of alerts for a certain location
	 * @return Response 
	 * */
	public static Response getAlertCount(String locationKey)
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.NO_OF_ALERTS_URI);
		Response response =
		given().
			param("apikey",apiProperties.get(APIConstants.API_KEY)).
		when().
			get(apiProperties.get(APIConstants.NO_OF_ALERTS)+locationKey).
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
	 * @author HFARAZ
	 * Method to call Alerts API to get the details about alerts for a certain location
	 * @return Response
	 * */
	public static Response getAlertDetails(String locationKey)
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.BASE_URI);
		Response response =
		given().
			param("apikey",apiProperties.get(APIConstants.API_KEY)).
		when().
			get(apiProperties.get(APIConstants.ALERTS_DETAILS)+locationKey+".json").
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
	 * @author HFARAZ
	 * This method will fetch the JSON response for WinterCast API
	 * */
	public static Response getWinterCastDetails(String locationKey)
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.BASE_URI);
		Response response =
		given().
			param("apikey",apiProperties.get(APIConstants.API_KEY)).
			param("language",apiProperties.get(APIConstants.LANGUAGE)).
			param("details",apiProperties.get(APIConstants.DETAILS)).
			param("metric",apiProperties.get(APIConstants.METRIC)).
		when().
			get(apiProperties.get(APIConstants.SNOW_RESOURCE)+locationKey+".json").
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
	 * @author HFARAZ
	 * This method will fetch the JSON response for Daily
	 * */
	public static Response getDaily()
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.BASE_URI);
		Response response =
		when().
			get(apiProperties.get(APIConstants.DAILY)).
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
	 * @author Mohammed
	 * This method will fetch the JSON response for Blogs API
	 * */
	public static Response getWeatherBlogsPostAPIResponse()
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.BLOGS);
		Response response =
		given().
		when().get("/wp-json/data/v1/blogs").
		then().
		assertThat().statusCode(200).and().
		extract().response();
		return response;
	}
    
	/**
	 * @author HFARAZ
	 * This method will fetch the JSON response for Landing Page API
	 * */
	public static Response getLandingPageDetails()
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.LANDING_PAGE_URI);
		Response response =
		given().
			param("template",apiProperties.get(APIConstants.TEMPLATE)).
			param("locations",apiProperties.get(APIConstants.LOCATIONS)).
		when().
			get(apiProperties.get(APIConstants.LANDING_PAGE_RESOURCES)).
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
	 * @author HFARAZ
	 * This method will give the JSON Response having location code and location offset value
	 * needed to get hourly forecast data for that location
	 * */
	public static Response getLocationDetails(String locationKey)
	{
		RestAssured.baseURI = apiProperties.get(APIConstants.BASE_URI);
		Response response =
		given().
			param("apikey",apiProperties.get(APIConstants.API_KEY)).
			param("language",apiProperties.get(APIConstants.LANGUAGE)).
			param("details",apiProperties.get(APIConstants.DETAILS)).
		when().
			get(apiProperties.get(APIConstants.LOCATION_DETAILS)+locationKey).
		then().
			assertThat().statusCode(200).and().
		extract().response();
		
		return response;
	}
	
	/**
     * @author HFARAZ
     * This method will give the API data for Hourly Page
     * */
    public static Response getHourlyPageDetails(String stationCode, String locationOffSet, String currentDate, String units)
    {
        Boolean metric = false;
        if(units.equalsIgnoreCase("IMPERIAL"))
            metric = false;
        else
            metric = true;
       
        RestAssured.baseURI = apiProperties.get(APIConstants.BASE_URI);
        Response response =
        given().
            param("apikey",apiProperties.get(APIConstants.API_KEY)).
            param("language",apiProperties.get(APIConstants.LANGUAGE)).
            param("details",apiProperties.get(APIConstants.DETAILS)).
            param("locationOffset",locationOffSet).
            param("startDate",currentDate+apiProperties.get(APIConstants.START_DATE_SUFFIX)).
            param("hourCount",apiProperties.get(APIConstants.HOUR_COUNT)).
            param("metric",metric).
        when().
            get(apiProperties.get(APIConstants.GET_HOURLY_FORECAST_DETAILS)+stationCode+".json").
        then().
            assertThat().statusCode(200).and().
        extract().response();
       
        return response;
    }
	
	
	/**
	 * @author HFARAZ
	 * Method to get the status code
	 * @return Status code values based on the response
	 * */
	public static int getStatusCode(Response response)
	{
		return response.getStatusCode();
	}
	
	public static void main(String[] args)
	{
		Response res = getLandingPageDetails();
		System.out.println(res.asString());
	}
}
