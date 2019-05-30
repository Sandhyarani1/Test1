package com.chameleon.selenium;

import static com.chameleon.utils.Constants.CURRENT_DIR;
import static com.chameleon.utils.Constants.DIR_SEPARATOR;

import org.openqa.selenium.PageLoadStrategy;

public class DriverConstants {
    /*
     * Driver Constants
     */
    public static final String DRIVERS_PATH_LOCAL = "/drivers/";
    public static final String DRIVERS_PATH_REMOTE = "C:\\Selenium\\WebDrivers\\";

    public static final String DRIVER_EXE_NAME_CHROME = "chromedriver";
    public static final String DRIVER_EXE_NAME_EDGE = "MicrosoftWebDriver";
    public static final String DRIVER_EXE_NAME_FIREFOX = "geckodriver";
    public static final String DRIVER_EXE_NAME_INTERNET_EXPLORER = "IEDriverServer";
    public static final String DRIVER_EXE_NAME_SAFARI = "IEDriverServer";

    public static final String SCREENSHOT_FOLDER = CURRENT_DIR + "selenium-reports" + DIR_SEPARATOR + "html" + DIR_SEPARATOR + "screenshots";
    public static final long DEFAULT_GLOBAL_DRIVER_TIMEOUT = 10000;
    public static final long ELEMENT_TIMEOUT = 15000;
    public static final long PAGE_TIMEOUT = 15000;
    public static final int MILLISECONDS_TO_POLL_FOR_ELEMENT = 250;

    public static final PageLoadStrategy DEFAULT_CHROME_PAGE_LOAD_STRATEGY = PageLoadStrategy.NONE;
    public static final PageLoadStrategy DEFAULT_EDGE_PAGE_LOAD_STRATEGY = PageLoadStrategy.NONE;
    public static final PageLoadStrategy DEFAULT_FIREFOX_PAGE_LOAD_STRATEGY = PageLoadStrategy.NONE;
    public static final PageLoadStrategy DEFAULT_INTERNET_EXPLORER_PAGE_LOAD_STRATEGY = PageLoadStrategy.NONE;
    public static final PageLoadStrategy DEFAULT_SAFARI_PAGE_LOAD_STRATEGY = PageLoadStrategy.NONE;

    public static boolean SAFARI_USE_TECHNOLOGY_PREVIEW = true;

    public static boolean ENABLE_CHROME_LOGS = true;
    public static final String CHROME_LOG_LOCATION = CURRENT_DIR + "target" + DIR_SEPARATOR + "chromedriver.log";
    public static final int MILLISECONDS_TO_WAIT_CHROME_DEVTOOLS = 3000;
}
