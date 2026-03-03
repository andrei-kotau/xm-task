package com.xm.selenium.pages._default;

import com.xm.selenium.pages.base.AbstractNavigationBar;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends AbstractNavigationBar {

    public NavigationBar() {
        PageFactory.initElements(driver, this);
    }
}
