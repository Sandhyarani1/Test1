package com.accuweather.glacier.www.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

import io.appium.java_client.android.nativekey.KeyEvent;

public class SeachResultsPage extends BasePage 
{
    Boolean flag;
	private By byLocation = By.cssSelector("div.search-results > a:nth-child(1)");
    private By byListOfSuggestedLocaions = By.cssSelector("div.search-results > a");
    private By bySelectLocationFromSearchResult = By.cssSelector("div > div.search-results > a:nth-child(1)");
    private By byRecentLocationUnderNavigationalMenu = By.cssSelector(".div.hero.page-hero.content-module.hero-4 > div.featured-locations > a:nth-child(1) > span.recent-location-name");
    private By bySelectFirstLocationFromSearchedResults = By.cssSelector("div > div.search-results > a:nth-child(1)");
    
	/**
	 * Method to Validate user navigated to 3 day forecast page when clicked on any of the location from the search results
	 * @author SOWMIYA
	 * */
	public void clickLocationFromSearchResults()
	{
		WebPageLoaded.isDomInteractive();
		WebElement locationFromSearchResults = getDriver().findElement(byLocation);
		locationFromSearchResults.syncVisible(15);
		locationFromSearchResults.jsClick();
	}
	
	/**
	 * Method to verify the list of suggested locations based on the characters entered appears
	 * @author SOWMIYA
	 * */
	public void verifyListofSuggestedLocations(String Location)
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> suggestedLocations = getDriver().findElements(byListOfSuggestedLocaions);
        if(suggestedLocations.size() >= 1) {
        	for(int i=1;i<=suggestedLocations.size();i++) {
    			String getLocation = getDriver().findElement(By.cssSelector("div.search-results > a:nth-child("+i+")")).getText();
    			if(getLocation.contains(Location)) {
    				flag = true;
    				continue;}
    			else
    				flag = false;
    		}
        }
	}
	
	/**
	 * Method to navigate search results using arrow keys
	 * @author SOWMIYA
	 * */
	public void navigateSearchResultsUsingArrowKeys()
	{
//		Actions actionObject = new Actions(getDriver());
//		actionObject.sendKeys(Keys.ARROW_DOWN).click();
//		Sleeper.sleep(2);
		
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.keyPress(java.awt.event.KeyEvent.VK_DOWN);
	        robot.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
	        Sleeper.sleep(5);
	        WebElement locationFromSearchResults = getDriver().findElement(bySelectLocationFromSearchResult);
			locationFromSearchResults.syncVisible(15);
			locationFromSearchResults.click();
//	        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//	        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	        Sleeper.sleep(5);

	}
	
	 /**
	 * Method to return city appears in the recent location under universal navigation menu 
	 * @author Sowmiya
	 * return - String - city name
	 * */
	public String cityAppearsInRecentLocationUnderUniversalNavigationalMenu(int i)
	{
		WebPageLoaded.isDomInteractive();
		String getLocationUnderUniversalNavigationSearchField = getDriver().findElement(By.cssSelector("div.featured-locations > a:nth-child("+i+") > span.recent-location-name")).getText();
		return getLocationUnderUniversalNavigationSearchField;
	}
	
	/**
	 * Method to select first location from the searched results
	 * @author Sowmiya
	 * */
	public void selectFirstLocationFromSearchedResults()
	{
		WebPageLoaded.isDomInteractive();
		WebElement locationFromSearchResults = getDriver().findElement(bySelectLocationFromSearchResult);
		locationFromSearchResults.syncVisible(15);
		locationFromSearchResults.jsClick(); 
	}
}
