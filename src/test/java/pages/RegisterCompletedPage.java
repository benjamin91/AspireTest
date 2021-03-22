package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterCompletedPage extends BasePage{
    public RegisterCompletedPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification = "You have successfully verified your email";

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement btnContinue;


}
