package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    String userName = faker.name().fullName(),
            userEmail = faker.internet().emailAddress(),
            permanentAddress = faker.address().streetAddress(),
            currentAddress = faker.friends().quote();
    @Test
    void successfulFillFormTest() {
        textBoxRegistrationPage.openPage()
                                .removeBanners();
        textBoxRegistrationPage.setFirstName(userName)
                                .setUserEmail(userEmail)
                                .setCurrentAddress(currentAddress)
                                .setPermanentAddress(permanentAddress)
                                .clickSubmitButton();
//      checking
        textBoxRegistrationPage.verifyNameOutput(userName)
                                .verifyEmailOutput(userEmail)
                                .verifyCurrentAddressOutput(currentAddress)
                                .verifyPermanentAddressOutput(permanentAddress);
    }
}
