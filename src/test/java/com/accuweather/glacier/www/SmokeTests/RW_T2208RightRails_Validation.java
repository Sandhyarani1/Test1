/**
 * 
 */
package com.accuweather.glacier.www.SmokeTests;

import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;

/**
 * @author HFARAZ
 *
 */
public class RW_T2208RightRails_Validation extends AccuWeatherBaseTest
{
	LandingPage landingPage = new LandingPage();
	SoftAssert softAssert;

	public ArrayList<String> rightRail1_ArticleTitlesFromAPI = new ArrayList<String>();
	public ArrayList<String> rightRail2_ArticleTitlesFromAPI = new ArrayList<String>();
	public int noOfRightRail1_Articles = 0;
	public int noOfRightRail2_Articles = 0;
	

	@BeforeClass
	public void getAPIData()
	{
		rightRail1_ArticleTitlesFromAPI = LandingPageAPI.getRightRails1_ArticlesTitles();
		rightRail2_ArticleTitlesFromAPI = LandingPageAPI.getRightRails2_ArticlesTitles();
		noOfRightRail1_Articles = LandingPageAPI.getNoOfRightRail1Articles();
		noOfRightRail2_Articles = LandingPageAPI.getNoOfRightRail2Articles();
	}

	@Test(priority = 1)
	public void testrightRail()
	{
		softAssert = new SoftAssert();
		testStart("******************** Validate right rail 1 articles titles ***********************");

		/****************** Validate the count of Rightrail 1 articles ****************************/
		int countOfRightRail1Articles = landingPage.getCountOfRightRail1_Articles();
		softAssert.assertEquals(countOfRightRail1Articles, noOfRightRail1_Articles);
		
		/********************** Validate RightRail 1 Articles Title **************************/
		ArrayList<String> railRightArticleTitlesUI = new ArrayList<String>();
		railRightArticleTitlesUI = landingPage.getRightRail1_ArticlesTitles(rightRail1_ArticleTitlesFromAPI.size());
		for (int i = 0; i < rightRail1_ArticleTitlesFromAPI.size(); i++)
		{
			int count = i + 1;
			softAssert.assertEquals(railRightArticleTitlesUI.get(i), rightRail1_ArticleTitlesFromAPI.get(i),
					"\nIssue-----> Title for Rightrail Article No: " + count + " not matching with API Data" + "\n");
		}
		
		
		/****************** Validate the count of Rightrail 2 articles ****************************/
		int countOfRightRail2Articles = landingPage.getCountOfRightRail2_Articles();
		softAssert.assertEquals(countOfRightRail2Articles, noOfRightRail2_Articles);

		/************** Validate RightRail 2 Articles Titles ************************/

		ArrayList<String> rightRail2_ArticleTitlesUI = new ArrayList<String>();
		rightRail2_ArticleTitlesUI = landingPage.getRightRail2_ArticlesTitles(rightRail2_ArticleTitlesFromAPI.size());

		for (int i = 0; i < rightRail2_ArticleTitlesFromAPI.size(); i++)
		{
			int count = i + 1;
			softAssert.assertEquals(rightRail2_ArticleTitlesUI.get(i), rightRail2_ArticleTitlesFromAPI.get(i),
					"\nIssue-----> Title for Rightrail Article No: " + count + " not matching with API Data" + "\n");
		}
		
		softAssert.assertAll();
	}
}
