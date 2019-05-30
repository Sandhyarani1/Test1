package com.accuweather.glacier;

import com.chameleon.AutomationException;

public enum LocationData {

    HIGH_POINT_NC("US", "High Point", "NC", 36.0442036, -79.9441293),
    WASHINGTON_DC("US", "Downtown", "DC", 38.8950712, -77.0362758),
    LAS_VEGAS_NV("US", "Las Vegas", "NV", 36.1672446, -115.1490207),
    LONDON_UK("UK", "Leicester Square", "", 51.5073219, -0.1276474);

    private final String country;
    private final String city;
    private final String state;
    private final double latitude;
    private final double longitude;

    LocationData(String country, String city, String state, double latitude, double longitude) {
        this.country = country;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static LocationData fromString(String location) {

        for (LocationData loc : LocationData.values()) {
            if (loc.toString().replace("_", "").equalsIgnoreCase(location.replace("_", "").replace(" ", ""))) {
                return loc;
            }
        }

        throw new AutomationException("No Location defined found for requested value [ " + location + " ]");
    }
}
