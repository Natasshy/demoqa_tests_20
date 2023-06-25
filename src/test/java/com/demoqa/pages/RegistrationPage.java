package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ConfirmationComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ConfirmationComponent confirmationComponent = new ConfirmationComponent();

    SelenideElement
            firtsNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            confirmationInput = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirtsName(String value) {
        firtsNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthday(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setConfirmation() {
        confirmationInput.pressEnter();
        return this;
    }

    public RegistrationPage verifyGreeting() {
        confirmationComponent.verifyGreeting();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        confirmationComponent.verifyResult(key, value);
        return this;
    }
}
