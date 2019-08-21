package com.accuweather.glacier.www.pages;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class DailyListPage extends BasePage{
	
	Boolean flag;
    private By byNextWeekDate = By.cssSelector("div.page-column-1 > div > p:nth-child(3)");
    private By byNextCTA = By.xpath("//a[@class='card-button nav-card next centered']");
    private By byPreviousCTA = By.xpath("//a[@class='card-button nav-card prev centered has-next']");
    
    /**
	 * Method to locate day of the week when clicked on Daily tab
	 * @author SOWMIYA
	 * @return - Boolean value - "true if day matches the current day else false"
	 * */
	public Boolean locateDayOfWeek()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> currentDay = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
		int size = currentDay.size();
		for(int i=0; i<=size; i++) {
			if(getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a")).syncVisible(5)) {
				flag = true;
				continue;
			}else
				flag = false;
			    break;
		}
		return true;
	}
	
	/**
	 * Method to forecast list for the current week should be displayed and limited to number of days in the current week
	 * @author SOWMIYA
	 * Boolean - return value - "true if two arraylist matches else false"
	 * */
	public Boolean verifyLimitedNumberOfDaysInCurrentWeek()
	{
        //Pull the list of week from UI
        List<WebElement> actualArray = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
        int sizeOfActualArray = actualArray.size();
        
        ArrayList<String> actualDays = new ArrayList<String>();
        
        //get day from UI and assign it to arraylist
        for(int i=1; i<=actualArray.size(); i++)
        {
        	String getDay = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a:nth-child("+i+") > div > p.dow")).getText();
        	actualDays.add(getDay);
        }
        
        //Userdefined days of a week
        ArrayList<String> daysUserDefined = new ArrayList<String>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        int sizeOfuserDefinedArray = daysUserDefined.size();
        
        //substract userdefined array size and actualArray size
        int noOfdysToRemoveFromUserdefinedArray = sizeOfuserDefinedArray-sizeOfActualArray;
        
        //Userdefined new array
        for(int i=0; i<noOfdysToRemoveFromUserdefinedArray; i++) {
        	daysUserDefined.remove(0);
        }
        
        System.out.println("daysUserDefined:"+daysUserDefined);
        
        //Compare 2 arraylist
        for(int i=0;i<actualDays.size();i++) {
        		if(actualDays.get(i).equalsIgnoreCase(daysUserDefined.get(i))) {
        			flag = true;
        			continue;
        		}else 
        			flag = false;
        			break;
        }
	return flag;
	}
	
	/**
	 * Method to verify next week header date and month
	 * @author SOWMIYA
	 * @return - Boolean value - true if both date and month matches
	 * */
	public Boolean confirmNextWeekHeaderDateAndMonth()
	{
		WebPageLoaded.isDomInteractive();
		WebElement actualNextWeekDateAndMonth = getDriver().findElement(byNextWeekDate);
		actualNextWeekDateAndMonth.syncVisible(15);
       
        //get actual next week date from UI
        String getNextWeekDateAndMonthFromUI = actualNextWeekDateAndMonth.getText();
        
        String nextWeekmonday = this.getMonday();
        String nextWeeksunday = this.getSunday();
        
        String nextWeekDateMonth = String.join(" - ", nextWeekmonday, nextWeeksunday);

        if(nextWeekDateMonth.equalsIgnoreCase(getNextWeekDateAndMonthFromUI))
        	flag = true;
        else
        	flag = false;
        
        return flag;
	}
	
	/**
	 * Method to get monday date and month
	 * @author SOWMIYA
	 * @return - Boolean value - date and month
	 * */
	public String getMonday()
	{
		Calendar calendar = Calendar.getInstance();
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (weekday != Calendar.MONDAY)
		{
		    // calculate how much to add
		    // the 2 is the difference between Saturday and Monday
		    int days = Calendar.SATURDAY - weekday + 2;
		    calendar.add(Calendar.DAY_OF_YEAR, days);
		}
          
          Format formatter = new SimpleDateFormat("MMMM d");
          String monday = formatter.format(calendar.getTime());
          
          return monday;
	}
	
	/**
	 * Method to get sunday date and month
	 * @author SOWMIYA
	 * @return - Boolean value - date and month
	 * */
	public String getSunday()
	{
		Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DAY_OF_YEAR, 7);
        
        int weekday = calendar.get(calendar.DAY_OF_WEEK);
           
        int days = Calendar.SUNDAY - weekday;
           if (days < 0)
           {
               days += 7;
           }
           
         calendar.add(Calendar.DAY_OF_YEAR, days);
         
         Format formatter = new SimpleDateFormat("MMMM d");
         String sunday = formatter.format(calendar.getTime());
         
         return sunday;
	}
	
	/**
	 * Method to verify the forecasts for Mon -Sun considering Monday as the first day
	 * @author SOWMIYA
	 * Boolean - return value - "true if two arraylist matches else false"
	 * */
	public Boolean confirmForecastListForWeekFromMonToSun()
	{
        //Pull the list of week from UI
		List<WebElement> actualArray = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(4) > a"));
        
        ArrayList<String> actualDays = new ArrayList<String>();
        
        //get day from UI and assign it to arraylist
        for(int i=1; i<=actualArray.size(); i++)
        {
        	String getDay = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(4) > a:nth-child("+i+") > div > p.dow")).getText();
        	actualDays.add(getDay);
        }
        
        //Userdefined days of a week
        ArrayList<String> daysUserDefined = new ArrayList<String>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        
        //Compare 2 arraylist
        for(int i=0;i<actualDays.size();i++) {
        		if(actualDays.get(i).equalsIgnoreCase(daysUserDefined.get(i))) {
        			flag = true;
        			continue;
        		}else 
        			flag = false;
        			break;
        }
	return flag;
	}
	
	/**
	 * Method to the daily foreast page has only three clusters of week. 
	 * There should not be more than 21 days weather report.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the weather report days are less than or equal to 21 else false"
	 * */
	public Boolean confirmDailyForecastPageShowsThreeClusters()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> threeClustersOfWeek = getDriver().findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
		if(threeClustersOfWeek.size() <= 21)
			flag = true;
		else
			flag = false;
		
		return flag;			
	}
	
	/**
	 * Method to click next CTA and page redirected to next three sets of weeks. 
	 * Verify both previous and next CTA are present
	 * @author SOWMIYA
	 * */
	public Boolean verifyBothNextAndCTAPresentInNextPage()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nextCTA = getDriver().findElement(byNextCTA);
		WebElement previousCTA = getDriver().findElement(byPreviousCTA);
	
		return nextCTA.syncVisible() && previousCTA.syncVisible();
	}
	
	/**
	 * Method to verify last week page have one or two week of data.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the weather report days are less than or equal to 14 else false"
	 * */
	public Boolean lastPageHaveOneOrTwoWeekReports()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> threeClustersOfWeek = getDriver().findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
		if(threeClustersOfWeek.size() <= 14)
			flag = true;
		else
			flag = false;
		
		return flag;			
	}
	
	/**
	 * Method to verify user able to navigate 1 page forward.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the page param is 1 else false"
	 * */
	public Boolean confirmUserAbleToNavigateTo1PageForward()
	{
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length()-6);
		return actualPageNumber.equalsIgnoreCase("page=1");
	}
	
	/**
	 * Method to verify user able to navigate 2 page forward.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the page param is 2 else false"
	 * */
	public Boolean confirmUserAbleToNavigateTo2PagesForward()
	{
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length()-6);
		return actualPageNumber.equalsIgnoreCase("page=2");
	}
	
	/**
	 * Method to verify user able to navigate 3 page forward.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the page param is 3 else false"
	 * */
	public Boolean confirmUserAbleToNavigateTo3PagesForward()
	{
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length()-6);
		return actualPageNumber.equalsIgnoreCase("page=3");
	}
	
	/**
	 * Method to verify user able to navigate upto to 4 pages forward.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the page param is 4 else false"
	 * */
	public Boolean confirmUserAbleToNavigateTo4PagesForward()
	{
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length()-6);
		return actualPageNumber.equalsIgnoreCase("page=4");
	}
        
}
