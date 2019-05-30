package com.accuweather.glacier.www.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.date.SimpleDate;

public class HourlyForecastPage extends BasePage
{

	private By byHourlyForecastPage = By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(4)");

	private By byTime = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > div.date > p:nth-child(1)");

	private By byDate = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > div.date > p:nth-child(2)");

	private By byWeatherIcon = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > img.weather-icon.icon");

	private By byTemperature = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > div.temp");

	private By byWeatherText = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > span.phrase");

	private By byPrecipitation = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > div > div.precip");

	private By byExpandTabIcon = By.cssSelector(" div.two-column-page-content > div > div > div > div > div > svg.");

	private By byCompressTabIcon = By.cssSelector("");

	private By byRealFeelValue = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(1)");

	private By byWindValue = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(2)");

	private By byGustsValue = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(3)");

	private By byHumidityValue = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(4)");

	private By byDewPointValue = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(5)");

	private By byMaxUVIndex = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div.panel.left > p:nth-child(6)");

	private By byCloudCover = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(1)");

	private By byRain = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(2)");

	private By bySnow = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(3)");

	private By byIce = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(4)");

	private By byVisibility = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(5)");

	private By byCeiling = By.cssSelector(
			"div.two-column-page-content > div > div > div > div.accordion-item-content > div > div:nth-child(2) > p:nth-child(6)");

	private By byNextDay = By.cssSelector("div.navigation.content-module > a.card-button.nav-card.next.centered");

	private By byNextDayText = By
			.cssSelector("div.navigation.content-module > a.card-button.nav-card.next.centered > span.text");

	private By byRightArrowIcon = By.cssSelector(
			"div.navigation.content-module > a.card-button.nav-card.next.centered > div > svg.arrow.icon-chevron.icon-chevron-right");

	private By byLeftArrowIcon = By.cssSelector(
			"div.navigation.content-module > a.card-button.nav-card.prev.centered.has-next > div > svg.arrow.icon-chevron.icon-chevron-left");

	private By byUpArrowIcon = By.cssSelector(
			"div.two-column-page-content > div > div > div > div > div > svg.icon-chevron.icon-chevron.icon-chevron-up");

	private By byDownArrowIcon = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div > svg.icon-chevron.icon-chevron");

	private By byPreviousDayText = By
			.cssSelector("div.navigation.content-module > a.card-button.nav-card.prev.centered.has-next > span.text");

	private By byPreviousDay = By
			.cssSelector("div.navigation.content-module > a.card-button.nav-card.prev.centered.has-next");

	private By byLastDayCTATab = By.cssSelector(
			"div.two-column-page-content > div.page-column-1 > div.navigation.content-module > a.card-button.nav-card.prev.centered");
	private By byLastDayCTATabText = By.cssSelector(
			"div.two-column-page-content > div.page-column-1 > div.navigation.content-module > a.card-button.nav-card.prev.centered > span.text");

	private By byAccuWeatherLogo = By
			.cssSelector("div.main-menu > div > div.icon-text > a:nth-child(1) > svg.icon-logo");

	private By byCurrentHourTab = By
			.cssSelector("div.two-column-page-content > div > div > div > div > div.header-wrapper.card");

	private By byCurrentHourInfoTab = By.cssSelector(
			"div.two-column-page-content > div > div > div.accordion-item.hourly-forecast-card.hour > div.accordion-item-content > div.hourly-forecast-card-content.hourly-forecast-content");

	private By byTemperatureAtTheTop = By.cssSelector(
			"div.page-subheader.content-module > div.page-subheader-wrap > div.recent-locations-label > a.recent-location-display > span:nth-child(2)");

	private By byWeatherIconAtTheTop = By.cssSelector(
			"div.page-subheader.content-module > div.page-subheader-wrap > div.recent-locations-label > a.recent-location-display > img.weather-icon");

	private static final String ENVIRONMENT_URL_CONFIG_FILE = "EnvironmentURLs.properties";

	private Calendar calendar = Calendar.getInstance();

	SimpleDate day = new SimpleDate();
	private Boolean timeValidation;
	private Boolean dateValidation;

