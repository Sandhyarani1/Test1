package com.accuweather.glacier.m.legalFooter;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.HomePageNonUSMobile;
import com.accuweather.glacier.m.pages.legalFooterMobile;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Constants;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.io.PropertiesManager;


public class Test_LegalFooterMobilePage extends AccuWeatherMobileBaseTest {

	public final static String EXPECTED_TERMSOFUSETAB_TEXT_COLOR = "1f1f1f";
	public final static String EXPECTED_TAGDISCLOSURE_TEXT_COLOR = "1f1f1f";
	
	public final static String EXPECTED_BLACK_COLOR = "#1f1f1f";
	public final static String EXPECTED_WHITE_COLOR = "#ffffff";
	
	public static String QA_URL = "";
	
	/****************************
	 * I understand Elements
	 ********************************************/

	public final static String EXPECTED_BANNER_STRING = "We have updated our Privacy Policy and our Cookie Policy.";
	public final static String EXPECTED_BANNER_I_UNDERSTAND_STRING = "I Understand";
	
	/*****************************
	 * PRIVACY POLICY
	 ********************************************/
	public final static String EXPECTED_PRIVACYANDPOLICY_TEXT_COLOR = "1f1f1f";
	private final static String EXPECTED_PRIVACY_POLICY_BANNER_WIDTH = "320px";
	private final static String EXPECTED_PRIVACY_POLICY_HEADER = "PRIVACY STATEMENT";
	private static String EXPECTED_PRIVACY_POLICY_URL =QA_URL+"/en/privacy";
	private final static String PRIVACY_POLICY_URL_SUFFIX= "/en/privacy";
	private final static String PRIVACY_POLICY_PAGE_TITLE="Privacy Statement & Policy | AccuWeather";
	
	/****************************
	 * COOKIE POLICY
	 ********************************************/
	public final static String EXPECTED_CCOOKIEPOLICY_TEXT_COLOR = "1f1f1f";
	private static String EXPECTED_COOKIE_POLICY_URL = QA_URL+"/en/cookiepolicy";
	private static String COOKIE_POLICY_URL_SUFFIX= "/en/cookiepolicy";
	private static String COOKIE_POLICY_TITLE= "Cookie Policy | AccuWeather";
	private static String COOKIE_POLICY_HEADER ="COOKIE POLICY";
	
	/****************************
	 * TAG DISCLOSURE
	 ********************************************/
	
	private static String TAG_DISCLOSURE_PAGE_TITLE = "TAG Disclosure | AccuWeather";
	private static String TAG_DISCLOSURE_PAGE_URL= QA_URL+"/en/tag-publisher-sourcing-disclosure";
	
	/****************************
	 * PROVIDERS
	 *********************************************/

	private final static String EXPECTED_LIVERAMP_PAGE_URL = "https://liveramp.com/privacy/";
	private final static String EXPECTED_CUEBIQ_PAGE_URL = "https://www.cuebiq.com/privacypolicy/";
	private final static String EXPECTED_INTERSECTION_PAGE_URL = "https://www.intersection.com/privacy-policy/";

	/****************************
	 * Pages
	 *********************************************/

