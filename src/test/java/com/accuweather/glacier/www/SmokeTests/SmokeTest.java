package com.accuweather.glacier.www.SmokeTests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.SmokeTests;

public class SmokeTest extends AccuWeatherBaseTest
{
	
	SoftAssert softAssert;
	LandingPageAPI getLandingPageAPIData = new LandingPageAPI();
	SmokeTests smokeTests = new SmokeTests();
	public String contentModuleTitle = "";
	public String contentModuleDate = "";
	public String centerWell1VideoTitle = "";
	public ArrayList<String> rightRailArticleTitles = new ArrayList<String>();
	public ArrayList<String> weatherNewsDateFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTypeFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTitleFromAPI = new ArrayList<String>();
	public int noOfWeatherNews = 0;
	
	
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
	
	@Test(priority=1)
	public void RW_T2183LandingPageAPIValidations()
	{
		softAssert = new SoftAssert();
		testStart("API Validation of Landing Page Elements");
		
		//Validate CenterWell 1 Content Module Title
		softAssert.assertEquals(smokeTests.getContentModuleTitle(), contentModuleTitle,
				"Issue-----> CenterWell 1 Content Module Title not matching with API Data");
		
		//Validate CenterWell 1 Content Module Date
		softAssert.assertTrue(smokeTests.getContentModuleDate().replaceAll("\\s+","").replaceAll(",", "").equalsIgnoreCase(contentModuleDate.replaceAll("\\s+","")),
				"Issue-----> CenterWell 1 Content Module Date not matching with API Data");
		
		//Validate CenterWell 1 Video Title
		softAssert.assertEquals(smokeTests.getCenterWell1VideoTitle(), centerWell1VideoTitle,
				"Issue----->CenterWell 1 Video Title not matcing with API Data");
		
		//Validate RightRail Articles Title
		ArrayList<String> railRightArticleTitlesUI = new ArrayList<String>();
		railRightArticleTitlesUI = smokeTests.getRightRailArticlesTitles(rightRailArticleTitles.size());
		
		for (int i=0;i<rightRailArticleTitles.size();i++)
		{
			int count = i+1;
			softAssert.assertEquals(railRightArticleTitlesUI.get(i), rightRailArticleTitles.get(i),
					"Issue-----> Title for Rightrail Article No: "+count+" not matching with API Data");
		}
		
		//Validate the number of CenterWell 2 Weather News Articles
		smokeTests.clickShowMore();
		softAssert.assertEquals(smokeTests.getCountOfWeatherNewsArticles(), noOfWeatherNews,
				"Issue----->Weather News Count not matching with the API");
		
		//Validate the Date on Weather News Articles with API Data
		ArrayList<String> weatherNewsDateOnUI = new ArrayList<String>();
		weatherNewsDateOnUI = smokeTests.readWeatherNewsDate(noOfWeatherNews);
		for (int i=0;i<noOfWeatherNews;i++)
		{
			int count = i+1;
			softAssert.assertTrue(weatherNewsDateOnUI.get(i).replaceAll("\\s+","").replaceAll("\\.", "").replaceAll(",", "").
					equalsIgnoreCase(weatherNewsDateFromAPI.get(i).replaceAll("\\s+","")),"Issue----> Date on Weather News Article "+count+" not matching with API data");
		}
		
		//Validate the Weather News type on Weather News Articles with API Data
		ArrayList<String> weatherNewsTypeOnUI = new ArrayList<String>();
		weatherNewsTypeOnUI = smokeTests.readWeatherNewsType(noOfWeatherNews);
		for (int i=0;i<noOfWeatherNews;i++)
		{
			int count=i+1;
			softAssert.assertTrue(weatherNewsTypeOnUI.get(i).
					equalsIgnoreCase(weatherNewsTypeFromAPI.get(i)),"Issue----> Weather News Type on Weather News Article "+count+" not matching with API data");
		}
			
		//Validate the Weather News titles on Weather News Articles with API Data
		ArrayList<String> weatherNewsTitlesOnUI = new ArrayList<String>();
		weatherNewsTitlesOnUI = smokeTests.readWeatherNewsTitles(noOfWeatherNews);
		for (int i=0;i<noOfWeatherNews;i++)
		{
			int count=i+1;
			softAssert.assertTrue(weatherNewsTitlesOnUI.get(i).
					equalsIgnoreCase(weatherNewsTitleFromAPI.get(i)),"Issue----> Weather News Title on Weather News Article "+count+" not matching with API data");
		}
		
		softAssert.assertAll();
		
	}
}
