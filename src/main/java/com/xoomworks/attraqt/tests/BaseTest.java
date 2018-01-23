package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.utilities.UrlMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static UrlMap urlMap;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\bogdan.apostol\\Desktop\\Geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10L);
        driver.manage().window().maximize();
        urlMap = new UrlMap();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static UrlMap getUrlMap() {
        return urlMap;
    }
}
