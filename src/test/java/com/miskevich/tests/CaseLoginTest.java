package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.DeltixuatPage;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CaseLoginTest {

    DeltixuatPage deltixuatPage;

    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        deltixuatPage = new DeltixuatPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @Description("Log in.\n" +
            "Check that main page with the following components is opened:\n" +
            "Settings button\n" +
            "Benchmark Selector control\n" +
            "Application Toolbar with Summary, Grid & chart, Histogram, Scatter-plot and Reports tabs")
    @Test
    public void loginTest() {
        assertTrue(deltixuatPage.clickUser());
        assertTrue(deltixuatPage.checkSetting());
        assertTrue(deltixuatPage.checkBenchmarkSelection());
        assertTrue(deltixuatPage.checkMenuElements());


    }

}
