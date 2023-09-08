package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.DeltixuatPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CaseLoginTest {

    DeltixuatPage deltixuatPage;

    @BeforeMethod
    public void openDeltixuat() {
        BrowserDriver.getDriver().get("https://app.tca.deltixuat.com");
        deltixuatPage = new DeltixuatPage();
    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }

    @Test
    public void loginTest(){
        assertTrue(deltixuatPage.clickUser());
        assertTrue(deltixuatPage.clickPassword());
        assertTrue(deltixuatPage.buttonClick());
        assertTrue(deltixuatPage.checkSetting());
        assertTrue(deltixuatPage.checkMenuElements());



    }

}
