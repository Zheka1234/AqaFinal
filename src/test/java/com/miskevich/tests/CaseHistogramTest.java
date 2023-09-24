package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.HistogramPage;
import com.miskevich.pages.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertTrue;

public class CaseHistogramTest {

    HistogramPage histogramPage;

    LoginPage loginPage;

    private String PATTERN_COUNT = "Count: \\d+";

    private String PATTERN_AVG = "Avg fill price: [\\[,\\(]\\d+\\.\\d+, \\d+\\.\\d+[),\\]]";


    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        histogramPage = new HistogramPage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Description("Hover over a bar." +
            "Check boundaries and number of orders are displayed." +
            "Click on the bar." +
            "Repeat steps 1-4 for all bars.")
    @Test
    public void testHistogram() {
        assertTrue(loginPage.inputUser());
        assertTrue(histogramPage.histogramClick());
        List<WebElement> barContainers = histogramPage.getBars();
        assertTrue(barContainers.size() > 0);
        barContainers.forEach(barContainer -> {
            WebElement bar = histogramPage.getBarElement(barContainer);
            try {
                histogramPage.moveMouseToElement(bar, -20, -20);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            histogramPage.getTooltip();
            String borders = histogramPage.getBordersText();
            String count = histogramPage.getCountText();
            assertTrue(borders.matches(PATTERN_AVG), borders);
            assertTrue(count.matches(PATTERN_COUNT), count);

        });
    }
}