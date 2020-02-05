package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.DataIOOperations.ExcelUtilities;

public class HomepageBreadcrumbs extends BasePage
{
	
	private By byfooterbreadcrumbs=By.cssSelector("div.template-root > div.breadcrumbs-wrapper");
	private By bybreadcrumbforWorld=By.cssSelector("div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(1) > a");
	private By bybreadcrumbsforRegion=By.cssSelector("div > div.breadcrumbs-wrapper > div > div:nth-child(2) > a");
	private By bybreadcrumbsforCountry=By.cssSelector("div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(3) > a");
	private By bybreadcrumbsforState=By.cssSelector("div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(4) > a");
	private By bybreadcrumbsforCity =By.cssSelector("div.template-root > div.breadcrumbs-wrapper > div > div:nth-child(5) > a");
	public static int rowNo=0;

	/**
	 * @author HFARAZ
	 * Method to get the row number for the city name
	 * */
	public static int getBreadCrumbsDetails(String cityName)
	{
		rowNo = ExcelUtilities.getRowNumberForCity(cityName);
		return rowNo;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get city name
	 * **/
	public static String getCityName()
	{
		return ExcelUtilities.getCityName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the state name
	 * **/
	public static String getStateCode()
	{
		return ExcelUtilities.getStateCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get zipcode
	 * **/
	public static String getZipCode()
	{
		return ExcelUtilities.getZipCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get country code of the city
	 * **/
	public static String getCountryCode()
	{
		return ExcelUtilities.getCountryCode(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to give location key for the city
	 * **/
	public static String getLocationKey()
	{
		return ExcelUtilities.getLocationKey(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the state name for the city searched 
	 * */
	public static String getStateName()
	{
		return ExcelUtilities.getStateName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get continent name for the city
	 * */
	public static String getRegionName()
	{
		return ExcelUtilities.getRegionName(rowNo);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get country name for the city
	 * */
	public static String getCountryName()
	{
		return ExcelUtilities.getCountryName(rowNo);
	}
	
	
	/**
	 * @author Sandhya Rani 
	 * Method to scroll down the page till the bottom of page by getting x and y co-ordinates
	 * 
	 **/
	public void scrolldownpage(){
		WebPageLoaded.isDomComplete();
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
		Sleeper.sleep(3);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}
		
	/**
	 * @author Hasan Faraz 
	 * Method to Vaidate Breadcrumbs displayed on Homepage (World/Region/Country/Region/State/City)
	 **/
	
	public boolean footerbreadcrumbDisplayedfor(String link)
	{
		WebPageLoaded.isDomComplete();
		Boolean isBreadCrumbDisplayed = false;
		try
		{
			switch(link)
			{
				case "BREAD_CRUMB":
					isBreadCrumbDisplayed = getDriver().findElement(byfooterbreadcrumbs).isDisplayed();
					break;
				case "BREAD_CRUMB_WORLD":
					isBreadCrumbDisplayed = getDriver().findElement(bybreadcrumbforWorld).isDisplayed();
					break;
				case "BREAD_CRUMB_REGION":
					isBreadCrumbDisplayed =  getDriver().findElement(bybreadcrumbsforRegion).isDisplayed();
					break;
				case "BREAD_CRUMB_COUNTRY":
					isBreadCrumbDisplayed =  getDriver().findElement(bybreadcrumbsforCountry).isDisplayed();
					break;
				case "BREAD_CRUMB_STATE":
					isBreadCrumbDisplayed =  getDriver().findElement(bybreadcrumbsforState).isDisplayed();
					break;
				case "BREAD_CRUMB_CITY":
					isBreadCrumbDisplayed =  getDriver().findElement(bybreadcrumbsforCity).isDisplayed();
					break;
				default:
					break;
			}
		}
		catch(NoSuchElementException nsee)
		{
			isBreadCrumbDisplayed = false;
			System.err.println("Breadcrumbs not found for "+ link);
			nsee.getStackTrace();
		}
		return isBreadCrumbDisplayed;
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of breadcrumbs
	 * */
	public String getTextOfBreadCrumbs(String breadCrumb)
	{
		WebPageLoaded.isDomComplete();
		String breadCrumbText = "";
		try
		{
			switch(breadCrumb)
			{
				case "BREAD_CRUMB":
					breadCrumbText = getDriver().findElement(byfooterbreadcrumbs).getText();
					break;
				case "BREAD_CRUMB_WORLD":
					breadCrumbText = getDriver().findElement(bybreadcrumbforWorld).getText();
					break;
				case "BREAD_CRUMB_REGION":
					breadCrumbText =  getDriver().findElement(bybreadcrumbsforRegion).getText();
					break;
				case "BREAD_CRUMB_COUNTRY":
					breadCrumbText =  getDriver().findElement(bybreadcrumbsforCountry).getText();
					break;
				case "BREAD_CRUMB_STATE":
					breadCrumbText =  getDriver().findElement(bybreadcrumbsforState).getText();
					break;
				case "BREAD_CRUMB_CITY":
					breadCrumbText =  getDriver().findElement(bybreadcrumbsforCity).getText();
					break;
				default:
					break;
			}
		}
		catch(NoSuchElementException nsee)
		{
			breadCrumbText = null;
			System.err.println("Breadcrumbs not found for "+ breadCrumb);
			nsee.getStackTrace();
		}
		return breadCrumbText;
	}
	
	
	/**
	 * @author Sandhya Rani 
	 * Method to Click on Links from Breadcrumbs displayed on Homepage (World/Region/Country/Region/State/City)
	 * 
	 **/
	public void clickOnBreadcrumb(String breadCrumb)
	{
		WebPageLoaded.isDomComplete();
		try
		{
			switch(breadCrumb)
			{
				case "BREAD_CRUMB_WORLD":
					getDriver().findElement(bybreadcrumbforWorld).jsClick();
					WebPageLoaded.isDomComplete();
					break;
				case "BREAD_CRUMB_REGION":
					getDriver().findElement(bybreadcrumbsforRegion).jsClick();
					WebPageLoaded.isDomComplete();
					break;
				case "BREAD_CRUMB_COUNTRY":
					getDriver().findElement(bybreadcrumbsforCountry).jsClick();
					WebPageLoaded.isDomComplete();
					break;
				case "BREAD_CRUMB_STATE":
					getDriver().findElement(bybreadcrumbsforState).jsClick();
					WebPageLoaded.isDomComplete();
					break;
				case "BREAD_CRUMB_CITY":
					getDriver().findElement(bybreadcrumbsforCity).jsClick();
					WebPageLoaded.isDomComplete();
					break;
				default:
					break;
			}
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println("Breadcrumbs not found for "+ breadCrumb);
			nsee.getStackTrace();
		}
	}
}