package com.xm.selenium.browser;

import com.xm.selenium.configuration.DriverSettings;
import com.xm.selenium.configuration.ScreenResolution;
import com.xm.selenium.configuration.XmConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class LocalDriverFactory implements IDriverFactory {
    private final DriverSettings driverSettings = XmConfiguration.getDriverSettings();

    @Override
    public WebDriver getDriver() {
        BrowserName browserName = driverSettings.getBrowser();
        RemoteWebDriver driver;
        switch (browserName) {
            case CHROME:
                driver = new ChromeDriver(getChromeOptions());
                break;
            case FIREFOX:
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case EDGE:
                driver = new EdgeDriver(getEdgeOptions());
                break;
            default:
                throw new RuntimeException("");
        }
        log.info("Browser is created {}", browserName);


        return setUp(driver);
    }

    private ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    private FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }

    private EdgeOptions getEdgeOptions() {
        var options = new EdgeOptions();
        options.addArguments("--guest");
        return options;
    }

    private WebDriver setUp(WebDriver driver) {
        var screenResolution = driverSettings.getScreenResolution();
        if (screenResolution.equals(ScreenResolution._DEFAULT)) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(screenResolution.getWidth(), screenResolution.getHeight()));
        }
        log.info("Screen resolution is set to " + screenResolution.getName());
        return driver;
    }
}
