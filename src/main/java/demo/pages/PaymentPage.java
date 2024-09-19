package demo.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class PaymentPage extends BaseClass{	

	Action action;
	
	@FindBy (xpath = "//*[@name='name_on_card']") WebElement nameField;
	@FindBy (xpath = "//*[@name='card_number']") WebElement cardField;
	@FindBy (xpath = "//*[@name='cvc']") WebElement cvvField;
	@FindBy (xpath = "//*[@name='expiry_month']") WebElement expMonthField;
	@FindBy (xpath = "//*[@name='expiry_year']") WebElement expYearField;
	@FindBy (xpath = "//*[@id='submit']") WebElement payBtn;
	@FindBy(xpath="(//div[@class='alert-success alert'])[1]") WebElement successAlertText;
	@FindBy(xpath="//*[@data-qa='order-placed']") WebElement orderPlacedText;
	@FindBy(xpath="//*[contains(text(), 'Download Invoice')]") WebElement downloadinvoicebtn;
	@FindBy(xpath="//*[contains(text(), 'Continue')]") WebElement continuebtn;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
		action=new Action();
	}
	
	public void enterCardDetails() {
		action.sendKeys(nameField, "jimmy");
		action.sendKeys(cardField, "4111111111111111");
		action.sendKeys(cvvField, "654");
		action.sendKeys(expMonthField, "12");
		action.sendKeys(expYearField, "2026");
	}
	
	void clickPayBtn() {
		action.click(payBtn);
	}
	
	public String getSuccessMsg() {
		return action.getText(successAlertText);		
	}
	
	public boolean isOrderPlacedDisplayed() {
		return action.isDisplayed(orderPlacedText);
	}
	
	public void downloadInvoice() throws AWTException {
		action.downLoadFile(downloadinvoicebtn);
	}
	
	void clickContinuebtn() {
		action.click(continuebtn);
	}
	
	
	
	

}
