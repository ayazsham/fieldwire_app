package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDropdownMenuButton() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-e2e='profile-menu']")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }
}
