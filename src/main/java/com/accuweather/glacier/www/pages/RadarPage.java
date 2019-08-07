package com.accuweather.glacier.www.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;


public class RadarPage extends BasePage
{
	 private By byfeaturedSearchbar= By.cssSelector(" div.searchbar.featured-search > div.searchbar-content > form > input"); 
	 private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
	 private By byRadarSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(2) > a > h4");
	 private By bysecondarynavMenus= By.cssSelector("div > div.subnav-items");
	 private By bysecondarRadarTab=By.cssSelector("div.subnav-items > a.subnav-item.active");
	 private By bysecondarymenuRadar=By.cssSelector("div.subnav-items > a.subnav-item.active > h1");
	 private By bysecondarymenuSatellite=By.cssSelector("div.subnav-items > a:nth-child(2) > span");
	 private By bysecondarymenuSevere=By.cssSelector("div.subnav-items > a:nth-child(3) > span");
	 private By bysecondarymenuForecast=By.cssSelector("div.subnav-items > a:nth-child(4) > span");
	  
	 private By byTitleofNationalRadarpage=By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > h2");
	 private By byTooltiponNationalRadarpage=By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-header > div > div.icon-tooltip");
	 private By bytooltipactive=By.cssSelector("div.tooltip-overlay > div.tooltip-header > div");
	 private By bytooltiptextDisplayed =By.cssSelector("div.map-header > div > div.tooltip-overlay > div.tooltip-content");
	 private By byMapboxattribution=By.cssSelector("div.mapboxgl-control-container >div.mapboxgl-ctrl-bottom-left > div:nth-child(2) > a");
	  
	 private By byFullscreenbutton=By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-canvas.full-mobile-width > div.full-screen-button");
	 private By byFullscreeTimelinecontrol=By.cssSelector("div.map-container.full-mobile-width.content-module.full-screen > div.map-tools > div.radar-controls.timeline-container.is-full-screen");
	 private By bylegendonfullscreen=By.cssSelector("div.map-container.full-mobile-width.content-module.full-screen > div.map-tools > div.radar-legend");
	 private By byclosebutton=By.cssSelector("div.map-container.full-mobile-width.content-module.full-screen > div.map-canvas.full-mobile-width > div.close-button");
	  
	 private By byTimelinecontrols=By.cssSelector("div.map-container.full-mobile-width.content-module > div.map-tools > div.radar-controls.timeline-container");
	 private By byPastCTA=By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(2)");
	 private By byFutureCTAdisplayed=By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div:nth-child(3)");
	 private By bySliderwithPlaybutton=By.xpath("//div[@class='play-toggle-button icon-play']");
	 private By byTimestampdisplayed=By.cssSelector("div.map-tools > div.radar-controls.timeline-container > div.timeline-controls > div.time-stamp");
	  
     private By byLegendRain=By.xpath("//div[contains(text(),'Rain')]");
	 private By bylegendSnow=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.label");
	 private By bylegendIce=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.label");
	 private By byLegendMix=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div.label");
	 
	 private By bylegendRainColors=By.xpath("//*[@class='key rain']//*[name()='rect']");
	 private By bylegendSnowColors=By.xpath("//*[@class='key snow']//*[name()='rect']");
	 private By bylegendIceColors=By.xpath("//*[@class='key ice']//*[name()='rect']");
	 private By bylegendMixColors=By.xpath("//*[@class='key mix']//*[name()='rect']");

     private By byRainlegendtextLight=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(1)");
     private By byRainlegendtextSevere=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(1) > div.range-label > span:nth-child(2)");
    
     private By bySnowlegendtextLight=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.range-label > span:nth-child(1)");
     private By bySnowlegendtextSevere=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(2) > div.range-label > span:nth-child(2)");
    
     private By byIceLegendTextLight=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.range-label > span:nth-child(1)");
     private By byIceLegendTextSevere=By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(3) > div.range-label > span:nth-child(2)");
    
     private By byMixLegendTextLight =By.cssSelector(" div.map-tools > div.radar-legend > div:nth-child(4) > div.range-label > span:nth-child(1)");
     private By byMixLegendTextSevere =By.cssSelector("div.map-tools > div.radar-legend > div:nth-child(4) > div.range-label > span:nth-child(2)");

     private By byzoomControls=By.cssSelector("div.mapboxgl-control-container > div.mapboxgl-ctrl-top-left");
     private By byzoomInControl=By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in");
     private By byzoomOutControl=By.cssSelector("div > button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-out");
    
