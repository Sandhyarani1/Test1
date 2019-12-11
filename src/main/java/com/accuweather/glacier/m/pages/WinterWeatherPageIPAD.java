package com.accuweather.glacier.m.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class WinterWeatherPageIPAD extends MobileBasePage {

	private By byNationalWeatherServiceMapTitle = By
			.cssSelector("div > div.snow-depth-map.content-module.full-mobile-width > p");
	private By byNationalForecastMapTitle = By
			.cssSelector("div.page-column-1 > div.content-module > div > div.map-header > h2");
	private By byLocalForecastMapSearchModule = By.cssSelector(
			"div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div > div > div.searchbar > div.searchbar-content > form > input");
	private By byLocalForecastMapTitle = By.cssSelector(
			"div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div.title.card");
	private By byRightRailReadMoreButton = By.cssSelector(
			"div.page-column-2 > div > div.content-module.zone-rightRail1 > div > a:nth-child(1) > div.right-rail-cta-text > div");
	private By byWinterWeatherSubmenuDescription = By
			.xpath("//p[contains(.,'Provides winter weather forecasts and the winter weather outlook for your area')]");
	private By byWinterWeatheerTab = By.cssSelector(
			"div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By byWinterHomeTab = By
			.cssSelector("div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");

	private By bycompany = By.xpath("//div[contains(text(),'Company')]");
	private By bySuperiorAccuracyinAction = By
			.cssSelector("div:nth-child(1) >div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAboutAccuWeather = By
			.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	private By byMediaKit = By
			.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By byCareers = By
			.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(4)");
	private By byContactUs = By
			.cssSelector("div:nth-child(1) > div.footer-category-section.footer-category-section > a:nth-child(6)");
	private By byPress = By.xpath(
			"//div[@class='footer-content-category']//a[@class='footer-category-section-link'][contains(text(),'Press')]");

	private By byproductandservice = By.xpath("//div[contains(text(),'Products & Services')]");
	private By byEnterpriseSolutions = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byD3DataDrivenDecisions = By
			.cssSelector("div.footer-content-tablet > div:nth-child(2) > div.footer-category-section > a:nth-child(2)");
	private By byAccuWeatherNetwork = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By byStoryTeller = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(4)");
	private By byToolsforBroadcast = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(5)");
	private By byRadioandNewspaper = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(6)");
	private By byAccuWeatherAPIs = By.cssSelector(
			"div.footer-content-tablet >div:nth-child(2) > div.footer-category-section.footer-category-section > a:nth-child(7)");
	private By byPodcast = By
			.cssSelector("div.footer-content-tablet >div:nth-child(2) > div.footer-category-section > a:nth-child(8)");

	private By byiPhoneApp = By
			.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAndroidApp = By
			.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	private By bySeeallAppsandDownloads = By
			.cssSelector("div:nth-child(3) > div.footer-category-section.footer-category-section > a:nth-child(3)");
	private By byAccuWeatherPremium = By
			.cssSelector("div:nth-child(4) > div.footer-category-section.footer-category-section > a:nth-child(1)");
	private By byAccuWeatherProfessional = By
			.cssSelector("div:nth-child(4) > div.footer-category-section.footer-category-section > a:nth-child(2)");
	private By byTopAdOnWinterWeatherPage = By.xpath("//div[@id='top']");

	/**
	 * Method to verify user is able to see national weather service map
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return title of the map"
	 */
	public String verifyUserSeeNationalWeatherServiceMap() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalWeatherServiceMap = getDriver().findElement(byNationalWeatherServiceMapTitle);
		return nationalWeatherServiceMap.getText();
	}

	/**
	 * Method to verify user is able to see national forecast map
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return title of the map"
	 */
	public String verifyNationalForecastMap() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byNationalForecastMapTitle);
		return nationalForecastMap.getText();
	}

	/**
	 * Method to verify user is able to see local forecast map search module
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return title of the map"
	 */
	public String verifyLocalForecastMapSearchModule() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byLocalForecastMapSearchModule);
		WebElement localForecastMapTitle = getDriver().findElement(byLocalForecastMapTitle);
		return localForecastMapTitle.getText();
	}

	/**
	 * Method to verify user able to see read more button in right rail module
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - Boolean value - "true if read more button is present"
	 */
	public Boolean verifyReadMoreButtonPresntInRightRailModule() {
		WebPageLoaded.isDomInteractive();
		WebElement rightRailReadMoreButton = getDriver().findElement(byRightRailReadMoreButton);
		String strrightRailReadMoreButton = rightRailReadMoreButton.getText();
		return strrightRailReadMoreButton.equalsIgnoreCase("Read More");
	}

	/**
	 * Method to verify user able to see read more button in right rail module color
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return color"
	 */
	public String verifyReadMoreButtonPresntInRightRailModuleColor() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement newsTab = getDriver().findElement(byRightRailReadMoreButton);
		getDriver().findElement(byRightRailReadMoreButton).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(5) > div > div.page-column-2 > div > div.content-module.zone-rightRail1 > div > a:nth-child(1) > div.right-rail-cta-text > div\")).color;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to verify winter weather submenu description
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return description"
	 */
	public String verifyWinterWeatherSubmenuDescription() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement winterWeatherSubmenuDescription = getDriver().findElement(byWinterWeatherSubmenuDescription);
		return winterWeatherSubmenuDescription.getText();
	}

	/**
	 * Method to verify winter weather tab is present and its color
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return color"
	 */
	public String verifyWinterWeatherTabIsPresentAndColor() {
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(byWinterWeatheerTab);
		getDriver().findElement(byWinterWeatheerTab).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active\")).borderTopColor;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to verify winter home tab is present and its color
	 * 
	 * @author MOHAMMED SIDDIQ
	 * @return - String value - "return color"
	 */
	public String verifyWinterHomeTabIsPresentAndColor() {
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(byWinterHomeTab);
		getDriver().findElement(byWinterWeatheerTab).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active\")).borderBottomColor;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to verify links links for Company Header
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean validatelinksforCompanyHeader() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		return getDriver().findElements(bycompany).size() > 0
				&& getDriver().findElements(bySuperiorAccuracyinAction).size() > 0
				&& getDriver().findElements(byAboutAccuWeather).size() > 0
				&& getDriver().findElements(byMediaKit).size() > 0 && getDriver().findElements(byCareers).size() > 0
				&& getDriver().findElements(byPress).size() > 0 && getDriver().findElements(byContactUs).size() > 0;
	}

	/**
	 * Method to verify links for Products and Services Header
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean validatelinksforProductsandServicesHeader() {

		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		return getDriver().findElements(byproductandservice).size() > 0
				&& getDriver().findElements(byEnterpriseSolutions).size() > 0
				&& getDriver().findElements(byD3DataDrivenDecisions).size() > 0
				&& getDriver().findElements(byAccuWeatherNetwork).size() > 0
				&& getDriver().findElements(byStoryTeller).size() > 0
				&& getDriver().findElements(byToolsforBroadcast).size() > 0
				&& getDriver().findElements(byRadioandNewspaper).size() > 0
				&& getDriver().findElements(byAccuWeatherAPIs).size() > 0
				&& getDriver().findElements(byPodcast).size() > 0;
	}

	/**
	 * Method to verify links Displayed under Apps and Downloads
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean validatelinksDisplayedunderAppsandDownloads() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		return getDriver().findElements(byiPhoneApp).size() > 0 && getDriver().findElements(byAndroidApp).size() > 0
				&& getDriver().findElements(bySeeallAppsandDownloads).size() > 0;

	}

	/**
	 * Method to verify subscription Services Contains Link
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean subscriptionServicesContainsLink(String link) {
		if (link.equalsIgnoreCase("AccuWeather Premium")) {
			Sleeper.sleep(4);
			return getDriver().findElements(byAccuWeatherPremium).size() > 0;
		}

		if (link.equalsIgnoreCase("AccuWeather Professional")) {
			Sleeper.sleep(4);
			return getDriver().findElements(byAccuWeatherProfessional).size() > 0;
		}

		return false;
	}

	/**
	 * Method to verify Mobile have A Top Ad On Winter Weather Page
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */
	public boolean verifyMobilehaveATopAdOnWinterWeatherPage() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byTopAdOnWinterWeatherPage);
		return getDriver().findElements(byTopAdOnWinterWeatherPage).size() > 0;
	}

}
