package com.xm.selenium.pages._800x600;

import com.xm.selenium.pages.base.AbstractNavigationBar;
import com.xm.selenium.utils.PageUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends AbstractNavigationBar {

    @FindBy(css = "body.main-site")
    WebElement bodyMainSite;

    @FindBy(css = "#researchMenu")
    WebElement researchMenu;

    @FindBy(css = ".toggle-bar .toggleLeftNav")
    WebElement leftMenuToggle;

    @FindBy(xpath = "//span[contains(text(), 'Research & Education')]")
    WebElement researchAndEducationAccordion;

    @FindBy(xpath = "//span[contains(text(), 'Economic Calendar')]")
    WebElement economicCalendarLink;

    @FindBy(xpath = "//div[@id='researchMenu']//a[text()[contains(.,'Educational Videos')]]")
    WebElement educationalVideosLink;

    public NavigationBar() {
        PageFactory.initElements(driver, this);
    }

    public void goToEconomicCalendarPage() {
        openLeftMenuToggle();

        expandResearchAndEducationAccordion();

        PageUtils.waitForVisibility(economicCalendarLink);
        economicCalendarLink.click();
    }

    public void goToEducationalVideosPage() {
        openLeftMenuToggle();

        expandResearchAndEducationAccordion();

        PageUtils.waitForVisibility(educationalVideosLink);
        educationalVideosLink.click();
    }

    private void openLeftMenuToggle() {
        PageUtils.waitForVisibility(leftMenuToggle);
        leftMenuToggle.click();
        PageUtils.waitForCssClassAdded(bodyMainSite, "menu-visible");
    }

    private void expandResearchAndEducationAccordion() {
        PageUtils.waitForVisibility(researchAndEducationAccordion);
        researchAndEducationAccordion.click();
        PageUtils.waitForCssClassAdded(researchMenu, "collapse in");
    }
}
