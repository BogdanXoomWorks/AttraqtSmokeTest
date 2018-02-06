package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.pageobjects.LandingPage;
import com.xoomworks.attraqt.pageobjects.RulePerformance;
import com.xoomworks.attraqt.utilities.Colors;
import com.xoomworks.attraqt.utilities.Commons;
import com.xoomworks.attraqt.utilities.XpathIdentifiers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class RulePerformanceTest extends BaseTest {
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static RulePerformance rulePerformance = PageFactory.initElements(driver, RulePerformance.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkFonts() {
        landingPage.load();
        rulePerformance.load();
        assertTrue(rulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_SECTION_HEADER_TEXT));
        assertTrue(rulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_CONTROLS_CONTAINER));
        assertTrue(rulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_HEADER_TEXT));
        assertTrue(rulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_BODY_TEXT));
        rulePerformance.isLoaded();
    }

    @Test
    public void checkColors() {
        landingPage.load();
        rulePerformance.load();
        //Check Square colors
        assertTrue(rulePerformance.colorMatch());
        //Check section header
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCE_SECTION_HEADER_TEXT, Colors.CSS_BACKGROUND_COLOR, Colors.SECTION_HEADER));
        //Check report controls
        assertTrue(commons.checkColors(XpathIdentifiers.RULE_PERFORMANCE_APPLY_REPORT_BUTTON, Colors.CSS_COLOR, Colors.COLOR_REPORT_HEADER));
        //Check Table Header color
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_HEADER, Colors.CSS_COLOR, Colors.TABLE_HEADER));
        //Check Table contens color
        assertTrue(commons.checkColors(XpathIdentifiers.TABLE_BODY_COLOR, Colors.CSS_COLOR, Colors.TABLE_CONTENS_COLOR));
        rulePerformance.isLoaded();
    }

    @Test
    public void functionalities() {
        landingPage.load();
        rulePerformance.load();
        rulePerformance.isLoaded();
        rulePerformance.changeSection();
        rulePerformance.resetToDefault();
        rulePerformance.changePage();
    }
}
