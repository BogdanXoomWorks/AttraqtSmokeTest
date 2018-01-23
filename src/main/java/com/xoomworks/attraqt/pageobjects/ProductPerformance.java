package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import com.xoomworks.attraqt.utilities.UrlMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ProductPerformance extends LoadableComponent<ProductPerformance> {
    private static WebDriver driver;
    public ProductPerformance(){driver = BaseTest.getDriver();}
    private String baseURL = UrlMap.getProperty("base.url");
    private String productPerformanceURL = baseURL + "reports/products-report.html";
    public void load() {
    driver.get(productPerformanceURL);
    }

    //POM Variables
    @FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[6]/a[1]")
    private WebElement applyReportButton;
    @FindBy (xpath = "/html/body/div[1]/section/div/div[1]/div[1]/div[6]/a[2]")
    private WebElement resetToDefaultButton;
    @FindBy(xpath = "//*[@id=\"xw-number-entries\"]")
    private WebElement numberOfItems;
    @FindBy(xpath = "//*[@id=\"DruContent\"]/div[1]/div[1]/div[1]")
    private WebElement dateRangeMenu;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div[1]/div/table/thead/tr")
    private WebElement tableHeader;
    @FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div[1]/div/table/tbody/tr[1]/td[10]/a")
    private WebElement tableIcon;
    @FindBy(xpath = "//*[@id=\"highcharts-0\"]")
    private WebElement tableChart;

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
    public void changeSection(){
     dateRangeMenu.click();
        List<WebElement> options = driver.findElements(By.id("xw-date-range-param-menu"));
        for(WebElement li : options){
            if (li.getText().equals("Last week (starting Monday)"));
            li.click();
        }
        assertEquals("Last week (starting Monday)", driver.findElement(By.xpath("//*[@id=\"xw-date-range-param-button\"]")).getText());
    }
    public void restToDefault(){
        resetToDefaultButton.click();
        assertEquals("This month (starting 1st)", driver.findElement(By.xpath("//*[@id=\"xw-date-range-param-button\"]")).getText());
    }
    public void isLoaded() throws Error {
    assertEquals(productPerformanceURL, driver.getCurrentUrl());
    assertEquals(true, applyReportButton.isDisplayed());
    assertEquals(true, resetToDefaultButton.isDisplayed());
    assertEquals(true, numberOfItems.isDisplayed());
    assertEquals(true, dateRangeMenu.isDisplayed());
    assertEquals(true, tableHeader.isDisplayed());
    assertEquals(true, tableIcon.isDisplayed());
    assertEquals(true, tableChart.isDisplayed());
    }
}
