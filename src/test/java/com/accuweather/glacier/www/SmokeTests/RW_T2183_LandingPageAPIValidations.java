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
 * This class deals with Landing page validations of all the elements via CMS API
 * JIRA ID: RW-T2183
 * */

public class RW_T2183_LandingPageAPIValidations extends AccuWeatherBaseTest
{
	
	SoftAssert softAssert;
	LandingPageAPI getLandingPageAPIData = new LandingPageAPI();
	LandingPage landingPage = new LandingPage();
	public String contentModuleTitle = "";
	public String contentModuleDate = "";
	public String centerWell1VideoTitle = "";
	public ArrayList<String> rightRailArticleTitles = new ArrayList<String>();
	public ArrayList<String> weatherNewsDateFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTypeFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTitleFromAPI = new ArrayList<String>();
	public int noOfWeatherNews = 0;
	
	
	/***
	 * @author HFARAZ
	 * This method will be called before any test starts.
	 * It will make calls to the CMS API and will gather the required test data for validation and will store in variables,
	 * that can be easily referenced in assertions
	 * */
	
	@BeforeClass()
	public void getAPIData()
	{
		contentModuleTitle = LandingPageAPI.getCenterWell1ContentModuleData()[0];
		contentModuleDate = LandingPageAPI.getCenterWell1ContentModuleData()[1];
		centerWell1VideoTitle = LandingPageAPI.getCenterWellVideoTitle()[0];
		rightRailArticleTitles = LandingPageAPI.getRightRailsArticlesTitles();
		noOfWeatherNews = LandingPageAPI.getNoOfWeatherNews();
		weatherNewsDateFromAPI = LandingPageAPI.getWeatherNewsDate();
		weatherNewsTypeFromAPI = LandingPageAPI.getWeatherNewsType();
		weatherNewsTitleFromAPI = LandingPageAPI.getWeatherNewsTitles();
	}
	
	@Test(priority=1,enabled=false)
	public void RW_T2183LandingPageAPIValidations()
	{
		softAssert = new SoftAssert();
		testStart("API Validation of Landing Page Elements");
		
		/****************Validate CenterWell 1 Content Module Title***************************************/
		softAssert.assertEquals(landingPage.getContentModuleTitle(), contentModuleTitle,
				"Issue-----> CenterWell 1 Content Module Title not matching with API Data");
		
		/********************Validate CenterWell 1 Content Module Date***************************************/
		softAssert.assertTrue(landingPage.getContentModuleDate().replaceAll("\\s+","").replaceAll(",", "").equalsIgnoreCase(contentModuleDate.replaceAll("\\s+","")),
				"Issue-----> CenterWell 1 Content Module Date not matching with API Data"
				+"\n");
		
		/********************Validate CenterWell 1 Video Title*******************************************/
		softAssert.assertEquals(landingPage.getCenterWell1VideoTitle(), centerWell1VideoTitle,
				"Issue----->CenterWell 1 Video Title not matcing with API Data");
		
		/********************Validate RightRail Articles Title*********************************************/
		ArrayList<String> railRightArticleTitlesUI = new ArrayList<String>();
		railRightArticleTitlesUI = landingPage.getRightRailArticlesTitles(rightRailArticleTitles.size());
		
		for (int i=0;i<rightRailArticleTitles.size();i++)
		{
			int count = i+1;
			softAssert.assertEquals(railRightArticleTitlesUI.get(i), rightRailArticleTitles.get(i),
					"\nIssue-----> Title for Rightrail Article No: "+count+" not matching with API Data"
					+"\n");
		}
		
		/*********************************Validate the number of CenterWell 2 Weather News Articles******************************/
		landingPage.clickShowMore();
		softAssert.assertEquals(landingPage.getCountOfWeatherNewsArticles(), noOfWeatherNews,
				"\nIssue----->Weather News Count not matching with the API"
				+"\n");
		
		/*******************************Validate the Date on Weather News Articles with API Data**********************************/
				
		  ArrayList<String> weatherNewsDateOnUI = new ArrayList<String>();
		  weatherNewsDateOnUI = landingPage.readWeatherNewsDate(noOfWeatherNews);
		  for(int i=0;i<noOfWeatherNews;i++)
		  {
			  /**
			   * The count variable is for the number of article/element you want to point on GUI
			   * E.g. The weather articles
			   * */
			  int count = i+1;
			  
			  /**
			   * API gives the date in format. E.g JANUARY 15 2020. 
			   * Trying to take substring from the date and remove spaces to match with UI date i.e JAN152020
			   * Removing Spaces from both the date from UI and API
			   * * */
			  String month = weatherNewsDateFromAPI.get(i).replaceAll("\\s+","").substring(0, 3);
			  String dateAndYear = weatherNewsDateFromAPI.get(i).replaceAll("\\s+","").substring(7, 13);
			  
			  softAssert.assertTrue(weatherNewsDateOnUI.get(i).replaceAll("\\s+","").replaceAll("\\.", "").replaceAll(",", "").
					  equalsIgnoreCase(month.concat(dateAndYear)),
					  "\nIssue----> Date on Weather News Article "+count+" not matching with API data"
					  +"\n"); 
		  }
		 
		
		/**********************************Validate the Weather News type on Weather News Articles with API Data******************************/
		ArrayList<String> weatherNewsTypeOnUI = new ArrayList<String>();
		weatherNewsTypeOnUI = landingPage.readWeatherNewsType(noOfWeatherNews);
		for (int i=0;i<noOfWeatherNews;i++)
		{
			int count=i+1;
			softAssert.assertTrue(weatherNewsTypeOnUI.get(i).
					equalsIgnoreCase(weatherNewsTypeFromAPI.get(i)),
					"\nIssue----> Weather News Type on Weather News Article "+count+" not matching with API data"
					+"\n"
							+"On UI------>"+weatherNewsTypeOnUI.get(i)
							+"\n"+
							"From API------>"+weatherNewsTypeFromAPI.get(i));
		}
			
		/**********************************Validate the Weather News titles on Weather News Articles with API Data***************************/
		ArrayList<String> weatherNewsTitlesOnUI = new ArrayList<String>();
		weatherNewsTitlesOnUI = landingPage.readWeatherNewsTitles(noOfWeatherNews);
		for (int i=0;i<noOfWeatherNews;i++)
		{
			int count=i+1;
			softAssert.assertTrue(weatherNewsTitlesOnUI.get(i).
					equalsIgnoreCase(weatherNewsTitleFromAPI.get(i)),
					"\nIssue----> Weather News Title on Weather News Article "+count+" not matching with API data"
					+"\n"
					+"On UI----> "+weatherNewsTitlesOnUI.get(i)+"\n"
					+"From API---->"+weatherNewsTitleFromAPI.get(i));
		}
		
		softAssert.assertAll();
		
	}
	
	@Test()
	public void testA()
	{
		softAssert = new SoftAssert();
		softAssert.assertEquals("A", "A");
		softAssert.assertAll();
	}
}
