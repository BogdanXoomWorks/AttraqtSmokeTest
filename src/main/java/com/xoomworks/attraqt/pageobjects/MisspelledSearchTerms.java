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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MisspelledSearchTerms extends LoadableComponent<MisspelledSearchTerms> {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private String baseURL = UrlMap.getProperty("base.url");
    private String mispelledSearchTermsURL = baseURL + "reports/misspelled-report.html";
    public MisspelledSearchTerms() {
        driver = BaseTest.getDriver();
    }

    //POM Variables
    @FindBy(xpath = ".//*[@id='xw-main-nav-button']/span[1]")
    private WebElement mispelledSearchTerms;
    @FindBy(xpath = "//*[@id=\"highcharts-0\"]")
    private WebElement chart;
    @FindBy(xpath = "//*[@id=\"xw-search\"]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"exact-words\"]")
    private WebElement exactWordsButton;
    @FindBy(xpath = "//*[@id=\"contains-words\"]")
    private WebElement thatConatinsButton;
    @FindBy(xpath = ".//*[@id='DruContent']/div/div/div/a[1]")
    private WebElement applyReportButton;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[5]/a[2]")
    private WebElement resetDefaultButton;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[1]")
    private WebElement dateRangeDropdownButton;
    @FindBy(xpath = ".//*[@id='SectionHeader']/a")
    private WebElement searchTermsButton;
    @FindBy(xpath = "//*[@id=\"xw-date-range-param\"]")
    private WebElement dateRangeParameters;

    public void load() {
        driver.get(mispelledSearchTermsURL);
    }

    public boolean misspelledSearcTermscheckFont(String xpath) {
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
        dateRangeDropdownButton.click();
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-menu"));
        for(WebElement li : options){
            if (li.getText().equals("Last week (starting Monday)"));
            li.click();
        }
    }

    public void resetToDefault() {
        resetDefaultButton.click();
    }

    public void goToSearchTerms(){

        searchTermsButton.click();
    }

    public void isLoaded() throws Error {
        assertEquals(mispelledSearchTermsURL, driver.getCurrentUrl());
        assertEquals(true, mispelledSearchTerms.isDisplayed());
        assertEquals(true, chart.isDisplayed());
        assertEquals(true, searchField.isDisplayed());
        assertEquals(true, exactWordsButton.isDisplayed());
        assertEquals(true, thatConatinsButton.isDisplayed());
        assertEquals(true, applyReportButton.isDisplayed());
        assertEquals(true, resetDefaultButton.isDisplayed());
        assertEquals(true, dateRangeDropdownButton.isDisplayed());
        assertEquals(true, searchTermsButton.isDisplayed());
    }
}
