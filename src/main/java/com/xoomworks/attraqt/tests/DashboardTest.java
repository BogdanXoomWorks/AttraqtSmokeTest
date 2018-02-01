package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.pageobjects.Dashboard;
import com.xoomworks.attraqt.pageobjects.LandingPage;
import com.xoomworks.attraqt.utilities.Commons;
import com.xoomworks.attraqt.utilities.XpathIdentifiers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class DashboardTest extends BaseTest {
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkFont() {
        landingPage.load();
        dashboard.load();
        assertTrue(dashboard.dashboardCheckFont(XpathIdentifiers.DASHBOARD_RULE_PERFORMANCE));
        assertTrue(dashboard.dashboardCheckFont(XpathIdentifiers.DASHBOARD_PRODUCT_PERFORMANCE));
        assertTrue(dashboard.dashboardCheckFont(XpathIdentifiers.DASHBOARD_SEARCH_TERMS));
        assertTrue(dashboard.dashboardCheckFont(XpathIdentifiers.DASHBOARD_FACET_PERFORMANCE));
        assertTrue(dashboard.dashboardCheckFont(XpathIdentifiers.DASHBOARD_SECTION_HEADER));
        dashboard.isLoaded();
    }

    @Test
    public void checkFunctionalities() {
        landingPage.load();
        dashboard.load();
        dashboard.isLoaded();
        dashboard.rulePerformance();
        dashboard.productPerformnce();
        dashboard.searchTerms();
        dashboard.facetPerformance();
    }
}