    /** 
     * Method to search city by name 
     * 
     **/ 

    public void searchCityByName(String cityName)
    { 
        WebPageLoaded.isDomInteractive(); 
        WebElement searchBartextfield = getDriver().findElement(byfeaturedSearchbar); 
        searchBartextfield.syncVisible(15); 
        searchBartextfield.hover(); 
        searchBartextfield.sendKeys(cityName); 
        WebDriverWait wait = new WebDriverWait(getDriver(),90);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-results']//*")));
   } 
    
    /** 
     * Method to find auto suggestions  
    * @throws InterruptedException 
     *  
     */ 
    public void selectCityByName() 
    {
        getDriver().findElement(By.cssSelector("div.search-results > div:nth-child(2)")).click();
    } 
    
		/**
		 * @author Sandhya Rani 
		 * Method to hover over top level navigation menus on Homepage 
		 * 
		 **/
	 
    public void mouseHoverOnRadarAndMaps() 
	  {
	   	WebPageLoaded.isDomInteractive();
       WebElement radarandmaps = getDriver().findElement(byRadarMaps);
       radarandmaps.syncVisible(15);
	    radarandmaps.hover();
	    }
    
    
	    /**
		 * @author Sandhya Rani 
		 *  Method to hover over top level navigation menus on Radar Maps  and to select Radar 
		 * 
		 **/
   
	  public void navigateToRadar()
	  {		    
		  
		  WebElement radarsubmenu=  getDriver().findElement(byRadarSubMenu);
		  
	      radarsubmenu.syncVisible(9000);
	      
		  radarsubmenu.jsClick();
     }

	    /**
		 * @author Sandhya Rani 
		 *  Method to Validate Secondary menus are displayed
		 * 
		 **/
 
	  public boolean  Secondarynavigationmenusdisplayed()
	  {
         getDriver().navigate().refresh();
         
		  WebElement secondarymenus=getDriver().findElement(bysecondarynavMenus);
		  
		  return secondarymenus.isDisplayed();	
	  }
	  
	  /**
	    * @author Sandhya Rani 
	    *  Method to Validated Secondary Navigation menus Displayed with following TAbs(Radar , Satellite ,Severe , Forecast)
	    * 
	   **/
	  public boolean isSecondarymenuDisplayed(String link)
	  {
			if (link.equalsIgnoreCase("Radar")) {
				WebPageLoaded.isDomInteractive();
				WebElement radarTab = getDriver().findElement(bysecondarymenuRadar);
				radarTab.syncVisible(6000);
				return radarTab.isDisplayed();
			}
	  
			if (link.equalsIgnoreCase("Satellite")) {
				WebPageLoaded.isDomInteractive();
				WebElement satelliteTab = getDriver().findElement(bysecondarymenuSatellite);
				satelliteTab.syncVisible(6000);
				return satelliteTab.isDisplayed();
			}
			
			if (link.equalsIgnoreCase("SEVERE")) {
				WebPageLoaded.isDomInteractive();
				WebElement severeTab = getDriver().findElement(bysecondarymenuSevere);
				severeTab.syncVisible(6000);
				return severeTab.isDisplayed();
              
			}
			if (link.equalsIgnoreCase("FORECAST")) {
				WebPageLoaded.isDomInteractive();
				WebElement forecastTab = getDriver().findElement(bysecondarymenuForecast);
				forecastTab.syncVisible(6000);
				return forecastTab.isDisplayed();
			}
	  
			return false;
	  }
	  /**
	    * @author Sandhya Rani 
	    *  Method to Validated  Radar Tab Highlighted by Default in orange colour at the border top 
	    * 
	   **/  
	  
	  public String RadartabHighlightedinOrange()
	  {
			getDriver().navigate().refresh();
			
			String radartabTopColour = getDriver().findElement(bysecondarRadarTab).getCssValue("border-top-color");
			
			return Color.fromString(radartabTopColour).asHex();
			
	  }

	  /**
	    * @author Sandhya Rani 
	    *  Method to Validated Title of National Radar Page 
	    * 
	   **/
   public String titleOfRadarMap()
    {
   	  WebPageLoaded.isDomInteractive();
   	  
   	 return getDriver().findElement(byTitleofNationalRadarpage).getText();
    }
   
     /**
	    * @author Sandhya Rani 
	    *  Method to Validated Tool Tip of National Radar Page 
	    * 
	   **/
   
