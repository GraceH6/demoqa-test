package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DemoQAFormTest extends TestBase {

    @Test
    void formTest() {

        registrationPage.openPage()
                        .setFirstName("Grace")
                        .setLastName("Hopper")
                        .setUserEmail("grace@hopper.com")
                        .gender("Female")
                        .setNumber("1234567891")
                        .setBirthDate("1903","December", "09");
        $("#subjectsInput").setValue("math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/photo.jpg");
        $("#currentAddress").setValue("129 E 60th ST");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        checking
        registrationPage.registrationModalAppears()
                .verifyResult("Student Name", "Grace Hopper")
                .verifyResult("Student Email", "grace@hopper.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "1234567891")
                .verifyResult("Date of Birth", "09 December,1903")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Address", "129 E 60th ST")
                .verifyResult("State and City", "NCR Delhi");


    }
}
