package com.xm.selenium.pages._1024x768;

import com.xm.selenium.pages.base.AbstractNavigationBar;
import com.xm.selenium.utils.JSUtils;
import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class NavigationBar extends AbstractNavigationBar {

    public NavigationBar() {
        PageFactory.initElements(driver, this);
    }

    public void goToEconomicCalendarPage() {
        log.info("Open Economic Calendar page");

        PageUtils.waitForVisibility(researchAndEducationLink);
        clickAndWaitForSelected(researchAndEducationLink);

        JSUtils.scrollTo(economicCalendarLink);
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
