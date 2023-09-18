package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ScatterPlot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;

public class CaseScatterPlotTest {

    ScatterPlot scatterPlot;

    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        scatterPlot = new ScatterPlot();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @DataProvider(name = "attributeNames")
    public Object[][] attributeNamesProvider() {
        return new Object[][]{
                {"Size", "Exec size"},
                {"Exec size", "Num of executions"},
                {"Avg fill price", "Execution price volatility"},

        };
    }

    @Test(dataProvider = "attributeNames")
    public void scatterPlotTest(String xAttributeName, String yAttributeName) throws InterruptedException, IOException {
        scatterPlot.clickUser();
        Thread.sleep(3000);
        scatterPlot.scatterClick();
        scatterPlot.xAttributeClick(xAttributeName);
        scatterPlot.yAttributeClick(yAttributeName);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(scatterPlot.checkLabel());
        soft.assertAll();
    }


}
