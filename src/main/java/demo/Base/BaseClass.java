package demo.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import demo.Action.Action;
import demo.Utility.ConfigReader;

public class BaseClass extends Action {
    
    // ThreadLocal variable to hold WebDriver instance per thread
    private static ThreadLocal<WebDriver> idriver = new ThreadLocal<>();

    public static WebDriver driver;
    

    @BeforeSuite		
    
    
    public void launchBrowser() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        chromeOptions.addArguments("--headless");
                    }
                    idriver.set(new ChromeDriver(chromeOptions));
                    driver =idriver.get();
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        firefoxOptions.addArguments("--headless");
                    }
                    idriver.set(new FirefoxDriver(firefoxOptions));
                    driver =idriver.get();
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        edgeOptions.addArguments("--headless");
                    }
                    idriver.set(new EdgeDriver(edgeOptions));
                    driver =idriver.get();
                    break;
                default:
                    throw new IllegalArgumentException("Browser type not supported: " + browser);
            }

            // Set implicit wait and maximize window
            driver.manage().timeouts().implicitlyWait(ConfigReader.getIntProperty("implicitWait"), TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
        }
    }

    @AfterSuite
    public void closeDriver() {
        if (driver != null) {
        	driver.quit();
            idriver.remove();
        }
    }

}
