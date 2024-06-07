package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
