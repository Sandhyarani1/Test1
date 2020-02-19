package com.accuweather.glacier.www.currentCondition;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.chameleon.Utilities.CommonUtilities;
import com.accuweather.glacier.api.CurrentConditionAPI;
import com.accuweather.glacier.api.TemperatureHistoryAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CurrentConditionpage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LegalFooter;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

public class RW_T2253CurrentWeatherDataValidation extends AccuWeatherBaseTest 
{
	public static final String CITYNAME = "Buffalo";
	public static String zipCode = "";
	public static String stateCode = "";
	public static String countryCode = "";
	public static String locationKey = "";
	public static String location = "";
	public static String cityNameForURL = "";
	public static final String IMPERIAL = "Imperial";
	public static final String METRIC = "Metric";
	public static final String DEGREE_SYMBOL = "°";
	public static final String DATEFORMAT = "yyyy/MM/dd";
	public static final String TEMPERATUREHISTORY_DATE_FORMAT = "MMMM dd";
	public static final String LASTYEAR_FORMAT = "yyyy";
	
	/******************** CURRENT WEATHER CARD UI LABELS *******************************/
	public static final String CURRENT_WEATHER = "CURRENT WEATHER";
	
	/******************** TEMPERATURE HISTORY UI LABELS *********************/
	public static final String TEMPERATURE_HISTORY = "TEMPERATURE HISTORY";
	public static final String FORECAST = "Forecast";
	public static final String AVERAGE	= "Average";
	public static final String RECORDS 	= "Records";
	public static final String HIGH		= "Hi";
	public static final String LOW		= "Lo";
	
	
	private LandingPage landingPage = new LandingPage();
	private LegalFooter legalFooter = new LegalFooter();
	private NavigationBar navigationBar = new NavigationBar();
	private CurrentConditionpage currentConditions = new CurrentConditionpage();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void setTestData()
	{
		int rowNo = 0;
		rowNo 				= ExcelUtilities.getRowNumberForCity(CITYNAME);
		zipCode 			= ExcelUtilities.getZipCode(rowNo);
		stateCode 			= ExcelUtilities.getStateCode(rowNo);
		countryCode 		= ExcelUtilities.getCountryCode(rowNo);
		locationKey 		= ExcelUtilities.getLocationKey(rowNo);
		location 			= CITYNAME + ", " + stateCode + ", " + countryCode;
		cityNameForURL 		= CITYNAME.replace(' ', '-');
		
	}
	
