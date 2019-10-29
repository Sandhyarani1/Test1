package com.accuweather.glacier.www.Footer;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LegalFooter;

public class Test_LegalFooter extends AccuWeatherBaseTest
{
	private final static String ZIPCODE = "53558";
	private final static String EXPECTED_LANDING_PAGE_TITLE = "Mc Farland Weather - AccuWeather Forecast for WI 53558";
	private final static String TERMS_OF_USE_TITLE = "Terms of Use | AccuWeather";
	private final static String TERMS_OF_USE = "Terms of Use";
	//private final static String TERMS_OF_USE_URL = "https://development.accuweather.com/en/legal";
	private final static String TERMS_OF_USE_URL = "https://qualityassurance.accuweather.com/en/legal";
	private final static String TERMS_OF_USE_CONTENT_HEADING = "AccuWeather Terms Of Use";
	private final static String PRIVACY_POLICY_TITLE = "Privacy Statement & Policy | AccuWeather";
	private final static String PRIVACY_POLICY = "Privacy Policy";
	private final static String PRIVACY_POLICY_TAB = "Privacy Statement";
	//private final static String PRIVACY_POLICY_URL = "https://development.accuweather.com/en/privacy";
	private final static String PRIVACY_POLICY_URL = "https://qualityassurance.accuweather.com/en/privacy";
	private final static String PRIVACY_POLICY_CONTENT_HEADING = "Privacy Policy";
	private final static String COOKIE_POLICY_TITLE = "Cookie Policy | AccuWeather";
	private final static String COOKIE_POLICY = "Cookie Policy";
	//private final static String COOKIE_POLICY_URL = "https://development.accuweather.com/en/cookiepolicy";
	private final static String COOKIE_POLICY_URL = "https://qualityassurance.accuweather.com/en/cookiepolicy";
	private final static String COOKIE_POLICY_CONTENT_HEADING = "Policy on Cookies, Web Beacons, Pixels, and Similar Technologies";
	private final static String TAG_DISCLOSURE_TITLE = "TAG Disclosure | AccuWeather";
	private final static String TAG_DISCLOSURE = "TAG Disclosure";
	//private final static String TAG_DISCLOSURE_URL = "https://development.accuweather.com/en/tag-publisher-sourcing-disclosure";
	private final static String TAG_DISCLOSURE_URL = "https://qualityassurance.accuweather.com/en/tag-publisher-sourcing-disclosure";
	private final static String TAG_DISCLOSURE_CONTENT_HEADING = "TAG PUBLISHER SOURCE AND DISCLOSURE";
	private final static String ACTIVE_TAB_COLOR = "#f05514";
	private final static String COPYRIGHT_INFO = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	private final static String REGISTERED_TRADEMARKS = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	private final static String ALL_RIGHTS_RESERVED = "© 2019 AccuWeather, Inc. \"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc. All Rights Reserved.";
	//Providers
	private final static String EXPECTED_LIVERAMP_PAGE_URL = "https://liveramp.com/privacy/";
	private final static String EXPECTED_CUEBIQ_PAGE_URL = "https://www.cuebiq.com/privacypolicy/";
	private final static String EXPECTED_INTERSECTION_PAGE_URL = "https://www.intersection.com/privacy-policy/";
	
	private LegalFooter legalFooter = new LegalFooter();
	
	@Test(priority=1)
	public void TC1_verifyPresenceOfTermsOfUseInFooter()
	{
		testStart("Validate whether Terms of Use link is present in footer");
		Assert.assertTrue(legalFooter.isTermsOfUsePresent());
	}

	@Test(priority=2)
	public void TC1_verifyTheTextOfTermsOfUseInFooter()
	{
		testStart("Validate whether Terms of Use is spelled correctly");
		Assert.assertEquals(legalFooter.getTermsOfUseText(),TERMS_OF_USE);
	}
	
	@Test(priority=3)
	public void TC2_verifyTitleOfTermsOfUse()
	{
		testStart("Validate the title of Terms Of use page");
		legalFooter.clickTermsOfUse();
		System.out.println("getDriver(). getTitle():"+getDriver().getTitle());
		Assert.assertEquals(getDriver().getTitle(),TERMS_OF_USE_TITLE);
	}

	@Test(priority=4)
	public void TC2_verifyURLOfTermsOfUse()
	{
		testStart("Validate whether the URL of Terms Of use page is correct");
		Assert.assertEquals(legalFooter.getURLOfTermsOfUse(),TERMS_OF_USE_URL);		
	}

	@Test(priority=5)
	public void TC2_verifyTermsOfUseTab()
	{
		testStart("Validate the name of Terms Of use tab");
		Assert.assertEquals(legalFooter.getNameOfTermsOfUseTab(),TERMS_OF_USE.toUpperCase());
	}

