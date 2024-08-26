package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class HomePage extends Action {
	
	

	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//a[@href='/login']")                           WebElement signupLoginButton;
	@FindBy (xpath = "//img[@alt='Website for automation practice']") WebElement Homepagetital;
	@FindBy(xpath = "//a[normalize-space()='Contact us']")            WebElement contactUsButton;
	@FindBy(xpath = "//a[@href='/products']")               WebElement productsButton;
	@FindBy(xpath = "//a[@href='/view_cart']")               WebElement cartButton;
	@FindBy(xpath = "//h2[contains(text(),'Category')]")     WebElement categorySectionVisible;
    @FindBy(xpath = "//a[normalize-space()='Women']")    WebElement womenCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Men']")    WebElement menCategoryLink;
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")    WebElement dressesSubCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Jeans']")    WebElement jeansSubCategoryLink;
    @FindBy(xpath = "//h2[@class='title text-center']")    WebElement titaltext;
    @FindBy(xpath = "//h2[normalize-space()='Brands']")    WebElement brandsSectionVisible;
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")    WebElement poloBrandLink;
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")    WebElement hmBrandLink;


    
    public void clickSignupLoginButton() {
        click(signupLoginButton);
        setLog("Clicked on Login/Signup button");
    }

    public boolean isHomePageVisible() {
        return isDisplayed(Homepagetital);
    }
    
    public void clickContactUs() {
        click(contactUsButton);
    }
    
    public void clickProducts() {
        click(productsButton);
    }
    
    public void clickCart() {
        click(cartButton);
    }
    
    public boolean areCategoriesVisible() {
        return isDisplayed(categorySectionVisible);
    }
    
    public void clickWomenCategory() {
        click(womenCategoryLink);
    }
    
    public void clickDressesSubCategory() {
        click(dressesSubCategoryLink);
    }
    public void clickTshirtsSubCategory() {
        click(jeansSubCategoryLink);
    }
    
    public void clickMenCategory() {
        click(menCategoryLink);
    }
    public boolean areBrandsVisible() {
        return isDisplayed(brandsSectionVisible);
    }

    public void clickPoloBrand() {
        click(poloBrandLink);
    }

    public void clickHmBrand() {
        click(hmBrandLink);
    }
    
    public String getSearchTital() {
    	isDisplayed(titaltext);
    	return titaltext.getText();
    }
}
