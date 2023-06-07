package com.codecool.swaglabstestautomationprojectbrreka.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class WebdriverClass {
    private static volatile WebDriver webDriverInstance;

    private WebdriverClass() {}

    public static WebDriver getInstance() {
        WebDriver driver = webDriverInstance;
        if(driver == null) {
            synchronized (WebdriverClass.class) {
                driver = webDriverInstance;
                if(driver == null) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    webDriverInstance = driver = new ChromeDriver(options);
                }
            }
        }
        return driver;
    }
}
