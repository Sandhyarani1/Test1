package com.accuweather.glacier.api;

import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WinterCastAPI extends APIUtilities
{
	public static ExcelUtilities readExcel = new ExcelUtilities();
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	public static String responseString="";
	public static int rowNo = 0;
	
	/**
	 * @author HFARAZ
	 * Method to get the row number of the location which has a snow prediction
	 * @return Integer value: "row number" for the location having snow prediction
	 * **/
	public static int getRowNumber()
	{
		APIUtilities.readLocationKeysFile();
		
		for(rowNo=1;rowNo<=ExcelUtilities.getLastRow();rowNo++)
		{
			Response response = getWinterCastDetails(getLocationKey(rowNo));
			responseString = response.asString();
			 
			if(getStatusCode(response)==200 && !responseString.equals("null"))
			{
				break;
			}
		}
		
		return rowNo;
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
	  
	public static void main(String[] args)
	{
		/**
		 * Usage: Call getRowNumber() method and store the value in an integer variable and use it other methods like getCityName(rowNo), getZipCode(rowNo) etc.
		 * */
		  
		  int rowNo = getRowNumber();
		  getZipCode(rowNo);
		  getWinterCastAPIResponse();
	  }
	
}
