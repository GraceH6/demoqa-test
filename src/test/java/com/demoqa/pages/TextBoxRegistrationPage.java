package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxRegistrationPage {

    SelenideElement textBoxPage = $(".body-height"),
                    textBoxUserName = $("#userName"),
                    permanentAddressField = $("#permanentAddress"),
                    userEmailInput = $("#userEmail"),
                    currentAddressField = $("#currentAddress"),
                    submitButton = $("#submit"),
                    emailOutput = $("#email"),
                    nameOutput = $("#name"),
                    currentAddressOutput = $("#currentAddress.mb-1"),
                    permanentAddressOutput = $("#permanentAddress.mb-1");

    public TextBoxRegistrationPage openPage() {
        open("/text-box");
        textBoxPage.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxRegistrationPage setFirstName(String value) {
        textBoxUserName.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setCurrentAddress(String value) {
        currentAddressField.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setPermanentAddress(String value) {
        permanentAddressField.setValue(value);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public TextBoxRegistrationPage verifyNameOutput(String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }
    public TextBoxRegistrationPage verifyEmailOutput(String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }public TextBoxRegistrationPage verifyCurrentAddressOutput(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }public TextBoxRegistrationPage verifyPermanentAddressOutput(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}
