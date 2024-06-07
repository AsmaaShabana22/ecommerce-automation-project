package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddToCartPage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private By addToCartButton = By.id("add-to-cart-button-4");
    private By viewShoppingCart = By.linkText("shopping cart");
    private By addToCartAssertion = By.linkText("Apple MacBook Pro 13-inch");
    //--------------------------------------------------------------------------------

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(viewShoppingCart).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public String getAddToCartAssertionMessage() {
        return driver.findElement(addToCartAssertion).getText();
    }
}
