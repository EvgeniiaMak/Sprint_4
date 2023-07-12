package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage {

    private WebDriver driver;
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.className("Button_Middle__1CSJM");

    private By deliveryDayInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    private By rentalPeriodInput = By.className("Dropdown-control");
    private By dropdownMenu = By.className("Dropdown-menu");
    private By dropdownOption = By.className("Dropdown-option");
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private By scooterColorBlackCheckbox = By.id("black");
    private By scooterColorGreyCheckbox = By.id("grey");

    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By metroList = By.xpath(".//ul[@class='select-search__options']");
    private By selectSearchRow = By.xpath(".//li[@class='select-search__row']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillingNameField(String name) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(nameInput).isEnabled()));
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillingLastNameField(String lastName) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(lastNameInput).isEnabled()));
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillingAddressField(String address) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(addressInput).isEnabled()));
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);

    }

    public void fillingPhoneNumberField(String number) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(phoneNumberInput).isEnabled()));
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(number);
    }

    public void fillingMetroField(int metroListIndex) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(metroInput).isEnabled()));
        driver.findElement(metroInput).click();
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(metroList).isEnabled()));
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(selectSearchRow).isEnabled()));
        List<WebElement> metroElements = driver.findElements(selectSearchRow);
        metroElements.get(metroListIndex).click();

    }

    public void clickBottomNext() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(nextButton).isEnabled()));
        driver.findElement(nextButton).click();
    }

    public void fillingCommentField(String comment) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(commentInput).isEnabled()));
        driver.findElement(commentInput).clear();
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void fillingRentalPeriod(Integer periodIndex) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(rentalPeriodInput).isEnabled()));
        driver.findElement(rentalPeriodInput).click();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(dropdownMenu).isEnabled()));
        List<WebElement> dropdownOptionElements = driver.findElements(dropdownOption);
        dropdownOptionElements.get(periodIndex).click();
    }

    public void fillingDeliveryDayField(String date) {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(deliveryDayInput).isEnabled()));
        driver.findElement(deliveryDayInput).clear();
        driver.findElement(deliveryDayInput).sendKeys(date);
    }

    public void colourChoice(String colour) {
        if ("black".equals(colour)) {
            new WebDriverWait(driver, 10).until(driver -> (driver.findElement(scooterColorBlackCheckbox).isEnabled()));
            driver.findElement(scooterColorBlackCheckbox).click();
        }
        if ("grey".equals(colour)) {
            new WebDriverWait(driver, 10).until(driver -> (driver.findElement(scooterColorGreyCheckbox).isEnabled()));
            driver.findElement(scooterColorGreyCheckbox).click();
        }

    }

    public void clickOrderButton() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(orderButton).isEnabled()));
        driver.findElement(orderButton).click();
    }

}
