package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatGridPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Grid & chart')]")
    private WebElement openChat;
    ////div[@col-id='orderId']//span[contains(text(),'1had73qs6:1734')]
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

    public void clickSortType() {
        typeSort.click();
    }

    public List<WebElement> getColumnElements() {
        return columnElements;

    }

    public boolean areElementSortedDecreasing() {
        List<String> columnValues = new ArrayList<>();
        for (WebElement element : columnElements) {
            columnValues.add(element.getText());
        }

        for (int i = 0; i < columnValues.size() - 1; i++) {
            if (columnValues.get(i).compareTo(columnValues.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean areElementSortedIncrease() {
        List<String> columnValues = new ArrayList<>();
        for (WebElement element : columnElements) {
            columnValues.add(element.getText());
        }

        for (int i = 0; i < columnValues.size() - 1; i++) {
            if (columnValues.get(i).compareTo(columnValues.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean areElementsUnsorted() {
        List<String> columnValues = new ArrayList<>();
        for (WebElement element : columnElements) {
            columnValues.add(element.getText());
        }

        for (int i = 0; i < columnValues.size() - 1; i++) {
            if (columnValues.get(i).compareTo(columnValues.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }


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
