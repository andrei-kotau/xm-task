package com.xm.tests;

import com.google.inject.Inject;
import com.xm.di.PageModule;
import com.xm.selenium.browser.DriverManager;
import com.xm.selenium.configuration.TestSettings;
import com.xm.selenium.configuration.XmConfiguration;
import com.xm.selenium.pages.base.AbstractEconomicCalendarPage;
import com.xm.selenium.pages.base.AbstractEducationalVideosPage;
import com.xm.selenium.pages.base.AbstractHomePage;
import com.xm.selenium.pages.base.AbstractNavigationBar;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;

@Guice(modules = PageModule.class)
public class BaseUITest {
    TestSettings testSettings = XmConfiguration.getTestSettings();

    @Inject
    AbstractHomePage homePage;
    @Inject
    AbstractNavigationBar navigationBar;
    @Inject
    AbstractEducationalVideosPage educationalVideosPage;
    @Inject
    AbstractEconomicCalendarPage economicCalendarPage;

    @BeforeTest
    void setUp() {
        DriverManager.getDriver().get(testSettings.getBaseUrl());
    }

    @AfterTest
    void tearDown() {
        DriverManager.quit();
    }
}
