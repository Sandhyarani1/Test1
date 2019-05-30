package com.accuweather.glacier.www.pages;

import java.util.Iterator;
import java.util.List;
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

public class PodcastPage extends BasePage {

	private By byAWSunLogo = By.cssSelector("div.podcast-landing > div.container-wrapper.lead > div.container > a > svg > g > g > path");
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
	private By byShareImageText = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > span");
	private By byShareNotificationText = By.cssSelector("div > div.content > div.share-container > div.share-text-icon > div");
	private By byListOfAllEpisodes = By.cssSelector("body > div.podcast-landing > div:nth-child(2) > div > div:nth-child(1)");

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
		WebPageLoaded.isDomInteractive();
		WebElement playicon = getDriver().findElement(byPodcastListFirstEpisodePlayIcon);
		playicon.syncVisible(15);
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
		playicon.click();
		
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
		WebElement shareicon = getDriver().findElement(byShareImageIcon);
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
}
