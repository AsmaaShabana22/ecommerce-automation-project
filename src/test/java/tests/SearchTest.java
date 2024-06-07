package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import java.time.Duration;

public class SearchTest extends BaseTest {

    HomePage homePage;
    SearchPage search;

    @Test
    public void SearchForMacProduct() {
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage("mac");
    }

    @Test(priority = 1)
    public void NavigateToMacProduct() {
        search = new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        search.navigateToMacProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(search.getMacProductAssertionMessage(), "Apple MacBook Pro 13-inch");
    }
}
