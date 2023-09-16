package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatGridPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Grid & chart')]")
    private WebElement openChat;

    @FindBy(xpath = "//span[@title='1h64n65f2:14845']")
    private WebElement orderClick;

    @FindBy(xpath = "//span[@class='chart-settings__title chart-mobile-title']")
    private WebElement linesClick;

    public boolean chartClick() {
        log.info("chartClick start");
        openChat.click();
        log.info("chartClick good");
        return openChat.isDisplayed();
    }

    public boolean orderClick() {
        orderClick.click();
        return orderClick.isDisplayed();

    }

    public boolean linesClick() {
        linesClick.click();
        return linesClick.isDisplayed();

    }

    public ChatGridPage() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

}
