package com.accuweather.glacier.api;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WinterCastAPI 
{
	public static ExcelUtilities readExcel = new ExcelUtilities();
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	public static String responseString="";
	
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
	 * Method to get the row number of the location which has a snow prediction
	 * @return Integer value: "row number" for the location having snow prediction
	 * **/
	public static int getRowNumber()
	{
		readLocationKeysFile();
		
		int i=0;
		for(i=1;i<=ExcelUtilities.getLastRow();i++)
		{
			int locationKey = ExcelUtilities.getNumericData(i, 0);
			
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
			
			responseString = response.asString();
			 
			
			int responseStatus = response.getStatusCode();
			System.out.println("Status Code:"+responseStatus);
			if(responseStatus==200 && !responseString.equals("null"))
			{
				break;
			}
		}
		System.out.println("i is "+i);
		return i;
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the Response string for later processing
	 * @return String value of the JSON response
	 * */
	public static String getWinterCastAPIResponse()
	{
		System.out.println(responseString);
		return responseString;
	}
	
	public static String getStartDateTime(String responseString)
	{
		JsonPath jsonObject = new JsonPath(responseString);
		return jsonObject.get("StartDateTime");
		
	}
	
	public static Float getForecastAmountValue(String responseString)
	{
		JsonPath jsonObject = new JsonPath(responseString);
		return jsonObject.get("ForecastAmount.Value");
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the zipcode from the location_keys.xlsx file based on the location key which has snow predictions
	 * @return zipcode
	 * */
	  public static String getZipCode()
	  {
		  int zipCode = ExcelUtilities.getNumericData(getRowNumber(), 4);
		  return zipCode+"";
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the City Name having snow
	   * @return String value: The city name having the snow prediction
	   * **/
	  public static String getCityName()
	  {
		  String cityName = ExcelUtilities.getStringData(getRowNumber(), 2);
		  return cityName;
	  }
	  
	  
	  
	  public static void main(String[] args)
	  {
		System.out.println(getZipCode());
		System.out.println(getCityName());
		getWinterCastAPIResponse();
		System.out.println(getForecastAmountValue(responseString));
	  }
	
}
