package demo.action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.base.BaseClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class Action extends BaseClass implements WebDriverActions  {

    protected WebDriver driver =BaseClass.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));;

    // Constructor to initialize WebDriver and WebDriverWait


    private void ensureElementIsInteractable(WebElement element) {
        waitForElementToBeVisible(element, Duration.ofSeconds(20));
        waitForElementToBeClickable(element, Duration.ofSeconds(20));
        if (!isEnabled(element)) {
            throw new IllegalStateException("Element is not interactable.");
        }
    }

    @Override
    public void click(WebElement element) {
        try {
            ensureElementIsInteractable(element);
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to click on the element. Error: " + e.getMessage());
        }
    }

    @Override
    public void sendKeys(WebElement element, CharSequence... keysToSend) {
        try {
            ensureElementIsInteractable(element);
            clear(element);
            element.sendKeys(keysToSend);
        } catch (Exception e) {
            System.out.println("Failed to send keys to the element. Error: " + e.getMessage());
        }
    }

    @Override
    public void clear(WebElement element) {
        try {
            ensureElementIsInteractable(element);
            element.clear();
        } catch (Exception e) {
            System.out.println("Failed to clear the element. Error: " + e.getMessage());
        }
    }

    @Override
    public void submit(WebElement element) {
        try {
            ensureElementIsInteractable(element);
            element.submit();
        } catch (Exception e) {
            System.out.println("Failed to submit the element. Error: " + e.getMessage());
        }
    }

    @Override
    public boolean isDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element, Duration.ofSeconds(10)); // Adjust timeout if necessary
            boolean isDisplayed = element.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Failed to check if element is displayed. Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isEnabled(WebElement element) {
        try {
            boolean isEnabled = element.isEnabled();
            return isEnabled;
        } catch (Exception e) {
            System.out.println("Failed to check if element is enabled. Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isSelected(WebElement element) {
        try {
            boolean isSelected = element.isSelected();
            return isSelected;
        } catch (Exception e) {
            System.out.println("Failed to check if element is selected. Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void waitForElementToBeVisible(WebElement element, Duration timeout) {
        try {
            ensureWaitIsInitialized();
            wait.withTimeout(timeout).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Failed to wait for element to be visible. Error: " + e.getMessage());
        }
    }

    @Override
    public void waitForElementToBeClickable(WebElement element, Duration timeout) {
        try {
            ensureWaitIsInitialized();
            wait.withTimeout(timeout).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Failed to wait for element to be clickable. Error: " + e.getMessage());
        }
    }

    @Override
    public void waitForElementToBePresent(By locator, Duration timeout) {
        try {
            ensureWaitIsInitialized();
            wait.withTimeout(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Failed to wait for element to be present. Error: " + e.getMessage());
        }
    }

    @Override
    public void waitForElementToBeInvisible(WebElement element, Duration timeout) {
        try {
            ensureWaitIsInitialized();
            wait.withTimeout(timeout).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("Failed to wait for element to be invisible. Error: " + e.getMessage());
        }
    }

    @Override
    public void waitForElementToHaveText(WebElement element, String text, Duration timeout) {
        try {
            ensureWaitIsInitialized();
            wait.withTimeout(timeout).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            System.out.println("Failed to wait for element to have text. Error: " + e.getMessage());
        }
    }

    @Override
    public void executeJavaScript(String script, Object... args) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, args);
        } catch (Exception e) {
            System.out.println("Failed to execute JavaScript. Error: " + e.getMessage());
        }
    }

    @Override
    public void scrollIntoView(WebElement element) {
        try {
            executeJavaScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Failed to scroll into view. Error: " + e.getMessage());
        }
    }

    @Override
    public void highlightElement(WebElement element) {
        try {
            executeJavaScript("arguments[0].style.border='3px solid red';", element);
        } catch (Exception e) {
            System.out.println("Failed to highlight element. Error: " + e.getMessage());
        }
    }

    @Override
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Failed to accept alert. Error: " + e.getMessage());
        }
    }

    @Override
    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("Failed to dismiss alert. Error: " + e.getMessage());
        }
    }

    @Override
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            return text;
        } catch (Exception e) {
            System.out.println("Failed to get alert text. Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void selectByVisibleText(WebElement element, String text) {
        try {
            ensureElementIsInteractable(element);
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            System.out.println("Failed to select by visible text. Error: " + e.getMessage());
        }
    }

    @Override
    public void selectByIndex(WebElement element, int index) {
        try {
            ensureElementIsInteractable(element);
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            System.out.println("Failed to select by index. Error: " + e.getMessage());
        }
    }

    @Override
    public void selectByValue(WebElement element, String value) {
        try {
            ensureElementIsInteractable(element);
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            System.out.println("Failed to select by value. Error: " + e.getMessage());
        }
    }

    @Override
    public void navigateTo(String url) {
        try {
            driver.get(url);
            System.out.println("Navigated to URL: " + url);
        } catch (Exception e) {
            System.out.println("Failed to navigate to URL. Error: " + e.getMessage());
        }
    }

    @Override
    public void refreshPage() {
        try {
            driver.navigate().refresh();
            System.out.println("Page refreshed successfully.");
        } catch (Exception e) {
            System.out.println("Failed to refresh page. Error: " + e.getMessage());
        }
    }

    @Override
    public void navigateBack() {
        try {
            driver.navigate().back();
            System.out.println("Navigated back successfully.");
        } catch (Exception e) {
            System.out.println("Failed to navigate back. Error: " + e.getMessage());
        }
    }

    @Override
    public void navigateForward() {
        try {
            driver.navigate().forward();
            System.out.println("Navigated forward successfully.");
        } catch (Exception e) {
            System.out.println("Failed to navigate forward. Error: " + e.getMessage());
        }
    }

    @Override
    public void switchToWindow(String windowHandle) {
        try {
            driver.switchTo().window(windowHandle);
            System.out.println("Switched to window: " + windowHandle);
        } catch (Exception e) {
            System.out.println("Failed to switch to window. Error: " + e.getMessage());
        }
    }

    @Override
    public void closeCurrentWindow() {
        try {
            driver.close();
            System.out.println("Current window closed successfully.");
        } catch (Exception e) {
            System.out.println("Failed to close current window. Error: " + e.getMessage());
        }
    }

    @Override
    public Set<String> getWindowHandles() {
        try {
            Set<String> handles = driver.getWindowHandles();
            System.out.println("Retrieved window handles successfully.");
            return handles;
        } catch (Exception e) {
            System.out.println("Failed to get window handles. Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void uploadFile(WebElement uploadElement, String filePath) {
        try {
            uploadElement.sendKeys(filePath);
            System.out.println("File uploaded successfully from path: " + filePath);
        } catch (Exception e) {
            System.out.println("Failed to upload file. Error: " + e.getMessage());
        }
    }

    // Ensure wait is initialized
    private void ensureWaitIsInitialized() {
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized. Call setup() first.");
        }
    }

	@Override
	public void hoverOverElement(WebElement element) {
		 
		
	}

	@Override
	public String getText(WebElement element) {
		try {
			isDisplayed(element);
			return element.getText();
			
		} catch (Exception e) {
			System.out.println("Unable to Get Text. Error: " + e.getMessage());
			return null;
		}
		
	}

	@Override
	public void downLoadFile(WebElement element) {
		click(element);
		 try {
			 Robot robot = new Robot();
			 robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("Unable to Download file");
		}
		
	}
}