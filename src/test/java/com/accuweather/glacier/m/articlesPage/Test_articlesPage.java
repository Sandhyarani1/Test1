
package com.accuweather.glacier.m.articlesPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.ArticlesPageMobile;
import com.chameleon.utils.Sleeper;

public class Test_articlesPage  extends AccuWeatherMobileBaseTest
{
	ArticlesPageMobile articles=new ArticlesPageMobile();
	
	String expectedNewsPageUrl ="https://qualityassurance.accuweather.com/en/weather-news";
	String newPageTitle="Current Weather News | AccuWeather";
	
	private static final int INITIAL_ARTICLES_SIZE=5;
	private static final int FINAL_ARTICLES_SIZE=10;
	
	
	@Test(priority=1,enabled = true)
	public void RW_TC945_Navigation_to_News_Article_Page_succesfully()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		System.out.println("News Landing page url  is "+getDriver().getCurrentUrl());
		System.out.println("News page Title is "+getDriver().getTitle());
		Assert.assertEquals(getDriver().getCurrentUrl(), expectedNewsPageUrl);
	}
	
	
	@Test(priority=2,enabled = true)
	public void RW_TC945_Navigation_to_News_Article_Page_Validate_Secondary_menusDisplayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.validateSecondaryMenusDisplayed();
		Assert.assertTrue(articles.validateSecondaryMenusDisplayed());
	}
	
	@Test(priority=2,enabled=true)
	public void RW_TC944_Navigation_to_News_Article_Page_Validate_NewsTab_HighlightedbyDefault()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.NewstabHighlightedinOrange();
		
	}
	@Test(priority=3,enabled=true)
	public void RW_TC945_Navigation_to_News_Article_Page_ClickonArticles_Displayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		System.out.println("Current URLafter clicking on Article"+getDriver().getCurrentUrl());	
		
	}
	
	
	@Test(priority=4,enabled=true)
	public void RW_TC946_Navigation_to_News_Article_Page_ClickonArticles_Validate_ReportTypoDisplayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		Assert.assertTrue(articles.reportTypoisDisplayed());
	}
	
	
	@Test(priority=5,enabled=false)
	public void RW_TC946_Navigation_to_News_Article_Page_Validate_ReportTypo_landingpageUrl()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
	    articles.ClickonreportTypoDisplayed();
		Sleeper.sleep(3);
	    System.out.println("report typo landing url "+getDriver().getCurrentUrl());
		
	}
	
	@Test(priority=6,enabled=false)
	public void RW_TC953_Navigation_to_News_Article_Page_Validate_Showmore_CtaDisplayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		Assert.assertTrue(articles.showMoreCTAisDisplayed());
	}
	
	@Test(priority=7,enabled=false)
	public void RW_TC953_Navigation_to_News_Article_Page_Validate_ArticlesSize_Displayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		int numberofArticles=articles.articlesDisplayedSize();
		Assert.assertEquals(numberofArticles, INITIAL_ARTICLES_SIZE);
	}
	
	
	
	@Test(priority=8,enabled=false)
	public void RW_TC953_Navigation_to_News_Article_Page_Validate_Articles_SizeDisplayed_Whenclickedon_ShowMore()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		int articlesSize=articles.articlesDisplayedSize();
		Assert.assertEquals(articlesSize, FINAL_ARTICLES_SIZE);
	}
	
	@Test(priority=9,enabled=false)
	public void RW_TC954_Navigation_to_News_Article_Page_Validate_Showless_CtaDisplayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
		Assert.assertTrue(articles.showLessCTAisDisplayed());
	}

	@Test(priority=10,enabled=false)
	public void RW_TC955_Navigation_to_News_Article_Page_Validate_ArticlesSize_Displayed_whenClicked_onShowless()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		Sleeper.sleep(3);articles.clickonShowmoreCTA();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
//		articles.clickonShowmoreCTA();
//		Sleeper.sleep(5);
		articles.clickonShowLessCTA();
		Sleeper.sleep(3);
		int articlesSize=articles.articlesDisplayedSize();
		Assert.assertEquals(articlesSize, FINAL_ARTICLES_SIZE);	
	}
	
	@Test(priority=11,enabled = false)
	public void RW_TC966_Navigating_to_News_Article_Page_Validate_ArticlebyLine_Displayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		String text=articles.articlesByLineDisplayed();
		System.out.println("Text displayed is "+text);
		Assert.assertNotNull(articles.articlesByLineDisplayed());
	}
	
	
	@Test(priority=12,enabled=false)
	public void RW_TC966_Navigating_to_News_Article_Page_Validate_ArtilcebyDate_Displayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		String dateDisplayed=articles.artilcesByDateDisplayed();
		Assert.assertNotNull(dateDisplayed);
	}
	
	@Test(priority=13,enabled=false)
	public void RW_TC966_Navigating_to_News_Article_Page_Validate_Shareicon_Displayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		Assert.assertTrue(articles.shareIconDisplayed());
	}
	
	@Test(priority=14,enabled=false)
	public void RW_TC966_Navigating_to_News_Article_Page_Validate_Shareicon_hasSocial_Sharing_OptionsDisplayed()
	{
		testStart("Validate National Article page is loaded successfully");
		articles.clickBreadCrumbMenu();
		articles.navigateToNews();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		articles.clickonShareIcon();
		Sleeper.sleep(3);

	}
	
	
	
}
