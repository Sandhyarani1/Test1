package com.accuweather.glacier.www.pages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.dailyforecasts.DailyForecasts;
import com.accuweather.glacier.api.objects1.Condition;
import com.accuweather.glacier.api.objects1.DailyForeCast1;
import com.accuweather.glacier.api.objects1.DailyForeCasts5;
import com.accuweather.glacier.api.objects1.DailyForecast4;
import com.accuweather.glacier.api.objects1.Day;
import com.accuweather.glacier.api.objects1.Headline2;
import com.accuweather.glacier.api.objects1.Temperature;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.TestReporter;
import com.chameleon.utils.date.SimpleDate;
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
	private By byDailyTab = By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(5)");
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
	private By byCurrentDay = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.date > p.dow");
	private By byCurrentDate = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.date > p.sub");
	private By byWeatherIcon = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > img.weather-icon.icon");
	private By byHighTemp = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.temps > span.high");
	private By byLowTemp = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.temps > span.low");
	private By byWeatherDescription = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > span.phrase");
	private By byPrecipitationText = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.info.precip > p:nth-child(1)");
	private By byPrecipitationValue = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.info.precip > p:nth-child(2)");
	private By byCurentDayCard = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div:nth-child(1) > a.forecast-list-card.forecast-card.today");
	private By byNextCTATab = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div.navigation > a > span.text");
	private By byRightArrowIcon = By.cssSelector("body > div.template-root.daily-forecast > div.two-column-page-content > div.page-column-1 > div.navigation > a > div.arrow-wrap.is-next > svg.arrow.icon-chevron.icon-chevron-right");
	
	/*public void validateDailyForecast (Headline2 headline) {
		 getDriver().page().isDomInteractive(10000);
	     getDriver().findElement(byDailyForecastDayTemp).syncVisible();
		//validate1(byDailyForecastDayTemp, "Day Detail Panel: Temperatur", headline.getTemperature());
		//validate1(byDailyForecastDayHrsOfRain, "Day Detail Panel: Hours Of Rain",headline.getDailyForecasts());
		 validate(byCurrentRealFeelTemp, "Current Panel: RealFeel Temperature",
		 round(condition.getRealFeelTemperature().getImperial().getValue(), 0));
		 validate(byCurrentCondition,
		 "Current Panel: Conditions",condition.getWeatherText());
		 //validate(byCurrentWindDirection, "Current Panel: Wind Direction",
		 "Winds from the " + condition.getWind().getDirection().getLocalized());
		 validate(byCurrentWindSpeed, "Current Panel: Wind Speed",
		 round(condition.getWind().getSpeed().getImperial().getValue(), 0));
		 validate(byCurrentHumidity, "Current Panel: Humidity", "Humidity: " +
		 round(condition.getRelativeHumidity(), 0) + "%"); validate(byCurrentPressure,
		 "Current Panel: Pressure", "Pressure: " +
		 condition.getPressure().getImperial().getValue()); validate(byCurrentUvIndex,
		 "Current Panel: UV Index", "UV Index: " + condition.getUVIndex());
		 //validate(byCurrentCloudCover, "Current Panel: Cloud Cover", "Cloud Cover: "
		 + condition.getCloudCover() + "%"); validate(byCurrentCeiling,
		 "Current Panel: Ceiling", "Ceiling: " +
		 round(condition.getCeiling().getImperial().getValue(), 0));
		 validate(byCurrentDewPoint, "Current Panel: Dew Point", "Dew Point: " +
		 round(condition.getDewPoint().getImperial().getValue(), 0));
		 validate(byCurrentVisibility, "Current Panel: Visibility", "Visibility: " +
		 round(condition.getVisibility().getImperial().getValue(), 0));
	}*/
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

	/**
	 * @author HFARAZ
	 * Method to click Daily Tab
	 * */
	public void clickDailyTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement dailyTab = getDriver().findElement(byDailyTab);
		dailyTab.syncVisible(15);
		dailyTab.click();
	}

	/**
	 * @author HFARAZ
	 * Method to get the top border color of the daily tab 
	 * @return - String: hex code of color value
	 * */
	public String getColor_Of_DailyTab()
	{
		clickDailyTab();
		String color = getDriver().findElement(byDailyTab).getCssValue("border-top-color");
		return Color.fromString(color).asHex();
	}

	/**
	 * @author HFARAZ
	 * Method to get the text of Daily tab
	 * @return: String value of the text on Daily tab
	 * */
	public String getDailyTabText()
	{
		WebPageLoaded.isDomInteractive();
		WebElement dailyTabText = getDriver().findElement(byDailyTab);
		dailyTabText.syncVisible(15);
		return dailyTabText.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to return the current page URL
	 * @return: String - value of current URL
	 * */
	public String getDailyTabURL()
	{
		clickDailyTab();
		String currentPageURL = getDriver().getCurrentUrl();
		return currentPageURL;
	}

	/**
	 * @author HFARAZ
	 * Method to return the current page title
	 * @return: String - value of current title
	 * */
	public String getTitleOfDailyTab()
	{
		clickDailyTab();
		String currentPageTitle= getDriver().getTitle();
		return currentPageTitle;
	}

	/**
	 * @author HFARAZ
	 * Method to call API and return response
	 * */
	public String getAPIResponse(String url)
	{
		String apiResponse="";
		try
		{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) 
			{
				response.append(inputLine);
			}

			in.close();
	     //print in String
	     System.out.println(response.toString());
	     apiResponse = response.toString();
		}

		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch(IOException ioE)
		{
			ioE.printStackTrace();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return apiResponse;
	}

	public JSONObject createJSONObject(String apiResponse)
	{
		JSONObject jsonObject = new JSONObject(apiResponse);
		return jsonObject;
	}

	/**
	 * @author HFARAZ
	 * Method to get the current day from daily tab
	 * @return : String - returns the day from the first tab in Daily forecast page
	 * */
	public String readCurrentDay()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentDay = getDriver().findElement(byCurrentDay);
		currentDay.syncVisible(15);
		return currentDay.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to get the current date from first tab in Daily forecast page
	 * @return : String - returns the date from the first tab in Daily forecast page
	 * */
	public String readCurrentDate()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentDate = getDriver().findElement(byCurrentDate);
		currentDate.syncVisible(15);
		return currentDate.getText();
	}

	/** Method to verify if the weather icon is displayed */
	public Boolean isWeatherIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement weatherIcon = getDriver().findElement(byWeatherIcon);
		weatherIcon.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return weatherIcon.isDisplayed();
	}

	/**
	 * @author HFARAZ
	 * Method to read the maximum temperature from the first tab in Daily forecast page
	 * @return : String - returns the maximum temperature present on the first tab on Daily forecast page
	 * */
	public String readMaxTemperature()
	{
		WebPageLoaded.isDomInteractive();
		WebElement highTemp = getDriver().findElement(byHighTemp);
		highTemp.syncVisible(30);
		return highTemp.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to read the minimum temperature from the first tab in Daily forecast page
	 * @return : String - returns the minimum temperature present on the first tab on Daily forecast page
	 * */
	public String readMinTemperature()
	{
		WebPageLoaded.isDomInteractive();
		WebElement lowTemp = getDriver().findElement(byLowTemp);
		lowTemp.syncVisible(30);
		return lowTemp.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to read the weather description from the first tab in Daily forecast page
	 * @return : String - returns the weather description present on the first tab on Daily forecast page
	 * */
	public String readWeatherDescription()
	{
		WebPageLoaded.isDomInteractive();
		WebElement weatherDescription = getDriver().findElement(byWeatherDescription);
		weatherDescription.syncVisible(30);
		return weatherDescription.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to read the Precip text from the first tab in Daily forecast page
	 * @return : String - returns the Precip text present on the first tab on Daily forecast page
	 * */
	public String readPrecipText()
	{
		WebPageLoaded.isDomInteractive();
		WebElement precipitationText = getDriver().findElement(byPrecipitationText);
		precipitationText.syncVisible(30);
		return precipitationText.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to read the Precip value from the first tab in Daily forecast page
	 * @return : String - returns the value text present on the first tab on Daily forecast page
	 * */
	public String readPrecipValue()
	{
		WebPageLoaded.isDomInteractive();
		WebElement precipitationValue = getDriver().findElement(byPrecipitationValue);
		precipitationValue.syncVisible(30);
		return precipitationValue.getText();
	}

	/**
	 * @author HFARAZ
	 * Method to get the color code
	 * @return color code for the current day on the Daily forecast page
	 * */
	public String getColor_Of_ActiveTab()
	{
		WebPageLoaded.isDomInteractive();
		String color = getDriver().findElement(byCurentDayCard).getCssValue("border-left");
		return Color.fromString(color).asHex();
	}

	/**
	 * @author HFARAZ
	 * Method to get the color code
	 * @return color code for the right Arrow Icon present on the Next CTA
	 * */
	public String getColor_Of_RightArrowIconOnNextCTA()
	{
		WebPageLoaded.isDomInteractive();
		String color = getDriver().findElement(byNextCTATab).getCssValue("fill");
		return Color.fromString(color).asHex();
	}

	public static void test() 
	{
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(cal.getTime()));
        for (int i = 1; i < maxDay; i++) 
        {
        cal.set(Calendar.DAY_OF_MONTH, i + 1);
        System.out.println(df.format(cal.getTime()));
        }

	}

	/**
	 * Method to check if the Next CTA tab is present
	 * @author HFARAZ
	 * @return: Boolean - true if the tab is present, else false
	 * */
	public Boolean isNextCTATabPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nextCTATab = getDriver().findElement(byNextCTATab);
		nextCTATab.syncVisible(15);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return nextCTATab.isDisplayed();
	}

	/**
	 * Method to check if the Right Arrow is present
	 * @author HFARAZ
	 * @return: Boolean - true if the right arrow is present, else false
	 * */
	public Boolean isRightArrowPresentOnNextCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rightArrowIcon = getDriver().findElement(byRightArrowIcon);
		rightArrowIcon.syncVisible(15);
		return rightArrowIcon.isDisplayed();																																																																																																											
	}

	/**
	 * @author HFARAZ
	 * Method to click Next CTA
	 * */
	public void clickNextCTA() 
	{
		WebPageLoaded.isDomInteractive();
		WebElement nextCTATab = getDriver().findElement(byNextCTATab);
		nextCTATab.syncVisible(15);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		nextCTATab.jsClick();
	}

}
