package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutCompletePage {

    public CheckoutCompletePage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }
}
