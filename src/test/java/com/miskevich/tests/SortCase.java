package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortCase {

    ChatGridPage chatPage;

    LoginPage loginPage;


    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        chatPage = new ChatGridPage();
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void testSort()  {
        assertTrue(loginPage.inputUser());

        assertTrue(chatPage.chartClick());
        chatPage.clickSortType();
        assertTrue(chatPage.areElementSortedIncrease());
        chatPage.clickSortType();
        assertTrue(chatPage.areElementSortedDecreasing());
        chatPage.clickSortType();
        assertFalse(chatPage.areElementsUnsorted());
    }
}
