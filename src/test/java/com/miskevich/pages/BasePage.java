package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.elements.MenuElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class BasePage {

    Logger log = Logger.getLogger(BasePage.class);

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
        return loginUser.isDisplayed();
    }

    public boolean clickPassword() {
        log.info("clickUser start");
        passwordUser.click();
        passwordUser.sendKeys("Axa@Demo");
        return passwordUser.isDisplayed();
    }

    public boolean buttonClick() {
        log.info("clickUser start");
        button.click();
        return button.isDisplayed();
    }

    protected MenuElements menuElements = new MenuElements();

    protected WebElement waitForElementIsVisible(By by) {
        WebElement item = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return item;
    }
}
