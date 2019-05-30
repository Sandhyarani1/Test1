package com.chameleon.selenium.mobile.driverManager;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.mobile.elements.MobileElement;

import io.appium.java_client.android.AndroidDriver;

public class AndroidWebDriverManager extends DriverManager {

    private MutableCapabilities options = null;

    public AndroidWebDriverManager() {
        options = new MutableCapabilities();
    }

    public AndroidWebDriverManager(MutableCapabilities options) {
        this.options = options;
    }

    @Override
    public void startService() {
    }

    @Override
    public void createDriver() {
        throw new WebDriverException("Cannot create local Android instance. Use createDriver(url) instead");
    }

    @Override
    public void createDriver(URL url) {
        driver = new AndroidDriver<MobileElement>(url, options);
        ((AndroidDriver<?>) driver).rotate(ScreenOrientation.PORTRAIT);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.ANDROID_WEB;
    }
}
