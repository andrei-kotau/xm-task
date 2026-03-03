package com.xm.selenium.pages._1024x768;

import com.xm.selenium.enums.SliderPosition;
import com.xm.selenium.pages.base.AbstractEconomicCalendarPage;
import com.xm.selenium.utils.JSUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class EconomicCalendarPage extends AbstractEconomicCalendarPage {

    public EconomicCalendarPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isSliderAtPosition(SliderPosition sliderPosition) {
        waitForCalendarIsLoaded();
        JSUtils.scrollTo(calendarIframe);
        return super.isSliderAtPosition(sliderPosition);
    }

    public void dragSlider(SliderPosition targetPosition) {
        waitForCalendarIsLoaded();
        JSUtils.scrollTo(calendarIframe);
        super.dragSlider(targetPosition);
    }
}
