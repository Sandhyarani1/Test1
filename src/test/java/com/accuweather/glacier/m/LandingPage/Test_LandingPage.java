package com.accuweather.glacier.m.LandingPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;

public class Test_LandingPage extends AccuWeatherMobileBaseTest
{
	int actualLocationSize;
	int expectedLocationSize;
	String zipcode = "16803";
	String zip = "60606";
	String actualLocationName;
	String crumbLocationName;
	String locationName = "Cambridge";
	String expectedCtaTitle = "United States Weather Radar";
	Object actualJWPlayerStatus;
	String actualWeatherRadarTitle;
	String actualCTATitle;
	String expectedJWPlayerStatus = "jwplayer jw-reset jw-state-playing ";
	String expectedForecastPageTitle = "State College Weather - AccuWeather Forecast for PA 16801";
	String expectedWeatherRadarTitle = "United States Doppler Weather Radar Map - AccuWeather.com";
	private LandingPage landingpage = new LandingPage();
	private NavigationBar navBar = new NavigationBar();
	
	  @Test(priority=1, enabled=true) public void TC1_VerifyRecentFirstLocationIsDisplayed() {
	  testStart("Is First Location Displayed Under Recent Location Section");
	  landingpage.isRecentLocationDisplayed(); expectedLocationSize = 1;
	  actualLocationSize = landingpage.getAllLocationsSize();
	  Assert.assertEquals(actualLocationSize, expectedLocationSize); }

	  @Test(priority=2, enabled=true) public void
	  TC1_VerifyDefaultLocationNameAndAkamaiNameAreNotSame() {
	  testStart("Default Location names are not same Under Recent Location Section"
	  ); landingpage.isRecentLocationDisplayed(); actualLocationName =
	  landingpage.getDefaultLocationName();
	  Assert.assertNotSame(actualLocationName, locationName); }

	  /*@Test(priority=3) public void TC1_VerifyDefaultLocationAndCrumbNamesAreSame()
	  { testStart("Are Default Location and Crumb names are same");
	  landingpage.isRecentLocationDisplayed(); actualLocationName =
	  landingpage.getDefaultLocationName(); crumbLocationName =
	  landingpage.getCrumbLocationName(); Assert.assertNotSame(actualLocationName,
	  crumbLocationName); }
	  @Test(priority=4, enabled=true) public void TC2_VerifyRecentTwoLocationsAreDisplayed() {
	  testStart("Are Two recent locations Displayed Under Recent Location Section"
	  ); landingpage.enterZipcodeInSearchField(zip);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.isRecentLocationDisplayed();
	  landingpage.isSecondLocationDisplayed();
	  landingpage.getHrefAttributeOfRecentLocation(); expectedLocationSize = 2;
	  actualLocationSize = landingpage.getAllLocationsSize();
	  Assert.assertEquals(actualLocationSize, expectedLocationSize); }

	  @Test(priority=5, enabled=true) public void TC3_VerifyRecentThreeLocationsAreDisplayed() {
	  testStart("Are Three recent locations Displayed Under Recent Location Section"
	  ); landingpage.enterZipcodeInSearchField(zip);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.enterZipcodeInSearchField(zipcode);
	  landingpage.clickOnZipcodeSearchIcon();
	  waitUntilElementIsDisplayedOrClickable();
	  waitUntilWindowExistsWithTitle(expectedForecastPageTitle);
	  navBar.navigateToHome(); WebPageLoaded.isDomInteractive(1000);
	  landingpage.isRecentLocationDisplayed();
	  landingpage.isSecondLocationDisplayed();
	  landingpage.isThirdLocationDisplayed(); expectedLocationSize = 3;
	  actualLocationSize = landingpage.getAllLocationsSize();
	  Assert.assertEquals(actualLocationSize, expectedLocationSize); }


	  @Test(priority=6) public void TC2_VerifyCTATitleAreSame() {
	  testStart("Verify CTA Title"); actualCTATitle =
	  landingpage.getCTATitle(); Assert.assertEquals(actualCTATitle,
	  expectedCtaTitle); }

	 @Test(priority=7, enabled=true) public void TC9_IsVideoAutoPlayedOnHomePage() throws
	 InterruptedException {
	 testStart("Verify Video is autoplayed on the landing page");
	 WebPageLoaded.isDomInteractive(5000);
	 waitUntilElementIsDisplayedOrClickable(); actualJWPlayerStatus =
	 landingpage.getVideoClassAttribute();
	   Assert.assertEquals(actualJWPlayerStatus,
	 expectedJWPlayerStatus); WebPageLoaded.isDomInteractive(2000); }

	 @Test(priority=8) public void TC10_IsStickyVideoAutoPlayedOnHomePage() throws
	 InterruptedException {
	 testStart("Verify Sticky Video is autoplayed on the landing page");
	 WebPageLoaded.isDomInteractive(5000);
	 waitUntilElementIsDisplayedOrClickable(); actualJWPlayerStatus =
	 landingpage.getStickyVideoClassAttribute();
	 Assert.assertEquals(actualJWPlayerStatus,
	 expectedJWPlayerStatus); WebPageLoaded.isDomInteractive(3000); }

	  @Test(priority=9) public void TC11_IsWeatherRadarImageDisplayedPOnHomePage()
	  { testStart("Verify Weather Radar Image Displayed on the landing page");
	  WebPageLoaded.isDomInteractive(1000);
	  waitUntilElementIsDisplayedOrClickable();
	  Assert.assertTrue(landingpage.isWeatherRadarImageDisplayed()); }

	  @Test(priority=10) public void TC12_IsWeatherRadarDisplayedFromMoreMapsLink()
	  { testStart("Verify Weather Radar Page displayed landing page");
	  WebPageLoaded.isDomInteractive(1000);
	  waitUntilElementIsDisplayedOrClickable(); landingpage.clickMoreMapsLink();
	  WebPageLoaded.isDomInteractive(1000);
	  waitUntilElementIsDisplayedOrClickable(); actualWeatherRadarTitle =
	  getDriver().getTitle(); Assert.assertEquals(actualWeatherRadarTitle,
	  expectedWeatherRadarTitle); }*/
}