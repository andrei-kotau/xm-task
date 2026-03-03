package com.xm.selenium.browser;

public enum BrowserName {
    CHROME,
    EDGE,
    FIREFOX;

    public static BrowserName fromString(String name) {
        try {
            return BrowserName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(String.format("Unsupported browser '%s'. " +
                    "Possible browser values are Chrome, Edge and Firefox.", name));
        }
    }
}
