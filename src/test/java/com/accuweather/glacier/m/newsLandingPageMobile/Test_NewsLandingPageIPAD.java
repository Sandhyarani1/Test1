package com.accuweather.glacier.m.newsLandingPageMobile;

import static com.chameleon.utils.TestReporter.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.pages.NewsWeatherPageIPAD;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Sleeper;

public class Test_NewsLandingPageIPAD extends AccuWeatherBaseTest
{
	private static final String EXPECTED_WEATHERNEWSPAGE_URL = "https://qualityassurance.accuweather.com/en/weather-news";
	private static final String EXPECTED_NEWSTAB_COLOR = "#f05514";
	NewsWeatherPageIPAD newsWeatherPage = new NewsWeatherPageIPAD();
	NavigationBar navigationbar = new NavigationBar();
	
	@Test(priority=1,enabled=true)
	public void RW_T420_NewsLandingPageLoadsSuccessfully_verifyWeatherNewsPage()
	{
		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
		navigationbar.mouseHoverOnNews();
		logInfo("Hovered mouse on news Main Tab");
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
		Sleeper.sleep(2);
		String actualWeatherNewsURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualWeatherNewsURL, EXPECTED_WEATHERNEWSPAGE_URL);	
	}
	
	@Test(priority=2,enabled=false)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkForSecondaryNavigationMenus()
	{
		testStart("Check for secondary navigation menus News, Videos, Blogs, Personalities");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
		Sleeper.sleep(2);
		Assert.assertTrue(newsWeatherPage.checkSecondaryNavigationMenu());
	}
	
	@Test(priority=3,enabled=false)
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
	
	@Test(priority=4,enabled=false)
	public void RW_T424_RightRailOrganismsBelowTopRightAd_locateRightRailOrganism()
	{
		testStart("Verify rail organism is present or not");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
	    newsWeatherPage.locateRightRailOrganism();
	}
	
	@Test(priority=5,enabled=false)
	public void RW_T422_CenterWellOrganismsContentTypeLatestNewsInBold_verifyLatestNewsPresent()
	{
		testStart("Verify latest news is present below secondary navigation menu");
		navigationbar.mouseHoverOnNews();
		navigationbar.isWeatherNewsSubMenuDisplayed();
		navigationbar.navigateToNewsPage();
	    newsWeatherPage.verifyLatestNewsPresent();
	}
}