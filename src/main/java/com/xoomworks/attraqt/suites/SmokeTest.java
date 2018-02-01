package com.xoomworks.attraqt.suites;


import com.xoomworks.attraqt.pageobjects.FacetsPerformance;
import com.xoomworks.attraqt.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MisspelledSearchTermsTest.class,
        SearchTermsTest.class,
        ProductPerformanceTest.class,
        RulePerformanceTest.class,
        FacetsPerformanceTest.class,
        DashboardTest.class
})
public class SmokeTest {
}