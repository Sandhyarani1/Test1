package com.chameleon.selenium;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.service.DriverService;

import com.chameleon.AutomationException;
import com.chameleon.selenium.mobile.ExtendedMobileDriver;
import com.chameleon.selenium.web.ExtendedWebDriver;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;
import com.chameleon.utils.Constants;
import com.chameleon.utils.io.FileLoader;

public abstract class DriverManager {

    protected WebDriver driver = null;
    protected static ThreadLocal<DriverService> driverService = new ThreadLocal<>();
    protected static ThreadLocal<File> driverLogFile = new ThreadLocal<>();
    private static ThreadLocal<ExtendedDriver> extendedDriver = new ThreadLocal<>();

    protected abstract void startService();

    protected abstract void createDriver();

    protected abstract void createDriver(URL url);

    protected abstract DriverType getDriverType();

    public static void quitDriver() {
        if (null != extendedDriver && null != extendedDriver.get()) {
            extendedDriver.get().quit();
            extendedDriver.remove();
        }
    }

    public static File getLogFile() {
        if (driverLogFile != null && driverLogFile.get() != null) {
            return driverLogFile.get();
        }
        return null;
    }

    public static void stopService() {
        if (null != driverService.get() && driverService.get().isRunning()) {
            driverService.get().stop();
            driverService.remove();
            System.gc();
        }
    }

    public static void setDriver(ExtendedDriver driver) {
        extendedDriver.set(driver);
    }

    public void initalizeDriver() {
        try {
            startService();
            createDriver();
            createExtendedDriver();
        } catch (WebDriverException e) {
            // If driver or session fails to create, then it is possible for service to remain open.
            // Explicitly close driver service here to prevent orphaned processes
            stopService();
            throw e;
        }
    }

    public void initalizeDriver(URL url) {
        createDriver(url);
        createExtendedDriver();
    }

    public static boolean hasDriver() {
        if (null == extendedDriver || null == extendedDriver.get()) {
            return false;
        }
        return true;
    }

    public static ExtendedDriver getDriver() {
        if (null == extendedDriver || null == extendedDriver.get()) {
            throw new AutomationException("Driver is null");
        }
        return extendedDriver.get();
    }

    public static ExtendedWebDriver getWebDriver() {
        return (ExtendedWebDriver) getDriver();
    }

    public static ExtendedWindowsDriver getWindowsDriver() {
        return (ExtendedWindowsDriver) getDriver();
    }

    public static ExtendedMobileDriver getMobileDriver() {
        return (ExtendedMobileDriver) getDriver();
    }

    protected String getDriverLocation(String filename) {
        String fileType = "";
        String osFolder = "";

        if (SystemUtils.IS_OS_WINDOWS) {
            osFolder = "windows\\";
            fileType = ".exe";
        } else if (SystemUtils.IS_OS_LINUX) {
            osFolder = "linux/";
        } else if (SystemUtils.IS_OS_MAC) {
            osFolder = "mac/";
        }

        String filePath = Constants.CURRENT_DIR + Constants.DRIVERS_PATH_LOCAL + osFolder + filename + fileType;
        String absoluteFilePath = FileLoader.getAbsolutePathForResource(filePath);

        // Validate driver client exists
        if (!FileLoader.isReadableFile(absoluteFilePath)) {
            throw new AutomationException(filename + fileType + " was not found on project path [ " + Constants.CURRENT_DIR + Constants.DRIVERS_PATH_LOCAL + osFolder + " ]");
        }
        return absoluteFilePath;
    }

    private void createExtendedDriver() {
        ExtendedDriver eDriver = null;
        switch (getDriverType()) {
            case WINDOWS:
                eDriver = new ExtendedWindowsDriver();
                break;
            case IOS_APP:
            case ANDROID_APP:
                eDriver = new ExtendedMobileDriver();
                break;
            default:
                eDriver = new ExtendedWebDriver();
                break;
        }

        eDriver.setDriver(this.driver);
        eDriver.setElementTimeout(Constants.ELEMENT_TIMEOUT);

        eDriver.setDriverType(getDriverType());
        extendedDriver.set(eDriver);

        if (isWebBrowserDriver()) {
            eDriver.setPageTimeout(Constants.PAGE_TIMEOUT);
            ((ExtendedWebDriver) eDriver).setScriptTimeout(Constants.DEFAULT_GLOBAL_DRIVER_TIMEOUT);
        }

    }

    public static boolean isMobileAppDriver() {
        DriverType type = getDriver().driverType;
        if (DriverType.ANDROID_APP.equals(type) || DriverType.IOS_APP.equals(type)) {
            return true;
        }
        return false;
    }

    public static boolean isWindowsAppDriver() {
        DriverType type = getDriver().driverType;
        if (DriverType.WINDOWS.equals(type)) {
            return true;
        }
        return false;
    }

    public static boolean isWebBrowserDriver() {
        if (isMobileAppDriver() || isWindowsAppDriver()) {
            return false;
        }
        return true;
    }

    public static boolean isWebDriver() {
        if (getDriver() instanceof ExtendedWebDriver) {
            return true;
        }
        return false;
    }

    public static boolean isMobileDriver() {
        if (getDriver() instanceof ExtendedMobileDriver) {
            return true;
        }
        return false;
    }

    public boolean isWindowsDriver() {
        if (getDriver() instanceof ExtendedWindowsDriver) {
            return true;
        }
        return false;
    }
}