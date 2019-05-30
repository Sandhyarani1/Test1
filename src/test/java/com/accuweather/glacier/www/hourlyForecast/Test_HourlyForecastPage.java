package com.accuweather.glacier.www.hourlyForecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.api.AccuweatherRest;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.date.SimpleDate;

public class Test_HourlyForecastPage extends AccuWeatherBaseTest
{
	String zipCode = "53558";
	String expectedLandingPageTitle = "Mc Farland Weather - AccuWeather Forecast for WI 53558";
	String expectedHourlyForecastTitle = "Mc Farland Hourly Weather - AccuWeather Forecast for WI 53558";

	private String expectedHourlyPage_URL = "https://development.accuweather.com/en/us/mc-farland/53558/hourly-weather-forecast/23238_pc";
	private static final String ORANGE_COLOR = "#f05514";
	private static final String BLACK_COLOR = "#1f1f1f";
	private static final String GREY_COLOR = "#878787";
	private static final String HOURLY_TAB = "HOURLY";
	private static final String QA = "QA";

	private LandingPage landingPage = new LandingPage();
	private HourlyForecastPage hourlyPage = new HourlyForecastPage();
	private SimpleDate getDateTime = new SimpleDate();

	@Test(priority = 1, enabled = false)
	public void TC1_navigation_To_Hourly_Tab()
	{
		testStart("Validate the navigation to Hourly tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		waitUntilWindowExistsWithTitle(expectedHourlyForecastTitle);

		try
		{
			Assert.assertEquals(getDriver().getTitle(), expectedHourlyForecastTitle);
		}
		catch (AssertionError ae)
		{
			System.out.println(ae.getMessage());
			Assert.fail("Hourly forecast title is not matching");
		}

	}

	@Test(priority = 2, enabled = false)
	public void TC1_validate_AccuweatherLogo_Presence_On_HourlyPage()
	{
		testStart("Validate if Accuweather logo is present on Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isAccuWeatherLogoDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 3, enabled = false)
	public void TC1_validation_Of_HourlyPage_URL()
	{
		testStart("Validate the URL for Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedHourlyPage_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 4, enabled = false)
	public void TC1_validation_Of_hourlyTab_Color()
	{
		testStart("Validate the URL for Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.getColor_Of_ActiveTab(), ORANGE_COLOR);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 5, enabled = false)
	public void TC1_validationOf_HourlyTab_Text()
	{
		testStart("Validate whether the Hourly tab has the name 'Hourly' ");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.getHourlyTabText(), HOURLY_TAB);
		}
		catch (AssertionError ae)
		{
			System.out.println(ae.getMessage());
			Assert.fail("Hourly forecast title is not matching");
		}

	}

	@Test(priority = 6, enabled = false)
	public void TC2_validation_If_CurrentHour_Tab_Expanded_ByDefault_On_Hourly_PageLoad()
	{
		testStart("Validate if current hour info tab is expanded automatically when the hourly page loads");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isCurrentHourTabExpanded_WhenFirstPageLoaded());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 7, enabled = false)
	public void TC2_is_Time_Displayed_Correctly()
	{
		testStart("Validation if the time displayed is correct");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		try
		{
			if (getDateTime.getHour() > 12)
			{
				Assert.assertEquals(hourlyPage.getTime(), getDateTime.getHour() - 12 + " PM");
			}
			else
			{
				Assert.assertEquals(hourlyPage.getTime(), getDateTime.getHour() + " AM");
			}
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 8, enabled = false)

	public void TC2_validation_UpArrow_Icon_Is_Displayed()
	{
		testStart("Validation if up arrow icon is displayed on the first page of Hourly tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		try
		{
			Assert.assertTrue(hourlyPage.isUpArrowIconDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 9, enabled = false)
	public void TC3_validation_If_Expanded_ForecastList_Collapses_When_Clicked_On_Current_Hour_Tab()

	{
		testStart(
				"Validate if current hour info tab collapses and a downward arrow comes up when clicked on current hour tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateCurrentHour_InfoTab_Collapse_When_Clicked_On_CurrentHourTab();
			Assert.assertFalse(hourlyPage.getCurrentHourInfoTabState());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("The hour info tab is still displayed");
		}

	}

	@Test(priority = 10, enabled = false)
	public void TC3_validation_If_DownwardArrowIcon_Is_Displayed_When_ExpandedHourTab_Collapses()

	{
		testStart("Validate if downward arrow icon is displayed when current hour tab collapses");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.clickCurrentHourTab();
			Assert.assertFalse(hourlyPage.isDownArrowIconDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Down arrow icon not found on the tab");
		}

	}

	@Test(priority = 10, enabled = false)
	public void TC4_isDate_Correct()
	{
		testStart("Validation for date format");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.getDate(), SimpleDate.getCurrentDate("M/d"));
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 11, enabled = false)
	public void TC4_isTemperature_Field_Displayed()
	{
		testStart("Validation if the temperature field is displayed and is not empty");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertNotNull(hourlyPage.getTemperature());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 12, enabled = false)
	public void TC4_isWeather_Condition_Displayed_And_IsNotEmpty()
	{
		testStart("Validation if the weather condition is displayed and is not empty");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertNotNull(hourlyPage.getWeather());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 13, enabled = false)
	public void TC4_is_Precipitation_Field_Displayed_And_NotEmpty()
	{
		testStart("Validation if the precipitation is displayed and is not empty");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertNotNull(hourlyPage.getPrecipitation());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 14, enabled = false)
	public void TC4_is_WeatherIcon_Displayed()
	{
		testStart("Validation if the weather icon is displayed");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isWeatherIconDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 15, enabled = false)
	public void TC5_validateIf_CurrentHourInfoTab_Expands_When_Clicked_On_First_Hour_Tab()
	{
		testStart(
				"Validate if current hour info tab expands and a upward arrow comes up when clicked on current hour tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateCurrentHour_InfoTab_Expands_When_Clicked_On_CurrentHourTab();
			Assert.assertTrue(hourlyPage.getCurrentHourInfoTabState());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 16, enabled = false)
	public void TC6_isCTACorrect()
	{
		testStart("Validation if the CTA on the first page is correct");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.getCTA(), getDateTime.getTomorrowsDay());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 17, enabled = false)
	public void TC6_isRightArrowIconDisplayedOnCTA()
	{
		testStart("Validation if the right arrow icon is displayed on the CTA");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isRightArrowDisplayedOnCTA());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 18, enabled = false)
	public void TC7_verify_ClickOnCTATab()
	{
		testStart("Validation if clicking on CTA tab is navigating to the next correct Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(10000);

		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(getDriver().getTitle(), expectedHourlyForecastTitle);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 19, enabled = false)
	public void TC7_validateCurrentDay_OnNextHourlyPage()
	{
		testStart("Validation if next hourly page is displaying the current day at the left CTA tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.readPreviousDay(), getDateTime.getCurrentDay());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 20, enabled = false)
	public void TC7_validateNextDayOnNextHourlyPage()
	{
		testStart("Validation if next hourly page is displaying the next day at the right CTA tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(hourlyPage.readNextDay(), hourlyPage.getNextDay(2));
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 21, enabled = false)
	public void TC7_validateLeftArrowIconIsDisplayed()
	{
		testStart("Validation if left arrow icon < is displaying on the next day at the left CTA tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isLeftArrowIconDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 22, enabled = false)
	public void TC7_validateRightArrowIconIsDisplayed()
	{
		testStart("Validation if right arrow icon > is displayed on the next day at the right CTA tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isRightArrowDisplayedOnCTA());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 23, enabled = false)
	public void TC7_validateAll24HourTabsPresentOnNextHourlyPage()
	{
		testStart("Validation if all 24 hour tabs are present on next hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertTrue(hourlyPage.isAllHourTabsPresent());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 24, enabled = false)
	public void TC8_validateClickingOnCurrentDay()
	{
		testStart("Validation if current day is clicked it should navigate to the first page of Hourly tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickCTATab();
		WebPageLoaded.isDomInteractive(1000);
		hourlyPage.clickPreviousDay();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			Assert.assertEquals(getDriver().getTitle(), expectedHourlyForecastTitle);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 25, enabled = false)
	public void TC9_validate_DayParam_In_URL_For_NextDay()
	{
		testStart("Validate the day parameter in URL for Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateDayParamInURLForNextDay();
			Assert.assertTrue(hourlyPage.getHourlyTabURLState());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 26, enabled = false)
	public void TC10_validate_DayParam_In_URL_For_PreviousDay()
	{
		testStart("Validate the day parameter in URL for Hourly page when clicked on Previous day tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateDayParamInURLForPreviousDay();
			Assert.assertTrue(hourlyPage.getHourlyTabURLState());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 27, enabled = true)
	public void TC11_getStationCode_And_GTMOffset() throws ParseException, IOException
	{

		/*final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).searchByLocationKey("23238_pc", true);
		System.out.println(qaResponse.getResponse());
		System.out.println(qaResponse.getStatusCode());
	     
	     //JSONObject myResponse = new JSONObject(response.toString());
	      * 
	      * 
	      * 
*/	
		 String url = "http://accuweather-api-glacier-northcentral-us.cloudapp.net/locations/v1/348181?apikey=5251445912b143d8b4bee5a741762dd1&language=en-us&details=True";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     //Read JSON response and print
	     JSONObject myResponse = new JSONObject(response.toString());
	     JSONObject region = myResponse.getJSONObject("Region");
	     String ID = region.getString("ID");
	     System.out.println("ID: "+ID);
	     System.out.println(region.length());
	     
	     JSONObject geoPosition = myResponse.getJSONObject("GeoPosition");
	     System.out.println("Value: "+geoPosition.getJSONObject("Elevation").getJSONObject("Metric").getDouble("Value"));
	     
	     //JSONArray getArray = 
	     System.out.println("result after Reading JSON Response "+myResponse);
	     System.out.println("Version- "+myResponse.getInt("Version"));
	     System.out.println("Key- "+myResponse.getString("Key"));
	     System.out.println("Localized Name" +myResponse.getString("LocalizedName"));
	     //System.out.println("Localized Name" +myResponse.getString("GmtOffset"));
	     /*System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
	     System.out.println("countryCode- "+myResponse.getString("countryCode"));
	     System.out.println("countryName- "+myResponse.getString("countryName"));
	     System.out.println("regionName- "+myResponse.getString("regionName"));
	     System.out.println("cityName- "+myResponse.getString("cityName"));
	     System.out.println("zipCode- "+myResponse.getString("zipCode"));
	     System.out.println("latitude- "+myResponse.getString("latitude"));
	     System.out.println("longitude- "+myResponse.getString("longitude"));
	     System.out.println("timeZone- "+myResponse.getString("timeZone"));*/  
	   }	
	
	
	

	@Test(priority = 28, enabled = false)
	public void TC12_validationAfterClickingOnWeatherIcon()
	{
		testStart(
				"Validation whether the user is navigated to 3 day forecast page when clicked on Weather icon at the top on Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickWeatherIconAtTheTop();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		Assert.assertEquals(getDriver().getTitle(), expectedLandingPageTitle);
	}

	@Test(priority = 29, enabled = false)
	public void TC12_validationAfterClickingOnTemperatureIcon() throws InterruptedException
	{
		testStart(
				"Validation whether the user is navigated to 3 day forecast page when clicked on Temperature icon at the top on Hourly page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		Thread.sleep(5000);
		hourlyPage.clickTemperatureIconAtTheTop();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		Assert.assertEquals(getDriver().getTitle(), expectedLandingPageTitle);
	}

	@Test(priority = 30, enabled = false)
	public void TC13_validate_PreviousDays_On_SubsequentPages() throws InterruptedException
	{
		testStart("Validation whether the previous days are coming correctly on subsequent pages");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validatePreviousDays();
			Assert.assertTrue(hourlyPage.getPreviousDayTextValidation());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 31, enabled = false)
	public void TC14_validate_NextDays_On_SubsequentPages() throws InterruptedException
	{
		testStart("Validation whether the next days are coming correctly on subsequent pages");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateNextDays();
			Assert.assertTrue(hourlyPage.getNextDayTextValidation());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 32, enabled = false)
	public void TC15_validate_PresenceOf_RealFeel() throws InterruptedException
	{
		testStart("Validation whether RealFeel value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isRealFeelDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 33, enabled = false)
	public void TC15_validate_PresenceOf_Wind() throws InterruptedException
	{
		testStart("Validation whether RealFeel value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isWindDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 34, enabled = false)
	public void TC15_validate_PresenceOf_Gusts() throws InterruptedException
	{
		testStart("Validation whether Gusts value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isGustsDisplayed();
			Assert.assertTrue(hourlyPage.isRealFeelDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 35, enabled = false)
	public void TC15_validate_PresenceOf_Humidity() throws InterruptedException
	{
		testStart("Validation whether Humidity value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isHumidityDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 36, enabled = false)
	public void TC15_validate_PresenceOf_DewPoint() throws InterruptedException
	{
		testStart("Validation whether DewPoint value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isDewPointDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 37, enabled = false)
	public void TC15_validate_PresenceOf_MaxUVIndex() throws InterruptedException
	{
		testStart("Validation whether MaxUV Index value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isMaxUVIndexDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 38, enabled = false)
	public void TC15_validate_PresenceOf_CloudCover() throws InterruptedException
	{
		testStart("Validation whether Cloud Cover value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isCloudCOverDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 39, enabled = false)
	public void TC15_validate_PresenceOf_Rain() throws InterruptedException
	{
		testStart("Validation whether Rain value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isRainDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 40, enabled = false)
	public void TC15_validate_PresenceOf_Snow() throws InterruptedException
	{
		testStart("Validation whether Snow value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isSnowDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 41, enabled = false)
	public void TC15_validate_PresenceOf_Ice() throws InterruptedException
	{
		testStart("Validation whether Ice value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isIceDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 42, enabled = false)
	public void TC15_validate_PresenceOf_Visibility() throws InterruptedException
	{
		testStart("Validation whether Visibility value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isVisibilityDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 43, enabled = false)
	public void TC15_validate_PresenceOf_Ceiling() throws InterruptedException
	{
		testStart("Validation whether Ceiling value is present");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.isRealFeelDisplayed();
			Assert.assertTrue(hourlyPage.isCeilingDisplayed());
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	}

	@Test(priority = 44, enabled = false)
	public void TC16_validateTimeOnAllTabsOfFirstPage()
	{
		testStart("Validation whether time is correct on all the hour tabs of Hour Page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateTimeForAllHourTabs();
			Assert.assertTrue(hourlyPage.getTimeValidation());
		}
		catch (AssertionError ae)
		{

			Assert.fail();
		}

	}

	@Test(priority = 45, enabled = false)
	public void TC16_validateDateOnAllTabsOfFirstPage()
	{
		testStart("Validation whether Date is correct on all the hour tabs of Hourly Page");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);

		hourlyPage.clickOnHourlyTab();
		WebPageLoaded.isDomInteractive(1000);

		try
		{
			hourlyPage.validateDateForAllHourTabs();
			Assert.assertTrue(hourlyPage.getDateValidation());
		}
		catch (AssertionError ae)
		{

			Assert.fail();
		}

	}
	
	public static void main(String[] args) {
	     try {
	         call_me();
	        } catch (Exception e) {
	         e.printStackTrace();
	       }
	     }
		   
	public static void call_me() throws Exception {
	     String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     //Read JSON response and print
	     JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("statusCode- "+myResponse.getString("statusCode"));
	     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
	     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
	     System.out.println("countryCode- "+myResponse.getString("countryCode"));
	     System.out.println("countryName- "+myResponse.getString("countryName"));
	     System.out.println("regionName- "+myResponse.getString("regionName"));
	     System.out.println("cityName- "+myResponse.getString("cityName"));
	     System.out.println("zipCode- "+myResponse.getString("zipCode"));
	     System.out.println("latitude- "+myResponse.getString("latitude"));
	     System.out.println("longitude- "+myResponse.getString("longitude"));
	     System.out.println("timeZone- "+myResponse.getString("timeZone"));  
	   }
	

}
