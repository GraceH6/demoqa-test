package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement firstNameInput = $("#firstName"),
                    formHeader = $(".practice-form-wrapper"),
                    lastNameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    genderSelect = $("#genterWrapper"),
                    userNumber = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesRadio = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    addressField = $("#currentAddress"),
                    stateSelector = $("#state"),
                    stateSelectorWrapper = $("#stateCity-wrapper"),
                    citySelector = $("#city"),
                    citySelectorWrapper = $("#stateCity-wrapper"),
                    submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeader.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage gender(String value) {
        genderSelect.$(byText(value)).click();
        return this;
    }

    public void setBirthDate(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
    }

    public RegistrationPage registrationModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String value) {
        hobbiesRadio.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPic(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressField.setValue(value).click();
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateSelector.click();
        stateSelectorWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        citySelector.click();
        citySelectorWrapper.$(byText(value)).click();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
