package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class MainPage {
    private WebDriver driver;

    private By cookieButton = By.id("rcc-confirm-button");

    // Верхняя кнопка "Заказать" в верхнем правом углу
    private By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Сколько это стоит? И как оплатить?
    private By howMuchCostHowToPayHeading = By.id("accordion__heading-0");
    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By responseHowMuchCostHowToPayPanel = By.id("accordion__panel-0");
    // Хочу сразу несколько самокатов! Так можно?
    private By severalScootersHeading = By.id("accordion__heading-1");
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By responseSeveralScootersPanel = By.id("accordion__panel-1");
    //Как рассчитывается время аренды?
    private By rentalTimeCalculationHeading = By.id("accordion__heading-2");
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private By responseRentalTimeCalculationPanel = By.id("accordion__panel-2");
    // Можно ли заказать самокат прямо на сегодня?
    private By orderForTodayHeading = By.id("accordion__heading-3");
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By responseOrderForTodayPanel = By.id("accordion__panel-3");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private By extendOrderReturnEarlierHeading = By.id("accordion__heading-4");
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By responseExtendOrderReturnEarlierPanel = By.id("accordion__panel-4");
    //Вы привозите зарядку вместе с самокатом?
    private By chargerForScooterHeading = By.id("accordion__heading-5");
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private By responseChargerForScooterPanel = By.id("accordion__panel-5");
    // Можно ли отменить заказ?
    private By cancellationsHeading = By.id("accordion__heading-6");
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By responseCancellationsPanel = By.id("accordion__panel-6");
    // Я живу за МКАДом, привезёте?
    private By outsideMoscowHeading = By.id("accordion__heading-7");
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private By responseOutsideMoscowPanel = By.id("accordion__panel-7");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }


    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }


    public String getResponse(By button, By text) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(text).isDisplayed()));
        return driver.findElement(text).getText();
    }

    public void getResponseHowMuchCostHowToPay() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = getResponse(howMuchCostHowToPayHeading, responseHowMuchCostHowToPayPanel);
        assertEquals(expected, actual);
    }

    public void getResponseSeveralScooters() {
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = getResponse(severalScootersHeading, responseSeveralScootersPanel);
        assertEquals(expected, actual);
    }

    public void getResponseRentalTimeCalculation() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = getResponse(rentalTimeCalculationHeading, responseRentalTimeCalculationPanel);
        assertEquals(expected, actual);

    }

    public void getResponseOrderForToday() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = getResponse(orderForTodayHeading, responseOrderForTodayPanel);
        assertEquals(expected, actual);

    }

    public void getResponseExtendOrderReturnEarlier() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = getResponse(extendOrderReturnEarlierHeading, responseExtendOrderReturnEarlierPanel);
        assertEquals(expected, actual);
    }

    public void getResponseChargerForScooter() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = getResponse(chargerForScooterHeading, responseChargerForScooterPanel);
        assertEquals(expected, actual);
    }

    public void getResponseCancellations() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = getResponse(cancellationsHeading, responseCancellationsPanel);
        assertEquals(expected, actual);

    }

    public void getResponseOutsideMoscow() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = getResponse(outsideMoscowHeading, responseOutsideMoscowPanel);
        assertEquals(expected, actual);

    }


    public void clickCookieButton() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(cookieButton).isEnabled()));
        driver.findElement(cookieButton).click();
    }

}
