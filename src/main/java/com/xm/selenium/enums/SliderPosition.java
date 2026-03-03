package com.xm.selenium.enums;

import lombok.Getter;

@Getter
public enum SliderPosition {
    RECENT_AND_NEXT(0, "Recent & Next"),
    TODAY(1, "Today"),
    TOMORROW(2, "Tomorrow"),
    THIS_WEEK(3, "This Week"),
    NEXT_WEEK(4, "Next Week"),
    THIS_MONTH(5, "This Month"),
    NEXT_MONTH(6, "Next Month");

    final int value;
    final String title;

    SliderPosition(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public int getTargetOffset(int valueMin, int valueMax, int valueCurrent, int sliderWidth) {
        double totalValues = SliderPosition.values().length - 1;
        if (valueMin != 0 || valueMax != totalValues) {
            throw new RuntimeException("Slider was modified on UI by developers of the website. Please update this enum with all relevant slider values.");
        }
        var currentPosition = valueCurrent / totalValues * sliderWidth;
        var targetPosition = this.value / totalValues * sliderWidth;
        return (int) (targetPosition - currentPosition);
    }
}
