package Tests;

import Base.Base;
import Page.MainPage;
import Page.SearchPage;
import org.testng.annotations.Test;

public class SearchPageTest extends Base {

    MainPage mainPage = new MainPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Test
    public void searchTest(){
        String textToSearch = "Hello World";

        mainPage.searchText(textToSearch);
        searchPage.checkSearchBoxText(textToSearch);
        searchPage.areResultsEmpty(false);
    }
}
