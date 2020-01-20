package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class BannerAlerts extends BasePage
{
	private By alertSummary = By.cssSelector("#banner-wrap > div > a > span");
	private By singleBannerAlertBar = By.cssSelector("div.alert-banner-container > div > div.alert-banner.alert-banner-weather");
	private By multipleAlertsBannerBar = By.cssSelector("div.alert-banner-container.has-multiple > div > div.alert-banner.alert-banner-weather");
	private By singleAlertHeaderSummary = By.cssSelector("div.two-column-page-content > div:nth-child(1) > div > div > div > div > div > div:nth-child(2)");
	private By featuredLocations = By.cssSelector("div.featured-locations > a.recent-location-item.featured-location");
	
	String alertCount="";
	public static ArrayList<String> alertsSummary;
	
		 /**
		  * @author HFARAZ
		  * Method to check if the alert banner is present or not
		  * @return true if alert found on UI, else returns false
		  * */
		 public Boolean presenceOfAlertBannerBar()
		 {
			 WebPageLoaded.isDomComplete();
			 List<WebElement> alertBanner = getDriver().findElements(singleBannerAlertBar);
			 if(!alertBanner.isEmpty())
				 return true;
			 else 
				 return false;
		 }
		 
		 /**
		  * @author HFARAZ
		  * Method to check if multiple alerts are present
		  * @return true if multiple alerts present on UI, else returns false
		  * */
		 public Boolean presenceOfMultipleAlertsBanner()
		 {
			 WebPageLoaded.isDomComplete();
			 List<WebElement> alertBanners = getDriver().findElements(multipleAlertsBannerBar);
			 if((!alertBanners.isEmpty()) && alertBanners.size()>1)
				 return true;
			 else 
				 return false;
		 }
		 
		 
		 public String colorOfAlertBannerBar()
		 {
			 WebPageLoaded.isDomInteractive();
			 String color = getDriver().findElement(singleBannerAlertBar).getCssValue("background-image");
			 
			 return Color.fromString(color).asHex();
		 }
	
	/**
	 * @author HFARAZ
	 * Method to get the alert Summary displayed at the top of alert Banner
	 * */
	public String getAlertsSummary()
	{
		return getDriver().findElement(alertSummary).getText();			
	}
	
	/**
	 * @author HFARAZ
	 * Method to get alert header summary from the alert page
	 * @return String value of the alert header summary
	 * */
	public String getAlertHeaderSummary()
	{
		WebPageLoaded.isDomComplete();
		return getDriver().findElement(singleAlertHeaderSummary).getText();		
	}
	
	/**
	 * @author HFARAZ
	 * Method to click on alert banner
	 * */
	public void clickAlert()
	{
		WebPageLoaded.isDomComplete();
		getDriver().findElement(alertSummary).click();
	}
	
	
	/**
	 *@author HFARAZ
	 *Method to get the alert count present on the recent searched locations on home page
	 *@return integer value of the no of alerts present for the recent searched location
	 * */
	public int getAlertCountOnRecentLocation(String location)
	{
		WebPageLoaded.isDomComplete();
		List<WebElement> recentlySearchedLocations = getDriver().findElements(featuredLocations);
		
		for(int i=1;i<=recentlySearchedLocations.size();i++)
		{
			String cityName = getDriver().findElement(By.cssSelector("div.featured-locations > a:nth-child("+i+") > span.recent-location-name")).getText();
			if((cityName.replaceAll("\\s+","")).equalsIgnoreCase(location))
			{
				alertCount = getDriver().findElement(By.cssSelector("div.featured-locations > a:nth-child("+i+") > span.recrent-location-alert")).getText().replaceAll("\\s+","");
				break;
			}	  		  			  
		}
		
		return Integer.parseInt(alertCount);
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the no of alert banners on UI
	 * @return integer value of alerts present on UI
	 * */
	public int alertBannerCount()
	{
		WebPageLoaded.isDomComplete();
		List<WebElement> alertBanners = getDriver().findElements(multipleAlertsBannerBar);
		return alertBanners.size();
	}
	
	
	/**
	 * @author HFARAZ
	 * Method to get the alert summaries for the multiple alerts for a location
	 * @return ArrayList of String values: alert summaries for a location having multipe alerts
	 * */
	public ArrayList<String> getMultipleAlertsSummary()
	{
		WebPageLoaded.isDomComplete();
		List<WebElement> alertBanners = getDriver().findElements(multipleAlertsBannerBar);
		alertsSummary = new ArrayList<String>();
		for (int i=1;i<=alertBanners.size();i++)
		{
			alertsSummary.add(getDriver().findElement(By.cssSelector("div.alert-banner-container.has-multiple > div > div:nth-child("+i+") > a > span")).getText());
		}
		
		return alertsSummary;
	}
	
}