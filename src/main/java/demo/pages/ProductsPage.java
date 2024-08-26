package demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class ProductsPage extends Action{
	
	@FindBy(xpath = "//h2[contains(text(),'All Products')]")    WebElement allProductsText;
    @FindBy(xpath = "//div[@class='productinfo text-center']")    List<WebElement> productsList;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")    WebElement firstProduct;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]")    WebElement secondProduct;
    @FindBy(xpath = "//a[@href='/product_details/1']")    WebElement firstProductViewButton;
    @FindBy(xpath = "//a[@href='/product_details/2']")    WebElement secondProductViewButton;
    @FindBy(xpath = "//a[@data-product-id='1']")    WebElement addToCartFirstProduct;
    @FindBy(xpath = "//a[@data-product-id='2']")    WebElement addToCartSecondProduct;
    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")    WebElement continueShoppingButton;
    @FindBy(xpath = "//u[normalize-space()='View Cart']")    WebElement viewCartModal;
    @FindBy(xpath = "//a[@href='/view_cart']")    WebElement viewCartButton;
    @FindBy(xpath = "//input[@id='search_product']")    WebElement searchInput;
    @FindBy(xpath = "//button[@id='submit_search']")    WebElement searchButton;
    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")    WebElement searchedProductsText;
    @FindBy(xpath = "//h2[normalize-space()='Brands']")    WebElement brandsSectionVisible;
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")    WebElement poloBrandLink;
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")    WebElement hmBrandLink;
    @FindBy(xpath = "//h2[@class='title text-center']")    WebElement titaltext;
	@FindBy(xpath = "//h2[contains(text(),'Category')]")     WebElement categorySectionVisible;
    @FindBy(xpath = "//a[normalize-space()='Women']")    WebElement womenCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Men']")    WebElement menCategoryLink;
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")    WebElement dressesSubCategoryLink;
    @FindBy(xpath = "//a[normalize-space()='Jeans']")    WebElement jeansSubCategoryLink;
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")    List<WebElement> addToCartButtons;
    
    
    public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    public String getSearchTital() {
    	isDisplayed(titaltext);
    	return titaltext.getText();
    }
    
    public boolean isAllProductsPageVisible() {
        return isDisplayed(allProductsText);
    }

    public boolean isProductsListVisible() {
        return !productsList.isEmpty();
    }

    public void clickFirstProductView() {
        click(firstProductViewButton);
    }
    
    public void enterProductNameInSearch(String productName) {
        sendKeys(searchInput,productName);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsText);
    }
    
    public void hoverOverFirstProduct() {
        hoverOverElement(firstProduct);
    }
    
    public void hoverOverSecondProduct() {
        hoverOverElement(secondProduct);
    }
    
    public void clickAddToCartFirstProduct() {
        click(addToCartFirstProduct);
    }
    
    public void clickAddToCartSecondProduct() {
        click(addToCartSecondProduct);
    }
    
    public void clickContinueShopping() {
        click(continueShoppingButton);
    }
    
    public void clickViewCart() {
        click(viewCartModal);
    }
    
    public void clickFirstProductViewButton() {
        click(firstProductViewButton);
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
    public void addAllProductsToCart() {
    	for (int i = 0; i < productsList.size(); i++) {
            WebElement product = productsList.get(i);
            WebElement addToCartButton = addToCartButtons.get(i);
            
            hoverOverElement(product);  // Hover over the product
            click(addToCartButton);     // Click the corresponding "Add to Cart" button
            click(continueShoppingButton);  // Click "Continue Shopping" if needed
        }
    }
    
}
