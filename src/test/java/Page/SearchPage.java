package Page;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends Base {

    protected By txtSearchBox = By.id("sb_form_q");
    protected By lblResultCount = By.className("sb_count");

    public SearchPage(WebDriver driver){
        Base.driver = driver;
    }

    public void checkSearchBoxText(String textToAssert){
        waitUntilElementLoad(txtSearchBox);
        Assert.assertEquals(getAttribute(txtSearchBox, "value"), textToAssert, "Search box text was incorrect.");
    }

    public void areResultsEmpty(boolean expected) {
        Assert.assertEquals(getText(lblResultCount).isEmpty(), expected);
    }
}
