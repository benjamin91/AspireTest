package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class OTPVerificationPage extends BasePage{
    public OTPVerificationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'digit-input__box')]/div")
    public List<WebElement> txtOTP;

    @FindBy(xpath = "(//div[contains(@class,'digit-input__box')]/div)[1]")
    public WebElement txtOTP1;



    /////////////////METHODs///////////////

    public void inputOTP() throws InterruptedException {
        Report.scenario.createNode(When.class, "Input OTP for verification");
        waitForElementVisible(txtOTP.get(0));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.NUMPAD1).perform();
        actions.sendKeys(Keys.NUMPAD2).perform();
        actions.sendKeys(Keys.NUMPAD3).perform();
        actions.sendKeys(Keys.NUMPAD4).perform();
    }
}
