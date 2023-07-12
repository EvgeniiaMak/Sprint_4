package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class SuccessPage {
    private WebDriver driver;

    private By successModalWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderIsProcessed() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(successModalWindow).isEnabled()));
        String actual = driver.findElement(successModalWindow).getText();
        assertTrue("упс", actual != null && actual.startsWith("Заказ оформлен"));
    }

}
