package com.accuweather.glacier.api;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author HFARAZ This class deals with Current Condition API objects
 */
public class CurrentConditionAPI extends APIUtilities 
{
	public static Response currentWeatherResponse = null;
	protected JsonPath jsonPathEvaluator = null;
	protected ArrayList responseList = null;
	protected ArrayList weatherDesc;
	public static String weatherDescription_UI;
	protected ArrayList weatherIcon;
	public static String weatherIcon_UI;
	protected ArrayList cloudCover;
	public static String cloudCover_UI;
	protected ArrayList humidity;
	public static String humidity_UI;
	protected ArrayList temperature;
	public static String temperature_UI;
	public static String temperatureUnit_UI;
	protected ArrayList realFeelTemp;
	public static String realFeelTemp_UI;
	protected ArrayList realFeelTempShade;
	public static String realFeelTempShade_UI;
	protected ArrayList dewPoint;
	public static String dewPoint_UI;
	protected ArrayList wind;
	public static String wind_UI;
	protected ArrayList windGust;
	public static String windGust_UI;
	protected ArrayList visibility;
	public static String visibility_UI;
	protected ArrayList ceiling;
	public static String ceiling_UI;
	protected ArrayList pressure;
	public static String pressure_UI;
	protected ArrayList uvIndex;
	public static String uvIndex_UI;
	protected ArrayList uvIndexText;

/*********************** CURRENT WEATHER PAGE UI TEXTS FORMAT ******************************/	
	public static final String AM = " AM";
	public static final String PM = " PM";
	public static final String PRECIP = "Precip ";
	public static final String DEGREE_SYMBOL = "°";
	public static final String PERCENTAGE_SYMBOL = "%";
	public static final String REALFEEL_UI_LABEL = "RealFeel® ";
	public static final String REALFEEL_SHADE_UI_LABEL = "RealFeel Shade™ ";
	public static final String UV_INDEX_UI_LABEL = "UV Index: ";
	public static final String WIND_UI_LABEL = "Wind: ";
	public static final String WINDGUSTS_UI_LABEL = "Wind Gusts: ";
	public static final String HUMIDITY_UI_LABEL = "Humidity: ";
	public static final String DEW_POINT_UI_LABEL = "Dew Point: ";
	public static final String PRESSURE_UI_LABEL = "Pressure: ";
	public static final String CLOUD_COVER_UI_LABEL = "Cloud Cover: ";
	public static final String VISIBILITY_UI_LABEL = "Visibility: ";
	public static final String CEILING_UI_LABEL = "Ceiling: ";
	public static final String KMH = " km/h";
	public static final String MPH = " mph";
	public static final String KM = " km";
	public static final String MI = " mi";
	public static final String METRES = " m";
	public static final String FEET = " ft";
	public static final String HG = " inHg";
	public static final String MBAR = " mbar";
	
	
/*********************** API OBJECTS *****************************************************/
	public static final String WEATHER_TEXT = "WeatherText";
	public static final String WEATHER_ICON = "WeatherIcon";
	public static final String CLOUD_COVER = "CloudCover";
	public static final String RELATIVE_HUMIDITY = "RelativeHumidity";
	public static final String TEMPERATURE = "Temperature";
	public static final String REALFEEL_TEMPERATURE = "RealFeelTemperature";
	public static final String REALFEEL_TEMPERATURE_SHADE = "RealFeelTemperatureShade";
	public static final String DEW_POINT = "DewPoint";
	public static final String VISIBILITY = "Visibility";
	public static final String CEILING = "Ceiling";
	public static final String PRESSURE = "Pressure";
	public static final String WIND_GUST = "WindGust";
	public static final String WIND = "Wind";
	public static final String UV_INDEX = "UVIndex";
	public static final String UV_INDEX_TEXT = "UVIndexText";
	public static final String VALUE = "Value";
	public static final String UNIT = "Unit";
	public static final String LOCALIZED = "Localized";
	public static final String SPEED = "Speed";
	public static final String DIRECTION = "Direction";
	
/************************** UNIT TYPES ************************************************/
	public static final String METRIC = "Metric";
	public static final String IMPERIAL = "Imperial";
	
	
	