   public boolean tooltipDisplayedonNationalRadarpage()
   {
   	  WebPageLoaded.isDomInteractive();
   	  
   	 return getDriver().findElement(byTooltiponNationalRadarpage).isDisplayed();
   	
   }
   
   public void clickontooltipfromNationalRadarpage()
   {
   	  WebPageLoaded.isDomInteractive();
   	  
      WebElement tooltip=getDriver().findElement(byTooltiponNationalRadarpage);    
   	
	  WebDriverWait wait = new WebDriverWait(getDriver(),80000000);
 	 
	   wait.until(ExpectedConditions.elementToBeClickable(tooltip));
	    
   	   tooltip.syncVisible(90000);
   	   
   	   tooltip.jsClick();
  
   }
    public String colordisplayedwhenclickedonTooltip()
    {
   	    getDriver().findElement(byTooltiponNationalRadarpage).jsClick();  
   	    
   	    String toolTipcolor= getDriver().findElement(bytooltipactive).getCssValue("background-color");
   	    return  Color.fromString(toolTipcolor).asHex();
    }
    
    public String textdisplayedwhenclickedonTooltip()
    {
   	   getDriver().findElement(byTooltiponNationalRadarpage).jsClick();
   	   
   	   return getDriver().findElement(bytooltiptextDisplayed).getText();
   	 
    }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to Validate and Click on Zoom Control buttons displayed at Top left corner of  Radar Map
	    * 
	   **/
     
    public boolean zoomControlsDisplayedonTopLeftCorner()
    {
   	return getDriver().findElement(byzoomControls).isDisplayed();
    }
    
    public void zoominControls()
    { 
        for(int i=0;i<=5;i++) 
        { 
        	WebElement zoomIn= getDriver().findElement(byzoomInControl);
        	
        	 WebDriverWait wait = new WebDriverWait(getDriver(),80000000);
          	 
             wait.until(ExpectedConditions.elementToBeClickable(zoomIn));
             
             zoomIn.jsClick();
             
             wait.until(ExpectedConditions.elementToBeClickable(zoomIn));
             
        } 
    } 

   public void zoomoutControls() 
   { 
        for(int i=0;i<=5;i++) 
        { 
        	WebElement zoomOut= getDriver().findElement(byzoomOutControl);
        	
       	   WebDriverWait wait = new WebDriverWait(getDriver(),80000000);
       	   
       	  wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
       	   
       	   zoomOut.jsClick();
       	  
          wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
           
        } 
        
    } 
         
     /**
	    * @author Sandhya Rani 
	    *  Method to Validate Map Box atrribution of National Radar Page 
	    * 
	   **/
    public boolean MapboxattributionDisplayedBottomLeft()
    {
   	 WebElement mapboxattribution=getDriver().findElement(byMapboxattribution);
   	 mapboxattribution.syncVisible(900);
   	 return mapboxattribution.isDisplayed(); 	 
    }
    
    public void ClickonMapboxattribution()
    {
   	 WebElement mapboxattribution=getDriver().findElement(byMapboxattribution);
   	 mapboxattribution.syncVisible(9000);
   	 mapboxattribution.jsClick(); 	 
    }
    
    
    /**
	    * @author Sandhya Rani 
	    *  Method to get the current url of the landing page in New Tab
	    * 
	   **/
    
    
    public String getlandingurltitle() 
    {
		List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
		WebPageLoaded.isDomComplete(8000000);
		return getDriver().switchTo().window(browserTabs.get(1)).getCurrentUrl();
	}
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Full Screen of National Radar Page 
	    * 
	   **/
    
    public boolean fullScreenbuttonDisplayed()
    {
   	
        return  getDriver().findElement(byFullscreenbutton).isDisplayed();
    }
    
    public int fullScreenbuttonDisplayedatbottomRight()
    {
   	
   	 return getDriver().findElement(byFullscreenbutton).getSize().getHeight(); 	
    }
    
    public void ClikonFullScreenButton()
    {
       WebElement fullscreenbutton= getDriver().findElement(byFullscreenbutton);
       getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
       fullscreenbutton.jsClick();
    }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Time line controls and legends displayed on Full Screen of  Radar Map
	    * 
	   **/
    
    public boolean timelinecontrolsdisplayedonFullscreen()
    {
        return getDriver().findElement(byFullscreeTimelinecontrol).isDisplayed();
    }
    
    
    public boolean legendsdisplayedonFullscreenRadarMap()
    {
        return getDriver().findElement(bylegendonfullscreen).isDisplayed();
    }
    
