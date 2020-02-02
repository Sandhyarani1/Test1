package com.accuweather.glacier.m.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class BlogsPageIOS extends MobileBasePage {

	private By byBreadCrumbMenu = By.cssSelector("div.icon-hamburger");
	private By byBreadCrumbMenuNews = By.cssSelector(".accordion-item:nth-child(2) .accordion-item-header-content");
	private By byBreadCrumbMenuWeatherBlogs = By.xpath("//a[contains(text(),'Weather Blogs')]");
	private By byNewsTab = By.xpath("//a[@class='subnav-item']//span[contains(text(),'News')]");
	private By byVideosTab = By.xpath("//span[contains(text(),'Videos')]");
	private By byBlogsTab = By.xpath("//h1[contains(text(),'BLOGS')]");
	private By byPersonalitiesTab = By.xpath("//span[contains(text(),'Personalities')]");

	private By byContentBlogOne = By.cssSelector("div.content-module.zone-centerWell1 > div > a:nth-child(2)");

	public Boolean clickBreadCrumbMenu() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenu).jsClick();
		return true;
	}

	public Boolean clickBreadCrumbMenuNews() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuNews).click();
		return true;
	}

	public Boolean clickbyBreadCrumbMenuWeatherBlogs() {
		WebPageLoaded.isDomInteractive();
		getDriver().findElement(byBreadCrumbMenuWeatherBlogs).jsClick();
		return true;
	}

	public String getcurrentUrl() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(2);
		return getDriver().getCurrentUrl();
	}

	public boolean weatherBlogsTabsIsDisplayed() {
		WebPageLoaded.isDomInteractive();
		Sleeper.sleep(2);
		return getDriver().findElements(byNewsTab).size() > 0 && getDriver().findElements(byVideosTab).size() > 0
				&& getDriver().findElements(byBlogsTab).size() > 0
				&& getDriver().findElements(byPersonalitiesTab).size() > 0;
	}

	public String weatherBlogsTabsIsDisplayedInOrangeColor() {
		WebPageLoaded.isDomInteractive();
		WebElement blogtab = getDriver().findElement(byBlogsTab);
		String radarBoarderColor = (String) DriverManager.getWebDriver().executeJavaScript(
				"return getComputedStyle(document.querySelector(\"body > div > div.page-subnav > div > div > div.subnav-items > a.subnav-item.active > h1\")).borderBottomColor;",
				blogtab);
		System.out.println("result > > > > " + radarBoarderColor);
		String actualColourdisplayed = Color.fromString(radarBoarderColor).asHex();
		return actualColourdisplayed;
	}

	public Boolean weatherBlogsVerification() {
		List<org.openqa.selenium.WebElement> blogslist = getDriver()
				.findElements(By.xpath("//div[@class='two-column-page-content']//li"));
		int BlogsSize = blogslist.size();
		Boolean blogtitle = null;
		Boolean blogAuthor = null;

		for (int i = 1; i <= BlogsSize; i++) {
			blogtitle = getDriver()
					.findElements(By.xpath("(//ul[@class='blog-list content-module full-responsive-width']/li/a)[" + i
							+ "]/div/div/div[@class='blog-title']"))
					.size() > 0;
			blogAuthor = getDriver()
					.findElements(By.xpath("(//ul[@class='blog-list content-module full-responsive-width']/li/a)[" + i
							+ "]/div/div/div[@class='blog-author']"))
					.size() > 0;
		}
		if (blogtitle.booleanValue() && blogAuthor.booleanValue())
			return true;
		else
			return false;
	}

	public boolean weatherBlogsIndidualVerificationBlogImage(int blogNumber) {
			getDriver().findElement(By.xpath("//div[@class='content-module']//a["+blogNumber+"]//img")).click();
		 Sleeper.sleep(2);
		 if(getDriver().findElements(By.xpath("//div[@class='article card full-mobile-width comments']")).size()>0)
			 return true;
		 else
			 return false;
	}

	public boolean weatherBlogsIndidualVerificationBlogArticleTitle(int blogNumber) {
		getDriver().findElement(By.xpath("//div[@class='content-module']//a["+blogNumber+"]//div[1]//div[1]")).click();
		 Sleeper.sleep(2);
		 if(getDriver().findElements(By.xpath("//div[@class='article card full-mobile-width comments']")).size()>0)
			 return true;
		 else
			 return false;
	}

	public boolean weatherBlogsIndidualVerificationBlogArticleCategory(int blogNumber) {
		getDriver().findElement(By.xpath("//div[@class='content-module']//a["+blogNumber+"]//div[1]//div[2]")).click();
		 Sleeper.sleep(2);
		 if(getDriver().findElements(By.xpath("//div[@class='article card full-mobile-width comments']")).size()>0)
			 return true;
		 else
			 return false;
	}

	public boolean weatherBlogsIndidualVerificationBlogPublishDate(int blogNumber) {
		getDriver().findElement(By.xpath("//a["+blogNumber+"]//div[1]//div[2]//span[2]")).click();
		 Sleeper.sleep(2);
		 if(getDriver().findElements(By.xpath("//div[@class='article card full-mobile-width comments']")).size()>0)
			 return true;
		 else
			 return false;
	}

	public void clickMoreBlogsButton() {
		getDriver().findElement(By.xpath("//a[@class='more-button']")).jsClick();
		Sleeper.sleep(1);
	}

	public void clickOnAstronomyBlog() {
		Sleeper.sleep(2);
		if(getDriver().findElements(By.xpath("//a[@href='/en/weather-blogs/astronomy']")).size()>0) {
			Sleeper.sleep(1);
			getDriver().findElement(By.xpath("//a[@href='/en/weather-blogs/astronomy']")).jsClick();
			Sleeper.sleep(2);
		}
	}

	public boolean clickOnArticleOnWidget() {
		if(getDriver().findElements(By.xpath("//div[@class='stories']/a")).size()>=4)
		getDriver().findElement(By.xpath("//div[@class='stories']/a[1]")).jsClick();
		if(getDriver().findElements(By.xpath("//Strong[@class='logo']/a[@href='https://www.zergnet.com']")).size()>0)
			return true;
		else 
			return false;
		
	}

	public void clickOnCanadianWeatherCategory() {
		Sleeper.sleep(2);
		if(getDriver().findElements(By.xpath("//div[@class='right-rail left-align-children content-module']")).size()>0)
		getDriver().findElement(By.xpath("//div[@class='two-column-page-content']//li[2]")).jsClick();
		
	}

	public boolean clickOnFirstBlogUnderWeatherCategory() {
		Sleeper.sleep(2);
		if(getDriver().findElements(By.xpath("//div[@class='content-module']//a[1]")).size()>0)
		getDriver().findElement(By.xpath("//div[@class='content-module']//a[1]")).jsClick();
		Sleeper.sleep(2);
		if(getDriver().findElements(By.xpath("//h1[@class='title hasPartner']")).size()>0)
			return true;
		else
			return false;
	}

	public ArrayList<String> getBloggersNames() {
		ArrayList<String> UIList = new ArrayList<String>();
		List<org.openqa.selenium.WebElement> BloggerNamesList = getDriver().findElements(By.xpath("//div[@class='blog-author']"));
		for (int i = 1; i <= BloggerNamesList.size(); i++) {
			UIList.add(getDriver().findElement(By.xpath("(//div[@class='blog-author'])["+i+"]")).getText());
		}
		return UIList;
	}
}
