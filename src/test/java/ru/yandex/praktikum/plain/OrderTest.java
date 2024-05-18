package ru.yandex.praktikum.plain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;

import static ru.yandex.praktikum.page.constants.HomePageConstants.*;
import static ru.yandex.praktikum.page.constants.HomePageConstants.TEXT_ANSWER_8;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{

    private final String button;
    private final String name;
    private final String surname;
    private final String adress;
    private final String phoneNumber;
    private final int subwayNumber;


    public OrderTest(String button, String name, String surname, String adress,String phoneNumber,int subwayNumber) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = adress;
        this.subwayNumber = subwayNumber;

    }


    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"header","Роман", "Марков","Пушкина 52","88005553535",23},
                {"howItOrder","Марк", "Романов","Колотушкина 69","87005556565",35},
        };
    }


    @Test
    public void upButtonOrder() {

        MainPage mainPage = new MainPage(driver);
        mainPage.OrderButtonClick(button);


        OrderPage orderPage = new OrderPage(driver);
        orderPage
                .nameFieldClearAndWrite(name)
                .surnameFieldClearAndWrite(surname)
                .adressFieldClearAndWrite(adress)
                .phoneNumberFieldClearAndWrite(phoneNumber)
                .subwayStationListChoose(subwayNumber)
                .nextButtonClick();


    }





}
