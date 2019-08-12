package com.accuweather.glacier.m.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;

public class legalFooterMobile extends MobileBasePage {

	private By lagalFooterSection = By.cssSelector("div.footer-legalese.footer-legalese");
	private By termsOfUseText = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(1)");
	private By termsOfUsePageTitle = By.cssSelector("head > title");

	private By TermsOfUseTab = By
			.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1");
	private By TermsOfUsePageHeading = By.cssSelector(
			"div.template-root:nth-child(1) div:nth-child(5) div.page-content div.legal-content div.legal-page-wrapper > h2.legal-page-heading:nth-child(2)");
	private By cookiePolicyPageHeading = By.cssSelector(
			"div.template-root:nth-child(1) div:nth-child(5) div.page-content div.legal-content div.legal-page-wrapper > h2.legal-page-heading:nth-child(2)");
	private By tagDisclosurePageHeading = By.cssSelector(
			"div.template-root:nth-child(1) div:nth-child(5) div.page-content div.legal-content div.legal-page-wrapper > h2.legal-page-heading:nth-child(2)");

	private By privacyAndPolicyfooterLink = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(2)");
	private By privacyAndPolicyPageTitle = By.cssSelector("head > title");
	private By TagDisclosurePageTitle = By.cssSelector("head > title");

	private By cookiepolicyPageTitle = By.cssSelector("head > title");
	private By PrivacyAndPolicyTab = By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	private By cookiePolicyTab = By
			.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1");
	private By TagDisclosureTab = By
			.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1");

	private By PrivacyAndPolicyPageHeading = By.cssSelector("div:nth-child(5) > div > div > div > h2");
	private By cookiePolicyfooterLink = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(3)");
	private By TagDisclosurefooterLink = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(4)");

	private By copyright2019Accuweather = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-copyright > span:nth-child(1)");
	private By copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherInc = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-copyright > span:nth-child(2)");
	private By allRightsReserved = By.cssSelector(
			"div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-copyright > span:nth-child(3)");

