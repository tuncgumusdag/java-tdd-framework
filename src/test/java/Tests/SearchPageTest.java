package Tests;

import Base.Base;
import Page.MainPage;
import org.testng.annotations.Test;

public class SearchPageTest extends Base {

    @Test
    public void searchTest(){
        MainPage mainPage = new MainPage(driver);

        mainPage.searchText("Hello World");
    }
}
