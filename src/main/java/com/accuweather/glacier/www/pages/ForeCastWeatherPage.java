package com.accuweather.glacier.www.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
//import com.chameleon.selenium.web.elements.WebLabel;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.Sleeper;


public class ForeCastWeatherPage extends BasePage {
	
	private By byForecastCityName = By.cssSelector("a:nth-child(3) > h1");
	private By byNowTab = By.cssSelector("div > div > div.subnav-items > a.subnav-item.active");
	private By byForecastTab = By.cssSelector("div > div > div.subnav-items > a.subnav-item.active");
	private By byForecastMapTitle = By.cssSelector("div.content-module > div.map-container.full-mobile-width.content-module > div.map-header > h2");
	private By bySatelliteTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byRadarTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byMinuteCastTab = By.cssSelector("div > div.subnav-items > a:nth-child(3)");
	private By byHourlyTab = By.cssSelector("div > div.subnav-items > a:nth-child(4)");
	private By byDailyTab = By.cssSelector("div > div.subnav-items > a:nth-child(5)");
	//private By byMonthlyTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	//private By byMonthlyTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	private By byMonthlyTab = By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/a[6]");
	private By byFullScreenBtn = By.cssSelector("div.full-screen-button");
	private By byMap = By.cssSelector("canvas.mapboxgl-canvas");
	private By byCloseButton = By.cssSelector("div.close-button");
	private By bySlideBar = By.cssSelector("div.timeline-controls > input.slider");
	private By byPlayButton = By.xpath("//input[@class='slider']/../div/div[@class='play-toggle-button icon-play']");
	private By byMapbox = By.cssSelector("div.mapboxgl-control-container > div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	private By byMapboxNextToi = By.xpath("//a[@class='mapboxgl-ctrl-logo']/../../div/div[@class='mapboxgl-ctrl-attrib-inner']");
	private By byTimeStamp = By.cssSelector("div.timeline-controls > input ~ div.time-stamp");
	private By byGetCurrentDate = By.cssSelector("div.map-tools > div.timeline-controls.precip-forecast-timeline-controls > div.time-stamp");
	private By byRainLightModerateHeavy = By.xpath("//div[@class='legend-labels rain']/span[contains(text(),'light')]/../span[contains(text(),'Moderate')]/../span[contains(text(),'Heavy')]");
	private By byRainTextAboveRainLegend = By.xpath("//div[@class='color-bar rain']/../div/span[text()='Rain']");
	private By bySnowLightModerateHeavy = By.xpath("//div[@class='legend-labels snow']/span[contains(text(),'light')]/../span[contains(text(),'Moderate')]/../span[contains(text(),'Heavy')]");
	private By bySnowTextAboveSnowLegend = By.xpath("//div[@class='color-bar snow']/../div/span[text()='Snow']");
	private By byIceTextAboveIceLegend = By.xpath("//div[@class='color-bar ice']/../div/span[text()='Ice']");
	private By byIceLegendBarColor = By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.forecast-map-legend > div:nth-child(4) > div.color-bar.ice");
	private By byMixTextAboveMixLegend = By.xpath("//div[@class='color-bar mix']/../div/span[text()='Mix']");
	private By byMixLegendBarColor = By.cssSelector("div.map-tools > div.forecast-map-legend > div:nth-child(5) > div.color-bar.mix > span");

	/*
	 * Method to get ForeCast City Name on AW Monthly Forecast page
	 */
	public String  getforecastCityNameSubString() {
		
		 WebPageLoaded.isDomInteractive();
		 final WebElement ForecastCityName = getDriver().findElement(byForecastCityName);
         ForecastCityName.syncVisible();
        String ForecastCityNam = ForecastCityName.getText();
        String substringForecastCityName = ForecastCityNam.substring(0, ForecastCityNam.length()-4);
        return substringForecastCityName;
        }
		
	/*
	 * Method to verify Now tab is selected by default AW Monthly Forecast page
	 */
	public boolean isNowTabEnabled() {
		WebPageLoaded.isDomInteractive();
		WebElement nowtab = getDriver().findElement(byNowTab);
		nowtab.syncVisible(15);
		return nowtab.isEnabled();
		}
	
	
	/*
	 * Method to verify Satellite tab is selected by default AW Monthly Forecast page
	 */
	public boolean isSatelliteTabEnabled() {
		WebPageLoaded.isDomInteractive();
		WebElement satellitetab = getDriver().findElement(bySatelliteTab);
		satellitetab.syncVisible(15);
		return satellitetab.isEnabled();
		}
	
	/*
	 * Method to click Satellite tab on the AW Monthly Forecast page
	 */
	public void clickOnSatelliteTab() {
		WebPageLoaded.isDomInteractive();
		WebElement SatelliteTab = getDriver().findElement(bySatelliteTab);
		SatelliteTab.hover();
		SatelliteTab.jsClick();
		}
	
	
	/*
	 * Method to click Monthly tab on the AW Monthly Forecast page
	 */
	public void clickOnMonthlyTab() {
		WebPageLoaded.isDomInteractive();
		WebElement monthtab = getDriver().findElement(byMonthlyTab);
		//methodtab.syncVisible(15);
		monthtab.hover();
		monthtab.jsClick();
		}
	
	/*
	 * Method to verify Radar tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isRadarTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement radar = getDriver().findElement(byRadarTab );
        radar.syncVisible(15);
        return radar.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify MinuteCast tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isMinuteCastTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement minutecasttab = getDriver().findElement(byMinuteCastTab  );
        minutecasttab.syncVisible(15);
        return minutecasttab.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Hourly tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isHourlyTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement hourlytab = getDriver().findElement(byHourlyTab);
        hourlytab.syncVisible(15);
        return hourlytab.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Daily tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isDailyTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement dailytab = getDriver().findElement(byDailyTab );
        dailytab.syncVisible(15);
        return dailytab.isDisplayed();    	   	
    }
	
	
	/*
	 * Method to verify Monthly tab is displayed on the AW Monthly Forecast page
	 */
	public boolean isMonthlyTabDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement monthlytab = getDriver().findElement(byMonthlyTab );
        monthlytab.syncVisible(15);
        return monthlytab.isDisplayed();    	   	
    }
	
