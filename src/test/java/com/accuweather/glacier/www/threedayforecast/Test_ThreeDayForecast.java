package com.accuweather.glacier.www.threedayforecast;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.MonthlyForeCastPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.date.SimpleDate;

public class Test_ThreeDayForecast extends AccuWeatherBaseTest 
{
	String zipcode = "48073";
	String actualForecastPageTitle;
	String expectedForecastPageTitle = "Royal Oak Weather - AccuWeather Forecast for MI 48073";
	String pageTitle3day = "Weather in Mc Farland - AccuWeather Forecast for WI 53558";
	private final static String EXPECTED_TAB_REFLECTS_CITY = "Cannondale, CT Three Day Weather Forecast | AccuWeather";
	private final static String EXPECTED_TAB_REFLECTS_CITY_COUNTRY = "Salvador, Bahia, Brazil Three Day Weather Forecast | AccuWeather";
	private final static String EXPECTED_TAB_REFLECTS_SEVEREWEAHTER = "Severe Weather Warnings & Watches | AccuWeather";

	private NavigationBar navBar = new NavigationBar();
	private LandingPage landingpage = new LandingPage();
	ThreeDayForecastPage threeDayForecastPage = new ThreeDayForecastPage();


	private SimpleDate getDateTime = new SimpleDate();
  
