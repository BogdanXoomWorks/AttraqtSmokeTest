package com.xoomworks.attraqt.suites;


import com.xoomworks.attraqt.pageobjects.ProductPerformance;
import com.xoomworks.attraqt.tests.MisspelledSearchTermsTest;
import com.xoomworks.attraqt.tests.ProductPerformanceTest;
import com.xoomworks.attraqt.tests.SearchTermsTest;
import com.xoomworks.attraqt.tests.ZoneRulePerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MisspelledSearchTermsTest.class,
        SearchTermsTest.class,
        ProductPerformanceTest.class,
        ZoneRulePerformanceTest.class
})
public class SmokeTest {
}