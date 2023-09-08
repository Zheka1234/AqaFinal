package com.miskevich.elements;

import com.miskevich.driver.BrowserDriver;
import com.miskevich.enums.MenuItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MenuElements {

    private static final String ITEM_PATTERN = "//div//*[contains(text(),'%s')]";

    private WebElement getMenuElement(MenuItem menuElements) {
        String xpath = String.format(ITEM_PATTERN, menuElements.getValue());

        WebElement menuItem = new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return menuItem;
    }

    public void checkItem(MenuItem item) {
        getMenuElement(item).isDisplayed();
    }

}
