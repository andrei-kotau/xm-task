package com.xm.selenium.pages.base;

import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public abstract class AbstractHomePage extends AbstractBasePage {

    @FindBy(id = "cookieModal")
    WebElement cookiesPopUp;

    @FindBy(css = ".gtm-acceptDefaultCookieFirstVisit")
    WebElement acceptCookiesButton;

    public boolean isCookiesPopUpDisplayed() {
        return cookiesPopUp.isDisplayed();
    }

    public void acceptCookies() {
        log.info("Close cookies popup if we found it");
        if (isCookiesPopUpDisplayed()) {
            acceptCookiesButton.click();
            PageUtils.waitForDisappear(cookiesPopUp);
        }
    }
}
