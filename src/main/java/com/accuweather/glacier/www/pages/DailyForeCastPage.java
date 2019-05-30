package com.accuweather.glacier.www.pages;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.JSONObject;
import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.dailyforecasts.DailyForecasts;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.DailyForeCast1;
import com.accuweather.glacier.api.objects1.DailyForeCasts5;
import com.accuweather.glacier.api.objects1.DailyForecast4;
import com.accuweather.glacier.api.objects1.Day;
import com.accuweather.glacier.api.objects1.Headline2;
import com.accuweather.glacier.api.objects1.Temperature;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.TestReporter;
import com.fasterxml.jackson.core.JsonFactory;

public class DailyForeCastPage extends BasePage{
	/*
	 * private Temperature temperature = new Temperature(); private DailyForeCasts
	 * dailyforecasts = new DailyForeCasts(); private Headline headline = new
	 * Headline(); private Day day = new Day();
	 */
	
	
	/*
     * Day Daily Forecast Area
     */
	private By byDailyForecastDayTemp = By.cssSelector("div.block.day > div > div.column.temps > div.main > span.temp");
	private By byDailyForecastDayRealFeel = By.cssSelector("div.block.day > div > div.column.temps > div.sub > div.realfeel");
	private By byDailyForecastDayPreciptation = By.cssSelector("div.block.day > div > div.column.temps > div.sub > div.precip");
	private By byDailyForecastDayDirection = By.cssSelector("div.block.day > div > div.column.wind > div.detail > div.winds-from > div.direction");
	private By byDailyForecastDaySpeed = By.cssSelector("div.block.day > div > div.column.wind > div.detail > div.winds-from > div.speed");
	private By byDailyForecastDayGust = By.cssSelector("div.block.day > div > div.column.wind > div.detail > div.gust");
	private By byDailyForecastDayUVIndex = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(1)");
	private By byDailyForecastDayThunder = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(2)");
	private By byDailyForecastDayPrecip = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(3)");
	private By byDailyForecastDayRain = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(4)");
	private By byDailyForecastDaySnow = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(5)");
	private By byDailyForecastDayIce = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(6)");
	private By byDailyForecastDayHrsOfPrecip = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(7)");
	private By byDailyForecastDayHrsOfRain = By.cssSelector("div.block.day > div > div.column.detail > div:nth-child(8)");
	
	public void validateDailyForecast (Headline2 headline) {
		 getDriver().page().isDomInteractive(10000);
	     getDriver().findElement(byDailyForecastDayTemp).syncVisible();
	        
		//validate1(byDailyForecastDayTemp, "Day Detail Panel: Temperatur", headline.getTemperature());
		//validate1(byDailyForecastDayHrsOfRain, "Day Detail Panel: Hours Of Rain",headline.getDailyForecasts());
		
		/*
		 * validate(byCurrentRealFeelTemp, "Current Panel: RealFeel Temperature",
		 * round(condition.getRealFeelTemperature().getImperial().getValue(), 0));
		 * validate(byCurrentCondition,
		 * "Current Panel: Conditions",condition.getWeatherText());
		 * //validate(byCurrentWindDirection, "Current Panel: Wind Direction",
		 * "Winds from the " + condition.getWind().getDirection().getLocalized());
		 * validate(byCurrentWindSpeed, "Current Panel: Wind Speed",
		 * round(condition.getWind().getSpeed().getImperial().getValue(), 0));
		 * validate(byCurrentHumidity, "Current Panel: Humidity", "Humidity: " +
		 * round(condition.getRelativeHumidity(), 0) + "%"); validate(byCurrentPressure,
		 * "Current Panel: Pressure", "Pressure: " +
		 * condition.getPressure().getImperial().getValue()); validate(byCurrentUvIndex,
		 * "Current Panel: UV Index", "UV Index: " + condition.getUVIndex());
		 * //validate(byCurrentCloudCover, "Current Panel: Cloud Cover", "Cloud Cover: "
		 * + condition.getCloudCover() + "%"); validate(byCurrentCeiling,
		 * "Current Panel: Ceiling", "Ceiling: " +
		 * round(condition.getCeiling().getImperial().getValue(), 0));
		 * validate(byCurrentDewPoint, "Current Panel: Dew Point", "Dew Point: " +
		 * round(condition.getDewPoint().getImperial().getValue(), 0));
		 * validate(byCurrentVisibility, "Current Panel: Visibility", "Visibility: " +
		 * round(condition.getVisibility().getImperial().getValue(), 0));
		 */
	}
	

	public void validate1(final By by, final String elementName, final Object expectedText) {
        final WebElement element = getDriver().findElement(by);
        System.out.println("Element In Base Page Class....." +element);
        if(elementName.equals("Day Detail Panel: Temperatur")) {
        	 final String Temperature = element.getText().substring(0, 3);
        	 System.out.println("Temperature In Base Page Class....." +Temperature);
        	 final String elementText = Temperature.substring(0, Temperature.length() -1);
        	 System.out.println("elementText In Base Page Class....." +elementText);
		/*final WebElement element = getDriver().findElement(by);
        System.out.println("Element In Base Page Class....." +element);
        if(elementName.equals("Day Detail Panel: Hours Of Rain")) {
        	 final String elementText = element.getText().substring(0, 20);
        	 System.out.println("HoursOfRain In day Section....." +elementText);*/
        	
        	 
        	 //final String elementText = HoursOfRain.substring(0, HoursOfRain.length() -1);
        	 //System.out.println("elementText In Base Page Class....." +elementText);
        	
        	//String expectedTempText = headline.getDailyForecast(day.getHoursOfRain().doubleValue()).toString();
        	 //String expectedTempText = headline.getDailyForecast();
        	 //List<Object> dailyforcast = headline.getDailyForecast("DailyForecasts");
        	 //List<Object> dailyforcast = dailyforecasts.getDailyForecasts("DailyForecasts");
			/*
			 * List<Object> dailyforcast = headline.getDailyForecast(); for(int
			 * i=0;i<dailyforcast.size();i++) { Object row = dailyforcast.get(i);
			 * System.out.println("Element "+i+Arrays.toString(dailyforcast)); }
			 */
			/*
			 * System.out.println("dailyforcast dailyforcast....." +dailyforcast);
			 * expectedText = ((DailyForecast) dailyforcast.get(5)).getDay();
			 * System.out.println("expectedText expectedText....." +expectedText);
			 */
        	 //JSONObject first = ((JSONArray) dailyforcast).getJSONObject(0);
        	 //JSONObject hoursOfRain = first.getJSONObject("HoursOfRain");
        	 //expectedText = hoursOfRain;
        	 /*System.out.println("jArray jArray jArray...." +jArray);
             for(int i=0;i<jArray.length();i++){
                     JSONObject json_obj = jArray.getJSONObject(i);

                     expectedText += json_obj.getString("Day");
                     System.out.println("expectedText expectedText..." +expectedText);
             }

             day.setHoursOfRain(expectedText);*/
			//System.out.println("expectedTempText expectedTempText..." +expectedTempText);
        	 
        	 final boolean found = elementText.contains(expectedText.toString());
             System.out.println("Boolean Found In Base Page Class....." +found);

             TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
             if (!found) {
                 element.highlight();
                 // TestReporter.logScreenshot(element, elementName);
             }
        }
}
}