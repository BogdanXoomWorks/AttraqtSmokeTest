package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static org.openqa.selenium.support.ui.WebDriverWait.*;

public class Dashboard extends LoadableComponent<Dashboard> {
    private static WebDriver driver;
    //private static WebDriver wait;
    private String baseURL = UrlMap.getProperty("base.url");
    private String dashboardURL = baseURL + "dashboard/dashboard.html";

    public Dashboard() {
        driver = BaseTest.getDriver();
    }

    //POM VARIABLES
    @FindBy(xpath = "//*[@id=\"SectionHeader\"]/div[2]")
    private WebElement allReportsSettings;
    @FindBy(xpath = "id(\"SectionHeader\")/div[1]/a[1]")
    private WebElement dashboardReportingButton;
    @FindBy(xpath = "id(\"SectionHeader\")")
    private WebElement sectionHeader;
    //RULE PERFORMANCE
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[1]/div[1]/h1/a")
    private WebElement rulePerformanceButton;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[1]/div[1]/div[2]/div[1]/a")
    private WebElement drilldownPage;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[1]/div[1]/div[2]/div[2]/a")
    private WebElement drilldownSearchTerm;
    @FindBy(xpath = "//*[@id=\"zone-rules\"]/div[1]")
    private WebElement openRulePerformanceReports;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[1]/div[1]/div[1]")
    private WebElement quickSortingRule;
    @FindBy(xpath = "//*[@id=\"highcharts-0\"]")
    private WebElement rulePerformanceChart;
    @FindBy(xpath = "id(\"zone-rules-settings-container\")/h3[1]")
    private WebElement dashboardReportSettingsRulePerformance;
    //PRODUCT PERFORMANCE
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[2]/div[1]/h1/a")
    private WebElement productPerformanceButton;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div/div[2]/div[1]/div")
    private WebElement quickSortingProduct;
    @FindBy(xpath = "//*[@id=\"product-performance\"]/div[2]")
    private WebElement productChartsProductPerformance;
    @FindBy(xpath = "//*[@id=\"product-performance\"]/div[1]")
    private WebElement openProductPerformanceReports;
    @FindBy(xpath = "id(\"product-performance-settings-container\")/h3[1]")
    private WebElement productPerformanceReportSettings;
    //SEARCH/MISSPELLED TERMS REPORT
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[2]/div/div[1]/div[1]/h1[1]/a")
    private WebElement searchTermsButton;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[2]/div/div[1]/div[1]/h1[2]/a")
    private WebElement misspelledSearchTermsButton;
    @FindBy(xpath = "//*[@id=\"search-terms\"]/div[1]")
    private WebElement openSearchTermsReport;
    @FindBy(xpath = "//*[@id=\"search-terms\"]/div[2]")
    private WebElement productChartsSearchTerms;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[2]/div/div[1]/div[1]/div")
    private WebElement quickSortingSearchTerms;
    @FindBy(xpath = "id(\"search-terms-settings-container\")/h3[1]")
    private WebElement searchTermsSettingsContainer;
    //CATEGORIES AND FACETS PERFORMANCE
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[2]/div/div[2]/div[1]/h1/a")
    private WebElement facetsPerformanceButton;
    @FindBy(xpath = "//*[@id=\"facets-performance\"]/div[1]")
    private WebElement openFacetsReport;
    @FindBy(xpath = "//*[@id=\"xw-facets-graph\"]")
    private WebElement facetsPerformanceGraph;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[2]/div/div[2]/div[1]/div/div[1]/a")
    private WebElement firstCategoryFacet;
    @FindBy(xpath = "id(\"facets-performance-settings-container\")/h3[1]")
    private WebElement facetsReportSettingsContainer;

    public void load() {
        driver.get(dashboardURL);
    }

    public boolean dashboardCheckFont(String xpath) {
        WebElement text = driver.findElement(By.xpath(xpath));
        String fontFamily = text.getCssValue("font-family");
        //System.out.println("Font family->" + fontFamily);
        boolean variable = false;
        if (fontFamily.equals("\"Lato\", sans-serif")) {
            variable = true;
        }
        return variable;
    }

    public void rulePerformance() {
        rulePerformanceButton.click();
        assertEquals("http://192.168.1.244:8080/reports/zone-rule-performance.html", driver.getCurrentUrl());
        dashboardReportingButton.click();
        assertEquals("http://192.168.1.244:8080/dashboard/dashboard.html", driver.getCurrentUrl());
        drilldownPage.click();
        assertEquals("http://192.168.1.244:8080/reports/zone-rule-performance.html?drilldown=page", driver.getCurrentUrl());
        dashboardReportingButton.click();
        drilldownSearchTerm.click();
        assertEquals("http://192.168.1.244:8080/reports/zone-rule-performance.html?drilldown=searchterm", driver.getCurrentUrl());
        dashboardReportingButton.click();
        openRulePerformanceReports.click();
        assertEquals(true, dashboardReportSettingsRulePerformance.isDisplayed());
    }

    public void productPerformnce() {
        productPerformanceButton.click();
        assertEquals("http://192.168.1.244:8080/reports/products-report.html", driver.getCurrentUrl());
        dashboardReportingButton.click();
        openProductPerformanceReports.click();
    }

    public void searchTerms() {
        searchTermsButton.click();
        assertEquals("http://192.168.1.244:8080/reports/search-terms-report.html", driver.getCurrentUrl());
        dashboardReportingButton.click();
        misspelledSearchTermsButton.click();
        assertEquals("http://192.168.1.244:8080/reports/misspelled-report.html", driver.getCurrentUrl());
        dashboardReportingButton.click();
        openSearchTermsReport.click();
        assertEquals(true, searchTermsSettingsContainer.isDisplayed());
    }

    public void facetPerformance() {
        facetsPerformanceButton.click();
        assertEquals("http://192.168.1.244:8080/reports/facets-report.html", driver.getCurrentUrl());
        dashboardReportingButton.click();
        openFacetsReport.click();
        assertEquals(true, facetsReportSettingsContainer.isDisplayed());
    }

    public void isLoaded() throws Error {
        assertEquals(dashboardURL, driver.getCurrentUrl());
        assertEquals(true, sectionHeader.isDisplayed());
        assertEquals(true, rulePerformanceButton.isDisplayed());
        assertEquals(true, quickSortingRule.isDisplayed());
        assertEquals(true, rulePerformanceChart.isDisplayed());
        assertEquals(true, productPerformanceButton.isDisplayed());
        assertEquals(true, productChartsSearchTerms.isDisplayed());
        assertEquals(true, searchTermsButton.isDisplayed());
        assertEquals(true, misspelledSearchTermsButton.isDisplayed());
        assertEquals(true, facetsPerformanceButton.isDisplayed());
        assertEquals(true, facetsPerformanceGraph.isDisplayed());
    }
}
