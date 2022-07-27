package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fw-button[@data-e2e='login-email']")));
        return driver.findElement(By.xpath("//fw-button[@data-e2e='login-email']"));
    }

    private WebElement getEmailField(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email-input")));
        return driver.findElement(By.id("email-input"));
    }

    private WebElement getPasswordField(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password-input")));
        return driver.findElement(By.id("password-input"));
    }

    private WebElement getLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fw-button[@data-e2e='signin-with-password']")));
        return driver.findElement(By.xpath("//fw-button[@data-e2e='signin-with-password']"));
    }

    private WebElement getAccountLockedButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Account locked?')]")));
        return driver.findElement(By.xpath("//a[contains(text(),'Account locked?')]"));
    }

    private WebElement getSendUnlockInstructionsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fw-button[@data-e2e='resend-unlock-instructions-btn']")));
        return driver.findElement(By.xpath("//fw-button[@data-e2e='resend-unlock-instructions-btn']"));
    }

    private WebElement getEmailForUnlockAccountField(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("emailInput")));
        return driver.findElement(By.id("emailInput"));
    }


    public boolean isInvalidPasswordErrorMessage() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Invalid password. Try again or click Forgot your password? to reset it.')]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public boolean isYouWillReceiveUnlockInstructionsMessage() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'If your email exists, you will receive an email with instructions about how to unlock your account shortly.')]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public MainPage logInBasicAcc(String email, String password) {
        getEmailField().sendKeys(email);
        getNextButton().click();
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }

    public void loginAccountLockedInstructionsSendMessage(String email) {
        getAccountLockedButton().click();
        getEmailForUnlockAccountField().sendKeys(email);
        getSendUnlockInstructionsButton().click();
    }

}
