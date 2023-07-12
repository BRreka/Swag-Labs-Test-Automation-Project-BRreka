package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitUtil;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class CheckoutOverviewPage {

    private final WebDriver driver = WebdriverUtil.getInstance();
    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement checkoutOverviewPageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryItemNameList;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    public CheckoutOverviewPage() {
        PageFactory.initElements(driver,this);
    }

    public String getOverviewPageTitle() {
        WaitUtil.waitUntilClickable(driver, checkoutOverviewPageTitle);
        return checkoutOverviewPageTitle.getText();
    }

    public List<String> getInventoryItemNameList() {
        List<String> nameList = new ArrayList<>();
        for(WebElement element : inventoryItemNameList) {
            nameList.add(element.getText());
        }
        return nameList;
    }

    public void clickCancelBtn() {
        WaitUtil.waitUntilClickable(driver, cancelBtn);
        cancelBtn.click();
    }

    public void clickFinishBtn() {
        WaitUtil.waitUntilClickable(driver, finishBtn);
        finishBtn.click();
    }

}
