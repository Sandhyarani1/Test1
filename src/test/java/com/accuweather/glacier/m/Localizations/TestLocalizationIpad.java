package com.accuweather.glacier.m.Localizations;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.accuweather.glacier.m.pages.LocalizationsIpad;
import com.accuweather.glacier.www.pages.NavigationBar;
import com.accuweather.glacier.www.AccuWeatherBaseTest;
import com.accuweather.glacier.www.pages.LandingPage;

	public class TestLocalizationIpad extends AccuWeatherBaseTest
	{
		String location = "Mumbai, MH, IN";
		String submenuTitle = "Weather News";
		private String expectedMapsSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
		private String expectedSatelliteSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/in/national/satellite";
		private String expectedSevereSubmenuPage_URL = "https://qualityassurance.accuweather.com/en/br/national/severe-weather-maps";
		private String expectedSatelliteImage_URL = "https://qualityassurance.accuweather.com/en/br/national/satellite";
		private String expectedMapsDescription = "Visualize past, present, and future weather from many angles via both static and interactive maps";
		private String expectedSatelliteDescription = "Satellite maps for visualizing where there is cloud cover and associated precipitation";
		private String expectedSevereDescription = "Currently active global watches and warnings, lightning, and severe weather risk";
		private String expectedSatelliteSubMenuMapTitle = "Brazil Satellite Image";
		private String expectedSatelliteSubMenuMapDescription = "Current satellite image showing cloud coverage";
		
		LocalizationsIpad localization = new LocalizationsIpad();
		LandingPage landingPage = new LandingPage();
		NavigationBar navBar = new NavigationBar() ;
		
		@Test(priority = 1,enabled = false)
		public void TC1_verify_PresenceOfMaps_OnTopNavigation()
		{
			testStart("Validate  whether Maps category is present on top level naviagtion");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			try
			{
				Assert.assertTrue(localization.isMapsPresent());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
			
		} 

		@Test(priority = 2,enabled = false)
		public void TC2_verify_CityForecastPageMap_Categories()
		{
			testStart("Validate maps categories on the city forecast page");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertTrue(localization.isCityForecastMapCategoriesPresent());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
			
		}
		
		@Test(priority = 3,enabled = false)
		public void TC3_verify_MapsSubmenu_Description()
		{
			testStart("Validate Maps submenu description");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertEquals(localization.getMapsSubmenuDescription(), expectedMapsDescription);
			}
			catch (AssertionError ae)
			{
				System.out.println(ae.getMessage());
				Assert.fail("Maps submenu description is not matching");
			}
		}
		
		@Test(priority = 4,enabled = false)
		public void TC4__validation_Of_MapsSubmenu_URL()
		{
			testStart("Validate the URL of Maps submenu page");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			navBar.navigateToRadarAndMapsSubMenu();
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(getDriver().getCurrentUrl(), expectedMapsSubmenuPage_URL);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
	  
		@Test(priority = 5,enabled = false)
		public void TC5_verify_SatelliteSubmenu_Description()
		{
			testStart("Validate Satellite submenu description");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertEquals(localization.getSatelliteSubmenuDescription(), expectedSatelliteDescription);
			}
			catch (AssertionError ae)
			{
				System.out.println(ae.getMessage());
				Assert.fail("Satellite submenu description is not matching");
			}
		}
		
		@Test(priority = 6,enabled = false)
		public void TC6__validation_Of_SatelliteSubmenu_URL()
		{
			testStart("Validate the URL of Satellite submenu page");
			landingPage.enterZipcodeInSearchField(location);
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			navBar.isSatelliteSubMenuDisplayed();
			navBar.navigateToSatellitePage();
			
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteSubmenuPage_URL);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 7,enabled = false)
		public void TC7_verify_PresenceOfSevere_UnderMaps()
		{
			testStart("Verify the Severe submenu is present under Maps");
			landingPage.enterZipcodeInSearchField("Munich, Germany");
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertTrue(navBar.isSeverSubMenuDisplayed());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 8,enabled = false)
		public void TC8_verify_SevereSubmenu_Description()
		{
			testStart("Validate Severe submenu description");
			landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertEquals(localization.getSevereSubmenuDescription(), expectedSevereDescription);
			}
			catch (AssertionError ae)
			{
				System.out.println(ae.getMessage());
				Assert.fail("Satellite submenu description is not matching");
			}
		}
		
		@Test(priority = 9,enabled = false)
		public void TC9__validation_Of_SevereSubmenu_URL()
		{
			testStart("Validate the URL of Severe submenu under Maps");
			landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			navBar.isSeverSubMenuDisplayed();
			navBar.navigateToSeverWeatherPage();
			
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(getDriver().getCurrentUrl(), expectedSevereSubmenuPage_URL);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 10,enabled = false)
		public void TC10__verify_SatelliteSubMenu_Map_Title()
		{
			testStart("Locate Satellite under Maps and verify description below the Maps");
			landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(localization.getSatelliteSubMenuMapTitle(), expectedSatelliteSubMenuMapTitle);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 11,enabled = false)
		public void TC11__verify_SatelliteSubMenu_Map_Description()
		{
			testStart("Locate Satellite under Maps and verify the title of the map");
			landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(localization.getSatelliteSubMenuMapDescription(), expectedSatelliteSubMenuMapDescription);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 12,enabled = false)
		public void TC12__validation_Of_SatelliteImage_URL()
		{
			testStart("Click on the satellite image under Maps and Validate the URL");
			landingPage.enterZipcodeInSearchField("Rio de Janeiro, Brazil");
			landingPage.clickOnZipcodeSearchIcon();
			navBar.hoverOnRadarAndMaps();
			waitUntilElementIsDisplayedOrClickable();
			localization.clickSatelliteImage();
			waitUntilWindowExistsWithTitle(submenuTitle);
			try
			{
				Assert.assertEquals(getDriver().getCurrentUrl(), expectedSatelliteImage_URL);
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 13,enabled = false)
		public void TC13__verfiy_PresenceOf_MinuteCast()
		{
			testStart("Verify the prescence of minutecast on city forecast page");
			landingPage.enterZipcodeInSearchField("Royal oak,Mi,US");
			landingPage.clickOnZipcodeSearchIcon();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertTrue(localization.isMinutecastPresent());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 14,enabled = false)
		public void TC14_change_Temperature_F_To_C()
		{
			testStart("Change the temperature from F to C");
			navBar.clickSettingsIcon();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertTrue(localization.changeTemperatureFromFarenheitToCelcius());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
		@Test(priority = 15,enabled = false)
		public void TC13__verfiy_abcenseOf_MinuteCast()
		{
			testStart("Verify the prescence of minutecast on city forecast page");
			landingPage.enterZipcodeInSearchField("Mumbai, MH, IN");
			landingPage.clickOnZipcodeSearchIcon();
			waitUntilElementIsDisplayedOrClickable();
			try
			{
				Assert.assertFalse(localization.isMinutecastPresent());
			}
			catch(AssertionError ae)
			{
				System.err.println(ae.getMessage());
				Assert.fail();
			}
		}
		
	}


