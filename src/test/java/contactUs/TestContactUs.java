package contactUs;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.ContactUsPage;
import demo.pages.HomePage;

public class TestContactUs extends BaseClass{

	private HomePage homePage;
	private ContactUsPage contactUsPage;
	
	@BeforeClass
	public void setup() {
		driver.get("http://automationexercise.com");
		homePage=new HomePage(driver);
		contactUsPage=new ContactUsPage(driver);		
	}
	
	@Test
    public void contactUsFormSubmission() {
        
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
        
        homePage.clickContactUs();
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible.");
        
        contactUsPage.enterName("Test User");
        contactUsPage.enterEmail("test@example.com");
        contactUsPage.enterSubject("Test Subject");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.uploadFile("C:\\Users\\user\\git\\EComDemo\\logs\\test.log");
        contactUsPage.clickSubmitButton();
        
        driver.switchTo().alert().accept();
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message is not visible.");
        
        contactUsPage.clickHomeButton();
        Assert.assertTrue(homePage.isHomePageVisible(), "Did not navigate back to the home page.");
    }
	
}
