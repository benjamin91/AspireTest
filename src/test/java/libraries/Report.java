package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;

public class Report {
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest feature;
    public static ExtentTest scenario;
    public static ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/java/reports/report.html");

    public static void generateExtentReport(WebDriver driver, ITestResult testResult) throws IOException {
        switch (testResult.getStatus()) {
            case ITestResult.SUCCESS:
                feature.pass("Pass");
                break;
            case ITestResult.FAILURE:
                feature.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, testResult)).build());
                break;
            case ITestResult.SKIP:
                feature.skip("Skip");
                break;
            default:
                throw new RuntimeException("Invalid status");
        }
    }
}
