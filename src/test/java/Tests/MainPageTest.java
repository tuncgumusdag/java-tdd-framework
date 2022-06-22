package Tests;

import Base.Base;
import Page.MainPage;
import Page.SearchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTest extends Base {

    MainPage mainPage = new MainPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Test
    public void searchTest() {
        String textToSearch = "Hello World";

        mainPage.searchText(textToSearch);
        searchPage.checkSearchBoxText(textToSearch);
    }

    @Test
    public void checkPageElementsTest() {
        mainPage.checkPageElements();
    }
}
