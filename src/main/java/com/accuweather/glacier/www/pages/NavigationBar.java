package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.selenium.web.elements.WebLink;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.Constants;

public class NavigationBar extends BasePage {
    private By byLogo = By.cssSelector("div > div.main-menu > div.logo-wrapper > a > svg");
    //private By byRadarMaps = By.id("navRadar");
    //private By byRadarMaps = By.xpath("//li[contains(@id,'navRadar')]/a/span");
    private By byRadarMaps = By.cssSelector("div.main-menu > ul > li:nth-child(1)");
    private By byNews = By.cssSelector("div.main-menu > ul > li:nth-child(2)");
    private By byVideo = By.cssSelector("div.main-menu > ul > li:nth-child(3)");
    private By bySevereWeather = By.cssSelector("div.main-menu > ul > li:nth-child(4)");
    private By byMore = By.cssSelector("div.main-menu > ul > li:nth-child(5)");
    private By byStartSearch = By.className("search-input");
    private By bySuperSearch = By.className("super-search-input");
    //private By bySuperSearchCityName = By.xpath("//nav[contains(@class,'header-refresh ')]/div[5]/div/div[1]/ul/li[1]/a[contains(@href,'select-city')]");
    private By bySuperSearchCityName = By.xpath("//body[contains(@id,'home')]/nav/div[5]/div/div[1]/ul/li/a");
    private By byRadarSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(2) > a > h4");
    private By bySevereSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(3) > a > h4");
    private By bySatelliteMapsSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(4) > a > h4");
    private By byForecastMapsSubMenu = By.cssSelector("div.mega-menu > div > div:nth-child(5) > a > h4");
    private By byMainMenuDescriptionLink = By.cssSelector("a > figure > figcaption");
    private By byWeatherNewsSubMenu = By.cssSelector("div > div:nth-child(2) > a > h4");
    private By byPersonalitiesSubMenu = By.cssSelector("div > div:nth-child(3) > a > h4");
    private By byWeatherBlogsSubMenu = By.cssSelector("div:nth-child(4) > a > h4");
    private By byClimateChangeSubMenu = By.cssSelector("div:nth-child(5) > a > h4");
    private By byNewsSubMenu = By.cssSelector("div.mega-menu-item.mega-menu-item-cta.fade-in-left > a:nth-child(1) > h4");
    private By byHurricaneSubMenu = By.cssSelector("div > div:nth-child(2) > a > h4");
    private By byAWReadySubMenu = By.cssSelector("div > div:nth-child(3) > a > h4");
    private By byWinterWeatherSubMenu = By.cssSelector("div > div:nth-child(4) > a > h4");
    private By bySeverWeatherSubMenu = By.cssSelector("div.mega-menu > div > div.mega-menu-item.mega-menu-item-cta.fade-in-left > a > h4");
    private By byVideoSubMenu = By.cssSelector("div.menu-dropdown > div > div:nth-child(1) > div > a:nth-child(1) > h3");
    private By byWatchVideoButton = By.cssSelector("div.menu-dropdown > div > div:nth-child(1) > div > a.orange-button.videos");
    //private By byTrendingNow = By.cssSelector("div.menu-dropdown > div > div:nth-child(2) > div:nth-child(1) > h4 > a");
    private By byTrendingNow = By.cssSelector("div > div:nth-child(2) > a > h4");
    private By byExpertForecasts = By.cssSelector(" div.mega-menu > div > div:nth-child(4) > a > h4");
    private By byStormChasers = By.cssSelector(" div.mega-menu > div > div:nth-child(4) > a > h4");
    //private By byTrendingNow = By.xpath("//body[contains(@id,'home')]//div[5]/div/div[2]/div[1]/h4/a[contains(.,'Trending Now')]");
    //private By byExpertForecasts = By.cssSelector("div.menu-dropdown > div > div:nth-child(2) > div:nth-child(2) > h4 > a");
    //private By byStormChasers = By.cssSelector("div.menu-dropdown > div > div:nth-child(3) > div > h4 > a");
    private By byVideoThumbNail = By.cssSelector("div.menu-dropdown > div > div:nth-child(4) > div > a > img");
    private By byVideoDescriptionLink = By.cssSelector("div.menu-dropdown > div > div:nth-child(4) > div > a > p.thumb-description");
    private By byAppsAndDownloadsSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(1) > a > h4");
    private By byAppsAndDownloadText = By.cssSelector("div > div.mega-menu > div > div:nth-child(1) > p");
    private By byAWPremiumSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(2) > a > h4");
    private By byAWPremiumText = By.cssSelector("div > div.mega-menu > div > div:nth-child(2) > p");
    private By byPodcastSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(5) > a > h4");
    private By byPodcastText = By.cssSelector("div > div.mega-menu > div > div:nth-child(3) > p");
    private By byAWProfessionalSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(4) > a > h4");
    private By byAWProfessionalText = By.cssSelector("div > div.mega-menu > div > div:nth-child(4) > p");
    private By byAboutAWSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(5) > a > h4");
    private By byAboutAWText = By.cssSelector("div > div.mega-menu > div > div:nth-child(5) > p");
    private By byCouponsSubMenu = By.cssSelector("div > div.mega-menu > div > div:nth-child(6) > a > h4");
    private By byCouponsText = By.cssSelector("div > div.mega-menu > div > div:nth-child(6) > p");
    
    
    
