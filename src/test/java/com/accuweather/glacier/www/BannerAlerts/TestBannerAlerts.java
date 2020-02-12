package com.accuweather.glacier.www.BannerAlerts;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.BannerAlertsAPI;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.BannerAlerts;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

/**
 * @author HFARAZ
 *         This class deals with the Banner Alerts validations
 *         Test method names starts with JIRA ID as prefix
 */

public class TestBannerAlerts extends AccuWeatherBaseTest
{

	private LandingPage landingPage = new LandingPage();
	private BannerAlerts bannerAlerts = new BannerAlerts();
	SoftAssert softAssert;
	public static String expectedURL = "";
	public static String cityHavingAlerts = "";
	public static String stateHavingAlerts = "";
	public static String countryCodeHavingAlerts = "";
	public static String zipCodeHavingAlerts = "";
	public static String locationKeyHavingAlerts = "";
	public static String cityNameForURL = "";
	public static String location = "";
	public static int alertCount = 0;
	public static String expectedTitle = "";
	public static ArrayList<String> alertsSummaryFromAPI;
	public static ArrayList<String> alertsDescriptionsFromAPI;
	public static ArrayList<String> alertsLocationsFromAPI;
	public static ArrayList<String> alertsHeaderSummaryFromUI;
	public static ArrayList<String> alertsSummaryOnUI;
	public static ArrayList<String> alertsLocationsOnUI;
	public static ArrayList<String> alertsDescriptionsOnUI;
	public static ArrayList<String> alertLogos;
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	public static String alertLogoSourceSuffix = "images/logos/noaa-logo.jpg";
	public static String alertLogo = "";
	
	/**
	 * @author HFARAZ
	 *         Method to set the test data to be used in the test methods
	 */
	public void getTestData(int noOfAlerts)
	{
		BannerAlertsAPI.getAlertsAPIResponse(noOfAlerts);
		cityHavingAlerts = BannerAlertsAPI.getCityNameHavingAlerts();
		stateHavingAlerts = BannerAlertsAPI.getStateCodeHavingAlerts();
		countryCodeHavingAlerts = BannerAlertsAPI.getCountryCodeHavingAlerts();
		zipCodeHavingAlerts = BannerAlertsAPI.getZipCodeHavingAlerts();
		locationKeyHavingAlerts = BannerAlertsAPI.getLocationKeyHavingAlerts();

		location = cityHavingAlerts + ", " + stateHavingAlerts + ", " + countryCodeHavingAlerts;
		cityNameForURL = BannerAlertsAPI.getCityNameHavingAlerts().replace(' ', '-');

		expectedURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + "en/us/" + cityNameForURL + "/"
				+ zipCodeHavingAlerts + "/weather-warnings/" + locationKeyHavingAlerts).toLowerCase();
		alertCount = BannerAlertsAPI.getAlertCount();

		expectedTitle = cityHavingAlerts + ", " + stateHavingAlerts
				+ " Weather Advisories - Warnings & Watches | AccuWeather";

		alertsSummaryFromAPI = new ArrayList<String>();
		alertsSummaryFromAPI = BannerAlertsAPI.getAlertSummary();
		
		alertsDescriptionsFromAPI = new ArrayList<String>();
		alertsDescriptionsFromAPI = BannerAlertsAPI.getAlertDescription();
		
		alertsLocationsFromAPI = new ArrayList<String>();
		alertsLocationsFromAPI = BannerAlertsAPI.getAlertLocations();
		
