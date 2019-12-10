package com.accuweather.glacier.m.WinterWeatherIOS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.WinterWeatherPageIOS;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.utils.Sleeper;

public class Test_WinterWeatherIOS extends AccuWeatherMobileBaseTest {
	private String EXPECTED_WINTERWEATHER_URL = "https://qualityassurance.accuweather.com/en/us/winter-weather";
	private String EXPECTED_MAP_TITLE = "NATIONAL WEATHER SERVICE - SNOW DEPTH";
	private String EXPECTED_NATIONAL_FORECAST_MAP_TITLE = "NATIONAL 24-HOUR SNOWFALL FORECAST MAP";
	private String EXPECTED_LOCAL_FORECAST_MAP_TITLE = "LOCAL FORECAST MAPS";
	private String EXPECTED_COLOR = "#2cabdc";
	private String EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION = "Provides winter weather forecasts and the winter weather outlook for your area";
	String zipcode = "48073";

	private LandingPageMobile landingPage = new LandingPageMobile();
	private NavigationBar navigationBar = new NavigationBar();
	private WinterWeatherPageIOS winterWeatherPage = new WinterWeatherPageIOS();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T1570_VerifyPageNavigationMenuSevereWeatherAndSubMenuWinterWeather_verifyWinterWeatherPage() {
		testStart("Validate user successfullly navigated to winter weather page");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
	}

	@Test(priority = 2, enabled = true)
	public void RW_T1588_VerifyNationalWeatherServiceSnowDepthonWinterWeatherPage_verifyUserSeeNationalWeatherServiceMap() {
		testStart("Validate user able to see national weather service map");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyUserSeeNationalWeatherServiceMap();
		Assert.assertEquals(actualTitle, EXPECTED_MAP_TITLE);
	}

	@Test(priority = 3, enabled = true)
	public void RW_T1573_VerifyNationalForecastMapModuleOnWinterWeatherHomePage_verifyNationalForecastMap() {
		testStart("Verify National Forecast Maps module on winter weather home page");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyNationalForecastMap();
		Assert.assertEquals(actualTitle, EXPECTED_NATIONAL_FORECAST_MAP_TITLE);
	}

	@Test(priority = 4, enabled = true)
	public void RW_T1587_VerifyLocalForecastMapModuleOnWinterWeatherHomePage_verifyLocalForecastMapSearchModule() {
		testStart("Verify Local Forecast Maps module on winter weather home page");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyLocalForecastMapSearchModule();
		Assert.assertEquals(actualTitle, EXPECTED_LOCAL_FORECAST_MAP_TITLE);
	}

	@Test(priority = 5, enabled = true)
	public void RW_T1586_VerifyNationalForecastMapsmoduleonwinterweatherhomepage() {
		testStart("Verify National Forecast Maps module on winter weather home page-MOBILE");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyNationalForecastMapsModule());
	}

	@Test(priority = 6, enabled = true)
	public void RW_T1590_VerifyMobilehaveATopAdOnWinterWeatherPage() {
		testStart("Verify Mobile have a top ad on winter weather page");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyMobilehaveATopAdOnWinterWeatherPage());
	}

	@Test(priority = 7, enabled = true)
	public void RW_T1696_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModule() {
		testStart("Verify read more button is present in right rail module");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		Assert.assertTrue(winterWeatherPage.verifyReadMoreButtonPresntInRightRailModule());
	}

	@Test(priority = 8, enabled = true)
	public void RW_T1596_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModuleColor() {
		testStart("Verify read more button is present in right rail module is higlighted in blue color");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyReadMoreButtonPresntInRightRailModuleColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}

	@Test(priority = 9, enabled = true)
	public void RW_T1583_ValidateWinterWeatherInMegaMenuWintereWeather_verifyWinterWeatherTabIsPresentAndColor() {
		testStart("Validate Winter Weather in mega menu-: Winter Weather tab and color");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyWinterWeatherTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}

	@Test(priority = 10, enabled = true)
	public void RW_T1585_verifyTertiaryNavigationWinterHomeTabActiveAndWinterPreparednessTabOnWinterWeatherPage_verifyWinterHomeTab() {
		testStart("Validate Winter Weather in mega menu-: Winter Weather home and color");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyWinterHomeTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);

	}

	@Test(priority = 11, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterforEnglishandfollowsstandardfooterRules() {
		testStart("Verify Winter Weather Footer for English and follows standard footer rules");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterIsInEnglish());
	}

	@Test(priority = 12, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterMainComponents() {
		testStart("Verify Winter Weather Footer Main Components");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterMainComponents());
	}

	@Test(priority = 13, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterCompanyComponents() {
		testStart("Verify Winter Weather Footer Company Components");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterCompanyComponents());
	}

	@Test(priority = 14, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterProductsAndSerivesComponents() {
		testStart("Verify Winter Weather Footer Products And Serive sComponents");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterProductsAndSerivesComponents());
	}

	@Test(priority = 15, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterAppsAndDownLoadsComponents() {
		testStart("Verify Winter Weather Footer Apps And DownLoads Components");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterAppsAndDownLoadsComponents());
	}

	@Test(priority = 16, enabled = true)
	public void RW_T1584_VerifyWinterWeatherFooterSubscriptionServicesComponents() {
		testStart("Verify Winter Weather Footer Subscription Service Components");
		winterWeatherPage.clickBreadCrumbMenu();
		winterWeatherPage.clickSevereWeatherMenu();
		winterWeatherPage.clickWinterWeatherMenu();
		Sleeper.sleep(2);
		Assert.assertTrue(winterWeatherPage.verifyWinterWeatherFooterSubscriptionServicesComponents());
	}

}
