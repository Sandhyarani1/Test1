package com.accuweather.glacier.www.AccuWeatherReady;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.AccuWeatherReady;




public class Test_AccuWeatherReady extends AccuWeatherBaseTest
{
	private AccuWeatherReady awReady = new AccuWeatherReady();
	
	private final static String ACCUWEATHER_READY_URL = "https://qualityassurance.accuweather.com/en/accuweather-ready";
	private final static String ACCUWEATHER_READY_TITLE = "AccuWeather Ready";
	private final static String CHECKLIST_DOWNLOAD = "CHECKLISTS & DOWNLOADS";
	private final static String CHECKLIST1 = "Keep pets safe during winter storms";
	private final static String CHECKLIST2 = "Be prepared for winter holidays";
	private final static String CHECKLIST3 = "Be prepared for winter travel";
	private final static String CHECKLIST4 = "Winter vehicle preparation checklist";
	private final static String CHECKLIST5 = "What to include in your winter weather preparedness kit";
	private final static String CHECKLIST6 = "Winter Dry Skin Preparedness Infographic";
	private final static String CHECKLIST1_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/winter-storms-prepare-your-pets.pdf";
	private final static String CHECKLIST2_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/be-prepared-for-winter-holidays.pdf";
	private final static String CHECKLIST3_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/be-prepared-for-winter-travel.pdf";
	private final static String CHECKLIST4_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/winter-vehicle-preparation-checklist.pdf";
	private final static String CHECKLIST5_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/family-home-preparedness-kit-checklist.pdf";
	private final static String CHECKLIST6_URL = "https://qualityassurance.accuweather.com/pdfs/accuweather-ready/winter-dry-skin-preparedness-infographic.pdf";
	
	@Test(priority=1)
	public void RW_T354_ValidationOfAWReadyURL()
	{
		testStart("Validation of AccuWeather Ready page URL");
		Assert.assertEquals(awReady.getAWReadyPageURL(), ACCUWEATHER_READY_URL);		
	}
	
	@Test(priority=2)
	public void RW_T354_ValidationOfAWReadyPageTitle()
	{
		testStart("Validation of AccuWeather Ready page Title");
		Assert.assertEquals(awReady.getAWReadyPageTitle(), ACCUWEATHER_READY_TITLE);		
	}
	
	@Test(priority=4)
	public void RW_T359_ValidationOfPresenceOfChecklistAndDownloadHeader() 
	{
		testStart("Validation for the presence of Checklist & Downloads Header");
		Assert.assertEquals(awReady.getTextOfChecklistHeader(), CHECKLIST_DOWNLOAD);
	}
	
	@Test(priority=5)
	public void RW_T359_ValidationOfChecklist1()
	{
		testStart("Validation for the presence of Keep pets safe during winter storms");
		Assert.assertEquals(awReady.getTextOfChecklist1(), CHECKLIST1);
		
	}
	
	@Test(priority=6)
	public void RW_T359_ValidationOfChecklist2()
	{
		testStart("Validation for the presence of Be prepared for winter holidays");
		Assert.assertEquals(awReady.getTextOfChecklist2(), CHECKLIST2);
		
	}
	
	@Test(priority=7)
	public void RW_T359_ValidationOfChecklist3()
	{
		testStart("Validation for the presence of Be prepared for winter travel");
		Assert.assertEquals(awReady.getTextOfChecklist3(), CHECKLIST3);
		
	}
	
	@Test(priority=8)
	public void RW_T359_ValidationOfChecklist4()
	{
		testStart("Validation for the presence of Winter vehicle preparation checklist");
		Assert.assertEquals(awReady.getTextOfChecklist4(), CHECKLIST4);
		
	}
	
	@Test(priority=9)
	public void RW_T359_ValidationOfChecklist5()
	{
		testStart("Validation for the presence of What to include in your winter weather preparedness kit");
		Assert.assertEquals(awReady.getTextOfChecklist5(), CHECKLIST5);
		
	}
	
	@Test(priority=10)
	public void RW_T359_ValidationOfChecklist6()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getTextOfChecklist6(), CHECKLIST6);
	}
	
	@Test(priority=11)
	public void RW_T359_ValidationOfChecklist1_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist1(), CHECKLIST1_URL);
	}
	
	@Test(priority=12)
	public void RW_T359_ValidationOfChecklist2_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist2(), CHECKLIST2_URL);
	}
	
	@Test(priority=13)
	public void RW_T359_ValidationOfChecklist3_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist3(), CHECKLIST3_URL);
	}
	
	@Test(priority=14)
	public void RW_T359_ValidationOfChecklist4_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist4(), CHECKLIST4_URL);
	}
	
	@Test(priority=15)
	public void RW_T359_ValidationOfChecklist5_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist5(), CHECKLIST5_URL);
	}
	
	@Test(priority=16)
	public void RW_T359_ValidationOfChecklist6_URL()
	{
		testStart("Validation for the presence of Winter Dry Skin Preparedness Infographic");
		Assert.assertEquals(awReady.getURLOfChecklist6(), CHECKLIST6_URL);
	}
	
	
}