	private LandingPage landingpage = new LandingPage();
	private NavigationBar navBar = new NavigationBar();
	private legalFooterMobile legalFooterMob = new legalFooterMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();
	private HomePageNonUSMobile homePage = new HomePageNonUSMobile();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	
	/**
	 * @author Mohammed
	 *         This method sets the URL as per the Environment
	 */
	@BeforeTest
	public void setURLData()
	{
		QA_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA);
		EXPECTED_PRIVACY_POLICY_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + PRIVACY_POLICY_URL_SUFFIX;
		EXPECTED_COOKIE_POLICY_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + COOKIE_POLICY_URL_SUFFIX;
	}


	@Test(priority = 1, enabled = false)
	public void RW_T100_VerifylegalFooterSectionIsDisplayed() {
		SoftAssert softassert = new SoftAssert();
		testStart("Is legal footer section is displayed");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.navigateToEndOfThePage();
		softassert.assertTrue(legalFooterMob.legalFooterSectionIsDisplayed());
		/*
		 * softassert.assertTrue(legalFooterMob.termsOfUseTextIsDisplayed());
		 * softassert.assertTrue(legalFooterMob.
		 * clickPrivacyAndPolicyFooterLinkIsDisplayed());
		 * softassert.assertTrue(legalFooterMob.clickPrivacyAndPolicyFooterLink());
		 * softassert.assertTrue(legalFooterMob.clickCookiePolicyFooterLinkIsDisplayed()
		 * );
		 * softassert.assertTrue(legalFooterMob.clickTagDisclosureFooterLinkIsDisplayed(
		 * )); softassert.assertTrue(legalFooterMob.
		 * copyrightinformationhas2019AccuWeatherIncTextIsDisplayed());
		 * softassert.assertTrue(legalFooterMob.
		 * copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherIncTextIsDisplayed
		 * ()); softassert.assertTrue(legalFooterMob.
		 * copyrightAllRightsReservedTextIsDisplayed()); softassert.assertAll();
		 */
	}

	//done

	@Test(priority = 2, enabled = false)
	public void RW_T101_VerifytermsOfUseTextIsDisplayed() {
		testStart("Is terms Of Use Text");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.termsOfUseTextIsDisplayed());
	}

	//done

	@Test(priority = 3, enabled = false)
	public void RW_T101_VerifyclicktermsOfUseText() {
		testStart("Is terms Of Use Text");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clicktermsOfUseText());
	}

	//done

	@Test(priority = 4, enabled = false)
	public void RW_T101_VerifyPageTitleTermsOfUseText() {
		testStart("Is Page tilte : Terms of Use - AccuWeather.com");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clicktermsOfUseText();
		Assert.assertEquals(legalFooterMob.getTitlePageTermsOfUse(), "Terms of Use | AccuWeather",
				"Page title incorrect");
	}


	@Test(priority = 5, enabled = false)
	public void RW_T101_VerifyTabNameTermsOfUseTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clicktermsOfUseText();
		Assert.assertEquals(legalFooterMob.getTabNameTermsOfUseIsinUpperCase(), "TERMS OF USE",
				"Tab name is not is upppercase");
	}

	/*
	 * @Test(priority=6, enabled=false) public void
	 * TC1_VerifyTabNameTermsOfUseTextIsInOrangeColor() {
	 * testStart("Tab Name Terms Of Use Text Is In orange Color");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clicktermsOfUseText();
	 * Assert.assertEquals(legalFooterMob.TabNameTermsOfUseIsinIsOrangeColor(),
	 * EXPECTED_TERMSOFUSETAB_TEXT_COLOR); }
	 */

	/*
	 * @Test(priority=7, enabled=false) public void
	 * TC1_VerifyHeadingNameTermsOfUseText() {
	 * testStart("Heading Name for Terms of Use is displayed");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clicktermsOfUseText();
	 * Assert.assertEquals(legalFooterMob.getTermsOfUsePageHeading(),
	 * "AccuWeather Terms Of Use", "Page title incorrect"); }
	 */

	// Test case 2


	@Test(priority = 8, enabled = false)
	public void RW_T102_VerifyPrivacyAndPolicyFooterLinkIsDisplayed() {
		testStart("Privacy And Policy Footer Link Is Displayed");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickPrivacyAndPolicyFooterLinkIsDisplayed());
	}
	
	//done


	@Test(priority = 9, enabled = false)
	public void RW_T102_VerifyPrivacyAndPolicyFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickPrivacyAndPolicyFooterLink());
	}
	
	//done


	@Test(priority = 10, enabled = false)
	public void RW_T102_VerifyPageTitlePrivacyAndPolicy() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTitlePrivacyAndPolicy(), PRIVACY_POLICY_PAGE_TITLE,
				"Page title incorrect");
	}


	@Test(priority = 11, enabled = false)
	public void RW_T102_VerifyPageTitlePrivacyAndPolicyPageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.privacyandPolicypageUrl(),
				EXPECTED_PRIVACY_POLICY_URL, "Page url incorrect");
	}


	@Test(priority = 12, enabled = false)
	public void RW_T102_VerifyTabNamePolicyandPrivacyTabTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTabNamePrivacyandPolicyeIsinUpperCase(), EXPECTED_PRIVACY_POLICY_HEADER,
				"Tab name is not is upppercase");
	}

	/*
	 * @Test(priority=13, enabled=false) public void
	 * TC2_VerifyTabNamePrivacyAndPolicyTabTextIsInOrangeColor() {
	 * testStart("Tab Name Terms Of Use Text Is In orange Color");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clickPrivacyAndPolicyFooterLink();
	 * Assert.assertEquals(legalFooterMob.TabNamePrivacyAndPolicyIsinIsOrangeColor()
	 * , EXPECTED_PRIVACYANDPOLICY_TEXT_COLOR); }
	 */

	/*
	 * @Test(priority=14, enabled=false) public void
	 * TC1_VerifyHeadingNamePrivacyAndPolicyText() {
	 * testStart("Heading Name for privacy and Policy is displayed");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clicktermsOfUseText();
	 * Assert.assertEquals(legalFooterMob.getTermsOfUsePageHeading(),
	 * "AccuWeather Terms Of Use", "Page title incorrect"); }
	 */

	// Test case 3


	@Test(priority = 15, enabled = false)
	public void RW_T103_VerifyCookiePolicyFooterLinkIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickCookiePolicyFooterLinkIsDisplayed());
	}
	
	//Done


	@Test(priority = 16, enabled = false)
	public void RW_T102_VerifyCookiePolicyFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickCookiePolicyFooterLink());
	}
	
	//done


	@Test(priority = 17, enabled = false)
	public void RW_T103_VerifyPageTitleCookiePolicy() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTitleCookiePolicy(), COOKIE_POLICY_TITLE,
				"Page title incorrect");

	}


	@Test(priority = 18, enabled = true)
	public void RW_T103_VerifyPageTitleCookiePolicyPageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.cookiePolicypageUrl(),
				EXPECTED_COOKIE_POLICY_URL, "Page url incorrect");
	}


	@Test(priority = 19, enabled = true)
	public void RW_T103_VerifyTabNamecookiePolicyTabTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTabNameCookiePloicyeIsinUpperCase(), COOKIE_POLICY_HEADER,
				"Tab name is not is upppercase");
	}

	/*
	 * @Test(priority=20, enabled=false) public void
	 * TC2_VerifyTabNameCookiePolicyTabTextIsInOrangeColor() {
	 * testStart("Tab Name Terms Of Use Text Is In orange Color");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clickCookiePolicyFooterLink();
	 * Assert.assertEquals(legalFooterMob.TabNameCookiePolicyIsinIsOrangeColor(),
	 * EXPECTED_CCOOKIEPOLICY_TEXT_COLOR); }
	 */

	/*
	 * @Test(priority=21, enabled=false) public void
	 * TC1_VerifyHeadingNameCookiePolicyText() {
	 * testStart("Heading Name for Terms of Use is displayed");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clickCookiePolicyFooterLink();
	 * Assert.assertEquals(legalFooterMob.getCookiePolicyPageHeading(),
	 * "Policy on Cookies, Web Beacons, Pixels, and Similar Technologies",
	 * "Page title incorrect"); }
	 */

	// Test case 4 TagDisclosure


	@Test(priority = 22, enabled = true)
	public void RW_T104_VerifyTagDisclosureFooterLinkIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickTagDisclosureFooterLinkIsDisplayed());
	}
	
	//done


	@Test(priority = 23, enabled = true)
	public void RW_T104_VerifyTagDisclosureFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		Assert.assertTrue(legalFooterMob.clickTagDisclosureFooterLink());
	}
	
	//done


	@Test(priority = 24, enabled = true)
	public void RW_T104_VerifyPageTitleTagDisclosure() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickTagDisclosureFooterLink();
		Assert.assertEquals(legalFooterMob.getTitleTagDisclosure(), TAG_DISCLOSURE_PAGE_TITLE,
				"Page title incorrect");
	}


	@Test(priority = 25, enabled = true)
	public void RW_T104_VerifyPageTitleTagDisclosurePageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		//legalFooterMob.TapPrivacyPolicyIUnderstandButton();
		legalFooterMob.clickTagDisclosureFooterLink();
		Assert.assertEquals(legalFooterMob.TagDisclosurepageUrl(),
				TAG_DISCLOSURE_PAGE_URL, "Page url incorrect");
	}


	@Test(priority = 26, enabled = false)
	public void RW_T104_VerifyTabNameTagDisclosureTabTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		legalFooterMob.clickTagDisclosureFooterLink();
		Assert.assertEquals(legalFooterMob.getTabNameTagDisclosureIsinUpperCase(), "TAG DISCLOSURE",
				"Tab name is not is upppercase");
	}

	/*
	 * @Test(priority=27, enabled=false) public void
	 * TC4_VerifyTabNameTagDisclosureTabTextIsInOrangeColor() {
	 * testStart("Tab Name Terms Of Use Text Is In orange Color");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clickTagDisclosureFooterLink();
	 * Assert.assertEquals(legalFooterMob.TabNameTagDisclosureIsinIsOrangeColor(),
	 * EXPECTED_TAGDISCLOSURE_TEXT_COLOR); }
	 */

	/*
	 * @Test(priority=28, enabled=false) public void
	 * TC4_VerifyHeadingNameTagDisclosureText() {
	 * testStart("Heading Name for Terms of Use is displayed");
	 * landingpage.isRecentLocationDisplayed();
	 * legalFooterMob.clickTagDisclosureFooterLink();
	 * Assert.assertEquals(legalFooterMob.getTagDisclosurePageHeading(),
	 * "TAG PUBLISHER SOURCE AND DISCLOSURE", "Page title incorrect"); }
	 */

	// Test case 5 All rights reserved


	@Test(priority = 29, enabled = false)
	public void RW_T105_Verifycopyrightinformationhas2019AccuWeatherIncTextIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob.copyrightinformationhas2019AccuWeatherIncTextIsDisplayed());
	}

	
	//done

	@Test(priority = 30, enabled = false)
	public void RW_T105_VerifycopyrightinformationTextIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob.copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherIncTextIsDisplayed());
	}
	
	//done


	@Test(priority = 31, enabled = false)
	public void RW_T105_VerifycopyrightReservedinformationTextIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob.copyrightAllRightsReservedTextIsDisplayed());
	}
	
	//done


	@Test(priority = 33, enabled = false)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyLiveRampLinkAndPage() {
		testStart("Verify LiveRampPolicy URL and page");
		getDriver().get("https://qualityassurance.accuweather.com/en/provider-list");
		String actualURL = legalFooterMob.verifyLiveRampLinkAndPage();
		Assert.assertEquals(actualURL, EXPECTED_LIVERAMP_PAGE_URL);
	}


	@Test(priority = 33, enabled = false)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyCuebiqLinkAndPage() {
		testStart("Verify Cuebiq URL and page");
		getDriver().get("https://qualityassurance.accuweather.com/en/provider-list");
		String actualURL = legalFooterMob.verifyCuebiqLinkAndPage();
		Assert.assertEquals(actualURL, EXPECTED_CUEBIQ_PAGE_URL);
	}


	@Test(priority = 33, enabled = false)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyIntersectionAndPage() {
		testStart("Verify Intersection URL and page");
		getDriver().get("https://qualityassurance.accuweather.com/en/provider-list");
		String actualURL = legalFooterMob.verifyIntersectionLinkAndPage();
		Assert.assertEquals(actualURL, EXPECTED_INTERSECTION_PAGE_URL);
	}
	


	@Test(priority = 34, enabled = false)
	public void RW_T1423_ValidatePrivacyPolicyBannerDesign() {
		testStart("Verify Privacy Policy Banner Design");
		Assert.assertTrue(legalFooterMob.IsBannerDislayed());
	}


	@Test(priority = 35, enabled = false)
	public void RW_T1423_ValidatePrivacyPolicyBannerDesigncolor() {
		testStart("Verify Privacy Policy Banner Design color");
		Assert.assertEquals(legalFooterMob.IsBannerColorDarkGrey(), EXPECTED_BLACK_COLOR);
	}


	@Test(priority = 36, enabled = false)
	public void RW_T1423_ValidatePrivacyPolicyBannerContents() {
		testStart("Verify Privacy Policy Banner Design contents");
		Assert.assertEquals(legalFooterMob.BannerConetentsText(), EXPECTED_BANNER_STRING);
	}


	@Test(priority = 37, enabled = false)
	public void RW_T1423_ValidatePrivacyPolicyBannerIUnderstandBackgroundColor() {
		testStart("Verify Privacy Policy Banner I understand background color");
		Assert.assertEquals(legalFooterMob.BannerConetentsIUnderstandBackGroundColor(), EXPECTED_WHITE_COLOR);
	}
	

	@Test(priority = 38, enabled = false)
	public void RW_T1423_ValidatePrivacyPolicyBannerIUnderstandText() {
		testStart("Verify Privacy Policy Banner I understand text");
		Assert.assertEquals(legalFooterMob.BannerConetentsIUnderstandText(), EXPECTED_BANNER_I_UNDERSTAND_STRING);
	}
	
	

	@Test(priority = 39, enabled = false)
	public void RW_T1425_ValidatePrivacyPolicyLink() {
		testStart("Verify Privacy Policy link");
		Assert.assertEquals(legalFooterMob.IsclickedOnPrivacyPolicyLink(), EXPECTED_PRIVACY_POLICY_URL);
	}
	

	@Test(priority = 40, enabled = false)
	public void RW_T1427_ValidateCookiePolicyLink() {
		testStart("Verify Cookie Policy link");
		Assert.assertEquals(legalFooterMob.IsclickedOnCookiePolicyLink(), EXPECTED_COOKIE_POLICY_URL);
	}
	

	@Test(priority = 41, enabled = false)
	public void RW_T1429_ValidatePrivacyPolicyBannerIs320pxwidth() {
		testStart("Verify Privacy Policy Banner Is 320px");
		Assert.assertEquals(legalFooterMob.IsPrivacyPolicyBanner320pxWidth(), EXPECTED_PRIVACY_POLICY_BANNER_WIDTH);
	}
	

	@Test(priority = 42, enabled = false)
	public void RW_T1432_ValidateTappingPrivacyPolicyIUnderstandButton() {
		testStart("Verify Tapping Privacy Policy I Understand Button leaves no pop up");
		Assert.assertTrue(legalFooterMob.TapPrivacyPolicyIUnderstandButton());
	}
	
	
	
	/*

 @Test(priority = 42, enabled = false) public void
	 * RW_T1626_ValidatePrivacyPolicyInSpanish() {
	 * testStart("Verify Privacy Policy In Spanish");
	 * legalFooterMob.TapPrivacyPolicyIUnderstandButton();
	 * legalFooterMob.clickPrivacyAndPolicyFooterLink();
	 * cityRadar.clickBreadCrumbMenu();
	 * homePage.clickBreadCrumbMenulanguageSelect();
	 * homePage.clickBreadCrumbMenulanguageSelectMobile();
	 * Assert.assertEquals(legalFooterMob.checkPrivacyAndPolicyTabIsinSpanish(),
	 * "Declaración de privacidad"); cityRadar.clickBreadCrumbMenu();
	 * homePage.clickBreadCrumbMenulanguageSelect();
	 * homePage.clickBreadCrumbMenulanguageSelectMobileEnglish(); }
	 */
	

	@Test(priority = 42, enabled = false)
	public void RW_T1433_ValidateBannerCenteredOnScreen360px() {
		testStart("Validate Banner Centered On Screen 360 px");
		Assert.assertEquals(legalFooterMob.IsPrivacyPolicyBanner320pxWidth(), EXPECTED_PRIVACY_POLICY_BANNER_WIDTH);
	}
	
	@Test(priority = 42, enabled = false)
	public void RW_T1694_ValidatethePrivacyPolicyPageTranslated() {
		testStart("Validate the Privacy Policy Page is not Translated in spanish");
		  legalFooterMob.TapPrivacyPolicyIUnderstandButton(); 
		  Sleeper.sleep(3);
		  legalFooterMob.clickPrivacyAndPolicyFooterLink();
		  cityRadar.clickBreadCrumbMenu();
		  homePage.clickBreadCrumbMenulanguageSelect();
		  homePage.clickBreadCrumbMenulanguageSelectMobile();
		  legalFooterMob.clickTabs();
		  Sleeper.sleep(5);
		  legalFooterMob.clickCLoseChildTab();
		  Sleeper.sleep(5);
		  legalFooterMob.clickDone();
		  Sleeper.sleep(5);
		  legalFooterMob.clickPrivacyAndPolicyFooterLink();
		  Assert.assertEquals(legalFooterMob.getPrivacyAndPolicyPageHeading(),
		  EXPECTED_PRIVACY_POLICY_HEADER);
		 
		 
	}
}