	@Test(priority=1)
	public void ImperialDataValidationForCurrentWeather()
	{
		softAssert = new SoftAssert();
		CurrentConditionAPI.getCurrentConditionDataForUI(locationKey, IMPERIAL);
		TemperatureHistoryAPI.getTemperatureHistoryDataForUI(CommonUtilities.getCurrentDate(DATEFORMAT), CommonUtilities.getLastYearDate(DATEFORMAT), IMPERIAL, locationKey);
		
		testStart("*************** Data validations for Current Conditions page for Imperial **********************");
		legalFooter.clickIUnderstand();
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		
		softAssert.assertEquals(currentConditions.getTitleOfCurrentWeathercard(), CURRENT_WEATHER,
				"\nIssue----> Title on Current Weather not as expected\n");
		softAssert.assertEquals(currentConditions.getWeatherIconNumberOnCurrentWeatherCard(), CurrentConditionAPI.weatherIcon_UI,
				"\nIssue----> Weather Icon image number not matching with the API data\n");
		softAssert.assertEquals(currentConditions.getTemperatureOnCurrentWeatherCard(), CurrentConditionAPI.temperature_UI,
				"\nIssue----> Temperature on Current Weather card not matching with API data\n");
		softAssert.assertEquals(currentConditions.getTemperatureUnitOnCurrentWeatherCard(), CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue---->Wrong Temperature Unit on current weather card\n");
		softAssert.assertEquals(currentConditions.getRealFeelOnCurrentWeatherCard(), CurrentConditionAPI.realFeelTemp_UI,
				"\nIssue----->RealFeel temperature not matching with the API data");
		softAssert.assertEquals(currentConditions.getIconPhraseOnCurrentWeatherCard(), CurrentConditionAPI.weatherDescription_UI,
				"\nIssue----> Icon Phrase on Current Weather not matching with the API data\n");
		
		currentConditions.clickCurrentweathercard();
		
		softAssert.assertEquals(currentConditions.getTitleOfCurrentWeatherModule(), CURRENT_WEATHER+"\n"+DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Title on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTempUnitOfCurrentWeatherModule(), DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Temperature Unit on Current Weather module not as expected\n");
		
		softAssert.assertEquals(currentConditions.getWeatherIconNumberOnCurrentWeatherModule(), CurrentConditionAPI.weatherIcon_UI,
				"\nIssue----> Weather Icon number on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTemperatureOnCurrentWeatherModule(), CurrentConditionAPI.temperature_UI,
				"\nIssue----> Temperature on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getRealFeelValueOnCurrentWeatherModule(), CurrentConditionAPI.realFeelTemp_UI,
				"\nIssue----> Real Feel on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getRealFeelShadeValueOnCurrentWeatherModule(), CurrentConditionAPI.realFeelTempShade_UI,
				"\nIssue----> Real Feel Shade on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getIconPhraseOnCurrentWeatherModule(), CurrentConditionAPI.weatherDescription_UI,
				"\nIssue----> Icon Phrase on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getUVIndexValueOnCurrentWeatherModule(), CurrentConditionAPI.uvIndex_UI,
				"\nIssue----> UV Index on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getWindValueOnCurrentWeatherModule(), CurrentConditionAPI.wind_UI,
				"\nIssue----> Wind Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getWindGustsValueOnCurrentWeatherModule(), CurrentConditionAPI.windGust_UI,
				"\nIssue----> Wind Gusts value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getHumidityValueOnCurrentWeatherModule(), CurrentConditionAPI.humidity_UI,
				"\nIssue----> Humidity Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getDewPointValueOnCurrentWeatherModule(), CurrentConditionAPI.dewPoint_UI,
				"\nIssue----> Dew Point value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getPressureValueOnCurrentWeatherModule(), CurrentConditionAPI.pressure_UI,
				"\nIssue----> Pressure value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getCloudCoverValueOnCurrentWeatherModule(), CurrentConditionAPI.cloudCover_UI,
				"\nIssue----> Cloud Cover value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getVisibilityValueOnCurrentWeatherModule(), CurrentConditionAPI.visibility_UI,
				"\nIssue----> Visibility Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getCeilingValueOnCurrentWeatherModule(), CurrentConditionAPI.ceiling_UI,
				"\nIssue----> Celing Value on Current Weather module not matching with the API data\n");
		
		/*************************************** Temperature History Validations *************************************************/
		
		softAssert.assertEquals(currentConditions.getTemperatureHistoryTitle(), TEMPERATURE_HISTORY,
				"\nIssue----> Temperature History Title not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getDateInTemperatureHistory(), CommonUtilities.getCurrentDate(TEMPERATUREHISTORY_DATE_FORMAT).toUpperCase(),
				"\nIssue----> Date on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTempUnitInTemperatureHistory(), DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Temperature Unit on Temperature History wrong\n");
		
		softAssert.assertEquals(currentConditions.getForecastHeaderTextInTemperatureHistory(), FORECAST,
				"\nIssue----> Forecast Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getAverageHeaderTextInTemperatureHistory(), AVERAGE,
				"\nIssue----> Average Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getRecordsHeaderTextInTemperatureHistory(), RECORDS,
				"\nIssue----> Records Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLastYearHeaderTextInTemperatureHistory(), CommonUtilities.getLastYear(LASTYEAR_FORMAT),
				"\nIssue----> Last Year Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLastYearMaxTempHistory(), TemperatureHistoryAPI.maxTempLastYear_UI,
				"\nIssue----> Maximum Temperature for Last year on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getLastYearMinTempHistory(), TemperatureHistoryAPI.minTempLastYear_UI,
				"\nIssue----> Minimum Temperature for Last year on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getLastYearMaxTempHistory(), currentConditions.getLastYearMinTempHistory(),
				"\nIssue----> Maximum Temperature and Minimum Temperature are same for last year on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getYearForMaxTemp(), TemperatureHistoryAPI.getYearForMaximumRecordTemp(),
				"\nIssue----> Year for Maximum Temperature on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getYearForMinTemp(), TemperatureHistoryAPI.getYearForMinimumRecordTemp(),
				"\nIssue----> Year for Minimum Temperature on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMaxTempInRecords(), TemperatureHistoryAPI.recordMaxTemp_UI,
				"\nIssue----> Maximum Temperature for Records on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMinTempInRecords(), TemperatureHistoryAPI.recordMinTemp_UI,
				"\nIssue----> Minimum Temperature for Records on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getMaxTempInRecords(), currentConditions.getMinTempInRecords(),
				"\nIssue----> Maximum Temperature and Minimum Temperature are same for Records on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getMaxTempInAverage(), TemperatureHistoryAPI.averageMaxTemp_UI,
				"\nIssue----> Maximum Temperature for Average on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMinTempInAverage(), TemperatureHistoryAPI.averageMinTemp_UI,
				"\nIssue----> Minimum Temperature for Average on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getMinTempInAverage(), currentConditions.getMaxTempInAverage(),
				"\nIssue----> Minimum Temperature and Maximum Temperature are same for Average on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getHiTempTitle(), HIGH,
				"\nIssue----> Hi Label Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLoTempTitle(), LOW,
				"\nIssue----> Lo Label on Temperature History not as expected\n");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void MetricDataValidationForCurrentWeather()
	{
		softAssert = new SoftAssert();
		CurrentConditionAPI.getCurrentConditionDataForUI(locationKey, METRIC);
		TemperatureHistoryAPI.getTemperatureHistoryDataForUI(CommonUtilities.getCurrentDate(DATEFORMAT), CommonUtilities.getLastYearDate(DATEFORMAT), METRIC, locationKey);
		
		testStart("*************** Data validations for Current Conditions page for Metric **********************");
		legalFooter.clickIUnderstand();
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.selectCityFromTheList(location);
		
		navigationBar.selectCelsius();
		
		softAssert.assertEquals(currentConditions.getTitleOfCurrentWeathercard(), CURRENT_WEATHER,
				"\nIssue----> Title on Current Weather not as expected\n");
		
		softAssert.assertEquals(currentConditions.getWeatherIconNumberOnCurrentWeatherCard(), CurrentConditionAPI.weatherIcon_UI,
				"\nIssue----> Weather Icon image number not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTemperatureOnCurrentWeatherCard(), CurrentConditionAPI.temperature_UI,
				"\nIssue----> Temperature on Current Weather card not matching with API data\n");
		
		softAssert.assertEquals(currentConditions.getTemperatureUnitOnCurrentWeatherCard(), CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue---->Wrong Temperature Unit on current weather card\n");
		
		softAssert.assertEquals(currentConditions.getRealFeelOnCurrentWeatherCard(), CurrentConditionAPI.realFeelTemp_UI,
				"\nIssue----->RealFeel temperature not matching with the API data");
		
		softAssert.assertEquals(currentConditions.getIconPhraseOnCurrentWeatherCard(), CurrentConditionAPI.weatherDescription_UI,
				"\nIssue----> Icon Phrase on Current Weather not matching with the API data\n");
		
		currentConditions.clickCurrentweathercard();
		
		softAssert.assertEquals(currentConditions.getTitleOfCurrentWeatherModule(), CURRENT_WEATHER+"\n"+DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Title on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTempUnitOfCurrentWeatherModule(), DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Temperature Unit on Current Weather module not as expected\n");
		
		softAssert.assertEquals(currentConditions.getWeatherIconNumberOnCurrentWeatherModule(), CurrentConditionAPI.weatherIcon_UI,
				"\nIssue----> Weather Icon number on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTemperatureOnCurrentWeatherModule(), CurrentConditionAPI.temperature_UI,
				"\nIssue----> Temperature on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getRealFeelValueOnCurrentWeatherModule(), CurrentConditionAPI.realFeelTemp_UI,
				"\nIssue----> Real Feel on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getRealFeelShadeValueOnCurrentWeatherModule(), CurrentConditionAPI.realFeelTempShade_UI,
				"\nIssue----> Real Feel Shade on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getIconPhraseOnCurrentWeatherModule(), CurrentConditionAPI.weatherDescription_UI,
				"\nIssue----> Icon Phrase on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getUVIndexValueOnCurrentWeatherModule(), CurrentConditionAPI.uvIndex_UI,
				"\nIssue----> UV Index on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getWindValueOnCurrentWeatherModule(), CurrentConditionAPI.wind_UI,
				"\nIssue----> Wind Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getWindGustsValueOnCurrentWeatherModule(), CurrentConditionAPI.windGust_UI,
				"\nIssue----> Wind Gusts value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getHumidityValueOnCurrentWeatherModule(), CurrentConditionAPI.humidity_UI,
				"\nIssue----> Humidity Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getDewPointValueOnCurrentWeatherModule(), CurrentConditionAPI.dewPoint_UI,
				"\nIssue----> Dew Point value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getPressureValueOnCurrentWeatherModule(), CurrentConditionAPI.pressure_UI,
				"\nIssue----> Pressure value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getCloudCoverValueOnCurrentWeatherModule(), CurrentConditionAPI.cloudCover_UI,
				"\nIssue----> Cloud Cover value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getVisibilityValueOnCurrentWeatherModule(), CurrentConditionAPI.visibility_UI,
				"\nIssue----> Visibility Value on Current Weather module not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getCeilingValueOnCurrentWeatherModule(), CurrentConditionAPI.ceiling_UI,
				"\nIssue----> Celing Value on Current Weather module not matching with the API data\n");
		
		/*************************************** Temperature History Validations *************************************************/
		softAssert.assertEquals(currentConditions.getTemperatureHistoryTitle(), TEMPERATURE_HISTORY,
				"\nIssue----> Temperature History Title not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getDateInTemperatureHistory(), CommonUtilities.getCurrentDate(TEMPERATUREHISTORY_DATE_FORMAT).toUpperCase(),
				"\nIssue----> Date on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getTempUnitInTemperatureHistory(), DEGREE_SYMBOL+CurrentConditionAPI.temperatureUnit_UI,
				"\nIssue----> Temperature Unit on Temperature History wrong\n");
		
		softAssert.assertEquals(currentConditions.getForecastHeaderTextInTemperatureHistory(), FORECAST,
				"\nIssue----> Forecast Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getAverageHeaderTextInTemperatureHistory(), AVERAGE,
				"\nIssue----> Average Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getRecordsHeaderTextInTemperatureHistory(), RECORDS,
				"\nIssue----> Records Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLastYearHeaderTextInTemperatureHistory(), CommonUtilities.getLastYear(LASTYEAR_FORMAT),
				"\nIssue----> Last Year Header on Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLastYearMaxTempHistory(), TemperatureHistoryAPI.maxTempLastYear_UI,
				"\nIssue----> Maximum Temperature for Last year on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getLastYearMinTempHistory(), TemperatureHistoryAPI.minTempLastYear_UI,
				"\nIssue----> Minimum Temperature for Last year on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getLastYearMaxTempHistory(), currentConditions.getLastYearMinTempHistory(),
				"\nIssue----> Maximum Temperature and Minimum Temperature are same for last year on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getYearForMaxTemp(), TemperatureHistoryAPI.getYearForMaximumRecordTemp(),
				"\nIssue----> Year for Maximum Temperature on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getYearForMinTemp(), TemperatureHistoryAPI.getYearForMinimumRecordTemp(),
				"\nIssue----> Year for Minimum Temperature on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMaxTempInRecords(), TemperatureHistoryAPI.recordMaxTemp_UI,
				"\nIssue----> Maximum Temperature for Records on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMinTempInRecords(), TemperatureHistoryAPI.recordMinTemp_UI,
				"\nIssue----> Minimum Temperature for Records on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getMaxTempInRecords(), currentConditions.getMinTempInRecords(),
				"\nIssue----> Maximum Temperature and Minimum Temperature are same for Records on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getMaxTempInAverage(), TemperatureHistoryAPI.averageMaxTemp_UI,
				"\nIssue----> Maximum Temperature for Average on Temperature History not matching with the API data\n");
		
		softAssert.assertEquals(currentConditions.getMinTempInAverage(), TemperatureHistoryAPI.averageMinTemp_UI,
				"\nIssue----> Minimum Temperature for Average on Temperature History not matching with the API data\n");
		
		softAssert.assertNotEquals(currentConditions.getMinTempInAverage(), currentConditions.getMaxTempInAverage(),
				"\nIssue----> Minimum Temperature and Maximum Temperature are same for Average on Temperature History\n");
		
		softAssert.assertEquals(currentConditions.getHiTempTitle(), HIGH,
				"\nIssue----> Hi Label Temperature History not as expected\n");
		
		softAssert.assertEquals(currentConditions.getLoTempTitle(), LOW,
				"\nIssue----> Lo Label on Temperature History not as expected\n");
		
		softAssert.assertAll();
	}
}
