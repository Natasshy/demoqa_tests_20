package com.demoqa.tests;


import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.DataWithFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationRemoteTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    DataWithFaker data = new DataWithFaker();

    @Test
    @Tag("remote")
    @DisplayName("Succesful registration")
    void successTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.removeBanners()
                    .setFirtsName(data.firstName)
                    .setLastName(data.lastName)
                    .setUserEmail(data.userEmail)
                    .setGender(data.gender)
                    .setUserNumber(data.phoneNumber)
                    .setBirthday(data.day, data.monthForRegistrationPage, data.year)
                    .setSubjects(data.subjects)
                    .setHobbies(data.hobbies)
                    .uploadPicture(data.pictureLocation)
                    .setCurrentAddress(data.userAddress)
                    .setState(data.state)
                    .setCity(data.usercity)
                    .setConfirmation();
        });
        step("Verify results", () -> {
            registrationPage.verifyGreeting()
                    .verifyResult("Student Name", data.firstName + " " + data.lastName)
                    .verifyResult("Student Email", data.userEmail)
                    .verifyResult("Gender", data.gender)
                    .verifyResult("Mobile", data.phoneNumber)
                    .verifyResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                    .verifyResult("Subjects", data.subjects)
                    .verifyResult("Hobbies", data.hobbies)
                    .verifyResult("Picture", data.pictureLocation)
                    .verifyResult("Address", data.userAddress)
                    .verifyResult("State and City", data.state + " " + data.usercity);
        });

    }


}
