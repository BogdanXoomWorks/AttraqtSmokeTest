package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.assertEquals;

public class LandingPage extends LoadableComponent<LandingPage> {
    private String baseURL = UrlMap.getProperty("base.url");
    private String landingPageUrl = baseURL + "reports/";
    private static WebDriver driver;

    public LandingPage() {
        driver = BaseTest.getDriver();
    }

    public void load() {
        driver.get(landingPageUrl);
        assertEquals(landingPageUrl, driver.getCurrentUrl());
    }

    protected void isLoaded() throws Error {

    }
}
