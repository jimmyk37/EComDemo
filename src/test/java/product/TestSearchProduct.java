package product;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.CartPage;
import demo.pages.HomePage;
import demo.pages.LoginPage;
import demo.pages.ProductsPage;

public class TestSearchProduct extends BaseClass{
	
	private HomePage homePage;
	private ProductsPage productsPage;
	private CartPage cartPage;
	private LoginPage loginPage;
	
	@BeforeClass
	public void setup() {
		driver.get("http://automationexercise.com");
		homePage = new HomePage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
    public void searchProduct() {
        
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
        
        homePage.clickProducts();       
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible.");
        setLog("PRODUCTS page is visible.");
        
        productsPage.enterProductNameInSearch("Top");  
        productsPage.clickSearchButton();
        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' text is not visible.");
        setLog("'SEARCHED PRODUCTS' text is visible.");
        
        Assert.assertTrue(productsPage.isProductsListVisible(), "'SEARCHED PRODUCTS' List is Empty.");
        setLog("'SEARCHED PRODUCTS' List Displyed.");
    }
	
	@Test(priority = 2, dependsOnMethods = "searchProduct")
    public void searchProductsAndVerifyCartAfterLogin() {
        
        productsPage.addAllProductsToCart();
        setLog("Added those products to cart");

        
        homePage.clickCart();

        Assert.assertTrue(cartPage.isCartNotEmpty(), "Products are not visible in the cart.");
        setLog("Cart List in Not Empty");
        
        homePage.clickSignupLoginButton();
        loginPage.enterEmail("mayank.imktg@gmail.com", "Mayank@123");
		loginPage.clickLoginButton();
		setLog("Loggedin With Valid Credentials");
		
        homePage.clickCart();

        Assert.assertTrue(cartPage.isCartNotEmpty(), "Products are not visible in the cart.");
        setLog("Cart List in Not Empty");
    }

}
