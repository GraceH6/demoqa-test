package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
//    SelenideElements / locators / etc

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();


    SelenideElement firstNameInput = $("#firstName"),
                    formHeader = $(".practice-form-wrapper"),
                    lastNameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    genderSelect = $("#genterWrapper"),
                    userNumber = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput");

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

}
