package com.accuweather.glacier.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author HFARAZ
 * This class deals with getting the API data for Hourly Page
 * */

public class HourlyPageAPI extends APIUtilities
{
	public static String locationDetailsResponse="";
	public static String hourlyForecastDetailsResponse;
	public static Response hourlyForecastJSONResponse;
	public static String locationCode="";
	public static String locationOffSet="";
	public static ArrayList<String> iconPhrase;
	public static ArrayList<String> temperature;
	public static ArrayList<String> time;
	public static ArrayList<String> date;
	public static ArrayList<String> precipitation;
	public static ArrayList<String> realFeel;
	public static ArrayList<String> windValue;
	public static ArrayList<String> windUnit;
	public static ArrayList<String> windDirection;
	public static ArrayList<String> windGustsValue;
	public static ArrayList<String> windGustsUnit;
	public static ArrayList<String> humidity;
	public static ArrayList<String> dewPoint;
	public static ArrayList<String> UVIndexValue;
	public static ArrayList<String> UVIndexText;
	public static ArrayList<String> cloudCover;
	public static ArrayList<String> rainValue;
	public static ArrayList<String> rainUnit;
	public static ArrayList<String> snowValue;
	public static ArrayList<String> snowUnit;
	public static ArrayList<String> iceValue;
	public static ArrayList<String> iceUnit;
	public static ArrayList<String> visibilityValue;
	public static ArrayList<String> visibilityUnit;
	public static ArrayList<String> ceilingValue;
	public static ArrayList<String> ceilingUnit;
	public static final String ArrayName = "array";
	public static String timeStampTime = "";
	public static String timeStampDate = "";
	public static int rowNo=0;
	
