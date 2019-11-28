package com.accuweather.glacier.m.pages;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class BuildErrorPageMobileIOS extends MobileBasePage {
	private By byerrorPage = By.cssSelector("body > div.template-root > div.error-page");
	private By byerrorText = By.cssSelector("body > div.template-root > div.error-page > div > div.text");
	private By byerrorType = By.cssSelector("body > div.template-root > div.error-page > div > div.error-code");
	private By byCTABacktoAccuweather = By.cssSelector("body > div.template-root > div.error-page > div > a");
	private By byCTABacktoAccuweathertextwitharrow = By
			.cssSelector("body > div > div.error-page > div > a > svg");

	/*
	 * Method to Append AccuWeather home page URL with some text
	 * 
	 * 
	 */

	public String addtexttoEndURL() throws URISyntaxException {
		WebPageLoaded.isDomInteractive();
		String currentURL = "https://qualityassurance.accuweather.com";
		URIBuilder uri = new URIBuilder(currentURL);
		uri.setPath("tt&%5E(%");
		return uri.toString();
	}

	public String apendtexttoEndURL2() throws URISyntaxException {
		String currentURL = "https://qualityassurance.accuweather.com";
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
	public String errorpagebackgroundimage() {
		WebPageLoaded.isDomInteractive();
		return getDriver().findWebElement(byerrorPage).getCssValue("background-image");
	}

	/** Method to get the ERROR Text displayed */
	public String errorpageTextDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement findErrorText = getDriver().findElement(byerrorText);
		//findErrorText.syncVisible(5);
		String errorText = getDriver().findElement(byerrorText).getText();
		return errorText;
	}

	/** Method to get the ERROR Type displayed */
	public String errortypeDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement errorType = getDriver().findElement(byerrorType);
		//errorType.syncVisible(5);
		String errorText = getDriver().findElement(byerrorType).getText();
		return errorText;
	}

	/** Method to get the CTA Text displayed */
	public String CTABacktoAccuweatheisDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement backtoAccuweather = getDriver().findElement(byCTABacktoAccuweather);
		//backtoAccuweather.syncVisible(5);
		String ctaText = getDriver().findElement(byCTABacktoAccuweather).getText();
		return ctaText;
	}

	/** Method to get the CTA Text displayed color */
	public String CTABacktoAccuweathercolourDisplayed() {
		/*
		 * WebPageLoaded.isDomInteractive(); WebElement backtoAccuweather =
		 * getDriver().findElement(byCTABacktoAccuweather);
		 * backtoAccuweather.syncVisible(5); String ctaTextColour =
		 * getDriver().findElement(byCTABacktoAccuweather).getCssValue("color"); String
		 * actualColour = Color.fromString(ctaTextColour).asHex(); return actualColour;
		 */
		
		
		WebPageLoaded.isDomInteractive(5);
		getDriver().findElement(byCTABacktoAccuweather).scrollIntoView();
		WebElement ele = getDriver().findElement(byCTABacktoAccuweather);
		String result = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.error-page > div > a\")).color;",
				ele);
		String arrowcolourdisplayed = Color.fromString(result).asHex();
		return arrowcolourdisplayed;
	}

	/** Method to check whetherCTA "Back to AccuWeather" is Displayed */
	public boolean CTABacktoAccuweatherwithArrowDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement backtoAccuweathertextwitharrow = getDriver().findElement(byCTABacktoAccuweathertextwitharrow);
		//backtoAccuweathertextwitharrow.syncVisible(5);
		return getDriver().findElements(byCTABacktoAccuweathertextwitharrow).size()>0;
	}

	/** Method to verify that its clicked on CTA "Back to AccuWeather" */
	public void CTABacktoAccuweatherisClicked() {
		WebPageLoaded.isDomInteractive();
		WebElement backtoAccuweather = getDriver().findElement(byCTABacktoAccuweather);
		//backtoAccuweather.syncVisible(5);
		getDriver().findElement(byCTABacktoAccuweather).jsClick();
		Sleeper.sleep(5);
	}

}
