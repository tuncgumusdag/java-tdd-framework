package Page;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {

    protected By txtSearch = By.id("sb_form_q");

    public MainPage(WebDriver driver){
        Base.driver = driver;
    }

    public void searchText(String textToSearch){
        waitElementStaleness(txtSearch);
        waitUntilElementLoad(txtSearch);
        sendKeys(txtSearch, textToSearch, Keys.ENTER);
    }
}
