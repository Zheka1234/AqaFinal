package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.HistogramPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CaseHistogramTest {

    HistogramPage histogramPage;

    private String COUNT = "Count: \\d+";

    private String AVG = "Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]";


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
    public void testHistogram() throws InterruptedException {
        assertTrue(histogramPage.clickUser());
        Thread.sleep(2000);
        assertTrue(histogramPage.histogramClick());
        List<WebElement> barContainers = histogramPage.getBars();
        assertTrue(barContainers.size() > 0);
        Thread.sleep(2000);
        barContainers.forEach(barContainer -> {
            WebElement bar = barContainer.findElement(By.xpath("./*[@class='bar']"));

            Actions actions = new Actions(BrowserDriver.getDriver());

            actions.moveToElement(bar, -50, -50);
            actions.build().perform();
            actions.click().build().perform();

            WebElement toolTipContainer = histogramPage.getTooltip();

            String borders = toolTipContainer.findElement(By.xpath("./div[1]")).getText();
            String count = toolTipContainer.findElement(By.xpath("./div[2]")).getText();
            assertTrue(borders.matches(AVG), borders);
            assertTrue(count.matches(COUNT), count);

            Actions actions2 = new Actions(BrowserDriver.getDriver());

            actions2.moveToElement(bar, -50, -50);
            actions2.click().build().perform();

        });
    }
}