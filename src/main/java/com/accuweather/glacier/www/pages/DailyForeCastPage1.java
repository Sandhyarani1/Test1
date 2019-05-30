package com.accuweather.glacier.www.pages;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.objects1.DailyForeCast1;
import com.accuweather.glacier.api.objects1.DailyForeCasts5;
import com.accuweather.glacier.api.objects1.DailyForecast4;
import com.accuweather.glacier.api.objects1.Headline2;
import com.accuweather.glacier.api.objects2.Example;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.TestReporter;

public class DailyForeCastPage1 extends BasePage {

	
	
	
	private By byDailyForecastDayTemp = By.cssSelector("div.block.day > div > div.column.temps > div.main > span.temp");	
	public void validateDailyForeCastPage1 (Example example) {
		 getDriver().page().isDomInteractive(10000);
	     getDriver().findElement(byDailyForecastDayTemp).syncVisible();
	     String Temperature = getDriver().findElement(byDailyForecastDayTemp).getText();
	     System.out.println("Temperature Temperature ... "+Temperature);
	     validate1(byDailyForecastDayTemp, "Day Detail Panel: Temperature",round(example.getDailyForecasts().get(0).getTemperature().getMaximum().getValue(),0));
		//validate1(byDailyForecastDayTemp, "Day Detail Panel: Temperatur",round(DailyForecast.getTemperature().getMaximum().getImperial().getValue(),0));
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
	

	public void validate1(final By by, final String elementName,final Object expectedText) {
        final WebElement element = getDriver().findElement(by);
        System.out.println("Element In Base Page Class....." +element);
        if(elementName.equals("Day Detail Panel: Temperature")) {
        	 final String Temperature = element.getText().substring(0, 3);
        	 System.out.println("Temperature In Base Page Class....." +Temperature);
        	 final String elementText = Temperature.substring(0, Temperature.length() -1);
        	 System.out.println("elementText In Base Page Class....." +elementText);
        	 //final Object expectedText = DailyForecast.getTemperature().getMaximum().getImperial().getValue();
        	 //System.out.println("expectedText expectedText....." +expectedText);
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
                  TestReporter.logScreenshot(element, elementName);
             }
			/*
			 * else if (elementName.equals("Current Panel: RealFeel Temperature")) {
			 * 
			 * final String RealFeelTemp = element.getText().substring(10, 13);
			 * System.out.println("RealFeelTemp In Base Page Class....." +RealFeelTemp);
			 * String elementText = RealFeelTemp.substring(0, RealFeelTemp.length() -1);
			 * System.out.println("elementText In Base Page Class....." +elementText); final
			 * boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Current Panel: Conditions")) { final String elementText
			 * = element.getText();
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else
			 * if(elementName.equals("Current Panel: Wind Direction")) { final String
			 * elementText = "Winds from the "+ element.getText();
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } }else if
			 * (elementName.equals("Current Panel: Humidity")) { final String elementText =
			 * element.getText().substring(0, 13);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else
			 * if(elementName.equals("Current Panel: Pressure")) { final String Pressure =
			 * element.getText().substring(0, 15);
			 * System.out.println("Pressure Text In Base Page Class....." +Pressure); final
			 * String elementText = round(Pressure,2);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } }else
			 * if(elementName.equals("Current Panel: UV Index")) { final String elementText
			 * = element.getText().substring(0, 11);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); }
			 * 
			 * }else if(elementName.equals("Current Panel: Cloud Cover")) { final String
			 * elementText = element.getText().substring(0, 16);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Current Panel: Ceiling")) { final String elementText =
			 * element.getText().substring(0, 14);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } }else if
			 * (elementName.equals("Current Panel: Dew Point")) { final String elementText =
			 * element.getText().substring(0, 13);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Current Panel: Visibility")) { final String elementText
			 * = element.getText().substring(0, 14);
			 * System.out.println("Element Text In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Temperature Summmary Panel: Now")) {
			 * 
			 * final String TemperatureNow = element.getText().substring(0, 3);
			 * System.out.println("TemperatureNow In Base Page Class....." +TemperatureNow);
			 * final String elementText = TemperatureNow.substring(0,
			 * TemperatureNow.length() -1);
			 * System.out.println("elementText In Base Page Class....." +elementText); final
			 * boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); }
			 * 
			 * } else if (elementName.equals("Temperature Summmary Panel: Yesterday")) {
			 * 
			 * final String TempYesterday = element.getText().substring(0, 3);
			 * System.out.println("TempYesterday In Base Page Class....." +TempYesterday);
			 * final String elementText = TempYesterday.substring(0, TempYesterday.length()
			 * -1); System.out.println("elementText In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Temperature Summmary Panel: RealFeel")) {
			 * 
			 * final String TempRealFeel = element.getText().substring(0, 3);
			 * System.out.println("TempRealFeel In Base Page Class....." +TempRealFeel);
			 * final String elementText = TempRealFeel.substring(0, TempRealFeel.length()
			 * -1); System.out.println("elementText In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Temperature Summmary Panel: RealFeel Shade")) {
			 * 
			 * final String TempRealFeelShade = element.getText().substring(0, 3);
			 * System.out.println("TempRealFeelShade In Base Page Class....."
			 * +TempRealFeelShade); final String elementText =
			 * TempRealFeelShade.substring(0, TempRealFeelShade.length() -1);
			 * System.out.println("elementText In Base Page Class....." +elementText); final
			 * boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Temperature Summmary Panel: Wind Chill")) {
			 * 
			 * final String TempWindChill = element.getText().substring(0, 3);
			 * System.out.println("TempWindChill In Base Page Class....." +TempWindChill);
			 * final String elementText = TempWindChill.substring(0, TempWindChill.length()
			 * -1); System.out.println("elementText In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } else if
			 * (elementName.equals("Temperature Summmary Panel: Dew Point")) {
			 * 
			 * final String TempDewPoint = element.getText().substring(0, 3);
			 * System.out.println("TempDewPoint In Base Page Class....." +TempDewPoint);
			 * final String elementText = TempDewPoint.substring(0, TempDewPoint.length()
			 * -1); System.out.println("elementText In Base Page Class....." +elementText);
			 * final boolean found = elementText.contains(expectedText.toString());
			 * System.out.println("Boolean Found In Base Page Class....." +found);
			 * 
			 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
			 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
			 * " ]"); if (!found) { element.highlight(); //
			 * TestReporter.logScreenshot(element, elementName); } } }
			 */
        }
}


	
}
