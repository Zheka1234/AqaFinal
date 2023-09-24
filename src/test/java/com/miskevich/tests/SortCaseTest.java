package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortCaseTest {

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
        List<WebElement> columnValues = chatPage.getColumnElements();
        List<String> columnTexts = new ArrayList<>();
        for (WebElement columnValue : columnValues) {
            columnTexts.add(columnValue.getText());
        }


        List<String> sortedColumnTexts = new ArrayList<>(columnTexts);
        Collections.sort(sortedColumnTexts);


        assertEquals(sortedColumnTexts, columnTexts);

    }

}