	@Test(priority=6)
	public void TC2_verifyBorderColorOfTermsOfUseTab()
	{
		testStart("Validate whether the color of Terms of Use tab is Orange");
		Assert.assertEquals(legalFooter.getTopBorderColor_Of_TermsOfUseTab(),ACTIVE_TAB_COLOR);
	}

	@Test(priority=7)
	public void TC2_verifyHeadingOfTermsOfUseTab()
	{
		testStart("Validate the Heading of Terms of Use content");
		Assert.assertEquals(legalFooter.getHeadingOfTermsOfUse(),TERMS_OF_USE_CONTENT_HEADING);
	}

	@Test(priority=8)
	public void TC3_verifyPresenceOfPrivacyPolicyInFooter()
	{
		testStart("Validate whether Privacy Policy link is present in footer");
		Assert.assertTrue(legalFooter.isPrivacyPolicyPresent());
	}

	@Test(priority=9)
	public void TC3_verifyTheTextOfPrivacyPolicyInFooter()
	{
		testStart("Validate whether Privacy Policy is spelled correctly");
		Assert.assertEquals(legalFooter.getPrivacyPolicyText(),PRIVACY_POLICY);
	}

	@Test(priority=10, enabled=true)
	public void TC4_verifyTitleOfPrivacyPolicy()
	{
		testStart("Validate the title of Terms Of use page");
		legalFooter.clickPrivacyPolicy();
		System.out.println("getDriver().getTitle():"+getDriver().getTitle());
		Assert.assertEquals(getDriver().getTitle(),PRIVACY_POLICY_TITLE);
	}

	@Test(priority=11)
	public void TC4_verifyURLOfPrivacyPolicy()
	{
		testStart("Validate whether the URL of Privacy Policy page is correct");
		Assert.assertEquals(legalFooter.getURLOfPrivacyPolicy(),PRIVACY_POLICY_URL);
	}

	@Test(priority=12)
	public void TC4_verifyPrivacyPolicyTab()
	{
		testStart("Validate the name of Privacy Policy tab");
		Assert.assertEquals(legalFooter.getNameOfPrivacyPolicyTab(),PRIVACY_POLICY_TAB.toUpperCase());
	}

	@Test(priority=13)
	public void TC4_verifyBorderColorOfPrivacyPolicyTab()
	{
		testStart("Validate whether the color of Privacy Policy tab is Orange");
		Assert.assertEquals(legalFooter.getTopBorderColor_Of_PrivacyPolicyTab(),ACTIVE_TAB_COLOR);
	}

	@Test(priority=14)
	public void TC4_verifyHeadingOfPrivacyPolicyTab()
	{
		testStart("Validate the Heading of Privacy Policy content");
		Assert.assertEquals(legalFooter.getHeadingOfPrivacyPolicy(),PRIVACY_POLICY_CONTENT_HEADING);
	}

	@Test(priority=15)
	public void TC5_verifyPresenceOfCookiePolicyInFooter()
	{
		testStart("Validate whether Cookie Policy link is present in footer");
		Assert.assertTrue(legalFooter.isCookiePolicyPresent());
	}

	@Test(priority=16)
	public void TC5_verifyTheTextOfCookiePolicyInFooter()
	{
		testStart("Validate whether Cookie Policy is spelled correctly");
		Assert.assertEquals(legalFooter.getCookiePolicyText(),COOKIE_POLICY);
	}

	@Test(priority=17)
	public void TC6_verifyTitleOfCookiePolicy()
	{
		testStart("Validate the title of Cookie Policy page");
		legalFooter.clickCookiePolicy();
		Assert.assertEquals(getDriver().getTitle(),COOKIE_POLICY_TITLE);
	}

	@Test(priority=18)
	public void TC6_verifyURLOfCookiePolicy()
	{
		testStart("Validate whether the URL of Cookie Policy page is correct");
		Assert.assertEquals(legalFooter.getURLOfCookiePolicy(),COOKIE_POLICY_URL);
	}

	@Test(priority=19)
	public void TC6_verifyCookiePolicyTab()
	{
		testStart("Validate the name of Cookie Policy tab");
		Assert.assertEquals(legalFooter.getNameOfCookiePolicyTab(),COOKIE_POLICY.toUpperCase());
	}

	@Test(priority=20, enabled=true)
	public void TC6_verifyBorderColorOfCookiePolicyTab()
	{
		testStart("Validate whether the color of Cookie Policy tab is Orange");
		Assert.assertEquals(legalFooter.getTopBorderColor_Of_CookiePolicyTab(),ACTIVE_TAB_COLOR);
	}

	@Test(priority=21)
	public void TC6_verifyHeadingOfCookiePolicyTab()
	{
		testStart("Validate the Heading of Cookie Policy content");
		Assert.assertEquals(legalFooter.getHeadingOfCookiePolicy(),COOKIE_POLICY_CONTENT_HEADING);
	}

