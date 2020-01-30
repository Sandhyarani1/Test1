package com.accuweather.glacier.www.Localizations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.Localizations;
import com.accuweather.glacier.www.pages.NavigationBar;


public class Test_Localization extends AccuWeatherBaseTest
{
	String location = "Mumbai, MH, IN";
	String submenuTitle = "Weather News";
	private String expectedMapsSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
	private String expectedSatelliteSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
	private String expectedSevereSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/br/national/severe-weather-maps";
	private String expectedSatelliteImage_URL = "https://qualityassurance.accuweather.com/en/br/national/satellite";
	private String expectedMapsDescription = "Visualize past, present, and future weather from many angles via both static and interactive maps";
	private String expectedSatelliteDescription = "Satellite maps for visualizing where there is cloud cover and associated precipitation";
	private String expectedSevereDescription = "Currently active global watches and warnings, lightning, and severe weather risk";
	private String expectedSatelliteSubMenuMapTitle = "Brazil Satellite Image";
	private String expectedSatelliteSubMenuMapDescription = "Current satellite image showing cloud coverage";
	
	SoftAssert softAssert;
	Localizations localization = new Localizations();
	LandingPage landingPage = new LandingPage();
	private NavigationBar navBar = new NavigationBar();
	
	@Test(priority=4,enabled=true)
	public void RW_T230_verifyTopLevelNavigationAndSubcategoryForCountriesWhereRadarIsNotAvailable()
	{
		softAssert = new SoftAssert();
		testStart("Top level Nav and Maps sub category for countries where Radar is not available ");

		/****************Validate Maps category is present on top level naviagtion***************************************/
		landingPage.enterZipcodeInSearchField(location);
		landingPage.clickOnZipcodeSearchIcon();
		softAssert.assertTrue(localization.isMapsPresent(),
				"Issue-----> Maps category is not present on the top level navigation");

		
		/****************Validate Maps submenu on the city forecast page***************************************/
		navBar.mouseHoverOnMaps();
		softAssert.assertTrue(localization.isCityForecastMapCategoriesPresent(),
				"Issue-----> Maps submenus like Maps, Satellite and  Satellite Image are not present");
		
		
		/****************Validate description of Map submenu under Maps category on top level navigation*************************************************/
		softAssert.assertEquals(navBar.getMapsSubmenuDescription(), expectedMapsDescription, 
				"Issue-----> Maps description under Maps category on top level navigation is not matching as expected");
		
		/****************Verify Satellite submenu description under Maps category on top level navigation*************************************************/
		softAssert.assertEquals(navBar.getSatelliteSubmenuDescription(), expectedSatelliteDescription, 
				"Issue-----> Satellite description under Maps category on top level navigation is not matching as expected");
		
		
		/****************Click the URL of Maps submenu under Maps category on top level navigation and verify URL*************************************************/
		navBar.clickOnMapsSubMenu();
		waitUntilWindowExistsWithTitle(submenuTitle);
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedMapsSubmenuPage_URL, 
				"Issue-----> Maps URL under Maps category on top level navigation is not matching as expected");
		
		/****************Click the URL of Satellite submenu under Maps category on top level navigation and verify URL*************************************************/
		
