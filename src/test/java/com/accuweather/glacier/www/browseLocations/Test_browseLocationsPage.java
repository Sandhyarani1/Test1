package com.accuweather.glacier.www.browseLocations;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.BrowseLocations;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Randomness;

public class Test_browseLocationsPage extends AccuWeatherBaseTest {
	private String expectedBrowseLocation_URL = "https://qualityassurance.accuweather.com/en/browse-locations";
	private String expectedWorldWeather_URL = "https://qualityassurance.accuweather.com/en/world-weather";
	private String expectedWorldRegion_URL = "https://qualityassurance.accuweather.com/en/browse-locations";
	private String expectedWorldWeatherCTAColour = "#f59721";
	private String expectedRegion_URL = "https://qualityassurance.accuweather.com/en/browse-locations/asi";
	private String expectedCountry_URL = "https://qualityassurance.accuweather.com/en/browse-locations/asi/in";
	private LandingPage landingPage = new LandingPage();
	private BrowseLocations browseLocationPage = new BrowseLocations();
	
	@Test(priority = 1)
	public void RW_T211_navigation_To_Browse_Location_Page()
	{
		testStart("Navigate to Browse for a Location page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedBrowseLocation_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Browse for a location URL is not matching as the expected");
		}
	}
	/*
	@Test(priority = 2)
	public void RW_T212_verify_List_of_Regions_On_Browse_Location_Page()
	{
		testStart("Verify the list of regions on Browse Location page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
	    Assert.assertTrue(browseLocationPage.verifyRegionsInBrowserLocationPage());
	}
	
	@Test(priority = 3)
	public void RW_T213_WorldWeatherCTA_navigationToWorldWeatherPage()
	{
		testStart("Navigate to World Weather page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickWorldWeatherCTA();
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedWorldWeather_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("World Weather URL is not matching as the expected");
		}
	}
	
	@Test(priority = 4)
	public void RW_T213_WorldWeatherCTA_verifyWorldWeatherCTABackgroundColor()
	{
		testStart("Verify World Weather CTA is present below the list of regions in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		String actualWorldWeatherCTAColour = browseLocationPage.verifyWorldWeatherCTABackgroundColor();
		try
		{
			Assert.assertEquals(actualWorldWeatherCTAColour, expectedWorldWeatherCTAColour);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("World Weather CTA color is not matching as the expected");
		}
	}
	
	@Test(priority = 5)
	public void RW_T213_WorldWeatherCTA_verifyWorldWeatherCTAArrow()
	{
		testStart("Verify World Weather CTA arrow");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
	    Assert.assertTrue(browseLocationPage.verifyWorldWeatherCTAArrow());
	}
	
	@Test(priority = 6)
	public void RW_T214_ContinentLevel_navigateToSelectedRegionPage()
	{
		testStart("Click on of the regions and verify the user navigated to selected region");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegion_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Browse for a location region URL is not matching as the expected");
		}
	}
	
	@Test(priority = 7)
	public void RW_T214_ContinentLevel_verifyWorldRegionAppearAboveSelectedRegion()
	{
		testStart("Verify world region should appear above the header with region selected");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		Assert.assertTrue(browseLocationPage.verifyWorldRegionAboveSelectedRegion());
	}
	
	@Test(priority = 8)
	public void RW_T214_ContinentLevel_verifySelectedRegionAppearBelowWorldRegion()
	{
		testStart("Verify selected region should appear below world region");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		Assert.assertTrue(browseLocationPage.verifySelectedRegionAppearBelowWorldRegion());
	}
	
	@Test(priority = 9)
	public void RW_T214_ContinentLevel_verifySelectedRegionWeatherCTAColor()
	{
		testStart("Verify Weather CTA is present below the list of regions in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		String actualWeatherCTAColour = browseLocationPage.verifyWeatherCTABackgroundColor();
		try
		{
			Assert.assertEquals(actualWeatherCTAColour, expectedWorldWeatherCTAColour);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Weather CTA color is not matching as the expected");
		}
	}
	
	@Test(priority = 10)
	public void RW_T214_ContinentLevel_weatherCTAArrow()
	{
		testStart("Verify seleceted region Weather CTA arrow");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    Assert.assertTrue(browseLocationPage.verifyWeatherCTAArrow());
	}
	
	@Test(priority = 11)
	public void RW_T214_ContinentLevel_verifyListOfRegionsFromSelectedRegion()
	{
		testStart("Verify the list of regions on from selected region");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    Assert.assertTrue(browseLocationPage.verifyListOfRegionsFromSelectedRegion());
	}
	
	@Test(priority = 12)
	public void RW_T214_ContinentLevel_navigationToWorldRegionPage()
	{
		testStart("Navigate to World Region page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		browseLocationPage.clickWorldRegionsCTA();
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedWorldRegion_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("World Regions URL is not matching as the expected");
		}
	}
	
	@Test(priority = 13)
	public void RW_T215_CountryLevel_verifyContinentAppearAboveSelectedCountry()
	{
		testStart("Verify continent should appear above the header with Country selected");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		Assert.assertTrue(browseLocationPage.verifyContinentApperaAboveCountrySelected());
	}
	
	@Test(priority = 14)
	public void RW_T215_CountryLevel_verifyCountryAppearBelowWorldContinent()
	{
		testStart("Verify country should appear below the continent");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		Assert.assertTrue(browseLocationPage.verifyCountryAppearBelowContinent());
	}
	
	@Test(priority = 15)
	public void RW_T215_CountryLevel_verifyListOfStatesFromCountry()
	{
		testStart("Verify the list of states on from selected country");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    Assert.assertTrue(browseLocationPage.verifyListOfStatesFromSelectedCountry());
	}
	
	@Test(priority = 16)
	public void RW_T215_CountryLevel_verifyCountryWeatherCTABackgroundColor()
	{
		testStart("Verify country Weather CTA is present below the list of states in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
		String actualCountryWeatherCTAColour = browseLocationPage.verifyCountryWeatherCTABackgroundColor();
		try
		{
			Assert.assertEquals(actualCountryWeatherCTAColour, expectedWorldWeatherCTAColour);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Country Weather CTA color is not matching as the expected");
		}
	}
	
	@Test(priority = 17)
	public void RW_T215_CountryLevel_verifyCountryWeatherCTAArrow()
	{
		testStart("Verify country weather CTA arrow");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    Assert.assertTrue(browseLocationPage.verifyCountryWeatherCTAArrow());
	}
	
	@Test(priority = 18)
	public void RW_T215_CountryLevel_navigateToContinentPage()
	{
		testStart("Click on of the continent CTA and verify the user navigated to world region page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		browseLocationPage.clcikCountryFromAContinent();
		browseLocationPage.clickContinentCTA();
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegion_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Continent URL is not matching as the expected");
		}
	}
	
	@Test(priority = 19)
	public void RW_T216_StateLevel_verifyCountryAppearAboveSelectedState()
	{
		testStart("Verify country should appear above the header with selected state");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		browseLocationPage.clcikCountryFromAContinent();
		browseLocationPage.clcikStateFromCountry();
		browseLocationPage.verifyCountryApperaAboveStateSelected();
	}
	
	@Test(priority = 20)
	public void RW_T216_StateLevel_verifyStateAppearBelowCountry()
	{
		testStart("Verify state should appear below country");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		browseLocationPage.clcikCountryFromAContinent();
		browseLocationPage.clcikStateFromCountry();
		browseLocationPage.verifyStateAppearBelowCountry();
	}
	
	@Test(priority = 21)
	public void RW_T216_StateLevel_verifyListOfCitiesFromState()
	{
		testStart("Verify list of cities from selected state");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    browseLocationPage.clcikStateFromCountry();
	    Assert.assertTrue(browseLocationPage.verifyListOfCitiesFromSelectedState());
	}
	
	@Test(priority = 22)
	public void RW_T216_StateLevel_verifyStateWeatherCTABackgroundColor()
	{
		testStart("Verify country Weather CTA is present below the list of states in orange");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    browseLocationPage.clcikStateFromCountry();
		String actualStateWeatherCTAColour = browseLocationPage.verifyStateWeatherCTABackgroundColor();
		try
		{
			Assert.assertEquals(actualStateWeatherCTAColour, expectedWorldWeatherCTAColour);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("State Weather CTA color is not matching as the expected");
		}
	}
	
	@Test(priority = 23)
	public void RW_T216_StateLevel_verifyStateWeatherCTAArrow()
	{
		testStart("Verify country weather CTA arrow");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    browseLocationPage.clcikStateFromCountry();
	    Assert.assertTrue(browseLocationPage.verifyCountryWeatherCTAArrow());
	}
	
	@Test(priority = 24)
	public void RW_T216_StateLevel_navigateToContinentPage()
	{
		testStart("Click on of the country CTA and verify the user navigated to continent page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
		browseLocationPage.clcikCountryFromAContinent();
		browseLocationPage.clcikStateFromCountry();
		browseLocationPage.clickContinentCTA(); 
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedCountry_URL);
		}
		catch (AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail("Country URL is not matching as the expected");
		}
	}
	 
	@Test(priority = 25)
	public void RW_T217_CityLevel_verifyThreeDayForecastPage()
	{
		testStart("Verify the user directed to three day forecast page of the city");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		browseLocationPage.isBrowseForLocationPresent();
		browseLocationPage.clickBrowseForLocationCTA();
		browseLocationPage.clickARegion();
	    browseLocationPage.clcikCountryFromAContinent();
	    browseLocationPage.clcikStateFromCountry();
	    Assert.assertTrue(browseLocationPage.verifyThreedayWeatherCard());
	}*/
}
