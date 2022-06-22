package Page;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends Base {

    protected By txtSearchBox = By.id("sb_form_q");
    protected By icoLogo = By.className("b_logoArea");
    protected By lblAllWeb = By.id("b-scopeListItem-web");
    protected By lblImages = By.id("b-scopeListItem-images");
    protected By lblVideo = By.id("b-scopeListItem-video");
    protected By lblLocal = By.id("b-scopeListItem-local");
    protected By lblNews = By.id("b-scopeListItem-news");
    protected By btnMicrophone = By.xpath("//div[@class='mic_cont icon partner']");
    protected By btnSearchByImage = By.id("sbiarea");
    protected By btnSearch = By.id("sb_search");
    protected By btnClearSearch = By.id("sb_clt");
    protected By lblResultCount = By.className("sb_count");
    protected By lblDate = By.className("fs_label");
    protected By btnSignIn = By.id("id_a");
    protected By btnSettings = By.id("id_sc");
    protected By lblNoResults = By.className("b_no");
    protected By lblSearchResultTitle = By.className("b_title");
    protected By lblTypoRequery = By.id("sp_requery");
    protected By lblTypoRecourse = By.id("sp_recourse");


    public SearchPage(WebDriver driver){
        Base.driver = driver;
    }

    public void checkSearchBoxText(String textToAssert){
        waitUntilElementLoad(txtSearchBox);
        Assert.assertEquals(getAttribute(txtSearchBox, "value"), textToAssert, "Search box text was incorrect.");
    }

    public void searchText(String textToSearch){
        waitElementStaleness(txtSearchBox);
        sendKeys(txtSearchBox, textToSearch, Keys.ENTER);
    }

    public void areResultsEmpty(boolean expected) {
        Assert.assertEquals(getText(lblResultCount).isEmpty(), expected);
        Assert.assertTrue(isElementFound(lblSearchResultTitle));
    }

    public void checkPageElements(){
        waitElementStaleness(icoLogo);
        Assert.assertTrue(isElementFound(txtSearchBox), "Search box was not found.");
        Assert.assertTrue(isElementFound(icoLogo), "Logo was not found.");
        Assert.assertTrue(isElementFound(lblAllWeb), "Web tab was not found.");
        Assert.assertTrue(isElementFound(lblImages), "Image tab was not found.");
        Assert.assertTrue(isElementFound(lblVideo), "Video tab was not found.");
        Assert.assertTrue(isElementFound(lblLocal), "Local tab was not found.");
        Assert.assertTrue(isElementFound(lblNews), "News tab was not found.");
        Assert.assertTrue(isElementFound(btnMicrophone), "Microphone button was not found.");
        Assert.assertTrue(isElementFound(btnSearchByImage), "Search by image button was not found.");
        Assert.assertTrue(isElementFound(btnSearch), "Search button was not found.");
        Assert.assertTrue(isElementFound(lblResultCount), "Results count was not found.");
        Assert.assertTrue(isElementFound(lblDate), "Date filter was not found.");
        Assert.assertTrue(isElementFound(btnSignIn), "Sign in button was not found.");
        Assert.assertTrue(isElementFound(btnSettings), "Settings button was not found.");
    }

    public void clickClearSearchBoxButton(){
        clickElement(txtSearchBox);
        Assert.assertTrue(isElementFound(btnClearSearch), "Clear search button was not found.");
        clickElement(btnClearSearch);
    }

    public void isSearchBoxEmpty(boolean expected){
        Assert.assertEquals(getAttribute(txtSearchBox, "value").isEmpty(), expected);
    }

    public void checkNoResultsPageElements(){
        Assert.assertFalse(isElementFound(lblResultCount), "Search displayed a result count when it was expected not to.");
        Assert.assertTrue(isElementFound(lblNoResults), "No results text was not found.");
        Assert.assertFalse(isElementFound(lblSearchResultTitle), "Search found a result title when there should have been no search results.");
    }

    public void checkTypoRecognitionPrompt(){
        Assert.assertTrue(isElementFound(lblTypoRequery), "Typo requery prompt was not found.");
        Assert.assertTrue(getText(lblTypoRequery).contains("Including results for"));
        Assert.assertTrue(isElementFound(lblTypoRecourse), "Typo recourse prompt was not found.");
        Assert.assertTrue(getText(lblTypoRecourse).contains("Do you want results only for"));
    }
}
