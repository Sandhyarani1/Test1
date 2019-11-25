package com.accuweather.glacier.www.pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class UniversalFooterPage extends BasePage 
{
	private By byfooterContent = By.xpath("//div[@class='footer-content']");
	private By bycompany = By.xpath("//div[contains(text(),'Company')]");
	private By byproductandservice = By.xpath("//div[contains(text(),'Products & Services')]");
	private By byappsAndDownload = By.xpath("//div[contains(text(),'Apps & Downloads')]");
	private By bysubscriptionServices = By.xpath("//div[contains(text(),'Subscription Services')]");
	private By bySuperiorAccuracyinAction = By.cssSelector("div:nth-child(1) >div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAboutAccuWeather = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	private By byMediaKit = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By byCareers = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(4)");
	private By byPress = By.xpath(
			"//div[@class='footer-content-category']//a[@class='footer-category-section-link'][contains(text(),'Press')]");
	private By byContactUs = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(6)");
	private By byEnterpriseSolutions = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byD3DataDrivenDecisions = By.cssSelector("div.footer-content-tablet > div:nth-child(2) > div.footer-category-section > a:nth-child(2)");
	
	private By byAccuWeatherNetwork = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By byStoryTeller = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(4)");
	private By byToolsforBroadcast = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(5)");
	private By byRadioandNewspaper = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(6)");
	private By byAccuWeatherAPIs = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(7)");
	private By byPodcast = By.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section > a:nth-child(8)");
	private By byiPhoneApp = By.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAndroidApp = By.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	//private By byWindowsApp = By.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By bySeeallAppsandDownloads = By.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	
	private By byAccuWeatherPremium = By.cssSelector("div:nth-child(4) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAccuWeatherProfessional = By.cssSelector("div:nth-child(4) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	private By bysocialicondownload = By.cssSelector("div:nth-child(4) > div.footer-social.footer-social-tablet > a:nth-child(1)");
	private By bysocialiconfacebook = By.cssSelector("div:nth-child(4) > div.footer-social.footer-social-tablet > a:nth-child(2)");
	private By bysocialicontwitter = By.cssSelector("div:nth-child(4) > div.footer-social.footer-social-tablet > a:nth-child(3)");
	private By bysocialicontv = By.cssSelector("div:nth-child(4) > div.footer-social.footer-social-tablet > a:nth-child(4)");
	private By bySettingicon = By.cssSelector("div.main-menu > div.header-right-container > div.settings-button > svg");
	private By byenglishLanguage = By.xpath("//div[3]/div/div/div[2]/div/div");
	private By byFrench = By.xpath("//div[4]");
	private By byfooterBreadCrumbs = By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper");
	private By byAboutFromPressMenu = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'About')]");
	private By byPressFromPressMenu = By.xpath("//div[@class='subnav-items']/a/h1[contains(text(),'Press')]");
	private By byCareersFromPressMenu = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'Careers')]");
	private By byFAQFromPressMenu = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'FAQ')]");
	private By byContactUsFromPressMenu = By.xpath("//div[@class='subnav-items']/a/span[contains(text(),'Contact Us')]");
	
	String[] expectedPressSecondaryNavigationMenus = {"ABOUT", "PRESS", "CAREERS", "FAQ", "CONTACT US"};
	/**
	 * @ author Sandhya Rani
	 * Method to verify footer is displayed for English Language
	 * @return - Boolean value - "true  If Footer content is Displayed "
	 **/
	public boolean footerisDisplayed() {

        Sleeper.sleep(4);
		return getDriver().findElement(byfooterContent).isDisplayed();
	}

	/**
	 * @author Sandhya Rani 
	 * Method to scroll down the page till the bottom of page by getting x and y co-ordinates
	 * 
	 **/
	public void scrolldownpage() {
		 Sleeper.sleep(4);
		getDriver().executeJavaScript("window.scrollBy(0,2103)");
	}

	/**
	 * @author Sandhya Rani 
	 * Method to switch the control to new tab and extracting landing page URL
	 * @return - String value - "URL of the Landing page"
	 **/
	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		Sleeper.sleep(2);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}

	/**
	 * Method to verify footer displayed with following Headers
	 * "Company","Products & Services" "Apps & Download" and "Subscription Services"
	 * @author Sandhya Rani 
	 * @return- Boolean value - "true  If footer Displayed with the following headers"
	 **/
	public boolean isbaseFooterContainsLink(String link) {
		if (link.equalsIgnoreCase("Company")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bycompany).isDisplayed();
		}

		if (link.equalsIgnoreCase("Products & Services")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byproductandservice).isDisplayed();
		}

		if (link.equalsIgnoreCase("Apps & Download")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byappsAndDownload).isDisplayed();
		}

		if (link.equalsIgnoreCase("Subscription Services")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bysubscriptionServices).isDisplayed();
		}

		return false;
	}

	/**
	 * Method to verify footer links present under the Header "Company"
	 * @author Sandhya Rani
	 * @return- Boolean value - "true  If company header Displayed with the following links"
	 **/
	
