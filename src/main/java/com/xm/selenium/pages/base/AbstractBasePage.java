package com.xm.selenium.pages.base;

import com.xm.selenium.browser.DriverManager;
import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

@Slf4j
public abstract class AbstractBasePage {
    protected WebDriver driver = DriverManager.getDriver();

    protected void switchToIframe(WebElement iframeElement) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeElement);
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void clickAndWaitForSelected(WebElement webElement) {
        webElement.click();
        PageUtils.waitForCssClassAdded(webElement, "selected");
    }

    public String getTitle() {
        log.info("Check the title of the page");
        return driver.getTitle();
    }

    protected void iframeActions(WebElement iframe, Action action) {
        switchToIframe(iframe);
        action.perform();
        switchToDefaultContent();
    }
}
