package com.OrangeLabs.Pages;

import com.OrangeLabs.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TedPage extends TestBase {

    public TedPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@title='TED'])[2]")
    WebElement TedApp;

    public void SelectApp()
    {
        TedApp.click();
    }



}
