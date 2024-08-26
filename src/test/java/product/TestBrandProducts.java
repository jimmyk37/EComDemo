package product;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.ProductsPage;

public class TestBrandProducts extends BaseClass{
	private HomePage homePage;
	private ProductsPage productPage;
	
	@BeforeClass
	public void setup() {
		driver.get("http://automationexercise.com");
        homePage = new HomePage(driver);
        productPage=new ProductsPage(driver);
        
	}
	
	@Test
    public void viewHomePageBrandsProducts() {
        
        Assert.assertTrue(homePage.areCategoriesVisible(), "Categories are not visible on the left side bar.");
        homePage.clickPoloBrand();
        setLog("Clicked on Women Category and SubCategory Dress");
        Assert.assertEquals(homePage.getSearchTital(),"BRAND - POLO PRODUCTS", "Brand page with 'BRAND - POLO PRODUCTS' text is not displayed.");

        homePage.clickHmBrand();
        Assert.assertEquals(homePage.getSearchTital(),"BRAND - H&M PRODUCTS", "Brandory page with 'BRAND - H&M PRODUCTS' text is not displayed.");
    }
	@Test
    public void viewProductPageBrandsProducts() {
		homePage.clickProducts();        
        Assert.assertTrue(productPage.areCategoriesVisible(), "Categories are not visible on the left side bar.");
        productPage.clickPoloBrand();
        setLog("Clicked on Women Category and SubCategory Dress");
        Assert.assertEquals(productPage.getSearchTital(),"BRAND - POLO PRODUCTS", "Brand page with 'BRAND - POLO PRODUCTS' text is not displayed.");

        productPage.clickHmBrand();
        Assert.assertEquals(productPage.getSearchTital(),"BRAND - H&M PRODUCTS", "Brand page with 'BRAND - H&M PRODUCTS' text is not displayed.");
    }
}
