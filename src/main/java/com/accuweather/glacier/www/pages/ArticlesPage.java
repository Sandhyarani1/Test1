package com.accuweather.glacier.www.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class ArticlesPage extends BasePage
{


	private By bySubNavigationMenus = By.cssSelector("div.page-subnav > div > div > div.subnav-items");
	private By bysecondarymenuNews= By.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bynewsTab=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a.subnav-item.active");
	private By bysecondarymenuVideos=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(2) > span");
	private By bysecondarymenuBlogs=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(3) > span");
	private By bysecondarymenuPersonalities=By.cssSelector("div.page-subnav > div > div > div.subnav-items > a:nth-child(4) > span");
	private By byCurrentWeather=By.cssSelector("div.content-module > div.zone-centerWell2 > div > p");
	private By byarticlesDisplayed=By.xpath("//div[@class='content-recirc']//a");
    private By byShowMoreButton=By.cssSelector("div.content-module > div.zone-centerWell2 > div > a.more-button");

    private By bycontentText=By.cssSelector("div.content-module > div.zone-centerWell2 > div > a:nth-child(4) > div > div.tout-title");


    private By bylandingpageContentarticle1=By.cssSelector("div > div.article.card.full-mobile-width.comments > h1");
    private By byReportTypo=By.cssSelector(" div.page-column-1 > div > div.article.card.full-mobile-width.comments > a");
    
    private By byShowMoreCta=By.cssSelector("div.zone-centerWell2 > div > a.more-button > span");
	private By byShowLessCTA=By.cssSelector("div.zone-centerWell2 > div > a.more-button > span");
    private By byShareicon=By.cssSelector("div > div.article.card.full-mobile-width.comments > div.top-header > div > span > svg:nth-child(6)");
    
    private By byArticlebyLine=By.cssSelector("div.article.card.full-mobile-width.comments > div.byline-section > p.byline > span.author");
    private By byArticlebyDate=By.cssSelector("div.article.card.full-mobile-width.comments > div.byline-section > p.date");
  
    private By byfacebookIcon=By.cssSelector("div > div.article.card.full-mobile-width.comments > div.top-header > div > span > a:nth-child(1) > svg");
    private By byTwitterIcon=By.cssSelector("div.top-header > div > span > a:nth-child(2) > svg > path");
    private By byEmailIcon=By.cssSelector("div.article.card.full-mobile-width.comments > div.top-header > div > span > a:nth-child(3) > svg");
    private By byprintIcon=By.cssSelector("div > div.article.card.full-mobile-width.comments > div.top-header > div > span > svg.hide-mobile-inherit.padding.fade-in-right > g");
	/**
	 * @author Sandhya Rani
	 * Method to Validate Secondary menus for New Weather page has News, Video,Blogs and Personalities displayed
	 * 
	 */
    
	public void subNavigatiomenusdisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement radarandmaps = getDriver().findElement(bySubNavigationMenus);
		radarandmaps.syncVisible(300);
	}

	public boolean isSecondarymenuhas(String link) {
		if (link.equalsIgnoreCase("News")) {
			WebPageLoaded.isDomInteractive();
			WebElement newsTab = getDriver().findElement(bysecondarymenuNews);
			newsTab.syncVisible(15);
			return newsTab.isDisplayed();
		}

		if (link.equalsIgnoreCase("Videos")) {
			WebPageLoaded.isDomInteractive();
			WebElement videosTab = getDriver().findElement(bysecondarymenuVideos);
			videosTab.syncVisible(15);
			return videosTab.isDisplayed();
		}

		if (link.equalsIgnoreCase("Blogs")) {
			WebPageLoaded.isDomInteractive();
			WebElement blogsTab = getDriver().findElement(bysecondarymenuBlogs);
			blogsTab.syncVisible(15);
			return blogsTab.isDisplayed();

		}
		if (link.equalsIgnoreCase("Personalities")) {
			WebPageLoaded.isDomInteractive();
			WebElement personalitiesTab = getDriver().findElement(bysecondarymenuPersonalities);
			personalitiesTab.syncVisible(15);
			return personalitiesTab.isDisplayed();
		}

		return false;
	}


	public String newstabHighlightedColor() {
		String tabColor = getDriver().findElement(bynewsTab).getCssValue("border-top");
		String boarderColor = tabColor.substring(10);
		return Color.fromString(boarderColor).asHex();
	}

	public boolean currentWeatherisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement currentWeather = getDriver().findElement(byCurrentWeather);
	
		
		currentWeather.syncVisible(30);
		return currentWeather.isDisplayed();
	}

	

	/**
	 * @author Sandhya Rani
	 * Method to Scroll down the Page 
	 *         
	 **/

	public void scrolldownpage() {
		getDriver().executeJavaScript("window.scrollBy(151,975)");
		Sleeper.sleep(3);
	}
	
	public int	articlesDisplayedSize()
	{
		List<org.openqa.selenium.WebElement> article = getDriver().findElements(byarticlesDisplayed); 
		return article.size()-1;
	}


	public boolean showMoreButtonisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showMoreButton = getDriver().findElement(byShowMoreButton);

		showMoreButton.syncVisible(30);
		return showMoreButton.isDisplayed();
	}
	
	
	public String articlesText()
	{
	 return getDriver().findElement(bycontentText).getText();
	
	}
	
	public void clickonArticlesDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement articles = getDriver().findElement(bycontentText);
		articles.syncVisible(30);
		articles.jsClick();
	}
	
	public String landingpageText()
	{
		return getDriver().findElement(bylandingpageContentarticle1).getText();
	}

	public boolean reportTypoisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement reportTypo = getDriver().findElement(byReportTypo);
		
		reportTypo.syncVisible(30);
	    return reportTypo.isDisplayed();
	}
	
	public void clickonreportTypo()
	{
		WebPageLoaded.isDomInteractive();
		WebElement reportTypo = getDriver().findElement(byReportTypo);
		
		reportTypo.syncVisible(30);
		reportTypo.jsClick();
	}
	
	
	public String getlandingPageUrlTitle() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
	    Sleeper.sleep(4);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}
		
	public boolean showMoreCTAisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showMoreCta = getDriver().findElement(byShowMoreCta);
		showMoreCta.syncVisible(60);
		return showMoreCta.isDisplayed();
	}
	
	public void clickonShowmoreCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showMoreCta = getDriver().findElement(byShowMoreCta);
		showMoreCta.jsClick();	
	}
	
	public boolean showLessCTAisDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showLessCta = getDriver().findElement(byShowLessCTA);
		showLessCta.syncVisible(60);
		return showLessCta.isDisplayed();
	}
	
	public void clickonShowLessCTA()
	{
		WebPageLoaded.isDomInteractive();
		WebElement showLessCta = getDriver().findElement(byShowLessCTA);
		showLessCta.jsClick();	
	}
	
	public boolean shareIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		WebElement shareicon = getDriver().findElement(byShareicon);
		shareicon.syncVisible(30);
		return shareicon.isDisplayed();	
	}
	
	public void shareIconExpands()
	{
		WebPageLoaded.isDomInteractive();
		WebElement shareicon = getDriver().findElement(byShareicon);
		shareicon.syncVisible(30);
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
	
	/**
	 * @author Sandhya Rani
	 * Method to Validate share button has Print icon is Displayed and clickable 
	 * @return true if Print icon is Displayed 
	 */
	public boolean printIconDisplayed()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement printIcon=getDriver().findElement(byprintIcon);
		printIcon.syncVisible(30);
		
		return printIcon.isDisplayed();
	}
	
	public void clickonPrintIcon()
	{
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(3);
		WebElement printIcon=getDriver().findElement(byprintIcon);
		printIcon.syncVisible(30);
		printIcon.click();
		printIcon.focusClick();
		
	}
	
	
	public void  closeBrowser() throws AWTException
	{

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);
		

		r.keyRelease(KeyEvent.VK_ESCAPE);
		
	}
	
	public void validatePrintButtonDisplayed()
	{
	
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[1].toString());
		
		JavascriptExecutor executor = (JavascriptExecutor) getDriver().getWebDriver();
		executor.executeScript("document.getElementsByClassName('cancel')[0].click();");
		
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	/**
	 * @author Sandhya Rani 
	 * Method to switch the control to new tab and extracting landing page URL
	 * @return - String value - "URL of the Landing page"
	 **/
	
	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		Sleeper.sleep(3);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}
	
	
	
	public void getTitle()
	{
		String parentWindow = getDriver().getWindowHandle();
		Set<String> handles =  getDriver().getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          getDriver().switchTo().window(windowHandle);
                  System.out.println("Current Url of Print page is"+ getDriver().getCurrentUrl());       
                
		           getDriver().close(); //closing child window
		          getDriver().switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
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
	
	
}
