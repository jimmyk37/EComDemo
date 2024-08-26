package demo.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ExtentManager class is used for Extent Report
 */
public class ExtentManager {

    private static final Logger logger = LoggerFactory.getLogger(ExtentManager.class);

    private static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        // Initialize ExtentReports
        if (extent == null) {
            extent = new ExtentReports();

            // Initialize ExtentSparkReporter
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport.html";
            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Results");
            sparkReporter.config().setReportName("RestAssured API Test Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent.attachReporter(sparkReporter);

            // Set system information
            extent.setSystemInfo("HostName", "MyHost");
            extent.setSystemInfo("ProjectName", "ECom Web Sample");
            extent.setSystemInfo("Tester", "Jimmy Gupta");
            extent.setSystemInfo("OS", "Win10");

            logger.info("Extent Report initialized successfully.");
        }
    }

    public static void endReport() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report flushed");
        } else {
            logger.warn("Extent Report is already null");
        }
        
    }
    
    
}
