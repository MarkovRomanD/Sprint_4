package ru.yandex.praktikum.plain;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.AboutRent;
import ru.yandex.praktikum.page.ConfirmOrderPage;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String button;
    private final String name;
    private final String surname;
    private final String adress;
    private final String phoneNumber;
    private final String date;
    private final String color;
    private final String comment;
    private final String expectedHeaderConfirmOrder = "Заказ оформлен";
    private final int timeRent;
    private final int subwayNumber;


    public OrderTest(String button, String name, String surname, String adress, String phoneNumber, int subwayNumber, String date, int timeRent, String color, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.subwayNumber = subwayNumber;
        this.date = date;
        this.timeRent = timeRent;
        this.color = color;
        this.comment = comment;

    }


    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"header", "Роман", "Марков", "Пушкина 52", "88005553535", 23, "22.05.2024", 7, "grey", "Хочу полную зарядку"},
                {"howItOrder", "Марк", "Романов", "Колотушкина 52", "88559993432", 11, "22.05.2024", 7, "black", "Утром верну"},
                {"header", "Сергей", "Сергеев", "чуйкова 52", "89003334343", 5, "22.05.2024", 7, "bothColor", "Украду"},
        };
    }


    @Test
    public void upButtonOrder() {

        MainPage mainPage = new MainPage(driver);
        mainPage.orderButtonClick(button);


        OrderPage orderPage = new OrderPage(driver);
        orderPage
                .nameFieldClearAndWrite(name)
                .surnameFieldClearAndWrite(surname)
                .adressFieldClearAndWrite(adress)
                .phoneNumberFieldClearAndWrite(phoneNumber)
                .subwayStationListChoose(subwayNumber)
                .nextButtonClick();


        AboutRent aboutRent = new AboutRent(driver);
        aboutRent
                .waitForLoadRentPage()
                .dateRentClearAndWrite(date)
                .chooseTimeRent(timeRent)
                .chooseColorRent(color)
                .commentWrite(comment)
                .rentButtonClick();


        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage
                .waitLoadConfirmModal()
                .orderModalYesButton();

        //Assert.assertEquals("Окно подтверждения не открылось", this.expectedHeaderConfirmOrder, confirmOrderPage.getHeaderModal());
        Assert.assertThat("Окно подтверждения заказа не открылось",confirmOrderPage.getHeaderModal(), CoreMatchers.containsString(this.expectedHeaderConfirmOrder));

    }


}
