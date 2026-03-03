package com.xm.selenium.pages.base;

import com.xm.selenium.enums.SliderPosition;
import com.xm.selenium.utils.ActionUtils;
import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class AbstractEconomicCalendarPage extends AbstractBasePage {

    @FindBy(css = ".rp-trading-central-widget>iframe")
    protected WebElement calendarIframe;

    @FindBy(css = "#economic-calendar-list .tc-economic-calendar-item-header-left-title")
    WebElement calendarLeftTitle;

    @FindBy(id = "noEvent")
    WebElement noEventsElement;

    @FindBy(css = "mat-slider .mat-slider-thumb")
    WebElement sliderThumb;

    @FindBy(css = "mat-slider[role='slider']")
    WebElement slider;

    @FindBy(css = "div.tc-slider-timezone-container .tc-finalval-tmz .ng-star-inserted")
    WebElement sliderTitle;

    public boolean isSliderAtPosition(SliderPosition sliderPosition) {
        log.info("Check if slider at position - {}", sliderPosition);
        waitForCalendarIsLoaded();

        iframeActions(calendarIframe, () -> {
            PageUtils.waitForTextToBePresent(sliderTitle, sliderPosition.getTitle());
        });
        return true;
    }

    public void dragSlider(SliderPosition targetPosition) {
        log.info("Drag slider to the position - {}", targetPosition);
        waitForCalendarIsLoaded();

        iframeActions(calendarIframe, () -> {
            var sliderValueMin = Integer.parseInt(slider.getAttribute("aria-valuemin"));
            var sliderValueMax = Integer.parseInt(slider.getAttribute("aria-valuemax"));
            var sliderValueNow = Integer.parseInt(slider.getAttribute("aria-valuenow"));
            var sliderWidth = slider.getSize().getWidth();
            var targetOffsetX = targetPosition.getTargetOffset(sliderValueMin, sliderValueMax, sliderValueNow, sliderWidth);
            log.debug("Slider value min {}, value max {}, value now {}, width {}, targetOffsetX {}",
                    sliderValueMin, sliderValueMax, sliderValueNow, sliderWidth, targetOffsetX);

            PageUtils.waitToBeClickable(sliderThumb);
            ActionUtils.dragAndDrop(sliderThumb, targetOffsetX, 0);
        });
    }

    protected void waitForCalendarIsLoaded() {
        iframeActions(calendarIframe, () -> {
            PageUtils.waitForVisibility(sliderTitle);
            PageUtils.waitForVisibilityOfAny(calendarLeftTitle, noEventsElement);
        });
    }
}