	/**
	 * @author HFARAZ
	 * Method to get the location details response and store it in a String a variable
	 * */
	public static String getLocationDetailsResponse()
	{
		readLocationKeysFile();
		Response response = getLocationDetails(getLocationKey(1));
		
		return response.asString();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get city name from the locationKeys.xlsx file
	 * **/
	public static String getCityName()
	{
		return getCityName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the state name from the locationKeys.xlsx file
	 * **/
	public static String getStateName()
	{
		return getStateName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get zipcode from the locationKeys.xlsx file
	 * **/
	public static String getZipCode()
	{
		return getZipCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get country code of the city selected for testing
	 * **/
	public static String getCountryCode()
	{
		return getCountryCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give location key having alerts
	 * **/
	public static String getLocationKey()
	{
		return getLocationKey(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the location code from Location Details Response
	 * */
	public static String getLocationCode(String locationDetailsResponse)
	{
		JsonPath jsonObject = new JsonPath(locationDetailsResponse);
		
		return jsonObject.get("Details.StationCode"); 
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the location offset from Location Detail Response
	 * */
	public static String getLocationOffSet(String locationDetailsResponse)
	{
		JsonPath jsonObject = new JsonPath(locationDetailsResponse);
		
		return jsonObject.get("Details.StationGmtOffset").toString(); 
	}
	
	/**
	 * @author HFARAZ
	 * Method to get hourly forecast details
	 * */
	public static Response getHourlyForecastDetailsJSONResponse()
	{
		locationDetailsResponse = getLocationDetailsResponse();
		locationCode = getLocationCode(locationDetailsResponse);
		
		locationOffSet = getLocationOffSet(locationDetailsResponse);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(new Date());
		System.out.println("Date--->"+date);
		
		hourlyForecastJSONResponse = getHourlyPageDetails(locationCode,locationOffSet,date);
		return hourlyForecastJSONResponse;
	}
	
	/**
	 * @author HFARAZ
	 * Method to count the no of hours data present in Hourly Forecast Response
	 * */
	public static int NoOfHoursForTheDay()
	{
		JsonPath jsonPathEvaluator = hourlyForecastJSONResponse.jsonPath();
		ArrayList hourlyForecastDetailsResponse=jsonPathEvaluator.get(ArrayName);
		
		System.out.println("No of hours from the API---->"+hourlyForecastDetailsResponse.size());
		return hourlyForecastDetailsResponse.size();
	}
	
	/**
	 * @author Apurba Das
	 * Method to split the date and time from the Hourly API response
	 * */
	public static void hourlyPageDateAndTimeFormat(String date)
	{	 
		String timeStamp[]=date.split("T");
		timeStampDate=timeStamp[0].substring(5).replace("-", "/");
		timeStampTime=timeStamp[1].substring(0, 2); 
	}
	
	/**
	 * @author HFARAZ
	 * Method to get
	 * */
	public static void getHourlyForecastData(String cityName)
	{
		rowNo = getRowNumberForCity(cityName);
		
		hourlyForecastDetailsResponse = getHourlyForecastDetailsJSONResponse().asString();
		JsonPath jsonObject = new JsonPath(hourlyForecastDetailsResponse);
		
		iconPhrase = new ArrayList<String>();
		temperature = new ArrayList<String>();
		time = new ArrayList<String>();
		date = new ArrayList<String>();
		precipitation = new ArrayList<String>();
		realFeel = new ArrayList<String>();
		windValue = new ArrayList<String>();
		windUnit = new ArrayList<String>();
		windDirection = new ArrayList<String>();
		windGustsValue = new ArrayList<String>();
		windGustsUnit = new ArrayList<String>();
		humidity = new ArrayList<String>();
		dewPoint = new ArrayList<String>();
		UVIndexValue = new ArrayList<String>();
		UVIndexText = new ArrayList<String>();
		cloudCover = new ArrayList<String>();
		rainValue = new ArrayList<String>();
		rainUnit = new ArrayList<String>();
		snowValue = new ArrayList<String>();
		snowUnit = new ArrayList<String>();
		iceValue = new ArrayList<String>();
		iceUnit = new ArrayList<String>();
		visibilityValue = new ArrayList<String>();
		visibilityUnit = new ArrayList<String>();
		ceilingValue = new ArrayList<String>();
		ceilingUnit = new ArrayList<String>();
		
		for (int count=0;count<NoOfHoursForTheDay();count++)
		{
			hourlyPageDateAndTimeFormat(jsonObject.getString("["+count+"].DateTime"));
			date.add(timeStampDate);
			time.add(timeStampTime);
			
			iconPhrase.add(jsonObject.getString("["+count+"].IconPhrase"));
			temperature.add(jsonObject.getString("["+count+"].Temperature.Value"));
			precipitation.add(jsonObject.getString("["+count+"].PrecipitationProbability"));
			realFeel.add(jsonObject.getString("["+count+"].RealFeelTemperature.Value"));
			windValue.add(jsonObject.getString("["+count+"].Wind.Speed.Value"));
			windUnit.add(jsonObject.getString("["+count+"].Wind.Speed.Unit"));
			windDirection.add(jsonObject.getString("["+count+"].Wind.Direction.Localized"));
			windGustsValue.add(jsonObject.getString("["+count+"].WindGust.Speed.Value"));
			windGustsUnit.add(jsonObject.getString("["+count+"].WindGust.Speed.Unit"));
			humidity.add(jsonObject.getString("["+count+"].RelativeHumidity"));
			dewPoint.add(jsonObject.getString("["+count+"].DewPoint.Value"));
			UVIndexValue.add(jsonObject.getString("["+count+"].UVIndex"));
			UVIndexText.add(jsonObject.getString("["+count+"].UVIndexText"));
			cloudCover.add(jsonObject.getString("["+count+"].CloudCover"));
			rainValue.add(jsonObject.getString("["+count+"].Rain.Value"));
			rainUnit.add(jsonObject.getString("["+count+"].Rain.Unit"));
			snowValue.add(jsonObject.getString("["+count+"].Snow.Value"));
			snowUnit.add(jsonObject.getString("["+count+"].Snow.Unit"));
			iceValue.add(jsonObject.getString("["+count+"].Ice.Value"));
			iceUnit.add(jsonObject.getString("["+count+"].Ice.Unit"));
			visibilityValue.add(jsonObject.getString("["+count+"].Visibility.Value"));
			visibilityUnit.add(jsonObject.getString("["+count+"].Visibility.Unit"));
			ceilingValue.add(jsonObject.getString("["+count+"].Ceiling.Value"));
			ceilingUnit.add(jsonObject.getString("["+count+"].Ceiling.Unit"));
		}
		
	}
	
	public static void main(String[] args)
	{
		  getHourlyForecastData("Buffalo");
		  
		  for(int i=0;i<NoOfHoursForTheDay();i++)
		  {
		  System.out.println("Icon Phrase---->"+iconPhrase.get(i));
		  System.out.println("Temperature----->"+temperature.get(i));
		  System.out.println("Precipitation---->"+precipitation.get(i));
		  System.out.println("Real Feel----->"+realFeel.get(i));
		  System.out.println("Wind Value----->"+windValue.get(i));
		  System.out.println("Wind Unit---->"+windUnit.get(i));
		  System.out.println("Wind Direction----->"+windDirection.get(i));
		  System.out.println("Date--->"+date.get(i));
		  System.out.println("Time--->"+time.get(i));
		  
		  }
		  
		  System.out.println(getCityName());
		 
		
	}
}
