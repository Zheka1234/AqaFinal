package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.OrdersGridPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CaseOrdersGridTest {

    OrdersGridPage ordersGridPage;

    ChatGridPage chatGridPage;

    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        ordersGridPage = new OrdersGridPage();
        chatGridPage = new ChatGridPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void testOrdersGrid() throws InterruptedException {

        assertTrue(ordersGridPage.clickUser());
        assertTrue(chatGridPage.chartClick());
        assertTrue(ordersGridPage.getClickFilter());
        ordersGridPage.getCliCkIdFilter();
        ordersGridPage.clickRefresh();
//        assertFalse(ordersGridPage.displayIdCheck());
        ordersGridPage.getCliCkIdFilter();
        assertTrue(ordersGridPage.getClickFilter());
        ordersGridPage.getCliCkIdFilter();
        ordersGridPage.clickRefresh();
//        assertTrue(ordersGridPage.displayIdCheck());

        assertTrue(ordersGridPage.tollPanel());


        assertTrue(ordersGridPage.columClick());

        assertTrue(ordersGridPage.columClickId());

        assertTrue(ordersGridPage.columClickSecond());

        assertTrue(ordersGridPage.columClickSecond());

    }


}
