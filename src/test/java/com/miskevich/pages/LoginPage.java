package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement loginUser;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordUser;

    @FindBy(xpath = "//button")
    private WebElement button;


    public boolean inputUser() {
        log.info("inputUser start");
        loginUser.click();
        loginUser.sendKeys("selenium_chrome");
        passwordUser.click();
        passwordUser.sendKeys("Axa@Demo");
        button.click();
        log.info("inputUser good");
        return button.isDisplayed();
    }

    public LoginPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
