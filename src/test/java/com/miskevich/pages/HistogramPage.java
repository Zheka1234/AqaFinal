package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HistogramPage extends BasePage {

    @FindBy(xpath = "//div[@class='app-title'][contains(text(),'Histogram')]")
    private WebElement openHistogram;

    @FindBy(xpath = "//*[contains(@class,'bars')]//*[contains(@class,'bar_container')]")
    private List<WebElement> bars;

    @FindBy(xpath = "//*[@class='tooltip']")
    private WebElement tool;

    public WebElement getBarElement(WebElement barContainer) {
        return barContainer.findElement(By.xpath("./*[@class='bar']"));
    }

    public String getBordersText() {
        return tool.findElement(By.xpath("./div[1]")).getText();
    }

    public String getCountText() {
        return tool.findElement(By.xpath("./div[2]")).getText();
    }

    public List<WebElement> getBars() {
        log.info("getBars start");
        return bars;
    }

    public WebElement getTooltip() {
        log.info("getTooltip start");
        return tool;
    }

    public boolean histogramClick() {
        log.info("histogramClick start");
        openHistogram.click();
        log.info("histogramClick good");
        return openHistogram.isDisplayed();
    }

    public void moveMouseToElement(WebElement element, int xOffset, int yOffset) throws IOException {
        Actions actions = new Actions(BrowserDriver.getDriver());
        actions.moveToElement(element, xOffset, yOffset);
        actions.click().build().perform();
    }

    public HistogramPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

}
