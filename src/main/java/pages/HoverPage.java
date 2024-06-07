package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverPage {

    //ToDo add driver
    private final WebDriver driver;


    Actions actions;
    WebDriverWait wait;

    //ToDo create constructor and initiate driver in constructor
    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By computers = By.xpath("//a[@href='/computers']");
    private final By desktops = By.xpath("//a[@href='/desktops']");
    private final By computersAssertion = By.xpath("//h1");
    //

    private final By electronics = By.xpath("//a[@href='/electronics']");
    private final By cell_phones = By.xpath("//a[@href='/cell-phones']");
    private final By electronicsAssertion = By.xpath("//h1[text()='Cell phones']");
    //

    private final By apparel = By.xpath("//a[@href='/apparel']");
    private final By shoes = By.xpath("//a[@href='/shoes']");
    private final By apparelAssertion = By.xpath("//h1[text()='Shoes']");
    //--------------------------------------------------------------------------------

    public void HoverOverApparel() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(apparel)).perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoes)));
        actions.moveToElement(driver.findElement(shoes)).click().perform();
    }

    public String getApparelAssertionMessage() {
        return driver.findElement(apparelAssertion).getText();
    }

    public void HoverOverComputers() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(computers)).perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(desktops)));
        actions.moveToElement(driver.findElement(desktops)).click().perform();
    }

    public String getComputersAssertionMessage() {
        return driver.findElement(computersAssertion).getText();
    }

    public void HoverOverElectronics() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(electronics)).perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cell_phones)));
        actions.moveToElement(driver.findElement(cell_phones)).click().perform();
    }

    public String getElectronicsAssertionMessage() {
        return driver.findElement(electronicsAssertion).getText();
    }
}
