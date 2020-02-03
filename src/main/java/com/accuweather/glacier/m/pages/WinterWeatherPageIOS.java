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

public class WinterWeatherPageIOS extends MobileBasePage {

	private By byNationalWeatherServiceMapTitle = By
			.cssSelector("div > div.snow-depth-map.content-module.full-mobile-width > p");
	private By byNationalForecastMapTitle = By
			.cssSelector("div.page-column-1 > div.content-module > div > div.map-header > h2");
	private By byLocalForecastMapSearchModule = By.cssSelector(
			"div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div > div > div.searchbar > div.searchbar-content > form > input");
	private By byLocalForecastMapTitle = By.cssSelector(
			"div.page-column-1 > div.content-module > div.wintercast-search-bar.content-module.full-mobile-width > div.title.card");
	private By byRightRailReadMoreButton = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-2 > div > div.content-module.zone-rightRail1 > div > a:nth-child(1) > div.right-rail-cta-text > div");
	private By byWinterWeatherSubmenuDescription = By
			.xpath("div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	private By byWinterWeatheerTab = By.cssSelector(
			"div.page-subnav > div > div.subnav.secondary-nav.has-tertiary > div.subnav-items > a.subnav-item.active");
	private By byWinterHomeTab = By
			.cssSelector("div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By bySevereWeatherMenu = By.cssSelector(".accordion-item:nth-child(4) .accordion-item-header-content");
	private By byWinterWeatherMenu = By.cssSelector(".accordion-item:nth-child(4) a:nth-child(4)");
	private By byLocalForecastMapModule = By.cssSelector(
			"#map > div.mapboxgl-canvas-container.mapboxgl-interactive.mapboxgl-touch-drag-pan.mapboxgl-touch-zoom-rotate > canvas");
	private By byTopAdOnWinterWeatherPage = By.xpath("//div[@id='top']");
	private By byWinterWeatherFooter = By.xpath("//div[@class='base-footer is-en']");
	private By byWinterWeatherFooterComapany = By.xpath("//span[contains(text(),'Company')]");
	private By byWinterWeatherFooterProductsAndServices = By.xpath("//span[contains(text(),'Products & Services')]");
	private By byWinterWeatherFooterAppsAndDownloads = By.xpath("//span[contains(text(),'Apps & Downloads')]");
	private By byWinterWeatherFooterSubscriptionSevices = By.xpath("//span[contains(text(),'Subscription Services')]");
	private By byCompanyWinterWeatherOptionSuperiorAccuracyInAction = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Superior Accuracy in Action')]");
	private By byCompanyWinterWeatherOptionAboutAccuWeather = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'About AccuWeather')]");
	private By byCompanyWinterWeatherOptionMediaKit = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Media Kit')]");
	private By byCompanyWinterWeatherOptionCareers = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Careers')]");
	private By byCompanyWinterWeatherOptionPress = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Press')]");
	private By byCompanyWinterWeatherOptionContactUs = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Contact Us')]");

	private By byWinterWeatherFooterPSEnterpriseSolutions = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Enterprise Solutions')]");
	private By byWinterWeatherFooterPSDataDrivenDecisions = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'D3: Data Driven Decisions')]");
	private By byWinterWeatherFooterPSAccuWeatherNetwork = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'AccuWeather Network')]");
	private By byWinterWeatherFooterPSStoryTeller = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'StoryTeller')]");
	private By byWinterWeatherFooterPSToolsforBroadcast = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Tools for Broadcast')]");
	private By byWinterWeatherFooterPSRadioAndNewspaper = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Radio & Newspaper')]");
	private By byWinterWeatherFooterPSAccuWeatherAPIS = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'AccuWeather APIs')]");
	private By byWinterWeatherFooterPSPodcast = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Podcast')]");

	private By byWinterWeatherFooterADiPhoneApp = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'iPhone App')]");
	private By byWinterWeatherFooterADAndroidApp = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'Android App')]");
	private By byWinterWeatherFooterADSeeAllAppsAndDownloads = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'See all Apps & Downloads')]");

	private By byWinterWeatherFooterSSAccuWeatherPremium = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'AccuWeather Premium')]");
	private By byWinterWeatherFooterSSAccuWeatherProfessional = By.xpath(
			"//div[@class='footer-category-section footer-category-accordion']//a[@class='footer-category-section-link'][contains(text(),'AccuWeather Professional')]");

	/**
	 * Method to verify user is able to see national weather service map
	 * 
	 * @author SOWMIYA
	 * @return - String value - "return title of the map"
	 */
	public String verifyUserSeeNationalWeatherServiceMap() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		getDriver().executeJavaScript("window.scrollTo(0, 400)");
		Sleeper.sleep(5);
		WebElement nationalWeatherServiceMap = getDriver().findElement(byNationalWeatherServiceMapTitle);
		return nationalWeatherServiceMap.getText();
	}

	/**
	 * Method to verify user is able to see national forecast map
	 * 
	 * @author SOWMIYA
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
	 * @author SOWMIYA
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
	 * @author SOWMIYA
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
	 * @author SOWMIYA
	 * @return - String value - "return color"
	 */
	public String verifyReadMoreButtonPresntInRightRailModuleColor() {
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(byRightRailReadMoreButton);
		getDriver().findElement(byRightRailReadMoreButton).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"div.page-subnav > div > div > div.subnav-items > a.subnav-item.active\")).border-top;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

	/**
	 * Method to verify winter weather submenu description
	 * 
	 * @author SOWMIYA
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
	 * @author SOWMIYA
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
	 * @author SOWMIYA
	 * @return - String value - "return color"
	 */
	public String verifyWinterHomeTabIsPresentAndColor() {
		WebPageLoaded.isDomInteractive();
		WebElement winterWeatheerTab = getDriver().findElement(byWinterWeatheerTab);
		winterWeatheerTab.syncVisible(30);
		String colorTab = getDriver().findElement(byWinterHomeTab).getCssValue("border-bottom");
		String trimColorReadMoreButton = colorTab.substring(10);
		String actualcolourdisplayed = Color.fromString(trimColorReadMoreButton).asHex();
		return actualcolourdisplayed;
	}
	
	/**
	 * Method to click Bread Crumb Menu
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public Boolean clickBreadCrumbMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenu).jsClick();
		return true;
	}
	
	/**
	 * Method to click Severe Weather Menu
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public Boolean clickSevereWeatherMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(bySevereWeatherMenu).jsClick();
		return true;

	}
	
	/**
	 * Method to click Winter Weather Menu
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public Boolean clickWinterWeatherMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byWinterWeatherMenu).jsClick();
		Sleeper.sleep(3);
		return true;

	}
	
	/**
	 * Method to verify National Forecast Maps Module
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyNationalForecastMapsModule() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byLocalForecastMapModule);
		return getDriver().findElements(byLocalForecastMapModule).size() > 0;

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
	
	/**
	 * Method to verify Winter Weather Footer Is In English
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyWinterWeatherFooterIsInEnglish() {
		WebPageLoaded.isDomInteractive();
		WebElement nationalForecastMap = getDriver().findElement(byWinterWeatherFooter);
		return getDriver().findElements(byWinterWeatherFooter).size() > 0;
	}
	
	/**
	 * Method to verify Winter Weather Footer Main Components
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyWinterWeatherFooterMainComponents() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		return getDriver().findElements(byWinterWeatherFooterComapany).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterProductsAndServices).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterAppsAndDownloads).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterSubscriptionSevices).size() > 0;
	}
	
	/**
	 * Method to verify Winter Weather Footer Company Components
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyWinterWeatherFooterCompanyComponents() {
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		getDriver().findElement(byWinterWeatherFooterComapany).click();
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byCompanyWinterWeatherOptionSuperiorAccuracyInAction).size() > 0
				&& getDriver().findElements(byCompanyWinterWeatherOptionAboutAccuWeather).size() > 0
				&& getDriver().findElements(byCompanyWinterWeatherOptionMediaKit).size() > 0
				&& getDriver().findElements(byCompanyWinterWeatherOptionCareers).size() > 0
				&& getDriver().findElements(byCompanyWinterWeatherOptionPress).size() > 0
				&& getDriver().findElements(byCompanyWinterWeatherOptionContactUs).size() > 0;
	}
	
	/**
	 * Method to verify Winter Weather Footer Products And Services Components
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyWinterWeatherFooterProductsAndSerivesComponents() {
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		getDriver().findElement(byWinterWeatherFooterProductsAndServices).click();
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byWinterWeatherFooterPSEnterpriseSolutions).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSDataDrivenDecisions).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSAccuWeatherNetwork).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSStoryTeller).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSToolsforBroadcast).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSRadioAndNewspaper).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSAccuWeatherAPIS).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterPSPodcast).size() > 0;
	}
	
	/**
	 * Method to verify Winter Weather Footer Apps And DownLoads Components
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */
	public boolean verifyWinterWeatherFooterAppsAndDownLoadsComponents() {
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		getDriver().findElement(byWinterWeatherFooterAppsAndDownloads).click();
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byWinterWeatherFooterADiPhoneApp).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterADAndroidApp).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterADSeeAllAppsAndDownloads).size() > 0;
	}
	
	/**
	 * Method to verify Winter Weather Footer Subscription Services Components
	 * 
	 * @author Mohammed Siddiq
	 * @return - boolean value
	 */

	public boolean verifyWinterWeatherFooterSubscriptionServicesComponents() {
		Sleeper.sleep(3);
		getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		Sleeper.sleep(3);
		getDriver().findElement(byWinterWeatherFooterSubscriptionSevices).click();
		WebPageLoaded.isDomInteractive();
		return getDriver().findElements(byWinterWeatherFooterSSAccuWeatherPremium).size() > 0
				&& getDriver().findElements(byWinterWeatherFooterSSAccuWeatherProfessional).size() > 0;
	}
}
