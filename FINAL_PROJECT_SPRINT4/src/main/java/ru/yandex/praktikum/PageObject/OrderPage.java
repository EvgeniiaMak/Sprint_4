package ru.yandex.praktikum.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By MetroInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.className("Button_Middle__1CSJM");
    private By deliveryDay = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriod = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private By scooterColorBlack = By.id("black");
    private By scooterColorGrey = By.id("grey");
    private By orderButton =By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
}
