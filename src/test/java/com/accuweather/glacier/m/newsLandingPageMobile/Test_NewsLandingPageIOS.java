package com.accuweather.glacier.m.newsLandingPageMobile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.NewsWeatherPageIOS;
import com.chameleon.utils.Sleeper;

public class Test_NewsLandingPageIOS extends AccuWeatherMobileBaseTest {
	private static final String EXPECTED_WEATHERNEWSPAGE_URL = "https://qualityassurance.accuweather.com/en/weather-news";
	private static final String EXPECTED_NEWSTAB_COLOR = "#f05514";
	NewsWeatherPageIOS newsWeatherPage = new NewsWeatherPageIOS();

	@Test(priority = 1, enabled = false)
	public void RW_T420_NewsLandingPageLoadsSuccessfully_verifyWeatherNewsPage() {
		testStart("User should be redirected to Daily forecast page when clicked on Daily tab");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(2);
		String actualWeatherNewsURL = getDriver().getCurrentUrl();
		Assert.assertEquals(actualWeatherNewsURL, EXPECTED_WEATHERNEWSPAGE_URL);
	}

	@Test(priority = 2, enabled = false)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkForSecondaryNavigationMenus() {
		testStart("Check for secondary navigation menus News, Videos, Blogs, Personalities");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(2);
		Assert.assertTrue(newsWeatherPage.checkSecondaryNavigationMenu());
	}

	@Test(priority = 3, enabled = false)
	public void RW_T421_Newstabhighlightedonsecondarynavigation_checkNewsTabIsHighlightedInColor() {
		testStart("Verify news tab is higlighted in orange color");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(2);
		String actualNewsTabColor = newsWeatherPage.checkNewsTabIsHighkightedInColor();
		Assert.assertEquals(actualNewsTabColor, EXPECTED_NEWSTAB_COLOR);
	}

	@Test(priority = 4, enabled = false)
	public void RW_T424_RightRailOrganismsBelowTopRightAd_locateRightRailOrganism() {
		testStart("Verify rail organism is present or not");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		Sleeper.sleep(2);
		newsWeatherPage.locateRightRailOrganism();
	}

	@Test(priority = 1, enabled = false)
	public void RW_T422_CenterWellOrganismsContentTypeLatestNewsInBold_verifyLatestNewsPresent() {
		testStart("Verify latest news is present below secondary navigation menu");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		newsWeatherPage.verifyLatestNewsPresent();
	}
	
	@Test(priority = 1, enabled = false)
	public void RW_T1405_CenterWellOrganismsContentIsDisplayed() {
		testStart("Verify Center Well Organisms Content Is Displayed");
		newsWeatherPage.clickBreadCrumbMenu();
		newsWeatherPage.clickBreadCrumbMenuNews();
		newsWeatherPage.clickbyBreadCrumbMenuWeatherNews();
		newsWeatherPage.verifyCenterWellOrganismIsDisplayed();
	}
	
	
}
