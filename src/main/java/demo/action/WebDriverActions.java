package demo.action;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface WebDriverActions {
    // Basic Actions
    void click(WebElement element);
    void sendKeys(WebElement element, CharSequence... keysToSend);
    void clear(WebElement element);
    void submit(WebElement element);
    String getText(WebElement element);
    public void hoverOverElement(WebElement element);
    public void downLoadFile(WebElement element);

    // Element Visibility and Interaction
    boolean isDisplayed(WebElement element);
    boolean isEnabled(WebElement element);
    boolean isSelected(WebElement element);

    // Waits
    void waitForElementToBeVisible(WebElement element, Duration timeout);
    void waitForElementToBeClickable(WebElement element, Duration timeout);
    void waitForElementToBePresent(By locator, Duration timeout);
    void waitForElementToBeInvisible(WebElement element, Duration timeout);
    void waitForElementToHaveText(WebElement element, String text, Duration timeout);

    // JavaScript Actions
    void executeJavaScript(String script, Object... args);

    // Element Interaction Enhancements
    void scrollIntoView(WebElement element);
    void highlightElement(WebElement element);

    // Handling Alerts
    void acceptAlert();
    void dismissAlert();
    String getAlertText();

    // Form Actions
    void selectByVisibleText(WebElement element, String text);
    void selectByIndex(WebElement element, int index);
    void selectByValue(WebElement element, String value);

    // Navigation
    void navigateTo(String url);
    void refreshPage();
    void navigateBack();
    void navigateForward();

    // Browser Window Handling
    void switchToWindow(String windowHandle);
    void closeCurrentWindow();
    Set<String> getWindowHandles();

    // File Upload
    void uploadFile(WebElement uploadElement, String filePath);
}
