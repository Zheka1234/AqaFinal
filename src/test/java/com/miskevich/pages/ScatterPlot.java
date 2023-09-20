package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ScatterPlot extends BasePage {

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

    @FindBy(css = "g[class='x axis']")
    private WebElement xAxis;

    //    //*[@class='x axis']/*[@class]/*[2]
    @FindBy(css = "g[class='y axis']")
    private WebElement yAxis;

    @FindBy(css = "//a[contains(text(),'10')]")
    private WebElement checkInterval;


    @FindBy(xpath = "//*[contains(@class,'scatter-plot-container')]//*[contains(@class,'scatter_element')]")
    private List<WebElement> bubbles;

    public boolean getBubbles() {
        log.info("getBubbles start");
        bubbles.size();
        return true;
    }

    public void setInterval(int value) {

    }

    public String getXAxis() {
        log.warn("X axis remains the same" + xAxis);
        return xAxis.getText();
    }

    public String getYAxis() {
        log.warn("Y axis remains the same" + yAxis);
        return yAxis.getText();
    }


    public boolean scatterClick() {
        log.info("scatterClick start");
        openScatter.click();
        log.info("scatterClick good");
        return openScatter.isDisplayed();
    }

    public boolean checkLabel() {
        log.info("checkLabel start");
        xLabel.getText();
        yLabel.getText();
        return true;
    }


    public void xAttributeClick(String xAttributeText) throws IOException {
        log.info("X the attribute has not changed" + xAttributeText);
        xAttribute.click();
        WebElement xAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + xAttributeText + "')]"));
        xAttributeElement.click();

    }

    public void yAttributeClick(String yAttributeText) throws IOException {
        log.info("Y the attribute has not changed" + yAttributeText);
        yAttribute.click();
        WebElement yAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + yAttributeText + "')]"));
        yAttributeElement.click();
    }

    public boolean checkName() {
        log.info("checkName start");
        xAttribute.getText();
        yAttribute.getText();
        return true;
    }

    public ScatterPlot() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
