package com.xm.tests;

import com.xm.selenium.enums.SliderPosition;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class XmUITest extends BaseUITest {

    @Test
    void xmTest() {
        homePage.acceptCookies();
        assertThat(homePage.getTitle())
                .describedAs("Check the title of Home page")
                .isEqualTo("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™");

        navigationBar.goToEconomicCalendarPage();
        assertThat(economicCalendarPage.getTitle())
                .describedAs("Check title of Economic Calendar page")
                .isEqualTo("Economic Calendar");

        assertThat(economicCalendarPage.isSliderAtPosition(SliderPosition.RECENT_AND_NEXT)).isTrue();

        economicCalendarPage.dragSlider(SliderPosition.TODAY);
        assertThat(economicCalendarPage.isSliderAtPosition(SliderPosition.TODAY)).isTrue();

        economicCalendarPage.dragSlider(SliderPosition.TOMORROW);
        assertThat(economicCalendarPage.isSliderAtPosition(SliderPosition.TOMORROW)).isTrue();

        economicCalendarPage.dragSlider(SliderPosition.NEXT_WEEK);
        assertThat(economicCalendarPage.isSliderAtPosition(SliderPosition.NEXT_WEEK)).isTrue();

        navigationBar.goToEducationalVideosPage();
        assertThat(educationalVideosPage.getTitle())
                .describedAs("Check title of Educational Videos page")
                .isEqualTo("Forex Trading Course — Learn Forex from A to Z for Free");

        educationalVideosPage.playFirstVideo();
        educationalVideosPage.waitVideoToPlaySeconds(5);
    }
}
