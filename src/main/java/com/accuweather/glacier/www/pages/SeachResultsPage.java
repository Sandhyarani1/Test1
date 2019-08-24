package com.accuweather.glacier.www.pages;


import java.util.List;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class SeachResultsPage extends BasePage 
{
    Boolean flag;
	private By byLocation = By.cssSelector("div.search-results > a:nth-child(1)");
    private By byListOfSuggestedLocaions = By.cssSelector("div.search-results > a");
	
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
}