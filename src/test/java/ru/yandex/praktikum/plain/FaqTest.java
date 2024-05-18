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
import static ru.yandex.praktikum.page.constants.HomePageConstants.*;

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
        return new Object[][]{
                {QUEST_1, ANSWER_1, TEXT_ANSWER_1},
                {QUEST_2, ANSWER_2, TEXT_ANSWER_2},
                {QUEST_3, ANSWER_3, TEXT_ANSWER_3},
                {QUEST_4, ANSWER_4, TEXT_ANSWER_4},
                {QUEST_5, ANSWER_5, TEXT_ANSWER_5},
                {QUEST_6, ANSWER_6, TEXT_ANSWER_6},
                {QUEST_7, ANSWER_7, TEXT_ANSWER_7},
                {QUEST_8, ANSWER_8, TEXT_ANSWER_8},
        };
          }

    @Test
    public void equalsAnswerQuestion() {
        MainPage mainPage = new MainPage(this.driver);
        String answerTextNow = mainPage.waitForLoadHomePage().scrollFaq().accordeonClick(this.question).getAnswerText(this.answer);
        Assert.assertEquals("Ошибка, строки не верны", this.expected, answerTextNow);
    }
}
