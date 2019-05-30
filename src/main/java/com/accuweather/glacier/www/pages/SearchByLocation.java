package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;


public class SearchByLocation extends BasePage {

	//private By bylocationlink = By.xpath("//body[contains(@id,'home')]/nav/div[5]/div/div[1]/a");
	//private By bylocationlink = By.xpath("//body[contains(@id,'home')]/nav/div[5]/div/div[1]//a[contains(@href,'https://www.accuweather.com/en/browse-locations')]");
	private By bylocationlink = By.cssSelector("#home > nav > div.menu-dropdown > div > div:nth-child(1) > a");
	
        public void navigateToLocations() {
        	//getDriver().findElement(bylocationlink).click();
        	//clickVisibleElement(bylocationlink);
        	
        	WebPageLoaded.isDomInteractive();
            WebElement BrowseByLink = getDriver().findElement(bylocationlink);
            BrowseByLink.syncVisible(20);
            BrowseByLink.jsClick();
            //BrowseByLink.click();
		
		/*
		 * Link ByLocationLink = getDriver().findLink(bylocationlink);
		 * ByLocationLink.syncEnabled(); ByLocationLink.click();
		 */
		 
            
        }

	
}
