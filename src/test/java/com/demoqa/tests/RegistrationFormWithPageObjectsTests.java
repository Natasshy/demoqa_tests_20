package com.demoqa.tests;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successTest() {


        registrationPage.openPage()
                .removeBanners()
                .setFirtsName("Natalia")
                .setLastName("Dolmatova")
                .setUserEmail("mail@mail.ru")
                .setGender("Female")
                .setUserNumber("9031809898")
                .setBirthday("30", "1", "1991")
                .setSubjects("Maths")
                .setHobbies("Music")
                .uploadPicture("sample.png")
                .setCurrentAddress("Moscow")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setConfirmation();

        registrationPage.verifyGreeting()
                .verifyResult("Student Name", "Natalia Dolmatova")
                .verifyResult("Student Email", "mail@mail.ru")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "9031809898")
                .verifyResult("Date of Birth", "30 January,1991")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "sample.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Uttar Pradesh Agra");
    }
}
