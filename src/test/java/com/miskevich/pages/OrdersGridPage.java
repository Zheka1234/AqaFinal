package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersGridPage extends BasePage {

    @FindBy(xpath = "//span[@class='ml-1'][contains(text(),'Filters')]")
    private WebElement clickFilter;

    @FindBy(xpath = "//div[@class='ag-column-tool-panel-container']//*[@title='Id']/preceding-sibling::span")
    private WebElement clickId;

    @FindBy(xpath = "//div[@col-id='orderId']")
    private WebElement displayIdFalse;

    @FindBy(xpath = "//button[@title='Refresh']")
    private WebElement buttonRefresh;

    @FindBy(xpath = "//div[@col-id='orderType']")
    private WebElement displayTypeFalse;

    @FindBy(xpath = "//button[@ref='eToggleButton']")
    private WebElement toolPanel;

    @FindBy(xpath = "//div[@class='ag-column-tool-panel-column']//span[@ref='eLabel'][text()='Type']")
    private WebElement typeClick;

    @FindBy(xpath = "//div[@col-id='orderId']")
    private WebElement moveClick;

    @FindBy(xpath = "//div[@col-id='orderId']//span[@ref='eMenu']")
    private WebElement columClick;

    @FindBy(xpath = "//span[@class='ag-tab ag-tab-selected']")
    private WebElement thirdTab;

    @FindBy(xpath = "//div[@ref='tabBody']//span[@title='Type']")
    private WebElement thirdTabTypeClick;


    public boolean getClickFilter() {
        clickFilter.click();
        return clickFilter.isDisplayed();
    }

    public void clickRefresh() {
        buttonRefresh.click();
    }

    public void getCliCkIdFilter() {
        clickId.click();
    }

    public boolean displayIdFalse() {
        displayIdFalse.isDisplayed();
        return false;
    }
    public boolean displayIdTrue() {
        displayIdFalse.isDisplayed();
        return true;
    }

    public void tollPanel() {
        toolPanel.click();
        typeClick.click();
    }

    public void columClick() throws InterruptedException {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(moveClick).perform();
        columClick.click();
        Thread.sleep(2000);


    }

    public void columClickId() {
        thirdTabTypeClick.click();
    }


    public OrdersGridPage() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }


}
