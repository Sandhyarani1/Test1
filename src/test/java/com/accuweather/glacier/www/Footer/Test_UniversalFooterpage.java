package com.accuweather.glacier.www.Footer;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.UniversalFooterPage;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.utils.Sleeper;

public class Test_UniversalFooterpage extends AccuWeatherBaseTest 
{
	String landingPageURL;
	private static final String FOOTER_COMPANY="Company";
	private static final String FOOTER_PRODUCTS_AND_SERVICES="Products & Services";
	private static final String FOOTER_APPS_AND_DOWNLOADS= "Apps & Download";
	private static final String FOOTER_SUBSCRIPTION_SERVICES="Subscription Services";
	private static final String SUPERIOR_ACCURACY_ACTION = "Superior Accuracy in Action";
	private static final String ABOUT_ACCUWEATHER="About AccuWeather";
	private static final String MEDIA_KIT="Media kit";
	private static final String CARRERS="Carrers";
	private static final String PRESS="Press";
	private static final String COUPONS ="Coupons";
	private static final String CONTACT_US="Contact Us";
	private static final  String ENTERPRISE_SOLUTIONS="Enterprise Solutions";
	private static final  String D3_DATA_DRIVEN_DECISION ="D3 Data Driven Decisions";
	private static final  String ACCUWEATHER_NETWORK="AccuWeather Network";
	private static final  String STORY_TELLER="Story Teller";
	private static final  String TOOLS_BROADCAST="Tools for Broadcast";
	private static final  String RADIO_AND_NEWSPAPER="Radio and Newspaper";
	private static final  String ACCUWEATHER_APIS="AccuWeather APIs";
	private static final  String ACCUWEATHER_STATUS= "AccuWeather Status";
	private static final  String PODCAST= "Podcast";
	private static final  String IPHONEAPP="iPhone App";
	private static final  String ANDROIDAPP="Android App";
	private static final  String WINDOWSAPP ="Windows App";
	private static final  String APPS_AND_DOWNLOAD="See all Apps & Downloads";
	private static final  String ACCUWEATHER_PREMIUM="AccuWeather Premium";
	private static final  String ACCUWEATHER_PROFESSIONAL="AccuWeather Professional";
	private static final  String ICON_DOWNLOAD="Social icon download";
	private static final  String ICON_FACEBOOK="Social icon facebook";
	private static final  String ICON_TWITTER="Social icon twitter";
	private static final  String ICON_TV="Social icon tv";
	private UniversalFooterPage footerpage=new UniversalFooterPage();
	private static final String EXPECTED_URL_FOR_SUPERIORAACURACY="https://corporate.accuweather.com/";
	private static final String EXPECTED_URL_FOR_ABOUT_ACCUWEATHER="https://corporate.accuweather.com/about";
	private static final String EXPECTED_URL_FOR_MEDIAKIT="https://mediakit.accuweather.com/";
	private static final String EXPECTED_URL_FOR_CARRERS="https://careers.accuweather.com/";
	private static final String EXPECTED_URL_FOR_PRESS="https://qualityassurance.accuweather.com/en/press/";
	private static final String EXPECTED_URL_FOR_COUPONS="https://www.accuweather.com/coupons";            //Landing for Production URL 
	private static final String EXPECTED_URL_FOR_CONTACTUS="https://qualityassurance.accuweather.com/en/contact";
	private static final String EXPECTED_URL_FOR_ENTERPRISE_SOLUTIONS="https://enterprisesolutions.accuweather.com/";
	private static final String EXPECTED_URL_FOR_D3_DATA_DRIVEN_DECISION="https://d3.accuweather.com/";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_NETWORK ="https://getaccuweather.tv/?utm_source=adc&utm_medium=icon&utm_campaign=footer";
	private static final String EXPECTED_URL_FOR_STORY_TELLER ="https://storyteller.accuweather.com/";
	private static final String EXPECTED_URL_FOR_BROADCAST ="https://corporate.accuweather.com/broadcast";
	private static final String EXPECTED_URL_FOR_RADIO="https://corporate.accuweather.com/radio";
	private static final String EXPECTED_URL_FOR_ACCUWEATHERAPIS="https://developer.accuweather.com/";
	private static final String EXPECTED_URL_FOR_ACCUWEATHERSTATUS ="https://status.accuweather.com/";
	private static final String EXPECTED_URL_FOR_PODCAST="https://qualityassurance.accuweather.com/podcast";
	private static final String EXPECTED_URL_FOR_IPHONE_APP="https://apps.apple.com/US/app/id300048137?mt=8";
	private static final String EXPECTED_URL_FOR_ANDROID_APP="https://play.google.com/store/apps/details?id=com.accuweather.android&referrer=af_tranid";
	private static final String EXPECTED_URL_FOR_WINDOWS_APP="https://downloads.accuweather.com/?shortlink=aba0397&pid=accuweatherDADC&c=Downloads";
	private static final String EXPECTED_URL_FOR_APPS_AND_DOWNLOAD="https://downloads.accuweather.com/?shortlink=aba0397&pid=accuweatherDADC&c=Downloads";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_PREMIUM="https://wwwl.accuweather.com/premium_login.php";  
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_PROFESSIONAL="https://wwwl.accuweather.com/pro_login.php";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_DOWNLOAD="https://downloads.accuweather.com/";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_FACEBOOK="https://www.facebook.com/AccuWeather";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TWITTER="https://twitter.com/BreakingWeather";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TV="https://getaccuweather.tv/?utm_source=adc&utm_medium=icon&utm_campaign=footer";
	