	/**
	 * @author HFARAZ
	 * Method to get the current weather API data
	 * @param location key for the city 
	 * @return the current weather API response as String
	 * */
	public static String getCurrentWeatherAPIData(String locationKey)
	{
		currentWeatherResponse = getCurrentConditionsDetails(locationKey);
		return currentWeatherResponse.asString();
	}

public void CurrentConditionAPIHelper(String locationKey)
{
	currentWeatherResponse = getCurrentConditionsDetails(locationKey);
	jsonPathEvaluator = currentWeatherResponse.jsonPath();
	
	weatherDesc			=jsonPathEvaluator.get(WEATHER_TEXT);
	weatherIcon			=jsonPathEvaluator.get(WEATHER_ICON); 
	cloudCover			=jsonPathEvaluator.get(CLOUD_COVER);
	humidity			=jsonPathEvaluator.get(RELATIVE_HUMIDITY);
	temperature			=jsonPathEvaluator.get(TEMPERATURE);
	realFeelTemp		=jsonPathEvaluator.get(REALFEEL_TEMPERATURE);
	realFeelTempShade	=jsonPathEvaluator.get(REALFEEL_TEMPERATURE_SHADE);
	dewPoint			=jsonPathEvaluator.get(DEW_POINT);
	visibility			=jsonPathEvaluator.get(VISIBILITY);
	ceiling				=jsonPathEvaluator.get(CEILING);
	pressure			=jsonPathEvaluator.get(PRESSURE);
	windGust			=jsonPathEvaluator.get(WIND_GUST);
	wind				=jsonPathEvaluator.get(WIND);
	uvIndex				=jsonPathEvaluator.get(UV_INDEX);
	uvIndexText			=jsonPathEvaluator.get(UV_INDEX_TEXT);
}

	/**
	 * Method to get weather description
	 * */
	public String getWeatherDescription()
	{
		return (String) weatherDesc.get(0);
	}
	
	/**
	 * Method to get weather icon
	 * */
	public String getWeatherIcon()
	{
		System.out.println(weatherIcon.get(0));
		return weatherIcon.get(0).toString();
	}

	/**
	 * Method to get UV Index as per the Current Weather UI format
	 * */
	public String getUVIndex()
	{
		return UV_INDEX_UI_LABEL+uvIndex.get(0).toString() + " " + uvIndexText.get(0).toString();
	}

	/**
	 * Method to get Cloud Cover as per the Current Weather UI format
	 * */
	public String getCloudCover()
	{
		return CLOUD_COVER_UI_LABEL+cloudCover.get(0).toString() + PERCENTAGE_SYMBOL;
	}

	/**
	 * Method to get Humidity as per the Current Weather UI format
	 * */
	public String getHumidity()
	{
		return HUMIDITY_UI_LABEL+humidity.get(0).toString() + PERCENTAGE_SYMBOL;
	}

	/**
	 * Method to get Current Temperature as per the Current Weather UI format
	 * */
	public String getCurrentTemp(String type)
	{
		HashMap nodeValue = (HashMap) temperature.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		
		return Integer.toString((int) Math.round(value)) + DEGREE_SYMBOL;

	}
	
	/**
	 * Method to get Current Temperature Unit as per the Current Weather UI format
	 * */
	public String getCurrentTempUnit(String type)
	{
		HashMap nodeValue = (HashMap) temperature.get(0);
		HashMap unitValues = (HashMap) nodeValue.get(type);
		String unit = unitValues.get(UNIT).toString();
		
		return unit;

	}

	/**
	 * Method to get RealFeel Temperature as per the Current Weather UI format
	 * */
	public String getRealFeelTemp(String type)
	{
		HashMap nodeValue = (HashMap) realFeelTemp.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		
		return REALFEEL_UI_LABEL+Integer.toString((int) Math.round(value)) + DEGREE_SYMBOL;

	}

	/**
	 * Method to get RealFeel Temperature Shade as per the Current Weather UI format
	 * */
	public String getRealFeelTempShade(String type)
	{
		HashMap nodeValue = (HashMap) realFeelTempShade.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		
		return REALFEEL_SHADE_UI_LABEL+Integer.toString((int) Math.round(value)) + DEGREE_SYMBOL;

	}

	/**
	 * Method to get Dew Point as per the Current Weather UI format
	 * */
	public String getdewPoint(String type)
	{
		HashMap nodeValue = (HashMap) dewPoint.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		
		return DEW_POINT_UI_LABEL+Integer.toString((int) Math.round(value)) + DEGREE_SYMBOL;

	}

	/**
	 * Method to get Visibility as per the Current Weather UI format
	 * */
	public String getVisibility(String type)
	{
		HashMap nodeValue = (HashMap) visibility.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		String unit = null;
		if (type == METRIC)
		{
			unit = KM;
		}
		else
		{
			unit = MI;
		}
		return VISIBILITY_UI_LABEL+Integer.toString((int) Math.round(value)) + unit;

	}

	public String getCeiling(String type)
	{
		HashMap nodeValue = (HashMap) ceiling.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		String unit = null;
		if (type == METRIC)
		{
			unit = METRES;
		} 
		else
		{
			unit = FEET;
		}

		return CEILING_UI_LABEL+Integer.toString((int) Math.round(value)) + unit;

	}

	public String getPressure(String type)
	{
		HashMap nodeValue = (HashMap) pressure.get(0);
		HashMap tempValues = (HashMap) nodeValue.get(type);
		float value = (float) tempValues.get(VALUE);
		String unit = null;
		if (type == METRIC)
		{
			unit = MBAR;
		}
		else
		{
			unit = HG;
		}

		DecimalFormat df = new DecimalFormat("0.00");
		return PRESSURE_UI_LABEL+df.format(value) + unit;

	}

