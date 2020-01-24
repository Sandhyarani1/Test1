package com.accuweather.glacier.www.SmokeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;

public class RW_T2268_VerifyThumbnailDateArticleTitleUnderSeverWeather extends AccuWeatherBaseTest
{
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
	public void getSevereWeatherAPIData()
	{
		getThumbnailImgSrc = LandingPageAPI.getUniversalNavigationSevereWeatherData()[4];
		getDateFromAPI = LandingPageAPI.getUniversalNavigationSevereWeatherData()[1];
		getArticleTitleFromAPI = LandingPageAPI.getUniversalNavigationSevereWeatherData()[0];
		getArticleTitleUrlFromAPI = LandingPageAPI.getUniversalNavigationSevereWeatherData()[2];
	}
	
	@Test(priority=1,enabled=true)
	public void RW_T2268_verifyThumbnaildateArticleUnderSevereWeather()
	{
		softAssert = new SoftAssert();
		testStart("API Validation of Severe Weather Elements");
		
		/****************Validate date below thumbnail***************************************/
		
		softAssert.assertEquals(navBar.getImgSrcThumbnailUnderSevereWeather(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under severe weather is not matching with API Data");
		
		/****************Validate date below thumbnail***************************************/	
		softAssert.assertEquals(navBar.getDateBelowThumbnailUnderSevereWeather(), getDateFromAPI,
				"Issue-----> Date below thumbnail under severe weather is not matching with API Data");
		
		/****************Validate article title***************************************/
		softAssert.assertEquals(navBar.getArticleTitleUnderSevereWeather(), getArticleTitleFromAPI,
				"Issue-----> Article title under severe weather is not matching with API Data");
		
		/******************** URL *********************************/
		softAssert.assertEquals(navBar.getArticleTitleUrlUnderSevereWeather(), getArticleTitleUrlFromAPI,
				"Issue------> Article URL not matching with the API Data");	
	}
	
}
