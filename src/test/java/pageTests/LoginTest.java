package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTest extends BaseTest{

    @Test
    public void login_basicAccount_successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInBasicAcc("ayazshamqa@gmail.com", "Test123!");
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAccountDropdownMenuButton());
    }

    @Test
    public void login_basicAccWrongPassword_errorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInBasicAcc("ayazshamqa@gmail.com", "Test1234");
        Assert.assertTrue(loginPage.isInvalidPasswordErrorMessage());
    }

    @Test
    public void login_accountLocked_unlockInstructionsSentMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccountLockedInstructionsSendMessage("ayazshamqa+1@gmail.com");
        Assert.assertTrue(loginPage.isYouWillReceiveUnlockInstructionsMessage());
    }

}
