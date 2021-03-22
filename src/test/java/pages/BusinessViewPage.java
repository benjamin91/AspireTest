package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BusinessViewPage extends BasePage{
    public BusinessViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement btnContinue;


}
