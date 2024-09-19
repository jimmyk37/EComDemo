package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action;

	@FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
	WebElement loginToYourAccountText;
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginButton;
	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
	WebElement errorMessage;
	@FindBy(xpath = "//li[10]//a[1]")
	WebElement loggedInAsUsername;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action= new Action();
	}

	public boolean isLoginToYourAccountVisible() {
		return action.isDisplayed(loginToYourAccountText);

	}

	public void enterEmail(String email, String password) {

		action.sendKeys(emailField, email);
		action.sendKeys(passwordField, password);
		setLog("Entered Email & Password");
	}

	public void clickLoginButton() {
		action.click(loginButton);
		setLog("Clicked on Login Button");
	}

	public boolean isErrorMessageVisible() {
		return action.isDisplayed(errorMessage);
	}

	public boolean isLoggedInAsUsernameVisible() {
		return action.isDisplayed(loggedInAsUsername);
	}

	public void clickLogoutButton() {
		action.click(logoutButton);
		setLog("Clicked on Login Button");
	}

}
