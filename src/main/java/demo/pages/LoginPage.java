package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class LoginPage extends Action {

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
	}

	public boolean isLoginToYourAccountVisible() {
		return isDisplayed(loginToYourAccountText);

	}

	public void enterEmail(String email, String password) {

		sendKeys(emailField, email);
		sendKeys(passwordField, password);
		setLog("Entered Email & Password");
	}

	public void clickLoginButton() {
		click(loginButton);
		setLog("Clicked on Login Button");
	}

	public boolean isErrorMessageVisible() {
		return isDisplayed(errorMessage);
	}

	public boolean isLoggedInAsUsernameVisible() {
		return isDisplayed(loggedInAsUsername);
	}

	public void clickLogoutButton() {
		click(logoutButton);
		setLog("Clicked on Login Button");
	}

}
