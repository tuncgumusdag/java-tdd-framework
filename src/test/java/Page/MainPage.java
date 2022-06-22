package Page;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage extends Base {

    protected By txtSearchBox = By.id("sb_form_q");
    protected By icoLogo = By.id("bLogo");
    protected By lblImages = By.id("images");
    protected By lblVideos = By.id("video");
    protected By lblTranslate = By.id("translate");
    protected By lblMoreOptions = By.id("dots_overflow_menu_container");
    protected By lblLanguage = By.className("sw_lang");
    protected By lblSignIn = By.id("id_s");
    protected By btnAccount = By.id("id_a");
    protected By btnSettings = By.id("id_sc");
    protected By btnMicrophone = By.xpath("//div[@class='mic_cont icon']");
    protected By btnCamera = By.xpath("//div[@class='camera icon ']");
    protected By btnSearch = By.id("search_icon");

    public MainPage(WebDriver driver){
        Base.driver = driver;
    }

    public void searchText(String textToSearch){
        waitElementStaleness(txtSearchBox);
        sendKeys(txtSearchBox, textToSearch, Keys.ENTER);
    }

    public void checkPageElements(){
        String textToCheck = "Hello World!";
        waitElementStaleness(txtSearchBox);
        Assert.assertTrue(isElementFound(txtSearchBox), "Search box was not found.");
        Assert.assertTrue(isElementFound(icoLogo), "Logo was not found.");
        Assert.assertTrue(isElementFound(lblImages), "Images tab was not found.");
        Assert.assertTrue(isElementFound(lblVideos), "Videos tab was not found.");
        Assert.assertTrue(isElementFound(lblTranslate), "Translate tab was not found.");
        Assert.assertTrue(isElementFound(lblMoreOptions), "More options tab was not found.");
        Assert.assertTrue(isElementFound(lblLanguage), "Change language tab was not found.");
        Assert.assertTrue(isElementFound(lblSignIn), "Sign In tab was not found.");
        Assert.assertTrue(isElementFound(btnAccount), "Account tab was not found.");
        Assert.assertTrue(isElementFound(btnSettings), "Settings tab was not found.");
        Assert.assertTrue(isElementFound(btnMicrophone), "Microphone button found.");
        Assert.assertTrue(isElementFound(btnCamera), "Camera button was not found.");
        Assert.assertTrue(isElementFound(btnSearch), "Search button was not found.");

        sendKeys(txtSearchBox, textToCheck);
        Assert.assertEquals(getAttribute(txtSearchBox, "value"), textToCheck, "Search box text was incorrect.");
    }
}
