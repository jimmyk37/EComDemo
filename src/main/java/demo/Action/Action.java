package demo.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Action implements Interactions {

	protected WebDriver driver;
	private Actions actions;


	@Override
	public void click(WebElement element) {
		try {
			actions.click(element).perform();
			System.out.println("Successfully clicked on Element");
		} catch (Exception e) {
			System.out.println("Unable to click on Element");
		}

	}

	@Override
	public void doubleClick(WebElement element) {

		try {
			actions.doubleClick(element).perform();
			System.out.println("Successfully double clicked on Element");
		} catch (Exception e) {
			System.out.println("Unable to double click on Element");
		}

	}

	@Override
	public void contextClick(WebElement element) {

		try {
			actions.contextClick(element).perform();
			System.out.println("Successfully Right clicked on Element");
		} catch (Exception e) {
			System.out.println("Unable to Right click on Element");
		}

	}

	@Override
	public void sendKeys(WebElement element, CharSequence... keysToSend) {

		try {
			actions.sendKeys(element, keysToSend).perform();
			System.out.println("Successfully entered text");
		} catch (Exception e) {
			System.out.println("Unable to enter text");
		}

	}

	@Override
	public void moveToElement(WebElement element) {

		try {
			actions.moveToElement(element).perform();
			System.out.println("Successfully moved to element");
		} catch (Exception e) {
			System.out.println("Unable to move");
		}
	}

	@Override
	public void moveToElement(WebElement element, int xOffset, int yOffset) {
		try {
			actions.moveToElement(element, xOffset, yOffset).perform();
			System.out.println("Successfully moved to element");
		} catch (Exception e) {
			System.out.println("Unable to move");
		}

	}

	@Override
	public void dragAndDrop(WebElement source, WebElement target) {
		try {
			actions.dragAndDrop(source, target).perform();
			System.out.println("Successfully performed Drag&Drop Action");
		} catch (Exception e) {
			System.out.println("Unable to perform Drag&Drop Action");
		}

	}

	@Override
	public void dragAndDropBy(WebElement source, int xOffset, int yOffset) {
		try {
			actions.dragAndDropBy(source, xOffset, yOffset).perform();
			System.out.println("Successfully performed Drag&Drop Action");
		} catch (Exception e) {
			System.out.println("Unable to perform Drag&Drop Action");
		}

	}

	@Override
	public void keyDown(WebElement element, Keys key) {
		try {
			actions.keyDown(element, key).perform();
			System.out.println("Successfully performed KeyDown Action");
		} catch (Exception e) {
			System.out.println("Unable to perform KeyDown Action");
		}

	}

	@Override
	public void keyUp(WebElement element, Keys key) {
		try {
			actions.keyUp(element, key).perform();
			System.out.println("Successfully performed KeyDown Action");
		} catch (Exception e) {
			System.out.println("Unable to perform KeyDown Action");
		}

	}

	@Override
	public void pause(long time) {
		try {
			actions.pause(time).perform();
			System.out.println("Successfully performed Pause Action");
		} catch (Exception e) {
			System.out.println("Unable to perform Pause Action");
		}

	}

	@Override
	public void scrollByAmount(int xOffset, int yOffset) {
		try {
			actions.scrollByAmount(xOffset, yOffset).perform();
			System.out.println("Successfully performed Scroll Action");
		} catch (Exception e) {
			System.out.println("Unable to perform Scroll Action");
		}

	}

	@Override
	public void scrollToElement(WebElement element) {
		try {
			actions.scrollToElement(element).perform();
			System.out.println("Successfully performed Scroll Action");
		} catch (Exception e) {
			System.out.println("Unable to perform Scroll Action");
		}

	}

	@Override
	public void clickAndHold(WebElement element) {
		try {
			actions.clickAndHold(element).perform();
			System.out.println("Successfully performed clickAndHold Action");
		} catch (Exception e) {
			System.out.println("Unable to perform clickAndHold Action");
		}

	}

	@Override
	public void release(WebElement element) {
		try {
			actions.release(element).perform();
			System.out.println("Successfully performed clickAndHold Action");
		} catch (Exception e) {
			System.out.println("Unable to perform clickAndHold Action");
		}

	}

	@Override
	public void clear(WebElement element) {
		try {
			element.clear();
			System.out.println("Successfully cleared field");
		} catch (Exception e) {
			System.out.println("Unable to clear field");
		}

	}

	@Override
	public void submit(WebElement element) {
		try {
			element.submit();
			System.out.println("Successfully submitted");
		} catch (Exception e) {
			System.out.println("Unable to submit");
		}

	}

	@Override
	public void selectByVisibleText(WebElement element, String text) {
		try {
			new Select(element).selectByVisibleText(text);
			System.out.println("Successfully selected");
		} catch (Exception e) {
			System.out.println("Unable to select");
		}

	}

	@Override
	public void selectByIndex(WebElement element, int index) {
		try {
			new Select(element).selectByIndex(index);
			;
			System.out.println("Successfully selected");
		} catch (Exception e) {
			System.out.println("Unable to select");
		}

	}

	@Override
	public void selectByValue(WebElement element, String value) {
		try {
			new Select(element).selectByValue(value);
			System.out.println("Successfully selected");
		} catch (Exception e) {
			System.out.println("Unable to select");
		}

	}

	@Override
	public void hoverOverElement(WebElement element) {
		try {
			actions.moveToElement(element).perform();
			System.out.println("Successfully performed hover Action");
		} catch (Exception e) {
			System.out.println("Unable to hover");
		}

	}

	@Override
	public void switchToFrame(WebElement frameElement) {

		try {
			driver.switchTo().frame(frameElement);
			System.out.println("Successfully switched to frame");
		} catch (Exception e) {
			System.out.println("Unable to switch");
		}

	}

	@Override
	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Successfully switched to frame");
		} catch (Exception e) {
			System.out.println("Unable to switch");
		}

	}

	@Override
	public String getText(WebElement element) {

		try {
			String text = element.getText();
			System.out.println("Successfully getText");
			return text;

		} catch (Exception e) {
			System.out.println("Successfully getText");
			return null;

		}
	}

	@Override
	public String getAttribute(WebElement element, String attribute) {
		try {
			String text = element.getAttribute(attribute);
			System.out.println("Successfully getText");
			return text;

		} catch (Exception e) {
			System.out.println("Successfully getText");
			return null;

		}
	}

	@Override
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    @Override
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    @Override
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    @Override
    public void waitForElementToBeVisible(WebElement element, Duration timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForElementToBePresent(By locator, Duration timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Override
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Override
    public void takeScreenshot(String screenshotName) {
    	String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
			try (FileOutputStream out = new FileOutputStream(filePath)) {
				out.write(Files.readAllBytes(screenshot.toPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    @Override
    public void executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }

    @Override
    public void selectCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Override
    public void deselectCheckbox(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Override
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Override
    public void navigateBack() {
        driver.navigate().back();
    }

    @Override
    public void navigateForward() {
        driver.navigate().forward();
    }}
