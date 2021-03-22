package pages;

import com.aventstack.extentreports.gherkin.model.When;
import libraries.Report;
import objects.Business;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusinessDetailPage extends BasePage{
    public BusinessDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@data-cy,'business-name')]")
    public WebElement txtBusinessName;

    @FindBy(xpath = "//input[@data-cy='register-business-registration-type']")
    public WebElement ddlParentType;

    @FindBy(xpath = "//div[contains(@data-cy,'business-sub-registration-type')]//i")
    public WebElement ddlSubType;

    @FindBy(xpath = "//input[contains(@data-cy,'business-registration-number')]")
    public WebElement txtUEN;

    @FindBy(xpath = "//input[contains(@data-cy,'website-url')]")
    public WebElement txtWebsite;

    @FindBy(xpath = "//div[contains(@aria-label,'website')]//input[@type='checkbox']")
    public WebElement cbNoWebsite;

    @FindBy(xpath = "//input[contains(@data-cy,'business-model')]")
    public WebElement txtBusinessModel;

    @FindBy(xpath = "(//div[contains(@data-cy,'business-industry')])[2]")
    public WebElement ddlIndustry;

    @FindBy(xpath = "(//div[contains(@data-cy,'business-sub-industry')])[2]")
    public WebElement ddlSubIndustry;

    @FindBy(xpath = "//div[contains(@class,'q-item__section')]/div")
    public List<WebElement> ddlItems;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//i[@role='presentation']")
    public WebElement ddlArrow;



    ///////////METHODs////////////

    public void fillBusinessDetail(Business business) throws InterruptedException {
        Report.scenario.createNode(When.class, "Fill business detail into form");
        waitForElementVisible(ddlArrow);
        fillIn(txtBusinessName, business.getName());
        selectBusinessType(business.getType());
        fillIn(txtUEN, business.getNumberUEN());
        fillIn(txtWebsite, business.getWebsite());
        selectIndustry(business.getIndustry());
    }

    public void selectBusinessType(String type) throws InterruptedException {
        waitForElementVisible(ddlArrow);
        selectItem(ddlParentType, type);
        ddlSubType.click();
        waitForElementVisible(ddlItems.get(0));
        ddlItems.get(0).click();
    }

    public void selectIndustry(String industry) throws InterruptedException {
        waitForElementVisible(ddlArrow);
        selectItem(ddlIndustry, industry);
//        ddlSubIndustry.click();
        click(ddlSubIndustry);
        waitForElementVisible(ddlItems.get(0));
//        Thread.sleep(500);
//        ddlItems.get(0).click();
        click(ddlItems.get(0));
    }
}
