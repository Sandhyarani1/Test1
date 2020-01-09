package com.accuweather.glacier.www.Footer;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LegalFooter;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

public class Test_LegalFooter extends AccuWeatherBaseTest
{
	
	/***************************** TERMS OF USE **********************************************/
	public final static String TERMS_OF_USE_TITLE = "Terms of Use | AccuWeather";
	public final static String TERMS_OF_USE = "Terms of Use";
	public final static String TERMS_OF_USE_URL_SUFFIX = "en/legal";
	public static String TERMS_OF_USE_URL = "";
	public final static String TERMS_OF_USE_CONTENT_HEADING = "AccuWeather Terms Of Use";
	
	/***************************** PRIVACY POLICY ********************************************/
	public final static String PRIVACY_POLICY_TITLE = "Privacy Statement & Policy | AccuWeather";
	public final static String PRIVACY_POLICY = "Privacy Policy";
	public final static String PRIVACY_POLICY_TAB = "Privacy Statement";
	public final static String PRIVACY_POLICY_URL_SUFFIX = "en/privacy";
	public static String PRIVACY_POLICY_URL = "";
	public final static String PRIVACY_POLICY_CONTENT_HEADING = "Privacy Policy";
	
	/**************************** COOKIE POLICY ********************************************/
	public final static String COOKIE_POLICY_TITLE = "Cookie Policy | AccuWeather";
	public final static String COOKIE_POLICY = "Cookie Policy";
	public final static String COOKIE_POLICY_URL_SUFFIX = "en/cookiepolicy";
	public static String COOKIE_POLICY_URL = "";
	public final static String COOKIE_POLICY_CONTENT_HEADING = "Policy on Cookies, Web Beacons, Pixels, and Similar Technologies";
	
	/*************************** TAG DISCLOSURE *******************************************/
	public final static String TAG_DISCLOSURE_TITLE = "TAG Disclosure | AccuWeather";
	public final static String TAG_DISCLOSURE = "TAG Disclosure";
	public final static String TAG_DISCLOSURE_URL_SUFIX = "en/tag-publisher-sourcing-disclosure";
	public static String TAG_DISCLOSURE_URL = "";
	public final static String TAG_DISCLOSURE_CONTENT_HEADING = "TAG PUBLISHER SOURCE AND DISCLOSURE";
	
	/*************************** COPY RIGHT INFORMATION **********************************/
	public final static String ACTIVE_TAB_COLOR = "#f05514";
	public final static String COPYRIGHT_INFO = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	public final static String REGISTERED_TRADEMARKS = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	public final static String ALL_RIGHTS_RESERVED = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	
	/**************************** PROVIDERS *********************************************/
	public final static String EXPECTED_LIVERAMP_PAGE_URL = "https://liveramp.com/privacy/";
	public final static String EXPECTED_CUEBIQ_PAGE_URL = "https://www.cuebiq.com/privacypolicy/";
	public final static String EXPECTED_INTERSECTION_PAGE_URL = "https://www.intersection.com/privacy-policy/";
	
	/************************************** CCPA *************************************************/
	public final static String CCPA = "CCPA";
	public final static String CCPA_TITLE = "CCPA | AccuWeather";
	public final static String CCPA_URL_SUFFIX = "en/ccpa";
	public static String CCPA_URL = "";
	
	/******************************* DO NOT SELL MY DATA *****************************************/
	public final static String DO_NOT_SELL_MY_DATA = "Do Not Sell My Data";
	
	/******************************** PRIVACY POLICY BANNER **************************************/
	public final static String BANNER_WIDTH = "320px";
	public final static String I_UNDERSTAND = "I Understand";
	public final static String PRIVACY_POLICY_TEXT = "We have updated our Privacy Policy and our Cookie Policy.";
	
	public LegalFooter legalFooter = new LegalFooter();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert;
	
	@BeforeTest
	public void setURLData()
	{
		CCPA_URL = appURLRepository.get("ACCUWEATHER_WEB_QA")+CCPA_URL_SUFFIX;
		PRIVACY_POLICY_URL = appURLRepository.get("ACCUWEATHER_WEB_QA")+PRIVACY_POLICY_URL_SUFFIX;
		TERMS_OF_USE_URL = appURLRepository.get("ACCUWEATHER_WEB_QA")+TERMS_OF_USE_URL_SUFFIX;
		TAG_DISCLOSURE_URL = appURLRepository.get("ACCUWEATHER_WEB_QA")+TAG_DISCLOSURE_URL_SUFIX;
		COOKIE_POLICY_URL = appURLRepository.get("ACCUWEATHER_WEB_QA")+COOKIE_POLICY_URL_SUFFIX;
		System.out.println(" CCPA URL :---------> "+CCPA_URL);
		
	}
	
	
	
