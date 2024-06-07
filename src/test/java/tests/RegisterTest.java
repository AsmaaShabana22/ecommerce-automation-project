package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

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
        registerPage.enterUserData("Asmaa", "Shabana", "11", "June", "1988");
        registerPage.completeUserData("ab@gmail.com", "asd", "123456");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(registerPage.registerAssertionMessage(), "Your registration completed");
        registerPage.clickContinueButton();
    }
}
