package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScatterPlot extends BasePage{

    Logger log = Logger.getLogger(DeltixuatPage.class);

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Scatter-plot')]")
    private WebElement openScatter;

    public boolean scatterClick(){
        log.info("scatterClick start");
        openScatter.click();
        log.info("scatterClick good");
        return openScatter.isDisplayed();


    }

    public ScatterPlot() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
