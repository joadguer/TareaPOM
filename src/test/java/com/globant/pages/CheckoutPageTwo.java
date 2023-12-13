package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageTwo extends BasePage{
    public CheckoutPageTwo(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public void finish(){
        finishBtn.click();
    }


}
