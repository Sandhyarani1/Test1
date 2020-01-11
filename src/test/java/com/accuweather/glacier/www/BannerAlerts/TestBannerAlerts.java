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

public class TestBannerAlerts extends AccuWeatherBaseTest {

	private LandingPage landingPage = new LandingPage();
	private BannerAlerts bannerAlerts = new BannerAlerts();
	SoftAssert softAssert;
	public static String expectedURL = "";
	public static String cityHavingAlerts="";
	public static String stateHavingAlerts="";
	public static String countryCodeHavingAlerts="";
	public static String zipCodeHavingAlerts="";
	public static String locationKeyHavingAlerts="";
	public static String cityNameForURL="";
	public static String location="";
	public static int alertCount=0;
	public static String expectedTitle="";
	public static ArrayList<String> alertsSummary;
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	
	public void getTestData(int noOfAlerts)
	{
		BannerAlertsAPI.getAlertsAPIResponse(noOfAlerts);
		cityHavingAlerts = BannerAlertsAPI.getCityNameHavingAlerts();
		stateHavingAlerts = BannerAlertsAPI.getStateNameHavingAlerts();
		countryCodeHavingAlerts = BannerAlertsAPI.getCountryCodeHavingAlerts();
		zipCodeHavingAlerts = BannerAlertsAPI.getZipCodeHavingAlerts();
		locationKeyHavingAlerts = BannerAlertsAPI.getLocationKeyHavingAlerts();
		
		location = cityHavingAlerts+", "+stateHavingAlerts+", "+countryCodeHavingAlerts;
		cityNameForURL = BannerAlertsAPI.getCityNameHavingAlerts().replace(' ', '-');
		expectedURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA)+"/en/us/"+cityNameForURL+"/"+zipCodeHavingAlerts+"/weather-warnings/"+locationKeyHavingAlerts).toLowerCase();
		alertCount = BannerAlertsAPI.getAlertCount();
		expectedTitle = cityHavingAlerts+", "+stateHavingAlerts+" Weather Advisories - Warnings & Watches | AccuWeather";
		alertsSummary = new ArrayList<String>();
		alertsSummary = BannerAlertsAPI.getAlertSummary();
	}
	
	
	  @Test(priority=1)
	  public void RW_T182()
	  {
		  getTestData(1);
		  softAssert =  new SoftAssert();
		  
		  testStart("********Verification of presence of Banner Alerts, Alert Summary Validation, URL validation, Title Validation, Number of Alerts on the recent search location********");
		  landingPage.enterZipcodeInSearchField(cityHavingAlerts);
		  landingPage.selectCityFromTheList(location);
		  
		  //Verifying the presence of alert banner
		  softAssert.assertTrue(bannerAlerts.presenceOfAlertBannerBar(),
				  				"Issue------->Alert Banner not found on UI for location-->City Name: "+cityHavingAlerts+" ------>ZipCode: "+
				  						zipCodeHavingAlerts+"-------->");
		  
		  //Verifying the alert summary
		  softAssert.assertEquals(bannerAlerts.getAlertsSummary().replaceAll("\\s+",""),alertsSummary.get(0).replaceAll("\\s+",""),
				  				"Issue------>Alert Summary on UI not matching with API for location-->City Name: "+cityHavingAlerts+" ------>ZipCode: "+
				  						zipCodeHavingAlerts+"--------->");
		  
		  bannerAlerts.clickAlert();
		  
		  //Verifying the presence of alert banner on alert page
		  softAssert.assertTrue(bannerAlerts.presenceOfAlertBannerBar(),
	  				"Issue------->Alert Banner not found on UI for location-->City Name: "+cityHavingAlerts+" ------>ZipCode: "+
	  						zipCodeHavingAlerts+"-------->");
		  
		  //Verifying the alert summary on the header of alert page
		  softAssert.assertEquals(bannerAlerts.getAlertHeaderSummary().replaceAll("\\s+",""), alertsSummary.get(0).replaceAll("\\s+",""),"Issue----->Alert Header Summary not matching on alert warning page----->");
		  
		  //Verifying the URL
		  softAssert.assertEquals(getDriver().getCurrentUrl(), expectedURL,
				  "Issue--------> Wrong URL of alert page------->");
		  
		  //verifying the title
		  softAssert.assertEquals(getDriver().getTitle(), expectedTitle);
		  
		  landingPage.clickAccuWeatherLogo();
		  
		  //verifying the alert count on the recent locations below search bar
		  softAssert.assertEquals(bannerAlerts.getAlertCountOnRecentLocation((cityHavingAlerts+","+stateHavingAlerts).replaceAll("\\s+","")), alertCount);
		  
		  softAssert.assertAll();
		  
	  }
	  
	
	
	  @Test(priority = 2)
	  public void RW_T1796() 
	  {
		  getTestData(1);
		  softAssert =  new SoftAssert();
		  testStart("********Verification that alert banner is not present at the home page********");
		  landingPage.enterZipcodeInSearchField(cityHavingAlerts);
		  landingPage.selectCityFromTheList(location);
		  
		  //Verifying the presence of alert banner
		  softAssert.assertTrue(bannerAlerts.presenceOfAlertBannerBar(),
	  				"Issue------->Alert Banner not found on UI for location-->City Name: "+cityHavingAlerts+" ------>ZipCode: "+
	  						zipCodeHavingAlerts+"-------->");
		  
		  landingPage.clickAccuWeatherLogo();
		  
		  //Verifying the presence of alert banner on Home Page
		  softAssert.assertFalse(bannerAlerts.presenceOfAlertBannerBar(),
	  "Issue------->Alert Banner found on home page after navigating from alert page for location-->City Name: "
	  +cityHavingAlerts+" ------>ZipCode: "+
	  zipCodeHavingAlerts+"-------->"); 
		  
		  softAssert.assertAll();
	  }
	  
	  @Test(priority=3)
	  public void RW_T183()
	  {
		  getTestData(2);
		  softAssert = new SoftAssert();
		  testStart("********Verification of two alerts********");
		  landingPage.enterZipcodeInSearchField(cityHavingAlerts);
		  landingPage.selectCityFromTheList(location);
		  
		  //Verifying the presence of multiple alerts banner
		  softAssert.assertTrue(bannerAlerts.presenceOfMultipleAlertsBanner(),"Issue-----> Multiple alerts not found on the page-----");
		  
		  //Verifying the presence of alert bars as per the alert count
		  softAssert.assertEquals(bannerAlerts.alertBannerCount(), alertCount);
		  
		  //Verifying the alert Summary for the both the alerts
		  bannerAlerts.getMultipleAlertsSummary();
		  softAssert.assertEquals(BannerAlerts.alertsSummary.get(0).replaceAll("\\s+",""), alertsSummary.get(0).replaceAll("\\s+",""),
				  "Issue-----> Alert Summary not matching for the first alert for city--->"+cityHavingAlerts+" and zipcode---->"+zipCodeHavingAlerts);
		  softAssert.assertEquals(BannerAlerts.alertsSummary.get(1).replaceAll("\\s+",""), alertsSummary.get(1).replaceAll("\\s+",""),
				  "Issue-----> Alert Summary not matching for the second alert for city--->"+cityHavingAlerts+" and zipcode---->"+zipCodeHavingAlerts);
		  
		  softAssert.assertAll();
		  
		  
	  }
	 
	 

}
