package com.miskevich.pages;

import com.miskevich.elements.MenuElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage {

    Logger log = Logger.getLogger(AuthorizationPage.class);

    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement loginUser;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordUser;

    @FindBy(xpath = "//button")
    private WebElement button;

    public boolean clickUser() {
        log.info("clickUser start");
        loginUser.click();
        loginUser.sendKeys("selenium_chrome");
        passwordUser.click();
        passwordUser.sendKeys("Axa@Demo");
        button.click();
        log.info("clickUser good");
        return true;
    }

    protected MenuElements menuElements = new MenuElements();

}
