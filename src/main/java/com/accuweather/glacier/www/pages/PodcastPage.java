package com.accuweather.glacier.www.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class PodcastPage extends BasePage {
	ArrayList<String> episodesDatePublishesList;
	
	private By byAWSunLogo = By.cssSelector("div.podcast-landing > div.container-wrapper.lead > div.container > a");
	private By byAWTextLogo = By.cssSelector("div.container > a > svg > g > path");
	private By byActiveVideoDate = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[1]/span[contains(.,'minutes')]/..");
	private By byActiveVideoMinuteText = By.cssSelector("div.container > div > div.content > div.meta > span");
	private By byActiveVideoTitleText = By.cssSelector("div.container > div > div.content > div.title");
	private By byActiveVideoSubTitleText = By.cssSelector("div.container > div > div.content > div.subtitle");
	private By byActiveVideoPlayIcon = By.cssSelector("div > div.content > div.audio-player > div.icon-play");
	private By byActiveVideoPauseIcon = By.cssSelector("div > div.content > div.audio-player > div.icon-pause");
	private By byActiveVideoSummaryText = By.cssSelector("div.container > div > div.content > div.summary");
	private By byActiveVideoPopUpImage = By.cssSelector("div > div.content > div.share-container > div.popup-text-icon > img");
	private By byActiveVideoPopUpSpanText = By.cssSelector("div.container > div > div.content > div.share-container > div.popup-text-icon > span");
	private By byActiveVideoShareImage = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > img");
	private By byActiveVideoShareSpanText = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > span");
	private By byPodcastListFirstEpisodeTitleText = By.cssSelector("div:nth-child(1) > div.content > div.title");
	private By byPodcastListFirstEpisodeSubTitleText = By.cssSelector("div:nth-child(1) > div:nth-child(1) > div.content > div.subtitle");
	private By byPodcastListFirstEpisodeSummaryText = By.cssSelector("div > div:nth-child(1) > div:nth-child(1) > div.content > div.summary");
	private By byPodcastListFirstEpisodePlayIcon = By.cssSelector("div > div:nth-child(1) > div:nth-child(2) > div.play-icon-container > div");
	private By byPopUpVideoTitleText = By.cssSelector("div.podcast-landing.popup > div > div > div.title");
	private By byPopUpVideoSubTitleText = By.cssSelector("div > div > div.subtitle");
	private By byPopUpVideoPlayIcon = By.cssSelector(" div.podcast-landing.popup > div > div.content > div.audio-player > div.icon-play");
	private By byPopUpVideoPauseIcon = By.cssSelector("div.podcast-landing.popup > div > div.content > div.audio-player > div.icon-pause");
	private By byLoadMoreEpisodesLink = By.cssSelector("div > div.load-more");
	private By byShareImageIcon = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > img");
	private By byShareImageText = By.cssSelector("div.share-text-icon > span");
	private By byShareNotificationText = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > div");
	private By byListOfAllEpisodes = By.cssSelector("body > div.podcast-landing > div:nth-child(2) > div > div:nth-child(1)");
	private By byEpisodeDateMonthYear = By.cssSelector("div:nth-child(1) > div:nth-child(5) > div.content > div.meta");
	
	/*
	 * Method to verify the AccuWeather LOGO is displayed PodCast page
	 */
	public boolean isAWLogoDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement awlog = getDriver().findElement(byAWSunLogo);
		awlog.syncVisible(15);
		return awlog.isDisplayed();
	}
	
	
	/*
	 * Method to click on the AccuWeather LOGO PodCast page
	 */
	public void clickOnAWLogo() {
		WebPageLoaded.isDomInteractive();
		WebElement awlogo = getDriver().findElement(byAWSunLogo);
		awlogo.syncVisible(15);
		awlogo.hover();
		awlogo.click();
	}

	/*
	 * Method to click on the AccuWeather LOGO PodCast page
	 */
	public void clickOnAWLogoText() {
		WebPageLoaded.isDomInteractive();
		WebElement awlogotext = getDriver().findElement(byAWTextLogo);
		awlogotext.syncVisible(15);
		awlogotext.hover();
		awlogotext.click();
	}

	/*
	 * Method to verify the AccuWeather LOGO Text is displayed PodCast page
	 */
	public boolean isAWLogoTextDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement awlogtext = getDriver().findElement(byAWTextLogo);
		awlogtext.syncVisible(15);
		return awlogtext.isDisplayed();
	}

	/*
	 * Method to get the size of All Episodes on the PodCast page
	 */

	public int getSizeOfAllPodcastEpisodeList() {
		WebPageLoaded.isDomInteractive();
		List<WebElement> allepisodesize = getDriver().findElements(byListOfAllEpisodes);
		return allepisodesize.size();

	}

	/*
	 * Method to get the Episode Title on the PodCast page
	 */
	public String getAllEpisodeTitle() {
		String episodetitle = "";
		for (int i = 5; i > 0; i--) {
			WebElement episodetitles = getDriver().findElement(
					By.cssSelector("div > div:nth-child(1) > div:nth-child(" + i + ") > div.content > div.title"));
			episodetitle = episodetitles.getText();
			}
		return episodetitle;

	}

	/*
	 * Method to get the Episode Title from Active Video on the PodCast page
	 */
	public String getActiveVideoTitle() {
		WebPageLoaded.isDomInteractive();
		WebElement activevideotitle = getDriver().findElement(byActiveVideoTitleText);
		activevideotitle.syncVisible(15);
		return activevideotitle.getText();
	}

	/*
	 * Method to get the Episode Title from First PodCast List on the PodCast page
	 */
	public String getFirstPodCastListTitle() {
		WebPageLoaded.isDomInteractive();
		WebElement podcastlistfirsttitle = getDriver().findElement(byPodcastListFirstEpisodeTitleText);
		podcastlistfirsttitle.syncVisible(15);
		return podcastlistfirsttitle.getText();
	}
	
	/*
	 * Method to verify Date and Duration is displayed under Active Video on the PodCast page
	 */
	public boolean isDateAndDurationDisplayedOnActiveVideo() {
		WebPageLoaded.isDomInteractive();
		WebElement dateandduration = getDriver().findElement(byActiveVideoDate);
		dateandduration.syncVisible(15);
		return dateandduration.isDisplayed();
	}
	
	/*
	 * Method to get the Date and Duration under Active Video on the PodCast page
	 */
	public String getDateAndDurationOnActiveVideo() {
		WebPageLoaded.isDomInteractive();
		WebElement dateandduration = getDriver().findElement(byActiveVideoDate);
		dateandduration.syncVisible(15);
		return dateandduration.getText();
	}
	
	/*
	 * Method to MouseHover on the Play Icon next to the First Episode List PodCast page
	 */
	public void mouseHoverOnDescriptionLink() {
    	WebPageLoaded.isDomInteractive();
        WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
        playicon.syncVisible(15);
        playicon.hover();
       }
	
	/*
	 * Method to click on the Play Icon next to the First Episode List PodCast page
	 */
	public void clickOnFirstEpisodePlayIcon() {
		Sleeper.sleep(5);
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
		playicon.syncVisible(15);
		Sleeper.sleep(5);
		playicon.jsClick();
		
	}
	
	
	
	/*
	 * Method to click on the PopUp Icon next to the First Episode List PodCast page
	 */
	public void clickOnPopUpFirstEpisodePlayIcon() {
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byActiveVideoPopUpImage);
		playicon.syncVisible(15);
		playicon.jsClick();
		Sleeper.sleep(2);
	}
	
	/*
	 * Method to get Location of the Play Icon next to the First Episode List PodCast page
	 */
	public Point getLocationOfFirstEpisodePlayIcon() {
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
		playicon.syncVisible(15);
		return playicon.getLocation();
	}
	
	/*
	 * Method to get X Coordinate on the Play Icon next to the First Episode List PodCast page
	 */
	public int getXCoordinateOfFirstEpisodePlayIcon() {
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
		playicon.syncVisible(15);
		return playicon.getLocation().getX();
	}
	
	/*
	 * Method to get Y Coordinate on the Play Icon next to the First Episode List PodCast page
	 */
	public int getYCoordinateOfFirstEpisodePlayIcon() {
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
		playicon.syncVisible(15);
		return playicon.getLocation().getY();
	}
	
	
	/*
	 * Method to verify Pause Icon is displayed under Active Video on the PodCast page
	 */
	public boolean isPauseIconDisplayedOnActiveVideo() {
		WebPageLoaded.isDomInteractive();
		WebElement activevideopauseicon = getDriver().findElement(byActiveVideoPauseIcon);
		activevideopauseicon.syncVisible(15);
		return activevideopauseicon.isDisplayed();
	}
	
	/*
	 * Method to verify Summary of Active Video is displayed under 
	 * Active Video on the PodCast page
	 */
	public boolean isActiveVideoSummaryTextDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement activevideosummary = getDriver().findElement(byActiveVideoSummaryText);
		activevideosummary.syncVisible(15);
		return activevideosummary.isDisplayed();
	}
	
	/*
	 * Method to verify Active Video Sub Title is displayed under 
	 * Active Video on the PodCast page
	 */
	public boolean isActiveVideoSubTitleDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement activevideosubtitle = getDriver().findElement(byActiveVideoSubTitleText);
		activevideosubtitle.syncVisible(15);
		return activevideosubtitle.isDisplayed();
	}
	
	/*
	 * Method to verify Play Button is displayed under 
	 * Active Video on the PodCast page
	 */
	public boolean isActiveVideoPlayIconDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement activevideoplayicon = getDriver().findElement(byActiveVideoPlayIcon);
		activevideoplayicon.syncVisible(15);
		return activevideoplayicon.isDisplayed();
	}
	
	/*
	 * Method to display Episode Title on the PodCast page
	 */
	public boolean isAllEpisodeTitleDisplayed() {
		boolean episodetitle = true ;
		for (int i = 5; i > 0; i--) {
			@SuppressWarnings("unused")
			boolean episodetitles = getDriver().findElement(
					By.cssSelector("div > div:nth-child(1) > div:nth-child(" + i + ") > div.content > div.title")).isDisplayed();
					}
		return episodetitle;

	}
	
	/*
	 * Method to display Episode Title on the PodCast page
	 */
	public boolean isAllPodcastTitleNumberDisplayed() {
		
		for (int i = 5; i > 0; i--) {
			@SuppressWarnings("unused")
			boolean episodetitles = getDriver().findElement(
					By.cssSelector("div > div:nth-child(1) > div:nth-child(" + i + ") > div.content > div.title")).syncVisible(10);
					}
		return true;

	}
	
		
	/*
	 * Method to verify Pop-Up video title is displayed under 
	 * New Window
	 */
	public boolean isPopUpVideoTitleDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement popupvideotitle = getDriver().findElement(byPopUpVideoTitleText);
		popupvideotitle.syncVisible(15);
		return popupvideotitle.isDisplayed();
	}
	
	public void switchToPopUpWindow(String podcastpage) {
		
		Set<String> windows = getDriver().getWindowHandles();
		System.out.println(windows.size());
		Iterator iterator = windows.iterator();
		String currentwindowId;
		while(iterator.hasNext()) {
		currentwindowId = iterator.next().toString();
		System.out.println("currentwindowId currentwindowId... " +currentwindowId);
		if(!currentwindowId.equals(podcastpage)) {
			getDriver().switchTo().window(currentwindowId);
			
		}
	}
		
}
	
	/*
	 * Method to click on the Play Icon under PopUp Window PodCast page
	 */
	public void clickOnPlayIconUnderPopUpWindow() {
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPopUpVideoPlayIcon);
		playicon.syncVisible(15);
		playicon.jsClick();
		
	}
	
	/*
	 * Method to verify Pause Icon is displayed under New Window
	 */
	public boolean isPopUpPauseIconeDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement popuppauseicon = getDriver().findElement(byPopUpVideoPauseIcon);
		popuppauseicon.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return popuppauseicon.isDisplayed();
	}
	
	/*
	 * Method to click on the Share Icon LOGO under PodCast page
	 */
	public void clickOnShareIconLogo() {
		WebPageLoaded.isDomInteractive();
		WebElement shareicon = getDriver().findElement(byShareImageText);
		shareicon.syncVisible(15);
		shareicon.hover();
		shareicon.click();
	}
	
	/*
	 * Method to verify the Share Notification message is displayed under New Window
	 */
	public boolean isShareNotificationMsgDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement sharenotificationmsg = getDriver().findElement(byShareNotificationText);
		sharenotificationmsg.syncVisible(30);
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return sharenotificationmsg.isDisplayed();
	}
	
	/**
	 * Method to verify five episodes are loaded on click of load more episodes link. 
	 * 
	 * @author Sowmiya
	 * return Boolean 
	 */
	public boolean loadFiveMoreEpisodes() {
		Boolean flag = null;
		WebElement loadMoreEpisodesLink = getDriver().findElement(byLoadMoreEpisodesLink);
		loadMoreEpisodesLink.syncVisible(15);
		loadMoreEpisodesLink.click();
		
		//verify five episodes are loaded
		for (int i = 6; i<=10; i++) {
			getDriver().findElement(By.cssSelector("div.podcast-landing > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(" + i + ")")).syncVisible(15);
		    
			if(i==10)
			   flag = getDriver().findElement(By.cssSelector("div.podcast-landing > div:nth-child(2) > div > div:nth-child(1) > div:nth-child(11)")).syncVisible(15, false);
				
		}
     return flag;
	}
	
	/**
	 * Method to verify five episodes are loaded on click of load more episodes link. 
	 * 
	 * @author Sowmiya
	 * return Boolean 
	 * @throws ParseException 
	 */
	public void getAllFiveEpisodesDatePublished() throws ParseException {
		
		WebElement loadMoreEpisodesLink = getDriver().findElement(byLoadMoreEpisodesLink);
		loadMoreEpisodesLink.syncVisible(15);
		loadMoreEpisodesLink.click();
		episodesDatePublishesList = new ArrayList<String>();
		//get 5 episodes data publishes in arraylist
		for (int i = 6; i<=10; i++) {
	           getDriver().findElement(By.cssSelector("div:nth-child(1) > div:nth-child("+i+") > div.content > div.meta")).syncVisible(15);
		       String datePublishedWithMinutes =  getDriver().findElement(By.cssSelector("div:nth-child(1) > div:nth-child("+i+") > div.content > div.meta")).getText();
		       episodesDatePublishesList.add(datePublishedWithMinutes);
		}
		    System.out.println("ArrayList:"+episodesDatePublishesList);   
		
	}
	
	
	/**
	 * Method to verify episodes are listed in descending order of date published 
	 * @author Sowmiya
	 * return Boolean - true if episodes are listed in expected order
	 * @throws ParseException 
	 */
	public Boolean verifyEpisodesListedInDescendingOrderOfDatePublished(int x, int y) throws ParseException {
		Boolean flag;
		
		String episode1 = episodesDatePublishesList.get(x);
		String episode2 = episodesDatePublishesList.get(y);
		
		//get year and compare
		String strYear1 = getYearFromDatePublished(episode1);
		String strYear2 = getYearFromDatePublished(episode2);
		
		int intYear1 = Integer.parseInt(strYear1);  
		int intYear2 = Integer.parseInt(strYear2);  
		
		if(intYear1 > intYear2)
			flag = true;
		
		else if (intYear1 == intYear2) {
			//verify month 
			int month1 = getMonthFromDatePublished(episode1);
			int month2 = getMonthFromDatePublished(episode2);
			
			if(month1 > month2) 
				flag = true;
			
			else if (month1 == month2) {
				//get dates
				String date1 = getDateFromDatePublished(episode1);
				String date2 = getDateFromDatePublished(episode2);
			
				int intDate1 = Integer.parseInt(date1);
				int intDate2 = Integer.parseInt(date2);
				
				//validate dates
				if(intDate1 > intDate2)
					flag = true;
				else
					flag = false;
			} 
			else 
				flag = false;
		} 
		else
			flag = false;
		
		return flag;
	}
	
	/**
	 * Method to verify episodes are listed in descending order of date published 
	 * @author Sowmiya
	 * return Boolean - true if episodes are listed in expected order
	 * @throws ParseException 
	 */
	public void conditionToIterateEpisodes() throws ParseException {
		 int i=0;
		 if(i<4) {
			 int x = i;
			 i++;
			 int y= i;
			 //pass x and y value to descending order function
			 verifyEpisodesListedInDescendingOrderOfDatePublished(x, y);
		 }
	}
	
	
	
	/**
	 * Method to get year from the episodes
	 * @author Sowmiya
	 * return Boolean - Year
	 * @throws ParseException 
	 */
	public String getYearFromDatePublished(String datePublishedWithMinutes) throws ParseException
	{
	       String datePublished = datePublishedWithMinutes.substring(0, datePublishedWithMinutes.indexOf('-'));
	       String strMonthYearDate = datePublished.replaceAll("\\s+$", "");
	       
	       //get year
	       String getYear = strMonthYearDate.substring(strMonthYearDate.length()-4);
	       System.out.println("YEAR::::::::::"+getYear);
	       
	       return getYear; 
	}
	
	/**
	 * Method to get date from the episodes
	 * @author Sowmiya
	 * return Boolean - Date
	 * @throws ParseException 
	 */
		public String getDateFromDatePublished(String datePublishedWithMinutes) throws ParseException
		{
			   String datePublished = datePublishedWithMinutes.substring(0, datePublishedWithMinutes.indexOf('-'));
		       String strMonthYearDate = datePublished.replaceAll("\\s+$", "");
		       
		       //get Year
		       String getYear = strMonthYearDate.substring(strMonthYearDate.length()-4);
		       System.out.println("YEAR::::::::::"+getYear);
		       
		       //get date
		       String strMonthDate = strMonthYearDate.substring(0, datePublishedWithMinutes.indexOf(','));
		       String getDate = strMonthDate.substring(strMonthDate.length()-2).trim();
		       
		       System.out.println("DATE::::::::::::"+getDate);
		       
		       return getDate;
		}

		/**
		 * Method to get month from the episodes
		 * @author Sowmiya
		 * return Boolean - Month in int
		 * @throws ParseException 
		 */
	public int getMonthFromDatePublished(String datePublishedWithMinutes) throws ParseException
	{
		String datePublished = datePublishedWithMinutes.substring(0, datePublishedWithMinutes.indexOf('-'));
	       String strMonthYearDate = datePublished.replaceAll("\\s+$", "");
	       
	       String getYear = strMonthYearDate.substring(strMonthYearDate.length()-4);
	       System.out.println("YEAR::::::::::"+getYear);
	       
	       //get date
	       String strMonthDate = strMonthYearDate.substring(0, datePublishedWithMinutes.indexOf(','));
	       String getDate = strMonthDate.substring(strMonthDate.length()-2);
	       System.out.println("DATE::::::::::::"+getDate);
	       
	       //get month
	       String trimDate = strMonthDate.replaceAll("[0-31]","");
	       String monthName = trimDate.replaceAll("\\s+$", "");
	       
	       Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthName);
	       Calendar cal = Calendar.getInstance();
	       cal.setTime(date);
	       int getMonth = cal.get(Calendar.MONTH);
	       System.out.println(getMonth+1);
	       
	       return getMonth+1;
	}
}
