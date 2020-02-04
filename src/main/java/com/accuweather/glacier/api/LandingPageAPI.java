package com.accuweather.glacier.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import io.restassured.path.json.JsonPath;

public class LandingPageAPI extends APIUtilities
{
	public static final String NAVIGATION_VIDEO = "navigationVideo";
	public static final String NAVIGATION_NEWS = "navigationNews";
	public static final String NAVIGATION_SEVERE = "navigationSevere";
	public static final String CENTERWELL1 = "centerWell1";
	public static final String CENTERWELL2 = "centerWell2";
	public static final String RIGHT_RAIL1 = "rightRail1";
	public static final String RIGHT_RAIL2 = "rightRail2";
	public static String month = "";
	public static String date = "";
	public static String year = "";

	/**
	 * 
	 * @author Apurba Das
	 * 		 Method to get Landing page data from API based on the element passed as a parameter
	 * 
	 */

	@SuppressWarnings("unchecked")
	public static ArrayList getLandingPageData(String element)
	{
		@SuppressWarnings("rawtypes")
		ArrayList allElement = new ArrayList();
		JsonPath jsonPathEvaluator = LandingPageAPI.getLandingPageDetails().jsonPath();

		@SuppressWarnings("rawtypes")
		HashMap mp = jsonPathEvaluator.get("zones");

		@SuppressWarnings("rawtypes")
		ArrayList parsingElement = (ArrayList) mp.get(element);

		for (int i = 0; i < parsingElement.size(); i++)
		{
			@SuppressWarnings("rawtypes")
			HashMap elements = (HashMap) parsingElement.get(i);

			if (!(elements.get("type").toString().contains("video")))
			{
				@SuppressWarnings("rawtypes")
				ArrayList elementsTitle = (ArrayList) elements.get("elements");

				for (int j = 0; j < elementsTitle.size(); j++)
				{
					@SuppressWarnings("rawtypes")
					HashMap getElementTitle = (HashMap) elementsTitle.get(j);
					HashMap image = (HashMap) getElementTitle.get("image");

					if (image == null || image.isEmpty())
					{
						image = (HashMap) getElementTitle.get("promoImage");
					}

					String imageSrc = (String) image.get("src");

					if (getElementTitle.get("title") == null)
					{
						if (element == "navigationVideo") 
						{
							allElement.add(getElementTitle.get("description") + "|" + imageSrc + "|"
									+ getElementTitle.get("duration") + "|" + getElementTitle.get("link"));

						} 
						else
						{
							System.out.println(getElementTitle.get("date").toString());
							allElement.add(getElementTitle.get("description") + "|"
									+ convertToAccuweatherDate(getElementTitle.get("date").toString().substring(0,
											getElementTitle.get("date").toString().indexOf("T")))
									+ "|" + getElementTitle.get("link") + "|" + getElementTitle.get("type") + "|"
									+ imageSrc + "|" + getElementTitle.get("duration"));
						}

					}
					else
					{
						System.out.println(getElementTitle.get("date").toString());
						allElement.add(getElementTitle.get("title") + "|"
								+ convertToAccuweatherDate(getElementTitle.get("date").toString().substring(0,
										getElementTitle.get("date").toString().indexOf("T")))
								+ "|" + getElementTitle.get("link") + "|" + getElementTitle.get("category") + "|"
								+ imageSrc);
					}
				}
			}
			else
			{
				allElement.add(elements.get("title") + "|" + "https://www.accuweather.com/en/videos/"
						+ elements.get("id") + "|" + elements.get("duration"));
			}
		}

		return allElement;
	}

	/** 
	 * @author HFARAZ 
	 * 		   Method to format the date
	 */

