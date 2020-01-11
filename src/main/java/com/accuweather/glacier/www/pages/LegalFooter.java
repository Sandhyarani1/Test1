package com.accuweather.glacier.www.pages;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class LegalFooter extends BasePage
{
	private By byCopyRight = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-copyright > span");
	private By byTermsOfUse = By.cssSelector("div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(1)");
	private By byTermsOfUseSpanish = By.cssSelector("div.template-root > div.base-footer > div > div.footer-terms > a:nth-child(1)");
	private By byPrivacyPolicy = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(2)");
	private By byCookiePolicy = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(3)");
	private By byCCPA = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > span:nth-child(4) > a:nth-child(4)");
	private By byTAGDisclosure = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > a:nth-child(4)");
	private By byDoNotSellMyData = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > span > a.ccpa-link > span.opt-out");
	private By byConfirmed = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > span > a.ccpa-link > span.opt-out-transition > span");
	private By byNotSellingYourData = By.cssSelector("div.footer-legalese.footer-legalese > div.footer-terms > span > a.ccpa-link > span.opt-in");
	private By byTermsOfUseTab = By.cssSelector("div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(1)");
	private By byPrivacyPolicyTab = By.cssSelector("div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(2)");
	private By byCookiePolicyTab = By.cssSelector("div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(5)");
	private By byTAGDisclosureTab = By.cssSelector("div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	private By byCCPATab = By.cssSelector("div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(7) > h1");
	private By byTermsOfUseHeading = By.cssSelector("div.page-content > div > div > h2");
	private By byPrivacyPolicyHeading = By.cssSelector("div.template-root > div > div.page-content > div > div > h2");
	private By byTAGDisclosureHeading = By.cssSelector("div.template-root > div > div.page-content > div > div > h2");
	private By byCookiePolicyHeading = By.cssSelector("div.template-root > div > div.page-content > div > div > h2");
	private By bySettingsButton = By.cssSelector("div.main-menu > div.header-right-container > div.settings-button");
	private By byLanguageSelector = By.cssSelector("div.utility-bar > div > div > div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-select-wrapper > div.select-title.non-touch");
	private By bySpanish = By.cssSelector("div.utility-bar > div > div > div.dropdown-select.locale-dropdown.fade-in-left > div.dropdown-content > div:nth-child(3)");
	private By byPrivacyPolicyBanner = By.cssSelector("div.template-root > div.privacy-policy-banner");
	private By byIUnderstandButton = By.cssSelector("div.privacy-policy-banner > div.banner-body > div.banner-button");
	private By byStartTextPrivacyPolicyBanner = By.xpath("/html/body/div/div[10]/div/p/text()[1]");
	private By byMiddleTextPrivacyPolicyBanner = By.xpath("/html/body/div/div[10]/div/p/text()[2]");
	private By byPrivacyPolicyLinkOnBanner = By.cssSelector("div.template-root > div.privacy-policy-banner > div > p > a:nth-child(1)");
	private By byCookiePolicyLinkOnBanner = By.cssSelector("div.template-root > div.privacy-policy-banner > div > p > a:nth-child(2)");
	
	
	/**
	 * Method to switch to a different window
	 * @author HFARAZ
	 * */
	public void switchToPopUpWindow(String webPage) {
		Set<String> windows = getDriver().getWindowHandles();
		System.out.println(windows.size());
		Iterator iterator = windows.iterator();
		String currentwindowId;
		while(iterator.hasNext()) 
		{
			currentwindowId = iterator.next().toString();
			if(!currentwindowId.equals(webPage))
				getDriver().switchTo().window(currentwindowId);
		}

	}
	
	/**
	 * @author HFARAZ
	 * Method to scroll to the bottom of the page
	 * */
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver().getWebDriver();
		js.executeScript("window.scrollBy(0,10000)");
		WebPageLoaded.isDomComplete();
		js.executeScript("window.scrollBy(0,10000)");
		WebPageLoaded.isDomComplete();
	}
	
/**************************************************** TERMS OF USE ******************************************************/
	
	/**
	 * Method to validate if Terms Of Use link is present on Footer
	 * @author HFARAZ
	 * @return - Boolean value - "true if Terms of use link is present else false"
	 * */
	public Boolean isTermsOfUsePresent()
	{
		Boolean isTermsOfUsePresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byTermsOfUse).isDisplayed())
				isTermsOfUsePresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isTermsOfUsePresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isTermsOfUsePresent = false;
		}
		
		return isTermsOfUsePresent;
		
	}

	/**
	 * Method to get the text of Terms Of Use present on Footer
	 * @author HFARAZ
	 * @return - String value - "returns the text of Terms of Use"
	 * */
	public String getTermsOfUseText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTermsOfUse).getText();
	}
	
	/**
	 * Method to click on Terms Of Use
	 * */
	public void clickTermsOfUse()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byTermsOfUse).jsClick();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();	
	}

	

	/**
	 * Method to get the value of Terms Of Use tab
	 * @author HFARAZ
	 * @return - String value - "name of the Terms of Use Tab"
	 * */
	public String getNameOfTermsOfUseTab()
	{
		WebElement termsOfUseTab = getDriver().findElement(byTermsOfUseTab);
		return termsOfUseTab.getText();
	}

	/**
	 * Method to get the heading of Terms Of Use page
	 * @author HFARAZ
	 * @return - String value - "heading of Terms Of Use page"
	 * */
	public String getHeadingOfTermsOfUse()
	{
		WebElement termsOfUseHeading = getDriver().findElement(byTermsOfUseHeading);
		return termsOfUseHeading.getText();
	}

	/**
	 * Method to get the color of the Active Tab
	 * @author HFARAZ
	 * @return - Color value of the Active tab
	 * */
	public String getBottomBorderColor_Of_TermsOfUseTab()
	{
		String color = getDriver().findElement(byTermsOfUseTab).getCssValue("border-bottom-color");
		return Color.fromString(color).asHex();
	}
	
