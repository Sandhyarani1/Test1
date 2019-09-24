package com.accuweather.glacier.www.lifeStyle;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LifeStylePage;

public class Test_LifeStyle extends AccuWeatherBaseTest
{
	private final static String ZIPCODE = "48073";
	private final static String expectedPersonalizedForecastDescription = "Let AccuWeather help you personalize your day-to-day forecasts, to help you better know how to plan your day, and your outdoor activities.";
	
	private LifeStylePage lifeStylePage = new LifeStylePage();
	private LandingPage landingPage = new LandingPage();
	
//	@Test(priority=1)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_clickOnAllergyPersonalizedForecastMenu()
//	{
//		testStart("Verfiy Today, Tomorrow and Day after tomorrow days should appear on the 3-day page");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.check3DayPageShowUpto3Days());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateDayElementsOfEachPanel()
//	{
//		testStart("Validate elements of each panel like day, date, index dial, weather description, weather icon, high temp, low temp");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.check3DayPageShowUpto3Days());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateDateElementsOfEachPanel()
//	{
//		testStart("Validate elements of each panel date");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateDateElementsOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateIndexDialOfEachPanel()
//	{
//		testStart("Validate index dial of each panel");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateIndexDialOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateWeatherDescriptionOfEachPanel()
//	{
//		testStart("Validate weather description  of each panel");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateWeatherDescriptionOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateWeatherIconOfEachPanel()
//	{
//		testStart("Validate weather icon of each panel");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateWeatherIconOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateHighTempOfEachPanel()
//	{
//		testStart("Validate high temp of each panel");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateHighTempOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_validateLowTempOfEachPanel()
//	{
//		testStart("Validate low temp of each panel");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.validateLowTempOfEachPanel());
//	}
//	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_clickForwardArrowAndUserIsShownNextThreeDays()
//	{
//		testStart("Click forward arrow and verify the user is shown three days");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.clickForwardArrowAndUserIsShownNextThreeDays());
//	}
	
//	@Test(priority=2)
//	public void RW_T370_ValidateDataFor3DayIndexPanels_clickBackwardArrowAndUserIsShownPreviousThreeDays()
//	{
//		testStart("Click backward arrow and verify the user is shown previous three days");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		lifeStylePage.clickOnAllergyPersonalizedForecastMenu();
//		Assert.assertTrue(lifeStylePage.clickForwardArrowAndUserIsShownNextThreeDays());
//	}
	
//	@Test(priority=1)
//	public void RW_T365_ValidateCategoriesAndSubCategoriesUnderPersonalizedForecastMenu_validateDescriptionForPersonalizedForecast()
//	{
//		testStart("Validate the description for personalized forecast in the expanded menu");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//		String actualPersonalizedForecastDescription = lifeStylePage.validateDescriptionForPersonalizedForecast();
//		try
//		{
//			Assert.assertEquals(actualPersonalizedForecastDescription, expectedPersonalizedForecastDescription);
//		}
//
//		catch (AssertionError ae)
//		{
//			System.out.println(ae.getMessage());
//			Assert.fail("Personalized forecast description is not matching");
//		}
//	}
//	
//	@Test(priority=1)
//	public void RW_T365_ValidateCategoriesAndSubCategoriesUnderPersonalizedForecastMenu_verifyEditIconAppearInExpandedMenu()
//	{
//		testStart("Validate edit icon appear in the expanded menu");
//		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
//	    Assert.assertTrue(lifeStylePage.verifyEditIconAppearInExpandedMenu());
//	}	
//	
	@Test(priority=1)
	public void RW_T365_ValidateCategoriesAndSubCategoriesUnderPersonalizedForecastMenu_verifyPersonalizedForecastMenu()
	{
		testStart("Validate the Categories under Personalized Forecast Menu");
		landingPage.enterZipcodeInSearchFieldAndClick(ZIPCODE);
	    Assert.assertTrue(lifeStylePage.verifyPersonalizedForecastCategories());
	    
	}	
}
