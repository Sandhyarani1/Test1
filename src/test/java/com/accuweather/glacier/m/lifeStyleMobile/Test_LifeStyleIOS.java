package com.accuweather.glacier.m.lifeStyleMobile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.CityRadarPageMobile;
import com.accuweather.glacier.m.pages.LandingPageMobile;
import com.accuweather.glacier.m.pages.LifeStyleIOS;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.LifeStylePage;

public class Test_LifeStyleIOS extends AccuWeatherMobileBaseTest {

	private final static String ZIPCODE = "48073";
	private final static String expectedPersonalizedForecastDescription = "Let AccuWeather help you personalize your day-to-day forecasts, to help you better know how to plan your day, and your outdoor activities.";

	private LifeStyleIOS lifeStylePage = new LifeStyleIOS();
	private LandingPageMobile landingPage = new LandingPageMobile();
	private CityRadarPageMobile cityRadar = new CityRadarPageMobile();

	@Test(priority = 1, enabled = true)
	public void RW_T1029_ValidateValidatePersonalizedforecastCTAInThenavigation() {
		testStart("Validate the Personalized forecast CTA in the navigation");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		Assert.assertTrue(lifeStylePage.verifyPersonalizedmenuOptions());
	}

	@Test(priority = 2, enabled = false)
	public void RW_T1030_ValidateValidatePersonalizedforecastCTAInThenavigationClickonForeCast() {
		testStart("Validate the Personalized forecast CTA in the navigation");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		Assert.assertTrue(lifeStylePage.ClickOnForecastPage());

	}

	@Test(priority = 3, enabled = false)
	public void RW_T1030_ValidatetheCategoriesAndSubcategorieUunderPersonalizedForecastAMPlannerPickerValues() {
		testStart("Validate the categories and subcategories under Personalized Forecast for AM planner picker values");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.clickOnAMPlannerOptionMenu();
		Assert.assertTrue(lifeStylePage.AMPlannerPickerValues());

	}

	@Test(priority = 4, enabled = false)
	public void RW_T1030_ValidatetheCategoriesAndSubcategorieUunderPersonalizedForecastHomeAndGardenPickerValues() {
		testStart(
				"Validate the categories and subcategories under Personalized Forecast for Home and garden Picker values");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.clickOnHomeAndGardenOptionMenu();
		Assert.assertTrue(lifeStylePage.HomeAndGardenPickerValues());
	}

	@Test(priority = 5, enabled = false)
	public void RW_T1030_ValidatetheCategoriesAndSubcategorieUunderPersonalizedForecastSportsAndRecreationPickerValues() {
		testStart(
				"Validate the categories and subcategories under Personalized Forecast for sports and recreation Picker values");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.clickOnSportsAndRecreationOptionMenu();
		lifeStylePage.clickOnSportsAndRecreationOptionMenu();
		Assert.assertTrue(lifeStylePage.sportsAndRecreationPickerValues());
	}

	@Test(priority = 6, enabled = false)
	public void RW_T1030_ValidatetheCategoriesAndSubcategorieUunderPersonalizedForecastMiscellaneousPickerValues() {
		testStart(
				"Validate the categories and subcategories under Personalized Forecast for Miscellaneous Picker values");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.clickOnMiscellaneousOptionMenu();
		lifeStylePage.clickOnMiscellaneousOptionMenu();
		Assert.assertTrue(lifeStylePage.miscellaneousPickerValues());
	}

	@Test(priority = 7, enabled = false)
	public void RW_T1031_ValidateTheabilityToAddEditFavoritePersonalizedForecast() {
		testStart("Validate the ability to add/edit favorite Personalized Forecast");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		Assert.assertTrue(lifeStylePage.ClickOnForecastPage());
	}

	@Test(priority = 8, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.check3DayPageShowUpto3Days());
	}

	@Test(priority = 9, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels2() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateDateElementsOfEachPanel());
	}

	@Test(priority = 10, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels3() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateIndexDialOfEachPanel());
	}

	@Test(priority = 11, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels4() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateWeatherDescriptionOfEachPanel());
	}

	@Test(priority = 12, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels5() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateWeatherIconOfEachPanel());
	}

	@Test(priority = 13, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels6() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateHighTempOfEachPanel());
	}

	@Test(priority = 14, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanels7() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.validateLowTempOfEachPanel());
	}

	@Test(priority = 15, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanelsClickForwardArrow() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.clickForwardArrowAndUserIsShownNextThreeDays());
	}

	@Test(priority = 16, enabled = false)
	public void RW_T1032_ValidateTheDataFor3DayIndexPanelsClickBackWardArrow() {
		testStart("Validate the data for 3-day index panels");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		lifeStylePage.ClickOnForecastPage();
		Assert.assertTrue(lifeStylePage.clickBackwardArrowAndUserIsShownPreviousThreeDays());
	}

	@Test(priority = 17, enabled = false)
	public void RW_T1743_VerifyPersonalizedForecastMenuExitWhenUsersClicksOutsideThePersonalizedForecastMenu() {
		testStart("Verify Personalized Forecast menu exit, when users clicks outside the Personalized Forecast menu");
		cityRadar.clickBreadCrumbMenu();
		lifeStylePage.clickOnPersonalizedForecastMenu();
		Assert.assertTrue(cityRadar.clickBreadCrumbMenuRadarAndMaps());

	}

}
