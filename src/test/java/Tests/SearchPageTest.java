package Tests;

import Base.Base;
import Page.HomePage;
import Page.SearchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchPageTest extends Base {

    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);
    String textToSearch = "Hello World";

    @BeforeTest
    public void beforeTest(){
        homePage.searchText(textToSearch);
    }

    @Test
    public void searchTest(){
        searchPage.checkSearchBoxText(textToSearch);
        searchPage.areResultsEmpty(false);

    }

    @Test
    public void checkPageElementsTest(){
        searchPage.checkPageElements();
    }

    @Test
    public void clearSearchBoxWithClearSearchButtonTest(){
        searchPage.clickClearSearchBoxButton();
        searchPage.isSearchBoxEmpty(true);
    }

    @Test
    public void searchWithNoResultsTest(){
        searchPage.searchText("pqhxaxada");
        searchPage.checkNoResultsPageElements();
    }

    @Test
    public void searchWithTypoTest(){
        searchPage.searchText("ello World");
        searchPage.checkTypoRecognitionPrompt();
    }
}
