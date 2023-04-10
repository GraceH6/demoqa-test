package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DemoQAFormTest extends TestBase {

    @Test
    void formTest() {

        String userName = "Grace";
        String userLastName = "Hopper";
        String userEmail = "grace@hopper.com";
        String userNumber = "1234567891";
        String userAddress = "129 E 60th ST";

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
//        $x("//label[contains(text(), 'Female')]").click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1903");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/photo.jpg");
        $("#currentAddress").setValue(userAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        checking

        $(".table").shouldHave(text(userName), text(userLastName), text(userEmail),
                text("Female"), text(userNumber),text("09 December,1903"), text("Maths"),
                text("Sports"), text(userAddress), text("NCR Delhi"));
    }
}
