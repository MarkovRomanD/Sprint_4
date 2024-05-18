//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.praktikum.plain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.constants.HomePageConstants;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {
    private final By question;
    private final By answer;
    private final String expected;

    public FaqTest(By question, By answer, String expected) {
        this.question = question;
        this.answer = answer;
        this.expected = expected;
    }

    @Parameters
    public static Object[][] getParameters() {
        return new Object[][]{{HomePageConstants.QUEST_1, HomePageConstants.ANSWER_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."}, {HomePageConstants.QUEST_2, HomePageConstants.ANSWER_2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}, {HomePageConstants.QUEST_4, HomePageConstants.ANSWER_4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}, {HomePageConstants.QUEST_5, HomePageConstants.ANSWER_5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."}, {HomePageConstants.QUEST_3, HomePageConstants.ANSWER_3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}, {HomePageConstants.QUEST_6, HomePageConstants.ANSWER_6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."}, {HomePageConstants.QUEST_7, HomePageConstants.ANSWER_7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}, {HomePageConstants.QUEST_8, HomePageConstants.ANSWER_8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}};
    }

    @Test
    public void equalsAnswerQuestion() {
        MainPage mainPage = new MainPage(this.driver);
        String answerTextNow = mainPage.waitForLoadHomePage().scrollFaq().accordeonClick(this.question).getAnswerText(this.answer);
        Assert.assertEquals("Ошибка, строки не верны", this.expected, answerTextNow);
    }
}
