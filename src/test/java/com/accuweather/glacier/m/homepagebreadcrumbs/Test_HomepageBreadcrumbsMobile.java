package com.accuweather.glacier.m.homepagebreadcrumbs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.HomepageBreadcrumbsMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;

public class Test_HomepageBreadcrumbsMobile extends AccuWeatherMobileBaseTest {

	String zipCode = "16803";
	String expectedHomePageTitle = "Weather Forecast Search - Find Your Location - AccuWeather.com";

	private static final String FOOTER_BREAD_CRUMB = "Footer breadcrumb";
	private static final String BREAD_CRUMB_WORLD = "Breadcrumb World";
	private static final String FOOTER_BREAD_REGION = "Breadcrumb Region";
	private static final String FOOTER_BREAD_COUNTRY = "Breadcrumb Country";
	private static final String FOOTER_BREAD_STATE = "Breadcrumb State";
	private static final String FOOTER_BREAD_CITY = "Breadcrumb City";

	String expectedWorldForecastTitle = "https://qualityassurance.accuweather.com/en/world-weather";
	String expectedRegionForecastTitle = "https://qualityassurance.accuweather.com/en/north-america-weather";
	String expectedCountryForecastTitle = "https://qualityassurance.accuweather.com/en/us/united-states-weather";
	String expectedStateForecastTitle = "https://qualityassurance.accuweather.com/en/us/pa/pennsylvania-weather";
	String expectedCityForecastTitle = "https://qualityassurance.accuweather.com/en/us/state-college/16803/weather-forecast/6789_pc";

	private LandingPageMobile landingPage = new LandingPageMobile();
	private HomepageBreadcrumbsMobile breadcrumbs = new HomepageBreadcrumbsMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T196_navigation_To_Homepage_Verfiying_footer_breadcrumbs_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed on Homepage");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_CRUMB));
	}

	@Test(priority = 2, enabled = true)
	public void RW_T197_validating_Footer_Breadcrumbs_for_World_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed for World");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_WORLD));
	}

	@Test(priority = 3, enabled = true)
	public void RW_T198_validating_Footer_Breadcrumbs_for_Region_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed for Region");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_REGION));
	}

	@Test(priority = 4, enabled = true)
	public void RW_T199_validating_Footer_Breadcrumbs_for_Country_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed for Country");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_COUNTRY));
	}

	@Test(priority = 5, enabled = true)
	public void RW_T200_validating_Footer_Breadcrumbs_for_State_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed for State");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_STATE));
	}

	@Test(priority = 6, enabled = false)
	public void RW_T196_validating_Footer_Breadcrumbs_for_City_Displayed() throws InterruptedException {
		testStart("Validate footer breadcrumbs displayed for City");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		Assert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(FOOTER_BREAD_CITY));
	}

	@Test(priority = 7, enabled = false)
	public void RW_T197_valdating_URL_when_clicked_on_Worldbreadcrumb() {
		testStart("Validating user redirected url when clicked on World ");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.scrolldownpage();
		breadcrumbs.isclickonFooterBreadcrumb(BREAD_CRUMB_WORLD);
		System.out.println("clicked on World breadcrump");
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedWorldForecastTitle);
	}

	@Test(priority = 8, enabled = false)
	public void RW_T199_valdating_URL_when_clicked_on_RegionBreadcrumb() {
		testStart("Validating user redirected url when clicked on region");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_REGION);
		breadcrumbs.scrolldownpage();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegionForecastTitle);
	}

	@Test(priority = 9, enabled = false)
	public void RW_T200_valdating_URL_when_clicked_on_CountryBreadcrumb() {
		testStart("Validating user redirected url when clicked on Country");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_COUNTRY);
		breadcrumbs.scrolldownpage();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedCountryForecastTitle);
	}

	@Test(priority = 10, enabled = false)
	public void RW_T200_valdating_URL_when_clicked_on_StateBreadcrumb() {
		testStart("Validating user redirected url when clicked on State");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_STATE);
		breadcrumbs.scrolldownpage();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedStateForecastTitle);
	}

	@Test(priority = 11, enabled = false)
	public void RW_T201_valdating_URL_when_clicked_on_CityBreadcrumb() {
		testStart("Validating user redirected url when clicked on City");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		breadcrumbs.isclickonFooterBreadcrumb(FOOTER_BREAD_CITY);
		breadcrumbs.scrolldownpage();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedCityForecastTitle);
	}
}
