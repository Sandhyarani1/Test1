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
		WebPageLoaded.isDomInteractive();
	}

	/**
	 * Method to verify if footer crumb is displayed
	 * 
	 * @author Mohammed
	 * @return - Boolean value - "true if footer crumb is displayed else false"
	 */

	public boolean footercrumb() {
		WebPageLoaded.isDomInteractive();
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
		WebPageLoaded.isDomComplete(8000000);
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
			return getDriver().findElement(byfooterbreadcrumbs).isDisplayed();
		}

		if (link.equalsIgnoreCase("Breadcrumb World")) {
			getDriver().findElement(bybreadcrumbsforState).click();
			Point loc = getDriver().findElement(bybreadcrumbsforState).getLocation();
			scrollHorizontal(loc.getX(), loc.getY());
			getDriver().findElement(bybreadcrumbforWorld).click();
			WebPageLoaded.isDomInteractive(5000);
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb Region")) {
			getDriver().findElement(bybreadcrumbsforRegion).click();
			WebPageLoaded.isDomInteractive(5000);
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb Country")) {
			getDriver().findElement(bybreadcrumbsforCountry).click();
			WebPageLoaded.isDomInteractive(5000);
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb State")) {
			getDriver().findElement(bybreadcrumbsforState).click();
			WebPageLoaded.isDomInteractive(5000);
			return true;
		}

		if (link.equalsIgnoreCase("Breadcrumb City")) {
			getDriver().findElement(bybreadcrumbsforCity).click();
			WebPageLoaded.isDomInteractive(5000);
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
			getDriver().findElement(bybreadcrumbforWorld).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb Region")) {
			getDriver().findElement(bybreadcrumbsforRegion).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb Country")) {
			getDriver().findElement(bybreadcrumbsforCountry).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb State")) {
			String currentUrl = getDriver().getCurrentUrl();
			getDriver().navigate().to(currentUrl);
			getDriver().findElement(bybreadcrumbsforState).jsClick();
		}

		if (link.equalsIgnoreCase("Breadcrumb City")) {
			getDriver().findElement(bybreadcrumbsforCity).jsClick();
		}
	}
}
