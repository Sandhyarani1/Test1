package com.accuweather.glacier.www.dailyList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.DailyForeCastPage;
import com.accuweather.glacier.www.pages.DailyListPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class Test_DailyListPage extends AccuWeatherBaseTest
{
	private final static String ZIPCODE = "48073";
	private static final String EXPECTEDCOLOROFACTIVITYTAB  = "#f05514";
	private static final String EXPECTEDDAILYFORECASTPAGE_URL = "https://qualityassurance.accuweather.com/en/us/royal-oak/48073/daily-weather-forecast/20813_pc";
	
	DailyListPage dailyListPage = new DailyListPage();
	NavigationBar navigationbar = new NavigationBar();
	LandingPage landingPage = new LandingPage();
	DailyForeCastPage dailyForeCastPage = new DailyForeCastPage();
//	
//	@Test(priority=1)
//	public void RW_187_DailyListPageItemsPresent_navigateToDailyForecastPage()
//	{
//		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		try
//		{
//			Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTEDDAILYFORECASTPAGE_URL);
//		}
//		catch (AssertionError ae)
//		{
//			System.err.println(ae.getMessage());
//			Assert.fail();
//		}
//	}
//	
//	@Test(priority=2)
//	public void RW_187_DailyListPageItemsPresent_confirmForecastListForWeek()
//	{
//		testStart("Verify Forecast list for the current week should be displayed and limited to number of days in the current week");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyListPage.verifyLimitedNumberOfDaysInCurrentWeek());
//		
//	}
//	
//	@Test(priority=3)
//	public void RW_187_DailyListPageItemsPresent_locateDayOfAWeek()
//	{
//		testStart("Locate day of a week");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyForeCastPage.readCurrentDay());
//		
//	}
//	
//	@Test(priority=3)
//	public void RW_187_DailyListPageItemsPresent_locateDateOfAWeek()
//	{
//		testStart("Locate date of a week");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyForeCastPage.readCurrentDate());
//		
//	}
//	
//	@Test(priority=4)
//	public void RW_187_DailyListPageItemsPresent_locateWeatherIcon()
//	{
//		testStart("Locate weather icon");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyForeCastPage.isWeatherIconDisplayed());
//		
//	}
//	
//	@Test(priority=5)
//	public void RW_187_DailyListPageItemsPresent_locateHighTemp()
//	{
//		testStart("Locate high and low temperature");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		dailyForeCastPage.readMaxTemperature();
//		
//	}
//	
//	@Test(priority=5)
//	public void RW_187_DailyListPageItemsPresent_locateLowTemp()
//	{
//		testStart("Locate high and low temperature");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		dailyForeCastPage.readMinTemperature();
//		
//	}
//	
//	@Test(priority=5)
//	public void RW_187_DailyListPageItemsPresent_locateWetehrDescription()
//	{
//		testStart("Locate weather description");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		dailyForeCastPage.readWeatherDescription();
//		
//	}
//	
//	@Test(priority=5)
//	public void RW_187_DailyListPageItemsPresent_locatePrecipitation()
//	{
//		testStart("Locate weather precipitation");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		dailyForeCastPage.readPrecipText();
//		
//	}
//	
//	@Test(priority=5)
//	public void RW_187_DailyListPageItemsPresent_currentDateCardIsHiglightedInOrangeColor()
//	{
//		testStart("Verify Current date card is highlighted in orange on the side of the component to indicate that it is today");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		String actualColorOfActivityTab = dailyForeCastPage.getColor_Of_ActiveTab();
//		try
//		{
//			Assert.assertEquals(actualColorOfActivityTab, EXPECTEDCOLOROFACTIVITYTAB);
//		}
//
//		catch (AssertionError ae)
//		{
//			System.out.println(ae.getMessage());
//		}
//		
//	}
	
//	@Test(priority=6)
//	public void RW_188_NextWeekListPageItemsPresent_confirmNextWeekHeaderDateAndMonth()
//	{
//		testStart("Verify next week header month and date");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		dailyListPage.getTextOfAllValueFromFirstWeekClusterOnDailyPage();
//	    dailyListPage.compareNextWeekHeaderArraylists();
	}
	
//	@Test(priority=2)
//	public void RW_188_NextWeekListPageItemsPresent_confirmForecastListForWeekFromMonToSun()
//	{
//		testStart("Verify Forecast list for the current week should be displayed from mon to sun");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyListPage.confirmForecastListForWeekFromMonToSun());
//		
//	}
	
//	@Test(priority=2)
//	public void RW_188_NextWeekListPageItemsPresent_confirmDailyForecastPageShowsThreeClusters()
//	{
//		testStart("Verify Daily molecules should be limited to show only three clusters for the page");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		
//	}
//	
//	@Test(priority=2)
//	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmLastPageHaveOneOrTwoWeekReports()
//	{
//		testStart("Verify last week page have one or two week of data");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		
//		dailyForeCastPage.clickNextCTA();
//
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.lastPageHaveOneWeekReports());
//	}
//	
//	@Test(priority=2)
//	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmUserAbleToNavigateTo4PagesForward()
//	{
//		testStart("Verify user able to navigate upto to 4 pages forward");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmDailyForecastPageShowsThreeClusters());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo4PagesForward());
//	}
//	
//	@Test(priority=2)
//	public void RW_189_NextweekActionDisplaysFutureWeekInformation_confirmEachWeekHasAnAdditionalParam()
//	{
//		testStart("Verify each week has an additional param like page=1, page=2, page=3, page=4..");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		dailyForeCastPage.clickDailyTab();
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo1PageForward());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo2PagesForward());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo3PagesForward());
//		
//		dailyForeCastPage.clickNextCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo4PagesForward());
//		
//		dailyListPage.clickPreviousCTA();
//		Assert.assertTrue(dailyListPage.confirmUserAbleToNavigateTo4PagesForward());
//		Assert.assertTrue(dailyListPage.verifyBothNextAndCTAPresentInNextPage());
//	}
//	
//}
