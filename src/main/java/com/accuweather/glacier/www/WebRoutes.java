package com.accuweather.glacier.www;

public class WebRoutes {
    public static final String MAIN = "https://www.accuweather.com/";
    private static final String ROOT = "https://www.accuweather.com";
    public static final String PLACEHOLDER = "/%s";

    public static final String WEATHER_RADAR = ROOT + PLACEHOLDER + PLACEHOLDER + PLACEHOLDER + "/weather-radar";
    public static final String WEATHER_NEWS = ROOT + PLACEHOLDER + "/weather-news";
    public static final String SEVERE_WEATHER = ROOT + PLACEHOLDER + PLACEHOLDER + "/severe-weather";
    public static final String SEARCH_LOCATIONS = ROOT + PLACEHOLDER + "/search-locations";
    public static final String VIDEOS = ROOT + PLACEHOLDER + "/videos";
    public static final String VIDEOS_SITE_NAV = ROOT + PLACEHOLDER + "/videos/?%s";

}
