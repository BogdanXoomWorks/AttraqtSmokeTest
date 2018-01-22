package com.xoomworks.attraqt.tests;

import com.xoomworks.attraqt.pageobjects.LandingPage;
import com.xoomworks.attraqt.pageobjects.MisspelledSearchTerms;
import com.xoomworks.attraqt.pageobjects.SearchTerms;
import com.xoomworks.attraqt.utilities.Colors;
import com.xoomworks.attraqt.utilities.Commons;
import com.xoomworks.attraqt.utilities.XpathIdentifiers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MisspelledSearchTermsTest extends BaseTest {
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static MisspelledSearchTerms misspelledSearchTerms = PageFactory.initElements(driver, MisspelledSearchTerms.class);
    private static SearchTerms searchTerms = PageFactory.initElements(driver, SearchTerms.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkFonts(){
        landingPage.load();
        misspelledSearchTerms.load();
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISPELLED_SEARCH_TERMS));
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISSPELLED_APPLY_REPORT_BUTTON));
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISSPELLED_CORRECTED_TO));
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISSPELLED_DASHBOARD_HEADER_BUTTON));
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISSPELLED_SEARCH_TERMS_HEADER_BUTTON));
        assertTrue(misspelledSearchTerms.misspelledSearcTermscheckFont(XpathIdentifiers.MISSPELLED_TABLE_DATA));
        misspelledSearchTerms.isLoaded();
    }
    @Test
    public void checkColors() {
        landingPage.load();
        misspelledSearchTerms.load();
        //Check Header Color
        assertTrue(commons.checkColors(XpathIdentifiers.BG_COLOR_MISSPELLED_SEARCH_TERMS_SECTION_HEADER,Colors.CSS_BACKGROUND_COLOR, Colors.SECTION_HEADER));
        //Check Table Columns Font Color
       assertTrue(commons.checkColors(XpathIdentifiers.COLOR_MISSPELLED_SEARCH_TERMS_FONT_COLOR,Colors.CSS_BORDER_BOTTOM_COLOR, Colors.COLOR_MISSPELLED_SEARCH_TERMS_FONT_COLOR));
        //Check Table Header Background Color
        assertTrue(commons.checkColors(XpathIdentifiers.MISSPELLED_TABLE_HEADER,Colors.CSS_COLOR, Colors.SEARCH_TABLE_HEADER_COLOR));
        //Check Color for Report Controls
        assertTrue(commons.checkColors(XpathIdentifiers.SEARCH_APPLY_REPORT_BUTTON, Colors.CSS_COLOR, Colors.COLOR_REPORT_HEADER));
    }
    @Test
    public void checkFunctionality(){
        landingPage.load();
        misspelledSearchTerms.load();
        misspelledSearchTerms.resetToDefault();
        //misspelledSearchTerms.changeDateRange();
        //assertTrue("Date range was not changed", driver.findElement(By.xpath(".//*[@id='xw-main-nav-button']/span[1]")).isDisplayed());
        misspelledSearchTerms.goToSearchTerms();
        assertEquals(searchTerms.searchTermsURL, driver.getCurrentUrl());

    }
}
