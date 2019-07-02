package com.accuweather.glacier.www.dailyForecast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.date.SimpleDate;
import com.google.gson.JsonObject;

public class Test_DailyForecast extends AccuWeatherBaseTest 
{
	private final static String ZIPCODE = "53558";
	private final static String EXPECTED_LANDING_PAGE_TITLE = "Mc Farland Weather - AccuWeather Forecast for WI 53558";
	private final static String EXPECTED_DAILY_TAB_TITLE = "Weather in Mc Farland - AccuWeather Forecast for WI 53558";
	private final static String EXPECTED_DAILY_TAB_URL = "https://development.accuweather.com/en/us/mc-farland/53558/daily-weather-forecast/23238_pc";
	private final static String ACTIVE_TAB_COLOR = "#f05514";
	private final static String DAILY_TAB = "DAILY";
	private final static String LOCATION_KEY = "23238_pc";
	private final static String API_KEY = "5251445912b143d8b4bee5a741762dd1";
	private final static String URL = "http://ncus-gadc-api-production.trafficmanager.net/forecasts/v1/daily/"+LOCATION_KEY+".json?apikey="+API_KEY+"&language=en-us&details=True&metric=False&dayCount=21&startDate="+SimpleDate.getCurrentDate("YYYY-MM-dd")+"T00:00:00Z";
	private LandingPage landingPage = new LandingPage();
	private DailyForeCastPage dailyForecast = new DailyForeCastPage();
	private SimpleDate currentDate = new SimpleDate();
	static
	{
	}

	@Test(priority=1)
	public void TC1_verifyDailyText()
	{
		testStart("Validate the text on Daily Tab");
		landingPage.enterZipcodeInSearchField(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTED_LANDING_PAGE_TITLE);
		WebPageLoaded.isDomInteractive(1000);
		Assert.assertEquals(dailyForecast.getDailyTabText(), DAILY_TAB);
	}
	@Test(priority=2)
	public void TC1_verifyDailyTabURL()
	{
		testStart("Validate the URL for Daily tab");
		landingPage.enterZipcodeInSearchField(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTED_LANDING_PAGE_TITLE);
		WebPageLoaded.isDomInteractive(1000);
		Assert.assertEquals(dailyForecast.getDailyTabURL(), EXPECTED_DAILY_TAB_URL);
	}
	@Test(priority=3)
	public void TC1_verifyDailyTabTitle()
	{
		testStart("Validate the title of Daily tab");
		landingPage.enterZipcodeInSearchField(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTED_LANDING_PAGE_TITLE);
		WebPageLoaded.isDomInteractive(1000);
		Assert.assertEquals(dailyForecast.getTitleOfDailyTab(), EXPECTED_DAILY_TAB_TITLE);
	}
	@Test(priority=4)
	public void TC1_verify_HighlightedColor_On_DailyTab()
	{
		testStart("Validate whether the top border color of Daily tab is Orange");
		landingPage.enterZipcodeInSearchField(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(EXPECTED_LANDING_PAGE_TITLE);
		WebPageLoaded.isDomInteractive(1000);
		Assert.assertEquals(dailyForecast.getColor_Of_DailyTab(), ACTIVE_TAB_COLOR);
	}
	
	@Test(priority=5)
	public void TC2_getResponse()
	{ 
		JSONObject jsonObject = dailyForecast.createJSONObject(dailyForecast.getAPIResponse(URL));
		System.out.println("Total Keys: "+jsonObject.length());
		System.out.println("Key 1:"+jsonObject.getJSONObject("Headline").getInt("Severity"));
		JSONObject headlines = jsonObject.getJSONObject("Headline");
		System.out.println(headlines.length());
		System.out.println("Printing JSON Array");
		JSONArray dailyForecasts = jsonObject.getJSONArray("DailyForecasts");
		System.out.println(dailyForecasts.length());
		for(int i=0;i<dailyForecasts.length();i++)
			System.out.println(dailyForecasts.get(i));
		System.out.println("First JSON Object "+dailyForecasts.getJSONObject(0).getJSONObject("Minimum").getString("Unit"));
	}
}