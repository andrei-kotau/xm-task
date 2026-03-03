package com.xm.selenium.configuration;

import com.xm.utils.JsonUtils;
import com.xm.utils.ResourcesUtils;

public class XmConfiguration {
    private static DriverSettings driverSettings;
    private static TestSettings testSettings;

    private static final String DRIVER_SETTINGS_KEY = "DRIVER_SETTINGS";
    private static final String TEST_SETTINGS_KEY = "TEST_SETTINGS";

    private XmConfiguration() {
    }

    public static DriverSettings getDriverSettings() {
        if (driverSettings == null) {
            var driverSettings = getEnvOrDefault(DRIVER_SETTINGS_KEY, "prod-browser-settings.json");
            return JsonUtils.to(DriverSettings.class, new ResourcesUtils().readResourceFileAsString(driverSettings));
        }
        return driverSettings;
    }

    public static TestSettings getTestSettings() {
        if (testSettings == null) {
            var testSettings = getEnvOrDefault(TEST_SETTINGS_KEY, "prod-test-settings.json");
            return JsonUtils.to(TestSettings.class, new ResourcesUtils().readResourceFileAsString(testSettings));
        }
        return testSettings;
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        return System.getenv(key) != null ? System.getenv(key) : defaultValue;
    }
}
