package com.accuweather.glacier;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebPageLoaded;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.selenium.web.elements.WebTextbox;
import com.chameleon.utils.TestReporter;

public class BasePage {
    protected ExtendedWebDriver getDriver() {
        return DriverManager.getWebDriver();
    }

    protected void clickVisibleElement(final By by) {
        WebPageLoaded.isDomInteractive();
        WebElement element = getDriver().findElement(by);
        element.syncVisible(15);
        element.click();
    }

    protected void enterTextVisibleElement(final By by, final String text) {
        WebPageLoaded.isDomInteractive();
        final WebTextbox element = getDriver().findTextbox(by);
        element.syncVisible();
        element.set(text);
        }

	/*
	 * protected void validate(final By by, final String elementName, final Object
	 * expectedText) { final WebElement element = getDriver().findElement(by);
	 * System.out.println("Element In Base Page Class....." +element); final String
	 * elementText = element.getText();
	 * System.out.println("Element Text In Base Page Class....." +elementText);
	 * final boolean found = elementText.contains(expectedText.toString());
	 * System.out.println("Boolean Found In Base Page Class....." +found);
	 * TestReporter.softAssertTrue(found, "Validate element [ " + elementName +
	 * " ] contains text [ " + expectedText + " ]. Found text [ " + elementText +
	 * " ]"); if (!found) { element.highlight(); //
	 * TestReporter.logScreenshot(element, elementName); } }
	 */

    protected String round(Object obj, int roundingPrecision) {
        if (NumberUtils.isCreatable(obj.toString())) {
            BigDecimal bd = new BigDecimal(obj.toString());
            bd = bd.setScale(roundingPrecision, RoundingMode.HALF_UP);
            return bd.toString();
        }
        return obj.toString();
    }
    
    protected String  getCityNameText(String info) {
        String text = info;
        return text;
        }
    
    protected boolean isSubMenuDisplayed(final By by) {
    	return getDriver().findElement(by).isDisplayed();
    }
    
