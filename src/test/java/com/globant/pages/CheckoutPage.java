package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continuebutton;
    public void ingresarDatos(String nombre, String apellido, String codigoPostal) {
        ingresarNombre(nombre);
        ingresarApellido(apellido);
        ingresarCodigoPostal(codigoPostal);
        continuebutton.click();
    }

    private void ingresarNombre(String nombre) {
        // Ingresa las teclas al campo
        firstNameInput.sendKeys(nombre);
    }

    private void ingresarApellido(String apellido) {
        // Ingresa las teclas al campo
        lastNameInput.sendKeys(apellido);
    }

    private void ingresarCodigoPostal(String codigoPostal) {
        // Ingresa las teclas al campo
        postalCodeInput.sendKeys(codigoPostal);
    }


}
