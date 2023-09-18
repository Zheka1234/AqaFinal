package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OrdersGridPage extends AuthorizationPage {

    @FindBy(xpath = "//span[@class='ml-1'][contains(text(),'Filters')]")
    private WebElement clickFilter;

    @FindBy(xpath = "//div[@class='ag-column-tool-panel-container']//*[@title='Id']/preceding-sibling::span")
    private WebElement clickId;

    @FindBy(xpath = "//span[@ref='eText'][contains(text(),'Id')]")
    private WebElement displayIdCheck;

    @FindBy(xpath = "//div[@col-id='endTime']")
    private WebElement displayIdCheckFalse;


    @FindBy(xpath = "//span[@ref='eText'][contains(text(),'Id')]")
    private WebElement displayTypeFalse;

    @FindBy(xpath = "//button[@ref='eToggleButton']")
    private WebElement toolPanel;

    @FindBy(xpath = "//*[@title='Id']/preceding-sibling::span")
    private WebElement typeClickId;

    @FindBy(xpath = "//div[@col-id='orderId']")
    private WebElement moveClick;

    @FindBy(xpath = "//div[@col-id='orderId']//span[@ref='eMenu']")
    private WebElement columClick;

    @FindBy(xpath = "//span[@class='ag-icon ag-icon-columns']")
    private WebElement thirdTabTypeClick;

    @FindBy(xpath = "//div[@class='ag-menu-column-select-wrapper']//*[@title='Id']/preceding-sibling::span")
    private WebElement thirdTypeClick;


    public boolean getClickFilter() {
        log.info("getClickFilter start");
        clickFilter.click();
        return clickFilter.isDisplayed();
    }


    public void getCliCkIdFilter() {
        log.info("getCliCkIdFilter start");
        clickId.click();
    }

    public boolean displayIdCheck() {
        log.info("displayIdCheck start");
        displayIdCheck.isDisplayed();
        return displayIdCheck.isDisplayed();
    }

    public boolean displayIdCheckFalse() {
        log.info("displayIdCheckFalse start");
        displayIdCheckFalse.isDisplayed();
        return false;
    }

    public void tollPanelClickOff() {
        log.info("tollPanelClickOff start");
        toolPanel.click();
        typeClickId.click();
    }

    public void tollPanelClickOn() {
        log.info("tollPanelClickOn start");
        typeClickId.click();
        toolPanel.click();

    }

    public boolean columClick() throws InterruptedException, IOException {
        log.info("columClick start");
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(moveClick).perform();
        columClick.click();
        Thread.sleep(2000);
        return true;
    }

    public boolean columClickId() {
        log.info("columClickId start");
        thirdTabTypeClick.click();
        return true;
    }

    public void columClickSecond() {
        log.info("columClickSecond start");
        thirdTypeClick.click();
    }


    public OrdersGridPage() throws IOException {

        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}