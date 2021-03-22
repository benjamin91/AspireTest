package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import objects.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String textVerification = "We are excited to have you here. To get started, please enter your name, email and mobile number";

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement txtName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//div[contains(@class,'flag')]")
    public WebElement selCountryCode;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement txtPhone;

    @FindBy(xpath = "//div[@aria-label='Non-director']")
    public WebElement rdoNonDirector;

    @FindBy(xpath = "//div[@aria-label='Appointed director']")
    public WebElement rdoAppointedDirector;

    @FindBy(xpath = "//input[@data-cy='register-person-heard-about']/..")
    public WebElement selHearAboutUs;

    @FindBy(xpath = "//input[@data-cy='register-person-referral-code']")
    public WebElement txtReferralCode;

    @FindBy(xpath = "//div[contains(text(),'I have read and agree')]/../div[@role='checkbox']")
    public WebElement cbAgreePolicy;

    @FindBy(xpath = "//button//span[.='Continue']")
    public WebElement btnContinue;



    ////////////////METHODs/////////////////////

    public void selectRole(String role) {
        if (role.equalsIgnoreCase("Appointed director"))
            rdoAppointedDirector.click();
        else if (role.equalsIgnoreCase("Non-director"))
            rdoNonDirector.click();
        else System.err.println("Wrong role " + role);
    }

    public void fillRegistrationForm(UserInfo user) throws InterruptedException {
        Report.scenario.createNode(When.class, "User fill information into registration form");
        fillIn(txtName, user.getName());
        fillIn(txtEmail, user.getEmail());
        selectItem(selCountryCode, user.getCountry());
        fillIn(txtPhone, user.getPhoneNumber());
        selectRole(user.getRole());
        selectItem(selHearAboutUs, user.getHear());
        fillIn(txtReferralCode, user.getReferral());
        cbAgreePolicy.click();
    }
}
