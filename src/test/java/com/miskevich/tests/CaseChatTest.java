package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CaseChatTest {

    ChatGridPage chatPage;


    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        chatPage = new ChatGridPage();

    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @Test
    public void testChat() throws InterruptedException {

        assertTrue(chatPage.clickUser());
        assertTrue(chatPage.chartClick());
        assertTrue(chatPage.orderClick());
        assertTrue(chatPage.linesClick());


    }
}
