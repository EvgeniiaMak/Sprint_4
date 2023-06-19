package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    // Верхняя кнопка "Заказать" в верхнем правлм углу
    private By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Сколько это стоит? И как оплатить?
    private By howMuchCostHowToPay = By.id("accordion__heading-0");
    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By responseHowMuchCostHowToPay = By.id("accordion__panel-0");
    // Хочу сразу несколько самокатов! Так можно?
    private By severalScooters = By.id("accordion__heading-1");
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By responseSeveralScooters = By.id("accordion__panel-1");
    //Как рассчитывается время аренды?
    private By rentalTimeCalculation = By.id("accordion__heading-2");
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private By responseRentalTimeCalculation = By.id("accordion__panel-2");
    // Можно ли заказать самокат прямо на сегодня?
    private By orderForToday = By.id("accordion__heading-3");
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By responseOrderForToday=By.id("accordion__panel-3");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private By extendOrderReturnEarlier = By.id("accordion__heading-4");
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By responseExtendOrderReturnEarlier=By.id("accordion__panel-4");
    //Вы привозите зарядку вместе с самокатом?
    private By chargerForScooter = By.id("accordion__heading-5");
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private By responseChargerForScooter = By.id("accordion__panel-5");
    // Можно ли отменить заказ?
    private By cancellations = By.id("accordion__heading-6");
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By responseCancellations = By.id("accordion__panel-6");
    // Я живу за МКАДом, привезёте?
    private By outsideMoscow = By.id("accordion__heading-7");
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private By responseOutsideMoscow = By.id("accordion__panel-7");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    // метод для клика на верхнюю кнопку "Заказать"
    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }
    // метод для клика на нижнюю кнопку "Заказать"
    public void clickBottomOrderButton(){
        driver.findElement(bottomOrderButton).click();
    }

    public String getResponseHowMuchCostHowToPay(){
        driver.findElement(howMuchCostHowToPay).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseHowMuchCostHowToPay).isDisplayed()));
        return driver.findElement(responseHowMuchCostHowToPay).getText();
    }
    public String getResponseSeveralScooters(){
        driver.findElement(severalScooters).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseSeveralScooters).isDisplayed()));
        return driver.findElement(responseSeveralScooters).getText();
    }
    public String getResponseRentalTimeCalculation(){
        driver.findElement(rentalTimeCalculation).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseRentalTimeCalculation).isDisplayed()));
        return driver.findElement(responseRentalTimeCalculation).getText();
    }
    public String getResponseOrderForToday(){
        driver.findElement(orderForToday).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseOrderForToday).isDisplayed()));
        return driver.findElement(responseOrderForToday).getText();
    }

    public String getResponseExtendOrderReturnEarlier(){
        driver.findElement(extendOrderReturnEarlier).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseExtendOrderReturnEarlier).isDisplayed()));
       return driver.findElement(responseExtendOrderReturnEarlier).getText();
    }
    public String getResponseChargerForScooter(){
        driver.findElement(chargerForScooter).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseChargerForScooter).isDisplayed()));
        return driver.findElement(responseChargerForScooter).getText();
    }
    public String getResponseCancellations(){
        driver.findElement(cancellations).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseCancellations).isDisplayed()));
        return driver.findElement(responseCancellations).getText();
    }
    public String getResponseOutsideMoscow(){
        driver.findElement(outsideMoscow).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(responseOutsideMoscow).isDisplayed()));
        return driver.findElement(responseOutsideMoscow).getText();
    }





}
