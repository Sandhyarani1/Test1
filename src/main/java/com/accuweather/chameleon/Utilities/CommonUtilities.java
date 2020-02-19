package com.accuweather.chameleon.Utilities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.web.WebPageLoaded;

public class CommonUtilities
{
	private Calendar calendar = Calendar.getInstance();
	
	protected ExtendedWebDriver getDriver() 
	{
        return DriverManager.getWebDriver();
    }
	
	/**
	 * 
	 * @author hasanfaraz 
	 * This method will split the String having alphanumeric and special characters
	 * 
	 * @return 
	 * This will return an Array list of strings having alphabets, numbers and special characters in different indexes
	 * 0 - alphabets
	 * 1 - numbers
	 * 2 - special characters
	 */

	public static ArrayList<String> getAllCharacters(String str)
	{
		ArrayList<String> allCharacters = new ArrayList<String>();
		StringBuffer alpha = new StringBuffer(), num = new StringBuffer(), special = new StringBuffer();

		for (int i = 0; i < str.length(); i++) 
		{
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
			else if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));
			else
				special.append(str.charAt(i));
		}

		allCharacters.add(alpha.toString());
		allCharacters.add(num.toString());
		allCharacters.add(special.toString());

		return allCharacters;
	}
	
	/**
	 * @author HFARAZ
	 * Method to round the number up to two decimal places
	 * **/
	public static String roundToTwoDecimalPlaces(String value)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(Math.round(Float.valueOf(value))).toString();
	}
	
	/**
	 * @author HFARAZ
	 * Method to round the number up to one decimal places
	 * **/
	public static String roundToOneDecimalPlaces(String value)
	{
		DecimalFormat df = new DecimalFormat("0.0");
		return df.format(Math.round(Float.valueOf(value))).toString();
	}
	
	/**Method to round up/down the decimals
	 * @author SOWMIYA
	 * return roundup number
	 *  */
	public static String roundingUpDecimals(String value)
	{
		float numberToRound = Float.parseFloat(value);
		int roundedFigure =(int)Math.round(numberToRound);
		
		return String.valueOf(roundedFigure);
	}
	
	/**
	 * @author HFARAZ
	 * Method to scroll down to the bottom of the page based on pixels
	 * */
	public void scrollDown(int pixels)
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver().getWebDriver();
		js.executeScript("window.scrollBy(0,"+pixels+")");
		WebPageLoaded.isDomComplete();
	}
	
	/**
	 * @author HFARAZ
	 * Method to switch to a tab and close it
	 * */
	public static void closeExtraTab(WebDriver driver)
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> setOfWindows = driver.getWindowHandles();
		Iterator<String> iterator = setOfWindows.iterator();
		while (iterator.hasNext())
		{
			String childWindow = iterator.next();
			if (!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	/**
	 *  @author HFARAZ
	 *  Method to get current date in the format specified in the parameter
	 * */
	public static String getCurrentDate(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}

	/** @author HFARAZ
	 *         Method to get Tomorrow's Date in a certain format 
	 * */
	public String getTomorrowDate(String format)
	{
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		return new SimpleDateFormat(format).format(tomorrow);
	}
	
	/**
	 *  @author HFARAZ
	 *  Method to get date for the last year in the format specified in the parameter
	 *  E.g If the current date is 2020/02/18, this method will give 2019/02/18
	 * */
	public static String getLastYearDate(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1); // to get previous year add -1
		Date nextYear = cal.getTime();
		return formatter.format(nextYear);
	}
	
	/**
	 *  @author HFARAZ
	 *  Method to get last year value
	 *  E.g if the current year is 2020, this method will return 2019
	 * */
	public static String getLastYear(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1); // to get previous year add -1
		Date previousYear = cal.getTime();
		return formatter.format(previousYear);
	}
	
	
	/**
	 * Use the main method to test any of the methods defined in this class
	 * */
	public static void main(String[] args) 
	{
		System.out.println(getLastYearDate("yyyy/MM/dd"));
		System.out.println(getLastYear("yyyy"));
		System.out.println(getCurrentDate("MMMM dd"));
	}
}
