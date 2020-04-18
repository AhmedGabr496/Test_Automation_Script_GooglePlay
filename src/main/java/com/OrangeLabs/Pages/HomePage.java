package com.OrangeLabs.Pages;

import com.OrangeLabs.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage  extends TestBase{
    public HomePage() throws IOException
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[@jsname='r4nke'])[2]")
    WebElement appsButton;

    public void ClickOnAppsButton()
    {
        appsButton.click();
    }
}
