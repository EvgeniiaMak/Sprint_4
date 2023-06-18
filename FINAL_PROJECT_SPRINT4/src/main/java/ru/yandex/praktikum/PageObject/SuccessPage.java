package ru.yandex.praktikum.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    private WebDriver driver;

    private By successModalWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public SuccessPage(WebDriver driver){
        this.driver = driver;
    }
}
