package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class CheckOutTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage log;
    AddToCartPage add;
    SearchPage search;
    CheckOutPage check;

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
        registerPage.completeUserData("am@gmail.com", "asd", "123456");
        Assert.assertEquals(registerPage.registerAssertionMessage(), "Your registration completed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registerPage.clickContinueButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registerPage.clickSignOutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        log.EnterUserData("am@gmail.com", "123456");
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
        search.navigateToMacProduct();
        Assert.assertEquals(search.getMacProductAssertionMessage(), "Apple MacBook Pro 13-inch");
    }

    @Test(priority = 6)
    public void addProductToCart() {
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAddToCartAssertionMessage(), "Apple MacBook Pro 13-inch");
    }

    @Test(priority = 7)
    public void navigateToCheckOut() {
        check = new CheckOutPage(driver);
        check.navigateToCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 8)
    public void completeCheckOut() {
        check = new CheckOutPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        check.EnterUserAddress("Daqahlya", "Egypt", "Mit-Ghamr", "1234", "0123456789", "12345");
        check.setShippingMethode();
        check.setPaymentMethode();
        check.setPaymentInformation();
        check.setConfirmOrder();
        Assert.assertEquals(check.confirmOrderAssertionMessage(), "Your order has been successfully processed!");
    }

}
