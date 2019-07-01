package com.accuweather.glacier.www.Localizations;

import org.testng.annotations.Test;

import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;
import com.accuweather.glacier.www.pages.Localizations;

public class TestLocalization extends AccuWeatherBaseTest
{
	Localizations l = new Localizations();
	LandingPage landingPage = new LandingPage();
	
	@Test
	public void testA()
	{
		testStart("Validate the navigation to Hourly tab");
		landingPage.enterZipcodeInSearchField("Mumbai");
		l.selectOptionWithText("Mumbai, MH, IN");
	}
}
