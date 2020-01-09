package com.accuweather.glacier.www.Footer;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.accuweather.glacier.www.AccuWeatherBaseTest;

public class TestA extends AccuWeatherBaseTest
{
	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qualitest\\Downloads\\WebDrivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Qualitest\\Downloads\\WebDrivers\\geckodriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extension_3_7_0_0.crx"));
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//options.merge(capabilities);
		driver = new ChromeDriver(options);
		
		driver.get("https://qualityassurance.accuweather.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		try
		{
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		catch(TimeoutException te)
		{
			te.getMessage();
		}
		
		//WebElement el = driver.findElement(By.cssSelector("body > div > div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > span:nth-child(4) > a"));
		WebElement privacyPolicyBanner = driver.findElement(By.cssSelector("div.template-root > div.privacy-policy-banner"));
		Point p = privacyPolicyBanner.getLocation();
		System.out.println("X coordinate------>"+ p.getX());
		System.out.println("Y coordinate------>"+p.getY());
		System.out.println(privacyPolicyBanner.getCssValue("width"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
		js.executeScript("window.scrollBy(0,10000)");
		js.executeScript("window.scrollBy(0,10000)");
		
		WebElement dnd = driver.findElement(By.cssSelector("body > div > div.base-footer.is-en > div.footer-legalese.footer-legalese > div.footer-terms > span > a > span.opt-out"));
		
		System.out.println(dnd.getText());
		//System.out.println(el.getText());
		driver.close();
		
		
	}
}
