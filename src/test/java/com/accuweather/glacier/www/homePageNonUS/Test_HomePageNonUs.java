package com.accuweather.glacier.www.homePageNonUS;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HomePageNonUS;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;

public class Test_HomePageNonUs extends AccuWeatherBaseTest
{
	String zipcode = "48073";
	String satelliteRadarCountry = "Tokyo, Japan";
	String expectedNavigationMenu = "AHORA";
	String expectedMapTitle = "Radar del tiempo de Estados Unidos";
	String expectedMapTitleOfSatelliteRadarCountry = "Radar del tiempo de Japón";
	String expectedMapCTA = "MÁS MAPAS";
	String satelliteCountry = "Buenos Aires, Argentina";
	String expectedMapTitleOfSatelliteCountry = "Argentina Satellite";
	String expectedSatelliteMapCTA = "MORE MAPS";
	String expectedMapTitleOfRadarCountry = "Japan Weather Radar";
	String expectedMapTitleOfUS = "United States Weather Radar";
	
	private LandingPage landingPage = new LandingPage();
	private NavigationBar navBar = new NavigationBar();
	private HomePageNonUS homePage = new HomePageNonUS();
	private ThreeDayForecastPage threedayForecastPage = new ThreeDayForecastPage();
	
	@Test(priority=1)
	public void RW_T745_ValidateTranslationOnBreadcrumbs_verifyCityPageTranslatedInSelectedLanguage()
	{
		testStart("Verify city page get translated in selected langauge");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		navBar.clickSettingsIcon();
		String actualMenu = homePage.verifyCityPageTranslatedInSelectedLanguage();
		try
		{
			Assert.assertEquals(expectedNavigationMenu, actualMenu);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=2)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyMapTitleNonEnglishLanguage()
	{
		testStart("Verify map title is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		navBar.clickSettingsIcon();
	    homePage.changeLanguage();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		try
		{
			Assert.assertEquals(expectedMapTitle, actualMapTitle);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=3)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyMapsCTANonEnglishLanguage()
	{
		testStart("Verify map cta is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		navBar.clickSettingsIcon();
		homePage.changeLanguage();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		try
		{
			Assert.assertEquals(expectedMapCTA, actualMapCTA);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=4)
	public void RW_T743_HomePageWithNonEnglishValidation_verify20LocationsOfCountry()
	{
		testStart("Change the language to non-english and verify 20 locations of the country");
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verify20LocationsOfCountry());
	}
	
	@Test(priority=5)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyWeathericonForAllLocationsOfCountry()
	{
		testStart("Verify weather for all 20 locations of the country");
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verifyWeathericonForAllLocationsOfCountry());
	}
	
	@Test(priority=6)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyTemperatureForAllLocationsOfCountry()
	{
		testStart("Verify temperature for all 20 locations of the country");
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verifyTemperatureForAllLocationsOfCountry());
	}
	
	@Test(priority=7)
	public void RW_T743_HomePageWithNonEnglishValidation_clickAnyLocationAndUserNavigatedTo3DayForecastPage()
	{
		testStart("Click one of the locations and verify user navigated to three day forecast page");
		navBar.clickSettingsIcon();
		homePage.changeLanguage();
		homePage.clickLocation();
		Assert.assertTrue(threedayForecastPage.fourWeathercardisDisplayed());
	}
	
	@Test(priority=8)
	public void RW_T741_SatelliteAndRadarCountry_verifyMapTitleIsNonEnglishLanguage()
	{
		testStart("Verify map title is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		homePage.changeLanguage();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		try
		{
			Assert.assertEquals(expectedMapTitleOfSatelliteRadarCountry, actualMapTitle);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=9)
	public void RW_T741_SatelliteAndRadarCountry_verifyMapsCTANonEnglishLanguage()
	{
		testStart("Verify map cta is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		homePage.changeLanguage();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		try
		{
			Assert.assertEquals(expectedMapCTA, actualMapCTA);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=10)
	public void RW_T741_SatelliteAndRadarCountry_verify20LocationsOfCountry()
	{
		testStart("Change the language to non-english and verify 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verify20LocationsOfCountry());
	}
	
	@Test(priority=11)
	public void RW_T741_SatelliteAndRadarCountry_verifyWeathericonForAllLocationsOfCountry()
	{
		testStart("Verify weather for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verifyWeathericonForAllLocationsOfCountry());
	}
	
	@Test(priority=12)
	public void RW_T741_SatelliteAndRadarCountry_verifyTemperatureForAllLocationsOfCountry()
	{
		testStart("Verify temperature for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		Assert.assertTrue(homePage.verifyTemperatureForAllLocationsOfCountry());
	}
	
	@Test(priority=13)
	public void RW_T741_SatelliteAndRadarCountry_clickAnyLocationAndUserNavigatedTo3DayForecastPage()
	{
		testStart("Click one of the locations and verify user navigated to three day forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.clickSettingsIcon();
		homePage.changeLanguage();
		homePage.clickLocation();
		Assert.assertTrue(threedayForecastPage.fourWeathercardisDisplayed());
	}
	
	@Test(priority=14)
	public void RW_T740_SatelliteCountryEnglish_verifyMapTitleIsEnglishLanguage()
	{
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteCountry);
		navBar.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		try
		{
			Assert.assertEquals(expectedMapTitleOfSatelliteCountry, actualMapTitle);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=15)
	public void RW_T740_SatelliteCountryWithEnglish_verifyMapsCTAIsEnglishLanguage()
	{
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteCountry);
		navBar.navigateToHomePageByLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		try
		{
			Assert.assertEquals(expectedSatelliteMapCTA, actualMapCTA);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=16)
	public void RW_T739_RadarCountryCountryWithEnglish_verifyMapTitleIsEnglishLanguage()
	{
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		try
		{
			Assert.assertEquals(expectedMapTitleOfRadarCountry, actualMapTitle);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=17)
	public void RW_T739_RadarCountryCountryWithEnglish_verifyMapsCTAIsEnglishLanguage()
	{
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		navBar.navigateToHomePageByLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		try
		{
			Assert.assertEquals(expectedSatelliteMapCTA, actualMapCTA);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=18)
	public void RW_T742_UsHomePageWithEnglish_verifyMapTitleIsEnglishLanguage()
	{
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		navBar.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		try
		{
			Assert.assertEquals(expectedMapTitleOfUS, actualMapTitle);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
	
	@Test(priority=19)
	public void RW_T742_UsHomePageWithEnglish_verifyMapsCTAIsEnglishLanguage()
	{
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		navBar.navigateToHomePageByLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		try
		{
			Assert.assertEquals(expectedSatelliteMapCTA, actualMapCTA);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
		
	}
}
