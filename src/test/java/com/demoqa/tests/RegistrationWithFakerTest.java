package com.demoqa.tests;


import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


import static com.demoqa.utils.RandomUtils.*;


public class RegistrationWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {

        String firstName = getRandomFirstName(),
                lastName = getRandomLastName(),
                userEmail = getRandomUserEmail(),
                gander = getRandomGender(),
                phoneNumber = getRandomPhoneNumber(),
                day = getRandomDay(),
                month = getRandomMonth(),
                year = String.valueOf(getRandomInt(1900, 2020));


        registrationPage.openPage()
                .removeBanners()
                .setFirtsName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gander)
                .setUserNumber(phoneNumber)
                .setBirthday(day, month, year)
                .setSubjects("Maths")
                .setHobbies("Music")
                .uploadPicture("sample.png")
                .setCurrentAddress("Moscow")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setConfirmation();

        registrationPage.verifyGreeting()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gander)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", day + " " + month + ", " + year)
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "sample.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Uttar Pradesh Agra");

    }
}
