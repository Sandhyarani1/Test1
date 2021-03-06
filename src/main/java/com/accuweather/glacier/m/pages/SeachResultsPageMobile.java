package com.accuweather.glacier.m.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class SeachResultsPageMobile extends MobileBasePage {
	Boolean flag;
	private By byLocation = By.cssSelector("div.search-results > a:nth-child(1)");
	private By byListOfSuggestedLocaions = By.cssSelector("div.search-results > a");
	private By fourweathercards = By.cssSelector(
			"div.page-column-1 > div > div.sliding-panel.three-day-panel.three-day-forecast.full-mobile-width");
	private By bySearchResultsList = By.xpath("//div[@class='search-bar-result search-result']");
	private By byRecentLocation = By.cssSelector("div.featured-locations > a:nth-child(1) > span.recent-location-name");
	

	/**
	 * Method to Validate user navigated to 3 day forecast page when clicked on any
	 * of the location from the search results
	 * 
	 * @author SOWMIYA
	 */
	public void clickLocationFromSearchResults() {
		WebPageLoaded.isDomInteractive();
		WebElement locationFromSearchResults = getDriver().findElement(byLocation);
		locationFromSearchResults.syncVisible(15);
		locationFromSearchResults.jsClick();
	}

	public Boolean fourWeathercardisDisplayed() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(fourweathercards).syncVisible(5);
		return getDriver().findElements(fourweathercards).size() > 0;
	}

	/**
	 * Method to verify the list of suggested locations based on the characters
	 * entered appears
	 * 
	 * @author SOWMIYA
	 */
	public void verifyListofSuggestedLocations(String Location) {
		WebPageLoaded.isDomInteractive();
		List<WebElement> suggestedLocations = getDriver().findElements(byListOfSuggestedLocaions);
		if (suggestedLocations.size() >= 1) {
			for (int i = 1; i <= suggestedLocations.size(); i++) {
				String getLocation = getDriver()
						.findElement(By.cssSelector("div.search-results > a:nth-child(" + i + ")")).getText();
				if (getLocation.contains(Location)) {
					flag = true;
					continue;
				} else
					flag = false;
			}
		}
	}

	public Boolean navigateSearchResults() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(java.awt.event.KeyEvent.VK_DOWN);
		robot.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
		Sleeper.sleep(5);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		Sleeper.sleep(5);
		return getDriver().findElements(bySearchResultsList).size()>0;

	}

	public String getRecentLocation() {
		return getDriver().findElement(byRecentLocation).getText();
		
	}

}
