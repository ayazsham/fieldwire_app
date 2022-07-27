package pageTests;

import enums.BrowserType;
import helper.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void startUp() throws NoSuchMethodException {
        //headless run
       driver = BrowserFabric.getDriver(BrowserType.CHROME);
       driver.get("http://app.fieldwire.com");

        //will run in Chrome browser
//        System.setProperty("webdriver.chrome.driver","chromedriver");
//        driver = new ChromeDriver();
//        driver.get("http://app.fieldwire.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
