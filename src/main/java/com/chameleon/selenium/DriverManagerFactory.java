package com.chameleon.selenium;

import com.chameleon.selenium.mobile.driverManager.AndroidAppDriverManager;
import com.chameleon.selenium.mobile.driverManager.AndroidWebDriverManager;
import com.chameleon.selenium.mobile.driverManager.IOSAppDriverManager;
import com.chameleon.selenium.mobile.driverManager.IOSWebDriverManager;
import com.chameleon.selenium.web.WebException;
import com.chameleon.selenium.web.driverManager.ChromeDriverManager;
import com.chameleon.selenium.web.driverManager.EdgeDriverManager;
import com.chameleon.selenium.web.driverManager.FirefoxDriverManager;
import com.chameleon.selenium.web.driverManager.InternetExplorerDriverManager;
import com.chameleon.selenium.web.driverManager.SafariDriverManager;
import com.chameleon.selenium.windows.driverManager.WindowsDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
            case HTML:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            case INTERNETEXPLORER:
                driverManager = new InternetExplorerDriverManager();
                break;
            case WINDOWS:
                driverManager = new WindowsDriverManager();
                break;
            case IOS_WEB:
                driverManager = new IOSWebDriverManager();
            case ANDROID_WEB:
                driverManager = new AndroidWebDriverManager();
                break;
            case IOS_APP:
                driverManager = new IOSAppDriverManager();
                break;
            case ANDROID_APP:
                driverManager = new AndroidAppDriverManager();
                break;
            default:
                throw new WebException("Not a valid DriverType [ " + type + " ]");
        }
        return driverManager;

    }

    public static DriverManager getManager(DriverType type, DriverOptionsManager options) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager(options.getChromeOptions());
                break;
            case FIREFOX:
            case HTML:
                driverManager = new FirefoxDriverManager(options.getFirefoxOptions());
                break;
            case EDGE:
                driverManager = new EdgeDriverManager(options.getEdgeOptions());
                break;
            case SAFARI:
                driverManager = new SafariDriverManager(options.getSafariOptions());
                break;
            case INTERNETEXPLORER:
                driverManager = new InternetExplorerDriverManager(options.getInternetExplorerOptions());
                break;
            case WINDOWS:
                driverManager = new WindowsDriverManager(options.getWindowsOptions());
                break;
            case IOS_WEB:
                driverManager = new IOSWebDriverManager(options.getIOSOptions());
                break;
            case ANDROID_WEB:
                driverManager = new AndroidWebDriverManager(options.getAndroidOptions());
                break;
            case IOS_APP:
                driverManager = new IOSAppDriverManager(options.getIOSOptions());
                break;
            case ANDROID_APP:
                driverManager = new AndroidAppDriverManager(options.getAndroidOptions());

            default:
                throw new WebException("Not a valid DriverType [ " + type + " ]");
        }
        return driverManager;

    }
}