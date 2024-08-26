package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class ProductDetailPage extends Action {

	@FindBy(xpath = "//div[@class='product-information']//h2") 	WebElement productName;
	@FindBy(xpath = "//input[@id='quantity']") 	WebElement quantityInput;
	@FindBy(xpath = "//button[@type='button']")	WebElement addToCartButton; 
	@FindBy(xpath = "//p[contains(text(),'Category')]")	WebElement productCategory;
	@FindBy(xpath = "//span[contains(text(),'Rs.')]")	WebElement productPrice;
	@FindBy(xpath = "//b[normalize-space()='Availability:']")	WebElement productAvailability;
	@FindBy(xpath = "//b[normalize-space()='Condition:']")	WebElement productCondition;
	@FindBy(xpath = "//b[normalize-space()='Brand:']")	WebElement productBrand;
	@FindBy(xpath = "//u[normalize-space()='View Cart']")    WebElement viewCartModal;

	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean isProductDetailVisible() {
		return isDisplayed(productName) && isDisplayed(productCategory) && isDisplayed(productPrice)
				&& isDisplayed(productAvailability) && isDisplayed(productCondition) && isDisplayed(productBrand);
	}
	
	public void setQuantity(String quantity) {
        sendKeys(quantityInput,quantity);
    }
	
	public void clickAddToCart() {
        click(addToCartButton);
    }
	public void clickViewCart() {
        click(viewCartModal);
    }
	
	
}
