package com.accuweather.glacier.www.pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
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
	private By byCoupons = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(6)");
	private By byContactUs = By.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(7)");
	
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
	private By byWindowsApp = By.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(3)");
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
	 * Method to verify footer all the links present under the Header "Company"
	 * @author Sandhya Rani
	 * @return- Boolean value - "true  If company header Displayed with the following links"
	 **/
	public boolean companyFooterContainsLink(String link) {
		if (link.equalsIgnoreCase("Superior Accuracy in Action")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bySuperiorAccuracyinAction).isDisplayed();
		}

		if (link.equalsIgnoreCase("About AccuWeather")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAboutAccuWeather).isDisplayed();
		}

		if (link.equalsIgnoreCase("Media kit")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byMediaKit).isDisplayed();
		}

		if (link.equalsIgnoreCase("Carrers")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byCareers).isDisplayed();
		}

		if (link.equalsIgnoreCase("Press")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byPress).isDisplayed();
		}

		if (link.equalsIgnoreCase("Coupons")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byCoupons).isDisplayed();
		}

		if (link.equalsIgnoreCase("Contact Us")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byContactUs).isDisplayed();
		}

		return false;
	}

	/**
	 * Method to verify footer links present under the Header "Products & Services"
	 * @author Sandhya Rani
	 * @return- Boolean value - "true  If  product and Services header Displayed with the following links"
	 **/
	public boolean productandServicesContainsLink(String link) {
		if (link.equalsIgnoreCase("Enterprise Solutions")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byEnterpriseSolutions).isDisplayed();
		}

		if (link.equalsIgnoreCase("D3 Data Driven Decisions")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byD3DataDrivenDecisions).isDisplayed();
		}

		if (link.equalsIgnoreCase("AccuWeather Network")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAccuWeatherNetwork).isDisplayed();
		}

		if (link.equalsIgnoreCase("Story Teller")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byStoryTeller).isDisplayed();
		}

		if (link.equalsIgnoreCase("Tools for Broadcast")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byToolsforBroadcast).isDisplayed();
		}

		if (link.equalsIgnoreCase("Radio and Newspaper")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byRadioandNewspaper).isDisplayed();
		}

		if (link.equalsIgnoreCase("AccuWeather APIs")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAccuWeatherAPIs).isDisplayed();
		}


		if (link.equalsIgnoreCase("Podcast")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byPodcast).isDisplayed();
		}

		return false;
	}

	/**
	 * Method to verify footer links present under the "Apps & Download"
	 * @author Sandhya Rani 
	 * @return- Boolean value - "true  If  Apps and Download header Displayed with the following links"
	 */
	public boolean appsandDownloadContainsLink(String link) {
		if (link.equalsIgnoreCase("iPhone App")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byiPhoneApp).isDisplayed();
		}

		if (link.equalsIgnoreCase("Android App")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byAndroidApp).isDisplayed();
		}

		if (link.equalsIgnoreCase("Windows App")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byWindowsApp).isDisplayed();
		}

		if (link.equalsIgnoreCase("See all Apps & Downloads")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(byWindowsApp).isDisplayed();
		}

		return false;
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
	public boolean socailmedialinkContains(String link) {
		if (link.equalsIgnoreCase("Social icon download")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bysocialicondownload).isDisplayed();
		}

		if (link.equalsIgnoreCase("Social icon facebook")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bysocialiconfacebook).isDisplayed();
		}

		if (link.equalsIgnoreCase("Social icon twitter")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bysocialicontwitter).isDisplayed();
		}

		if (link.equalsIgnoreCase("Social icon tv")) {
			 Sleeper.sleep(4);
			return getDriver().findElement(bysocialicontv).isDisplayed();
		}

		return false;
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

		if (link.equalsIgnoreCase("Coupons")) {
			WebPageLoaded.isDomInteractive();
			 Sleeper.sleep(4);
			getDriver().findElement(byCoupons).jsClick();
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

		if (link.equalsIgnoreCase("Windows App")) {
			WebPageLoaded.isDomInteractive();
			getDriver().findElement(byWindowsApp).jsClick();
			WebPageLoaded.isDomInteractive(6000);
		}

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

}
