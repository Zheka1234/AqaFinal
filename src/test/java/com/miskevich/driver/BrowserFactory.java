package com.miskevich.driver;

import com.miskevich.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserFactory {
    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
    }

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                break;
            case RemoteWebDriver:
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.100.18:4444"), new ChromeOptions());
                } catch (MalformedURLException e) {
                    throw new RuntimeException("URL is not supported" + e.getMessage());
                }
                break;
            default:
                throw new IllegalStateException("Browser Not Supported: " + browserType);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }
}
