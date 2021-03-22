package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class IncorporateSelectorPage extends BasePage {
    public IncorporateSelectorPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification = "Is your business incorporated in Singapore?";

    @FindBy(xpath = "//span[contains(text(),'Yes, my business is registered in Singapore with ACRA')]/../following-sibling::button")
    public WebElement btnContinueRegisteredBusiness;

    @FindBy(xpath = "//span[contains(text(),'I don’t have a business yet')]/../following-sibling::button")
    public WebElement btnContinueNoBusiness;

    @FindBy(xpath = "//button[.='Learn More']")
    public WebElement btnLearnMore;


}