	public Boolean getTimeValidation()
	{
		return timeValidation;
	}

	public void setTimeValidation(Boolean timeValidation)
	{
		this.timeValidation = timeValidation;
	}

	public static String getEnvironmentUrlConfigFile()
	{

		return ENVIRONMENT_URL_CONFIG_FILE;

	}

	private static final String QA_URL = "ACCUWEATHER_WEB_QA";

	public static String getQaUrl()
	{

		return (String) get(QA_URL);

	}

	private static final Properties properties = new Properties();

	private Boolean currentHourInfoTabState;

	private Boolean hourlyTabURLState;

	private Boolean previousDayTextValidation = false;
	private Boolean nextDayTextValidation = false;

	static

	{

		try
		{

			loadProperties();

		}

		catch (IOException ioE)

		{

			ioE.printStackTrace();

		}

	}

	/** @author HFARAZ
	 * 
	 *         Method to load properties file **/

	public static void loadProperties() throws IOException

	{

		if (properties.size() > 0)

			return;

		InputStream in = HourlyForecastPage.class.getClassLoader().getResourceAsStream(ENVIRONMENT_URL_CONFIG_FILE);

		if (in == null)

			throw new FileNotFoundException(ENVIRONMENT_URL_CONFIG_FILE + " not found on classpath");

		properties.load(in);

	}

	public static Object get(String key)

	{

		return properties.getProperty(key);

	}

	public Boolean getHourlyTabURLState()
	{

		return hourlyTabURLState;

	}

	public void setHourlyTabURLState(Boolean hourlyTabURLState)
	{

		this.hourlyTabURLState = hourlyTabURLState;

	}

	public Boolean getCurrentHourInfoTabState()
	{

		return currentHourInfoTabState;

	}

	public void setCurrentHourInfoTabState(Boolean currentHourInfoTabState)
	{

		this.currentHourInfoTabState = currentHourInfoTabState;

	}

	/** @author HFARAZ
	 * 
	 *         Method to click on Hourly Tab */

	public void clickOnHourlyTab()

	{

		WebPageLoaded.isDomInteractive();

		WebElement hourlyTab = getDriver().findElement(byHourlyForecastPage);

		hourlyTab.syncVisible(15);

		hourlyTab.click();

	}

	/** Method to get the Hourly tab text */

	public String getHourlyTabText()

	{

		WebPageLoaded.isDomInteractive();

		WebElement hourlyTab = getDriver().findElement(byHourlyForecastPage);

		hourlyTab.syncVisible(15);

		return hourlyTab.getText();

	}

	/** Method to get the time */

	public String getTime()

	{

		WebPageLoaded.isDomInteractive();

		WebElement time = getDriver().findElement(byTime);

		time.syncVisible(15);

		return time.getText();

	}

	/** Method to get the date */

	public String getDate()

	{

		WebPageLoaded.isDomInteractive();

		WebElement date = getDriver().findElement(byDate);

		date.syncVisible(15);

		return date.getText();

	}

	/** Method to split the hour and AM/PM **/

	public String[] splitTime(String time)

	{

		String[] splitTime = time.split("\\s+");

		return splitTime;

	}

	/** Method to get the Temperature */

	public String getTemperature()

	{

		WebPageLoaded.isDomInteractive();

		WebElement temperature = getDriver().findElement(byTemperature);

		temperature.syncVisible(15);

		return temperature.getText();

	}

	/** Method to get Weather */

	public String getWeather()

	{

		WebPageLoaded.isDomInteractive();

		WebElement weatherCondition = getDriver().findElement(byWeatherText);

		weatherCondition.syncVisible(15);

		return weatherCondition.getText();

	}

	/** Method to get Precipitation */

	public String getPrecipitation()

	{

		WebPageLoaded.isDomInteractive();

		WebElement precipitation = getDriver().findElement(byPrecipitation);

		precipitation.syncVisible(15);

		return precipitation.getText();

	}

	/** Method to verify if the weather icon is displayed */

	public Boolean isWeatherIconDisplayed()

