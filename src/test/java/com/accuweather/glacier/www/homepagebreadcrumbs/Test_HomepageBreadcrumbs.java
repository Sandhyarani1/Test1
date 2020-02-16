package com.accuweather.glacier.www.homepagebreadcrumbs;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HomepageBreadcrumbs;
import com.accuweather.glacier.www.pages.LandingPage;
import com.chameleon.utils.Constants;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;
import com.chameleon.utils.io.PropertiesManager;

public class Test_HomepageBreadcrumbs extends AccuWeatherBaseTest {
	
	public static final String CITY_NAME = "Buffalo";
	public static String cityNameForURL = "";
	public static String stateNameForURL = "";
	public static String countryNameForURL = "";
	public static String regionNameForURL = "";
	public static String stateName = "";
	public static String countryName = "";
	public static String regionName = "";
	public static String location = "";
	public static final String LANGUAGE = "EN";
	public static final String BREADCRUMBS_URL_SUFFIX = "-WEATHER";
	public static final String BREADCRUMBS_CITY_URL_SUFFIX = "WEATHER-FORECAST";
	public static String expectedWorldPage_URL = "";
	public static String expectedRegionPageURL= "";
	public static String expectedCountry_URL="";
	public static String expectedState_URL="";
	public static String expectedCity_URL = "";
	public static String zipCode = "";
	public static String locationKey = "";
	public static String countryCode = "";
	public static String stateCode = "";
	public static final String WORLD_BREADCRUMB_TEXT = "World";
	public static final String EXPECTED_LOCAL_BREADCRUMB_TITLE = "Local Current Weather | AccuWeather";
	public static final String EXPECTED_NATIONAL_BREADCRUMB_TITLE = "National Current Weather | AccuWeather";
	public static final String EXPECTED_GLOBAL_BREADCRUMB_TITLE = "Global Current Weather | AccuWeather";
	public static String expectedCityBreadCrumbTitle = "";
	

	private static final String  BREAD_CRUMB="BREAD_CRUMB";
	private static final String  BREAD_CRUMB_WORLD="BREAD_CRUMB_WORLD";
	private static final String  BREAD_CRUMB_REGION="BREAD_CRUMB_REGION";
	private static final String  BREAD_CRUMB_COUNTRY="BREAD_CRUMB_COUNTRY";
	private static final String  BREAD_CRUMB_STATE ="BREAD_CRUMB_STATE";
	private static final String  BREAD_CRUMB_CITY="BREAD_CRUMB_CITY";
	
