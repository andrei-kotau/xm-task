package com.xm.di;

import com.google.inject.AbstractModule;
import com.xm.selenium.configuration.DriverSettings;
import com.xm.selenium.configuration.XmConfiguration;
import com.xm.selenium.constants.Const;
import com.xm.selenium.pages._default.EconomicCalendarPage;
import com.xm.selenium.pages._default.EducationalVideosPage;
import com.xm.selenium.pages._default.HomePage;
import com.xm.selenium.pages._default.NavigationBar;
import com.xm.selenium.pages.base.AbstractEconomicCalendarPage;
import com.xm.selenium.pages.base.AbstractEducationalVideosPage;
import com.xm.selenium.pages.base.AbstractHomePage;
import com.xm.selenium.pages.base.AbstractNavigationBar;

public class PageModule extends AbstractModule {
    DriverSettings driverSettings = XmConfiguration.getDriverSettings();

    @Override
    protected void configure() {
        var screenResolution = driverSettings.getScreenResolution();
        switch (screenResolution) {
            case _DEFAULT:
                bind(AbstractHomePage.class).to(HomePage.class);
                bind(AbstractNavigationBar.class).to(NavigationBar.class);
                bind(AbstractEconomicCalendarPage.class).to(EconomicCalendarPage.class);
                bind(AbstractEducationalVideosPage.class).to(EducationalVideosPage.class);
                break;
            case _1024x768:
                bind(AbstractHomePage.class).to(HomePage.class);
                bind(AbstractNavigationBar.class).to(com.xm.selenium.pages._1024x768.NavigationBar.class);
                bind(AbstractEconomicCalendarPage.class).to(com.xm.selenium.pages._1024x768.EconomicCalendarPage.class);
                bind(AbstractEducationalVideosPage.class).to(com.xm.selenium.pages._1024x768.EducationalVideosPage.class);
                break;
            case _800x600:
                bind(AbstractHomePage.class).to(HomePage.class);
                bind(AbstractNavigationBar.class).to(com.xm.selenium.pages._800x600.NavigationBar.class);
                bind(AbstractEconomicCalendarPage.class).to(com.xm.selenium.pages._800x600.EconomicCalendarPage.class);
                bind(AbstractEducationalVideosPage.class).to(com.xm.selenium.pages._1024x768.EducationalVideosPage.class);
                break;
            default:
                throw new RuntimeException(Const.INVALID_SCREEN_RESOLUTION);
        }
    }
}