	/** Method to get legal footer section is displayed */
	public boolean legalFooterSectionIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(lagalFooterSection).isDisplayed();
		return true;
	}

	/** Method to get terms Of Use Text is displayed */
	public boolean termsOfUseTextIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(termsOfUseText).isDisplayed();
		return true;
	}

	/** Method to get terms Of Use Text is displayed */
	public boolean clicktermsOfUseText() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(termsOfUseText).click();
		return true;
	}

	/** Method to get title of the page terms Of Use Page */
	public String getTitlePageTermsOfUse() {
		WebPageLoaded.isDomInteractive();
		return getDriver().getTitle();
	}

	/** Method to get name on tab is "TERMS OF USE" in upper case */
	public String getTabNameTermsOfUseIsinUpperCase() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TermsOfUseTab).scrollIntoView();
		return getDriver().findElement(TermsOfUseTab).getText();
	}

	/**
	 * Method to validate Tab Name Terms Of Use Is in Is Orange Color.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String TabNameTermsOfUseIsinIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TermsOfUseTab).scrollIntoView();
		String arrowcolour = getDriver().findElement(TermsOfUseTab).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	/** Method to get Terms of Use Page heading */
	public String getTermsOfUsePageHeading() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TermsOfUsePageHeading).scrollIntoView();
		return getDriver().findElement(TermsOfUsePageHeading).getText();
	}

	/** Method to click privacy and Policy footer link is displayed */
	public boolean clickPrivacyAndPolicyFooterLinkIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(privacyAndPolicyfooterLink).isDisplayed();
		return true;
	}

	/** Method to click privacy and Policy footer link */
	public boolean clickPrivacyAndPolicyFooterLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(privacyAndPolicyfooterLink).click();
		return true;
	}

	/** Method to get title of the page "Privacy and Policy" */
	public String getTitlePrivacyAndPolicy() {
		WebPageLoaded.isDomInteractive();
		return getDriver().getTitle();
	}

	/**
	 * Method to current url on privacy and Policy page
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url privacy and Policy page
	 **/
	public String privacyandPolicypageUrl() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(privacyAndPolicyPageTitle);
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}

	/** Method to get name on tab is "TERMS OF USE" in upper case */
	public String getTabNamePrivacyandPolicyeIsinUpperCase() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(PrivacyAndPolicyTab).scrollIntoView();
		return getDriver().findElement(PrivacyAndPolicyTab).getText();
	}

	/**
	 * Method to validate Tab Name Terms Of Use Is in Is Orange Color.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String TabNamePrivacyAndPolicyIsinIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(PrivacyAndPolicyTab).scrollIntoView();
		String arrowcolour = getDriver().findElement(PrivacyAndPolicyTab).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	/** Method to get Privacy and Policy Page heading */
	public String getPrivacyAndPolicyPageHeading() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(PrivacyAndPolicyPageHeading).scrollIntoView();
		return getDriver().findElement(PrivacyAndPolicyPageHeading).getText();
	}

	/** Method to click Cookie policy footer link is displayed */
	public boolean clickCookiePolicyFooterLinkIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(cookiePolicyfooterLink).isDisplayed();
		return true;
	}

	/** Method to click privacy and Policy footer link */
	public boolean clickCookiePolicyFooterLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(cookiePolicyfooterLink).click();
		return true;
	}

	/** Method to get title of the page "Privacy and Policy" */
	public String getTitleCookiePolicy() {
		WebPageLoaded.isDomInteractive();
		return getDriver().getTitle();
	}

	/**
	 * Method to current url on privacy and Policy page
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url privacy and Policy page
	 **/
	public String cookiePolicypageUrl() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(cookiepolicyPageTitle);
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}

	/** Method to get name on tab is "TERMS OF USE" in upper case */
	public String getTabNameCookiePloicyeIsinUpperCase() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(cookiePolicyTab).scrollIntoView();
		return getDriver().findElement(cookiePolicyTab).getText();
	}

	/**
	 * Method to validate Tab Name Terms Of Use Is in Is Orange Color.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String TabNameCookiePolicyIsinIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(cookiePolicyTab).scrollIntoView();
		String arrowcolour = getDriver().findElement(cookiePolicyTab).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	/** Method to get Terms of Use Page heading */
	public String getCookiePolicyPageHeading() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(cookiePolicyPageHeading).scrollIntoView();
		return getDriver().findElement(cookiePolicyPageHeading).getText();
	}

	/** Method to click Cookie policy footer link is displayed */
	public boolean clickTagDisclosureFooterLinkIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TagDisclosurefooterLink).isDisplayed();
		return true;
	}

	/** Method to click privacy and Policy footer link */
	public boolean clickTagDisclosureFooterLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TagDisclosurefooterLink).click();
		return true;
	}

	/** Method to get title of the page "Privacy and Policy" */
	public String getTitleTagDisclosure() {
		WebPageLoaded.isDomInteractive(5000);
		return getDriver().getTitle();
	}

	/**
	 * Method to current url on privacy and Policy page
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns url privacy and Policy page
	 **/
	public String TagDisclosurepageUrl() {
		WebPageLoaded.isDomInteractive(10000);
		getDriver().findElement(TagDisclosurePageTitle);
		WebPageLoaded.isDomInteractive(10000);
		return getDriver().getCurrentUrl();
	}

	/** Method to get name on tab is "TERMS OF USE" in upper case */
	public String getTabNameTagDisclosureIsinUpperCase() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TagDisclosureTab).scrollIntoView();
		return getDriver().findElement(TagDisclosureTab).getText();
	}

	/**
	 * Method to validate Tab Name Terms Of Use Is in Is Orange Color.
	 * 
	 * @author Mohammed Siddiq
	 * @return-String - Returns color value if displayed
	 **/
	public String TabNameTagDisclosureIsinIsOrangeColor() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(TagDisclosureTab).scrollIntoView();
		String arrowcolour = getDriver().findElement(TagDisclosureTab).getCssValue("color");
		String arrowcolourdisplayed = Color.fromString(arrowcolour).asHex();
		return arrowcolourdisplayed;
	}

	/** Method to get Terms of Use Page heading */
	public String getTagDisclosurePageHeading() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(tagDisclosurePageHeading).scrollIntoView();
		return getDriver().findElement(tagDisclosurePageHeading).getText();
	}

	/** Method to click Cookie policy footer link is displayed */
	public boolean copyrightinformationhas2019AccuWeatherIncTextIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(copyright2019Accuweather).getText().contains("© 2019 AccuWeather, Inc.");

	}

	/** Method to click Cookie policy footer link is displayed */
	public boolean copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherIncTextIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(copyrightAccuWeatherandsundesignareregisteredtrademarksofAccuWeatherInc)
				.getText().contains("\"AccuWeather\" and sun design are registered trademarks of AccuWeather, Inc.");

	}

	/** Method to click Cookie policy footer link is displayed */
	public boolean copyrightAllRightsReservedTextIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(allRightsReserved).getText().contains("All Rights Reserved.");

	}
}
