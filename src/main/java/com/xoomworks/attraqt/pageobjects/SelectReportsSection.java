package com.xoomworks.attraqt.pageobjects;

import com.xoomworks.attraqt.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectReportsSection extends LoadableComponent<SelectReportsSection> {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public SelectReportsSection() {
        driver = BaseTest.getDriver();
    }

    //POM Variables
    @FindBy(xpath = ".//*[@id='SiteSelect']")
    private WebElement dataCenterDropdown;
    @FindBy(xpath = ".//*[@id='SiteMenu']/li[2]/a")
    private WebElement screwfixEU;
    @FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[2]/ul/li[3]/a")
    private WebElement reportsButton;
    @FindBy(xpath = "//*[@id=\"DruContentLeftSync\"]/div[4]/div[2]/div[1]/a")
    private WebElement mispelledButton;

    public void selectDataCenter() {
        dataCenterDropdown.click();
        screwfixEU.click();
    }

    public void selectReportsSection() {
        reportsButton.click();
        mispelledButton.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ReportTableBody\"]")));
    }

    protected void load() {

    }

    protected void isLoaded() throws Error {

    }
}
