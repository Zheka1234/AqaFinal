package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='d-flex align-items-center benchmark-selection']")
    private WebElement benchmarkSelection;

    @FindBy(xpath = "//a[@href='/settings']")
    private WebElement settingButton;


    public WebElement section(String sectionName) throws IOException {
        WebElement element = BrowserDriver.getDriver()
                .findElement(By.xpath("//div[@class='app-title'][contains(text(),'')]"));
        sectionName.isEmpty();
        return element;
    }

    public boolean isSettingDisplayed() {
        log.info("isSettingDisplayed start" + settingButton.isDisplayed());

        return settingButton.isDisplayed();
    }


    public boolean iskBenchmarkSelectionDisplayed() {
        log.info("iskBenchmarkSelectionDisplayed start" + benchmarkSelection.isDisplayed());
        return benchmarkSelection.isDisplayed();
    }

    public MainPage() throws IOException {
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }
}
