package com.accuweather.glacier.www.articlespage;

import org.testng.annotations.Test;

import org.testng.Assert;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.ArticlesPage;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;

public class Test_ArticlesPage extends AccuWeatherBaseTest
{
	String expectedNewsPageTitle="Weather News - AccuWeather.com";


	private static final String EXPECTED_NEWS_LANDINGPAGE_URL="https://qualityassurance.accuweather.com/en/weather-news";

	private static final String NEWS_MENU="News";
	private static final String VIDEOS_MENU ="Videos";
	private static final String BLOGS_MENU ="Blogs";
	private static final String PERSONALITIES_MENU ="Personalities";

	private static final int INITIAL_ARTICLES_SIZE=5;

	private static final String EXPECTED_LANDINGPAGEURL_REPORT_TYPO="https://qualityassurance.accuweather.com/en/contact/?type=typo";
	private static final int ARTICLES_SIZE_AFTER_CLICKONSHOWMORE=10;


	private NavigationBar navigation=new NavigationBar();
	private ArticlesPage articles=new ArticlesPage();


	@Test(priority=1,enabled = true)
	public void RW_TC367_Navigation_to_News_Article_Page_succesfully()
	{
		testStart("Validate National Article page is loaded successfully");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		String actuallandingpageURL=getDriver().getCurrentUrl();
		Assert.assertEquals(actuallandingpageURL, EXPECTED_NEWS_LANDINGPAGE_URL);
	}


