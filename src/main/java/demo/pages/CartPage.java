package demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.action.Action;

public class CartPage extends Action{
	
	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']/p")     WebElement firstProductPrice;
    @FindBy(xpath = "//*[@id='product-1']//td[@class='cart_quantity']/button")     WebElement firstProductQuantity;
    @FindBy(xpath = "//*[@id='product-1']//td[@class='cart_total']/p")    WebElement firstProductTotal;
    @FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']/p")    WebElement secondProductPrice;
    @FindBy(xpath = "//*[@id='product-2']//td[@class='cart_quantity']/button")    WebElement secondProductQuantity;
    @FindBy(xpath = "//*[@id='product-2']//td[@class='cart_total']/p")    WebElement secondProductTotal;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")    WebElement checkOutButton;
    @FindBy(xpath = "//tr[@id='product-1']//a[@class='cart_quantity_delete']") WebElement removeFirstProductButton;
    @FindBy(xpath = "//tr[@id='product-2']//a[@class='cart_quantity_delete']") WebElement removeSecondProductButton;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']") List<WebElement> cartlengh;
    
    
    public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    public boolean verifyFirstProductDetails(String price, String quantity, String total) {
        return firstProductPrice.getText().equals(price) &&
               firstProductQuantity.getText().equals(quantity) &&
               firstProductTotal.getText().equals(total);
    } 	
    
    public boolean verifySecondProductDetails(String price, String quantity, String total) {
        return secondProductPrice.getText().equals(price) &&
               secondProductQuantity.getText().equals(quantity) &&
               secondProductTotal.getText().equals(total);
    }
    
    public boolean verifyProductQuantity(String expectedQuantity) {
        return firstProductQuantity.getText().equals(expectedQuantity);
    }
    
    public void clickRemoveFirstProductButton() {
    	click(removeFirstProductButton);
    }
    public boolean isCartNotEmpty() {
        return !cartlengh.isEmpty();
    }
    
    public void clickRemoveSecondProductButton() {
    	click(removeSecondProductButton);
    }
    
    public boolean isProductRemoved(String name) {
        // Add code to check if the product has been removed
        return !driver.getPageSource().contains(name); 
    }


}