    public void navigateToHome() {
        clickVisibleElement(byLogo);
    }

    public void navigateToRadarAndMaps() {
        clickVisibleElement(byRadarMaps);
    }

    public void navigateToNews() {
        clickVisibleElement(byNews);
    }

    public void navigateToVideo() {
        clickVisibleElement(byVideo);
    }

    public void navigateToSevereWeather() {
        clickVisibleElement(bySevereWeather);
    }
    
    public void navigateToForecast() {
    	
        clickVisibleElement(bySuperSearchCityName);
    }
    
    public void navigateToRadar() {
    getDriver().findElement(byRadarSubMenu).click();
    //clickVisibleElement(byRadarSubMenu);
    }
    
    public void navigateToHomePageByLogo() {
        getDriver().findElement(byLogo).click();
        
        }
    
    public void navigateToSeverWeatherPage() {
        getDriver().findElement(bySevereSubMenu).click();
        
        }
    
    public void navigateToSatellitePage() {
        getDriver().findElement(bySatelliteMapsSubMenu).click();
        }
    
    public void navigateToForeCastPage() {
        getDriver().findElement(byForecastMapsSubMenu).click();
        }

    public void locationSearch(String info) {
        WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
        txtSearch.syncEnabled();
        txtSearch.click();
        WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
        txtSuperSearch.syncVisible();
        txtSuperSearch.set(info);
        txtSuperSearch.sendKeys(Keys.RETURN);
    }
    
    public void clickStartSearch() {
    	 WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
		  txtSearch.syncEnabled(); txtSearch.click();
        
    }
    
