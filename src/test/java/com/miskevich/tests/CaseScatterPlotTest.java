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
        loginPage.login("selenium_chrome","Axa@Demo");
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @DataProvider(name = "attributeNames")
    public Object[][] attributeNamesProvider() {
        return new Object[][]{
                {"Size", "Avg fill price"},
                {"Exec size", "Num of executions"},
                {"Avg fill price", "Participation rate"},
                {"Exec size", "Size"},
                {"Execution price volatility", "Exec size"},



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
    public void scatterPlotTest(String xAttributeName, String yAttributeName) throws IOException, InterruptedException {

        scatterPlot.scatterClick();
        scatterPlot.setInterval();


        String initialXAxis = scatterPlot.getXAxis();
        String initialYAxis = scatterPlot.getYAxis();


        scatterPlot.xAttributeSelect(xAttributeName);
        scatterPlot.yAttributeSelect(yAttributeName);

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
