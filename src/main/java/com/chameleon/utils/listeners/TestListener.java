package com.chameleon.utils.listeners;

import static org.openqa.selenium.OutputType.BYTES;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlSuite;

import com.chameleon.selenium.DriverManager;
import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.web.WebBaseTest;
import com.chameleon.utils.Constants;
import com.chameleon.utils.Preamble;
import com.chameleon.utils.TestReporter;

import io.qameta.allure.Attachment;
import io.qameta.allure.Stories;

public class TestListener extends TestListenerAdapter implements IReporter {
    private ExtendedDriver driver = null;
    private String runLocation = "";

    private void init(ITestResult result) {

        Object currentClass = result.getInstance();

        try {
            runLocation = ((WebBaseTest) currentClass).getRunLocation().toLowerCase();
        } catch (Exception e) {
        }

        try {
            driver = DriverManager.getDriver();
        } catch (Exception e) {
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        init(result);
        String slash = Constants.DIR_SEPARATOR;

        String destDir = Constants.SCREENSHOT_FOLDER + slash + result.getInstanceName().replace(".", slash);
        DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");

        String destFile = destDir + slash + dateFormat.format(new Date()) + ".png";

        Reporter.setCurrentTestResult(result);

        if (driver != null) {
            WebDriver augmentDriver = driver.getWebDriver();
            // if (!(augmentDriver instanceof HtmlUnitDriver)) {
            if (runLocation == "remote") {
                augmentDriver = new Augmenter().augment(driver.getWebDriver());
            }

            new File(destDir).mkdirs();

            // Capture a screenshot for TestNG reporting
            TestReporter.logScreenshot(augmentDriver, destFile, slash);
            // Capture a screenshot for Allure reporting
            failedScreenshot(augmentDriver);
            // }

            // Log any console errors
            TestReporter.logConsoleLogging();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // will be called after test will be skipped
        init(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // will be called after test will pass
        init(result);
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites,
            List<ISuite> suites, String outputDirectory) {
        // TODO Auto-generated method stub

    }

    @Attachment(type = "image/png")
    public static byte[] failedScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    private Preamble getPreambleAnnotation(IInvokedMethod method) {
        if (!method.isTestMethod()) {
            return null;
        }
        ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
        if (com.getMethod() == null) {
            return null;
        }
        Method m = com.getMethod();
        return m.getAnnotation(Preamble.class);
    }

    /**
    private TestCaseId getTestCaseIdAnnotation(IInvokedMethod method) {
        if (!method.isTestMethod()) {
            return null;
        }
        ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
        if (com.getMethod() == null) {
            return null;
        }
        Method m = com.getMethod();
        return m.getAnnotation(TestCaseId.class);
    }**/

    private Stories getStoriesAnnotation(IInvokedMethod method) {
        if (!method.isTestMethod()) {
            return null;
        }
        ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
        if (com.getMethod() == null) {
            return null;
        }
        Method m = com.getMethod();
        return m.getAnnotation(Stories.class);
    }
}