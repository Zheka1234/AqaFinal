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

        Thread.sleep(2000);

        assertTrue(chatGridPage.chartClick());

        assertTrue(ordersGridPage.getClickFilter());
        Thread.sleep(2000);
        ordersGridPage.getCliCkIdFilter();
        Thread.sleep(2000);
        ordersGridPage.clickRefresh();
        Thread.sleep(2000);
        assertFalse(ordersGridPage.displayIdFalse());
        Thread.sleep(2000);
        assertTrue(ordersGridPage.getClickFilter());
        Thread.sleep(2000);
        ordersGridPage.getCliCkIdFilter();
        Thread.sleep(2000);
        ordersGridPage.clickRefresh();
        Thread.sleep(2000);
        assertTrue(ordersGridPage.displayIdTrue());

        ordersGridPage.tollPanel();
//        assertFalse(ordersGridPage.displayIdFalse());
        Thread.sleep(5000);
        ordersGridPage.columClick();
        Thread.sleep(5000);
//        ordersGridPage.columClickId();
//        Thread.sleep(5000);


    }


}
