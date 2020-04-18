package com.OrangeLabs.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.OrangeLabs.Base.TestBase;
import com.OrangeLabs.Pages.AppPage;
import com.OrangeLabs.Pages.EducationPage;
import com.OrangeLabs.Pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class EducationPageTest extends TestBase {

    public EducationPageTest() throws IOException {
        super();
    }
    HomePage homePage;
    AppPage appPage;
    EducationPage educationPage;
    @BeforeMethod
    public void setup(Method method) throws ATUTestRecorderException, IOException, InterruptedException {
        intialize(pro.getProperty("browser"));
        homePage = new HomePage();
        appPage = new AppPage();
        logger = extent.startTest(method.getName());
        recorder = new ATUTestRecorder("Report\\", method.getName(), false);
        recorder.start();
        homePage.ClickOnAppsButton();
        appPage.chooseCategory();
        WebDriverWait wait = new WebDriverWait(driver,10);
    }
    @Test
    public void searchTed() throws IOException, InterruptedException {
        educationPage = new EducationPage();
        educationPage.searchapp();
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
