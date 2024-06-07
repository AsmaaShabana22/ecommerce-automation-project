package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

    HomePage homePage;
    ContactUsPage contact;

    @Test
    public void navigateToContactUsPage() {
        homePage = new HomePage(driver);
        homePage.navigateToContactUs();
        contact = new ContactUsPage(driver);
        Assert.assertEquals(contact.getContactUsPageAssertionMessage(), "Put your contact information here." +
                " You can edit this in the admin site.");
    }

    @Test(priority = 1)
    public void UseContactUs() {
        contact = new ContactUsPage(driver);
        contact.ContactUs("Asmaa", "ss@gmail.com", "Hello, Welcome to my project");
        Assert.assertEquals(contact.getContactUsAssertionMessage(), "Your enquiry has been successfully sent to the store owner.");
    }
}
