package com.accuweather.glacier.m.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class ArticlesPageIpad extends MobileBasePage
{
	private By byNews = By.cssSelector("div.main-menu > ul > li:nth-child(2)");
	private By byWeatherNewsSubMenu = By.cssSelector("div > div:nth-child(2) > a > h4");
    
	private By byNewstab=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bySecondarymenuNews=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bysecondarymenuVideos=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(2) > span");
	private By bysecondarymenuBlogs=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(3) > span");
	private By bysecondarymenuPersonalities=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(4) > span");

	private By byArticles=By.cssSelector("div.content-module > div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-title");
	//body > div > div:nth-child(4) > div > div.page-column-1 > div.content-module > div.zone-centerWell2 > div > a:nth-child(2) > div > div.tout-title > h4
    private By byReportTypo=By.cssSelector(" div.page-column-1 > div > div.article.card.full-mobile-width.comments > a");
	
    private By byShowMoreCta=By.cssSelector("div.page-column-1 > div.content-module > div.zone-centerWell2 > div > a.more-button > span");
 	private By byShowLessCTA=By.cssSelector("div.zone-centerWell2 > div > a.more-button > span");
	private By byarticlesDisplayed=By.xpath("//div[@class='content-recirc']//a");
    
	private By byArticlebyLine=By.cssSelector("div.article.card.full-mobile-width.comments > div.byline-section > p.byline > span.author");
    private By byArticlebyDate=By.cssSelector("div.article.card.full-mobile-width.comments > div.byline-section > p.date");
  
    private By byShareicon=By.cssSelector("div.article.card.full-mobile-width.comments > div.top-header > div > span > svg:nth-child(6)");
    
    private By byfacebookIcon=By.cssSelector("div > div.article.card.full-mobile-width.comments > div.top-header > div > span > a:nth-child(1) > svg");
    private By byTwitterIcon=By.cssSelector("div.top-header > div > span > a:nth-child(2) > svg > path");
    private By byEmailIcon=By.cssSelector("div.article.card.full-mobile-width.comments > div.top-header > div > span > a:nth-child(3) > svg");
    private By byprintIcon=By.cssSelector("div > div.article.card.full-mobile-width.comments > div.top-header > div > span > svg.hide-mobile-inherit.padding.fade-in-right > g");
	
    
    
    public void navigateToNews() {
		clickVisibleElement(byNews);
	}
    
    public boolean isWeatherNewsSubMenuDisplayed() {
		WebPageLoaded.isDomInteractive();
		WebElement weatherNews = getDriver().findElement(byWeatherNewsSubMenu);
		weatherNews.syncVisible(15);
		return weatherNews.isDisplayed();
	}
    
    
    public void navigateToNewsPage() {

		getDriver().findElement(byWeatherNewsSubMenu).jsClick();

	}
    
    /**
	 * @author Sandhya Rani Method to Validated Radar Tab Highlighted by Default in
	 *         orange color at the border top
	 * @return String Hex color
	 * 
	 **/

	public String NewstabHighlightedinOrange() {
		WebPageLoaded.isDomInteractive();
		WebElement newsTab = getDriver().findElement(byNewstab);
		//getDriver().findElement(byNewstab).scrollIntoView();
		String BoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"div.page-subnav > div > div > div.subnav-items > a.subnav-item.active\")).border-top;",
				newsTab);
		System.out.println("color displayed  in rgba  > > > > " + BoarderColor);
		String actualColourdisplayed = Color.fromString(BoarderColor).asHex();
		return actualColourdisplayed;
	}

    /**
	 * Method to Validate Secondary navigation menus displayed on New Landing page
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/

	public boolean validateSecondaryMenusDisplayed() {
		return getDriver().findElements(bySecondarymenuNews).size() > 0
				&& getDriver().findElements(bysecondarymenuVideos).size() > 0
				&& getDriver().findElements(bysecondarymenuBlogs).size() > 0
				&& getDriver().findElements(bysecondarymenuPersonalities).size() > 0;
	}
	
	
	/**
	 * Method to validate Report Typo displayed on Articles Landing page
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/
	public void clickonArticlesDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement articles = getDriver().findElement(byArticles);
		//articles.syncVisible(30);
		articles.jsClick();
	}
	
	public boolean reportTypoisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement reportTypo = getDriver().findElement(byReportTypo);
		
	//	reportTypo.syncVisible(30);
	    return reportTypo.isDisplayed();
	}
	
	public void ClickonreportTypoDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement reportTypo = getDriver().findElement(byReportTypo);
		reportTypo.click();

	}
	
	/**
	 * Method to validate Show More cta Displayed on Articles Page and click on CTA Displayed 
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/
	
	public boolean showMoreCTAisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showMoreCta = getDriver().findElement(byShowMoreCta);
		//showMoreCta.syncVisible(60);
		return getDriver().findElements(byShowMoreCta).size() >0;
	}
	
	public void clickonShowmoreCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showMoreCta = getDriver().findElement(byShowMoreCta);
		getDriver().findElement(byShowMoreCta).scrollIntoView();
		showMoreCta.jsClick();	
	}

	/**
	 * Method to validate Show less cta  Displayed on Articles Page and to click on CTA Displayed
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/
	
	
	public boolean showLessCTAisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showLessCta = getDriver().findElement(byShowLessCTA);
		//showLessCta.syncVisible(60);
		getDriver().findElement(byShowLessCTA).scrollIntoView();
		return getDriver().findElements(byShowLessCTA).size() >0;
	}
	
	public void clickonShowLessCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showLessCta = getDriver().findElement(byShowLessCTA);
		showLessCta.jsClick();	
	}
	
	/**
	 * Method to validate Artilces Size Displayed when clicked on Show More cta Displayed on Articles Page
	 * 
	 * @author sandhya.narayanarao
	 * 
	 **/
	public int	articlesDisplayedSize()
	{
		List<org.openqa.selenium.WebElement> article = getDriver().findElements(byarticlesDisplayed); 
		return article.size()-1;
	}

	
	/**
	 * @author Sandhya Rani
	 * Method to Validate Articles Byline  and Date is displayed on Articles page
	 * @return true if Print icon is Displayed 
	 */
	
	public String articlesByLineDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement articlebyLine = getDriver().findElement(byArticlebyLine);
		return articlebyLine.getText();	
	}
	
	
	public String artilcesByDateDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement articlebyDate = getDriver().findElement(byArticlebyDate);
		articlebyDate.syncVisible(30);
		return articlebyDate.getText();	
	}
	
	/**
	 * @author Sandhya Rani
	 * Method to Validate shareicon displayed on Articles page
	 * @return true if Print icon is Displayed 
	 */
	public boolean shareIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement shareicon = getDriver().findElement(byShareicon);
		//shareicon.syncVisible(30);
		//return shareicon.isDisplayed();
	
		return getDriver().findElements(byShareicon).size() >0 ;
	}
	
	public void shareIconExpands()
	{
		WebPageLoaded.isDomInteractive();
		WebElement shareicon = getDriver().findElement(byShareicon);
		//shareicon.syncVisible(30);
		shareicon.click();
		shareicon.focusClick();
	}
	
	/**
	 * @author Sandhya Rani
	 * Method to Validate share button has Facebook icon is Displayed and clickable 
	 * @return true if Facebook icon is Displayed 
	 */
	public boolean facebookIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement facebook=getDriver().findElement(byfacebookIcon);
		facebook.syncVisible(30);
		
		return facebook.isDisplayed();
	}
	
	public void clickonFacebookIcon()
	{
		WebPageLoaded.isDomInteractive();
		WebElement facebook=getDriver().findElement(byfacebookIcon);
		facebook.click();
		facebook.focusClick();
	}
	
	/**
	 * @author Sandhya Rani
	 * Method to Validate share button has Twitter icon is Displayed and clickable 
	 * @return true if Twitter icon is Displayed 
	 */
	public boolean twitterIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement facebook=getDriver().findElement(byTwitterIcon);
		facebook.syncVisible(30);
		
		return facebook.isDisplayed();
	}
	
	public void clickontwitterIcon()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement facebook=getDriver().findElement(byTwitterIcon);
		facebook.click();
		facebook.focusClick();
	}
	
	/**
	 * @author Sandhya Rani
	 * Method to Validate share button has Email icon is Displayed and clickable 
	 * @return true if Email icon is Displayed 
	 */
	public boolean mailIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement facebook=getDriver().findElement(byEmailIcon);
		facebook.syncVisible(30);
		
		return facebook.isDisplayed();
	}
	
	public void clickonEmailIcon()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement facebook=getDriver().findElement(byEmailIcon);
		facebook.syncVisible(30);
		facebook.click();
		facebook.focusClick();
	}
	
}
