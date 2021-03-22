package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification = "Please enter the required credentials to continue1";

    @FindBy(xpath = "//div[contains(@class,'flag')]")
    public WebElement selCountryCode;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement txtPhone;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement linkRegister;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement btnLogin;



    public void login(String country, String phoneNumber) throws InterruptedException {
        Report.scenario.createNode(When.class, "User login to system by phone: (" + country + ")" + " " + phoneNumber);
        selectItem(selCountryCode,country);
        fillIn(txtPhone,phoneNumber);
        click(btnLogin);
    }
}