public boolean validatelinksforCompanyHeader() {
		
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		 
		WebElement companyHeader = getDriver().findElement(bycompany);
		companyHeader.syncVisible(15);
		
		WebElement superiorAccuracyinAction = getDriver().findElement(bySuperiorAccuracyinAction);
		superiorAccuracyinAction.syncVisible(15);
		
		WebElement aboutAccuWeather = getDriver().findElement(byAboutAccuWeather);
		aboutAccuWeather.syncVisible(60);
		

		WebElement mediaKit = getDriver().findElement(byMediaKit);
		mediaKit.syncVisible(60);
		
		
		WebElement careers = getDriver().findElement(byCareers);
		careers.syncVisible(60);
		
		WebElement press = getDriver().findElement(byPress);
		press.syncVisible(60);
		
		WebElement contactUs = getDriver().findElement(byContactUs);
		contactUs.syncVisible(60);
		
		
		return companyHeader.isDisplayed() && superiorAccuracyinAction.isDisplayed() && aboutAccuWeather.isDisplayed() 
				&& mediaKit.isDisplayed() && careers.isDisplayed()  && contactUs.isDisplayed();
   }
	
	
	

	/**
	 * Method to verify footer links present under the Header "Products & Services"
	 * @author Sandhya Rani
	 * @return- Boolean value - "true  If  product and Services header Displayed with the following links"
	 **/


public boolean validatelinksforProductsandServicesHeader() {
	
	WebPageLoaded.isDomInteractive();
	Sleeper.sleep(5);
	
	WebElement productandservice = getDriver().findElement(byproductandservice);
	productandservice.syncVisible(15);
	
	WebElement enterpriseSolutions = getDriver().findElement(byEnterpriseSolutions);
	enterpriseSolutions.syncVisible(15);
	
	WebElement d3dataDrivenDecisions = getDriver().findElement(byD3DataDrivenDecisions);
	d3dataDrivenDecisions.syncVisible(60);
	

	WebElement accuWeatherNetwork = getDriver().findElement(byAccuWeatherNetwork);
	accuWeatherNetwork.syncVisible(60);
	
	
	WebElement storyTeller = getDriver().findElement(byStoryTeller);
	storyTeller.syncVisible(60);
	
	WebElement toolsforBroadcast = getDriver().findElement(byToolsforBroadcast);
	toolsforBroadcast.syncVisible(60);
	
	WebElement radioandNewspaper = getDriver().findElement(byRadioandNewspaper);
	radioandNewspaper.syncVisible(60);
	
	WebElement accuWeatherAPIs = getDriver().findElement(byAccuWeatherAPIs);
	accuWeatherAPIs.syncVisible(60);
	
	WebElement podcast = getDriver().findElement(byPodcast);
	podcast.syncVisible(60);
	
	
	return productandservice.isDisplayed() && enterpriseSolutions.isDisplayed() && d3dataDrivenDecisions.isDisplayed()
			&& accuWeatherNetwork.isDisplayed() && storyTeller.isDisplayed()  &&toolsforBroadcast.isDisplayed() 
			&& radioandNewspaper.isDisplayed() && accuWeatherAPIs.isDisplayed()  && podcast.isDisplayed();
}
	
	/**
	 * Method to verify footer links present under the "Apps & Download"
	 * @author Sandhya Rani 
	 * @return- Boolean value - "true  If  Apps and Download header Displayed with the following links"
	 */


