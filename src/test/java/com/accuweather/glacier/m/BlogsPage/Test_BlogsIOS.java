package com.accuweather.glacier.m.BlogsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accuweather.glacier.api.BlogsAPI;
import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.BlogsPageIOS;
import com.accuweather.glacier.m.pages.LandingPageMobile;

public class Test_BlogsIOS extends AccuWeatherMobileBaseTest {

	String zipcode = "48073";
	public static final String WEATHEHBLOGSLANDINGURL = "https://qualityassurance.accuweather.com/en/weather-blogs";
	String EXPECTEDBLOGSTABCOLOR = "#f05514";

	private BlogsPageIOS BlogsPage = new BlogsPageIOS();
	private LandingPageMobile landingPage = new LandingPageMobile();

	@Test(priority = 1, enabled = false)
	public void TC1_1323_ValidateWeatherBlogsPageLoadSuccessfully() {
		testStart("Validate weather-blogs page load successfully");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertEquals(BlogsPage.getcurrentUrl(), WEATHEHBLOGSLANDINGURL);
		softassert.assertTrue(BlogsPage.weatherBlogsTabsIsDisplayed());
		softassert.assertEquals(BlogsPage.weatherBlogsTabsIsDisplayedInOrangeColor(), EXPECTEDBLOGSTABCOLOR);
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1324_ValidateBlogCategoryAppearOnRightRailOfTheBlogLandingPage() {
		testStart("alidate the Blog category appear on the right rail of the blog landing page");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsVerification());
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageOne() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(1));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleOne() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(1));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryOne() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(1));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateOne() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(1));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageTwo() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(2));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleTwo() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(2));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryTwo() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(2));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateTwo() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(2));
	}

	// three

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageThree() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(3));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleThree() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(3));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryThree() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(3));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateThree() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(3));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageFour() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(4));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleFour() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(4));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryFour() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(4));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateFour() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(4));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageFive() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(5));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleFive() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(5));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryFive() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(5));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateFive() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(5));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageSix() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();

		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(6));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleSix() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(6));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategorySix() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(6));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateSix() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(6));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageSeven() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(7));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleSeven() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(7));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategorySeven() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(7));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateSeven() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(7));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageEight() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();

		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(8));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleEight() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(8));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryEight() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(8));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateEight() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(8));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageNine() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(9));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleNine() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(9));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryNine() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(9));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateNine() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(9));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogImageTen() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();

		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogImage(10));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogtitleTen() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleTitle(10));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogArticleCategoryTen() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogArticleCategory(10));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1325_ValidateUserClickOnBlogPublishDateTen() {
		testStart("Validate User Clicks on image,Blog title,Blog category and publish date");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickMoreBlogsButton();
		softassert.assertTrue(BlogsPage.weatherBlogsIndidualVerificationBlogPublishDate(10));
	}

	@Test(priority = 2, enabled = false)
	public void TC1_1963_ValidateZergnetWidgetAppearsOnTheBottomOfRightRailOfBlogPages() {
		testStart("Validate Zergnet widget appears on the bottom of right rail of Blog pages");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		landingPage.clickOnZipcodeSearchIcon();
		BlogsPage.clickBreadCrumbMenu();
		BlogsPage.clickBreadCrumbMenuNews();
		BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		BlogsPage.clickOnAstronomyBlog();
		softassert.assertTrue(BlogsPage.clickOnArticleOnWidget());

	}

	@Test(priority = 2, enabled = true)
	public void TC1_1326_ValidateHookUpBlogsAPIWeatherBlogsPostWithCategory() {
		testStart("Validate Zergnet widget appears on the bottom of right rail of Blog pages");
		SoftAssert softassert = new SoftAssert();
		waitUntilElementIsDisplayedOrClickable();
		/*
		 * landingPage.enterZipcodeInSearchFieldAndClick(zipcode);
		 * landingPage.clickOnZipcodeSearchIcon(); BlogsPage.clickBreadCrumbMenu();
		 * BlogsPage.clickBreadCrumbMenuNews();
		 * BlogsPage.clickbyBreadCrumbMenuWeatherBlogs();
		 */
		BlogsPage.clickOnCanadianWeatherCategory();
		softassert.assertTrue(BlogsPage.clickOnFirstBlogUnderWeatherCategory());
	}

	@Test(priority = 3, enabled = false)
	public void RW_T1326_validationofBlogNames() {
		testStart("********Validation of blog Name********");
		ArrayList<String> var = BlogsAPI.getBlogsName();
		System.out.println("output");
		for (int i = 0; i < var.size(); i++) {
			System.out.println(var.get(i));

		}

	}

	@Test(priority = 4, enabled = false)
	public void RW_T1326() {
		testStart("********Validation of blog image type********");
		ArrayList<String> var = BlogsAPI.getBlogsImageType();
		System.out.println("output");
		for (int i = 0; i < var.size(); i++) {
			System.out.println(var.get(i));

		}

	}

	@Test(priority = 4, enabled = true)
	public void RW_T1327() {
		testStart("********Validation of blogger names********");
		
		// UI
		
		List<String> UIList = BlogsPage.getBloggersNames();
		
		ArrayList<String> var = BlogsAPI.getBlogsBloggerNames();
		
		
		System.out.println("output");
		for (int i = 0; i < var.size(); i++) {
			System.out.println("APi List" + var.get(i));

		}
		 // API 
		
		boolean isEqual = var.equals(UIList); // false
		for (int j = 0; j < UIList.size(); j++) {
			System.out.println("UI List" + var.get(j));

		}
		System.out.println("isEqual" + isEqual);

	}

}
