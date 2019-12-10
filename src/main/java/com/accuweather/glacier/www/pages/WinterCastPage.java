package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class WinterCastPage extends BasePage {
	
    private By byWinterCastTab = By.cssSelector("div > div.page-subnav > div.subnav > div.subnav-items > a:nth-child(2)");
    private By byWinterCastTabColor = By.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
    private By byRightRailTitle = By.cssSelector("div:nth-child(5) > div > div.page-column-2 > div.lifestyles-right-rail.content-module.full-mobile-width > h2");
    private By byDustAndDander = By.xpath("//div[@class='lifestyle-item']/div/div/h2[contains(text(),'Dust & Dander')]");
    private By byAsthma = By.xpath("//div[@class='lifestyle-item']/div/div/h2[contains(text(),'Asthma')]");
    private By byCommonCold = By.xpath("//div[@class='lifestyle-item']/div/div/h2[contains(text(),'Common Cold')]");
    private By byFlu = By.xpath("//div[@class='lifestyle-item']/div/div/h2[contains(text(),'Flu')]");
    private By byTooltipFromSnowfallAccumulation = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > div > div > div.icon-tooltip");
	private By byTooltipHeaderFromSnowfallAccumulation = By.cssSelector("div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > div > div > div.tooltip-overlay > div.tooltip-header > span");
	private By bySnowfallAccumulationHeader = By.cssSelector("div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > p");
	private By byRightRailReadMoreButton = By.cssSelector("div.page-column-2 > div.content-module.zone-rightRail1 > div > a:nth-child(1) > div.right-rail-cta-text > div");
	private By bySnowfallAmountProbabilityHeader = By.xpath("//div[@class='header']/p[contains(text(),'Snowfall Amount Probability')]");
	private By byTooltipFromSnowfallAmountProbability = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-probability.card.full-mobile-width.content-module > div.header > div > div.icon-tooltip");
	private By byTooltipHeaderFromSnowfallAmountProbability = By.cssSelector("div.content-module > div.snowfall-probability.card.full-mobile-width.content-module > div.header > div > div.tooltip-overlay > div.tooltip-header > span");
	private By byWinterCastTabBesideNowTab = By.xpath("//div[@class='subnav-items']/a/h2[contains(text(),'WinterCast')]/../../a/span[contains(text(),'Now')]");
	private By byTotalAccumulation = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.map-subnav > ul > li.active");
	private By byHourlyAccumulation = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.map-subnav > ul > li:nth-child(2)");
	private By byTimeSpanTextSize = By.cssSelector("div:nth-child(5) > div > div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > div > p");
	private By byTooltipContent = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > div > div > div.tooltip-overlay > div.tooltip-content");
	private By byTextColorOfTimeInSnowfallAccumulation = By.cssSelector("div.page-column-1 > div.content-module > div.snowfall-accumulation.full-mobile-width.content-module > div.header > div > p");
    
	
	/**
	 * Method to click on wintercast tab
	 * @author SOWMIYA
	 * @return - "true if landed on wintercast page"
	 * */
	public Boolean clickWinterCastTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement winterCastTab = getDriver().findElement(byWinterCastTab);
		winterCastTab.syncVisible(30);
		winterCastTab.jsClick();
		WebElement rightRailTitle = getDriver().findElement(byRightRailTitle);
		return rightRailTitle.syncVisible(15);
	}
	
	/**
	 * Method to verify right rail lifestyle forecasts displayed
	 * @author SOWMIYA
	 * @return - "true if lifestyle forecasts are displayed"
	 * */
	public Boolean verifyRightRailLifestyleForecast()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rightRailTitle = getDriver().findElement(byRightRailTitle);
		rightRailTitle.syncVisible(15);
		WebElement dustAndDander = getDriver().findElement(byDustAndDander);
		WebElement asthma = getDriver().findElement(byAsthma);
		WebElement commonCold = getDriver().findElement(byCommonCold);
		WebElement flu = getDriver().findElement(byFlu);
		return dustAndDander.syncVisible(15) && asthma.syncVisible(15) && commonCold.syncVisible(15) && flu.syncVisible(15);
	}
	
	/**
	 * Method to verify snowfall accumulation header, tooltip icon is present and tooltip header is in blue
	 * @author SOWMIYA
	 * return tooltip header color
	 * */
	public String verifySnowfallAccumulationAndTooltipIconPresentAndTooltipHeaderInBlue()
	{
		WebElement snowfallAccumulationHeader = getDriver().findElement(bySnowfallAccumulationHeader);
		snowfallAccumulationHeader.syncVisible(15);
		WebElement toolTip = getDriver().findElement(byTooltipFromSnowfallAccumulation);
		toolTip.syncVisible(15);
		toolTip.jsClick();
		String colorTooltip = getDriver().findElement(byTooltipHeaderFromSnowfallAccumulation).getCssValue("color");
		String actualColourdisplayed = Color.fromString(colorTooltip).asHex();
		System.out.println("actualColourdisplayed:"+actualColourdisplayed);
		return actualColourdisplayed;
	}
	
	/**
	 * Method to verify user able to see read more button in right rail module
	 * @author SOWMIYA
	 * @return - Boolean value - "true if read more button is present"
	 * */
	public Boolean verifyReadMoreButtonPresntInRightRailModule()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rightRailReadMoreButton = getDriver().findElement(byRightRailReadMoreButton);
		rightRailReadMoreButton.syncVisible(30);
		String strrightRailReadMoreButton = rightRailReadMoreButton.getText();
	
		return strrightRailReadMoreButton.equalsIgnoreCase("Read More");
	}
	
	/**
	 * Method to verify snowfall amount probability and tooltip icon is present and tooltip header is in blue
	 * @author SOWMIYA
	 * return tooltip header color
	 * */
	public String verifySnowfallAmountProbabilityAndTooltipIconPresentAndTooltipHeaderInBlue()
	{
		WebElement snowfallAmountProbabilityHeader = getDriver().findElement(bySnowfallAmountProbabilityHeader);
		snowfallAmountProbabilityHeader.syncVisible(15);
		WebElement toolTip = getDriver().findElement(byTooltipFromSnowfallAmountProbability);
		toolTip.syncVisible(15);
		toolTip.jsClick();
		String colorTooltip = getDriver().findElement(byTooltipHeaderFromSnowfallAmountProbability).getCssValue("color");
		String actualColourdisplayed = Color.fromString(colorTooltip).asHex();
		System.out.println("actualColourdisplayed:"+actualColourdisplayed);
		return actualColourdisplayed;
	}
	
	/**
	 * Verify the title and presence of Tertiary Navigation menu on the WinterCast page
	 * @author SOWMIYA
	 * return true if menus are present
	 * */
	public Boolean verifyTertiaryNavigationMenuPresent()
	{
		WebElement snowfallAccumulationHeader = getDriver().findElement(bySnowfallAccumulationHeader);
		snowfallAccumulationHeader.syncVisible(15);
		WebElement totalAccumulation = getDriver().findElement(byTotalAccumulation);
		WebElement hourlyAccumulation = getDriver().findElement(byHourlyAccumulation);
		return totalAccumulation.syncVisible(15) && hourlyAccumulation.syncVisible(15);
	}
	
	/**
	 * Method to Validate the WINTERCAST tab is located beside the NOW tab
	 * @author SOWMIYA
	 * @return - "true if color is blue and wintercast tab is next to now tab"
	 * */
	public Boolean verifyWinterCastTabIsBesideNowTab()
	{
		WebPageLoaded.isDomInteractive();
		WebElement rightRailTitle = getDriver().findElement(byRightRailTitle);
		rightRailTitle.syncVisible(15);
		
		//check wnintertab is next to now tab
		WebElement winterCastTabBesideNowTab = getDriver().findElement(byWinterCastTabBesideNowTab);
		winterCastTabBesideNowTab.syncVisible(15);
		
		//get color of wintercast tab
		String colorTab = getDriver().findElement(byWinterCastTabColor).getCssValue("border-top");
		String trimColor = colorTab.substring(10);
		String actualcolourdisplayed = Color.fromString(trimColor).asHex();
		actualcolourdisplayed.equalsIgnoreCase("#2cabdc");
		
		return winterCastTabBesideNowTab.syncVisible(15);
	}
	
	/**
	 * Method to verify the color picker for the time span text
	 * @author SOWMIYA
	 * return span text size
	 * */
	public Boolean verifyColorPickerForSpanText()
	{
		WebElement snowfallAccumulationHeader = getDriver().findElement(bySnowfallAccumulationHeader);
		snowfallAccumulationHeader.syncVisible(15);
		//get color 
		String colorText = getDriver().findElement(byTextColorOfTimeInSnowfallAccumulation).getCssValue("color");
		String actualcolourdisplayed = Color.fromString(colorText).asHex();
		//get size
		String fontSize = getDriver().findElement(byTimeSpanTextSize).getCssValue("font-size");
		String lineHeight = getDriver().findElement(byTimeSpanTextSize).getCssValue("line-height");
		
		return fontSize.equals("16px") && lineHeight.equals("20px") && actualcolourdisplayed.equalsIgnoreCase("#1f1f1f");
	}
	
	/**
	 * Method to verify snowfall accumulation tooltip description and color
	 * @author SOWMIYA
	 * return tooltip content and color
	 * */
	public String verifySnowfallAccumulationTooltipDescriptionAndColor()
	{
		WebElement snowfallAccumulationHeader = getDriver().findElement(bySnowfallAccumulationHeader);
		snowfallAccumulationHeader.syncVisible(15);
		//click tootltip 
		WebElement tooltipFromSnowfallAccumulation = getDriver().findElement(byTooltipFromSnowfallAccumulation);
		tooltipFromSnowfallAccumulation.syncVisible(15);
		tooltipFromSnowfallAccumulation.jsClick();
		//tooltip content
		WebElement tootTipContent = getDriver().findElement(byTooltipContent);
		tootTipContent.syncVisible(15);
		String getTootltipContent = tootTipContent.getText();
		//get color 
		String colorText = getDriver().findElement(byTooltipContent).getCssValue("color");
		String actualcolourdisplayed = Color.fromString(colorText).asHex();
		
		return getTootltipContent+"|"+actualcolourdisplayed;
	}
	
	/**
	 * Method to verify the color picker for the time span text
	 * @author SOWMIYA
	 * return true if the tooltip is closed
	 * */
	public Boolean verifyTooltipRevertBackToPreviousState()
	{
		WebElement snowfallAccumulationHeader = getDriver().findElement(bySnowfallAccumulationHeader);
		snowfallAccumulationHeader.syncVisible(15);
		//click tootltip 
		WebElement tooltipFromSnowfallAccumulation = getDriver().findElement(byTooltipFromSnowfallAccumulation);
		tooltipFromSnowfallAccumulation.syncVisible(15);
		tooltipFromSnowfallAccumulation.jsClick();
		WebElement tootTipContent = getDriver().findElement(byTooltipContent);
		tootTipContent.syncVisible(15);
		//clok tooltip again to close
		WebElement textColorOfTimeInSnowfallAccumulation = getDriver().findElement(byTextColorOfTimeInSnowfallAccumulation);
		return textColorOfTimeInSnowfallAccumulation.syncVisible(15); 
	}
}
