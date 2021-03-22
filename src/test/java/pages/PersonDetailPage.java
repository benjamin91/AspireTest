package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import libraries.Utils;
import objects.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class PersonDetailPage extends BasePage{
    public PersonDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Provide your KTP number']")
    public WebElement txtCardNumber;

    @FindBy(xpath = "//input[@placeholder='Set your date of birth']")
    public WebElement txtDOB;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[1]")
    public WebElement btnPreviousMonths;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[2]")
    public WebElement btnSelectMonth;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[3]")
    public WebElement btnNextMonth;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[4]")
    public WebElement btnPreviousYear;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[5]")
    public WebElement btnSelectYear;

    @FindBy(xpath = "(//div[contains(@class,'q-date__navigation')]//button)[6]")
    public WebElement btnNextYear;

    @FindBy(xpath = "(//div[contains(@class,'q-date__years')]//i)[1]")
    public WebElement btnPreviousYearPeriod;

    @FindBy(xpath = "//div[contains(@class,'q-date__years-item')]//button")
    public List<WebElement> btnYear;

    @FindBy(xpath = "(//div[contains(@class,'q-date__years')]//i)[2]")
    public WebElement btnNextYearPeriod;

    @FindBy(xpath = "//div[contains(@class,'q-date__months-item')]")
    public List<WebElement> btnMonth;

    @FindBy(xpath = "//div[contains(@class,'q-date__calendar-item--in')]")
    public List<WebElement> btnDay;

    @FindBy(xpath = "//input[@placeholder='Select any of the following']")
    public WebElement selNationality;

    @FindBy(xpath = "//div[@data-cy='kyc-gender']//input")
    public WebElement selGender;

    @FindBy(xpath = "//div[@label='Which products are you interested in?']//div[@data-cy='person-edit-purposes']")
    public WebElement selInterestedProducts;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement btnSubmit;


    //////////////////METHODs/////////////////////

    public void selectYear(int year) throws InterruptedException {
        if (!btnSelectYear.getText().equals(year)) {
            btnSelectYear.click();
            Thread.sleep(1000);
            while (Integer.parseInt(btnYear.get(0).getText()) > year) {
                System.out.println(Integer.parseInt(btnYear.get(1).getText()));
                btnPreviousYearPeriod.click();
            }
            Utils.getElement("xpath", "//div[contains(@class,'q-date__years-item')]//button[.='"+ year + "']").click();
        }
    }

    public void selectMonth(Month month) {
        if (!btnSelectMonth.getText().equalsIgnoreCase(String.valueOf(month))) {
            btnSelectMonth.click();
            btnMonth.get(month.getValue() - 1).click();
        }
    }

    public void selectDay(int day) {
        btnDay.get(day - 1).click();
    }

    public void selectDOB(String date) throws InterruptedException {
        txtDOB.click();
        LocalDate localDate = LocalDate.parse(date);
        selectYear(localDate.getYear());
        selectMonth(localDate.getMonth());
        selectDay(localDate.getDayOfMonth());
    }

    public void fillPersonDetail(UserInfo user) throws InterruptedException {
        Report.scenario.createNode(When.class, "Fill user information detail");
        fillIn(txtCardNumber, user.getCardNumber());
        selectDOB(user.getDob());
        selectItem(selNationality,user.getNationality(), user.getNationality());
        selectItem(selGender, user.getGender());
        Utils.selectMultipleItems(selInterestedProducts, user.getInterestedProducts());
    }
}
