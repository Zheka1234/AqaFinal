package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.HistogramPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HistogramTest {

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
    public void testHistogram(){
        assertTrue(histogramPage.clickUser());
        assertTrue(histogramPage.clickPassword());
        assertTrue(histogramPage.buttonClick());
        assertTrue(histogramPage.histogramClick());

    }

}
