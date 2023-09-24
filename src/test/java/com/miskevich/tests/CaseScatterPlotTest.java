package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.LoginPage;
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

    LoginPage loginPage;


    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        scatterPlot = new ScatterPlot();
        loginPage = new LoginPage();
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
                {"Exec size", "Permanent market impact"},
                {"Price", "Exec size"},
                {"Execution price volatility", "Avg fill price"},
                {"Realized market impact", "Shortfall"},
                {"Permanent market impact", "Permanent market impact"},
                {"Participation rate", "Exec size"},
                {"Shortfall", "Num of executions"},
                {"Multiplier", "Execution price volatility"},
                {"Tick size", "Permanent market impact"},
                {"Currency code", "Exec size"},
                {"Sequence number", "Num of executions"},
                {"Db sequence number", "Execution price volatility"},
                {"Benchmark price", "Permanent market impact"},
                {"Price imp. (ticks)", "Execution price volatility"},
                {"Price imp. (amount)", "Permanent market impact"},


        };
    }

    @Description("Change X Attribute." +
            "Check that:" +
            "values of axes are updated" +
            "name of the X-axis changed to X Attribute" +
            "Change Y Attribute.\n" +
            "Check that:" +
            "grid is collapsed" +
            "values are updated" +
            "name of the Y-axis is changed to Y Attribute" +
            "Repeat steps 1-4 for all attributes.")
    @Test(dataProvider = "attributeNames")
    public void scatterPlotTest(String xAttributeName, String yAttributeName) throws IOException {
        loginPage.inputUser();
        scatterPlot.scatterClick();
        scatterPlot.setInterval();

        String initialXAxis = scatterPlot.getXAxis();
        String initialYAxis = scatterPlot.getYAxis();

        scatterPlot.xAttributeClick(xAttributeName);
        scatterPlot.yAttributeClick(yAttributeName);

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(scatterPlot.getBubbles());
        soft.assertEquals(scatterPlot.checkLabelX(), scatterPlot.checkXAttribute());
        soft.assertEquals(scatterPlot.checkLabelY(), scatterPlot.checkYAttribute());


        String updatedXAxis = scatterPlot.getXAxis();
        String updatedYAxis = scatterPlot.getYAxis();

        soft.assertNotEquals(initialXAxis, updatedXAxis, "X-axis values are not updated");
        soft.assertNotEquals(initialYAxis, updatedYAxis, "Y-axis values are not updated");
        soft.assertAll();
    }
}
