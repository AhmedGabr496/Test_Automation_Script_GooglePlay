package com.OrangeLabs.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.OrangeLabs.Base.TestBase;
import com.OrangeLabs.Pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomePageTest extends TestBase {
    public HomePageTest() throws IOException {
        super();
    }
    HomePage homePage ;
    boolean assert_res = false;
    @BeforeMethod
    public void setup(Method method) throws ATUTestRecorderException {
        intialize(pro.getProperty("browser"));
        logger = extent.startTest(method.getName());
        recorder = new ATUTestRecorder("Report\\", method.getName(), false);
        recorder.start();
    }

    @Test (priority = 1)
    public void checkUrl() throws IOException {
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl=pro.getProperty("HomePage");
        Assert.assertEquals(ActualUrl,ExpectedUrl);
        assert_res = true;
    }
    @Test (priority = 2)
    public void AppsButton() throws IOException {
        Assert.assertTrue(assert_res);
        homePage = new HomePage();
        homePage.ClickOnAppsButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,pro.getProperty("AppPage"));
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
