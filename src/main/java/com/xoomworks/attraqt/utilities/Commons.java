package com.xoomworks.attraqt.utilities;

import com.xoomworks.attraqt.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


}
