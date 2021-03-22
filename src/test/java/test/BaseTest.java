package test;

import libraries.Report;
import libraries.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public String browser;
    public String baseURL;

    @BeforeTest
    public void init() throws IOException {
        browser = Utils.getProperty("config.properties", "browser");
        driver = Utils.openBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Utils.timeout, TimeUnit.SECONDS);
        baseURL = Utils.getProperty("config.properties", "baseUrl");
        driver.get(baseURL);
    }

    @BeforeMethod
    public void initMethod(ITestResult testResult) {
        Report.extent.attachReporter(Report.spark);
        Report.feature = Report.extent.createTest(testResult.getMethod().getMethodName());
    }

    @AfterTest
    public void End() {
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        Report.generateExtentReport(driver, testResult);
        Report.extent.flush();
    }
}
