package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.DeltixuatPage;
import com.miskevich.pages.ScatterPlot;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;

public class CaseScatterPlotTest {

    ScatterPlot scatterPlot;

    DeltixuatPage deltixuatPage;



    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        scatterPlot = new ScatterPlot();
        deltixuatPage = new DeltixuatPage();
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

    @Description("Change X Attribute.\n" +
            "Check that:\n" +
            "values of axes are updated\n" +
            "name of the X-axis changed to X Attribute\n" +
            "Change Y Attribute.\n" +
            "Check that:\n" +
            "grid is collapsed\n" +
            "values are updated\n" +
            "name of the Y-axis is changed to Y Attribute\n" +
            "Repeat steps 1-4 for all attributes.")
    @Test(dataProvider = "attributeNames")
    public void scatterPlotTest(String xAttributeName, String yAttributeName) throws InterruptedException, IOException {
        deltixuatPage.clickUser();
        Thread.sleep(3000);
        scatterPlot.scatterClick();
        scatterPlot.xAttributeClick(xAttributeName);
        scatterPlot.yAttributeClick(yAttributeName);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(scatterPlot.getBubbles());
        soft.assertEquals(scatterPlot.checkLabel(),scatterPlot.checkName());
        soft.assertAll();
    }
}
