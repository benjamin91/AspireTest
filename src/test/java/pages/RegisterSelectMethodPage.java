package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSelectMethodPage extends BasePage{
    public RegisterSelectMethodPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'MyInfo Registration')]/following-sibling::button")
    public WebElement btnMyInfoRegistration;

    @FindBy(xpath = "//div[contains(text(),'Standard Registration')]/following-sibling::button")
    public WebElement btnStandardRegistration;


}
