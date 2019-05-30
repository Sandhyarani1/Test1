package com.chameleon.selenium;

import com.chameleon.AutomationException;

public enum DriverType {
    CHROME("chrome", "ch"),
    FIREFOX("firefox", "ff"),
    INTERNETEXPLORER("internetexplorer", "ie", "iexplorer"),
    SAFARI("safari"),
    EDGE("edge", "microsoftedge"),
    ANDROID_WEB("android_web"),
    IOS_WEB("ios_web"),
    ANDROID_APP("android_app"),
    IOS_APP("ios_app"),
    APPIUM("appium"),
    WINDOWS("windows", "win"),
    HTML("html");

    private final String[] type;

    DriverType(String... type) {
        this.type = type;
    }

    public String[] getDriverType() {
        return type;
    }

    public static DriverType fromString(String type) {
        for (DriverType driverType : values()) {
            if (driverType.toString().equalsIgnoreCase(type)) {
                return driverType;
            }
        }

        for (DriverType browser : DriverType.values()) {
            for (String driverType : browser.getDriverType()) {
                if (driverType.equalsIgnoreCase(type)) {
                    return browser;
                }
            }
        }

        throw new AutomationException("No DriverType defined found for requested value [ " + type + " ]");
    }
}