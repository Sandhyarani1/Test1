package com.accuweather.glacier.www.newsLandingPage;

import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

public class Test_NewsLandingPage extends AccuWeatherBaseTest
{
	public static String weatherNewsURL								= "";
	public static final String WEATHER_NEWS_URL_SUFFIX				= "weather-news";
	public final static String LANGUAGE = "EN";
	private static final String EXPECTED_NEWSTAB_COLOR = "#f05514";
	NewsWeatherPage newsWeatherPage = new NewsWeatherPage();
	NavigationBar navigationbar = new NavigationBar();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	
	SoftAssert softAssert;
	
	@BeforeClass
	public void setTestData()
	{
		weatherNewsURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+LANGUAGE+"/"+WEATHER_NEWS_URL_SUFFIX).toLowerCase();
	}
	
	@Test(priority=1)
	public void RW_T420_NewsLandingPageLoadsSuccessfully_verifyWeatherNewsPage()
	{
		softAssert = new SoftAssert();
		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
		navigationbar.navigateToNewsSubMenu();
		String actualWeatherNewsURL = getDriver().getCurrentUrl();
		softAssert.assertEquals(actualWeatherNewsURL, weatherNewsURL);	
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkForSecondaryNavigationMenus()
	{
		testStart("Check for secondary navigation menus News, Videos, Blogs, Personalities");
		navigationbar.navigateToNewsSubMenu();
		softAssert.assertTrue(newsWeatherPage.checkSecondaryNavigationMenu());
		
		String actualNewsTabColor = newsWeatherPage.checkNewsTabIsHighkightedInColor();
		softAssert.assertEquals(actualNewsTabColor, EXPECTED_NEWSTAB_COLOR);
		
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void RW_T422_CenterWellOrganismsContentTypeLatestNewsInBold_verifyLatestNewsPresent()
	{
		testStart("Verify latest news is present below secondary navigation menu");
		navigationbar.navigateToNewsSubMenu();
	    newsWeatherPage.verifyLatestNewsPresent();
	    
	    softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void RW_T424_RightRailOrganismsBelowTopRightAd_locateRightRailOrganism()
	{
		testStart("Verify rail organism is present or not");
		navigationbar.navigateToNewsSubMenu();
	    newsWeatherPage.locateRightRailOrganism();
	    
	    softAssert.assertAll();
	}
}
