package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    //ToDo add driver
    private final WebDriver driver;

    Select select;

    //ToDo create constructor and initiate driver in constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By assertionMessage = By.xpath("//h1[text()='Register']");
    private final By genderButton = By.id("gender-female");
    private final By first_Name = By.id("FirstName");
    private final By last_Name = By.id("LastName");
    private final By dateOfBirthDay = By.name("DateOfBirthDay");
    private final By dateOfBirthMonth = By.name("DateOfBirthMonth");
    private final By dateOfBirthYear = By.name("DateOfBirthYear");
    private final By eMail = By.id("Email");
    private final By company_Name = By.id("Company");
    private final By passWord = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By registerAssertion = By.xpath("//div[@class='result']");
    private final By continueButton = By.xpath("//a[@class='button-1 register-continue-button']");
    private final By signOutButton = By.xpath("//a[normalize-space()='Log out']");
    //--------------------------------------------------------------------------------

    public String RegisterPageAssertion() {
        return driver.findElement(assertionMessage).getText();
    }

    public void enterUserData(String firstName, String lastName, String day, String month, String year) {
        driver.findElement(genderButton).click();
        driver.findElement(first_Name).sendKeys(firstName);
        driver.findElement(last_Name).sendKeys(lastName);
        select = new Select(driver.findElement(dateOfBirthDay));
        select.selectByVisibleText(day);
        select = new Select(driver.findElement(dateOfBirthMonth));
        select.selectByVisibleText(month);
        select = new Select(driver.findElement(dateOfBirthYear));
        select.selectByVisibleText(year);
    }

    public void completeUserData(String email, String company, String password) {
        driver.findElement(eMail).sendKeys(email);
        driver.findElement(company_Name).sendKeys(company);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(confirmPassword).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public String registerAssertionMessage() {
        return driver.findElement(registerAssertion).getText();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickSignOutButton() {
        driver.findElement(signOutButton).click();
    }
}
