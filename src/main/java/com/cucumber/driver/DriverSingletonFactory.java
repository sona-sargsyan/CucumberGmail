package com.cucumber.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingletonFactory {
    public static DriverDecorator driver;

    private DriverSingletonFactory() {
    }

    public static DriverDecorator getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new DriverDecorator(new FirefoxDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new DriverDecorator(new ChromeDriver());
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
