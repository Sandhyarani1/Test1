package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;

public class SmokeTests extends BasePage
{
	private By centerWell1Title = By.cssSelector("div.content-module.zone-centerWell1 > a > div > div > div.featured-title");
	private By centerWell1FeaturedDate = By.cssSelector("div.content-module.zone-centerWell1 > a > div > div > div.featured-date");
	private By centerWell1VideoTitle = By.cssSelector("div.title-share > div.jw-title.jw-reset-text > div.jw-title-primary.jw-reset-text");
	private By weatherNewsArticles = By.cssSelector("div.zone-centerWell2 > div > a");
	private By showMoreButton = By.cssSelector("div.zone-centerWell2 > div > a.more-button > span.text");
	
	public static final String SHOW_MORE = "SHOW MORE";
	public static final String SHOW_LESS = "SHOW LESS";
	
	
	/**
	 * @author HFARAZ
	 * Method to scroll to the bottom of the page
	 * */
	public void scrollDown(int pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver().getWebDriver();
		js.executeScript("window.scrollBy(0,"+pixels+")");
		//js.executeScript("arguments[0].scrollIntoView();", element);
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the title of content module is displayed
	 * @return true if displayed else false
	 * */
	public Boolean isContentModuleTitleDisplayed()
	{
		Boolean isContentModuleTitleDisplayed = false;
		WebPageLoaded.isDomComplete();
		scrollDown(800);
		WebPageLoaded.isDomComplete();
		try
		{
			if(getDriver().findElement(centerWell1Title).isDisplayed())
				isContentModuleTitleDisplayed = true;
		}
		catch(NoSuchElementException nsee)
		{
			isContentModuleTitleDisplayed = false;
			System.err.println(nsee.getMessage());
		}
		return isContentModuleTitleDisplayed;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Content Module title
	 * @return String value of content module title
	 * */
	public String getContentModuleTitle()
	{
		if(isContentModuleTitleDisplayed().equals(true))
			return getDriver().findElement(centerWell1Title).getText();
		else
			return null;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the date of content module is displayed
	 * @return true if displayed else false
	 * */
	public Boolean isContentModuleDateDisplayed()
	{
		Boolean isContentModuleDateDisplayed = false;
		WebPageLoaded.isDomComplete();
		try
		{
			if(getDriver().findElement(centerWell1FeaturedDate).isDisplayed())
				isContentModuleDateDisplayed = true;
		}
		catch(NoSuchElementException nsee)
		{
			isContentModuleDateDisplayed = false;
			System.err.println(nsee.getMessage());
		}
		return isContentModuleDateDisplayed;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Content Module date
	 * @return String value of content module date
	 * */
	public String getContentModuleDate()
	{
		if(isContentModuleDateDisplayed().equals(true))
			return getDriver().findElement(centerWell1FeaturedDate).getText();
		else
			return null;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the date of content module is displayed
	 * @return true if displayed else false
	 * */
	public Boolean isCenterWell1VideoDisplayed()
	{
		Boolean isCenterWell1Video = false;
		WebPageLoaded.isDomComplete();
		try
		{
			if(getDriver().findElement(centerWell1VideoTitle).isDisplayed())
				isCenterWell1Video = true;
		}
		catch(NoSuchElementException nsee)
		{
			isCenterWell1Video = false;
			System.err.println(nsee.getMessage());
		}
		return isCenterWell1Video;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Content Module date
	 * @return String value of content module date
	 * */
	public String getCenterWell1VideoTitle()
	{
		if(isCenterWell1VideoDisplayed().equals(true))
			return getDriver().findElement(centerWell1VideoTitle).getText();
		else
			return null;
	}
	
	/**
	 * @author HFARAZ
	 * Method to check if the date of content module is displayed
	 * @return true if displayed else false
	 * */
	public Boolean isWeatherNewsArticlesDisplayed()
	{
		Boolean isWeatherArticleDisplayed = false;
		WebPageLoaded.isDomComplete();
		try
		{
			if(getDriver().findElement(weatherNewsArticles).isDisplayed())
				isWeatherArticleDisplayed = true;
		}
		catch(NoSuchElementException nsee)
		{
			isWeatherArticleDisplayed = false;
			System.err.println(nsee.getMessage());
		}
		return isWeatherArticleDisplayed;
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the text of Content Module date
	 * @return String value of content module date
	 * */
	public int getCountOfWeatherNewsArticles()
	{
		 WebPageLoaded.isDomComplete();
		 scrollDown(100);
		 List<WebElement> weatherArticles = getDriver().findElements(weatherNewsArticles);
		 if(!weatherArticles.isEmpty())
			 return weatherArticles.size()-1;
		 else 
			 return 0;
	}
	
	/**
	 * @author HFARAZ
	 * Method to click 'SHOW MORE' button
	 * */
	public void clickShowMore()
	{
		WebPageLoaded.isDomComplete();
		scrollDown(800);
		WebPageLoaded.isDomComplete();
		while(getDriver().findElement(showMoreButton).getText().equalsIgnoreCase(SHOW_MORE))
		{
			scrollDown(200);
			WebPageLoaded.isDomComplete();
			getDriver().findElement(showMoreButton).jsClick();
		}
			
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the weather news articles
	 * */
	public ArrayList readWeatherNewsTitles(int count)
	{
		String window = "";
		ArrayList<String> weatherNewsTitles = new ArrayList<String>();
		WebPageLoaded.isDomComplete();
		
		for(int i=1;i<=count;i++)
		{
			if (i==1)
			{
				int j=i+1;
				if(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText().equalsIgnoreCase("VIDEO"))
				{
					getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-title > p")).jsClick();
					window = getDriver().getWindowHandle();
					switchToDifferentTab(window);
					WebPageLoaded.isDomComplete();
					weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div > div.featured-video.featured-video > div.video-content > div.media-data > h1")).getText());
					getDriver().close();
				}
				else
				{
					getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-title > p")).jsClick();
					WebPageLoaded.isDomComplete();
					//window = getDriver().getWindowHandle();
					//switchToDifferentTab(window);
					weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div.template-root > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.article.card.full-mobile-width.comments > h1.title.hasPartner")).getText());
					getDriver().navigate().back();
				}
			}
			else
			{
				int j=i+2;
				WebPageLoaded.isDomComplete();
				if (getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText().equalsIgnoreCase("VIDEO"))
				{
					getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div > div.tout-title > p")).jsClick();
					window = getDriver().getWindowHandle();
					switchToDifferentTab(window);
					weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div > div.featured-video.featured-video > div.video-content > div.media-data > h1")).getText());
					getDriver().close();
				}
				else
				{
					getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div > div.tout-title > p")).jsClick();
					//window = getDriver().getWindowHandle();
					//switchToDifferentTab(window);
					weatherNewsTitles.add(getDriver().findElement(By.cssSelector("body > div.template-root > div:nth-child(5) > div > div.page-column-1 > div:nth-child(1) > div.article.card.full-mobile-width.comments > h1.title.hasPartner")).getText());
					getDriver().navigate().back();
				}
			}
			
			
		}
		return weatherNewsTitles;
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the weather news dates
	 * */
	public ArrayList readWeatherNewsDate(int count)
	{
		ArrayList<String> weatherNewsDates = new ArrayList<String>();
		WebPageLoaded.isDomComplete();
		//weatherNewsDates.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > div.tout-body > div.tout-meta > span.tout-date")).getText());
		for(int i=1;i<=count;i++)
		{
			if (i==1)
			{
				int j=i+1;
				weatherNewsDates.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-date")).getText());
			}
			else
			{
				int j=i+2;
				weatherNewsDates.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-date")).getText());
			}
			
		}
		return weatherNewsDates;
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to read the weather news type
	 * */
	public ArrayList readWeatherNewsType(int count)
	{
		ArrayList<String> weatherNewsTypes = new ArrayList<String>();
		WebPageLoaded.isDomComplete();
		
		//weatherNewsTypes.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child(2) > div.tout-body > div.tout-meta > span.tout-type")).getText());
		for(int i=1;i<=count;i++)
		{
			if (i==1)
			{
				int j=i+1;
				weatherNewsTypes.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText());
			}
			else
			{
				int j=i+2;
				weatherNewsTypes.add(getDriver().findElement(By.cssSelector("div.zone-centerWell2 > div > a:nth-child("+j+") > div.tout-body > div.tout-meta > span.tout-type")).getText());
			}
		}
		return weatherNewsTypes;
		
	}
	
	/**
	 * @author HFARAZ
	 * Method to read right rail articles
	 * */
	public ArrayList<String> getRightRailArticlesTitles(int count)
	{
		ArrayList<String> rightRailArticlesTitle = new ArrayList<String>();
		WebPageLoaded.isDomComplete();
		for (int i=1;i<=count;i++)
		{
			try
			{
				if(getDriver().findElement(By.cssSelector("div.content-module.zone-rightRail1 > div > a:nth-child("+i+") > p.right-rail-article-title")).isDisplayed())
					rightRailArticlesTitle.add(getDriver().findElement(By.cssSelector("div.content-module.zone-rightRail1 > div > a:nth-child("+i+") > p.right-rail-article-title")).getText());
			}
			catch(NoSuchElementException nsee)
			{
				System.err.println(nsee.getMessage());
			}
			
		}
		return rightRailArticlesTitle;
	}
	
}
