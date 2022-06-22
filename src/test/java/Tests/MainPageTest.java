package Tests;

import Base.Base;
import Page.MainPage;
import Page.SearchPage;
import org.testng.annotations.Test;

public class MainPageTest extends Base {

    @Test
    public void searchTest() {
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String textToSearch = "Hello World";

        mainPage.searchText(textToSearch);
        searchPage.checkSearchBoxText(textToSearch);
    }
}
