package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmOrderPage {
    private final WebDriver driver;
    //локатор хедера модального окна
    private final By headerModal = By.className("Order_ModalHeader__3FDaJ");
    //локатор кнопки "да"
    private final By yesButtonOrder = By.xpath("//div[@class=\"Order_Modal__YZ-d3\"]/div[@class=\"Order_Buttons__1xGrp\"]/*[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    //локатор хедера окна подтверждения заказаа

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public ConfirmOrderPage waitLoadConfirmModal() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(15L))).until((driver) -> {
            return driver.findElement(this.headerModal).getText() != null && !driver.findElement(this.headerModal).getText().isEmpty();
        });
        return this;
    }

    public ConfirmOrderPage orderModalYesButton() {
        driver.findElement(yesButtonOrder).click();
        return this;
    }

    public String getHeaderModal() {
        return driver.findElement(headerModal).getText();
    }
}
