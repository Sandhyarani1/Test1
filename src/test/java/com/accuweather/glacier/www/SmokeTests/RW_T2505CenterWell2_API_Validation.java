package com.accuweather.glacier.www.SmokeTests;

import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.accuweather.glacier.api.LandingPageAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;

/**
 * @author Hasan Faraz
 * This class deals with validating the Centerwell 2 data with the CMS API data
 *
 */
public class RW_T2505CenterWell2_API_Validation extends AccuWeatherBaseTest
{
	SoftAssert softAssert;
	LandingPageAPI landingPageAPI = new LandingPageAPI();
	LandingPage landingPage = new LandingPage();
	
	public ArrayList<String> weatherNewsDateFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTypeFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsTitleFromAPI = new ArrayList<String>();
	public ArrayList<String> weatherNewsURLFromAPI = new ArrayList<String>();
	public int noOfWeatherNewsFromAPI = 0;
	
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
		noOfWeatherNewsFromAPI = LandingPageAPI.getNoOfWeatherNews();
		weatherNewsDateFromAPI = LandingPageAPI.getWeatherNewsDate();
		weatherNewsTypeFromAPI = LandingPageAPI.getWeatherNewsType();
		weatherNewsTitleFromAPI = LandingPageAPI.getWeatherNewsTitles();
		weatherNewsURLFromAPI = LandingPageAPI.getWeatherNewsURLs();
	}

	@Test(priority=1)
	public void RW_T505CenterWell2_APIValidation()
	{	
		softAssert = new SoftAssert();
		testStart("*************** Validating the CenterWell 2 with API Data *******************************");
		
		/************************* Validate the number of CenterWell 2 Weather News Articles ***************************/
		landingPage.clickShowMore();
		
		int countOfWeatherNewsFromUI = landingPage.getCountOfWeatherNewsArticles();
		softAssert.assertEquals(countOfWeatherNewsFromUI, noOfWeatherNewsFromAPI,
				"\nIssue----->Weather News Count not matching with the API"
						+ "\n"
						+ "Count of Weather News from API---->" + noOfWeatherNewsFromAPI
						+ "\n"
						+ "Count of Weather News from UI----->" + countOfWeatherNewsFromUI);

		
		/*************************** Validate the Date on Weather News Articles with API Data ***************************/
		ArrayList<String> weatherNewsDateOnUI = new ArrayList<String>();
		weatherNewsDateOnUI = landingPage.readWeatherNewsDate(noOfWeatherNewsFromAPI);
		for (int i = 0; i < noOfWeatherNewsFromAPI; i++)
		{

			/**
			 * The count variable is for the number of article/element you want to point on
			 * GUI E.g. The weather articles
			 */

			int count = i + 1;
			softAssert.assertTrue(weatherNewsDateOnUI.get(i).equalsIgnoreCase(weatherNewsDateFromAPI.get(i)),
					"\nIssue----> Date on Weather News Article " + count + " not matching with API data"
							+ "\n"
							+ "Date From API--->" + weatherNewsDateFromAPI.get(i)
							+ "\n"
							+ "Date on UI----->" + weatherNewsDateOnUI.get(i));
		}

		/******************* Validate the Weather News type on Weather News Articles with API Data ****************************/
		ArrayList<String> weatherNewsTypeOnUI = new ArrayList<String>();
		weatherNewsTypeOnUI = landingPage.readWeatherNewsType(noOfWeatherNewsFromAPI);
		for (int i = 0; i < noOfWeatherNewsFromAPI; i++)
		{
			int count = i + 1;
			softAssert.assertTrue(weatherNewsTypeOnUI.get(i).equalsIgnoreCase(weatherNewsTypeFromAPI.get(i)),
					"\nIssue----> Weather News Type on Weather News Article " + count + " not matching with API data"
							+ "\n"
							+ "On UI------>" + weatherNewsTypeOnUI.get(i)
							+ "\n"
							+ "From API------>" + weatherNewsTypeFromAPI.get(i));
		}

		/********************************** Validate the Weather News titles on Weather News Articles with API Data *****************/

		ArrayList<String> weatherNewsTitlesOnUI = new ArrayList<String>();
		weatherNewsTitlesOnUI = landingPage.readWeatherNewsTitles(noOfWeatherNewsFromAPI);
		
		for (int i = 0; i < noOfWeatherNewsFromAPI; i++)
		{
			int count = i + 1;
			softAssert.assertTrue(weatherNewsTitlesOnUI.get(i).equalsIgnoreCase(weatherNewsTitleFromAPI.get(i)),
					"\nIssue----> Weather News Title on Weather News Article " + count + " not matching with API data"
							+ "\n"
							+ "On UI----> " + weatherNewsTitlesOnUI.get(i)
							+ "\n"
							+ "From API---->" + weatherNewsTitleFromAPI.get(i));
		}
		
		/******************************** Validate the weather news urls ************************************************/
		for (int i = 0; i < noOfWeatherNewsFromAPI; i++)
		{
			int count = i + 1;
			softAssert.assertTrue(landingPage.weatherNewsArticles_URLs.get(i).equalsIgnoreCase(weatherNewsURLFromAPI.get(i)),
					"\nIssue----> Weather News URL on Weather News Article " + count + " not matching with API data"
							+ "\n"
							+ "On UI----> " + landingPage.weatherNewsArticles_URLs.get(i)
							+ "\n"
							+ "From API---->" + weatherNewsURLFromAPI.get(i));
		}
	}
}
