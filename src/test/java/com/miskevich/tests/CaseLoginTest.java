package com.miskevich.tests;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.pages.MainPage;
import com.miskevich.pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.miskevich.driver.BrowserDriver.getMyProperties;
import static org.testng.Assert.assertTrue;

public class CaseLoginTest {

    LoginPage loginPage;

    MainPage mainPage;

    @BeforeMethod
    public void openDeltixuat() throws IOException {
        BrowserDriver.getDriver().get(getMyProperties().getProperty("siteUrl"));
        loginPage = new LoginPage();

        loginPage.login("selenium_chrome","Axa@Demo");
        mainPage = new MainPage();

    }

    @AfterMethod
    public void closeDeltixuat() {
        BrowserDriver.close();
    }


    @DataProvider(name = "checkSection")
    public Object[][] sectionNamesProvider() {
        return new Object[][]{
                {"Summary"},
                {"Grid & chart"},
                {"Histogram"},
                {"Scatter-plot"},
                {"Reports"},
        };
    }

    @Description("Log in." +
            "Check that main page with the following components is opened:" +
            "Settings button" +
            "Benchmark Selector control" +
            "Application Toolbar with Summary, Grid & chart, Histogram, Scatter-plot and Reports tabs")
    @Test(dataProvider = "checkSection")
    public void caseLoginTest(String sectionName) throws IOException {
        assertTrue(mainPage.isSettingDisplayed());
        assertTrue(mainPage.iskBenchmarkSelectionDisplayed());
        mainPage.section(sectionName);

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(mainPage.section(sectionName).isDisplayed());

        soft.assertAll();

    }
}
