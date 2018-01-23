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

public class SearchTermsTest extends BaseTest{
    private static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class).get();
    private static SearchTerms searchTerms = PageFactory.initElements(driver, SearchTerms.class);
    private static Commons commons = PageFactory.initElements(driver, Commons.class);

    @Test
    public void checkSearchTermsFonts(){
        landingPage.load();
        searchTerms.load();
        assertTrue(searchTerms.searchTermscheckFont(XpathIdentifiers.SEARCH_APPLY_REPORT_BUTTON));
        assertTrue(searchTerms.searchTermscheckFont(XpathIdentifiers.SEARCH_AVERAGE_RESULTS));
        assertTrue(searchTerms.searchTermscheckFont(XpathIdentifiers.SEARCH_MISSPELLED_SEARCH_TERMS_BUTTON));
        assertTrue(searchTerms.searchTermscheckFont(XpathIdentifiers.SEARCH_TABLE_DATA));
        assertTrue(searchTerms.searchTermscheckFont(XpathIdentifiers.SEARCH_TERMS_HEADER));
        searchTerms.isLoaded();
    }
    @Test
    public void checkColors(){
        landingPage.load();
        searchTerms.load();
        //Check header color
        assertTrue(commons.checkColors(XpathIdentifiers.BG_COLOR_MISSPELLED_SEARCH_TERMS_SECTION_HEADER, Colors.CSS_BACKGROUND_COLOR, Colors.SECTION_HEADER));
        //Check Table Columns Font Color
        assertTrue(commons.checkColors(XpathIdentifiers.SEARCH_AVERAGE_RESULTS,Colors.CSS_BORDER_BOTTOM_COLOR, Colors.COLOR_MISSPELLED_SEARCH_TERMS_FONT_COLOR));
        //Check Table Header Background Color
        assertTrue(commons.checkColors(XpathIdentifiers.SEARCH_TABLE_HEADER,Colors.CSS_COLOR, Colors.SEARCH_TABLE_HEADER_COLOR));
        //Check Color for Report Controls
        assertTrue(commons.checkColors(XpathIdentifiers.SEARCH_APPLY_REPORT_BUTTON, Colors.CSS_COLOR, Colors.COLOR_REPORT_HEADER));
    }
    @Test
    public void checkSearchTermsFunctionlaity(){
        landingPage.load();
        searchTerms.load();
        searchTerms.changeDateRange();
        searchTerms.showOnlyConversionsFunctionality();
        searchTerms.includeMinandMaxResults();
    }
}