/************************************** PRIVACY POLICY **************************************************************************/	
	
	/**
	 * Method to validate if Privacy Policy link is present on Footer
	 * @author HFARAZ
	 * @return - Boolean value - "true if Privacy Policy link is present else false"
	 * */
	public Boolean isPrivacyPolicyPresent()
	{
		Boolean isPrivacyPolicyPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byPrivacyPolicy).isDisplayed())
				isPrivacyPolicyPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isPrivacyPolicyPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isPrivacyPolicyPresent = false;
		}
		
		return isPrivacyPolicyPresent;
	}
	
	/**
	 * Method to click Privacy Policy
	 * @author HFARAZ
	 * */
	public void clickPrivacyPolicy()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byPrivacyPolicy).jsClick();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();
	}


	/**
	 * Method to get the text of Privacy Policy present on Footer
	 * @author HFARAZ
	 * @return - String value - "returns the text of Privacy Policy"
	 * */
	public String getPrivacyPolicyText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byPrivacyPolicy).getText();
	}

	/**
	 * Method to get the value of Privacy Policy tab
	 * @author HFARAZ
	 * @return - String value - "name of the Privacy Policy Tab"
	 * */
	public String getNameOfPrivacyPolicyTab()
	{
		WebElement privacyPolicyTab = getDriver().findElement(byPrivacyPolicyTab);
		return privacyPolicyTab.getText();
	}

	/**
	 * Method to get the heading of Privacy page
	 * @author HFARAZ
	 * @return - String value - "heading of Privacy Policy page"
	 * */
	public String getHeadingOfPrivacyPolicy()
	{
		WebElement privacyPolicyHeading = getDriver().findElement(byPrivacyPolicyHeading);
		return privacyPolicyHeading.getText();
	}

	/**
	 * Method to get the color of the Active Tab
	 * @author HFARAZ
	 * @return - Color value of the Active tab
	 * */
	public String getBottomBorderColor_Of_PrivacyPolicyTab()
	{
		String color = getDriver().findElement(byPrivacyPolicyTab).getCssValue("border-bottom-color");
		return Color.fromString(color).asHex();
	}

/******************************************** Cookie Policy ***********************************************************/	
	
	/**
	 * Method to validate if Cookie Policy link is present on Footer
	 * @author HFARAZ
	 * @return - Boolean value - "true if Cookie Policy link is present else false"
	 * */
	public Boolean isCookiePolicyPresent()
	{
		Boolean isCookiePolicyPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byCookiePolicy).isDisplayed())
				isCookiePolicyPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isCookiePolicyPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isCookiePolicyPresent = false;
		}
		
		return isCookiePolicyPresent;
		
	}

	/**
	 * Method to get the text of Cookie Policy present on Footer
	 * @author HFARAZ
	 * @return - String value - "returns the text of Cookie Policy"
	 * */
	public String getCookiePolicyText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCookiePolicy).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to click on Cookie Policy
	 * */
	public void clickCookiePolicy()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byCookiePolicy).jsClick();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();	
	}

	

	/**
	 * Method to get the value of Cookie Policy tab
	 * @author HFARAZ
	 * @return - String value - "name of the Cookie Policy Tab"
	 * */
	public String getNameOfCookiePolicyTab()
	{
		WebElement cookiePolicyTab = getDriver().findElement(byCookiePolicyTab);
		return cookiePolicyTab.getText();
	}

	/**
	 * Method to get the heading of Cookie Policy page
	 * @author HFARAZ
	 * @return - String value - "heading of Cookie Policy page"
	 * */
	public String getHeadingOfCookiePolicy()
	{
		WebElement cookiePolicyHeading = getDriver().findElement(byCookiePolicyHeading);
		return cookiePolicyHeading.getText();
	}

	/**
	 * Method to get the color of the Active Tab
	 * @author HFARAZ
	 * @return - Color value of the Active tab
	 * */
	public String getBottomBorderColor_Of_CookiePolicyTab()
	{
		String color = getDriver().findElement(byCookiePolicyTab).getCssValue("border-bottom-color");
		return Color.fromString(color).asHex();
	}

