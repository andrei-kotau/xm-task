package com.xm.selenium.utils;

import com.xm.selenium.browser.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class PageUtils {
    private static final WebDriver driver = DriverManager.getDriver();

    private static final Duration DEFAULT_WAIT_DURATION = Duration.ofSeconds(30);

    public static void waitForDisappear(WebElement element) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibleAndClickable(WebElement element) {
        waitForVisibility(element);
        waitToBeClickable(element);
    }

    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(WebElement element) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibilityOfAny(WebElement element1, WebElement element2) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION).until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element1),
                ExpectedConditions.visibilityOf(element2)
        ));
    }

    public static void waitForCssClassAdded(WebElement element, String cssClassName) {
        waitForAttribute(element, "class", cssClassName);
    }

    public static void waitForTextToBePresent(WebElement element, String text) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitForAttribute(WebElement element, String attribute, String value) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static void waitForTimestampToBeMoreThan(WebElement timestampElement, int waitForSeconds, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until((ExpectedCondition<Boolean>) d ->
                        {
                            var text = timestampElement.getAttribute("aria-valuenow");
                            log.debug("Timestamp value: " + text);
                            if (text.isEmpty()) return false;
                            return ((int) Double.parseDouble(text)) > waitForSeconds;
                        }
                );
    }

    public static void waitForDisplayed(WebElement element) {
        new WebDriverWait(driver, DEFAULT_WAIT_DURATION)
                .until((ExpectedCondition<Boolean>) d ->
                        {
                            try {
                                return element.isDisplayed();
                            } catch (NoSuchElementException e) {
                                return false;
                            }
                        }
                );
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
