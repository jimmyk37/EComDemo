package product;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.ProductsPage;

public class TestCategoryProducts extends BaseClass{
	
	private HomePage homePage;
	private ProductsPage productsPage;
	
	@BeforeClass
	public void setup() {
		driver.get("http://automationexercise.com");
        homePage = new HomePage(driver);
        productsPage= new ProductsPage(driver);
        
	}
	
	@Test
    public void viewHomePageCategoryProducts() {
        
        Assert.assertTrue(homePage.areCategoriesVisible(), "Categories are not visible on the left side bar.");
        homePage.clickWomenCategory();        
        homePage.clickDressesSubCategory();
        setLog("Clicked on Women Category and SubCategory Dress");
        Assert.assertEquals(homePage.getSearchTital(),"WOMEN - DRESS PRODUCTS", "Women category page with 'WOMEN - DRESS PRODUCTS' text is not displayed.");

        homePage.clickMenCategory();
        homePage.clickTshirtsSubCategory();
        Assert.assertEquals(homePage.getSearchTital(),"MEN - JEANS PRODUCTS", "Men category page with 'MEN - JEANS PRODUCTS' text is not displayed.");
    }
	
	@Test
    public void viewProductPageCategoryProducts() {
        
        Assert.assertTrue(homePage.areCategoriesVisible(), "Categories are not visible on the left side bar.");
        homePage.clickProducts();
        productsPage.clickWomenCategory();        
        productsPage.clickDressesSubCategory();
        setLog("Clicked on Women Category and SubCategory Dress");
        Assert.assertEquals(homePage.getSearchTital(),"WOMEN - DRESS PRODUCTS", "Women category page with 'WOMEN - DRESS PRODUCTS' text is not displayed.");

        productsPage.clickMenCategory();
        productsPage.clickTshirtsSubCategory();
        Assert.assertEquals(homePage.getSearchTital(),"MEN - JEANS PRODUCTS", "Men category page with 'MEN - JEANS PRODUCTS' text is not displayed.");
    }

}
