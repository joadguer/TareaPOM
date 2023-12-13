package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends BasePage{
    public ThankYouPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver,this);
    }
}
