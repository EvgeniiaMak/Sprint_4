package ru.yandex.praktikum.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    private WebDriver driver;
    private By orderConfirmation= By.xpath(".//div[text()='Хотите оформить заказ?']");
    private By buttonYes = By.xpath(".//button[text()='Да']");


    public ConfirmPage(WebDriver driver){
        this.driver = driver;
    }



}