public boolean validatelinksDisplayedunderAppsandDownloads() {
	
	WebPageLoaded.isDomInteractive();
	Sleeper.sleep(3);
	
	WebElement iPhoneApp = getDriver().findElement(byiPhoneApp);
	iPhoneApp.syncVisible(15);
	
	WebElement androidApp = getDriver().findElement(byAndroidApp);
	androidApp.syncVisible(60);
		
	
	WebElement seeallAppsandDownloads = getDriver().findElement(bySeeallAppsandDownloads);
	seeallAppsandDownloads.syncVisible(60);
	
	
	return iPhoneApp.isDisplayed() && androidApp.isDisplayed() && seeallAppsandDownloads.isDisplayed(); 
			
}

	
	/**
	 * Method to verify footer links present under Subscription Services
	 * @author Sandhya Rani 
	 * @return- Boolean value - "true  If  Subscription Services header Displayed with the following links"
	 **/
	public boolean subscriptionServicesContainsLink(String link) {
		if (link.equalsIgnoreCase("AccuWeather Premium")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAccuWeatherPremium).isDisplayed();
		}

		if (link.equalsIgnoreCase("AccuWeather Professional")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAccuWeatherProfessional).isDisplayed();
		}

		return false;
	}

	/**
	 * Method to verify all footer links present for Social media Links
	 * @author Sandhya Rani
	 * @return- Boolean value - "true  If  Subscription Services header Displayed with the following links"
	 **/
	
	public boolean validateSocailMedialinksDisplayed() {
		
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		
		WebElement socialicondownload = getDriver().findElement(bysocialicondownload);
		socialicondownload.syncVisible(15);
		
		WebElement socialiconfacebook = getDriver().findElement(bysocialiconfacebook);
		socialiconfacebook.syncVisible(60);
		

		WebElement socialicontwitter = getDriver().findElement(bysocialicontwitter);
		socialicontwitter.syncVisible(60);
		
		
		WebElement socialicontv = getDriver().findElement(bysocialicontv);
		socialicontv.syncVisible(60);
		
		
		return socialicondownload.isDisplayed() && socialiconfacebook.isDisplayed() && socialicontwitter.isDisplayed() 
				&& socialicontv.isDisplayed();
   }
	
	
	/**
	 *  Method to click on the links available from the footers
	 * @author Sandhya Rani
	 * @return- Boolean value - "true if clicked on links from the footer"
	 **/
	public void isclickedonfooterlink(String link) {
		if (link.equalsIgnoreCase("Superior Accuracy in Action")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bySuperiorAccuracyinAction).jsClick();
			Sleeper.sleep(2);
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("About AccuWeather")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byAboutAccuWeather).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Media kit")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byMediaKit).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("carrers")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byCareers).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Press")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byPress).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Contact Us")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byContactUs).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Enterprise Solutions")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byEnterpriseSolutions).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("D3 Data Driven Decisions")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byD3DataDrivenDecisions).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("AccuWeather Network")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byAccuWeatherNetwork).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Story Teller")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byStoryTeller).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Tools for Broadcast")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byToolsforBroadcast).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Radio and Newspaper")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byRadioandNewspaper).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("AccuWeather APIs")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byAccuWeatherAPIs).jsClick();
			WebPageLoaded.isDomInteractive();
		}


		if (link.equalsIgnoreCase("Podcast")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byPodcast).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("iPhone App")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byiPhoneApp).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Android App")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byAndroidApp).jsClick();
			WebPageLoaded.isDomInteractive();
		}

//		if (link.equalsIgnoreCase("Windows App")) {
//			WebPageLoaded.isDomInteractive();
//			getDriver().findElement(byWindowsApp).jsClick();
//			WebPageLoaded.isDomInteractive(6000);
//		}

		if (link.equalsIgnoreCase("See all Apps & Downloads")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(bySeeallAppsandDownloads).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("AccuWeather Premium")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byAccuWeatherPremium).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("AccuWeather Professional")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byAccuWeatherProfessional).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Social icon download")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(bysocialicondownload).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Social icon facebook")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(bysocialiconfacebook).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Social icon twitter")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(bysocialicontwitter).jsClick();
			WebPageLoaded.isDomInteractive();
		}

		if (link.equalsIgnoreCase("Social icon tv")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(bysocialicontv).jsClick();
			WebPageLoaded.isDomInteractive();
		}

	}

	/**
	 * Method to change the language other than English from Settings icon
	 * @author Sandhya Rani
	 * 
	 **/
	public void changeLanguagefromSettingsicon() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bySettingicon).syncVisible();
		getDriver().findElement(bySettingicon).click();
		 Sleeper.sleep(4);
		getDriver().findElement(byenglishLanguage).syncVisible();
		getDriver().findElement(byenglishLanguage).click();
		getDriver().findElement(byFrench).click();
		 Sleeper.sleep(4);
	}
	

	/**
	 * Method to verify footer bread crumbs are displayed when changed the Language other than English.
	 * @author Sandhya Rani
	 * 
	 **/
	public boolean footerbreadcrumbsDisplayed() {
		 Sleeper.sleep(4);
		return getDriver().findWebElement(byfooterBreadCrumbs).isDisplayed();
	}

	/**
	 * Method to validate press navigation secondary menus
	 * @author SOWMIYA
	 * return Boolean value - "true if list of press menus are present else false"
	 * */
	public Boolean verifyPressSecondaryNavigationMenus()
	{
		WebElement aboutFromPressMenu = getDriver().findElement(byAboutFromPressMenu);
		WebElement pressFromPressMenu = getDriver().findElement(byPressFromPressMenu);
		WebElement careersFromPressMenu = getDriver().findElement(byCareersFromPressMenu);
		WebElement fAQFromPressMenu = getDriver().findElement(byFAQFromPressMenu);
		WebElement contactUsFromPressMenu = getDriver().findElement(byContactUsFromPressMenu);
		
		return aboutFromPressMenu.syncVisible(20) && pressFromPressMenu.syncVisible(20) && careersFromPressMenu.syncVisible(20) &&
				fAQFromPressMenu.syncVisible(20) && contactUsFromPressMenu.syncVisible(20);
	}
}
