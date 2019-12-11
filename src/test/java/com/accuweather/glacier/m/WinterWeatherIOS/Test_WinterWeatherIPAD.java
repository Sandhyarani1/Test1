package com.accuweather.glacier.m.WinterWeatherIOS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.WinterWeatherPageIPAD;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.UniversalFooterPage;
import com.chameleon.utils.Sleeper;

public class Test_WinterWeatherIPAD extends AccuWeatherMobileBaseTest {
	private String EXPECTED_WINTERWEATHER_URL = "https://qualityassurance.accuweather.com/en/us/winter-weather";
	private String EXPECTED_MAP_TITLE = "NATIONAL WEATHER SERVICE - SNOW DEPTH";
	private String EXPECTED_NATIONAL_FORECAST_MAP_TITLE = "NATIONAL 24-HOUR SNOWFALL FORECAST MAP";
	private String EXPECTED_LOCAL_FORECAST_MAP_TITLE = "LOCAL FORECAST MAPS";
	private String EXPECTED_COLOR = "#2cabdc";
	private String EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION = "Provides winter weather forecasts and the winter weather outlook for your area";
	String zipcode = "48073";

	private LandingPageMobile landingPage = new LandingPageMobile();
	private NavigationBar navigationBar = new NavigationBar();
	private WinterWeatherPageIPAD winterWeatherPage = new WinterWeatherPageIPAD();

	@Test(priority = 1, enabled = true)
	public void RW_T1583_VerifyPageNavigationMenuSevereWeatherAndSubMenuWinterWeather_verifyWinterWeatherPage() {
		testStart("Validate user successfullly navigated to winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
	}

	@Test(priority = 2, enabled = true)
	public void RW_T1588_T1590_VerifyNationalWeatherServiceSnowDepthonWinterWeatherPage_verifyUserSeeNationalWeatherServiceMap() {
		testStart("Validate user able to see national weather service map");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		String actualTitle = winterWeatherPage.verifyUserSeeNationalWeatherServiceMap();
		winterWeatherPage.verifyMobilehaveATopAdOnWinterWeatherPage();
		Assert.assertEquals(actualTitle, EXPECTED_MAP_TITLE);
	}

	@Test(priority = 3, enabled = true)
	public void RW_T1586_VerifyNationalForecastMapModuleOnWinterWeatherHomePage_verifyNationalForecastMap() {
		testStart("Verify National Forecast Maps module on winter weather home page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		String actualTitle = winterWeatherPage.verifyNationalForecastMap();
		Assert.assertEquals(actualTitle, EXPECTED_NATIONAL_FORECAST_MAP_TITLE);
	}

	@Test(priority = 4, enabled = true)
	public void RW_T1587_VerifyLocalForecastMapModuleOnWinterWeatherHomePage_verifyLocalForecastMapSearchModule() {
		testStart("Verify Local Forecast Maps module on winter weather home page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyLocalForecastMapSearchModule();
		Assert.assertEquals(actualTitle, EXPECTED_LOCAL_FORECAST_MAP_TITLE);
	}

	@Test(priority = 5, enabled = true)
	public void RW_T1696_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModule() {
		testStart("Verify read more button is present in right rail module");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyReadMoreButtonPresntInRightRailModule());
	}

	@Test(priority = 6, enabled = true)
	public void RW_T1696_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModuleColor() {
		testStart("Verify read more button is present in right rail module is higlighted in blue color");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		String actualColor = winterWeatherPage.verifyReadMoreButtonPresntInRightRailModuleColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}

	@Test(priority = 7, enabled = true)
	public void RW_T1597_ValidateWinterWeatherInMegaMenuWintereWeather_verifyWinterWeatherSubmenuDescription() {
		testStart("Validate Winter Weather in mega menu-: Winter Weather");
		navigationBar.mouseHoverOnSeverWeather();
		String actualDescription = winterWeatherPage.verifyWinterWeatherSubmenuDescription();
		Assert.assertEquals(actualDescription, EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION);
	}

	@Test(priority = 8, enabled = true)
	public void RW_T1597_1596_1585_ValidateWinterWeatherInMegaMenuWintereWeather_verifyWinterWeatherTabIsPresentAndColor() {
		testStart("Validate Winter Weather in mega menu-: Winter Weather tab and color");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		String actualColor = winterWeatherPage.verifyWinterWeatherTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}

	@Test(priority = 9, enabled = true)
	public void RW_T1572_verifyTertiaryNavigationWinterHomeTabActiveAndWinterPreparednessTabOnWinterWeatherPage_verifyWinterHomeTab() {
		testStart("Validate Winter Weather in mega menu-: Winter Weather home and color");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		String actualColor = winterWeatherPage.verifyWinterHomeTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);

	}

	@Test(priority = 10, enabled = true)
	public void RW_T1584_verifyWinterWeatherFooterForEnglishAndFollowsStandardFooterRules_verifyHeadersUnderCompany() {
		testStart("Verify headers under company on winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		winterWeatherPage.validatelinksforCompanyHeader();
	}

	@Test(priority = 11, enabled = true)
	public void RW_T1584_verifyWinterWeatherFooterForEnglishAndFollowsStandardFooterRules_validatelinksforProductsandServicesHeader() {
		testStart("Verify headers under company on winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		winterWeatherPage.validatelinksforProductsandServicesHeader();
	}

	@Test(priority = 12, enabled = true)
	public void RW_T1584_verifyWinterWeatherFooterForEnglishAndFollowsStandardFooterRules_validatelinksDisplayedunderAppsandDownloads() {
		testStart("Verify headers under company on winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		winterWeatherPage.validatelinksDisplayedunderAppsandDownloads();
	}

	@Test(priority = 13, enabled = true)
	public void RW_T1584_verifyWinterWeatherFooterForEnglishAndFollowsStandardFooterRules_subscriptionServicesContainsLink() {
		testStart("Verify headers under company on winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		winterWeatherPage.subscriptionServicesContainsLink("AccuWeather Premium");
		winterWeatherPage.subscriptionServicesContainsLink("AccuWeather Professional");
	}

}
