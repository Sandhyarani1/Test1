package com.accuweather.glacier.www.Footer;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LegalFooter;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.PropertiesManager;

/**
 * @author HFARAZ
 *         This class deals with the validations of the Legal Footer Content
 *         present at the bottom of the page
 *         Method Name has the JIRA ID as the prefix
 */
public class Test_LegalFooter extends AccuWeatherBaseTest
{

	/*****************************
	 * TERMS OF USE
	 **********************************************/
	public final static String TERMS_OF_USE_TITLE = "Terms of Use | AccuWeather";
	public final static String TERMS_OF_USE = "Terms of Use";
	public final static String TERMS_OF_USE_URL_SUFFIX = "en/legal";
	public static String TERMS_OF_USE_URL = "";
	public final static String TERMS_OF_USE_CONTENT_HEADING = "AccuWeather Terms Of Use";

	/*****************************
	 * PRIVACY POLICY
	 ********************************************/
	public final static String PRIVACY_POLICY_TITLE = "Privacy Statement & Policy | AccuWeather";
	public final static String PRIVACY_POLICY = "Privacy Policy";
	public final static String PRIVACY_POLICY_TAB = "Privacy Statement";
	public final static String PRIVACY_POLICY_URL_SUFFIX = "en/privacy";
	public static String PRIVACY_POLICY_URL = "";
	public final static String PRIVACY_POLICY_CONTENT_HEADING = "Privacy Policy";

	/****************************
	 * COOKIE POLICY
	 ********************************************/
	public final static String COOKIE_POLICY_TITLE = "Cookie Policy | AccuWeather";
	public final static String COOKIE_POLICY = "Cookie Policy";
	public final static String COOKIE_POLICY_URL_SUFFIX = "en/cookiepolicy";
	public static String COOKIE_POLICY_URL = "";
	public final static String COOKIE_POLICY_CONTENT_HEADING = "Policy on Cookies, Web Beacons, Pixels, and Similar Technologies";

	/***************************
	 * TAG DISCLOSURE
	 *******************************************/
	public final static String TAG_DISCLOSURE_TITLE = "TAG Disclosure | AccuWeather";
	public final static String TAG_DISCLOSURE = "TAG Disclosure";
	public final static String TAG_DISCLOSURE_URL_SUFIX = "en/tag-publisher-sourcing-disclosure";
	public static String TAG_DISCLOSURE_URL = "";
	public final static String TAG_DISCLOSURE_CONTENT_HEADING = "TAG PUBLISHER SOURCE AND DISCLOSURE";

	/***************************
	 * COPY RIGHT INFORMATION
	 **********************************/
	public final static String ACTIVE_TAB_COLOR = "#c2c2c2";
	public final static String COPYRIGHT_INFO = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	public final static String REGISTERED_TRADEMARKS = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	public final static String ALL_RIGHTS_RESERVED = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";

	/****************************
	 * PROVIDERS
	 *********************************************/
	public final static String EXPECTED_LIVERAMP_PAGE_URL = "https://liveramp.com/privacy/";
	public final static String EXPECTED_CUEBIQ_PAGE_URL = "https://www.cuebiq.com/privacypolicy/";
	public final static String EXPECTED_INTERSECTION_PAGE_URL = "https://www.intersection.com/privacy-policy/";

	/**************************************
	 * CCPA
	 *************************************************/
	public final static String CCPA = "CCPA";
	public final static String CCPA_TITLE = "CCPA | AccuWeather";
	public final static String CCPA_URL_SUFFIX = "en/ccpa";
	public static String CCPA_URL = "";

	/*******************************
	 * DO NOT SELL MY DATA
	 *****************************************/
	public final static String DO_NOT_SELL_MY_DATA = "Do Not Sell My Data";
	public final static String CONFIRMED = "Confirmed";
	public final static String NOT_SELLING_YOUR_DATA = "Not Selling Your Data";

	/********************************
	 * PRIVACY POLICY BANNER
	 **************************************/
	public final static String BANNER_WIDTH = "320px";
	public final static String I_UNDERSTAND = "I Understand";
	public final static String PRIVACY_POLICY_TEXT = "We have updated our Privacy Policy and our Cookie Policy";

