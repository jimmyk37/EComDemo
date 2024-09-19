package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class ProductDetailPage extends BaseClass {
	
	Action action;

	@FindBy(xpath = "//div[@class='product-information']//h2") 	WebElement productName;
	@FindBy(xpath = "//input[@id='quantity']") 	WebElement quantityInput;
	@FindBy(xpath = "//button[@type='button']")	WebElement addToCartButton; 
	@FindBy(xpath = "//p[contains(text(),'Category')]")	WebElement productCategory;
	@FindBy(xpath = "//span[contains(text(),'Rs.')]")	WebElement productPrice;
	@FindBy(xpath = "//b[normalize-space()='Availability:']")	WebElement productAvailability;
	@FindBy(xpath = "//b[normalize-space()='Condition:']")	WebElement productCondition;
	@FindBy(xpath = "//b[normalize-space()='Brand:']")	WebElement productBrand;
	@FindBy(xpath = "//u[normalize-space()='View Cart']")    WebElement viewCartModal;
	@FindBy(xpath = "//*[@href='#reviews']")  WebElement reviewSection;
	@FindBy(xpath = "//*[@id='name']")   WebElement nameField;
	@FindBy(xpath = "//*[@id='email']")   WebElement emailField;
	@FindBy(xpath = "//*[@id='review']")   WebElement reviewField;
	@FindBy(xpath = "//*[@id='button-review']")   WebElement submitbtn;
	@FindBy(xpath = "//div[@class='alert-success alert']/span") 	WebElement reviewSuccess;

	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action= new Action();
	}

	public boolean isProductDetailVisible() {
		return action.isDisplayed(productName) && action.isDisplayed(productCategory) && action.isDisplayed(productPrice)
				&& action.isDisplayed(productAvailability) && action.isDisplayed(productCondition) && action.isDisplayed(productBrand);
	}
	
	public void setQuantity(String quantity) {
		action.sendKeys(quantityInput,quantity);
		setLog("Entered quantity "+ quantity);
    }
	
	public void clickAddToCart() {
		action.click(addToCartButton);
		setLog("Clicked on Ad to Card Button");
    }
	public void clickViewCart() {
		action.click(viewCartModal);
		setLog("Clicked on View Cart Modal");
    }
	
	public boolean isReviewDIsplayed() {
		return action.isDisplayed(reviewSection);
	}
	
	public void enterReview(String name, String email, String review) {
		action.sendKeys(nameField, name);
		action.sendKeys(emailField, email);
		action.sendKeys(reviewField, review);
		setLog("Entered Review Details");
	}
	
	public void clickOnSubmit() {
		action.clear(submitbtn);
		setLog("Clicked on Submit Review button");
	}
	
	public String getReviewSuccessText() {
		return action.getText(reviewSuccess);
	}
	
	
}