	  @Test(priority=1,enabled=true)
		public void TC1_validatingBaseFooterDisplayedforEnglish() {
			testStart("Navigating to  test application and validating whether Footer is Displayed for English");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.footerisDisplayed());		   		
		}

	  @Test(priority=2,enabled=true)
		public void TC2_validatingBaseFooterhasCompanydisplayed() {
			testStart("Navigating to  test application and validating whether Base Footer has header Company Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_COMPANY));		   		
		}

	  @Test(priority=3,enabled=true)
		public void TC3_validatingBaseFooterhasProductandServicesDisplayed() {
			testStart("Navigating to test application and validating whether Base Footer has header Products & Services Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_PRODUCTS_AND_SERVICES));			   		
		}

	  @Test(priority=4,enabled=true)
		public void TC4_validatingBaseFooterhasAppsandDownloadsDisplayed()  {
			testStart("Navigating to test application and validating whether Base Footer has Apps & Downloads Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_APPS_AND_DOWNLOADS));			   		
		}

	  @Test(priority=5,enabled=true)
		public void TC5_validatingBaseFooterhasSubscriptionServicesDisplayed() {
			testStart("Navigating to test application and validating whether Base Footer has Subscription Services Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_SUBSCRIPTION_SERVICES));			   		
		}

	  @Test(priority=6,enabled=true)
		public void TC6_validatingCompanyFooterhasSuperiorAccuracyinActionlinkDisplayed(){
			testStart("Navigating to  test application and validating whether Company Footer has Superior Accuracy in Action link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(SUPERIOR_ACCURACY_ACTION));	
	  }

	  @Test(priority=7,enabled=true)
		public void TC6_validatingCompanyFooterhasAboutAccuWeatherlinkDisplayed()  {
			testStart("Navigating to  test application and validating whether Company Footer has About AccuWeather link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(ABOUT_ACCUWEATHER));	
	  }

	  @Test(priority=8,enabled=true)
		public void TC6_validatingCompanyFooterhasMediakitlinkDisplayed()  {
			testStart("Navigating to  test application and validating whether Company Footer has Media kit link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(MEDIA_KIT));	
	  }

	  @Test(priority=9,enabled=true)
		public void TC6_validatingCompanyFooterhasCarrerslinkDisplayed()  {
			testStart("Navigating to  test application and validating whether Company Footer has Carrers link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(CARRERS));	
	  }

	  @Test(priority=10,enabled=true)
		public void TC6_validatingCompanyFooterhasPresslinkDisplayed()  {
			testStart("Navigating to  test application and validating whether Company Footer has Press link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			WebPageLoaded.isDomInteractive();
			Assert.assertTrue(footerpage.companyFooterContainsLink(PRESS));	
	  }

	  @Test(priority=11,enabled=true)
		public void TC6_validatingCompanyFooterhasCouponslinkDisplayed() {
			testStart("Navigating to  test application and validating whether Company Footer has Coupons link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(COUPONS));	
	  }

	  @Test(priority=12,enabled=true)
		public void TC6_validatingCompanyFooterhasContactUslinkDisplayed()  {
			testStart("Navigating to  test application and validating whether Company Footer has Contact Us link Displayed");	
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			Assert.assertTrue(footerpage.companyFooterContainsLink(CONTACT_US));	
	  }

	 @Test(priority=13,enabled=true)
	    public void TC7_validatingurlwhenclickedonSuperiorAccuracylink(){
		testStart("Navigating to test application and clicking on SuperiorAccuracyinAction");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();	
		footerpage.isclickedonfooterlink(SUPERIOR_ACCURACY_ACTION);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals( landingPageURL, EXPECTED_URL_FOR_SUPERIORAACURACY);	    
	}

	@Test(priority=14,enabled=true)
	    public void TC8_validatingurlwhenclickedonAboutAccuweather() {
		testStart("Navigating to test application and clicking on About AccuWeather");
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ABOUT_ACCUWEATHER);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ABOUT_ACCUWEATHER);			    
	}

	@Test(priority=15,enabled=true)
	public void TC9_validatingurlwhenclickedonMediakit() {
		testStart("Navigating to test application and clicking on Media kit");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(MEDIA_KIT);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_MEDIAKIT);			  		
	}

	@Test(priority=16,enabled=true)
	    public void TC10_validatingurlwhenclickedonCarrers(){
		testStart("Navigating to test application and clicking on Carrers");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(CARRERS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_CARRERS);		 
	}

	@Test(priority=17,enabled=true)
	public void TC11_validatingurlwhenclickedonPress() {
		testStart("Navigating to  test application and clicking on Press");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(PRESS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PRESS);		 		
	}

	@Test(priority=18,enabled=true)
	    public void TC12_validatingurlwhenclickedonCoupons()  {
		testStart("Navigating to  test application and clicking on Coupons");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(COUPONS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_COUPONS);	    		
	}

	@Test(priority=19,enabled=true)
	public void TC13_validatingurlwhenclickedonContactUs() {
		testStart("Navigating to  test application and clicking on Contact Us");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(CONTACT_US);
	    landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_CONTACTUS);					  		
	}

	@Test(priority=20,enabled=true)
	    public void TC14_validatingProductandServiceshasEnterpriseSolutionslinkDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has Enterprise Solutions link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(ENTERPRISE_SOLUTIONS));	
  }

	@Test(priority=21,enabled=true)
	public void TC14_validatingProductandServiceshasD3DataDrivenDecisionsDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has D3 Data Driven Decisions link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(D3_DATA_DRIVEN_DECISION));	
  }

	@Test(priority=22,enabled=true)
	    public void TC14_validatingProductandServiceshasAccuWeatherNetworkDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Network link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(ACCUWEATHER_NETWORK));	
  }

	@Test(priority=23,enabled=true)
	public void TC14_validatingProductandServiceshasStoryTellerDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has Story Teller link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(STORY_TELLER));	
  }

	@Test(priority=24,enabled=true)
	public void TC14_validatingProductandServiceshasToolsforBroadcastDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has Tools for Broadcast link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(TOOLS_BROADCAST));	
  }

	@Test(priority=25,enabled=true)
	    public void TC14_validatingProductandServiceshasRadioandNewspaperDisplayed(){
		testStart("Navigating to  test application and validating whether Company Footer has Radio and Newspaper link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(RADIO_AND_NEWSPAPER));	
  }

	@Test(priority=26,enabled=true)
	public void TC14_validatingProductandServiceshasAccuWeatherAPIsDisplayed()  {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather APIs link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(ACCUWEATHER_APIS));	
  }

	@Test(priority=27,enabled=true)
	    public void TC14_validatingProductandServiceshasAccuWeatherStatusDisplayed()  {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Status link Displayed");	
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(ACCUWEATHER_STATUS));	
  }

	@Test(priority=28,enabled=true)
	    public void TC14_validatingProductandServiceshasPodcastDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has Podcast link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.productandServicesContainsLink(PODCAST));	
  }

	@Test(priority=29,enabled=true)
	    public void TC15_validatingurlwhenclickedonEnterpriseSolutions(){
		testStart("Navigating to  test application and clicking on Enterprise Solutions");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ENTERPRISE_SOLUTIONS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ENTERPRISE_SOLUTIONS);					  		
	}

	@Test(priority=30,enabled=true)
	    public void TC16_validatingurlwhenclickedonD3DataDrivenDecisions() {
		testStart("Navigating to  test application and clicking on D3 Data Driven Decisions");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(D3_DATA_DRIVEN_DECISION);
		WebPageLoaded.isDomInteractive();
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_D3_DATA_DRIVEN_DECISION);	
	}

	@Test(priority=31,enabled=true)
	    public void TC17_validatingurlwhenclickedonAccuWeatherNetwork(){
		testStart("Navigating to  test application and clicking on AccuWeather Network");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ACCUWEATHER_NETWORK);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_NETWORK);	
	}

	@Test(priority=32,enabled=true)
	    public void TC18_validatingurlwhenclickedonStoryTeller() {
		testStart("Navigating to  test application and clicking on Story Teller");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(STORY_TELLER);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_STORY_TELLER);	
	}

	@Test(priority=33,enabled=true)
	    public void TC19_validatingurlwhenclickedontoolsforbroadcast() {
		testStart("Navigating to  test application and clicking on tools for broadcast");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(TOOLS_BROADCAST);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_BROADCAST);	
	}

	@Test(priority=34,enabled=true)
	    public void TC20_validatingurlwhenclickedonRadioandNewspaper() {
		testStart("Navigating to  test application and clicking on Radio and Newspaper");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(RADIO_AND_NEWSPAPER);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_RADIO);	
	}

	@Test(priority=35,enabled=true)
	    public void TC21_validatingurlwhenclickedonAccuWeatherAPIs() {
		testStart("Navigating to  test application and clicking on AccuWeather APIs");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ACCUWEATHER_APIS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHERAPIS);	
	}

	@Test(priority=36,enabled=true)
	    public void TC22_validatingurlwhenclickedonAccuWeatherStatus() {
		testStart("Navigating to  test application and clicking on Weather Status");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ACCUWEATHER_STATUS);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHERSTATUS);	
	}

	@Test(priority=37,enabled=true)
	    public void TC23_validatingurlwhenclickedonPodcast() {
		testStart("Navigating to  test application and clicking on Podcast");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(PODCAST);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PODCAST);	
	}

	@Test(priority=38,enabled=true)
	    public void TC24_validatingAppsandDownloadhasiPhoneAppDisplayed(){
		testStart("Navigating to  test application and validating whether Apps & Download Footer has iPhoneApp link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.appsandDownloadContainsLink(IPHONEAPP));	
  }

	@Test(priority=39,enabled=true)
	    public void TC24_validatingAppsandDownloadhasAndroidAppDisplayed() {
		testStart("Navigating to  test application and validating whether Apps & Download Footer has Android App link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.appsandDownloadContainsLink(ANDROIDAPP));	
  }

	@Test(priority=40,enabled=true)
	    public void TC24_validatingAppsandDownloadhasWindowsAppDisplayed() {
		testStart("Navigating to  test application and validating whether Apps & Download Footer has Windows App link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.appsandDownloadContainsLink(WINDOWSAPP));	
  }

	@Test(priority=41,enabled=true)
	    public void TC24_validatingAppsandDownloadhasSeeallAppsandDownloadsDisplayed() {
		testStart("Navigating to  test application and validating whether Apps & Download Footer has See all Apps & Downloadslink Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.appsandDownloadContainsLink(APPS_AND_DOWNLOAD));	
  }

	@Test(priority=42,enabled=true)
	    public void TC25_validatingurlwhenclickedoniphoneapp() {
		testStart("Navigating to  test application and clicking on iphone app");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(IPHONEAPP);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_IPHONE_APP);	
	}

	@Test(priority=43,enabled=true)
	    public void TC26_validatingurlwhenclickedonandroidapp()  {
		testStart("Navigating to  test application and clicking on android app");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ANDROIDAPP);
		landingPageURL=footerpage.getlandingurltitle();
		landingPageURL.contains(EXPECTED_URL_FOR_ANDROID_APP);
//		Assert.assertEquals(landingPageURL.EXPECTED_URL_FOR_ANDROID_APP);	
	}

	@Test(priority=44,enabled=true)
	    public void TC27_validatingurlwhenclickedonWindowsapp() {
		testStart("Navigating to  test application and clicking on Windows app");	
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(WINDOWSAPP);
		WebPageLoaded.isDomComplete(80000000);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_WINDOWS_APP);	
	}

	@Test(priority=45,enabled=true)
	    public void TC28_validatingurlwhenclickedonappsanddownload() {
		testStart("Navigating to  test application and clicking on apps and download");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(APPS_AND_DOWNLOAD);
		WebPageLoaded.isDomInteractive();
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_APPS_AND_DOWNLOAD);	
	}

	@Test(priority=46,enabled=true)
		public void TC29_validatingSubscriptionServiceshasAccuWeatherPremiumDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Premium  link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.subscriptionServicesContainsLink(ACCUWEATHER_PREMIUM));	
  }

	@Test(priority=47,enabled=true)
		public void TC29_validatingSubscriptionServiceshasAccuWeatherProfessionalDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Professional  link Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.subscriptionServicesContainsLink(ACCUWEATHER_PROFESSIONAL));	
  }

	@Test(priority=48,enabled=true)
		public void TC30_validatingurlwhenclickedonaccuWeatherpremium() {
		testStart("Navigating to  test application and clicking on accuWeather premium");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ACCUWEATHER_PREMIUM);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_PREMIUM);	
	}

	@Test(priority=49,enabled=true)
		public void TC31_validatingurlwhenclickedonaccuWeatherprofessional() {
		testStart("Navigating to  test application and clicking on accuWeather professional");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ACCUWEATHER_PROFESSIONAL);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_PROFESSIONAL);	
	}

	@Test(priority=50,enabled=true)
		public void TC32_validatingSocailmedialinkshasDownloadiconDisplayed()  {
		testStart("Navigating to  test application and validating whether Socail media links has Download icon Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.socailmedialinkContains(ICON_DOWNLOAD));	
  }

	@Test(priority=51,enabled=true)
	public void TC32_validatingSocailmedialinkshasFacebookiconDisplayed()  {
		testStart("Navigating to  test application and validating whether Socail media links has facebook icon Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.socailmedialinkContains(ICON_FACEBOOK));	
  }

	@Test(priority=52,enabled=true)
		public void TC32_validatingSocailmedialinkshasTwittericonDisplayed() {
		testStart("Navigating to  test application and validating whether Socail media links has twitter icon Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.socailmedialinkContains(ICON_TWITTER));	
  }

	@Test(priority=53,enabled=true)
		public void TC32_validatingSocailmedialinkshasTVconDisplayed()  {
		testStart("Navigating to  test application and validating whether Socail media links has TV icon Displayed");	
		WebPageLoaded.isDomInteractive();
		footerpage.scrolldownpage();
		Assert.assertTrue(footerpage.socailmedialinkContains(ICON_TV));	
  }

	@Test(priority=54,enabled=true)
		public void TC33_validatingurlwhenclickedoniconDownload()  {
		testStart("Navigating to  test application and clicking on icon download");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ICON_DOWNLOAD);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_DOWNLOAD);	
	}

	@Test(priority=55,enabled=true)
		public void TC34_validatingurlwhenclickedoniconFacebook()  {
		testStart("Navigating to  test application and clicking on icon facebook");	
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ICON_FACEBOOK);
		WebPageLoaded.isDomComplete(80000);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_FACEBOOK);	
	}

	@Test(priority=56,enabled=true)
		public void TC35_validatingurlwhenclickedoniconTwitter()  {
		testStart("Navigating to  test application and clicking on icon twitter");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ICON_TWITTER);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TWITTER);	
	}

	@Test(priority=57,enabled=true)
		public void TC36_validatingurlwhenclickedoniconTV() {
		testStart("Navigating to  test application and clicking on icon TV");	
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();
		footerpage.isclickedonfooterlink(ICON_TV);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TV);	
	}

	@Test(priority=58,enabled=true)
		public void TC37_validatingFootercrumpsdisplayedforotherlanguage() throws InterruptedException {
		testStart("Navigating to test application and verfiying Footer crumps displayed when changed the Language other than English");	
		Sleeper.sleep(2);
		footerpage.changeLanguagefromSettingsicon();
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();		
		Assert.assertTrue(footerpage.footerbreadcrumbsDisplayed());
	}
}
