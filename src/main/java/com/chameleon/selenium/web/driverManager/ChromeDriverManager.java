package com.chameleon.selenium.web.driverManager;

import static com.chameleon.selenium.DriverConstants.DRIVER_EXE_NAME_CHROME;
import static com.chameleon.utils.Constants.CURRENT_DIR;
import static com.chameleon.utils.Constants.DIR_SEPARATOR;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.chameleon.selenium.DriverConstants;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.web.WebException;

public class ChromeDriverManager extends DriverManager {

    private ChromeOptions options = null;

    public ChromeDriverManager() {
        options = new ChromeOptions();
        options.setPageLoadStrategy(DriverConstants.DEFAULT_CHROME_PAGE_LOAD_STRATEGY);
    }

    public ChromeDriverManager(ChromeOptions options) {
        this.options = options;
    }

    @Override
    public void startService() {
        if (null == driverService.get()) {
            final String driverLocation = getDriverLocation(DRIVER_EXE_NAME_CHROME);
            boolean verbose = false;

            File logFile = null;
            if (DriverConstants.ENABLE_CHROME_LOGS) {
                // System.setProperty(CHROME_DRIVER_LOG_PROPERTY, CHROME_LOG_LOCATION);
                String logFileName = UUID.randomUUID().toString();
                String logFilePath = CURRENT_DIR + "target" + DIR_SEPARATOR + "ChromeLogs" + DIR_SEPARATOR + logFileName + ".log";
                // File.createTempFile(logFileName, "log", Files.);
                try {
                    logFile = new File(logFilePath);
                    logFile.deleteOnExit();
                    FileUtils.touch(logFile);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                verbose = true;
            }

            try {
                driverService.set(new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(driverLocation))
                        .usingAnyFreePort()
                        .withLogFile(logFile)
                        .withVerbose(verbose)
                        .build());
                driverService.get().start();
            } catch (Exception e) {
                throw new WebException("Failed to start Chrome driver service", e);
            }

            driverLogFile.set(logFile);
        }
    }

    @Override
    public void createDriver() {
        driver = new ChromeDriver((ChromeDriverService) driverService.get(), options);
    }

    @Override
    public void createDriver(URL url) {
        driver = new RemoteWebDriver(url, options);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.CHROME;
    }
}