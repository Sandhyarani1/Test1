package com.accuweather.glacier.www.podcast;
import java.text.ParseException;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.pages.PodcastPage;

public class Test_PodcastPage extends AccuWeatherBaseTest 
{
	String PodcastTitle = "Everything Under the Sun & Daily Weather Podcasts | AccuWeather";
	String ExpectedHomePageTitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
	String ActualHomePageTitle;
	String ActiveVideoTitle;
	String PodcastListFirstVideoTitle;
	String EpisodeVideoTitle;
	String PodCastPageID;
	private NavigationBar navBar = new NavigationBar();
	private PodcastPage podpage = new PodcastPage();
//	
//	 
//	 @Test (priority=1) public void TC5_isAWLogoDisplayedOnPodcastPage() {
//	 
//	 testStart("Is AccuWeather LOGO Displayed On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 Assert.assertTrue(podpage.isAWLogoDisplayed()); }
//
//	 
//	 
//	 
//	 @Test (priority=2) public void TC5_isAWLogoTextDisplayedOnPodcastPage() {
//	 
//	 testStart("Is AccuWeather LOGO Text Displayed On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 Assert.assertTrue(podpage.isAWLogoTextDisplayed()); }
//
//	 
//	 
//	@Test(priority = 3)
//	public void TC5_isAWHomePageDisplayed() {
//		testStart("Is AccuWeather Home page Displayed From PodCast Page");
//		navBar.hoverOnMoreMenu();
//		navBar.mouseHoverOnPodcastSubMenu();
//		waitUntilElementIsDisplayedOrClickable();
//		navBar.clickOnPodcastSubMenu();
//		waitUntilWindowExistsWithTitle(PodcastTitle);
//		waitUntilElementIsDisplayedOrClickable();
//		podpage.clickOnAWLogo();
//		navBar.isAWLogoDisplayed();
//		ActualHomePageTitle = getDriver().getTitle();
//		Assert.assertEquals(ActualHomePageTitle, ExpectedHomePageTitle);
//	}
//
//	
//	 
//	 @Test(priority=4)
//	 public void TC6_isLatestEpisodeVideoDisplayed() 
//	 {
//		 testStart("Is Latest Episode Video Displayed On PodCast Page");
//		 navBar.hoverOnMoreMenu();
//		 navBar.mouseHoverOnPodcastSubMenu();
//		 waitUntilElementIsDisplayedOrClickable();
//		 navBar.clickOnPodcastSubMenu();
//		 waitUntilWindowExistsWithTitle(PodcastTitle); 
//		 ActiveVideoTitle =	podpage.getActiveVideoTitle(); 
//		 PodcastListFirstVideoTitle = podpage.getFirstPodCastListTitle();
//		 Assert.assertEquals(ActiveVideoTitle,PodcastListFirstVideoTitle);
//	 }
//
//	 
//	 
//	 
//	 
//	 
//	 @Test (priority=5) public void
//	 
//	 TC7_isDateDurationDisplayedOnActiveVideoPodcastPage() {
//	 
//	 testStart("Is Date and Duration Displayed under Active Video On PodCast Page"
//	 
//	 ); navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 waitUntilElementIsDisplayedOrClickable();
//	 
//	 Assert.assertTrue(podpage.isDateAndDurationDisplayedOnActiveVideo()); }
//
//	 
//	 
//	 
//	 
//	 
//	 @Test (priority=6) public void TC8_isAllPodCastTitleAndNumberDisplayed() {
//	 
//	 testStart("Is All PodCast Title And Number Displayed On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 Assert.assertTrue(podpage.isAllPodcastTitleNumberDisplayed()); }
//
//	 
//	 
//	 
//	 @Test (priority=7) public void
//	 
//	 TC9_isEpisodeNameDisplayedOnActiveVideoPodcastPage() {
//	 
//	 testStart("Is Active Video Episode Name Displayed under Active Video On PodCast Page"
//	 
//	 ); navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 Assert.assertTrue(podpage.isActiveVideoSubTitleDisplayed()); }
//
//	 
//	 
//	 
//	 @Test (priority=8) public void
//	 
//	 TC10_isSummaryDisplayedOnActiveVideoPodcastPage() {
//	 
//	 testStart("Is Summary of Active Video Displayed under Active Video On PodCast Page"
//	 
//	 ); navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 waitUntilElementIsDisplayedOrClickable();
//	 
//	 Assert.assertTrue(podpage.isActiveVideoSummaryTextDisplayed()); }
//
//	 
//	 
//	 
//	 
//	 
//	 @Test (priority=9) public void TC11_isActiveVideoPlayIconDisplayed() {
//	 
//	 testStart("Is Play Icon Displayed under Active Video On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 waitUntilElementIsDisplayedOrClickable();
//	 
//	 Assert.assertTrue(podpage.isActiveVideoPlayIconDisplayed()); }
//
//	 
//	 
//	 
//	 
//	 
//	 @Test (priority=10) public void
//	 
//	 TC12_isEpisodeVideoPlayedOnActiveVideoPodcastPage() {
//	 
//	 testStart("Is Episode List video played under Active Video On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle);
//	 
//	 podpage.clickOnFirstEpisodePlayIcon();
//	 
//	 Assert.assertTrue(podpage.isPauseIconDisplayedOnActiveVideo()); }
//
//	 
//	 
//	 
//	 @Test (priority=11) public void TC13_isPodcastPopUpPlayerDisplayed() {
//	 
//	 testStart("Is Pop-up Player displayed in New PodCast Window");
//	 
//	 navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle); PodCastPageID =
//	 
//	 getDriver().getWindowHandle(); 
//	 podpage.clickOnPopUpFirstEpisodePlayIcon();
//	 
//	 podpage.switchToPopUpWindow(PodCastPageID);
//	 
//	 Assert.assertTrue(podpage.isPopUpVideoTitleDisplayed()); }
//
//	 
//	 
//	
//	 
//	 @Test (priority=12) public void TC14_isPodcastPopUpvideoPlaying() {
//	 
//	 testStart("Is video under Pop-up Window playing");
//	 
//	 navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle); PodCastPageID =
//	 
//	 getDriver().getWindowHandle(); podpage.clickOnPopUpFirstEpisodePlayIcon();
//	 
//	 podpage.switchToPopUpWindow(PodCastPageID);
//	 
//	 waitUntilElementIsDisplayedOrClickable();
//	 
//	 podpage.clickOnPlayIconUnderPopUpWindow();
//	 
//	 Assert.assertTrue(podpage.isPopUpPauseIconeDisplayed());
//	 
//	 }
//
//	 
//	 
//	 
//	 
//	 
//	 @Test (priority=13) public void TC15_isShareNotificaitonMsgDisplayed() {
//	 
//	 testStart("Is Share Notification Message Displayed On PodCast Page");
//	 
//	 navBar.hoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
//	 
//	 navBar.mouseHoverOnPodcastSubMenu();
//	 
//	 waitUntilElementIsDisplayedOrClickable(); navBar.clickOnPodcastSubMenu();
//	 
//	 waitUntilWindowExistsWithTitle(PodcastTitle); 
//	 
//	 podpage.clickOnShareIconLogo();
//	 
//	 waitUntilElementIsDisplayedOrClickable();
//	 
//	 Assert.assertTrue(podpage.isShareNotificationMsgDisplayed());
//	 
//	 }	 
	
//	@Test (priority=1) public void RW_T789_VerifyResultsforPodcastPageImplementedAndPaged_loadMoreEpisodesDisplayFiveEpisodes() throws ParseException {
//		 testStart("Click load more episodes and 5 episodes are listed");
//	     navBar.hoverOnMoreMenu(); 
//	     navBar.mouseHoverOnPodcastSubMenu();
//	     navBar.clickOnPodcastSubMenu();
//		 waitUntilWindowExistsWithTitle(PodcastTitle);
//		 Assert.assertFalse(podpage.loadFiveMoreEpisodes());
//		 
//		}
//	
	@Test (priority=1) public void RW_T789_VerifyResultsforPodcastPageImplementedAndPaged_verifyEpisodesListedInDescendingOrderOfDatePublished() {
	 testStart("Is AccuWeather LOGO Displayed On PodCast Page");
     navBar.hoverOnMoreMenu(); 
     navBar.mouseHoverOnPodcastSubMenu();
     navBar.clickOnPodcastSubMenu();
	 waitUntilWindowExistsWithTitle(PodcastTitle);
	 try {
		 podpage.getAllFiveEpisodesDatePublished();
		 podpage.conditionToIterateEpisodes();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
}
