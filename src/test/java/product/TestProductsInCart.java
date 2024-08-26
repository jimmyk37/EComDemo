package product;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.CartPage;
import demo.pages.HomePage;
import demo.pages.ProductDetailPage;
import demo.pages.ProductsPage;

public class TestProductsInCart extends BaseClass{
	private HomePage homePage;
	private ProductsPage productsPage;
	private ProductDetailPage productDetailPage;
	private CartPage cartPage;
	@BeforeClass
	public void setup() {
		driver.get("http://automationexercise.com");
		homePage = new HomePage(driver);
		productsPage = new ProductsPage(driver);
		productDetailPage = new ProductDetailPage(driver);
		cartPage = new CartPage(driver);
		
	}

	@Test(priority = 1)
    public void addProductsToCart() {
        
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
        
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible.");
        setLog("PRODUCTS page is visible.");
        
        productsPage.hoverOverFirstProduct();
        productsPage.clickAddToCartFirstProduct();
        productsPage.clickContinueShopping();
        productsPage.hoverOverSecondProduct();
        productsPage.clickAddToCartSecondProduct();
        setLog("PRODUCTS are added to CART");
        productsPage.clickViewCart();            
        softAssert.assertTrue(cartPage.verifyFirstProductDetails("Rs. 500", "1", "Rs. 500"), "First product details are incorrect.");
        softAssert.assertTrue(cartPage.verifySecondProductDetails("Rs. 400", "1", "Rs. 400"), "Second product details are incorrect.");
        softAssert.assertAll();
        setLog("PRODUCTS details are visible in CART.");
	}
	
	@Test(priority = 2)
    public void removeProductsFromCart() {        
        cartPage.clickRemoveFirstProductButton();
        cartPage.clickRemoveSecondProductButton();
        Assert.assertTrue(cartPage.isProductRemoved("Blue Top"), "Product was not removed from the cart."); 
        setLog("PRODUCTS is removed from cart.");
    }
	
	@Test(priority = 3)
    public void verifyProductQuantityInCart() {		
		driver.get("http://automationexercise.com");
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
		homePage.clickProducts();       
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible.");
        setLog("PRODUCTS page is visible.");
        productsPage.clickFirstProductViewButton();
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page is not visible.");
        setLog("PRODUCTS page is visible.");
        productDetailPage.setQuantity("4");
        setLog("Set Product quantity to 4");
        productDetailPage.clickAddToCart();
        setLog("PRODUCTS are added to cart");
        
        productDetailPage.clickViewCart();
        Assert.assertTrue(cartPage.verifyProductQuantity("4"), "Product quantity in the cart is incorrect.");
        cartPage.clickRemoveFirstProductButton();
        setLog("PRODUCTS is removed from cart.");
    }
}