	private LandingPage landingPage = new LandingPage();
	private HomepageBreadcrumbs breadcrumbs = new HomepageBreadcrumbs();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void getTestData()
	{
		int rowNo = 0;
		rowNo = ExcelUtilities.getRowNumberForCity(CITY_NAME);
		zipCode = ExcelUtilities.getZipCode(rowNo);
		stateCode = ExcelUtilities.getStateCode(rowNo);
		countryCode = ExcelUtilities.getCountryCode(rowNo);
		locationKey = ExcelUtilities.getLocationKey(rowNo);
		regionName = ExcelUtilities.getRegionName(rowNo);
		countryName = ExcelUtilities.getCountryName(rowNo);
		stateName = ExcelUtilities.getStateName(rowNo);
		location = CITY_NAME + ", " + stateCode + ", " + countryCode;
		cityNameForURL = CITY_NAME.replace(' ', '-');
		stateNameForURL = ExcelUtilities.getStateName(rowNo).replace(' ', '-');
		countryNameForURL = ExcelUtilities.getCountryName(rowNo).replace(' ', '-');
		regionNameForURL = ExcelUtilities.getRegionName(rowNo).replace(' ', '-');
		expectedWorldPage_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + LANGUAGE+"/"+WORLD_BREADCRUMB_TEXT+BREADCRUMBS_URL_SUFFIX).toLowerCase();
		expectedRegionPageURL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + LANGUAGE+"/"+regionNameForURL+BREADCRUMBS_URL_SUFFIX).toLowerCase();
		expectedCountry_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + LANGUAGE+"/"+countryCode+"/"+countryNameForURL+BREADCRUMBS_URL_SUFFIX).toLowerCase();
		expectedState_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + LANGUAGE+"/"+countryCode+"/"+stateCode+"/"+stateNameForURL+BREADCRUMBS_URL_SUFFIX).toLowerCase();
		expectedCity_URL = (appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + LANGUAGE+"/"+countryCode+"/"+cityNameForURL+"/"+zipCode+"/"+BREADCRUMBS_CITY_URL_SUFFIX+"/"+locationKey).toLowerCase();
		expectedCityBreadCrumbTitle = CITY_NAME+", "+stateCode+" Three Day Weather Forecast | AccuWeather";
	}
	
	@Test(priority=1)
	public void RW_T196_Validation_If_BreadCrumbs_Displayed()
	{
		softAssert = new SoftAssert();
		
		testStart("********************Validate footer breadcrumbs displayed on Homepage****************" );
		
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/****************** Validating whether breadcrumbs is displayed ****************************************************************/
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB),
				"\nIssue----->Breadcrumbs not displayed");
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_WORLD),
				"\nIssue----->Breadcrumbs not displayed");
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_REGION),
				"\nIssue----->Breadcrumbs not displayed");
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_COUNTRY),
				"\nIssue----->Breadcrumbs not displayed");
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_STATE),
				"\nIssue----->Breadcrumbs not displayed");
		softAssert.assertTrue(breadcrumbs.footerbreadcrumbDisplayedfor(BREAD_CRUMB_CITY),
				"\nIssue----->Breadcrumbs not displayed");
		
		/****************** Validating whether the breadcrumbs values are correct ******************************/
		softAssert.assertEquals(breadcrumbs.getTextOfBreadCrumbs(BREAD_CRUMB_WORLD), WORLD_BREADCRUMB_TEXT,
				"\nIssue-----> Breadcrumb text for World not as expected\n");
		softAssert.assertEquals(breadcrumbs.getTextOfBreadCrumbs(BREAD_CRUMB_REGION), regionName,"\nIssue---->Breadcrumb text for Region not as expected");
		softAssert.assertEquals(breadcrumbs.getTextOfBreadCrumbs(BREAD_CRUMB_COUNTRY), countryName,"\nIssue---->Breadcrumb text for country not as expected");
		softAssert.assertEquals(breadcrumbs.getTextOfBreadCrumbs(BREAD_CRUMB_STATE), stateName,"\nIssue---->Breadcrumb text for state not as expected");
		softAssert.assertEquals(breadcrumbs.getTextOfBreadCrumbs(BREAD_CRUMB_CITY), CITY_NAME,"\nIssue---->Breadcrumb text for city not as expected");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void RW_T197_WorldBreadCrumb_URL_Validation()
	{
		softAssert = new SoftAssert();
		
		testStart("******************Validate the URL & Title for breadcrumbs displayed for World************************");
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/**************** Validating the URL for World breadcrumb ********************************/
		breadcrumbs.clickOnBreadcrumb(BREAD_CRUMB_WORLD);
		Assert.assertEquals(getDriver().getCurrentUrl(),expectedWorldPage_URL,
				"\nIssue-----> URL not matching for World breadcrumb");
		
		/**************** Validating the Title for World Breadcrumb *****************************/
		Assert.assertEquals(getDriver().getTitle(),EXPECTED_GLOBAL_BREADCRUMB_TITLE,
				"\nIssue-----> Title not matching for World breadcrumb");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void RW_T198_RegionBreadCrumb_URL_Validation()
	{
		softAssert = new SoftAssert();
		
		testStart("******************Validate the URL & Title for breadcrumbs displayed for Region************************");
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/**************** Validating the URL for Region breadcrumb ********************************/
		breadcrumbs.clickOnBreadcrumb(BREAD_CRUMB_REGION);
		Assert.assertEquals(getDriver().getCurrentUrl(),expectedRegionPageURL,
				"\nIssue-----> URL not matching for Region breadcrumb");
		
		/**************** Validating the Title for Region breadcrumb ********************************/
		Assert.assertEquals(getDriver().getTitle(),EXPECTED_GLOBAL_BREADCRUMB_TITLE,
				"\nIssue-----> Title not matching for Region breadcrumb");
		
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void RW_T199_CountryBreadCrumb_URL_Validation()
	{
		softAssert = new SoftAssert();
		
		testStart("******************Validate the URL & Title for breadcrumbs displayed for Country************************");
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/**************** Validating the URL for Country breadcrumb ********************************/
		breadcrumbs.clickOnBreadcrumb(BREAD_CRUMB_COUNTRY);
		Assert.assertEquals(getDriver().getCurrentUrl(),expectedCountry_URL,
				"\nIssue-----> URL not matching for Country breadcrumb");
		
		/**************** Validating the title for Country breadcrumb ********************************/
		Assert.assertEquals(getDriver().getTitle(),EXPECTED_NATIONAL_BREADCRUMB_TITLE,
				"\nIssue-----> Title not matching for Country breadcrumb");
		
		softAssert.assertAll();
	}
	
	@Test(priority=5)
	public void RW_T200_StateBreadCrumb_URL_Validation()
	{
		softAssert = new SoftAssert();
		
		testStart("******************Validate the URL & Title for breadcrumbs displayed for State************************");
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/**************** Validating the URL for State breadcrumb ********************************/
		breadcrumbs.clickOnBreadcrumb(BREAD_CRUMB_STATE);
		Assert.assertEquals(getDriver().getCurrentUrl(),expectedState_URL,
				"\nIssue-----> URL not matching for State breadcrumb");
		
		/**************** Validating the Title for State breadcrumb ********************************/
		Assert.assertEquals(getDriver().getTitle(),EXPECTED_LOCAL_BREADCRUMB_TITLE,
				"\nIssue-----> Title not matching for State breadcrumb");
		
		softAssert.assertAll();
	}
	
	@Test(priority=6)
	public void RW_T201_CityBreadCrumb_URL_Validation()
	{
		softAssert = new SoftAssert();
		
		testStart("****************** Validate the URL & Title for breadcrumbs displayed for City ************************");
		landingPage.enterCityNameInSearchField(CITY_NAME);
		landingPage.selectCityFromTheList(location);

		breadcrumbs.scrolldownpage();
		breadcrumbs.scrolldownpage();
		
		/**************** Validating the URL for City breadcrumb ********************************/
		breadcrumbs.clickOnBreadcrumb(BREAD_CRUMB_CITY);
		Assert.assertEquals(getDriver().getCurrentUrl(),expectedCity_URL,
				"\nIssue-----> URL not matching for City breadcrumb");
		
		/**************** Validating the Title for City breadcrumb ********************************/
		Assert.assertEquals(getDriver().getTitle(),expectedCityBreadCrumbTitle,
				"\nIssue-----> Title not matching for City breadcrumb");
		
		softAssert.assertAll();
	}
}
