package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getFistNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstNameInput")));
        return driver.findElement(By.id("firstNameInput"));
    }

    private WebElement getLastNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lastNameInput")));
        return driver.findElement(By.id("lastNameInput"));
    }

    private WebElement getCreateAccountLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Create an account')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'Create an account')]"));
    }

    private WebElement getEmailField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Work email']")));
        return driver.findElement(By.xpath("//input[@placeholder='Work email']"));
    }

    private WebElement getPasswordField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password'] ")));
        return driver.findElement(By.xpath("//input[@type='password'] "));
    }

    private WebElement getCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fw-button[@data-e2e='create-account-button']")));
        return driver.findElement(By.xpath("//fw-button[@data-e2e='create-account-button']"));
    }

    private WebElement getExplicitAgreementCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("explicitAgreement")));
        return driver.findElement(By.id("explicitAgreement"));
    }

    private WebElement getCompanyNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("company")));
        return driver.findElement(By.id("company"));
    }

    private WebElement getCompanyTypeDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("companyType")));
        return driver.findElement(By.id("companyType"));
    }

    private WebElement getNumberOfEmployeesDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("companySize")));
        return driver.findElement(By.id("companySize"));
    }

    private WebElement getTradeTypeDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tradeType")));
        return driver.findElement(By.id("tradeType"));
    }

    private WebElement getPhoneNumberField() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("phone")));
        return driver.findElement(By.id("phone"));
    }

    private WebElement getCompleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fw-button[@data-e2e='create-account-complete']")));
        return driver.findElement(By.xpath("//fw-button[@data-e2e='create-account-complete']"));
    }

    public boolean isAccountAlreadyExistMessage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'An account with that email address already exists.')]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public boolean isSubscriptionAgreementButtonPresent() {
        getCreateAccountLink().click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Subscription Agreement')]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public MainPage signUpBasicAcc(String firstName, String lastName, String email, String password, String companyName, String phoneNumber) {
        getCreateAccountLink().click();
        getFistNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getExplicitAgreementCheckbox().click();
        getCreateAccountButton().click();
        getCompanyNameField().sendKeys(companyName);
        Select companyType = new Select(getCompanyTypeDropdownMenu());
        companyType.selectByValue("SPECIALTY_CONTRACTOR");
        Select tradeType = new Select(getTradeTypeDropdownMenu());
        tradeType.selectByValue("CONCRETE");
        Select numberOfEmployees = new Select(getNumberOfEmployeesDropdownMenu());
        numberOfEmployees.selectByValue("size_1_10");
        getPhoneNumberField().sendKeys(phoneNumber);
        getCompleteButton().click();
        return new MainPage(driver);
    }

    public void signUpExistingAcc(String firstName, String lastName, String email, String password) {
        getCreateAccountLink().click();
        getFistNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getExplicitAgreementCheckbox().click();
        getCreateAccountButton().click();
    }
}

