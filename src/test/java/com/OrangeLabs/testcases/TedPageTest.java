package com.OrangeLabs.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.OrangeLabs.Base.TestBase;
import com.OrangeLabs.Pages.AppPage;
import com.OrangeLabs.Pages.EducationPage;
import com.OrangeLabs.Pages.HomePage;
import com.OrangeLabs.Pages.TedPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TedPageTest extends TestBase {
    HomePage homePage;
    AppPage appPage;
    EducationPage educationPage;
    TedPage tedPage;
    public TedPageTest() throws IOException {
    super();
    }
    @BeforeMethod
    public void setup(Method method) throws ATUTestRecorderException, IOException, InterruptedException {
        intialize(pro.getProperty("browser"));
        homePage = new HomePage();
        appPage = new AppPage();
        educationPage = new EducationPage();
        logger = extent.startTest(method.getName());
        recorder = new ATUTestRecorder("Report\\", method.getName(), false);
        recorder.start();
        homePage.ClickOnAppsButton();
        appPage.chooseCategory();
        educationPage.searchapp();
    }
    @Test

    public void ChooseTedApp() throws IOException {
        tedPage = new TedPage();
        tedPage.SelectApp();
        String ActualUrl= driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,pro.getProperty("TedPage"));
    }

    @AfterMethod
    public void endAll(Method method , ITestResult result) throws IOException, ATUTestRecorderException {
        Screenshot(method.getName());
        if (result.getStatus()==ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "TestPassed");
            logger.log(LogStatus.PASS, "<a href = '" + result.getName() + ".png" + "'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.PASS, "<a href = '" + result.getName() + ".mov" + "'><span class='lable info'>Download video</span></a>");

        }
        else if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(LogStatus.FAIL, "TestPassed");
            logger.log(LogStatus.FAIL, "<a href = '" + result.getName() + ".png" + "'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.FAIL, "<a href = '" + result.getName() + ".mov" + "'><span class='lable info'>Download video</span></a>");
        }
        else {
            logger.log(LogStatus.SKIP,"Test Skipped"+result.getThrowable());

        }
        recorder.stop();
        driver.quit();
    }
}
