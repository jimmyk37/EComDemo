package product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.ProductDetailPage;
import demo.pages.ProductsPage;

public class TestProducts extends BaseClass{
	
	private HomePage homePage;
	private ProductsPage productsPage;
	private ProductDetailPage productDetailPage;
	
	@BeforeClass
	public void setUp() {
		driver.get("http://automationexercise.com");
		homePage=new HomePage(driver);
		productsPage= new ProductsPage(driver);
		productDetailPage= new ProductDetailPage(driver);
	}
	
	@Test
    public void verifyAllProductsAndProductDetailPage() {
        
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
        setLog("Home page is visible.");
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible.");
        setLog("ALL PRODUCTS page is visible.");
        Assert.assertTrue(productsPage.isProductsListVisible(), "Products list is not visible.");
        setLog("Products list is visible.");
        productsPage.clickFirstProductView();
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail is not visible.");
        setLog("Products detail is visible.");
    }

}