    public void clickedonClosebuttonfromFullscreenRadarMap()
    {
        getDriver().findElement(byclosebutton).jsClick();
    }
 
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Time line controls,legends,Slider with play button displayed on Radar Map
	    * 
	   **/
    
    
    public boolean timelinecontrolsdisplayedonRadarMap()
    {
        return getDriver().findElement(byTimelinecontrols).isDisplayed();
    }
    
    
    public String PastCTAHighlightedbyDefaultonRadarMap()
    {
         String pastCTA = getDriver().findElement( byPastCTA).getCssValue("background-color");
         return  Color.fromString(pastCTA).asHex();
    }
    
    public String FutureCtaNotHighlightedonRadarMap()
    {
    	
         String pastCTA = getDriver().findElement( byFutureCTAdisplayed).getCssValue("background-color");
         return  Color.fromString(pastCTA).asHex();
    }
    
   
    public void ClickonFutureCTAonRadarMap()
    {
   	   	 
   	    WebElement futureCta=getDriver().findElement( byFutureCTAdisplayed);
   
    	WebDriverWait wait = new WebDriverWait(getDriver(),8000);
   	     
        wait.until(ExpectedConditions.elementToBeClickable(futureCta));
        
         futureCta.jsClick();
       
    }
    
    public void ClickonPastCTAonRadarMap()
    {
   	    WebDriverWait wait = new WebDriverWait(getDriver(),8000);
   	 
       wait.until(ExpectedConditions.elementToBeClickable(byPastCTA));
        
       getDriver().findElement( byPastCTA).jsClick();
        
    }
    
    public boolean SliderwithPlayButtonDisplayed()
    {
    	WebElement playbutton=getDriver().findElement( bySliderwithPlaybutton);
   	
   	    playbutton.syncVisible(900);
   	
   	   return playbutton.isDisplayed();
    }
   

    public void clickonPlayButton()
    {
    	WebElement playbutton= getDriver().findElement(bySliderwithPlaybutton);
    	
       WebDriverWait wait = new WebDriverWait(getDriver(),800);
   	 
      wait.until(ExpectedConditions.elementToBeClickable(playbutton));
        
      playbutton.jsClick();
    }
    
    public String timestampdisplayed()
    {
    	WebElement timestamp= getDriver().findElement(byTimestampdisplayed);
    	
    	WebDriverWait wait = new WebDriverWait(getDriver(),8000);
      	 
        wait.until(ExpectedConditions.elementToBeClickable(timestamp));
    	
   	   return timestamp.getText();
    }
    

     /**
	    * @author Sandhya Rani 
	    *  Method to validate following Legends displayed (Rain,Snow,Ice,Mix) on Radar Map
	    * 
	   **/

    public boolean isLegendDisplayedbelowRadarMap(String link)
	  {
			if (link.equalsIgnoreCase("Rain")) {
				WebPageLoaded.isDomInteractive(3000);
				return getDriver().findElement(byLegendRain).isDisplayed();
			}
	  
			if (link.equalsIgnoreCase("Snow")) {
				WebPageLoaded.isDomInteractive(3000);
				return getDriver().findElement(bylegendSnow).isDisplayed();
			}
			
			if (link.equalsIgnoreCase("Ice")) {
				WebPageLoaded.isDomInteractive(3000);
				return getDriver().findElement(bylegendIce).isDisplayed();
			}
			if (link.equalsIgnoreCase("Mix")) {
				WebPageLoaded.isDomInteractive(3000);
				return getDriver().findElement(byLegendMix).isDisplayed();
			}
	  
			return false;
	  }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Rain Displayed with Text Light and Severe
	    * 
	   **/

    public boolean legendRainTextLightisDisplayed()
    {
       return getDriver().findElement(byRainlegendtextLight).isDisplayed();
   
   }
    public boolean  legenRainTextSevereisDisplayed()
    {
   	 return getDriver().findElement(byRainlegendtextSevere).isDisplayed();
   	
   }
    
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Snow Displayed with Text Light and Severe
	    * 
	   **/
    public boolean legendSnowDisplayedwithTextLight()
    {
   	 return getDriver().findElement(bySnowlegendtextLight).isDisplayed();
    }
    
    public boolean legendSnowDisplayedwithTextSevere()
    {
   	 return getDriver().findElement(bySnowlegendtextSevere).isDisplayed();
    }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Ice Displayed with Text Light and Severe
	    * 
	   **/
  
    public boolean legendICEDisplayedwithTextLight()
    {
   	 return getDriver().findElement(byIceLegendTextLight).isDisplayed();
    }
    
