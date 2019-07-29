package com.accuweather.glacier.www.CitySatellite;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.CitySatellitePage;
import com.accuweather.glacier.www.pages.ForeCastWeatherPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;

public class Test_CitySatellite extends AccuWeatherBaseTest {

	private LandingPage landingpage = new LandingPage();
	private ForeCastWeatherPage forecastpage = new ForeCastWeatherPage();
	private CitySatellitePage citysatellite = new CitySatellitePage();
	private NavigationBar navBar = new NavigationBar();
	String defaultWindowid;
	String actualmapboxtitle;
	String expectedmapboxtitle = "Mapbox";
	
	
	
	 @Test(priority = 1) 
	 public void isSatelliteTabDisplayed() throws AWTException, InterruptedException 
	 {
		 testStart("Is Enhanced Tab enabled by default" );
		 WebPageLoaded.isDomComplete(2000); 
		 navBar.mouseHoverOnMoreMenu();
		 waitUntilElementIsDisplayedOrClickable();
		 
		 navBar.clickTopNavStartSearchIcon();
		 waitUntilElementIsDisplayedOrClickable();
		 
		 navBar.satelliteCitylocationSearch(); 
		 navBar.enterlocationSearch();
		 waitUntilElementIsDisplayedOrClickable(); 
		 
		 WebPageLoaded.isDomComplete(3000);
		 Assert.assertTrue(forecastpage.isSatelliteTabDisplayed());
	 }
	 
	 @Test(priority = 2) 
	 public void isSatelliteTabEnabled() throws AWTException,InterruptedException 
	 {
		 testStart("Is Enhanced Tab enabled by default" );
		 WebPageLoaded.isDomComplete(2000); 
		 navBar.mouseHoverOnMoreMenu();
		 waitUntilElementIsDisplayedOrClickable();
		 navBar.clickTopNavStartSearchIcon();
		 waitUntilElementIsDisplayedOrClickable();
		 navBar.satelliteCitylocationSearch(); 
		 navBar.enterlocationSearch();
		 waitUntilElementIsDisplayedOrClickable(); 
		 WebPageLoaded.isDomComplete(3000);
		 Assert.assertTrue(forecastpage.isSatelliteTabEnabled()); 
	 }
	 
	 @Test(priority = 3) public void isEnhancedTabDisplayed() throws AWTException,
	 InterruptedException { testStart("Is Enhanced Tab enabled by default" );
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.isSatelliteTabEnabled(); forecastpage.clickOnSatelliteTab();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedTabDisplayed()); }
	 
	 @Test(priority = 4) public void isEnhancedTabEnabled() throws AWTException,
	 InterruptedException { testStart("Is Enhanced Tab enabled by default" );
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.isSatelliteTabEnabled(); forecastpage.clickOnSatelliteTab();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedTabEnabled()); }
	 
	 @Test(priority = 5) public void isStandardTabDisplayed() throws AWTException,
	 InterruptedException { testStart("Is Enhanced Tab enabled by default" );
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isStandardTabDisplayed()); }
	 
	 @Test(priority = 6) public void isVisibleTabDisplayed() throws AWTException,
	 InterruptedException { testStart("Is Enhanced Tab enabled by default" );
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isVisibleTabDisplayed()); }
	 
	 @Test(priority = 7) public void isWaterVaporTabDisplayed() throws
	 AWTException, InterruptedException {
	 testStart("Is Enhanced Tab enabled by default" );
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isWaterVaporTabDisplayed()); }
	 
	 @Test(priority = 8) public void isEnhancedHeaderDisplayed() throws
	 AWTException, InterruptedException {
	 testStart("Is Enhanced Header Displayed"); WebPageLoaded.isDomComplete(2000);
	 navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedHeaderDisplayed()); }
	 
	 @Test(priority = 9) public void isEnhancedZoomInDisplayed() throws
	 AWTException, InterruptedException {
	 testStart("Is Enhanced Header Displayed"); WebPageLoaded.isDomComplete(2000);
	 navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedZoomInDisplayed()); }
	 
	 @Test(priority = 10) public void isEnhancedZoomOutDisplayed() throws
	 AWTException, InterruptedException {
	 testStart("Is Enhanced Header Displayed"); WebPageLoaded.isDomComplete(2000);
	 navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedZoomOutDisplayed()); }
	 
	 @Test(priority = 11) public void isEnhancedMapBoxDisplayed() throws
	 AWTException, InterruptedException {
	 testStart("Is Enhanced Header Displayed"); WebPageLoaded.isDomComplete(2000);
	 navBar.mouseHoverOnMoreMenu(); waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertTrue(citysatellite.isEnhancedMapBoxDisplayed()); }
	 
	 
	 
	 @Test(priority = 12) public void isMapBoxPageDisplayed() throws AWTException,
	 InterruptedException { testStart("Is Enhanced Header Displayed");
	 WebPageLoaded.isDomComplete(2000); navBar.mouseHoverOnMoreMenu();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.clickTopNavStartSearchIcon();
	 waitUntilElementIsDisplayedOrClickable();
	 navBar.satelliteCitylocationSearch(); navBar.enterlocationSearch();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 forecastpage.clickOnSatelliteTab(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000); citysatellite.clickOnEnhancedMapBoxIcon();
	 waitUntilElementIsDisplayedOrClickable(); WebPageLoaded.isDomComplete(3000);
	 defaultWindowid = getDriver().getWindowHandle();
	 navBar.switchToPopUpWindow(defaultWindowid); actualmapboxtitle =
	 getDriver().getTitle(); waitUntilElementIsDisplayedOrClickable();
	 WebPageLoaded.isDomComplete(3000);
	 Assert.assertEquals(actualmapboxtitle,expectedmapboxtitle); }
	 
	
	@Test(priority = 13) public void isZoomInControlClickable() throws AWTException, InterruptedException {
		  testStart("Is Enhanced Header Displayed"); 
		  WebPageLoaded.isDomComplete(2000);
		  navBar.mouseHoverOnMoreMenu(); 
		  waitUntilElementIsDisplayedOrClickable();
		  navBar.clickTopNavStartSearchIcon();
		  waitUntilElementIsDisplayedOrClickable();
		  navBar.satelliteCitylocationSearch();
		  navBar.enterlocationSearch();
		  waitUntilElementIsDisplayedOrClickable(); 
		  WebPageLoaded.isDomComplete(3000);
		  forecastpage.clickOnSatelliteTab();
		  waitUntilElementIsDisplayedOrClickable(); 
		  WebPageLoaded.isDomComplete(3000);
		  citysatellite.clickOnEnhancedZoomInControl();
		  waitUntilElementIsDisplayedOrClickable(); 
		  WebPageLoaded.isDomComplete(5000);
		  }
	
}
