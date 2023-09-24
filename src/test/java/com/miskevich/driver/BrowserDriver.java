package com.miskevich.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserDriver {

    private static WebDriver driver;

    private static Properties properties;

    private static final int WAIT = 3;

    public static void initDriver() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/project.properties"));
        if (properties.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("driverLocation"));
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        driver.manage().window().maximize();
    }

    public static Properties getMyProperties() {
        return properties;
    }

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}

