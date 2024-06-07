package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class EmailToFriendTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    SearchPage search;
    LoginPage log;
    EmailToFriendPage email;

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
        registerPage.completeUserData("dd@gmail.com", "asd", "123456");
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
        log.EnterUserData("dd@gmail.com", "123456");
        Assert.assertEquals(log.getLoginSuccessfullyAssertionMessage(), "My account");
    }

    @Test(priority = 4)
    public void SearchForMacProduct() {
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage("mac");
    }

    @Test(priority = 5)
    public void NavigateToMacProduct() {
        search = new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        search.navigateToMacProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(search.getMacProductAssertionMessage(), "Apple MacBook Pro 13-inch");
    }

    @Test(priority = 6)
    public void navigateToSendEmailPage() {
        email = new EmailToFriendPage(driver);
        email.navigateToEmailToFriendPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(email.getEmailToFriendPageAssertionMessage(), "Email a friend");
    }

    @Test(priority = 7)
    public void sendEmailToFriend() {

        email = new EmailToFriendPage(driver);
        email.SendAMessageToAFriend("dd@gmail.com", "My Ecommerce automation testing project");
        Assert.assertEquals(email.getSuccessfulMessageAssertion(), "Your message has been sent.");
    }
}
