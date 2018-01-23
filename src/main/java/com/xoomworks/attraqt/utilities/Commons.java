package com.xoomworks.attraqt.utilities;

import com.xoomworks.attraqt.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commons {
    private static WebDriver driver;

    public Commons() {
        driver = BaseTest.getDriver();
    }

    public boolean checkColors(String xpath, String checkColor, String expectedColor) {
        WebElement color = driver.findElement(By.xpath(xpath));
        String backgroundColor = color.getCssValue(checkColor);
        System.out.println("Background Color" + backgroundColor);
        boolean variable = false;
        if (backgroundColor.equals(expectedColor)) {
            variable = true;
        }
        return variable;
    }
}