	{

		WebPageLoaded.isDomInteractive();

		WebElement weatherIcon = getDriver().findElement(byWeatherIcon);

		weatherIcon.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return weatherIcon.isDisplayed();

	}

	/** Method to verify if CTA is displayed and fetch the value */

	public String getCTA()

	{

		WebPageLoaded.isDomInteractive();

		WebElement cta = getDriver().findElement(byNextDayText);

		cta.syncVisible(15);

		return cta.getText();

	}

	/** Method to click CTA */

	public void clickCTATab()

	{

		WebPageLoaded.isDomInteractive();

		WebElement cta = getDriver().findElement(byNextDay);

		cta.syncVisible(15);

		cta.jsClick();

	}

	/** Method to verify if the ">" icon is displayed on CTA */

	public Boolean isRightArrowDisplayedOnCTA()

	{

		WebPageLoaded.isDomInteractive();

		WebElement rightArrowIcon = getDriver().findElement(byRightArrowIcon);

		rightArrowIcon.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return rightArrowIcon.isDisplayed();

	}

	/** Method to verify if current day is displayed and fetch the value */

	public String readPreviousDay()

	{

		WebPageLoaded.isDomInteractive();

		WebElement currentDay = getDriver().findElement(byPreviousDayText);

		currentDay.syncVisible(15);

		return currentDay.getText();

	}

	/** Method to read Last CTA Tab text */
	public String readLastCTATabtext()
	{
		WebPageLoaded.isDomInteractive();

		WebElement lastDayText = getDriver().findElement(byLastDayCTATabText);

		lastDayText.syncVisible(15);

		return lastDayText.getText();
	}

	/** Method to verify if current day is displayed and fetch the value */

	public void clickPreviousDay()

	{

		WebPageLoaded.isDomInteractive();

		WebElement previousDay = getDriver().findElement(byPreviousDay);

		previousDay.syncVisible(15);

		previousDay.jsClick();

	}

	/** Method to verify if current day is displayed and fetch the value */

	public void clickLastDayCTATab()

	{

		WebPageLoaded.isDomInteractive();

		WebElement previousDay = getDriver().findElement(byLastDayCTATab);

		previousDay.syncVisible(15);

		previousDay.jsClick();

	}

	/** Method to verify if the left arrow icon is displayed on current day tab */

	public Boolean isLeftArrowIconDisplayed()

	{

		WebPageLoaded.isDomInteractive();

		WebElement leftArrowIcon = getDriver().findElement(byLeftArrowIcon);

		leftArrowIcon.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return leftArrowIcon.isDisplayed();

	}

	/** Method to verify if next day is displayed and fetch the value */

	public String readNextDay()

	{

		WebPageLoaded.isDomInteractive();

		WebElement nextDay = getDriver().findElement(byNextDayText);

		nextDay.syncVisible(15);

		return nextDay.getText();

	}

	/** Method to verify if up arrow icon is displayed on the Hourly page */

	public Boolean isUpArrowIconDisplayed()

	{

		WebPageLoaded.isDomInteractive();

		WebElement upArrowIcon = getDriver().findElement(byUpArrowIcon);

		upArrowIcon.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return upArrowIcon.isDisplayed();

	}

	/** Method to verify if down arrow icon is displayed on the Hourly page */

	public Boolean isDownArrowIconDisplayed()

	{

		WebPageLoaded.isDomInteractive();

		WebElement downArrowIcon = getDriver().findElement(byDownArrowIcon);

		downArrowIcon.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return downArrowIcon.isDisplayed();

	}

	/** Method to verify all 24 Hour tabs are present in next page of Hourly tab */

	public Boolean isAllHourTabsPresent()

	{

		WebPageLoaded.isDomInteractive();

		int counter = 0;

		for (int i = 1; i <= 24; i++)

		{

			WebElement hourTab = getDriver()
					.findElement(By.cssSelector("div.two-column-page-content > div > div > div:nth-child(" + i + ")"));

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			if (hourTab.isDisplayed())

				counter++;

		}

		System.out.println(counter);

		if (counter == 24)

			return true;

		else

			return false;

	}

