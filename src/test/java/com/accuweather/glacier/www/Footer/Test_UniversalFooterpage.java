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
	private static final String EXPECTED_URL_FOR_PODCAST="https://qualityassurance.accuweather.com/podcast";
	private static final String EXPECTED_URL_FOR_IPHONE_APP="https://apps.apple.com/US/app/id300048137?mt=8";
	private static final String EXPECTED_URL_FOR_ANDROID_APP="https://play.google.com/store/apps/details?id=com.accuweather.android&referrer=af_tranid";
	private static final String EXPECTED_URL_FOR_WINDOWS_APP="https://downloads.accuweather.com/?shortlink=aba0397&pid=accuweatherDADC&c=Downloads";
	private static final String EXPECTED_URL_FOR_APPS_AND_DOWNLOAD="https://downloads.accuweather.com/?shortlink=aba0397&pid=accuweatherDADC&c=Downloads";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_PREMIUM="https://wwwl.accuweather.com/premium_login.php?url=qualityassurance.accuweather.com/premium";  
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_PROFESSIONAL="https://wwwl.accuweather.com/pro_login.php?url=qualityassurance.accuweather.com/professional";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_DOWNLOAD="https://downloads.accuweather.com/";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_FACEBOOK="https://www.facebook.com/AccuWeather";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TWITTER="https://twitter.com/BreakingWeather";
	private static final String EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TV="https://getaccuweather.tv/?utm_source=adc&utm_medium=icon&utm_campaign=footer";
	private static final String EXPECTED_PRESS_TITLE="Press Room | AccuWeather";
	
	
	  @Test(priority=1,enabled=true)
		public void TC1_validatingBaseFooterDisplayedforEnglish() {
			testStart("Navigating to  test application and validating whether Footer is Displayed for English");	
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			Sleeper.sleep(2);
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.footerisDisplayed());		   		
		}

	  @Test(priority=2,enabled=true)
		public void TC2_validatingBaseFooterhasCompanydisplayed() {
			testStart("Navigating to  test application and validating whether Base Footer has header Company Displayed");	
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			Sleeper.sleep(2);
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_COMPANY));		   		
		}

	  @Test(priority=3,enabled=true)
		public void TC3_validatingBaseFooterhasProductandServicesDisplayed() {
			testStart("Navigating to test application and validating whether Base Footer has header Products & Services Displayed");
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			WebPageLoaded.isDomInteractive();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_PRODUCTS_AND_SERVICES));			   		
		}

	  @Test(priority=4,enabled=true)
		public void TC4_validatingBaseFooterhasAppsandDownloadsDisplayed()  {
			testStart("Navigating to test application and validating whether Base Footer has Apps & Downloads Displayed");	
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			Sleeper.sleep(2);
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_APPS_AND_DOWNLOADS));			   		
		}

	  @Test(priority=5,enabled=true)
		public void TC5_validatingBaseFooterhasSubscriptionServicesDisplayed() {
			testStart("Navigating to test application and validating whether Base Footer has Subscription Services Displayed");
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			Sleeper.sleep(2);
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.isbaseFooterContainsLink(FOOTER_SUBSCRIPTION_SERVICES));			   		
		}

	  @Test(priority=6,enabled=true)
		public void TC6_validatinglinksDisplayedunderCompanyFooter(){
			testStart("Navigating to  test application and validating whether Company Footer has Superior Accuracy in Action link Displayed");	
			waitUntilElementIsDisplayedOrClickable();
			WebPageLoaded.isDomInteractive(800);
			Sleeper.sleep(2);
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			footerpage.scrolldownpage();
			Sleeper.sleep(2);
			Assert.assertTrue(footerpage.validatelinksforCompanyHeader());	
	  }

	  
	 @Test(priority=13,enabled=true)
	    public void TC7_validatingurlwhenclickedonSuperiorAccuracylink(){
		testStart("Navigating to test application and clicking on SuperiorAccuracyinAction");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(SUPERIOR_ACCURACY_ACTION);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals( landingPageURL, EXPECTED_URL_FOR_SUPERIORAACURACY);	    
	}

	@Test(priority=14,enabled=true)
	    public void TC8_validatingurlwhenclickedonAboutAccuweather() {
		testStart("Navigating to test application and clicking on About AccuWeather");
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ABOUT_ACCUWEATHER);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ABOUT_ACCUWEATHER);			    
	}

	@Test(priority=15,enabled=true)
	public void TC9_validatingurlwhenclickedonMediakit() {
		testStart("Navigating to test application and clicking on Media kit");
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(MEDIA_KIT);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_MEDIAKIT);			  		
	}

	@Test(priority=16,enabled=true)
	    public void TC10_validatingurlwhenclickedonCarrers(){
		testStart("Navigating to test application and clicking on Carrers");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(CARRERS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_CARRERS);		 
	}

	@Test(priority=17,enabled=true)
	public void TC11_validatingurlwhenclickedonPress() {
		testStart("Navigating to  test application and clicking on Press");	
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(PRESS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PRESS);		 		
	}

	
	@Test(priority=19,enabled=true)
	public void TC13_validatingurlwhenclickedonContactUs() {
		testStart("Navigating to  test application and clicking on Contact Us");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(CONTACT_US);
		Sleeper.sleep(2);
	    landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_CONTACTUS);					  		
	}

	@Test(priority=20,enabled=true)
	    public void TC14_validatinglinksDisplayedunderProductandServices() {
		testStart("Navigating to  test application and validating links displayed under ProductandServices Header ");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		Sleeper.sleep(2);
		Assert.assertTrue(footerpage.validatelinksforProductsandServicesHeader());
		
  }


	@Test(priority=29,enabled=true)
	    public void TC15_validatingurlwhenclickedonEnterpriseSolutions(){
		testStart("Navigating to  test application and clicking on Enterprise Solutions");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ENTERPRISE_SOLUTIONS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ENTERPRISE_SOLUTIONS);					  		
	}

	@Test(priority=30,enabled=true)
	    public void TC16_validatingurlwhenclickedonD3DataDrivenDecisions() {
		testStart("Navigating to  test application and clicking on D3 Data Driven Decisions");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(D3_DATA_DRIVEN_DECISION);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_D3_DATA_DRIVEN_DECISION);	
	}

	@Test(priority=31,enabled=true)
	    public void TC17_validatingurlwhenclickedonAccuWeatherNetwork(){
		testStart("Navigating to  test application and clicking on AccuWeather Network");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ACCUWEATHER_NETWORK);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_NETWORK);	
	}

	@Test(priority=32,enabled=true)
	    public void TC18_validatingurlwhenclickedonStoryTeller() {
		testStart("Navigating to  test application and clicking on Story Teller");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(STORY_TELLER);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_STORY_TELLER);	
	}

	@Test(priority=33,enabled=true)
	    public void TC19_validatingurlwhenclickedontoolsforbroadcast() {
		testStart("Navigating to  test application and clicking on tools for broadcast");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(TOOLS_BROADCAST);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_BROADCAST);	
	}

	@Test(priority=34,enabled=true)
	    public void TC20_validatingurlwhenclickedonRadioandNewspaper() {
		testStart("Navigating to  test application and clicking on Radio and Newspaper");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(RADIO_AND_NEWSPAPER);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_RADIO);	
	}

	@Test(priority=35,enabled=true)
	    public void TC21_validatingurlwhenclickedonAccuWeatherAPIs() {
		testStart("Navigating to  test application and clicking on AccuWeather APIs");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ACCUWEATHER_APIS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHERAPIS);	
	}

	@Test(priority=36,enabled=true)
	    public void TC23_validatingurlwhenclickedonPodcast() {
		testStart("Navigating to  test application and clicking on Podcast");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(PODCAST);
		landingPageURL=footerpage.getlandingurltitle();
		Sleeper.sleep(2);
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PODCAST);	
	}

	@Test(priority=37,enabled=true)
	    public void TC24_validatinglinksDisplayedunderAppsandDownloads(){
		testStart("Navigating to  test application and validating links Displayed underAppsandDownloads ");
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		Sleeper.sleep(2);
		Assert.assertTrue(footerpage.validatelinksDisplayedunderAppsandDownloads());	
  }
	
	@Test(priority=41,enabled=true)
	    public void TC25_validatingurlwhenclickedoniphoneapp() {
		testStart("Navigating to  test application and clicking on iphone app");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(IPHONEAPP);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_IPHONE_APP);	
	}

	@Test(priority=42,enabled=true)
	    public void TC26_validatingurlwhenclickedonandroidapp()  {
		testStart("Navigating to  test application and clicking on android app");	
		footerpage.scrolldownpage();
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ANDROIDAPP);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		landingPageURL.contains(EXPECTED_URL_FOR_ANDROID_APP);
	}

	
	@Test(priority=44,enabled=true)
	    public void TC28_validatingurlwhenclickedonappsanddownload() {
		testStart("Navigating to  test application and clicking on apps and download");
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(APPS_AND_DOWNLOAD);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_APPS_AND_DOWNLOAD);	
	}

	@Test(priority=45,enabled=true)
		public void TC29_validatingSubscriptionServiceshasAccuWeatherPremiumDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Premium  link Displayed");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		Sleeper.sleep(2);
		Assert.assertTrue(footerpage.subscriptionServicesContainsLink(ACCUWEATHER_PREMIUM));	
  }

	@Test(priority=46,enabled=true)
		public void TC29_validatingSubscriptionServiceshasAccuWeatherProfessionalDisplayed() {
		testStart("Navigating to  test application and validating whether Company Footer has AccuWeather Professional  link Displayed");
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		Sleeper.sleep(2);
		Assert.assertTrue(footerpage.subscriptionServicesContainsLink(ACCUWEATHER_PROFESSIONAL));	
  }

	@Test(priority=47,enabled=true)
		public void TC30_validatingurlwhenclickedonaccuWeatherpremium() {
		testStart("Navigating to  test application and clicking on accuWeather premium");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ACCUWEATHER_PREMIUM);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_PREMIUM);	
	}

	@Test(priority=48,enabled=true)
		public void TC31_validatingurlwhenclickedonaccuWeatherprofessional() {
		testStart("Navigating to  test application and clicking on accuWeather professional");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ACCUWEATHER_PROFESSIONAL);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_PROFESSIONAL);	
	}

	@Test(priority=49,enabled=true)
		public void TC32_validatingSocailmedialinkshasDownloadiconDisplayed()  {
		testStart("Navigating to  test application and validating whether Socail media links has Download icon Displayed");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		Sleeper.sleep(2);
		Assert.assertTrue(footerpage.validateSocailMedialinksDisplayed());
  }


	@Test(priority=53,enabled=true)
		public void TC33_validatingurlwhenclickedoniconDownload()  {
		testStart("Navigating to  test application and clicking on icon download");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ICON_DOWNLOAD);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_DOWNLOAD);	
	}

	@Test(priority=54,enabled=true)
		public void TC34_validatingurlwhenclickedoniconFacebook()  {
		testStart("Navigating to  test application and clicking on icon facebook");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ICON_FACEBOOK);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_FACEBOOK);	
	}

	@Test(priority=55,enabled=true)
		public void TC35_validatingurlwhenclickedoniconTwitter()  {
		testStart("Navigating to  test application and clicking on icon twitter");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ICON_TWITTER);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TWITTER);	
	}

	@Test(priority=56,enabled=true)
		public void TC36_validatingurlwhenclickedoniconTV() {
		testStart("Navigating to  test application and clicking on icon TV");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(ICON_TV);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_ACCUWEATHER_SOCIAL_ICON_TV);	
	}

	@Test(priority=57,enabled=true)
		public void TC37_validatingFootercrumpsdisplayedforotherlanguage() throws InterruptedException {
		testStart("Navigating to test application and verfiying Footer crumps displayed when changed the Language other than English");	
		waitUntilElementIsDisplayedOrClickable();
		WebPageLoaded.isDomInteractive(800);
		Sleeper.sleep(2);
		footerpage.changeLanguagefromSettingsicon();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		WebPageLoaded.isDomInteractive();		
		Assert.assertTrue(footerpage.footerbreadcrumbsDisplayed());
	}

    @Test(priority=17,enabled=true)
	public void TC11_validatePressTitle() {
		testStart("Navigating to  test application and clicking on Press");	
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(PRESS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PRESS);		
		Assert.assertEquals(getDriver().getTitle(), EXPECTED_PRESS_TITLE);
	}
    
    @Test(priority=17,enabled=true)
	public void T464_SecondaryNavigationMenuDisplayedOnPressPage_verifySecondaryNavigationMenus() {
		testStart("Verify secondary navigation menus");	
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.scrolldownpage();
		footerpage.isclickedonfooterlink(PRESS);
		Sleeper.sleep(2);
		landingPageURL=footerpage.getlandingurltitle();
		Assert.assertEquals(landingPageURL,EXPECTED_URL_FOR_PRESS);		
		Assert.assertTrue(footerpage.verifyPressSecondaryNavigationMenus());
	}
}
