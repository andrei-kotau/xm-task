package com.xm.selenium.pages._800x600;

import com.xm.selenium.enums.SliderPosition;
import com.xm.selenium.pages.base.AbstractEconomicCalendarPage;
import com.xm.selenium.utils.ActionUtils;
import com.xm.selenium.utils.JSUtils;
import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class EconomicCalendarPage extends AbstractEconomicCalendarPage {

    public EconomicCalendarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".tc-calendar-button mat-icon")
    WebElement calendarMiniIcon;

    @FindBy(css = "tc-header-container .tc-time-filter-container")
    WebElement timeFilterContainer;


    public boolean isSliderAtPosition(SliderPosition sliderPosition) {
        openCalendarWidget();
        return super.isSliderAtPosition(sliderPosition);
    }

    public void dragSlider(SliderPosition targetPosition) {
        openCalendarWidget();
        super.dragSlider(targetPosition);
    }

    public void openCalendarWidget() {
        PageUtils.waitForDisplayed(calendarIframe);
        JSUtils.scrollTo(calendarIframe);

        iframeActions(calendarIframe, () -> {
            var attempts = 0;
            while (!PageUtils.isDisplayed(timeFilterContainer)) {
                log.debug("Open calendar mini-widget, attempt {}", ++attempts);
                PageUtils.waitForDisplayed(calendarMiniIcon);
                PageUtils.waitForVisibleAndClickable(calendarMiniIcon);
                calendarMiniIcon.click();
                ActionUtils.pauseSeconds(2);

                if (attempts > 5) {
                    throw new RuntimeException("Unable to open calendar mini-widget");
                }
            }
        });
    }
}
