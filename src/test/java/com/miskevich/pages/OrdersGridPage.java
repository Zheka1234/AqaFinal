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
    private WebElement displayIdCheck;

    @FindBy(xpath = "//button[@title='Refresh']")
    private WebElement buttonRefresh;

    @FindBy(xpath = "//span[@ref='eText'][contains(text(),'Id')]")
    private WebElement displayTypeFalse;

    @FindBy(xpath = "//button[@ref='eToggleButton']")
    private WebElement toolPanel;

    @FindBy(xpath = "//*[@title='Type']/preceding-sibling::span")
    private WebElement typeClick;

    @FindBy(xpath = "//div[@col-id='orderId']")
    private WebElement moveClick;

    @FindBy(xpath = "//div[@col-id='orderId']//span[@ref='eMenu']")
    private WebElement columClick;

    @FindBy(xpath = "//span[@class='ag-icon ag-icon-columns']")
    private WebElement thirdTabTypeClick;

    @FindBy(xpath = "//div[@class='ag-menu-column-select-wrapper']//*[@title='Id']/preceding-sibling::span")
    private WebElement thirdTypeClick;


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

    public boolean displayIdCheck() {
        displayIdCheck.isDisplayed();
        return displayIdCheck.isDisplayed();
    }

    public boolean tollPanel() {
        toolPanel.click();
        typeClick.click();
        typeClick.click();
        toolPanel.click();
        return true;
    }

    public boolean columClick() throws InterruptedException {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(moveClick).perform();
        columClick.click();
        Thread.sleep(2000);
        return true;
    }

    public boolean columClickId() {
        thirdTabTypeClick.click();
        return true;
    }

    public boolean columClickSecond() {
        thirdTypeClick.click();
        thirdTypeClick.click();
        return true;
    }


    public OrdersGridPage() {

        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
