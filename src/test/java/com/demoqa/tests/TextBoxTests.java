package com.demoqa.tests;

import com.demoqa.pages.TextBoxRegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class TextBoxTests extends TestBase {

    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();

    String userName = "Abay", userEmail = "abay@kunanbayev.com",
            permanentAddress = "anotherWorld", currentAddress = "Semey";
    @Test
    void successfulFillFormTest() {
        textBoxRegistrationPage.openPage()
                                .setFirstName(userName)
                                .setUserEmail(userEmail)
                                .setCurrentAddress(currentAddress)
                                .setPermanentAddress(permanentAddress)
                                .clickSubmitButton();

//      checking
        textBoxRegistrationPage.verifyNameOutput(userName)
                                .verifyEmailOutput(userEmail)
                                .verifyCurrentAddressOutput(currentAddress)
                                .verifyPermanentAddressOutput(permanentAddress);
        sleep(4000);
    }

}
