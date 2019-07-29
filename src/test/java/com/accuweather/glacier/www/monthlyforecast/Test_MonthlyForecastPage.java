package com.accuweather.glacier.www.monthlyforecast;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.MonthlyForeCastPage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.date.SimpleDate;

public class Test_MonthlyForecastPage extends AccuWeatherBaseTest 
{
	String zipcode = "16803";
	String ActualForecastPageTitle;
	String ExpectedForecastPageTitle = "State College Weather - AccuWeather Forecast for PA 16803";
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
	String strDateFormat;
	private LandingPage landingpage = new LandingPage();
	private ForeCastWeatherPage forecastpage = new ForeCastWeatherPage();
	private MonthlyForeCastPage monthlyforecast = new MonthlyForeCastPage();
	private SimpleDate simpledate = new SimpleDate();
	private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat();
	
	
	  
	  
	
	
	
	
	  @Test(priority = 1) public void TC1_navigateToAWWeatherForecastPage() {
	  testStart("Is AW Weather Forecast Page Displayed From Home Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000); ActualForecastPageTitle =
	  getDriver().getTitle(); Assert.assertEquals(ActualForecastPageTitle,
	  ExpectedForecastPageTitle); }
	 
	  
	  
	
	  @Test(priority = 2) public void TC2_NowTabEnabledForeCasthtlyWeatherPage() {
	  testStart("Is Now Tab enabled on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isNowTabEnabled());
	  WebPageLoaded.isDomInteractive(1000); }
	 
	  
	
	  @Test(priority = 3) public void TC2_isRadarTabDisplayed() {
	  testStart("Is Radar Tab displayed on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isRadarTabDisplayed());
	  WebPageLoaded.isDomInteractive(1000); }
	 
	
	
	
	  @Test(priority = 4) public void TC2_isMinuteCastTabDisplayed() {
	  testStart("Is Minute Cast Tab displayed on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isMinuteCastTabDisplayed());
	  WebPageLoaded.isDomInteractive(1000); }
	 
	  
	
	  @Test(priority = 4) public void TC2_isHourlyTabDisplayed() {
	  testStart("Is Hourly Tab displayed on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isHourlyTabDisplayed());
	  WebPageLoaded.isDomInteractive(1000); }
	  
	  @Test(priority = 5) public void TC2_isDailyTabDisplayed() {
	  testStart("Is Daily Tab displayed on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isDailyTabDisplayed());
	  WebPageLoaded.isDomInteractive(1000); }
	  
	  
	  
	  @Test(priority = 6) public void TC2_isMonthlyTabDisplayed() {
	  testStart("Is Monthly Tab displayed on AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(forecastpage.isMonthlyTabDisplayed());
	  WebPageLoaded.isDomInteractive(1000); }
	  
	  
	  
	  @Test(priority = 8) public void TC2_isAWLogoDisplayed() {
	  testStart("Is AW Logo Displayed From AW Weather Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  WebPageLoaded.isDomInteractive(1000); forecastpage.clickOnMonthlyTab();
	  WebPageLoaded.isDomInteractive(1000);
	  Assert.assertTrue(monthlyforecast.isAWLogoDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 9) public void TC3_NavigateToFutureMonthForeCast() throws
	  InterruptedException {
	  testStart("Navigate to future month forecast from current month forecast");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(4000); Thread.sleep(6000);
	  monthlyforecast.clickOnRightArrowLink();
	  WebPageLoaded.isDomInteractive(4000); Thread.sleep(6000); actualfuturemonth =
	  monthlyforecast.getGridViewMonthSubString(); months =
	  simpledate.advanceMonth(1); expectedfuturemonth =
	  months.getMonthString().toUpperCase();
	  Assert.assertEquals(actualfuturemonth,expectedfuturemonth); 
	  }
	  
	  
	  
	 
	  
	  @Test(priority = 10) public void TC4_NavigateToPreviousMonthForeCast() throws
	  InterruptedException {
	  testStart("Navigate to previous month forecast from current month forecast");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(3000); Thread.sleep(6000);
	  monthlyforecast.clickOnLeftArrowLink(); WebPageLoaded.isDomInteractive(3000);
	  Thread.sleep(6000); actualprevmonth =
	  monthlyforecast.getGridViewMonthSubString();
	  WebPageLoaded.isDomInteractive(10000); previousmonth = simpledate.getMonth();
	  expectedpreviousmonth = Month.of(previousmonth).name().toUpperCase();
	  Assert.assertEquals(actualprevmonth, expectedpreviousmonth); }
	  
	  
	  
	  
	  
	  
	
	  @Test(priority = 14) public void TC5_VerifyListViewIconIsDisplayed() {
	  testStart("Verify the List View Icon is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab();
	  Assert.assertTrue(monthlyforecast.isListViewIconDislayed()); 
	  }
	 
	  
	  
	  
	  
	  
	
	
	  @Test(priority = 16) public void TC5_VerifyGirdViewIconColorAreSame() {
	  testStart("Verify the List View Icon is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); actualgridiconhexvalue =
	  monthlyforecast.getGridIconColor();
	  Assert.assertEquals(actualgridiconhexvalue, expectedgridiconhexvalue); }
	 
	  
	  
	
	  @Test(priority = 17) public void TC5_VerifyGirdViewIconColorDisplayed() {
	  testStart("Verify the List View Icon is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab();
	  Assert.assertTrue(monthlyforecast.getGridIconColor().equals(
	  expectedgridiconhexvalue)); }
	 
	  
	  
	  @Test(priority = 18) public void
	  TC5_VerifyAllActiveDayPanelSectionDisplayed() {
	  testStart("Verify All Active Day Panel sections are displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  Assert.assertTrue(monthlyforecast.isActiveDayPanelDisplayed()); }
	  
	  
	  
	  @Test(priority = 19) public void
	  TC5_VerifyAllActiveDatesUnderDayPanelSectionDisplayed() {
	  testStart("Verify All Active Dates in Day Panel sections are displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isActiveDatesOfDaysPanelDisplayed()); }
	  
	  
	  
	  
	  
	  @Test(priority = 20) public void TC5_VerifyAllActiveRemainingDatesDisplayed()
	  {
	  testStart("Verify All Active Dates in Day Panel sections are displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.
	  isAllActiveCurrentMnthRemainingDaysDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 21) public void TC12_VerifyNonActiveSpanTextAreSame() {
	  testStart("Verify Actual Temp text are same under Monthly Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  ExpectedNonActiveSpanText = "Actual Temp"; ActualNonActiveSpanText =
	  monthlyforecast.getLastSpanTextForNonActiveDays();
	  Assert.assertEquals(ActualNonActiveSpanText, ExpectedNonActiveSpanText); 
	  }
	  
	  
	  
	  @Test(priority = 22) public void TC12_VerifyAllNonActiveSpanTextDisplayed() {
	  testStart("Verify Actual Temp text displayed for All Non Active Days under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isListOfSpanTextForNonActiveDaysDisplayed()
	  ); }
	  
	  
	  
	  
	  @Test(priority = 23) public void
	  TC12_VerifyAllNonActiveActualHighTempDisplayed() {
	  testStart("Verify Actual High Temp is displayed for All Non Active Days under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.
	  isListOfActualHightempForNonActiveDaysDisplayed()); }
	  
	  @Test(priority = 24) public void
	  TC12_VerifyAllNonActiveActualLowTempDisplayed() {
	  testStart("Verify Actual Low Temp is displayed for All Non Active Days under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.
	  isListOfActualLowtempForNonActiveDaysDisplayed()); }
	  
	  @Test(priority = 25) public void
	  TC12_VerifyAllNonActiveAvgHighLowTempDisplayed() {
	  testStart("Verify Avg High Low Temp is displayed for All Non Active Days under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.
	  isListOfActualAvgHighLowtempForNonActiveDaysDisplayed()); }
	  
	  
	  
	  
	  @Test(priority = 26) public void TC13_VerifyAllWeatherIconsDisplayed() {
	  testStart("Verify Weather Icon is displayed for All Active Days under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isListOfWeatherIconForActiveDaysDisplayed()
	  ); }
	  
	  
	  
	  
	  
	  @Test(priority = 28) public void TC16_VerifyTempOnTempGraphIsDisplayed() {
	  testStart("Verify Temperature on Temperature Graph is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isAllTempOnTempGraphDislayed()); }
	 
	  
	
	  @Test(priority = 29) public void TC17_VerifyAllDaysOnTempGraphIsDisplayed() {
	  testStart("Verify All Days on Temperature Graph is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(monthlyforecast.isAllDaysOnTempGraphDislayed()); }
	  
	  
	  
	  @Test(priority = 30) public void
	  TC18_VerifyOrangeThinLineOnTempGraphIsDisplayed() {
	  testStart("Verify Orange Thin Line on Temperature Graph is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  //waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(monthlyforecast.isOrangeLineForAvgHighOnTempGraphDislayed()); 
	  }
	  
	  
	  @Test(priority = 31) public void
	  TC19_VerifyOrangeThickLineOnTempGraphIsDisplayed() {
	  testStart("Verify Orange Thick Line on Temperature Graph is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); Assert.assertTrue(monthlyforecast.
	  isOrangeLineForActualHighOnTempGraphDislayed()); }
	  
	  
	  
	
	  @Test(priority = 32) public void
	  TC02_VerifyInGridViewTopMnthlyNavIsDisplayed() {
	  testStart("Verify Top Mnthly Nav is displayed under Monthly Forecast Page");
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isTopMnthlyNavOnGridViewDislayed()); 
	  }
	  
	  
	  
	  @Test(priority = 33) public void
	  TC02_VerifyInGridViewBottomMnthlyNavIsDisplayed() {
	  testStart("Verify Bottom Mnthly Nav is displayed under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isBottomMnthlyNavOnGridViewDislayed()); }
	 
	 
	  
	 
	  
	  @Test(priority = 34) public void TC02_VerifyCurrentMonthAreSame() {
	  testStart("Verify current Month in Grid View is same under Monthly Forecast Page"
	  ); expectecurrentmonth = simpledate.getMonthString().toUpperCase();
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000); actualcurrentmonth =
	  monthlyforecast.getGridViewMonthSubString();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(5000);
	  //getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  Assert.assertEquals(actualcurrentmonth, expectecurrentmonth); }
	 
	 
	 
	 
	  
	
	
	  @Test(priority = 35) public void TC10_VerifyListOfDaysWeekDisplayed() throws
	  InterruptedException {
	  testStart("Verify List of Days of week in List View under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); monthlyforecast.clickOnListViewIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(monthlyforecast.isListOfDaysWeekForCurrentMonthDisplayed()); 
	  }
	  
	  
	  
	  
	  
	  
	  @Test(priority = 36) public void TC08_VerifyListOfDaysMonthDisplayed() throws
	  InterruptedException {
	  testStart("Verify List of Days of Month in List View under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); monthlyforecast.clickOnListViewIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(monthlyforecast.isListOfDaysMonthForCurrentMonthDisplayed()); 
	  }
	  
	  
	  
	  
	  
	  
	  @Test(priority = 37) public void TC08_VerifyListViewCurrentMonthAreSame()	 throws InterruptedException {
	  testStart("Verify current Month in List View is same"); 
	  strDateFormat = "MMMM"; 
	  sdf = new SimpleDateFormat(strDateFormat);
	  expectecurrentmonth = sdf.format(date).toUpperCase();
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); monthlyforecast.clickOnListViewIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); actualcurrentmonth =
	  monthlyforecast.getListViewMonthSubString();
	  Assert.assertEquals(actualcurrentmonth, expectecurrentmonth);  
	  }
	  
	  
	  
	  
	  @Test(priority = 38) public void TC08_VerifyListViewCurrentYearAreSame()
	  throws InterruptedException {
	  testStart("Verify current Year in List View is same under Monthly Forecast Page"
	  ); integercurrentyear = simpledate.getYear(); expectedcurrentyear =
	  Integer.toString(integercurrentyear);
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Thread.sleep(2000); monthlyforecast.clickOnListViewIcon();
	  Thread.sleep(3000); actualcurrentyear =
	  monthlyforecast.getListViewYearSubString();
	  Assert.assertEquals(actualcurrentyear, expectedcurrentyear); }
	  
	  
	  
	  
	  
	  @Test(priority = 39) public void TC09_VerifyListOfWeekDaysOfMonthDisplayed()
	  throws InterruptedException {
	  testStart("Verify List of Week Days of Month Displayed in Grid View under Monthly Forecast Page"
	  ); expectecurrentmonth = simpledate.getMonthString().toUpperCase();
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isListOfWeekDaysForCurrentMonthDisplayed())
	  ; }
	  
	  
	  
	  
	  @Test(priority = 40) public void TC20_VerifyOrangeDottedLineIsDisplayed() {
	  testStart("Verify Orange Dotted Line is displayed under Graph under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isOrangeDottedLineOnTempGraphDislayed()); }
	  
	  
	  @Test(priority = 41) public void TC21_VerifyBlueThinLineIsDisplayed() {
	  testStart("Verify Blue Thin Line is displayed under Graph under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isBlueLineForAvgLowOnTempGraphDislayed());
	  }
	 
	  
	  
	  @Test(priority = 42) public void TC22_VerifyBlueThickLineIsDisplayed() {
	  testStart("Verify Blue Thick Line is displayed under Graph under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isBlueLineForActualLowOnTempGraphDislayed()
	  ); }
	  
	  
	
	  @Test(priority = 43) public void TC23_VerifyBlueDottedLineIsDisplayed() {
	  testStart("Verify Blue Dotted Line is displayed under Graph under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isBlueDottedLineOnTempGraphDislayed()); }
	 
	  
	  
	  @Test(priority = 44) public void TC24_VerifyTodayMarkerIsDisplayed() {
	  testStart("Verify Today Marker is displayed under Graph under Monthly Forecast Page"
	  ); landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(monthlyforecast.isTodayMarkerOnTempGraphDislayed()); }
	  
	  
	  
	
	  @Test(priority = 45) public void TC06_VerifyListViewIconDisplayed() throws
	  InterruptedException {
	  testStart("Verify List View Icon is enabled by default under Monthly Forecast Page"
	  ); 
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(ExpectedForecastPageTitle);
	  forecastpage.clickOnMonthlyTab(); waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000); monthlyforecast.clickOnListViewIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  WebPageLoaded.isDomInteractive(2000);
	  Assert.assertTrue(monthlyforecast.isListViewIconEnabled()); 
	  }
	 
	 
	  
	 
}
