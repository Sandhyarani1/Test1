package com.chameleon.selenium.web.driverManager;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.chameleon.selenium.DriverConstants;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.web.WebException;

public class FirefoxDriverManager extends DriverManager {

    private FirefoxOptions options = null;

    public FirefoxDriverManager() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        options = new FirefoxOptions().setProfile(profile);
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(DriverConstants.DEFAULT_FIREFOX_PAGE_LOAD_STRATEGY);
    }

    public FirefoxDriverManager(FirefoxOptions options) {
        this.options = options;
    }

    @Override
    public void startService() {
        if (null == driverService.get()) {
            String driverLocation = getDriverLocation(DriverConstants.DRIVER_EXE_NAME_FIREFOX);
            try {
                driverService.set(new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(driverLocation))
                        .usingAnyFreePort()
                        .build());
                driverService.get().start();
            } catch (Exception e) {
                throw new WebException("Failed to start Gecko/Firefox driver service", e);
            }
        }
    }

    @Override
    public void createDriver() {
        driver = new FirefoxDriver((GeckoDriverService) driverService.get(), options);
    }

    @Override
    public void createDriver(URL url) {
        driver = new RemoteWebDriver(url, options);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.FIREFOX;
    }
}