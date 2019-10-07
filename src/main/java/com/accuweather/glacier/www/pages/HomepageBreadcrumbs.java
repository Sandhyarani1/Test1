package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;

public class HomepageBreadcrumbs extends BasePage {
	
	private By byfooterbreadcrumbs=By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper");
	private By bybreadcrumbforWorld=By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(1) > a");
	private By bybreadcrumbsforRegion=By.cssSelector("body > div > div.breadcrumbs-wrapper > div > div:nth-child(2) > a");
	private By bybreadcrumbsforCountry=By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(3) > a");
	private By bybreadcrumbsforState=By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(4) > a");
	private By bybreadcrumbsforCity =By.cssSelector("body > div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(5) > a");
		

	
	/**
	 * @author Sandhya Rani 
	 * Method to scroll down the page till the bottom of page by getting x and y co-ordinates
	 * 
	 **/
	public void scrolldownpage(){
		WebPageLoaded.isDomInteractive();
		getDriver().executeJavaScript("window.scrollBy(0,2103)");	
	}

	/**
	 * @author Sandhya Rani 
	 * Method to Validate Footer Breadcrumbs are displayed 
	 * 
	 **/
	
	public boolean footercrumb()
	{
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byfooterbreadcrumbs).isDisplayed();
	}
	
	/**
	 * @author Sandhya Rani 
	 * Method to Click on Breadcrumbs and validate the Landing page url with the Title  
	 * 
	 **/
	
	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		WebPageLoaded.isDomComplete(8000000);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}
		
	/**
	 * @author Sandhya Rani 
	 * Method to Vaidate Breadcrumbs displayed on Homepage (World/Region/Country/Region/State/City)
	 * 
	 **/
	
	public boolean footerbreadcrumbDisplayedfor(String link)
	{
		if(link.equalsIgnoreCase("Footer breadcrumb"))
		{
			getDriver().manage().deleteAllCookies();
			return getDriver().findElement(byfooterbreadcrumbs).syncVisible(25);
		}
		
		if(link.equalsIgnoreCase("Breadcrumb World"))
		{
			return getDriver().findElement(bybreadcrumbforWorld).syncVisible(25);
		}
		
		if(link.equalsIgnoreCase("Breadcrumb Region"))
		{
			return getDriver().findElement(bybreadcrumbsforRegion).isDisplayed();
		}
		
		if(link.equalsIgnoreCase("Breadcrumb Country"))
		{
			return getDriver().findElement(bybreadcrumbsforCountry).isDisplayed();
		}
		
		if(link.equalsIgnoreCase("Breadcrumb State"))
		{
			return getDriver().findElement(bybreadcrumbsforState).isDisplayed();
		}
		
		if(link.equalsIgnoreCase("Breadcrumb City"))
		{
			return getDriver().findElement(bybreadcrumbsforCity).isDisplayed();
		}
		return false;
		
	}	
	
	/**
	 * @author Sandhya Rani 
	 * Method to Click on Links from Breadcrumbs displayed on Homepage (World/Region/Country/Region/State/City)
	 * 
	 **/
	public void isclickonFooterBreadcrumb(String link )
	 {
		if(link.equalsIgnoreCase("Breadcrumb World"))
		{
			getDriver().manage().deleteAllCookies();
			getDriver().findElement(bybreadcrumbforWorld).jsClick();
		}
			
		if(link.equalsIgnoreCase("Breadcrumb Region"))
		{
			getDriver().manage().deleteAllCookies();
			getDriver().findElement(bybreadcrumbsforRegion).jsClick();
			}
			
		if(link.equalsIgnoreCase("Breadcrumb Country"))
		{
			getDriver().manage().deleteAllCookies();
			getDriver().findElement(bybreadcrumbsforCountry).jsClick();
		}
			
		if(link.equalsIgnoreCase("Breadcrumb State"))
		{
//		    String currentUrl=getDriver().getCurrentUrl();		
//			getDriver().navigate().to(currentUrl);
			getDriver().manage().deleteAllCookies();
			getDriver().findElement(bybreadcrumbsforState).jsClick();
		}
			
		if(link.equalsIgnoreCase("Breadcrumb City"))
		{
			getDriver().manage().deleteAllCookies();
			getDriver().findElement(bybreadcrumbsforCity).jsClick();
		}
	}
}