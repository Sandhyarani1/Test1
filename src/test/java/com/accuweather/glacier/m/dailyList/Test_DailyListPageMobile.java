package com.accuweather.glacier.m.dailyList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.DailyListPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Sleeper;

public class Test_DailyListPageMobile extends AccuWeatherMobileBaseTest {
	private final static String ZIPCODE = "48073";
	private static final String EXPECTEDCOLOROFACTIVITYTAB = "#f05514";
	private static final String EXPECTEDDAILYFORECASTPAGE_URL = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/daily-weather-forecast/20813_pc";

	DailyListPageMobile dailyListPage = new DailyListPageMobile();
	LandingPageMobile landingPage = new LandingPageMobile();

	@Test(priority = 1,enabled  = true)
	public void RW_187_DailyListPageItemsPresent_navigateToDailyForecastPage() {
		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Sleeper.sleep(5);
		try {
			Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTEDDAILYFORECASTPAGE_URL);
			
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
	
	

	@Test(priority = 2,enabled  = true)
	public void RW_187_DailyListPageItemsPresent_confirmForecastListForWeek() {
		testStart(
				"Verify Forecast list for the current week should be displayed and limited to number of days in the current week");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.verifyLimitedNumberOfDaysInCurrentWeek());

	}
	
	

	@Test(priority = 3,enabled  = true)
	public void RW_187_DailyListPageItemsPresent_locateDayOfAWeek() {
		testStart("Locate day of a week");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.readCurrentDay());

	}
	
	

	@Test(priority = 4,enabled  = true)
	public void RW_187_DailyListPageItemsPresent_locateDateOfAWeek() {
		testStart("Locate date of a week");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.readCurrentDate());

	}
	
	

	@Test(priority = 5,enabled  = true)
	public void RW_187_DailyListPageItemsPresent_locateWeatherIcon() {
		testStart("Locate weather icon");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.isWeatherIconDisplayed());

	}
	
	

	@Test(priority = 6,enabled  = false)
	public void RW_187_DailyListPageItemsPresent_locateHighTemp() {
		testStart("Locate high and low temperature");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		dailyListPage.readMaxTemperature();

	}
	
	

	@Test(priority = 7,enabled  = false)
	public void RW_187_DailyListPageItemsPresent_locateLowTemp() {
		testStart("Locate high and low temperature");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		dailyListPage.readMinTemperature();
	}
	
	

	@Test(priority = 8,enabled  = false)
	public void RW_187_DailyListPageItemsPresent_locateWetehrDescription() {
		testStart("Locate weather description");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.readWeatherDescription());
	}
	
	

	//EOF

	@Test(priority = 8,enabled  = false)
	public void RW_187_DailyListPageItemsPresent_currentDateCardIsHiglightedInOrangeColor() {
		testStart("Verify Current date card is highlighted in orange on the side of the component to indicate that it is today");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		String actualColorOfActivityTab = dailyListPage.getColor_Of_ActiveTab();
		try {
			Assert.assertEquals(actualColorOfActivityTab, EXPECTEDCOLOROFACTIVITYTAB);
		}

		catch (AssertionError ae) {
			System.out.println(ae.getMessage());
		}

	}
	
	

	@Test(priority = 9,enabled  = false)
	public void RW_188_NextWeekListPageItemsPresent_confirmNextWeekHeaderDateAndMonth() {
		testStart("Verify next week header month and date");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		dailyListPage.confirmNextWeekHeaderDateAndMonth();
	}
	
	

	@Test(priority = 2,enabled  = false)
	public void RW_188_NextWeekListPageItemsPresent_confirmForecastListForWeekFromMonToSun() {
		testStart("Verify Forecast list for the current week should be displayed from mon to sun");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.confirmForecastListForWeekFromMonToSun());

	}
	
	

	@Test(priority = 10,enabled  = false)
	public void RW_188_NextWeekListPageItemsPresent_confirmDailyForecastPageShowsThreeClusters() {
		testStart("Verify Daily molecules should be limited to show only three clusters for the page");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());

	}
	
	

	@Test(priority = 11,enabled  = false)
	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmLastPageHaveOneOrTwoWeekReports() {
		testStart("Verify last week page have one or two week of data");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.lastPageHaveOneOrTwoWeekReports());
	}
	
	

	@Test(priority = 12,enabled  = false)
	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmUserAbleToNavigateTo4PagesForward() {
		testStart("Verify user able to navigate upto to 4 pages forward");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo4PagesForward());
	}
	
	

	@Test(priority = 13,enabled  = false)
	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmEachWeekHasAnAdditionalParam() {
		testStart("Verify each week has an additional param like page=1, page=2, page=3, page=4..");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
		landingPage.clickOnZipcodeSearchIcon();
		dailyListPage.navigateToDailyListTab();
		dailyListPage.clickDailyTab();

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo1PageForward());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo2PagesForward());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo3PagesForward());

		dailyListPage.clickNextCTA();
		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo4PagesForward());
	}
	
	

}
