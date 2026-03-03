package com.xm.selenium.pages._default;

import com.xm.selenium.pages.base.AbstractHomePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends AbstractHomePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
