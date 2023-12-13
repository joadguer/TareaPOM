package com.globant.test;


import com.globant.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver and open the Saucedemo URL
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Josue\\IdeaProjects\\projectwithcode\\TareaPom\\src\\utils\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user","secret_sauce");
    }

    @AfterTest
    public void tearDown() {
        // Cerrar el WebDriver después de que todas las pruebas se hayan ejecutado
        if (driver != null) {
            driver.close();
        }
    }

}