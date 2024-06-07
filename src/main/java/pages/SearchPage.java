package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchPage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By macProduct = By.id("ui-id-1");
    private final By macProductAssertion = By.xpath("//h1");
    //--------------------------------------------------------------------------------

    public void navigateToMacProduct() {
        driver.findElement(macProduct).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getMacProductAssertionMessage() {
        return driver.findElement(macProductAssertion).getText();
    }
}