/******************************************** TAG DISCLOSURE ***************************************************/	
	
	/**
	 * Method to validate if TAG Disclosure link is present on Footer
	 * @author HFARAZ
	 * @return - Boolean value - "true if TAG Disclosure link is present else false"
	 * */
	public Boolean isTAGDisclosurePresent()
	{
		Boolean isTAGDisclosurePresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byTAGDisclosure).isDisplayed())
				isTAGDisclosurePresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isTAGDisclosurePresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isTAGDisclosurePresent = false;
		}
		
		return isTAGDisclosurePresent;
		
	}

	/**
	 * Method to get the text of TAG Disclosure present on Footer
	 * @author HFARAZ
	 * @return - String value - "returns the text of TAG Disclosure"
	 * */
	public String getTAGDisclosureText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTAGDisclosure).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to click on TAG Disclosure
	 * */
	public void clickTAGDisclosure()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byTAGDisclosure).jsClick();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();	
	}

	

	/**
	 * Method to get the value of TAG Disclosure tab
	 * @author HFARAZ
	 * @return - String value - "name of the TAG Disclosure Tab"
	 * */
	public String getNameOfTAGDisclosureTab()
	{
		WebElement tagDisclosureTab = getDriver().findElement(byTAGDisclosureTab);
		return tagDisclosureTab.getText();
	}

	/**
	 * Method to get the heading of TAG Disclosure page
	 * @author HFARAZ
	 * @return - String value - "heading of TAG Disclosure page"
	 * */
	public String getHeadingOfTAGDisclosure()
	{
		WebElement tagDisclosureHeading = getDriver().findElement(byTAGDisclosureHeading);
		return tagDisclosureHeading.getText();
	}

	/**
	 * Method to get the color of the Active Tab
	 * @author HFARAZ
	 * @return - Color value of the Active tab
	 * */
	public String getBottomBorderColor_Of_TAGDisclosureTab()
	{
		String color = getDriver().findElement(byTAGDisclosureTab).getCssValue("border-bottom-color");
		return Color.fromString(color).asHex();
	}

