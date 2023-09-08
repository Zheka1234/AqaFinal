package com.miskevich.pages;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.elements.MenuElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected MenuElements menuElements = new MenuElements();
    protected WebElement waitForElementIsVisible(By by) {
        WebElement item = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return item;
    }
}
