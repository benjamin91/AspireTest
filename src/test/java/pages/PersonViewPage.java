package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonViewPage extends BasePage{
    public PersonViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Get Started']")
    public WebElement btnGetStarted;
}
