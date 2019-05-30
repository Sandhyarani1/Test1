package com.accuweather.glacier.api;

import com.accuweather.glacier.api.currentconditions.CurrentConditions;
import com.accuweather.glacier.api.dailyforecasts.DailyForecasts;
import com.accuweather.glacier.api.locations.Locations;

public class AccuweatherRest {

    public static CurrentConditions currentConditions() {
        return new CurrentConditions();
    }

    public static Locations locations() {
        return new Locations();
    }
    
    public static DailyForecasts dailyforecasts() {
        return new DailyForecasts();
    }
    
}
