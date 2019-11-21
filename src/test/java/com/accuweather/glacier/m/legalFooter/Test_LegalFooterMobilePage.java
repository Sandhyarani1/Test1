package com.accuweather.glacier.m.legalFooter;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.HomePageNonUSMobile;
import com.accuweather.glacier.m.pages.legalFooterMobile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;

public class Test_LegalFooterMobilePage extends AccuWeatherMobileBaseTest {

	public final static String EXPECTED_TERMSOFUSETAB_TEXT_COLOR = "1f1f1f";
	public final static String EXPECTED_PRIVACYANDPOLICY_TEXT_COLOR = "1f1f1f";
	public final static String EXPECTED_CCOOKIEPOLICY_TEXT_COLOR = "1f1f1f";
	public final static String EXPECTED_TAGDISCLOSURE_TEXT_COLOR = "1f1f1f";
	public final static String EXPECTED_BLACK_COLOR = "#1f1f1f";
	public final static String EXPECTED_WHITE_COLOR = "#ffffff";

	public final static String EXPECTED_BANNER_STRING = "We have updated our Privacy Policy and our Cookie Policy.";
	public final static String EXPECTED_BANNER_I_UNDERSTAND_STRING = "I Understand";
	private final static String EXPECTED_PRIVACY_POLICY_URL = "https://qualityassurance.accuweather.com/en/privacy";
	private final static String EXPECTED_COOKIE_POLICY_URL = "https://qualityassurance.accuweather.com/en/cookiepolicy";
	private final static String EXPECTED_PRIVACY_POLICY_BANNER_WIDTH = "320px";

	private final static String EXPECTED_LIVERAMP_PAGE_URL = "https://liveramp.com/privacy/";
	private final static String EXPECTED_CUEBIQ_PAGE_URL = "https://www.cuebiq.com/privacypolicy/";
	private final static String EXPECTED_INTERSECTION_PAGE_URL = "https://www.intersection.com/privacy-policy/";

	private LandingPage landingpage = new LandingPage();
	private NavigationBar navBar = new NavigationBar();
	private legalFooterMobile legalFooterMob = new legalFooterMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();
	private HomePageNonUSMobile homePage = new HomePageNonUSMobile();

	@Test(priority = 1, enabled = false)
	public void RW_T100_VerifylegalFooterSectionIsDisplayed() {
		testStart("Is legal footer section is displayed");
		Assert.assertTrue(legalFooterMob.legalFooterSectionIsDisplayed());
	}

	@Test(priority = 2, enabled = false)
	public void RW_T101_VerifytermsOfUseTextIsDisplayed() {
		testStart("Is terms Of Use Text");
		Assert.assertTrue(legalFooterMob.termsOfUseTextIsDisplayed());
	}

	@Test(priority = 3, enabled = false)
	public void RW_T101_VerifyclicktermsOfUseText() {
		testStart("Is terms Of Use Text");
		Assert.assertTrue(legalFooterMob.clicktermsOfUseText());
	}

	@Test(priority = 4, enabled = false)
	public void RW_T101_VerifyPageTitleTermsOfUseText() {
		testStart("Is Page tilte : Terms of Use - AccuWeather.com");
		legalFooterMob.clicktermsOfUseText();
		Assert.assertEquals(legalFooterMob.getTitlePageTermsOfUse(), "Terms of Use | AccuWeather",
				"Page title incorrect");
	}

