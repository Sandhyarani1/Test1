package com.accuweather.glacier.m.homePageNonUS;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.HomePageNonUSMobile;
import com.accuweather.glacier.m.pages.HomePageNonUSMobileAndroid;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.ThreeDayForecastPage;

public class Test_HomePageNonUsPageMobileAndroid extends AccuWeatherMobileBaseTest {
	String zipcode = "48073";
	String zipcodeJapan = "Tokyo, Japan";
	String satelliteRadarCountry = "Tokyo, Japan";
	String expectedNavigationMenu = "AHORA";
	String expectedMapTitle = "RADAR METEOROLÓGICO EN ESTADOS UNIDOS";
	String expectedMapTitleOfSatelliteRadarCountry = "RADAR METEOROLÓGICO EN ESTADOS UNIDOS";
	String expectedMapCTA = "MÁS MAPAS";
	String satelliteCountry = "Buenos Aires, Argentina";
	String expectedMapTitleOfSatelliteCountry = "ARGENTINA SATELLITE";
	String expectedSatelliteMapCTA = "MORE MAPS";
	String expectedMapTitleOfRadarCountry = "JAPAN WEATHER RADAR";
	String expectedMapTitleOfUS = "UNITED STATES WEATHER RADAR";

	private LandingPageMobile landingPage = new LandingPageMobile();
	private NavigationBar navBar = new NavigationBar();
	private HomePageNonUSMobileAndroid homePage = new HomePageNonUSMobileAndroid();
	private ThreeDayForecastPage threedayForecastPage = new ThreeDayForecastPage();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T745_ValidateTranslationOnBreadcrumbs_verifyCityPageTranslatedInSelectedLanguage() {
		testStart("Verify city page get translated in selected langauge");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		String actualMenu = homePage.verifyCityPageTranslatedInSelectedLanguage();
		Assert.assertEquals(expectedNavigationMenu, actualMenu);
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();

	} 

	@Test(priority = 2, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyMapTitleNonEnglishLanguage() {
		testStart("Verify map title is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		Assert.assertEquals(actualMapTitle,expectedMapTitle);
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 3, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyMapsCTANonEnglishLanguage() {
		testStart("Verify map cta is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		Assert.assertEquals(expectedMapCTA, actualMapCTA);
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 4, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_verify20LocationsOfCountry() {
		testStart("Change the language to non-english and verify 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verify20LocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 5, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyWeathericonForAllLocationsOfCountry() {
		testStart("Verify weather for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verifyWeathericonForAllLocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	}

	@Test(priority = 6, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_verifyTemperatureForAllLocationsOfCountry() {
		testStart("Verify temperature for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verifyTemperatureForAllLocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 7, enabled = true)
	public void RW_T743_HomePageWithNonEnglishValidation_clickAnyLocationAndUserNavigatedTo3DayForecastPage() {
		testStart("Click one of the locations and verify user navigated to three day forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		homePage.clickLocation();
		Assert.assertTrue(homePage.fourWeathercardisDisplayed());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 8, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_verifyMapTitleIsNonEnglishLanguage() {
		testStart("Verify map title is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		Assert.assertEquals(actualMapTitle,expectedMapTitleOfSatelliteRadarCountry);
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 9, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_verifyMapsCTANonEnglishLanguage() {
		testStart("Verify map cta is in non-English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		Assert.assertEquals(expectedMapCTA, actualMapCTA);
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();

	} 

	@Test(priority = 10, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_verify20LocationsOfCountry() {
		testStart("Change the language to non-english and verify 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcodeJapan);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verify20LocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	}

	@Test(priority = 11, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_verifyWeathericonForAllLocationsOfCountry() {
		testStart("Verify weather for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcodeJapan);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verifyWeathericonForAllLocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	} 

	@Test(priority = 12, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_verifyTemperatureForAllLocationsOfCountry() {
		testStart("Verify temperature for all 20 locations of the country");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcodeJapan);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		Assert.assertTrue(homePage.verifyTemperatureForAllLocationsOfCountry());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();
	}

	@Test(priority = 13, enabled = true)
	public void RW_T741_SatelliteAndRadarCountry_clickAnyLocationAndUserNavigatedTo3DayForecastPage() {
		testStart("Click one of the locations and verify user navigated to three day forecast page");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcodeJapan);
		landingPage.clickOnZipcodeSearchIcon();
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobile();
		homePage.clickLogo();
		homePage.clickLocation();
		Assert.assertTrue(homePage.fourWeathercardisDisplayed());
		cityRadar.clickBreadCrumbMenu();
		homePage.clickBreadCrumbMenulanguageSelect();
		homePage.clickBreadCrumbMenulanguageSelectMobileEnglish();

	} 

	@Test(priority = 14, enabled = true)
	public void RW_T740_SatelliteCountryEnglish_verifyMapTitleIsEnglishLanguage() {
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteCountry);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		Assert.assertEquals(actualMapTitle,expectedMapTitleOfSatelliteCountry);

	} 

	@Test(priority = 15, enabled = true)
	public void RW_T740_SatelliteCountryWithEnglish_verifyMapsCTAIsEnglishLanguage() {
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteCountry);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapCTALanguage();
		Assert.assertEquals(actualMapTitle,expectedSatelliteMapCTA);

	} 

	@Test(priority = 16, enabled = true)
	public void RW_T739_RadarCountryCountryWithEnglish_verifyMapTitleIsEnglishLanguage() {
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		Assert.assertEquals(actualMapTitle,expectedMapTitleOfRadarCountry);
	} 

	@Test(priority = 17, enabled = true)
	public void RW_T739_RadarCountryCountryWithEnglish_verifyMapsCTAIsEnglishLanguage() {
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(satelliteRadarCountry);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		Assert.assertEquals(actualMapCTA,expectedSatelliteMapCTA);

	}

	@Test(priority = 18, enabled = true)
	public void RW_T742_UsHomePageWithEnglish_verifyMapTitleIsEnglishLanguage() {
		testStart("Verify map title is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapTitle = homePage.verifyMapTitleLanguage();
		Assert.assertEquals(actualMapTitle,expectedMapTitleOfUS);

	}

	@Test(priority = 19, enabled = true)
	public void RW_T742_UsHomePageWithEnglish_verifyMapsCTAIsEnglishLanguage() {
		testStart("Verify map cta is in English language");
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		homePage.navigateToHomePageByLogo();
		String actualMapCTA = homePage.verifyMapCTALanguage();
		Assert.assertEquals(actualMapCTA,expectedSatelliteMapCTA);
	}
}
