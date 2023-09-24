package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class ChatGridPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Grid & chart')]")
    private WebElement openChat;
    @FindBy(xpath = "//div[@row-index='5']//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value']")
    private WebElement orderClick;

    @FindBy(xpath = "//span[@class='chart-settings__title chart-mobile-title']")
    private WebElement linesClick;

    @FindBy(xpath = "//span[text()='Mid price']/following-sibling::div[@Class='legend-container__item-value']")
    private WebElement midPrice;

    @FindBy(css = "g[class$='MID_PRICE']>text:last-child")
    private WebElement mid;

    @FindBy(xpath = "//span[text()='Avg fill price']/following-sibling::div[@Class='legend-container__item-value']")
    private WebElement avgPrice;

    @FindBy(xpath = "//div[@class='chart-view__info mb-2 hidden-text']")
    private WebElement lineUnderChat;

    @FindBy(xpath = "//div[@tabindex='-1']/..//div[@col-id='orderType']")
    private List<WebElement> columnElements;

    @FindBy(xpath = "//div[@col-id='orderType']//span[@ref='eText']")
    private WebElement typeSort;

    @FindBy(xpath = "//div[@row-index='5']//div[@col-id='averageFillPrice']/span[1]")
    private WebElement tableAvg;

    @FindBy(xpath = "//div[@class='legend-container__square']")
    private WebElement midPriceColor;

    @FindBy(css = "g[class$='MID_PRICE']>rect")
    private WebElement midColor;


    public void clickSortType() {
        typeSort.click();
    }

    public String getMidPriceColor() {
        log.info("getMidPriceColor start");

        return midColor.getText();
    }

    public String getMidColor() {
        log.info("getMidColor start");

        return midPriceColor.getText();
    }

    public List<WebElement> getColumnElements() {
        return columnElements;

    }

    public boolean chartClick() {
        log.info("chart click and wait for it to appear " + openChat.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(openChat));
        openChat.click();
        log.info("chartClick good");
        return openChat.isDisplayed();
    }

    public void orderClick() {
        log.info("getMidPriceTooltip start");
        orderClick.click();

    }


    public double getMidPrice() {
        log.info("getMidPrice start");
        return Double.parseDouble(midPrice.getText());
    }

    public double getMidPriceTooltip() {
        log.info("getMidPriceTooltip start");

        return Double.parseDouble(mid.getText());
    }

    public double getAvgPrice() {
        log.info("getAvgPrice start");
        return Double.parseDouble(avgPrice.getText());
    }

    public double getAvgTablePrice() {
        log.info("getAvgTablePrice start");
        return Double.parseDouble(tableAvg.getText());
    }

    public double underChat() {
        log.info("underChat start");
        String temp = lineUnderChat.getText();
        int index = temp.indexOf("Exec price:");
        int index2 = temp.indexOf(",", index + 11);
        String result = temp.substring(index + 11, index2);
        return Double.parseDouble(result);
    }

    public ChatGridPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

}
