package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatGridPage extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Grid & chart')]")
    private WebElement openChat;

    @FindBy(xpath = "//div[@row-index='3']//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value']")
    private WebElement orderClick;

    @FindBy(xpath = "//span[@class='chart-settings__title chart-mobile-title']")
    private WebElement linesClick;

    @FindBy(xpath = "//div[@class='d-flex flex-wrap']//div[@class='d-flex align-items-center']//div[@class='legend-container__item-value']")
    private WebElement midPrice;

    @FindBy(xpath = "//div[@class='d-flex flex-wrap']//div[@class='d-flex align-items-center']//div[@class='legend-container__item-value']")
    private WebElement mid;


    public boolean chartClick() {
        log.info("chartClick start");
        openChat.click();
        log.info("chartClick good");
        return openChat.isDisplayed();
    }

    public void orderClick() {
        orderClick.click();

    }

    public boolean linesClick() {
        linesClick.click();
        return linesClick.isDisplayed();

    }

    public ChatGridPage() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

}
