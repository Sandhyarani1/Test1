package com.accuweather.glacier.m.pages;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.support.Color;
	import org.openqa.selenium.support.ui.Select;
	import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
	import com.chameleon.selenium.web.elements.WebElement;
	import com.chameleon.utils.Sleeper;

	public class ContactUsMobile extends MobileBasePage
	{
		private By byContactUsLink = By.cssSelector("div.footer-content > div.footer-content-tablet > div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(7)");
		private By byContactUsTabHeading = By.xpath("//h1[contains(text(),'Contact Us')]");
		private By byGeneralSupportLink = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(1)");
		private By byIPhoneAppsLink = By.cssSelector("div.subnav.tertiary-nav > div.subnav-items > a:nth-child(2)");
		private By byHelpLink = By.linkText("AccuWeather.com Help");
		private By byClickHereLink = By.cssSelector("div.two-column-page-content > div > div > div.contact-us.full-mobile-width > p.content-module.post-content > a:nth-child(1)");
		private By bySelectQuestionType = By.name("subject");
		private By bySelectProductType = By.name("product");
		private By byComments = By.name("comments");
		private By byEmail = By.name("email");
		private By byFirstName = By.name("fname");
		private By byLastName = By.name("lname");
		private By byZipCode = By.name("zip");
		private By byCaptcha = By.cssSelector("div.rc-anchor-content > div > div > div > span > div:nth-child(1)");
		private By bySubmitButton = By.className("submit-button");
		private By byResponseHeading = By.cssSelector("div.two-column-page-content > div > div > div > p:nth-child(1)");
		private By byResponseMessage = By.cssSelector("div.two-column-page-content > div > div > div > p:nth-child(2)");
		private By byCompanyDropDown = By.xpath("(//div[@class='accordion-item-header accordion-item-simple-header'])[1]");
		private By byContactUSLinkMObile = By.xpath("//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Contact Us')]");
		private By byContactUsTab = By.xpath("//div[@class='subnav secondary-nav has-tertiary']//a[@class='subnav-item active']");
		
		/**
		 * @author Hasan Faraz
		 * Method to click Contact Us link present on the Universal Footer
		 * */
		public void clickContactUs()
		{
			WebPageLoaded.isDomInteractive();
			WebElement contactUs = getDriver().findElement(byContactUsLink);
			contactUs.syncVisible(30);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			contactUs.jsClick();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to switch to Contact Us page in the different tab
		 * */
		public void switchToContactUs()
		{
			clickContactUs();
			String window = getDriver().getWindowHandle();
			switchToPopUpWindow(window);
			Sleeper.sleep(20);
			WebPageLoaded.isDomInteractive();
			getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to fetch the text of Contact Us link present on the Universal Footer
		 * @return - String: returns the value of Contact Us text present on the bottom of the page
		 * */
		public String getContactUsText()
		{
			WebPageLoaded.isDomInteractive();
			WebElement contactUs = getDriver().findElement(byContactUsLink);
			contactUs.syncVisible(30);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return contactUs.getText();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to get the Contact Us page URL
		 * */
		public String getContactUsURL()
		{
			//switchToContactUs();
			Sleeper.sleep(1);
			return getDriver().getCurrentUrl();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to get the Contact Us page Title
		 * @return - String: returns the title of Contact Us page
		 * */
		public String getContactUsTitle()
		{
			//switchToContactUs();
			return getDriver().getTitle();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to get the Contact Us page Title
		 * @return - String value : heading of Contact Us tab
		 * */
		public String getHeadingOfContactUsTab()
		{
			//switchToContactUs();
			WebElement contactUsTab = getDriver().findElement(byContactUsTabHeading);
			return contactUsTab.getText();
		}
		
		/**
		 * Method to get the color of the Active Tab
		 * @author Hasan Faraz
		 * @return - Color value of the Active tab
		 * */
		public String getTopBorderColor_Of_ContactUsTab()
		{
		/*
		 * switchToContactUs(); String color =
		 * getDriver().findElement(byContactUsTabHeading).getCssValue("border-top-color"
		 * ); System.out.println(color); String hexValue =
		 * Color.fromString(color).asHex(); System.out.println(hexValue); return
		 * hexValue;
		 */
			
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byContactUsTab).scrollIntoView();
			WebElement ele = getDriver().findElement(byContactUsTab);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div.template-root > div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active\")).borderTopColor;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		
		/**
		 * @author Hasan Faraz
		 * @return - String - text of General Support tab
		 * Method to validate presence of General Support Tab
		 * */
		public String getTextOfGeneralSupportTab()
		{
			WebElement generalSupportTab = getDriver().findElement(byGeneralSupportLink);
			return generalSupportTab.getText();
		}
		
		/**
		 * @author Hasan Faraz
		 * @return - String - text of General Support tab
		 * Method to validate presence of General Support Tab
		 * */
		public String getTextOfIPhoneAppsTab()
		{
			//switchToContactUs();
			WebElement generalSupportTab = getDriver().findElement(byIPhoneAppsLink);
			return generalSupportTab.getText();
		}
		
		
		/**
		 * Method to get the bottom border color of the general Support link
		 * @author Hasan Faraz
		 * @return - Color value of the border color of general support link
		 * */
		public String getBottom_BorderColor_Of_GeneralSupport_Link()
		{
		/*
		 * String color = getDriver().findElement(byGeneralSupportLink).getCssValue(
		 * "border-bottom-color"); return Color.fromString(color).asHex();
		 */
			
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byGeneralSupportLink).scrollIntoView();
			WebElement ele = getDriver().findElement(byGeneralSupportLink);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active\")).borderBottomColor;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		
		/**
		 * Method to switch to general Support tab
		 * @author Hasan Faraz
		 * */
		public void click_GeneralSupportTab()
		{
			//switchToContactUs();
			WebElement generalSupportTab = getDriver().findElement(byGeneralSupportLink);
			generalSupportTab.click();
		}
		
		/**
		 * Method to switch to general Support tab
		 * @author Hasan Faraz
		 * */
		public void click_IPhoneAppsTab()
		{
			//switchToContactUs();
			WebElement iPhoneApsTab = getDriver().findElement(byIPhoneAppsLink);
			iPhoneApsTab.click();
		}
		
		/**
		 * Method to get the bottom border color of the IPhone Apps link
		 * @author Hasan Faraz
		 * @return - Color value of the border color of IPhone Apps link
		 * */
		public String getBottom_BorderColor_Of_IPhoneApps_Link()
		{
		/*
		 * switchToContactUs(); String color =
		 * getDriver().findElement(byIPhoneAppsLink).getCssValue("border-bottom-color");
		 * return Color.fromString(color).asHex();
		 */
			
			WebPageLoaded.isDomInteractive(5);
			getDriver().findElement(byIPhoneAppsLink).scrollIntoView();
			WebElement ele = getDriver().findElement(byIPhoneAppsLink);
			String result = (String) DriverManager.getWebDriver().executeJavaScript(
					"return getComputedStyle(document.querySelector(\"body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a:nth-child(2)\")).borderBottomColor;",
					ele);
			String arrowcolourdisplayed = Color.fromString(result).asHex();
			return arrowcolourdisplayed;
		}
		
		/**
		 * Method to click the Help link present in general support tab
		 * @author Hasan Faraz
		 * */
		public void clickHelpLinkFromGeneralSupport()
		{
			//click_GeneralSupportTab();
			WebElement helpLink = getDriver().findElement(byHelpLink);
			helpLink.jsClick();
		}
		
		/**
		 * Method to click the Click here link present in general support tab
		 * @author Hasan Faraz
		 * */
		public void clickClickHereLinkFromGeneralSupport()
		{
			//click_GeneralSupportTab();
			WebElement clickHereLink = getDriver().findElement(byClickHereLink);
			clickHereLink.jsClick();
			
		}
		
		/**
		 * Method to get the URL when clicked on Click here link from General Support
		 * @author Hasan Faraz
		 * */
		public String getClickHereURLWhenClickedFromGeneralSupport()
		{
			clickClickHereLinkFromGeneralSupport();
			WebPageLoaded.isDomInteractive();
			Sleeper.sleep(20);
			return getDriver().getCurrentUrl();
		}
		
		/**
		 * Method to get the URL when clicked on Help link from General Support
		 * @author Hasan Faraz
		 * */
		public String getHelpURLWhenClickedFromGeneralSupport()
		{
			clickHelpLinkFromGeneralSupport();
			WebPageLoaded.isDomInteractive();
			Sleeper.sleep(3);
			return getDriver().getCurrentUrl();
		}
		
		/**
		 * Method to click the Help link present in general support tab
		 * @author Hasan Faraz
		 * */
		public void clickHelpLinkFromIPhoneApps()
		{
			click_IPhoneAppsTab();
			WebPageLoaded.isDomInteractive();
			WebElement helpLink = getDriver().findElement(byHelpLink);
			helpLink.jsClick();
		}
		
		/**
		 * Method to click the Click here link present in general support tab
		 * @author Hasan Faraz
		 * */
		public void clickClickHereLinkFromIPhoneApps()
		{
			click_IPhoneAppsTab();
			WebElement clickHereLink = getDriver().findElement(byClickHereLink);
			clickHereLink.jsClick();
		}
		
		/**
		 * Method to get the URL when clicked on Click here link from IPhone Apps tab
		 * @author Hasan Faraz
		 * */
		public String getClickHereURLWhenClickedFromIPhoneApps()
		{
			clickClickHereLinkFromIPhoneApps();
			WebPageLoaded.isDomInteractive();
			return getDriver().getCurrentUrl();
		}
		
		/**
		 * Method to get the URL when clicked on Help link from IPhone Apps tab
		 * @author Hasan Faraz
		 * */
		public String getHelpURLWhenClickedFromIPhoneApps()
		{
			clickHelpLinkFromIPhoneApps();
			Sleeper.sleep(10);
			return getDriver().getCurrentUrl();
		}
		
		/**
		 * Method to select the value from "Select Question Type" dropdown
		 * @author Hasan Faraz
		 * */
		public void selectQuestionType(String questionType)
		{
			Select selectQuestionType = new Select(getDriver().findElement(bySelectQuestionType));
			selectQuestionType.selectByVisibleText(questionType);
		}
		
		/**
		 * Method to select the value from "Select AccuWeather Product" dropdown
		 * @author Hasan Faraz
		 * */
		public void selectProductType(String productType)
		{
			Select selectProductType = new Select(getDriver().findElement(bySelectProductType));
			selectProductType.selectByVisibleText(productType);
		}
		
		/**
		 * Method to write comments
		 * @author Hasan Faraz
		 * */
		public void writeComments(String comments)
		{
			getDriver().findElement(byComments).sendKeys(comments);
		}
		
		/**
		 * Method to write email
		 * @author Hasan Faraz
		 * */
		public void enterYourInformation(String emailID, String firstName, String lastName, String zipCode)
		{
			getDriver().findElement(byEmail).sendKeys(emailID);
			getDriver().findElement(byFirstName).sendKeys(firstName);
			getDriver().findElement(byLastName).sendKeys(lastName);
			getDriver().findElement(byZipCode).sendKeys(zipCode);
		}
		
		/**
		 * Method to click captcha
		 * @author Hasan Faraz
		 * */
		public void clickCaptcha()
		{
			WebElement captcha = getDriver().findElement(byCaptcha);
			captcha.jsClick();
		}
		
		/**
		 * Method to click Submit Button
		 * @author Hasan Faraz
		 * */
		public void clickSubmitButton()
		{
			getDriver().findElement(bySubmitButton).jsClick();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to get the response heading
		 * */
		public String getResponseHeading()
		{
			return getDriver().findElement(byResponseHeading).getText();
		}
		
		/**
		 * @author Hasan Faraz
		 * Method to get the response message
		 * */
		public String getResponseMessage()
		{
			return getDriver().findElement(byResponseMessage).getText();
		}
		
		/**
		 * @author Mohammed Siddiq
		 * Method to click on Company DropDown
		 * */
		public void clickOnCompanyDropDown()
		{
			getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
			Sleeper.sleep(2);
			//getDriver().executeJavaScript("window.scrollTo(0, -100)");
			Sleeper.sleep(2);
			getDriver().findElement(byCompanyDropDown).jsClick();
		}
		
		/**
		 * @author Mohammed Siddiq
		 * Method to click on Contact US link
		 * */
		public void clickOnContactUSlink()
		{
			//getDriver().executeJavaScript("window.scrollTo(0, -100)");
			Sleeper.sleep(2);
			getDriver().findElement(byContactUSLinkMObile).click();
		}
	}


