package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.HistogramPage;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertTrue;

public class CaseHistogramTest {

    HistogramPage histogramPage;

    private String COUNT = "Count: \\d+";

    private String AVG = "Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]";


    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        histogramPage = new HistogramPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Description("Hover over a bar.\n" +
            "Check boundaries and number of orders are displayed.\n" +
            "Click on the bar.\n" +
            "Repeat steps 1-4 for all bars.")
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

            Actions actions = null;
            try {
                actions = new Actions(BrowserDriver.getDriver());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            actions.moveToElement(bar, -20, -20);
            actions.build().perform();
            actions.build().perform();

            WebElement toolTipContainer = histogramPage.getTooltip();

            String borders = toolTipContainer.findElement(By.xpath("./div[1]")).getText();
            String count = toolTipContainer.findElement(By.xpath("./div[2]")).getText();
            assertTrue(borders.matches(AVG), borders);
            assertTrue(count.matches(COUNT), count);

            Actions actions2 = null;
            try {
                actions2 = new Actions(BrowserDriver.getDriver());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            actions2.moveToElement(bar, -50, -50);
            actions2.build().perform();

        });
    }
}