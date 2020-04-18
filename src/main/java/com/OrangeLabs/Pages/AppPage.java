package com.OrangeLabs.Pages;

import com.OrangeLabs.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AppPage extends TestBase  {
    public AppPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[@class='TwyJFf']")
    WebElement CategoriesButton;

    @FindBy (linkText = "Education")
    WebElement EducationButton;

    public void chooseCategory()
    {
        CategoriesButton.click();
        EducationButton.click();
    }

}
