package com.accuweather.glacier.m.monthlyForecast;

import java.time.Month;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.DailyListPageMobile;
import com.accuweather.glacier.m.pages.ForeCastWeatherPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.MonthlyForeCastPageMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.MonthlyForeCastPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.date.SimpleDate;

public class Test_MonthlyForecastPageIOS extends AccuWeatherBaseTest {
//		String zipcode = "16801";
	String zipcode = "State College, PA";
	String ActualForecastPageTitle;
	String ExpectedForecastPageTitle = "State College, PA Three Day Weather Forecast | AccuWeather";
	int integercurrentyear;
	String expectedcurrentyear;
	String actualcurrentyear;
	String actualcurrentmonth;
	String expectecurrentmonth;
	String actualfuturemonth;
	String actualprevmonth;
	SimpleDate months;
	String expectedfuturemonth;
	String expectedpreviousmonth;
	int previousmonth;
	String actualgridiconhexvalue;
	String actualdatecolor;
	String ExpectedNonActiveSpanText;
	String ActualNonActiveSpanText;
	String expecteddatecolor = "#f05514";
	String expectedgridiconhexvalue = "#f59721";
	String actualdailyforcastpagetitle;
	String expecteddailyforecastpagetitle = "Weather in  - AccuWeather Forecast for ";
	private LandingPageMobile landingpage = new LandingPageMobile();
	private ForeCastWeatherPageMobile forecastpage = new ForeCastWeatherPageMobile();
	private MonthlyForeCastPageMobile monthlyforecast = new MonthlyForeCastPageMobile();
	private SimpleDate simpledate = new SimpleDate();
	DailyListPageMobile dailyListPage = new DailyListPageMobile();