	/*
	 * @Test(priority = 1) public void RW_T2023_ValidatePresenceOfCCPA() {
	 * testStart("************************** Verifying the presence of CCPA, spelling of CCPA *******************"
	 * );
	 * 
	 * //Verifying the presence of CCPA
	 * softAssert.assertTrue(legalFooter.isCCPAPresent());
	 * 
	 * //Verifying the spelling of CCPA
	 * //System.out.println(legalFooter.getCCPAText());
	 * softAssert.assertEquals(legalFooter.getCCPAText(), CCPA);
	 * 
	 * softAssert.assertAll(); }
	 * 
	 * @Test(priority=2) public void RW_T2029() {
	 * testStart("************ Validating the title and URL of CCPA page ********************"
	 * ); legalFooter.clickCCPA();
	 * 
	 * //Verify the title on CCPA page
	 * softAssert.assertEquals(getDriver().getTitle(), CCPA_TITLE);
	 * 
	 * //Verify the URL of CCPA page
	 * softAssert.assertEquals(getDriver().getCurrentUrl(), CCPA_URL);
	 * 
	 * softAssert.assertAll(); }
	 * 
	 * @Test(priority=3) public void RW_T2030() {
	 * testStart("****************** Validating the CCPA Secondary Navigation Title ********************"
	 * );
	 * 
	 * //Verify the name on CCPA tab
	 * softAssert.assertEquals(legalFooter.getNameOfCCPATab(), CCPA);
	 * 
	 * //Verify the color at the bottom of CCPA tab
	 * softAssert.assertEquals(legalFooter.getBorderColorOfCCPATab(),
	 * ACTIVE_TAB_COLOR);
	 * 
	 * softAssert.assertAll(); }
	 */
	
	@Test(priority=4)
	public void RW_T1428()
	{
		testStart("*********** Validating the width of privacy policy banner ********************");
		softAssert.assertEquals(legalFooter.getPrivacyPolicyBannerWidth(), BANNER_WIDTH);
		softAssert.assertAll();
	}
	
	@Test(priority=5)
	public void RW_T1422()
	{
		testStart("******* Validate presence of privacy policy banner, 'I Understand' button, text on privacy policy banner *****************");
		
		//Verify the presence of privacy policy banner
		softAssert.assertTrue(legalFooter.isAlertBannerPresent());
		
		//Verify the presence of "I Understand" button on privacy policy banner
		softAssert.assertTrue(legalFooter.isIUnderstandButtonPresentOnPrivacyPolicyBanner());
		
		//Verify the text of the button on privacy policy banner
		softAssert.assertEquals(legalFooter.getTextOfButtonOnPrivacyPolicyBanner(), I_UNDERSTAND);
		
		//Verify the text on Privacy Policy Banner
		softAssert.assertEquals(legalFooter.getTextofPrivacyPolicyBanner(), PRIVACY_POLICY_TEXT);
		
		softAssert.assertAll();
	}
	
	@Test(priority=6)
	public void RW_T1424()
	{
		testStart("******* Validating the URL after clicking on Privacy Policy link on the banner ************************");
		legalFooter.clickPrivacyPolicyLinkOnBanner();
		
		//verify the URL on Privacy Policy page
		softAssert.assertEquals(getDriver().getCurrentUrl(), PRIVACY_POLICY_URL);
		softAssert.assertAll();
	}
	
	@Test(priority=7)
	public void RW_T1430()
	{
		testStart("******* Validating the URL after clicking on Cookie Policy link on the banner ************************");
		legalFooter.clickCookiePolicyLinkOnBanner();
		
		//verify the URL on Privacy Policy page
		softAssert.assertEquals(getDriver().getCurrentUrl(), COOKIE_POLICY_URL);
		softAssert.assertAll();
	}
	
	@Test(priority=8)
	public void RW_T1431()
	{
		testStart("******* Validating whether privacy policy banner disappears after clicking on 'I Understand' button **************");
		legalFooter.clickIUnderstand();
		
		//verify the presence of Privacy Policy Banner
		softAssert.assertFalse(legalFooter.isPrivacyPolicyPresent());
		
		softAssert.assertAll();
	}
	
	
}
