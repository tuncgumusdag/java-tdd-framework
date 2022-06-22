package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class Base {
    public static WebDriver driver;
    public static String initWebpageUrl = "https://www.bing.com/";

    @BeforeSuite
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.get(initWebpageUrl);
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by){
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {
            System.out.println("Something gone wrong while finding element: " + by);
        }
        return element;
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getAttribute(By by, String attribute) {
        return findElement(by).getAttribute(attribute);
    }

    public void clickElement(By by) {
        waitUntilElementLoad(by);
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        WebElement element = findElement(by);

        element.clear();
        element.sendKeys(text);
    }

    public void sendKeys(By by, String text, Keys key) {
        WebElement element = findElement(by);

        element.clear();
        element.sendKeys(text, key);
    }

    public void sendKeys(By by, Keys key) {
        WebElement element = findElement(by);

        element.clear();
        element.sendKeys(key);
    }

    public boolean isElementFound(By by) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        int exists = driver.findElements(by).size();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return exists != 0;
    }

    public void onHover(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void waitUntilElementLoad(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(findElement(by)));
    }

    public void waitUntilElementDisappears(By by){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOf(findElement(by)));
    }

    public void waitElementStaleness(By by){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        try{
            wait.until(ExpectedConditions.stalenessOf(findElement(by)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
