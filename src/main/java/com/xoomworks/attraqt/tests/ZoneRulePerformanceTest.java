package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.pageobjects.LandingPage;
import com.xoomworks.attraqt.pageobjects.ZoneRulePerformance;
import com.xoomworks.attraqt.utilities.Colors;
import com.xoomworks.attraqt.utilities.Commons;
import com.xoomworks.attraqt.utilities.XpathIdentifiers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class ZoneRulePerformanceTest extends BaseTest {
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static ZoneRulePerformance zoneRulePerformance = PageFactory.initElements(driver, ZoneRulePerformance.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkFonts() {
        landingPage.load();
        zoneRulePerformance.load();
        assertTrue(zoneRulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_SECTION_HEADER_TEXT));
        assertTrue(zoneRulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_CONTROLS_CONTAINER));
        assertTrue(zoneRulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_HEADER_TEXT));
        assertTrue(zoneRulePerformance.rulePerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_BODY_TEXT));
        zoneRulePerformance.isLoaded();
    }

    @Test
    public void checkColors() {
        landingPage.load();
        zoneRulePerformance.load();
        //Check section header
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCE_SECTION_HEADER_TEXT, Colors.CSS_BACKGROUND_COLOR, Colors.SECTION_HEADER));
        //Check report controls
        assertTrue(commons.checkColors(XpathIdentifiers.SEARCH_APPLY_REPORT_BUTTON, Colors.CSS_COLOR, Colors.COLOR_REPORT_HEADER));
        //Check Views color
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCE_VIEWS, Colors.CSS_BACKGROUND_COLOR, Colors.VIEWS_HEADER));
        //Check Adds to Basket color
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCE_ADDS_TO_BASKET, Colors.CSS_BACKGROUND_COLOR, Colors.ADDS_TO_BASKET_HEADER));
        //Check Unique purchases color
        assertTrue(commons.checkColors(XpathIdentifiers.PRODUCT_PERFORMANCe_UNIQUE_PURCHASES, Colors.CSS_BACKGROUND_COLOR, Colors.UNIQUE_PURCHASES_HEADER));
        //Check Table contens color
        assertTrue(commons.checkColors(XpathIdentifiers.TABLE_BODY_COLOR, Colors.CSS_COLOR, Colors.TABLE_CONTENS_COLOR));
        zoneRulePerformance.isLoaded();
    }

    @Test
    public void functionalities() {
        landingPage.load();
        zoneRulePerformance.load();
        zoneRulePerformance.isLoaded();
        zoneRulePerformance.changeSection();
        zoneRulePerformance.resetToDefault();
        zoneRulePerformance.changePage();

    }
}
