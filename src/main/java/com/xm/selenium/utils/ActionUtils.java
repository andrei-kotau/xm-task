package com.xm.selenium.utils;

import com.xm.selenium.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionUtils {
    private static final WebDriver driver = DriverManager.getDriver();

    public static void pauseSeconds(int seconds) {
        new Actions(driver).pause(Duration.ofSeconds(seconds)).build().perform();
    }

    public static void dragAndDrop(WebElement element, int offsetX, int offsetY) {
        new Actions(DriverManager.getDriver()).dragAndDropBy(element, offsetX, offsetY).click().build().perform();
    }
}
