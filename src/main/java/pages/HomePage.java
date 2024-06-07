package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By registerButton = By.linkText("Register");
    private final By contactUs = By.linkText("Contact us");
    private final By loginButton = By.linkText("Log in");
    private final By searchBox = By.id("small-searchterms");
    //--------------------------------------------------------------------------------

    public RegisterPage NavigateToRegisterPage() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public ContactUsPage navigateToContactUs() {
        driver.findElement(contactUs).click();
        return new ContactUsPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public SearchPage navigateToSearchPage(String product) {
        driver.findElement(searchBox).sendKeys(product);
        return new SearchPage(driver);
    }
}