/************************************ COPYRIGHT INFORMATION ****************************************************/

	/**
	 * @author HFARAZ
	 * Method to verify whether copyright information is present
	 * @return true if copyright information found else false
	 * */
	public Boolean isCopyRightInformationPresent()
	{
		Boolean isCopyRightInformationPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byCopyRight).isDisplayed())
				isCopyRightInformationPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isCopyRightInformationPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isCopyRightInformationPresent = false;
		}
		
		return isCopyRightInformationPresent;
		
	}
	
	
	
	/**
	 * Method to get the text for copyRight information
	 * @author HFARAZ
	 * @return - String: text for copyright information
	 * */
	public String getCopyRightInformation()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCopyRight).getText();
	}

	/**
	 * Method to get the year in copyright information
	 * @author HFARAZ
	 * @return - String: value of the year in copyright information
	 * */
	public String getYearInCopyRightInformation()
	{
		return getCopyRightInformation().substring(2,6).trim();
	}

	/**
	 * Method to get the current year
	 * @author HFARAZ
	 * @return String: value of the current year
	 * */
	public String getCurrentYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR)+"";
	}

	/**
	 * Method to change the site language to Spanish
	 * @author HFARAZ
	 * */
	public Boolean legalFooterStatusWhenLangChanged()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(bySettingsButton).click();
		getDriver().findElement(byLanguageSelector).syncVisible(15);
		getDriver().findElement(byLanguageSelector).click();
		getDriver().findElement(bySpanish).click();
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byTermsOfUseSpanish).isDisplayed();
	}
	
	/**
	 * Method to verify advertising section have updated providers 
	 * @author Sowmiya
	 * Boolean return true if providers are available
	 * */
	public Boolean verifyAdvertisingSectionHaveUpdatedProviders()
	{
		WebPageLoaded.isDomInteractive();
		//Advertising section should have live ramp, cuebiq, Intersection
		return getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='LiveRamp']")).syncVisible(15)
		&& getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Cuebiq']")).syncVisible(15)
		&& getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Intersection']")).syncVisible(15);
	
	}
	
	/**
	 * Method to verify Liveramp providers URL and Page 
	 * @author Sowmiya
	 * Boolean return true if providers URL
	 * */
	public String verifyLiveRampLinkAndPage()
	{
		WebPageLoaded.isDomInteractive();
		//Advertising section should have live ramp, cuebiq, Intersection
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='LiveRamp']/../td/a[text()='https://liveramp.com/privacy/']")).syncVisible(15);
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='LiveRamp']/../td/a[text()='https://liveramp.com/privacy/']")).jsClick();
		//return the URL
		Sleeper.sleep(2);
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify Cuebiq providers URL and Page 
	 * @author Sowmiya
	 * Boolean return true if providers URL
	 * */
	public String verifyCuebiqLinkAndPage()
	{
		WebPageLoaded.isDomInteractive();
		//Advertising section should have live ramp, cuebiq, Intersection
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Cuebiq']/../td/a[text()='https://www.cuebiq.com/privacypolicy/']")).syncVisible(15);
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Cuebiq']/../td/a[text()='https://www.cuebiq.com/privacypolicy/']")).jsClick();
		//return the URL
		Sleeper.sleep(2);
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to verify Intersection providers URL and Page 
	 * @author Sowmiya
	 * Boolean return true if providers URL
	 * */
	public String verifyIntersectionLinkAndPage()
	{
		WebPageLoaded.isDomInteractive();
		//Advertising section should have live ramp, cuebiq, Intersection
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Intersection']/../td/a[text()='https://www.intersection.com/privacy-policy/']")).syncVisible(15);
		getDriver().findElement(By.xpath("//table/tbody[@class='table-section']/tr/th[contains(text(),'ADVERTISING')]/../../tr/td[text()='Intersection']/../td/a[text()='https://www.intersection.com/privacy-policy/']")).jsClick();
		//return the URL
		Sleeper.sleep(2);
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author HFARAZ
	 * Method to find if CCPA link is present
	 * @return true if CCPA link found, else returns false
	 * */
	public Boolean isCCPAPresent()
	{
		Boolean isCCPAPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byCCPA).isDisplayed())
				isCCPAPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isCCPAPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isCCPAPresent = false;
		}
		
		return isCCPAPresent;	
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the CCPA text
	 * @return String value of the text present at CCPA locator
	 * */
	public String getCCPAText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCCPA).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to click the CCPA link
	 * */
	public void clickCCPA()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byCCPA).jsClick();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the CCPA name on the secondary navigation
	 * @return String value of the CCPA tab
	 * */
	public String getNameOfCCPATab()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byCCPATab).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the border bottom color of active tab
	 * @return String value of the border bottom color of the CCPA tab
	 * */
	public String getBorderColorOfCCPATab()
	{
		WebPageLoaded.isDomComplete();
		String color = getDriver().findElement(byCCPATab).getCssValue("border-bottom-color");
		return Color.fromString(color).asHex();
	}
	
	/**
	 * @author HFARAZ
	 * Method to find if Do Not Sell My Data link is present
	 * @return true if Do Not Sell My Data link found, else returns false
	 * */
	public Boolean isDoNotSellMyDataPresent()
	{
		Boolean isDoNotSellMyDataPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byDoNotSellMyData).isDisplayed())
				isDoNotSellMyDataPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isDoNotSellMyDataPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isDoNotSellMyDataPresent = false;
		}
		
		return isDoNotSellMyDataPresent;	
	}
	
	/**
	 * @author HFARAZ
	 * Method to click Do Not Sell My Data
	 * 
	 * */
	
	public void clickDoNotSellMyData()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(byDoNotSellMyData).jsClick();	
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to find if Confirmed text appears
	 * @return true if Confirmed text found, else returns false
	 * */
	public Boolean isConfirmedPresent()
	{
		Boolean isConfirmedPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byConfirmed).isDisplayed())
				isConfirmedPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isConfirmedPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isConfirmedPresent = false;
		}
		
		return isConfirmedPresent;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to find if "Not Selling Your Data" link is present
	 * @return true if "Not Selling Your Data" link found, else returns false
	 * */
	public Boolean isNotSellingYourDataPresent()
	{
		Boolean isNotSellingYourDataPresent = true;
		try
		{
			WebPageLoaded.isDomComplete();
			scrollDown();
			if(getDriver().findElement(byNotSellingYourData).isDisplayed())
				isNotSellingYourDataPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isNotSellingYourDataPresent = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			isNotSellingYourDataPresent = false;
		}
		
		return isNotSellingYourDataPresent;		
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the Confirmed text
	 * @return String value of the text present at Confirmed locator
	 * */
	public String getConfirmedText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byConfirmed).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the CCPA text
	 * @return String value of the text present at CCPA locator
	 * */
	public String getNotSellingYourDataText()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byNotSellingYourData).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the privacy policy banner is present
	 * @return true if alert banner present else returns false
	 * */
	public Boolean isAlertBannerPresent()
	{
		Boolean isBannerPresent = false;
		WebPageLoaded.isDomComplete();
		try
		{
			if (getDriver().findElement(byPrivacyPolicyBanner).isDisplayed())
				isBannerPresent = true;
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println(nsee.getMessage());
			isBannerPresent = false;
		}
		return isBannerPresent;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the "I Understand" button is present on privacy policy banner
	 * @return true if "I Understand" button present else returns false
	 * */
	public Boolean isIUnderstandButtonPresentOnPrivacyPolicyBanner()
	{
		WebPageLoaded.isDomComplete();
		if (getDriver().findElement(byIUnderstandButton).isDisplayed())
			return true;
		else
			return false;
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to give the width of privacy policy banner in pixels
	 * */
	public String getPrivacyPolicyBannerWidth()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byPrivacyPolicyBanner).getCssValue("width");
	}
	
	/**
	 * @author HFARAZ
	 * Method to click "I Understand Button"
	 * */
	public void clickIUnderstand()
	{
		WebPageLoaded.isDomComplete();
		if(getDriver().findElement(byIUnderstandButton).isDisplayed())
			getDriver().findElement(byIUnderstandButton).click();
	}
	
	/**
	 * @author HFARAZ
	 * Method to click "Privacy Policy" link on the banner
	 * */
	public void clickPrivacyPolicyLinkOnBanner()
	{
		WebPageLoaded.isDomComplete();
		if(getDriver().findElement(byPrivacyPolicyLinkOnBanner).isDisplayed())
			getDriver().findElement(byPrivacyPolicyLinkOnBanner).click();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to click "Cookie Policy" link on the banner
	 * */
	public void clickCookiePolicyLinkOnBanner()
	{
		WebPageLoaded.isDomComplete();
		if(getDriver().findElement(byCookiePolicyLinkOnBanner).isDisplayed())
			getDriver().findElement(byCookiePolicyLinkOnBanner).click();
		String window = getDriver().getWindowHandle();
		switchToPopUpWindow(window);
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of the button on the privacy policy banner
	 * @return String value of the text present on the button
	 * */
	public String getTextOfButtonOnPrivacyPolicyBanner()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(byIUnderstandButton).getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to return the value of the text on Privacy Policy Banner
	 * @return String value of the text on Privacy Policy Banner
	 * */
	public String getTextofPrivacyPolicyBanner()
	{
		WebPageLoaded.isDomComplete();
		StringBuilder privacyPolicyTextOnBanner = new StringBuilder();
		ArrayList<String> multipleStringsOnPrivacyPolicyBanner = new ArrayList<String>();
		
		if(getDriver().findElement(byStartTextPrivacyPolicyBanner).isDisplayed() && getDriver().findElement(byPrivacyPolicyLinkOnBanner).isDisplayed()
				&& getDriver().findElement(byMiddleTextPrivacyPolicyBanner).isDisplayed() && getDriver().findElement(byCookiePolicyLinkOnBanner).isDisplayed()
				)
		{
			multipleStringsOnPrivacyPolicyBanner.add(getDriver().findElement(byStartTextPrivacyPolicyBanner).getText());
			multipleStringsOnPrivacyPolicyBanner.add(getDriver().findElement(byPrivacyPolicyLinkOnBanner).getText());
			multipleStringsOnPrivacyPolicyBanner.add(getDriver().findElement(byMiddleTextPrivacyPolicyBanner).getText());
			multipleStringsOnPrivacyPolicyBanner.add(getDriver().findElement(byCookiePolicyLinkOnBanner).getText());
			
		}
		for (int i=0;i<multipleStringsOnPrivacyPolicyBanner.size();i++)
		{
			privacyPolicyTextOnBanner = privacyPolicyTextOnBanner.append(multipleStringsOnPrivacyPolicyBanner.get(i));
		}
		System.out.println(privacyPolicyTextOnBanner.toString());
		return privacyPolicyTextOnBanner.toString();
	}
	

}
