package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IdentifyViewPage extends BasePage {
    public IdentifyViewPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification = "Please be ready to provide the following documents for identity verification";

    @FindBy(xpath = "//button[.='Get Started']")
    public WebElement btnGetStarted;
}