    protected void validate(final By by, final String elementName, final Object expectedText) {
        final WebElement element = getDriver().findElement(by);
        System.out.println("Element In Base Page Class....." +element);
        if(elementName.equals("Current Panel: Temperature")) {
        	 final String Temperature = element.getText().substring(0, 3);
        	 System.out.println("Temperature In Base Page Class....." +Temperature);
        	 final String elementText = Temperature.substring(0, Temperature.length() -1);
        	 System.out.println("elementText In Base Page Class....." +elementText);
        	 final boolean found = elementText.contains(expectedText.toString());
             System.out.println("Boolean Found In Base Page Class....." +found);

             TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
             if (!found) {
                 element.highlight();
                 // TestReporter.logScreenshot(element, elementName);
             }
        } else if (elementName.equals("Current Panel: RealFeel Temperature")) {
        	
        	final String RealFeelTemp = element.getText().substring(10, 13);
        	System.out.println("RealFeelTemp In Base Page Class....." +RealFeelTemp);
        	String elementText = RealFeelTemp.substring(0, RealFeelTemp.length() -1);
        	System.out.println("elementText In Base Page Class....." +elementText);
			final boolean found = elementText.contains(expectedText.toString());
            System.out.println("Boolean Found In Base Page Class....." +found);

            TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
            if (!found) {
                element.highlight();
                // TestReporter.logScreenshot(element, elementName);
            }
        } else if (elementName.equals("Current Panel: Conditions")) {
        	final String elementText = element.getText();
          	 System.out.println("Element Text In Base Page Class....." +elementText);
          	 final boolean found = elementText.contains(expectedText.toString());
               System.out.println("Boolean Found In Base Page Class....." +found);

               TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
               if (!found) {
                   element.highlight();
                   // TestReporter.logScreenshot(element, elementName);
               }
        } else if(elementName.equals("Current Panel: Wind Direction")) {
        	final String elementText = "Winds from the "+ element.getText();
         	 System.out.println("Element Text In Base Page Class....." +elementText);
         	 final boolean found = elementText.contains(expectedText.toString());
              System.out.println("Boolean Found In Base Page Class....." +found);

              TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
              if (!found) {
                  element.highlight();
                  // TestReporter.logScreenshot(element, elementName);
              }
        }else if (elementName.equals("Current Panel: Humidity")) {
        	final String elementText = element.getText().substring(0, 13);
       	 System.out.println("Element Text In Base Page Class....." +elementText);
       	 final boolean found = elementText.contains(expectedText.toString());
            System.out.println("Boolean Found In Base Page Class....." +found);

            TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
            if (!found) {
                element.highlight();
                // TestReporter.logScreenshot(element, elementName);
            }
    } else if(elementName.equals("Current Panel: Pressure")) {
    	final String Pressure = element.getText().substring(0, 15);
      	 System.out.println("Pressure Text In Base Page Class....." +Pressure);
      	final String elementText = round(Pressure,2);
     	 System.out.println("Element Text In Base Page Class....." +elementText);
      	 final boolean found = elementText.contains(expectedText.toString());
           System.out.println("Boolean Found In Base Page Class....." +found);

           TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
           if (!found) {
               element.highlight();
               // TestReporter.logScreenshot(element, elementName);
           }
    }else if(elementName.equals("Current Panel: UV Index")) {
    	final String elementText = element.getText().substring(0, 11);
     	 System.out.println("Element Text In Base Page Class....." +elementText);
     	 final boolean found = elementText.contains(expectedText.toString());
          System.out.println("Boolean Found In Base Page Class....." +found);

          TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
          if (!found) {
              element.highlight();
              // TestReporter.logScreenshot(element, elementName);
          }
    	
    }else if(elementName.equals("Current Panel: Cloud Cover")) {
    	final String elementText = element.getText().substring(0, 16);
    	 System.out.println("Element Text In Base Page Class....." +elementText);
    	 final boolean found = elementText.contains(expectedText.toString());
         System.out.println("Boolean Found In Base Page Class....." +found);

         TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
         if (!found) {
             element.highlight();
             // TestReporter.logScreenshot(element, elementName);
         }
    } else if (elementName.equals("Current Panel: Ceiling")) {
    	final String elementText = element.getText().substring(0, 14);
   	 System.out.println("Element Text In Base Page Class....." +elementText);
   	 final boolean found = elementText.contains(expectedText.toString());
        System.out.println("Boolean Found In Base Page Class....." +found);

        TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
        if (!found) {
            element.highlight();
            // TestReporter.logScreenshot(element, elementName);
        }
    }else if (elementName.equals("Current Panel: Dew Point")) {
    	final String elementText = element.getText().substring(0, 13);
     	 System.out.println("Element Text In Base Page Class....." +elementText);
     	 final boolean found = elementText.contains(expectedText.toString());
          System.out.println("Boolean Found In Base Page Class....." +found);

          TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
          if (!found) {
              element.highlight();
              // TestReporter.logScreenshot(element, elementName);
          }
      } else if (elementName.equals("Current Panel: Visibility")) {
      	final String elementText = element.getText().substring(0, 14);
    	 System.out.println("Element Text In Base Page Class....." +elementText);
    	 final boolean found = elementText.contains(expectedText.toString());
         System.out.println("Boolean Found In Base Page Class....." +found);

         TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
         if (!found) {
             element.highlight();
             // TestReporter.logScreenshot(element, elementName);
         }
     } else if (elementName.equals("Temperature Summmary Panel: Now")) {
    	 
         	 final String TemperatureNow = element.getText().substring(0, 3);
         	 System.out.println("TemperatureNow In Base Page Class....." +TemperatureNow);
         	 final String elementText = TemperatureNow.substring(0, TemperatureNow.length() -1);
         	 System.out.println("elementText In Base Page Class....." +elementText);
         	 final boolean found = elementText.contains(expectedText.toString());
              System.out.println("Boolean Found In Base Page Class....." +found);

              TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
              if (!found) {
                  element.highlight();
                  // TestReporter.logScreenshot(element, elementName);
              }
              
     } else if (elementName.equals("Temperature Summmary Panel: Yesterday")) {
   	 
    	 final String TempYesterday = element.getText().substring(0, 3);
    	 System.out.println("TempYesterday In Base Page Class....." +TempYesterday);
    	 final String elementText = TempYesterday.substring(0, TempYesterday.length() -1);
    	 System.out.println("elementText In Base Page Class....." +elementText);
    	 final boolean found = elementText.contains(expectedText.toString());
         System.out.println("Boolean Found In Base Page Class....." +found);

         TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
         if (!found) {
             element.highlight();
             // TestReporter.logScreenshot(element, elementName);
         }
       } else if (elementName.equals("Temperature Summmary Panel: RealFeel")) {
    	   	 
      	 final String TempRealFeel = element.getText().substring(0, 3);
      	 System.out.println("TempRealFeel In Base Page Class....." +TempRealFeel);
      	 final String elementText = TempRealFeel.substring(0, TempRealFeel.length() -1);
      	 System.out.println("elementText In Base Page Class....." +elementText);
      	 final boolean found = elementText.contains(expectedText.toString());
           System.out.println("Boolean Found In Base Page Class....." +found);

           TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
           if (!found) {
               element.highlight();
               // TestReporter.logScreenshot(element, elementName);
           }
         } else if (elementName.equals("Temperature Summmary Panel: RealFeel Shade")) {
    	   	 
      	 final String TempRealFeelShade = element.getText().substring(0, 3);
      	 System.out.println("TempRealFeelShade In Base Page Class....." +TempRealFeelShade);
      	 final String elementText = TempRealFeelShade.substring(0, TempRealFeelShade.length() -1);
      	 System.out.println("elementText In Base Page Class....." +elementText);
      	 final boolean found = elementText.contains(expectedText.toString());
           System.out.println("Boolean Found In Base Page Class....." +found);

           TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
           if (!found) {
               element.highlight();
               // TestReporter.logScreenshot(element, elementName);
           }
         } else if (elementName.equals("Temperature Summmary Panel: Wind Chill")) {
    	   	 
      	 final String TempWindChill = element.getText().substring(0, 3);
      	 System.out.println("TempWindChill In Base Page Class....." +TempWindChill);
      	 final String elementText = TempWindChill.substring(0, TempWindChill.length() -1);
      	 System.out.println("elementText In Base Page Class....." +elementText);
      	 final boolean found = elementText.contains(expectedText.toString());
           System.out.println("Boolean Found In Base Page Class....." +found);

           TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
           if (!found) {
               element.highlight();
               // TestReporter.logScreenshot(element, elementName);
           }
         } else if (elementName.equals("Temperature Summmary Panel: Dew Point")) {
    	   	 
      	 final String TempDewPoint = element.getText().substring(0, 3);
      	 System.out.println("TempDewPoint In Base Page Class....." +TempDewPoint);
      	 final String elementText = TempDewPoint.substring(0, TempDewPoint.length() -1);
      	 System.out.println("elementText In Base Page Class....." +elementText);
      	 final boolean found = elementText.contains(expectedText.toString());
           System.out.println("Boolean Found In Base Page Class....." +found);

           TestReporter.softAssertTrue(found, "Validate element [ " + elementName + " ] contains text [ " + expectedText + " ]. Found text [ " + elementText + " ]");
           if (!found) {
               element.highlight();
               // TestReporter.logScreenshot(element, elementName);
           }
         }
    }
        
}
