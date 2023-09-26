package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.driver.Settings;
import com.miskevich.pages.ChatGridPage;
import com.miskevich.pages.LoginPage;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CaseSortTest {

    ChatGridPage chatPage;

    LoginPage loginPage;


    @BeforeMethod
    public void openMainPage() throws IOException {
        loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(Settings.getUserName(), Settings.getUserPassword());
        chatPage = new ChatGridPage();

    }

    @AfterMethod
    public void cleanUp() {
        BrowserDriver.close();
    }

    @Description("")
    @Test
    public void testSort() {

    }

}