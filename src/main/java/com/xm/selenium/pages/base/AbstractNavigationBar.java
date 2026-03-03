package com.xm.selenium.pages.base;

import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class AbstractNavigationBar extends AbstractBasePage {

    @FindBy(css = "#main-nav .main_nav_research")
    public WebElement researchAndEducationLink;

    @FindBy(xpath = "//a[contains(text(),'Educational Videos')]")
    public WebElement educationalVideosLink;

    @FindBy(xpath = "//a[contains(text(),'Economic Calendar')]")
    public WebElement economicCalendarLink;

    public void goToEconomicCalendarPage() {
        log.info("Open Economic Calendar page");

        PageUtils.waitForVisibility(researchAndEducationLink);
        clickAndWaitForSelected(researchAndEducationLink);

        PageUtils.waitForVisibility(economicCalendarLink);
        economicCalendarLink.click();
    }

    public void goToEducationalVideosPage() {
        log.info("Open Educational Videos page");
        clickAndWaitForSelected(researchAndEducationLink);
        PageUtils.waitForVisibility(educationalVideosLink);
        educationalVideosLink.click();
    }
}
