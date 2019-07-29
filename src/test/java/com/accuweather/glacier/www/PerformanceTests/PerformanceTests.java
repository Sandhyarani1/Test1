package com.accuweather.glacier.www.PerformanceTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.HourlyForecastPage;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.RadarWeatherPage;
import com.chameleon.selenium.web.WebPageLoaded;

public class PerformanceTests extends AccuWeatherBaseTest
{
	LandingPage landingPage = new LandingPage();
	HourlyForecastPage hourlyPage = new HourlyForecastPage();
	String zipCode = "53558";
	String expectedLandingPageTitle = "Mc Farland Weather - AccuWeather Forecast for WI 53558";
	
	@Test(invocationCount=20)
	public void testCityForecast()
	{
		testStart("Validate the navigation to Hourly tab");
		landingPage.enterZipcodeInSearchField(zipCode);
		landingPage.clickOnZipcodeSearchIcon();
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedLandingPageTitle);
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(1)")).click();
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(2)")).click();
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(3)")).click();
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(4)")).click();
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(5)")).click();
		WebPageLoaded.isDomInteractive(1000);
		getDriver().findElement(By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(6)")).click();
		WebPageLoaded.isDomInteractive(1000);
		
	}
}
