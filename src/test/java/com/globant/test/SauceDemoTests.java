package com.globant.test;

import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {


    @Test
    public void purchaseProductTest() {
        ProductPage productPage = new ProductPage(driver, driver.getCurrentUrl());
        productPage.purchaseProduct();
        productPage.goToShoopingCart();
        CartPage cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.checkout();
        CheckoutPage checkoutPage = new CheckoutPage(driver,driver.getCurrentUrl());
        checkoutPage.ingresarDatos("Josue","Guerrero","901090");
        CheckoutPageTwo checkoutPageTwo = new CheckoutPageTwo(driver, driver.getCurrentUrl());
        checkoutPageTwo.finish();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");

        //esta parte es necesaria si quiero que funcione al correr la clase
        LoginPage loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user","secret_sauce");
    }



    @Test
    public void removeElementsFromCartTest() {
        String actualURL = driver.getCurrentUrl();
        ProductPage productPage = new ProductPage(driver, actualURL);
        productPage.agregarProductosAlCarrito(3);
        productPage.goToShoopingCart();
        CartPage cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.removeAll();
        Assert.assertEquals(cartPage.getElementosHija().size(), 0, "La lista no está vacía después de intentar eliminar elementos");

        //esta parte es necesaria si quiero que funcione al correr la clase
        LoginPage loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user","secret_sauce");
    }

    @Test
    public void logoutTest() {
        String actualURL = driver.getCurrentUrl();
        ProductPage productPage = new ProductPage(driver, actualURL);
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL, expectedURL, "La URL después de iniciar sesión no es la esperada.");
        productPage.logout();

        //esta parte es necesaria si quiero que funcione al correr la clase
        LoginPage loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user","secret_sauce");
    }

}