	public LegalFooter legalFooter = new LegalFooter();
	protected Map<String, String> appURLRepository = PropertiesManager.properties(Constants.ENVIRONMENT_URL_PROPERTIES);
	SoftAssert softAssert;

	/**
	 * @author HFARAZ
	 *         This method sets the URL as per the Environment
	 */
	@BeforeTest
	public void setURLData()
	{
		CCPA_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + CCPA_URL_SUFFIX;
		PRIVACY_POLICY_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + PRIVACY_POLICY_URL_SUFFIX;
		TERMS_OF_USE_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + TERMS_OF_USE_URL_SUFFIX;
		TAG_DISCLOSURE_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + TAG_DISCLOSURE_URL_SUFIX;
		COOKIE_POLICY_URL = appURLRepository.get(Constants.ACCUWEATHER_WEB_QA) + COOKIE_POLICY_URL_SUFFIX;
	}

	@Test(priority = 1)
	public void RW_T100_ValidateTermsOfUseInFooter()
	{
		softAssert = new SoftAssert();
		testStart(
				"*******Validate Terms of Use link, it's spelling, title, URL, color of the tab and heading of the tab************");

		// Verifying whether Terms of Use is present
		softAssert.assertTrue(legalFooter.isTermsOfUsePresent(), "Issue----> Terms Of Use Not Found on Legal Footer\n");

		// Verifying the spelling of Terms of Use
		softAssert.assertEquals(legalFooter.getTermsOfUseText(), TERMS_OF_USE,
				"Issue-----> Terms Of Use Spelling Wrong");

		// Verifying the title of Terms of Use page
		legalFooter.clickTermsOfUse();
		softAssert.assertEquals(getDriver().getTitle(), TERMS_OF_USE_TITLE,
				"Issue----> Title of the Terms Of Use Page Not As Expected");

		// Verifying the URL of Terms of Use page
		softAssert.assertEquals(getDriver().getCurrentUrl(), TERMS_OF_USE_URL,
				"URL of Terms Of Use Page Not As Expected");

		// Verifying the spelling of Terms Of Use tab
		softAssert.assertEquals(legalFooter.getNameOfTermsOfUseTab(), TERMS_OF_USE.toUpperCase(),
				"Issue-----> Wrong Spelling of Terms Of Use On The Tab");

		// Verifying the color of the Terms of Use tab
		softAssert.assertEquals(legalFooter.getBottomBorderColor_Of_TermsOfUseTab(), ACTIVE_TAB_COLOR,
				"Issue-----> Wrong color on Active Terms Of Use Tab");

		// Verifying the content heading of the Terms of Use page
		softAssert.assertEquals(legalFooter.getHeadingOfTermsOfUse(), TERMS_OF_USE_CONTENT_HEADING,
				"Issue----> Terms Of Use Heading Wrong on the Terms Of Use Page");

		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void RW_T101_ValidatePrivacyPolicyLinkInFooter()
	{
		softAssert = new SoftAssert();
		testStart(
				"*******Validate Privacy Policy link, it's spelling, title, URL, color of the tab and heading of the tab************");

		// Verify whether Privacy Policy link is present on footer
		softAssert.assertTrue(legalFooter.isPrivacyPolicyPresent(),
				"Issue-----> Privacy Policy Link Not Found In Legal Footer");

		// Verify the text of Privacy Policy
		softAssert.assertEquals(legalFooter.getPrivacyPolicyText(), PRIVACY_POLICY,
				"Issue---->Wrong spelling of Privacy Policy in Legal Footer");

		// Verify the title of Privacy Policy page
		legalFooter.clickPrivacyPolicy();
		softAssert.assertEquals(getDriver().getTitle(), PRIVACY_POLICY_TITLE,
				"Issue-----> Title of Privacy Policy Page Not As Expected");

		// Verify the URL of Privacy Policy page
		softAssert.assertEquals(getDriver().getCurrentUrl(), PRIVACY_POLICY_URL,
				"Issue-----> URL of Privacy Policy Page Not As Expected");

		// Verify the spelling of Privacy Policy tab
		softAssert.assertEquals(legalFooter.getNameOfPrivacyPolicyTab(), PRIVACY_POLICY_TAB.toUpperCase(),
				"Issue----> Wrong Spelling of Privacy Policy Tab on the Tab");

		// Verify the color of Privacy Policy tab
		softAssert.assertEquals(legalFooter.getBottomBorderColor_Of_PrivacyPolicyTab(), ACTIVE_TAB_COLOR,
				"Issue-----> Wrong color of the Active Privacy Policy tab");

		// Verify the content heading of Privacy Policy header
		softAssert.assertEquals(legalFooter.getHeadingOfPrivacyPolicy(), PRIVACY_POLICY_CONTENT_HEADING,
				"Issue------> Wrong Heading of the Privacy Policy heading On The Privacy Policy Page");

		softAssert.assertAll();

	}

	@Test(priority = 3)
	public void RW_T102_ValidateCookiePolicyLinkInFooter()
	{
		softAssert = new SoftAssert();
		testStart(
				"*******Validate Cookie Policy link, it's spelling, title, URL, color of the tab and heading of the tab************");

		// Verifying the presence ofCookie Policy link in the footer
		softAssert.assertTrue(legalFooter.isCookiePolicyPresent(),
				"Issue---->Cookie Policy Link Not Found On Legal Footer");

		// Verifying the spelling of Cookie Policy
		softAssert.assertEquals(legalFooter.getCookiePolicyText(), COOKIE_POLICY,
				"Issue----> Spelling of Cookie Policy Wrong");

		// verifying the title of Cookie Policy
		legalFooter.clickCookiePolicy();
		softAssert.assertEquals(getDriver().getTitle(), COOKIE_POLICY_TITLE,
				"Issue----->Title of The Cookie Policy Page Not As Expected");

		// Verifying the URL of Cookie Policy
		softAssert.assertEquals(getDriver().getCurrentUrl(), COOKIE_POLICY_URL,
				"Issue----->URL of The Cookie Policy Page Not As Expected");

		// Verifying the name on Cookie Policy tab
		softAssert.assertEquals(legalFooter.getNameOfCookiePolicyTab(), COOKIE_POLICY.toUpperCase(),
				"Issue---->Cookie Policy Name Wrong on the TAB");

		// verifying the Active Tab color
		softAssert.assertEquals(legalFooter.getBottomBorderColor_Of_CookiePolicyTab(), ACTIVE_TAB_COLOR,
				"Issue---->Wrong Color for the Active Cookie Policy");

		// Verifying the content heading of Cookie Policy
		softAssert.assertEquals(legalFooter.getHeadingOfCookiePolicy(), COOKIE_POLICY_CONTENT_HEADING,
				"Issue----> Cookie Policy Heading Wrong on Cookie Policy Page");

		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void RW_T102ValidateTAGDisclosureInFooter()
	{
		softAssert = new SoftAssert();
		testStart(
				"******Validate TAG Disclosure link, spelling, title, URL, color of the tab, content heading*************");

		// Verifying the presence of TAG Disclosure Link in Footer
		softAssert.assertTrue(legalFooter.isTAGDisclosurePresent(),
				"Issue---->TAG Disclosure Link Not Found In Legal Footer\n");

		// Verifying the spelling of TAG Disclosure in Footer
		softAssert.assertEquals(legalFooter.getTAGDisclosureText(), TAG_DISCLOSURE,
				"Issue---->TAG Disclosure Spelling Not Correct in Legal Footer\n");

		// Verifying the title of TAG Disclosure Page
		legalFooter.clickTAGDisclosure();
		softAssert.assertEquals(getDriver().getTitle(), TAG_DISCLOSURE_TITLE,
				"Issue----->Title of the TAG Disclosure Page Not As Expected\n");

		// Verifying the URL of TAG Disclosure Page
		softAssert.assertEquals(getDriver().getCurrentUrl(), TAG_DISCLOSURE_URL,
				"Issue-----> URL of TAG Dislcosure Page Not As expected\n");

		// Verifying the name on TAG Disclosure Tab
		softAssert.assertEquals(legalFooter.getNameOfTAGDisclosureTab(), TAG_DISCLOSURE.toUpperCase(),
				"Issue----> TAG Disclosure Name Wrong on the TAB");

		// Verifying the color of the Active tab
		softAssert.assertEquals(legalFooter.getBottomBorderColor_Of_TAGDisclosureTab(), ACTIVE_TAB_COLOR,
				"Issue----> Wrong color for the Active TAG Disclosure Tab");

		// Verifying the content heading of TAG Disclosure
		softAssert.assertEquals(legalFooter.getHeadingOfTAGDisclosure(), TAG_DISCLOSURE_CONTENT_HEADING,
				"Issue-----> Wrong TAG Disclosure Heading on TAG Disclosure Page");

		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void RW_T104_ValidateCopyrightInformation()
	{
		softAssert = new SoftAssert();
		testStart("*********Validate the copyright information content************");

		// Verifying the presence of copyright information
		softAssert.assertTrue(legalFooter.isCopyRightInformationPresent(),
				"Issue-----> Copyright information not found");

		// Verifying the copyright information
		softAssert.assertEquals(legalFooter.getCopyRightInformation(), COPYRIGHT_INFO,
				"Issue-----> Copyright information Not as expected");

		// Verifying the current year in copyright information
		softAssert.assertEquals(legalFooter.getYearInCopyRightInformation(), legalFooter.getCurrentYear(),
				"Issue---->Wrong year in Copyright information\n");

		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void RW_T105_ValidatePresenceOfLegalFooter_WhenSwitchedTo_DifferentLanguage()
	{
		softAssert = new SoftAssert();
		testStart("********Validate the presence of footer when language changed**********");

		// Verifying the presence of legal footer when language changed
		softAssert.assertTrue(legalFooter.legalFooterStatusWhenLangChanged(),
				"Issue------> Legal Footer Not Found When Language Changed");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = false)
	public void RW_T761_ValidateDataProviderList()
	{
		softAssert = new SoftAssert();
		testStart("Verify Advertising section have updated code");
		softAssert.assertTrue(legalFooter.verifyAdvertisingSectionHaveUpdatedProviders());

		// Verifying the Live Ramp URL
		softAssert.assertEquals(legalFooter.verifyLiveRampLinkAndPage(), EXPECTED_LIVERAMP_PAGE_URL);

		// verifying the Cuebiq URL
		softAssert.assertEquals(legalFooter.verifyCuebiqLinkAndPage(), EXPECTED_CUEBIQ_PAGE_URL);

		// Verifying the Intersection URL
		softAssert.assertEquals(legalFooter.verifyIntersectionLinkAndPage(), EXPECTED_INTERSECTION_PAGE_URL);

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = false)
	public void RW_T2023_ValidatePresenceOfCCPA()
	{
		softAssert = new SoftAssert();
		testStart("************************** Verifying the presence of CCPA, spelling of CCPA *******************");

		// Verifying the presence of CCPA
		softAssert.assertTrue(legalFooter.isCCPAPresent());

		// Verifying the spelling of CCPA
		softAssert.assertEquals(legalFooter.getCCPAText(), CCPA);

		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = false)
	public void RW_T2029_ValidateURLAndTitleOfCCPA()
	{
		softAssert = new SoftAssert();
		testStart("************ Validating the title and URL of CCPA page ********************");

		legalFooter.clickCCPA();

		// Verify the title on CCPA page
		softAssert.assertEquals(getDriver().getTitle(), CCPA_TITLE);

		// Verify the URL of CCPA page
		softAssert.assertEquals(getDriver().getCurrentUrl(), CCPA_URL);

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = false)
	public void RW_T2030_ValidateCCPASecondaryNavigation()
	{
		softAssert = new SoftAssert();
		testStart("****************** Validating the CCPA Secondary Navigation Title ********************");

		// Verify the name on CCPA tab
		softAssert.assertEquals(legalFooter.getNameOfCCPATab(), CCPA);

		// Verify the color at the bottom of CCPA tab
		softAssert.assertEquals(legalFooter.getBorderColorOfCCPATab(), ACTIVE_TAB_COLOR);

		softAssert.assertAll();
	}

	@Test(priority = 11)
	public void RW_T1997_ValidateDoNotSellMyData()
	{
		softAssert = new SoftAssert();
		testStart("****************** Validating the Do Not Sell My Data ********************");

		// Verify the presence of Do Not Sell My Data Link
		softAssert.assertTrue(legalFooter.isDoNotSellMyDataPresent(),
				"Issue-----> Do Not Sell My Data Link Not Present On Legal Footer");

		legalFooter.clickDoNotSellMyData();

		// Verify the text of Confirmed
		softAssert.assertEquals(legalFooter.getConfirmedText(), CONFIRMED,
				"Issue-----> Confirmed Not Found After Clicking on Do Not Sell My Data link");

		// Verify the presence of Not Selling your Data
		softAssert.assertEquals(legalFooter.getNotSellingYourDataText(), NOT_SELLING_YOUR_DATA,
				"Issue---->Not Selling Your Data Not Found On Legal Footer");

	}

	@Test(priority = 12)
	public void RW_T1428_ValidatingTheWidthOfPrivacyPolicy()
	{
		softAssert = new SoftAssert();
		testStart("*********** Validating the width of privacy policy banner ********************");
		softAssert.assertEquals(legalFooter.getPrivacyPolicyBannerWidth(), BANNER_WIDTH,
				"Issue------> Banner width was expected 320px but found " + legalFooter.getPrivacyPolicyBannerWidth());
		softAssert.assertAll();
	}

	@Test(priority = 13)
	public void RW_T1422_VerifyingThePresenceOfPrivacyPolicyBanner()
	{
		softAssert = new SoftAssert();
		testStart(
				"******* Validate presence of privacy policy banner, 'I Understand' button, text on privacy policy banner *****************");

		// Verify the presence of privacy policy banner
		softAssert.assertTrue(legalFooter.isAlertBannerPresent(), "Issue-----> Privacy Policy banner not found");

		// Verify the presence of "I Understand" button on privacy policy banner
		softAssert.assertTrue(legalFooter.isIUnderstandButtonPresentOnPrivacyPolicyBanner(),
				"Issue----> Button not found");

		// Verify the text of the button on privacy policy banner
		softAssert.assertEquals(legalFooter.getTextOfButtonOnPrivacyPolicyBanner(), I_UNDERSTAND,
				"Issue-----> The text found on the button is " + legalFooter.getTextOfButtonOnPrivacyPolicyBanner());

		softAssert.assertAll();
	}

	@Test(priority = 14)
	public void RW_T1424_PrivacyPolicy_URL_Verification()
	{
		softAssert = new SoftAssert();

		testStart(
				"******* Validating the URL after clicking on Privacy Policy link on the banner ************************");
		legalFooter.clickPrivacyPolicyLinkOnBanner();

		// verify the URL on Privacy Policy page
		softAssert.assertEquals(getDriver().getCurrentUrl(), PRIVACY_POLICY_URL,
				"Issue-----> Privacy Policy URL " + getDriver().getCurrentUrl() + " not as expected");
		softAssert.assertAll();
	}

	@Test(priority = 15)
	public void RW_T1430_CookiePolicy_URL_Verification()
	{
		softAssert = new SoftAssert();

		testStart(
				"******* Validating the URL after clicking on Cookie Policy link on the banner ************************");
		legalFooter.clickCookiePolicyLinkOnBanner();

		// verify the URL on Cookie Policy page
		softAssert.assertEquals(getDriver().getCurrentUrl(), COOKIE_POLICY_URL,
				"Issue-----> Cookie Policy URL " + getDriver().getCurrentUrl() + " not as expected");
		softAssert.assertAll();
	}

	@Test(priority = 16)
	public void RW_T1431_ValidatePresenceOfPrivacyPolicyBannerAfterClickingIUnderstand()
	{
		softAssert = new SoftAssert();

		testStart(
				"******* Validating whether privacy policy banner disappears after clicking on 'I Understand' button **************");
		legalFooter.clickIUnderstand();

		// verify the presence of Privacy Policy Banner after clicking I Understand
		// button
		softAssert.assertFalse(legalFooter.isAlertBannerPresent(),
				"Issue-----> Privacy Policy Banner still present even after clicking on 'I Understand' button");

		softAssert.assertAll();
	}

}
