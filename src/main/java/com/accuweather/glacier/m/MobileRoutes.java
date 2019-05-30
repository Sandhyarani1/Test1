package com.accuweather.glacier.m;

public class MobileRoutes {
    public static final String MAIN = "https://m.accuweather.com";
    public static final String PLACEHOLDER = "/%s";

    public static final String SEARCH_LOCATIONS = MAIN + "/search-locations";
    public static final String BROWSE_LOCATIONS = MAIN + PLACEHOLDER + "/browse-locations";

    public static final String WORLD_WEATHER = MAIN + PLACEHOLDER + "/world-weather";
    public static final String AFRICA_WEATHER = MAIN + PLACEHOLDER + "/africa-weather";
    public static final String ANTARCTICA_WEATHER = MAIN + PLACEHOLDER + "/antarctica-weather";
    public static final String ARCTIC_WEATHER = MAIN + PLACEHOLDER + "/arctic-weather";
    public static final String ASIA_WEATHER = MAIN + PLACEHOLDER + "/asia-weather";
    public static final String CENTRAL_AMERICA_WEATHER = MAIN + PLACEHOLDER + "/central-america-weather";
    public static final String EUROPE_WEATHER = MAIN + PLACEHOLDER + "/europe-weather";
    public static final String MIDDLE_EAST_WEATHER = MAIN + PLACEHOLDER + "/middle-east-weather";
    public static final String NORTH_AMERICA_WEATHER = MAIN + PLACEHOLDER + "/north-america-weather";
    public static final String OCEANIA_WEATHER = MAIN + PLACEHOLDER + "/oceania-weather";
    public static final String SOUTH_AMERICA_WEATHER = MAIN + PLACEHOLDER + "/south-america-weather";
}
