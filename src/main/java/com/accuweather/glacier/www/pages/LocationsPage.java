package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class LocationsPage extends BasePage {

	//private By byRegionLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[8]/div/h6/a/em");
	//private By byCountryLink = By.xpath("//ul/li[5]/div/h6/a/em");
	
	
	//private By byCountryLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[5]/div/h6/a/em");
	//private By byStateLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[39]/div/h6/a/em");
	//private By byCityLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[31]/div/h6/a/em");
	//private By byRegionLink = By.cssSelector("ul > li:nth-child(8) > div > h6 > a > em");
	//private By byRegionLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[8]/div/h6/a");
	//private By byCountryLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[5]/div/h6/a");
	//private By byStateLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[1]/div/h6/a");
	//private By byCityLink = By.xpath("//div[contains(@id,'panel-main')]/div[2]/div/div/div/ul/li[1]/div/h6/a");
	
	//private By byRegionLink = By.cssSelector("ul > li:nth-child(8) > div > h6 > a > em");
	//private By byStateLink = By.cssSelector("ul > li:nth-child(39) > div > h6 > a > em");		
	//private By byCityLink = By.cssSelector("ul > li:nth-child(31) > div > h6 > a > em");
	
	private By byRegionLink = By.cssSelector("#panel-main > div.panel-body-lt > div > div > div > ul > li:nth-child(8) > div > h6 > a");
	private By byCountryLink = By.cssSelector("#panel-main > div.panel-body-lt > div > div > div > ul > li.drilldown.cl.last > div > h6 > a");
	private By byStateLink = By.cssSelector("#panel-main > div.panel-body-lt > div > div > div > ul > li:nth-child(39) > div > h6 > a");
	private By byCityLink = By.cssSelector("#panel-main > div.panel-body-lt > div > div > div > ul > li:nth-child(96) > div > h6 > a");
	
	
	public void navigateToCountry() {
		getDriver().findElement(byRegionLink).click();
		
		//clickVisibleElement(byRegionLink);
		
		/*
		 * Link ByRegionLink = getDriver().findLink(byRegionLink);
		 * ByRegionLink.syncEnabled(); ByRegionLink.click();
		 */
		 
        
	}
	
	public void navigateToState() {
		
		getDriver().findElement(byCountryLink).click();
		
		//clickVisibleElement(byCountryLink);
		
		/*
		 * Link ByCountryLink = getDriver().findLink(byCountryLink);
		 * ByCountryLink.syncEnabled(); ByCountryLink.click();
		 */
		 
	}
	
	public void navigateToCity() {
		getDriver().findElement(byStateLink).click();
		
		//clickVisibleElement(byStateLink);
		/*
		 * Link ByStateLink = getDriver().findLink(byStateLink);
		 * ByStateLink.syncEnabled(); ByStateLink.click();
		 */
		 
	}
	
	public String navigateToForeCast() {
		WebPageLoaded.isDomInteractive();
        WebElement BrowseByLink = getDriver().findElement(byCityLink);
        BrowseByLink.syncEnabled(15);
        String ForeCastCityName = BrowseByLink.getText();
        System.out.println("ForeCastCityName....." +ForeCastCityName);
        BrowseByLink.click();
        return ForeCastCityName;
		//clickVisibleElement(byCityLink);
		
		/*
		 * Link ByCityLink = getDriver().findLink(byCityLink); ByCityLink.syncEnabled();
		 * ByCityLink.click();
		 */
		 
	}
}