	public String getWindGust(String type)
	{
		HashMap nodeValue = (HashMap) windGust.get(0);
		HashMap innerNodeValue = (HashMap) nodeValue.get(SPEED);
		HashMap tempValues = (HashMap) innerNodeValue.get(type);
		String unit = null;
		if (type == METRIC)
		{
			unit = KMH;
		}
		else
		{
			unit = MPH;
		}

		float value = (float) tempValues.get(VALUE);
		return WINDGUSTS_UI_LABEL+Integer.toString((int) Math.round(value)) + unit;

	}

	public String getWind(String type) 
	{
		HashMap nodeValue = (HashMap) wind.get(0);
		HashMap speed = (HashMap) nodeValue.get(SPEED);
		HashMap direction = (HashMap) nodeValue.get(DIRECTION);

		HashMap parseSpeed = (HashMap) speed.get(type);
		String unit = null;
		if (type == METRIC)
		{
			unit = KMH;
		}
		else
		{
			unit = MPH;
		}

		int speedValue = (int) Math.round((float) parseSpeed.get(VALUE));
		String directionValue = (String) direction.get(LOCALIZED);
		return WIND_UI_LABEL+directionValue + " at " + speedValue + unit;

	}
	
	
	/**
	 * @author HFARAZ
	 * 
	 * */
	public static void getCurrentConditionDataForUI(String locationKey, String unit)
	{
		CurrentConditionAPI currentCondition = new CurrentConditionAPI();
		currentCondition.CurrentConditionAPIHelper(locationKey);
		
		weatherDescription_UI = currentCondition.getWeatherDescription();
		weatherIcon_UI = currentCondition.getWeatherIcon();
		cloudCover_UI = currentCondition.getCloudCover();
		humidity_UI = currentCondition.getHumidity();
		temperature_UI = currentCondition.getCurrentTemp(unit);
		temperatureUnit_UI = currentCondition.getCurrentTempUnit(unit);
		realFeelTemp_UI = currentCondition.getRealFeelTemp(unit);
		realFeelTempShade_UI = currentCondition.getRealFeelTempShade(unit);
		dewPoint_UI = currentCondition.getdewPoint(unit);
		wind_UI = currentCondition.getWind(unit);
		windGust_UI = currentCondition.getWindGust(unit);
		visibility_UI = currentCondition.getVisibility(unit);
		ceiling_UI = currentCondition.getCeiling(unit);
		pressure_UI = currentCondition.getPressure(unit);
		uvIndex_UI = currentCondition.getUVIndex();
		
	}
	
	
	public static void main(String[] args)
	{
		String NEWYORK_CITY_KEY = "349726";
		CurrentConditionAPI currentCondition = new CurrentConditionAPI();
		currentCondition.CurrentConditionAPIHelper(NEWYORK_CITY_KEY);

		System.out.println("Weather Description is: " + currentCondition.getWeatherDescription());
		System.out.println("Current Temp in Imperial:" + currentCondition.getCurrentTemp("Imperial"));
		System.out.println("RealFeel Temp in Imperial:" + currentCondition.getRealFeelTemp("Imperial"));
		System.out.println("RealFeel Shade Temp in Imperial:" + currentCondition.getRealFeelTempShade("Imperial"));
		System.out.println("Imperial" + currentCondition.getCeiling("Imperial"));
		System.out.println("Imperial" + currentCondition.getdewPoint("Imperial"));
		System.out.println("Imperial" + currentCondition.getPressure("Imperial"));
		System.out.println("Imperial" + currentCondition.getVisibility("Imperial"));
		System.out.println(currentCondition.getCloudCover());
		System.out.println(currentCondition.getHumidity());
		System.out.println(currentCondition.getUVIndex());
		System.out.println(currentCondition.getWindGust("Imperial"));
		System.out.println(currentCondition.getWind("Imperial"));

		System.out.println("#################################################");

		System.out.println("Weather Description is: " + currentCondition.getWeatherDescription());
		System.out.println("Current Temp in Metric:" + currentCondition.getCurrentTemp("Metric"));
		System.out.println("RealFeel Temp in Metric:" + currentCondition.getRealFeelTemp("Metric"));
		System.out.println("RealFeel Shade Temp in Metric:" + currentCondition.getRealFeelTempShade("Metric"));
		System.out.println(currentCondition.getCeiling("Metric"));
		System.out.println(currentCondition.getdewPoint("Metric"));
		System.out.println(currentCondition.getPressure("Metric"));
		System.out.println(currentCondition.getVisibility("Metric"));
		System.out.println(currentCondition.getCloudCover());
		System.out.println(currentCondition.getHumidity());
		System.out.println(currentCondition.getUVIndex());
		System.out.println(currentCondition.getWindGust("Metric"));
		System.out.println(currentCondition.getWind("Metric"));
	}
}
