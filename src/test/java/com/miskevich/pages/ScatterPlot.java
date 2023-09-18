package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScatterPlot extends AuthorizationPage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Scatter-plot')]")
    private WebElement openScatter;

    @FindBy(xpath = "//div[text()='X Attribute']/following-sibling::*")
    private WebElement xAttribute;

    @FindBy(xpath = "//div[text()='Y Attribute']/following-sibling::*")
    private WebElement yAttribute;

    @FindBy(xpath = "//*[@name='intervalCountAutocomplete']//input")
    private WebElement interval;

    @FindBy(xpath = "//*[@class='scatter-plot-x-label']")
    private WebElement xLabel ;

    @FindBy(xpath = "//*[@class='scatter-plot-y-label']")
    private WebElement yLabel ;

    public boolean scatterClick() {
        log.info("scatterClick start");
        openScatter.click();
        log.info("scatterClick good");
        return openScatter.isDisplayed();


    }

    public ScatterPlot() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
