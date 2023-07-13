package ru.yandex.praktikum.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public abstract class AbstractTest {

    protected WebDriver driver;

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

    @After
    public void teardown() {
        driver.quit();
    }

}
