package com.accuweather.glacier.www.pages;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;

public class BuildErrorPage extends BasePage
{
	private By byerrorPage = By.cssSelector("body > div.template-root > div.error-page");
	private By byerrorText=By.cssSelector("body > div.template-root > div.error-page > div > div.text");
	private By byerrorType =By.cssSelector("body > div.template-root > div.error-page > div > div.error-code");
	private By byCTABacktoAccuweather=By.cssSelector("body > div.template-root > div.error-page > div > a");
	private By byCTABacktoAccuweathertextwitharrow=By.cssSelector("body > div.template-root > div.error-page > div > a > svg > path");

	/*
	 * Method to Append AccuWeather home page URL with some text 
	 * 
	 * 
	 */
	 
	public String addtexttoEndURL() throws URISyntaxException
	{
		String currentURL ="https://development.accuweather.com";
		URIBuilder uri = new URIBuilder(currentURL);
		uri.setPath("tt");
		return uri.toString();
	}

	public String apendtexttoEndURL2() throws URISyntaxException
	{
		String currentURL ="https://development.accuweather.com";
		URIBuilder uri = new URIBuilder(currentURL);
		uri.setPath("throw-exception");
		return uri.toString();
	}

	/*
	 * 
	 * Method to get the Background image displayed
	 * 
	 * 
	 */
	public String errorpagebackgroundimage()
	{
		WebPageLoaded.isDomInteractive();
		return getDriver().findWebElement(byerrorPage).getCssValue("background-image");
	}

	/** Method to get the ERROR Text displayed */
	public String errorpageTextDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		String errorText=getDriver().findElement(byerrorText).getText();
		return errorText;
	}

	/** Method to get the ERROR Type displayed */
	public String errortypeDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		String errorText=getDriver().findElement(byerrorType).getText();
		return errorText;
	}

	/** Method to get the CTA Text displayed */
	public String CTABacktoAccuweatheisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		String ctaText=getDriver().findElement(byCTABacktoAccuweather).getText();
		return ctaText;
	}

	/** Method to get the CTA Text displayed color  */
	public String CTABacktoAccuweathercolourDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		String ctaTextColour=getDriver().findElement(byCTABacktoAccuweather).getCssValue("color");
	    String actualColour=Color.fromString(ctaTextColour).asHex();
		return actualColour;
	}

	/** Method to check whetherCTA "Back to AccuWeather" is  Displayed  */
	public boolean CTABacktoAccuweatherwithArrowDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		return getDriver().findElement(byCTABacktoAccuweathertextwitharrow).isDisplayed();
	}

	/** Method to verify that its clicked on CTA "Back to AccuWeather"   */
	public void CTABacktoAccuweatherisClicked()
	{
		WebPageLoaded.isDomInteractive();
		 getDriver().findElement(byCTABacktoAccuweather).jsClick();
	}

}
