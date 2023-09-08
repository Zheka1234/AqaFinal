package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.enums.MenuItem;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeltixuatPage extends BasePage {

    Logger log = Logger.getLogger(DeltixuatPage.class);


    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement loginUser;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordUser;

    @FindBy(xpath = "//button")
    private WebElement button;

    @FindBy(xpath = "//a[@href='/settings']")
    private WebElement settingButton;

    @FindBy(xpath = "//div[@class='app-title']")
    private WebElement checkMenu;

    public boolean clickUser() {
        log.info("clickUser start");
        loginUser.click();
        loginUser.sendKeys("selenium_chrome");
        return loginUser.isDisplayed();
    }

    public boolean clickPassword() {
        log.info("clickPassword start");
        passwordUser.click();
        passwordUser.sendKeys("Axa@Demo");
        return passwordUser.isDisplayed();
    }

    public boolean buttonClick(){
        log.info("buttonClick start");
        button.click();
        return button.isDisplayed();
    }


    public boolean checkSetting(){
        log.info("checkSetting start");

        return settingButton.isDisplayed();
    }

    public boolean checkMenuElements(){
        log.info("checkMenuElements start");
        menuElements.checkItem(MenuItem.SUMMARY);
        menuElements.checkItem(MenuItem.GRID_AND_CHAT);
        menuElements.checkItem(MenuItem.SCATTER_PLOT);
        menuElements.checkItem(MenuItem.REPORTS);
        menuElements.checkItem(MenuItem.HISTOGRAM);
        return true;

    }

    public DeltixuatPage(){
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
