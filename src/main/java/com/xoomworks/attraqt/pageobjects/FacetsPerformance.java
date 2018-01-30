package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FacetsPerformance extends LoadableComponent<FacetsPerformance> {
    private static WebDriver driver;

    public FacetsPerformance() {
        driver = BaseTest.getDriver();
    }

    private String baseURL = UrlMap.getProperty("base.url");
    private String facetsPerformanceURL = baseURL + "reports/facets-report.html";
    //POM VARIABLES
    @FindBy(css = "a.xw-apply-report-button")
    private WebElement applyToReport;
    @FindBy(css = ".xw-date-range")
    private WebElement dateRangeDropdown;
    @FindBy(xpath = "//*[@id=\"xw-search\"]")
    private WebElement inputTextSearchField;
    @FindBy(xpath = "//*[@id=\"contains-words\"]")
    private WebElement thatContainsButton;
    @FindBy(css = "#DruContent div:nth-of-type(1) div:nth-of-type(1) div:nth-of-type(4) a:nth-of-type(2)")
    private WebElement resetToDefault;
    @FindBy(xpath = "//*[@id=\"highcharts-0\"]")
    private WebElement chart;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div[2]/div/svg")
    private WebElement reportSelection;


    public void load() {
        driver.get(facetsPerformanceURL);
    }

    public boolean facetsPerformanceCheckFont(String xpath) {
        WebElement text = driver.findElement(By.xpath(xpath));
        String fontFamily = text.getCssValue("font-family");
        System.out.println("Font family->" + fontFamily);
        boolean variable = false;
        if (fontFamily.equals("\"Lato\", sans-serif")) {
            variable = true;
        }
        return variable;
    }

    public void changeSection() {
        dateRangeDropdown.click();
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-button"));
        for (WebElement li : options) {
            if (li.getText().equals("Last week (starting Monday)")) ;
            li.click();
        }
    }

    public void changePage() {
        reportSelection.click();
        List<WebElement> selection = driver.findElements(By.id("xw-main-nav-menu"));
        for (WebElement li : selection) {
            if (li.getText().equals("Search Terms & Misspelled Terms")) ;
            li.click();
        }
        assertEquals("http://192.168.1.78:8080/reports/search-terms-report.html", driver.getCurrentUrl());
    }

    public void isLoaded() throws Error {
        assertEquals(facetsPerformanceURL, driver.getCurrentUrl());
        assertEquals(true, applyToReport.isDisplayed());
        assertEquals(true, dateRangeDropdown.isDisplayed());
        assertEquals(true, inputTextSearchField.isDisplayed());
        assertEquals(true, thatContainsButton.isDisplayed());
        assertEquals(true, resetToDefault.isDisplayed());
        assertEquals(true, chart.isDisplayed());
    }
}
