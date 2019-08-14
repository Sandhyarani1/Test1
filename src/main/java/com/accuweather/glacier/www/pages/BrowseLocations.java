package com.accuweather.glacier.www.pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class BrowseLocations extends BasePage
{
	int noOfRegions;
	boolean flag;
    String[] expectedListOfRegions = {"Africa", "Antarctica", "Arctic", "Asia", "Central America", "Europe", "Middle East", "North America", "Oceania", "South America"};
    String[] expectedListOfRegionsFromSelectedRegion = {"Afghanistan", "Armenia", "Azerbaijan", "Bangladesh", "Bhutan", "British Indian Ocean Territory", "Brunei", "Cambodia", "China", "Christmas Island", "Cocos (Keeling) Islands", "Georgia", "Hong Kong", "India", "Indonesia", "Japan", "Kazakhstan", 
    		"Kyrgyzstan", "Laos", "Macau", "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nansha Islands", "Nepal", "North Korea", "Pakistan", "Philippines", "Russia", "Singapore", "South Korea", "Sri Lanka", "Taiwan", "Tajikistan", "Thailand", "Timor-Leste", "Turkey", "Turkmenistan", "Uzbekistan", "Vietnam"};
   
    String[] expectedListOfStatesFromSelectedCountry = {"Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", 
    		"Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
	private int expectedNumberOfCititesInState = 100;
    private By byZipCodeSearchBox = By.cssSelector("div.searchbar.featured-search > div.searchbar-content > form > input.search-input");
	private By byBrowseForLocationCTA = By.xpath("//div[@class='page-column-1']/div[@class='content-module']/a/span");
	private By byAWLogo = By.cssSelector("div > div.main-menu > div.logo-wrapper >div.icon-text > a");
	private By byWorldWeatherCTALink = By.cssSelector("div.page-column-1 > div.content-module > a");
	private By byWorldWeatherCTAColor = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span");
	private By arrowWorldWeatherCTA = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span/../div[@class='arrow-wrap is-next']");
	private By byRegion = By.cssSelector("div.page-column-1 > div.content-module > div > a:nth-child(4)");
	private By byWorldRegions = By.xpath("//div[@class='page-column-1']/div/div[1]/../a[@class='search-result back-button']");
	private By bySelectedRegion = By.xpath("//div[@class='page-column-1']/div/a[contains(text(),'World Regions')]/../div[@class='location-title']");
	private By byWeatherCTAColorFromSelectedRegion = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span");
	private By arrowWeatherCTAFromSelectedRegion = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span/../div[@class='arrow-wrap is-next']");
	private By byCountry = By.cssSelector("div.page-column-1 > div.content-module > div > a:nth-child(14)");
	private By byContinentHeader = By.xpath("//div[@class='page-column-1']/div/div[1]/../a[@class='search-result back-button']");
	private By byCounteryWeatherCTALink = By.cssSelector("div.page-column-1 > div.content-module > a.card-button");
	private By byCountryHeader = By.xpath("//div[@class='page-column-1']/div/a/../div[@class='location-title']");
	private By byCountryWeatherCTAColor = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span");
	private By byCountryWeatherCTAArrow = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span/../div[@class='arrow-wrap is-next']");
	private By byContinentCTA = By.xpath("//div[@class='page-column-1']/div/div[1]/../a[@class='search-result back-button']");
	private By byContinentWeather = By.cssSelector("div.page-column-1 > div.content-module > a.card-button");
	private By byState = By.cssSelector("div.page-column-1 > div.content-module > div > a:nth-child(2)");
	private By byStateWeatherCTALink = By.cssSelector("div.page-column-1 > div.content-module > a.card-button");
	private By byStateWeatherCTAColor = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span");
	private By byCountryHeaderAboveState = By.xpath("//div[@class='page-column-1']/div/div[1]/../a[@class='search-result back-button']");
	private By byStateHeaderBelowCountry = By.xpath("//div[@class='page-column-1']/div/a/../div[@class='location-title']");
	private By byStateWeatherCTAArrow = By.xpath("//div[@class='result-container']/../a[@class='card-button']/span/../div[@class='arrow-wrap is-next']");
	private By byCity = By.cssSelector("div.page-column-1 > div.content-module > div.result-container > a:nth-child(1)");
	private By byThreeDayWeathercards = By.cssSelector("div > div.flipper-panel  > div.scroll");
	private By byCitiesList = By.cssSelector("div.page-column-1 > div.content-module > div.result-container > a");
	
	/**
	 * Method to validate if Browse For a Location CTA is present
	 * @author SOWMIYA
	 * @return - Boolean value - "true if Browse For a Location is present else false"
	 * */
	public Boolean isBrowseForLocationPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement browseForLocationCTA = getDriver().findElement(byBrowseForLocationCTA);
		return browseForLocationCTA.syncVisible(30);
	}

	/**
	 * Method to click Browse For a Location CTA
	 * @author SOWMIYA
	 * @return - Boolean value - "true if user is redirected to browse for a location page else false"
	 * */
	public Boolean clickBrowseForLocationCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement browseForLocationCTA = getDriver().findElement(byBrowseForLocationCTA);
		try
		{
		    browseForLocationCTA.syncVisible(10);
		    browseForLocationCTA.jsClick();
		    Sleeper.sleep(3);
		}
		catch(Exception e)
		{
			WebElement logoAW = getDriver().findElement(byAWLogo);
			logoAW.syncVisible(10);
			logoAW.jsClick();
			WebElement zipcodetextfield = getDriver().findElement(byZipCodeSearchBox);
			zipcodetextfield.syncVisible(15);
			zipcodetextfield.hover();
			zipcodetextfield.sendKeys("st");
			zipcodetextfield.sendKeys(Keys.ENTER);
			Sleeper.sleep(3);
		}
		WebElement worldWeatherCTA = getDriver().findElement(byWorldWeatherCTALink);
		return worldWeatherCTA.syncVisible(30);
	}

	/**
	* Method to click World Weather CTA
	* @author SOWMIYA
	* @return - Boolean value - "true if user is redirected to world weather page else false"
	* */
	public Boolean clickWorldWeatherCTA()
	{
		WebElement worldWeatherCTA = getDriver().findElement(byWorldWeatherCTALink);
		worldWeatherCTA.syncVisible(20);
		worldWeatherCTA.jsClick();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.syncVisible(10);
		WebElement zipcodetextfield = getDriver().findElement(byZipCodeSearchBox);
		return zipcodetextfield.syncVisible(15);
	}
	
	/**
	 * Method to verify the list of regions on browse location page
	 * @author Sowmiya
	 * @return - Boolean value - "true if list of regions are same as expected else false"
	 * */
	public Boolean verifyRegionsInBrowserLocationPage()
	{
		WebPageLoaded.isDomInteractive();
		for(int i=1; i<=expectedListOfRegions.length; i++) {
			String nameOfRegionFromPage = getDriver().findElement(By.xpath("//div[@class='result-container']/a["+i+"]")).getText();
			if(nameOfRegionFromPage.equalsIgnoreCase(expectedListOfRegions[i-1]))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Method to verify world weather is present below the list of regions and it's background color
	 * @author SOWMIYA
	 * @return - String value - "returns the color of world weather CTA"
	 * */
	public String verifyWorldWeatherCTABackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		//world weather CTA is present below the list of regions
		WebElement worldWeatherCTA = getDriver().findElement(byWorldWeatherCTAColor);
		worldWeatherCTA.syncVisible(30);
		
		//world weather CTA background color
		String colorWorldWeatherCTA = getDriver().findElement(byWorldWeatherCTAColor).getCssValue("color");
		String actualWorldWeatherCTAColour = Color.fromString(colorWorldWeatherCTA).asHex();
		return actualWorldWeatherCTAColour;
	}
	
	/**
	 * Method to verify world weather arrow is present
	 * @author SOWMIYA
	 * @return - String value - "returns if world weather CTA arrow is displayed"
	 * */
	public Boolean verifyWorldWeatherCTAArrow()
	{
		WebPageLoaded.isDomInteractive();
		//world weather CTA is present below the list of regions
		WebElement worldWeatherCTA = getDriver().findElement(byWorldWeatherCTALink);
		worldWeatherCTA.syncVisible(30);
		
		//return world weather CTA arrow
		return getDriver().findElement(arrowWorldWeatherCTA).isDisplayed();
	}
	
	/**
	 * Method to verify the user navigated to selected region
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean clickARegion()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement region = getDriver().findElement(byRegion);
		region.syncVisible(25);
		region.jsClick();
		Sleeper.sleep(3);
		WebElement worldRegions = getDriver().findElement(byWorldRegions);
		return worldRegions.syncVisible(25);
	}
	
	/**
	 * Method to verify world region appeared above the header with region selected
	 * @author SOWMIYA
	 * @return - Boolean value - "true if world region present above selected region"
	 * */
	public Boolean verifyWorldRegionAboveSelectedRegion()
	{
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byWorldRegions).syncVisible(25);
		return getDriver().findElement(byWorldRegions).isDisplayed();
	}
	
	/**
	 * Method to verify selected region appeared below the world region
	 * @author SOWMIYA
	 * @return - Boolean value - "true if selected region present below world region"
	 * */
	public Boolean verifySelectedRegionAppearBelowWorldRegion()
	{
		WebPageLoaded.isDomInteractive();;
		return getDriver().findElement(bySelectedRegion).isDisplayed();
	}
	
	/**
	 * Method to verify selected region weather is present below the list of regions and it's background color
	 * @author SOWMIYA
	 * @return - String value - "returns the color of weather CTA"
	 * */
	public String verifyWeatherCTABackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		//weather CTA is present below the list of regions
		WebElement worldWeatherCTA = getDriver().findElement(byWeatherCTAColorFromSelectedRegion);
		worldWeatherCTA.syncVisible(30);
		
		//weather CTA background color
		String colorWeatherCTA = getDriver().findElement(byWeatherCTAColorFromSelectedRegion).getCssValue("color");
		String actualWeatherCTAColour = Color.fromString(colorWeatherCTA).asHex();
		return actualWeatherCTAColour;
	}
	
	/**
	 * Method to verify selected region weather arrow is present
	 * @author SOWMIYA
	 * @return - String value - "returns if weather CTA arrow is displayed"
	 * */
	public Boolean verifyWeatherCTAArrow()
	{
		WebPageLoaded.isDomInteractive();
		//weather CTA is present below the list of regions
		WebElement weatherCTA = getDriver().findElement(byWeatherCTAColorFromSelectedRegion);
		weatherCTA.syncVisible(30);
		
		//return weather CTA arrow from selected region
		return getDriver().findElement(arrowWeatherCTAFromSelectedRegion).isDisplayed();
	}
	
	/**
	 * Method to verify the list of regions from the selected region
	 * @author Sowmiya
	 * @return - Boolean value - "true if list of regions are same as expected else false"
	 * */
	public Boolean verifyListOfRegionsFromSelectedRegion()
	{
		WebPageLoaded.isDomInteractive();
		for(int i=1; i<=expectedListOfRegionsFromSelectedRegion.length; i++) {
			String nameOfRegionFromPage = getDriver().findElement(By.xpath("//div[@class='result-container']/a["+i+"]")).getText();
			if(nameOfRegionFromPage.equalsIgnoreCase(expectedListOfRegionsFromSelectedRegion[i-1]))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Method to click on world regions CTA from selected region
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean clickWorldRegionsCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement worldRegion = getDriver().findElement(byWorldRegions);
		worldRegion.syncVisible(20);
		worldRegion.jsClick();
		Sleeper.sleep(3);
		WebElement worldWeatherCTA = getDriver().findElement(byWorldWeatherCTALink);
		return worldWeatherCTA.syncVisible(30);
	}
	
	/**
	 * Method to click on the country from a continent
	 * @author SOWMIYA
	 * */
	public void clcikCountryFromAContinent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		
		//select country
		WebElement selcetCountry = getDriver().findElement(byCountry);
		selcetCountry.isDisplayed();
		selcetCountry.jsClick();
		Sleeper.sleep(3);
		WebElement counteryWeatherCTALink = getDriver().findElement(byCounteryWeatherCTALink);
		counteryWeatherCTALink.isDisplayed();
	}
	
	/**
	 * Method to select on of the countries from a continent.
	 * Verify continent is appeared above the header with country selected
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean verifyContinentApperaAboveCountrySelected()
	{
		clcikCountryFromAContinent();
		//verify continent appear above the country selected
		WebElement headerContinent = getDriver().findElement(byContinentHeader);
		headerContinent.syncVisible(25);
		return headerContinent.isDisplayed();
	}
	
	/**
	 * Method to verify country appeared below the continent
	 * @author SOWMIYA
	 * @return - return counter name
	 * */
	public Boolean verifyCountryAppearBelowContinent()
	{
		clcikCountryFromAContinent();
		//get country header
		getDriver().findElement(byCountryHeader).syncVisible();
		return getDriver().findElement(byCountryHeader).isDisplayed();
	}
	
	/**
	 * Method to verify the list of states from the selected country
	 * @author Sowmiya
	 * @return - Boolean value - "true if list of states are same as expected else false"
	 **/
	public Boolean verifyListOfStatesFromSelectedCountry()
	{
		WebPageLoaded.isDomInteractive();
		for(int i=1; i<=expectedListOfStatesFromSelectedCountry.length; i++) {
			String nameOfRegionFromPage = getDriver().findElement(By.xpath("//div[@class='result-container']/a["+i+"]")).getText();
			if(nameOfRegionFromPage.equalsIgnoreCase(expectedListOfStatesFromSelectedCountry[i-1]))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Method to verify country weather is present below the list of states and it's background color
	 * @author SOWMIYA
	 * @return - String value - "returns the color of world weather CTA"
	 * */
	public String verifyCountryWeatherCTABackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		//country weather CTA is present below the list of regions
		WebElement countryWeatherCTA = getDriver().findElement(byCountryWeatherCTAColor);
		countryWeatherCTA.syncVisible(30);
		
		//country weather CTA background color
		String colorWorldWeatherCTA = getDriver().findElement(byCountryWeatherCTAColor).getCssValue("color");
		String actualCountryWeatherCTAColour = Color.fromString(colorWorldWeatherCTA).asHex();
		return actualCountryWeatherCTAColour;
	}
	
	/**
	 * Method to verify country weather CTA arrow is present
	 * @author SOWMIYA
	 * @return - Boolean value - "returns if world weather CTA arrow is displayed"
	 * */
	public Boolean verifyCountryWeatherCTAArrow()
	{
		WebPageLoaded.isDomInteractive();
		//country  weather CTA is present below the list of regions
		WebElement worldWeatherCTA = getDriver().findElement(byCounteryWeatherCTALink);
		worldWeatherCTA.syncVisible(30);
		
		//return world weather CTA arrow
		return getDriver().findElement(byCountryWeatherCTAArrow).isDisplayed();
	}
	
	/**
	 * Method to click on continent CTA
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean clickContinentCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement continent = getDriver().findElement(byContinentCTA);
		continent.syncVisible(20);
		continent.jsClick();
		Sleeper.sleep(3);
		WebElement continentWeatherCTA = getDriver().findElement(byContinentWeather);
		return continentWeatherCTA.syncVisible(20);
	}
	
	/**
	 * Method to click on the state from a country
	 * @author SOWMIYA 
	 * */
	public void clcikStateFromCountry()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		
		//select one of the states from country
		WebElement state = getDriver().findElement(byState);
		state.isDisplayed();
		state.jsClick();
		Sleeper.sleep(3);
		WebElement stateWeatherCTALink = getDriver().findElement(byStateWeatherCTALink);
		stateWeatherCTALink.isDisplayed();
	}
	
	/**
	 * Verify country appeared above the header with state selected
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean verifyCountryApperaAboveStateSelected()
	{
		WebPageLoaded.isDomInteractive();
		//verify country appear above the state selected
		WebElement countryHeaderAboveState = getDriver().findElement(byCountryHeaderAboveState);
		return countryHeaderAboveState.isDisplayed();
	}
	
	/**
	 * Method to verify state appeared below the country
	 * @author SOWMIYA
	 * @return - return if state header appears below country
	 * */
	public Boolean verifyStateAppearBelowCountry()
	{
		WebPageLoaded.isDomInteractive();
		WebElement stateAppearBelowCountry = getDriver().findElement(byStateHeaderBelowCountry);
		return stateAppearBelowCountry.isDisplayed();
	}
	
	/**
	 * Method to verify the list of cities from the selected state
	 * @author Sowmiya
	 * @return - Boolean value - "true if list of cities are same as expected else false"
	 **/
	public Boolean verifyListOfCitiesFromSelectedState()
	{
		WebPageLoaded.isDomInteractive();
		List<WebElement> listCities = getDriver().findElements(byCitiesList);
		int actualNumberOfCitiesInState = listCities.size();
		if(actualNumberOfCitiesInState == expectedNumberOfCititesInState)
			flag = true;
		else
		    flag = false;
		return flag;
	}
	
	/**
	 * Method to verify state weather is present below the list of states and it's background color
	 * @author SOWMIYA
	 * @return - String value - "returns the color of state weather CTA"
	 * */
	public String verifyStateWeatherCTABackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		//state weather CTA is present below the list of regions
		WebElement stateWeatherCTA = getDriver().findElement(byStateWeatherCTAColor);
		stateWeatherCTA.syncVisible(30);
		
		//state weather CTA background color
		String colorStateWeatherCTA = getDriver().findElement(byStateWeatherCTAColor).getCssValue("color");
		String actualStateWeatherCTAColour = Color.fromString(colorStateWeatherCTA).asHex();
		return actualStateWeatherCTAColour;
	}
	
	/**
	 * Method to verify state weather CTA arrow is present
	 * @author SOWMIYA
	 * @return - Boolean value - "returns if state weather CTA arrow is displayed"
	 * */
	public Boolean verifyStateWeatherCTAArrow()
	{
		WebPageLoaded.isDomInteractive();
		//state  weather CTA is present below the list of regions
		WebElement stateWeatherCTA = getDriver().findElement(byStateWeatherCTALink);
		stateWeatherCTA.syncVisible(30);
		
		//return state weather CTA arrow
		return getDriver().findElement(byStateWeatherCTAArrow).isDisplayed();
	}
	
	/**
	 * Method to click on country CTA
	 * @author SOWMIYA
	 * @return - Boolean value - "true if it navigates else false"
	 * */
	public Boolean clickCountryCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement countryCTA = getDriver().findElement(byCountryHeaderAboveState);
		countryCTA.syncVisible(20);
		countryCTA.jsClick();
		WebElement countryWeatherCTA = getDriver().findElement(byCounteryWeatherCTALink);
		return countryWeatherCTA.syncVisible(20);
	}
	
	/**
	 * Method to click on the city from a state.
	 * Verify user directed to three day weather card
	 * @author SOWMIYA 
	 * */
	public Boolean verifyThreedayWeatherCard()
	{
		WebPageLoaded.isDomInteractive();
		WebElement logoAW = getDriver().findElement(byAWLogo);
		logoAW.isDisplayed();
		WebElement city = getDriver().findElement(byCity);
		city.isDisplayed();
		city.jsClick();
		Sleeper.sleep(3);
		WebElement threeDayWeatherCard = getDriver().findElement(byThreeDayWeathercards);
		threeDayWeatherCard.syncVisible();
		return threeDayWeatherCard.isDisplayed();
	}
}
