package demo.pages;

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
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		action=new Action();
	}
	
	public boolean isAddressSectionDisplayed() {
		return action.isDisplayed(addressSection);
	}
	public boolean isReviewOrderDisplayed() {
		return action.isDisplayed(reviewOrderSection);		
	}
	
	void enterDiscription(String discription) {
		action.sendKeys(discriptionbox, discription);
	}
	
	void clickPlaceOrder() {
		action.click(placeorderBtn);
	}
	
}
