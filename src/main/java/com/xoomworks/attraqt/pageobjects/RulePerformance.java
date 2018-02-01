package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.Alert;
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
import static junit.framework.TestCase.assertTrue;

public class RulePerformance extends LoadableComponent<RulePerformance> {
    private static WebDriver driver;

    public RulePerformance() {
        driver = BaseTest.getDriver();
    }

    private String baseURL = UrlMap.getProperty("base.url");
    private String rulePerformanceURL = baseURL + "reports/zone-rule-performance.html";

    public void load() {
        driver.get(rulePerformanceURL);
    }

    //POM VARIABLES
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div/div")
    private WebElement reportSelection;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[3]/div[4]/a[1]")
    private WebElement applyReportButton;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[3]/div[4]/a[2]")
    private WebElement resetToDefaultButton;
    @FindBy(xpath = "//*[@id=\"xw-date-range-param-button\"]")
    private WebElement dateRangeDropdown;
    @FindBy(xpath = "//*[@id=\"xw-drilldown-page\"]")
    private WebElement drilldownPage;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[1]/label[2]/input")
    private WebElement drilldownSearchTerm;
    @FindBy(xpath = "//*[@id=\"xw-search\"]")
    private WebElement searchTextBox;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[4]")
    private WebElement currencyDropdown;


    public boolean rulePerformanceCheckFont(String xpath) {
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

    public void resetToDefault() {
        drilldownPage.click();
        assertTrue("Search box is not displayed", searchTextBox.isDisplayed());
        searchTextBox.sendKeys("test");
        dateRangeDropdown.click();
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-menu"));
        for (WebElement li : options) {
            if (li.getText().equals("Last week (starting Monday)")) ;
            li.click();
        }
        List<WebElement> currency = driver.findElements(By.xpath("/html/body/div[1]/section/div/div[1]/div[1]/div[4]"));
        for (WebElement li : currency) {
            if (li.getText().equals("EUR")) ;
            li.click();
        }
        resetToDefaultButton.click();
        assertEquals("This month (starting 1st)", driver.findElement(By.xpath("//*[@id=\"xw-date-range-param-button\"]")).getText());
    }

    public void changePage() {
        reportSelection.click();
        List<WebElement> selection = driver.findElements(By.id("xw-main-nav-menu"));
        for (WebElement li : selection) {
            if (li.getText().equals("Search Terms & Misspelled Terms")) ;
            li.click();
        }
        assertEquals("http://192.168.1.244:8080/reports/search-terms-report.html", driver.getCurrentUrl());
    }

    public boolean colorMatch() {
        ArrayList<String> colors = new ArrayList<>();
        colors.addAll(Arrays.asList("#d3d800", "#bf1660", "#ffed00", "#662483", "#189f43", "#e30613", "#78c6bf", "#e84e0e",
                "#0faae3", "#f18800", "#554696", "#fbb900", "#073e59", "#6dc8bf", "#f4a82b", "f58b1f", "#096790", "#0da84f", "#c42968", "#fdf101", "#06889b", "#d5e52f", "#732063", "#d5e52f"));
        List<WebElement> colorList = driver.findElements(By.xpath("//*[@class='xw-rules-checkobx-cell']"));
        boolean varaible = false;
        for (WebElement color : colorList) {
            String colorValue = color.getCssValue("outline-color");
            String hex = Color.fromString(colorValue).asHex();
            System.out.println(hex);
            if (colors.contains(hex)) {

                varaible = true;
            }

        }
        return varaible;
    }

    public void isLoaded() throws Error {
        assertEquals(rulePerformanceURL, driver.getCurrentUrl());
        assertEquals(true, reportSelection.isDisplayed());
        assertEquals(true, applyReportButton.isDisplayed());
        assertEquals(true, resetToDefaultButton.isDisplayed());
        assertEquals(true, dateRangeDropdown.isDisplayed());
        assertEquals(true, drilldownPage.isDisplayed());
        assertEquals(true, dateRangeDropdown.isDisplayed());
    }
}
