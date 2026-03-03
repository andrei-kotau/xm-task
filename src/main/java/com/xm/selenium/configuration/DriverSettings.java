package com.xm.selenium.configuration;

import com.xm.selenium.browser.BrowserName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverSettings {
    private String browser;
    private String screenResolution;

    public ScreenResolution getScreenResolution() {
        return ScreenResolution.fromString(screenResolution);
    }

    public BrowserName getBrowser() {
        return BrowserName.fromString(browser);
    }
}
