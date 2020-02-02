package com.accuweather.glacier.m.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;
import com.chameleon.utils.date.SimpleDate;

public class MonthlyForeCastPageMobile extends BasePage {
	private int i;
	int r;
	int g;
	int b;
	int noOfdates;
	boolean isDisplayed;
	boolean bordercolor;
	boolean gridviewicon;
	boolean listviewicon;
	boolean allactivedaypanel;
	boolean activedaypanel;
	boolean activedatedaypanel;
	boolean episodetitles;
	boolean alldays;
	boolean monthlynav;
	boolean today;
	boolean blueline;
	boolean episodetitle;
	boolean activedatesdaypanel;
	boolean orangedottedline;
	boolean orangeline;
	boolean listalldays;
	boolean listalltemp;
	boolean activedatesweathericon;
	boolean nonactiveavghighlowtemp;
	boolean nonactivelowtemp;
	boolean nonactivehightemp;
	boolean nonactivespanlist;
	boolean listofweekdaysofmonth;
	boolean listofdaysmonth;
	boolean listofdaysweek;
	String color;
	String hex;
	String[] numbers;
	String gridcolor;
	String[] arrColor;
	String nonactivespantext;
	String substringyearname;
	String listviewyear;
	String listviewmonth;
	String substringmonthname;
	public static final String MONTHS[] = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	List<String> addalldays = new ArrayList<>();
	List<String> nonactivespan = new ArrayList<>();
	List<String> listofalldaysweek = new ArrayList<>();
	private By byAWLogo = By.cssSelector(
			"body > div > div.component-sticky-container.header > div > div.main-menu-wrapper > div > div.logo-wrapper > div > a > img");
	private By byGridViewRightArrow = By
			.cssSelector("div.monthly-tools > div.card-button.monthly-nav.centered > a.arrow-wrap.is-next > svg");
	private By byGridViewLeftArrow = By
			.cssSelector("div.monthly-tools > div.card-button.monthly-nav.centered > a:nth-child(1) > svg");
	private By byListViewGridIcon = By.cssSelector("div.monthly-tools > div.layout-selector > a:nth-child(2)");
	private By byListViewIcon = By.cssSelector("div.layout-selector > a:nth-child(2) > svg > path");
	private By byGridViewIconSelected = By
			.cssSelector("div.page-column-1 > div > div.monthly-tools > div.layout-selector > a.grid-button");
	private By byListViewIconSelected = By.cssSelector("div.monthly-tools > div.layout-selector > a:nth-child(2)");
	private By byGridViewMonthYearText = By.cssSelector(
			"div.two-column-page-content > div.page-column-1 > div > div.monthly-tools > div.card-button.monthly-nav.centered > span");
	private By byGridViewTodayMonthPanel = By.xpath("//a[@class='monthly-daypanel is-today']");
	private By byGridIconColor = By.cssSelector("div.layout-selector > a.grid-button > svg > g > path.p2");
	private By byAllCurrentMonthDate = By
			.xpath("//div[1]/div[2]/div[2]/a/div[contains(@class,'date') and not(contains(.,'/'))]");
	private By byAllActiveDayPanel = By.xpath(
			"//div[@class='monthly-grid-container monthly-component']/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))]");
	private By byAllActiveDayPanelIndex = By.xpath(
			"//div[@class='monthly-grid-container monthly-component']/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))]["
					+ i + "]");
	private By byAllActiveDatesInDayPanelIndex = By
			.xpath("//div[5]/div[1]/div[2]/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))][" + i
					+ "]/div[contains(@class,'date')and not(contains(.,'/'))]");
	private By byAllNonActivePastDates = By.xpath(
			"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]");
	private By byAllTempOnTempGraph = By.cssSelector("div.temp-graph > div.chart-container > div.left-column > svg");
	private By byAllDaysOnTempGraph = By.cssSelector(
			"div.page-column-1 > div > div.temp-graph > div.chart-container > div.chart > svg > g.x-labels");
	private By byOrangeThinLineOnTempGraph = By
			.cssSelector("div.page-column-1 > div.temp-graph > div.chart-legend > div:nth-child(1) > svg > line");
	private By byOrangeThickLineOnTempGraph = By
			.cssSelector("div.page-column-1 > div > div.temp-graph > div.chart-legend > div:nth-child(2) > svg > line");
	private By byOrangeDottedLineOnTempGraph = By
			.cssSelector("div.temp-graph > div.chart-legend > div:nth-child(3) > svg > line");
	private By byBlueThinLineOnTempGraph = By
			.cssSelector("div.temp-graph > div.chart-legend > div:nth-child(4) > svg > line");
	private By byBlueThickLineOnTempGraph = By
			.cssSelector("div.temp-graph > div.chart-legend > div:nth-child(5) > svg > line");
	private By byBlueDottedLineOnTempGraph = By
			.cssSelector("div.temp-graph > div.chart-legend > div:nth-child(6) > svg > line");
	private By byTodayMarkerOnTempGraph = By.cssSelector(
			"div.page-column-1 > div > div.temp-graph > div.chart-container > div.chart > svg > g.indicator > text");
	private By byBottomMonthlyNavOnGridView = By
			.cssSelector("div.page-column-1 > div >  div.card-button.monthly-nav.content-module.centered");
	private By byTopMonthlyNavOnGridView = By
			.cssSelector("div.page-column-1 > div > div.monthly-tools > div.card-button.monthly-nav.centered");
	private By byListViewAllDaysOfWeek = By
			.cssSelector("div.page-column-1 > div.monthly-component > a > div.date > p.dow");
	private By byListViewAllDaysOfMonth = By
			.cssSelector("div.page-column-1 > div.monthly-component > a > div.date > p.sub");
	private By byListViewCurrentMonthYear = By
			.cssSelector("div.page-column-1 > div > div.monthly-tools > div.card-button.monthly-nav.centered > span");
	private By byGridViewAllDaysOfWeek = By.cssSelector(
			"body > div.template-root > div.two-column-page-content > div.page-column-1 > div.monthly-grid-container.monthly-component > div.monthly-header > div");

