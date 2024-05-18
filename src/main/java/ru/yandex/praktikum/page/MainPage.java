//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.praktikum.page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final By headerOrderButton = By.xpath("//*[@class=\"Header_Nav__AGCXC\"]/button[@class=\"Button_Button__ra12g\"]");
    private final By faqBlock = By.className("Home_FourPart__1uthg");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage accordeonClick(By question) {
        this.driver.findElement(question).click();
        return this;
    }

    public String getAnswerText(By answer) {
        return this.driver.findElement(answer).getText();
    }

    public MainPage scrollFaq() {
        WebElement element = this.driver.findElement(this.faqBlock);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        return this;
    }

    public MainPage waitForLoadHomePage() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(15L))).until((driver) -> {
            return driver.findElement(this.headerOrderButton).getText() != null && !driver.findElement(this.headerOrderButton).getText().isEmpty();
        });
        return this;
    }
}
