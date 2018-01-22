package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ReportingDashboard extends LoadableComponent<ReportingDashboard> {
    private static WebDriver driver;
    public ReportingDashboard(){driver = BaseTest.getDriver();}

    protected void load() {

    }

    protected void isLoaded() throws Error {

    }
}