	@Test(priority = 1)
	public void TC1_nowTabOnCityForecastPage() {
		String Expectedactive="subnav-item active";
		testStart("Navigate to city forecast page and Verfiy Now Tab highlighted");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertEquals(threeDayForecastPage.isnowTabHighlighted(), Expectedactive, "Now tab is not active ");
	}
	
	
	@Test(priority = 2)
	public void TC1_nowTabHighlighted() {
		String ExpectedNowtabcolour = "#f05514";
		testStart("Navigate to city forecast and Validate Now tab highlightded in orange colour");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String Actualtabcolour = threeDayForecastPage.nowTabcolour();
		Assert.assertEquals(Actualtabcolour, ExpectedNowtabcolour, "Tab not highlighted in orange");
	}
	
	
	@Test(priority = 3)
	public void TC2_verifyingFourWeatherCardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate 4 weather cards are displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.fourWeathercardisDisplayed());
	}
	
	
	@Test(priority = 4)
	public void TC2_verifyingCurrentWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Current Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();	
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.currentWeathercardisDisplayed());
	}
	
	
	@Test(priority = 5)
	public void TC2_verifyingTodayWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.todayWeathercardisDisplayed());
	}
	
	
	@Test(priority = 6, enabled = true)
	public void TC2_verifyingTonightWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.tonightWeathercardisDisplayed());
	}
	
	
	@Test(priority = 7, enabled = true)
	public void TC2_verifyingTomorrowWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tomorrow Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.tomorrowWeathercardisDisplayed());
	}
	
	@Test(priority = 8, enabled = true)
	public void TC3_verifyingCurrentWeatherTitleDisplayed() {
		String Expectedcurrentcardtitle = "CURRENT WEATHER";
		testStart("Navigate to city day forecast page and Validating Current Weather card Title displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String currentweathercardtitle = threeDayForecastPage.currentWeathercardTitle();
		Assert.assertEquals(currentweathercardtitle, Expectedcurrentcardtitle);
	}
	
	
	@Test(priority = 9, enabled = true)
	public void TC3_verifyingcurrentweathercardCurrentTimeisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Time stamp displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.getcurentTime(),"Current card Current time not Displayed");
		}
	
	
	@Test(priority = 10, enabled = true)
	public void TC3_verifyingCurrentWeathercardweathericonisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Weather icon is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Current Weather Weather Icon"));
	}
	
	
	@Test(priority = 11, enabled = true)
	public void TC3_verifyingCurrentWeathercardTemperatureisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Time stamp displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Current Weather Temperature"));
	}
	
	
	@Test(priority = 12, enabled = true)
	public void TC3_verifyingCurrentWeathercardRealfeelTempisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Current Weather Real feel temperature with trademark symbol is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Current Weather Real FeelTemperature"));
	}
	
	
	@Test(priority = 13, enabled = true)
	public void TC3_verifyingCurrentWeathercardWeatherDescriptionisDisplayed() {
		testStart("Navigate to city day forecast page and Validating Current Weather Current Weather Description is Displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Current Weather Description"));
	}
	
	
	@Test(priority = 14, enabled = true)
	public void TC4_verfyingisclickedonCurrentweathercard() {
		String ExpectedUrl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		threeDayForecastPage.isclickedonCurrentWeather();
		Assert.assertEquals(getDriver().getCurrentUrl(),ExpectedUrl);
	}
	
	
	@Test(priority = 15, enabled = true)
	public void TC4_verifyingnavigatingtoCurrentWeatherlocationpage() {
		String ExpectedUrl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		threeDayForecastPage.isclickedonCurrentWeather();
		Assert.assertEquals(getDriver().getCurrentUrl(), ExpectedUrl);
	}
	
	@Test(priority = 16, enabled = true)
	public void TC5_verifyingTodaycardWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card Title is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Today"));
	}
	
	
	@Test(priority = 17, enabled = true)
	public void TC5_verifyingTodaycardTitledisplayed() {
		String ExpectedTodaycardtitle = "TODAY";
		testStart("Navigate to city day forecast page and Validate Today Weather card Title is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String Actualcardtitle = threeDayForecastPage.TodayweathercardTitle();
		Assert.assertEquals(Actualcardtitle, ExpectedTodaycardtitle, "Card Title mismatch");
	}
	
	
	@Test(priority = 18, enabled = true)
	public void TC5_verifyingTodaycardcurrentDateisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card has current Date displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.gettodaycardDate(), "Current Date is not displayed for Current card");
	}
	
	@Test(priority = 19, enabled = true)
	public void TC5_verifyingToadycardWeathericonisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card has Weather icon displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Today Weather icon"));
	}
	
	
	@Test(priority = 20, enabled = true)
	public void TC5_verifyingtodaycardTemperatureisDisplayed() {
		String ExpectedText="Hi";
		testStart("Navigate to city day forecast page and Validate Today Weather card has High Temperature displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertEquals(threeDayForecastPage.todaytextdisplayedisHigh(), ExpectedText, "Text Hi is not displayed");
	}
	
	
	@Test(priority = 21, enabled = true)
	public void TC5_verifyingtodaycardRealfeeltempisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card has Real feel Temperature with trademark displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Today RealFeelTemperature with trademark"));
	}
	
	
	@Test(priority = 22, enabled = true)
	public void TC5_verifyingtodaycardWeatherdescriptionisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Today Weather card has Weather description displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Today Weather Description"));
	}
	
	
	@Test(priority = 23, enabled = true)
	public void TC6_verifyingTonightWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.tonightWeathercardisDisplayed());
	}
	
	
	@Test(priority = 24, enabled = true)
	public void TC6_verifyingTonightWeathercardtitleDisplayed() {
		String ExpectedTonightcardtitle = "TONIGHT";
		testStart("Navigate to city day forecast page and Validate Tonight Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String tonightcardTitle = threeDayForecastPage.tonightweathercardTitle();
		Assert.assertEquals(tonightcardTitle, ExpectedTonightcardtitle);
	}
	
	
	@Test(priority = 25, enabled = true)
	public void TC6_verifyingTonightWeathercardDateDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card has current Date displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.gettonightcardDate(), "Current Date is not displayed for Tonight card");
	}
	
	
	@Test(priority = 26, enabled = true)
	public void TC6_verifyingTonightWeathercardisiconDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card has Weather icon displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Tonight Weather icon"));
	}
	
	
	@Test(priority = 27, enabled = true)
	public void TC6_verifyingtonightweathercardTemperatureDisplayed() {
		String ExpectedText ="Lo";
		testStart("Navigate to city day forecast page and Validate Tonight Weather card has Low Temperature displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertEquals(threeDayForecastPage.tonighttextdisplayedisLow(), ExpectedText, "Text Low is not displayed");
	}
	
	
	@Test(priority = 28, enabled = true)
	public void TC6_verifyingtonightweathercardRealfeeltempDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card has Real feel Temperature with trademark displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Tonight RealFeelTemperature with trademark"));
	}
	
	
	@Test(priority = 29, enabled = true)
	public void TC6_verifyingtonightcardWeatherdescriptionisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card has Weather description displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Tonight Weather Description"));
	}
	
	
	@Test(priority = 30, enabled = true)
	public void TC7_verfyingisclickedonTodayweathercard() {
		String ExpectedUrl="https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		threeDayForecastPage.isclickedonTodayWeather();
		Assert.assertEquals(getDriver().getCurrentUrl(), ExpectedUrl);
	}
	
	
	@Test(priority = 31, enabled = true)
	public void TC7_verifyingnavigatingtoCurrentWeatherlocationpage()  {
		String ExpectedUrl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/current-weather/20813_pc";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertEquals(threeDayForecastPage.todayWeatherurldisplayed(), ExpectedUrl,"Landing page URL Mismatch");
	}
	
	
	@Test(priority = 32, enabled = true)
	public void TC8_verifyingtomorrowtWeathercardisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tonight Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.tomorrowWeathercardisDisplayed());
	}
	
	
	@Test(priority = 33, enabled = true)
	public void TC8_verifyingTomorrowWeathercadrTitle() {
		String ExpectedTonightcardtitle = "TOMORROW";
		testStart("Navigate to city day forecast page and Validate Tonight Weather card is displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String tonightcardTitle = threeDayForecastPage.tomorrowweathercardTitle();
		Assert.assertEquals(tonightcardTitle, ExpectedTonightcardtitle);
	}
	
	
	@Test(priority = 34, enabled = true)
	public void TC8_verifyingTomorrowcarddateDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tomorrow Weather card has  Date displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.gettomorrowcardDate(), "Date is not displayed for Tomorrow card");
	}
	
	
	@Test(priority = 35, enabled = true)
	public void TC8_verifyingTomorrowcardWeathericonisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tomorrow Weather card has Weather icon displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Tomorrow Weather icon"));
	}
	
	
	@Test(priority = 36, enabled = true)
	public void TC8_verifyingTomorrowcardTemperatureisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tomorrow Weather card has High and Low Temperature displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertNotNull(threeDayForecastPage.tomorrowtextHiLoDisplayed(), "Tomorrow card Hi and Lo text not displayed ");
	}
	
	
	@Test(priority = 37, enabled = true)
	public void TC8_verifyingTomorrowcardWeatherdescriptionisDisplayed() {
		testStart("Navigate to city day forecast page and Validate Tomorrow Weather card has Weather description displayed ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.weatherCardElementsDetailsDisplayed("Tomorrow  Weather Description"));
	}
	
	
	@Test(priority = 38, enabled = true)
	public void TC9_verfyingisclickedonTomorrowweathercard() {
		String ExpectedUrl="https://qualityassurance.accuweather.com/en/us/royal-oak/48073/daily-weather-forecast/20813_pc?day=1";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		threeDayForecastPage.isclickedonTomorrowWeather();
		Assert.assertEquals(getDriver().getCurrentUrl(), ExpectedUrl);
	}
	
	
	@Test(priority = 39, enabled = true)
	public void TC9_verifyingnavigatingtoCurrentWeatherlocationpage() {
		String ExpectedUrl = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/daily-weather-forecast/20813_pc?day=1";
		testStart("Navigate to city day forecast page and click on Current weather card and validating URL");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		String ActualUrldisplayed=threeDayForecastPage.tomorrowWeatherurldisplayed();
		WebPageLoaded.isDomInteractive(3000);
		Assert.assertEquals(ActualUrldisplayed, ExpectedUrl);
	}
	
	
	@Test(priority = 40, enabled = true)
	public void TC10_VerifyingnArrowsonThreeDayForecast() {
		String ExpectedForwardarroworange = "#f59721"; // Forward arrow Orange Active on City forecast page
		testStart("Navigate to city forecast page and validate forward arrow Active and highlighted");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		String Forwardarrowcolour=threeDayForecastPage.Forwardarrowcolour();
		Assert.assertEquals(Forwardarrowcolour, ExpectedForwardarroworange);
	}
	
	
	@Test(priority = 41, enabled = true)
	public void TC10_VerifyingnForwardactiveandBackArrowinactiveonThreeDayForecast() {
		String ExpectedBackarrowGreyColour = "#878787"; // Back arrow Grey Inactive on City forecast page
		testStart("Navigate city forecast page and verfiying Backward arrow inactive and displayed in Grey ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		String backarowcolour = threeDayForecastPage.Backarrowcolour();
		System.out.println("Back arrow colour displayed is" + backarowcolour);
		Assert.assertEquals(backarowcolour, ExpectedBackarrowGreyColour);
	}
	
	
	@Test(priority = 42, enabled = true)
	public void TC11_VerifyingnFourfuturedays() {
		testStart("Navigate to city forecast city page and Click on forward arrow verfiy four future days displayed");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		threeDayForecastPage.animationforwardarrowclick();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastPage.nextfourdaysforecast());
	}
	
	
	@Test(priority = 43, enabled = true)
	public void TC11_VerifyingnbackarrowActive() {
		String ExpectedForwardarroworange = "#f59721"; // Back arrow active and enabled after forward click
		testStart("Navigate to city forecast city page and Click on forward arrow verfiy Backarrow enabled and displayed in orange colour");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		threeDayForecastPage.animationforwardarrowclick();
		Sleeper.sleep(3);
		String backarowcolour2 = threeDayForecastPage.Backarrowcolour2();
		Assert.assertEquals(backarowcolour2, ExpectedForwardarroworange);
	}
	
	
	@Test(priority = 44, enabled = true)
	public void TC11_VerifyingpastfourdaysDisplayed() {
		testStart("Navigate to city forecast city page,Click on forward arrow verfiy future days displayed,click on Back arrow to  past days ");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		threeDayForecastPage.animationforwardarrowclick();
		Sleeper.sleep(3);
		threeDayForecastPage.animationBackwardarrowclick();
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastPage.fourWeathercardisDisplayed());
	}
	
	
	
	
	@Test(priority = 45, enabled = true)
	public void TC12_isTimeCorrectOnCurrentWeather()
	{
		testStart("Verification whether the time is displayed correctly on Current weather card");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Sleeper.sleep(3);
		Assert.assertTrue(threeDayForecastPage.timeValidationOnCurrentWeather());
	}
	
	
	@Test(priority = 46, enabled = true)
	public void TC12_isDateCorrectOnTodayCard()
	{
		testStart("Verification whether current date is displayed on Today card");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.dateValidationOnTodayCard());
	}
	
	
	@Test(priority = 47, enabled = true)
	public void TC12_isDateCorrectOnTonightCard()
	{
		testStart("Verification whether current date is displayed on tonight card");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.dateValidationOnTonightCard());
	}
	
	
	
	@Test(priority = 48, enabled = true)
	public void TC12_isDateCorrectOnTomorrowsCard()
	{
		testStart("Verification whether current date is displayed on tonight card");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		Sleeper.sleep(3);
		waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
		Assert.assertTrue(threeDayForecastPage.dateValidationOnTomorrowsCard());
	}
	
	@Test(priority = 48, enabled = true)
	public void TC1186_VerifyIndexTabsforThreeDayPageDisplayed_verifyTabReflectsFormatOfCity()
	{
		testStart("Verify tab reflects format of city");
		landingpage.enterZipcodeInSearchFieldAndClick("Cannondale, CT");
		String actualTabReflectsCity = getDriver().getTitle();
		Assert.assertEquals(actualTabReflectsCity, EXPECTED_TAB_REFLECTS_CITY);
	}
	
	@Test(priority = 48, enabled = true)
	public void TC1188_VerifyIndexTabsforThreeDayPageDisplayed_verifyTabReflectsFormatOfCityAndCountry()
	{
		testStart("Verify tab reflects format of city and country");
		landingpage.enterZipcodeInSearchFieldAndClick("Salvador, Bahia, Brazil");
		String actualTabReflectsCityCountry = getDriver().getTitle();
		Assert.assertEquals(actualTabReflectsCityCountry, EXPECTED_TAB_REFLECTS_CITY_COUNTRY);
	}
	
	@Test(priority = 48, enabled = true)
	public void TC1190_VerifyIndexTabsforThreeDayPageDisplayed_verifyTabReflectsFormatOfCityAndCountry()
	{
		testStart("Verify tab reflects severe weather warnings");
		navBar.mouseHoverOnSeverWeather();
		navBar.isSeverWeatherSubMenuDisplayed();
		navBar.clickSeverWeatherSubMenu();
		Sleeper.sleep(2);
		String actualTabReflectsSevereWeather = getDriver().getTitle();
		System.out.println("actualTabReflectsSevereWeather:"+actualTabReflectsSevereWeather);
		Assert.assertEquals(actualTabReflectsSevereWeather, EXPECTED_TAB_REFLECTS_SEVEREWEAHTER);
	}
}