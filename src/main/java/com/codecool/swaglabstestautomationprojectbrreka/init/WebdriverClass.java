package com.codecool.swaglabstestautomationprojectbrreka.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverClass {
    private static volatile WebDriver webDriverInstance;

    private WebdriverClass() {}

    public static WebDriver getInstance() {
        WebDriver driver = webDriverInstance;
        if(driver == null) {
            synchronized (WebdriverClass.class) {
                driver = webDriverInstance;
                if(driver == null) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    webDriverInstance = driver = new ChromeDriver(options);
                }
            }
        }
        return driver;
    }
}
