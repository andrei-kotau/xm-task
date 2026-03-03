package com.xm.selenium.configuration;

import com.xm.selenium.constants.Const;
import lombok.Getter;

@Getter
public enum ScreenResolution {
    _DEFAULT(0, 0), // Maximized
    _1024x768(1024, 768),
    _800x600(800, 600);

    private final int width;
    private final int height;

    ScreenResolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static ScreenResolution fromString(String value) {
        switch (value) {
            case "":
                return _DEFAULT;
            case "1024x768":
                return _1024x768;
            case "800x600":
                return _800x600;
            default:
                throw new RuntimeException(Const.INVALID_SCREEN_RESOLUTION);
        }
    }

    public String getName() {
        if (this.width == 0 && this.height == 0)
            return "Maximized";
        return this.width + "x" + this.height;
    }
}
