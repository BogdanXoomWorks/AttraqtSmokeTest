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
import static junit.framework.TestCase.assertTrue;

public class ZoneRulePerformance extends LoadableComponent<ZoneRulePerformance> {
    private static WebDriver driver;

    public ZoneRulePerformance() {
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
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[6]/a[1]")
    private WebElement applyReportButton;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[6]/a[2]")
    private WebElement resetToDefaultButton;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[3]")
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
        assertEquals("Last week (starting Monday)", driver.findElement(By.xpath("//*[@id=\"xw-date-range-param-button\"]")).getText());
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
        assertEquals("http://192.168.1.78:8080/reports/search-terms-report.html", driver.getCurrentUrl());
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
