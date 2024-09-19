package product;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.HomePage;
import demo.pages.ProductDetailPage;
import demo.pages.ProductsPage;

public class TestAddReview extends BaseClass{
	
	private HomePage homePage;
	private ProductsPage productPage;
	private ProductDetailPage productDetails;
	
	@BeforeClass
	void setUp() {
		driver.get("http://automationexercise.com");
//		setLog("Navigated to url :- http://automationexercise.com");
        homePage = new HomePage(driver);
        productPage=new ProductsPage(driver);
        productDetails=new ProductDetailPage(driver);
	}
	
	@Test
	void writeReview() {
		homePage.clickProducts();
		Assert.assertTrue(productPage.isAllProductsPageVisible());
		productPage.clickFirstProductView();
		Assert.assertTrue(productDetails.isReviewDIsplayed(), "Review Section not Displayed");
		productDetails.enterReview("Jimmy", "asdg@gmail.com", "xfgfhgjghfdfd");
		productDetails.clickOnSubmit();
		Assert.assertEquals(productDetails.getReviewSuccessText(), "Thank you for your review.");			
		
	}
	

}
