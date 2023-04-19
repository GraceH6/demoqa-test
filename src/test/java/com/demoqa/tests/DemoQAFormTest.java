package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;


public class DemoQAFormTest extends TestBase {

    String userName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10).toString(),
            year = RandomUtils.setRandomYear(),
            month = RandomUtils.setRandomMonth(),
            day = RandomUtils.setRandomDay(),
            gender = getRandomGender(),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            userAddress = faker.address().streetAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState);

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
                        .setBirthDate(year, month, day);
        registrationPage.clickSubmitButton();

//        checking
        registrationPage.registrationModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}
