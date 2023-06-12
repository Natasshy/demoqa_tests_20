package com.demoqa.tests;


import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.DataWithFaker;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;

import static com.demoqa.utils.RandomUtils.*;


public class RegistrationWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        DataWithFaker data = new  DataWithFaker();

        registrationPage.openPage()
                .removeBanners()
                .setFirtsName(data.firstName)
                .setLastName(data.lastName)
                .setUserEmail(data.userEmail)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .setBirthday(data.day, data.month, data.year)
                .setSubjects("Maths")
                .setHobbies("Music")
                .uploadPicture("sample.png")
                .setCurrentAddress("Moscow")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setConfirmation();

        registrationPage.verifyGreeting()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber)
               .verifyResult("Date of Birth", data.day + " " + data.month + ", " + data.year)
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "sample.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Uttar Pradesh Agra");

    }
}
