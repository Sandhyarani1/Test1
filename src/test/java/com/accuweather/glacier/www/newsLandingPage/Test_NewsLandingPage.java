package com.accuweather.glacier.www.newsLandingPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.NewsWeatherPage;
import com.chameleon.utils.Sleeper;

public class Test_NewsLandingPage extends AccuWeatherBaseTest
{
	private static final String EXPECTED_WEATHERNEWSPAGE_URL = "https://qualityassurance.accuweather.com/en/weather-news";
	private static final String EXPECTED_NEWSTAB_COLOR = "#f05514";
	NewsWeatherPage newsWeatherPage = new NewsWeatherPage();
	NavigationBar navigationbar = new NavigationBar();
	
	@Test(priority=1)
	public void RW_T420_NewsLandingPageLoadsSuccessfully_verifyWeatherNewsPage()
	{
		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
		Sleeper.sleep(2);
		String actualWeatherNewsURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualWeatherNewsURL, EXPECTED_WEATHERNEWSPAGE_URL);	
	}
	
	@Test(priority=1)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkForSecondaryNavigationMenus()
	{
		testStart("Check for secondary navigation menus News, Videos, Blogs, Personalities");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
		Sleeper.sleep(2);
		Assert.assertTrue(newsWeatherPage.checkSecondaryNavigationMenu());
	}
	
	@Test(priority=1)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkNewsTabIsHighlightedInColor()
	{
		testStart("Verify news tab is higlighted in orange color");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
		Sleeper.sleep(2);
		String actualNewsTabColor = newsWeatherPage.checkNewsTabIsHighkightedInColor();
		Assert.assertEquals(actualNewsTabColor, EXPECTED_NEWSTAB_COLOR);
	}
	
	@Test(priority=1)
	public void RW_T424_RightRailOrganismsBelowTopRightAd_locateRightRailOrganism()
	{
		testStart("Verify rail organism is present or not");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
	    newsWeatherPage.locateRightRailOrganism();
	}
	
	@Test(priority=1)
	public void RW_T422_CenterWellOrganismsContentTypeLatestNewsInBold_verifyLatestNewsPresent()
	{
		testStart("Verify latest news is present below secondary navigation menu");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
	    newsWeatherPage.verifyLatestNewsPresent();
	}
}
