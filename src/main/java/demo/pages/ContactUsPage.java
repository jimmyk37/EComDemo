package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class ContactUsPage extends Action{
	
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
	}
    
    public boolean isGetInTouchVisible() {
        return isDisplayed(getInTouchText);
    }

    public void enterName(String name) {
       sendKeys(nameField,name);
    }

    public void enterEmail(String email) {
        sendKeys(emailField,email);
    }

    public void enterSubject(String subject) {
        sendKeys(subjectField,subject);
    }

    public void enterMessage(String message) {
        sendKeys(messageField,message);
    }

    public void uploadFile(String filePath) {
        sendKeys(uploadFileInput,filePath);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }

    public void clickHomeButton() {
        homeButton.click();
    }


}
