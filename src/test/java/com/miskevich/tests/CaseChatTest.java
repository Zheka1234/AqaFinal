package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.DeltixuatPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CaseChatTest {

    ChatGridPage chatPage;

    DeltixuatPage deltixuatPage;


    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        chatPage = new ChatGridPage();
        deltixuatPage = new DeltixuatPage();

    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @Test
    public void testChat() throws InterruptedException {

        assertTrue(deltixuatPage.clickUser());
        Thread.sleep(3000);
        assertTrue(chatPage.chartClick());
        chatPage.orderClick();
        assertEquals(chatPage.getMidPriceTooltip(), chatPage.getMidPrice());
        assertEquals(chatPage.getAvgPrice(), chatPage.underChat());


    }
}
