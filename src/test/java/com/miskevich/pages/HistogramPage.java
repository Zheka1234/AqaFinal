package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HistogramPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Histogram')]")
    private WebElement openHistogram;

    @FindBy(xpath = "//*[contains(@class,'bars')]//*[contains(@class,'bar_container')]")
    private List<WebElement> bars;

    @FindBy(xpath = "//*[@class='tooltip']")
    private WebElement tool;

    public List<WebElement> getBars() {
        return bars;
    }

    public WebElement getTooltip() {
        return tool;
    }

    public boolean histogramClick() {
        log.info("histogramClick start");
        openHistogram.click();
        log.info("histogramClick good");
        return openHistogram.isDisplayed();
    }

    public HistogramPage() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }


}
