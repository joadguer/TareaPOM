package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(className = "btn_action")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_list .cart_item")
    private List<WebElement> elementosHija;

    public void removeAll(){
        for (WebElement elemento : elementosHija) {
            // Realizar acciones sobre cada elemento

            // Encontrar el botón de remover dentro de cada elemento hija
            WebElement botonRemover = elemento.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));

            // Realizar acciones específicas con el botón de remover (clic, etc.)
            botonRemover.click();
        }

    }


    public void checkout(){
        shoppingCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }

    public List<WebElement> getElementosHija() {
        return elementosHija;
    }
}
