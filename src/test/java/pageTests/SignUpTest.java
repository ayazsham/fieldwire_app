package pageTests;

import helper.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SignUpPage;

import java.net.MalformedURLException;

public class SignUpTest extends BaseTest{

    @Test
    public void signUp_basicAccount_successfulSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        String newEmail = TestDataGenerator.randomString(4);
        signUpPage.signUpBasicAcc("Test", "Test", "ayazshamqa+"+newEmail+"@gmail.com", "Test123!", "Test", "8189380030");
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAccountDropdownMenuButton());
    }

    @Test
    public void signUp_accountAlreadyExistMessage() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpExistingAcc("Test", "Test", "ayazshamqa@gmail.com", "Test123!");
        Assert.assertTrue(signUpPage.isAccountAlreadyExistMessage());
    }

    @Test
    public void signUp_subscriptionAgreementPageIsPresent() throws MalformedURLException {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickOnSubscriptionAgreementAtSignUp();
        Assert.assertTrue(signUpPage.isSubscriptionAgreementPresent());
    }

}
