package demo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import demo.Base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[@id='nava']//img")
	WebElement logo;
	
	@FindBy(xpath="//li[@class='nav-item active']//a[@class='nav-link']")
	WebElement homebtn;
	
	@FindBy(xpath="//a[normalize-space()='Contact']")
	WebElement contactbtn;
	
	@FindBy(xpath="//a[normalize-space()='About us']")
	WebElement aboutbtn;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement cartbtn;
	
	@FindBy(xpath="//a[@id='login2']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@id='signin2']")
	WebElement signinbtn;
	
	@FindBy(xpath="//div[@id='contcont']//a[2]")
	WebElement phonetab;
	
	@FindBy(xpath="//a[3]")
	WebElement laptoptab;
	
	@FindBy(xpath="//*[@id=\"itemc\"]")
	WebElement monitorstab;
	
	
	
	
	

}
