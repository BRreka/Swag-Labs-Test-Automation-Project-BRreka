package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class CheckoutOverviewPage {

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement checkoutOverviewPageTitle;

    @FindBy(xpath = "div[@class='inventory_item_name']")
    private List<WebElement> inventoryItemNameList;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    public CheckoutOverviewPage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }

    public String getOverviewPageTitle() {
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
        cancelBtn.click();
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }

}
