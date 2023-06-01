package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {


    @BeforeAll
            static void beforeAll() {
        open("https://demoqa.com/automation-practice-form");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }
    @Test
    void successTest() {
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Natalia");
        $("#lastName").setValue("Dolmatova");
        $("#userEmail").setValue("mail@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("9031809898");
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOptionByValue("1");
        $("[class*='year-select']").selectOptionByValue("1991");
        $("[class*='day--030']").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/data/sample.png"));
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldBe(Condition.visible).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Natalia Dolmatova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("mail@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9031809898"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("30 January,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("sample.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));


    }



}