	@Test(priority = 5, enabled = false)
	public void RW_T101_VerifyTabNameTermsOfUseTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
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
		Assert.assertTrue(legalFooterMob.clickPrivacyAndPolicyFooterLinkIsDisplayed());
	}

	@Test(priority = 9, enabled = false)
	public void RW_T102_VerifyPrivacyAndPolicyFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		Assert.assertTrue(legalFooterMob.clickPrivacyAndPolicyFooterLink());
	}

	@Test(priority = 10, enabled = false)
	public void RW_T102_VerifyPageTitlePrivacyAndPolicy() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTitlePrivacyAndPolicy(), "Privacy Statement & Policy | AccuWeather",
				"Page title incorrect");
	}

	@Test(priority = 11, enabled = false)
	public void RW_T102_VerifyPageTitlePrivacyAndPolicyPageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.privacyandPolicypageUrl(),
				"https://qualityassurance.accuweather.com/en/privacy", "Page url incorrect");
	}

	@Test(priority = 12, enabled = false)
	public void RW_T102_VerifyTabNamePolicyandPrivacyTabTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		legalFooterMob.clickPrivacyAndPolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTabNamePrivacyandPolicyeIsinUpperCase(), "PRIVACY STATEMENT",
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
		Assert.assertTrue(legalFooterMob.clickCookiePolicyFooterLinkIsDisplayed());
	}

	@Test(priority = 16, enabled = false)
	public void RW_T102_VerifyCookiePolicyFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		Assert.assertTrue(legalFooterMob.clickCookiePolicyFooterLink());
	}

	@Test(priority = 17, enabled = false)
	public void RW_T103_VerifyPageTitleCookiePolicy() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTitleCookiePolicy(), "Cookie Policy | AccuWeather",
				"Page title incorrect");

	}

	@Test(priority = 18, enabled = false)
	public void RW_T103_VerifyPageTitleCookiePolicyPageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.cookiePolicypageUrl(),
				"https://qualityassurance.accuweather.com/en/cookiepolicy", "Page url incorrect");
	}

	@Test(priority = 19, enabled = false)
	public void RW_T103_VerifyTabNamecookiePolicyTabTextIsInUpperCase() {
		testStart("Tab Name Terms Of Use Text Is In UpperCase");
		legalFooterMob.clickCookiePolicyFooterLink();
		Assert.assertEquals(legalFooterMob.getTabNameCookiePloicyeIsinUpperCase(), "COOKIE POLICY",
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

	@Test(priority = 22, enabled = false)
	public void RW_T104_VerifyTagDisclosureFooterLinkIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob.clickTagDisclosureFooterLinkIsDisplayed());
	}

	@Test(priority = 23, enabled = false)
	public void RW_T104_VerifyTagDisclosureFooterLink() {
		testStart("Privacy And Policy Footer Link is clicked");
		Assert.assertTrue(legalFooterMob.clickTagDisclosureFooterLink());
	}

	@Test(priority = 24, enabled = false)
	public void RW_T104_VerifyPageTitleTagDisclosure() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickTagDisclosureFooterLink();
		Assert.assertEquals(legalFooterMob.getTitleTagDisclosure(), "TAG Disclosure | AccuWeather",
				"Page title incorrect");
	}

	@Test(priority = 25, enabled = false)
	public void RW_T104_VerifyPageTitleTagDisclosurePageCurrentUrl() {
		testStart("Is Page tilte : Privacy Statement & Policy - AccuWeather.com");
		legalFooterMob.clickTagDisclosureFooterLink();
		Assert.assertEquals(legalFooterMob.TagDisclosurepageUrl(),
				"https://qualityassurance.accuweather.com/en/tag-publisher-sourcing-disclosure", "Page url incorrect");
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

	@Test(priority = 30, enabled = false)
	public void RW_T105_VerifycopyrightinformationTextIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob
				.copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherIncTextIsDisplayed());
	}

	@Test(priority = 31, enabled = false)
	public void RW_T105_VerifycopyrightReservedinformationTextIsDisplayed() {
		testStart("Cookie Policy Footer Link Is Displayed");
		Assert.assertTrue(legalFooterMob.copyrightAllRightsReservedTextIsDisplayed());
	}

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
	
	/////////////////

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
	
	
	////////////////////
	
	
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
	 * @Test(priority = 42, enabled = true) public void
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
	
	
	

}
