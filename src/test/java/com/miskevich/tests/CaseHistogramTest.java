package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.HistogramPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CaseHistogramTest {

    HistogramPage histogramPage;

    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        histogramPage = new HistogramPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void testHistogram() {
        assertTrue(histogramPage.clickUser());
        assertTrue(histogramPage.histogramClick());
        List<WebElement> barContainers = BrowserDriver.getDriver().findElements(By.xpath("//*[contains(@class,'bars')]//*[contains(@class,'bar_container')]"));
        Assert.assertTrue(barContainers.size() > 0);
        barContainers.forEach(barContainer -> {
            WebElement bar = barContainer.findElement(By.xpath("./*[@class='bar']"));

            Actions actions = new Actions(BrowserDriver.getDriver());

            actions.moveToElement(bar, -40, -40);
            actions.build().perform();
            By toolTipLocator = By.xpath("//*[@class='tooltip']");

            WebElement toolTipContainer = BrowserDriver.getDriver().findElement(toolTipLocator);

            String borders = toolTipContainer.findElement(By.xpath("./div[1]")).getText();
            String count = toolTipContainer.findElement(By.xpath("./div[2]")).getText();
            Assert.assertTrue(borders.matches("Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]"), borders);
            Assert.assertTrue(count.matches("Count: \\d+"), count);

            Actions actions2 = new Actions(BrowserDriver.getDriver());

            actions2.moveToElement(bar, -50, -50);
            actions2.build().perform();
        });


    }
}