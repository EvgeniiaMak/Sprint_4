package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmPage {
    private WebDriver driver;
    private By orderConfirmationTitle = By.xpath(".//div[text()='Хотите оформить заказ?']");
    private By yesButton = By.xpath(".//button[text()='Да']");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonYes() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(orderConfirmationTitle).isEnabled()));
        driver.findElement(yesButton).click();
    }


}
