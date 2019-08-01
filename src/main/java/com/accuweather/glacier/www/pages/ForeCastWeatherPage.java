package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
//import com.chameleon.selenium.web.elements.WebLabel;
import com.chameleon.selenium.web.elements.WebTextbox;


public class ForeCastWeatherPage extends BasePage {
	
	private By byForecastCityName = By.cssSelector("a:nth-child(3) > h1");
	private By byNowTab = By.cssSelector("div > div > div.subnav-items > a.subnav-item.active");
	private By bySatelliteTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byRadarTab = By.cssSelector("div > div > div.subnav-items > a:nth-child(2)");
	private By byMinuteCastTab = By.cssSelector("div > div.subnav-items > a:nth-child(3)");
	private By byHourlyTab = By.cssSelector("div > div.subnav-items > a:nth-child(4)");
	private By byDailyTab = By.cssSelector("div > div.subnav-items > a:nth-child(5)");
	//private By byMonthlyTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	//private By byMonthlyTab = By.cssSelector("body > div.template-root > div.page-subnav > div > div > div.subnav-items > a:nth-child(6)");
	private By byMonthlyTab = By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/a[6]");


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
}
