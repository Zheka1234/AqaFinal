package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ScatterPlot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CaseScatterPlotTest {

    ScatterPlot scatterPlot;

    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        scatterPlot = new ScatterPlot();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void loginTest() {
        assertTrue(scatterPlot.clickUser());
        assertTrue(scatterPlot.scatterClick());


    }
}
