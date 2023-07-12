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

public class OrderTest {
    private WebDriver driver;


    @Before
    public void startUp() {
        if ("yandex".equals(System.getProperty("browser"))) {
            WebDriverManager.chromedriver().driverVersion(System.getProperty("YaBrowserDriverVersion")).setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary(System.getProperty("YaBrowserLocation"));
            driver = new ChromeDriver(options);
        } else if ("firefox".equals(System.getProperty("browser"))) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }


    @Test
    public void checkOrderUpperButton() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);

        OrderPage orderPage = new OrderPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        SuccessPage successPage = new SuccessPage(driver);
        Random random = new Random();

        mainPage.clickCookieButton();

        mainPage.clickTopOrderButton();

        orderPage.fillingNameField("Иван");
        orderPage.fillingLastNameField("Иванов");
        orderPage.fillingAddressField("Москва");
        orderPage.fillingMetroField(random.nextInt(224));
        orderPage.fillingPhoneNumberField("79876543210");

        orderPage.clickBottomNext();

        orderPage.fillingRentalPeriod(random.nextInt(6));
        orderPage.fillingCommentField("Привет!");
        String deliveryDate = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        orderPage.fillingDeliveryDayField(deliveryDate);
        orderPage.colourChoice("black");

        orderPage.clickOrderButton();

        confirmPage.clickButtonYes();
        successPage.checkOrderIsProcessed();
    }

    @Test
    public void checkOrderLowerButton() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);

        OrderPage orderPage = new OrderPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        SuccessPage successPage = new SuccessPage(driver);
        Random random = new Random();

        mainPage.clickCookieButton();

        mainPage.clickBottomOrderButton();

        orderPage.fillingNameField("Алиса");
        orderPage.fillingLastNameField("Васнецова");
        orderPage.fillingAddressField("Санкт-Петербург");
        orderPage.fillingMetroField(random.nextInt(224));
        orderPage.fillingPhoneNumberField("79999999999");

        orderPage.clickBottomNext();

        orderPage.fillingRentalPeriod(random.nextInt(6));
        String deliveryDate = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        orderPage.fillingDeliveryDayField(deliveryDate);
        orderPage.colourChoice("grey");
        orderPage.fillingCommentField("Привезите самокат, будьте добры!");

        orderPage.clickOrderButton();

        confirmPage.clickButtonYes();
        successPage.checkOrderIsProcessed();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
