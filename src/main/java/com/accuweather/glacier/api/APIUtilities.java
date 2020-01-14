package com.accuweather.glacier.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtilities 
{
	
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	
	/**
	 * @author HFARAZ
	 * Method to read the location_keys.xlsx file
	 * **/
	public static void readLocationKeysFile()
	{
		ExcelUtilities.readExcelFile(apiProperties.get(APIConstants.LOCATION_KEYS_FILE_PATH), apiProperties.get(APIConstants.US_SHEET));
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the location key from location_keys.xlsx file
	 * @return String value: location key/CityID based on the row number provided in the parameter
	 * */
	public static String getLocationKey(int rowNo)
	{
		return ExcelUtilities.getNumericData(rowNo, 0)+"";
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the zipcode from location_keys.xlsx file
	 * @return String value: zipcode based on the row number provided in the parameters
	 * */
	public static String getZipCode(int rowNo)
	{
		String zipCode = ExcelUtilities.getNumericData(rowNo, 4)+"";
		return zipCode;
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the country code from location_keys.xlsx file
	 * @return String value: country code based on the row number provided in the parameters
	 * */
	public static String getCountryCode(int rowNo)
	{
		String countryCode = ExcelUtilities.getStringData(rowNo, 1)+"";
		return countryCode;
	}
	
	 /**
	   * @author HFARAZ
	   * Method to get the City Name from location_keys.xlsx file
	   * @return String value: city name based on the row no provide in the parameter
	   * **/
	  public static String getCityName(int rowNo)
	  {
		  String cityName = ExcelUtilities.getStringData(rowNo, 2);
		  return cityName;
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the State Name from location_keys.xlsx file
	   * @return String value: city name based on the row no provide in the parameter
	   * **/
	  public static String getStateName(int rowNo)
	  {
		  String stateName = ExcelUtilities.getStringData(rowNo, 3);
		  return stateName;
	  }
	
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
	 * @author HFARAZ
	 * Method to get the status code
	 * @return Status code values based on the response
	 * */
	public static int getStatusCode(Response response)
	{
		return response.getStatusCode();
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
}
