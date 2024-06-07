package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

import java.time.Duration;

public class HoverTest extends BaseTest {

    HoverPage hover;

    @Test
    public void HoverOverComputer() {
        hover = new HoverPage(driver);
        hover.HoverOverComputers();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(hover.getComputersAssertionMessage(), "Desktops");
    }

    @Test(priority = 1)
    public void HoverOverElectronics() {
        hover = new HoverPage(driver);
        hover.HoverOverElectronics();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(hover.getElectronicsAssertionMessage(), "Cell phones");
    }

    @Test(priority = 2)
    public void HoverOverApparel() {
        hover = new HoverPage(driver);
        hover.HoverOverApparel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(hover.getApparelAssertionMessage(), "Shoes");
    }
}
