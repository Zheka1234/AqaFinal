package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.By;
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
    private WebElement xLabel;

    @FindBy(xpath = "//*[@class='scatter-plot-y-label']")
    private WebElement yLabel;

    @FindBy(xpath = "//li[@class='autocomplete-dropdown-item']//a[contains(text(),'Exec size')]")
    public WebElement checkX;

    @FindBy(xpath = "//li[@class='autocomplete-dropdown-item']//a[contains(text(),'Size')]")
    public WebElement checkY;

    public boolean scatterClick() {
        log.info("scatterClick start");
        openScatter.click();
        log.info("scatterClick good");
        return openScatter.isDisplayed();
    }

    public void xAttributeClick() {

        xAttribute.click();
        checkX.click();
    }

    public void yAttributeClick() {

        yAttribute.click();
        checkY.click();
    }

    public boolean checkLabel(){
        xLabel.isDisplayed();
        yLabel.isDisplayed();
        return true;
    }

    public void xAttributeClick(String xAttributeText) {
        xAttribute.click();
        WebElement xAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + xAttributeText + "')]"));
        xAttributeElement.click();
    }

    public void yAttributeClick(String yAttributeText) {
        yAttribute.click();
        WebElement yAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + yAttributeText + "')]"));
        yAttributeElement.click();
    }

    public ScatterPlot() {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
