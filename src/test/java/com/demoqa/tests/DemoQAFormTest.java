package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;

public class DemoQAFormTest extends TestBase {
    @Test
    @Tag("remote-test")
    @DisplayName("Successful registration")
    void formTest() {
        step("Open the form", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });
        step("Fill the form", () -> {
            registrationPage.setFirstName(userName)
                    .setLastName(userLastName)
                    .setUserEmail(userEmail)
                    .gender(genderIs)
                    .setNumber(userNumber)
                    .setSubject(subjectIs)
                    .selectHobby(hobbyIs)
                    .uploadPic("img/photo.jpg")
                    .setAddress(userAddress)
                    .selectState(userState)
                    .selectCity(userCity)
                    .setBirthDate(year, month, day);
            registrationPage.clickSubmitButton();
        });
        step("Results verification", () -> {
            registrationPage.registrationModalAppears()
                    .verifyResult("Student Name", userName + " " + userLastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", genderIs)
                    .verifyResult("Mobile", userNumber)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subjectIs)
                    .verifyResult("Hobbies", hobbyIs)
                    .verifyResult("Address", userAddress)
                    .verifyResult("State and City", userState + " " + userCity);
        });
    }
}
