package com.accuweather.glacier.www.searchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.SeachResultsPage;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
import com.chameleon.utils.Randomness;

public class Test_SearchResultsPage extends AccuWeatherBaseTest
{
	private String expectedSearchlocation_URL = "https://qualityassurance.accuweather.com/en/search-locations";
	private String expectedSearchResultPageWithAddedLocation_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=Aspen";
	private String expectedSearchResultPageWithAddedZipcode_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=06901";
	private String expectedSearchResultPageForLocationWithNoMatch_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=rubbish";
	
	private LandingPage landingPage = new LandingPage();
	private SeachResultsPage seachResultsPage = new SeachResultsPage();
	private ThreeDayForecastPage threedayForecastPage = new ThreeDayForecastPage();
	
	@Test(priority=1)
	public void RW_T245_UniversalNavigation_navigateSearchResultPage()
	{
		testStart("Validate user successfullly navigated to search result page");
		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		try
		{
			getDriver().getCurrentUrl().contains(expectedSearchlocation_URL);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void RW_T247_SearchResultPageComponents_verifySearchResultPageWithAddedLocation()
	{
		testStart("Validate user navigated to search result page with added location");
		landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedSearchResultPageWithAddedLocation_URL);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
	
//	@Test(priority=3)
//	public void RW_T247_SearchResultPageComponents_verifyBrowseForLocationIsPresent()
//	{
//		testStart("Verify browse for location CTA is present");
//	    landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
//		//check it once the merge is complete. BrowseForlocation is present browse location class.
//	}
//	
	@Test(priority=4)
	public void RW_T249_Search5DigitNumericZipcode_verifySearchResultPageWithAddedZipcode()
	{
		testStart("Validate user navigated to search result page with added zipcode");
		landingPage.enterZipcodeInSearchFieldAndClick("06901");
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedSearchResultPageWithAddedZipcode_URL);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
//	
//	@Test(priority=5)
//	public void RW_T249_Search5DigitNumericZipcode_verifyBrowseForLocationIsPresent()
//	{
//		testStart("Verify browse for location CTA is present");
//		landingPage.enterZipcodeInSearchFieldAndClick("06901");
		//check it once the merge is complete. BrowseForlocation is present browse location class.
//	}
	
//	@Test(priority=6)
//	public void RW_T250_SearchWith2AlphabeticCharacters_verifyBrowseForLocationIsPresent()
//	{
//		testStart("Verify browse for location CTA is present");
//		landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
		//check it once the merge is complete. BrowseForlocation is present browse location class.
//	}
	
	@Test(priority=7)
	public void RW_T251_SearchForLocationWithoutAnyMatch_verifySearchResultPage()
	{
		testStart("Validate user navigated to expected search result page");
		landingPage.enterZipcodeInSearchFieldAndClick("rubbish");
		try
		{
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedSearchResultPageForLocationWithNoMatch_URL);
		}
		catch(AssertionError ae)
		{
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	}
	
//	@Test(priority=8)
//	public void RW_T251_SearchForLocationWithoutAnyMatch_verifyBrowseForLocationIsPresent()
//	{
//		testStart("Verify browse for location CTA is present");
//		landingPage.enterZipcodeInSearchFieldAndClick("rubbish");
//		check it once the merge is complete. BrowseForlocation is present browse location class.
//	}

	@Test(priority=2)
	public void RW_T252_NavigationTo3dayForecastPageFromSearchResults_navigationTo3dayForecastPage()
	{
		testStart("Validate user navigated to 3 day forecast page when clicked on any of the location from the search results");
		landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
		seachResultsPage.clickLocationFromSearchResults();
		Assert.assertTrue(threedayForecastPage.fourWeathercardisDisplayed());
	}
	
	@Test(priority=2)
	public void RW_T610_NonUSLocations_verifyListofSuggestedLocations()
	{
		testStart("Verify the list of suggested of locations based on the characters entered appears");
		landingPage.enterZipcodeInSearchFieldAndClick("Royal Oak");
		seachResultsPage.verifyListofSuggestedLocations("Royal Oak");
	}
	
	@Test(priority=2)
	public void RW_T609_USLocations_verifyListofSuggestedLocations()
	{
		testStart("Verify the list of suggested of locations based on the characters entered appears");
		landingPage.enterZipcodeInSearchFieldAndClick("Mumbai");
		seachResultsPage.verifyListofSuggestedLocations("Mumbai");
	}
	
}
