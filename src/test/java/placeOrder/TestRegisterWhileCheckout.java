package placeOrder;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.CartPage;
import demo.pages.HomePage;
import demo.pages.ProductsPage;
import demo.pages.SignupPage;

public class TestRegisterWhileCheckout extends BaseClass {
	HomePage homePage;
	ProductsPage productPage;
	CartPage cartpage;
	SignupPage signupPage;
	
	@BeforeClass
	void setup() {
		driver.get("http://automationexercise.com");
		homePage = new HomePage(driver);
		homePage=new HomePage(driver);
		cartpage= new CartPage(driver);
		signupPage=new SignupPage(driver);	
		productPage=new ProductsPage(driver);
	}
	
	@Test
	void testCompleteOrderProcess() {
		assertTrue(homePage.isHomePageVisible());
		homePage.clickProducts();
		assertTrue(productPage.isAllProductsPageVisible());
		productPage.clickAddToCartFirstProduct();
		productPage.clickAddToCartSecondProduct();
		productPage.clickViewCart();
		assertTrue(cartpage.isCartNotEmpty());
		cartpage.clickCheckOut();
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
		Assert.assertTrue(homePage.isLoginToYourAccountVisible(),"User is not navigated back to the login page after logout.");
		homePage.clickCart();
		assertTrue(cartpage.isCartNotEmpty());
		cartpage.clickCheckOut();
		

	}
	

}
