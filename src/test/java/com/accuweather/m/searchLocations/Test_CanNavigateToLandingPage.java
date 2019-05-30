package com.accuweather.m.searchLocations;

import org.testng.annotations.Test;

import com.accuweather.glacier.m.AccuWeatherMobileBaseTest;
import com.accuweather.glacier.m.pages.SearchByCityLandingPage;

import io.qameta.allure.Feature;

public class Test_CanNavigateToLandingPage extends AccuWeatherMobileBaseTest {
	private SearchByCityLandingPage searchbycitylandingpage = new SearchByCityLandingPage();
	String searchText = "State College, PA";
	
	 @Feature("Navigation")
	 @Test(groups = { "regression", "navigation" })
	public void testCanNavigateToLandingPage() {
		testStart("CanNavigateToLandingPage");
		searchbycitylandingpage.searchByCityNameAndSubmit(searchText);
		searchbycitylandingpage.clickOnEnteredCityName();
	}

}
