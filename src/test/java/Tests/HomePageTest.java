package Tests;

import Base.Base;
import Page.HomePage;
import Page.SearchPage;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Test
    public void searchTest() {
        String textToSearch = "Hello World";

        homePage.searchText(textToSearch);
        searchPage.checkSearchBoxText(textToSearch);
    }

    @Test
    public void checkPageElementsTest() {
        homePage.checkPageElements();
    }
}
