package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class DemoQAFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String userName = "Grace", userLastName = "Hopper", userEmail = "grace@hopper.com",
            userNumber = "1234567891", gender = "Female", subject = "math", hobby = "Sports",
            userAddress = "129 E 60th ST", userState = "NCR", userCity = "Delhi";

    @Test
    void formTest() {

        registrationPage.openPage()
                        .removeBanners();
        registrationPage.setFirstName(userName)
                        .setLastName(userLastName)
                        .setUserEmail(userEmail)
                        .gender(gender)
                        .setNumber(userNumber)
                        .setSubject(subject)
                        .selectHobby(hobby)
                        .uploadPic("img/photo.jpg")
                        .setAddress(userAddress)
                        .selectState(userState)
                        .selectCity(userCity)
                        .setBirthDate("1903","December", "09");
        registrationPage.clickSubmitButton();

//        checking
        registrationPage.registrationModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "09 December,1903")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
        sleep(4000);
    }
}