	/** Method to validate time on all the tabs */

	public Boolean isTheTimeCorrectOnEachTab()

	{

		WebPageLoaded.isDomInteractive();

		for (int i = 1; i <= 24; i++)

		{

			WebElement timeTab = getDriver().findElement(By.cssSelector(""));

		}

		return true;

	}

	/** Method to validate date on all the tabs */

	public Boolean isTheDateCorrectOnEachTab()

	{

		int counter = 0;

		WebPageLoaded.isDomInteractive();

		for (int i = 1; i <= 24; i++)

		{

			String dateTab = getDriver()
					.findElement(By.cssSelector("div.two-column-page-content > div > div > div:nth-child(" + i
							+ ") > div > div > div > div > p:nth-child(2)"))
					.getText();

			if (dateTab.equals(SimpleDate.getCurrentDate("M/d")))

				counter++;

		}

		if (counter == 24)

			return true;

		else

			return false;

	}

	/** Method to validate if Accuweather logo is displayed */

	public Boolean isAccuWeatherLogoDisplayed()

	{

		WebPageLoaded.isDomInteractive();

		WebElement accuWeatherLogo = getDriver().findElement(byAccuWeatherLogo);

		accuWeatherLogo.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return accuWeatherLogo.isDisplayed();

	}

	/** Method to validate if the tab is expanded for the first hour tab by
	 * default */

	public Boolean isCurrentHourTabExpanded_WhenFirstPageLoaded()

	{

		WebPageLoaded.isDomInteractive();

		WebElement currentHourInfoTab = getDriver().findElement(byCurrentHourInfoTab);

		currentHourInfoTab.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return currentHourInfoTab.isDisplayed();

	}

	/** Method to validate that by clicking on the first hour tab the Information
	 * tab
	 * below gets collapsed if it is in expanded mode */

	public void validateCurrentHour_InfoTab_Collapse_When_Clicked_On_CurrentHourTab()

	{

		WebPageLoaded.isDomInteractive();

		WebElement currentHourInfoTab = getDriver().findElement(byCurrentHourInfoTab);

		currentHourInfoTab.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (currentHourInfoTab.isDisplayed())

		{

			getDriver().findElement(byCurrentHourTab).jsClick();

			if (currentHourInfoTab.isDisplayed())

				setCurrentHourInfoTabState(true);

			else

				setCurrentHourInfoTabState(false);

		}

	}

	/** Method to validate that by clicking on the hour tab it expands if in
	 * collapsed mode and arrow becomes upward */

	public void validateCurrentHour_InfoTab_Expands_When_Clicked_On_CurrentHourTab()

	{

		WebPageLoaded.isDomInteractive();

		WebElement currentHourInfoTab = getDriver().findElement(byCurrentHourInfoTab);

		currentHourInfoTab.syncVisible(30);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (currentHourInfoTab.isDisplayed())

		{

			getDriver().findElement(byCurrentHourTab).jsClick();

			getDriver().findElement(byCurrentHourTab).jsClick();

			currentHourInfoTab.syncVisible(30);

			if (currentHourInfoTab.isDisplayed())

				setCurrentHourInfoTabState(true);

			else

				setCurrentHourInfoTabState(false);

		}

		else

		{

			getDriver().findElement(byCurrentHourTab).jsClick();

			currentHourInfoTab.syncVisible(30);

			if (currentHourInfoTab.isDisplayed())

				setCurrentHourInfoTabState(true);

			else

				setCurrentHourInfoTabState(false);

		}

	}

