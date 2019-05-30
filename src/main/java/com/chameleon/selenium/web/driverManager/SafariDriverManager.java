package com.chameleon.selenium.web.driverManager;

import java.net.URL;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import com.chameleon.selenium.DriverConstants;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.web.WebException;

public class SafariDriverManager extends DriverManager {

    private SafariOptions options = null;

    public SafariDriverManager() {
        options = new SafariOptions();
    }

    public SafariDriverManager(SafariOptions options) {
        this.options = options;
    }

    @Override
    public void startService() {
        if (null == driverService.get()) {
            try {
                driverService.set(new SafariDriverService.Builder()
                        .usingAnyFreePort()
                        .usingTechnologyPreview(DriverConstants.SAFARI_USE_TECHNOLOGY_PREVIEW)
                        .build());
                driverService.get().start();
            } catch (Exception e) {
                throw new WebException("Failed to start Safari driver service", e);
            }
        }
    }

    @Override
    public void createDriver() {
        driver = new SafariDriver((SafariDriverService) driverService.get(), options);
    }

    @Override
    public void createDriver(URL url) {
        driver = new RemoteWebDriver(url, options);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.SAFARI;
    }
}