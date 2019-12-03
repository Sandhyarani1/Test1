package com.accuweather.glacier.m.pages;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class LifeStyleIOS extends MobileBasePage {
	private final static String MENU = "Driving";
	Boolean flag;
	String[] expectedPersonalizedMenuCategories = { "A.M. Planner", "Home & Garden", "Sports & Recreation", "Health",
			"Miscellaneous" };

	private By byPersonalizedForecastArrow = By.cssSelector("div.lifestyle-label > svg");
	private By byToday = By.xpath(
			"//div[@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'Today')]");
	private By byTomorrow = By.xpath(
			"//div[@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'Tomorrow')]");
	private By byDateToday = By.xpath("//p[@class='module-header sub date']/../p[contains(text(),'Today')]");
	private By byDateTomorrow = By.xpath("//p[@class='module-header sub date']/../p[contains(text(),'Tomorrow')]");
	private By byIndexDialToday = By.xpath("//div[@class='value-gauge']/../p[contains(text(),'Today')]");
	private By byIndexDialTomorrow = By.xpath("//div[@class='value-gauge']/../p[contains(text(),'Tomorrow')]");
	private By byWeatherDescriptionToday = By.xpath("//div[@class='cond']/../p[contains(text(),'Today')]");
	private By byWeatherDescriptionTomorrow = By.xpath("//div[@class='cond']/../p[contains(text(),'Tomorrow')]");
	private By byWeatherIconToday = By
			.xpath("//div[@class='forecast']/img[@class='weather-icon icon']/../../p[contains(text(),'Today')]");
	private By byWeatherIconTomorrow = By
			.xpath("//div[@class='forecast']/img[@class='weather-icon icon']/../../p[contains(text(),'Tomorrow')]");
	private By byHighTempToday = By
			.xpath("//div[@class='temp']/span[@class='high']/../../../p[contains(text(),'Today')]");
	private By byHighTempTomorrow = By
			.xpath("//div[@class='temp']/span[@class='high']/../../../p[contains(text(),'Tomorrow')]");
	private By byLowTempToday = By
			.xpath("//div[@class='temp']/span[@class='low']/../../../p[contains(text(),'Today')]");
	private By byLowTempTomorrow = By
			.xpath("//div[@class='temp']/span[@class='low']/../../../p[contains(text(),'Tomorrow')]");
	private By byNextArrow = By.cssSelector("div > div.next > div.arrow.top.card.active");
	private By byPreviousArrow = By.cssSelector("div > div.next > div:nth-child(2)");
	private By byPersonalizedForecastDescription = By
			.cssSelector("div.lifestyle-label > div > div > div.lifestyle-dropdown-left > p");
	private By byEditIconInExpandedMenu = By.cssSelector("div.lifestyle-dropdown-left > div.dropdown-title > img");

	private By byPesonalizedForecastmenu = By
			.cssSelector(".accordion-item:nth-child(6) .accordion-item-header-content");
	private By byForecast = By.cssSelector(".featured-lifestyle > a");

	private By by3DayPersonalisedForecastToday = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.three-day-index-panel.three-day-forecast.full-mobile-width.content-module > div > div.scroll > div:nth-child(1) > p:nth-child(1)");
	private By by3DayPersonalisedForecastTomorrow = By.cssSelector(
			"body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.sliding-panel.three-day-index-panel.three-day-forecast.full-mobile-width.content-module > div > div.scroll > div:nth-child(2) > p:nth-child(1)");

	/**
	 * Method to Today, Tomorrow and Day after tomorrow days should appear on the
	 * 3-day page
	 * 
	 * @author SOWMIYA return Boolean value - true if selected allergy is visible
	 *         else false
	 */
	public Boolean clickOnAllergyPersonalizedForecastMenu() {
		WebPageLoaded.isDomInteractive();
		WebElement personalizedForecastArrow = getDriver().findElement(byPersonalizedForecastArrow);
		personalizedForecastArrow.syncVisible();
		personalizedForecastArrow.click();
		// select one of the allergy on the personalized forecast menu
		WebElement menuFromPersonalizedForecast = getDriver().findElement(
				By.xpath("//div[@class='lifestyle-dropdown-right']/div/div/a[contains(text(),'" + MENU + "')]"));
		menuFromPersonalizedForecast.syncVisible();
		menuFromPersonalizedForecast.jsClick();
		WebElement menuPresent = getDriver().findElement(By.xpath(
				"//div[@class='subnav secondary-nav has-tertiary']/div[@class='subnav-items']/a/h1[contains(text(),'"
						+ MENU + "')]"));
		return menuPresent.syncVisible(15);
	}

	/**
	 * Method to get the day of day after tomorrow
	 * 
	 * @author SOWMIYA return Boolean value - day of day after tomorrow
	 */
	public String getDayOfDayAfterTomorrow(int numberOfDaysToAdd) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, numberOfDaysToAdd); // add 2 days
		Date currentDatePlusOTwo = c.getTime();
		Format formatter = new SimpleDateFormat("EEEE");
		String dayAfterTomorrowDay = formatter.format(c.getTime());

		return dayAfterTomorrowDay;
	}

	/**
	 * Method to verfiy Today, Tomorrow and Day after tomorrow days should appear on
	 * the 3-day page
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel are displayed
	 *         else false
	 */
	public Boolean check3DayPageShowUpto3Days() {
		WebPageLoaded.isDomInteractive();

		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		// verify today panel
		WebElement today = getDriver().findElement(by3DayPersonalisedForecastToday);

		// verify tomorrow panel
		WebElement tomorrow = getDriver().findElement(by3DayPersonalisedForecastTomorrow);

		// verify day after tomorrow panel
		String dayOfDayAfterTomorrow = this.getDayOfDayAfterTomorrow(2);
		WebElement dayAftertomorrow = getDriver().findElement(By.xpath(
				"//div[3][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ dayOfDayAfterTomorrow + "')]"));

		return true;

	}

	/**
	 * Method to validate date elements of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel's date are
	 *         displayed else false
	 */
	public Boolean validateDateElementsOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement dateFirstPanel = getDriver().findElement(byDateToday);
		WebElement dateSecondPanel = getDriver().findElement(byDateTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement dateThirdPAnel = getDriver().findElement(
				By.xpath("//p[@class='module-header sub date']/../p[contains(text(),'" + dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate index dial of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel have index dial
	 *         else false
	 */
	public Boolean validateIndexDialOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement indexDialFirstPanel = getDriver().findElement(byIndexDialToday);
		WebElement indexDialSecondPanel = getDriver().findElement(byIndexDialTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement indexDialThirdPanel = getDriver().findElement(
				By.xpath("//div[@class='value-gauge']/../p[contains(text(),'" + dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate weather description of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel have weather
	 *         description else false
	 */
	public Boolean validateWeatherDescriptionOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement weatherDescriptionFirstPanel = getDriver().findElement(byWeatherDescriptionToday);
		WebElement weatherDescriptionSecondPanel = getDriver().findElement(byWeatherDescriptionTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement weatherDescriptionThirdPanel = getDriver()
				.findElement(By.xpath("//div[@class='cond']/../p[contains(text(),'" + dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate weather icon of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel have weather icon
	 *         else false
	 */
	public Boolean validateWeatherIconOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement weatherIconFirstPanel = getDriver().findElement(byWeatherIconToday);
		WebElement weatherIconSecondPanel = getDriver().findElement(byWeatherIconTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement weatherIconThirdPanel = getDriver().findElement(
				By.xpath("//div[@class='forecast']/img[@class='weather-icon icon']/../../p[contains(text(),'"
						+ dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate high temp of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel have high temp
	 *         else false
	 */
	public Boolean validateHighTempOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement highTempFirstPanel = getDriver().findElement(byHighTempToday);
		WebElement highTempSecondPanel = getDriver().findElement(byHighTempTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement highTempThirdPanel = getDriver().findElement(By.xpath(
				"//div[@class='temp']/span[@class='high']/../../../p[contains(text(),'" + dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate low temp of each day panel
	 * 
	 * @author SOWMIYA return Boolean value - true if 3 days panel have low temp
	 *         else false
	 */
	public Boolean validateLowTempOfEachPanel() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement lowTempFirstPanel = getDriver().findElement(byLowTempToday);
		WebElement lowTempSecondPanel = getDriver().findElement(byLowTempTomorrow);

		String dayOfThirdDayPanel = this.getDayOfDayAfterTomorrow(2);
		WebElement lowTempThirdPanel = getDriver().findElement(By.xpath(
				"//div[@class='temp']/span[@class='low']/../../../p[contains(text(),'" + dayOfThirdDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to click forward arrow and verify user is shown next three days
	 * 
	 * @author SOWMIYA return Boolean value - true if user see three days else false
	 */
	public Boolean clickForwardArrowAndUserIsShownNextThreeDays() {
		WebPageLoaded.isDomInteractive();
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement nextArrrow = getDriver().findElement(byNextArrow);
		// nextArrrow.syncVisible();
		nextArrrow.jsClick();

		// get first day from next three days panel
		String getFirstDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(3);
		WebElement firstDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[1][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getFirstDayFromNextThreeDayPanel + "')]"));

		// get second day from next three days panel
		String getSecondDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(4);
		WebElement secondDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[2][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getSecondDayFromNextThreeDayPanel + "')]"));

		// get second day from next three days panel
		String getThirdDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(5);
		WebElement thirdDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[3][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getThirdDayFromNextThreeDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to click backward arrow and verify user is shown previous three days
	 * 
	 * @author SOWMIYA return Boolean value - true if user see previous three days
	 *         else false
	 */
	public Boolean clickBackwardArrowAndUserIsShownPreviousThreeDays() {
		WebPageLoaded.isDomInteractive();
		if (getDriver().findElements(By.xpath(
				"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
				.size() > 0) {
			getDriver().findElement(By.xpath(
					"(//*[@nodeName='svg' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='dismiss-button']]]/*[@nodeName='path' and @width>0])[2]"))
					.click();
		}
		WebPageLoaded.isDomInteractive();
		WebElement previousArrrow = getDriver().findElement(byPreviousArrow);
		// previousArrrow.syncVisible();
		previousArrrow.jsClick();

		// get first day from next three days panel
		String getFirstDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(3);
		WebElement firstDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[1][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getFirstDayFromNextThreeDayPanel + "')]"));

		// get second day from next three days panel
		String getSecondDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(4);
		WebElement secondDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[2][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getSecondDayFromNextThreeDayPanel + "')]"));

		// get second day from next three days panel
		String getThirdDayFromNextThreeDayPanel = this.getDayOfDayAfterTomorrow(5);
		WebElement thirdDayFromNextThreeDayPanel = getDriver().findElement(By.xpath(
				"//div[3][@class='index-panel index-panel panel panel-fade-in card']/p[@class='module-header' and contains(text(),'"
						+ getThirdDayFromNextThreeDayPanel + "')]"));

		return true;
	}

	/**
	 * Method to validate the description for personalized forecast in the expanded
	 * menu
	 * 
	 * @author SOWMIYA return String - description of personalized forecast
	 */
	public String validateDescriptionForPersonalizedForecast() {
		WebPageLoaded.isDomInteractive();
		WebElement personalizedForecastArrow = getDriver().findElement(byPersonalizedForecastArrow);
		personalizedForecastArrow.syncVisible();
		personalizedForecastArrow.click();
		// get the description of personalized forecast menu
		WebElement personalizedForecastDescription = getDriver().findElement(byPersonalizedForecastDescription);
		personalizedForecastDescription.syncVisible();
		return personalizedForecastDescription.getText();
	}

	/**
	 * Method to validate the edit icon appear in the expanded menu
	 * 
	 * @author SOWMIYA return Boolean true - if edit icon is present else false
	 */
	public Boolean verifyEditIconAppearInExpandedMenu() {
		WebPageLoaded.isDomInteractive();
		WebElement personalizedForecastArrow = getDriver().findElement(byPersonalizedForecastArrow);
		personalizedForecastArrow.syncVisible();
		personalizedForecastArrow.click();
		// verify edit con is present
		WebElement iconEdit = getDriver().findElement(byEditIconInExpandedMenu);
		return iconEdit.syncVisible();
	}

	/**
	 * Method to validate personalized forecast menu categories
	 * 
	 * @author SOWMIYA return Boolean value - "true if list of categories are same
	 *         as expected else false"
	 */
	public Boolean verifyPersonalizedForecastCategories() {
		WebPageLoaded.isDomInteractive();
		WebElement personalizedForecastArrow = getDriver().findElement(byPersonalizedForecastArrow);
		personalizedForecastArrow.syncVisible();
		personalizedForecastArrow.click();

		for (int i = 0; i < expectedPersonalizedMenuCategories.length; i++) {
			// div[@class='lifestyle-dropdown-right']/div/h4[text()='A.M. Planner']
			System.out.println("value:::::::" + expectedPersonalizedMenuCategories[i]);
			WebElement category = getDriver()
					.findElement(By.xpath("//div[@class='lifestyle-dropdown-right']/div/h4[text()='"
							+ expectedPersonalizedMenuCategories[i] + "']"));
			try {
				if (category.syncVisible(10))
					;
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

	public void clickOnPersonalizedForecastMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byPesonalizedForecastmenu).click();
	}

	public Boolean verifyPersonalizedmenuOptions() {

		WebPageLoaded.isDomInteractive();
		String[] expectedArray = { "A.M. Planner", "Home & Garden", "Sports & Recreation", "Health", "Miscellaneous" };
		String[] actualArray = {};
		for (int i = 1; i < 6; i++) {
			// String xPathWithVariable = "(//div[@class='select-title hidden'])" + "[" + i
			// + "]";
			actualArray[i - 1] = getDriver()
					.findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + i + "]")).getText();
		}

		if (Arrays.equals(expectedArray, actualArray))
			return true;
		else
			return false;

	}

	public void clickOnAMPlannerOptionMenu() {
		getDriver().findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + 1 + "]")).click();
	}

	public boolean ClickOnForecastPage() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byForecast).click();
		return true;

	}

	public boolean AMPlannerPickerValues() {
		WebPageLoaded.isDomInteractive();
		String strArray0 = (String) getDriver().executeJavaScript(
				"seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPickerWheel']\", 0, 0)");
		return strArray0.contains("A.M. Planner") && strArray0.contains("Driving") && strArray0.contains("School Day")
				&& strArray0.contains("Hair Day") && strArray0.contains("Snow Days");
	}

	public boolean HomeAndGardenPickerValues() {
		WebPageLoaded.isDomInteractive();
		String strArray0 = (String) getDriver().executeJavaScript(
				"seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPickerWheel']\", 0, 0)");
		return strArray0.contains("Home & Garden") && strArray0.contains("D.I.Y") && strArray0.contains("Lawn & Garden")
				&& strArray0.contains("Home & Energy") && strArray0.contains("Entertaining")
				&& strArray0.contains("Mosquito");
	}

	public void clickOnHomeAndGardenOptionMenu() {
		getDriver().findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + 2 + "]")).click();

	}

	public void clickOnSportsAndRecreationOptionMenu() {
		getDriver().findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + 3 + "]")).click();

	}

	public boolean sportsAndRecreationPickerValues() {
		WebPageLoaded.isDomInteractive();
		String strArray0 = (String) getDriver().executeJavaScript(
				"seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPickerWheel']\", 0, 0)");
		return strArray0.contains("Sports & Recreation") && strArray0.contains("Golf") && strArray0.contains("Ski")
				&& strArray0.contains("Hunting") && strArray0.contains("Fishing") && strArray0.contains("Running")
				&& strArray0.contains("Hiking") && strArray0.contains("Biking") && strArray0.contains("Sun & Sand")
				&& strArray0.contains("Sailing");
	}

	public void clickOnHealthOptionMenu() {
		getDriver().findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + 4 + "]")).click();

	}

	public boolean healthnPickerValues() {
		WebPageLoaded.isDomInteractive();
		String strArray0 = (String) getDriver().executeJavaScript(
				"seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPickerWheel']\", 0, 0)");
		return strArray0.contains("Health") && strArray0.contains("Cold & Flu") && strArray0.contains("Allergies")
				&& strArray0.contains("Respiratory") && strArray0.contains("Arthritis") && strArray0.contains("Migrane")
				&& strArray0.contains("Sinus");

	}

	public void clickOnMiscellaneousOptionMenu() {
		getDriver().findElement(By.xpath("(//div[@class='select-title hidden'])" + "[" + 5 + "]")).click();

	}

	public boolean miscellaneousPickerValues() {
		WebPageLoaded.isDomInteractive();
		String strArray0 = (String) getDriver().executeJavaScript(
				"seetest:client.getPickerValues(\"NATIVE\", \"xpath=//*[@class='UIAPickerWheel']\", 0, 0)");
		return strArray0.contains("Miscellaneous") && strArray0.contains("Travel") && strArray0.contains("Astronomy")
				&& strArray0.contains("Events");

	}
}
