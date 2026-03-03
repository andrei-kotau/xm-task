package com.xm.selenium.pages._default;

import com.xm.selenium.pages.base.AbstractEconomicCalendarPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class EconomicCalendarPage extends AbstractEconomicCalendarPage {

    public EconomicCalendarPage() {
        PageFactory.initElements(driver, this);
    }
}