		alertsHeaderSummaryFromUI = new ArrayList<String>();
		alertsSummaryOnUI = new ArrayList<String>();
		alertLogos = new ArrayList<String>();
		alertsDescriptionsOnUI = new ArrayList<String>();
		alertsLocationsOnUI = new ArrayList<String>();
		alertLogo = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+alertLogoSourceSuffix;
	}

	@Test(priority = 1)
	public void RW_T182_GovernmentIssuedAlertsValidation()
	{
		//Getting test data for location having one alert
		getTestData(1);
		softAssert = new SoftAssert();

		testStart(
				"********Verification of presence of Banner Alerts, Alert Summary Validation, URL validation, Title Validation, Number of Alerts on the recent search location********");

		landingPage.enterCityNameInSearchField(cityHavingAlerts);
		landingPage.selectCityFromTheList(location);

		// Verifying the presence of alert banner
		softAssert.assertTrue(bannerAlerts.presenceOfAlertBannerBar(),
				"Issue------->Alert Banner not found on UI for location-->City Name: " + cityHavingAlerts
						+ " ------>ZipCode: " + zipCodeHavingAlerts + "-------->");

		// Verifying the alert summary
		softAssert.assertEquals(bannerAlerts.getAlertsSummary().replaceAll("\\s+", ""),
				alertsSummaryFromAPI.get(0).replaceAll("\\s+", ""),
				"Issue------>Alert Summary on UI not matching with API for location-->City Name: " + cityHavingAlerts
						+ " ------>ZipCode: " + zipCodeHavingAlerts + "--------->");

		bannerAlerts.clickAlert();
		
		// Verifying the URL on Alert Page
				softAssert.assertEquals(getDriver().getCurrentUrl(), expectedURL,
						"Issue--------> Wrong URL of alert page------->");

				// verifying the title on Alert page
				softAssert.assertEquals(getDriver().getTitle(), expectedTitle,
						"\nIssue-----> Title of the alert page not as expected");

		// Verifying the presence of alert banner on alert page
		softAssert.assertTrue(bannerAlerts.presenceOfAlertBannerBar(),
				"Issue------->Alert Banner not found on UI for location-->City Name: " + cityHavingAlerts
						+ " ------>ZipCode: " + zipCodeHavingAlerts + "-------->");

		// Verifying the alert summary on the header of alert page
		alertsHeaderSummaryFromUI = bannerAlerts.getAlertHeaderSummary();
		for(int i=0;i<alertsHeaderSummaryFromUI.size();i++)
		{
			softAssert.assertEquals(alertsHeaderSummaryFromUI.get(i).replaceAll("\\s+", ""),
					alertsSummaryFromAPI.get(i).replaceAll("\\s+", ""),
					"Issue----->Alert Header Summary not matching on alert warning page----->");
		}

		landingPage.clickAccuWeatherLogo();

		// verifying the alert count on the recent locations below search bar
		softAssert.assertEquals(bannerAlerts.getAlertCountOnRecentLocation(
				(cityHavingAlerts + "," + stateHavingAlerts).replaceAll("\\s+", "")), alertCount,
				"\n Issue----> Alert count mentioned at the top of recently searched location not matching with the API count");
		
		// Verifying the presence of alert banner on Home Page
				softAssert.assertFalse(bannerAlerts.presenceOfAlertBannerBar(),
						"Issue------->Alert Banner found on home page after navigating from alert page for location-->City Name: "
								+ cityHavingAlerts + " ------>ZipCode: " + zipCodeHavingAlerts + "-------->");

		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void RW_T183_MultipleAlertsValidations()
	{
		getTestData(2);
		softAssert = new SoftAssert();

		testStart("********Verification of two alerts********");

		landingPage.enterZipcodeInSearchField(zipCodeHavingAlerts);
		landingPage.selectCityFromTheList(location);

		// Verifying the presence of multiple alerts banner
		softAssert.assertTrue(bannerAlerts.presenceOfMultipleAlertsBanner(),
				"Issue-----> Multiple alerts not found on the page-----");

		// Verifying the presence of alert bars as per the alert count
		softAssert.assertEquals(bannerAlerts.alertBannerCount(), alertCount);

		// Verifying the alert Summary for the two the alerts
		alertsSummaryOnUI = bannerAlerts.getMultipleAlertsSummary();
		for (int i=0;i<alertsSummaryOnUI.size();i++)
		{
			softAssert.assertEquals(BannerAlerts.alertsSummary.get(i).replaceAll("\\s+", ""),
					alertsSummaryOnUI.get(i).replaceAll("\\s+", ""),
					"Issue-----> Alert Summary not matching for the alert "+i+" for city--->" + cityHavingAlerts
							+ " and zipcode---->" + zipCodeHavingAlerts);
		}
		
		bannerAlerts.clickAlert();
		
		// Verifying the alert summaries on the header of alert page
		alertsHeaderSummaryFromUI = bannerAlerts.getAlertHeaderSummary();
		for(int i=0;i<alertsHeaderSummaryFromUI.size();i++)
		{
			softAssert.assertEquals(alertsHeaderSummaryFromUI.get(i).replaceAll("\\s+", ""),alertsSummaryFromAPI.get(i).replaceAll("\\s+", ""),
							"Issue----->Alert Header Summary not matching on alert warning page----->");
		}
		
		// Verifying the source of logo image on all the alerts
		alertLogos = bannerAlerts.verifyLogos();
		for(int i=0;i<alertLogos.size();i++)
		{
			softAssert.assertEquals(alertLogos.get(i),alertLogo,
									"Issue----->Logo source not matching on alert warning page----->");
		}
		
		//Verifying the alert locations for all the alerts on UI
		alertsLocationsOnUI = bannerAlerts.getAlertLocation();
		for(int i=0;i<alertsLocationsOnUI.size();i++)
		{
			softAssert.assertEquals(alertsLocationsOnUI.get(i),alertsLocationsFromAPI.get(i),
					"Issue----->Alert Locations not matching on alert warning page----->");
		}
		
		//Verifying the alert locations for all the alerts on UI
		alertsDescriptionsOnUI = bannerAlerts.getAlertDescription();
		for(int i=0;i<alertsDescriptionsOnUI.size();i++)
		{
			softAssert.assertEquals(alertsDescriptionsOnUI.get(i),alertsDescriptionsFromAPI.get(i),
					"Issue----->Alert Descriptions not matching on alert warning page----->");
		}
		
		softAssert.assertAll();

	}

}
