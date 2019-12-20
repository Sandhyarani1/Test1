package com.accuweather.glacier.m.SearchResultsPage;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.SeachResultsPageMobile;

import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.accuweather.glacier.www.AccuWeatherBaseTest;
	import com.accuweather.glacier.www.pages.LandingPage;
	import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
	import com.chameleon.utils.Randomness;
import com.chameleon.utils.Sleeper;

	public class Test_SearchResultsPageMobile extends AccuWeatherMobileBaseTest
	{
		private String expectedSearchlocation_URL = "https://qualityassurance.accuweather.com/en/search-locations";
		private String expectedSearchResultPageWithAddedLocation_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=Aspen";
		private String expectedSearchResultPageWithAddedZipcode_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=06901";
		private String expectedSearchResultPageForLocationWithNoMatch_URL = "https://qualityassurance.accuweather.com/en/search-locations?query=rubbish";
		String zipcode = "11221";
		String zipcode_2 = "11222";
		
		private LandingPageMobile landingPage = new LandingPageMobile();
		private SeachResultsPageMobile seachResultsPage = new SeachResultsPageMobile();
		private ThreeDayForecastPage threedayForecastPage = new ThreeDayForecastPage();
		
		@Test(priority=1,enabled = true)
		public void RW_T245_UniversalNavigation_navigateSearchResultPage()
		{
			testStart("Validate user successfullly navigated to search result page");
			landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
			landingPage.clickOnZipcodeSearchIcon();
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
		
		@Test(priority=2,enabled = true)
		public void RW_T247_SearchResultPageComponents_verifySearchResultPageWithAddedLocation()
		{
			testStart("Validate user navigated to search result page with added location");
			landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
			landingPage.clickOnZipcodeSearchIcon();
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
		
//		@Test(priority=3)
//		public void RW_T247_SearchResultPageComponents_verifyBrowseForLocationIsPresent()
//		{
//			testStart("Verify browse for location CTA is present");
//		    landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
//			//check it once the merge is complete. BrowseForlocation is present browse location class.
//		}
	//	
		@Test(priority=4,enabled = true)
		public void RW_T249_Search5DigitNumericZipcode_verifySearchResultPageWithAddedZipcode()
		{
			testStart("Validate user navigated to search result page with added zipcode");
			landingPage.enterZipcodeInSearchFieldAndClick("06901");
			landingPage.clickOnZipcodeSearchIcon();
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
//		@Test(priority=5)
//		public void RW_T249_Search5DigitNumericZipcode_verifyBrowseForLocationIsPresent()
//		{
//			testStart("Verify browse for location CTA is present");
//			landingPage.enterZipcodeInSearchFieldAndClick("06901");
			//check it once the merge is complete. BrowseForlocation is present browse location class.
//		}
		
//		@Test(priority=6)
//		public void RW_T250_SearchWith2AlphabeticCharacters_verifyBrowseForLocationIsPresent()
//		{
//			testStart("Verify browse for location CTA is present");
//			landingPage.enterZipcodeInSearchFieldAndClick(Randomness.randomString(2));
			//check it once the merge is complete. BrowseForlocation is present browse location class.
//		}
		
		@Test(priority=7,enabled = true)
		public void RW_T251_SearchForLocationWithoutAnyMatch_verifySearchResultPage()
		{
			testStart("Validate user navigated to expected search result page");
			landingPage.enterZipcodeInSearchFieldAndClick("rubbish");
			landingPage.clickOnZipcodeSearchIcon();
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
		
//		@Test(priority=8)
//		public void RW_T251_SearchForLocationWithoutAnyMatch_verifyBrowseForLocationIsPresent()
//		{
//			testStart("Verify browse for location CTA is present");
//			landingPage.enterZipcodeInSearchFieldAndClick("rubbish");
//			check it once the merge is complete. BrowseForlocation is present browse location class.
//		}

		@Test(priority=2,enabled = false)
		public void RW_T252_NavigationTo3dayForecastPageFromSearchResults_navigationTo3dayForecastPage()
		{
			testStart("Validate user navigated to 3 day forecast page when clicked on any of the location from the search results");
			landingPage.enterZipcodeInSearchFieldAndClick("Aspen");
			landingPage.clickOnZipcodeSearchIcon();
			seachResultsPage.clickLocationFromSearchResults();
			Assert.assertTrue(seachResultsPage.fourWeathercardisDisplayed());
		}
		
		
		
		@Test(priority=2,enabled = false)
		public void RW_T610_NonUSLocations_verifyListofSuggestedLocations()
		{
			testStart("Verify the list of suggested of locations based on the characters entered appears");
			landingPage.enterZipcodeInSearchFieldAndClick("Royal Oak");
			landingPage.clickOnZipcodeSearchIcon();
			seachResultsPage.verifyListofSuggestedLocations("Royal Oak");
		}
		
		@Test(priority=2,enabled = false)
		public void RW_T609_USLocations_verifyListofSuggestedLocations()
		{
			testStart("Verify the list of suggested of locations based on the characters entered appears");
			landingPage.enterZipcodeInSearchFieldAndClick("Mumbai");
			landingPage.clickOnZipcodeSearchIcon();
			seachResultsPage.verifyListofSuggestedLocations("Mumbai");
		}
		
		
		
		@Test(priority=1,enabled = false)
		public void RW_T1228_ValidateArrowKeysEnabledForUseOnFeaturedSearch_navigateSearchResults()
		{
			testStart("Validate user navigated to 3 day forecast page when clicked on any of the location from the search results");
			landingPage.enterZipcodeInSearchField("ff");
			Sleeper.sleep(3);
			seachResultsPage.navigateSearchResults();
		}
		
		@Test(priority=1,enabled = false)
		public void RW_T1230_SearchZipCode_Multiple_Locations()
		{
			testStart("Validate SearchZipCode Multiple Locations");
			landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
			landingPage.clickOnZipcodeSearchIcon();
			Sleeper.sleep(10);
			getDriver().navigate().back();
			Sleeper.sleep(10);
			Assert.assertEquals(seachResultsPage.getRecentLocation(), "Brooklyn, NY");
			landingPage.enterZipcodeInSearchFieldAndClick(zipcode_2);
			landingPage.clickOnZipcodeSearchIcon();
			Sleeper.sleep(10);
			getDriver().navigate().back();
			Sleeper.sleep(10);
			landingPage.enterZipcodeInSearchFieldAndClick("Brooklyn,OH");
			landingPage.clickOnZipcodeSearchIcon();
			Sleeper.sleep(10);
			landingPage.SelectFirstRecordOfResults();
			Sleeper.sleep(10);
			getDriver().navigate().back();
			Sleeper.sleep(10);
			getDriver().navigate().back();
			Sleeper.sleep(10);
			Assert.assertTrue(landingPage.getRecordOfSearchedLocationResults());
		}
		
		
		
	}


