package com.accuweather.glacier.www.homepagebreadcrumbs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HomepageBreadcrumbs;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;

public class Test_HomepageBreadcrumbs extends AccuWeatherBaseTest {
	
	String zipCode = "16803";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";

	private static final String  FOOTER_BREAD_CRUMB="Footer breadcrumb";
	private static final String  BREAD_CRUMB_WORLD="Breadcrumb World";
	private static final String  FOOTER_BREAD_REGION="Breadcrumb Region";
	private static final String  FOOTER_BREAD_COUNTRY="Breadcrumb Country";
	private static final String  FOOTER_BREAD_STATE ="Breadcrumb State";
	private static final String  FOOTER_BREAD_CITY="Breadcrumb City";
	
	String expectedWorldForecastTitle = "https://qualityassurance.accuweather.com/en/world-weather";
	String expectedRegionForecastTitle = "https://qualityassurance.accuweather.com/en/north-america-weather";
	String expectedCountryForecastTitle = "https://qualityassurance.accuweather.com/en/us/united-states-weather";
	String expectedStateForecastTitle = "https://qualityassurance.accuweather.com/en/us/pa/pennsylvania-weather";
	String expectedCityForecastTitle = "https://qualityassurance.accuweather.com/en/us/state-college/16803/weather-forecast/6789_pc";
			
	private LandingPage landingPage = new LandingPage();
	private HomepageBreadcrumbs breadcrumbs = new HomepageBreadcrumbs();
	
	
	@Test(priority=1,enabled = true)
	public void TC1_navigation_To_Homepage_Verfiying_footer_breadcrumbs_Displayed()
	{
		
		testStart("Validate footer breadcrumbs displayed on Homepage" );
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
    	waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_CRUMB));
	}
	
	@Test(priority=2,enabled = true)
	public void TC1_validating_Footer_Breadcrumbs_for_World_Displayed()
	{
		testStart("Validate footer breadcrumbs displayed for World");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
   	    waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_WORLD));
	}
	
	@Test(priority=3,enabled = true)
	public void TC1_validating_Footer_Breadcrumbs_for_Region_Displayed()
	{
		testStart("Validate footer breadcrumbs displayed for Region");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_REGION));
	}
	
	@Test(priority=4,enabled = true)
	public void TC1_validating_Footer_Breadcrumbs_for_Country_Displayed()
	{
		testStart("Validate footer breadcrumbs displayed for Country");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_COUNTRY));
	}
	
	@Test(priority=5,enabled = true)
	public void TC1_validating_Footer_Breadcrumbs_for_State_Displayed()
	{
		testStart("Validate footer breadcrumbs displayed for State");
		getDriver().manage().deleteAllCookies();
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_STATE));
	}
	
	@Test(priority=6,enabled = true)
	public void TC1_validating_Footer_Breadcrumbs_for_City_Displayed()
	{
		testStart("Validate footer breadcrumbs displayed for City");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		Sleeper.sleep(3);
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_CITY));
	}
	
	@Test(priority=7,enabled = true)
	public void TC2_valdating_URL_when_clicked_on_Worldbreadcrumb()
	{
		testStart("Validating user redirected url when clicked on World ");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
    	waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(BREAD_CRUMB_WORLD);
		Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedWorldForecastTitle);
	}
		
	@Test(priority=8,enabled = true)
	public void TC4_valdating_URL_when_clicked_on_RegionBreadcrumb()
	{
		testStart("Validating user redirected url when clicked on Country");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_REGION);
		waitUntilElementIsDisplayedOrClickable();
	    Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegionForecastTitle);
	}
	
	@Test(priority=9,enabled = true)
	public void TC5_valdating_URL_when_clicked_on_CountryBreadcrumb()
	{
		testStart("Validating user redirected url when clicked on Country");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_COUNTRY);
        Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedCountryForecastTitle);
	}
	
	
	@Test(priority=	10,enabled = true)
	public void TC5_valdating_URL_when_clicked_on_StateBreadcrumb()
	{
		testStart("Validating user redirected url when clicked on State");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_STATE);
		WebPageLoaded.isDomComplete(8000);
	     Sleeper.sleep(3);
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedStateForecastTitle);
	}
	

	@Test(priority=11,enabled = true)
	public void TC6_valdating_URL_when_clicked_on_CityBreadcrumb()
	{
		testStart("Validating user redirected url when clicked on City");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilWindowExistsWithTitle(expectedHomePageTitle);
		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_CITY);
	    Sleeper.sleep(3);
		System.out.println("Landing page URL is >>>"+getDriver().getCurrentUrl());
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedCityForecastTitle);
	}
}
