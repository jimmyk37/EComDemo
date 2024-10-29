package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class CheckOutPage extends BaseClass{

	Action action;
	
	@FindBy (xpath = "(//*[@class='step-one'])[1]") WebElement addressSection;
	@FindBy (xpath = "(//*[@class='step-one'])[2]") WebElement reviewOrderSection;
	@FindBy (xpath = "//*[@name='message']") WebElement discriptionbox;
	@FindBy (xpath = "//*[@href='payment']") WebElement placeorderBtn;
	@FindBy (xpath = "//*[@class='heading']") WebElement paymentText;
	@FindBy (xpath = "//*[@name='name_on_card']") WebElement nameCard;
	@FindBy (xpath = "//*[@name='card_number']") WebElement cardNumber;
	@FindBy (xpath = "//*[@name='cvc']") WebElement cvc;
	@FindBy (xpath = "//*[@name='expiry_month']") WebElement expiryMonth;
	@FindBy (xpath = "//*[@name='expiry_year']") WebElement expiryYear;
	@FindBy (id =  "submit") WebElement payBtn;
	@FindBy (xpath = "//b[text()='Order Placed!']") WebElement orderPlacedText;

	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action=new Action();
	}
	
	public boolean isAddressSectionDisplayed() {
		return action.isDisplayed(addressSection);
	}
	public boolean isReviewOrderDisplayed() {
		return action.isDisplayed(reviewOrderSection);		
	}
	
	public void enterDiscription(String discription) {
		action.sendKeys(discriptionbox, discription);
		setLog("Entered discription Text:- "+discription);
	}
	
	public void clickPlaceOrder() {
		action.click(placeorderBtn);
		setLog("Clicked on Place Order Button");
	}
	
	public boolean isPaymentVisible() {
		return paymentText.isDisplayed();
	}
	
	public void enterName(String name) {
		nameCard.sendKeys(name);
		setLog("Entered Card Holder Name");
	}
	
	public void enterexpiryMonth(String Month) {
		expiryMonth.sendKeys(Month);
		setLog("Entered Card Expiry Month");
	}
	
	public void enterCardNumber(String card) {
		cardNumber.sendKeys(card);
		setLog("Entered Card Number");
	}
	
	public void entercvc(String cvv) {
		cvc.sendKeys(cvv);
		setLog("Entered Card CVV");
	}
	
	public void enterexpiryYear(String Year) {
		expiryYear.sendKeys(Year);
		setLog("Entered Card Expiry Year");
	}
	
	public void clickonPay() {	 
		payBtn.click();
		setLog("Clicked On Pay Button");
	}
	
	public boolean isorderPlacedDisplayed() {
		return orderPlacedText.isDisplayed();
	}
	
	
	
	
}