		navBar.navigateToHomePageByLogo();
		landingPage.enterZipcodeInSearchField(location);
		landingPage.clickOnZipcodeSearchIcon();
		localization.isMapsPresent();
		navBar.mouseHoverOnMaps();
		navBar.isSatelliteSubMenuDisplayed();
		navBar.clickOnSatelliteSubMenu();
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteSubmenuPage_URL, 
				"Issue-----> Satellite URL under Maps category on top level navigation is not matching as expected");
	
		
		softAssert.assertAll();
	}
	
	@Test(priority=1,enabled=true)
	public void RW_T232_verifyCountryWithSevereSubcategoriesUnderMaps()
	{
		testStart("API Validation of Severe submenu and Satellite under maps Elements");
		softAssert = new SoftAssert();
		
		/****************Validate severe submenu under radar&maps***************************************/
		
		landingPage.enterZipcodeInSearchField("Munich, Germany");
		landingPage.clickOnZipcodeSearchIcon();
		navBar.mouseHoverOnRadarAndMaps();
		softAssert.assertTrue(navBar.isSeverSubMenuDisplayed(),
				"Issue-----> Severe submenu is not found under maps category");

		
		/****************Validate severe submenu description***************************************/
		
		navBar.navigateToHomePageByLogo();
		landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
		landingPage.clickOnZipcodeSearchIcon();
		navBar.mouseHoverOnMaps();
		softAssert.assertEquals(navBar.getSevereSubmenuDescription(), expectedSevereDescription,
				"Issue-----> Severe submenu is not matching as expected");
		
		/****************Verify severe submenu URL*************************************************/
		
		navBar.isSeverSubMenuDisplayed();
		navBar.navigateToSevereTab();
		waitUntilWindowExistsWithTitle(submenuTitle);
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedSevereSubmenuPage_URL, 
				"Issue-----> Severe submenu URl is matching as expected");
		
		/******************** Verify satellite submenu map title *********************************/
		
		navBar.navigateToHomePageByLogo();
		landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
		landingPage.clickOnZipcodeSearchIcon();
		navBar.mouseHoverOnMaps();
		waitUntilWindowExistsWithTitle(submenuTitle);
		softAssert.assertEquals(localization.getSatelliteSubMenuMapTitle(), expectedSatelliteSubMenuMapTitle, 
				"Issue-----> Satellite submenu map title is not matching");
		
        /******************** Verify satellite submenu map description *********************************/
		
		softAssert.assertEquals(localization.getSatelliteSubMenuMapDescription(), expectedSatelliteSubMenuMapDescription, 
				"Issue-----> Satellite submenu description is matching as expected");
		
        /******************** Verify satellite submenu URL *********************************/
		
		localization.clickSatelliteImageDescription();
		softAssert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteImage_URL, "Issue-----> Satellite submenu URl is matching as expected");
		
		softAssert.assertAll();
	}

	@Test(priority=2,enabled=true)
	public void RW_T233_verifyPrescenceOfMinuteCast()
	{
		softAssert = new SoftAssert();
		testStart("Verify prescence of minutecast tab present for countries like US and UK");
		landingPage.enterZipcodeInSearchField("Royal oak,Mi,US");
		landingPage.clickOnZipcodeSearchIcon();
		softAssert.assertTrue(localization.isMinutecastPresent(),
				"Issue-----> MinuteCast tab is not showing on city page");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3,enabled=true)
	public void RW_T235_changeTenperatureSettingsToCelsiusToFahrenheit()
	{
		softAssert = new SoftAssert();
		testStart("Change the temperature Settings to Celsius from Fahrenheit");
		navBar.clickSettingsIcon();
		softAssert.assertTrue(localization.changeTemperatureFromFarenheitToCelcius(),
				"Issue-----> Unable to change from C to F");
		
		softAssert.assertAll();
	}
	
	@Test(priority=4,enabled=true)
	public void RW_T238_verifyCountriesWithSevereWeatherNavigation()
	{
   	    softAssert = new SoftAssert();
		testStart("Countries with Severe Weather alerts ON should see Severe Weather navigation");
		landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
		landingPage.clickOnZipcodeSearchIcon();
		softAssert.assertTrue(navBar.isSevereWeatherDisplayed(),
				"Issue-----> Severe Weather is not present on the top level navigation for the countries that has severe weather alert ON");
		
		softAssert.assertAll();
	}
	

	@Test(priority = 5)
	public void RW_T234__verfiyAbscenceOfMinuteCast()
	{
	    softAssert = new SoftAssert();
		testStart("Verify the abscence of minutecast on city forecast page");
		landingPage.enterZipcodeInSearchField("Mumbai, MH, IN");
		landingPage.clickOnZipcodeSearchIcon();
		softAssert.assertFalse(localization.isMinutecastPresent(),
				"Issue-----> Minutecast is present for countries like India");
		
		softAssert.assertAll();
	}
	
}
