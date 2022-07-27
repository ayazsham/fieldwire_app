package helper;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFabric {
    public static WebDriver getDriver(BrowserType browserType) throws NoSuchMethodException {
        switch (browserType){

            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new NoSuchMethodException("Browser not exist");
        }

    }

    private static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","geckodriver");
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1000");
        options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver","chromedriver");
        return new ChromeDriver(options);
    }
}
