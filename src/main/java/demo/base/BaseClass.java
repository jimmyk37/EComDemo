package demo.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import demo.action.Action;
import demo.utility.ConfigReader;
import demo.utility.ExtentManager;

public class BaseClass extends ExtentManager {

    // ThreadLocal variable to hold WebDriver instance per thread
    private static ThreadLocal<WebDriver> idriver = new ThreadLocal<>();
    protected static Logger logger = Logger.getLogger(BaseClass.class);
    public static ExtentTest test;
    protected static WebDriver driver;   
    public static SoftAssert softAssert;

    @BeforeSuite
    public static void launchBrowser() {
        if (idriver.get() == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        chromeOptions.addArguments("--headless");
                    }
                    idriver.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        firefoxOptions.addArguments("--headless");
                    }
                    idriver.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        edgeOptions.addArguments("--headless");
                    }
                    idriver.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    throw new IllegalArgumentException("Browser type not supported: " + browser);
            }

            driver = idriver.get();
            // Set implicit wait and maximize window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));
            driver.manage().window().maximize();
         // Initialize ExtentReports
            ExtentManager.setExtent();
            logger.info("Extent Report initialized successfully.");
//            driver.get(ConfigReader.getProperty("url"));            
        }
    }
    
   

    @AfterSuite
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            idriver.remove();
        }

        // End the ExtentReports
        ExtentManager.endReport();
        logger.info("Extent Report flushed successfully.");
    }

    @BeforeMethod
    public void setUp(ITestResult result) {
        test = ExtentManager.extent.createTest(getClass().getSimpleName() + "." + result.getMethod().getMethodName());
        setLog("Test Case Started: " + result.getMethod().getMethodName());
        softAssert=new SoftAssert();
        
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
    	
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                
                test.log(Status.FAIL, "Test Case Failed: " + result.getMethod().getMethodName());
                test.log(Status.FAIL, "Failure Reason: " + result.getThrowable().getMessage());
                logger.info("Test Case Failed: " + result.getMethod().getMethodName());
                logger.info("Failure Reason: " + result.getThrowable().getMessage());
                String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
                test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                test.fail("Failed to capture screenshot. Error: " + e.getMessage());
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
            logger.info("Test Case Passed: " + result.getMethod().getMethodName());
            test.log(Status.INFO, "Test completed.");
        }
        
        
    }

    private String takeScreenshot(String methodName) throws IOException {
        // Capture screenshot
        Path screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath();
        String filePath = "screenshots/" + methodName + ".png";
        Path destinationFile = Paths.get(filePath);

        // Create directories if they don't exist
        Files.createDirectories(destinationFile.getParent());

        // Copy the screenshot to the destination
        Files.copy(screenshotFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);

        return filePath;
    }
    
    public static WebDriver getDriver() {return idriver.get();}
    
    public static void setLog(String log) {
    	logger.info(log);
    	test.log(Status.INFO, log);
    }
    
    
    
    
    
}
