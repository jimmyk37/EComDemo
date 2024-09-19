package subscription;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.base.BaseClass;
import demo.pages.CartPage;
import demo.pages.HomePage;

public class TestSubscription extends BaseClass {
	
	private HomePage homePage;
	private CartPage cartPage;
	
	@BeforeClass
	void setUp() {
		driver.get("http://automationexercise.com");
        homePage = new HomePage(driver);
        cartPage=new CartPage(driver);		
	}
	
	@Test
	void testSubscriptionHomePage() {
		Assert.assertTrue(homePage.isHomePageVisible());
		Assert.assertEquals(homePage.getSubscriptionText(), "SUBSCRIPTION");
		homePage.enterEMailtoSubscription("asdfg@gmail.com");
		homePage.clickOnSubscribeBtn();
		Assert.assertEquals(homePage.getSubscriptionAlertText(), "You have been successfully subscribed!");		
	}
	
	@Test
	void testSubscriptionProductPage() {
		homePage.clickCart();
		Assert.assertEquals(cartPage.getSubscriptionText(), "SUBSCRIPTION");
		cartPage.enterEMailtoSubscription("asdfg@gmail.com");
		cartPage.clickOnSubscribeBtn();
		Assert.assertEquals(cartPage.getSubscriptionAlertText(), "You have been successfully subscribed!");		
	}
	
}
