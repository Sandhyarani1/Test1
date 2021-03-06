package com.accuweather.glacier.m.pages;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class CityRadarPageMobileIpad extends MobileBasePage {
	
	

	

	
		Boolean flag;
		String[] expectedNavigationMenu = {"Now", "Radar" ,"MinuteCast", "Hourly", "Daily", "Month"};
		private By byRadarTab = By.cssSelector("div.subnav-container > div > div.subnav-items > a.subnav-item.active > h1");
		private By byBarsList = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > svg > rect");
		private By byLightMix = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div > span:nth-child(1)");
		private By bySeveremix = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div > span:nth-child(2)");
		private By byLightIce = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div > span:nth-child(1)");
		private By bySevereIce = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div > span:nth-child(2)");
		private By byLightSnow = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div > span:nth-child(1)");
		private By bySevereSnow = By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div > span:nth-child(2)");
		private By bySlideBar = By.cssSelector("div.timeline-controls > input.slider");
		private By byPlayButton = By.xpath("//input[@class='slider']/../div/div[@class='play-toggle-button icon-play']");
		private By byTimeStamp = By.cssSelector("div.timeline-controls > input ~ div.time-stamp");
		private By byFutureCTA = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(3)");
		private By byFutureCTAIsActive = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active");
		private By byPastCTA = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(2)");
		private By byPastCTAIsActive = By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div.map-button.is-active");
		private By byPastCTABelowMap = By.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[2]");
		private By byFutureCTABelowMap = By.xpath("//div/canvas[@aria-label='Map']/following::div[@class='map-tools']/div[2]/div[3]");
		private By byMapbox = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(1)");
		private By byOpenStreetMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(2)");
		private By byImproveThisMap = By.cssSelector("div.mapboxgl-ctrl-attrib-inner > a:nth-child(3)");
		private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
		private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
		private By byCloseButton = By.cssSelector("div.close-button");
		private By byZoomIn = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
		private By byZoomOut = By.cssSelector("div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
		private By byTooltip = By.cssSelector("div.map-header > div > div.icon-tooltip");
		private By byTooltipActive = By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
		private By byTooltipHeader = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-header > span");
		private By byTooltipDescription = By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
		private By byRadarTabColor = By.cssSelector("div.subnav-items > a.subnav-item.active");
		private By byMapHeader = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");
		private By byNavigationMenusList = By.cssSelector("div.subnav-items > a");
		private By byRadarNavigationMenu = By.cssSelector("div.subnav-items > a:nth-child(2)");
		  private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
		     private By byRadarSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(2) > a > h4");
		
		/**
		 * Method to verify severe text below the Mix legend
		 * @author Mohammed
		 * @return - Boolean value - "true if light and severe link are present else false"
		 * */
		public Boolean verifyLightAndSeverFromMixLegend()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement light = getDriver().findElement(byLightMix);
			WebElement severe = getDriver().findElement(bySeveremix);
			return getDriver().findElements(byLightMix).size()>0 && getDriver().findElements(bySeveremix).size()>0;
		}
		
		/**
		 * Method to verify color vary from light to dark
		 * @author Mohammed
		 * @return - Boolean value - "true if the color gradually increases from light to dark else false"
		 * */
		public Boolean verifyColorVaryFromLightToDark()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
	 	    List<WebElement> listBars = getDriver().findElements(byBarsList);

	 	   float colorLight = 0;
	 	    for(int i=2; i<=listBars.size(); i++) {
	 	    	String getPercentageOfEachKey   = getDriver().findElement(By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > svg > rect:nth-child("+i+")")).getAttribute("x");
	 	        String percentage = getPercentageOfEachKey.substring(0, getPercentageOfEachKey.length()-1);
	 			float colorDark = Float.parseFloat(percentage);
	 	    	if(colorDark > colorLight) {
	 	    		flag = true;
	 	    		colorLight = colorDark;
	 	    	}
	 	    	else 
	 	    		flag = false;
	 	    	    break;
	 	    }
			return flag;
		}
		
		/**
		 * Method to verify severe text below the Ice legend
		 * @author Mohammed
		 * @return - Boolean value - "true if light and severe link are present else false"
		 * */
		public Boolean verifyLightAndSeverFromIceLegend()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement light = getDriver().findElement(byLightIce);
			WebElement severe = getDriver().findElement(bySevereIce);
			return getDriver().findElements(byLightIce).size()>0 && getDriver().findElements(bySevereIce).size()>0;
		}
		
		/**
		 * Method to verify severe text below the snow legend
		 * @author Mohammed
		 * @return - Boolean value - "true if light and severe link are present else false"
		 * */
		public Boolean verifyLightAndSeverFromSnowLegend()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement light = getDriver().findElement(byLightSnow);
			WebElement severe = getDriver().findElement(bySevereSnow);
			return getDriver().findElements(byLightSnow).size()>0 && getDriver().findElements(bySevereSnow).size()>0;
		}
		
		/**
		 * Method to verify presence of slide bar with play button and time at the end of the bar
		 * @author Mohammed
		 * @return - Boolean value - "true if slidebar, playbutton and timestamp are present else false"
		 * */
		public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement slideBar = getDriver().findElement(bySlideBar);
			WebElement playButton = getDriver().findElement(byPlayButton);
			WebElement timeStamp = getDriver().findElement(byTimeStamp);
			return getDriver().findElements(bySlideBar).size()>0 && getDriver().findElements(byPlayButton).size()>0 && getDriver().findElements(byTimeStamp).size()>0 ;
		}
		
		/**
		 * Method to toggle between past and future CTA 
		 * @author Mohammed
		 * @return - Boolean value - "true if past and future cta is active depending on what Cta is selected else false"
		 * */
		public Boolean toggleBetweenPastAndFutureCTA()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement ctaFuture = getDriver().findElement(byFutureCTA);
			ctaFuture.click();
			WebElement ctaFutureActive = getDriver().findElement(byFutureCTAIsActive);
			WebElement ctaPast = getDriver().findElement(byPastCTA);
			ctaPast.click();
			WebElement ctaPastActive = getDriver().findElement(byPastCTAIsActive);
			return ctaPastActive.syncVisible();
		}
		
		/**
		 * Method to verify timeline controls like Past and Future CTA below the map
		 * @author Mohammed
		 * @return - Boolean value - "true if past and future cta is below the map else false"
		 * */
		public Boolean verifyPastAndFutureCTABelowMap()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement pastCTABelowMap = getDriver().findElement(byPastCTABelowMap);
			WebElement futureCTABelowMap = getDriver().findElement(byFutureCTABelowMap);
			return true;
		}
		
		/**
		 * Method to verify PAST CTA highlighted by default on city Weather Radar page
		 * @author Mohammed
		 * @return - Boolean value - "true if past is active else false"
		 * */
		public Boolean locatePastCTAHighlightedByDefault()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement ctaPastActive = getDriver().findElement(byPastCTAIsActive);
			return true;
		}
		
		/**
		 * Method to click mapbox
		 * @author Mohammed
		 * */
		public void clickMapbox()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement mapbox = getDriver().findElement(byMapbox);
			Sleeper.sleep(3);
			mapbox.jsClick();
			Sleeper.sleep(8);
		}
		
		/**
		 * Method to click open street map
		 * @author Mohammed
		 * */
		public void clickOpenStreetMap()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement openStreetMap = getDriver().findElement(byOpenStreetMap);
			Sleeper.sleep(3);
			openStreetMap.jsClick();
			Sleeper.sleep(6);
		}
		
		/**
		 * Method to click improve this map
		 * @author Mohammed
		 * */
		public void clickImproveThisMap()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement improveThisMap = getDriver().findElement(byImproveThisMap);
			Sleeper.sleep(3);
			improveThisMap.jsClick();
			Sleeper.sleep(4);
		}
		
		/**
		 * Click full screen button of the map
		 * verify Map opens up into full screen with timeline controls, slider with play button, and legend and if you click on x symbol the map switches back to normal
		 * @author Mohammed
		 * */
		public Boolean clickFullScreenButtonOfMap()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement map = getDriver().findElement(byMap);
			
			//get small screen width and height
			int smallScreenWidth = map.getSize().getWidth();
			int smallcreenHeight = map.getSize().getHeight();
			
			//click fullscreen button
			WebElement fullScreenBtn = getDriver().findElement(byFullScreenBtn);
			fullScreenBtn.jsClick();
			
			//get fullscreen map width and height
			int afterFullScreenWidth = map.getSize().getWidth();
			int afterFullScreenHeight = map.getSize().getHeight();
			
			if(afterFullScreenWidth > smallScreenWidth && afterFullScreenHeight > smallcreenHeight) {
				//future cta
				WebElement ctaFuture = getDriver().findElement(byFutureCTA);
				//past cta
				WebElement ctaPast = getDriver().findElement(byPastCTA);
				//play button and slider bar
				WebElement slideBar = getDriver().findElement(bySlideBar);
				WebElement playButton = getDriver().findElement(byPlayButton);
				playButton.syncVisible();
				//click 'x' at the top right corner
				WebElement closeButton = getDriver().findElement(byCloseButton);
				closeButton.click();
			}
			
			//again take small screen width and height and verify the width and height
			int screenWidth = map.getSize().getWidth();
			int screenHeight = map.getSize().getHeight();
			if(smallScreenWidth == screenWidth && smallcreenHeight == screenHeight)
				flag = true;
			else
				flag = false;
			
			return flag;
		}
		
		/**
		 * Method to click zoom in and zoom out of the map
		 * @author Mohammed
		 * */
		public void clickZoomInAndZoomOut()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement zoomIn = getDriver().findElement(byZoomIn);
			zoomIn.jsClick();
			WebElement zoomOut = getDriver().findElement(byZoomOut);
			zoomOut.jsClick();
		}
		
		/**
		 * Method to verify tooltip background color in orange
		 * @author Mohammed
		 * return tooltip color
		 * */
		public String verifyTootipBackgroundColor()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.syncVisible();
			toolTip.jsClick();
			String colorTooltip = getDriver().findElement(byTooltipActive).getCssValue("background-color");
			String actualcolourdisplayed = Color.fromString(colorTooltip).asHex();
			return actualcolourdisplayed;
		}
		
		/**
		 * Method to verify tooltip background color in orange
		 * @author Mohammed
		 * return tooltip header color
		 * */
		public String verifyTootipHeaderBackgroundColor()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.jsClick();
			String colorTooltip = getDriver().findElement(byTooltipHeader).getCssValue("color");
			String actualColourdisplayed = Color.fromString(colorTooltip).asHex();
			return actualColourdisplayed;
		}
		
		/**
		 * Method to get tooltip description
		 * @author Mohammed
		 * return tooltip description
		 * */
		public String verifyTooltipDescription()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.jsClick();
			WebElement tooltipDescription = getDriver().findElement(byTooltipDescription);
			String getTooltipDescription = tooltipDescription.getText();
			return getTooltipDescription;
		}
		
		/**
		 * Method to get the radar tab boarder highlighted color
		 * @author Mohammed
		 * return radar tab color
		 * */
		public String verifyRadarTabHighlightedColor()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			String radarBoarderColor = getDriver().findElement(byRadarTabColor).getCssValue("border-top");
			System.out.println("radarBoarderColor:"+radarBoarderColor);
			String boarderColor = radarBoarderColor.substring(10);
			String actualColourdisplayed = Color.fromString(boarderColor).asHex();
			return actualColourdisplayed;
		}
		
		/**
		 * Method to get title of the map on map header
		 * @author Mohammed
		 * return map header text
		 * */
		public String getMapHeader()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement mapHeader = getDriver().findElement(byMapHeader);
			String mapHeaderText = mapHeader.getText();
			return mapHeaderText;
		}
		
		/**
		 * Method to verify on click of tooltip again, the tooltip closes
		 * @author Mohammed
		 * return tooltip color
		 * */
		public String verifyToolTipClosed()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarTab);
			WebElement toolTip = getDriver().findElement(byTooltip);
			toolTip.jsClick();
			WebElement toolTipActive = getDriver().findElement(byTooltipActive);
			toolTipActive.jsClick();
			String tootltipColor = getDriver().findElement(byTooltip).getCssValue("color");
			String actualColourdisplayed = Color.fromString(tootltipColor).asHex();
			return actualColourdisplayed;
		}
		
		/**
		 * Method to verify the presence of navigation menu n city forecast page
		 * @author Mohammed
		 * @return - Boolean value - "true if navigation menu matches the expected one"
		 * */
		public Boolean verifyPresenceOfNavigationMenus()
		{
			WebPageLoaded.isDomInteractive();
	 	    List<WebElement> navigationMenusList = getDriver().findElements(byNavigationMenusList);
	 	    for(int i=1; i<=navigationMenusList.size(); i++) {
	 	    	String actualNavigationMenu = getDriver().findElement(By.cssSelector("div.subnav-items > a:nth-child("+i+")")).getText();
	 	       if(actualNavigationMenu.equalsIgnoreCase(expectedNavigationMenu[i-1])) {
	 	    		flag = true;
	 	            continue;}
	 	    	else 
	 	    		flag = false;
	 	            break;
	 	    }
			return flag;
		}
		
		/**
		 * Method to click radar navigation menu
		 * @author Mohammed
		 * */
		public void clickRadarNavigationMenu()
		{
			WebPageLoaded.isDomInteractive();
			WebElement radarTab = getDriver().findElement(byRadarNavigationMenu);
			radarTab.jsClick();
			Sleeper.sleep(3);
		}
		
		
		public void mouseHoverOnRadarAndMaps() {
	    	WebPageLoaded.isDomInteractive();
	        WebElement radarandmaps = getDriver().findElement(byRadarMaps);
	        radarandmaps.syncVisible(15);
	        radarandmaps.hover();
	    }
	    
	     public boolean isRadarSubMenuDisplayed() {
	    	WebPageLoaded.isDomInteractive();
	        WebElement radar = getDriver().findElement(byRadarSubMenu);
	        radar.syncVisible(15);
	        return radar.isDisplayed();    	   	
	    }
	    
	    public void navigateToRadar() {
	    getDriver().findElement(byRadarSubMenu).click();
	    }
	    
	    public void switchToPopUpWindow(String defaultwindow) {
    		
    		Set<String> windows = getDriver().getWindowHandles();
    		Iterator iterator = windows.iterator();
    		String currentwindowId;
    		while(iterator.hasNext()) {
    		currentwindowId = iterator.next().toString();
    		    		if(!currentwindowId.equals(defaultwindow)) {
    			getDriver().switchTo().window(currentwindowId);
    			
    		}
    	}
    		
	}
	    
}


