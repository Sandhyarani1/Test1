package com.accuweather.glacier.api;

import java.util.ArrayList;
import java.util.Map;

import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BannerAlertsAPI extends APIUtilities
{
	public static ExcelUtilities readExcel = new ExcelUtilities();
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	public static String alertDetails="";
	public static String alertCountResponse="";
	public static int rowNo = 0;
	public static int alertCount = 0;
	public static ArrayList<String> alertSummary;
	
	/**
	 * @author HFARAZ
	 * Method to get the row number of the location which has alerts equivalent to the count provided in the parameter
	 * @return Integer value: "row number" for the location having any alerts
	 * **/
	public static int getRowNumber(int alertCount)
	{
		APIUtilities.readLocationKeysFile();
		
		for(rowNo=1;rowNo<=ExcelUtilities.getLastRow();rowNo++)
		{		
			Response response = getAlertCount(getLocationKey(rowNo));
			alertCountResponse = response.asString();
			
			if(APIUtilities.getStatusCode(response)==200 && getNoOfAlerts()==alertCount)
			{
				break;
			}
		}
		System.out.println("Alert for a city with "+alertCount+" alert found at row number:---->"+rowNo);
		return rowNo;
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the no of alerts present in a JSON response
	 * */
	public static int getNoOfAlerts()
	{
		JsonPath jsonObject = new JsonPath(alertCountResponse);
		alertCount = jsonObject.get("[0].alerts");
		return alertCount;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the String value of the JSON response for the alertDetails api 
	 * @param int : no of alerts you are looking for
	 * */
	public static String getAlertsAPIResponse(int alertCount)
	{
		Response response = getAlertDetails(getLocationKey(getRowNumber(alertCount)));
		alertDetails = response.asString();
		
		return alertDetails;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the alert summary from API response
	 * */
	public static ArrayList<String> getAlertSummary()
	{
		JsonPath jsonObject = new JsonPath(alertDetails);
		alertSummary = new ArrayList<String>();
		for (int i=0;i<alertCount;i++)
		{
			alertSummary.add(jsonObject.getString("["+i+"].Area[0].Summary"));
		}
		return alertSummary;
		
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to give city name having alerts
	 * **/
	public static String getCityNameHavingAlerts()
	{
		return getCityName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give state name having alerts
	 * **/
	public static String getStateNameHavingAlerts()
	{
		return getStateName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give zip code of the city name having alerts
	 * **/
	public static String getZipCodeHavingAlerts()
	{
		return getZipCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give country code of the city name having alerts
	 * **/
	public static String getCountryCodeHavingAlerts()
	{
		return getCountryCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give location key having alerts
	 * **/
	public static String getLocationKeyHavingAlerts()
	{
		return getLocationKey(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give the alert count
	 * */
	public static int getAlertCount()
	{
		return alertCount;
	}
	
	/**
	 * Use the main method to see the function calls and usages
	 * */
	public static void main(String[] args) {
		System.out.println(getAlertsAPIResponse(3));
		System.out.println(getCityName(rowNo));
		System.out.println(getZipCode(rowNo));
		System.out.println(getLocationKey(rowNo));
		System.out.println(getAlertCount());
		System.out.println(getAlertSummary());
	}
}
