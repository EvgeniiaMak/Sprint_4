package ru.yandex.praktikum.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.pageobject.MainPage;

import static org.junit.Assert.assertEquals;


public class QuestionsAboutImportantTest extends AbstractTest {

    private static final String QA_SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

    @Test
    public void checkResponseHowMuchCostHowToPay() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = mainPage.getResponseHowMuchCostHowToPay();
        assertEquals(expected, actual);

    }

    @Test
    public void checkResponseSeveralScooters() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = mainPage.getResponseSeveralScooters();
        assertEquals(expected, actual);
    }

    @Test
    public void checkResponseRentalTimeCalculation() {
        driver.get(QA_SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = mainPage.getResponseRentalTimeCalculation();
        assertEquals(expected, actual);

    }

    @Test
    public void checkResponseOrderForToday() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = mainPage.getResponseOrderForToday();
        assertEquals(expected, actual);
    }

    @Test
    public void checkResponseExtendOrderReturnEarlier() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = mainPage.getResponseExtendOrderReturnEarlier();
        assertEquals(expected, actual);
    }

    @Test
    public void checkResponseChargerForScooter() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = mainPage.getResponseChargerForScooter();
        assertEquals(expected, actual);
    }

    @Test
    public void checkResponseCancellations() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = mainPage.getResponseCancellations();
        assertEquals(expected, actual);
    }

    @Test
    public void checkResponseOutsideMoscow() {
        driver.get(QA_SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = mainPage.getResponseOutsideMoscow();
        assertEquals(expected, actual);
    }


}
