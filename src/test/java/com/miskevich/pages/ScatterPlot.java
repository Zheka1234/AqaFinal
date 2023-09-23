package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class ScatterPlot extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Scatter-plot')]")
    private WebElement openScatter;

    @FindBy(xpath = "//div[text()='X Attribute']/following-sibling::*")
    private WebElement xAttribute;

    @FindBy(xpath = "//div[text()='Y Attribute']/following-sibling::*")
    private WebElement yAttribute;

    @FindBy(xpath = "//div[text()='Intervals']/following-sibling::*")
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

    @FindBy(xpath = "//a[contains(text(),'10')]")
    private WebElement checkInterval;




    @FindBy(xpath = "//*[contains(@class,'scatter-plot-container')]//*[contains(@class,'scatter_element')]")
    private List<WebElement> bubbles;

    public boolean getBubbles() {
        log.info("getBubbles start");
        bubbles.size();
        return bubbles.size() > 0;
    }



    public void setInterval() {
        log.info("click on the interval and select");
        wait.until(ExpectedConditions.visibilityOf(interval));
        interval.click();
        checkInterval.sendKeys(Keys.ENTER);
    }

    public String getXAxis() {
        log.warn("X axis remains the same" + xAxis);
        return xAxis.getText();
    }

    public String getYAxis() {
        log.warn("Y axis remains the same" + yAxis);
        return yAxis.getText();
    }


    public void scatterClick() {
        log.info("scatter click and wait for it to appear");
        wait.until(ExpectedConditions.visibilityOf(openScatter));
        openScatter.click();
        log.info("scatterClick good");
        ;
    }

    public boolean checkLabelX() {
        log.info("checking the label x ");
        xLabel.getText();
        return xLabel.isDisplayed();
    }

    public boolean checkLabelY() {
        log.info("checking the label y ");
        yLabel.getText();
        return yLabel.isDisplayed();
    }


    public void xAttributeClick(String xAttributeText) throws IOException {
        log.info("X the attribute has not changed" + xAttributeText);
        xAttribute.click();
        WebElement xAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + xAttributeText + "')]"));
        xAttributeElement.sendKeys(Keys.ENTER);

    }

    public void yAttributeClick(String yAttributeText) throws IOException {
        log.info("Y the attribute has not changed" + yAttributeText);
        yAttribute.click();
        WebElement yAttributeElement = BrowserDriver.getDriver()
                .findElement(By.xpath("//li[@class='autocomplete-dropdown-item']//a[contains(text(),'" + yAttributeText + "')]"));
        yAttributeElement.sendKeys(Keys.ENTER);
    }

    public boolean checkXAttribute() {
        log.info("checking the attribute name " + xAttribute.getText());
        xAttribute.getText();
        return xAttribute.isDisplayed();
    }

    public boolean checkYAttribute() {
        log.info("checking the attribute name " + yAttribute.getText());
        yAttribute.getText();

        return yAttribute.isDisplayed();
    }

    public ScatterPlot() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
