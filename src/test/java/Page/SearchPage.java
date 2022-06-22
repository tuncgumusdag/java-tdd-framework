package Page;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends Base {

    protected By txtSearchBox = By.id("sb_form_q");

    public SearchPage(WebDriver driver){
        Base.driver = driver;
    }

    public void checkSearchBoxText(String textToAssert){
        waitUntilElementLoad(txtSearchBox);
        Assert.assertEquals(getAttribute(txtSearchBox, "value"), textToAssert, "Search box text was incorrect.");
    }
}
