package com.accuweather.glacier.m.Localizations;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.LocalizationsMobileIos;
import com.accuweather.glacier.www.pages.NavigationBar;

public class TestLocalizationIOS extends AccuWeatherMobileBaseTest {
	String location = "Mumbai, MH, IN";
	String locationMunich = "Munich, Germany";
	String locationRio = "Rio de Janeiro, Brazil";
	String locationRoyaOak = "Royal oak,Mi,US";
	
	String submenuTitle = "Weather News";
	private String expectedMapsSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
	private String expectedSatelliteSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
	private String expectedSevereSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/br/national/severe-weather-maps";
	private String expectedSatelliteImage_URL = "https://qualityassurance.accuweather.com/en/br/national/satellite";
	private String expectedMapsDescription = "Visualize past, present, and future weather from many angles via both static and interactive maps";
	private String expectedSatelliteDescription = "Satellite maps for visualizing where there is cloud cover and associated precipitation";
	private String expectedSevereDescription = "Currently active global watches and warnings, lightning, and severe weather risk";
	private String expectedSatelliteSubMenuMapTitle = "Brazil Satellite Image";
	private String expectedSatelliteSubMenuMapDescription = "Current satellite image showing cloud coverage";

	LocalizationsMobileIos localization = new LocalizationsMobileIos();
	private NavigationBar navBar = new NavigationBar();
	private LandingPageMobile landingPage = new LandingPageMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();

	@Test(priority = 1, enabled = true)
	public void TC1_verify_PresenceOfMaps_OnTopNavigation() {
		testStart("Validate  whether Maps category is present on top level naviagtion");
		landingPage.enterZipcodeInSearchFieldAndClick(location);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		try {
			Assert.assertTrue(cityRadar.clickBreadCrumbMenuMaps());
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	} 

	@Test(priority = 2, enabled = true)
	public void TC2_verify_CityForecastPageMap_Categories() {
		testStart("Validate maps categories on the city forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(location);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuMaps();
		try {
			Assert.assertTrue(cityRadar.clickbyBreadCrumbMenuSatellite());
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}

	} 

	/*
	 * @Test(priority = 3,enabled = true) public void
	 * TC3_verify_MapsSubmenu_Description() {
	 * testStart("Validate Maps submenu description");
	 * landingPage.enterZipcodeInSearchField(location);
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable(); try {
	 * Assert.assertEquals(localization.getMapsSubmenuDescription(),
	 * expectedMapsDescription); } catch (AssertionError ae) {
	 * System.out.println(ae.getMessage());
	 * Assert.fail("Maps submenu description is not matching"); } } //NA
	 */
	
	
	/*
	 * @Test(priority = 4, enabled = true) public void
	 * TC4__validation_Of_MapsSubmenu_URL() {
	 * testStart("Validate the URL of Maps submenu page");
	 * landingPage.enterZipcodeInSearchField(location);
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable(); navBar.isMapsSubMenuDisplayed();
	 * navBar.clickOnMapsSubMenu(); waitUntilWindowExistsWithTitle(submenuTitle);
	 * try { Assert.assertEquals(getDriver().getCurrentUrl(),
	 * expectedMapsSubmenuPage_URL); } catch (AssertionError ae) {
	 * System.err.println(ae.getMessage()); Assert.fail(); } } //NA
	 */
	
	
	/*
	 * @Test(priority = 5, enabled = true) public void
	 * TC5_verify_SatelliteSubmenu_Description() {
	 * testStart("Validate Satellite submenu description");
	 * landingPage.enterZipcodeInSearchField(location);
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable(); try {
	 * Assert.assertEquals(localization.getSatelliteSubmenuDescription(),
	 * expectedSatelliteDescription); } catch (AssertionError ae) {
	 * System.out.println(ae.getMessage());
	 * Assert.fail("Satellite submenu description is not matching"); } } //NA
	 */
	
	
	@Test(priority = 6, enabled = true)
	public void TC6__validation_Of_SatelliteSubmenu_URL() {
		testStart("Validate the URL of Satellite submenu page");
		landingPage.enterZipcodeInSearchFieldAndClick(location);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuMaps();
		cityRadar.clickbyBreadCrumbMenuSatellite();
		try {
			waitUntilElementIsDisplayedOrClickable();
			Assert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteSubmenuPage_URL);
		} catch (AssertionError ae) {
			System.err.println(ae.getMessage());
			Assert.fail();
		}
	} 

	@Test(priority = 7, enabled = true)
	public void TC7_verify_PresenceOfSevere_UnderMaps() {
		testStart("Verify the Severe submenu is present under Maps");
		landingPage.enterZipcodeInSearchFieldAndClick(locationMunich);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		Assert.assertTrue(cityRadar.clickbyBreadCrumbMenuSevere());
		waitUntilElementIsDisplayedOrClickable();
	} 

	/*
	 * @Test(priority = 8, enabled = true) public void
	 * TC8_verify_SevereSubmenu_Description() {
	 * testStart("Validate Severe submenu description");
	 * landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable(); try {
	 * Assert.assertEquals(localization.getSevereSubmenuDescription(),
	 * expectedSevereDescription); } catch (AssertionError ae) {
	 * System.out.println(ae.getMessage());
	 * Assert.fail("Satellite submenu description is not matching"); } } //NA
	 */
	
	
	@Test(priority = 9, enabled = true)
	public void TC9__validation_Of_SevereSubmenu_URL() {
		testStart("Validate the URL of Severe submenu under Maps");
		landingPage.enterZipcodeInSearchFieldAndClick(locationRio);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadCrumbMenuRadarAndMaps();
		cityRadar.clickbyBreadCrumbMenuSevere();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedSevereSubmenuPage_URL);
	} 

