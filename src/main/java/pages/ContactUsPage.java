package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By contactUsPageAssertion = By.xpath("//p");
    private final By nameTxt = By.id("FullName");
    private final By emailTxt = By.id("Email");
    private final By messageTxt = By.id("Enquiry");
    private final By submitButton = By.name("send-email");
    private final By contactUsAssertionMessage = By.xpath("//div[@class='result']");
    //--------------------------------------------------------------------------------

    public String getContactUsPageAssertionMessage() {
        return driver.findElement(contactUsPageAssertion).getText();
    }

    public void ContactUs(String name, String email, String message) {
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(messageTxt).sendKeys(message);
        driver.findElement(submitButton).click();
    }

    public String getContactUsAssertionMessage() {
        return driver.findElement(contactUsAssertionMessage).getText();
    }
}
