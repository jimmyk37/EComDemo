package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class ContactUsPage extends BaseClass{
	Action action;
	
	@FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElement getInTouchText;
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement subjectField;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFileInput;
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement homeButton;
    
    public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action=new Action();
	}
    
    public boolean isGetInTouchVisible() {
        return action.isDisplayed(getInTouchText);
    }

    public void enterName(String name) {
    	action.sendKeys(nameField,name);
    }

    public void enterEmail(String email) {
    	action.sendKeys(emailField,email);
    }

    public void enterSubject(String subject) {
    	action.sendKeys(subjectField,subject);
    }

    public void enterMessage(String message) {
    	action.sendKeys(messageField,message);
    }

    public void uploadFile(String filePath) {
    	action.sendKeys(uploadFileInput,filePath);
    }

    public void clickSubmitButton() {
    	action.click(submitButton);
    }

    public boolean isSuccessMessageVisible() {
        return action.isDisplayed(successMessage);
    }

    public void clickHomeButton() {
        homeButton.click();
    }


}