	public static String convertToAccuweatherDate(String date)
	{
		Calendar calendar = Calendar.getInstance();
		Date date1 = null;
		try 
		{
			date1 = new SimpleDateFormat("yyyy/mm/dd").parse(date.replace("-", "/"));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		calendar.setTime(date1);
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " "
				+ calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
	}

	/**
	 * Run this main method to see the data returned by API
	 */

	public static void main(String[] args)
	{
		System.out.println("********************* NAVIGATION VIDEO ******************************"
				+ "\n"+
				getLandingPageData(NAVIGATION_VIDEO));
		System.out.println("\n");
		System.out.println("********************* NAVIGATION NEWS ******************************"
				+ "\n"
				+ getLandingPageData(NAVIGATION_NEWS));
		System.out.println("\n");
		System.out.println("********************* NAVIGATION SEVERE ****************************"
				+ "\n"
				+ getLandingPageData(NAVIGATION_SEVERE));
		System.out.println("\n");
		System.out.println("********************* CENTERWELL 1 *********************************"
				+ "\n"
				+ getLandingPageData(CENTERWELL1));
		System.out.println("\n");
		System.out.println("********************* CENTERWELL 2 *********************************"
				+ "\n"
				+ getLandingPageData(CENTERWELL2));
		System.out.println("\n");
		System.out.println("********************* RIGHT RAIL 1 *********************************"
				+ "\n"
				+ getLandingPageData(RIGHT_RAIL1)
				+ "\n");
		System.out.println("********************* RIGHT RAIL 2 *********************************"
				+ "\n"
				+ getLandingPageData(RIGHT_RAIL2));
	}

	/**
	 * @author HFARAZ 
	 * Method to get the values of Content Module Data like title, Weather Category and URL of the video present
	 */

	public static String[] getCenterWell1ContentModuleData()
	{
		return splitString(getLandingPageData(CENTERWELL1).get(0).toString(), 5);
	}

	/**
	 * @author hasanfaraz 
	 * Method to get the date of Content Module Data and format it as per the UI
	 */

	public static String getContentModuleDate()
	{
		month = getAllCharacters(getCenterWell1ContentModuleData()[1]).get(0);
		if(getCenterWell1ContentModuleData()[1].length()==6)
		{
			date = getAllCharacters(getCenterWell1ContentModuleData()[1]).get(1).substring(0, 2);
			year = getAllCharacters(getCenterWell1ContentModuleData()[1]).get(1).substring(2, 6);
		}
		else
		{
			date = getAllCharacters(getCenterWell1ContentModuleData()[1]).get(1).substring(0, 1);
			year = getAllCharacters(getCenterWell1ContentModuleData()[1]).get(1).substring(1, 5);
		}
		String contentModueDate = month.toUpperCase() + " " + date + ", " + year;
		
		return contentModueDate;

	}

	/**
	 * @author HFARAZ
	 * Method to get the title of the video present in Centerwell 1 from the API
	 */

	public static String[] getCenterWellVideoTitle()
	{
		return splitString(getLandingPageData(CENTERWELL1).get(1).toString(), 3);
	}

	/**
	 * @author HFARAZ
	 * Method to get the number of weather news articles from the CMS API
	 */

	public static int getNoOfWeatherNews()
	{
		return getLandingPageData(CENTERWELL2).size();
	}

	/**
	 * @author HFARAZ 
	 * Method to get the dates of all weather news articles present in Centerwell 2 from CMS API
	 */

	public static ArrayList<String> getWeatherNewsDate()
	{
		ArrayList<String> weatherNewsDates = new ArrayList<String>();
		for (int i = 0; i < getNoOfWeatherNews(); i++) 
		{
			try
			{
				month = getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(0)
						.substring(0, 3).toUpperCase();
				
				if(getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(1).length()==5)
				{
					date = getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(1)
							.substring(0, 1);

					year = getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(1)
							.substring(1, 5);
				}
				else
				{
					date = getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(1)
							.substring(0, 2);

					year = getAllCharacters(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[1]).get(1)
							.substring(2, 6);
				}
				

				weatherNewsDates.add(month + ". " + date + ", " + year);

			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
				int j = i + 1;
				System.err.println("Date Not Found In API Response For Weather News " + j + ", Iteration: " + i
						+ "\nException----->\n");
				e.printStackTrace();
			}
		}

		return weatherNewsDates;

	}

	/**
	 * 
	 * @author HFARAZ 
	 * Method to get the category types of all the weather news articles in Centerwell 2 from CMS API
	 */

	public static ArrayList<String> getWeatherNewsType()
	{
		ArrayList<String> weatherNewsTypes = new ArrayList<String>();

		for (int i = 0; i < getNoOfWeatherNews(); i++)
		{
			try
			{
				weatherNewsTypes.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[3]);
			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
				int j = i + 1;
				System.err.println("News Type not found in API response for weather news: " + j + ", Iteration:" + i
						+ "\nException----->\n");
				e.printStackTrace();
			}

		}
		return weatherNewsTypes;

	}

	/**
	 * 
	 * @author HFARAZ Method to get the news titles of all the weather news articles in Centerwell 2 from CMS API
	 * 
	 */

	public static ArrayList<String> getWeatherNewsTitles()
	{
		ArrayList<String> weatherNewsTitles = new ArrayList<String>();

		for (int i = 0; i < getNoOfWeatherNews(); i++)
		{
			try
			{
				weatherNewsTitles.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[0]);
			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
				int j = i + 1;
				System.err.println("News Title Not Found In API Response For Weather News: " + j + ", Iteration: " + i
						+ "\nException--------->\n" + e.getMessage());
			}
		}

