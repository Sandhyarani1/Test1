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
	
	
	
	/**
	 * @author HFARAZ
	 * Method to get Landing page data from API based on the element passed as a parameter
	 * */
	@SuppressWarnings("unchecked")
	public static ArrayList getLandingPageData(String element)
	{
		@SuppressWarnings("rawtypes")
		ArrayList allElement= new ArrayList();
		JsonPath jsonPathEvaluator = LandingPageAPI.getLandingPageDetails().jsonPath();
		
		@SuppressWarnings("rawtypes")
		HashMap mp = jsonPathEvaluator.get("zones");
		
		@SuppressWarnings("rawtypes")
		ArrayList parsingElement=(ArrayList) mp.get(element);

		for(int i=0; i<parsingElement.size();i++)
		{
			@SuppressWarnings("rawtypes")
			HashMap elements=(HashMap) parsingElement.get(i);
			
			if(!(elements.get("type").toString().contains("video")) )
			{
				@SuppressWarnings("rawtypes")
				ArrayList elementsTitle=(ArrayList) elements.get("elements");
				for(int j=0; j<elementsTitle.size();j++) 
				{
					@SuppressWarnings("rawtypes")
					HashMap getElementTitle= (HashMap) elementsTitle.get(j);
					if(getElementTitle.get("title")==null) 
					{
						allElement.add(getElementTitle.get("description")+"|"+convertToAccuweatherDate(getElementTitle.get("date").toString().substring(0, getElementTitle.get("date").toString().indexOf("T")))+"|"+getElementTitle.get("link"));
					}
					else
					{
						allElement.add(getElementTitle.get("title")+"|"+convertToAccuweatherDate(getElementTitle.get("date").toString().substring(0, getElementTitle.get("date").toString().indexOf("T")))+"|"+getElementTitle.get("category"));
					}
				}
			}
			else
			{
				allElement.add(elements.get("title")+"|"+"https://www.accuweather.com/en/videos/"+elements.get("id"));
			}

		}
		return allElement;
		}
	

	/**
	 * @author HFARAZ
	 * Method to format the date
	 * */
	public static String convertToAccuweatherDate(String date)
	{
		Calendar calendar = Calendar.getInstance(); 
		Date date1=null;
		try 
		{
			date1 = new SimpleDateFormat("yyyy/mm/dd").parse(date.replace("-", "/"));
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		} 
		calendar.setTime(date1);

		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())+" "+calendar.get(Calendar.DAY_OF_MONTH)+" "+calendar.get(Calendar.YEAR);
	}
	
	public static void main(String[] args)
	{
		/**
		 * Example of the usage of the above method
		 */
		ArrayList<String> a = new ArrayList<String>();
		
		/*
		 * System.out.println(getLandingPageData(NAVIGATION_VIDEO));
		 * System.out.println("\n");
		 * System.out.println(getLandingPageData(NAVIGATION_NEWS));
		 * System.out.println("\n");
		 * System.out.println(getLandingPageData(NAVIGATION_SEVERE));
		 * System.out.println("\n");
		 * System.out.println(getLandingPageData(CENTERWELL1));
		 * System.out.println("\n");
		 */
		  System.out.println(getLandingPageData(CENTERWELL2));
		  System.out.println("\n");
		/*
		 * System.out.println(getLandingPageData(RIGHT_RAIL1));
		 * System.out.println("RIGHT RAIL----------------->");
		 * 
		 * for (int i=0;i<getLandingPageData(RIGHT_RAIL1).size();i++) {
		 * System.out.println(splitString(getLandingPageData(RIGHT_RAIL1).get(i).
		 * toString(),3)[i]);
		 * a.add(splitString(getLandingPageData(RIGHT_RAIL1).get(i).toString(),3)[0]); }
		 * System.out.println(a.get(0)); System.out.println(a.get(1));
		 * System.out.println(a.get(2));
		 */
	}
	
	public static String[] getCenterWell1ContentModuleData()
	{
		
		return splitString(getLandingPageData(CENTERWELL1).get(0).toString(),3);
	}
	
	public static String[] getCenterWellVideoTitle()
	{
		return splitString(getLandingPageData(CENTERWELL1).get(1).toString(),3);
	}
	
	public static int getNoOfWeatherNews()
	{
		return getLandingPageData(CENTERWELL2).size();
	}
	
	
	  public static ArrayList<String> getWeatherNewsDate() 
	  {
		  ArrayList<String> weatherNewsDates = new ArrayList<String>();
		  for (int i=0;i<getNoOfWeatherNews();i++)
		  {
			  weatherNewsDates.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(),3)[1]);
		  }
		  return weatherNewsDates;
	  }
	  
	  public static ArrayList<String> getWeatherNewsType() 
	  {
		  ArrayList<String> weatherNewsTypes = new ArrayList<String>();
		  for (int i=0;i<getNoOfWeatherNews();i++)
		  {
			  if (splitString(getLandingPageData(CENTERWELL2).get(i).toString(),3)[2].startsWith("http"))
				  weatherNewsTypes.add("VIDEO");
			  else
				  weatherNewsTypes.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(),3)[2]);
		  }
		  return weatherNewsTypes;
	  }
	  
	  public static ArrayList<String> getWeatherNewsTitles() 
	  {
		  ArrayList<String> weatherNewsTitles = new ArrayList<String>();
		  for (int i=0;i<getNoOfWeatherNews();i++)
		  {
			  weatherNewsTitles.add(splitString(getLandingPageData(CENTERWELL2).get(i).toString(),3)[0]);
		  }
		  return weatherNewsTitles;
	  }
	 
	
	public static ArrayList<String> getRightRailsArticlesTitles()
	{
		ArrayList<String> rightRailArticleTitles = new ArrayList<String>();
		for (int i=0;i<getLandingPageData(RIGHT_RAIL1).size();i++)
		{
			rightRailArticleTitles.add(splitString(getLandingPageData(RIGHT_RAIL1).get(i).toString(),3)[0]);
		}
		
		return rightRailArticleTitles;
	}
	

	/**
	 * @author HFARAZ
	 * Method to split the String
	 * @return 
	 * */
	public static String[] splitString(String str, int i)
	{
		String arr = str;
		String[] spit = arr.split("\\|",i); 
		return spit;
	}
	
	
	}
	
	
	

