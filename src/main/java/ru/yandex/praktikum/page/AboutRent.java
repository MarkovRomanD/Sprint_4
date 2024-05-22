package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRent {
    private final WebDriver driver;
    //локатор когда привезти самокат
    private final By dateRent = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    //локатор поля срок аренды
    private final By timeRent = By.className("Dropdown-arrow");
    //локатор количества суток срока аренды
    private final String timeRentDay = "//*[@class=\"Dropdown-option\"]";
    //локатор комментария
    private final By comment = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]");

    //локатор кнопки заказать
    private final By rentButton = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    //локатор цвета самоката
    private final By colorRentBlack = By.xpath("//label[@for=\"black\"]");
    private final By colorRentGrey = By.xpath("//label[@for=\"grey\"]");


    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRent waitForLoadRentPage() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(15L))).until((driver) -> {
            return driver.findElement(this.rentButton).getText() != null && !driver.findElement(this.rentButton).getText().isEmpty();
        });
        return this;
    }

    public AboutRent dateRentClearAndWrite(String date) {
        driver.findElement(dateRent).clear();
        driver.findElement(dateRent).sendKeys(date);
        return this;
    }

    public AboutRent chooseTimeRent(int duration) {
        driver.findElement(timeRent).click();
        driver.findElement(By.xpath(String.format(timeRentDay + "[%d]", duration))).click();
        return this;
    }

    public AboutRent chooseColorRent(String color) {
        if (color.equals("black")) {
            driver.findElement(colorRentBlack).click();
        } else if (color.equals("grey")) {
            driver.findElement(colorRentGrey).click();
        } else if (color.equals("bothColor")) {
            driver.findElement(colorRentBlack).click();
            driver.findElement(colorRentGrey).click();
        }
        return this;
    }

    public AboutRent commentWrite(String comments) {
        driver.findElement(comment).clear();
        driver.findElement(comment).sendKeys(comments);
        return this;
    }

    public AboutRent rentButtonClick() {
        driver.findElement(rentButton).click();
        return this;
    }


}
