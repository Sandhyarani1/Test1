package com.accuweather.glacier.www.ContactUs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.ContactUs;

public class Test_ContactUs extends AccuWeatherBaseTest
{
	private ContactUs contactUs = new ContactUs();
	private final static String CONTACT_US = "Contact Us";
	private final static String CONTACT_US_TITLE = "Contact Us - AccuWeather.com";
	private final static String CONTACT_US_URL = "https://qualityassurance.accuweather.com/en/contact";
	private final static String CONTACT_US_TAB_HEADING = "CONTACT US";
	private final static String CONTACT_US_BORDER_COLOR = "#f05514";
	private final static String GENERAL_SUPPORT_BOTTOM_BORDER_COLOR = "#ec5f17";
	private final static String IPHONE_APPS_BOTTOM_BORDER_COLOR = "#1f1f1f";
	private final static String HELP_URL = "https://qualityassurance.accuweather.com/en/help";
	private final static String HELP_TITLE = "Help - AccuWeather.com";
	private final static String PRIVACY_POLICY_URL = "https://qualityassurance.accuweather.com/en/privacy";
	private final static String PRIVACY_POLICY_TITLE = "Privacy Statement & Policy - AccuWeather.com";
	private final static String GENERAL_SUPPORT = "GENERAL SUPPORT";
	private final static String IPHONE_APPS = "IPHONE APPS";
	private final static String comments = "\"Test Message \" this is just to test contact form\r\n" + 
			"My name is Hasan Faraz, Working for Qualitest ,we are testing the contact\r\n" + 
			"us form page on the new Accuweather site for project Glacier .\r\n" + 
			"Please confirm if you receieve this message from the contact form. Please\r\n" + 
			"reply to me and keep CC Lisa Pierre Lois as well.";
	private final static String QUESTION_TYPE = "Access Problems";
	private final static String PRODUCT_TYPE = "AccuWeather.com";
	private final static String EMAIL = "hfaraz@qualitestgroup.com";
	private final static String FIRSTNAME = "HASAN";
	private final static String LASTNAME = "FARAZ";
	private final static String ZIPCODE = "53558";
	private final static String RESPONSE_HEADING = "THANK YOU FOR CONTACTING US!";
	private final static String RESPONSE_MESSAGE = "Thank you for your submission. All comments, suggestions, and bug reports for AccuWeather.com products and services are read. Due to the volume of requests, we cannot guarantee a personal response, however, we will investigate your request.";
	
	
	@Test(priority=1)
	private void RW_T510_ValidatePresenceOfContactUs()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getContactUsText(), CONTACT_US);
	}
	
	@Test(priority=2)
	private void RW_T510_Validate_URL_Of_ContactUs_Page()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getContactUsURL(), CONTACT_US_URL);
	}
	
	@Test(priority=3)
	private void RW_T510_Validate_Title_Of_ContactUs_Page()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getContactUsTitle(), CONTACT_US_TITLE);
	}
	
	@Test(priority=4)
	private void RW_T510_Validate_Heading_Of_ContactUs_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getHeadingOfContactUsTab().toUpperCase(), CONTACT_US_TAB_HEADING);
	}
	
	@Test(priority=5)
	private void RW_T510_Validate_BorderColor_Of_ContactUs_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getTopBorderColor_Of_ContactUsTab(), CONTACT_US_BORDER_COLOR);
	}
	
	@Test(priority=6)
	private void RW_T510_Validate_BorderColor_Of_GeneralSupport_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getBottom_BorderColor_Of_GeneralSupport_Link(), GENERAL_SUPPORT_BOTTOM_BORDER_COLOR);
	}
	
	@Test(priority=7)
	private void RW_T510_Validate_BorderColor_Of_IPhoneApps_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getBottom_BorderColor_Of_IPhoneApps_Link(), IPHONE_APPS_BOTTOM_BORDER_COLOR);
	}
	
	@Test(priority=8)
	private void RW_T510_Validate_Presence_Of_IPhoneApps_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getTextOfIPhoneAppsTab(), IPHONE_APPS);
	}
	
	@Test(priority=9)
	private void RW_T510_Validate_Presence_Of_GeneralSupport_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getTextOfGeneralSupportTab(), GENERAL_SUPPORT);
	}
	
	@Test(priority=10)
	private void RW_T510_Validate_URL_WhenClickedOn_HelpLink_From_GeneralSupport_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getHelpURLWhenClickedFromGeneralSupport(), HELP_URL);
	}
	
	@Test(priority=11)
	private void RW_T510_Validate_URL_WhenClickedOn_ClickHereLink_From_GeneralSupport_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getClickHereURLWhenClickedFromGeneralSupport(), PRIVACY_POLICY_URL);
	}
	
	@Test(priority=12)
	private void RW_T510_Validate_URL_WhenClickedOn_HelpLink_From_IPhoneApps_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getHelpURLWhenClickedFromIPhoneApps(), HELP_URL);
	}
	
	@Test(priority=13)
	private void RW_T510_Validate_URL_WhenClickedOn_ClickHereLink_From_IPhoneApps_Tab()
	{
		testStart("Verifying the presence of Contact Us");
		Assert.assertEquals(contactUs.getClickHereURLWhenClickedFromIPhoneApps(), PRIVACY_POLICY_URL);
	}
	
	/*@Test(priority=14)
	private void RW_T503_Validate_ResponseHeading_WhenSubmitted_From_GeneralSupport()
	{
		testStart("Verifying the Response Heading when submitted a tecnical issue from General Support tab");
		contactUs.switchToContactUs();
		contactUs.selectQuestionType(QUESTION_TYPE);
		contactUs.selectProductType(PRODUCT_TYPE);
		contactUs.writeComments(comments);
		contactUs.enterYourInformation(EMAIL, FIRSTNAME, LASTNAME, ZIPCODE);
		contactUs.clickCaptcha();
		contactUs.clickSubmitButton();
		Assert.assertEquals(contactUs.getResponseHeading(), RESPONSE_HEADING);
		
	}
	
	@Test(priority=15)
	private void RW_T508_Validate_ResponseMessage_WhenSubmitted_From_IPhoneApps()
	{
		testStart("Verifying the Response Message when submitted a technical issue from General Support tab");
		contactUs.switchToContactUs();
		contactUs.click_IPhoneAppsTab();
		contactUs.selectQuestionType(QUESTION_TYPE);
		contactUs.selectProductType(PRODUCT_TYPE);
		contactUs.writeComments(comments);
		contactUs.enterYourInformation(EMAIL, FIRSTNAME, LASTNAME, ZIPCODE);
		contactUs.clickCaptcha();
		contactUs.clickSubmitButton();
		Assert.assertEquals(contactUs.getResponseMessage(), RESPONSE_MESSAGE);
		
	}*/
	
	
	
	
	
}