	@Test(priority=22)
	public void TC7_verifyPresenceOfTAGDisclosureInFooter()
	{
		testStart("Validate whether TAG Dsiclosure link is present in footer");
		Assert.assertTrue(legalFooter.isTAGDisclosurePresent());
	}

	@Test(priority=23)
	public void TC7_verifyTheTextOfTAGDisclosureInFooter()
	{
		testStart("Validate whether TAG Disclosure is spelled correctly");
		Assert.assertEquals(legalFooter.getTAGDisclosureText(),TAG_DISCLOSURE);
	}

	@Test(priority=24)
	public void TC8_verifyTitleOfTAGDisclosure()
	{
		testStart("Validate the title of TAG Disclosure page");
		legalFooter.clickTAGDisclosure();
		Assert.assertEquals(getDriver().getTitle(),TAG_DISCLOSURE_TITLE);
	}

	@Test(priority=25)
	public void TC8_verifyURLOfTAGDisclosure()
	{
		testStart("Validate whether the URL of TAG Disclosure page is correct");
		Assert.assertEquals(legalFooter.getURLOfTAGDisclosure(),TAG_DISCLOSURE_URL);
	}

	@Test(priority=26)
	public void TC8_verifyTAGDisclosureTab()
	{
		testStart("Validate the name of TAG Disclosure tab");
		Assert.assertEquals(legalFooter.getNameOfTAGDisclosureTab(),TAG_DISCLOSURE.toUpperCase());
	}

	@Test(priority=27)
	public void TC8_verifyBorderColorOfTAGDisclosureTab()
	{
		testStart("Validate whether the color of TAG Disclosure tab is Orange");
		Assert.assertEquals(legalFooter.getTopBorderColor_Of_TAGDisclosureTab(),ACTIVE_TAB_COLOR);
	}

	@Test(priority=28)
	public void TC8_verifyHeadingOfTAGDisclosureTab()
	{
		testStart("Validate the Heading of TAG Disclosure content");
		Assert.assertEquals(legalFooter.getHeadingOfTAGDisclosure(),TAG_DISCLOSURE_CONTENT_HEADING);
	}

	@Test(priority=29)
	public void TC9_verifyCopyrightInformation()
	{
		testStart("Validate the copyright information content");
		Assert.assertEquals(legalFooter.getCopyRightInformation(),COPYRIGHT_INFO);
	}

	@Test(priority=30)
	public void TC9_verifyRegisteredTrademarksInformation()
	{
		testStart("Validate the registered trademarks content");
		Assert.assertEquals(legalFooter.getRegisteredTrademarksInformation(),REGISTERED_TRADEMARKS);
	}

	@Test(priority=31)
	public void TC9_verifyAllRightsReservedInformation()
	{
		testStart("Validate the right reserved content");
		Assert.assertEquals(legalFooter.getAllRightsReservedInformation(),ALL_RIGHTS_RESERVED);
	}

	@Test(priority=32)
	public void TC9_verifyYearInCopyrightInformation()
	{
		testStart("Validate the copyright information content");
		Assert.assertEquals(legalFooter.getYearInCopyRightInformation(),legalFooter.getCurrentYear());		
	}

	@Test(priority=33)
	public void TC10_verifyPresenceOfFooterWhenLanguageChanged()
	{
		testStart("Validate the presence of footer when language changed");
		Assert.assertTrue(legalFooter.legalFooterStatusWhenLangChanged());
	}
	
	@Test(priority=33)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyAdvertisingSectionHaveUpdatedProviders()
	{
		testStart("Verify Advertising section have updated code");
		Assert.assertTrue(legalFooter.verifyAdvertisingSectionHaveUpdatedProviders());
	}
	
	@Test(priority=33)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyLiveRampLinkAndPage()
	{
		testStart("Verify LiveRampPolicy URL and page");
		String actualURL = legalFooter.verifyLiveRampLinkAndPage();
	    Assert.assertEquals(actualURL, EXPECTED_LIVERAMP_PAGE_URL);
	}
	
	@Test(priority=33)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyCuebiqLinkAndPage()
	{
		testStart("Verify Cuebiq URL and page");
		String actualURL = legalFooter.verifyCuebiqLinkAndPage();
	    Assert.assertEquals(actualURL, EXPECTED_CUEBIQ_PAGE_URL);
	}
	
	@Test(priority=33)
	public void RW_T761_ValidateDataProviderListupdatedontheProviderlistPage_verifyIntersectionAndPage()
	{
		testStart("Verify Intersection URL and page");
		String actualURL = legalFooter.verifyIntersectionLinkAndPage();
	    Assert.assertEquals(actualURL, EXPECTED_INTERSECTION_PAGE_URL);
	}
}
