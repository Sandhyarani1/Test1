package com.chameleon.selenium.mobile.driverManager;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.safari.SafariOptions;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.mobile.elements.MobileElement;

import io.appium.java_client.ios.IOSDriver;

public class IOSAppDriverManager extends DriverManager {

    private MutableCapabilities options = null;

    public IOSAppDriverManager() {
        options = new SafariOptions();
    }

    public IOSAppDriverManager(MutableCapabilities options) {
        this.options = options;
    }

    @Override
    public void startService() {
    }

    @Override
    public void createDriver() {
        throw new WebDriverException("Cannot create local IOSDriver instance. Use createDriver(url) instead");
    }

    @Override
    public void createDriver(URL url) {
        driver = new IOSDriver<MobileElement>(url, options);
        ((IOSDriver<?>) driver).rotate(ScreenOrientation.PORTRAIT);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.IOS_APP;
    }
}