package com.accuweather.glacier.www.SmokeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class RW_T2266_VerifyThumbnailDateArticleTitleUnderNews extends AccuWeatherBaseTest {
	
	SoftAssert softAssert;
	LandingPageAPI getLandingPageAPIData = new LandingPageAPI();
	LandingPage landingPage = new LandingPage();
	public String getThumbnailImgSrc = "";
	public String getDateFromAPI = "";
	public String getArticleTitleFromAPI = "";
	public String getArticleTitleUrlFromAPI = "";
	
	NavigationBar navBar = new NavigationBar();
	
	/***
	 * @author SOWMIYA
	 * This method will be called before any test starts.
	 * It will make calls to the landing pages API and will gather the required test data for validation and will store in variables,
	 * that can be easily referenced in assertions
	 * */
	
	@BeforeClass()
	public void getNewsAPIData()
	{
		getThumbnailImgSrc = LandingPageAPI.getUniversalNavigationNewsData()[4];
		getDateFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[1];
		getArticleTitleFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[0];
		getArticleTitleUrlFromAPI = LandingPageAPI.getUniversalNavigationNewsData()[2];
	}
	
	@Test(priority=1,enabled=true)
	public void RW_T2266_verifyThumbnaildateArticleUnderNews()
	{
		softAssert = new SoftAssert();
		testStart("API Validation of News Weather Elements");
//		
		/****************Validate date below thumbnail***************************************/
		
		softAssert.assertEquals(navBar.getImgSrcThumbnailUnderNews(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under news is not matching with API Data");

		/****************Validate date below thumbnail***************************************/	
		softAssert.assertEquals(navBar.getDateBelowThumbnailUnderNews(), getDateFromAPI,
				"Issue-----> Date below thumbnail under news is not matching with API Data");
		
		
		/****************Validate article title***************************************/
		softAssert.assertEquals(navBar.getArticleTitleUnderNews(), getArticleTitleFromAPI,
				"Issue-----> Article title under news is not matching with API Data");
		
		/******************** URL *********************************/
		softAssert.assertEquals(navBar.getArticleTitleUrlUnderNews(), getArticleTitleUrlFromAPI,
				"Issue------> Article URL not matching with the API Data");	
	}
	
}