		return weatherNewsTitles;
	}

	/**
	 * @author HFARAZ 
	 * Method to get the URL of all the weather news articles in Centerwell 2 from CMS API
	 * 
	 */

	public static ArrayList<String> getWeatherNewsURLs()
	{
		ArrayList<String> weatherNewsURLs = new ArrayList<String>();
		for (int i = 0; i < getNoOfWeatherNews(); i++) 
		{
			try
			{
				weatherNewsURLs.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(), 5)[2]);
			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
				int j = i + 1;
				System.err.println("News URL Not Found in API Response For Weather News " + j + ", Iteration: " + i
						+ "\nException------>\n" + e.getMessage());
			}
		}

		return weatherNewsURLs;

	}
	
	/**
	 * @author HFARAZ
	 * Method to get the number of right rail 1 articles
	 * */
	public static int getNoOfRightRail1Articles()
	{
		return getLandingPageData(RIGHT_RAIL1).size();
	}
	
	/**
	 * @author HFARAZ
	 * Method to get the number of right rail 2 articles
	 * */
	public static int getNoOfRightRail2Articles()
	{
		return getLandingPageData(RIGHT_RAIL2).size();
	}

	/**
	 * 
	 * @author HFARAZ 
	 * Method to get the titles of Right Rail 1 Articles
	 * 
	 * @return array list of right rail articles titles
	 * 
	 */

	public static ArrayList<String> getRightRails1_ArticlesTitles()
	{
		ArrayList<String> rightRailArticleTitles = new ArrayList<String>();

		for (int i = 0; i < getLandingPageData(RIGHT_RAIL1).size(); i++)
		{
			try 
			{
				rightRailArticleTitles.add(splitString(getLandingPageData(RIGHT_RAIL1).get(i).toString(), 3)[0]);
			}
			catch (ArrayIndexOutOfBoundsException e) 
			{
				int j = i + 1;
				System.err.println("Title Not Found In API Response for Right Rail 1, Article " + j + ", Iteration:" + i
						+ ", \nException:---->\n" + e.getMessage());
			}

		}

		return rightRailArticleTitles;
	}

	/**
	 * 
	 * @author HFARAZ 
	 * Method to get the titles of Right Rail 2 Articles
	 * @return array list of right rail articles titles
	 * 
	 */

	public static ArrayList<String> getRightRails2_ArticlesTitles()
	{
		ArrayList<String> rightRailArticleTitles = new ArrayList<String>();

		for (int i = 0; i < getLandingPageData(RIGHT_RAIL2).size(); i++)
		{
			try
			{
				rightRailArticleTitles.add(splitString(getLandingPageData(RIGHT_RAIL2).get(i).toString(), 3)[0]);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				int j = i + 1;
				System.err.println("Title Not Found In API Response for Right Rail 2, Article " + j + ", Iteration:" + i
						+ ", \nException:---->\n" + e.getMessage());
			}

		}

		return rightRailArticleTitles;
	}

	/**
	 * @author HFARAZ 
	 * Method to get the values of Universal Navigation ->News title, date and URL
	 * 
	 */

	public static String[] getUniversalNavigationNewsData()
	{
		return splitString(getLandingPageData(NAVIGATION_NEWS).get(0).toString(), 5);
	}

	/**
	 * @author HFARAZ 
	 * Method to get the values of Universal Navigation ->Video title, date, duration and URL
	 */

	public static String[] getUniversalNavigationVideoData()
	{
		return splitString(getLandingPageData(NAVIGATION_VIDEO).get(0).toString(), 3);
	}

	/**
	 * @author HFARAZ 
	 * Method to get the values of Universal Navigation ->Severe Weather title, date Image SRC and URL
	 */

	public static String[] getUniversalNavigationSevereWeatherData()
	{
		return splitString(getLandingPageData(NAVIGATION_SEVERE).get(0).toString(), 5);
	}

	/**
	 * 
	 * @author HFARAZ 
	 * Method to split the String
	 * @return an array of the values after removing '|' character
	 * 
	 */

	public static String[] splitString(String str, int i)
	{
		String arr = str;
		String[] spit = arr.split("\\|", i);

		return spit;
	}

	/**
	 * 
	 * @author hasanfaraz 
	 * This method will split the String having alphanumeric and special characters
	 * 
	 * @return 
	 * This will return separate strings having alphabets, numbers and special characters and store into global variables declared above
	 */

	static ArrayList<String> getAllCharacters(String str)
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

}