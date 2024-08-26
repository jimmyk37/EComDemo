package loginRegister;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.SignupPage;

public class TestRegister extends BaseClass {

	private HomePage homePage;
	private SignupPage signupPage;

	@BeforeClass
	public void setUp() {		
		homePage = new HomePage(driver);
		signupPage = new SignupPage(driver);
	}
	
	@Test(priority = 0)
	public void registerWithExistingEmail() {
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
		setLog("Home page is visible");

		homePage.clickSignupLoginButton();
		
		Assert.assertTrue(signupPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");
		setLog("'New User Signup!' is visible");

		signupPage.enterNameAndEmail("John Doe", "john.doe@example.com");

		signupPage.clickSignupButton();
		
		Assert.assertTrue(signupPage.isEmailAlreadyExistVisible(), "'Email Address already exist!' is not visible");
		setLog("'Email Address already exist!' is visible");
		
		}

	@Test(priority = 1, dependsOnMethods = "registerWithExistingEmail")
	public void registerUser() {
		
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		homePage.clickSignupLoginButton();

		
		Assert.assertTrue(signupPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");
		setLog("'New User Signup!' is visible");

		signupPage.enterNameAndEmail("Jimmy Gupta", "jimmy.imktg@example.com");

		signupPage.clickSignupButton();

		
		Assert.assertTrue(signupPage.isAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' is not visible");
		setLog("'ENTER ACCOUNT INFORMATION' is visible");

		signupPage.fillAccountInformation("Mr", "password123", "1", "January", "1990");

		signupPage.selectCheckboxes(true, true);

		signupPage.fillAdditionalDetails("Jimmy", "Gupta", "Acme Corp", "123 Elm St", "Apt 4B", "United States",
				"California", "Los Angeles", "90001", "1234567890");

		signupPage.clickCreateAccountButton();
		
		Assert.assertTrue(signupPage.isAccountCreatedVisible(), "'ACCOUNT CREATED!' is not visible");
		setLog("'ACCOUNT CREATED!' is visible");

		signupPage.clickContinueButton();

		signupPage.clickDeleteAccountButton();

		Assert.assertTrue(signupPage.isAccountDeletedVisible(), "'ACCOUNT DELETED!' is not visible");
		setLog("'ACCOUNT DELETED!' is visible");

	}
}
