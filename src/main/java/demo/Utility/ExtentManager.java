package demo.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ExtentManager class is used for Extent Report
 */
public class ExtentManager {

    private static final Logger logger = LoggerFactory.getLogger(ExtentManager.class);
    
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
//    public static ExtentTest test;

    public static void setExtent() throws IOException {
        // Initialize ExtentHtmlReporter
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport/" + "MyReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);

        // Optional: Customize the report
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Demoblaze Test Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "Demoblaze");
        extent.setSystemInfo("Tester", "Jimmy Gupta");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");

        logger.info("Extent Report initialized");
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