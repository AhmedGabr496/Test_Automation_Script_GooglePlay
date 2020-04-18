package com.OrangeLabs.Pages;

import com.OrangeLabs.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class EducationPage extends TestBase {
    public EducationPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gbqfq")
    WebElement SearchBar ;
    @FindBy(xpath = "//Button[@aria-label='Google Search']")
    WebElement SearchButton;

    public void searchapp() throws InterruptedException {
        Thread.sleep(3000);

        SearchBar.sendKeys(pro.getProperty("APP"));
        Thread.sleep(3000);
        SearchButton.click();
    }
}
