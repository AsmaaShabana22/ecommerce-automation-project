package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    //ToDo add driver
    private final WebDriver driver;

    //ToDo create constructor and initiate driver in constructor
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo Adding Locators
    //--------------------------------------------------------------------------------
    private final By agreeServices = By.id("termsofservice");
    private final By checkOutButton = By.id("checkout");
    private final By countryName = By.xpath("//select[@data-trigger='country-select']");
    private final By exactCountry = By.xpath("//option[normalize-space()='United States']");
    private final By stateName = By.id("BillingNewAddress_StateProvinceId");
    private final By exactState = By.xpath("//option[normalize-space()='Alabama']");
    private final By cityName = By.id("BillingNewAddress_City");
    private final By addressOne = By.id("BillingNewAddress_Address1");
    private final By addressTwo = By.id("BillingNewAddress_Address2");
    private final By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNum = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumber = By.id("BillingNewAddress_FaxNumber");
    private final By continueButton = By.name("save");
    private final By shippingMethode = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private final By paymentMethode = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By paymentInformation = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private final By confirmOrder = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    private final By confirmOrderAssertion = By.xpath("//strong[text()='Your order has been successfully processed!']");
    //--------------------------------------------------------------------------------

    public void navigateToCheckout() {
        driver.findElement(agreeServices).click();
        driver.findElement(checkOutButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    public void EnterUserAddress(String city, String address_one, String address_Tow,
                                 String zip, String phone, String fax) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(countryName).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(exactCountry).click();

        driver.findElement(stateName).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(exactState).click();

        driver.findElement(cityName).sendKeys(city);
        driver.findElement(addressOne).sendKeys(address_one);
        driver.findElement(addressTwo).sendKeys(address_Tow);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phoneNum).sendKeys(phone);
        driver.findElement(faxNumber).sendKeys(fax);
        driver.findElement(continueButton).click();
    }

    //Method
    public void setShippingMethode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(shippingMethode)));
        driver.findElement(shippingMethode).click();
    }

    //Method
    public void setPaymentMethode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paymentMethode)));
        driver.findElement(paymentMethode).click();
    }

    public void setPaymentInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paymentInformation)));
        driver.findElement(paymentInformation).click();
    }

    public void setConfirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmOrder)));
        driver.findElement(confirmOrder).click();
    }

    public String confirmOrderAssertionMessage() {
        return driver.findElement(confirmOrderAssertion).getText();
    }

}
