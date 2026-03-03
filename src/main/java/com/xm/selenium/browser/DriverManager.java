package com.xm.selenium.browser;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriverContainer = new ThreadLocal<>();
    private static final ThreadLocal<IDriverFactory> factoryContainer = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (webDriverContainer.get() == null) {
            setDefaultDriver();
        }
        return webDriverContainer.get();
    }

    public static void quit() {
        if (webDriverContainer.get() != null) {
            webDriverContainer.get().quit();
            webDriverContainer.remove();
        }
    }

    public static void setDefaultFactory() {
        IDriverFactory browserFactory = new LocalDriverFactory();
        // depending on configuration any DriverFactory can be set, for example RemoteDriverFactory
        setFactory(browserFactory);
    }

    public static void setFactory(IDriverFactory browserFactory) {
        removeContainer(factoryContainer);
        DriverManager.factoryContainer.set(browserFactory);
    }

    private static void setDefaultDriver() {
        if (factoryContainer.get() == null) {
            setDefaultFactory();
        }
        setDriver(factoryContainer.get().getDriver());
    }

    public static void setDriver(WebDriver driver) {
        removeContainer(webDriverContainer);
        DriverManager.webDriverContainer.set(driver);
    }

    private static void removeContainer(ThreadLocal<?> container) {
        if (container.get() != null) {
            container.remove();
        }
    }
}
