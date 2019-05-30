package com.accuweather.glacier;

import com.chameleon.utils.Constants;

public class Environment {
    public final static String QA = "qa";
    public final static String PROD = "prod";

    private static ThreadLocal<String> cachedEnvironment = ThreadLocal.withInitial(() -> QA);

    public static void setEnvironment(final String environment) {
        cachedEnvironment.set(environment);
    }

    public static String getEnvironment() {
        if (cachedEnvironment == null || cachedEnvironment.get() == null) {
            return Constants.TESTNG_PARAM_ENVIRONMENT;
        } else {
            return cachedEnvironment.get();
        }
    }
}
