package tests;

import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LogInTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage log;

    @Test
    public void NavigateToRegisterPage() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.NavigateToRegisterPage();
        Assert.assertEquals(registerPage.RegisterPageAssertion(), "Register");
    }

    @Test(priority = 1)
    public void RegisterNewUser() {
        registerPage = new RegisterPage(driver);
        registerPage.enterUserData("Asmaa", "Shabana", "1", "May", "1988");
        registerPage.completeUserData("ss@gmail.com", "asd", "123456");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(registerPage.registerAssertionMessage(), "Your registration completed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registerPage.clickContinueButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registerPage.clickSignOutButton();
    }


    @Test(priority = 2)
    public void navigateToLoginPage() {
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        log = new LoginPage(driver);
        Assert.assertEquals(log.getLoginPageAssertionMessage(), "Welcome, Please Sign In!");
    }

    @Test(priority = 3)
    public void Login() {
        log = new LoginPage(driver);
        log.EnterUserData("ss@gmail.com", "123456");
        Assert.assertEquals(log.getLoginSuccessfullyAssertionMessage(), "My account");
    }
}