	@Test(priority = 1, enabled = true)
	public void TC1_navigateToAWWeatherForecastPage() {
		testStart("Is AW Weather Forecast Page Displayed From Home Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		ActualForecastPageTitle = getDriver().getTitle();
		Assert.assertEquals(ActualForecastPageTitle, ExpectedForecastPageTitle);
	} 

	@Test(priority = 2, enabled = true)
	public void TC2_NowTabEnabledForeCasthtlyWeatherPage() {
		testStart("Is Now Tab enabled on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isNowTabEnabled());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 3, enabled = true)
	public void TC2_isRadarTabDisplayed() {
		testStart("Is Radar Tab displayed on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isRadarTabDisplayed());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 4, enabled = true)
	public void TC2_isMinuteCastTabDisplayed() {
		testStart("Is Minute Cast Tab displayed on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isMinuteCastTabDisplayed());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 4, enabled = true)
	public void TC2_isHourlyTabDisplayed() {
		testStart("Is Hourly Tab displayed on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isHourlyTabDisplayed());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 5, enabled = true)
	public void TC2_isDailyTabDisplayed() {
		testStart("Is Daily Tab displayed on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isDailyTabDisplayed());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 6, enabled = true)
	public void TC2_isMonthlyTabDisplayed() {
		testStart("Is Monthly Tab displayed on AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(forecastpage.isMonthlyTabDisplayed());
		WebPageLoaded.isDomInteractive(5);
	} 

	@Test(priority = 7, enabled = true)
	public void TC2_navigateToAWMonhtlyWeatherPage() {
		testStart("Is AW Monthly Weather page Displayed From AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(monthlyforecast.isGridViewIconSelected());
	} 

	@Test(priority = 8, enabled = true)
	public void TC2_isAWLogoDisplayed() {
		testStart("Is AW Logo Displayed From AW Weather Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		WebPageLoaded.isDomInteractive(5);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(monthlyforecast.isAWLogoDisplayed());
	} 

	@Test(priority = 9, enabled = true)
	public void TC3_NavigateToFutureMonthForeCast() throws InterruptedException {
		testStart("Navigate to future month forecast from current month forecast");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive();
		forecastpage.clickOnMonthlyTab();
		WebPageLoaded.isDomInteractive();
		monthlyforecast.clickOnRightArrowLink();
		Thread.sleep(1000);
		actualfuturemonth = monthlyforecast.getGridViewMonthSubString();
		WebPageLoaded.isDomInteractive(10000);
		months = simpledate.advanceMonth(1);
		expectedfuturemonth = months.getMonthString().toUpperCase();
		Assert.assertEquals(actualfuturemonth, expectedfuturemonth);
	} 

	@Test(priority = 10, enabled = true)
	public void TC4_NavigateToPreviousMonthForeCast() throws InterruptedException {
		testStart("Navigate to previous month forecast from current month forecast");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnLeftArrowLink();
		Thread.sleep(1000);
		actualprevmonth = monthlyforecast.getGridViewMonthSubString();
		WebPageLoaded.isDomInteractive(10000);
		previousmonth = simpledate.getMonth();
		expectedpreviousmonth = Month.of(previousmonth).name().toUpperCase();
		Assert.assertEquals(actualprevmonth, expectedpreviousmonth);
	} 

	@Test(priority = 11, enabled = true)
	public void TC7_VerifyColorIsDisplayedOnActiveDate() {
		testStart("Navigate to previous month forecast from current month forecast");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		actualdatecolor = monthlyforecast.getcolorofDateBottom();
		Assert.assertEquals(actualdatecolor, expecteddatecolor);
	} 

	/*
	 * @Test(priority = 12, enabled = true) public void
	 * TC8_VerifyColorIsDisplayedOnActiveDate() {
	 * testStart("Navigate to previous month forecast from current month forecast");
	 * landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
	 * landingpage.clickOnZipcodeSearchIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	 * dailyListPage.navigateToDailyListTab(); WebPageLoaded.isDomInteractive(5);
	 * forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	 * monthlyforecast.getcolorofDateBottom();
	 * monthlyforecast.isOrangeBordersColorDislayed();
	 * Assert.assertTrue(monthlyforecast.isOrangeBordersColorDislayed()); }
	 */ //NA

	@Test(priority = 13, enabled = true)
	public void TC5_VerifyGridViewIconIsDisplayed() {
		testStart("Verify the Grid View Icon is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Assert.assertTrue(monthlyforecast.isGridIconDislayed());
	} 

	@Test(priority = 14, enabled = true)
	public void TC5_VerifyListViewIconIsDisplayed() {
		testStart("Verify the List View Icon is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Assert.assertTrue(monthlyforecast.isListViewIconDislayed());
	} 

	@Test(priority = 16, enabled = true)
	public void TC5_VerifyGirdViewIconColorAreSame() {
		testStart("Verify the List View Icon is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		actualgridiconhexvalue = monthlyforecast.getGridIconColor();
		Assert.assertEquals(actualgridiconhexvalue, expectedgridiconhexvalue);
	}

	@Test(priority = 17, enabled = true)
	public void TC5_VerifyGirdViewIconColorDisplayed() {
		testStart("Verify the List View Icon is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Assert.assertTrue(monthlyforecast.getGridIconColor().equals(expectedgridiconhexvalue));
	} 

	@Test(priority = 18, enabled = true)
	public void TC5_VerifyAllActiveDayPanelSectionDisplayed() {
		testStart("Verify All Active Day Panel sections are displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isActiveDayPanelDisplayed());
	} 

	@Test(priority = 19, enabled = true)
	public void TC5_VerifyAllActiveDatesUnderDayPanelSectionDisplayed() {
		testStart("Verify All Active Dates in Day Panel sections are displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isActiveDatesOfDaysPanelDisplayed());
	} 

	@Test(priority = 20, enabled = true)
	public void TC5_VerifyAllActiveRemainingDatesDisplayed() {
		testStart("Verify All Active Dates in Day Panel sections are displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isAllActiveCurrentMnthRemainingDaysDisplayed());
	} 

	/*
	 * @Test(priority = 21, enabled = true) public void
	 * TC12_VerifyNonActiveSpanTextAreSame() {
	 * testStart("Verify Actual Temp text are same under Monthly Forecast Page");
	 * landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
	 * landingpage.clickOnZipcodeSearchIcon();
	 * waitUntilElementIsDisplayedOrClickable();
	 * waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	 * dailyListPage.navigateToDailyListTab(); WebPageLoaded.isDomInteractive(5);
	 * forecastpage.clickOnMonthlyTab(); Sleeper.sleep(5);
	 * waitUntilElementIsDisplayedOrClickable(); ExpectedNonActiveSpanText =
	 * "Actual Temp"; ActualNonActiveSpanText =
	 * monthlyforecast.getLastSpanTextForNonActiveDays();
	 * Assert.assertEquals(ActualNonActiveSpanText, ExpectedNonActiveSpanText);
	 * }//NA
	 */
	
	
	@Test(priority = 22, enabled = true)
	public void TC12_VerifyAllNonActiveSpanTextDisplayed() {
		testStart("Verify Actual Temp text displayed for All Non Active Days under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isListOfSpanTextForNonActiveDaysDisplayed());
	} //NA

	@Test(priority = 23, enabled = true)
	public void TC12_VerifyAllNonActiveActualHighTempDisplayed() {
		testStart("Verify Actual High Temp is displayed for All Non Active Days under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isListOfActualHightempForNonActiveDaysDisplayed());
	} 

	@Test(priority = 24, enabled = true)
	public void TC12_VerifyAllNonActiveActualLowTempDisplayed() {
		testStart("Verify Actual Low Temp is displayed for All Non Active Days under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isListOfActualLowtempForNonActiveDaysDisplayed());
	} 

	/*
	 * @Test(priority = 25, enabled = true) public void
	 * TC12_VerifyAllNonActiveAvgHighLowTempDisplayed() {
	 * testStart("Verify Avg High Low Temp is displayed for All Non Active Days under Monthly Forecast Page"
	 * ); landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
	 * waitUntilElementIsDisplayedOrClickable();
	 * waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	 * forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	 * Assert.assertTrue(monthlyforecast.
	 * isListOfActualAvgHighLowtempForNonActiveDaysDisplayed()); }//NA
	 */
	
	@Test(priority = 26, enabled = true)
	public void TC13_VerifyAllWeatherIconsDisplayed() {
		testStart("Verify Weather Icon is displayed for All Active Days under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isListOfWeatherIconForActiveDaysDisplayed());
	} 

	@Test(priority = 27, enabled = true)
	public void TC14_VerifyDailyForecastPageIsDisplayed() throws InterruptedException {
		testStart("Verify Weather Icon is displayed for All Active Days under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.isDailyForecastPageDisplayed();
		waitUntilElementIsDisplayedOrClickable();
		actualdailyforcastpagetitle = getDriver().getTitle();
		Assert.assertTrue(actualdailyforcastpagetitle.contains("State College, PA Day and Night Weather | AccuWeather"));
	} 

	@Test(priority = 28, enabled = true)
	public void TC16_VerifyTempOnTempGraphIsDisplayed() {
		testStart("Verify Temperature on Temperature Graph is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isAllTempOnTempGraphDislayed());
	} 

	@Test(priority = 29, enabled = true)
	public void TC17_VerifyAllDaysOnTempGraphIsDisplayed() {
		testStart("Verify All Days on Temperature Graph is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isAllDaysOnTempGraphDislayed());
	} 

	@Test(priority = 30, enabled = true)
	public void TC18_VerifyOrangeThinLineOnTempGraphIsDisplayed() {
		testStart("Verify Orange Thin Line on Temperature Graph is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isAllDaysOnTempGraphDislayed());
	} 

	@Test(priority = 31, enabled = true)
	public void TC19_VerifyOrangeThickLineOnTempGraphIsDisplayed() {
		testStart("Verify Orange Thick Line on Temperature Graph is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isOrangeLineForActualHighOnTempGraphDislayed());
	} 

	@Test(priority = 32, enabled = true)
	public void TC02_VerifyInGridViewTopMnthlyNavIsDisplayed() {
		testStart("Verify Top Mnthly Nav is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isTopMnthlyNavOnGridViewDislayed());
	} 

	@Test(priority = 33, enabled = true)
	public void TC02_VerifyInGridViewBottomMnthlyNavIsDisplayed() {
		testStart("Verify Bottom Mnthly Nav is displayed under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isBottomMnthlyNavOnGridViewDislayed());
	} 

	@Test(priority = 34, enabled = true)
	public void TC02_VerifyCurrentMonthAreSame() {
		testStart("Verify current Month in Grid View is same under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		actualcurrentmonth = monthlyforecast.getGridViewMonthSubString();
		Assert.assertEquals(actualcurrentmonth, expectecurrentmonth);
	} 

	@Test(priority = 35, enabled = true)
	public void TC10_VerifyListOfDaysWeekDisplayed() throws InterruptedException {
		testStart("Verify List of Days of week in List View under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnListViewIcon();
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(monthlyforecast.isListOfDaysWeekForCurrentMonthDisplayed());
	} 

	@Test(priority = 36, enabled = true)
	public void TC08_VerifyListOfDaysMonthDisplayed() throws InterruptedException {
		testStart("Verify List of Days of Month in List View under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnListViewIcon();
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(monthlyforecast.isListOfDaysMonthForCurrentMonthDisplayed());
	} 

	@Test(priority = 37, enabled = true)
	public void TC08_VerifyListViewCurrentMonthAreSame() throws InterruptedException {
		testStart("Verify current Month in List View is same under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnListViewIcon();
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(5);
		WebPageLoaded.isDomInteractive(5);
		actualcurrentmonth = monthlyforecast.getGridViewMonthSubString();
		Assert.assertEquals(actualcurrentmonth, expectecurrentmonth);
	} 

	@Test(priority = 38, enabled = true)
	public void TC08_VerifyListViewCurrentYearAreSame() throws InterruptedException {
		testStart("Verify current Year in List View is same under Monthly Forecast Page");
		integercurrentyear = simpledate.getYear();
		expectedcurrentyear = Integer.toString(integercurrentyear);
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnListViewIcon();
		Thread.sleep(5);
		actualcurrentyear = monthlyforecast.getListViewYearSubString();
		Assert.assertEquals(actualcurrentyear, expectedcurrentyear);
	} 

	@Test(priority = 39, enabled = true)
	public void TC09_VerifyListOfWeekDaysOfMonthDisplayed() throws InterruptedException {
		testStart("Verify List of Week Days of Month Displayed in Grid View under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isListOfWeekDaysForCurrentMonthDisplayed());
	} 

	@Test(priority = 40, enabled = true)
	public void TC20_VerifyOrangeDottedLineIsDisplayed() {
		testStart("Verify Orange Dotted Line is displayed under Graph under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isOrangeDottedLineOnTempGraphDislayed());
	} 

	@Test(priority = 41, enabled = true)
	public void TC21_VerifyBlueThinLineIsDisplayed() {
		testStart("Verify Blue Thin Line is displayed under Graph under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isBlueLineForAvgLowOnTempGraphDislayed());
	}

	@Test(priority = 42, enabled = true)
	public void TC22_VerifyBlueThickLineIsDisplayed() {
		testStart("Verify Blue Thick Line is displayed under Graph under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isBlueLineForActualLowOnTempGraphDislayed());
	}

	@Test(priority = 43, enabled = true)
	public void TC23_VerifyBlueDottedLineIsDisplayed() {
		testStart("Verify Blue Dotted Line is displayed under Graph under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isBlueDottedLineOnTempGraphDislayed());
	}

	@Test(priority = 44, enabled = true)
	public void TC24_VerifyTodayMarkerIsDisplayed() {
		testStart("Verify Today Marker is displayed under Graph under Monthly Forecast Page");
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(monthlyforecast.isTodayMarkerOnTempGraphDislayed());
	}

	@Test(priority = 45, enabled = true)
	public void TC06_VerifyListViewIconDisplayed() throws InterruptedException {
		testStart("Verify List View Icon is enabled by default under Monthly Forecast Page");
		expectecurrentmonth = simpledate.getMonthString().toUpperCase();
		landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingpage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
		dailyListPage.navigateToDailyListTab();
		WebPageLoaded.isDomInteractive(5);
		forecastpage.clickOnMonthlyTab();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		monthlyforecast.clickOnListViewIcon();
		Sleeper.sleep(5);
		WebPageLoaded.isDomInteractive(5);
		Assert.assertTrue(monthlyforecast.isListViewIconEnabled());
	}
	
	
	@Test(priority = 45, enabled = true)
	public void TCRW_T1523_VerifyDropdownisaddedformonthandyear() throws InterruptedException {
		testStart("Verify Drop down is added for month and year under Monthly Forecast Page");
		  landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		  landingpage.clickOnZipcodeSearchIcon();
		  waitUntilElementIsDisplayedOrClickable();
		  dailyListPage.navigateToDailyListTab(); 
		  WebPageLoaded.isDomInteractive(5);
		  forecastpage.clickOnMonthlyTab();
		  Sleeper.sleep(5);
		  waitUntilElementIsDisplayedOrClickable();
		  monthlyforecast.ValidateThreeMonthsForecast();
	}
	
	@Test(priority = 45, enabled = true)
	public void TCRW_T1547_VerifyMonthDropdownAreDiplayedInEnglish() throws InterruptedException {
		testStart("Verify Drop down is added for month and year under Monthly Forecast Page");
		  landingpage.enterZipcodeInSearchFieldAndClick(zipcode);
		  landingpage.clickOnZipcodeSearchIcon();
		  waitUntilElementIsDisplayedOrClickable();
		  dailyListPage.navigateToDailyListTab(); 
		  WebPageLoaded.isDomInteractive(5);
		  forecastpage.clickOnMonthlyTab();
		  Sleeper.sleep(5);
		  waitUntilElementIsDisplayedOrClickable();
		  monthlyforecast.ValidateMonthDropDownOpionsInEnglish();
	}
	
	
	

}
