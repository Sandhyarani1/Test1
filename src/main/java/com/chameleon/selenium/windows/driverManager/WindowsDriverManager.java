package com.chameleon.selenium.windows.driverManager;

import java.net.URL;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.chameleon.AutomationException;
import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.DriverType;
import com.chameleon.selenium.elements.Element;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsDriverManager extends DriverManager {

    private WindowsOptions options = null;

    public WindowsDriverManager() {
        throw new AutomationException("Windows driver cannot be started without options. Create WindowsOptions and pass in through Driver Factory");
    }

    public WindowsDriverManager(WindowsOptions options) {
        this.options = options;
    }

    @Override
    public void startService() {
        // if (null == driverService.get()) {
        // try {
        // driverService.set(new AppiumServiceBuilder()
        // // .withLogFile(logFile)
        // // .usingDriverExecutable(driverExecutable)
        // // .withAppiumJS(appiumJs)
        // .withIPAddress(AppiumServiceBuilder.DEFAULT_LOCAL_IP_ADDRESS)
        // .usingAnyFreePort()
        // // .usingPort(4723)
        // .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
        // .withArgument(GeneralServerFlag.LOG_TIMESTAMP)
        // .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf(4723))
        // .withArgument(AndroidServerFlag.CHROME_DRIVER_PORT, String.valueOf(8888))
        // .build());
        // driverService.get().start();
        // // }catch (InvalidServerInstanceException i){
        // // throw new AutomationException("");
        // } catch (Exception e) {
        // throw new WebException("Failed to start Windows driver service", e);
        // }
        // }
    }

    @Override
    public void createDriver() {
        try {
            driver = new WindowsDriver<Element>(options.getUrl(), options);
        } catch (WebDriverException wde) {
            if (wde.getMessage().contains("Connection refused")) {
                throw new AutomationException("WinAppDriver service requires manual start. Please ensure driver service has been started at [ C:\\Program Files (x86)\\Windows Application Driver ]", wde);
            } else {
                throw wde;
            }
        }
    }

    @Override
    public void createDriver(URL url) {
        driver = new RemoteWebDriver(url, options);
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.WINDOWS;
    }

}