    public boolean validateNavigation(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Constants.PAGE_TIMEOUT);
        return wait.until(ExpectedConditions.urlContains(url));
    }
    
    public String clickAndGetlocationCityName(String info) {
		
		  WebTextbox txtSearch = getDriver().findTextbox(byStartSearch);
		  txtSearch.syncEnabled(); txtSearch.click();
		 
        WebTextbox txtSuperSearch = getDriver().findTextbox(bySuperSearch);
        txtSuperSearch.syncVisible();
        txtSuperSearch.set(info);
        txtSuperSearch.sendKeys();
        String CityName = getCityNameText(info);
        navigateToForecast();
        return CityName;
    }
    
    public boolean isRadarSubMenuDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement radar = getDriver().findElement(byRadarSubMenu);
        radar.syncVisible(15);
        return radar.isDisplayed();    	   	
    }
    
    
    public boolean isSeverSubMenuDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement Severe = getDriver().findElement(bySevereSubMenu);
        Severe.syncVisible(15);
        return Severe.isDisplayed();       	   	
    }
    
    public boolean isSatelliteMapsSubMenuDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement SatelliteMaps = getDriver().findElement(bySatelliteMapsSubMenu);
        SatelliteMaps.syncVisible(15);
        return SatelliteMaps.isDisplayed();       	   	
    }
    
    public boolean isForecastMapsSubMenuDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement SatelliteMaps = getDriver().findElement(byForecastMapsSubMenu);
        SatelliteMaps.syncVisible(15);
        return SatelliteMaps.isDisplayed();       	   	
    }
    
    
    
    public boolean isDescriptionLinkDisplayed() {
    	WebPageLoaded.isDomInteractive();
        WebElement descriptionLink = getDriver().findElement(byMainMenuDescriptionLink);
        descriptionLink.syncVisible(15);
        return descriptionLink.isDisplayed();       	   	
    }
    
    public void mouseHoverOnAWLogo() {
    	WebPageLoaded.isDomInteractive();
        WebElement radarandmaps = getDriver().findElement(byLogo);
        radarandmaps.syncVisible(15);
        radarandmaps.hover();
       
    }
    
        public void mouseHoverOnRadarAndMaps() {
    	WebPageLoaded.isDomInteractive();
        WebElement radarandmaps = getDriver().findElement(byRadarMaps);
        radarandmaps.syncVisible(15);
        radarandmaps.hover();
       
    }
        
        public void mouseHoverOnDescriptionLink() {
        	WebPageLoaded.isDomInteractive();
            WebElement descriptionLink = getDriver().findElement(byMainMenuDescriptionLink);
            descriptionLink.syncVisible(15);
            descriptionLink.hover();
           
        }
        
        
        public boolean isAWLogoDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awlogo = getDriver().findElement(byLogo);
            awlogo.syncVisible(15);
            return awlogo.isDisplayed();    	   	
        }
        
        
        public boolean isNewsSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement news = getDriver().findElement(byNewsSubMenu);
            news.syncVisible(15);
            return news.isDisplayed();    	   	
        }
        
        
        public boolean isWeatherNewsSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement weatherNews = getDriver().findElement(byWeatherNewsSubMenu);
            weatherNews.syncVisible(15);
            return weatherNews.isDisplayed();       	   	
        }
        
        public boolean isPersonalitiesSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement personalities = getDriver().findElement(byPersonalitiesSubMenu);
            personalities.syncVisible(15);
            return personalities.isDisplayed();       	   	
        }
        
        public boolean isWeatherBlogsSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement weatherblogs = getDriver().findElement(byWeatherBlogsSubMenu);
            weatherblogs.syncVisible(15);
            return weatherblogs.isDisplayed();       	   	
        }
        
        public boolean isClimateChangeSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement climatechange = getDriver().findElement(byClimateChangeSubMenu);
            climatechange.syncVisible(15);
            return climatechange.isDisplayed();       	   	
        }
        
        public void navigateToNewsPage() {
            getDriver().findElement(byWeatherNewsSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
            
            public void navigateToPersonalitiesPage() {
                getDriver().findElement(byPersonalitiesSubMenu).click();
                //clickVisibleElement(byRadarSubMenu);
                }
            
            public void navigateToWeatherBlogPage() {
                getDriver().findElement(byWeatherBlogsSubMenu).click();
                //clickVisibleElement(byRadarSubMenu);
                }
            
            public void navigateToClimateChangePage() {
                getDriver().findElement(byClimateChangeSubMenu).click();
                //clickVisibleElement(byRadarSubMenu);
                }
            
            public void navigateToNewsTab() {
                getDriver().findElement(byNewsSubMenu).click();
                //clickVisibleElement(byRadarSubMenu);
                }
            
            
            
            public void navigateToRadarPageFromDescritionLink() {
                getDriver().findElement(byMainMenuDescriptionLink).click();
                //clickVisibleElement(byRadarSubMenu);
                }
        
        public void mouseHoverOnNews() {
        	WebPageLoaded.isDomInteractive();
            WebElement news = getDriver().findElement(byNews);
            news.syncVisible(15);
            news.hover();
           
        }
        
       
        
        public boolean isHurricaneSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement hurricane = getDriver().findElement(byHurricaneSubMenu);
            hurricane.syncVisible(15);
            return hurricane.isDisplayed();       	   	
        }
        
        public boolean isAWReadySubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awready = getDriver().findElement(byAWReadySubMenu);
            awready.syncVisible(15);
            return awready.isDisplayed();       	   	
        }
        
        public boolean isWinterWeatherSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement winterweather = getDriver().findElement(byWinterWeatherSubMenu);
            winterweather.syncVisible(15);
            return winterweather.isDisplayed();       	   	
        }
               
        
        public boolean isSeverWeatherSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement severweather = getDriver().findElement(bySeverWeatherSubMenu);
            severweather.syncVisible(15);
            return severweather.isDisplayed();       	   	
        }
        
        public void navigateToSevereTab() {
            getDriver().findElement(bySeverWeatherSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void navigateToSevereTabFromSevereWeatherSubMenu() {
            getDriver().findElement(byAWReadySubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void navigateToWinterWeatherTab() {
            getDriver().findElement(byWinterWeatherSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void navigateToHurricaneTab() {
            getDriver().findElement(byHurricaneSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void mouseHoverOnSeverWeather() {
        	WebPageLoaded.isDomInteractive();
            WebElement severeweather = getDriver().findElement(bySevereWeather);
            severeweather.syncVisible(15);
            severeweather.hover();
           
        }
        
        public void mouseHoverOnVideo() {
        	WebPageLoaded.isDomInteractive();
            WebElement video = getDriver().findElement(byVideo);
            video.syncVisible(15);
            video.hover();
           
        }
        
        public void mouseHoverOnVideoDescriptionLink() {
        	WebPageLoaded.isDomInteractive();
            WebElement vidoedescriptionLink = getDriver().findElement(byVideoDescriptionLink);
            vidoedescriptionLink.syncVisible(15);
            vidoedescriptionLink.hover();
            }
        
        public void mouseHoverOnTrendingNowSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement trendingnowsubmenu = getDriver().findElement(byTrendingNow);
            trendingnowsubmenu.syncVisible(15);
            trendingnowsubmenu.hover();
            }
        
        public boolean isVideoSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement videosubmenu = getDriver().findElement(byVideoSubMenu);
            videosubmenu.syncVisible(15);
            return videosubmenu.isDisplayed();    	   	
        }
        
        public boolean isWatchVideoButtonDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement watchvideobtn = getDriver().findElement(byWatchVideoButton);
            watchvideobtn.syncVisible(15);
            return watchvideobtn.isDisplayed();    	   	
        }
        
        public boolean isTrendingNowSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement trendingnow = getDriver().findElement(byTrendingNow);
            trendingnow.syncVisible(15);
            return trendingnow.isDisplayed();    	   	
        }
        
        public boolean isExpertForecastSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement expertforecast = getDriver().findElement(byExpertForecasts);
            expertforecast.syncVisible(15);
            return expertforecast.isDisplayed();    	   	
        }
        
        public boolean isStormChasersSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement stormchasers = getDriver().findElement(byStormChasers);
            stormchasers.syncVisible(15);
            return stormchasers.isDisplayed();    	   	
        }
        
        public boolean isVideoTumbnailDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement videothumnail = getDriver().findElement(byVideoThumbNail);
            videothumnail.syncVisible(15);
            return videothumnail.isDisplayed();    	   	
        }
        
        public boolean isVideoDescriptionLinkDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement videodescriptionlink = getDriver().findElement(byVideoThumbNail);
            videodescriptionlink.syncVisible(15);
            return videodescriptionlink.isDisplayed();    	   	
        }
        
        public void clickVidoeSubMenu() {
            getDriver().findElement(byVideoSubMenu).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        
        public void clickOnVideoMainMenu() {
            getDriver().findElement(byVideo).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void clickWatchVideoButton() {
            getDriver().findElement(byWatchVideoButton).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void clickTrendingNowSubMenu() {
            getDriver().findElement(byTrendingNow).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void clickExpertForecastSubMenu() {
            getDriver().findElement(byExpertForecasts).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void clickStormChasersSubMenu() {
            getDriver().findElement(byStormChasers).click();
            //clickVisibleElement(byRadarSubMenu);
            }
        
        public void clickVideoThumbNail() {
            getDriver().findElement(byVideoThumbNail).click();
                     }
        
        public void clickVideoDescriptionLink() {
            getDriver().findElement(byVideoDescriptionLink).click();
                        }
        
        public void mouseHoverOnMoreMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement more = getDriver().findElement(byMore);
            more.syncVisible(15);
            more.hover();
            }
        
        public void mouseHoverOnPodcastSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement podcast = getDriver().findElement(byPodcastSubMenu);
            podcast.syncVisible(15);
            podcast.hover();
            }
        
        public boolean isPodcastSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement podcast = getDriver().findElement(byPodcastSubMenu);
            podcast.syncVisible(15);
            return podcast.isDisplayed();    	   	
        }
        
        public void clickOnPodcastSubMenu() {
            //getDriver().findElement(byPodcastSubMenu).click();
        	getDriver().findElement(byPodcastSubMenu).jsClick();          
        }
        
        public void mouseHoverOnAWPremiumSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement awpremium = getDriver().findElement(byAWPremiumSubMenu);
            awpremium.syncVisible(15);
            awpremium.hover();
            }
        
        public boolean isAWPremiumSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awpremium = getDriver().findElement(byAWPremiumSubMenu);
            awpremium.syncVisible(15);
            return awpremium.isDisplayed();    	   	
        }
        
        public boolean isAWPremiumTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awpremiumtext = getDriver().findElement(byAWPremiumText);
            awpremiumtext.syncVisible(15);
            return awpremiumtext.isDisplayed();    	   	
        }
        
        public void clickOnAWPremiumSubMenu() {
            getDriver().findElement(byAWPremiumSubMenu).click();                       
        }
        
        public String getAWPremiumText() {
            return getDriver().findElement(byAWPremiumSubMenu).getText();                       
        }
        
        public void mouseHoverOnAWProfessionalSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement awprofessional = getDriver().findElement(byAWProfessionalSubMenu);
            awprofessional.syncVisible(15);
            awprofessional.hover();
            }
        
        public boolean isAWProfessionalSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awprofessional = getDriver().findElement(byAWProfessionalSubMenu);
            awprofessional.syncVisible(15);
            return awprofessional.isDisplayed();    	   	
        }
        
        public boolean isAWProfessionalTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awprofessionaltext = getDriver().findElement(byAWProfessionalText);
            awprofessionaltext.syncVisible(15);
            return awprofessionaltext.isDisplayed();    	   	
        }
        
        public void clickOnAWProfessionalSubMenu() {
            getDriver().findElement(byAWProfessionalSubMenu).click();                       
        }
        
        public String getAWProfessionalText() {
            return getDriver().findElement(byAWProfessionalText).getText();                       
        }
        
        public void mouseHoverOnAWAboutSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement awabout = getDriver().findElement(byAboutAWSubMenu);
            awabout.syncVisible(15);
            awabout.hover();
            }
        
        public boolean isAWAboutSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awabout = getDriver().findElement(byAboutAWSubMenu);
            awabout.syncVisible(15);
            return awabout.isDisplayed();    	   	
        }
        
        public boolean isAWAboutTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awabouttext = getDriver().findElement(byAboutAWText);
            awabouttext.syncVisible(15);
            return awabouttext.isDisplayed();    	   	
        }
        
        public void clickOnAWAboutSubMenu() {
            getDriver().findElement(byAboutAWSubMenu).click();                       
        }
        
        public String getAWAboutText() {
            return getDriver().findElement(byAboutAWText).getText();                       
        }
        
        public void mouseHoverOnCouponsSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement coupons = getDriver().findElement(byCouponsSubMenu);
            coupons.syncVisible(15);
            coupons.hover();
            }
        
        public boolean isCouponsSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement coupons = getDriver().findElement(byCouponsSubMenu);
            coupons.syncVisible(15);
            return coupons.isDisplayed();    	   	
        }
        
        public boolean isCouponsTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement couponstext = getDriver().findElement(byCouponsText);
            couponstext.syncVisible(15);
            return couponstext.isDisplayed();    	   	
        }
        
        public void clickOnCouponsSubMenu() {
            getDriver().findElement(byCouponsSubMenu).click();                       
        }
        
        public String getCouponsText() {
            return getDriver().findElement(byCouponsText).getText();                       
        }
        
        public boolean isPodcastTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement podcasttext = getDriver().findElement(byPodcastText);
            podcasttext.syncVisible(15);
            return podcasttext.isDisplayed();    	   	
        }
        
        public String getPodcastText() {
            return getDriver().findElement(byPodcastText).getText();                       
        }
        
        public void mouseHoverOnApssAppsAndDwnldSubMenu() {
        	WebPageLoaded.isDomInteractive();
            WebElement appdwnldsubmenu = getDriver().findElement(byAppsAndDownloadsSubMenu);
            appdwnldsubmenu.syncVisible(15);
            appdwnldsubmenu.hover();
            }
        
        public boolean isAppAndDwnldSubMenuDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement appdwnldsubmenu = getDriver().findElement(byAppsAndDownloadsSubMenu);
            appdwnldsubmenu.syncVisible(15);
            return appdwnldsubmenu.isDisplayed();    	   	
        }
        
        public boolean isAppAndDwnldTextDisplayed() {
        	WebPageLoaded.isDomInteractive();
            WebElement awpremiumtext = getDriver().findElement(byAppsAndDownloadText);
            awpremiumtext.syncVisible(15);
            return awpremiumtext.isDisplayed();    	   	
        }
        
        public void clickOnAppAndDwnldSubMenu() {
            getDriver().findElement(byAppsAndDownloadsSubMenu).click();                       
        }
        
        public String getAppAndDwnldText() {
            return getDriver().findElement(byAppsAndDownloadsSubMenu).getText();                       
        }
        
        
}
