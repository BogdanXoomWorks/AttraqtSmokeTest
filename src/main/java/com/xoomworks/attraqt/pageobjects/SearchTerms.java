package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SearchTerms extends LoadableComponent<SearchTerms> {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private String baseURL = UrlMap.getProperty("base.url");
    public String searchTermsURL = baseURL + "reports/search-terms-report.html";

    public SearchTerms() {
        driver = BaseTest.getDriver();
    }

    public void load() {
        driver.get(searchTermsURL);
    }

    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[3]")
    private WebElement searchTermsDropDown;
    @FindBy(xpath = ".//*[@id='SectionHeader']/a")
    private WebElement misspelledSearchTermsButton;
    @FindBy(xpath = ".//*[@id='DruContent']/div[1]/div[1]/div[1]/label[1]/span")
    private WebElement showOnlyConversions;
    @FindBy(xpath = ".//*[@id='xw-select-conversions']")
    private WebElement tickShowOnlyConversions;
    @FindBy(xpath = ".//*[@id='DruContent']/div[1]/div[1]/div[1]/label[2]/span")
    private WebElement includeMinMaxResults;
    @FindBy(xpath = "//*[@id=\"xw-select-minmax\"]")
    private WebElement tickIncludeMinMaxResults;
    @FindBy(xpath = ".//*[@id='DruContent']/div/div/div/a[1]")
    private WebElement applyReportButton;
    @FindBy(xpath = ".//*[@id='DruContent']/div/div/div/a[2]")
    private WebElement resetToDefaultButton;
    @FindBy(xpath = ".//*[@id='DruContent']/div/div/div/div/label[1]")
    private WebElement exactWords;
    @FindBy(xpath = ".//*[@id='search-terms-report']/thead/tr/th[4]")
    private WebElement averageResults; //Used also for conversion functionality
    @FindBy(xpath = ".//*[@id='search-terms-report']/tbody/tr/td")
    private WebElement dataTableSearchTerms;
    @FindBy(xpath = "//*[@id=\"highcharts-10\"]")
    private WebElement searchTermsChart;
    @FindBy(xpath = ".//*[@id='search-terms-report']/thead/tr/th[5]")
    private WebElement minResults;
    @FindBy(xpath = ".//*[@id='search-terms-report']/thead/tr/th[6]")
    private WebElement maxResults;

    public boolean searchTermscheckFont(String xpath) {
        WebElement text = driver.findElement(By.xpath(xpath));
        String fontFamily = text.getCssValue("font-family");
        System.out.println("Font family->" + fontFamily);
        boolean variable = false;
        if (fontFamily.equals("\"Lato\", sans-serif")) {
            variable = true;
        }
        return variable;
    }

    public void changeDateRange() {
        searchTermsDropDown.click();
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-menu"));
        for (WebElement li : options) {
            if (li.getText().equals("Last week (starting Monday)")) ;
            li.click();
        }
    }

    public boolean showOnlyConversionsFunctionality() {
        tickShowOnlyConversions.click();
        boolean visible = averageResults.isDisplayed();
        System.out.println(visible);
        return visible;
    }

    public void includeMinandMaxResults() {
        tickShowOnlyConversions.click();
        tickIncludeMinMaxResults.click();
        assertEquals(true, minResults.isDisplayed());
        assertEquals(true, maxResults.isDisplayed());
    }

    public void isLoaded() throws Error {
        assertEquals(searchTermsURL, driver.getCurrentUrl());
        assertEquals(true, misspelledSearchTermsButton.isDisplayed());
        assertEquals(true, showOnlyConversions.isDisplayed());
        assertEquals(true, tickShowOnlyConversions.isDisplayed());
        assertEquals(true, includeMinMaxResults.isDisplayed());
        assertEquals(true, tickIncludeMinMaxResults.isDisplayed());
        assertEquals(true, applyReportButton.isDisplayed());
        assertEquals(true, resetToDefaultButton.isDisplayed());
        assertEquals(true, exactWords.isDisplayed());
        assertEquals(true, dataTableSearchTerms.isDisplayed());
        assertEquals(true, searchTermsChart.isDisplayed());
    }
}
