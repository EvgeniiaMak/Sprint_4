package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {
    private WebDriver driver;

    private By successModalWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessModalWindowText() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(successModalWindow).isEnabled()));
        return driver.findElement(successModalWindow).getText();

    }

}
