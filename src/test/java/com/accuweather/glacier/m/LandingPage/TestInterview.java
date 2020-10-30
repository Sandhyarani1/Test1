package com.accuweather.glacier.m.LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestInterview 
{
	
	@Test(enabled=false)
	public void interview()
	{
		String S1= "Selense";
		String S2= "";
		  String S3 = "*";
		  int count=0; 
		  
		for(int i=0;i<S1.length();i++)
		  {
		    if(S1.charAt(i)=='e')
		   {
		      S2=S2+S3;
//		      for(int j=0;i<=count;i++)
//			    { 
//			    	S2=S2+S3;
//			    
//			    }
		      count++;
		   }
          
		    
		    else
		   {

		     S2= S2+S1.charAt(i);
		 
		  }                   
		  
		
		  }
	    
	    System.out.println(S2);
	}
	
	
	 @Test()
	 public void launchMyTrip() throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");  
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.makemytrip.com/flights/");
		 Thread.sleep(3);
		 
		 WebElement city =driver.findElement(By.xpath("//p[@data-cy='newsLetterTitle0']/p[1]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView();", city);
		 
		 System.out.println("City is displayed ");
		 
		 
	 }

	
}




