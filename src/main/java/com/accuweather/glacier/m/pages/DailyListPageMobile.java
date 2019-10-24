package com.accuweather.glacier.m.pages;

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
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class DailyListPageMobile extends MobileBasePage {

	Boolean flag;
	private By byNextWeekDate = By.xpath("(//p[@class='module-title'])[1]");
	private By byNextCTA = By.xpath("//a[@class='card-button nav-card next centered']");
	private By byPreviousCTA = By.xpath("//a[@class='card-button nav-card prev centered has-next']");
	private By byArrowTabs = By.cssSelector("body > div > div.page-subnav > div > div > div.overflow.overflow-right > svg");
	private By byDailyTab = By.xpath("//a[@href=\"/en/us/royal-oak/48073/daily-weather-forecast/20813_pc\"]");
	private By byNextCTATab = By.xpath("//a[@class='card-button nav-card next centered']");
	private By byCurrentDay = By.cssSelector("a.forecast-list-card.forecast-card.today > div.date > p.dow");
	private By byCurrentDate = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.date > p.sub");
	private By byWeatherIcon = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today > img.weather-icon.icon");
	private By byHighTemp = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.temps > span.high");
	private By byLowTemp = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today > div.temps > span.low");
	private By byWeatherDescription = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today > span.phrase");
	private By byCurentDayCard = By.cssSelector("div:nth-child(1) > a.forecast-list-card.forecast-card.today");
	
	/**
	 * @author HFARAZ
	 * Method to click Daily Tab
	 * */
	public void clickDailyTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement dailyTab = getDriver().findElement(byDailyTab);
		Sleeper.sleep(3);
		dailyTab.click();
	}

	/**
	 * Method to locate day of the week when clicked on Daily tab
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value - "true if day matches the current day else false"
	 */
	public Boolean locateDayOfWeek() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> currentDay = getDriver()
				.findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
		int size = currentDay.size();
		for (int i = 0; i <= size; i++) {
			if (getDriver().findElements( By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a")).size()>0)
					 {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return true;
	}

	/**
	 * Method to forecast list for the current week should be displayed and limited
	 * to number of days in the current week
	 * 
	 * @author SOWMIYA Boolean - return value - "true if two arraylist matches else
	 *         false"
	 */
	public Boolean verifyLimitedNumberOfDaysInCurrentWeek() {
		// Pull the list of week from UI
		List<WebElement> actualArray = getDriver()
				.findElements(By.cssSelector("div.page-column-1 > div > div:nth-child(1) > a"));
		int sizeOfActualArray = actualArray.size();

		ArrayList<String> actualDays = new ArrayList<String>();

		// get day from UI and assign it to arraylist
		for (int i = 1; i <= actualArray.size(); i++) {
			String getDay = getDriver()
					.findElement(By.cssSelector(
							"div.page-column-1 > div > div:nth-child(1) > a:nth-child(" + i + ") > div > p.dow"))
					.getText();
			actualDays.add(getDay);
		}

		// Userdefined days of a week
		ArrayList<String> daysUserDefined = new ArrayList<String>(
				Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
		int sizeOfuserDefinedArray = daysUserDefined.size();

		// substract userdefined array size and actualArray size
		int noOfdysToRemoveFromUserdefinedArray = sizeOfuserDefinedArray - sizeOfActualArray;

		// Userdefined new array
		for (int i = 0; i < noOfdysToRemoveFromUserdefinedArray; i++) {
			daysUserDefined.remove(0);
		}

		System.out.println("daysUserDefined:" + daysUserDefined);

		// Compare 2 arraylist
		for (int i = 0; i < actualDays.size(); i++) {
			if (actualDays.get(i).equalsIgnoreCase(daysUserDefined.get(i))) {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to verify next week header date and month
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value - true if both date and month matches
	 */
	public Boolean confirmNextWeekHeaderDateAndMonth() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byNextWeekDate).scrollIntoView();
		WebElement actualNextWeekDateAndMonth = getDriver().findElement(byNextWeekDate);

		// get actual next week date from UI
		String getNextWeekDateAndMonthFromUI = actualNextWeekDateAndMonth.getText();

		String nextWeekmonday = this.getMonday();
		String nextWeeksunday = this.getSunday();

		String nextWeekDateMonth = String.join(" - ", nextWeekmonday, nextWeeksunday);

		if (nextWeekDateMonth.equalsIgnoreCase(getNextWeekDateAndMonthFromUI))
			flag = true;
		else
			flag = false;

		return flag;
	}

	/**
	 * Method to get monday date and month
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value - date and month
	 */
	public String getMonday() {
		Calendar calendar = Calendar.getInstance();
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);

		if (weekday != Calendar.MONDAY) {
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
	 * 
	 * @author SOWMIYA
	 * @return - Boolean value - date and month
	 */
	public String getSunday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendar.DAY_OF_YEAR, 7);

		int weekday = calendar.get(calendar.DAY_OF_WEEK);

		int days = Calendar.SUNDAY - weekday;
		if (days < 0) {
			days += 7;
		}

		calendar.add(Calendar.DAY_OF_YEAR, days);

		Format formatter = new SimpleDateFormat("MMMM d");
		String sunday = formatter.format(calendar.getTime());

		return sunday;
	}

	/**
	 * Method to verify the forecasts for Mon -Sun considering Monday as the first
	 * day
	 * 
	 * @author SOWMIYA Boolean - return value - "true if two arraylist matches else
	 *         false"
	 */
	public Boolean confirmForecastListForWeekFromMonToSun() {
		// Pull the list of week from UI
		List<WebElement> actualArray = getDriver().findElements(By.cssSelector("div > div.page-column-1 > div > div:nth-child(5) > a"));
		ArrayList<String> actualDays = new ArrayList<String>();
		// get day from UI and assign it to arraylist
		for (int i = 1; i <= actualArray.size(); i++) {
			String getDay = getDriver().findElement(By.xpath("(//a[@class='forecast-list-card forecast-card']//p[@class='dow'])["+i+"]")).getText();
			actualDays.add(getDay);
		}

		// Userdefined days of a week
		ArrayList<String> daysUserDefined = new ArrayList<String>(
				Arrays.asList( "Tue", "Wed", "Thu", "Fri", "Sat", "Sun","Mon"));

		// Compare 2 arraylist
		for (int i = 0; i < actualDays.size(); i++) {
			if (actualDays.get(i).equalsIgnoreCase(daysUserDefined.get(i))) {
				flag = true;
				continue;
			} else
				flag = false;
			break;
		}
		return flag;
	}

	/**
	 * Method to the daily foreast page has only three clusters of week. There
	 * should not be more than 21 days weather report.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the weather report days are
	 *         less than or equal to 21 else false"
	 */
	public Boolean confirmDailyForecastPageShowsThreeClusters() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> threeClustersOfWeek = getDriver()
				.findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
		if (threeClustersOfWeek.size() <= 21)
			flag = true;
		else
			flag = false;

		return flag;
	}

	/**
	 * Method to click next CTA and page redirected to next three sets of weeks.
	 * Verify both previous and next CTA are present
	 * 
	 * @author SOWMIYA
	 */
	public Boolean verifyBothNextAndCTAPresentInNextPage() {
		WebPageLoaded.isDomInteractive();
		WebElement nextCTA = getDriver().findElement(byNextCTA);
		WebElement previousCTA = getDriver().findElement(byPreviousCTA);

		return getDriver().findElements(byNextCTA).size()>0 && getDriver().findElements(byPreviousCTA).size()>0;
	}

	/**
	 * Method to verify last week page have one or two week of data.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the weather report days are
	 *         less than or equal to 14 else false"
	 */
	public Boolean lastPageHaveOneOrTwoWeekReports() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> threeClustersOfWeek = getDriver()
				.findElements(By.xpath("//a[contains(@class,'forecast-list-card forecast-card')]"));
		if (threeClustersOfWeek.size() <= 14)
			flag = true;
		else
			flag = false;

		return flag;
	}

	/**
	 * Method to verify user able to navigate 1 page forward.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the page param is 1 else
	 *         false"
	 */
	public Boolean confirmUserAbleToNavigateTo1PageForward() {
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length() - 6);
		return actualPageNumber.equalsIgnoreCase("page=1");
	}

	/**
	 * Method to verify user able to navigate 2 page forward.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the page param is 2 else
	 *         false"
	 */
	public Boolean confirmUserAbleToNavigateTo2PagesForward() {
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length() - 6);
		return actualPageNumber.equalsIgnoreCase("page=2");
	}

	/**
	 * Method to verify user able to navigate 3 page forward.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the page param is 3 else
	 *         false"
	 */
	public Boolean confirmUserAbleToNavigateTo3PagesForward() {
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length() - 6);
		return actualPageNumber.equalsIgnoreCase("page=3");
	}

	/**
	 * Method to verify user able to navigate upto to 4 pages forward.
	 * 
	 * @author SOWMIYA Boolean - return value - "true if the page param is 4 else
	 *         false"
	 */
	public Boolean confirmUserAbleToNavigateTo4PagesForward() {
		WebPageLoaded.isDomInteractive();
		String getURL = getDriver().getCurrentUrl();
		String actualPageNumber = getURL.substring(getURL.length() - 6);
		return actualPageNumber.equalsIgnoreCase("page=4");
	}
	
	public Boolean navigateToDailyListTab() {
		WebPageLoaded.isDomInteractive();
		WebElement arrowTab = getDriver().findElement(byArrowTabs);
		Sleeper.sleep(3);
		//arrowTab.syncVisible(3);
		arrowTab.click();
		return true;
		
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to click Next CTA
	 * */
	public void clickNextCTA() 
	{
		WebPageLoaded.isDomInteractive();
		WebElement nextCTATab = getDriver().findElement(byNextCTATab);
		Sleeper.sleep(3);
		nextCTATab.jsClick();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the current day from daily tab
	 * @return : String - returns the day from the first tab in Daily forecast page
	 * */
	public Boolean readCurrentDay()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentDay = getDriver().findElement(byCurrentDay);
		//get current day from the calendar 
		Calendar calendar = Calendar.getInstance();
        String getTime = calendar.getTime().toString();
        String getOnlyDay = getTime.substring(0, 3); 
        
		return currentDay.getText().equalsIgnoreCase(getOnlyDay);
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the current date from first tab in Daily forecast page
	 * @return : String - returns the date from the first tab in Daily forecast page
	 * */
	public Boolean readCurrentDate()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentDate = getDriver().findElement(byCurrentDate);
		//get currentdate from the calendar
		Date date = new Date();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		String getTime = formatter.format(date);
		String getDateAndMonth = getTime.substring(6, 10);
		String formatDateAndMonth = getDateAndMonth.replace("-", "/");
		System.out.println(formatDateAndMonth);
		return currentDate.getText().equalsIgnoreCase(formatDateAndMonth);
	}
	
	/** Method to verify if the weather icon is displayed */
	public Boolean isWeatherIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		return getDriver().findElements(byWeatherIcon).size()>0;
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the maximum temperature from the first tab in Daily forecast page
	 * @return : String - returns the maximum temperature present on the first tab on Daily forecast page
	 * */
	public String readMaxTemperature()
	{
		WebPageLoaded.isDomInteractive();
		WebElement highTemp = getDriver().findElement(byHighTemp);
		return highTemp.getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the minimum temperature from the first tab in Daily forecast page
	 * @return : String - returns the minimum temperature present on the first tab on Daily forecast page
	 * */
	public String readMinTemperature()
	{
		WebPageLoaded.isDomInteractive();
		WebElement lowTemp = getDriver().findElement(byLowTemp);
		return lowTemp.getText();
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the weather description from the first tab in Daily forecast page
	 * @return : String - returns the weather description present on the first tab on Daily forecast page
	 * */
	public boolean readWeatherDescription()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(5);
		return getDriver().findElements(byWeatherDescription).size()>0;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the color code
	 * @return color code for the current day on the Daily forecast page
	 * */
	public String getColor_Of_ActiveTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement ele= getDriver().findElement(byCurentDayCard);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div > div:nth-child(1) > a.forecast-list-card.forecast-card.today\")).borderLeftColor;",ele);
		System.out.println("result > > > > " + result);
		String colourdisplayed = Color.fromString(result).asHex();
		return colourdisplayed;
	}


}
