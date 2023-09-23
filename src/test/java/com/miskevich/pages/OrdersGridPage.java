package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OrdersGridPage extends BasePage {

    @FindBy(xpath = "//span[@class='ml-1'][contains(text(),'Filters')]")
    private WebElement clickFilter;

    @FindBy(xpath = "//div[@class='ag-column-tool-panel-container']//*[@title='Id']/preceding-sibling::span")
    private WebElement clickId;

    @FindBy(xpath = "//span[@ref='eText'][contains(text(),'Id')]")
    private WebElement displayIdCheck;

    @FindBy(xpath = "//div[@col-id='endTime']")
    private WebElement displayIdCheckFalse;

    @FindBy(xpath = "//button[@ref='eToggleButton']")
    private WebElement toolPanel;

    @FindBy(xpath = "//*[@title='Id']/preceding-sibling::span")
    private WebElement typeClickId;

    @FindBy(xpath = "//div[@col-id='orderId']")
    private WebElement moveClick;

    @FindBy(xpath = "//div[@col-id='orderId']//span[@ref='eMenu']")
    private WebElement columClick;

    @FindBy(xpath = "//span[@class='ag-icon ag-icon-columns']")
    private WebElement thirdVersionOfTheMenu;

    @FindBy(xpath = "//div[@class='ag-menu-column-select-wrapper']//*[@title='Id']/preceding-sibling::span")
    private WebElement thirdTypeClickId;


    public boolean getClickFilter() {
        log.info("getClickFilter " + clickFilter.isDisplayed());
        clickFilter.click();
        return clickFilter.isDisplayed();
    }


    public void getCliCkIdFilter() {
        log.info("getCliCkIdFilter start");
        clickId.click();
    }

    public boolean displayIdCheck() {
        log.info("display id colum check " + displayIdCheck.isDisplayed());
        return displayIdCheck.isDisplayed();
    }

    public boolean displayIdCheckFalse() {
        log.info("display id colum check false ");
        displayIdCheckFalse.isDisplayed();
        return false;
    }

    public void tollPanelClickOff() {
        log.info("check the column on the instrument panel off");
        toolPanel.click();
        typeClickId.click();
    }

    public void tollPanelClickOn() {
        log.info("check the column on the instrument panel on");
        typeClickId.click();
        toolPanel.click();

    }

    public void columClick() throws IOException {
        log.info("Open filter for any column and switch to the 3rd tab");
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(moveClick).perform();
        columClick.click();


    }

    public void columClickId() {
        log.info("third version of the menu ");
        thirdVersionOfTheMenu.click();

    }

    public void columClickIdColum() {
        log.info("click on ID in menu 3 ");
        thirdTypeClickId.click();
    }


    public OrdersGridPage() throws IOException {

        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}