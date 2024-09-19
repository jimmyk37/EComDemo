package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;
import demo.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action;

	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		action=new Action();
	}
	@FindBy (xpath = "//a[@href='/login']")                           WebElement signupLoginButton;
	@FindBy (xpath = "//img[@alt='Website for automation practice']") WebElement Homepagetital;
	@FindBy(xpath = "//a[normalize-space()='Contact us']")            WebElement contactUsButton;
	@FindBy(xpath = "//a[@href='/products']")               WebElement productsButton;
	@FindBy(xpath = "//a[@href='/view_cart']")               WebElement cartButton;
	 @FindBy(xpath = "//*[contains(text(), ' Delete Account')]") 	WebElement deleteAccountbtn;
	@FindBy(xpath = "//h2[contains(text(),'Category')]")     WebElement categorySectionVisible;
    @FindBy(xpath = "//a[normalize-space()='Women']")    WebElement womenCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Men']")    WebElement menCategoryLink;
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")    WebElement dressesSubCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Jeans']")    WebElement jeansSubCategoryLink;
    @FindBy(xpath = "//h2[@class='title text-center']")    WebElement titaltext;
    @FindBy(xpath = "//h2[normalize-space()='Brands']")    WebElement brandsSectionVisible;
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")    WebElement poloBrandLink;
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")    WebElement hmBrandLink;
    @FindBy(xpath ="//*[@id=\"footer\"]" )  WebElement footer;
    @FindBy(xpath ="//*[@class=\"single-widget\"]//h2" ) WebElement subscriptiontext;
    @FindBy(xpath = "//*[@id=\"susbscribe_email\"]") WebElement emailinput;
    @FindBy(xpath= "//button[@id=\"subscribe\"]") WebElement subscribeButton;
    @FindBy(xpath="//div[@class='alert-success alert']") WebElement subscriptionAlertText;
    @FindBy(xpath = "//li[10]//a[1]") 	WebElement loggedInAsUsername;
    @FindBy(xpath = "//*[contains(text(), 'Account Deleted!')]") 	WebElement accountDeleted;
    @FindBy(xpath = "//*[@data-qa=\"continue-button\"]") 	WebElement continuebtn;
    
    
 

    
    public void clickSignupLoginButton() {
    	action.click(signupLoginButton);
        setLog("Clicked on Login/Signup button");
    }

    public boolean isHomePageVisible() {
        return action.isDisplayed(Homepagetital);
    }
    
    public void clickContactUs() {
    	action.click(contactUsButton);
    }
    
    public void clickProducts() {
    	action.click(productsButton);
    }
    
    public void clickCart() {
    	action.click(cartButton);
    }
    
    public boolean areCategoriesVisible() {
        return action.isDisplayed(categorySectionVisible);
    }
    
    public void clickWomenCategory() {
    	action.click(womenCategoryLink);
    }
    
    public void clickDressesSubCategory() {
    	action.click(dressesSubCategoryLink);
    }
    public void clickTshirtsSubCategory() {
    	action.click(jeansSubCategoryLink);
    }
    
    public void clickMenCategory() {
    	action.click(menCategoryLink);
    }
    public boolean areBrandsVisible() {
        return action.isDisplayed(brandsSectionVisible);
    }

    public void clickPoloBrand() {
    	action.click(poloBrandLink);
    }

    public void clickHmBrand() {
    	action.click(hmBrandLink);
    }
    
    public String getSearchTital() {
    	action.isDisplayed(titaltext);
    	return titaltext.getText();
    }
    
    public String getSubscriptionText() {
    	action.scrollIntoView(footer);
		return action.getText(subscriptiontext);
    	
    }
    
    public void enterEMailtoSubscription(String email) {
    	action.sendKeys(emailinput, email);
    	}
    
    public void clickOnSubscribeBtn() {
    	action.click(subscribeButton);
    }
    
    public String getSubscriptionAlertText() {    	
		return action.getText(subscriptionAlertText);    	
    } 

	public boolean isLoginToYourAccountVisible() {
		return action.isDisplayed(loggedInAsUsername);
	}
	
	public void clickDeleteAccountBtn() {
    	action.click(deleteAccountbtn);
    }
	public boolean isDeleteAccountTextVisible() {
        return action.isDisplayed(Homepagetital);
    }
	
	public void clickContinue() {
    	action.click(continuebtn);
    }
    }
