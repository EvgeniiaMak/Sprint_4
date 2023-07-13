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
import ru.yandex.praktikum.pageobject.ConfirmPage;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.OrderPage;
import ru.yandex.praktikum.pageobject.SuccessPage;

import java.util.Random;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class OrderTest extends AbstractTest {
    private static final String QA_SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

    private static final String NAME_IVAN = "ИВАН";
    private static final String LAST_NAME_IVANOV = "ИВАНОВ";
    private static final String CITY_NAME_MOSCOW = "МОСКВА";
    private static final String PHONE_NUMBER_FIELD1 = "79876543210";
    private static final String NAME_ALISA = "АЛИСА";
    private static final String LAST_NAME_VASNECOVA = "ВАСНЕЦОВА";
    private static final String CITY_NAME_SPB = "САНКТ-ПЕТЕРБУРГ";
    private static final String PHONE_NUMBER_FIELD2 = "79999999999";
    private static final String COLOUR_BLACK = "black";
    private static final String COLOUR_GREY = "grey";
    private static final String COMMENT_FIELD1 = "Привет!";
    private static final String COMMENT_FIELD2 = "Привезите самокат, будьте добры!";
    private static final String SUCCESS_MODAL_WINDOW_TEXT_EXPECTED = "Заказ оформлен";

    private static final int METRO_DROPDOWN_SIZE = 224;

    private static final int RENTAL_PERIOD_DROPDOWN_SIZE = 6;

    private static final Random random = new Random();

    private static final DateTimeFormatter DATE_FORMATTER_DD_MM_YYYY = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Test
    public void checkOrderUpperButton() {

        driver.get(QA_SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);

        OrderPage orderPage = new OrderPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        SuccessPage successPage = new SuccessPage(driver);

        mainPage.clickCookieButton();

        mainPage.clickTopOrderButton();

        orderPage.fillingNameField(NAME_IVAN);
        orderPage.fillingLastNameField(LAST_NAME_IVANOV);
        orderPage.fillingAddressField(CITY_NAME_MOSCOW);
        orderPage.fillingMetroField(random.nextInt(METRO_DROPDOWN_SIZE));
        orderPage.fillingPhoneNumberField(PHONE_NUMBER_FIELD1);

        orderPage.clickBottomNext();

        orderPage.fillingRentalPeriod(random.nextInt(RENTAL_PERIOD_DROPDOWN_SIZE));
        orderPage.fillingCommentField(COMMENT_FIELD1);
        String deliveryDate = LocalDate.now().plusDays(2).format(DATE_FORMATTER_DD_MM_YYYY);
        orderPage.fillingDeliveryDayField(deliveryDate);
        orderPage.colourChoice(COLOUR_BLACK);

        orderPage.clickOrderButton();

        confirmPage.clickButtonYes();
        String actual = successPage.getSuccessModalWindowText();
        assertTrue("упс", actual != null && actual.startsWith(SUCCESS_MODAL_WINDOW_TEXT_EXPECTED));
    }

    @Test
    public void checkOrderLowerButton() {


        driver.get(QA_SCOOTER_URL);


        MainPage mainPage = new MainPage(driver);

        OrderPage orderPage = new OrderPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        SuccessPage successPage = new SuccessPage(driver);


        mainPage.clickCookieButton();

        mainPage.clickBottomOrderButton();

        orderPage.fillingNameField(NAME_ALISA);
        orderPage.fillingLastNameField(LAST_NAME_VASNECOVA);
        orderPage.fillingAddressField(CITY_NAME_SPB);
        orderPage.fillingMetroField(random.nextInt(METRO_DROPDOWN_SIZE));
        orderPage.fillingPhoneNumberField(PHONE_NUMBER_FIELD2);

        orderPage.clickBottomNext();

        orderPage.fillingRentalPeriod(random.nextInt(RENTAL_PERIOD_DROPDOWN_SIZE));
        String deliveryDate = LocalDate.now().plusDays(2).format(DATE_FORMATTER_DD_MM_YYYY);
        orderPage.fillingDeliveryDayField(deliveryDate);
        orderPage.colourChoice(COLOUR_GREY);
        orderPage.fillingCommentField(COMMENT_FIELD2);

        orderPage.clickOrderButton();

        confirmPage.clickButtonYes();
        String actual = successPage.getSuccessModalWindowText();
        assertTrue("упс", actual != null && actual.startsWith(SUCCESS_MODAL_WINDOW_TEXT_EXPECTED));
    }


}
