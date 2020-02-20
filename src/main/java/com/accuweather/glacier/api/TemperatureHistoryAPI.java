package com.accuweather.glacier.api;

import com.accuweather.chameleon.Utilities.CommonUtilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TemperatureHistoryAPI extends APIUtilities
{
	public static Response temperatureHistoryResponse;
	public static String temperatureHistory;
	public static String temperatureHistoryLastYear;
	public static String averageMaxTemp_UI;
	public static String averageMinTemp_UI;
	public static String recordMaxTemp_UI;
	public static String recordMinTemp_UI;
	public static String recordMaxTempYear_UI;
	public static String recordMinTempYear_UI;
	public static String maxTempLastYear_UI;
	public static String minTempLastYear_UI;
	
	/*************************** API OBJECTS *************************/
	public static String YEAR 			= "Year";
	public static String RECORD 		= "Record";
	public static String RECORDS 		= "Records";
	public static String NORMAL			= "Normal";
	public static String NORMALS		= "Normals";
	public static String ACTUAL			= "Actual";
	public static String ACTUALS		= "Actuals";
	public static String TEMPERATURES 	= "Temperatures";
	public static String AVERAGE		= "Average";
	public static String MAXIMUM 		= "Maximum";
	public static String MINIMUM 		= "Minimum";
	public static String METRIC 		= "Metric";
	public static String IMPERIAL 		= "Imperial";
	public static String VALUE 			= "Value";
	public static String UNIT 			= "Unit";
	
	/*************************** CURRENT WEATHER PAGE TEMPERATURE HISTORY UI FORMAT *****************************/
	public static final String DEGREE_SYMBOL = "°";
	
	/**
	 * @author HFARAZ
	 * This method calls temperature history API and store it's response as String
	 * */
	public static String getTemperatureHistoryResponse(String date, String locationKey)
	{
		temperatureHistoryResponse = getTemperatureHistoryDetails(date, locationKey);
		temperatureHistory = temperatureHistoryResponse.asString();
		return temperatureHistory;
	}
	
	/**
	 * @author HFARAZ
	 * This method calls temperature history API for last year and store it's response as String
	 * */
	public static String getTemperatureHistoryLastYear(String lastYeardate, String locationKey)
	{
		temperatureHistoryResponse = getTemperatureHistoryDetails(lastYeardate, locationKey);
		temperatureHistoryLastYear = temperatureHistoryResponse.asString();
		return temperatureHistoryLastYear;
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for maximum recorded temperature from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMaximumRecordTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(RECORD+"."+RECORDS+"."+TEMPERATURES+"."+MAXIMUM+"."+unit+"."+VALUE);
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for minimum recorded temperature from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMinimumRecordTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(RECORD+"."+RECORDS+"."+TEMPERATURES+"."+MINIMUM+"."+unit+"."+VALUE);
	}
	
	/**
	 * @author HFARAZ
	 * This method will year for maximum recorded temperature from the API
	 * */
	public static String getYearForMaximumRecordTemp()
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(RECORD+"."+RECORDS+"."+TEMPERATURES+"."+MAXIMUM+"."+YEAR);
	}
	
	/**
	 * @author HFARAZ
	 * This method will year for minimum recorded temperature from the API 
	 * */
	public static String getYearForMinimumRecordTemp()
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(RECORD+"."+RECORDS+"."+TEMPERATURES+"."+MINIMUM+"."+YEAR);
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for maximum average temperature from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMaximumAverageTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(NORMAL+"."+NORMALS+"."+TEMPERATURES+"."+MAXIMUM+"."+unit+"."+VALUE);
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for minimum recorded temperature from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMinimumAverageTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistory);
		return jsonObject.getString(NORMAL+"."+NORMALS+"."+TEMPERATURES+"."+MINIMUM+"."+unit+"."+VALUE);
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for maximum temperature for the last year from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMaximumLastYearTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistoryLastYear);
		return jsonObject.getString(ACTUAL+"."+ACTUALS+"."+TEMPERATURES+"."+MAXIMUM+"."+unit+"."+VALUE);
	}
	
	/**
	 * @author HFARAZ
	 * This method will get the values for minimum temperature  for the last year from the API 
	 * based on the unit (Imperial/Metric)
	 * */
	public static String getMinimumLastYearTemp(String unit)
	{
		JsonPath jsonObject = new JsonPath(temperatureHistoryLastYear);
		return jsonObject.getString(ACTUAL+"."+ACTUALS+"."+TEMPERATURES+"."+MINIMUM+"."+unit+"."+VALUE);
	}
	
	public static void getTemperatureHistoryDataForUI(String currentDate, String lastYearDate, String unit, String locationKey)
	{
		getTemperatureHistoryResponse(currentDate,locationKey);
		getTemperatureHistoryLastYear(lastYearDate, locationKey);
		averageMaxTemp_UI = CommonUtilities.roundingUpDecimals(getMaximumAverageTemp(unit))+DEGREE_SYMBOL;
		averageMinTemp_UI = CommonUtilities.roundingUpDecimals(getMinimumAverageTemp(unit))+DEGREE_SYMBOL;
		recordMaxTemp_UI = CommonUtilities.roundingUpDecimals(getMaximumRecordTemp(unit))+DEGREE_SYMBOL;
		recordMinTemp_UI = CommonUtilities.roundingUpDecimals(getMinimumRecordTemp(unit))+DEGREE_SYMBOL;
		recordMaxTempYear_UI = getYearForMaximumRecordTemp();
		recordMinTempYear_UI = getYearForMinimumRecordTemp();
		maxTempLastYear_UI = CommonUtilities.roundingUpDecimals(getMaximumLastYearTemp(unit))+DEGREE_SYMBOL;
		minTempLastYear_UI = CommonUtilities.roundingUpDecimals(getMinimumLastYearTemp(unit))+DEGREE_SYMBOL;	
	}
	
	/**
	 * Use the main method to see the values returned from API
	 * */
	public static void main(String[] args) 
	{
		getTemperatureHistoryDataForUI("2020/02/18", "2019/02/18", IMPERIAL, "349726");
		System.out.println(getMaximumRecordTemp(IMPERIAL));
		System.out.println(getMinimumRecordTemp(IMPERIAL));
		System.out.println(getYearForMaximumRecordTemp());
		System.out.println(getYearForMinimumRecordTemp());
		System.out.println(getMaximumAverageTemp(IMPERIAL));
		System.out.println(getMinimumAverageTemp(IMPERIAL));
		System.out.println(getMaximumLastYearTemp(IMPERIAL));
		System.out.println(getMinimumLastYearTemp(IMPERIAL));
		System.out.println("Average Max Temp ----> "+averageMaxTemp_UI);
		System.out.println("Average Min Temp-----> "+averageMinTemp_UI);
		System.out.println("Record Max Temp-----> "+recordMaxTemp_UI);
		System.out.println("Record Min Temp-----> "+recordMinTemp_UI);
		System.out.println("Year in Record (Max)----> "+recordMaxTempYear_UI);
		System.out.println("Year in Record (Min)----> "+recordMinTempYear_UI);
		System.out.println("Max Temp in Last Year---->"+maxTempLastYear_UI);
		System.out.println("Min Temp in Last Year---->"+minTempLastYear_UI);
	}
	
}
	