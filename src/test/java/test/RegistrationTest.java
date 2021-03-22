package test;

import com.aventstack.extentreports.gherkin.model.Scenario;
import libraries.Report;
import libraries.Utils;
import objects.Business;
import objects.UserInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.Iterator;

public class RegistrationTest extends BaseTest{

    @DataProvider(name = "userInfo")
    public Iterator<Object[]> getUserInfo() {
        return Utils.LoadDataProvider("userInfo.csv");
    }

    @Test(dataProvider = "userInfo")
    public void Registration(String name,
                             String country,
                             String role,
                             String hear,
                             String referral,
                             String card,
                             String dob,
                             String gender,
                             String interestedProducts,
                             String businessType,
                             String businessModel,
                             String businessIndustry) throws InterruptedException {

        Report.scenario = Report.feature.createNode(Scenario.class, "Register a account");

        UserInfo user = new UserInfo(name, country, role, hear, referral, card, dob, gender,interestedProducts);
        System.out.println(user.getPhoneNumber());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.click(loginPage.linkRegister);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        //fill information for registration form
        registrationPage.fillRegistrationForm(user);
        registrationPage.click(registrationPage.btnContinue);

        //input Mobile OTP
        OTPVerificationPage otpVerificationPage = new OTPVerificationPage(driver);
        otpVerificationPage.inputOTP();

        //Register completed, click Continue
        RegisterCompletedPage registerCompletedPage = new RegisterCompletedPage(driver);
        registerCompletedPage.verifyPageContainText(registerCompletedPage.textVerification);
        registerCompletedPage.click(registerCompletedPage.btnContinue);

        //Register Business
        IncorporateSelectorPage incorporateSelectorPage = new IncorporateSelectorPage(driver);
        incorporateSelectorPage.verifyPageContainText(incorporateSelectorPage.textVerification);
        incorporateSelectorPage.click(incorporateSelectorPage.btnContinueRegisteredBusiness);

        RegisterSelectMethodPage registerSelectMethodPage = new RegisterSelectMethodPage(driver);
        registerSelectMethodPage.click(registerSelectMethodPage.btnStandardRegistration);

        //fill person deail
        PersonViewPage personViewPage = new PersonViewPage(driver);
        personViewPage.click(personViewPage.btnGetStarted);
        PersonDetailPage personDetailPage = new PersonDetailPage(driver);
        personDetailPage.fillPersonDetail(user);
        personDetailPage.click(personDetailPage.btnSubmit);

        //fill business
        BusinessViewPage businessViewPage = new BusinessViewPage(driver);
        businessViewPage.click(businessViewPage.btnContinue);

        Business business = new Business(name, businessType, businessModel, businessIndustry);
        user.setBusiness(business);
        BusinessDetailPage businessDetailPage = new BusinessDetailPage(driver);
        businessDetailPage.fillBusinessDetail(user.getBusiness());
        businessDetailPage.click(businessDetailPage.btnSubmit);

        //Identify View
        IdentifyViewPage identifyViewPage = new IdentifyViewPage(driver);
        identifyViewPage.verifyPageContainText(identifyViewPage.textVerification);
        identifyViewPage.click(identifyViewPage.btnGetStarted);

        IdentifyManualPage identifyManualPage = new IdentifyManualPage(driver);
        identifyManualPage.click(identifyManualPage.btnBeginVerification);

        //Upload
        identifyManualPage.uploadDocument(identifyManualPage.btnUploadKTP, Utils.getProjectPath() + "./src/test/java/data/front.PNG");
        identifyManualPage.click(identifyManualPage.btnContinue);

        //Take Selfie
        identifyManualPage.uploadDocument(identifyManualPage.btnTakeSelfie, Utils.getProjectPath() + "./src/test/java/data/selfie.PNG");
        identifyManualPage.click(identifyManualPage.btnContinue);

        KYCVerificationPage kycVerificationPage = new KYCVerificationPage(driver);
        kycVerificationPage.verifyPageContainText(kycVerificationPage.textVerification1);
        kycVerificationPage.click(kycVerificationPage.btnContinue);
        kycVerificationPage.verifyPageContainText(kycVerificationPage.textVerification2);
    }
}
