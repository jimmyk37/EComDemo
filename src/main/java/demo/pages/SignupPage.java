package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import demo.action.Action;
import demo.base.BaseClass;

public class SignupPage extends BaseClass {
	
	Action action;
	
    // Locators
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    private WebElement accountInfoText;

    @FindBy(xpath = "//input[@value='Mr']")
    private WebElement titleMrRadio;

    @FindBy(xpath = "//input[@value='Mrs']")
    private WebElement titleMrsRadio;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daySelect;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthSelect;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearSelect;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement specialOffersCheckbox;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address1Input;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElement address2Input;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countrySelect;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='zipcode']")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//input[@name='mobile_number']")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    private WebElement accountDeletedText;
    
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    private WebElement emailalreadyexistText;

    public SignupPage(WebDriver driver) {        
        PageFactory.initElements(driver, this);
        action=new Action();
    }

    public void enterNameAndEmail(String name, String email) {    	
    	action.sendKeys(nameInput, name);
    	action.sendKeys(emailInput, email);
    	setLog("Entered Name & Email Address");
    	
    }

    public void clickSignupButton() {
    	action.click(signupButton);
    	setLog("Clicked on Signup Button");
    }

    public boolean isNewUserSignupVisible() {
        return action.isDisplayed(newUserSignupText);
        
    }
    
    public boolean isEmailAlreadyExistVisible() {
        return action.isDisplayed(emailalreadyexistText);
    }

    public boolean isAccountInfoVisible() {
        return action.isDisplayed(accountInfoText);
    }

    public void fillAccountInformation(String title, String password, String day, String month, String year) {
        if (title.equalsIgnoreCase("Mr")) {
        	action.click(titleMrRadio);
        } else {
        	action.click(titleMrsRadio);
        }
        action.sendKeys(passwordInput, password);
        action.selectByValue(daySelect, day);
        action.selectByValue(monthSelect, month);
        action.selectByValue(yearSelect, year);
        
        setLog("Entered Account Information");
    }

    

	public void selectCheckboxes(boolean newsletter, boolean specialOffers) {
        if (newsletter) {
        	action.click(newsletterCheckbox);
        	setLog("Selected Newsletter Checkbox");
        }
        if (specialOffers) {
        	action.click(specialOffersCheckbox);
        	setLog("Selected offers Checkbox");
        }
    }

    public void fillAdditionalDetails(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
    	action.sendKeys(firstNameInput, firstName);
    	action.sendKeys(lastNameInput, lastName);
    	action.sendKeys(companyInput, company);
    	action.sendKeys(address1Input, address1);
    	action.sendKeys(address2Input, address2);
    	action.selectByValue(countrySelect, country);
    	action.sendKeys(stateInput, state);
    	action.sendKeys(cityInput, city);
    	action.sendKeys(zipcodeInput, zipcode);
    	action.sendKeys(mobileNumberInput, mobileNumber);
    	
    	setLog("Entered Additional Information");
    }

    public void clickCreateAccountButton() {
    	action.click(createAccountButton);
    	setLog("Clicked on Create Account button");
    }

    public boolean isAccountCreatedVisible() {
        return action.isDisplayed(accountCreatedText);
    }

    public void clickContinueButton() {
    	action.click(continueButton);
    	setLog("Clicked on Continue button");
    }

    public void clickDeleteAccountButton() {
    	action.click(deleteAccountButton);
    	setLog("Clicked on Delete button");
    }

    public boolean isAccountDeletedVisible() {
        return action.isDisplayed(accountDeletedText);
    }
}