	private By byMonthDropDown = By.cssSelector(
			"div.monthly-tools > div.card-button.monthly-nav.centered > div > div:nth-child(1) > div.displayed-item > svg");
	private By ByYearDropDown = By
			.cssSelector("div.card-button.monthly-nav.centered > div > div:nth-child(2) > div.displayed-item > svg");

	private By byYearDropDownPastYear = By.cssSelector(
			"div.template-root:nth-child(1) div.two-column-page-content div.page-column-1 div.content-module div.monthly-tools div.card-button.monthly-nav.centered div.date-buttons div.dropdown:nth-child(2) div.items.active a.item:nth-child(1) > span:nth-child(1)");
	private By ByyearDisplayed = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.monthly-tools > div.card-button.monthly-nav.centered > div > div:nth-child(2) > div.displayed-item > span");
	private SimpleDate simpledate = new SimpleDate();

	/*
	 * 
	 * Method to click On Right Arrow under Grid View of the AW Monthly Forecast
	 * page
	 * 
	 */
	public void clickOnRightArrowLink() {
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byGridViewLeftArrow).scrollIntoView();
		getDriver().findElement(byGridViewRightArrow).click();
	}

	/*
	 * 
	 * Method to click On Left Arrow on the AW Monthly Forecast page
	 * 
	 */
	public void clickOnLeftArrowLink() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byGridViewLeftArrow).scrollIntoView();
		WebElement leftarrowlink = getDriver().findElement(byGridViewLeftArrow);
		leftarrowlink.hover();
		leftarrowlink.click();
	}

	/*
	 * 
	 * Method to get Substring of Month from Month Year Span
	 * 
	 * under Grid View on AW Monthly Forecast page
	 * 
	 */
	public String getGridViewMonthSubString() {
		WebPageLoaded.isDomInteractive(5);
		final WebElement gridviewmonthText = getDriver().findElement(byGridViewMonthYearText);
		String gridviewmonth = gridviewmonthText.getText();
		String substringmonthname = gridviewmonth.substring(0, gridviewmonth.length() - 4).trim();
		return substringmonthname;
	}

	/*
	 * 
	 * Method to get the color of the Active Date
	 * 
	 * under Grid View on AW Monthly Forecast page
	 * 
	 */
	public String getColorOfTodayDate() {
		WebPageLoaded.isDomInteractive();
		final WebElement gridviewtodaymonthcolor = getDriver().findElement(byGridViewTodayMonthPanel);
		color = gridviewtodaymonthcolor.getCssValue("border-bottom-color");
		hex = Color.fromString(color).asHex();
		numbers = color.replace("rgb(", "").replace(")", "").split(",");
		r = Integer.parseInt(numbers[0].trim());
		g = Integer.parseInt(numbers[1].trim());
		b = Integer.parseInt(numbers[2].trim());
		hex = String.format("#%02x%02x%02x", r, g, b);
		return hex;
	}

	/*
	 * 
	 * Method to verify border color is displayed in Orange color for Current Date
	 * Monthly forecast
	 * 
	 * under Grid View on AW Monthly Forecast page
	 * 
	 */
	public boolean isOrangeBorderColorDislayed() {
		WebElement we = getDriver().findElement(byGridViewTodayMonthPanel);
		isDisplayed = we.syncAttributeContainsValue("border-bottom-width", "4px", 15);
		return isDisplayed;
	}

	public boolean isOrangeBordersColorDislayed() {
		bordercolor = true;
		final WebElement test = getDriver().findElement(byGridViewTodayMonthPanel);
		test.syncAttributeContainsValue("href", "?day=0");
		return bordercolor;
	}

	/*
	 * 
	 * Method to get the Hex color of Date
	 * 
	 */
	public String getcolorofDateBottom() {
		WebPageLoaded.isDomInteractive();
		WebElement ele = getDriver().findElement(byGridViewTodayMonthPanel);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.monthly-grid-container.monthly-component > div.monthly-grid > a.monthly-daypanel.is-today\")).borderBottomColor;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/*
	 * 
	 * Method to verify Gird Icon is displayed under Monthly forecast Page
	 * 
	 * 
	 * 
	 */
	public boolean isGridIconDislayed() {
		getDriver().findElement(byListViewGridIcon).syncVisible();
		return getDriver().findElements(byListViewGridIcon).size() > 0;
	}

	/*
	 * 
	 * Method to verify List view Icon is displayed under Monthly forecast Page
	 * 
	 * 
	 * 
	 */
	public boolean isListViewIconDislayed() {
		return getDriver().findElements(byListViewIcon).size() > 0;
	}

	/*
	 * 
	 * Method to get Hex value of Grid Icon color under Monthly forecast Page
	 * 
	 */
	public String getGridIconColor() {
		WebPageLoaded.isDomInteractive(5);
		WebElement ele = getDriver().findElement(byGridIconColor);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div:nth-child(4) > div > div.page-column-1 > div > div.monthly-tools > div.layout-selector > a.grid-button > svg > g > path.p2\")).fill;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/*
	 * 
	 * Method to verify Grid Icon color under Monthly forecast Page
	 * 
	 */
	public boolean isGridIconColorDisplayed() {
		WebPageLoaded.isDomInteractive();
		final WebElement gridviewtodaymonthcolor = getDriver().findElement(byGridIconColor);
		gridcolor = gridviewtodaymonthcolor.getCssValue("fill");
		arrColor = gridcolor.split("#");
		return arrColor[1].equals("f59721");
	}

	/*
	 * 
	 * Method to verify All Active Day Panel Is Displayed under Monthly forecast
	 * Page
	 * 
	 */
	public boolean isActiveDayPanelDisplayed() {
		allactivedaypanel = true;
		for (i = 1; i > getActiveDayPanelSize(); i--) {
			WebPageLoaded.isDomInteractive();
			activedaypanel = getDriver().findElements(byAllActiveDayPanelIndex).size() > 0;
		}

		return allactivedaypanel;
	}

	/*
	 * 
	 * Method to get size of All Active Day Panel Is Displayed under Monthly
	 * forecast Page
	 * 
	 */
	public int getActiveDayPanelSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> activedaypanel = getDriver().findElements(byAllActiveDayPanel);
		return activedaypanel.size();
	}

	/*
	 * 
	 * Method to get size of All Non Active Day Panel Is Displayed under Monthly
	 * forecast Page
	 * 
	 */
	public int getNonActiveDayPanelSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> nonactivedaypanel = getDriver().findElements(byAllNonActivePastDates);
		return nonactivedaypanel.size();
	}

	/*
	 * 
	 * Method to get size for current month under Monthly forecast Page
	 * 
	 */
	public int getCurrentMonthDatesSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> currentmonthsize = getDriver().findElements(byAllCurrentMonthDate);
		return currentmonthsize.size();
	}

	/*
	 * 
	 * Method to verify All Active Day Panel Is Displayed under Monthly forecast
	 * Page
	 * 
	 */
	public boolean isActiveDaysPanelDisplayed() {
		WebPageLoaded.isDomInteractive();
		episodetitle = true;
		for (int i = 1; i > 27; i--) {
			@SuppressWarnings("unused")
			boolean episodetitles = getDriver().findElement(byAllActiveDayPanelIndex).isDisplayed();
		}

		return episodetitle;
	}

	/*
	 * 
	 * Method to verify All Active Dates of Day Panel Is Displayed under Monthly
	 * forecast Page
	 * 
	 */
	public boolean isActiveDatesOfDaysPanelDisplayed() {
		WebPageLoaded.isDomInteractive();
		activedatesdaypanel = true;
		for (int i = 1; i > getActiveDayPanelSize(); i--) {
			@SuppressWarnings("unused")
			boolean activedatedaypanel = getDriver().findElements(byAllActiveDatesInDayPanelIndex).size() > 0;
		}

		return activedatesdaypanel;
	}

	/*
	 * 
	 * Method to get List of all Dates for Active Dates of Day Panel under Monthly
	 * forecast Page
	 * 
	 */
	public List<String> getListOfDateForActiveDays() {
		WebPageLoaded.isDomInteractive();
		String alldays;
		List<WebElement> alldates = getDriver().findElements(By.xpath(
				"//div[5]/div[1]/div[2]/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))]/div[contains(@class,'date')and not(contains(.,'/'))]"));
		noOfdates = alldates.size() + 1;
		for (int i = 1; i < noOfdates; i++) {
			WebElement alldate = getDriver().findElement(
					By.xpath("//div[5]/div[1]/div[2]/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))][" + i
							+ "]/div[contains(@class,'date')and not(contains(.,'/'))]"));
			alldays = alldate.getText();
			addalldays.add(alldays);
		}

		return addalldays;
	}

	/*
	 * 
	 * Method to get List of all Dates for Active Dates of Day Panel Is Displayed
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isAllActiveCurrentMnthRemainingDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		alldays = true;
		List<WebElement> alldates = getDriver().findElements(By.xpath(
				"//div[5]/div[1]/div[2]/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))]/div[contains(@class,'date')and not(contains(.,'/'))]"));
		noOfdates = alldates.size() + 1;
		for (int i = 1; i < noOfdates; i++) {
			boolean value = getDriver().findElements(
					By.xpath("//div[5]/div[1]/div[2]/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))][" + i
							+ "]/div[contains(@class,'date')and not(contains(.,'/'))]"))
					.size() > 0;

		}

		return alldays;
	}

	/*
	 * 
	 * Method to get List of all Span Text for Non Active Dates of Day Panel under
	 * Monthly forecast Page
	 * 
	 */
	public List<String> getListOfSpanTextForNonActiveDays() {
		WebPageLoaded.isDomInteractive();
		String nonactivespantext;
		for (int i = 1; i < getNonActiveDayPanelSize() + 1; i++) {
			WebElement span = getDriver().findElement(By.xpath(
					"//div[1]/div[2]/div[2]/a[(contains(@class,'monthly-daypanel is-past'))][" + i + "]/div[2]/span"));
			System.out.println("span span span..." + span);
			nonactivespantext = span.getText();
			nonactivespan.add(nonactivespantext);
		}

		return nonactivespan;
	}

	/*
	 * 
	 * Method to get Last Span Text for Non Active Dates of Day Panel under Monthly
	 * forecast Page
	 * 
	 */
	public String getLastSpanTextForNonActiveDays() {
		WebPageLoaded.isDomInteractive();
		String nonactivespantext;
		i = getNonActiveDayPanelSize();
		WebElement span = getDriver().findElement(By.xpath(
				"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]["
						+ i + "]/div[2]/span"));
		nonactivespantext = span.getText();
		return nonactivespantext;
	}

	/*
	 * 
	 * Method to verify List of Actual Temp Span Text is displayed for Non Active
	 * Dates of Day Panel
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isListOfSpanTextForNonActiveDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		nonactivespanlist = true;
		for (int i = 1; i < getNonActiveDayPanelSize() + 1; i++) {
			WebElement span = getDriver().findElement(By.xpath(
					"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]["
							+ i + "]/div[2]/span"));
			nonactivespanlist = span.syncVisible(10);
		}

		return nonactivespanlist;
	}

	/*
	 * 
	 * Method to verify List of Actual High Temperature is displayed for Non Active
	 * Dates of Day Panel
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isListOfActualHightempForNonActiveDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		nonactivehightemp = true;
		Boolean value = null;
		for (int i = 1; i < getNonActiveDayPanelSize() + 1; i++) {
			value = getDriver().findElements(By.xpath(
					"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]["
							+ i + "]/div[3]/div[1]"))
					.size() > 0;

		}

		return value;
	}

	/*
	 * 
	 * Method to verify List of Actual Low Temperature is displayed for Non Active
	 * Dates of Day Panel
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isListOfActualLowtempForNonActiveDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		nonactivelowtemp = true;
		Boolean value;
		for (int i = 1; i < getNonActiveDayPanelSize() + 1; i++) {
			value = getDriver().findElements(By.xpath(
					"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]["
							+ i + "]/div[3]/div[2]"))
					.size() > 0;
			nonactivelowtemp = value;
		}

		return nonactivelowtemp;
	}

	/*
	 * 
	 * Method to verify List of Actual Average High and Low Temperature is displayed
	 * 
	 * for Non Active Dates of Day Panel under Monthly forecast Page
	 * 
	 */
	public boolean isListOfActualAvgHighLowtempForNonActiveDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		nonactiveavghighlowtemp = true;
		for (int i = 1; i < getNonActiveDayPanelSize() + 1; i++) {
			WebElement span = getDriver().findElement(By.xpath(
					"//div[@class='monthly-grid-container monthly-component']/div[2]/a[(contains(@class,'monthly-daypanel is-past'))]["
							+ i + "]/div[4]/div[2]"));
			nonactiveavghighlowtemp = span.syncVisible(10);
		}

		return nonactiveavghighlowtemp;
	}

	/*
	 * 
	 * Method to verify Weather Icon is displayed
	 * 
	 * for Active Dates of Day Panel under Monthly forecast Page
	 * 
	 */
	public boolean isListOfWeatherIconForActiveDaysDisplayed() {
		WebPageLoaded.isDomInteractive();
		activedatesweathericon = true;
		Boolean value;
		for (int i = 1; i < getActiveDayPanelSize() + 1; i++) {
			value = getDriver().findElements(By.xpath(
					"//div[@class='monthly-grid-container monthly-component']/div[2]/a[not(contains(@class,'monthly-daypanel is-past'))]["
							+ i + "]/div[2]/img"))
					.size() > 0;
			activedatesweathericon = value;
		}

		return activedatesweathericon;
	}

	/*
	 * 
	 * Method to click on Active Date in Grid View under Monthly forecast Page
	 * 
	 * 
	 * 
	 */
	public void isDailyForecastPageDisplayed() {
		WebPageLoaded.isDomInteractive();
		i = getActiveDayPanelSize();
		WebElement activedate = getDriver().findElement(By.cssSelector(
				"div.two-column-page-content > div.page-column-1 > div > div.monthly-grid-container.monthly-component > div.monthly-grid > a:nth-child("
						+ i + ")"));
		activedate.jsClick();
	}

	/*
	 * 
	 * Method to verify Temperature on Temperature Graph is displayed under Monthly
	 * forecast Page
	 * 
	 * 
	 * 
	 */
	public boolean isAllTempOnTempGraphDislayed() {
		return getDriver().findElements(byAllTempOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify All days on Temperature Graph is displayed under Monthly
	 * forecast Page
	 * 
	 * 
	 * 
	 */
	public boolean isAllDaysOnTempGraphDislayed() {
		return getDriver().findElements(byAllDaysOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Average High Orange Thin Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isOrangeLineForAvgHighOnTempGraphDislayed() {
		orangeline = getDriver().findElement(byOrangeThinLineOnTempGraph).isDisplayed();
		return orangeline;
	}

	/*
	 * 
	 * Method to verify Actual High Orange Thick Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isOrangeLineForActualHighOnTempGraphDislayed() {
		return getDriver().findElements(byOrangeThickLineOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Forecast High Orange Dotted Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isOrangeDottedLineOnTempGraphDislayed() {
		return getDriver().findElements(byOrangeDottedLineOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Average Low Blue Thin Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isBlueLineForAvgLowOnTempGraphDislayed() {
		return getDriver().findElements(byBlueThinLineOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Actual Low Blue Thin Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isBlueLineForActualLowOnTempGraphDislayed() {
		return getDriver().findElements(byBlueThickLineOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Forecast Low Blue Dotted Line on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isBlueDottedLineOnTempGraphDislayed() {
		return getDriver().findElements(byBlueDottedLineOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Today Marker on Temperature Graph
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isTodayMarkerOnTempGraphDislayed() {
		return getDriver().findElements(byTodayMarkerOnTempGraph).size() > 0;
	}

	/*
	 * 
	 * Method to verify Top Monthly Navigation
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isTopMnthlyNavOnGridViewDislayed() {
		return getDriver().findElements(byTopMonthlyNavOnGridView).size() > 0;
	}

	/*
	 * 
	 * Method to verify Bottom Monthly Navigation
	 * 
	 * is displayed under Monthly forecast Page
	 * 
	 */
	public boolean isBottomMnthlyNavOnGridViewDislayed() {
		return getDriver().findElements(byBottomMonthlyNavOnGridView).size() > 0;
	}

	/*
	 * 
	 * Method to click On List View icon on AW Monthly Forecast page
	 * 
	 */
	public void clickOnListViewIcon() {
		WebPageLoaded.isDomInteractive();
		WebElement listviewicon = getDriver().findElement(byListViewGridIcon);
		listviewicon.click();
	}

	/*
	 * 
	 * Method to get size of all Days of Week in List View for
	 * 
	 * current month under Monthly forecast Page
	 * 
	 */
	public int getListOfDaysWeekSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> daysofweeksize = getDriver().findElements(byListViewAllDaysOfWeek);
		return daysofweeksize.size();
	}

	/*
	 * 
	 * Method to verify days of week is displayed on the left side
	 * 
	 * for current month in List View under Monthly forecast Page
	 * 
	 */
	public boolean isListOfDaysWeekForCurrentMonthDisplayed() {
		WebPageLoaded.isDomInteractive();
		listofdaysweek = true;
		Boolean value;
		for (int i = 1; i < getListOfDaysWeekSize() + 1; i++) {
			value = getDriver()
					.findElements(By.cssSelector(
							"div.page-column-1 > div.monthly-component > a:nth-child(" + i + ") > div.date > p.dow"))
					.size() > 0;
			listofdaysweek = value;
		}

		return listofdaysweek;
	}

	/*
	 * 
	 * Method to get size of all Days of Month in List View for
	 * 
	 * current month under Monthly forecast Page
	 * 
	 */
	public int getListOfDaysMonthSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> daysofmonthsize = getDriver().findElements(byListViewAllDaysOfMonth);
		return daysofmonthsize.size();
	}

	/*
	 * 
	 * Method to verify days of month is displayed on the left side
	 * 
	 * for current month in List View under Monthly forecast Page
	 * 
	 */
	public boolean isListOfDaysMonthForCurrentMonthDisplayed() {
		WebPageLoaded.isDomInteractive();
		listofdaysmonth = true;
		Boolean value;
		for (int i = 1; i < getListOfDaysMonthSize() + 1; i++) {
			value = getDriver()
					.findElements(By.cssSelector(
							"div.page-column-1 > div.monthly-component > a:nth-child(" + i + ") > div.date > p.sub"))
					.size() > 0;
			listofdaysmonth = value;
		}

		return listofdaysmonth;
	}

	/*
	 * 
	 * Method to get Substring of Month from Month Year Span
	 * 
	 * under List View on AW Monthly Forecast page
	 * 
	 */
	public String getListViewMonthSubString() {
		WebPageLoaded.isDomInteractive();
		final WebElement listviewmonthText = getDriver().findElement(byListViewCurrentMonthYear);
		listviewmonthText.syncVisible();
		listviewmonth = listviewmonthText.getText();
		substringmonthname = listviewmonth.substring(0, listviewmonth.length() - 4).trim();
		return substringmonthname;
	}

	/*
	 * 
	 * Method to get Substring of Year from Month Year Span
	 * 
	 * under List View on AW Monthly Forecast page
	 * 
	 */
	public String getListViewYearSubString() {
		substringyearname = null;
		WebPageLoaded.isDomInteractive();
		final WebElement listviewyearText = getDriver().findElement(byListViewCurrentMonthYear);
		listviewyearText.syncVisible();
		listviewyear = listviewyearText.getText();
		if (listviewyear.length() > 4) {
			substringyearname = listviewyear.substring(listviewyear.length() - 4).trim();
		}

		return substringyearname;
	}

	/*
	 * 
	 * Method to get size of all Week Days of Month in List View for
	 * 
	 * current month under Monthly forecast Page
	 * 
	 */
	public int getListOfWeekDaysSize() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> weekdaysofmonthsize = getDriver().findElements(byGridViewAllDaysOfWeek);
		return weekdaysofmonthsize.size();
	}

	/*
	 * 
	 * Method to verify week days of month is displayed on the Top section
	 * 
	 * for current month in Grid View under Monthly forecast Page
	 * 
	 */
	public boolean isListOfWeekDaysForCurrentMonthDisplayed() {
		WebPageLoaded.isDomInteractive();
		listofweekdaysofmonth = true;
		Boolean value;
		for (int i = 1; i < getListOfWeekDaysSize() + 1; i++) {
			value = getDriver().findElements(By.cssSelector(
					"div.page-column-1 > div.monthly-grid-container.monthly-component > div.monthly-header > div:nth-child("
							+ i + ") > span.day-name"))
					.size() > 0;
			listofweekdaysofmonth = value;
		}

		return listofweekdaysofmonth;
	}

	/*
	 * 
	 * Method to verify Grid Icon is selected by default
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isGridViewIconSelected() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byGridViewIconSelected).size() > 0;

	}

	/*
	 * 
	 * Method to verify AW LOGO is displayed
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isAWLogoDisplayed() {
		WebPageLoaded.isDomInteractive(5);
		return getDriver().findElements(byAWLogo).size() > 0;
	}

	/*
	 * 
	 * Method to verify List View Icon is Enabled by default
	 * 
	 * under Monthly forecast Page
	 * 
	 */
	public boolean isListViewIconEnabled() {
		return getDriver().findElements(byListViewIconSelected).size() > 0;
	}

	public boolean clickMonthDropDown() {
		getDriver().findElement(byMonthDropDown).click();
		return true;
	}

	public boolean clickYearDropDown() {
		getDriver().findElement(ByYearDropDown).click();
		return true;
	}

	public void clickYearDropDownAndSelectYear() {
		getDriver().findElement(byYearDropDownPastYear).click();

	}

	public boolean validatemonthDislayedAfterMonthselected() {
		String src = getDriver().findElement(ByyearDisplayed).getText();
		getDriver().findElement(byYearDropDownPastYear).click();
		String dest = getDriver().findElement(byYearDropDownPastYear).getText();
		return src.equalsIgnoreCase(dest);

	}

	public void clickAdvance3Months(String advanceThreeMonth) {
		Sleeper.sleep(5);
		getDriver().findElement(By.xpath("//span[contains(text(),'" + advanceThreeMonth + "')]")).click();
	}

	public Boolean ValidateThreeMonthsForecast() {
		String expectecurrentmonth = simpledate.getMonthString();
		String AdvanceThreeMonth = simpledate.advanceMonth(3).getMonthString();
		int expectedCurrentyear = simpledate.getYear();
		int AdvanceYear = simpledate.advanceMonth(3).getYear();
		if (AdvanceYear > expectedCurrentyear) {
			getDriver().findElement(byMonthDropDown).click();
			Sleeper.sleep(5);
			getDriver().findElement(By.xpath("//span[contains(text(),'" + AdvanceThreeMonth + "')]")).click();
			Sleeper.sleep(5);
			getDriver().findElement(ByYearDropDown).click();
			Sleeper.sleep(5);
			getDriver().findElement(By.cssSelector(
					"div.card-button.monthly-nav.centered > div > div:nth-child(2) > div.items.active > a:nth-child(3) > span"))
					.click();
			Sleeper.sleep(5);
		} else {
			getDriver().findElement(byMonthDropDown).click();
			Sleeper.sleep(5);
			getDriver().findElement(By.xpath("//span[contains(text(),'" + AdvanceThreeMonth + "')]")).click();
			Sleeper.sleep(5);
		}
		return getDriver().findElements(By.cssSelector(
				"div.monthly-grid-container.monthly-component > div.monthly-grid > a:nth-child(4) > div.temp > div.low"))
				.size() > 0;
	}

	public Boolean ValidateMonthDropDownOpionsInEnglish() {
		boolean isEqual = true;
		getDriver().findElement(byMonthDropDown).click();
		Sleeper.sleep(5);
		for (int i = 1; i < 13; i++) 
		{
			String UIActString = getDriver().findElement(By.xpath("(//div[@class='items active']/a/span)[" + i + "]")).getText();
			if (UIActString != (MONTHS[i - 1])) {
				isEqual = false;
			}
		}

		return isEqual;
	}

}
