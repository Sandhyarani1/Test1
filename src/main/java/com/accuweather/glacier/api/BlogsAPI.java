package com.accuweather.glacier.api;

import java.util.ArrayList;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BlogsAPI {
	
	/**
	 * @author Mohammed
	 * Method to fetch the Weather Blogs Post with Category 
	 * @return String value of the JSON response
	 * */
	public static Response getWeatherBlogsResponse()
	{
		return APIUtilities.getWeatherBlogsPostAPIResponse();
		
	}
	
	
	public static ArrayList<String> getBlogsName() {
		String responseString  = getWeatherBlogsResponse().asString();
		JsonPath jsonObject = new JsonPath(responseString);
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> imageType = new ArrayList<String>();
		ArrayList<String> bloggerName = new ArrayList<String>();

		for (int i = 0; i <= 8; i++)
		{
			name.add(jsonObject.getString("[" + i + "].name"));
		}
		
		
		//for (int j = 0; j <= 8; j++) 
		//{
		//	name.add(jsonObject.getString("[" + i + "].image.type"));
		//}
			
		//for (int k = 0; k <= 8; k++) 
		//{
		//	name.add(jsonObject.getString("[" + i + "].blogger.name"));
		//}
		
		
		
		//for (int j = 0; j < name.size(); j++) {
	//		System.out.println(name.get(j));
			/*
			 * System.out.println(imageType.get(i)); System.out.println(bloggerName.get(i));
			 */
			
			
		
		
		return name;
		
		
	}


	public static ArrayList<String> getBlogsImageType() {
		// TODO Auto-generated method stub
		String responseString  = getWeatherBlogsResponse().asString();
		JsonPath jsonObject = new JsonPath(responseString);
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> imageType = new ArrayList<String>();
		ArrayList<String> bloggerName = new ArrayList<String>();

		for (int i = 0; i <= 8; i++)
		{
			imageType.add(jsonObject.getString("[" + i + "].image.type"));
		}
		
		return imageType;
	}

	
	public static ArrayList<String> getBlogsBloggerNames() {
		// TODO Auto-generated method stub
		String responseString  = getWeatherBlogsResponse().asString();
		JsonPath jsonObject = new JsonPath(responseString);
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> imageType = new ArrayList<String>();
		ArrayList<String> bloggerName = new ArrayList<String>();

		for (int i = 0; i <= 8; i++)
		{
			bloggerName.add(jsonObject.getString("[" + i + "].blogger.name"));
		}
		
		return bloggerName;
	}
}
