package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ProductPerformance extends LoadableComponent<ProductPerformance> {
    private static WebDriver driver;
    public ProductPerformance(){driver = BaseTest.getDriver();}
    private String baseURL = UrlMap.getProperty("base.url");
    public String productPerformanceURL = baseURL + "reports/products-report.html";

    protected void load() {
    driver.get(productPerformanceURL);
    }

    public boolean productPerformancecheckFont(String xpath) {
        WebElement text = driver.findElement(By.xpath(xpath));
        String fontFamily = text.getCssValue("font-family");
        System.out.println("Font family->" + fontFamily);
        boolean variable = false;
        if (fontFamily.equals("\"Lato\", sans-serif")) {
            variable = true;
        }
        return variable;
    }

    protected void isLoaded() throws Error {

    }
}
