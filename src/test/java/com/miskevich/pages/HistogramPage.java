package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistogramPage extends BasePage{

    Logger log = Logger.getLogger(DeltixuatPage.class);

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Histogram')]")
    private WebElement openHistogram;

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Histogram')]")
    private WebElement moveBar;



    public boolean histogramClick(){
        log.info("histogramClick start");
        openHistogram.click();
        log.info("histogramClick good");
        return openHistogram.isDisplayed();


    }

    public HistogramPage() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
