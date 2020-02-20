package com.accuweather.glacier.www.SmokeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LegalFooter;

/**
 * 
 * @author HFARAZ This class deals with Landing page validations of all the elements via CMS API 
 * JIRA ID: RW-T2183
 * 
 */

public class RW_T2269CenterWell1_API_Validation extends AccuWeatherBaseTest
{

	SoftAssert softAssert;
	LandingPage landingPage = new LandingPage();
	LegalFooter legalFooter = new LegalFooter();

	public String contentModuleTitleFromAPI = "";
	public String contentModuleDateFromAPI = "";
	public String contentModuleImageSourceFromAPI = "";
	public String contentModuleVideoURLFromAPI = "";
	public String centerWell1VideoTitleFromAPI = "";
	
	public static final String LANDING_PAGE_TITLE = "Local, National, & Global Daily Weather Forecast | AccuWeather";

	/***
	 * 
	 * @author HFARAZ 
	 * This method will be called before any test starts. It will
	 * make calls to the CMS API and will gather the required test data for
	 * validation and will store in variables, that can be easily referenced in assertions
	 */

	@BeforeClass()
	public void getAPIData()
	{
		contentModuleTitleFromAPI = LandingPageAPI.getCenterWell1ContentModuleData()[0];
		contentModuleImageSourceFromAPI = LandingPageAPI.getCenterWell1ContentModuleData()[4];
		contentModuleDateFromAPI = LandingPageAPI.getContentModuleDate();
		contentModuleVideoURLFromAPI = LandingPageAPI.getCenterWell1ContentModuleData()[2];
		centerWell1VideoTitleFromAPI = LandingPageAPI.getCenterWellVideoTitle()[0];
	}

	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	public void RW_T2269CenterWell1_APIValidation()
	{
		softAssert = new SoftAssert();
		
		testStart("API Validation of Landing Page Elements");
		legalFooter.clickIUnderstand();
		
		/********************** Validate whether the landing page loaded successfully *************************/
		softAssert.assertEquals(getDriver().getTitle(), LANDING_PAGE_TITLE,
				"\nIssue------> Landing Page Title Not matching"
						+ "\n");

		/********************* Validate CenterWell 1 Article Title ***************************************/
		softAssert.assertEquals(landingPage.getContentModuleTitle(), contentModuleTitleFromAPI,
				"\nIssue-----> CenterWell 1 Content Module Title not matching with API Data"
						+ "\n");

		/************** Validate CenterWell 1 Article Date ***************************************/
		String contentModuleDateOnUI = landingPage.getContentModuleDate();
		softAssert.assertTrue(contentModuleDateOnUI.equalsIgnoreCase(contentModuleDateFromAPI),
				"\nIssue-----> CenterWell 1 Content Module Date not matching with API Data"
						+ "\n"
						+ "Date On UI----->" + contentModuleDateOnUI
						+ "\n"
						+ "Date From API---->" + contentModuleDateFromAPI +
				"\n");

		/************** Validate the Image source of CenterWell 1 Article *************************/
		String imageSourceFromUI = landingPage.getImageSourceOfContentModule();
		softAssert.assertTrue(imageSourceFromUI.startsWith(contentModuleImageSourceFromAPI),
				"\nIssue-----> Image Source on UI not matching with the API Data"
						+ "\n" +
						"Image Source From UI----->" + imageSourceFromUI
						+ "\n"
						+ "Image Source From API----->" + contentModuleImageSourceFromAPI
						+ "\n");

		/****************** Validate CenterWell 1 Article Video URL *****************/
		softAssert.assertEquals(landingPage.getURLForContentModule(), contentModuleVideoURLFromAPI,
				"\nIssue------> Content Module URL not matching with the API Data"
						+ "\n");

		/******************* Validate CenterWell 1 Video Title ************************/
		softAssert.assertEquals(landingPage.getCenterWell1VideoTitle(), centerWell1VideoTitleFromAPI,
				"\nIssue----->CenterWell 1 Video Title not matcing with API Data"
						+ "\n");

		softAssert.assertAll();

	}

}