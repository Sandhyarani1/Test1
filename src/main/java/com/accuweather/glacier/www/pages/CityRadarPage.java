package com.accuweather.glacier.www.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class CityRadarPage extends BasePage
{
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
	private By byMapHeader = By.cssSelector("div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byNavigationMenusList = By.cssSelector("div.subnav-items > a");
	
	/**
	 * Method to verify severe text below the Mix legend
	 * @author SOWMIYA
	 * @return - Boolean value - "true if light and severe link are present else false"
	 * */
	public Boolean verifyLightAndSeverFromMixLegend()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightMix);
		WebElement severe = getDriver().findElement(bySeveremix);
	    light.syncVisible();
		severe.syncVisible();
		return light.isDisplayed() && severe.isDisplayed();
	}
	
	/**
	 * Method to verify color vary from light to dark
	 * @author SOWMIYA
	 * @return - Boolean value - "true if the color gradually increases from light to dark else false"
	 * */
	public Boolean verifyColorVaryFromLightToDark()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible(30);
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
	 * @author SOWMIYA
	 * @return - Boolean value - "true if light and severe link are present else false"
	 * */
	public Boolean verifyLightAndSeverFromIceLegend()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightIce);
		WebElement severe = getDriver().findElement(bySevereIce);
	    light.syncVisible();
		severe.syncVisible();
		return light.isDisplayed() && severe.isDisplayed();
	}
	
	/**
	 * Method to verify severe text below the snow legend
	 * @author SOWMIYA
	 * @return - Boolean value - "true if light and severe link are present else false"
	 * */
	public Boolean verifyLightAndSeverFromSnowLegend()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement light = getDriver().findElement(byLightSnow);
		WebElement severe = getDriver().findElement(bySevereSnow);
	    light.syncVisible();
		severe.syncVisible();
		return light.isDisplayed() && severe.isDisplayed();
	}
	
	/**
	 * Method to verify presence of slide bar with play button and time at the end of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if slidebar, playbutton and timestamp are present else false"
	 * */
	public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement slideBar = getDriver().findElement(bySlideBar);
		WebElement playButton = getDriver().findElement(byPlayButton);
		WebElement timeStamp = getDriver().findElement(byTimeStamp);
		return slideBar.isDisplayed() && playButton.isDisplayed() && timeStamp.isDisplayed();
	}
	
	/**
	 * Method to toggle between past and future CTA 
	 * @author SOWMIYA
	 * @return - Boolean value - "true if past and future cta is active depending on what Cta is selected else false"
	 * */
	public Boolean toggleBetweenPastAndFutureCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		//future cta
		WebElement ctaFuture = getDriver().findElement(byFutureCTA);
		ctaFuture.syncVisible();
		ctaFuture.click();
		WebElement ctaFutureActive = getDriver().findElement(byFutureCTAIsActive);
		ctaFutureActive.syncVisible(15);
		//past cta
		WebElement ctaPast = getDriver().findElement(byPastCTA);
		ctaPast.click();
		WebElement ctaPastActive = getDriver().findElement(byPastCTAIsActive);
		ctaPastActive.syncVisible(15);
		return ctaPastActive.syncVisible();
	}
	
	/**
	 * Method to verify timeline controls like Past and Future CTA below the map
	 * @author SOWMIYA
	 * @return - Boolean value - "true if past and future cta is below the map else false"
	 * */
	public Boolean verifyPastAndFutureCTABelowMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		//future cta
		WebElement pastCTABelowMap = getDriver().findElement(byPastCTABelowMap);
		WebElement futureCTABelowMap = getDriver().findElement(byFutureCTABelowMap);
		return pastCTABelowMap.syncVisible(20) && futureCTABelowMap.syncVisible(20);
	}
	
	/**
	 * Method to verify PAST CTA highlighted by default on city Weather Radar page
	 * @author SOWMIYA
	 * @return - Boolean value - "true if past is active else false"
	 * */
	public Boolean locatePastCTAHighlightedByDefault()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement ctaPastActive = getDriver().findElement(byPastCTAIsActive);
		return ctaPastActive.syncVisible(15);
	}
	
	/**
	 * Method to click mapbox
	 * @author SOWMIYA
	 * */
	public void clickMapbox()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement mapbox = getDriver().findElement(byMapbox);
		Sleeper.sleep(3);
		mapbox.jsClick();
		Sleeper.sleep(8);
	}
	
	/**
	 * Method to click open street map
	 * @author SOWMIYA
	 * */
	public void clickOpenStreetMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement openStreetMap = getDriver().findElement(byOpenStreetMap);
		Sleeper.sleep(3);
		openStreetMap.jsClick();
		Sleeper.sleep(6);
	}
	
	/**
	 * Method to click improve this map
	 * @author SOWMIYA
	 * */
	public void clickImproveThisMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement improveThisMap = getDriver().findElement(byImproveThisMap);
		Sleeper.sleep(3);
		improveThisMap.jsClick();
		Sleeper.sleep(4);
	}
	
	/**
	 * Click full screen button of the map
	 * verify Map opens up into full screen with timeline controls, slider with play button, and legend and if you click on x symbol the map switches back to normal
	 * @author SOWMIYA
	 * */
	public Boolean clickFullScreenButtonOfMap()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement map = getDriver().findElement(byMap);
		map.syncVisible();
		
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
			ctaFuture.syncVisible(10);
			//past cta
			WebElement ctaPast = getDriver().findElement(byPastCTA);
			ctaPast.syncVisible(10);
			//play button and slider bar
			WebElement slideBar = getDriver().findElement(bySlideBar);
			WebElement playButton = getDriver().findElement(byPlayButton);
			slideBar.syncVisible();
			playButton.syncVisible();
			//click 'x' at the top right corner
			WebElement closeButton = getDriver().findElement(byCloseButton);
			closeButton.syncVisible();
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
	 * @author SOWMIYA
	 * */
	public void clickZoomInAndZoomOut()
	{
		WebPageLoaded.isDomInteractive();
		WebElement zoomIn = getDriver().findElement(byZoomIn);
		zoomIn.jsClick();
		WebElement zoomOut = getDriver().findElement(byZoomOut);
		zoomOut.jsClick();
	}
	
	/**
	 * Method to verify tooltip background color in orange
	 * @author SOWMIYA
	 * return tooltip color
	 * */
	public String verifyTootipBackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.syncVisible();
		toolTip.jsClick();
		String colorTooltip = getDriver().findElement(byTooltipActive).getCssValue("background-color");
		String actualcolourdisplayed = Color.fromString(colorTooltip).asHex();
		return actualcolourdisplayed;
	}
	
	/**
	 * Method to verify tooltip background color in orange
	 * @author SOWMIYA
	 * return tooltip header color
	 * */
	public String verifyTootipHeaderBackgroundColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.syncVisible();
		toolTip.jsClick();
		String colorTooltip = getDriver().findElement(byTooltipHeader).getCssValue("color");
		String actualColourdisplayed = Color.fromString(colorTooltip).asHex();
		return actualColourdisplayed;
	}
	
	/**
	 * Method to get tooltip description
	 * @author SOWMIYA
	 * return tooltip description
	 * */
	public String verifyTooltipDescription()
	{
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.syncVisible();
		toolTip.jsClick();
		WebElement tooltipDescription = getDriver().findElement(byTooltipDescription);
		tooltipDescription.syncVisible();
		String getTooltipDescription = tooltipDescription.getText();
		return getTooltipDescription;
	}
	
	/**
	 * Method to get the radar tab boarder highlighted color
	 * @author SOWMIYA
	 * return radar tab color
	 * */
	public String verifyRadarTabHighlightedColor()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarTab = getDriver().findElement(byRadarTab);
		radarTab.syncVisible();
		String radarBoarderColor = getDriver().findElement(byRadarTabColor).getCssValue("border-top");
		System.out.println("radarBoarderColor:"+radarBoarderColor);
		String boarderColor = radarBoarderColor.substring(10);
		String actualColourdisplayed = Color.fromString(boarderColor).asHex();
		return actualColourdisplayed;
	}
	
	/**
	 * Method to get title of the map on map header
	 * @author SOWMIYA
	 * return map header text
	 * */
	public String getMapHeader()
	{
		WebPageLoaded.isDomInteractive();
		WebElement mapHeader = getDriver().findElement(byMapHeader);
		mapHeader.syncVisible();
		String mapHeaderText = mapHeader.getText();
		return mapHeaderText;
	}
	
	/**
	 * Method to verify on click of tooltip again, the tooltip closes
	 * @author SOWMIYA
	 * return tooltip color
	 * */
	public String verifyToolTipClosed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement toolTip = getDriver().findElement(byTooltip);
		toolTip.syncVisible();
		toolTip.jsClick();
		WebElement toolTipActive = getDriver().findElement(byTooltipActive);
		toolTipActive.syncVisible();
		toolTipActive.jsClick();
		String tootltipColor = getDriver().findElement(byTooltip).getCssValue("color");
		String actualColourdisplayed = Color.fromString(tootltipColor).asHex();
		return actualColourdisplayed;
	}
	
	/**
	 * Method to verify the presence of navigation menu n city forecast page
	 * @author SOWMIYA
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
	
}
