package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KYCVerificationPage extends BasePage{

    public KYCVerificationPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification1 = "You have successfully completed the KYC processs and we have received your documents";
    public String textVerification2 = "We have received your KYC documents";

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement btnContinue;
}