    public boolean legendICEDisplayedwithTextSevere()
    {
   	 return getDriver().findElement(byIceLegendTextSevere).isDisplayed();
    }
    
    /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Mix Displayed with Text Light and Severe
	    * 
	   **/
    public boolean legendMixisplayedwithTextLight()
    {
   	 return  getDriver().findElement(byMixLegendTextLight).isDisplayed();
    }
    
    public boolean legendMixDisplayedwithTextSevere()
    {
   	 return  getDriver().findElement(byMixLegendTextSevere).isDisplayed();
    }
       
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Rain Displayed with various colors
	    * 
	   **/
    
    public void legendRaincoloursdisplayed()
    {
   	 List<WebElement> childrenElements = getDriver().findElements(bylegendRainColors);
    	
    	for (int i=1;i<=childrenElements.size();i++)
    	{
    		WebDriverWait wait = new WebDriverWait(getDriver(),6000);
            wait.until(ExpectedConditions.elementToBeClickable(bylegendRainColors));
    		String raincolour=
            getDriver().findElement(By.xpath("//*[@class='key rain']//*[name()='rect' and @class='c-"+i+"']")).getCssValue("fill");
    		String colorinHex = Color.fromString(raincolour).asHex();
    
    		
    	    ArrayList<String> aList = new ArrayList<>();
    	    aList.add(colorinHex);
    	     for(String list:aList)
    	     {
    				  System.out.println("Legend Rain has following colors displayed "+list);
    				  
    	     }
    	     
    	}

 }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Snow Displayed with various colors
	    * 
	   **/
    
    public void legendSnowcoloursdisplayed()
    {
   	 List<WebElement> childrenElements = getDriver().findElements(bylegendSnowColors);
    	
    	for (int i=1;i<=childrenElements.size();i++)
    	{

    		WebDriverWait wait = new WebDriverWait(getDriver(),60);
            wait.until(ExpectedConditions.elementToBeClickable(bylegendSnowColors));
    		String raincolour=
           getDriver().findElement(By.xpath("//*[@class='key snow']//*[name()='rect' and @class='c-"+i+"']")).getCssValue("fill");
    		String colorinHex = Color.fromString(raincolour).asHex();
    		
    	    List<String> aList = new ArrayList<>();
    	    aList.add(colorinHex);
    	     for(String list:aList)   			 
    	     {
    				  System.out.println("Legend Snow has following colors displayed "+list);
    	     }     	     
    	}
    }
    
     /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Ice Displayed with various colors
	    * 
	   **/    
    public void legendIcecoloursdisplayed()
    {
   	 List<WebElement> childrenElements = getDriver().findElements(bylegendIceColors);
    	
    	for (int i=1;i<=childrenElements.size();i++)
    	{

    		WebDriverWait wait = new WebDriverWait(getDriver(),60);
           wait.until(ExpectedConditions.elementToBeClickable(bylegendIceColors));
    		String raincolour=
           getDriver().findElement(By.xpath("//*[@class='key ice']//*[name()='rect' and @class='c-"+i+"']")).getCssValue("fill");
    		String colorinHex = Color.fromString(raincolour).asHex();
    	 	
    	    List<String> aList = new ArrayList<>();
    	    aList.add(colorinHex);
    	     for(String list:aList)
    			 
    	     {
    				  System.out.println("Legend Ice has following colors displayed "+list);
    	     }
    	}
    
    }
    
    /**
	    * @author Sandhya Rani 
	    *  Method to validate Legend Mix Displayed with various colors
	    * 
	   **/ 
    public void legendMixcoloursdisplayed()
    {
   	 List<WebElement> childrenElements = getDriver().findElements(bylegendMixColors);
    	
    	for (int i=1;i<=childrenElements.size();i++)
    	{
    	   WebDriverWait wait = new WebDriverWait(getDriver(),60);
           wait.until(ExpectedConditions.elementToBeClickable(bylegendMixColors));
    	   String raincolour=
           getDriver().findElement(By.xpath("//*[@class='key mix']//*[name()='rect' and @class='c-"+i+"']")).getCssValue("fill");
    		String colorinHex = Color.fromString(raincolour).asHex();
    	 	
    	    List<String> aList = new ArrayList<>();
    	    aList.add(colorinHex);
    	     for(String list:aList)
    	     {
    				  System.out.println("Legend Mix has following colors displayed "+list);
   
    	     }
    	     
    	}
    
    }     
}

