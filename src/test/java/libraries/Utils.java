package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.curiousoddman.rgxgen.RgxGen;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import pages.BasePage;
import test.BaseTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils extends BaseTest {
    private static String imagePath = System.getProperty("user.dir") + "/src/test/java/reports/images";
    public static int timeout;

    static {
        try {
            timeout = Integer.parseInt(getProperty("config.properties", "timeout"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getProjectPath() +  "/src/test/java/configurations/drivers/chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", getProjectPath() + "/src/test/java/configurations/drivers/geckodriver.exe");
            return new FirefoxDriver();
        }
        else System.err.println(browser + " is not supported");
        return null;
    }

    public static String getProperty(String fileName, String key) throws IOException {
        Properties property = new Properties();
        FileInputStream file = new FileInputStream(getProjectPath() + "/src/test/java/configurations/" + fileName);
        property.load(file);
        return (String) property.get(key);
    }

    public static Iterator<Object[]> LoadDataProvider(String fileName) {
        String line = "";
        String splitBy =";";
        List<Object[]> dataProvider = new ArrayList<>();
        int iteration = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(getProjectPath() + "\\src\\test\\java\\data\\" + fileName));
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] data = line.split(splitBy);
                dataProvider.add(data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return dataProvider.iterator();
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void selectMultipleItems(WebElement el, List<String> items) {
        el.click();
        for(String item:items) {
            getElement("xpath", "//div[contains(text(),'" + item + "')]").click();
        }
        el.click();
    }

    public static WebElement getElement(String type, String locator) {
        WebElement el = null;
        if (type.equalsIgnoreCase("xpath"))
            el = driver.findElement(By.xpath(locator));
        else if (type.equalsIgnoreCase("css"))
            el = driver.findElement(By.cssSelector(locator));
        else System.err.println("Wrong input: " + type + " - " + locator);
        return el;
    }

    public static String generateEUN(String regex){
        return new RgxGen(regex).generate();
    }

    public static By getLocator(WebElement el) {
        String method = el.toString().split("-> ")[1].split(": ")[0];
        String selector_temp = el.toString().split(": ")[2];
        String selector = selector_temp.substring(0, selector_temp.length() - 1);
        if (method.equals("xpath")) return By.xpath(selector);
        else if (method.equals("css selector")) return By.cssSelector(selector);
        else return null;
    }

    public static String takeScreenShot(WebDriver driver, ITestResult testResult) throws IOException {
        String screenShotFile = null;
        String tc_name = testResult.getMethod().getConstructorOrMethod().getName();
        String dateFormat = new SimpleDateFormat("ddMMYYY_hhmmss").format(Calendar.getInstance().getTime());
        screenShotFile = imagePath + "/ScreenShot_" + tc_name + "_" + dateFormat + ".png";

        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotFile));
        }
        return screenShotFile;
    }
}
