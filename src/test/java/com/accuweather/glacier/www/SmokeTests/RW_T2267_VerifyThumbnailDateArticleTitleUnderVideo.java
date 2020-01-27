package com.accuweather.glacier.www.SmokeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Sleeper;

public class RW_T2267_VerifyThumbnailDateArticleTitleUnderVideo extends AccuWeatherBaseTest {
	SoftAssert softAssert;
	LandingPageAPI getLandingPageAPIData = new LandingPageAPI();
	LandingPage landingPage = new LandingPage();
	public String getThumbnailImgSrc = "";
	public String getDurationFromAPI = "";
	public String getArticleTitleFromAPI = "";
	public String getArticleTitleUrlFromAPI = "";
	
	NavigationBar navBar = new NavigationBar();
	
	/**
	 * @author SOWMIYA
	 * This method will be called before any test starts.
	 * It will make calls to the landing pages API and will gather the required test data for validation and will store in variables,
	 * that can be easily referenced in assertions
	 * */
	
	@BeforeClass()
	public void getVideoAPIData()
	{
		getThumbnailImgSrc = LandingPageAPI.getUniversalNavigationVideoData()[1];
		getDurationFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[2];
		getArticleTitleFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[0];
		getArticleTitleUrlFromAPI = LandingPageAPI.getUniversalNavigationVideoData()[3];
	}
	
	@Test(priority=1,enabled=true)
	public void RW_T2266_verifyThumbnaildateArticleUnderVideo()
	{
		softAssert = new SoftAssert();
		testStart("API Validation of Video Weather Elements");

		/****************Validate date below thumbnail***************************************/
		
		softAssert.assertEquals(navBar.getImgSrcThumbnailUnderVideo(), getThumbnailImgSrc,
				"Issue-----> Thumbnail src value under video is not matching with API Data");

		
		/****************Validate date below thumbnail***************************************/
		
		softAssert.assertEquals(navBar.getDurationBelowThumbnailUnderVideo(), getDurationFromAPI,
				"Issue-----> Duration below thumbnail under video is not matching with API Data");
		
		
		/****************Validate article title*************************************************/
		
		softAssert.assertEquals(navBar.getArticleTitleUnderVideo(), getArticleTitleFromAPI,
				"Issue-----> Article title under video is not matching with API Data");
		
		/******************** URL *********************************/
		String articleTitleUrlFromAPI = getArticleTitleUrlFromAPI.toLowerCase();
		softAssert.assertEquals(navBar.getArticleTitleUrlUnderVideo(), articleTitleUrlFromAPI,
				"Issue------> Article URL not matching with the API Data");	
		
		softAssert.assertAll();
	}
	

}
