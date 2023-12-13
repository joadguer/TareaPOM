package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.Random;


import java.util.List;
import java.util.Set;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOfAllElements(itemDescriptions));

    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;


    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "inventory_item_description")
    private List<WebElement> itemDescriptions;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    private WebDriverWait wait = new WebDriverWait(driver, 10);

    private Set<Integer> indicesUtilizados = new HashSet<>();

    public void openMenu() {
        menuButton.click();
    }

    public void logout() {
        openMenu();
        clickLogoutLink();
    }

    private void clickLogoutLink() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutLink.click();
    }


    private void purchaseOneProduct() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(itemDescriptions.size());
        } while (!indicesUtilizados.add(randomIndex));

        WebElement selectedProduct = itemDescriptions.get(randomIndex);
        String productName = selectedProduct.findElement(By.className("inventory_item_name")).getText();
        selectedProduct.findElement(By.className("btn_small")).click();
    }

    public void purchaseProduct() {
        purchaseOneProduct();
    }

    public void goToShoopingCart() {
        shoppingCartButton.click();
    }

    public void agregarProductosAlCarrito(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            purchaseProduct();
        }
    }
}
