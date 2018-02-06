package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.pageobjects.FacetsPerformance;
import com.xoomworks.attraqt.pageobjects.LandingPage;
import com.xoomworks.attraqt.utilities.Colors;
import com.xoomworks.attraqt.utilities.Commons;
import com.xoomworks.attraqt.utilities.XpathIdentifiers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class FacetsPerformanceTest extends BaseTest {
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static FacetsPerformance facetsPerformance = PageFactory.initElements(driver, FacetsPerformance.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkFonts() {
        landingPage.load();
        facetsPerformance.load();
        assertTrue(facetsPerformance.facetsPerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_SECTION_HEADER_TEXT));
        assertTrue(facetsPerformance.facetsPerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_CONTROLS_CONTAINER));
        assertTrue(facetsPerformance.facetsPerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_HEADER_TEXT));
        assertTrue(facetsPerformance.facetsPerformanceCheckFont(XpathIdentifiers.PRODUCT_PERFORMANCE_TABLE_BODY_TEXT));
        facetsPerformance.isLoaded();
    }

    @Test
    public void checkColors() {
        landingPage.load();
        facetsPerformance.load();
        facetsPerformance.isLoaded();
        //Check header color
        assertTrue(commons.checkColors(XpathIdentifiers.FACETS_PERFORMANCE_SECTION_HEADER, Colors.CSS_BACKGROUND_COLOR, Colors.FP_SECTION_HEADER));
        //Check Table Header Color
        assertTrue(commons.checkColors(XpathIdentifiers.FACETS_PERFORMANCE_TABLE_HEADER, Colors.CSS_COLOR, Colors.TABLE_HEADER));
        //Check Table Header Text Color
        assertTrue(commons.checkColors(XpathIdentifiers.FACETS_PERFORMANCE_TABLE_HEADER_TEXT, Colors.CSS_BORDER_BOTTOM_COLOR, Colors.FP_TABLE_HEADER_TEXT_COLOR));
        //Check Report Header Text Color
        assertTrue(commons.checkColors(XpathIdentifiers.FACETS_PERFORMANCE_REPORT_CONTROLS, Colors.CSS_COLOR, Colors.FP_REPORT_HEADER));
        //Check Color Squares
        assertTrue(facetsPerformance.colorMatch());
    }

    @Test
    public void functionalities() {
        landingPage.load();
        facetsPerformance.load();
        facetsPerformance.isLoaded();
        facetsPerformance.changeSection();
    }
}
