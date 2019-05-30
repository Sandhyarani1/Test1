package com.chameleon;

import static com.chameleon.utils.Constants.TESTNG_PARAM_ENVIRONMENT;
import static com.chameleon.utils.Constants.TEST_REPORTER_DEFAULT_LEVEL;
import static com.chameleon.utils.TestReporter.log;
import static com.chameleon.utils.TestReporter.logTrace;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.accuweather.glacier.Environment;
import com.chameleon.utils.TestReporter;

public class BaseTest {
    private static String environment;
    private String testName;
    protected int logLevel;
    private ThreadLocal<String> dataProviderTestInstanceName = ThreadLocal.withInitial(() -> null);

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "environment", "logLevel" })
    public void beforeSuite(@Optional String environment, @Optional String logLevel) {

        if (isNotEmpty(logLevel)) {
            this.logLevel = determineLogLevel(logLevel);
            TestReporter.setDebugLevel(determineLogLevel(logLevel));
        } else {
            this.logLevel = TEST_REPORTER_DEFAULT_LEVEL;
            TestReporter.setDebugLevel(TEST_REPORTER_DEFAULT_LEVEL);
        }
        log("Setting Test Reporter log level to [ " + logLevel + " ]");
        logTrace("Entering BaseTest#beforeSuite");

        if (isNotEmpty(environment)) {
            log("Setting parameter [ environment ] to [ " + environment + " ]");
            BaseTest.environment = environment;
            Environment.setEnvironment(environment);
        } else {
            BaseTest.environment = TESTNG_PARAM_ENVIRONMENT;
            Environment.setEnvironment(TESTNG_PARAM_ENVIRONMENT);
        }
        logTrace("Exiting BaseTest#beforeSuite");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method testMethod, Object[] testParams) {
        TestReporter.setDebugLevel(logLevel);
        TestReporter.setAssertFailed(false); // reset softAssertions in case of assertAll not being called
        logTrace("Entering BaseTest#beforeMethod");
        testName = testMethod.getDeclaringClass().getSimpleName() + "#" + testMethod.getName();
        log("Starting test [ " + testName + " ]");

        int id = 1;
        for (Object param : Arrays.asList(testParams)) {
            if (id == 1) {
                // dataProviderTestInstanceName.set(value);
            }
            log("Test parameter [ " + id + " ] value [ " + param.toString() + " ]");
            id++;
        }
        logTrace("Exiting BaseTest#beforeMethod");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method testMethod, ITestResult testResults) {
        logTrace("Entering BaseTest#afterMethod");
        TestReporter.setAssertFailed(false); // reset softAssertions in case of assertAll not being called
        testName = testMethod.getDeclaringClass().getSimpleName() + "#" + testMethod.getName();
        String status = null;

        switch (testResults.getStatus()) {
            case ITestResult.FAILURE:
                status = "FAIL";
                break;
            case ITestResult.SKIP:
                status = "SKIP";
                break;
            case ITestResult.SUCCESS:
                status = "PASS";
                break;
            default:
                break;
        }

        log("Ending test [ " + testName + " ] with status [ " + status + " ]. Execution time [ " + ((testResults.getEndMillis() - testResults.getStartMillis()) / 1000.0) + " ] seconds");
        logTrace("Exiting BaseTest#afterMethod");
    }

    protected void setEnvironment(String environment) {
        BaseTest.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    protected void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    protected int determineLogLevel(String level) {
        switch (level.toUpperCase()) {
            case "1":
            case "INFO":
                return 1;

            case "2":
            case "DEBUG":
                return 2;

            case "3":
            case "TRACE":
                return 3;

            default:
                return 0;
        }
    }
}
