package com.accuweather.glacier.api;

import java.util.ArrayList;

import com.chameleon.utils.date.SimpleDate;

import io.restassured.path.json.JsonPath;

/**
 * @author HFARAZ
 * This class deals with getting the API data for Daily Page
 * */
public class DailyPageAPI extends APIUtilities
{
	public static int rowNo=0;
	public static final String DEGREE_SYMBOL = "°";
	public static final String PERCENTAGE_SYMBOL = "%";
	public static String dailyPageResponse = "";
	
	/************** Array Lists for API ***********************/
	public static ArrayList<String> iconPhrase_API;
	public static ArrayList<String> maxTemperature_API;
	public static ArrayList<String> minTemperature_API;
	public static ArrayList<String> date_API;
	public static ArrayList<String> precipitation_API;
	
	/************** Array Lists for UI **********************/
	public static ArrayList<String> iconPhrase_UI;
	public static ArrayList<String> maxTemperature_UI;
	public static ArrayList<String> minTemperature_UI;
	public static ArrayList<String> date_UI;
	public static ArrayList<String> precipitation_UI;
	
	public static String timeStampDate = "";
	
	
	
	/**
	 * @author Hasan Faraz
	 * Method to split the date and time from the Daily Page API response
	 * */
	public static void dailyPageDateAndTimeFormat(String date)
	{	 
		String timeStamp[]=date.split("T");
		timeStampDate=timeStamp[0].substring(5).replace("-", "/"); 
	}
	
	/**
	 * @author HFARAZ
	 * Method to format date as per the Daily Page UI
	 * */
	public static String getDateAsPerDailyPageUI(String dateFromAPI)
	{
		String dateAndMonth[] = dateFromAPI.split("/");
		String month = dateAndMonth[0];
		String date = dateAndMonth[1];
		if(month.substring(0,2).startsWith("0"))
			month = month.substring(1,2);
		if(date.substring(0,2).startsWith("0"))
			date = date.substring(1,2);
		return month+"/"+date;
	}
	
	/**Method to round up the decimals
	 * @author SOWMIYA
	 * return roundup number
	 *  */
	public static String roundingUpDecimals(String value)
	{
		float numberToRound = Float.parseFloat(value);
		int roundedFigure =(int)Math.round(numberToRound);
		
		return String.valueOf(roundedFigure);
	}
	
	/**
	 * @author HFARAZ
	 * Method to convert float value to int for temperature
	 * */
	public static String getTemperatureAsPerDailyPageUI(String temperatureFromAPI)
	{
		return roundingUpDecimals(temperatureFromAPI)+DEGREE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Precipitation as per the Hourly Page UI
	 * */
	public static String getPrecipitationAsPerTheDailyPageUI(String precipitationFromAPI)
	{
		return precipitationFromAPI+PERCENTAGE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get API data for Daily Page
	 * */
	public static void getDailyPageAPIData(int dayCount, String date, String unit, String locationKey)
	{
		dailyPageResponse = getDailyPageDetails(dayCount, date, unit, locationKey).asString();
		JsonPath jsonObject = new JsonPath(dailyPageResponse);
		
		iconPhrase_API 		= new ArrayList<String>();
		maxTemperature_API 	= new ArrayList<String>();
		minTemperature_API 	= new ArrayList<String>();
		date_API 			= new ArrayList<String>();
		precipitation_API 	= new ArrayList<String>();
		
		for (int count=0;count<dayCount;count++)
		{
			dailyPageDateAndTimeFormat(jsonObject.getString("DailyForecasts["+count+"].Date"));
			date_API.add(timeStampDate);
			iconPhrase_API.add(jsonObject.getString("DailyForecasts["+count+"].Day.ShortPhrase"));
			maxTemperature_API.add(jsonObject.getString("DailyForecasts["+count+"].Temperature.Maximum.Value"));
			minTemperature_API.add(jsonObject.getString("DailyForecasts["+count+"].Temperature.Minimum.Value"));
			precipitation_API.add(jsonObject.getString("DailyForecasts["+count+"].Day.PrecipitationProbability"));				
		}
		
		
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to format the API data as per the Daily page UI format
	 * */
	public static void getDailyPageDataForUI(int dayCount, String date, String unit, String locationKey)
	{
		getDailyPageAPIData(dayCount,date,unit, locationKey);
		
		date_UI 			= new ArrayList<String>();
		iconPhrase_UI 		= new ArrayList<String>();
		maxTemperature_UI 	= new ArrayList<String>();
		minTemperature_UI 	= new ArrayList<String>();
		precipitation_UI 	= new ArrayList<String>();
		
		for (int count=0;count<dayCount;count++)
		{
			date_UI.add(getDateAsPerDailyPageUI((date_API.get(count))));
			iconPhrase_UI.add(iconPhrase_API.get(count));
			maxTemperature_UI.add(getTemperatureAsPerDailyPageUI(maxTemperature_API.get(count)));
			minTemperature_UI.add(getTemperatureAsPerDailyPageUI(minTemperature_API.get(count)));
			precipitation_UI.add(getPrecipitationAsPerTheDailyPageUI(precipitation_API.get(count)));
		}
	}
	
	/**
	 * Use the main method to check what values are returned by the methods defined inside this class
	 * */
	public static void main(String[] args) 
	{
		getDailyPageDataForUI(21,SimpleDate.getCurrentDate("yyyy-MM-dd"),"IMPERIAL","349726");
		for(int i=0;i<21;i++)
		{
			System.out.println(date_UI.get(i));
			System.out.println(iconPhrase_UI.get(i));
			System.out.println(maxTemperature_UI.get(i));
			System.out.println(minTemperature_UI.get(i));
			System.out.println(precipitation_UI.get(i));
		}
		 
		
		
	}
}
