package com.accuweather.glacier.www.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;



public class AccuWeatherReady extends BasePage
{
	private By byAWVideo = By.cssSelector("div.content-module.zone-centerWell1 > div.video-player");
	private By byCheckListDownloadHeading = By.cssSelector("div.checklist.content-module > div.checklist-header");
	private By byChecklist1 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(1) > span.checklist-text");
	private By byChecklist2 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(2) > span.checklist-text");
	private By byChecklist3 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(3) > span.checklist-text");
	private By byChecklist4 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(4) > span.checklist-text");
	private By byChecklist5 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(5) > span.checklist-text");
	private By byChecklist6 = By.cssSelector("div.checklist.content-module > div.checklist-grid > a:nth-child(6) > span.checklist-text");
	private By byPreviousIcon = By.cssSelector("div.jw-reset.jw-button-container > div.jw-icon.jw-icon-inline.jw-button-color.jw-reset.jw-icon-playback");
	
	private NavigationBar navBar = new NavigationBar();
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL for AccuWeather Ready page
	 * */
	public String getAWReadyPageURL()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the title for AccuWeather Ready page
	 * */
	public String getAWReadyPageTitle()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		
		return getDriver().getTitle();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to check if the video is present below the AW logo
	 * @return : Boolean -> true if video is present else false
	 * */
	public Boolean isAWVideoPresent()
	{
		WebPageLoaded.isDomInteractive();
		WebElement awVideo = getDriver().findElement(byAWVideo);
		awVideo.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return awVideo.isDisplayed();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist Header
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklistHeader()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checklistHeader = getDriver().findElement(byCheckListDownloadHeading);
		return checklistHeader.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 1
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist1()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList1 = getDriver().findElement(byChecklist1);
		return checkList1.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 2
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist2()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList2 = getDriver().findElement(byChecklist2);
		return checkList2.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 3
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist3()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList3 = getDriver().findElement(byChecklist3);
		return checkList3.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 4
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist4()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList4 = getDriver().findElement(byChecklist4);
		return checkList4.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 5
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist5()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList5 = getDriver().findElement(byChecklist5);
		return checkList5.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the text of Checklist 6
	 * @return -> String : value of checklist and download text
	 * */
	public String getTextOfChecklist6()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		WebElement checkList6 = getDriver().findElement(byChecklist6);
		return checkList6.getText();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 1
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist1()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist1).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 2
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist2()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist2).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 3
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist3()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist3).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 4
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist4()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist4).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 5
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist5()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist5).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * @author Hasan Faraz
	 * Method to get the URL of Checklist 6
	 * @return -> String : URL of checklist window
	 * */
	public String getURLOfChecklist6()
	{
		navBar.hoverOnSevereWeather();
		navBar.navigateToAccuWeatherReady();
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(10);
		getDriver().findElement(byChecklist6).jsClick();
		switchToCheckListWindow();
		return getDriver().getCurrentUrl();
	}
	
	/**
	 * Method to switch to checklist window
	 * @author Hasan Faraz
	 * */
	public void switchToCheckListWindow()
	{
		String window = getDriver().getWindowHandle();
		switchToDifferentTab(window);
		Sleeper.sleep(20);
		WebPageLoaded.isDomInteractive();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
}
