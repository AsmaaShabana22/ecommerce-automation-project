package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By loginPageAssertion = By.xpath("//h1");
    private final By eMail = By.id("Email");
    private final By passWord = By.id("Password");
    private final By loginButton = By.xpath("//button[@class='button-1 login-button']");
    private final By LoginAssertionMessage = By.linkText("My account");
    //--------------------------------------------------------------------------------

    public String getLoginPageAssertionMessage() {
        return driver.findElement(loginPageAssertion).getText();
    }

    public void EnterUserData(String email, String password) {
        driver.findElement(eMail).sendKeys(email);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getLoginSuccessfullyAssertionMessage() {
        return driver.findElement(LoginAssertionMessage).getText();
    }
}