	/*
	 * @Test(priority = 10, enabled = true) public void
	 * TC10__verify_SatelliteSubMenu_Map_Title() {
	 * testStart("Locate Satellite under Maps and verify description below the Maps"
	 * ); landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable();
	 * 
	 * waitUntilWindowExistsWithTitle(submenuTitle); try {
	 * Assert.assertEquals(localization.getSatelliteSubMenuMapTitle(),
	 * expectedSatelliteSubMenuMapTitle); } catch (AssertionError ae) {
	 * System.err.println(ae.getMessage()); Assert.fail(); } } //NA
	 */
	
	
	/*
	 * @Test(priority = 11, enabled = true) public void
	 * TC11__verify_SatelliteSubMenu_Map_Description() {
	 * testStart("Locate Satellite under Maps and verify the title of the map");
	 * landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable();
	 * 
	 * waitUntilWindowExistsWithTitle(submenuTitle); try {
	 * Assert.assertEquals(localization.getSatelliteSubMenuMapDescription(),
	 * expectedSatelliteSubMenuMapDescription); } catch (AssertionError ae) {
	 * System.err.println(ae.getMessage()); Assert.fail(); } } //NA
	 */

	/*
	 * @Test(priority = 12, enabled = true) public void
	 * TC12__validation_Of_SatelliteImage_URL() {
	 * testStart("Click on the satellite image under Maps and Validate the URL");
	 * landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
	 * landingPage.clickOnZipcodeSearchIcon(); navBar.mouseHoverOnMaps();
	 * waitUntilElementIsDisplayedOrClickable(); localization.clickSatelliteImage();
	 * waitUntilWindowExistsWithTitle(submenuTitle); try {
	 * Assert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteImage_URL);
	 * } catch (AssertionError ae) { System.err.println(ae.getMessage());
	 * Assert.fail(); } } //NA
	 */
	
	
	@Test(priority = 13, enabled = true)
	public void TC13__verfiy_PresenceOf_MinuteCast() {
		testStart("Verify the prescence of minutecast on city forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(locationRoyaOak);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(localization.isMinutecastPresent());
	} 

	@Test(priority = 14, enabled = true)
	public void TC14_change_Temperature_F_To_C() {
		testStart("Change the temperature from F to C");
		landingPage.enterZipcodeInSearchFieldAndClick(locationRoyaOak);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadcrumbTemperatureToggleMenu();
		Assert.assertTrue(localization.changeTemperatureFromFarenheitToCelcius());
		cityRadar.clickBreadCrumbMenu();
		cityRadar.clickBreadcrumbTemperatureToggleMenu();
	} 

	@Test(priority = 15, enabled = true)
	public void TC13__verfiy_abcenseOf_MinuteCast() {
		testStart("Verify the prescence of minutecast on city forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(location);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		Assert.assertTrue(localization.isMinutecastPresent());
	
	
	}

}
