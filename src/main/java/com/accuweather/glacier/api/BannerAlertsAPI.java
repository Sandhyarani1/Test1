package com.accuweather.glacier.api;

import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BannerAlertsAPI extends APIUtilities
{
	public static ExcelUtilities readExcel = new ExcelUtilities();
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	public static String responseString="";
	public static int rowNo = 0;
	
	/**
	 * @author HFARAZ
	 * Method to get the row number of the location which has an alert
	 * @return Integer value: "row number" for the location having any alerts
	 * **/
	public static int getRowNumber()
	{
		APIUtilities.readLocationKeysFile();
		
		for(rowNo=1;rowNo<=ExcelUtilities.getLastRow();rowNo++)
		{		
			Response response = getAlertCount(getLocationKey(rowNo));
			String alertCountResponse = response.asString();
			
			if(APIUtilities.getStatusCode(response)==200 && getNoOfAlerts(alertCountResponse)!=0)
			{
				break;
			}
		}
		System.out.println("Row number is "+rowNo);
		return rowNo;
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the no of alerts present in a JSON response
	 * */
	public static int getNoOfAlerts(String response)
	{
		JsonPath jsonObject = new JsonPath(response);
		int alertCount = jsonObject.get("[0].alerts");
		return alertCount;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the String value of the JSON response for the alertDetails api
	 * */
	public static String getAlertsAPIResponse()
	{
		Response response = getAlertDetails(getLocationKey(getRowNumber()));
		responseString = response.asString();
		
		return responseString;
	}
	
	public static void main(String[] args) {
		System.out.println(getAlertsAPIResponse());
	}
}
