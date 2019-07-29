package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class CitySatellitePage extends BasePage {
	
	private By byEnhancedTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a.subnav-item.active");
	private By byStandardTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a:nth-child(2)");
	private By byVisibleTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a:nth-child(3)");
	private By byWaterVaporTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div.subnav.tertiary-nav > div.subnav-items > a:nth-child(4)");
	private By byEnhancedHeader = By.cssSelector("body > div.template-root > div:nth-child(5) > div > div.page-column-1 > div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By byEnhancedToolTip = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > div > div.icon-tooltip");
	private By byZoomInControl = By.cssSelector("#map > div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
	private By byZoomOutControl = By.cssSelector("#map > div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left > div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
	private By byMapBox = By.cssSelector("#map > div.mapboxgl-control-container > div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byPlayIcon = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.timeline-controls > div.button-wrapper > div");
	private By byWhiteColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-1");
	private By byPinkColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-2");
	private By byPurpleColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-3");
	private By byBlueColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-4");
	private By byGreenColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-5");
	private By byLightGreenCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-6");
	private By byLighterGreenCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-7");
	private By byYellowColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-8");
	private By byOrangeColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-9");
	private By byRedColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-10");
	private By byBrownColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-11");
	private By byBlackColorCloud = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > svg > rect.c-12");
	private By byCloudLabel = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > div.label");
	private By byLowLabel = By.cssSelector("div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > div.range-label > span:nth-child(1)");
	private By byHighLabel = By.cssSelector("div.content-module > div.map-container.full-mobile-width.content-module > div.map-tools > div.satellite-legend > div > div.range-label > span:nth-child(2)");
	
	/*
	 * Method to verify Enhanced tab is displayed on the City Satellite page
	 */
	public boolean isEnhancedTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement enhanced = getDriver().findElement(byEnhancedTab);
        enhanced.syncVisible(15);
        return enhanced.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Enhanced tab is enabled on the City Satellite page
	 */
	public boolean isEnhancedTabEnabled() {
    	WebPageLoaded.isDomInteractive();
        WebElement enhanced = getDriver().findElement(byEnhancedTab);
        enhanced.syncVisible(15);
        return enhanced.isEnabled();    	   	
    }
	
	/*
	 * Method to verify Standard tab is displayed on the City Satellite page
	 */
	public boolean isStandardTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement standard = getDriver().findElement(byStandardTab);
        standard.syncVisible(15);
        return standard.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Visible tab is displayed on the City Satellite page
	 */
	public boolean isVisibleTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement visible = getDriver().findElement(byVisibleTab);
        visible.syncVisible(15);
        return visible.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify WaterVapor tab is displayed on the City Satellite page
	 */
	public boolean isWaterVaporTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement watervapor = getDriver().findElement(byWaterVaporTab);
        watervapor.syncVisible(15);
        return watervapor.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Enhanced Header is displayed on the City Satellite page
	 */
	public boolean isEnhancedHeaderDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement header = getDriver().findElement(byEnhancedHeader);
        header.syncVisible(15);
        return header.isDisplayed();    	   	
    }
	
	/*
	 * Method to click on Enhanced Tab on the City Satellite page
	 */
	public void clickOnEnhancedTab() {
    	WebPageLoaded.isDomInteractive();
        WebElement enhanced = getDriver().findElement(byEnhancedTab);
        enhanced.jsClick();    	   	
    }
	
	/*
	 * Method to click on Standard Tab on the City Satellite page
	 */
	public void clickOnStandardTab() {
    	WebPageLoaded.isDomInteractive();
        WebElement standard = getDriver().findElement(byStandardTab);
        standard.jsClick();    	   	
    }
	
	
	/*
	 * Method to click on Visibility Tab on the City Satellite page
	 */
	public void clickOnVisibilityTab() {
    	WebPageLoaded.isDomInteractive();
        WebElement visiblity = getDriver().findElement(byVisibleTab);
        visiblity.jsClick();    	   	
    }
	
	
	/*
	 * Method to click on WaterVapor Tab on the City Satellite page
	 */
	public void clickOnWaterVaporTab() {
    	WebPageLoaded.isDomInteractive();
        WebElement watervapor = getDriver().findElement(byWaterVaporTab);
        watervapor.jsClick();    	   	
    }
	
	/*
	 * Method to verify ToolTip is displayed on the Enhanced Tab Section 
	 * Under City Satellite page
	 */
	public boolean isEnhancedToolTipDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement tooltip = getDriver().findElement(byEnhancedToolTip);
        tooltip.syncVisible(15);
        return tooltip.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Zoom In Icon is displayed on the Enhanced Tab Section 
	 * Under City Satellite page
	 */
	public boolean isEnhancedZoomInDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement zoomin = getDriver().findElement(byZoomInControl);
        zoomin.syncVisible(15);
        return zoomin.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Zoom Out Icon is displayed on the Enhanced Tab Section 
	 * Under City Satellite page
	 */
	public boolean isEnhancedZoomOutDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement zoomout = getDriver().findElement(byZoomOutControl);
        zoomout.syncVisible(15);
        return zoomout.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify MapBox Icon is displayed on the Enhanced Tab Section 
	 * Under City Satellite page
	 */
	public boolean isEnhancedMapBoxDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement mapbox = getDriver().findElement(byMapBox);
        mapbox.syncVisible(15);
        return mapbox.isDisplayed();    	   	
    }
	
	/*
	 * Method to click on Enhanced Zoom In Control on the City Satellite page
	 */
	public void clickOnEnhancedZoomInControl() {
    	WebPageLoaded.isDomInteractive();
        WebElement zoomin = getDriver().findElement(byZoomInControl);
        zoomin.jsClick();    	   	
    }
	
	/*
	 * Method to click on Enhanced Zoom Out Control on the City Satellite page
	 */
	public void clickOnEnhancedZoomOutControl() {
    	WebPageLoaded.isDomInteractive();
        WebElement zoomout = getDriver().findElement(byZoomOutControl);
        zoomout.jsClick();    	   	
    }
	
	/*
	 * Method to click on Enhanced MapBox on the City Satellite page
	 */
	public void clickOnEnhancedMapBoxIcon() {
    	WebPageLoaded.isDomInteractive();
        WebElement mapbox = getDriver().findElement(byMapBox);
        mapbox.jsClick();    	   	
    }
	
	
	
	
	











	

}
