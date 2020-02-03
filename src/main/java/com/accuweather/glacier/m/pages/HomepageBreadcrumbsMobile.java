package com.accuweather.glacier.m.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.utils.Sleeper;

public class HomepageBreadcrumbsMobile extends MobileBasePage {

	private By byfooterbreadcrumbs = By.xpath("//div[@class='breadcrumbs']");
	private By bybreadcrumbforWorld = By.xpath("//div[@class='crumb']//a[@href='/en/world-weather']");
	private By bybreadcrumbsforRegion = By.xpath("//div[@class='crumb']//a[@href='/en/north-america-weather']");
	private By bybreadcrumbsforCountry = By.xpath("//div[@class='crumb']//a[@href='/en/us/united-states-weather']");
	private By bybreadcrumbsforState = By.xpath("//div[@class='crumb']//a[@href='/en/us/pa/pennsylvania-weather']");
	private By bybreadcrumbsforCity = By
			.xpath("//div[@class='crumb']//a[@href='/en/us/state-college/16803/weather-forecast/6789_pc']");

	/**
	 * Method to Scroll down on a page
	 * 
	 * @author Mohammed
	 * @return - void
	 */
	public void scrolldownpage() {
	}

	/**
	 * Method to verify if footer crumb is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if footer crumb is displayed else false"
	 */

	public boolean footercrumb() {
		return getDriver().findElement(byfooterbreadcrumbs).isDisplayed();
	}

	/**
	 * Method to get landing url title
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if landing url title is fetched else false"
	 */

	public String getlandingurltitle() {
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}

	/**
	 * Method to scroll page
	 * 
	 * @author Mohammed
	 * @return - void
	 */

	public void scrollPage() {
		WebPageLoaded.isDomInteractive();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	/**
	 * Method to scroll horizontal
	 * 
	 * @author Mohammed
	 * @return - void
	 */

	public void scrollHorizontal(int x, int y) {
		WebPageLoaded.isDomInteractive();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.mouseMove(x, y);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.mouseWheel(-2);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	/**
	 * Method to verify all the footer crumb displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if footer crumb values are displayed else
	 *         false"
	 */

	public boolean footerbreadcrumbDisplayedfor(String link) throws InterruptedException {
		if (link.equalsIgnoreCase("Footer breadcrumb")) {
			 Sleeper.sleep(10);
		        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			return getDriver().findElements(byfooterbreadcrumbs).size()>0;
		}

		if (link.equalsIgnoreCase("Breadcrumb World")) {
			
			Sleeper.sleep(10);
	        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
	        Sleeper.sleep(10);
			
			
			  Point loc =
			  getDriver().findElement(bybreadcrumbsforState).getLocation();
			  scrollHorizontal(loc.getX(), loc.getY());
			 
			getDriver().findElement(bybreadcrumbforWorld).jsClick();
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb Region")) {
			Sleeper.sleep(10);
	        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
	        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforRegion).jsClick();
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb Country")) {
			 getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforCountry).jsClick();
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb State")) {
			 getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforState).jsClick();
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb City")) {
			 getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforCity).jsClick();
			return true;
		}
		return false;

	}

	/**
	 * Method to move to element
	 * 
	 * @author Mohammed
	 * @return - void
	 */

	private Actions moveToElement(WebElement findElement) {
		return null;
	}

	/**
	 * Method to click footer crumb links
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true footer crumbs links are clicked else false"
	 */
	public void isclickonFooterBreadcrumb(String link) {
		if (link.equalsIgnoreCase("Breadcrumb World")) {
			 Sleeper.sleep(10);
		        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbforWorld).jsClick();
			Sleeper.sleep(10);
		}

		if (link.equalsIgnoreCase("Breadcrumb Region")) {
			 Sleeper.sleep(10);
		        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforRegion).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb Country")) {
			 Sleeper.sleep(10);
		        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforCountry).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb State")) {
			 Sleeper.sleep(10);
		        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		        Sleeper.sleep(10);
		        getDriver().findElement(bybreadcrumbsforState).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb City")) {
			Sleeper.sleep(10);
	        getDriver().executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
	        Sleeper.sleep(10);
			getDriver().findElement(bybreadcrumbsforCity).jsClick();
		}
	}
}
