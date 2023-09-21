package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.DeltixuatPage;
import com.miskevich.pages.OrdersGridPage;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CaseOrdersGridTest {

    OrdersGridPage ordersGridPage;

    ChatGridPage chatGridPage;

    DeltixuatPage deltixuatPage;

    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        ordersGridPage = new OrdersGridPage();
        chatGridPage = new ChatGridPage();
        deltixuatPage = new DeltixuatPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Description("Open Filter Configurator control and check/uncheck the column.\n" +
            "Make sure the column appears/disappears from the grid.\n" +
            "Open Tool panel and check/uncheck the column.\n" +
            "Make sure the column appears/disappears from the grid.\n" +
            "Open filter for any column and switch to the 3rd tab.\n" +
            "Check/uncheck the column.\n" +
            "Make sure the column appears/disappears from the grid.")
    @Test
    public void testOrdersGridFilterColumns() throws InterruptedException, IOException {

        assertTrue(deltixuatPage.clickUser());
        assertTrue(chatGridPage.chartClick());
        assertTrue(ordersGridPage.getClickFilter());
        ordersGridPage.getCliCkIdFilter();
        assertFalse(ordersGridPage.displayIdCheckFalse());
        assertTrue(ordersGridPage.getClickFilter());
        ordersGridPage.getCliCkIdFilter();
        assertTrue(ordersGridPage.displayIdCheck());

        ordersGridPage.tollPanelClickOff();
        assertFalse(ordersGridPage.displayIdCheckFalse());
        ordersGridPage.tollPanelClickOn();
        assertTrue(ordersGridPage.displayIdCheck());

        assertTrue(ordersGridPage.columClick());
        assertTrue(ordersGridPage.columClickId());
        ordersGridPage.columClickSecond();
        assertFalse(ordersGridPage.displayIdCheckFalse());
        ordersGridPage.columClickSecond();
        assertTrue(ordersGridPage.displayIdCheck());

    }


}
