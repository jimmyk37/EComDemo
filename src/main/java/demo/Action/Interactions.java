package demo.Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface Interactions {
    void click(WebElement element);
    void doubleClick(WebElement element);
    void contextClick(WebElement element);
    void sendKeys(WebElement element, CharSequence... keysToSend);
    void moveToElement(WebElement element);
    void moveToElement(WebElement element, int xOffset, int yOffset);
    void dragAndDrop(WebElement source, WebElement target);
    void dragAndDropBy(WebElement source, int xOffset, int yOffset);
    void keyDown(WebElement element, Keys key);
    void keyUp(WebElement element, Keys key);
    void pause(long time);
    void scrollByAmount(int xOffset, int yOffset);
    void scrollToElement(WebElement element);
    void clickAndHold(WebElement element);
    void release(WebElement element);
    void clear(WebElement element);
    void submit(WebElement element);
    void selectByVisibleText(WebElement element, String text);
    void selectByIndex(WebElement element, int index);
    void selectByValue(WebElement element, String value);
    void hoverOverElement(WebElement element);
    void switchToFrame(WebElement frameElement);
    void switchToDefaultContent();
    String getText(WebElement element);
    String getAttribute(WebElement element, String attribute);
    boolean isDisplayed(WebElement element);
    boolean isEnabled(WebElement element);
    boolean isSelected(WebElement element);
    void waitForElementToBeVisible(WebElement element, Duration timeoutInSeconds);
    void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds);
    void waitForElementToBePresent(By locator, Duration timeoutInSeconds);
    void acceptAlert();
    void dismissAlert();
    String getAlertText();
    void takeScreenshot(String filePath);
    void highlightElement(WebElement element);
    void executeJavaScript(String script, Object... args);
    void selectCheckbox(WebElement checkbox);
    void deselectCheckbox(WebElement checkbox);
    void navigateTo(String url);
    void refreshPage();
    void navigateBack();
    void navigateForward();
}