	/*
	 * Method to verify Satellite tab displayed by default AW Monthly Forecast page
	 */
	public boolean isSatelliteTabDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement satellitetab = getDriver().findElement(bySatelliteTab);
		satellitetab.syncVisible(15);
		return satellitetab.isDisplayed();
		}
	
	/**
	 * Method to verify forecast tab is active and higlighted in orange color
	 * @author SOWMIYA
	 * @return - Boolean value - "true if tab is active"
	 * */
	public String verifyForecastTabIsHiglighted() {
		WebPageLoaded.isDomInteractive();
		WebElement forecastTab = getDriver().findElement(byForecastTab);
		forecastTab.syncVisible(15);
		forecastTab.isEnabled();
		String forecastTabColor = getDriver().findElement(byForecastTab).getCssValue("border-top");
		System.out.println("forecastTabColor:"+forecastTabColor.substring(10));
		String color = Color.fromString(forecastTabColor.substring(10)).asHex();
		System.out.println("color:"+color);
		return color;
	}	
	
	/**
	 * Method to verify title of the map on forecast page
	 * @author SOWMIYA
	 * @return - title of the map
	 * */
	public String verifyTitleOfTheMap() {
		WebPageLoaded.isDomInteractive();
		WebElement forecastMapTitle = getDriver().findElement(byForecastMapTitle);
		forecastMapTitle.syncVisible(15);
		String titleOfMap = forecastMapTitle.getText();
		return titleOfMap;
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
		
		Boolean flag; 
		
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
	 * Method to verify mapbox on the map and i next to it
	 * @author SOWMIYA
	 * @return - true if mapbox and i present on the map
	 * */
	public Boolean verifyMapboxAndiNextToIt() {
		WebPageLoaded.isDomInteractive();
		WebElement mapbox = getDriver().findElement(byMapbox);
		WebElement mapboxNextToi = getDriver().findElement(byMapboxNextToi);
		return mapbox.syncVisible(15) && mapboxNextToi.syncVisible(15);
	}	
	
	/**
	 * Method to verify presence of slide bar with play button and time at the end of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if slidebar, playbutton and timestamp are present else false"
	 * */
	public Boolean verifyPresenceOfSliderBarWithPlayButtonAndTime()
	{
		WebPageLoaded.isDomInteractive();
		WebElement slideBar = getDriver().findElement(bySlideBar);
		WebElement playButton = getDriver().findElement(byPlayButton);
		WebElement timeStamp = getDriver().findElement(byTimeStamp);
		return slideBar.isDisplayed() && playButton.isDisplayed() && timeStamp.isDisplayed();
	}
	
	/**
	 * Method to verify presence of current date at end of slide bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if current date matches the current day"
	 * */
	public Boolean verifyCurrentDateAtTheEndOfSliderBar()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentdate = getDriver().findElement(byGetCurrentDate);
		currentdate.syncVisible(15);
		String getDateFromSlider = currentdate.getText().substring(0, 3);
		Date now = new Date();
	    SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
	    String getTodayDay = simpleDateformat.format(now);
	    return getDateFromSlider.equalsIgnoreCase(getTodayDay.toUpperCase());
	}
	
	/**
	 * Method to verify light moderate and heavy from rainare in order
	 * @author SOWMIYA
	 * @return - Boolean value - "true if are in order"
	 * */
	public Boolean verifyLightModerateHeavyFromRainLegend()
	{
		WebPageLoaded.isDomInteractive();
		WebElement lightModerateHeavy = getDriver().findElement(byRainLightModerateHeavy);
		return lightModerateHeavy.syncVisible(15);
	}
	
	/**
	 * Method to verify Legends for Rain should have text Rain in the center of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if rain legend have rain text"
	 * */
	public Boolean verifyLegendsForRainHaveTextRain()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rainTextAboveRainLegend = getDriver().findElement(byRainTextAboveRainLegend);
		return rainTextAboveRainLegend.syncVisible(15);
	}
	
	/**
	 * Method to verify light moderate and heavy from snow are in order
	 * @author SOWMIYA
	 * @return - Boolean value - "true if are in order"
	 * */
	public Boolean verifyLightModerateHeavyFromSnowLegend()
	{
		WebPageLoaded.isDomInteractive();
		WebElement lightModerateHeavy = getDriver().findElement(bySnowLightModerateHeavy);
		return lightModerateHeavy.syncVisible(15);
	}
	
	/**
	 * Method to verify Legends for Snow should have text Snow in the center of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if snow legend have sanow text"
	 * */
	public Boolean verifyLegendsForSnowHaveTextSnow()
	{
		WebPageLoaded.isDomInteractive();
		WebElement snowTextAboveSnowLegend = getDriver().findElement(bySnowTextAboveSnowLegend);
		return snowTextAboveSnowLegend.syncVisible(15);
	}
	
	/**
	 * Method to verify Legends for Ice should have text ICe in the center of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if ice legend have ice text"
	 * */
	public Boolean verifyLegendsForIceHaveTextIce()
	{
		WebPageLoaded.isDomInteractive();
		WebElement iceTextAboveRainLegend = getDriver().findElement(byIceTextAboveIceLegend);
		return iceTextAboveRainLegend.syncVisible(15);
	}
	
	/**
	 * Method to verify Legends for Ice legend color
	 * @author SOWMIYA
	 * @return - ice legend color
	 * */
	public String verifyIceLegendBarColor()
	{
		WebPageLoaded.isDomInteractive();
		String iceLegendColor = getDriver().findElement(byIceLegendBarColor).getCssValue("background");
		System.out.println("iceLegendColor:"+iceLegendColor);
		String iceColor = Color.fromString(iceLegendColor).asHex();
		return iceColor;
	}
	
	/**
	 * Method to verify Legends for mix should have text mix in the center of the bar
	 * @author SOWMIYA
	 * @return - Boolean value - "true if mix legend have mix text"
	 * */
	public Boolean verifyLegendsForMixHaveTextMix()
	{
		WebPageLoaded.isDomInteractive();
		WebElement mixTextAboveMixLegend = getDriver().findElement(byMixTextAboveMixLegend);
		return mixTextAboveMixLegend.syncVisible(15);
	}
	
	/**
	 * Method to verify Legends for mix legend color
	 * @author SOWMIYA
	 * @return - mix legend color
	 * */
	public String verifyMixLegendBarColor()
	{
		WebPageLoaded.isDomInteractive();
		String mixLegendColor = getDriver().findElement(byMixLegendBarColor).getCssValue("background");
		System.out.println("iceLegendColor:"+mixLegendColor);
		String mixColor = Color.fromString(mixLegendColor).asHex();
		return mixColor;
	}
}
