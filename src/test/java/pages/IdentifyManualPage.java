package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IdentifyManualPage extends BasePage{
    public IdentifyManualPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Begin Verification']")
    public WebElement btnBeginVerification;

    @FindBy(xpath = "//span[contains(text(),'Upload KTP')]/input")
    public WebElement btnUploadKTP;

    @FindBy(xpath = "//span[contains(text(),'Take a selfie')]/input")
    public WebElement btnTakeSelfie;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement btnContinue;

    /////////////////METHODs/////////////////


}