	@Test(priority=2,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_Validate_SecondaryMenu_isDisplayed()
	{
		testStart("Navigating to News Article page and Validating Secondary Menu Displayed on the page");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		Sleeper.sleep(5);
		articles.subNavigatiomenusdisplayed();
	}


	@Test(priority=3,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_SecondaryMenu_hasNewstabDisplayed()
	{
		testStart("Navigating to News Article page and Validating Secondary Menu has News tab Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		Sleeper.sleep(5);
		articles.subNavigatiomenusdisplayed();
		articles.isSecondarymenuhas(NEWS_MENU);
	}

	@Test(priority=4,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_SecondaryMenu_hasVideoTabDisplayed()
	{
		testStart("Navigating to News Article page and Validating Secondary Menu has Video tab Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.subNavigatiomenusdisplayed();
		articles.isSecondarymenuhas(VIDEOS_MENU);
	}
	@Test(priority=5,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_SecondaryMenu_hasBlogstabDisplayed()
	{
		testStart("Navigating to News Article page and Validating Secondary Menu has Blogs tab Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.subNavigatiomenusdisplayed();
		articles.isSecondarymenuhas(BLOGS_MENU);
	}
	@Test(priority=6,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_SecondaryMenu_hasPersonalitiestabDisplayed()
	{
		testStart("Navigating to News Article page and Validating Secondary Menu has Personalities tab Displayed ");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.subNavigatiomenusdisplayed();
		articles.isSecondarymenuhas(PERSONALITIES_MENU);
	}

	@Test(priority=7,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_NewsTab_HighlightedinOrange_byDefault()
	{
		testStart("Navigating to News Article page and Validating News tab Highlighted in Orange by Default");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.subNavigatiomenusdisplayed();
		String color=articles.newstabHighlightedColor();
		System.out.println("Color displayed is "+color);
	}

	@Test(priority=8,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_latestWeather_Displayed()
	{
		testStart("Navigating to News Article page and Validating Latest  Weather Header is displayed below Secondary Navgation menus");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		Assert.assertTrue(articles.currentWeatherisDisplayed());
	}


	@Test(priority=9,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_numberofArticles_Displayed()
	{
		testStart("Navigating to News Article page and Validating five Articles displayed below Current Weather Header");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		int numberofArticles=articles.articlesDisplayedSize();
		Assert.assertEquals(numberofArticles, INITIAL_ARTICLES_SIZE);
	}


	@Test(priority=10,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_ShowMore_button_Displayed()
	{
		testStart("Navigating to News Article page and Validating five Articles displayed below Current Weather Header");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		articles.scrolldownpage();
		Assert.assertTrue(articles.showMoreButtonisDisplayed());

	}

	@Test(priority=11,enabled = true)
	public void RW_TC368_Navigating_to_News_Article_Page_andValidating_Articlespage_whenclickedonArticle()
	{
		testStart("Navigating to News Article page and Validating five Articles displayed below Current Weather Header");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		System.out.println("Current URLafter clicking on Article"+getDriver().getCurrentUrl());	
	}

	@Test(priority=11,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_Articlespage_whenclickedonArticle()
	{
		testStart("Navigating to News Article page and Validating five Articles displayed below Current Weather Header");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(3);
		System.out.println("Current URLafter clicking on Article"+getDriver().getCurrentUrl());	


	}

	@Test(priority=12,enabled = true)
	public void RW_TC367_Navigating_to_News_Article_Page_andValidating_Articlespage_textDisplayed()
	{
		testStart("Navigating to News Article page and Validating five Articles displayed below Current Weather Header");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.scrolldownpage();
		articles.scrolldownpage();
		String homepageText=articles.articlesText();
		articles.clickonArticlesDisplayed();
		String landingpageText=articles.landingpageText();
		Assert.assertEquals(homepageText, landingpageText);

	}

	@Test(priority=13,enabled = true)
	public void RW_TC371_Navigating_to_News_Article_Page_andValidating_ReportTypo_isDisplayed()
	{
		testStart("Navigating to News Article page Click on Articles displayed Validate Report Typo is Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.clickonArticlesDisplayed();
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.scrolldownpage();
		Assert.assertTrue(articles.reportTypoisDisplayed());

	}

	@Test(priority=14,enabled = true)
	public void RW_TC371_Navigating_to_News_Article_Page_andValidating_ReportTypo_Landingpage_URL()
	{
		testStart("Navigating to News Article page Click on Articles displayed Validate Report Typo is Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		WebPageLoaded.isDomComplete(300);
		articles.clickonArticlesDisplayed();
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.scrolldownpage();
		articles.reportTypoisDisplayed();
		articles.clickonreportTypo();
		Sleeper.sleep(3);
		String landingpageURL=articles.getlandingPageUrlTitle();
		System.out.println("landing page URL is "+landingpageURL);
		Assert.assertEquals(landingpageURL, EXPECTED_LANDINGPAGEURL_REPORT_TYPO);		
	}

	@Test(priority=15,enabled = true)
	public void RW_TC758_Navigating_to_News_Article_Page_andValidating_ShowMOre_Displayed()
	{
		testStart("Navigating to News Article page and Validating Show More CTA is Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.scrolldownpage();
		articles.scrolldownpage();
		Sleeper.sleep(5);
		WebPageLoaded.isDomComplete(300);
		Sleeper.sleep(3);
		Assert.assertTrue(articles.showMoreCTAisDisplayed());


	}

	@Test(priority=16,enabled = true)
	public void RW_TC758_Navigating_to_News_Article_Page_andClick_onShowMore_CTA()
	{
		testStart("Navigating to News Article page and Validating Show More CTA is Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.scrolldownpage();
		Sleeper.sleep(5);
		WebPageLoaded.isDomComplete(300);
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(3);
		int articlesSize=articles.articlesDisplayedSize();
		Assert.assertEquals(articlesSize, ARTICLES_SIZE_AFTER_CLICKONSHOWMORE);

	}

	@Test(priority=17,enabled = true)
	public void RW_TC759_Navigating_to_News_Article_Page_andValidate_onShowless_CTA()
	{
		testStart("Navigating to News Article page and Validating Show More CTA is Displayed");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.scrolldownpage();
		Sleeper.sleep(5);
		WebPageLoaded.isDomComplete(300);
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		Assert.assertTrue(articles.showLessCTAisDisplayed());

	}

	@Test(priority=18,enabled = true)
	public void RW_TC759_Navigating_to_News_Article_Page_andValidate_ClickonShowless_CTA()
	{
		testStart("Navigating to News Article page and Validating Show Less CTA is Displayed and when clicked on Show less Hides the additional articles and reverts back to the initial 5 in view.");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.scrolldownpage();
		Sleeper.sleep(5);
		WebPageLoaded.isDomComplete(300);
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(3);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowmoreCTA();
		Sleeper.sleep(5);
		articles.clickonShowLessCTA();
		int articlesSize=articles.articlesDisplayedSize();
		Assert.assertEquals(articlesSize, INITIAL_ARTICLES_SIZE);	
	}


	@Test(priority=19,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_Shareicon_Displayed()
	{
		testStart("Navigating to News Article page and Validating Show Less CTA is Displayed and when clicked on Show less Hides the additional articles and reverts back to the initial 5 in view.");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		Assert.assertTrue(articles.shareIconDisplayed());
	}


	@Test(priority=20,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_facebook_iconDisplayed() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu isDisplayed  which has Facebook icon in it");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		Assert.assertTrue(articles.facebookIconDisplayed());
	}

	@Test(priority=21,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_facebook_LandingpageTitle() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu Displayed validte Facebook landing page url");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		articles.clickonFacebookIcon();
		waitUntilElementIsDisplayedOrClickable();
		String pageTitle=articles.getlandingurltitle();
		Assert.assertTrue(pageTitle.startsWith("https://www.facebook.com/login.php"));
	}


	@Test(priority=22,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_Twitter_iconDisplayed() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu isDisplayed  which has Twittew icon in it");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		Assert.assertTrue(articles.twitterIconDisplayed());
	}


	@Test(priority=23,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_twitter_LandingpageTitle() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu Displayed validte Twitter landing page url");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		articles.clickontwitterIcon();
		waitUntilElementIsDisplayedOrClickable();
		String pageTitle=articles.getlandingurltitle();
		Assert.assertTrue(pageTitle.startsWith("https://twitter.com/intent/tweet?"));
	}


	@Test(priority=22,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_Mail_iconDisplayed() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu isDisplayed  which has Twittew icon in it");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		Assert.assertTrue(articles.mailIconDisplayed());
	}


	@Test(priority=23,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_Validate_Mail_LandingpageTitle() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu Displayed validte Twitter landing page url");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		articles.clickonEmailIcon();

	}
	@Test(priority=22,enabled = true)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_ValidatePrint_iconDisplayed() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu isDisplayed  which has Twittew icon in it");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		Assert.assertTrue(articles.printIconDisplayed());
	}


	@Test(priority=23,enabled = false)
	public void RW_TC750_Navigating_to_News_Article_Page_ClickonArticles_ValidatePrint_LandingpageTitle() 
	{
		testStart("Navigating to News Article page click on any Articles and click on Share icon expanded menu Displayed validte Twitter landing page url");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		articles.shareIconDisplayed();
		Sleeper.sleep(6);
		articles.shareIconExpands();
		Sleeper.sleep(6);
		String landingpageurl=articles.getlandingurltitle();
		System.out.println("Landing page url "+landingpageurl);

	}

	@Test(priority=24,enabled = true)
	public void RW_TC964_Navigating_to_News_Article_Page_Validate_ArticlebyLine_Displayed()
	{
		testStart("Navigating to News Article page and Click on Any Article and Validate Article by Line is Displayed.");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		String text=articles.articlesByLineDisplayed();
		System.out.println("Text displayed is "+text);
	}

	@Test(priority=25,enabled = true)
	public void RW_TC964_Navigating_to_News_Article_Page_Validate_ArtilcebyDate_Displayed()
	{
		testStart("Navigating to News Article page and Click on Any Article and Validate Article by Date is Displayed.");
		navigation.navigateToNews();
		navigation.isWeatherNewsSubMenuDisplayed();
		navigation.navigateToNewsPage();
		Sleeper.sleep(5);
		waitUntilElementIsDisplayedOrClickable();
		waitUntilWindowExistsWithTitle(expectedNewsPageTitle);
		articles.clickonArticlesDisplayed();
		Sleeper.sleep(6);
		String dateDisplayed=articles.artilcesByDateDisplayed();
		Assert.assertNotNull(dateDisplayed);
	}

}
