package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.Arrays;
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
    @FindBy(xpath = "id(\"SectionHeader\")/div[1]/div[1]/span[1]")
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
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-menu"));
        for (WebElement li : options) {
            if (li.getText().equals("Last week (starting Monday)")) ;
            li.click();
        }
    }

    public boolean colorMatch() {
        ArrayList<String> colors = new ArrayList<>();
        colors.addAll(Arrays.asList("#d3d800", "#bf1660", "#ffed00", "#662483", "#189f43", "#e30613", "#78c6bf", "#e84e0e",
                "#0faae3", "#f18800", "#554696", "#fbb900", "#073e59", "#6dc8bf", "#f4a82b", "f58b1f", "#096790", "#0da84f", "#c42968", "#fdf101", "#06889b", "#d5e52f", "#732063", "#d5e52f"));
        List<WebElement> colorList = driver.findElements(By.xpath("//*[@class='color-square']"));
        boolean varaible = false;
        for (WebElement color : colorList) {
            String colorValue = color.getCssValue("background-color");
            String hex = Color.fromString(colorValue).asHex();
            System.out.println(hex);
            if (colors.contains(hex)) {

                varaible = true;
            }

        }
        return varaible;
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
