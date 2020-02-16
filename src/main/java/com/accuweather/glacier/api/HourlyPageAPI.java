package com.accuweather.glacier.api;

import java.text.DecimalFormat;
import java.util.ArrayList;
import com.chameleon.utils.date.SimpleDate;
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
	
	/*************************** Array Lists for API ********************************/
	public static ArrayList<String> iconPhrase_API;
	public static ArrayList<String> temperature_API;
	public static ArrayList<String> time_API;
	public static ArrayList<String> date_API;
	public static ArrayList<String> precipitation_API;
	public static ArrayList<String> realFeel_API;
	public static ArrayList<String> windValue_API;
	public static ArrayList<String> windUnit_API;
	public static ArrayList<String> windDirection_API;
	public static ArrayList<String> windGustsValue_API;
	public static ArrayList<String> windGustsUnit_API;
	public static ArrayList<String> humidity_API;
	public static ArrayList<String> dewPoint_API;
	public static ArrayList<String> UVIndexValue_API;
	public static ArrayList<String> UVIndexText_API;
	public static ArrayList<String> cloudCover_API;
	public static ArrayList<String> rainValue_API;
	public static ArrayList<String> rainUnit_API;
	public static ArrayList<String> snowValue_API;
	public static ArrayList<String> snowUnit_API;
	public static ArrayList<String> iceValue_API;
	public static ArrayList<String> iceUnit_API;
	public static ArrayList<String> visibilityValue_API;
	public static ArrayList<String> visibilityUnit_API;
	public static ArrayList<String> ceilingValue_API;
	public static ArrayList<String> ceilingUnit_API;
	
	/*************************** Array Lists for UI ************************************/
	public static ArrayList<String> iconPhrase_UI;
	public static ArrayList<String> temperature_UI;
	public static ArrayList<String> time_UI;
	public static ArrayList<String> date_UI;
	public static ArrayList<String> precipitation_UI;
	public static ArrayList<String> realFeel_UI;
	public static ArrayList<String> wind_UI;
	public static ArrayList<String> windGusts_UI;
	public static ArrayList<String> humidity_UI;
	public static ArrayList<String> dewPoint_UI;
	public static ArrayList<String> UVIndex_UI;
	public static ArrayList<String> cloudCover_UI;
	public static ArrayList<String> rain_UI;
	public static ArrayList<String> snow_UI;
	public static ArrayList<String> ice_UI;
	public static ArrayList<String> visibility_UI;
	public static ArrayList<String> ceiling_UI;
	
	
	/************************************ UI TEXT *******************************************************/
	public static final String ArrayName = "array";
	public static String timeStampTime = "";
	public static String timeStampDate = "";
	public static int rowNo=0;
	public static final String AM = " AM";
	public static final String PM = " PM";
	public static final String PRECIP = "Precip ";
	public static final String DEGREE_SYMBOL = "°";
	public static final String PERCENTAGE_SYMBOL = "%";
	public static final String REALFEEL = "RealFeel®: ";
	public static final String WIND = "Wind: ";
	public static final String WINDGUSTS = "Wind Gusts: ";
	public static final String HUMIDITY = "Humidity: ";
	public static final String DEW_POINT = "Dew Point: ";
	public static final String MAX_UV_INDEX = "Max UV Index: ";
	public static final String CLOUD_COVER = "Cloud Cover: ";
	public static final String RAIN = "Rain: ";
	public static final String SNOW = "Snow: ";
	public static final String ICE = "Ice: ";
	public static final String VISIBILITY = "Visibility: ";
	public static final String CEILING = "Ceiling: ";
	public static final String MPH = "mph";
	public static final String INCHES = "in";
	public static final String MILES = "mi";
	public static final String CENTIMETRES = "cm";
	public static final String MILLIMETRES = "mm";
	
	
	
	/**
	 * @author HFARAZ
	 * Method to get the location details response and store it in a String a variable
	 * */
	public static String getLocationDetailsResponse()
	{
		readLocationKeysFile();
		Response response = getLocationDetails(getLocationKey(rowNo));
		
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
	 * Method to get statecode from the locationKeys.xlsx file
	 * **/
	public static String getStateCode()
	{
		return getStateCode(rowNo);
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
	public static Response getHourlyForecastDetailsJSONResponse(String currentDate, String unit)
	{
		locationDetailsResponse = getLocationDetailsResponse();
		locationCode = getLocationCode(locationDetailsResponse);
		
		locationOffSet = getLocationOffSet(locationDetailsResponse);
		
		hourlyForecastJSONResponse = getHourlyPageDetails(locationCode,locationOffSet, currentDate, unit);
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
	 * Method to get hourly forecast data based on the city, date(yyyy-MM-dd) and unit (imperial or metric)
	 * */
	public static void getHourlyForecastData(String cityName, String currentDate, String unit)
	{
		rowNo = getRowNumberForCity(cityName);
		
		hourlyForecastDetailsResponse = getHourlyForecastDetailsJSONResponse(currentDate, unit).asString();
		JsonPath jsonObject = new JsonPath(hourlyForecastDetailsResponse);
		
		iconPhrase_API	 	= new ArrayList<String>();
		temperature_API 	= new ArrayList<String>();
		time_API 			= new ArrayList<String>();
		date_API 			= new ArrayList<String>();
		precipitation_API 	= new ArrayList<String>();
		realFeel_API 		= new ArrayList<String>();
		windValue_API 		= new ArrayList<String>();
		windUnit_API 		= new ArrayList<String>();
		windDirection_API 	= new ArrayList<String>();
		windGustsValue_API 	= new ArrayList<String>();
		windGustsUnit_API 	= new ArrayList<String>();
		humidity_API 		= new ArrayList<String>();
		dewPoint_API 		= new ArrayList<String>();
		UVIndexValue_API 	= new ArrayList<String>();
		UVIndexText_API 	= new ArrayList<String>();
		cloudCover_API 		= new ArrayList<String>();
		rainValue_API 		= new ArrayList<String>();
		rainUnit_API 		= new ArrayList<String>();
		snowValue_API 		= new ArrayList<String>();
		snowUnit_API 		= new ArrayList<String>();
		iceValue_API 		= new ArrayList<String>();
		iceUnit_API 		= new ArrayList<String>();
		visibilityValue_API = new ArrayList<String>();
		visibilityUnit_API 	= new ArrayList<String>();
		ceilingValue_API 	= new ArrayList<String>();
		ceilingUnit_API 	= new ArrayList<String>();
		
		for (int count=0;count<NoOfHoursForTheDay();count++)
		{
			hourlyPageDateAndTimeFormat(jsonObject.getString("["+count+"].DateTime"));
			date_API.add(timeStampDate);
			time_API.add(timeStampTime);
			
			iconPhrase_API.add(jsonObject.getString("["+count+"].IconPhrase"));
			temperature_API.add(jsonObject.getString("["+count+"].Temperature.Value"));
			precipitation_API.add(jsonObject.getString("["+count+"].PrecipitationProbability"));
			realFeel_API.add(jsonObject.getString("["+count+"].RealFeelTemperature.Value"));
			windValue_API.add(jsonObject.getString("["+count+"].Wind.Speed.Value"));
			windUnit_API.add(jsonObject.getString("["+count+"].Wind.Speed.Unit"));
			windDirection_API.add(jsonObject.getString("["+count+"].Wind.Direction.Localized"));
			windGustsValue_API.add(jsonObject.getString("["+count+"].WindGust.Speed.Value"));
			windGustsUnit_API.add(jsonObject.getString("["+count+"].WindGust.Speed.Unit"));
			humidity_API.add(jsonObject.getString("["+count+"].RelativeHumidity"));
			dewPoint_API.add(jsonObject.getString("["+count+"].DewPoint.Value"));
			UVIndexValue_API.add(jsonObject.getString("["+count+"].UVIndex"));
			UVIndexText_API.add(jsonObject.getString("["+count+"].UVIndexText"));
			cloudCover_API.add(jsonObject.getString("["+count+"].CloudCover"));
			rainValue_API.add(jsonObject.getString("["+count+"].Rain.Value"));
			rainUnit_API.add(jsonObject.getString("["+count+"].Rain.Unit"));
			snowValue_API.add(jsonObject.getString("["+count+"].Snow.Value"));
			snowUnit_API.add(jsonObject.getString("["+count+"].Snow.Unit"));
			iceValue_API.add(jsonObject.getString("["+count+"].Ice.Value"));
			iceUnit_API.add(jsonObject.getString("["+count+"].Ice.Unit"));
			visibilityValue_API.add(jsonObject.getString("["+count+"].Visibility.Value"));
			visibilityUnit_API.add(jsonObject.getString("["+count+"].Visibility.Unit"));
			ceilingValue_API.add(jsonObject.getString("["+count+"].Ceiling.Value"));
			ceilingUnit_API.add(jsonObject.getString("["+count+"].Ceiling.Unit"));
		}
		
	}
	
	/**
	 * @author HFARAZ
	 * This method calls the getHourlyForecastData() method and get the API data for hourly page 
	 * based on the city, date and unit provided in parameters and converts the API data 
	 * as per the Hourly page format
	 * */
	public static void getHourlyPageAPIData(String cityName, String currentDate, String unit)
	{
		getHourlyForecastData(cityName, currentDate, unit);
		time_UI 				= new ArrayList<String>();
		date_UI 				= new ArrayList<String>();
		iconPhrase_UI 			= new ArrayList<String>();
		temperature_UI			= new ArrayList<String>();
		precipitation_UI		= new ArrayList<String>();
		realFeel_UI				= new ArrayList<String>();
		wind_UI					= new ArrayList<String>();
		windGusts_UI			= new ArrayList<String>();
		humidity_UI				= new ArrayList<String>();
		dewPoint_UI				= new ArrayList<String>();
		UVIndex_UI				= new ArrayList<String>();
		cloudCover_UI			= new ArrayList<String>();
		rain_UI					= new ArrayList<String>();
		snow_UI					= new ArrayList<String>();
		ice_UI					= new ArrayList<String>();
		visibility_UI			= new ArrayList<String>();
		ceiling_UI				= new ArrayList<String>();
				
		for (int count=0;count<NoOfHoursForTheDay();count++)
		{
			time_UI.add(getTimeAsPerHourlyPageUI(time_API.get(count)));
			date_UI.add(getDateAsPerHourlyPageUI(date_API.get(count)));
			iconPhrase_UI.add(iconPhrase_API.get(count));
			temperature_UI.add(getTemperatureAsPerHourlyPageUI(temperature_API.get(count)));
			precipitation_UI.add(getPrecipitationAsPerTheHourlyPage(precipitation_API.get(count)));
			realFeel_UI.add(getRealFeelAsPerHourlyPageUI(realFeel_API.get(count)));
			wind_UI.add(getWindAsPerHourlyPageUI(windValue_API.get(count), windDirection_API.get(count), windUnit_API.get(count)));
			windGusts_UI.add(getWindGustsAsPerHourlyPageUI(windGustsValue_API.get(count), windGustsUnit_API.get(count)));
			humidity_UI.add(getHumidityAsPerHourlyPageUI(humidity_API.get(count)));
			dewPoint_UI.add(getDewPointAsPerHourlyPageUI(dewPoint_API.get(count)));
			UVIndex_UI.add(getUVIndexAsPerHourlyPageUI(UVIndexValue_API.get(count), UVIndexText_API.get(count)));
			cloudCover_UI.add(getCloudCoverAsPerHourlyPageUI(cloudCover_API.get(count)));
			rain_UI.add(getRainAsPerHourlyPageUI(rainValue_API.get(count), rainUnit_API.get(count)));
			snow_UI.add(getSnowAsPerHourlyPageUI(snowValue_API.get(count), snowUnit_API.get(count)));
			ice_UI.add(getIceAsPerHourlyPageUI(iceValue_API.get(count), iceUnit_API.get(count)));
			visibility_UI.add(getVisibilityAsPerHourlyPageUI(visibilityValue_API.get(count), visibilityUnit_API.get(count)));
			ceiling_UI.add(getCeilingAsPerHourlyPageUI(ceilingValue_API.get(count),ceilingUnit_API.get(count)));
		}
	}
	
	/**
	 * @author HFARAZ
	 * Method to convert the time as per the Hourly Page format
	 * */
	public static String getTimeAsPerHourlyPageUI(String timeFromAPI)
	{
		String timeOnUI;
		
		if(Integer.parseInt(timeFromAPI)<12)
		{
			if(Integer.parseInt(timeFromAPI)==00)
				timeOnUI = "12"+AM;
			else
				timeOnUI = String.valueOf(Integer.parseInt(timeFromAPI))+AM;
		
		}
		else if(Integer.parseInt(timeFromAPI)==12)
			timeOnUI = String.valueOf(Integer.parseInt(timeFromAPI))+PM;
		
		else
			timeOnUI = String.valueOf(Integer.parseInt(timeFromAPI)-12)+PM;
		
		return timeOnUI;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format date as per the Hourly Page UI
	 * */
	public static String getDateAsPerHourlyPageUI(String dateFromAPI)
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
	
	
	/**
	 * @author HFARAZ
	 * Method to convert float value to int for temperature
	 * */
	public static String getTemperatureAsPerHourlyPageUI(String temperatureFromAPI)
	{
		return roundingUpDecimals(temperatureFromAPI)+DEGREE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Precipitation as per the Hourly Page UI
	 * */
	public static String getPrecipitationAsPerTheHourlyPage(String precipitationFromAPI)
	{
		return PRECIP+precipitationFromAPI+PERCENTAGE_SYMBOL;
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to convert float value to int for Real Feel
	 * */
	public static String getRealFeelAsPerHourlyPageUI(String realFeelFromAPI)
	{
		return REALFEEL+roundingUpDecimals((realFeelFromAPI))+DEGREE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to convert float value to int for Wind
	 * */
	public static String getWindAsPerHourlyPageUI(String windFromAPI, String windDirectionFromAPI,String windUnitFromAPI)
	{
		if(windUnitFromAPI.equalsIgnoreCase("mi/h"))
			return WIND+windDirectionFromAPI+" "+roundingUpDecimals((windFromAPI))+" "+MPH;
		else
			return WIND+windDirectionFromAPI+" "+roundingUpDecimals((windFromAPI))+" "+windUnitFromAPI;
	}
	
	/**
	 * @author HFARAZ
	 * Method to convert float value to int for WindGusts
	 * */
	public static String getWindGustsAsPerHourlyPageUI(String windGustsFromAPI, String windUnitFromAPI)
	{
		if(windUnitFromAPI.equalsIgnoreCase("mi/h"))
			return WINDGUSTS+roundingUpDecimals((windGustsFromAPI))+" "+MPH;
		else
			return WINDGUSTS+roundingUpDecimals((windGustsFromAPI))+" "+windUnitFromAPI;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Humidity value as per the Hourly Page UI
	 * */
	public static String getHumidityAsPerHourlyPageUI(String humidityFromAPI)
	{
		return HUMIDITY+humidityFromAPI+PERCENTAGE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Dew Point value as per the Hourly Page UI
	 * */
	public static String getDewPointAsPerHourlyPageUI(String dewPointFromAPI)
	{
		return DEW_POINT+roundingUpDecimals((dewPointFromAPI))+DEGREE_SYMBOL;
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to format UV Index value as per the Hourly Page UI
	 * */
	public static String getUVIndexAsPerHourlyPageUI(String uvIndexValueFromAPI, String uvIndexRangeFromAPI)
	{
		return MAX_UV_INDEX+roundingUpDecimals((uvIndexValueFromAPI))+" ("+uvIndexRangeFromAPI+")";
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Cloud Cover value as per the Hourly Page UI
	 * */
	public static String getCloudCoverAsPerHourlyPageUI(String cloudCoverValueFromAPI)
	{
		return CLOUD_COVER+roundingUpDecimals((cloudCoverValueFromAPI))+PERCENTAGE_SYMBOL;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Rain value as per the Hourly Page UI
	 * */
	public static String getRainAsPerHourlyPageUI(String rainValueFromAPI, String rainUnit)
	{
		if(rainUnit.equalsIgnoreCase(INCHES))
			return RAIN+roundToTwoDecimalPlaces((rainValueFromAPI))+" "+rainUnit;
		else
			return RAIN+roundToOneDecimalPlaces((rainValueFromAPI))+" "+rainUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Snow value as per the Hourly Page UI
	 * */
	public static String getSnowAsPerHourlyPageUI(String snowValueFromAPI, String snowUnit)
	{
		return SNOW+roundToOneDecimalPlaces((snowValueFromAPI))+" "+snowUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Ice value as per the Hourly Page UI
	 * */
	public static String getIceAsPerHourlyPageUI(String iceValueFromAPI, String iceUnit)
	{
		if(iceUnit.equalsIgnoreCase(INCHES))
			return ICE+roundToTwoDecimalPlaces((iceValueFromAPI))+" "+iceUnit;
		else
			return ICE+roundToOneDecimalPlaces((iceValueFromAPI))+" "+iceUnit;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Visibility value as per the Hourly Page UI
	 * */
	public static String getVisibilityAsPerHourlyPageUI(String visibilityFromAPI, String visibilityUnitFromAPI)
	{
		return VISIBILITY+roundingUpDecimals((visibilityFromAPI))+" "+visibilityUnitFromAPI;
	}
	
	/**
	 * @author HFARAZ
	 * Method to format Ceiling value as per the Hourly Page UI
	 * */
	public static String getCeilingAsPerHourlyPageUI(String ceilingValueFromAPI, String ceilingUnit)
	{
		return CEILING+roundingUpDecimals((ceilingValueFromAPI))+" "+ceilingUnit;
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
	 * Method to round the number upto two decimal places
	 * **/
	public static String roundToTwoDecimalPlaces(String value)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(Math.round(Double.valueOf(value))).toString();
	}
	
	/**
	 * @author HFARAZ
	 * Method to round the number upto one decimal places
	 * **/
	public static String roundToOneDecimalPlaces(String value)
	{
		DecimalFormat df = new DecimalFormat("0.0");
		return df.format(Math.round(Double.valueOf(value))).toString();
	}
	
	public static void main(String[] args)
	{
		/************* test rounding up scenarios *************************/
		System.out.println(roundingUpDecimals("0.02"));
		System.out.println(roundingUpDecimals("0.25"));
		System.out.println(roundingUpDecimals("0.5"));
		System.out.println(roundingUpDecimals("0.9"));
		System.out.println(roundingUpDecimals("1.5"));
		System.out.println(roundingUpDecimals("1.4"));
		
		/**************** test two decimal places scenarios *******************/
		System.out.println("**************** up to two decimal places scenarios*******************");
		System.out.println(roundToTwoDecimalPlaces("0.02"));
		System.out.println(roundToTwoDecimalPlaces("0.05"));
		System.out.println(roundToTwoDecimalPlaces("0.50"));
		System.out.println(roundToTwoDecimalPlaces("0.7"));
		System.out.println(roundToTwoDecimalPlaces("2.4"));
		
		/****************** test one decimal places scenarios ******************************/
		System.out.println("********************** One decimal places scenarios *************");
		System.out.println(roundToOneDecimalPlaces("0.2"));
		System.out.println(roundToOneDecimalPlaces("0.5"));
		System.out.println(roundToOneDecimalPlaces("0.7"));
		System.out.println(roundToOneDecimalPlaces("1.4"));
		
		
		
		
		
		SimpleDate sd = new SimpleDate();

		getHourlyPageAPIData("Buffalo",sd.getCurrentDate("yyyy-MM-dd"),"IMPERIAL");
		//getHourlyForecastData("Buffalo",sd.getTomorrowDate("yyyy-MM-dd"),"IMPERIAL");
		  
		  for(int i=0;i<NoOfHoursForTheDay();i++)
		  {
		  System.out.println("Date--->"+date_API.get(i));
		  System.out.println("Time--->"+time_API.get(i));
		  System.out.println("Icon Phrase---->"+iconPhrase_API.get(i));
		  System.out.println("Temperature----->"+temperature_API.get(i));
		  System.out.println("Precipitation---->"+precipitation_API.get(i));
		  System.out.println("Real Feel----->"+realFeel_API.get(i));
		  System.out.println("Wind Value----->"+windValue_API.get(i));
		  System.out.println("Wind Unit---->"+windUnit_API.get(i));
		  System.out.println("Wind Direction----->"+windDirection_API.get(i));
		  System.out.println("Wind Gusts----->"+windGustsValue_API.get(i));
		  System.out.println("Wind Gusts Unit----->"+windGustsUnit_API.get(i));
		  System.out.println("Humidity----->"+humidity_API.get(i));
		  System.out.println("Dew Point----->"+dewPoint_API.get(i));
		  System.out.println("Max UV Index----->"+UVIndexValue_API.get(i)+UVIndexText_API.get(i));
		  System.out.println("Cloud Cover----->"+cloudCover_API.get(i));
		  System.out.println("Rain Value----->"+rainValue_API.get(i));
		  System.out.println("Rain Unit----->"+rainUnit_API.get(i));
		  System.out.println("Snow Value----->"+snowValue_API.get(i));
		  System.out.println("Snow Unit----->"+snowUnit_API.get(i));
		  System.out.println("Ice Value----->"+iceValue_API.get(i));
		  System.out.println("Ice Unit----->"+iceUnit_API.get(i));
		  System.out.println("Visibility Value----->"+visibilityValue_API.get(i));
		  System.out.println("Visibility Unit----->"+visibilityUnit_API.get(i));
		  System.out.println("Ceiling Value----->"+ceilingValue_API.get(i));
		  System.out.println("Ceiling Unit----->"+ceilingUnit_API.get(i));
		  
		  
		  /********************** Values of UI as per the UI format***************************/
		  System.out.println("*************************** UI Format ***************************************");
		  System.out.println("Date on UI-------"+date_UI.get(i));
		  System.out.println("Time on UI-------"+time_UI.get(i));
		  System.out.println("Temperature on UI-----"+temperature_UI.get(i));
		  System.out.println("Icon Phrase on UI-----"+iconPhrase_UI.get(i));
		  System.out.println("Precipitation on UI----->"+precipitation_UI.get(i));
		  System.out.println("Real Feel on UI----->"+realFeel_UI.get(i));
		  System.out.println("Wind on UI----->"+wind_UI.get(i));
		  System.out.println("WindGusts on UI----->"+windGusts_UI.get(i));
		  System.out.println("Humidity on UI--->"+humidity_UI.get(i));
		  System.out.println("Dew Point on UI--->"+dewPoint_UI.get(i));
		  System.out.println("max UV Index on UI--->"+UVIndex_UI.get(i));
		  System.out.println("Cloud Cover on UI--->"+cloudCover_UI.get(i));
		  System.out.println("Rain on UI--->"+rain_UI.get(i));
		  System.out.println("Snow on UI--->"+snow_UI.get(i));
		  System.out.println("Ice on UI--->"+ice_UI.get(i));
		  System.out.println("Visibility on UI--->"+visibility_UI.get(i));
		  System.out.println("Ceiling on UI--->"+ceiling_UI.get(i));
		  System.out.println("/*************************************************************************************************");
		  }
		 
		  /***************** test time in different scenarios ************************/
		  System.out.println(getTimeAsPerHourlyPageUI("09"));
		  System.out.println(getTimeAsPerHourlyPageUI("11"));
		  System.out.println(getTimeAsPerHourlyPageUI("12"));
		  System.out.println(getTimeAsPerHourlyPageUI("15"));
		  System.out.println(getTimeAsPerHourlyPageUI("00"));
		  
		 
		
	}
}
