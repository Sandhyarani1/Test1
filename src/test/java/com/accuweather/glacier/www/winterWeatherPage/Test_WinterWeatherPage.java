package com.accuweather.glacier.www.winterWeatherPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.SeachResultsPage;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;
import com.accuweather.glacier.www.pages.WinterWeatherPage;
import com.chameleon.utils.Randomness;
import com.chameleon.utils.Sleeper;

public class Test_WinterWeatherPage extends AccuWeatherBaseTest 
{
	private String EXPECTED_WINTERWEATHER_URL = "https://qualityassurance.accuweather.com/en/us/winter-weather";
	private String EXPECTED_MAP_TITLE = "NATIONAL WEATHER SERVICE - SNOW DEPTH";
	private String EXPECTED_NATIONAL_FORECAST_MAP_TITLE = "NATIONAL 24-HOUR SNOWFALL FORECAST MAP";
	private String EXPECTED_LOCAL_FORECAST_MAP_TITLE = "LOCAL FORECAST MAPS";
	private String EXPECTED_COLOR = "#2cabdc";
	private String EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION = "Provides winter weather forecasts and the winter weather outlook for your area";
	
	private LandingPage landingPage = new LandingPage();
	private NavigationBar navigationBar = new NavigationBar();
	private WinterWeatherPage winterWeatherPage = new WinterWeatherPage();
	
	@Test(priority=1)
	public void RW_T1570_VerifyPageNavigationMenuSevereWeatherAndSubMenuWinterWeather_verifyWinterWeatherPage()
	{
		testStart("Validate user successfullly navigated to winter weather page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
	}
	
	@Test(priority=1)
	public void RW_T1576_VerifyNationalWeatherServiceSnowDepthonWinterWeatherPage_verifyUserSeeNationalWeatherServiceMap()
	{
		testStart("Validate user able to see national weather service map");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyUserSeeNationalWeatherServiceMap();
        Assert.assertEquals(actualTitle, EXPECTED_MAP_TITLE);
	}
	
	@Test(priority=1)
	public void RW_T1573_VerifyNationalForecastMapModuleOnWinterWeatherHomePage_verifyNationalForecastMap()
	{
		testStart("Verify National Forecast Maps module on winter weather home page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyNationalForecastMap();
        Assert.assertEquals(actualTitle, EXPECTED_NATIONAL_FORECAST_MAP_TITLE);
	}
	
	@Test(priority=1)
	public void RW_T1574_VerifyLocalForecastMapModuleOnWinterWeatherHomePage_verifyLocalForecastMapSearchModule()
	{
		testStart("Verify Local Forecast Maps module on winter weather home page");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualTitle = winterWeatherPage.verifyLocalForecastMapSearchModule();
        Assert.assertEquals(actualTitle, EXPECTED_LOCAL_FORECAST_MAP_TITLE);
	}
	
	@Test(priority=1)
	public void RW_T1695_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModule()
	{
		testStart("Verify read more button is present in right rail module");
		landingPage.enterZipcodeInSearchFieldAndClick("48073");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		Assert.assertTrue(winterWeatherPage.verifyReadMoreButtonPresntInRightRailModule());
	}
	
	@Test(priority=1)
	public void RW_T1695_WinterWeatherRightRail_verifyReadMoreButtonPresntInRihtRailModuleColor()
	{
		testStart("Verify read more button is present in right rail module is higlighted in blue color");
		landingPage.enterZipcodeInSearchFieldAndClick("48073");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyReadMoreButtonPresntInRightRailModuleColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}
	
	@Test(priority=1)
	public void RW_T1597_ValidateWinterWeatherInMegaMenuWintereWeather_verifyWinterWeatherSubmenuDescription()
	{
		testStart("Validate Winter Weather in mega menu-: Winter Weather");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		String actualDescription = winterWeatherPage.verifyWinterWeatherSubmenuDescription();
		Assert.assertEquals(actualDescription, EXPECTED_WINETERWEAHTER_SUBMENU_DESCRIPTION);
	}
	
	@Test(priority=1)
	public void RW_T1597_ValidateWinterWeatherInMegaMenuWintereWeather_verifyWinterWeatherTabIsPresentAndColor()
	{
		testStart("Validate Winter Weather in mega menu-: Winter Weather tab and color");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyWinterWeatherTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
	}
	
	@Test(priority=1)
	public void RW_T1572_verifyTertiaryNavigationWinterHomeTabActiveAndWinterPreparednessTabOnWinterWeatherPage_verifyWinterHomeTab()
	{
		testStart("Validate Winter Weather in mega menu-: Winter Weather home and color");
		navigationBar.mouseHoverOnSeverWeather();
		navigationBar.isWinterWeatherSubMenuDisplayed();
		navigationBar.clickWinterWeatherSubMenu();
		Sleeper.sleep(2);
		Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_WINTERWEATHER_URL);
		String actualColor = winterWeatherPage.verifyWinterHomeTabIsPresentAndColor();
		Assert.assertEquals(actualColor, EXPECTED_COLOR);
		
	}
}