	/** Method to click current hour tab */
	public void clickCurrentHourTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentHourInfoTab = getDriver().findElement(byCurrentHourInfoTab);
		currentHourInfoTab.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().findElement(byCurrentHourTab).jsClick();
	}

	/** Method to get the color of the active tab */

	public String getColor_Of_ActiveTab()

	{

		WebPageLoaded.isDomInteractive();

		String color = getDriver().findElement(byHourlyForecastPage).getCssValue("border-top-color");

		return Color.fromString(color).asHex();

	}

	/** Method to get the color of the text in hour tab */

	public String getColorOfHourComponents()

	{

		WebPageLoaded.isDomInteractive();

		String color = getDriver().findElement(byHourlyForecastPage).getCssValue("border-top-color");

		return Color.fromString(color).asHex();

	}

	/** Method to validate day parameter in URL when next CTA is clicked */

	public void validateDayParamInURLForNextDay()

	{

		for (int i = 0; i <= 6; i++)

		{

			try

			{

				if (i == 0)

				{

					if ((getDriver().getCurrentUrl()
							.equals(getQaUrl() + "en/us/mc-farland/53558/hourly-weather-forecast/23238_pc")))
						;

					setHourlyTabURLState(true);

				}

				else

				{

					clickCTATab();

					if (getDriver().getCurrentUrl()
							.equals(getQaUrl() + "en/us/mc-farland/53558/hourly-weather-forecast/23238_pc?day=" + i))
						;

					setHourlyTabURLState(true);

				}

			}

			catch (AssertionError ae)

			{

				System.err.println(ae.getMessage());

				Assert.fail("URL not as expected for page " + i);

			}

		}

	}

	/** Method to validate day parameter in URL when previous day CTA is clicked */

	public void validateDayParamInURLForPreviousDay()

	{

		for (int i = 0; i < 6; i++)

		{

			clickCTATab();

		}

		for (int i = 6; i > 0; i--)

		{

			try

			{

				if (i == 6)

				{

					if (getDriver().getCurrentUrl()
							.equals(getQaUrl() + "en/us/mc-farland/53558/hourly-weather-forecast/23238_pc?day=" + i))
					{
						setHourlyTabURLState(true);
						clickLastDayCTATab();
					}

				}

				else

				{

					if (getDriver().getCurrentUrl()
							.equals(getQaUrl() + "en/us/mc-farland/53558/hourly-weather-forecast/23238_pc?day=" + i))
					{
						clickPreviousDay();
						setHourlyTabURLState(true);
					}

				}

			}

			catch (AssertionError ae)

			{

				System.err.println(ae.getMessage());

				Assert.fail("URL not as expected for page " + i);

			}

		}

	}

	/** Method to click on Weather Icon at the top **/

	public void clickWeatherIconAtTheTop()

	{

		WebPageLoaded.isDomInteractive();

		WebElement weatherIcon = getDriver().findElement(byWeatherIconAtTheTop);

		weatherIcon.syncVisible(15);

		weatherIcon.jsClick();

	}

	/** Method to click on Temperature at the top */

	public void clickTemperatureIconAtTheTop()

	{

		WebPageLoaded.isDomInteractive();

		WebElement temperatureIcon = getDriver().findElement(byTemperatureAtTheTop);

		temperatureIcon.syncVisible(15);

		temperatureIcon.jsClick();

	}

	/** @author HFARAZ
	 * 
	 *         Method to get the next day for previous day tabs */

	public String getNextDay(int pageNo)

	{

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		int nextDay = today + (pageNo - 1);
		if (nextDay > 7)
			nextDay = nextDay - 7;

		String dayOfTheWeek = "";

		switch (nextDay)
		{

		case Calendar.SUNDAY:

			dayOfTheWeek = "SUNDAY";

			break;

		case Calendar.MONDAY:

			dayOfTheWeek = "MONDAY";

			break;

		case Calendar.TUESDAY:

			dayOfTheWeek = "TUESDAY";

			break;

		case Calendar.WEDNESDAY:

			dayOfTheWeek = "WEDNESDAY";

			break;

		case Calendar.THURSDAY:

			dayOfTheWeek = "THURSDAY";

			break;

		case Calendar.FRIDAY:

			dayOfTheWeek = "FRIDAY";

			break;

		case Calendar.SATURDAY:

			dayOfTheWeek = "SATURDAY";

			break;

		}

		return dayOfTheWeek;

	}

	/** @author HFARAZ
	 * 
	 *         Method to get the next day for next day tabs */

	public String getNextDay_ForCTATab(int pageNo)

	{

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		int nextDay = today + (pageNo);

		String dayOfTheWeek = "";
		if (nextDay > 7)
			nextDay = nextDay - 7;

		switch (nextDay)
		{

		case Calendar.SUNDAY:

			dayOfTheWeek = "SUNDAY";

			break;

		case Calendar.MONDAY:

			dayOfTheWeek = "MONDAY";

			break;

		case Calendar.TUESDAY:

			dayOfTheWeek = "TUESDAY";

			break;

		case Calendar.WEDNESDAY:

			dayOfTheWeek = "WEDNESDAY";

			break;

		case Calendar.THURSDAY:

			dayOfTheWeek = "THURSDAY";

			break;

		case Calendar.FRIDAY:

			dayOfTheWeek = "FRIDAY";

			break;

		case Calendar.SATURDAY:

			dayOfTheWeek = "SATURDAY";

			break;

		}

		return dayOfTheWeek;

	}

	/** Method to validate previous days on previous CTA tabs */
	public void validatePreviousDays()
	{
		for (int i = 0; i <= 6; i++)
		{
			try
			{
				if (i == 0)
					clickCTATab();
				else
				{
					if (i == 1)
					{
						if (readPreviousDay().equals(day.getCurrentDay()))
						{
							setPreviousDayTextValidation(true);
							clickCTATab();
						}

					}
					else
					{
						if (i != 6)
						{
							if (readPreviousDay().equals(getNextDay(i)))
							{
								setPreviousDayTextValidation(true);
								clickCTATab();
							}

						}
						else
						{
							if (readLastCTATabtext().equals(getNextDay(i)))
								setPreviousDayTextValidation(true);
						}
					}
				}
			}
			catch (AssertionError ae)
			{
				setPreviousDayTextValidation(false);
				Assert.fail("Previous day not matching on page " + i);

			}
			catch (Exception e)
			{
				e.getMessage();
			}
		}

	}

	/** Method to validate next days on next CTA tabs */
	public void validateNextDays()
	{
		for (int i = 1; i <= 6; i++)
		{
			try
			{
				Assert.assertEquals(readNextDay(), getNextDay_ForCTATab(i));
				setNextDayTextValidation(true);
				clickCTATab();

			}
			catch (AssertionError ae)
			{
				setNextDayTextValidation(false);
				Assert.fail("Next day not matching on page " + i);

			}
		}

	}

	/** Method to validate if RealFeel is displayed in expanded hour component */
	public Boolean isRealFeelDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement realFeel = getDriver().findElement(byRealFeelValue);
		realFeel.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return realFeel.isDisplayed();

	}

	/** Method to validate if Wind is displayed in expanded hour component */
	public Boolean isWindDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement wind = getDriver().findElement(byWindValue);
		wind.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return wind.isDisplayed();

	}

	/** Method to validate if Gusts is displayed in expanded hour component */
	public Boolean isGustsDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement gusts = getDriver().findElement(byGustsValue);
		gusts.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return gusts.isDisplayed();

	}

	/** Method to validate if Humidity is displayed in expanded hour component */
	public Boolean isHumidityDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement humidity = getDriver().findElement(byHumidityValue);
		humidity.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return humidity.isDisplayed();

	}

	/** Method to validate if Dew Point is displayed in expanded hour component */
	public Boolean isDewPointDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement dewPoint = getDriver().findElement(byDewPointValue);
		dewPoint.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return dewPoint.isDisplayed();

	}

	/** Method to validate if Max UV Index is displayed in expanded hour
	 * component */
	public Boolean isMaxUVIndexDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement maxUVIndex = getDriver().findElement(byMaxUVIndex);
		maxUVIndex.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return maxUVIndex.isDisplayed();

	}

	/** Method to validate if Cloud Cover is displayed in expanded hour component */
	public Boolean isCloudCOverDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement cloudCover = getDriver().findElement(byCloudCover);
		cloudCover.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return cloudCover.isDisplayed();

	}

	/** Method to validate if Rain is displayed in expanded hour component */
	public Boolean isRainDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rain = getDriver().findElement(byRain);
		rain.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return rain.isDisplayed();

	}

	/** Method to validate if Snow is displayed in expanded hour component */
	public Boolean isSnowDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement snow = getDriver().findElement(bySnow);
		snow.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return snow.isDisplayed();

	}

	/** Method to validate if Ice is displayed in expanded hour component */
	public Boolean isIceDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement ice = getDriver().findElement(byIce);
		ice.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return ice.isDisplayed();

	}

	/** Method to validate if Visibility is displayed in expanded hour component */
	public Boolean isVisibilityDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement visibility = getDriver().findElement(byVisibility);
		visibility.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return visibility.isDisplayed();

	}

	/** Method to validate if Ceiling is displayed in expanded hour component */
	public Boolean isCeilingDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement ceiling = getDriver().findElement(byCeiling);
		ceiling.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return ceiling.isDisplayed();

	}

	public Boolean getPreviousDayTextValidation()
	{
		return previousDayTextValidation;
	}

	public void setPreviousDayTextValidation(Boolean previousDayTextValidation)
	{
		this.previousDayTextValidation = previousDayTextValidation;
	}

	public Boolean getNextDayTextValidation()
	{
		return nextDayTextValidation;
	}

	public void setNextDayTextValidation(Boolean nextDayTextValidation)
	{
		this.nextDayTextValidation = nextDayTextValidation;
	}

	/** Method for getting time for all hour tabs present on first page */
	public String getTimeForAllTabs(int i)
	{
		WebPageLoaded.isDomInteractive();
		WebElement time = getDriver()
				.findElement(By.cssSelector("div.two-column-page-content > div > div > div:nth-child(" + i
						+ ") > div > div > div > div.date > p:nth-child(1)"));
		time.syncVisible(15);
		return time.getText();

	}

	/** Method for getting date for all hour tabs present on first page */
	public String getDateForAllTabs(int i)
	{
		WebPageLoaded.isDomInteractive();
		WebElement date = getDriver()
				.findElement(By.cssSelector("div.two-column-page-content > div > div > div:nth-child(" + i
						+ ") > div > div > div > div.date > p:nth-child(2)"));
		date.syncVisible(15);
		return date.getText();

	}

	public void validateTimeForAllHourTabs()
	{
		int startTime = 0;
		int currentHour = day.getHour();
		int totalTabs = 0;
		int counter = 0;

		if (currentHour > 12)
		{
			startTime = currentHour - 12;
			totalTabs = 24 - currentHour;
			counter = startTime;
		}
		else
		{
			if (currentHour == 0)
			{
				startTime = 12;
				totalTabs = 24 - currentHour;
				counter = startTime;
			}
			else if (currentHour == 12)
			{
				startTime = 12;
				totalTabs = 24 - currentHour;
				counter = startTime;
			}
			else
			{
				startTime = currentHour;
				totalTabs = 24 - startTime;
				counter = startTime;
			}

		}

		if (totalTabs >= 6)
		{
			for (int i = 1; i <= totalTabs; i++)
			{

				if (i == 1)
				{
					if (counter < 12)
					{
						if (getTimeForAllTabs(i).equals(counter + " AM"))
						{
							setTimeValidation(true);
							counter++;
						}
						else
						{
							setTimeValidation(false);
						}

					}
					else
					{
						if (counter == 12)
						{
							if (getTimeForAllTabs(i).equals(counter + " PM"))
							{
								setTimeValidation(true);
								counter++;
							}
							else
							{
								setTimeValidation(false);
							}
						}
						else
						{
							if (getTimeForAllTabs(i).equals(counter - 12 + " PM"))
							{
								setTimeValidation(true);
								counter++;
							}
							else
							{
								setTimeValidation(false);
							}
						}
					}

				}
				else
				{
					if (counter < 12)
					{
						if (getTimeForAllTabs(i).equals(counter + " AM"))
						{
							setTimeValidation(true);
							counter++;
						}
						else
						{
							setTimeValidation(false);
						}
					}
					else
					{
						if (counter == 12)
						{
							if (getTimeForAllTabs(i).equals(12 + " PM"))
							{
								setTimeValidation(true);
								counter++;
							}
							else
							{
								setTimeValidation(false);
							}
						}
						else
						{
							if (getTimeForAllTabs(i).equals(counter - 12 + " PM"))
							{
								setTimeValidation(true);
								counter++;
							}
							else
							{
								setTimeValidation(false);
							}
						}

					}

				}
			}
		}
		else
		{
			for (int i = 1; i <= 6; i++)
			{
				if (i <= totalTabs)
				{
					if (getTimeForAllTabs(i).equals(counter + " PM"))
					{
						setTimeValidation(true);
						counter++;
					}
					else
					{
						setTimeValidation(false);
					}
				}
				else
				{
					if (counter > 12)
					{
						if (getTimeForAllTabs(i).equals(counter - 12 + " AM"))
						{
							setTimeValidation(true);
							counter++;
						}
						else
						{
							setTimeValidation(false);
						}
					}
					else
					{
						if (getTimeForAllTabs(i).equals(counter + " AM"))
						{
							setTimeValidation(true);
							counter++;
						}
						else
						{
							setTimeValidation(false);
						}
					}

				}
			}
		}

	}

	public void validateDateForAllHourTabs()
	{
		int startTime = 0;
		int currentHour = day.getHour();
		int totalTabs = 0;
		int counter = 0;

		if (currentHour > 12)
		{
			startTime = currentHour - 12;
			totalTabs = 24 - currentHour;
			counter = startTime;
		}
		else
		{
			if (currentHour == 0)
			{
				startTime = 12;
				totalTabs = 24 - currentHour;
				counter = startTime;
			}
			else if (currentHour == 12)
			{
				startTime = 12;
				totalTabs = 24 - currentHour;
				counter = startTime;
			}
			else
			{
				startTime = currentHour;
				totalTabs = 24 - startTime;
				counter = startTime;
			}

		}

		if (totalTabs >= 6)
		{
			for (int i = 1; i <= totalTabs; i++)
			{

				if (i == 1)
				{
					if (counter < 12)
					{
						if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
						{
							setDateValidation(true);
							counter++;
						}
						else
						{
							setDateValidation(false);
						}

					}
					else
					{
						if (counter == 12)
						{
							if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
							{
								setDateValidation(true);
								counter++;
							}
							else
							{
								setDateValidation(false);
							}
						}
						else
						{
							if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
							{
								setDateValidation(true);
								counter++;
							}
							else
							{
								setDateValidation(false);
							}
						}
					}

				}
				else
				{
					if (counter < 12)
					{
						if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
						{
							setDateValidation(true);
							counter++;
						}
						else
						{
							setDateValidation(false);
						}
					}
					else
					{
						if (counter == 12)
						{
							if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
							{
								setDateValidation(true);
								counter++;
							}
							else
							{
								setDateValidation(false);
							}
						}
						else
						{
							if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
							{
								setDateValidation(true);
								counter++;
							}
							else
							{
								setDateValidation(false);
							}
						}

					}

				}
			}
		}
		else
		{
			for (int i = 1; i <= 6; i++)
			{
				if (i <= totalTabs)
				{
					if (getDateForAllTabs(i).equals(day.getCurrentDate("M/d")))
					{
						setDateValidation(true);
						counter++;
					}
					else
					{
						setDateValidation(false);
					}
				}
				else
				{
					if (counter > 12)
					{
						if (getDateForAllTabs(i).equals(day.getTomorrowDate("M/d")))
						{
							setDateValidation(true);
							counter++;
						}
						else
						{
							setDateValidation(false);
						}
					}
					else
					{
						if (getDateForAllTabs(i).equals(day.getTomorrowDate("M/d")))
						{
							setDateValidation(true);
							counter++;
						}
						else
						{
							setDateValidation(false);
						}
					}

				}
			}
		}

	}

	public Boolean getDateValidation()
	{
		return dateValidation;
	}

	public void setDateValidation(Boolean dateValidation)
	{
		this.dateValidation = dateValidation;
	}

}
