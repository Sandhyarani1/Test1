package com.accuweather.glacier.www.pages;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.DailyPageAPI;
import com.accuweather.glacier.api.HourlyPageAPI;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class DailyListPage extends BasePage{
	public static ArrayList<String> startMonthDateList;
	public static ArrayList<String> endMonthDateList;
	public static ArrayList<String> MonthAndDateHeaderList_UserDefined;
	public static ArrayList<String> dateMonthDateList_UI = new ArrayList<String>();
	
	//Arraylist
	public static ArrayList<String> dayList_UI;
	public static ArrayList<String> dateList;
	public static ArrayList<String> maximimTemperatureList;
	public static ArrayList<String> minimumTemperatureList;
	public static ArrayList<String> iconPhraseList;
	public static ArrayList<String> precipitationPercentageList;
	public static ArrayList<String> dayList_Userdefined;
	public static ArrayList<String> pageNumberForwardList_UI;
	public static ArrayList<String> pageNumberPreviousList_UI;
	public static ArrayList<String> firstWeekURLList_UI;
	public static ArrayList<String> secondWeekURLList_UI;
	public static ArrayList<String> thirdWeekURLList_UI;
	
	Boolean flag;
    private By byNextWeekHeader1 = By.cssSelector("div > div.page-column-1 > div > p:nth-child(4)");
    private By byNextWeekHeader2 = By.cssSelector("div > div.page-column-1 > div > p:nth-child(7)");
    private By byNextWeekHeader3 = By.cssSelector("div > div.page-column-1 > div > p:nth-child(1)");
    private By byNextWeekHeader4 = By.cssSelector("div > div.page-column-1 > div > p:nth-child(5)");
    private By byNextWeekHeader5 = By.cssSelector("div > div.page-column-1 > div > p:nth-child(8)");
    private By byNextCTA = By.cssSelector("div.navigation > a.card-button.centered.nav-card.next");
    private By byPreviousCTA = By.cssSelector("div > div.navigation > a.card-button.centered.nav-card.prev");
    private By byDailyTab = By.xpath("//a[@data-gaid='daily']");
    
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
	 * Method to get next week header date and month from UI
	 * @author SOWMIYA
	 * */
	public Boolean getNextWeekHeaderDateAndMonthFromUI()
	{
	
		WebElement getNextWeekHeader1 = getDriver().findElement(byNextWeekHeader1);
		getNextWeekHeader1.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader1.getText());
        
        WebElement getNextWeekHeader2 = getDriver().findElement(byNextWeekHeader2);
		getNextWeekHeader2.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader2.getText());
       
        clickNextCTA();
        
        WebElement getNextWeekHeader3 = getDriver().findElement(byNextWeekHeader3);
		getNextWeekHeader3.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader3.getText());
        
        WebElement getNextWeekHeader4 = getDriver().findElement(byNextWeekHeader4);
		getNextWeekHeader4.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader4.getText());
        
        WebElement getNextWeekHeader5 = getDriver().findElement(byNextWeekHeader5);
		getNextWeekHeader5.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader5.getText());
        
        clickNextCTA();
        
        WebElement getNextWeekHeader6 = getDriver().findElement(byNextWeekHeader3);
		getNextWeekHeader6.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader6.getText());
        
        WebElement getNextWeekHeader7 = getDriver().findElement(byNextWeekHeader4);
		getNextWeekHeader7.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader7.getText());
        
        WebElement getNextWeekHeader8 = getDriver().findElement(byNextWeekHeader5);
		getNextWeekHeader8.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader8.getText());
        
        clickNextCTA();
        
        WebElement getNextWeekHeader9 = getDriver().findElement(byNextWeekHeader3);
		getNextWeekHeader9.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader9.getText());
        
        WebElement getNextWeekHeader10 = getDriver().findElement(byNextWeekHeader4);
		getNextWeekHeader10.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader10.getText());
        
        WebElement getNextWeekHeader11 = getDriver().findElement(byNextWeekHeader5);
		getNextWeekHeader11.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader11.getText());
        
        clickNextCTA();
        
        WebElement getNextWeekHeader12 = getDriver().findElement(byNextWeekHeader3);
		getNextWeekHeader12.syncVisible(15);
		dateMonthDateList_UI.add(getNextWeekHeader12.getText());
        
		System.out.println("dateMonthDateList_UI:"+dateMonthDateList_UI);
		
        return true;
	}
	
	/**
	 * Method to get date and month headers on all pages 
	 * @author SOWMIYA
	 * */
	public void getStartAndEndHeaderOnAllPagesUsingCalendarFunction()
	{
		ArrayList<String> startMonthDateList;
		ArrayList<String> endMonthDateList;
		
		startMonthDateList = new ArrayList<String>();
		endMonthDateList = new ArrayList<String>();
		MonthAndDateHeaderList_UserDefined = new ArrayList<String>();
		 
		for(int i=1; i<=12; i++) {
			Calendar calendar = Calendar.getInstance();
			int j =i*7;
				
			calendar.add(Calendar.DATE, j);
			Format formatter = new SimpleDateFormat("MMMM d");
			startMonthDateList.add(formatter.format(calendar.getTime()));
				
			calendar.add(Calendar.DATE, 6);
			Format formatter1 = new SimpleDateFormat("MMMM d");
			endMonthDateList.add(formatter1.format(calendar.getTime()));
			
		}
		for(int i=0; i<12; i++) {
			MonthAndDateHeaderList_UserDefined.add(startMonthDateList.get(i).toUpperCase()+" - "+endMonthDateList.get(i).toUpperCase());
		}	
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
	 * Method to click next CTA and verify daily forecast page has only three clusters of week. 
	 * There should be 21 days on a page..
	 * @author SOWMIYA
	 * Boolean - return value - "true if the weather report has 3 weeks i.e., 21 days else false"
	 * */
	public Boolean confirmDailyForecastPageShowsThreeClustersWhenClickedOnNextCTA()
	{
		for (int i=1; i<=3; i++) {
			clickNextCTA();
			verifyBothNextAndCTAPresentInNextPage();
			WebPageLoaded.isDomInteractive();
			List<WebElement> threeClustersOfWeek = getDriver().findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
			if(threeClustersOfWeek.size() == 21)
				flag = true;
			else
				flag = false;		
		}	
		return flag;
	}
	
	/**
	 * Method to click previous CTA and verify daily forecast page has only three clusters of week. 
	 * There should be 21 days on a page.
	 * @author SOWMIYA
	 * Boolean - return value - "true if the weather report has 3 weeks i.e., 21 days else false"
	 * */
	public Boolean confirmDailyForecastPageShowsThreeClustersWhenClickedOnPreviousCTA()
	{
		for (int i=1; i<=3; i++) {
			clickPreviousCTA();
			if(i!=3)
				verifyBothNextAndCTAPresentInNextPage();
			WebPageLoaded.isDomInteractive();
			List<WebElement> threeClustersOfWeek = getDriver().findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
			if(threeClustersOfWeek.size() == 21)
				flag = true;
			else
				flag = false;		
		}	
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
	 * Boolean - return value - "true if one week report is shown i.e., 7 days else false"
	 * */
	public Boolean lastPageHaveOneWeekReports()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> threeClustersOfWeek = getDriver().findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
		if(threeClustersOfWeek.size() == 7)
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
        
	/**
	 * Method to click previous CTA
	 * @author SOWMIYA
	 * */
	public void clickPreviousCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement previousCTA = getDriver().findElement(byPreviousCTA);
		previousCTA.syncVisible(20);
		previousCTA.click();
		Sleeper.sleep(1.5);
	}
	
	/**
	 * Method to click next CTA
	 * @author SOWMIYA
	 * */
	public void clickNextCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement nextCTA = getDriver().findElement(byNextCTA);
		nextCTA.syncVisible(20);
		nextCTA.click();
		Sleeper.sleep(1.5);
	}
	
	/**
	 * Method to click next CTA
	 * @author SOWMIYA
	 * */
	public void clickDailyTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement dailyTab = getDriver().findElement(byDailyTab);
		dailyTab.syncVisible(15);
		dailyTab.jsClick();
		Sleeper.sleep(2);
	}
	
	/** Method to get URL when previous CTA is clicked
	 *  @author SOMWIYA
	 * */
	public void getURLWhenClickOnPreviousCTA()
	{
		pageNumberPreviousList_UI = new ArrayList<String>();
		for (int i=4; i>=0; i--) {
			pageNumberPreviousList_UI.add(getDriver().getCurrentUrl());
			if(i!=0)
				clickPreviousCTA();
		}
		
		Collections.sort(pageNumberPreviousList_UI);
		System.out.println("pageNumberPreviousList_UI:"+pageNumberPreviousList_UI);
	}
	
	/** Method to get URL when next CTA is clicked
	 *  @author SOMWIYA
	 * */
	public void getURLWhenClickOnNextCTA()
	{
		pageNumberForwardList_UI = new ArrayList<String>();
		clickNextCTA();
		for (int i=1; i<=4; i++) {
			pageNumberForwardList_UI.add(getDriver().getCurrentUrl());
			if(i!=4)
			clickNextCTA();
		}
	}
	
	/** Method to get the elements from three weeks cluster on daily page
	 * @author SOWMIYA
	 *  */
	public void getTextOfAllValueFromThreeWeekClustersOnDailyPage() {
		dayList_UI = new ArrayList<String>();
		dateList =new ArrayList<String>();
		maximimTemperatureList = new ArrayList<String>();
		minimumTemperatureList =new ArrayList<String>();
		iconPhraseList = new ArrayList<String>();
		precipitationPercentageList =new ArrayList<String>();
		
		boolean isEquals = false;
		//get the total number of tabs in today's hourly page
		List<WebElement> NoOfTabs = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div"));
		int totalTabs = NoOfTabs.size();
		System.out.println("totalTabs:"+totalTabs);
		
		for(int i=0; i<=totalTabs+1; i++) {
			
			if (i==1 || i==5 || i==8) {
				
				for(int j=1;j<=7;j++) {
					
					//DAY
					WebElement day = getDriver().findElement(By.cssSelector("div:nth-child(" + i +") > a:nth-child(" + j + ") > div.date > p.dow"));
					day.syncVisible(10);
					dayList_UI.add(day.getText());
					
					//DATE
					WebElement date = getDriver().findElement(By.cssSelector("div:nth-child(" + i +") > a:nth-child(" + j + ") > div.date > p.sub"));
					date.syncVisible(10);
					dateList.add(date.getText());
					
					//MAXIMUM TEMPERATURE
					WebElement maximumTemperature = getDriver().findElement(By.cssSelector("div > div:nth-child(" + i + ") > a:nth-child(" + j + ") > div.temps > span.high"));
					maximumTemperature.syncVisible(10);
					maximimTemperatureList.add(maximumTemperature.getText());
					
					//MINIMUM TEMPERATURE
					WebElement minimumTemperature = getDriver().findElement(By.cssSelector("div > div:nth-child(" + i + ") > a:nth-child(" + j + ") > div.temps > span.low"));
					minimumTemperature.syncVisible(10);
					minimumTemperatureList.add(minimumTemperature.getText().replace("/", "").replace(" ", ""));
					
					//PHRASE
					WebElement phrase = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(" + i +") > a:nth-child(" + j + ") > span"));
					phrase.syncVisible(10);
					iconPhraseList.add(phrase.getText());
					
					//PRECIPITATION PERCENTAGE
					WebElement precipitaionPercentage = getDriver().findElement(By.cssSelector("div > div:nth-child(" + i + ") > a:nth-child(" + j + ") > div.info.precip > p:nth-child(2)"));
					precipitaionPercentage.syncVisible(10);
					precipitationPercentageList.add(precipitaionPercentage.getText());
				}
			}
		}
	}
	
	/** Method to click on each tab on first week card and get the url
	 * @author SOWMIYA
	 *  */
	public void firstWeekCardClickAllTabAndGetURLFrom() {
		
		//get the total number of tabs from 1st week card
		List<WebElement> NoOfTabs = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
		firstWeekURLList_UI = new ArrayList<String>();
		for(int i=1; i<=NoOfTabs.size(); i++) {	
			//click on tab and store the URL in arraylist
			WebElement card1 = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a:nth-child(" + i + ")"));
			card1.syncVisible(25);
			card1.jsClick();
			Sleeper.sleep(1.5);
			firstWeekURLList_UI.add(getDriver().getCurrentUrl());
			getDriver().navigate().back();
		}
	}
	
	/** Method to click on each tab on 2nd week card and get the url
	 * @author SOWMIYA
	 *  */
	public void secondWeekCardClickAllTabAndGetURLFrom() {
		
		//get the total number of tabs from 2nd week card
		List<WebElement> NoOfTabs = getDriver().findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(5) > a"));
		secondWeekURLList_UI = new ArrayList<String>();
		for(int i=1; i<=NoOfTabs.size(); i++) {	
			//click on tab and store the URL in arraylist
			WebElement card1 = getDriver().findElement(By.cssSelector("div.page-column-1 > div > div:nth-child(5) > a:nth-child(" + i + ")"));
			card1.syncVisible(25);
			card1.jsClick();
			Sleeper.sleep(1.5);
			secondWeekURLList_UI.add(getDriver().getCurrentUrl());
			getDriver().navigate().back();
		}
	}
	
	/** Method to click on each tab on 3rd week card and get the url
	 * @author SOWMIYA
	 *  */
	public void thirdWeekCardClickAllTabAndGetURLFrom() {
		
		//get the total number of tabs from 3rd week card
		List<WebElement> NoOfTabs = getDriver().findElements(By.cssSelector("div > div.content-module.bottom-forecast > a"));
		thirdWeekURLList_UI = new ArrayList<String>();
		for(int i=1; i<=NoOfTabs.size(); i++) {	
			//click on tab and store the URL in arraylist
			WebElement card1 = getDriver().findElement(By.cssSelector("div > div.content-module.bottom-forecast > a:nth-child(" + i + ")"));
			card1.syncVisible(25);
			card1.jsClick();
			Sleeper.sleep(1.5);
			thirdWeekURLList_UI.add(getDriver().getCurrentUrl());
			getDriver().navigate().back();
		}
		
		System.out.println("thirdWeekURLList_UI:"+thirdWeekURLList_UI);
	}
	
	/**
	 * Method to verify minimum temperature is not greater than /equal to maximum temperature
	 * @author SOWMIYA
	 * */
	public Boolean verifyMinimumTemperatureIsNotGreaterOrEqualToMaximumTemperature(ArrayList<String> minTempFromAPI, ArrayList<String> maxTempFromAPI)
	{
		boolean isEquals = false;
		//First verify min and max from UI and API are equal 
		if(maximimTemperatureList.equals(maxTempFromAPI) && minimumTemperatureList.equals(minTempFromAPI)) {
			
			//verify minimum temperature is not greater than / equal to maximum temperature
			for (int i=0; i<21;i++) {
				System.out.println("minimumTemperatureList.get(i):"+minimumTemperatureList.get(i));
				System.out.println("maximimTemperatureList.get(i):"+maximimTemperatureList.get(i));
				if (Integer.parseInt(minimumTemperatureList.get(i).replace("°", "")) < Integer.parseInt(maximimTemperatureList.get(i).replace("°", "")))
					isEquals = true;
				else 
					break;
				}
			}
		System.out.println("maximimTemperatureList:"+maximimTemperatureList);
		System.out.println("maxTempFromAPI        :"+maxTempFromAPI);
		System.out.println("minimumTemperatureList:"+minimumTemperatureList);
		System.out.println("minTempFromAPI        :"+minTempFromAPI);
		return isEquals;	
	}
	
	/**
	 * Method to verify the days displayed in UI in all threee weeks
	 * @author SOWMIYA
	 * */
	public void verifyDayShownInAllThreeWeeks()
	{
		dayList_Userdefined = new ArrayList<String>();
		for(int i=0; i<=20; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, i);
			Format formatter = new SimpleDateFormat("EEE");
			String day_Userdefined = formatter.format(calendar.getTime());
			dayList_Userdefined.add(day_Userdefined);
	        System.out.println("dayList_Userdefined:"+day_Userdefined);
		}
	}
}

















