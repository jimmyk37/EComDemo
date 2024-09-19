package loginRegister;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.LoginPage;
import demo.pages.SignupPage;

public class TestLogin extends BaseClass {

	private HomePage homePage;
	private LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		driver.get("http://automationexercise.com");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 0)
	public void loginUserWithIncorrectEmailAndPassword() {

		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
		homePage.clickSignupLoginButton();
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible(), "'Login to your account' is not visible.");
		loginPage.enterEmail("incorrect@example.com", "incorrectpassword");
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isErrorMessageVisible(),"'Your email or password is incorrect!' error is not visible.");
	}

	@Test(priority = 1)
	public void loginUserWithCorrectEmailAndPassword() {

		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
		setLog("Home page is visible.");
		homePage.clickSignupLoginButton();
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible(), "'Login to your account' is not visible.");
		setLog("'Login to your account' is visible.");
		loginPage.enterEmail("mayank.imktg@gmail.com", "Mayank@123");
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isLoggedInAsUsernameVisible(), "'Logged in as username' is not visible.");
		setLog("'Logged in as username' is visible.");
		loginPage.clickLogoutButton();
	}

	@Test(priority = 2, dependsOnMethods = "loginUserWithCorrectEmailAndPassword")
	public void loginUserWithCorrectEmailAndPasswordThenLogout() {
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
		setLog("Home page is visible.");
		homePage.clickSignupLoginButton();
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible(), "'Login to your account' is not visible.");
		setLog("'Login to your account' is visible.");
		loginPage.enterEmail("mayank.imktg@gmail.com", "Mayank@123");
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isLoggedInAsUsernameVisible(), "'Logged in as username' is not visible.");
		setLog("'Logged in as username' is visible.");
		loginPage.clickLogoutButton();
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible(),
				"User is not navigated back to the login page after logout.");
		setLog("User is navigated back to the login page after logout.");
	}
}
