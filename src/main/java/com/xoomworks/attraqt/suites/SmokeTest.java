package com.xoomworks.attraqt.suites;


import com.xoomworks.attraqt.tests.MisspelledSearchTermsTest;
import com.xoomworks.attraqt.tests.SearchTermsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MisspelledSearchTermsTest.class,
        SearchTermsTest.class
})
public class SmokeTest {
}