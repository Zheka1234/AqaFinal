package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.LoginPage;
import com.miskevich.pages.OrdersGridPage;
import io.qameta.allure.Description;
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

    LoginPage loginPage;

    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        ordersGridPage = new OrdersGridPage();
        chatGridPage = new ChatGridPage();
        loginPage = new LoginPage();
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
    public void testOrdersGridFilterColumns() throws IOException {

        assertTrue(loginPage.inputUser());
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

        ordersGridPage.columClick();
        ordersGridPage.thirdVersionOfTheMenu();
        ordersGridPage.columClickIdColum();
        assertFalse(ordersGridPage.displayIdCheckFalse());
        ordersGridPage.columClickIdColum();
        assertTrue(ordersGridPage.displayIdCheck());

    }


}
