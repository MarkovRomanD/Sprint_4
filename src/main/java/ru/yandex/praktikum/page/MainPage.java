//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final String question = "accordion__heading-";
    private final String answer = "accordion__panel-";

    //кнопка заказать в хедере страницы
    private final By headerOrderButton = By.xpath("//*[@class=\"Header_Nav__AGCXC\"]/button[@class=\"Button_Button__ra12g\"]");
    //кнопка заказать в Как это заказать
    private final By howItOrderButton = By.xpath("//div[@class=\"Home_FinishButton__1_cWm\"]/button");
    //блок вопросов
    private final By faqBlock = By.className("Home_FourPart__1uthg");
    //блок как это заказать
    private final By howItOrder = By.className("Home_FinishButton__1_cWm");

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
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        return this;
    }

    public MainPage scrollHowItOrder() {
        WebElement element = this.driver.findElement(this.howItOrder);
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        return this;
    }

    public MainPage waitForLoadHomePage() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(15L))).until((driver) -> {
            return driver.findElement(this.headerOrderButton).getText() != null && !driver.findElement(this.headerOrderButton).getText().isEmpty();
        });
        return this;
    }

    public MainPage waitForLoadHowItOrder() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(15L))).until((driver) -> {
            return driver.findElement(this.howItOrder).getText() != null && !driver.findElement(this.howItOrder).getText().isEmpty();
        });
        return this;
    }

    public MainPage orderButtonClick(String chooseButton) {
        if (chooseButton.equals("header")) {
            waitForLoadHomePage();
            driver.findElement(headerOrderButton).click();
        } else if (chooseButton.equals("howItOrder")) {
            scrollHowItOrder();
            waitForLoadHowItOrder();
            driver.findElement(howItOrderButton).click();
        }

        return this;
    }

    public By getQuestion(int numQuestion) {
        return By.id(String.format(question + "%d", numQuestion));
    }

    public By getAnswer(int numAnswer) {
        return By.id(String.format(answer + "%d", numAnswer));
    }

}


